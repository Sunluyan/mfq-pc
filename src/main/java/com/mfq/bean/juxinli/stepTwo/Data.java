package com.mfq.bean.juxinli.stepTwo;

public class Data {
    private String token;

    private String cell_phone_num;

    private Datasource datasource;

    @Override
    public String toString() {
        return "Data{" +
                "token='" + token + '\'' +
                ", cell_phone_num='" + cell_phone_num + '\'' +
                ", datasource=" + datasource +
                '}';
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }

    public void setCell_phone_num(String cell_phone_num) {
        this.cell_phone_num = cell_phone_num;
    }

    public String getCell_phone_num() {
        return this.cell_phone_num;
    }

    public void setDatasource(Datasource datasource) {
        this.datasource = datasource;
    }

    public Datasource getDatasource() {
        return this.datasource;
    }

}