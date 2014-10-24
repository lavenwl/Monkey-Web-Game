package com.stang.game.entity;

public class GameSkill implements Cloneable{
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	
	private int id;
	private String skillName;
	private String skillDesc;
	private String skillIcon;
	private String skillMc;
	private String skillMcclip;
	private int type;
	private Double skillType;
	private int mpcost;
	private int skillCd;
	private Double skillArea;
	private String skillBuffId;
	private int flag;
	private String nameurl;
	private int skillodd;
	
	public int getSkillodd() {
		return skillodd;
	}
	public void setSkillodd(int skillodd) {
		this.skillodd = skillodd;
	}
	public String getNameurl() {
		return nameurl;
	}
	public void setNameurl(String nameurl) {
		this.nameurl = nameurl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public String getSkillDesc() {
		return skillDesc;
	}
	public void setSkillDesc(String skillDesc) {
		this.skillDesc = skillDesc;
	}
	public String getSkillIcon() {
		return skillIcon;
	}
	public void setSkillIcon(String skillIcon) {
		this.skillIcon = skillIcon;
	}
	public String getSkillMc() {
		return skillMc;
	}
	public void setSkillMc(String skillMc) {
		this.skillMc = skillMc;
	}
	public String getSkillMcclip() {
		return skillMcclip;
	}
	public void setSkillMcclip(String skillMcclip) {
		this.skillMcclip = skillMcclip;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Double getSkillType() {
		return skillType;
	}
	public void setSkillType(Double skillType) {
		this.skillType = skillType;
	}
	public int getMpcost() {
		return mpcost;
	}
	public void setMpcost(int mpcost) {
		this.mpcost = mpcost;
	}
	public int getSkillCd() {
		return skillCd;
	}
	public void setSkillCd(int skillCd) {
		this.skillCd = skillCd;
	}
	public Double getSkillArea() {
		return skillArea;
	}
	public void setSkillArea(Double skillArea) {
		this.skillArea = skillArea;
	}

	public String getSkillBuffId() {
		return skillBuffId;
	}
	public void setSkillBuffId(String skillBuffId) {
		this.skillBuffId = skillBuffId;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getIsUpdate() {
		return isUpdate;
	}
	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}
	
	
}
