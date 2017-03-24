package com.csjbot.admin.backadmin.tms.service.impl;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.Properties;

@Component
public class FileUploadProperties {

    @Resource(name = "appconfig")
    private Properties properties;

    // @Value("${pkg.store.base.dir}")
    // private String baseDir;
    // @Value("${pkg.store.checksum}")
    // private String checksumAlg;
    // @Value("${pkg.store.folder.regex}")
    // private String folderRegex;

    public String getBaseDir() {
        String baseDir = properties.getProperty("pkg.store.base.dir");
        if (baseDir == null) throw new NullPointerException("baseDir");
        return baseDir;
    }

    public String getChecksumAlg() {
        String checksumAlg = properties.getProperty("pkg.store.checksum");
        return (checksumAlg == null) ? "SHA1" : checksumAlg;
    }

    public String getFolderRegex() {
        String folderRegex = properties.getProperty("pkg.store.folder.regex");
        return (folderRegex == null) ? "[0-9a-zA-Z-_]{3,20}" : folderRegex;
    }
}
