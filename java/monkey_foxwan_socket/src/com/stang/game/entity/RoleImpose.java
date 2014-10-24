package com.stang.game.entity;

public class RoleImpose implements Cloneable{
	@Override
	public Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	
	private int roleid;
	private int imposenum;
	private long imposetime;
	private int imposenums;
	private long imposetimes;
	private int impose;
	private int flag;
	private int isnew;
	private int day;

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public int getImposenum() {
		return imposenum;
	}

	public void setImposenum(int imposenum) {
		this.imposenum = imposenum;
	}

	public long getImposetime() {
		return imposetime;
	}

	public void setImposetime(long imposetime) {
		this.imposetime = imposetime;
	}

	public int getImposenums() {
		return imposenums;
	}

	public void setImposenums(int imposenums) {
		this.imposenums = imposenums;
	}

	public long getImposetimes() {
		return imposetimes;
	}

	public void setImposetimes(long imposetimes) {
		this.imposetimes = imposetimes;
	}

	public int getImpose() {
		return impose;
	}

	public void setImpose(int impose) {
		this.impose = impose;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getIsnew() {
		return isnew;
	}

	public void setIsnew(int isnew) {
		this.isnew = isnew;
	}

	public int getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}

}
