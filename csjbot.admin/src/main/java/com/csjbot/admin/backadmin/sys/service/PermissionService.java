package com.csjbot.admin.backadmin.sys.service;

import java.util.List;
import java.util.Map;

import com.csjbot.admin.data.sys.model.Permission;
import com.csjbot.admin.exception.ServiceException;
import com.csjbot.admin.page.Page;


public interface PermissionService {
    
    public Permission get(String id) throws ServiceException;

    public <K, V> Map<K, V> findOne(String id) throws ServiceException;

    public <T, K, V> List<T> find(Map<K, V> params) throws ServiceException;

    public int insert(Permission permission) throws ServiceException;

    public int update(Permission permission) throws ServiceException;

    public int delete(String id) throws ServiceException;

    public <E, K, V> Page<E> page(Map<K, V> params, int current, int pagesize) throws ServiceException;
}
