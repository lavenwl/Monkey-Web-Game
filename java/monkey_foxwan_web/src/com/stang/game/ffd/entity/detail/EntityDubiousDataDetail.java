package com.stang.game.ffd.entity.detail;

public class EntityDubiousDataDetail {
	private int ITEMTYPE=0;//物品类型id
	private int ITEMID=0;//物品id
	private int PRICEMAX=0;//价格最大值
	private int PRICEMIN=0;//价格最小值
	private int FLAG=0;
	private String ITEMNAME;//道具名称
	private int buyers;//买家
	private int seller;//卖家
	private String todaytime;//当天数据信息
	
	public int getITEMTYPE() {
		return ITEMTYPE;
	}
	public void setITEMTYPE(int itemtype) {
		ITEMTYPE = itemtype;
	}
	public int getITEMID() {
		return ITEMID;
	}
	public void setITEMID(int itemid) {
		ITEMID = itemid;
	}
	public int getPRICEMAX() {
		return PRICEMAX;
	}
	public void setPRICEMAX(int pricemax) {
		PRICEMAX = pricemax;
	}
	public int getPRICEMIN() {
		return PRICEMIN;
	}
	public void setPRICEMIN(int pricemin) {
		PRICEMIN = pricemin;
	}
	public int getFLAG() {
		return FLAG;
	}
	public void setFLAG(int flag) {
		FLAG = flag;
	}
	public String getITEMNAME() {
		return ITEMNAME;
	}
	public void setITEMNAME(String itemname) {
		ITEMNAME = itemname;
	}
	public int getBuyers() {
		return buyers;
	}
	public void setBuyers(int buyers) {
		this.buyers = buyers;
	}
	public int getSeller() {
		return seller;
	}
	public void setSeller(int seller) {
		this.seller = seller;
	}
	public String getTodaytime() {
		return todaytime;
	}
	public void setTodaytime(String todaytime) {
		this.todaytime = todaytime;
	}
}
