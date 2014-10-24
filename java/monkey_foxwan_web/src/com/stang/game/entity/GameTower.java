package com.stang.game.entity;

public class GameTower {
	private int id;
	private String name;
	private String desc;
	private String bombtype;
	private int shottype;
	private int type;
	private int level;
	private int gjextra;
	private int gsextra;
	private int fwextra;
	private int fanwei;
	private String description;
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getGjextra() {
		return gjextra;
	}

	public void setGjextra(int gjextra) {
		this.gjextra = gjextra;
	}

	public int getGsextra() {
		return gsextra;
	}

	public void setGsextra(int gsextra) {
		this.gsextra = gsextra;
	}

	public int getFwextra() {
		return fwextra;
	}

	public void setFwextra(int fwextra) {
		this.fwextra = fwextra;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getBombtype() {
		return bombtype;
	}

	public void setBombtype(String bombtype) {
		this.bombtype = bombtype;
	}

	public int getShottype() {
		return shottype;
	}

	public void setShottype(int shottype) {
		this.shottype = shottype;
	}

	public int getFanwei() {
		return fanwei;
	}

	public void setFanwei(int fanwei) {
		this.fanwei = fanwei;
	}
}
