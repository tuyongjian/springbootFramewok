package com.tu.oauth.pojo;

/**
 * @Description
 * @Classname Response
 * @Date 2019/7/25 10:50
 * @Created by tuyongjian
 */
public class Response {

    private Object object;

    public Response(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}