package com.csjbot.admin.backadmin.tms.service;

import com.csjbot.admin.backadmin.tms.model.Result;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;

// todo
public interface FSStoreService {

    String getBaseDir();

    List<String> getDirList(); // todo

    boolean checkDirStrSyntax(String dirStr); // todo

    String composePathStr(String dirStr);

    String composePathStr(String dirStr, String fileName);

    Path getDirPath(String dirStr);

    Path getFilePath(String dirStr, String fileName);

    boolean exists(Path path);

    boolean fileExists(Path filePath);

    boolean fileExists(String dirStr, String fileName);

    boolean dirExists(Path dirPath);

    boolean dirExists(String dirStr);

    Result createDir(String dirStr);

    Result store(String dirStr, MultipartFile file);

    String genChecksum(Path path);

    boolean delete(String filePath, String fileName);
}
