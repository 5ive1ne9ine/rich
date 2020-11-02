package com.oldduck.home.rich.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class BillDetailDto implements Serializable {
    /**
     * ��ˮ��
     */
    private Integer serialno;

    /**
     * �˺�,ͬһ����Ψһ
     */
    private String userid;

    /**
     * ��ˮ���
     */
    private BigDecimal amount;

    /**
     * ����.156�����
     */
    private String moneytype = "156";

    /**
     * ��֧,I����O֧��
     */
    private String flow;

    /**
     * ��ˮ����
     */
    private String billtype;

    /**
     * ��ˮ����
     */
    private String billdate;

    /**
     * FLOWΪOʱ,��¼֧�����˺�
     */
    private String outaccount;

    /**
     * FLOWΪIʱ,��¼������˺�
     */
    private String inaccount;

    private Date inserttime;

    private Date updatetime;

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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getMoneytype() {
        return moneytype;
    }

    public void setMoneytype(String moneytype) {
        this.moneytype = moneytype;
    }

    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }

    public String getBilltype() {
        return billtype;
    }

    public void setBilltype(String billtype) {
        this.billtype = billtype;
    }

    public String getBilldate() {
        return billdate;
    }

    public void setBilldate(String billdate) {
        this.billdate = billdate;
    }

    public String getOutaccount() {
        return outaccount;
    }

    public void setOutaccount(String outaccount) {
        this.outaccount = outaccount;
    }

    public String getInaccount() {
        return inaccount;
    }

    public void setInaccount(String inaccount) {
        this.inaccount = inaccount;
    }

    public Date getInserttime() {
        return inserttime;
    }

    public void setInserttime(Date inserttime) {
        this.inserttime = inserttime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}