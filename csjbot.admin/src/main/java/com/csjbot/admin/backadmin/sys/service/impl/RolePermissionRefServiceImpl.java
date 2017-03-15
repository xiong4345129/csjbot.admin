package com.csjbot.admin.backadmin.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csjbot.admin.backadmin.sys.service.RolePermissionRefService;
import com.csjbot.admin.data.sys.dao.RolePermissionRefDao;
import com.csjbot.admin.data.sys.model.RolePermissionRef;
import com.csjbot.admin.util.StringUtil;

@Service
public class RolePermissionRefServiceImpl implements RolePermissionRefService {

    @Autowired
    private RolePermissionRefDao dao;

    @Override
    public void saveOrUpdate(RolePermissionRef ref) {
        if (dao.update(ref) == 0) {
            if (StringUtil.isEmpty(ref.getId())) {
                ref.setId(StringUtil.createUUID());
            }
            dao.insert(ref);
        }
    }

    @Override
    public int removeByRoleId(String roleId) {
        return dao.removeByRoleId(roleId);
    }

    @Override
    public <T, K, V> List<T> getRolePermissionRef(Map<String, Object> params) {
        return dao.getRolePermissionRef(params);
    }

    @Override
    public RolePermissionRef get(String id) {
        return dao.get(id);
    }

}
