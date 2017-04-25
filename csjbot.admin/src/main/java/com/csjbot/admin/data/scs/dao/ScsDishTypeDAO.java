package com.csjbot.admin.data.scs.dao;

import java.util.List;
import java.util.Map;

import com.csjbot.admin.data.scs.model.ScsDishType;
import com.csjbot.admin.page.Page;

/**
 * 菜品类型接口
 * 
 * @author Zhangyangyang
 *
 */
public interface ScsDishTypeDAO {
	public final static java.lang.String PREFIX = ScsDishTypeDAO.class.getName();

	int insert(ScsDishType scsDishType);

	int delete(Integer id);

	ScsDishType selectByPrimaryKey(Integer id);

	<E, K, V> Page<E> pageAndSort(Map<String, Object> params, int current, int pagesize, String sortString);
	
	int updateByPrimaryKeySelective(ScsDishType scsDishType);

    int updateByPrimaryKey(ScsDishType scsDishType);
    
    List<ScsDishType> selectAll();
}
