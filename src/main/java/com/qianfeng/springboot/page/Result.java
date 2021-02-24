package com.qianfeng.springboot.page;

public class Result {
    private Message message;
    private Object data;

    public Result() {
    }

    public Result(Message message, Object data) {
        this.message = message;
        this.data = data;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "message=" + message +
                ", data=" + data +
                '}';
    }
}
