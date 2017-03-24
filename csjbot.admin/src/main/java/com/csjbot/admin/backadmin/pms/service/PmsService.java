
/**   
 * @Title: DictionaryService.java 
 * @Package: com.csjbot.admin.backadmin.sys.service 
 * @Description: TODO
 * @author DCJ  
 * @date 2015-4-29 下午10:32:41 
 * @version 1.0 
 */


package com.csjbot.admin.backadmin.pms.service;

import java.util.Map;

import com.csjbot.admin.data.pms.model.PmsProduct;
import com.csjbot.admin.page.Page;

/** 
 * @Description 
 * @author DCJ
 * @date 2015-4-29 下午10:32:41 
 * @version V1.0
 */

public interface PmsService {

	    /**     
	     * @discription 
	     * @author CJay       
	     * @created 2017年3月21日 下午2:58:18        
	     */
	Page<Map<String, Object>> pageAndSort(Map<String, Object> params, int i,
			int length, String sortString);
	
	boolean insert(PmsProduct product);
	
	PmsProduct selectByPrimaryKey(String id);

	boolean update(PmsProduct pmsProduct);
	
	boolean deleteByPrimaryKey(String id);

}
