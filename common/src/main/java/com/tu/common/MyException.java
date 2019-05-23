package com.tu.common;

/**
 * @Description
 * @Classname MyException
 * @Date 2019/5/23 14:01
 * @Created by tuyongjian
 */
public class MyException extends RuntimeException {

    private String code;

    private String msg;

    public MyException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}