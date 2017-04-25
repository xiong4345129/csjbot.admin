package com.csjbot.admin.data.scs.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csjbot.admin.data.DaoSupport;
import com.csjbot.admin.data.scs.dao.ScsDeskDao;
import com.csjbot.admin.data.scs.model.ScsDesk;
import com.csjbot.admin.page.Page;

/**
 * 数据访问接口
 * 
 * @author xiongmietao
 * 
 */
@Repository
public class ScsDeskDaoImpl implements ScsDeskDao{
	
	@Autowired
	private DaoSupport dao;

	@Override
	public int insert(ScsDesk scsDesk) {
		return dao.insert(PREFIX + ".insert", scsDesk);
	}

	@Override
	public int delete(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return dao.delete(PREFIX + ".delete", map);
	}

	@Override
	public ScsDesk selectByPrimaryKey(String id) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return dao.get(PREFIX + ".selectByPrimaryKey", map);
	}

	@Override
	public <E, K, V> Page<E> pageAndSort(Map<String, Object> params, int current, int pagesize,String sortString) {
		return dao.pageAndSort(PREFIX + ".page", params, current, pagesize, sortString);
	}
	
	
	

}
