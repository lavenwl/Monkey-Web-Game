package com.stang.game.entity.detail;

import com.stang.game.entity.GameChLevel;

public class GameChLevelDetail extends GameChLevel {
	private int id;
	private String name;
	private int level;
	private int gongxun;
	private String ta;
	private int type;
	private int flag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getGongxun() {
		return gongxun;
	}

	public void setGongxun(int gongxun) {
		this.gongxun = gongxun;
	}

	public String getTa() {
		return ta;
	}

	public void setTa(String ta) {
		this.ta = ta;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
}
