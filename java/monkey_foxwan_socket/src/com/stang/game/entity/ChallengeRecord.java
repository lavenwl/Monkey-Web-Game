package com.stang.game.entity;

public class ChallengeRecord implements Cloneable{
	@Override
	public Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	
	private int id;
	private int hitid;
	private int beihitid;
	private String time;
	private String record;
	private String mids;
	private String hitmids;
	private String hitname;
	private String totem;
	private String totemtwo;

	public String getTotemtwo() {
		return totemtwo;
	}
	public void setTotemtwo(String totemtwo) {
		this.totemtwo = totemtwo;
	}
	public String getTotem() {
		return totem;
	}
	public void setTotem(String totem) {
		this.totem = totem;
	}
	public String getHittoux() {
		return hittoux;
	}
	public void setHittoux(String hittoux) {
		this.hittoux = hittoux;
	}
	public String getBeihittoux() {
		return beihittoux;
	}
	public void setBeihittoux(String beihittoux) {
		this.beihittoux = beihittoux;
	}
	public int getHitlevel() {
		return hitlevel;
	}
	public void setHitlevel(int hitlevel) {
		this.hitlevel = hitlevel;
	}
	public int getBeihitlevel() {
		return beihitlevel;
	}
	public void setBeihitlevel(int beihitlevel) {
		this.beihitlevel = beihitlevel;
	}
	public int getHitrate() {
		return hitrate;
	}
	public void setHitrate(int hitrate) {
		this.hitrate = hitrate;
	}
	public int getBeihitrate() {
		return beihitrate;
	}
	public void setBeihitrate(int beihitrate) {
		this.beihitrate = beihitrate;
	}
	private String beihitname;
	private int winid;
	private String hittoux;
	private String beihittoux;
	private int hitlevel;
	private int beihitlevel;
	private int hitrate;
	private int beihitrate;
	public String getHitname() {
		return hitname;
	}
	public void setHitname(String hitname) {
		this.hitname = hitname;
	}
	public String getBeihitname() {
		return beihitname;
	}
	public void setBeihitname(String beihitname) {
		this.beihitname = beihitname;
	}
	public int getWinid() {
		return winid;
	}
	public void setWinid(int winid) {
		this.winid = winid;
	}
	public String getHitmids() {
		return hitmids;
	}
	public void setHitmids(String hitmids) {
		this.hitmids = hitmids;
	}
	public String getMids() {
		return mids;
	}
	public void setMids(String mids) {
		this.mids = mids;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHitid() {
		return hitid;
	}
	public void setHitid(int hitid) {
		this.hitid = hitid;
	}
	public int getBeihitid() {
		return beihitid;
	}
	public void setBeihitid(int beihitid) {
		this.beihitid = beihitid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	public int getIsUpdate() {
		return isUpdate;
	}
	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}

}
