package com.stang.game.entity;

import java.util.Date;

public class GameTask {
	private int id;
	private int oldid;
	private String taskname;
	private String taskgoal;
	private String taskdesc;
	private int exp;
	private int type;
	private int tasktype;
	private int tasklevel;
	private String tasksx;
	private int tasknum;
	private Date time;
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	private int taskcoin;
	private int cointype;
	private String taskres;
	private String taskres2;
	
	private int flag;
	private int gongxun;
	private int junling;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOldid() {
		return oldid;
	}
	public void setOldid(int oldid) {
		this.oldid = oldid;
	}
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	public String getTaskdesc() {
		return taskdesc;
	}
	public void setTaskdesc(String taskdesc) {
		this.taskdesc = taskdesc;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getTasktype() {
		return tasktype;
	}
	public void setTasktype(int tasktype) {
		this.tasktype = tasktype;
	}
	public int getTasklevel() {
		return tasklevel;
	}
	public void setTasklevel(int tasklevel) {
		this.tasklevel = tasklevel;
	}
	public String getTasksx() {
		return tasksx;
	}
	public void setTasksx(String tasksx) {
		this.tasksx = tasksx;
	}
	public int getTasknum() {
		return tasknum;
	}
	public void setTasknum(int tasknum) {
		this.tasknum = tasknum;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getTaskcoin() {
		return taskcoin;
	}
	public void setTaskcoin(int taskcoin) {
		this.taskcoin = taskcoin;
	}
	public int getCointype() {
		return cointype;
	}
	public void setCointype(int cointype) {
		this.cointype = cointype;
	}
	public String getTaskres() {
		return taskres;
	}
	public void setTaskres(String taskres) {
		this.taskres = taskres;
	}
	public String getTaskres2() {
		return taskres2;
	}
	public void setTaskres2(String taskres2) {
		this.taskres2 = taskres2;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getTaskgoal() {
		return taskgoal;
	}
	public void setTaskgoal(String taskgoal) {
		this.taskgoal = taskgoal;
	}
	public int getGongxun() {
		return gongxun;
	}
	public void setGongxun(int gongxun) {
		this.gongxun = gongxun;
	}
	public int getJunling() {
		return junling;
	}
	public void setJunling(int junling) {
		this.junling = junling;
	}


}
