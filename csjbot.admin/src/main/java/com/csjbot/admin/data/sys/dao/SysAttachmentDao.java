package com.csjbot.admin.data.sys.dao;

import com.csjbot.admin.data.sys.model.SysAttachment;

public interface SysAttachmentDao {
    int deleteByPrimaryKey(Long id);

    int insert(SysAttachment record);

    int insertSelective(SysAttachment record);

    SysAttachment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysAttachment record);

    int updateByPrimaryKey(SysAttachment record);
}