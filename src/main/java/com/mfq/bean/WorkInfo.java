package com.mfq.bean;

import java.util.Date;

public class WorkInfo {
    private Long id;

    private Long uid;

    private String idFront;

    private String idBack;

    private String visitingCard;

    private String idWithHand;

    private String company;

    private String academicBackground;

    private String email;

    private String familyName;

    private String familyMobile;

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

    public String getIdFront() {
        return idFront;
    }

    public void setIdFront(String idFront) {
        this.idFront = idFront == null ? null : idFront.trim();
    }

    public String getIdBack() {
        return idBack;
    }

    public void setIdBack(String idBack) {
        this.idBack = idBack == null ? null : idBack.trim();
    }

    public String getVisitingCard() {
        return visitingCard;
    }

    public void setVisitingCard(String visitingCard) {
        this.visitingCard = visitingCard == null ? null : visitingCard.trim();
    }

    public String getIdWithHand() {
        return idWithHand;
    }

    public void setIdWithHand(String idWithHand) {
        this.idWithHand = idWithHand == null ? null : idWithHand.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getAcademicBackground() {
        return academicBackground;
    }

    public void setAcademicBackground(String academicBackground) {
        this.academicBackground = academicBackground == null ? null : academicBackground.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName == null ? null : familyName.trim();
    }

    public String getFamilyMobile() {
        return familyMobile;
    }

    public void setFamilyMobile(String familyMobile) {
        this.familyMobile = familyMobile == null ? null : familyMobile.trim();
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