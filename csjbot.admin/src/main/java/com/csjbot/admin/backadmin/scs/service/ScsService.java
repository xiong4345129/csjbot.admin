package com.csjbot.admin.backadmin.scs.service;

import java.util.List;
import java.util.Map;

import com.csjbot.admin.data.scs.model.ScsAccessory;
import com.csjbot.admin.data.scs.model.ScsDesk;
import com.csjbot.admin.data.scs.model.ScsDishType;
import com.csjbot.admin.data.scs.model.ScsDish;
import com.csjbot.admin.page.Page;

/**
 * @Description
 * @author XMT
 * @version V1.0
 */
public interface ScsService {

	public boolean insert(ScsDesk scsDesk);

	public boolean delete(String id);

	ScsDesk selectByPrimaryKey(String id);

	public <E, K, V> Page<E> pageAndSort(Map<String, Object> params, int current, int pagesize, String sortString);

	/**
	 * 
	 * 
	 */
	public boolean insertDish(ScsDish scsDish);
	public boolean updateDish(ScsDish sortdDish);

	public boolean deleteDish(String id);

     ScsDish selectDisByPrimaryKey(String id);

	public <E, K, V> Page<E> pageDishAndSort(Map<String, Object> params, int current, int pagesize, String sortString);

	/**
	 * 
	 * @param scsDesk
	 * @return
	 */
	public boolean insertDishType(ScsDishType scsDishType);
	public boolean updateDishType(ScsDishType scsDishType);
	public List<ScsDishType> selectAll();
	public boolean deleteDishType(Integer id);

	ScsDishType selectDishTypeByPrimaryKey(Integer id);

	public <E, K, V> Page<E> pageDishTypeAndSort(Map<String, Object> params, int current, int pagesize, String sortString);

	/**
	 * 
	 * @param scsDesk
	 * @return
	 */
	public boolean insertAccessory(ScsAccessory scsAccessory);
	public List<ScsAccessory> selectAcceAll();
	public boolean deleteAccessory(String id);

	ScsAccessory selectAccessoryByPrimaryKey(String id);

	public <E, K, V> Page<E> pageAccessoryAndSort(Map<String, Object> params, int current, int pagesize, String sortString);

}
