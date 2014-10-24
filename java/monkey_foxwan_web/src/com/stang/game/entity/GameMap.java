package com.stang.game.entity;

import java.util.Date;

public class GameMap {
	private int id;
	private String name;
	private String desc;
	private String battery;
	private int flag;
	private int getgongxun;
	private int getexp;
	private int getyin;
private Date time;
	public Date getTime() {
	return time;
}

public void setTime(Date time) {
	this.time = time;
}

	public int getGetgongxun() {
		return getgongxun;
	}

	public void setGetgongxun(int getgongxun) {
		this.getgongxun = getgongxun;
	}

	public int getGetexp() {
		return getexp;
	}

	public void setGetexp(int getexp) {
		this.getexp = getexp;
	}

	public int getGetyin() {
		return getyin;
	}

	public void setGetyin(int getyin) {
		this.getyin = getyin;
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
}
