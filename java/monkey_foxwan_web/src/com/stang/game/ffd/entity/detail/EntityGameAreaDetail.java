package com.stang.game.ffd.entity.detail;

import java.util.Date;

/**
 * @author jianbo.feng
 * @company 上海三唐信息科技有限公司
 * @description 游戏大区信息  
 */
public class EntityGameAreaDetail {

	private Integer id;			/*序列号*/
	private Integer serverId;	/*服务器序列号*/
	private String areaName;	/*大区名称*/
	private Integer statusWellPlayerNum;	/*良好状态玩家人数上限*/
	private Integer statusGeneralPlayerNum;	/*一般状态玩家人数上限*/
	private Integer statusCrowdPlayerNum;	/*拥挤状态玩家人数上限*/
	private Integer maxPlayerNum;		/*最大玩家数量*/
	private Integer areaType;			/*大区类型(1,新手区;2,普通区)*/
	private Date createTime;	/*信息录入时间*/
	private Integer flag;		/*信息标识位,默认值1(-1,删除;0,隐藏;1,正常;)*/
	private Integer maxLevel;	/*游戏角色等级上限(小于)*/
	private Integer minLevel;	/*游戏角色等级最低值(大于等于)*/
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getServerId() {
		return serverId;
	}
	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}
	public Integer getStatusWellPlayerNum() {
		return statusWellPlayerNum;
	}
	public void setStatusWellPlayerNum(Integer statusWellPlayerNum) {
		this.statusWellPlayerNum = statusWellPlayerNum;
	}
	public Integer getStatusGeneralPlayerNum() {
		return statusGeneralPlayerNum;
	}
	public void setStatusGeneralPlayerNum(Integer statusGeneralPlayerNum) {
		this.statusGeneralPlayerNum = statusGeneralPlayerNum;
	}
	public Integer getStatusCrowdPlayerNum() {
		return statusCrowdPlayerNum;
	}
	public void setStatusCrowdPlayerNum(Integer statusCrowdPlayerNum) {
		this.statusCrowdPlayerNum = statusCrowdPlayerNum;
	}
	public Integer getMaxPlayerNum() {
		return maxPlayerNum;
	}
	public void setMaxPlayerNum(Integer maxPlayerNum) {
		this.maxPlayerNum = maxPlayerNum;
	}
	public Integer getAreaType() {
		return areaType;
	}
	public void setAreaType(Integer areaType) {
		this.areaType = areaType;
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
	public Integer getMaxLevel() {
		return maxLevel;
	}
	public void setMaxLevel(Integer maxLevel) {
		this.maxLevel = maxLevel;
	}
	public Integer getMinLevel() {
		return minLevel;
	}
	public void setMinLevel(Integer minLevel) {
		this.minLevel = minLevel;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
}
