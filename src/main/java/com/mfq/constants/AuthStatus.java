package com.mfq.constants;

public enum AuthStatus {

    INIT(0,"初始化状态"),
    BASE(1,"已填写基本信息"),
    USERTYPEDETAIL(2,"已填写用户身份详细信息"),
    USERPRIVATE(3,"已填写征信信息");

    
    int id;
    String desc;
    
    AuthStatus(int id, String desc){
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
	
    public static AuthStatus fromId(int id){
        for(AuthStatus status : AuthStatus.values()){
            if(status.getId() == id){
                return status;
            }
        }
        return null;
    }
    
}
