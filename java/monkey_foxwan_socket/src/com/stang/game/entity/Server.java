package com.stang.game.entity;

public class Server implements Cloneable{
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	
	private int id;
	private String name;
	private int statue_mag;
	private int statue_tui;
	private int statue_xin;
	private int statue_on;
	private int onlineNum;
	private String server_ip;
	public String getServer_ip() {
		return server_ip;
	}
	public void setServer_ip(String server_ip) {
		this.server_ip = server_ip;
	}
	public int getOnlineNum() {
		return onlineNum;
	}
	public void setOnlineNum(int onlineNum) {
		this.onlineNum = onlineNum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStatue_mag() {
		return statue_mag;
	}
	public void setStatue_mag(int statue_mag) {
		this.statue_mag = statue_mag;
	}
	public int getStatue_tui() {
		return statue_tui;
	}
	public void setStatue_tui(int statue_tui) {
		this.statue_tui = statue_tui;
	}
	public int getStatue_xin() {
		return statue_xin;
	}
	public void setStatue_xin(int statue_xin) {
		this.statue_xin = statue_xin;
	}
	public int getStatue_on() {
		return statue_on;
	}
	public void setStatue_on(int statue_on) {
		this.statue_on = statue_on;
	}
	public int getIsUpdate() {
		return isUpdate;
	}
	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}
}
