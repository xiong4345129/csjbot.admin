package com.csjbot.admin.backadmin.sys.service;

import com.csjbot.admin.data.sys.model.SysAttachment;
import com.csjbot.admin.exception.ServiceException;


public interface SysAttachService {
    
    boolean insert(SysAttachment attach) throws ServiceException;
    
    void deleteByTransInfo(String transation_id,String transation_type);
    
    SysAttachment getAttachByTransInfo(String transaction_id , String transaction_type);
    
    SysAttachment getAttachByTransInfo(String transaction_id , String transaction_type, String fileName);
    
    String filenameChange(String filename);
}
