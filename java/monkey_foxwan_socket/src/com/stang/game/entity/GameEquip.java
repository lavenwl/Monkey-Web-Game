package com.stang.game.entity;

public class GameEquip implements Cloneable{
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	
	private int id;
	private String equipname;
	private String equipurl;
	private int equiptype;
	private int type;
	private int gongji;
	private int fanwei;
	private int sudu;
	private int xueliang;
	private String extra;
	private int level;
	private int flag;
	private int coin;
	private int cointype;
	private String desc;
	private int isshop;
	private int quality;
private int eatequipid;
public int getEatequipid() {
	return eatequipid;
}

public void setEatequipid(int eatequipid) {
	this.eatequipid = eatequipid;
}

private int isstar;

	public int getIsstar() {
	return isstar;
}

public void setIsstar(int isstar) {
	this.isstar = isstar;
}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getIsshop() {
		return isshop;
	}

	public void setIsshop(int isshop) {
		this.isshop = isshop;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEquipname() {
		return equipname;
	}

	public void setEquipname(String equipname) {
		this.equipname = equipname;
	}

	public String getEquipurl() {
		return equipurl;
	}

	public void setEquipurl(String equipurl) {
		this.equipurl = equipurl;
	}

	public int getEquiptype() {
		return equiptype;
	}

	public void setEquiptype(int equiptype) {
		this.equiptype = equiptype;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getGongji() {
		return gongji;
	}

	public void setGongji(int gongji) {
		this.gongji = gongji;
	}

	public int getFanwei() {
		return fanwei;
	}

	public void setFanwei(int fanwei) {
		this.fanwei = fanwei;
	}

	public int getSudu() {
		return sudu;
	}

	public void setSudu(int sudu) {
		this.sudu = sudu;
	}

	public int getXueliang() {
		return xueliang;
	}

	public void setXueliang(int xueliang) {
		this.xueliang = xueliang;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}

	public int getCointype() {
		return cointype;
	}

	public void setCointype(int cointype) {
		this.cointype = cointype;
	}

	public int getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}
}
