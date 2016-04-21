package com.mfq.bean.juxinli.stepTwo;

public class Datasource {
    private String id;

    private String website;

    private String name;

    private String category;

    private String category_name;

    private Create_time create_time;

    private Update_time update_time;

    private int offline_times;

    private int status;

    private int website_code;

    private int reset_pwd_method;

    private int sms_required;

    private int required_captcha_user_identified;


    @Override
    public String toString() {
        return "Datasource{" +
                "id='" + id + '\'' +
                ", website='" + website + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", category_name='" + category_name + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", offline_times=" + offline_times +
                ", status=" + status +
                ", website_code=" + website_code +
                ", reset_pwd_method=" + reset_pwd_method +
                ", sms_required=" + sms_required +
                ", required_captcha_user_identified=" + required_captcha_user_identified +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getWebsite() {
        return this.website;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_name() {
        return this.category_name;
    }

    public void setCreate_time(Create_time create_time) {
        this.create_time = create_time;
    }

    public Create_time getCreate_time() {
        return this.create_time;
    }

    public void setUpdate_time(Update_time update_time) {
        this.update_time = update_time;
    }

    public Update_time getUpdate_time() {
        return this.update_time;
    }

    public void setOffline_times(int offline_times) {
        this.offline_times = offline_times;
    }

    public int getOffline_times() {
        return this.offline_times;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return this.status;
    }

    public void setWebsite_code(int website_code) {
        this.website_code = website_code;
    }

    public int getWebsite_code() {
        return this.website_code;
    }

    public void setReset_pwd_method(int reset_pwd_method) {
        this.reset_pwd_method = reset_pwd_method;
    }

    public int getReset_pwd_method() {
        return this.reset_pwd_method;
    }

    public void setSms_required(int sms_required) {
        this.sms_required = sms_required;
    }

    public int getSms_required() {
        return this.sms_required;
    }

    public void setRequired_captcha_user_identified(int required_captcha_user_identified) {
        this.required_captcha_user_identified = required_captcha_user_identified;
    }

    public int getRequired_captcha_user_identified() {
        return this.required_captcha_user_identified;
    }

}