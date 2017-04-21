package com.csjbot.admin.data.scs.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csjbot.admin.data.DaoSupport;
import com.csjbot.admin.data.scs.dao.ScsAccessoryDAO;
import com.csjbot.admin.data.scs.model.ScsAccessory;
import com.csjbot.admin.data.scs.model.ScsDishType;
import com.csjbot.admin.page.Page;
@Repository
public class ScsAccessoryDAOImpl implements ScsAccessoryDAO{

	@Autowired
	private DaoSupport dao;

	@Override
	public int insert(ScsAccessory scsAccessory) {
		return dao.insert(PREFIX + ".insert", scsAccessory);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return dao.delete(PREFIX + ".delete", map);
	}

	@Override
	public ScsAccessory selectByPrimaryKey(String id) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return dao.get(PREFIX + ".selectByPrimaryKey", map);
	}

	@Override
	public <E, K, V> Page<E> pageAndSort(Map<String, Object> params, int current, int pagesize, String sortString) {
		return dao.pageAndSort(PREFIX + ".page", params, current, pagesize, sortString);
	}

	@Override
	public List<ScsAccessory> selectAll() {
		List<ScsAccessory> list = dao.find(PREFIX +".selectAll");
		return list;
	}

	@Override
	public int insertSelective(ScsAccessory record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
