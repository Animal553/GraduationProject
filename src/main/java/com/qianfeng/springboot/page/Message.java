package com.qianfeng.springboot.page;


import com.qianfeng.springboot.enums.MyEnum;

public class Message {
    private Integer code;
    private String message;

    public Message() {
    }

    public Message(MyEnum myEnum) {
        this.code = myEnum.getCode();
        this.message = myEnum.getMessage();
    }
    public Message(Integer code, String message) {
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

    @Override
    public String toString() {
        return "Message{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}