package com.oldduck.home.rich;

import com.alibaba.druid.support.json.JSONUtils;
import com.google.gson.internal.$Gson$Preconditions;
import com.oldduck.home.rich.dto.BillDetailDto;
import com.oldduck.home.rich.manager.BillManager;
import com.oldduck.home.rich.mapper.BillDetailMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@SpringBootTest
class RichApplicationTests {

    Logger logger = LoggerFactory.getLogger(RichApplicationTests.class);

    @Autowired
    private BillManager billManager;
    @Autowired
    private BillDetailMapper billDetailMapper;

    public static void main(String[] args) {

        File file = new File("G:\\1.Java_video\\尚硅谷\\4.尚硅谷全套JAVA教程--JavaEE高级\\尚硅谷韩顺平Netty核心技术教程\\视频");
        for (File listFile : file.listFiles()) {
            listFile.renameTo(new File(listFile.getAbsolutePath().replace("尚硅谷-Netty核心技术及源码剖析-", "")));
        }

    }

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
        billDetail.setBilldate("20201030");
        billDetail.setOutaccount("165111161");
        billDetail.setInaccount("");
        billManager.addBill(billDetail);
    }

    @Test
    void billMapper() {
        List<BillDetailDto> detailDtos = billDetailMapper.selectDataByUseridYeatMonth("odinc", "202010");
        System.out.println(detailDtos.size());
    }

    @Test
    void billQuery() {
        Map<String, Object> map = billManager.queryDetail("odinc");
        System.out.println(JSONUtils.toJSONString(map));
    }

}
