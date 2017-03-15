
/**   
 * @Title: SysDataDao.java 
 * @Package: com.csjbot.admin.data.sys.dao 
 * @Description: TODO
 * @author DCJ  
 * @date 2015-4-29 下午10:11:03 
 * @version 1.0 
 */


package com.csjbot.admin.data.sys.dao;

import java.util.Map;

import com.csjbot.admin.data.sys.model.SysData;
import com.csjbot.admin.page.Page;

/** 
 * @Description 
 * @author DCJ
 * @date 2015-4-29 下午10:11:03 
 * @version V1.0
 */

public interface SysDataDao {
	
	public final static String PREFIX = SysDataDao.class.getName();

	 
	/** 
	 * @Description 
	 * @author DCJ
	 * @param params
	 * @return  
	 */
	  	
	Map<String, Object> findOneByCode(Map<String, Object> params);


	 
	/** 
	 * @Description 
	 * @author DCJ
	 * @param current
	 * @param pagesize
	 * @return  
	 */
	  	
	public <E, K, V> Page<E> page( int current, int pagesize);



	 
	/** 
	 * @Description 
	 * @author DCJ
	 * @param params
	 * @return  
	 */
	  	
	SysData findSysDataById(Map<String, Object> params);

}
