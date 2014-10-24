package com.stang.game.ffd.entity.detail;

public class EntityItemAllDetail {
	private String date;//录入时间
	private int type;//数据类型 1~4
	private EntityGameItemsDetail gameItems;//道具类型
	private EntityGamePlaneDetail gameplane;//飞机类型
	private EntityGameEquipDetail gameEquip;//装备类型
	private EntityGameAvatarDetail gameAvatar;//装扮类型
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public EntityGameItemsDetail getGameItems() {
		return gameItems;
	}
	public void setGameItems(EntityGameItemsDetail gameItems) {
		this.gameItems = gameItems;
	}
	public EntityGamePlaneDetail getGameplane() {
		return gameplane;
	}
	public void setGameplane(EntityGamePlaneDetail gameplane) {
		this.gameplane = gameplane;
	}
	public EntityGameEquipDetail getGameEquip() {
		return gameEquip;
	}
	public void setGameEquip(EntityGameEquipDetail gameEquip) {
		this.gameEquip = gameEquip;
	}
	public EntityGameAvatarDetail getGameAvatar() {
		return gameAvatar;
	}
	public void setGameAvatar(EntityGameAvatarDetail gameAvatar) {
		this.gameAvatar = gameAvatar;
	}
	
}
