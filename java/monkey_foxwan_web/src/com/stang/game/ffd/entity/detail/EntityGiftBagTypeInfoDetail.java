package com.stang.game.ffd.entity.detail;

public class EntityGiftBagTypeInfoDetail {
	private int ID;//类型id
	private String GTI_NAME;//礼包类型名
	private String CREATE_TIME;//创建时间
	private int FLAG;//是否使用
	public int getID() {
		return ID;
	}
	public void setID(int id) {
		ID = id;
	}
	public String getGTI_NAME() {
		return GTI_NAME;
	}
	public void setGTI_NAME(String gti_name) {
		GTI_NAME = gti_name;
	}
	public String getCREATE_TIME() {
		return CREATE_TIME;
	}
	public void setCREATE_TIME(String create_time) {
		CREATE_TIME = create_time;
	}
	public int getFLAG() {
		return FLAG;
	}
	public void setFLAG(int flag) {
		FLAG = flag;
	}
	
}
