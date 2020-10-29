package com.oldduck.home.rich.exception;

import com.oldduck.home.rich.common.ResultCode;

/**
 * @author ：ex-caihh
 * @description：
 * @date ：Created in 2020/10/29 09:59
 */
public class ApiException extends RuntimeException {

    private String errorCode;
    private String errorMsg;

    public ApiException(String errorCode, String errorMsg) {
        super(errorCode + ":" + errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public ApiException(ResultCode resultCode, Throwable cause) {
        super(cause);
        this.errorCode = resultCode.getErrCode();
        this.errorMsg = resultCode.getErrMsg();
    }

    public ApiException(ResultCode resultCode) {
        super(resultCode.getErrCode() + ":" + resultCode.getErrMsg());
        this.errorCode = resultCode.getErrCode();
        this.errorMsg = resultCode.getErrCode();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
