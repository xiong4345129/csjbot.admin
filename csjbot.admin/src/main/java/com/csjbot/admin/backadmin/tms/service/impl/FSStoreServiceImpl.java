package com.csjbot.admin.backadmin.tms.service.impl;

import com.csjbot.admin.backadmin.tms.model.Result;
import com.csjbot.admin.backadmin.tms.model.Result.PreDefined;
import com.csjbot.admin.backadmin.tms.service.FSStoreService;
import com.csjbot.admin.util.FileUtil;
import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.common.SystemCache;
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
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class FSStoreServiceImpl implements FSStoreService {

    private static final Boolean IS_WIN =
        System.getProperty("os.name").toLowerCase().contains("windows");

    private static final Logger LOGGER = LoggerFactory.getLogger(FSStoreServiceImpl.class);

    private static final char SLASH = '/'; // tested ok, linux: genric, window: jvm auto convert

    private final String baseDir;
    private final String checksumAlg;
    private final String regex;
    private static final int maxLevel = 3;

    @Autowired
    public FSStoreServiceImpl(FileUploadProperties properties) {
        String base = properties.getBaseDir();
        int last = base.length() - 1;
        this.baseDir = (base.charAt(last) == SLASH) ? base.substring(0, last) : base;
        this.checksumAlg = properties.getChecksumAlg();
        this.regex = properties.getFolderRegex();
    }

    @Override
    public String getBaseDir() {
        return baseDir;
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
    public boolean checkDirStrSyntax(String dirStr) {
        if (dirStr == null || (dirStr = dirStr.trim()).length() == 0)
            return false;
        int firstSlash = dirStr.indexOf(SLASH);
        int length = dirStr.length();
        if (firstSlash != 0) {
            return false;
        } else if (length == 1) {
            return true;
        } else {
            dirStr = dirStr.substring(1, length);
            String[] subs = dirStr.split("/");
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
    public String composePathStr(String dirStr) {
        if (dirStr.charAt(dirStr.length() - 1) != SLASH) dirStr = dirStr + SLASH;
        return baseDir + dirStr;
    }

    @Override
    public String composePathStr(String dirStr, String fileName) {
        return composePathStr(dirStr) + fileName;
    }

    @Override
    public Path getDirPath(String dirStr) {
        return Paths.get(composePathStr(dirStr));
    }

    @Override
    public Path getFilePath(String dirStr, String fileName) {
        return Paths.get(composePathStr(dirStr, fileName));
    }

    @Override
    public boolean exists(Path path) {
        return path != null && Files.exists(path);
    }

    @Override
    public boolean dirExists(Path dirPath) {
        return exists(dirPath) && Files.isDirectory(dirPath);
    }

    @Override
    public boolean dirExists(String dirStr) {
        return dirExists(Paths.get(baseDir + dirStr));
    }

    @Override
    public boolean fileExists(Path filePath) {
        return exists(filePath) && Files.isRegularFile(filePath);
    }


    @Override
    public boolean fileExists(String dirStr, String fileName) {
        return fileExists(getFilePath(dirStr, fileName));
    }

    @Override
    public Result createDir(String dirStr) {
        Result res;
        Path targetDir = Paths.get(baseDir + dirStr);
        if (exists(targetDir)) {
            res = Files.isDirectory(targetDir) ?
                Result.success() : Result.from(PreDefined.EXISTING_FILE);
        } else {
            try {
                Path outDir = Files.createDirectories(targetDir);
                res = dirExists(outDir) ? Result.success() : Result.from(PreDefined.SERVER_FAIL);
            } catch (IOException e) {
                LOGGER.error("createDir " + dirStr, e);
                res = Result.from(PreDefined.SERVER_EXCEPTION);
            }
        }
        return res;
    }

    @Override
    public Result store(String dirStr, MultipartFile file) {
        Result res;
        String targetDir = composePathStr(dirStr);
        String targetFile = composePathStr(dirStr, file.getOriginalFilename());
        File target = new File(targetFile);
        try {
            Path path = target.toPath();
            Files.copy(file.getInputStream(), path);
            genChecksum(path);
            checkedUnzip(targetFile);
            res = Result.success();
        } catch (IOException e) {
            LOGGER.error("store " + target.getAbsolutePath(), e);
            res = Result.from(PreDefined.SERVER_EXCEPTION);
        }
        return res;
    }

    // private static final String PERM_DIR_DEFAULT = "rwxrwxr-x";
    // private static final String PERM_FILE_DEFAULT = "rw-rw-r--";

    // private void assignPermissions(Path path, String permStr) {
    //     try {
    //         Files.setPosixFilePermissions(path, PosixFilePermissions.fromString(permStr));
    //     } catch (IOException e) {
    //         LOGGER.error("assign permission", path.toString() + " " + permStr);
    //     }
    // }

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
    private void checkedUnzip(String fileFullPath) {
        String outDirStr = stripZipFileExt(fileFullPath);
        if (isZipFile(fileFullPath)) {
            String tempDirStr = outDirStr + ".unzip";
            Path outDir = Paths.get(outDirStr);
            Path tempDir = Paths.get(tempDirStr);
            try {
                UnZip.unzip(fileFullPath, tempDirStr);
                Files.move(tempDir, outDir);
                FileUtils.deleteDirectory(new File(tempDirStr));
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
        return (dot > 0) ? fileName.substring(0, dot) : fileName;
    }

    @Override
    public boolean delete(String filePath, String fileName) {
        String fullPath = composePathStr(filePath, fileName);
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
