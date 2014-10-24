package com.stang.game.entity;

public class RoleDaytask implements Cloneable{
	@Override
	public Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	
	private int id;
	private int roleid; 
	private int qianghua;
	private int lueduo;
	private int qiangduo;
	private int zhaomu;
	private int xiulian;
	private int zhangdou;
	private String baoxiang;
	private String integralstatue;
	private String box;
	private  int day;
	private int middlerecruit;
	private int toprecruit;
	
	
	
	public int getMiddlerecruit() {
		return middlerecruit;
	}
	public void setMiddlerecruit(int middlerecruit) {
		this.middlerecruit = middlerecruit;
	}
	public int getToprecruit() {
		return toprecruit;
	}
	public void setToprecruit(int toprecruit) {
		this.toprecruit = toprecruit;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getBox() {
		return box;
	}
	public void setBox(String box) {
		this.box = box;
	}
	public int getZhaomu() {
		return zhaomu;
	}
	public void setZhaomu(int zhaomu) {
		this.zhaomu = zhaomu;
	}
	public String getIntegralstatue() {
		return integralstatue;
	}
	public void setIntegralstatue(String integralstatue) {
		this.integralstatue = integralstatue;
	}
	public String getBaoxiang() {
		return baoxiang;
	}
	public void setBaoxiang(String baoxiang) {
		this.baoxiang = baoxiang;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public int getQianghua() {
		return qianghua;
	}
	public void setQianghua(int qianghua) {
		this.qianghua = qianghua;
	}
	public int getLueduo() {
		return lueduo;
	}
	public void setLueduo(int lueduo) {
		this.lueduo = lueduo;
	}
	public int getQiangduo() {
		return qiangduo;
	}
	public void setQiangduo(int qiangduo) {
		this.qiangduo = qiangduo;
	}
	public int getXiulian() {
		return xiulian;
	}
	public void setXiulian(int xiulian) {
		this.xiulian = xiulian;
	}
	public int getZhangdou() {
		return zhangdou;
	}
	public void setZhangdou(int zhangdou) {
		this.zhangdou = zhangdou;
	}
	public int getIsUpdate() {
		return isUpdate;
	}
	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}

}
