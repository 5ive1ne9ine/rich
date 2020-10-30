package com.oldduck.home.rich;

import com.oldduck.home.rich.dto.BillDetailDto;
import com.oldduck.home.rich.manager.BillManager;
import com.oldduck.home.rich.mapper.BillDetailMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class RichApplicationTests {

    Logger logger = LoggerFactory.getLogger(RichApplicationTests.class);

    @Autowired
    private BillManager billManager;
    @Autowired
    private BillDetailMapper billDetailMapper;

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
        billDetail.setFlow("O");
        billDetail.setBilltype("1");
        billDetail.setBilldate("20201029");
        billDetail.setOutaccount("165111161");
        billDetail.setInaccount("");
        billManager.addBill(billDetail);
    }

    @Test
    void billMapper() {
        List<BillDetailDto> detailDtos = billDetailMapper.selectDataByUseridYeatMonth("odinc", "202010");
        System.out.println(detailDtos.size());
    }

}
