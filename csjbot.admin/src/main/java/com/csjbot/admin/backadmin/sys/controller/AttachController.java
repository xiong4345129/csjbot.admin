package com.csjbot.admin.backadmin.sys.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csjbot.admin.backadmin.sys.service.SysAttachService;
import com.csjbot.admin.data.sys.model.SysAttachment;

  
/**          
 * Description 
 * @author CJay       
 * @created 2017年3月23日 下午3:49:44    
 */
@Controller
@RequestMapping("/attach")
public class AttachController {

	@Autowired SysAttachService sysAttachService;
	
	    @RequestMapping(value = "{id}/{type}/pic")  
	    public void createFolw(@PathVariable String id,@PathVariable String type, HttpServletRequest request, HttpServletResponse response) {  
	        FileInputStream fis = null;  
	        OutputStream os = null;  
	        SysAttachment sysAttachment = sysAttachService.getAttachByTransInfo(id, type);
	        try {  
	            fis = new FileInputStream(sysAttachment.getLocation());  
	            os = response.getOutputStream();  
	            int count = 0;  
	            byte[] buffer = new byte[1024 * 8];  
	            while ((count = fis.read(buffer)) != -1) {  
	                os.write(buffer, 0, count);  
	                os.flush();  
	            }  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        try {  
	            fis.close();  
	            os.close();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	    }  
	}  
