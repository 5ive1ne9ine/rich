package com.oldduck.home.rich.common;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum BudgetType {

    /**
     * ����
     */
    SALARY("A", "н��", "I"),
    BONUS("B", "����", "I"),
    PARTTIME("C", "��ְ", "I"),
    EARNINGS("D", "����", "I"),
    /**
     * ֧��
     */
    REPAST("1", "����", "O"),
    THESTORE("2", "���ðٻ�", "O"),
    TRAFFIC("3", "��ͨ", "O"),
    ELECTRONICS("4", "���Ӳ�Ʒ", "O"),
    COSTUME("5", "����", "O"),
    MEDICAL("6", "ҽ��", "O"),
    GIFT("7", "����", "O"),
    CHARTER("8", "����", "O"),
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
