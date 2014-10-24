package com.stang.game.entity;

public class RoleEquip {
	private int id;
	private int roleId;
	private int equipId;
	private int dengji;
	private int type;
	
	private int equiptype;
	private int flag;
	private String user;
	private double attack;
	private double speed;
	private double rectlength;
	private double hpMax;
	

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public double getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public double getRectlength() {
		return rectlength;
	}

	public void setRectlength(int rectlength) {
		this.rectlength = rectlength;
	}

	public double getHpMax() {
		return hpMax;
	}

	public void setHpMax(int hpMax) {
		this.hpMax = hpMax;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getEquipId() {
		return equipId;
	}

	public void setEquipId(int equipId) {
		this.equipId = equipId;
	}

	public int getDengji() {
		return dengji;
	}

	public void setDengji(int dengji) {
		this.dengji = dengji;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getEquiptype() {
		return equiptype;
	}

	public void setEquiptype(int equiptype) {
		this.equiptype = equiptype;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

}
