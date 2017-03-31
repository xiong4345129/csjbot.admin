package com.csjbot.admin.backadmin.sys.service;

import java.util.List;
import java.util.Map;

import com.csjbot.admin.data.sys.model.SysMenu;
import com.csjbot.admin.exception.ServiceException;


public interface SysMenuService {
    
    int insert(SysMenu menu) throws ServiceException;
    
    int update(Map<String, Object> params) throws ServiceException;
    
    SysMenu findOne(String id);
    
    <E> List<E> listAll(Map<String, Object> params) throws ServiceException;
    
    int delete(String id);
    
    <K, V> List<Map< K, V>> getMenuPermissions();
    
    <K, V> List<Map< K, V>> getMenuParents();
    
    Map<String, Object> getMenuPermissionById(String id);
}
