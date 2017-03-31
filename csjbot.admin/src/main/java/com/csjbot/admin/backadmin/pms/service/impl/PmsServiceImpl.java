
/**   
 * @Title: DictionaryServiceImpl.java 
 * @Package: com.csjbot.admin.backadmin.sys.service.impl 
 * @Description: TODO
 * @author DCJ  
 * @date 2015-4-29 下午10:33:14 
 * @version 1.0 
 */


package com.csjbot.admin.backadmin.pms.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csjbot.admin.backadmin.pms.service.PmsService;
import com.csjbot.admin.data.pms.dao.PmsAdvertisementDao;
import com.csjbot.admin.data.pms.dao.PmsProductDao;
import com.csjbot.admin.data.pms.model.PmsAdvertisement;
import com.csjbot.admin.data.pms.model.PmsProduct;
import com.csjbot.admin.page.Page;

/** 
 * @Description 
 * @author DCJ
 * @date 2015-4-29 下午10:33:14 
 * @version V1.0
 */

@Service
public class PmsServiceImpl implements PmsService{
	
	@Autowired
	private PmsProductDao pmsProductDao;
	@Autowired
	private PmsAdvertisementDao pmsAdvertisementDao;
    /** 
     * @author CJay       
     * @created 2017年3月21日 下午2:58:49        
     */  
	@Override
	public Page<Map<String, Object>> pageAndSort(Map<String, Object> params,int current, int pagesize, String sortString) {
		return pmsProductDao.pageAndSort(params, current, pagesize, sortString);
	}
	  
	@Override
	public boolean insert(PmsProduct product) {
		return pmsProductDao.insert(product)>0;
	}

	@Override
	public PmsProduct selectByPrimaryKey(String id) {
		return pmsProductDao.selectByPrimaryKey(id);
	}
	
	@Override
	public boolean update(PmsProduct product) {
		return pmsProductDao.updateByPrimaryKeySelective(product)>0;
	}
	    
	@Override
	public boolean deleteByPrimaryKey(String id) {
		return pmsProductDao.deleteByPrimaryKey(id)>0;
	}

	  
    /** 
     * @author CJay       
     * @created 2017年3月28日 上午10:37:30        
     */  
    
	@Override
	public Page<Map<String, Object>> AdvPageAndSort(Map<String, Object> params,	int current, int pagesize, String sortString) {
		return pmsAdvertisementDao.pageAndSort(params, current, pagesize, sortString);
	}

	  
	@Override
	public boolean insertAdvertisement(PmsAdvertisement pmsAdvertisement) {
		return pmsAdvertisementDao.insert(pmsAdvertisement)>0;
	}

	@Override
	public boolean deleteAdvByPrimaryKey(String id) {
		return pmsAdvertisementDao.deleteByPrimaryKey(id)>0;
	}

	@Override
	public PmsAdvertisement selectAdvByPrimaryKey(String id) {
		return pmsAdvertisementDao.selectByPrimaryKey(id);
	}

	@Override
	public boolean updateAdvertisement(PmsAdvertisement pmsAdvertisement) {
		return pmsAdvertisementDao.updateByPrimaryKeySelective(pmsAdvertisement)>0;
	}
	


}
