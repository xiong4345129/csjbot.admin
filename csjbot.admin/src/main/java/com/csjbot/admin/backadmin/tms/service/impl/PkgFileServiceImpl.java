package com.csjbot.admin.backadmin.tms.service.impl;

import com.csjbot.admin.backadmin.tms.service.PkgFileService;
import com.csjbot.admin.data.tms.dao.PkgFileDao;
import com.csjbot.admin.data.tms.model.FileEntry;
import com.csjbot.admin.data.tms.model.PkgFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PkgFileServiceImpl implements PkgFileService {

    @Autowired
    private PkgFileDao dao;

    @Override
    public PkgFile get(String id) {
        return dao.get(id);
    }

    @Override
    public List<PkgFile> getAll() {
        return dao.getAll();
    }

    @Override
    public int insert(PkgFile pojo) {
        return dao.insert(pojo);
    }

    @Override
    public int update(PkgFile pojo) {
        return dao.update(pojo);
    }

    @Override
    public int delete(String id) {
        return dao.delete(id);
    }

    @Override
    public List<String> getDistinctPaths() {
        return dao.getDistinct("path");
    }

    @Override
    public List<FileEntry> findByName(String ptn, Integer orderBy) {
        String col;
        switch (orderBy) {
            case 2:
                col = "uptime";
                break;
            default:
                col = "path";
        }
        return dao.getLike(ptn, col);
    }
}
