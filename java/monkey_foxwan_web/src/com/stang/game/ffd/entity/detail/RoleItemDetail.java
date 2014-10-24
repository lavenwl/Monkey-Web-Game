package com.stang.game.ffd.entity.detail;

import java.util.Date;

/**
 * @author jianbo.feng
 * @company 上海三唐信息科技有限公司 
 * @description 角色-战斗性道具信息
 */
public class RoleItemDetail {

	private Integer id;			/*序列号*/
	private Integer roleId;		/*角色序列号*/
	private Integer storageType;/*存储方式(0:仓库,1:背包)*/
	private Integer itemId;		/*战斗性道具信息序列号*/
	private Integer isUsed;		/*是否已使用*/
	private Integer isBind;		/*是否已绑定(0,否;1,;是)
            当is_used为1的时候，且装备原型信息中的is_bind为1时,该装备即为绑定;
            不管该装备原型信息中是否已绑定，只要玩家没有使用，则装备还可以进行交易。*/
	private Date startUseTime;	/*道具开始使用时间*/
	private Integer useTime;	/*道具已使用的时间(单位：秒)*/
	private Date createTime;	/*信息录入时间*/
	private Integer flag;		/*信息标识位(-1,删除;0,隐藏;1,正常)*/
	private Integer num;		/*数量*/
	
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
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
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
	public Date getStartUseTime() {
		return startUseTime;
	}
	public void setStartUseTime(Date startUseTime) {
		this.startUseTime = startUseTime;
	}
	public Integer getUseTime() {
		return useTime;
	}
	public void setUseTime(Integer useTime) {
		this.useTime = useTime;
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
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
}
