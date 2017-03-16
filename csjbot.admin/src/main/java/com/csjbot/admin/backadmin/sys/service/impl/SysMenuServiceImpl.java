package com.csjbot.admin.backadmin.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csjbot.admin.backadmin.sys.service.SysMenuService;
import com.csjbot.admin.data.sys.dao.SysMenuDao;
import com.csjbot.admin.data.sys.model.SysMenu;
import com.csjbot.admin.exception.ServiceException;
import com.csjbot.admin.util.StringUtil;


@Service
public class SysMenuServiceImpl implements SysMenuService {
    
    @Autowired
    private SysMenuDao sysMenuDao;
    
    @Override
    public int insert(SysMenu menu) throws ServiceException {
        menu.setId(StringUtil.createUUID());
        return sysMenuDao.insert(menu);
    }

    @Override
    public int update(Map<String, Object> params) throws ServiceException{
        return sysMenuDao.update(params);
    }

    @Override
    public SysMenu findOne(String id) {
        return sysMenuDao.findOne(id);
    }

    @Override
    public <E> List<E> listAll(Map<String, Object> params) throws ServiceException{
        return sysMenuDao.listAll(params);
    }

    @Override
    public int delete(String id) {
        return sysMenuDao.delete(id);
    }

    @Override
    public <K, V> List<Map< K, V>> getMenuPermissions() {
        return sysMenuDao.getMenuPermissions();
    }

    @Override
    public <K, V> List<Map<K, V>> getMenuParents() {
        return sysMenuDao.getMenuParents();
    }

    @Override
    public Map<String, Object> getMenuPermissionById(String id) {
        return sysMenuDao.getMenuPermissionById(id);
    }

}
