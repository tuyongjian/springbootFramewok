package com.tu.common;

/**
 * Created by tuyongjian on 2019/4/29.
 *  result 公共的结果类
 *
 */
public class Result {

    private String state;

    private String message;

    private Object data;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
