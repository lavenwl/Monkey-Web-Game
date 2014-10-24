package com.stang.game.ffd.entity.detail;

public class EntityCheckFbDetail {
	private int fbnum;//进入fb 的人数
	private int fbwin;//fb成功的人数
	private int fblost;//fb失败的人数
	private String datetime;//fb采集时间
	public int getFbnum() {
		return fbnum;
	}
	public void setFbnum(int fbnum) {
		this.fbnum = fbnum;
	}
	public int getFbwin() {
		return fbwin;
	}
	public void setFbwin(int fbwin) {
		this.fbwin = fbwin;
	}
	public int getFblost() {
		return fblost;
	}
	public void setFblost(int fblost) {
		this.fblost = fblost;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String _datetime) {
		this.datetime = _datetime;
	}
}
