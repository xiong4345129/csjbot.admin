package com.csjbot.admin.data.tms.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.csjbot.admin.data.tms.model.PkgFile;


public interface PkgFileDao {

    PkgFile get(String id);

    List<PkgFile> getAll();

    // todo insert should return fileId not 0 or 1
    int insert(PkgFile pojo);

    int update(PkgFile pojo);

    int delete(String id);

    <V> List<V> getDistinct(String fieldName);
}
