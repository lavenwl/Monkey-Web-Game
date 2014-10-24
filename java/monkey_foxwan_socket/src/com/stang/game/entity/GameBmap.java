package com.stang.game.entity;

public class GameBmap implements Cloneable{
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	
	private int id;
	private String name;
	private int nandu;
	private String chubing;
	private int isagain;
	private int flag;
	private int startlv;
	private int startnum;
	private int dengji;
	private int getexp;
	private int getyin;
	private int getgongxun;
	private int mapid;
	
	public int getMapid() {
		return mapid;
	}
	public void setMapid(int mapid) {
		this.mapid = mapid;
	}
	public int getDengji() {
		return dengji;
	}
	public void setDengji(int dengji) {
		this.dengji = dengji;
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
	public int getGetgongxun() {
		return getgongxun;
	}
	public void setGetgongxun(int getgongxun) {
		this.getgongxun = getgongxun;
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

	public int getNandu() {
		return nandu;
	}
	public void setNandu(int nandu) {
		this.nandu = nandu;
	}
	public String getChubing() {
		return chubing;
	}
	public void setChubing(String chubing) {
		this.chubing = chubing;
	}
	public int getIsagain() {
		return isagain;
	}
	public void setIsagain(int isagain) {
		this.isagain = isagain;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getStartlv() {
		return startlv;
	}
	public void setStartlv(int startlv) {
		this.startlv = startlv;
	}
	public int getStartnum() {
		return startnum;
	}
	public void setStartnum(int startnum) {
		this.startnum = startnum;
	}
	public int getIsUpdate() {
		return isUpdate;
	}
	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}
}
