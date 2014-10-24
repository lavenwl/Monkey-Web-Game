package com.stang.game.entity;

public class HostStatus {
	private int id;
	private int status;
	private String message;
	private int itemid;
	private int odds;
	private int mid1;
	private int mid2;
	private int flag;
	private int month;
	private int day;
	private int monthend;
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getOdds() {
		return odds;
	}
	public void setOdds(int odds) {
		this.odds = odds;
	}
	public int getMid1() {
		return mid1;
	}
	public void setMid1(int mid1) {
		this.mid1 = mid1;
	}
	public int getMid2() {
		return mid2;
	}
	public void setMid2(int mid2) {
		this.mid2 = mid2;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonthend() {
		return monthend;
	}
	public void setMonthend(int monthend) {
		this.monthend = monthend;
	}
	public int getDayend() {
		return dayend;
	}
	public void setDayend(int dayend) {
		this.dayend = dayend;
	}
	public String getRes1() {
		return res1;
	}
	public void setRes1(String res1) {
		this.res1 = res1;
	}
	public String getRes2() {
		return res2;
	}
	public void setRes2(String res2) {
		this.res2 = res2;
	}
	public String getReses() {
		return reses;
	}
	public void setReses(String reses) {
		this.reses = reses;
	}
	private int dayend;
	private String res1;
	private String res2;
	private String reses;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
