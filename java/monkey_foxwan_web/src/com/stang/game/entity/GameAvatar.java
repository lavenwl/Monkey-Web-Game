package com.stang.game.entity;

/**
 * @author jianbo.feng
 * @company 上海三唐信息科技有限公司
 * @description 装饰信息
 */
public class GameAvatar {
	private int id; /* 序列号 */
	private String avatarName; /* 装饰标题或名称 */
	private String avatarRes; /* 资源名称 */
	private int avatarType;
	private int isMarket; /* 是否在商城出售（0/否，1/是） */
	private String avatarDh; /* 动画资源地址 */
	private int isBase; /* 是否为基础配置（0/否，1/是,2/是美容院使用） */
	private int sellcoin;
	private int selltype;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAvatarName() {
		return avatarName;
	}

	public void setAvatarName(String avatarName) {
		this.avatarName = avatarName;
	}

	public String getAvatarRes() {
		return avatarRes;
	}

	public void setAvatarRes(String avatarRes) {
		this.avatarRes = avatarRes;
	}

	public int getAvatarType() {
		return avatarType;
	}

	public void setAvatarType(int avatarType) {
		this.avatarType = avatarType;
	}

	public int getIsMarket() {
		return isMarket;
	}

	public void setIsMarket(int isMarket) {
		this.isMarket = isMarket;
	}

	public String getAvatarDh() {
		return avatarDh;
	}

	public void setAvatarDh(String avatarDh) {
		this.avatarDh = avatarDh;
	}

	public int getIsBase() {
		return isBase;
	}

	public void setIsBase(int isBase) {
		this.isBase = isBase;
	}

	public int getSellcoin() {
		return sellcoin;
	}

	public void setSellcoin(int sellcoin) {
		this.sellcoin = sellcoin;
	}

	public int getSelltype() {
		return selltype;
	}

	public void setSelltype(int selltype) {
		this.selltype = selltype;
	}
}
