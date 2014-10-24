package com.stang.game.entity;

public class GameFoeskill implements Cloneable{
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	
	private int id;
	private String name;
	private String desc;
	private int type;
	private int summon;
	private int number;
	private int bufftype;
	private int fanwei;
	private double effect;

	

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

	public int getSummon() {
		return summon;
	}

	public void setSummon(int summon) {
		this.summon = summon;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getBufftype() {
		return bufftype;
	}

	public void setBufftype(int bufftype) {
		this.bufftype = bufftype;
	}

	public int getFanwei() {
		return fanwei;
	}

	public void setFanwei(int fanwei) {
		this.fanwei = fanwei;
	}

	public double getEffect() {
		return effect;
	}

	public void setEffect(double effect) {
		this.effect = effect;
	}

	public int getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}
}
