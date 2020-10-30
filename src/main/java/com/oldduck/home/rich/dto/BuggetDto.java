package com.oldduck.home.rich.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * BUGGET
 * @author 
 */
public class BuggetDto implements Serializable {
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
}