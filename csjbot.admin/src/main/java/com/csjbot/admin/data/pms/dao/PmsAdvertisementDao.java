package com.csjbot.admin.data.pms.dao;

import com.csjbot.admin.data.pms.model.PmsAdvertisement;

public interface PmsAdvertisementDao {
	
	public final static String PREFIX = PmsAdvertisementDao.class.getName();
			
    int deleteByPrimaryKey(String id);

    int insert(PmsAdvertisement record);

    int insertSelective(PmsAdvertisement record);

    PmsAdvertisement selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PmsAdvertisement record);

    int updateByPrimaryKey(PmsAdvertisement record);
}