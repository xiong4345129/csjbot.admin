package com.csjbot.admin.backadmin.tms.service;

import com.csjbot.admin.data.tms.model.PkgFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PkgFileService {
    PkgFile get(String id);

    List<PkgFile> getAll();

    int insert(PkgFile pojo);

    int update(PkgFile pojo);

    int delete(String id);

    List<String> getDistinctPaths();
}
