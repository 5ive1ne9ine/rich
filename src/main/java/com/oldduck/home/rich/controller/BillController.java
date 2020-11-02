package com.oldduck.home.rich.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.google.gson.Gson;
import com.oldduck.home.rich.dto.BillDetailDto;
import com.oldduck.home.rich.manager.BillManager;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
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
    public String addBill(@RequestParam("amount") String amount,
                          @RequestParam("flow") String flow,
                          @RequestParam("billtype") String billType,
                          @RequestParam("billdate") String billDate,
                          @RequestParam("inaccount") String inAccount,
                          @RequestParam("outaccount") String outAccount
                          ) {
        try {
            BillDetailDto detailDto = new BillDetailDto();
            detailDto.setAmount(new BigDecimal(amount));
            detailDto.setFlow(flow);
            detailDto.setBilltype(billType);
            detailDto.setBilldate(StringUtils.replace(billDate, "-", ""));
            detailDto.setInaccount(inAccount);
            detailDto.setOutaccount(outAccount);
            billManager.addBill(detailDto);
        } catch (Exception e) {
            logger.error("addBill failed:", e);
        }
        return "index";
    }

    @RequestMapping("/delBill")
    public String delBill(@RequestBody String serialno) {
        billManager.deleteBill(serialno);
        return "index";
    }

    @RequestMapping("/queryDetail")
    @ResponseBody
    public String queryDetail(@RequestBody String userId) {
        Map<String, Object> map = billManager.queryDetail(userId);
        return new Gson().toJson(map);
    }
}
