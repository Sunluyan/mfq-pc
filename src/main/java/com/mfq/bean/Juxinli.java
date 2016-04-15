package com.mfq.bean;

import java.util.Date;

public class Juxinli {
    private Long id;

    private Long uid;

    private String taobao;

    private String jd;

    private String taobaoPassword;

    private String jdPassword;

    private String mobile;

    private String mobilePassword;

    private Date createdAt;

    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getTaobao() {
        return taobao;
    }

    public void setTaobao(String taobao) {
        this.taobao = taobao == null ? null : taobao.trim();
    }

    public String getJd() {
        return jd;
    }

    public void setJd(String jd) {
        this.jd = jd == null ? null : jd.trim();
    }

    public String getTaobaoPassword() {
        return taobaoPassword;
    }

    public void setTaobaoPassword(String taobaoPassword) {
        this.taobaoPassword = taobaoPassword == null ? null : taobaoPassword.trim();
    }

    public String getJdPassword() {
        return jdPassword;
    }

    public void setJdPassword(String jdPassword) {
        this.jdPassword = jdPassword == null ? null : jdPassword.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getMobilePassword() {
        return mobilePassword;
    }

    public void setMobilePassword(String mobilePassword) {
        this.mobilePassword = mobilePassword == null ? null : mobilePassword.trim();
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
}