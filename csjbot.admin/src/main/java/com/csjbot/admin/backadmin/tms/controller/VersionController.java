package com.csjbot.admin.backadmin.tms.controller;

import com.csjbot.admin.backadmin.tms.service.FSStoreService;
import com.csjbot.admin.backadmin.tms.service.PkgFileService;
import com.csjbot.admin.data.tms.model.PkgFile;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.OK;

@Controller
@RequestMapping("/tms")
public class VersionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(VersionController.class);

    private final ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private PkgFileService fileDBService;
    @Autowired
    private FSStoreService storeService;

    @RequestMapping(value = "/versionControl", method = RequestMethod.GET)
    public String versionView(Model model) {
        List<PkgFile> fileList = fileDBService.getAll();
        model.addAttribute("pkgFile", fileList);
        return "tms/version";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@RequestParam("id") String id) {
        LOGGER.debug("delete file " + id);
        PkgFile file = fileDBService.get(id);
        if (file == null)
            return textResponse(BAD_REQUEST, "未找到文件ID=" + id);
        boolean res = false;
        if (storeService.delete(file.getPath(), file.getName())) {
            if (removeDBInfo(id)) res = true;
            else LOGGER.error("remove db info " + file.getInfo() + " failed");
        } else {
            LOGGER.error("delete " + file.getInfo() + " failed");
        }
        return (res) ? textResponse(OK, id + " 删除成功") :
            textResponse(INTERNAL_SERVER_ERROR, id + " 删除失败");
    }

    @RequestMapping(value = "/listdir", method = RequestMethod.GET)
    public ResponseEntity<String> listDir() {
        List<String> dirs = fileDBService.getDistinctPaths();
        String dirJson;
        try {
            dirJson = mapper.writeValueAsString(dirs);
        } catch (JsonProcessingException e) {
            LOGGER.error("jackson serialize error", e);
            dirJson = manualSerialize(dirs);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(dirJson, headers, OK);
    }

    private static String manualSerialize(List<String> dirs) {
        if (dirs == null || dirs.size() == 0) return "[]";
        String part = String.join("\",\"", dirs);
        return "[\"" + part + "\"]";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<String> upload(@RequestParam("dir") String dirStr,
                                         @RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return textResponse(BAD_REQUEST, "空文件");
        }
        if (!storeService.checkDirStrSyntax(dirStr)) {
            return textResponse(BAD_REQUEST, "文件夹不符合格式");
        }
        if (!storeService.createDir(dirStr)) {
            return textResponse(FORBIDDEN, "存在同名文件");
        }
        if (storeService.isFileExists(dirStr, file)) {
            return textResponse(FORBIDDEN, "存在同名文件(夹)");
        }
        if (!storeService.store(dirStr, file)) {
            return textResponse(INTERNAL_SERVER_ERROR, "保存出错");
        }
        if (!createDBInfo(dirStr, file.getOriginalFilename())) {
            // todo how to handle errors??
            LOGGER.error("upload file fail to insert to db " + dirStr + file.getName());
        }
        return textResponse(OK, "上传成功");
    }

    private boolean createDBInfo(String filePath, String fileName) {
        PkgFile file = new PkgFile(fileName, filePath, new Date());
        return (fileDBService.insert(file) == 1);
    }

    private boolean removeDBInfo(String fileId) {
        return (fileDBService.delete(fileId) == 1);
    }

    private ResponseEntity<String> textResponse(HttpStatus status, String msg) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        return new ResponseEntity<>(msg, headers, status);
    }

}
