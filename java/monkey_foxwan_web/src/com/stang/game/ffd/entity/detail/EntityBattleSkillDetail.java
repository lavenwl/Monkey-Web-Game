package com.stang.game.ffd.entity.detail;

/**
 * 战斗中使用的技能
 * @author guk
 *
 */
public class EntityBattleSkillDetail {
	private String dateTiem;//开设房间的时间
	private int roomId=0;//房间id
	private String skillId;//使用道具id
	private int skillCounts=0;//使用该道具的次数
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
	public String getSkillId() {
		return skillId;
	}
	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}
	public int getSkillCounts() {
		return skillCounts;
	}
	public void setSkillCounts(int skillCounts) {
		this.skillCounts = skillCounts;
	}
}
