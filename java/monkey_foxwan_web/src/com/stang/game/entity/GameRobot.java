package com.stang.game.entity;

public class GameRobot {

	private int id;
	private String name;
	private int level;
	private int percent;
	private String militarys;
	private int flag;
	
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
	public int getPercent() {
		return percent;
	}
	public void setPercent(int percent) {
		this.percent = percent;
	}
	public String getMilitarys() {
		return militarys;
	}
	public void setMilitarys(String militarys) {
		this.militarys = militarys;
	}
}
