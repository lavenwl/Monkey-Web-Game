package com.stang.game.ffd.entity.detail;

import java.util.Date;

/**
 * @author jianbo.feng
 * @company 上海三唐信息科技有限公司
 * @description 装饰信息(不可强化) 
 */
public class EntityGameAvatarDetail {

	private Integer id;			/*序列号*/
	private String avatarName;	/*装饰标题或名称*/
	private String avatarRes;	/*资源名称*/
	private Integer avatarType;	/*AVATAR部位(1帽子-hat；2发型-hair；3耳环-earring；4配件(即眼部装饰)-eye；5表情-face；6衣服-clothes；7鞋子-shoe；91戒子-ring；8项链-necklace；9翅膀-wings;20嘴-mouth，21耳朵-ear，22身体-body，23头-head)*/
	private Integer isWhole;	/*是否为套装(0:否;1:是;默认值：0)*/
	private Integer isFashion;	/*是否为时装(0:否;1:是;默认值：0)*/
	private Integer avatarSex;	/*AVATAR性别（0共用1男2女）*/
	private Integer rmbBuy;		/*消费点券*/
	private Integer coinBuy;	/*消费游戏币*/
	private Integer storeTime;	/*时效时间*/
	private Integer avatarBind;	/*是否为绑定装饰*/
	private Integer avatarForever;		/*是否为永久*/
	private Integer avatarLevel;		/*装饰等级(暂未定)*/
	private Integer strengthenLevel;	/*强化等级(默认值：0)*/
	private Integer addPower;	/*增加角色力量(未鉴定时基础值)*/
	private Integer addAgility;	/*增加角色敏捷(未鉴定时基础值)*/
	private Integer addStamina;	/*增加角色耐力(未鉴定时基础值)*/
	private Integer addMana;	/*增加精神值(未鉴定时基础值)*/
	private String avatarPowerPropAdd;	/*鉴定后力量(p)值加成*/
	private String avatarAgilityPropAdd;/*鉴定后敏捷(a)值加成*/
	private String avatarStaminaPropAdd;/*鉴定后耐力(s)值加成*/
	private String avatarManaPropAdd;	/*鉴定后精神(m)值加成*/
	private String strengthenPowerPropAdd;	/*每强化递增一级力量值加成*/
	private String strengthenAgilityPropAdd;/*每强化递增一级敏捷值加成*/
	private String strengthenStaminaPropAdd;/*每强化递增一级耐力值加成*/
	private String strengthenManaPropAdd;	/*每强化递增一级精神值加成*/
	private Date createTime;	/*信息录入时间*/
	private Integer flag;		/*信息标识位,默认值为1(-1,删除;0,隐藏;1,正常;)*/
	private Integer grade;			/*品级(1:白;2:绿;3:蓝;4:紫;5:金)*/
	private Integer race;		/*种族(0:混穿/公用；1：精灵；2：恶魔；3：人类)*/
	private Integer isShow;		/*是否显示(0,不显示;1,显示)*/
	private String avatarRes2;	/*正面资源名称*/
	private Integer isMarket;	/*是否在商城出售（0/否，1/是）*/
	private String avatarDh;	/*动画资源地址*/
	private Integer isGoodFree;	/*是否为推荐或免费领取（0/否，1/推荐，2/免费会员领取，3/免费每日领取，4/免费活动领取）*/
	private Integer isBase;		/*是否为基础配置（0/否，1/是,2/是美容院使用）*/
	private Integer isBattleGift;/*是否为战斗后赠送的为物品（0/否，1/是）*/
	private Integer avatarSellGold;/*出售所得金币*/
	private Integer num=0;//数量
	private Integer sellNum=0;//使用的数量
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAvatarRes() {
		return avatarRes;
	}
	public void setAvatarRes(String avatarRes) {
		this.avatarRes = avatarRes;
	}
	public Integer getAvatarType() {
		return avatarType;
	}
	public void setAvatarType(Integer avatarType) {
		this.avatarType = avatarType;
	}
	public Integer getIsWhole() {
		return isWhole;
	}
	public void setIsWhole(Integer isWhole) {
		this.isWhole = isWhole;
	}
	public Integer getIsFashion() {
		return isFashion;
	}
	public void setIsFashion(Integer isFashion) {
		this.isFashion = isFashion;
	}
	public Integer getAvatarSex() {
		return avatarSex;
	}
	public void setAvatarSex(Integer avatarSex) {
		this.avatarSex = avatarSex;
	}
	public Integer getRmbBuy() {
		return rmbBuy;
	}
	public void setRmbBuy(Integer rmbBuy) {
		this.rmbBuy = rmbBuy;
	}
	public Integer getCoinBuy() {
		return coinBuy;
	}
	public void setCoinBuy(Integer coinBuy) {
		this.coinBuy = coinBuy;
	}
	public Integer getStoreTime() {
		return storeTime;
	}
	public void setStoreTime(Integer storeTime) {
		this.storeTime = storeTime;
	}
	public Integer getAvatarBind() {
		return avatarBind;
	}
	public void setAvatarBind(Integer avatarBind) {
		this.avatarBind = avatarBind;
	}
	public Integer getAvatarForever() {
		return avatarForever;
	}
	public void setAvatarForever(Integer avatarForever) {
		this.avatarForever = avatarForever;
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
	public Integer getAddPower() {
		return addPower;
	}
	public void setAddPower(Integer addPower) {
		this.addPower = addPower;
	}
	public Integer getAddAgility() {
		return addAgility;
	}
	public void setAddAgility(Integer addAgility) {
		this.addAgility = addAgility;
	}
	public Integer getAddStamina() {
		return addStamina;
	}
	public void setAddStamina(Integer addStamina) {
		this.addStamina = addStamina;
	}
	public Integer getAddMana() {
		return addMana;
	}
	public void setAddMana(Integer addMana) {
		this.addMana = addMana;
	}
	public String getAvatarPowerPropAdd() {
		return avatarPowerPropAdd;
	}
	public void setAvatarPowerPropAdd(String avatarPowerPropAdd) {
		this.avatarPowerPropAdd = avatarPowerPropAdd;
	}
	public String getAvatarAgilityPropAdd() {
		return avatarAgilityPropAdd;
	}
	public void setAvatarAgilityPropAdd(String avatarAgilityPropAdd) {
		this.avatarAgilityPropAdd = avatarAgilityPropAdd;
	}
	public String getAvatarStaminaPropAdd() {
		return avatarStaminaPropAdd;
	}
	public void setAvatarStaminaPropAdd(String avatarStaminaPropAdd) {
		this.avatarStaminaPropAdd = avatarStaminaPropAdd;
	}
	public String getAvatarManaPropAdd() {
		return avatarManaPropAdd;
	}
	public void setAvatarManaPropAdd(String avatarManaPropAdd) {
		this.avatarManaPropAdd = avatarManaPropAdd;
	}
	public String getStrengthenPowerPropAdd() {
		return strengthenPowerPropAdd;
	}
	public void setStrengthenPowerPropAdd(String strengthenPowerPropAdd) {
		this.strengthenPowerPropAdd = strengthenPowerPropAdd;
	}
	public String getStrengthenAgilityPropAdd() {
		return strengthenAgilityPropAdd;
	}
	public void setStrengthenAgilityPropAdd(String strengthenAgilityPropAdd) {
		this.strengthenAgilityPropAdd = strengthenAgilityPropAdd;
	}
	public String getStrengthenStaminaPropAdd() {
		return strengthenStaminaPropAdd;
	}
	public void setStrengthenStaminaPropAdd(String strengthenStaminaPropAdd) {
		this.strengthenStaminaPropAdd = strengthenStaminaPropAdd;
	}
	public String getStrengthenManaPropAdd() {
		return strengthenManaPropAdd;
	}
	public void setStrengthenManaPropAdd(String strengthenManaPropAdd) {
		this.strengthenManaPropAdd = strengthenManaPropAdd;
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
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public Integer getRace() {
		return race;
	}
	public void setRace(Integer race) {
		this.race = race;
	}
	public Integer getIsShow() {
		return isShow;
	}
	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}
	public String getAvatarRes2() {
		return avatarRes2;
	}
	public void setAvatarRes2(String avatarRes2) {
		this.avatarRes2 = avatarRes2;
	}
	public Integer getIsMarket() {
		return isMarket;
	}
	public void setIsMarket(Integer isMarket) {
		this.isMarket = isMarket;
	}
	public String getAvatarDh() {
		return avatarDh;
	}
	public void setAvatarDh(String avatarDh) {
		this.avatarDh = avatarDh;
	}
	public Integer getIsGoodFree() {
		return isGoodFree;
	}
	public void setIsGoodFree(Integer isGoodFree) {
		this.isGoodFree = isGoodFree;
	}
	public Integer getIsBase() {
		return isBase;
	}
	public void setIsBase(Integer isBase) {
		this.isBase = isBase;
	}
	public String getAvatarName() {
		return avatarName;
	}
	public void setAvatarName(String avatarName) {
		this.avatarName = avatarName;
	}
	public Integer getIsBattleGift() {
		return isBattleGift;
	}
	public void setIsBattleGift(Integer isBattleGift) {
		this.isBattleGift = isBattleGift;
	}
	public Integer getAvatarSellGold() {
		return avatarSellGold;
	}
	public void setAvatarSellGold(Integer avatarSellGold) {
		this.avatarSellGold = avatarSellGold;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getSellNum() {
		return sellNum;
	}
	public void setSellNum(Integer sellNum) {
		this.sellNum = sellNum;
	}
}
