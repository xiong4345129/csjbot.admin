
/**   
 * @Title: DictionaryService.java 
 * @Package: com.csjbot.admin.backadmin.sys.service 
 * @Description: TODO
 * @author DCJ  
 * @date 2015-4-29 下午10:32:41 
 * @version 1.0 
 */


package com.csjbot.admin.backadmin.tms.service;

import java.util.Map;

import com.csjbot.admin.data.sys.model.SysVersionRobot;
import com.csjbot.admin.page.Page;

/** 
 * @Description 
 * @author DCJ
 * @date 2015-4-29 下午10:32:41 
 * @version V1.0
 */

public interface VrcService {

	/**
	     * @discription 版本列表
	     * @author CJay       
	     * @created 2017年4月20日 下午3:10:20
	 */
	Page<Map<String, Object>> pageAndSort(Map<String, Object> params, int i,int length, String sortString);

	  
    /**     
     * @discription 新增版本
     * @author CJay       
     * @created 2017年4月20日 下午5:05:06        
     */
	boolean insert(SysVersionRobot sysVersionRobot);

		  
    /**     
     * @discription 版本信息
     * @author CJay       
     * @created 2017年4月21日 上午10:23:00        
     */
	SysVersionRobot selectByPrimaryKey(String id);


	  
    /**     
     * @discription 修改版本信息
     * @author CJay       
     * @created 2017年4月21日 下午2:11:33        
     */
	boolean updateVersionRobot(SysVersionRobot sysVersionRobot);


	  
    /**     
     * @discription 删除版本
     * @author CJay       
     * @created 2017年4月21日 下午2:16:59        
     */
	boolean deleteVersionByPrimaryKey(String id);

	


}
