package com.stang.game.entity;

public class RoleEquip implements Cloneable{
	@Override
	public Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	
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
	private int starlevel;
	private int levelexp;

	public int getStarlevel() {
		return starlevel;
	}

	public void setStarlevel(int starlevel) {
		this.starlevel = starlevel;
	}

	public int getLevelexp() {
		return levelexp;
	}

	public void setLevelexp(int levelexp) {
		this.levelexp = levelexp;
	}


	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	

	

	
	

	public double getAttack() {
		return attack;
	}

	public double getSpeed() {
		return speed;
	}

	public double getRectlength() {
		return rectlength;
	}

	public double getHpMax() {
		return hpMax;
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

	public int getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}

	public void setAttack(double attack) {
		this.attack = attack;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public void setRectlength(double rectlength) {
		this.rectlength = rectlength;
	}

	public void setHpMax(double hpMax) {
		this.hpMax = hpMax;
	}

}
