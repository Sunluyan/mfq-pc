package com.mfq.constants;

public enum WechatMessageType {

    TEXT(1,"文本消息","text"),
    VOICE(2,"音频消息","voice"),
    IMAGE(3,"图片消息","image"),
    ARTICLE(4,"图文消息","news");


    int id;
    String desc;
    String typeDesc;

    WechatMessageType(int id, String desc , String typeDesc){
        this.id = id;
        this.desc = desc;
        this.typeDesc = typeDesc;
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

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public static WechatMessageType fromId(int id){
        for(WechatMessageType status : WechatMessageType.values()){
            if(status.getId() == id){
                return status;
            }
        }
        return null;
    }
    
}
