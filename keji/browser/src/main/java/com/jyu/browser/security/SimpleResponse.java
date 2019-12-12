package com.jyu.browser.security;

public class SimpleResponse {

    private Object msg;

    public SimpleResponse() {
    }

    public SimpleResponse(Object msg) {
        this.msg = msg;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }
}
