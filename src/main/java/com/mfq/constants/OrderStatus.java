package com.mfq.constants;

public enum OrderStatus {


	APPLY(0,"申请借款中", "有用户申请借款。"),
	PASS(1,"借款已批准", "您的借款已批准。"), // 订单确认后
	ORDER_OK(2,"订单完成", "您的订单已完成，敬请留意，欢迎下次使用。"), // 属于最终状态
	NOTPASS(-1,"借款未批准", "借款未批准。"); // 属于最终状态

	int value;
	String name;
	String desc;
	
	OrderStatus(int value, String name, String desc){
        this.value = value;
        this.name = name;
        this.desc = desc;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static OrderStatus fromValue(int value){
		for(OrderStatus status : OrderStatus.values()){
			if(status.value == value){
				return status;
			}
		}
		return null;
	}
}
