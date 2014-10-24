package com.stang.game.entity;

public class GameItem implements Cloneable{
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	
	private int id;
	private String itemname;
	private String itemres;
	private String itemprop;
	private int itemtype;
	private String itemurl;
	private int itemlevel;
	private int isover;
	private int isuse;
	private int isshop;
	private int coin;
	private int cointype;
	private int flag;
	private String reward;
	private int quality;
	private int itemvip;
	private int yuanbao;
	private int indexs;
	public int getIndexs() {
		return indexs;
	}

	public void setIndexs(int indexs) {
		this.indexs = indexs;
	}

	public int getYuanbao() {
		return yuanbao;
	}

	public void setYuanbao(int yuanbao) {
		this.yuanbao = yuanbao;
	}

	public int getItemvip() {
		return itemvip;
	}

	public void setItemvip(int itemvip) {
		this.itemvip = itemvip;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getItemres() {
		return itemres;
	}

	public void setItemres(String itemres) {
		this.itemres = itemres;
	}

	public String getItemprop() {
		return itemprop;
	}

	public void setItemprop(String itemprop) {
		this.itemprop = itemprop;
	}

	public int getItemtype() {
		return itemtype;
	}

	public void setItemtype(int itemtype) {
		this.itemtype = itemtype;
	}

	public String getItemurl() {
		return itemurl;
	}

	public void setItemurl(String itemurl) {
		this.itemurl = itemurl;
	}

	public int getItemlevel() {
		return itemlevel;
	}

	public void setItemlevel(int itemlevel) {
		this.itemlevel = itemlevel;
	}

	public int getIsover() {
		return isover;
	}

	public void setIsover(int isover) {
		this.isover = isover;
	}

	public int getIsuse() {
		return isuse;
	}

	public void setIsuse(int isuse) {
		this.isuse = isuse;
	}

	public int getIsshop() {
		return isshop;
	}

	public void setIsshop(int isshop) {
		this.isshop = isshop;
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

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getReward() {
		return reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}

	public int getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}
}
