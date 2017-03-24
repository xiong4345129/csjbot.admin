package com.csjbot.admin.backadmin.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csjbot.admin.backadmin.sys.service.SysAttachService;
import com.csjbot.admin.data.sys.dao.SysAttachmentDao;
import com.csjbot.admin.data.sys.model.SysAttachment;
import com.csjbot.admin.exception.ServiceException;
import com.csjbot.admin.util.FileUtil;


@Service
public class SysAttachServiceImpl implements SysAttachService{
    
    @Autowired
    private SysAttachmentDao sysAttachDao;
    
	@Override
	public boolean insert(SysAttachment attach) throws ServiceException {
		return sysAttachDao.insert(attach);
	}

	@Override
	public SysAttachment getAttachByTransInfo(String transaction_id,String transaction_type) {
		return sysAttachDao.getAttachByTransInfo(transaction_id,transaction_type);
	}

	  
	@Override
	public void deleteByTransInfo(String transation_id, String transation_type) {
		SysAttachment sysAttachment = this.getAttachByTransInfo(transation_id, transation_type);
		if(null==sysAttachment)return;
		FileUtil fileUtil = new FileUtil();
		fileUtil.deleteFile(sysAttachment.getLocation());
		sysAttachDao.deleteByTransInfo(transation_id,transation_type);
	}



}
