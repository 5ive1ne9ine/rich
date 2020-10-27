package com.oldduck.home.rich;

import com.oldduck.home.rich.dto.BillDetailDto;
import com.oldduck.home.rich.manager.BillManager;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class RichApplicationTests {

    Logger logger = LoggerFactory.getLogger(RichApplicationTests.class);

    @Autowired
    private BillManager billManager;

    @Test
    void contextLoads() {
        
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        
    }

    @Test
    void billTest() {

        BillDetailDto billDetail = new BillDetailDto();
        billDetail.setUserid("odinc");
        billDetail.setAmount(new BigDecimal("10.27"));
        billDetail.setMoneytype("156");
        billDetail.setFlow("I");
        billDetail.setBilltype("1");
        billDetail.setBilldate("20201027");
        billDetail.setOutaccount("out");
        billDetail.setInaccount("in");
        billManager.addBill(billDetail);

    }

}
