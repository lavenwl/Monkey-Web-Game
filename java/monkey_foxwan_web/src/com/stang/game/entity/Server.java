package com.stang.game.entity;

import java.io.*;

public class Server implements Serializable{
 int id;
 String name;
 int statue_mag;
 int statue_tui;
 int statue_xin;
 int statue_on;
 String time;
 String ip;
 int online_num;

public int getOnline_num() {
	return online_num;
}
public void setOnline_num(int online_num) {
	this.online_num = online_num;
}
public String getIp() {
	return ip;
}
public void setIp(String ip) {
	this.ip = ip;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
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
public int getStatue_mag() {
	return statue_mag;
}
public void setStatue_mag(int statue_mag) {
	this.statue_mag = statue_mag;
}
public int getStatue_tui() {
	return statue_tui;
}
public void setStatue_tui(int statue_tui) {
	this.statue_tui = statue_tui;
}
public int getStatue_xin() {
	return statue_xin;
}
public void setStatue_xin(int statue_xin) {
	this.statue_xin = statue_xin;
}
public int getStatue_on() {
	return statue_on;
}
public void setStatue_on(int statue_on) {
	this.statue_on = statue_on;
}
 
}
