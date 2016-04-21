package com.mfq.bean.juxinli.stepTwo;

public class Root {
    private boolean success;

    private Data data;

    @Override
    public String toString() {
        return "Root{" +
                "success=" + success +
                ", data=" + data +
                '}';
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean getSuccess() {
        return this.success;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Data getData() {
        return this.data;
    }

}