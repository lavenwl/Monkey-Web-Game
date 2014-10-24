package com.stang.game.entity;

public class Member {
	private int id;
	private String username;
	private String password;
	private int flag;
	private String allfriends;
	private int invite;
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
}
