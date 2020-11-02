package com.oldduck.home.rich.manager.impl;

import com.oldduck.home.rich.dto.AccountInfoDto;
import com.oldduck.home.rich.manager.AccountManager;
import com.oldduck.home.rich.mapper.AccountInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author £ºex-caihh
 * @description£ºaccount
 * @date £ºCreated in 2020/10/30 15:47
 */
@Component("accountManager")
public class AccountManagerImpl implements AccountManager {

    private Logger logger = LoggerFactory.getLogger(AccountManagerImpl.class);
    
    @Autowired
    private AccountInfoMapper accountInfoMapper;

    @Override
    public List<AccountInfoDto> queryAccountInfo(String userId) {
        logger.info("queryAccountInfo start, userId:{}", userId);
        return accountInfoMapper.selectByUserid(userId);
    }
}
