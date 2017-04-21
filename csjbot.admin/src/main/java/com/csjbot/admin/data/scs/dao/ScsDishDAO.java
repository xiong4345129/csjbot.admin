package com.csjbot.admin.data.scs.dao;

import java.util.Map;

import com.csjbot.admin.data.scs.model.ScsDish;
import com.csjbot.admin.page.Page;

/**
 * 菜品接口
 * @author Zhangyangyang
 *
 */
public interface ScsDishDAO {
	public final static java.lang.String PREFIX = ScsDishDAO.class.getName();
	
	int insert(ScsDish scsDish);
	
	int delete(String id);
	
	ScsDish selectByPrimaryKey(String  id);
	
	<E, K, V> Page<E> pageAndSort(Map<String, Object> params,int current, int pagesize, String sortString);
	
	int updateByPrimaryKeySelective(ScsDish scsDish);

    int updateByPrimaryKey(ScsDish scsDish);
}
