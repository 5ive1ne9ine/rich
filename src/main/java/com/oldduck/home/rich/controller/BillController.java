package com.oldduck.home.rich.controller;

import com.oldduck.home.rich.dto.BillDetailDto;
import com.oldduck.home.rich.manager.BillManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author £ºex-caihh
 * @description£ºbill
 * @date £ºCreated in 2020/10/27 13:40
 */
@RequestMapping("/bill")
public class BillController {
    
    private Logger logger = LoggerFactory.getLogger(BillController.class);

    @Autowired
    private BillManager billManager;

    @RequestMapping("/addBill")
    public String addBill(@RequestBody BillDetailDto billDetailDto) {
        billManager.addBill(billDetailDto);
        return "";
    }
    
}
