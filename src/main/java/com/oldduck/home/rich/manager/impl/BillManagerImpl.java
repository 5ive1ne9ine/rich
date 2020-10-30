package com.oldduck.home.rich.manager.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.oldduck.home.rich.common.Constant;
import com.oldduck.home.rich.common.ResultCode;
import com.oldduck.home.rich.dto.BillDetailDto;
import com.oldduck.home.rich.dto.BuggetDto;
import com.oldduck.home.rich.exception.ApiException;
import com.oldduck.home.rich.manager.BillManager;
import com.oldduck.home.rich.mapper.BillDetailMapper;
import com.oldduck.home.rich.mapper.BuggetMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author ：ex-caihh
 * @description：
 * @date ：Created in 2020/10/27 13:54
 */
@Component(value = "billManager")
public class BillManagerImpl implements BillManager {

    private Logger logger = LoggerFactory.getLogger(BillManagerImpl.class);

    private static final SimpleDateFormat YEAR_MONTH_DAY_FORMAT = new SimpleDateFormat("yyyyMMdd");

    @Autowired
    private BillDetailMapper billDetailMapper;
    @Autowired
    private BuggetMapper buggetMapper;

    @Override
    public void addBill(BillDetailDto billDetailDto) {
        IOVerify(billDetailDto);
        billDetailMapper.insert(billDetailDto);
    }

    @Override
    public void deleteBill(String serialno) {
        billDetailMapper.deleteByPrimaryKey(Integer.parseInt(serialno));
    }

    @Override
    public Map<String, Object> queryDetail(String userId) {
        Map<String, Object> map = new HashMap<>();
        String curDate = YEAR_MONTH_DAY_FORMAT.format(new Date());
        logger.info("queryDetail start user:{},yearMonth:{}", userId, curDate);
        List<BillDetailDto> details = billDetailMapper.selectDataByUseridYeatMonth(userId, curDate.substring(0, 6));
        BuggetDto buggetDto = buggetMapper.selectByUserid(userId);
        BigDecimal curAmount = new BigDecimal(0);
        BigDecimal monthAmountCount = new BigDecimal(0);
        for (BillDetailDto detail : details) {
            monthAmountCount = monthAmountCount.add(detail.getAmount());
            if (StringUtils.equals(curDate, detail.getBilldate())) {
                curAmount = curAmount.add(detail.getAmount());
            }
        }
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:OO"));
        int day = c.get(Calendar.DAY_OF_MONTH);
        int last = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        BigDecimal diff = new BigDecimal(last - day + 1);
        //今日支出
        map.put("curAmount", curAmount);
        //月总支出
        map.put("monthAmountCount", monthAmountCount);
        //月预算
        map.put("bugget", buggetDto == null ? 0 : buggetDto.getBudget());
        //本月剩余
        map.put("monthSurplus", buggetDto == null ? 0 : buggetDto.getBudget().subtract(monthAmountCount));
        //月平均
        map.put("monthAve", buggetDto == null ? 0 : (buggetDto.getBudget().subtract(monthAmountCount)).divide(diff));
        //剩余天数
        map.put("days", diff);
        logger.info("queryDetail start user:{},yearMonth:{},resultMap:{}", userId, curDate, JSONUtils.toJSONString(map));
        return map;
    }

    private void IOVerify(BillDetailDto billDetail) {
        if (StringUtils.isEmpty(billDetail.getFlow())) {
            throw new ApiException(ResultCode.FLOW_ISEMPTY$1001);
        }
        if (StringUtils.equals(billDetail.getFlow(), Constant.FLOW_IN) && StringUtils.isEmpty(billDetail.getInaccount())) {
            throw new ApiException(ResultCode.INACCOUNT_ISEMPTY$1002);
        }
        if (StringUtils.equals(billDetail.getFlow(), Constant.FLOW_OUT) && StringUtils.isEmpty(billDetail.getOutaccount())) {
            throw new ApiException(ResultCode.OUTACCOUNT_ISEMPTY$1003);
        }
        if (StringUtils.equals(billDetail.getFlow(), Constant.FLOW_TRANSFER) && StringUtils.isAnyEmpty(billDetail.getInaccount(), billDetail.getOutaccount())) {
            throw new ApiException(ResultCode.TRANSFER$1004);
        }
    }
}
