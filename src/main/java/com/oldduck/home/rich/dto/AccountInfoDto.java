package com.oldduck.home.rich.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * ACCOUNT_INFO
 *
 * @author
 */
public class AccountInfoDto implements Serializable {
    private Integer serialno;

    private String userid;

    private String account;

    private BigDecimal balance;

    private String cardid;

    private String remark;

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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }
}