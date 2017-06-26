package com.spring.simple.model;

/**
 * Created by feng.xu on 2017/5/8.
 */
public class ApiResult<T> {

    private boolean ret;
    private String errmsg;
    private int errcode;

    private T data;

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public void setErrEnum(ErrorCodeEnum errorCodeEnum) {
        this.errcode = errorCodeEnum.getCode();this.errmsg=errorCodeEnum.getMessage();
    }

    @Override
    public String toString() {
        return "ApiResult{" +
                "ret=" + ret +
                ", errmsg='" + errmsg + '\'' +
                ", errcode=" + errcode +
                ", data=" + data +
                '}';
    }

    public ApiResult success(){
        this.ret=true;
        return this;
    }

    public ApiResult success(T data){
        this.ret=true;
        this.data=data;
        return this;
    }

    public ApiResult success(String msg, T data){
        this.ret=true;
        this.errmsg = msg;
        this.data=data;
        return this;
    }

    public ApiResult fail(int errorCode,String errorMessage){
        this.errcode=errorCode;
        this.ret=false;
        this.errmsg=errorMessage;
        return this;
    }

    public ApiResult fail(ErrorCodeEnum errorCodeEnum,String errorMessage){
        this.errcode=errorCodeEnum.getCode();
        this.ret=false;
        this.errmsg=errorMessage;
        return this;
    }

    public ApiResult fail(ErrorCodeEnum errorCodeEnum){
        this.ret=false;
        this.errcode = errorCodeEnum.getCode();this.errmsg=errorCodeEnum.getMessage();
        return this;
    }
}
