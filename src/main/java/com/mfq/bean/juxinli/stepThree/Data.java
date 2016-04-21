package com.mfq.bean.juxinli.stepThree;

import com.mfq.bean.juxinli.stepTwo.Datasource;

public class Data {
    private String type;

    private String content;

    private int process_code;

    private Req_msg_tpl req_msg_tpl;

    private boolean finish;

    private Datasource next_datasource;


    @Override
    public String toString() {
        return "Data{" +
                "type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", process_code=" + process_code +
                ", req_msg_tpl=" + req_msg_tpl +
                ", finish=" + finish +
                ", next_datasource=" + next_datasource +
                '}';
    }

    public boolean isFinish() {
        return finish;
    }

    public Datasource getNext_datasource() {
        return next_datasource;
    }

    public void setNext_datasource(Datasource next_datasource) {
        this.next_datasource = next_datasource;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void setProcess_code(int process_code) {
        this.process_code = process_code;
    }

    public int getProcess_code() {
        return this.process_code;
    }

    public void setReq_msg_tpl(Req_msg_tpl req_msg_tpl) {
        this.req_msg_tpl = req_msg_tpl;
    }

    public Req_msg_tpl getReq_msg_tpl() {
        return this.req_msg_tpl;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public boolean getFinish() {
        return this.finish;
    }

}