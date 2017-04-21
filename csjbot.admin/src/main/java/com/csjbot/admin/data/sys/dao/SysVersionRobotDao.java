package com.csjbot.admin.data.sys.dao;

import java.util.Map;

import com.csjbot.admin.data.sys.model.SysVersionRobot;
import com.csjbot.admin.page.Page;

public interface SysVersionRobotDao {
	
	public final static String PREFIX = SysVersionRobotDao.class.getName();
	
    int deleteByPrimaryKey(String id);

    int insert(SysVersionRobot record);

    int insertSelective(SysVersionRobot record);

    SysVersionRobot selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysVersionRobot record);

    int updateByPrimaryKey(SysVersionRobot record);
    
    public <E, K, V> Page<E> pageAndSort(Map<String, Object> params,int current, int pagesize, String sortString);
}