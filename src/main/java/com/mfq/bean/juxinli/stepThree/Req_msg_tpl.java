package com.mfq.bean.juxinli.stepThree;

public class Req_msg_tpl {
    private String type;

    private String method;

    @Override
    public String toString() {
        return "Req_msg_tpl{" +
                "type='" + type + '\'' +
                ", method='" + method + '\'' +
                '}';
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return this.method;
    }

}