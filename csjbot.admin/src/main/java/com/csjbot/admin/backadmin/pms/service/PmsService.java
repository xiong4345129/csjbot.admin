
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

import com.csjbot.admin.data.pms.model.PmsAdvertisement;
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
     * @discription 产品列表
     * @author CJay       
     * @created 2017年3月21日 下午2:58:18        
     */
	Page<Map<String, Object>> pageAndSort(Map<String, Object> params, int i,
			int length, String sortString);
	
	boolean insert(PmsProduct product);
	
	PmsProduct selectByPrimaryKey(String id);

	boolean update(PmsProduct pmsProduct);
	
	boolean deleteByPrimaryKey(String id);

	  
    /**     
     * @discription 广告列表
     * @author CJay       
     * @created 2017年3月28日 上午10:37:03        
     */
	Page<Map<String, Object>> AdvPageAndSort(Map<String, Object> params, int i,
			int length, String sortString);

	  
    /**     
     * @discription 新增广告
     * @author CJay       
     * @created 2017年3月28日 下午5:56:14        
     */
	boolean insertAdvertisement(PmsAdvertisement pmsAdvertisement);

	  
    /**     
     * @discription 删除广告
     * @author CJay       
     * @created 2017年3月28日 下午7:45:55        
     */
	boolean deleteAdvByPrimaryKey(String id);

	  
    /**     
     * @discription 主键查询广告
     * @author CJay       
     * @created 2017年3月29日 上午9:30:07        
     */
	PmsAdvertisement selectAdvByPrimaryKey(String id);

	  
    /**     
     * @discription 修改广告信息
     * @author CJay       
     * @created 2017年3月29日 下午5:00:25        
     */
	boolean updateAdvertisement(PmsAdvertisement pmsAdvertisement);

}
