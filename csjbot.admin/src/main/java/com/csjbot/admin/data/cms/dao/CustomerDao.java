package com.csjbot.admin.data.cms.dao;

import java.util.List;
import java.util.Map;

import com.csjbot.admin.data.cms.model.Customer;
import com.csjbot.admin.page.Page;

/**
 * 数据访问接口
 * 
 * @author xiongmietao
 * 
 */

public interface CustomerDao {
	
	public final static String PREFIX = CustomerDao.class.getName();
	
	public Customer get(String code,String code_group);
	
	public <K, V> Map<K, V> findOne(String code,String code_group);
	
	public <T, K, V> List<T> find(Map<K, V> params);
	
	public int insert(Customer customer);
	
	public int update(Customer customer);
	
	Customer selectByPrimaryKey(String code,String code_group);
	
	public int delete(String code,String code_group);
	
	public <E, K, V> Page<E> pageAndSort(Map<String, Object> params,int current, int pagesize, String sortString);
	
}
