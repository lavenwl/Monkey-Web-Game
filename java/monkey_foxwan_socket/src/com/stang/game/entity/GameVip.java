package com.stang.game.entity;

public class GameVip implements Cloneable{
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	
	private int id;
	private int vipLevel;
	private int vipRmb;
	private int militaryTop;
	private int junlingTop;
	private int backTop;
	private int challengTop;
	private int qiangzhengTop;
	private int trainTop;
	private int dhjlTop;
	private int zjxxTop;
	private int djzmTop;
	private int zjxlTop;
	private int gjxxTop;
	private String vipsli;
	private int flag;
	private int yptop;
	private int zhuxianTop;
	private int hour;
    private int missionTop;
    private int zillionaireLuck;//大富翁
    
	public int getZillionaireLuck() {
		return zillionaireLuck;
	}

	public void setZillionaire(int zillionaireLuck) {
		this.zillionaireLuck = zillionaireLuck;
	}
	
	public int getMissionTop() {
		return missionTop;
	}

	public void setMissionTop(int missionTop) {
		this.missionTop = missionTop;
	}

	public int getZhuxianTop() {
		return zhuxianTop;
	}

	public void setZhuxianTop(int zhuxianTop) {
		this.zhuxianTop = zhuxianTop;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getYptop() {
		return yptop;
	}

	public void setYptop(int yptop) {
		this.yptop = yptop;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVipLevel() {
		return vipLevel;
	}

	public void setVipLevel(int vipLevel) {
		this.vipLevel = vipLevel;
	}

	public int getVipRmb() {
		return vipRmb;
	}

	public void setVipRmb(int vipRmb) {
		this.vipRmb = vipRmb;
	}

	public int getMilitaryTop() {
		return militaryTop;
	}

	public void setMilitaryTop(int militaryTop) {
		this.militaryTop = militaryTop;
	}

	public int getJunlingTop() {
		return junlingTop;
	}

	public void setJunlingTop(int junlingTop) {
		this.junlingTop = junlingTop;
	}

	public int getBackTop() {
		return backTop;
	}

	public void setBackTop(int backTop) {
		this.backTop = backTop;
	}

	public int getChallengTop() {
		return challengTop;
	}

	public void setChallengTop(int challengTop) {
		this.challengTop = challengTop;
	}

	public int getQiangzhengTop() {
		return qiangzhengTop;
	}

	public void setQiangzhengTop(int qiangzhengTop) {
		this.qiangzhengTop = qiangzhengTop;
	}

	public int getTrainTop() {
		return trainTop;
	}

	public void setTrainTop(int trainTop) {
		this.trainTop = trainTop;
	}

	public int getDhjlTop() {
		return dhjlTop;
	}

	public void setDhjlTop(int dhjlTop) {
		this.dhjlTop = dhjlTop;
	}

	public int getZjxxTop() {
		return zjxxTop;
	}

	public void setZjxxTop(int zjxxTop) {
		this.zjxxTop = zjxxTop;
	}

	public int getDjzmTop() {
		return djzmTop;
	}

	public void setDjzmTop(int djzmTop) {
		this.djzmTop = djzmTop;
	}

	public int getZjxlTop() {
		return zjxlTop;
	}

	public void setZjxlTop(int zjxlTop) {
		this.zjxlTop = zjxlTop;
	}

	public String getVipsli() {
		return vipsli;
	}

	public void setVipsli(String vipsli) {
		this.vipsli = vipsli;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getGjxxTop() {
		return gjxxTop;
	}

	public void setGjxxTop(int gjxxTop) {
		this.gjxxTop = gjxxTop;
	}

	public int getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}
}
