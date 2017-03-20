
/**   
 * @Title: XmlController.java 
 * @Package: com.bravowhale.ecp.admin.backadmin.tms.controller 
 * @Description: TODO
 * @author DCJ  
 * @date 2015-4-28 下午3:54:11 
 * @version 1.0 
 */


package com.csjbot.admin.backadmin.api.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csjbot.admin.util.XMLHandler;


/** 
 * @Description 
 * @author DCJ
 * @date 2015-4-28 下午3:54:11 
 * @version V1.0
 */
//增加ECP Pad打包时，获取指定租户xml信息  NO.01 DCJ
@Controller
@RequestMapping(value = "/xml")
public class XmlController {
	
	 private Logger logger = Logger.getLogger(XmlController.class);
	 
	// NO.01
	@RequestMapping(value = "/test")
	public @ResponseBody ResponseEntity<String> getTestXml(HttpServletResponse response) {
        XMLHandler xmlHander = new XMLHandler();
        String xml = xmlHander.createXML();
        logger.info("xml:"+xml);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        response.setCharacterEncoding("UTF-8");
        ResponseEntity<String> result = new ResponseEntity<String>(xml, headers, HttpStatus.OK);
        return result;
	}

}
