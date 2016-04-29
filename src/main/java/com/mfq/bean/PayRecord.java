package com.mfq.bean;

import java.math.BigDecimal;
import java.util.Date;

public class PayRecord {
    private Long id;

    private Integer orderType;

    private String payNo;

    private String orderNo;

    private BigDecimal amount;

    private Long uid;

    private String tpp;

    private Integer status;

    private Date createdAt;

    private Date updatedAt;

    private Date payAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo == null ? null : payNo.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getTpp() {
        return tpp;
    }

    public void setTpp(String tpp) {
        this.tpp = tpp == null ? null : tpp.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getPayAt() {
        return payAt;
    }

    public void setPayAt(Date payAt) {
        this.payAt = payAt;
    }
}