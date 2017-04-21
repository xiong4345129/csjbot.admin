package com.csjbot.admin.data.scs.dao;

import java.util.List;
import java.util.Map;

import com.csjbot.admin.data.scs.model.ScsAccessory;
import com.csjbot.admin.page.Page;

public interface ScsAccessoryDAO {
	public final static String PREFIX = ScsAccessoryDAO.class.getName();
	
    int deleteByPrimaryKey(String id);

    int insert(ScsAccessory record);

    int insertSelective(ScsAccessory record);

    ScsAccessory selectByPrimaryKey(String id);
    
    List<ScsAccessory> selectAll();
	  
    public <E, K, V> Page<E> pageAndSort(Map<String, Object> params,int current, int pagesize, String sortString);
}
