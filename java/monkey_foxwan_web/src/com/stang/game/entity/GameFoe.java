package com.stang.game.entity;

import java.util.Date;

public class GameFoe {
	private int foeid;
	private String foename;
	private String foedesc;
	private int type;
	private int fangyu;
	private int xueliang;
	private double sudu;
	private int flag;
     private Date time;
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
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
}
