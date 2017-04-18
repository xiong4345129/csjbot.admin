package com.csjbot.admin.backadmin.scs.service;

import java.util.Map;

import com.csjbot.admin.data.scs.model.ScsDesk;
import com.csjbot.admin.page.Page;
/**
* @Description
* @author XMT
* @version V1.0
*/
public interface ScsService {
	
    public boolean insert(ScsDesk scsDesk);
	
	public boolean delete(String id);
	
	ScsDesk selectByPrimaryKey(String  id);
	
	public <E, K, V> Page<E> pageAndSort(Map<String, Object> params,int current, int pagesize, String sortString);

}
