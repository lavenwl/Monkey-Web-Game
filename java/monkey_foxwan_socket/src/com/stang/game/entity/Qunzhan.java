package com.stang.game.entity;

public class Qunzhan implements Cloneable{
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	
	private String name;
	private int jjs;
	private int hjs;
	private double sum;
	private int roleId;
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getJjs() {
		return jjs;
	}
	public void setJjs(int jjs) {
		this.jjs = jjs;
	}
	public int getHjs() {
		return hjs;
	}
	public void setHjs(int hjs) {
		this.hjs = hjs;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public int getIsUpdate() {
		return isUpdate;
	}
	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}


}
