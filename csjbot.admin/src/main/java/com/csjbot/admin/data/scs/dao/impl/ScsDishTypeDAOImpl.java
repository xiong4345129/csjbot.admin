package com.csjbot.admin.data.scs.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csjbot.admin.data.DaoSupport;
import com.csjbot.admin.data.scs.dao.ScsDishTypeDAO;
import com.csjbot.admin.data.scs.model.ScsDishType;
import com.csjbot.admin.page.Page;
/**
 * 
 * @author Zhangyangyang
 *
 */
@Repository
public class ScsDishTypeDAOImpl implements ScsDishTypeDAO{
	
	@Autowired
	private DaoSupport dao;

	@Override
	public int insert(ScsDishType scsDishType) {
		return dao.insert(PREFIX + ".insert", scsDishType);
	}

	@Override
	public int delete(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return dao.delete(PREFIX + ".delete", map);
	}

	@Override
	public ScsDishType selectByPrimaryKey(Integer id) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return dao.get(PREFIX + ".selectByPrimaryKey", map);
	}

	@Override
	public <E, K, V> Page<E> pageAndSort(Map<String, Object> params, int current, int pagesize, String sortString) {
		return dao.pageAndSort(PREFIX + ".page", params, current, pagesize, sortString);
	}

	@Override
	public int updateByPrimaryKeySelective(ScsDishType scsDishType) {
		return dao.update(PREFIX +".updateByPrimaryKeySelective", scsDishType) ;
	}

	@Override
	public int updateByPrimaryKey(ScsDishType scsDishType) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ScsDishType> selectAll() {
		List<ScsDishType> list = dao.find(PREFIX +".selectAll");
		return list;
	}

}
