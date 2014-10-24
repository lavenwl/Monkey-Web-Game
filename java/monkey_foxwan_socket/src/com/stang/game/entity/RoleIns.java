package com.stang.game.entity;

public class RoleIns implements Cloneable{
	@Override
	public Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	
	private  int roleId;
	private long intensify;
	private long intensifytime;
	private long successtime;
	
	public long getSuccesstime() {
		return successtime;
	}
	public void setSuccesstime(long successtime) {
		this.successtime = successtime;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public long getIntensify() {
		return intensify;
	}
	public void setIntensify(long intensify) {
		this.intensify = intensify;
	}
	public long getIntensifytime() {
		return intensifytime;
	}
	public void setIntensifytime(long intensifytime) {
		this.intensifytime = intensifytime;
	}
	public int getIsUpdate() {
		return isUpdate;
	}
	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}
	
	

}
