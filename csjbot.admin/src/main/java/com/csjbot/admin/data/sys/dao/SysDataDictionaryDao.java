
/**   
 * @Title: SysDataDictionaryDao.java 
 * @Package: com.csjbot.admin.data.sys.dao 
 * @Description: TODO
 * @author DCJ  
 * @date 2015-4-29 下午10:11:33 
 * @version 1.0 
 */


package com.csjbot.admin.data.sys.dao;

import java.util.List;
import java.util.Map;

import com.csjbot.admin.data.sys.model.SysDataDictionary;
import com.csjbot.admin.page.Page;

/** 
 * @Description 
 * @author DCJ
 * @date 2015-4-29 下午10:11:33 
 * @version V1.0
 */

public interface SysDataDictionaryDao {

	public final static String PREFIX = SysDataDictionaryDao.class.getName();
	/** 
	 * @Description 
	 * @author DCJ
	 * @param params
	 * @return  
	 */
	  	
	public <T, K, V> List<T> findDicById(Map<K, V> params);
	 
	/** 
	 * @Description 
	 * @author DCJ
	 * @param params
	 * @return  
	 */
	  	
	public <T, K, V> List<T> findDictionaryByCode(Map<String, Object> params);

	 
	/** 
	 * @Description 
	 * @author DCJ
	 * @param params
	 * @param current
	 * @param pagesize
	 * @return  
	 */
	public <E, K, V> Page<E> page( Map<String, Object> params,int current, int pagesize);

	 
	/** 
	 * @Description 
	 * @author DCJ
	 * @param params
	 * @return  
	 */
	  	
	public SysDataDictionary findSysDataDicById(Map<String, Object> params);

	 
	/** 
	 * @Description 
	 * @author DCJ
	 * @param dicdata
	 * @return  
	 */
	  	
	public int dicDataUpdate(SysDataDictionary dicdata);  
	
	public int dicDataInsert(SysDataDictionary dicdata);  

}
