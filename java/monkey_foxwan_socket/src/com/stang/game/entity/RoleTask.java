package com.stang.game.entity;

public class RoleTask implements Cloneable{
	@Override
	public Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	
	private int id;
	private int roleId;
	private int taskid;
	private int taskoldid;
	private int tasktype;
	private int type;
	private int tasknum;
	private int ctime;
	private int flag;
	private int dailynum;
	private long time;// 领取礼包倒计时时，点击不执行
	private int day;// 每天零点更新
	private int status;// 礼包是否领取
	private int states;

	public int getStates() {
		return states;
	}

	public void setStates(int states) {
		this.states = states;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public int getDailynum() {
		return dailynum;
	}

	public void setDailynum(int dailynum) {
		this.dailynum = dailynum;
	}

	public int getTaskid() {
		return taskid;
	}

	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}

	public int getTaskoldid() {
		return taskoldid;
	}

	public void setTaskoldid(int taskoldid) {
		this.taskoldid = taskoldid;
	}

	public int getTasknum() {
		return tasknum;
	}

	public void setTasknum(int tasknum) {
		this.tasknum = tasknum;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	public int getTasktype() {
		return tasktype;
	}

	public void setTasktype(int tasktype) {
		this.tasktype = tasktype;
	}

	public int getCtime() {
		return ctime;
	}

	public void setCtime(int ctime) {
		this.ctime = ctime;
	}

	public int getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}

}
