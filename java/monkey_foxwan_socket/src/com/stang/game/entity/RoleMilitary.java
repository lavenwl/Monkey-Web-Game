package com.stang.game.entity;

public class RoleMilitary implements Cloneable{
	@Override
	public Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	
	private int id;
	private int roleId;
	private int militaryid;
	private String name;
	private int level;
	private int exp;
	private int type;
	private int types;
	private int flag;
	private int wuqi;
	private int huwan;
	private int yifu;
	private int xiezi;
	private int touguan;
	private int shipin;
	private long time;
	private int xltype;
	private int challenge;
	private String bingstatus;
	private int bing;
	private int fuben;


	public int getFuben() {
		return fuben;
	}

	public void setFuben(int fuben) {
		this.fuben = fuben;
	}

	public String getBingstatus() {
		return bingstatus;
	}

	public void setBingstatus(String bingstatus) {
		this.bingstatus = bingstatus;
	}

	public int getBing() {
		return bing;
	}

	public void setBing(int bing) {
		this.bing = bing;
	}

	public int getChallenge() {
		return challenge;
	}

	public void setChallenge(int challenge) {
		this.challenge = challenge;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getWuqi() {
		return wuqi;
	}

	public void setWuqi(int wuqi) {
		this.wuqi = wuqi;
	}

	public int getHuwan() {
		return huwan;
	}

	public void setHuwan(int huwan) {
		this.huwan = huwan;
	}

	public int getYifu() {
		return yifu;
	}

	public void setYifu(int yifu) {
		this.yifu = yifu;
	}

	public int getXiezi() {
		return xiezi;
	}

	public void setXiezi(int xiezi) {
		this.xiezi = xiezi;
	}

	public int getTouguan() {
		return touguan;
	}

	public void setTouguan(int touguan) {
		this.touguan = touguan;
	}

	public int getShipin() {
		return shipin;
	}

	public void setShipin(int shipin) {
		this.shipin = shipin;
	}

	public int getMilitaryid() {
		return militaryid;
	}

	public void setMilitaryid(int militaryid) {
		this.militaryid = militaryid;
	}

	public int getTypes() {
		return types;
	}

	public void setTypes(int types) {
		this.types = types;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}



	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public int getXltype() {
		return xltype;
	}

	public void setXltype(int xltype) {
		this.xltype = xltype;
	}

	public int getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}

}
