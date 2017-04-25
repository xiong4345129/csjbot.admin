package com.csjbot.admin.data.scs.dao;

import java.util.Map;

import com.csjbot.admin.data.scs.model.ScsDesk;
import com.csjbot.admin.page.Page;

/**
 * 数据访问接口
 * 
 * @author xiongmietao
 * 
 */
public interface ScsDeskDao {
	
	public final static java.lang.String PREFIX = ScsDeskDao.class.getName();
	
	public int insert(ScsDesk scsDesk);
	
	public int delete(String id);
	
	ScsDesk selectByPrimaryKey(String  id);
	
	public <E, K, V> Page<E> pageAndSort(Map<String, Object> params,int current, int pagesize, String sortString);

}
