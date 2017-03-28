package com.csjbot.admin.data.pms.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csjbot.admin.data.DaoSupport;
import com.csjbot.admin.data.pms.dao.PmsAdvertisementDao;
import com.csjbot.admin.data.pms.model.PmsAdvertisement;

@Repository
public class PmsAdvertisementDaoImpl implements PmsAdvertisementDao {

	@Autowired DaoSupport dao;

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(PmsAdvertisement record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(PmsAdvertisement record) {
		// TODO Auto-generated method stub
		return 0;
	}
	  
	@Override
	public PmsAdvertisement selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(PmsAdvertisement record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(PmsAdvertisement record) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}