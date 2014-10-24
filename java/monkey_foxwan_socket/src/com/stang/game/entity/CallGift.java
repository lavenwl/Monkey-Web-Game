package com.stang.game.entity;

public class CallGift implements Cloneable{
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	
private int id;
private int itemid;
private int type;
private int stype;
private int num;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getItemid() {
	return itemid;
}
public void setItemid(int itemid) {
	this.itemid = itemid;
}
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}
public int getStype() {
	return stype;
}
public void setStype(int stype) {
	this.stype = stype;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
public int getIsUpdate() {
	return isUpdate;
}
public void setIsUpdate(int isUpdate) {
	this.isUpdate = isUpdate;
}
}
