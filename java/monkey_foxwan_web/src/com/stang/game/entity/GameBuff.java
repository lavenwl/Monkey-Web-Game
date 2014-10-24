package com.stang.game.entity;

import java.util.Date;

public class GameBuff {
	private int id;
	private String name; 
	private String buffDip;
	private int type;
	private int buffAtktime;
	private long buffKeeptime;
	private int atkperson;
	private int bufftype;
	private int bufftime;
	private int flag;
	private Date ctime;
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	public int getBufftype() {
		return bufftype;
	}
	public void setBufftype(int bufftype) {
		this.bufftype = bufftype;
	}
	public int getBufftime() {
		return bufftime;
	}
	public void setBufftime(int bufftime) {
		this.bufftime = bufftime;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
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
	public String getBuffDip() {
		return buffDip;
	}
	public void setBuffDip(String buffDip) {
		this.buffDip = buffDip;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	public int getBuffAtktime() {
		return buffAtktime;
	}
	public void setBuffAtktime(int buffAtktime) {
		this.buffAtktime = buffAtktime;
	}
	public long getBuffKeeptime() {
		return buffKeeptime;
	}
	public void setBuffKeeptime(long buffKeeptime) {
		this.buffKeeptime = buffKeeptime;
	}
	public int getAtkperson() {
		return atkperson;
	}
	public void setAtkperson(int atkperson) {
		this.atkperson = atkperson;
	}
	 
}
