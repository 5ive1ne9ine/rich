package com.oldduck.home.rich.common;

public enum ResultCode {

    FLOW_ISEMPTY$1001("1001", "ת��ת�����Ͳ���Ϊ��"),
    INACCOUNT_ISEMPTY$1002("1002", "�����˻�����Ϊ��"),
    OUTACCOUNT_ISEMPTY$1003("1003", "֧���˻�����Ϊ��"),
    TRANSFER$1004("1004", "ת��ת���˻�����Ϊ��"),

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
