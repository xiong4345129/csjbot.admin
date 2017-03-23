package com.csjbot.admin.data.pms.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csjbot.admin.data.DaoSupport;
import com.csjbot.admin.data.pms.dao.PmsProductDao;
import com.csjbot.admin.data.pms.model.PmsProduct;
import com.csjbot.admin.page.Page;

@Repository
public class PmsProductDaoImpl implements PmsProductDao {

	@Autowired DaoSupport dao;
	
	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(PmsProduct product) {
		return dao.insert(PREFIX +".insert",product);
	}

	@Override
	public int insertSelective(PmsProduct record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PmsProduct selectByPrimaryKey(String id) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		return dao.get(PREFIX +".selectByPrimaryKey", map);
	}

	@Override
	public int updateByPrimaryKeySelective(PmsProduct record) {
		return dao.update(PREFIX +".updateByPrimaryKeySelective", record) ;
	}

	@Override
	public int updateByPrimaryKey(PmsProduct record) {
		// TODO Auto-generated method stub
		return 0;
	}

	  
	@Override
	public <E, K, V> Page<E> pageAndSort(Map<String, Object> params, int current, int pagesize, String sortString) {
		return dao.pageAndSort(PREFIX + ".page", params, current, pagesize, sortString);
	}
}