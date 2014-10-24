package com.stang.game.entity;

public class Activity {

	private int id;
	private String url;
	private int type;
	private String conditions;
	private String reward;
	private int flag;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getConditions() {
		return conditions;
	}
	public void setConditions(String conditions) {
		this.conditions = conditions;
	}
	public String getReward() {
		return reward;
	}
	public void setReward(String reward) {
		this.reward = reward;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTipurl() {
		return tipurl;
	}
	public void setTipurl(String tipurl) {
		this.tipurl = tipurl;
	}
	public int getIsnew() {
		return isnew;
	}
	public void setIsnew(int isnew) {
		this.isnew = isnew;
	}
	private int month;
	private int day;
	private int monthend;
	private int dayend;
	private String description;
	private String tipurl;
	private int isnew;
	
}
