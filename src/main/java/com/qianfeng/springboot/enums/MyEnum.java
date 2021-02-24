package com.qianfeng.springboot.enums;

public enum MyEnum {
    OK(200,"ok"),
    ADD_ERROR(201,"添加失败"),
    DELETE_ERROR(202,"删除失败"),
    UPDATE_ERROR(203,"修改失败"),
    SELECT_ERROR(204,"查找失败"),
    AUTHENTICATION_ERROR(205,"认证失败"),
    AUTHORIZATION_ERROR(206,"授权失败"),
    OTHER_ERROR(207,"其他异常"),
    LOGIN_ERROR(208,"登录失败")
    ;

    private Integer code;
    private String message;

    MyEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
