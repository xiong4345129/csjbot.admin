package com.csjbot.admin.backadmin.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csjbot.admin.backadmin.sys.service.UserRoleRefService;
import com.csjbot.admin.data.sys.dao.UserRoleRefDao;
import com.csjbot.admin.data.sys.model.UserRoleRef;
import com.csjbot.admin.util.StringUtil;

@Service
public class UserRoleRefServiceImpl implements UserRoleRefService {

    @Autowired
    private UserRoleRefDao dao;

    @Override
    public int countRoleUserSize(String roleId) {
        return dao.countRoleUserSize(roleId);
    }

    @Override
    public List<Map<String, Object>> listAdmins(Map<String, Object> params) {
        return dao.listAdmins(params);
    }

    @Override
    public void saveOrUpdate(UserRoleRef ref) {
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
	public UserRoleRef getUserRoleRefById(String id) {
		return dao.get(id);
	}

}
