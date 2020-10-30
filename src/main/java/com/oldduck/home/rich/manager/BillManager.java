package com.oldduck.home.rich.manager;

import com.oldduck.home.rich.dto.BillDetailDto;

import java.util.Map;

public interface BillManager {
    void addBill(BillDetailDto billDetailDto);

    void deleteBill(String serialno);

    Map<String, Object> queryDetail(String userId);
}
