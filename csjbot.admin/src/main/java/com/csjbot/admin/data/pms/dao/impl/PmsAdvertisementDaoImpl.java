package com.csjbot.admin.data.pms.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csjbot.admin.data.DaoSupport;
import com.csjbot.admin.data.pms.dao.PmsAdvertisementDao;
import com.csjbot.admin.data.pms.model.PmsAdvertisement;
import com.csjbot.admin.page.Page;

@Repository
public class PmsAdvertisementDaoImpl implements PmsAdvertisementDao {

	@Autowired DaoSupport dao;

	@Override
	public int deleteByPrimaryKey(String id) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		return dao.delete(PREFIX +".deleteByPrimaryKey", map);
	}

	@Override
	public int insert(PmsAdvertisement record) {
		return dao.insert(PREFIX +".insert", record);
	}

	@Override
	public int insertSelective(PmsAdvertisement record) {
		// TODO Auto-generated method stub
		return 0;
	}
	  
	@Override
	public PmsAdvertisement selectByPrimaryKey(String id) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		return dao.get(PREFIX + ".selectByPrimaryKey", map);
	}

	@Override
	public int updateByPrimaryKeySelective(PmsAdvertisement record) {
		return dao.update(PREFIX + ".updateByPrimaryKeySelective", record);
	}

	@Override
	public int updateByPrimaryKey(PmsAdvertisement record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <E, K, V> Page<E> pageAndSort(Map<String, Object> params, int current, int pagesize, String sortString) {
		return dao.pageAndSort(PREFIX + ".page", params, current, pagesize, sortString);
	}
	
}