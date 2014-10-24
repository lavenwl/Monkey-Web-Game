package com.stang.game.entity;

import java.util.Date;

public class GamePlats {
	private int id;
	private int mid;
	private String res;
	private int resodds;
	private int flag;
private Date time;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getRes() {
		return res;
	}

	public void setRes(String res) {
		this.res = res;
	}

	public int getResodds() {
		return resodds;
	}

	public void setResodds(int resodds) {
		this.resodds = resodds;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
}
