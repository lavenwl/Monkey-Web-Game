package com.stang.game.ffd.entity.detail;

import java.util.Date;

import com.stang.game.ffd.entity.EntityGameConsortia;


/**
 * @author jianbo.feng
 * @company 上海三唐信息科技有限公司
 * @description 公会信息  
 */
public class EntityGameConsortiaDetail implements EntityGameConsortia{

	private Integer id;		/*序列号*/
	private String consortiaName;	/*公会名称*/
	private String consortiaBulletin;	/*公会公告*/
	private String consortiaDesc;	/*公会描述*/
	private Integer consortiaLevel;	/*公会等级,默认0*/
	private Integer consortiaExp;	/*公会经验*/
	private Integer consortiaCoin;	/*公会金币(不能使用RMB,由会员捐赠)*/
	private Integer roleMaxSize;	/*玩家最大个数,默认值1*/
	private Integer chairmanId;		/*会长角色序列号*/
	private Integer viceChairman1Id;/*第一副会长角色序列号*/
	private Integer viceChairman2Id;/*第二副会长角色序列号*/
	private Date createTime;	/*公会创建时间*/
	private Integer flag;		/*信息标识位,默认值1(-1,删除;0,隐藏;1,正常)*/
	private Integer serverId;	/*服务器序号*/
	private Integer guildNum;  /*工会人数*/
	private EntityGameRoleDetail egrd;
	private String ctime;//工会穿件时间 
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getConsortiaName() {
		return consortiaName;
	}
	public void setConsortiaName(String consortiaName) {
		this.consortiaName = consortiaName;
	}
	public String getConsortiaBulletin() {
		return consortiaBulletin;
	}
	public void setConsortiaBulletin(String consortiaBulletin) {
		this.consortiaBulletin = consortiaBulletin;
	}
	public String getConsortiaDesc() {
		return consortiaDesc;
	}
	public void setConsortiaDesc(String consortiaDesc) {
		this.consortiaDesc = consortiaDesc;
	}
	public Integer getConsortiaLevel() {
		return consortiaLevel;
	}
	public void setConsortiaLevel(Integer consortiaLevel) {
		this.consortiaLevel = consortiaLevel;
	}
	public Integer getConsortiaExp() {
		return consortiaExp;
	}
	public void setConsortiaExp(Integer consortiaExp) {
		this.consortiaExp = consortiaExp;
	}
	public Integer getConsortiaCoin() {
		return consortiaCoin;
	}
	public void setConsortiaCoin(Integer consortiaCoin) {
		this.consortiaCoin = consortiaCoin;
	}
	public Integer getRoleMaxSize() {
		return roleMaxSize;
	}
	public void setRoleMaxSize(Integer roleMaxSize) {
		this.roleMaxSize = roleMaxSize;
	}
	public Integer getChairmanId() {
		return chairmanId;
	}
	public void setChairmanId(Integer chairmanId) {
		this.chairmanId = chairmanId;
	}
	public Integer getViceChairman1Id() {
		return viceChairman1Id;
	}
	public void setViceChairman1Id(Integer viceChairman1Id) {
		this.viceChairman1Id = viceChairman1Id;
	}
	public Integer getViceChairman2Id() {
		return viceChairman2Id;
	}
	public void setViceChairman2Id(Integer viceChairman2Id) {
		this.viceChairman2Id = viceChairman2Id;
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
	public Integer getServerId() {
		return serverId;
	}
	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}
	public Integer getGuildNum() {
		return guildNum;
	}
	public void setGuildNum(Integer guildNum) {
		this.guildNum = guildNum;
	}
	public EntityGameRoleDetail getEgrd() {
		return egrd;
	}
	public void setEgrd(EntityGameRoleDetail egrd) {
		this.egrd = egrd;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
}
