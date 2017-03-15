package com.csjbot.admin.backadmin.sys.service;

import java.util.List;
import java.util.Map;

import com.csjbot.admin.data.sys.model.Role;
import com.csjbot.admin.page.Page;

public interface RoleService {

    public Role get(String id);

    public void saveOrUpdate(Role role);

    public List<Map<String, Object>> find(Map<String, Object> params);

    public Page<Map<String, Object>> page(Map<String, Object> params, int current, int pagesize);

}
