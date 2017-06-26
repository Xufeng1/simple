package com.spring.simple.model;

public enum ErrorCodeEnum {
    INTERNAL_ERROR(500,"系统错误，请联系管理员"),
    PARAM_ERROR(400, "参数错误");

    private int code;
    private String message;

    ErrorCodeEnum(int code, String desc) {
        this.code = code;
        this.message = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ErrorCodeEnum valueOf(int code){
        for(ErrorCodeEnum e:ErrorCodeEnum.values()){
            if(e.getCode()==code){
                return e;
            }
        }
        return null;
    }
}
