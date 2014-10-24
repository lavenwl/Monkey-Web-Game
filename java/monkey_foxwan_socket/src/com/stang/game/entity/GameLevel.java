package com.stang.game.entity;

public class GameLevel implements Cloneable{
	@Override
	public Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	
	private int id;
	private int level;
	private int getcoin;
	private int getgongxun;
	private int getexp;
	private int needexp;
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

	public int getGetcoin() {
		return getcoin;
	}

	public void setGetcoin(int getcoin) {
		this.getcoin = getcoin;
	}

	public int getGetgongxun() {
		return getgongxun;
	}

	public void setGetgongxun(int getgongxun) {
		this.getgongxun = getgongxun;
	}

	public int getGetexp() {
		return getexp;
	}

	public void setGetexp(int getexp) {
		this.getexp = getexp;
	}

	public int getNeedexp() {
		return needexp;
	}

	public void setNeedexp(int needexp) {
		this.needexp = needexp;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}
}
