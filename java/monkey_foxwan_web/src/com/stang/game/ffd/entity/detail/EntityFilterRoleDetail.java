package com.stang.game.ffd.entity.detail;

import java.util.Date;

public class EntityFilterRoleDetail {
	private int id;
	private String member_name;
	private int server_id;
	private String username;
	private Date releaseall_time;
	private int type;
	private String context;
	private int flag;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public int getServer_id() {
		return server_id;
	}
	public void setServer_id(int server_id) {
		this.server_id = server_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getReleaseall_time() {
		return releaseall_time;
	}
	public void setReleaseall_time(Date releaseall_time) {
		this.releaseall_time = releaseall_time;
	}

	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
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
