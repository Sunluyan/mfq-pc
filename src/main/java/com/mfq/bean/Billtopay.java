package com.mfq.bean;

public class Billtopay {
    private String payNo;

    private String billNos;

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo == null ? null : payNo.trim();
    }

    public String getBillNos() {
        return billNos;
    }

    public void setBillNos(String billNos) {
        this.billNos = billNos == null ? null : billNos.trim();
    }
}