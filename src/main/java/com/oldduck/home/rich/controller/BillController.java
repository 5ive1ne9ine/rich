package com.oldduck.home.rich.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.oldduck.home.rich.dto.BillDetailDto;
import com.oldduck.home.rich.manager.BillManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author £ºex-caihh
 * @description£ºbill
 * @date £ºCreated in 2020/10/27 13:40
 */
@Controller
@RequestMapping("/bill")
public class BillController {
    
    private Logger logger = LoggerFactory.getLogger(BillController.class);

    @Autowired
    private BillManager billManager;

    @RequestMapping("/addBill")
    public String addBill(@RequestBody BillDetailDto billDetailDto) {
        billManager.addBill(billDetailDto);
        return "html/index.html";
    }

    @RequestMapping("/delBill")
    public String delBill(@RequestBody String serialno) {
        billManager.deleteBill(serialno);
        return "html/index.html";
    }

    @RequestMapping("/queryDetail")
    @ResponseBody
    public String queryDetail(@RequestBody String userId){
        Map<String, Object> map = billManager.queryDetail(userId);
        return JSONUtils.toJSONString(map);
    }
}
