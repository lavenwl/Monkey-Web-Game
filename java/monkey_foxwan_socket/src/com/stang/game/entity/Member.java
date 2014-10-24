package com.stang.game.entity;

public class Member implements Cloneable{
	@Override
	public Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	
	private int id;
	private String username;
	private String password;
	private int flag;
	private String allfriends;
	private String allgroupfriends;
	public String getAllgroupfriends() {
		return allgroupfriends;
	}
	public void setAllgroupfriends(String allgroupfriends) {
		this.allgroupfriends = allgroupfriends;
	}
	private int invite;
	private String serverId;
	
	public String getServerId() {
		return serverId;
	}
	public void setServerId(String serverId) {
		this.serverId = serverId;
	}
	public int getInvite() {
		return invite;
	}
	public void setInvite(int invite) {
		this.invite = invite;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getAllfriends() {
		return allfriends;
	}
	public void setAllfriends(String allfriends) {
		this.allfriends = allfriends;
	}
	public int getIsUpdate() {
		return isUpdate;
	}
	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}
}
