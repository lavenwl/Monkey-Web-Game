package com.stang.game.ffd.entity.detail;

public class TyroCardDetail {
	private Integer id;
	private String card;
	private Integer flag;
	private Integer serverId;
	private Integer roleId;
	private String md5card;
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getServerId() {
		return serverId;
	}
	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public String getMd5card() {
		return md5card;
	}
	public void setMd5card(String md5card) {
		this.md5card = md5card;
	}
}
