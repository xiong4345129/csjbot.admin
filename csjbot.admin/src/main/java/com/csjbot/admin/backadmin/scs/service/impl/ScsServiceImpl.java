package com.csjbot.admin.backadmin.scs.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csjbot.admin.backadmin.scs.service.ScsService;
import com.csjbot.admin.data.scs.dao.ScsAccessoryDAO;
import com.csjbot.admin.data.scs.dao.ScsDeskDao;
import com.csjbot.admin.data.scs.dao.ScsDishDAO;
import com.csjbot.admin.data.scs.dao.ScsDishTypeDAO;
import com.csjbot.admin.data.scs.model.ScsAccessory;
import com.csjbot.admin.data.scs.model.ScsDesk;
import com.csjbot.admin.data.scs.model.ScsDishType;
import com.csjbot.admin.data.scs.model.ScsDish;
import com.csjbot.admin.page.Page;



/** 
 * @Description 
 * @author XMT
 * @date 2017-04-17 
 * @version V1.0
 */
@Service
public class ScsServiceImpl implements ScsService {
	
	@Autowired
	private ScsDeskDao scsDeskDao;

	@Autowired
	private ScsDishDAO scsDishDAO;
	
	@Autowired
	private ScsDishTypeDAO scsDishTypeDAO;
	
	@Autowired
	private ScsAccessoryDAO scsAccessoryDAO;
	
	@Override
	public boolean insert(ScsDesk scsDesk) {
		return scsDeskDao.insert(scsDesk)>0;
	}

	@Override
	public boolean delete(String id) {
		return scsDeskDao.delete(id)>0;
	}

	@Override
	public ScsDesk selectByPrimaryKey(String id) {
		return scsDeskDao.selectByPrimaryKey(id);
	}

	@Override
	public <E, K, V> Page<E> pageAndSort(Map<String, Object> params, int current, int pagesize, String sortString) {
		return scsDeskDao.pageAndSort(params, current, pagesize, sortString);
	}

	@Override
	public boolean insertDish(ScsDish scsDish) {
		
		return scsDishDAO.insert(scsDish) > 0;
	}

	@Override
	public boolean deleteDish(String id) {
		return scsDishDAO.delete(id) > 0;
	}

	@Override
	public ScsDish selectDisByPrimaryKey(String id) {
		return scsDishDAO.selectByPrimaryKey(id);
	}

	@Override
	public <E, K, V> Page<E> pageDishAndSort(Map<String, Object> params, int current, int pagesize, String sortString) {
		
		return scsDishDAO.pageAndSort(params, current, pagesize, sortString);
	}

	@Override
	public boolean insertDishType(ScsDishType scsDishType) {
		return scsDishTypeDAO.insert(scsDishType) > 0;
	}

	@Override
	public boolean deleteDishType(Integer id) {
		return scsDishTypeDAO.delete(id) > 0;
	}

	@Override
	public ScsDishType selectDishTypeByPrimaryKey(Integer id) {
		return scsDishTypeDAO.selectByPrimaryKey(id);
	}

	@Override
	public <E, K, V> Page<E> pageDishTypeAndSort(Map<String, Object> params, int current, int pagesize,
			String sortString) {
		return scsDishTypeDAO.pageAndSort(params, current, pagesize, sortString);
	}

	@Override
	public boolean updateDish(ScsDish sortdDish) {
		
		return scsDishDAO.updateByPrimaryKeySelective(sortdDish) > 0;
	}

	@Override
	public boolean updateDishType(ScsDishType scsDishType) {
		return scsDishTypeDAO.updateByPrimaryKeySelective(scsDishType) > 0;
	}

	@Override
	public List<ScsDishType> selectAll() {
		return scsDishTypeDAO.selectAll();
	}

	@Override
	public boolean insertAccessory(ScsAccessory scsAccessory) {
		
		return scsAccessoryDAO.insert(scsAccessory) > 0;
	}

	@Override
	public List<ScsAccessory> selectAcceAll() {
		return scsAccessoryDAO.selectAll();
	}

	@Override
	public boolean deleteAccessory(String id) {
		return scsAccessoryDAO.deleteByPrimaryKey(id) > 0;
	}

	@Override
	public ScsAccessory selectAccessoryByPrimaryKey(String id) {
		return scsAccessoryDAO.selectByPrimaryKey(id);
	}

	@Override
	public <E, K, V> Page<E> pageAccessoryAndSort(Map<String, Object> params, int current, int pagesize,
			String sortString) {
		return scsAccessoryDAO.pageAndSort(params, current, pagesize, sortString);
				
	}


}
