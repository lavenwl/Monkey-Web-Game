package com.stang.game.ffd.entity.detail;

/**
 * 战斗中的道具使用记录
 * @author guk
 *
 */
public class EntityBattleItemDetail {
	private String dateTiem;//开设房间的时间
	private int roomId=0;//房间id
	private String ItemId;//使用道具id
	private int ItemCounts=0;//使用该道具的次数
	private EntityBattleSkillDetail ebsd;//战斗中使用的技能数
	public String getDateTiem() {
		return dateTiem;
	}
	public void setDateTiem(String dateTiem) {
		this.dateTiem = dateTiem;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getItemId() {
		return ItemId;
	}
	public void setItemId(String itemId) {
		ItemId = itemId;
	}
	public int getItemCounts() {
		return ItemCounts;
	}
	public void setItemCounts(int itemCounts) {
		ItemCounts = itemCounts;
	}
	public EntityBattleSkillDetail getEbsd() {
		return ebsd;
	}
	public void setEbsd(EntityBattleSkillDetail ebsd) {
		this.ebsd = ebsd;
	}
	
}
