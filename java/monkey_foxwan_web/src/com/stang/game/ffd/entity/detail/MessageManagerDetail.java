package com.stang.game.ffd.entity.detail;

import java.util.Date;

public class MessageManagerDetail {
	private int id;
	private int uid;
	private String uname;
	private Date op_time;
	private String message;
	private Date send_time;
	private Date next_time;
	private int times;
	private int int_time;
	private int type;
	private String herf;
	private int flag;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public Date getOp_time() {
		return op_time;
	}
	public void setOp_time(Date op_time) {
		this.op_time = op_time;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getSend_time() {
		return send_time;
	}
	public void setSend_time(Date send_time) {
		this.send_time = send_time;
	}
	public Date getNext_time() {
		return next_time;
	}
	public void setNext_time(Date next_time) {
		this.next_time = next_time;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	public int getInt_time() {
		return int_time;
	}
	public void setInt_time(int int_time) {
		this.int_time = int_time;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getHerf() {
		return herf;
	}
	public void setHerf(String herf) {
		this.herf = herf;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
