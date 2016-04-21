package com.mfq.bean.web;

import java.math.BigDecimal;

/**
 * Created by liuzhiguo1 on 16/4/19.
 */
public class Bill2App {
    private String orderNo;
    private String billNo;
    private String name;
    private BigDecimal price;
    private Integer current;
    private Integer period;
    private Integer day;

    public Bill2App() {
        super();
    }

    @Override
    public String toString() {
        return "Bill2App{" +
                "orderNo='" + orderNo + '\'' +
                ", billNo='" + billNo + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", current=" + current +
                ", period=" + period +
                ", day=" + day +
                '}';
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }
}
