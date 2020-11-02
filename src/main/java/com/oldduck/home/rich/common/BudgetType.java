package com.oldduck.home.rich.common;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum BudgetType {

    /**
     * 收入
     */
    SALARY("A", "薪资", "I"),
    BONUS("B", "奖金", "I"),
    PARTTIME("C", "兼职", "I"),
    EARNINGS("D", "收益", "I"),
    /**
     * 支出
     */
    REPAST("1", "餐饮", "O"),
    THESTORE("2", "日用百货", "O"),
    TRAFFIC("3", "交通", "O"),
    ELECTRONICS("4", "电子产品", "O"),
    COSTUME("5", "服饰", "O"),
    MEDICAL("6", "医疗", "O"),
    GIFT("7", "礼物", "O"),
    CHARTER("8", "房租", "O"),
    ;


    private String code;
    private String explain;
    private String flow;

    public String getCode() {
        return code;
    }

    public String getExplain() {
        return explain;
    }

    public String getFlow() {
        return flow;
    }

    public static List allToMap() {
        List<Map<String, String>> list = new ArrayList<>();
        for (BudgetType budgetType : BudgetType.values()) {
            Map<String, String> map = new HashMap<>();
            map.put("code", budgetType.getCode());
            map.put("explain", budgetType.getExplain());
            map.put("flow", budgetType.getFlow());
            list.add(map);
        }
        return list;
    }

    BudgetType(String code, String explain, String flow) {
        this.code = code;
        this.explain = explain;
        this.flow = flow;
    }

    public String getExplainByCode(String code) {
        for (BudgetType type : BudgetType.values()) {
            if (StringUtils.equals(type.getCode(), code)) {
                return type.getExplain();
            }
        }
        return null;
    }

}
