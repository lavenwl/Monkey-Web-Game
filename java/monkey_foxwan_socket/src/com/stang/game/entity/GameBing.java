package com.stang.game.entity;

public class GameBing implements Cloneable{
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	
	private int id;
	private String name;
	private String icon;
	private String artdesc;
	private int type;
	private int isenemy;
	private int gongji;
	private double xishu1;
	private int xueliang;
	private double xishu2;
	private int fangyu;
	private double gongsu;
	private int gongfan;
	private int shangfan;
	private double sudu;
	private int renkou;
	private int jiage;
	private int lengque;
	private int bullet;
	private String bulletfly;
	private String bullethit;
	private int flag;
	private String skill;
	private int gongjun;
	private int bingfu;
	private int xtype;
	private double xixue;
	private String accord;
	private int qty;
	private String speakdesc;
	private String speaktext;
	public String getSpeakdesc() {
		return speakdesc;
	}
	public void setSpeakdesc(String speakdesc) {
		this.speakdesc = speakdesc;
	}
	public String getSpeaktext() {
		return speaktext;
	}
	public void setSpeaktext(String speaktext) {
		this.speaktext = speaktext;
	}
	public String getAccord() {
		return accord;
	}
	public void setAccord(String accord) {
		this.accord = accord;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getXtype() {
		return xtype;
	}
	public void setXtype(int xtype) {
		this.xtype = xtype;
	}
	public int getGongjun() {
		return gongjun;
	}
	public void setGongjun(int gongjun) {
		this.gongjun = gongjun;
	}
	public int getBingfu() {
		return bingfu;
	}
	public void setBingfu(int bingfu) {
		this.bingfu = bingfu;
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
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public String getArtdesc() {
		return artdesc;
	}
	public void setArtdesc(String artdesc) {
		this.artdesc = artdesc;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getIsenemy() {
		return isenemy;
	}
	public void setIsenemy(int isenemy) {
		this.isenemy = isenemy;
	}
	public int getGongji() {
		return gongji;
	}
	public void setGongji(int gongji) {
		this.gongji = gongji;
	}
	public double getXishu1() {
		return xishu1;
	}
	public void setXishu1(double xishu1) {
		this.xishu1 = xishu1;
	}
	public int getXueliang() {
		return xueliang;
	}
	public void setXueliang(int xueliang) {
		this.xueliang = xueliang;
	}
	public double getXishu2() {
		return xishu2;
	}
	public void setXishu2(double xishu2) {
		this.xishu2 = xishu2;
	}
	public int getFangyu() {
		return fangyu;
	}
	public void setFangyu(int fangyu) {
		this.fangyu = fangyu;
	}
	public double getGongsu() {
		return gongsu;
	}
	public void setGongsu(double gongsu) {
		this.gongsu = gongsu;
	}
	public int getGongfan() {
		return gongfan;
	}
	public void setGongfan(int gongfan) {
		this.gongfan = gongfan;
	}
	public int getShangfan() {
		return shangfan;
	}
	public void setShangfan(int shangfan) {
		this.shangfan = shangfan;
	}
	public double getSudu() {
		return sudu;
	}
	public void setSudu(double sudu) {
		this.sudu = sudu;
	}
	public int getRenkou() {
		return renkou;
	}
	public void setRenkou(int renkou) {
		this.renkou = renkou;
	}
	public int getJiage() {
		return jiage;
	}
	public void setJiage(int jiage) {
		this.jiage = jiage;
	}
	public int getLengque() {
		return lengque;
	}
	public void setLengque(int lengque) {
		this.lengque = lengque;
	}
	public int getBullet() {
		return bullet;
	}
	public void setBullet(int bullet) {
		this.bullet = bullet;
	}
	public String getBulletfly() {
		return bulletfly;
	}
	public void setBulletfly(String bulletfly) {
		this.bulletfly = bulletfly;
	}
	public String getBullethit() {
		return bullethit;
	}
	public void setBullethit(String bullethit) {
		this.bullethit = bullethit;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public double getXixue() {
		return xixue;
	}
	public void setXixue(double xixue) {
		this.xixue = xixue;
	}
	public int getIsUpdate() {
		return isUpdate;
	}
	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}
	
}
