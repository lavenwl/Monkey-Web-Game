package com.stang.game.ffd.entity.detail;

import java.util.Date;

/**
 * @author jianbo.feng
 * @company 上海三唐信息科技有限公司
 * @description 游戏角色信息  (1帽子-hat；2发型-hair；3耳环-earring；4配件(即眼部装饰)-eye；5表情-face；6衣服-clothes；7鞋子-shoe；91戒子-ring；8项链-necklace；9翅膀-wings；20嘴-mouth，21耳朵-ear，22身体-body)
 */
public class EntityGameRoleDetail {

	private Integer id;			/*序列号*/
	private Integer areaId;		/*玩家当前所在大区序列号(根据玩家进入的大区不同可改变)*/
	private Integer serverId;	/*服务器序列号*/
	private Integer memberId;	/*会员序列号*/
	private String roleName;	/*角色名称*/
	private Integer roleLevel;	/*角色等级信息序列号,默认值1*/
	private Integer roleRace;	/*角色种族序列号*/
	private Integer roleExp;	/*角色经验值*/
	private Integer roleSex;	/*角色性别(1男2女,默认1)*/
	private Integer chatSaveCycle;		/*聊天信息保存周期(默认：0天)*/
	private Date chatSaveCycleStartTime;/*聊天信息存开始时间(当到期之后置为初始值0)*/
	
	private Integer avatarHairId;		/*头发装饰(角色-装饰)序列号[带属性]*/
	private Integer avatarFaceId;		/*表情装饰(角色-装饰)序列号[带属性]*/
	private Integer avatarClothesId;      /*衣服，鞋子，身体*/
	
	
	private Integer avatarMouthId;		/*嘴型装饰(角色-装饰)序列号[不带属性]*/
	private Integer avatarEarId;		/*耳朵装饰(角色-装饰)序列号[不带属性]*/
	private Integer avatarBodyId;		/*身体装饰(角色-装饰)序列号[不带属性]*/
	private Integer avatarHeadId;		/*头*/
	
	private Date inAreaTime;	/*进入大区时间*/
	private Date createTime;	/*信息录入时间*/
	private String inAreaRemoteAddress;	/*进入大区时客户端地址*/
	private Integer roleStatus;		/*玩家状态(0:未进入大厅[即离线状态];1:大厅;2:房间)*/
	private Integer victoryNumber;		/*胜利次数*/
	private Integer failureNumber;		/*失败次数*/		
	
	private Integer dailyNumber;        /*日常任务胜利次数*/
	private Integer battleVictoryNumber;/*战斗胜利次数*/
	
	private Integer troopVictoryNumber; /*组队胜利次数*/
	private Integer consortiaVictoryNumber; /*社团胜利次数*/
	
	
	private Integer flag;		/*信息标识位,默认值为1(-1,删除;0,隐藏;1,正常;)*/
	private Integer roleGold;	/*玩家金币数量*/
	private Integer roleMoney;	/*玩家金钱/点卷数量*/
	private String rolePower;	/*玩家属性:力量(默认值"0",基础值+相关被动技能属性值+属性点加上的值)*/
	private String roleAgility; /*玩家属性:敏捷(默认值"0",基础值+相关被动技能属性值+属性点加上的值)*/
	private String roleStamina; /*玩家属性:耐力(默认值"0",基础值+相关被动技能属性值+属性点加上的值)*/
	private String roleSpirit;	/*玩家属性:精神(默认值"0",基础值+相关被动技能属性值+属性点加上的值)*/
	
	private Integer roleSkillPoints;/*玩家所有技能点数(默认值0)*/
	private Integer rolePropPoints;	/*玩家所有属性点数(默认值0)*/
	private Integer roleSkillPoint;	/*玩家剩余技能点数(默认值0)*/
	private Integer rolePropPoint;	/*玩家剩余属性点数(默认值0)*/
	private Integer isVip;			/*是否为会员 0/否，1/是 (默认值0)*/
	private Date vipStart;			/*会员开始时间*/
	private Date vipEnd;			/*会员结束时间*/
	
	private Integer roleTyro;   /*是否新手 0否/，1/是*/
	private Integer roleFatigue;/*是否防沉迷 0/是,1/否*/
	private Integer roleFatigueFuntime; /*防沉迷累加时间*/
	private Integer roleBattleBonus; /*战斗奖励是否标示, 3/奖励减半,5/无奖励*/
	private Integer roleSalle; /*1/战斗大厅,2/pve大厅*/
	private Integer isKick;/*是否防踢*/
	private Integer isAddExp;/*是否增加经验*/
	private Integer addExpPer;/*增加经验百分比*/
	private Integer rolePackageNum;/*背包格子数量*/
	private Date dekickTimeStart;/*防踢开始时间*/
	private Date dekickTimeEnd;/*防踢结束时间*/
	private Date addExpTimeStart;/*增加经验开始时间*/
	private Date addExpTimeEnd;/*增加经验结束时间*/
	private int gamblingExp;	/*赌博每日获得的经验丹次数*/
	private int gamblingMoney;	/*赌博每日获得的金币次数	*/
	private String cTime;//时间string 格式
	public int getGamblingExp() {
		return gamblingExp;
	}
	public void setGamblingExp(int gamblingExp) {
		this.gamblingExp = gamblingExp;
	}
	public int getGamblingMoney() {
		return gamblingMoney;
	}
	public void setGamblingMoney(int gamblingMoney) {
		this.gamblingMoney = gamblingMoney;
	}
	public Integer getIsKick() {
		return isKick;
	}
	public void setIsKick(Integer isKick) {
		this.isKick = isKick;
	}
	public Integer getIsAddExp() {
		return isAddExp;
	}
	public void setIsAddExp(Integer isAddExp) {
		this.isAddExp = isAddExp;
	}

	public Integer getRoleSalle() {
		return roleSalle;
	}
	public void setRoleSalle(Integer roleSalle) {
		this.roleSalle = roleSalle;
	}
	public Integer getRoleTyro() {
		return roleTyro;
	}
	public void setRoleTyro(Integer roleTyro) {
		this.roleTyro = roleTyro;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public Integer getServerId() {
		return serverId;
	}
	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getRoleLevel() {
		return roleLevel;
	}
	public void setRoleLevel(Integer roleLevel) {
		this.roleLevel = roleLevel;
	}
	public Integer getRoleRace() {
		return roleRace;
	}
	public void setRoleRace(Integer roleRace) {
		this.roleRace = roleRace;
	}
	public Integer getRoleExp() {
		return roleExp;
	}
	public void setRoleExp(Integer roleExp) {
		this.roleExp = roleExp;
	}
	public Integer getRoleSex() {
		return roleSex;
	}
	public void setRoleSex(Integer roleSex) {
		this.roleSex = roleSex;
	}
	public Integer getChatSaveCycle() {
		return chatSaveCycle;
	}
	public void setChatSaveCycle(Integer chatSaveCycle) {
		this.chatSaveCycle = chatSaveCycle;
	}
	public Date getChatSaveCycleStartTime() {
		return chatSaveCycleStartTime;
	}
	public void setChatSaveCycleStartTime(Date chatSaveCycleStartTime) {
		this.chatSaveCycleStartTime = chatSaveCycleStartTime;
	}

	public Integer getAvatarHairId() {
		return avatarHairId;
	}
	public void setAvatarHairId(Integer avatarHairId) {
		this.avatarHairId = avatarHairId;
	}

	public Integer getAvatarFaceId() {
		return avatarFaceId;
	}
	public void setAvatarFaceId(Integer avatarFaceId) {
		this.avatarFaceId = avatarFaceId;
	}
	public Integer getAvatarMouthId() {
		return avatarMouthId;
	}
	public void setAvatarMouthId(Integer avatarMouthId) {
		this.avatarMouthId = avatarMouthId;
	}
	public Integer getAvatarEarId() {
		return avatarEarId;
	}
	public void setAvatarEarId(Integer avatarEarId) {
		this.avatarEarId = avatarEarId;
	}
	public Integer getAvatarBodyId() {
		return avatarBodyId;
	}
	public void setAvatarBodyId(Integer avatarBodyId) {
		this.avatarBodyId = avatarBodyId;
	}
	public Date getInAreaTime() {
		return inAreaTime;
	}
	public void setInAreaTime(Date inAreaTime) {
		this.inAreaTime = inAreaTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getInAreaRemoteAddress() {
		return inAreaRemoteAddress;
	}
	public void setInAreaRemoteAddress(String inAreaRemoteAddress) {
		this.inAreaRemoteAddress = inAreaRemoteAddress;
	}
	public Integer getRoleStatus() {
		return roleStatus;
	}
	public void setRoleStatus(Integer roleStatus) {
		this.roleStatus = roleStatus;
	}
	public Integer getVictoryNumber() {
		return victoryNumber;
	}
	public void setVictoryNumber(Integer victoryNumber) {
		this.victoryNumber = victoryNumber;
	}
	public Integer getFailureNumber() {
		return failureNumber;
	}
	public void setFailureNumber(Integer failureNumber) {
		this.failureNumber = failureNumber;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public Integer getRoleGold() {
		return roleGold;
	}
	public void setRoleGold(Integer roleGold) {
		this.roleGold = roleGold;
	}
	public Integer getRoleMoney() {
		return roleMoney;
	}
	public void setRoleMoney(Integer roleMoney) {
		this.roleMoney = roleMoney;
	}
	public String getRolePower() {
		return rolePower;
	}
	public void setRolePower(String rolePower) {
		this.rolePower = rolePower;
	}
	public String getRoleAgility() {
		return roleAgility;
	}
	public void setRoleAgility(String roleAgility) {
		this.roleAgility = roleAgility;
	}
	public String getRoleStamina() {
		return roleStamina;
	}
	public void setRoleStamina(String roleStamina) {
		this.roleStamina = roleStamina;
	}
	public String getRoleSpirit() {
		return roleSpirit;
	}
	public void setRoleSpirit(String roleSpirit) {
		this.roleSpirit = roleSpirit;
	}
	public Integer getRoleSkillPoints() {
		return roleSkillPoints;
	}
	public void setRoleSkillPoints(Integer roleSkillPoints) {
		this.roleSkillPoints = roleSkillPoints;
	}
	public Integer getRolePropPoints() {
		return rolePropPoints;
	}
	public void setRolePropPoints(Integer rolePropPoints) {
		this.rolePropPoints = rolePropPoints;
	}
	public Integer getRoleSkillPoint() {
		return roleSkillPoint;
	}
	public void setRoleSkillPoint(Integer roleSkillPoint) {
		this.roleSkillPoint = roleSkillPoint;
	}
	public Integer getRolePropPoint() {
		return rolePropPoint;
	}
	public void setRolePropPoint(Integer rolePropPoint) {
		this.rolePropPoint = rolePropPoint;
	}
	public Integer getIsVip() {
		return isVip;
	}
	public void setIsVip(Integer isVip) {
		this.isVip = isVip;
	}
	public Date getVipStart() {
		return vipStart;
	}
	public void setVipStart(Date vipStart) {
		this.vipStart = vipStart;
	}
	public Date getVipEnd() {
		return vipEnd;
	}
	public void setVipEnd(Date vipEnd) {
		this.vipEnd = vipEnd;
	}
	public Integer getAvatarHeadId() {
		return avatarHeadId;
	}
	public void setAvatarHeadId(Integer avatarHeadId) {
		this.avatarHeadId = avatarHeadId;
	}
	public Integer getTroopVictoryNumber() {
		return troopVictoryNumber;
	}
	public void setTroopVictoryNumber(Integer troopVictoryNumber) {
		this.troopVictoryNumber = troopVictoryNumber;
	}
	public Integer getConsortiaVictoryNumber() {
		return consortiaVictoryNumber;
	}
	public void setConsortiaVictoryNumber(Integer consortiaVictoryNumber) {
		this.consortiaVictoryNumber = consortiaVictoryNumber;
	}
	public Integer getDailyNumber() {
		return dailyNumber;
	}
	public void setDailyNumber(Integer dailyNumber) {
		this.dailyNumber = dailyNumber;
	}
	public Integer getBattleVictoryNumber() {
		return battleVictoryNumber;
	}
	public void setBattleVictoryNumber(Integer battleVictoryNumber) {
		this.battleVictoryNumber = battleVictoryNumber;
	}
	public Integer getAvatarClothesId() {
		return avatarClothesId;
	}
	public void setAvatarClothesId(Integer avatarClothesId) {
		this.avatarClothesId = avatarClothesId;
	}
	public Integer getRoleFatigue() {
		return roleFatigue;
	}
	public void setRoleFatigue(Integer roleFatigue) {
		this.roleFatigue = roleFatigue;
	}
	public Integer getRoleFatigueFuntime() {
		return roleFatigueFuntime;
	}
	public void setRoleFatigueFuntime(Integer roleFatigueFuntime) {
		this.roleFatigueFuntime = roleFatigueFuntime;
	}
	public Integer getRoleBattleBonus() {
		return roleBattleBonus;
	}
	public void setRoleBattleBonus(Integer roleBattleBonus) {
		this.roleBattleBonus = roleBattleBonus;
	}

	public Integer getAddExpPer() {
		return addExpPer;
	}
	public void setAddExpPer(Integer addExpPer) {
		this.addExpPer = addExpPer;
	}
	public Integer getRolePackageNum() {
		return rolePackageNum;
	}
	public void setRolePackageNum(Integer rolePackageNum) {
		this.rolePackageNum = rolePackageNum;
	}
	public Date getDekickTimeStart() {
		return dekickTimeStart;
	}
	public void setDekickTimeStart(Date dekickTimeStart) {
		this.dekickTimeStart = dekickTimeStart;
	}
	public Date getDekickTimeEnd() {
		return dekickTimeEnd;
	}
	public void setDekickTimeEnd(Date dekickTimeEnd) {
		this.dekickTimeEnd = dekickTimeEnd;
	}
	public Date getAddExpTimeStart() {
		return addExpTimeStart;
	}
	public void setAddExpTimeStart(Date addExpTimeStart) {
		this.addExpTimeStart = addExpTimeStart;
	}
	public Date getAddExpTimeEnd() {
		return addExpTimeEnd;
	}
	public void setAddExpTimeEnd(Date addExpTimeEnd) {
		this.addExpTimeEnd = addExpTimeEnd;
	}
	public String getCTime() {
		return cTime;
	}
	public void setCTime(String time) {
		cTime = time;
	}
}
