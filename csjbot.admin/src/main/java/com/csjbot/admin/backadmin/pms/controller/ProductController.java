package com.csjbot.admin.backadmin.pms.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.csjbot.admin.backadmin.pms.service.PmsService;
import com.csjbot.admin.page.Page;
import com.csjbot.admin.util.StringUtil;
import com.csjbot.admin.web.entity.ResultEntity;
import com.csjbot.admin.web.entity.ResultEntityHashMapImpl;

/**          
 * Description: 产品信息
 * @author CJay       
 * @created 2017年3月21日 上午10:21:27    
 */
@Controller
@RequestMapping("/pms")
public class ProductController {
	
	@Autowired
	private PmsService pmsService;
	
	@RequestMapping(value = "/list")
    public ModelAndView portal() {
        ModelAndView mv = new ModelAndView("pms/product_list");
        return mv;
    }
	
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ResponseEntity<ResultEntity> page(HttpServletRequest request, HttpServletResponse response) {
        ResultEntity result = null;
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            int length = Integer.valueOf(request.getParameter("length"));
            int start = Integer.valueOf(request.getParameter("start"));
            String orderColIndex = request.getParameter("order[0][column]");
            String dir = request.getParameter("order[0][dir]");
            String orderName = request.getParameter("columns[" + orderColIndex + "][data]");

            String name = request.getParameter("name");
            if (StringUtil.notEmpty(name)) {
                params.put("name", name);
            }
            String sortString = null;
            if (orderName != null && !"".equals(orderName) && dir != null && !"".equals(dir)) {
                sortString = orderName + "." + dir;
            }
            Page<Map<String, Object>> pageMap = pmsService.pageAndSort(params, (start / length) + 1, length, sortString);
            result = new ResultEntityHashMapImpl(ResultEntity.KW_STATUS_SUCCESS, "search success");
            if (pageMap.getRows() != null && pageMap.getRows().size() > 0) {
                result.addObject("data", pageMap.getRows());
                result.addObject("recordsFiltered", pageMap.getTotal());
                result.addObject("recordsTotal", pageMap.getTotal());
            } else {
                result.addObject("data", null);
                result.addObject("recordsFiltered", 0);
                result.addObject("recordsTotal", 0);
            }

        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultEntityHashMapImpl(ResultEntity.KW_STATUS_FAIL, "Internal Server Error!");
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        response.setCharacterEncoding("UTF-8");
        return new ResponseEntity<ResultEntity>(result, headers, HttpStatus.OK);
    }
}
