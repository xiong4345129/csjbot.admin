package com.csjbot.admin.backadmin.scs.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csjbot.admin.backadmin.scs.service.ScsService;
import com.csjbot.admin.data.scs.dao.ScsDeskDao;
import com.csjbot.admin.data.scs.model.ScsDesk;
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

}
