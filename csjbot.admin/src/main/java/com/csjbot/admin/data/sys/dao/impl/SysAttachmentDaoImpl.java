package com.csjbot.admin.data.sys.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csjbot.admin.data.DaoSupport;
import com.csjbot.admin.data.sys.dao.SysAttachmentDao;
import com.csjbot.admin.data.sys.dao.SysDataDao;
import com.csjbot.admin.data.sys.model.SysAttachment;
import com.csjbot.admin.data.sys.model.SysData;
import com.csjbot.admin.page.Page;

/** 
 * @Description 
 * @author DCJ
 * @date 2017-3-21 
 * @version V1.0
 */

@Repository
public class SysAttachmentDaoImpl implements SysAttachmentDao{

	@Autowired  private DaoSupport dao;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean insert(SysAttachment record) {
		return dao.insert(PREFIX + ".insert", record)>0;
	}

	@Override
	public int insertSelective(SysAttachment record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SysAttachment selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(SysAttachment record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(SysAttachment record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SysAttachment getAttachByTransInfo(String transaction_id,String transaction_type) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("transaction_id", transaction_id);
		map.put("transaction_type", transaction_type);
		return dao.get(PREFIX + ".getAttachByTransInfo", map);
	}

	    
	@Override
	public void deleteByTransInfo(String transation_id, String transation_type) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("transaction_id", transation_id);
		map.put("transaction_type", transation_type);
		dao.delete(PREFIX + ".deleteByTransInfo", map);
	}
	

}
