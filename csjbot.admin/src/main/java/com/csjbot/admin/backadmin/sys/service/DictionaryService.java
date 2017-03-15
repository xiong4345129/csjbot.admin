
/**   
 * @Title: DictionaryService.java 
 * @Package: com.csjbot.admin.backadmin.sys.service 
 * @Description: TODO
 * @author DCJ  
 * @date 2015-4-29 下午10:32:41 
 * @version 1.0 
 */


package com.csjbot.admin.backadmin.sys.service;

import java.util.List;
import java.util.Map;

import com.csjbot.admin.data.sys.model.SysData;
import com.csjbot.admin.data.sys.model.SysDataDictionary;
import com.csjbot.admin.page.Page;

/** 
 * @Description 
 * @author DCJ
 * @date 2015-4-29 下午10:32:41 
 * @version V1.0
 */

public interface DictionaryService {

	 
	/** 
	 * @Description 
	 * @author DCJ
	 * @param glmk
	 * @return  
	 */
	  	
	Map<String, Object> findOneByCode(String code);

	 
	/** 
	 * @Description 
	 * @author DCJ
	 * @param dictionaryId
	 * @return  
	 */
	  	
	public <T, K, V> List<T> findDicById(Integer dictionaryId,String tenantFk);


	 
	/** 
	 * @Description 
	 * @author DCJ
	 * @param bbsj
	 * @return  
	 */
	  	
	List<SysDataDictionary> findDictionaryByCode(String code);


	 
	/** 
	 * @Description 
	 * @author DCJ
	 * @param i
	 * @param pageSize
	 * @return  
	 */
	  	
	Page<Map<String, Object>> page(int current, int pageSize);


	 
	/** 
	 * @Description 
	 * @author DCJ
	 * @param params
	 * @param i
	 * @param pageSize
	 * @return  
	 */
	  	
	Page<Map<String, Object>> sonpage(Map<String, Object> params, int current,	int pageSize);


	 
	/** 
	 * @Description 
	 * @author DCJ
	 * @param parseInt
	 * @return  
	 */
	  	
	SysData findSysDataById(int parseInt);


	 
	/** 
	 * @Description 
	 * @author DCJ
	 * @param parseInt
	 * @return  
	 */
	  	
	SysDataDictionary findSysDataDicById(int parseInt);


	/** 
	 * @Description 
	 * @author DCJ
	 * @return  
	 */
	  	
	int dicDataUpdate(SysDataDictionary dicdata);


	 
	/** 
	 * @Description 
	 * @author DCJ
	 * @param dicdata  
	 */
	  	
	int dicDataInsert(SysDataDictionary dicdata);

}
