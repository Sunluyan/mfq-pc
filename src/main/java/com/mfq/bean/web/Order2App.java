package com.mfq.bean.web;

import com.mfq.constants.Order2AppStatus;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by liuzhiguo1 on 16/4/19.
 */
public class Order2App {
    public String orderNo;
    public String name;
    public BigDecimal price;
    public Integer period;
    public Integer currentPeriod;
    public String dueAt;
    public String createdAt;
    public Order2AppStatus Status;


    public Order2App() {
        super();
    }

    @Override
    public String toString() {
        return "Order2App{" +
                "orderNo='" + orderNo + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", period=" + period +
                ", currentPeriod=" + currentPeriod +
                ", dueAt=" + dueAt +
                ", createdAt=" + createdAt +
                ", Status=" + Status +
                '}';
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getCurrentPeriod() {
        return currentPeriod;
    }

    public void setCurrentPeriod(Integer currentPeriod) {
        this.currentPeriod = currentPeriod;
    }


    public String getDueAt() {
        return dueAt;
    }

    public void setDueAt(String dueAt) {
        this.dueAt = dueAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Order2AppStatus getStatus() {
        return Status;
    }

    public void setStatus(Order2AppStatus status) {
        Status = status;
    }
}
