package com.csjbot.admin.data.sys.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csjbot.admin.data.DaoSupport;
import com.csjbot.admin.data.sys.dao.RoleDao;
import com.csjbot.admin.data.sys.model.Role;
import com.csjbot.admin.page.Page;


/**
 * 数据访问接口
 * 
 * @author cjay
 * 
 */
@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private DaoSupport dao;

    @Override
    public Role get(String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        return dao.get(PREFIX + ".get", params);
    }

    @Override
    public <K, V> Map<K, V> findOne(String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        return dao.get(PREFIX + ".findOne", params);
    }

    @Override
    public <T, K, V> List<T> find(Map<K, V> params) {
        return dao.find(PREFIX + ".find", params);
    }

    @Override
    public int insert(Role role) {
        return dao.insert(PREFIX + ".insert", role);
    }

    @Override
    public int update(Role role) {
        return dao.update(PREFIX + ".update", role);
    }

    @Override
    public int delete(String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        return dao.delete(PREFIX + ".delete", params);
    }

    @Override
    public <E, K, V> Page<E> page(Map<K, V> params, int current, int pagesize) {
        return dao.page(PREFIX + ".page", params, current, pagesize);
    }
}
