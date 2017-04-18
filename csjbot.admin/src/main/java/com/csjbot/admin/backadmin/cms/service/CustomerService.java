package com.csjbot.admin.backadmin.cms.service;

import java.util.List;
import java.util.Map;

import com.csjbot.admin.data.cms.dao.CustomerDao;
import com.csjbot.admin.data.cms.model.Customer;
import com.csjbot.admin.data.pms.model.PmsProduct;
import com.csjbot.admin.page.Page;

/**
 * @Description
 * @author XMT
 * @version V1.0
 */

public interface CustomerService {
	
public final static String PREFIX = CustomerDao.class.getName();
	
	public Customer get(String code,String code_group);
	
	public <K, V> Map<K, V> findOne(String code,String code_group);
	
	public <T, K, V> List<T> find(Map<K, V> params);
	
	public boolean insert(Customer customer);
	
	public boolean update(Customer customer);
	
	Customer selectByPrimaryKey(String code,String code_group);
	
	public boolean delete(String code,String code_group);
	
	public Page<Map<String, Object>> pageAndSort(Map<String, Object> params, int current, int pagesize, String sortString);
	

}
