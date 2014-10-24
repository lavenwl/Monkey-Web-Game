package com.stang.game.entity;

import java.util.Date;

public class GameLevel {
	private int id;
	private int level;
	private int getcoin;
	private int getgongxun;
	private int getexp;
	private int needexp;
	private int flag;
public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

private Date time;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getGetcoin() {
		return getcoin;
	}

	public void setGetcoin(int getcoin) {
		this.getcoin = getcoin;
	}

	public int getGetgongxun() {
		return getgongxun;
	}

	public void setGetgongxun(int getgongxun) {
		this.getgongxun = getgongxun;
	}

	public int getGetexp() {
		return getexp;
	}

	public void setGetexp(int getexp) {
		this.getexp = getexp;
	}

	public int getNeedexp() {
		return needexp;
	}

	public void setNeedexp(int needexp) {
		this.needexp = needexp;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
}
