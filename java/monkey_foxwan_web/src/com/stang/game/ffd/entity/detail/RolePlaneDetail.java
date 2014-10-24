package com.stang.game.ffd.entity.detail;

import java.util.Date;

/**
 * @author jianbo.feng
 * @company 上海三唐信息科技有限公司 
 * @description 角色-飞机关系信息，即角色所拥有的飞机信息
 */
public class RolePlaneDetail {

	private Integer id;		/*序列号*/
	private Integer roleId;	/*角色序列号*/
	private Integer planeId;	/*飞机序列号*/
	private Integer isBind;		/*是否已绑定(0:未;1;绑定)*/
	private Integer isUsed;		/*是否当前使用(0:否;1:是)*/
	private Integer isIdentify;	/*是否已鉴定(0:未;1;鉴定)*/
	private Integer strengthenLevel;	/*强化等级*/
	private Date createTime;	/*信息录入时间*/
	private Integer flag;		/*信息标识位(-1,删除;0,隐藏;1,正常;)*/
	private Integer storageType;/*存储方式(0:仓库,1:背包,2:（房间战斗型道具）,3:拍卖行)*/
	private Integer grade;		/*品级(1:白;2:绿;3:蓝;4:紫;5:金)*/
	private Integer isCheck;	/*是否鉴定飞机属性*/
	private Integer checkAt;
	private Integer checkHp;
	private Integer checkDe;
	private Integer checkCu;
	private Integer checkSp;
	private Integer checkDcu;
	private Integer enchaseId1;
	private Integer enchaseState1;
	private Integer enchaseType1;
	private Integer enchaseType2;
	private Integer enchaseId2;
	private Integer enchaseState2;
	private Integer enchaseType3;
	private Integer enchaseId3;
	private Integer enchaseState3;
	private Integer enchaseType4;
	private Integer enchaseId4;
	private Integer enchaseState4;
	private Integer enchaseType5;
	private Integer enchaseId5;
	private Integer enchaseState5;
		
	public Integer getIsCheck() {
		return isCheck;
	}
	public void setIsCheck(Integer isCheck) {
		this.isCheck = isCheck;
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
	public Integer getPlaneId() {
		return planeId;
	}
	public void setPlaneId(Integer planeId) {
		this.planeId = planeId;
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
	public Integer getIsUsed() {
		return isUsed;
	}
	public void setIsUsed(Integer isUsed) {
		this.isUsed = isUsed;
	}
	public Integer getStrengthenLevel() {
		return strengthenLevel;
	}
	public void setStrengthenLevel(Integer strengthenLevel) {
		this.strengthenLevel = strengthenLevel;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public Integer getStorageType() {
		return storageType;
	}
	public void setStorageType(Integer storageType) {
		this.storageType = storageType;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public Integer getCheckAt() {
		return checkAt;
	}
	public void setCheckAt(Integer checkAt) {
		this.checkAt = checkAt;
	}
	public Integer getCheckHp() {
		return checkHp;
	}
	public void setCheckHp(Integer checkHp) {
		this.checkHp = checkHp;
	}
	public Integer getCheckDe() {
		return checkDe;
	}
	public void setCheckDe(Integer checkDe) {
		this.checkDe = checkDe;
	}
	public Integer getCheckCu() {
		return checkCu;
	}
	public void setCheckCu(Integer checkCu) {
		this.checkCu = checkCu;
	}
	public Integer getCheckSp() {
		return checkSp;
	}
	public void setCheckSp(Integer checkSp) {
		this.checkSp = checkSp;
	}
	public Integer getEnchaseId1() {
		return enchaseId1;
	}
	public void setEnchaseId1(Integer enchaseId1) {
		this.enchaseId1 = enchaseId1;
	}
	public Integer getEnchaseState1() {
		return enchaseState1;
	}
	public void setEnchaseState1(Integer enchaseState1) {
		this.enchaseState1 = enchaseState1;
	}
	public Integer getEnchaseType2() {
		return enchaseType2;
	}
	public void setEnchaseType2(Integer enchaseType2) {
		this.enchaseType2 = enchaseType2;
	}
	public Integer getEnchaseId2() {
		return enchaseId2;
	}
	public void setEnchaseId2(Integer enchaseId2) {
		this.enchaseId2 = enchaseId2;
	}
	public Integer getEnchaseState2() {
		return enchaseState2;
	}
	public void setEnchaseState2(Integer enchaseState2) {
		this.enchaseState2 = enchaseState2;
	}
	public Integer getEnchaseType3() {
		return enchaseType3;
	}
	public void setEnchaseType3(Integer enchaseType3) {
		this.enchaseType3 = enchaseType3;
	}
	public Integer getEnchaseId3() {
		return enchaseId3;
	}
	public void setEnchaseId3(Integer enchaseId3) {
		this.enchaseId3 = enchaseId3;
	}
	public Integer getEnchaseState3() {
		return enchaseState3;
	}
	public void setEnchaseState3(Integer enchaseState3) {
		this.enchaseState3 = enchaseState3;
	}
	public Integer getEnchaseType4() {
		return enchaseType4;
	}
	public void setEnchaseType4(Integer enchaseType4) {
		this.enchaseType4 = enchaseType4;
	}
	public Integer getEnchaseId4() {
		return enchaseId4;
	}
	public void setEnchaseId4(Integer enchaseId4) {
		this.enchaseId4 = enchaseId4;
	}
	public Integer getEnchaseState4() {
		return enchaseState4;
	}
	public void setEnchaseState4(Integer enchaseState4) {
		this.enchaseState4 = enchaseState4;
	}
	public Integer getEnchaseType5() {
		return enchaseType5;
	}
	public void setEnchaseType5(Integer enchaseType5) {
		this.enchaseType5 = enchaseType5;
	}
	public Integer getEnchaseId5() {
		return enchaseId5;
	}
	public void setEnchaseId5(Integer enchaseId5) {
		this.enchaseId5 = enchaseId5;
	}
	public Integer getEnchaseState5() {
		return enchaseState5;
	}
	public void setEnchaseState5(Integer enchaseState5) {
		this.enchaseState5 = enchaseState5;
	}
	public Integer getEnchaseType1() {
		return enchaseType1;
	}
	public void setEnchaseType1(Integer enchaseType1) {
		this.enchaseType1 = enchaseType1;
	}
	public Integer getCheckDcu() {
		return checkDcu;
	}
	public void setCheckDcu(Integer checkDcu) {
		this.checkDcu = checkDcu;
	}

}
