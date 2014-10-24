package com.stang.game.ffd.entity.detail;

import java.util.Date;

/**
 * @author jianbo.feng 
 * @company 上海三唐信息科技有限公司
 * @description 角色-装饰品(所拥有)关系信息{在商城里面买的装饰，是已经'鉴定'过的} 
 */
public class RoleAvatarDetail {

	private Integer id;			/*序列号*/
	private Integer roleId;		/*角色序列号*/
	private Integer storageType;/*存储方式(0:仓库,1:背包)*/
	private Integer avatarId;	/*装饰序列号(对应GameAvatar序列号)*/
	private Integer avatarLevel;	/*装饰等级(默认值:0)*/
	private Integer strengthenLevel;/*强化等级(默认值：0)*/
	private Integer avatarPower;	/*力量值*/
	private Integer avatarAgility;	/*敏捷值*/
	private Integer avatarStamina;	/*耐力值*/
	private Integer avatarMana;		/*精神值*/
	private Integer sourceType;	/*来源类型(0:参与战斗,1:强化,2,:其他来源,10：商城)*/
	private Integer isUsed;		/*是否已使用(0,否;1,是;)*/
	private Integer isBind;		/*是否已绑定(0,否;1,是;)*/
	private Integer isIdentify;	/*是否已鉴定(0:未;1;鉴定)*/
	private Date createTime;	/*信息录入时间*/
	private Date useTime;		/*使用时间(指该道具开始使用的时间)*/
	private Integer flag;		/*信息标识位(-1,删除;0,隐藏;1,正常;)*/
	private Integer grade;		/*品级(1:白;2:绿;3:蓝;4:紫;5:金)*/
	private Integer address;	/*位置(1帽子-hat；2发型-hair；3耳环-earring；4配件(即眼部装饰)-eye；5表情-face；6衣服-clothes；7鞋子-shoe；91（左）戒子-ring；8项链-necklace；9翅膀-wings;20嘴-mouth，21耳朵-ear，22身体-body，23头-head，92（右）戒子-ring)*/
	private Integer storeTime;	/*时效*/
	private Integer avatarHpMax;
	private Integer avatarDef;

	public Integer getAvatarDef() {
		return avatarDef;
	}
	public void setAvatarDef(Integer avatarDef) {
		this.avatarDef = avatarDef;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getStorageType() {
		return storageType;
	}
	public void setStorageType(Integer storageType) {
		this.storageType = storageType;
	}
	public Integer getAvatarId() {
		return avatarId;
	}
	public void setAvatarId(Integer avatarId) {
		this.avatarId = avatarId;
	}
	public Integer getAvatarLevel() {
		return avatarLevel;
	}
	public void setAvatarLevel(Integer avatarLevel) {
		this.avatarLevel = avatarLevel;
	}
	public Integer getStrengthenLevel() {
		return strengthenLevel;
	}
	public void setStrengthenLevel(Integer strengthenLevel) {
		this.strengthenLevel = strengthenLevel;
	}
	public Integer getAvatarPower() {
		return avatarPower;
	}
	public void setAvatarPower(Integer avatarPower) {
		this.avatarPower = avatarPower;
	}
	public Integer getAvatarAgility() {
		return avatarAgility;
	}
	public void setAvatarAgility(Integer avatarAgility) {
		this.avatarAgility = avatarAgility;
	}
	public Integer getAvatarStamina() {
		return avatarStamina;
	}
	public void setAvatarStamina(Integer avatarStamina) {
		this.avatarStamina = avatarStamina;
	}
	public Integer getAvatarMana() {
		return avatarMana;
	}
	public void setAvatarMana(Integer avatarMana) {
		this.avatarMana = avatarMana;
	}
	public Integer getSourceType() {
		return sourceType;
	}
	public void setSourceType(Integer sourceType) {
		this.sourceType = sourceType;
	}
	public Integer getIsUsed() {
		return isUsed;
	}
	public void setIsUsed(Integer isUsed) {
		this.isUsed = isUsed;
	}
	public Integer getIsBind() {
		return isBind;
	}
	public void setIsBind(Integer isBind) {
		this.isBind = isBind;
	}
	public Integer getIsIdentify() {
		return isIdentify;
	}
	public void setIsIdentify(Integer isIdentify) {
		this.isIdentify = isIdentify;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUseTime() {
		return useTime;
	}
	public void setUseTime(Date useTime) {
		this.useTime = useTime;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public Integer getAddress() {
		return address;
	}
	public void setAddress(Integer address) {
		this.address = address;
	}
	public Integer getStoreTime() {
		return storeTime;
	}
	public void setStoreTime(Integer storeTime) {
		this.storeTime = storeTime;
	}
	public Integer getAvatarHpMax() {
		return avatarHpMax;
	}
	public void setAvatarHpMax(Integer avatarHpMax) {
		this.avatarHpMax = avatarHpMax;
	}	
	
	
}
