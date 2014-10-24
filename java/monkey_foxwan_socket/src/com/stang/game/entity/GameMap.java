package com.stang.game.entity;

public class GameMap implements Cloneable{
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	
	private int id;
	private String name;
	private String desc;
	private String battery;
	private int flag;
	private int getgongxun;
	private int getexp;
	private int getyin;
	private int tower;
	private String dongwu;
	private String zuobiao;

	public int getTower() {
		return tower;
	}

	public String getDongwu() {
		return dongwu;
	}

	public void setDongwu(String dongwu) {
		this.dongwu = dongwu;
	}

	public String getZuobiao() {
		return zuobiao;
	}

	public void setZuobiao(String zuobiao) {
		this.zuobiao = zuobiao;
	}

	public void setTower(int tower) {
		this.tower = tower;
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

	public int getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}
}
