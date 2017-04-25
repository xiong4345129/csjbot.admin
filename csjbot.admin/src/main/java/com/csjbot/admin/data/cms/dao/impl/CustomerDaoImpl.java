package com.csjbot.admin.data.cms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csjbot.admin.data.DaoSupport;
import com.csjbot.admin.data.cms.dao.CustomerDao;
import com.csjbot.admin.data.cms.model.Customer;
import com.csjbot.admin.data.pms.model.PmsProduct;
import com.csjbot.admin.page.Page;

/**
 * 数据访问接口
 * 
 * @author xiongmietao
 * 
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	private DaoSupport dao;

	@Override
	public <K, V> Map<K, V> findOne(String code,String code_group) {
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("code", code);
		params.put("code_group", code_group);
		return dao.get(PREFIX + ".findOne",params);
	}

	@Override
	public <T, K, V> List<T> find(Map<K, V> params) {
		return dao.find(PREFIX + ".find", params);
	}

	@Override
	public int insert(Customer customer) {
		return dao.insert(PREFIX + ".insert",customer);
	}

	@Override
	public int update(Customer customer) {
		return dao.update(PREFIX + ".update", customer);
	}

	@Override
	public Customer get(String code, String code_group) {
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("code", code);
        params.put("code_group", code_group);
        return dao.get(PREFIX + ".get", params);
	}

	@Override
	public int delete(String code, String code_group) {
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("code", code);
        params.put("code_group", code_group);
        return dao.delete(PREFIX + ".delete", params);
	}

	@Override
	public <E, K, V> Page<E> pageAndSort(Map<String, Object> params, int current, int pagesize, String sortString) {
		return dao.pageAndSort(PREFIX + ".page", params, current, pagesize, sortString);
	}

	@Override
	public Customer selectByPrimaryKey(String code, String code_group) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("code", code);
		params.put("code_group", code_group);
		return dao.get(PREFIX +".selectByPrimaryKey", params);
	}

}
