package com.mfq.constants;

/**
 * 单一帐单状态
 * @author xingyongshan
 *
 */
public enum Order2AppStatus {

    PAYING(1, "还款中"),
    PAYOFF(-1, "已还清"),
    OVER_TIME(2, "已逾期");

    int id;
    String desc;

    Order2AppStatus(int id, String desc){
        this.id = id;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public static Order2AppStatus fromId(int id){
        for(Order2AppStatus status : Order2AppStatus.values()){
            if(status.getId() == id){
                return status;
            }
        }
        return null;
    }
}
