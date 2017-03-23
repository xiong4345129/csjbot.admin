package com.csjbot.admin.data.sys.dao;

import com.csjbot.admin.data.sys.model.SysAttachment;

public interface SysAttachmentDao {
	
	public final static String PREFIX = SysAttachmentDao.class.getName();
			
    int deleteByPrimaryKey(Long id);

    boolean insert(SysAttachment record);

    int insertSelective(SysAttachment record);

    SysAttachment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysAttachment record);

    int updateByPrimaryKey(SysAttachment record);

	SysAttachment getAttachByTransInfo(String transaction_id,String transaction_type);

	void deleteByTransInfo(String transation_id, String transation_type);
}