package com.qianfeng.springboot.Exceptions;


import com.qianfeng.springboot.enums.MyEnum;

public class MyException extends RuntimeException{
    private Integer code;
    private String message;

    public MyException() {
    }

    public MyException(MyEnum myEnum) {
        this.code = myEnum.getCode();
        this.message = myEnum.getMessage();
    }

    public MyException(Integer code, String message) {
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
        return "MyException{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
