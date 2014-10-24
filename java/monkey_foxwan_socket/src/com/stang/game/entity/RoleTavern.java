package com.stang.game.entity;

public class RoleTavern implements Cloneable{
	@Override
	public Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	
	private int id;
	private int roleId;
	private int id1;
	private int id2;
	private int id3;

	private int id4;
	private int id5;
	private int id6;
	private int flag;
	private long time;
	private int chuji;
	private int jifen;

	public int getJifen() {
		return jifen;
	}

	public void setJifen(int jifen) {
		this.jifen = jifen;
	}

	public int getChuji() {
		return chuji;
	}

	public void setChuji(int chuji) {
		this.chuji = chuji;
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

	public int getId1() {
		return id1;
	}

	public void setId1(int id1) {
		this.id1 = id1;
	}

	public int getId2() {
		return id2;
	}

	public void setId2(int id2) {
		this.id2 = id2;
	}

	public int getId3() {
		return id3;
	}

	public void setId3(int id3) {
		this.id3 = id3;
	}

	public int getId4() {
		return id4;
	}

	public void setId4(int id4) {
		this.id4 = id4;
	}

	public int getId5() {
		return id5;
	}

	public void setId5(int id5) {
		this.id5 = id5;
	}

	public int getId6() {
		return id6;
	}

	public void setId6(int id6) {
		this.id6 = id6;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public int getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}
}
