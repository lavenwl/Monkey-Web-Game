package com.stang.game.entity;

public class Buy {
private int id;
private String openid;
private String payitem;
private String totalmoney;
public String getTotalmoney() {
	return totalmoney;
}
public void setTotalmoney(String totalmoney) {
	this.totalmoney = totalmoney;
}
private String time;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getOpenid() {
	return openid;
}
public void setOpenid(String openid) {
	this.openid = openid;
}
public String getPayitem() {
	return payitem;
}
public void setPayitem(String payitem) {
	this.payitem = payitem;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}

}
