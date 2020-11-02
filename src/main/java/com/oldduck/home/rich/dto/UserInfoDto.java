package com.oldduck.home.rich.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * USER_INFO
 * @author 
 */
public class UserInfoDto implements Serializable {
    private Integer serialno;

    /**
     * 由系统生成
     */
    private String userid;

    /**
     * 用户注册
     */
    private String username;

    private String password;

    private String sex;

    private String phone;

    private String address;

    /**
     * 客户姓名
     */
    private String custname;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
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