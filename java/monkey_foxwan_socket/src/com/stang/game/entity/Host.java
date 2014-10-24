package com.stang.game.entity;

public class Host implements Cloneable{
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	
	private int id;
	private int status;
	private String message;
	private int itemid;
	private int odds;
	private int mid1;
	private int mid2;
	private String res1;
	private String res2;
	private String reses;
	private int flag;
	private int month;
	private int day;
	private int monthend;
	private int dayend;
	private String server;
	
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
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
	public int getIsUpdate() {
		return isUpdate;
	}
	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}
	
}
