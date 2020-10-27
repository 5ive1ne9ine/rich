package com.oldduck.home.rich.manager.impl;

import com.oldduck.home.rich.dao.BillDetailDao;
import com.oldduck.home.rich.dto.BillDetailDto;
import com.oldduck.home.rich.manager.BillManager;
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
    private BillDetailDao billDetailDao;
    
    @Override
    public void addBill(BillDetailDto billDetailDto) {
        billDetailDao.insert(billDetailDto);
    }
}
