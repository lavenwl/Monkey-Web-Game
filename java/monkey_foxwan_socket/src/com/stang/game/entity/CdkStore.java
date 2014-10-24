package com.stang.game.entity;

public class CdkStore implements Cloneable{
	public Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	public int getIsUpdate() {
		return isUpdate;
	}
	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}
	private int id;
	private String cdk;
	private String level;
	private String employ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCdk() {
		return cdk;
	}
	public void setCdk(String cdk) {
		this.cdk = cdk;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getEmploy() {
		return employ;
	}
	public void setEmploy(String employ) {
		this.employ = employ;
	}
	
}
