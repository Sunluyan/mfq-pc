package com.mfq.bean;

import java.util.Date;

public class Vcode {
    private Long id;

    private String vcode;

    private String emkey;

    private Date expireAt;

    private Date resendAt;

    private Integer retryTime;

    private Date createdAt;

    private Date updatedAt;

    private Integer seqId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode == null ? null : vcode.trim();
    }

    public String getEmkey() {
        return emkey;
    }

    public void setEmkey(String emkey) {
        this.emkey = emkey == null ? null : emkey.trim();
    }

    public Date getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(Date expireAt) {
        this.expireAt = expireAt;
    }

    public Date getResendAt() {
        return resendAt;
    }

    public void setResendAt(Date resendAt) {
        this.resendAt = resendAt;
    }

    public Integer getRetryTime() {
        return retryTime;
    }

    public void setRetryTime(Integer retryTime) {
        this.retryTime = retryTime;
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

    public Integer getSeqId() {
        return seqId;
    }

    public void setSeqId(Integer seqId) {
        this.seqId = seqId;
    }
}