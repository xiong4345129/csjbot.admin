package com.csjbot.admin.backadmin.cms.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csjbot.admin.backadmin.cms.service.CustomerService;
import com.csjbot.admin.data.cms.dao.CustomerDao;
import com.csjbot.admin.data.cms.model.Customer;
import com.csjbot.admin.page.Page;

/** 
 * @Description 
 * @author XMT
 * @date 2016-4-14 下午10:33:14 
 * @version V1.0
 */

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao dao;

	@Override
	public <K, V> Map<K, V> findOne(String code,String code_group) {
		return dao.findOne(code, code_group);
	}

	@Override
	public <T, K, V> List<T> find(Map<K, V> params) {
		return dao.find(params);
	}

	@Override
	public boolean insert(Customer customer) {
		return dao.insert(customer)>0;
	}

	@Override
	public boolean update(Customer customer) {
		return dao.update(customer)>0;
	}

	@Override
	public Customer get(String code, String code_group) {
		return dao.get(code, code_group);
	}

	@Override
	public boolean delete(String code, String code_group) {
		return dao.delete(code, code_group)>0;
	}

	@Override
	public Page<Map<String, Object>> pageAndSort(Map<String, Object> params, int current, int pagesize, String sortString) {
		return dao.pageAndSort(params, current, pagesize, sortString);
	}

	@Override
	public Customer selectByPrimaryKey(String code, String code_group) {
		return dao.selectByPrimaryKey(code, code_group);
	}


}
