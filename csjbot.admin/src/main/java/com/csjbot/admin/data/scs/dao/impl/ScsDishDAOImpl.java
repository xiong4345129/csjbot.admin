package com.csjbot.admin.data.scs.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csjbot.admin.data.DaoSupport;
import com.csjbot.admin.data.scs.dao.ScsDishDAO;
import com.csjbot.admin.data.scs.model.ScsDish;
import com.csjbot.admin.page.Page;

/**
 * 
 * @author Zhangyangyang
 *
 */
@Repository
public class ScsDishDAOImpl implements ScsDishDAO{
	@Autowired
	private DaoSupport dao;
	
	@Override
	public int insert(ScsDish scsDish) {
		return dao.insert(PREFIX + ".insert", scsDish);
	}

	@Override
	public int delete(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return dao.delete(PREFIX + ".delete", map);
	}

	@Override
	public ScsDish selectByPrimaryKey(String id) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return dao.get(PREFIX + ".selectByPrimaryKey", map);
	}

	@Override
	public <E, K, V> Page<E> pageAndSort(Map<String, Object> params, int current, int pagesize, String sortString) {
		return dao.pageAndSort(PREFIX + ".page", params, current, pagesize, sortString);
	}

	@Override
	public int updateByPrimaryKeySelective(ScsDish scsDish) {
		return dao.update(PREFIX +".updateByPrimaryKeySelective", scsDish) ;
	}

	@Override
	public int updateByPrimaryKey(ScsDish scsDish) {
		// TODO Auto-generated method stub
		return 0;
	}

}
