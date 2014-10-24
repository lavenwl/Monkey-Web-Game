package com.stang.game.entity;

public class GameStar implements Cloneable{
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	
private int id;
private int starlevel;
private int levelexp;
private int statusadd;
private int flag;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
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
public int getStatusadd() {
	return statusadd;
}
public void setStatusadd(int statusadd) {
	this.statusadd = statusadd;
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
}
