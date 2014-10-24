package com.stang.game.ffd.entity.detail;

import java.util.Date;

public class EntityFilterIPDetail {
	
	private int id;
	private String ip;
	private int server_id;
	private String mask;
	private Date releaseall_time;
	private String context;
	private int flag;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getServer_id() {
		return server_id;
	}
	public void setServer_id(int server_id) {
		this.server_id = server_id;
	}
	public String getMask() {
		return mask;
	}
	public void setMask(String mask) {
		this.mask = mask;
	}
	public Date getReleaseall_time() {
		return releaseall_time;
	}
	public void setReleaseall_time(Date releaseall_time) {
		this.releaseall_time = releaseall_time;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	

}
