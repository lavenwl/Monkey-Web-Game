package com.stang.game.entity;

public class Roletotem implements Cloneable{
	@Override
	public Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	
	private int id;
	private int roleid;
	private int type;
	private int level;
	private int flag;
	private int num;
	private int quality;
	private int totemid;
	public int getEquiptotem() {
		return equiptotem;
	}
	public void setEquiptotem(int equiptotem) {
		this.equiptotem = equiptotem;
	}
	private int equiptotem;
	public int getTotemid() {
		return totemid;
	}
	public void setTotemid(int totemid) {
		this.totemid = totemid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
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
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
	public int getIsUpdate() {
		return isUpdate;
	}
	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}
	
	
	
}
