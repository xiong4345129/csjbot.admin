package com.csjbot.admin.backadmin.tms.service.impl;

import com.csjbot.admin.backadmin.tms.service.FSStoreService;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FSStoreServiceImpl implements FSStoreService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FSStoreServiceImpl.class);

    private static final char SLASH = '/'; // tested ok, linux: genric, window: jvm auto convert

    private final String baseDir;
    private final String checksumAlg;
    private final String regex;
    private static final int maxLevel = 3;

    @Autowired
    public FSStoreServiceImpl(FileUploadProperties properties) {
        this.baseDir = properties.getBaseDir();
        this.checksumAlg = properties.getChecksumAlg();
        this.regex = properties.getFolderRegex();
    }

    @Override
    public List<String> getDirList() {
        final List<String> dirs = new ArrayList<>();
        dirs.add(String.valueOf(SLASH)); // add root
        final File base = new File(baseDir);
        walk(dirs, base, "", 1);
        return dirs;
    }

    private static void walk(List<String> dirs, File parentDir, String parentName, int curLevel) {
        for (File file : parentDir.listFiles()) {
            if (file.isDirectory()) {
                String dirName = parentName + SLASH + file.getName();
                dirs.add(dirName);
                if (curLevel < maxLevel)
                    walk(dirs, file, dirName, curLevel + 1);
            }
        }
    }

    @Override
    public boolean checkDirStrSyntax(String filePath) {
        if (filePath == null || (filePath = filePath.trim()).length() == 0)
            return false;
        int firstSlash = filePath.indexOf(SLASH);
        int length = filePath.length();
        if (firstSlash != 0) {
            return false;
        } else if (length == 1) {
            return true;
        } else {
            filePath = filePath.substring(1, length);
            String[] subs = filePath.split("/");
            if (subs.length > 3) {
                return false;
            } else {
                for (String s : subs) {
                    if (!s.matches(regex)) return false;
                }
                return true;
            }
        }
    }

    @Override
    public boolean createDir(String filePath) {
        File target = new File(baseDir + filePath);
        if (target.exists()) {
            return target.isDirectory();
        } else {
            return target.mkdirs();
        }
    }

    @Override
    public boolean isFileExists(String filePath, MultipartFile file) {
        File target = new File(compose(filePath, file.getOriginalFilename()));
        return target.exists();
    }

    private String compose(String filePath, String fileName) {
        if (filePath.charAt(filePath.length() - 1) != SLASH) filePath = filePath + SLASH;
        return baseDir + filePath + fileName;
    }

    @Override
    public boolean store(String filePath, MultipartFile file) {
        boolean res;
        String targetDir = baseDir + filePath;
        String targetFile = targetDir + SLASH + file.getOriginalFilename();
        File target = new File(targetFile);
        try {
            Path path = target.toPath();
            Files.copy(file.getInputStream(), path);
            genChecksum(path);
            checkedUnzip(targetFile);
            res = true;
        } catch (IOException e) {
            LOGGER.error("store " + target.getAbsolutePath(), e);
            res = false;
        }
        return res;
    }

    // todo
    public String genChecksum(Path path) {
        String hash = null;
        try {
            byte[] bytes = Files.readAllBytes(path);
            final byte[] hashBytes = MessageDigest.getInstance(checksumAlg).digest(bytes);
            hash = DatatypeConverter.printHexBinary(hashBytes);
            String sigFileName = getSigFileName(path.getFileName().toString());
            Path sigFilePath = path.resolveSibling(sigFileName);
            Files.write(sigFilePath, Collections.singletonList(hash), StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("checksum", e);
        } catch (IOException e) {
            LOGGER.error(path + " checksum", e);
        }
        return hash;
    }

    private String getSigFileName(String fileName) {
        return fileName + "." + checksumAlg.toLowerCase();
    }

    // todo
    private static void checkedUnzip(String fileFullPath) {
        String outDir = stripZipFileExt(fileFullPath);
        if (isZipFile(fileFullPath)) {
            String tempDir = outDir + ".unzip";
            try {
                UnZip.unzip(fileFullPath, tempDir);
                Files.move(Paths.get(tempDir), Paths.get(outDir));
                FileUtils.deleteDirectory(new File(tempDir));
            } catch (IOException e) {
                LOGGER.error("unzip " + fileFullPath, e);
            }
        }
    }

    // todo
    private static boolean isZipFile(String fileName) {
        int len = fileName.length();
        if (len < 5) return false;
        String ext = fileName.substring(len - 4, len);
        return ".zip".equals(ext);
    }

    private static String stripZipFileExt(String fileName) {
        int dot = fileName.lastIndexOf(".");
        return fileName.substring(0, dot);
    }

    @Override
    public boolean delete(String filePath, String fileName) {
        String fullPath = compose(filePath, fileName);
        boolean deleteOk = checkedDelete(fullPath);// original file
        checkedDelete(getSigFileName(fullPath)); // checksum file
        if (isZipFile(fileName)) checkedDelete(stripZipFileExt(fullPath));
        return deleteOk;
    }

    private boolean checkedDelete(String fullPath) {
        boolean deleted = false;
        Path file = Paths.get(fullPath);
        if (Files.exists(file)) {
            try {
                if (Files.isDirectory(file))
                    FileUtils.deleteDirectory(new File(fullPath));
                else
                    Files.delete(file);
                deleted = true;
            } catch (IOException e) {
                LOGGER.error("delete " + fullPath, e);
            }
        }
        return deleted;
    }
}
