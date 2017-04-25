package com.csjbot.admin.data.sys.dao.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csjbot.admin.data.DaoSupport;
import com.csjbot.admin.data.sys.dao.SysVersionRobotDao;
import com.csjbot.admin.data.sys.model.SysVersionRobot;
import com.csjbot.admin.page.Page;

/**          
     * Description 
     * @author CJay       
     * @created 2017年4月20日 下午2:31:22    
     */
@Repository
public class SysVersionRobotDaoImpl implements SysVersionRobotDao {

	@Autowired DaoSupport dao;
	
	/** 
	 * @author CJay       
	 * @created 2017年4月20日 下午2:31:23        
	 */

	@Override
	public int deleteByPrimaryKey(String id) {
		return dao.delete(PREFIX +".deleteByPrimaryKey",id);
	}

	/** 
	 * @author CJay       
	 * @created 2017年4月20日 下午2:31:23        
	 */

	@Override
	public int insert(SysVersionRobot sysVersionRobot) {
		return dao.insert(PREFIX +".insert",sysVersionRobot);
	}

	/** 
	 * @author CJay       
	 * @created 2017年4月20日 下午2:31:23        
	 */

	@Override
	public int insertSelective(SysVersionRobot record) {
		// TODO Auto-generated method stub
		return 0;
	}

	/** 
	 * @author CJay       
	 * @created 2017年4月20日 下午2:31:23        
	 */

	@Override
	public SysVersionRobot selectByPrimaryKey(String id) {
		return dao.get(PREFIX +".selectByPrimaryKey",id);
	}

	/** 
	 * @author CJay       
	 * @created 2017年4月20日 下午2:31:23        
	 */

	@Override
	public int updateByPrimaryKeySelective(SysVersionRobot record) {
		return dao.update(PREFIX +".updateByPrimaryKeySelective",record);
	}

	/** 
	 * @author CJay       
	 * @created 2017年4月20日 下午2:31:23        
	 */

	@Override
	public int updateByPrimaryKey(SysVersionRobot record) {
		// TODO Auto-generated method stub
		return 0;
	}

	  
    /** 
     * @author CJay       
     * @created 2017年4月20日 下午3:05:31        
     */  
	@Override
	public <E, K, V> Page<E> pageAndSort(Map<String, Object> params, int current, int pagesize, String sortString) {
		return dao.pageAndSort(PREFIX + ".page", params, current, pagesize, sortString);
	}

}
