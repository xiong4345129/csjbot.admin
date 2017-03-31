package com.csjbot.admin.data.pms.dao;

import java.util.Map;

import com.csjbot.admin.data.pms.model.PmsAdvertisement;
import com.csjbot.admin.page.Page;

public interface PmsAdvertisementDao {
	
	public final static String PREFIX = PmsAdvertisementDao.class.getName();
			
    int deleteByPrimaryKey(String id);

    int insert(PmsAdvertisement record);

    int insertSelective(PmsAdvertisement record);

    PmsAdvertisement selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PmsAdvertisement record);

    int updateByPrimaryKey(PmsAdvertisement record);
	  
    public <E, K, V> Page<E> pageAndSort(Map<String, Object> params,int current, int pagesize, String sortString);
}