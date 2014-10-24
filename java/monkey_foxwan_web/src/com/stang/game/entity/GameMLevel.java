package com.stang.game.entity;

import java.util.Date;

public class GameMLevel {
	private int id;
	private int level;
	private int exp;
	private int allexp;
	private int xyin;
	private int flag;
	private Date time;
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

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

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getXyin() {
		return xyin;
	}

	public void setXyin(int xyin) {
		this.xyin = xyin;
	}

	public int getAllexp() {
		return allexp;
	}

	public void setAllexp(int allexp) {
		this.allexp = allexp;
	}
}
