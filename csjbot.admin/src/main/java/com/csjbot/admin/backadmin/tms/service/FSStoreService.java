package com.csjbot.admin.backadmin.tms.service;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;

// todo
public interface FSStoreService {

    List<String> getDirList();

    boolean checkDirStrSyntax(String filePath);

    boolean createDir(String filePath);

    boolean isFileExists(String filePath, MultipartFile file);

    boolean store(String filePath, MultipartFile file);

    String genChecksum(Path path);

    boolean delete(String filePath, String fileName);
}
