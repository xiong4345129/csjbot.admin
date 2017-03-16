package com.csjbot.admin.data.sys.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csjbot.admin.data.DaoSupport;
import com.csjbot.admin.data.sys.dao.SysMenuDao;
import com.csjbot.admin.data.sys.model.SysMenu;


@Repository
public class SysMenuDaoImpl implements SysMenuDao {

    @Autowired
    private DaoSupport dao;
    
    @Override
    public int insert(SysMenu menu) {
        return dao.insert(PREFIX + ".insert", menu);
    }

    @Override
    public int update(Map<String, Object> params) {
        return dao.update(PREFIX + ".update", params);
    }

    @Override
    public SysMenu findOne(String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        return dao.get(PREFIX + ".findOne", params);
    }

    @Override
    public <E> List<E> listAll(Map<String, Object> params) {
        return dao.find(PREFIX + ".listAll", params);
    }

    @Override
    public int delete(String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        return dao.delete(PREFIX + ".delete", params);
    }

    @Override
    public <E> List<E> getMenuPermissions() {
        
        return dao.find(PREFIX + ".getMenuPermissions");
    }

    @Override
    public <E> List<E> getMenuParents() {
        return dao.find(PREFIX + ".getMenuParents");
    }

    @Override
    public Map<String, Object> getMenuPermissionById(String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        return dao.get(PREFIX + ".getMenuPermissionById", params);
    }

}
