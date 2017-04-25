
/**   
 * @Title: DictionaryServiceImpl.java 
 * @Package: com.csjbot.admin.backadmin.sys.service.impl 
 * @Description: TODO
 * @author DCJ  
 * @date 2015-4-29 下午10:33:14 
 * @version 1.0 
 */


package com.csjbot.admin.backadmin.tms.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csjbot.admin.backadmin.tms.service.VrcService;
import com.csjbot.admin.data.sys.dao.SysVersionRobotDao;
import com.csjbot.admin.data.sys.model.SysVersionRobot;
import com.csjbot.admin.page.Page;

/** 
 * @Description 
 * @author DCJ
 * @date 2015-4-29 下午10:33:14 
 * @version V1.0
 */

@Service
public class VrcServiceImpl implements VrcService{
	
	@Autowired
	private SysVersionRobotDao sysVersionRobotDao;
	
	@Override
	public Page<Map<String, Object>> pageAndSort(Map<String, Object> params,int current, int pagesize, String sortString) {
		return sysVersionRobotDao.pageAndSort(params, current, pagesize, sortString);
	}

	    
	@Override
	public boolean insert(SysVersionRobot sysVersionRobot) {
		return sysVersionRobotDao.insert(sysVersionRobot)>0;
	}

	@Override
	public SysVersionRobot selectByPrimaryKey(String id) {
		return sysVersionRobotDao.selectByPrimaryKey(id);
	}

	@Override
	public boolean updateVersionRobot(SysVersionRobot sysVersionRobot) {
		return sysVersionRobotDao.updateByPrimaryKeySelective(sysVersionRobot)>0;
	}

	@Override
	public boolean deleteVersionByPrimaryKey(String id) {
		return sysVersionRobotDao.deleteByPrimaryKey(id)>0;
	}

}
