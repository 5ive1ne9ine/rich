package com.oldduck.home.rich.manager.impl;

import com.oldduck.home.rich.common.Constant;
import com.oldduck.home.rich.common.ResultCode;
import com.oldduck.home.rich.dto.BillDetailDto;
import com.oldduck.home.rich.exception.ApiException;
import com.oldduck.home.rich.manager.BillManager;
import com.oldduck.home.rich.mapper.BillDetailMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author £ºex-caihh
 * @description£º
 * @date £ºCreated in 2020/10/27 13:54
 */
@Component(value = "billManager")
public class BillManagerImpl implements BillManager {

    private Logger logger = LoggerFactory.getLogger(BillManagerImpl.class);

    @Autowired
    private BillDetailMapper billDetailMapper;

    @Override
    public void addBill(BillDetailDto billDetailDto) {
        IOVerify(billDetailDto);
        billDetailMapper.insert(billDetailDto);
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
