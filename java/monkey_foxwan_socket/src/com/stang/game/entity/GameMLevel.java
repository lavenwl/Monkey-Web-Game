package com.stang.game.entity;

public class GameMLevel implements Cloneable{
	@Override
	protected Object clone() throws CloneNotSupportedException {
	// 实现clone方法
	return super.clone();
}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	
	private int id;
	private int level;
	private int exp;
	private int allexp;
	private int xyin;
	private int flag;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getXyin() {
		return xyin;
	}

	public void setXyin(int xyin) {
		this.xyin = xyin;
	}

	public int getAllexp() {
		return allexp;
	}

	public void setAllexp(int allexp) {
		this.allexp = allexp;
	}

	public int getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}
}
