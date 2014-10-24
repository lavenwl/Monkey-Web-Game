package com.stang.game.entity;

public class RoleChallenge {

	private int id;
	private String militaryid;
	private int roleid;
	private int flag;
	private int success;
	private int totals;
	private int win;
	
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = success;
	}
	public int getTotals() {
		return totals;
	}
	public void setTotals(int totals) {
		this.totals = totals;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getMilitaryid() {
		return militaryid;
	}
	public void setMilitaryid(String militaryid) {
		this.militaryid = militaryid;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
}
