package com.oldduck.home.rich.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oldduck.home.rich.common.BudgetType;
import com.oldduck.home.rich.dto.AccountInfoDto;
import com.oldduck.home.rich.manager.AccountManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ：ex-caihh
 * @description：account
 * @date ：Created in 2020/10/30 15:44
 */
@Controller
@RequestMapping("/info")
public class InfoController {

    Logger logger = LoggerFactory.getLogger(InfoController.class);

    @Autowired
    private AccountManager accountManager;

    @RequestMapping("/queryAccount")
    @ResponseBody
    public String accountInfo(@RequestBody String userId) {
        List<AccountInfoDto> accountInfos = accountManager.queryAccountInfo(userId);
        return new Gson().toJson(accountInfos);
    }

    @RequestMapping("/queryBudgetType")
    @ResponseBody
    public String budgetTypeInfo() {
        logger.info(new Gson().toJson(BudgetType.values()));
        return new Gson().toJson(BudgetType.values());
    }

}
