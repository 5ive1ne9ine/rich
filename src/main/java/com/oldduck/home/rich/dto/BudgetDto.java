package com.oldduck.home.rich.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Budget
 * @author 
 */
public class BudgetDto implements Serializable {
    /**
     * 序列号
     */
    private Integer serialno;

    /**
     * 用户
     */
    private String userid;

    /**
     * 预算
     */
    private BigDecimal budget;

    /**
     * 预算类型
     */
    private String budgettype;

    private static final long serialVersionUID = 1L;

    public Integer getSerialno() {
        return serialno;
    }

    public void setSerialno(Integer serialno) {
        this.serialno = serialno;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public String getBudgettype() {
        return budgettype;
    }

    public void setBudgettype(String budgettype) {
        this.budgettype = budgettype;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}