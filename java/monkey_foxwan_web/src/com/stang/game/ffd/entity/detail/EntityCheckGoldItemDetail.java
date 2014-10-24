package com.stang.game.ffd.entity.detail;

public class EntityCheckGoldItemDetail {
	private String dateTime;//时间
	private long goldType=0;//金币道具类型1强化，2改造，3鉴定，4洗练，5上架拍卖物，6,购买战斗道具,7公会捐献
	private long goldType2=0;
	private long goldType3=0;
	private long goldType4=0;
	private long goldType5=0;
	private long goldType6=0;
	private long goldType7=0;
	private long goldSell=0;//金币消耗总数
	private long tadayGold=0;//今天产出了多少金币
	private long serverGold=0;//服务器当前的金币数量是多少
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public long getGoldType() {
		return goldType;
	}
	public void setGoldType(long goldType) {
		this.goldType = goldType;
	}
	public long getGoldSell() {
		return goldSell;
	}
	public void setGoldSell(long goldSell) {
		this.goldSell = goldSell;
	}
	public long getGoldType2() {
		return goldType2;
	}
	public void setGoldType2(long goldType2) {
		this.goldType2 = goldType2;
	}
	public long getGoldType3() {
		return goldType3;
	}
	public void setGoldType3(long goldType3) {
		this.goldType3 = goldType3;
	}
	public long getGoldType4() {
		return goldType4;
	}
	public void setGoldType4(long goldType4) {
		this.goldType4 = goldType4;
	}
	public long getGoldType5() {
		return goldType5;
	}
	public void setGoldType5(long goldType5) {
		this.goldType5 = goldType5;
	}
	public long getGoldType6() {
		return goldType6;
	}
	public void setGoldType6(long goldType6) {
		this.goldType6 = goldType6;
	}
	public long getGoldType7() {
		return goldType7;
	}
	public void setGoldType7(long goldType7) {
		this.goldType7 = goldType7;
	}
	public long getTadayGold() {
		return tadayGold;
	}
	public void setTadayGold(long tadayGold) {
		this.tadayGold = tadayGold;
	}
	public long getServerGold() {
		return serverGold;
	}
	public void setServerGold(long serverGold) {
		this.serverGold = serverGold;
	}

}
