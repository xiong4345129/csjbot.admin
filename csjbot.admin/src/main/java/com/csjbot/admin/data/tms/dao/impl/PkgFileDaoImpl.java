package com.csjbot.admin.data.tms.dao.impl;

import com.csjbot.admin.data.DaoSupport;
import com.csjbot.admin.data.tms.dao.PkgFileDao;
import com.csjbot.admin.data.tms.model.PkgFile;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.singletonMap;

@Repository
public class PkgFileDaoImpl implements PkgFileDao {
    @Autowired
    private DaoSupport dao;

    private static final String PREFIX = PkgFileDao.class.getName(); // the interface

    private static final String getStatement(String statementId) {
        return PREFIX + "." + statementId;
    }

    @Override
    public PkgFile get(String id) {
        return dao.get(getStatement("get"), singletonMap("id", id));
    }

    @Override
    public List<PkgFile> getAll() {
        return dao.find(getStatement("getAll"));
    }

    @Override
    public int insert(@Param("pojo") PkgFile pojo) {
        return dao.insert(getStatement("insert"), pojo);
    }

    @Override
    public int update(@Param("pojo") PkgFile pojo) {
        return dao.update(getStatement("update"), pojo);
    }

    @Override
    public int delete(String id) {
        return dao.delete(getStatement("delete"), singletonMap("id", id));
    }

    @Override
    public <V> List<V> getDistinct(String fieldName) {
        return dao.find(getStatement("getDistinct"), singletonMap("fieldName", fieldName));
    }

    @Override
    public <V> List<V> getLike(String ptn, String orderBy) {
        Map<String, String> params = new HashMap<>();
        params.put("ptn", ptn);
        params.put("col", orderBy);
        return dao.find(getStatement("getLike"), params);
    }
}
