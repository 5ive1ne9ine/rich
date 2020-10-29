package com.oldduck.home.rich.common;

public enum ResultCode {

    FLOW_ISEMPTY$1001("1001", "转入转出类型不能为空"),
    INACCOUNT_ISEMPTY$1002("1002", "收入账户不能为空"),
    OUTACCOUNT_ISEMPTY$1003("1003", "支出账户不能为空"),
    TRANSFER$1004("1004", "转入转出账户不能为空"),

    ;

    private String errCode;
    private String errMsg;

    public String getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    ResultCode(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
}
