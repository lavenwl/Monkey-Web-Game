package com.stang.game.entity;

public class Dantiao implements Cloneable{
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	
	private int id;
	private int roleId;
	private int zgongji;
	private int zxueliang;
private String rmname;
private String grname;
	public String getRmname() {
	return rmname;
}
public void setRmname(String rmname) {
	this.rmname = rmname;
}
public String getGrname() {
	return grname;
}
public void setGrname(String grname) {
	this.grname = grname;
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

	public int getZgongji() {
		return zgongji;
	}
	public void setZgongji(int zgongji) {
		this.zgongji = zgongji;
	}
	public int getZxueliang() {
		return zxueliang;
	}
	public void setZxueliang(int zxueliang) {
		this.zxueliang = zxueliang;
	}
	public int getIsUpdate() {
		return isUpdate;
	}
	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}
	

}
