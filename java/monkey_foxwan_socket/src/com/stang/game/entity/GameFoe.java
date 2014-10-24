package com.stang.game.entity;

public class GameFoe implements Cloneable{
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	
	private int foeid;
	private String foename;
	private String foedesc;
	private int type;
	private int fangyu;
	private int xueliang;
	private double sudu;
	private int flag;
	private int skill;

	public int getSkill() {
		return skill;
	}

	public void setSkill(int skill) {
		this.skill = skill;
	}

	public int getFoeid() {
		return foeid;
	}

	public void setFoeid(int foeid) {
		this.foeid = foeid;
	}

	public String getFoename() {
		return foename;
	}

	public void setFoename(String foename) {
		this.foename = foename;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getFangyu() {
		return fangyu;
	}

	public void setFangyu(int fangyu) {
		this.fangyu = fangyu;
	}

	public int getXueliang() {
		return xueliang;
	}

	public void setXueliang(int xueliang) {
		this.xueliang = xueliang;
	}

	public double getSudu() {
		return sudu;
	}

	public void setSudu(double sudu) {
		this.sudu = sudu;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getFoedesc() {
		return foedesc;
	}

	public void setFoedesc(String foedesc) {
		this.foedesc = foedesc;
	}

	public int getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}
}
