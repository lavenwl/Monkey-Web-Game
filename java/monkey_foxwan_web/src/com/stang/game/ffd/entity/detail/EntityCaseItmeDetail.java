package com.stang.game.ffd.entity.detail;

public class EntityCaseItmeDetail {
	private int masttypeId;//主类型
	private int itemId;//道具id
	private int buyNum;//道具数量
	private int price;//购买价格
	
	public int getMasttypeId() {
		return masttypeId;
	}
	public void setMasttypeId(int masttypeId) {
		this.masttypeId = masttypeId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getBuyNum() {
		return buyNum;
	}
	public void setBuyNum(int buyNum) {
		this.buyNum = buyNum;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
