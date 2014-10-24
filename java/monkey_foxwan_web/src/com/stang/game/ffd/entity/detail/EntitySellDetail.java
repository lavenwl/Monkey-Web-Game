package com.stang.game.ffd.entity.detail;

public class EntitySellDetail {
	private int sell=0;//消费的金额
	private int serverMoney=0;//当前服务器的总金额
	private int payMoney=0;//今天充值的金额
	private int payCount=0;//充值次数
	private int payCountpeople=0;//充值人数
	private int serverCountPeople=0;//当前区的人数
	
	private String datetime;//时间
	public int getSell() {
		return sell;
	}
	public void setSell(int sell) {
		this.sell = sell;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public int getServerMoney() {
		return serverMoney;
	}
	public void setServerMoney(int serverMoney) {
		this.serverMoney = serverMoney;
	}
	public int getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(int payMoney) {
		this.payMoney = payMoney;
	}
	public int getPayCount() {
		return payCount;
	}
	public void setPayCount(int payCount) {
		this.payCount = payCount;
	}
	public int getPayCountpeople() {
		return payCountpeople;
	}
	public void setPayCountpeople(int payCountpeople) {
		this.payCountpeople = payCountpeople;
	}
	public int getServerCountPeople() {
		return serverCountPeople;
	}
	public void setServerCountPeople(int serverCountPeople) {
		this.serverCountPeople = serverCountPeople;
	}
}
