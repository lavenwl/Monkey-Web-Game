package com.stang.game.ffd.entity.detail;

import java.util.Date;

/**
 * @author jianbo.feng
 * @company 上海三唐信息科技有限公司 
 * @description 游戏(飞机)装备信息表
 */
public class EntityGameEquipDetail {

	private Integer id;			/*序列号*/
	private String equipName;	/*装备名称*/
	private String equipDesc;	/*装备描述*/
	private Integer starLevel;	/*星级*/
	private Integer equipType;	/*装备类型(0,武器;1,装甲)*/
	private String equipRes;	/*资源名称*/
	private Integer equipLevel;	/*装备等级(默认值：0)*/
	private Integer strengthenLevel;	/*强化等级(默认值：0)*/
	private String boomRes;		/*爆炸动画特效资源*/
	private String boomSize;	/*爆炸半径*/
	private Integer rangeY;		/*攻击范围纵向：导弹可攻击Y轴的最大距离*/
	private Integer rangeX;		/*攻击范围横向：导弹攻击的X轴最大距离*/
	private Integer equipWeight;/*重量(影响飞机的移动距离（油耗）)*/
	private Integer equipAtk;	/*攻击(计算伤害值，与飞机属性叠加)*/
	private Integer equipAgi;	/*速度(计算回合先手，与飞机属性叠加)*/
	private Integer equipDef;	/*防御(减免伤害，与飞机属性叠加)*/
	private Integer equipHp;	/*增加血量(增加飞机血上限，与飞机属性叠加)*/
	private Integer equipDur;	/*耐久度(每发射一次导弹消耗一定量耐久度,耐久度为0时，武器损坏，属性为空)*/
	private Integer equipBind;	/*是否为装备绑定(装备绑定的道具则为使用后绑定飞机，否则为可与玩家交易状态)0:否;1:是;*/
	private Integer equipConsume;	/*是否耐久消耗(该装备是否会消耗耐久)0:否;1:是;*/
	private Integer coinBuy;	/*游戏币购买价格*/
	private Integer rmbBuy;		/*点券购买价格*/
	private Integer storeTime;	/*存留时间（装备保存时间-基本为点券类道具）*/
	private Integer equipForever;	/*是否为永久装备（永久道具-无时限）0:否;1:是;*/
	private String equipWeightPropAdd;	/*鉴定后重量(影响飞机的移动距离（油耗）)（w）*/
	private String equipAtkPropAdd;	/*鉴定后攻击(计算伤害值，与飞机属性叠加性)（a）*/
	private String equipAgiPropAdd;	/*鉴定后速度(计算回合先手，与飞机属性叠加)（s）*/
	private String equipDefPropAdd;	/*鉴定后防御(减免伤害，与飞机属性叠加)（f）*/
	private String equipDurPropAdd;	/*鉴定后耐久度(每发射一次导弹消耗一定量耐久度,耐久度为0时，武器损坏，属性为空)（d）*/
	private String equipHpPropAdd;	/*鉴定后增加血量(增加飞机血上限，与飞机属性叠加)（h）*/
	private String strengthenWeightPropAdd;	/*每强化递增一级负重值加成*/
	private String strengthenAtkPropAdd;	/*每强化递增一级攻击值加成*/
	private String strengthenAgiPropAdd;	/*每强化递增一级敏捷值加成*/
	private String strengthenDefPropAdd;	/*每强化递增一级防御值加成*/
	private String strengthenDurPropAdd;	/*每强化递增一级耐久值加成*/
	private String strengthenHpPropAdd;		/*每强化递增一级血量值加成*/
	private Date createTime;	/*信息录入时间*/
	private Integer flag;		/*信息标识位(-1,删除;0,隐藏;1,正常)*/
	private Integer grade;			/*品级(1:白;2:绿;3:蓝;4:紫;5:金)*/
	private String equipRes2;	/*正面资源名称*/
	private Integer isMarket;	/*是否在商城出售（0/否，1/是）*/
	private Integer isGoodFree;	/*是否为推荐或免费领取（0/否，1/推荐，2/免费会员领取，3/免费每日领取，4/免费活动领取）*/
	private Integer isBattleGift;/*是否为战斗后赠送的为物品（0/否，1/是）*/
	private String equipArmType; /*武器类型 (0:近程导弹,1:中程导弹)*/
	private String equipArmPrecision; /*武器准确度*/
	private Integer equipSellGold; /*出售所得金币*/
	private Integer num=0;/* 数量 */
	private Integer sellNum=0;// 销售业绩
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStarLevel() {
		return starLevel;
	}
	public void setStarLevel(Integer starLevel) {
		this.starLevel = starLevel;
	}
	public Integer getEquipType() {
		return equipType;
	}
	public void setEquipType(Integer equipType) {
		this.equipType = equipType;
	}
	public String getEquipRes() {
		return equipRes;
	}
	public void setEquipRes(String equipRes) {
		this.equipRes = equipRes;
	}
	public Integer getEquipLevel() {
		return equipLevel;
	}
	public void setEquipLevel(Integer equipLevel) {
		this.equipLevel = equipLevel;
	}
	public Integer getStrengthenLevel() {
		return strengthenLevel;
	}
	public void setStrengthenLevel(Integer strengthenLevel) {
		this.strengthenLevel = strengthenLevel;
	}
	public String getBoomRes() {
		return boomRes;
	}
	public void setBoomRes(String boomRes) {
		this.boomRes = boomRes;
	}
	public String getBoomSize() {
		return boomSize;
	}
	public void setBoomSize(String boomSize) {
		this.boomSize = boomSize;
	}
	public Integer getRangeY() {
		return rangeY;
	}
	public void setRangeY(Integer rangeY) {
		this.rangeY = rangeY;
	}
	public Integer getRangeX() {
		return rangeX;
	}
	public void setRangeX(Integer rangeX) {
		this.rangeX = rangeX;
	}
	public Integer getEquipWeight() {
		return equipWeight;
	}
	public void setEquipWeight(Integer equipWeight) {
		this.equipWeight = equipWeight;
	}
	public Integer getEquipAtk() {
		return equipAtk;
	}
	public void setEquipAtk(Integer equipAtk) {
		this.equipAtk = equipAtk;
	}
	public Integer getEquipAgi() {
		return equipAgi;
	}
	public void setEquipAgi(Integer equipAgi) {
		this.equipAgi = equipAgi;
	}
	public Integer getEquipDef() {
		return equipDef;
	}
	public void setEquipDef(Integer equipDef) {
		this.equipDef = equipDef;
	}
	public Integer getEquipHp() {
		return equipHp;
	}
	public void setEquipHp(Integer equipHp) {
		this.equipHp = equipHp;
	}
	public Integer getEquipDur() {
		return equipDur;
	}
	public void setEquipDur(Integer equipDur) {
		this.equipDur = equipDur;
	}
	public Integer getEquipBind() {
		return equipBind;
	}
	public void setEquipBind(Integer equipBind) {
		this.equipBind = equipBind;
	}
	public Integer getEquipConsume() {
		return equipConsume;
	}
	public void setEquipConsume(Integer equipConsume) {
		this.equipConsume = equipConsume;
	}
	public Integer getCoinBuy() {
		return coinBuy;
	}
	public void setCoinBuy(Integer coinBuy) {
		this.coinBuy = coinBuy;
	}
	public Integer getRmbBuy() {
		return rmbBuy;
	}
	public void setRmbBuy(Integer rmbBuy) {
		this.rmbBuy = rmbBuy;
	}
	public Integer getStoreTime() {
		return storeTime;
	}
	public void setStoreTime(Integer storeTime) {
		this.storeTime = storeTime;
	}
	public Integer getEquipForever() {
		return equipForever;
	}
	public void setEquipForever(Integer equipForever) {
		this.equipForever = equipForever;
	}
	public String getEquipWeightPropAdd() {
		return equipWeightPropAdd;
	}
	public void setEquipWeightPropAdd(String equipWeightPropAdd) {
		this.equipWeightPropAdd = equipWeightPropAdd;
	}
	public String getEquipAtkPropAdd() {
		return equipAtkPropAdd;
	}
	public void setEquipAtkPropAdd(String equipAtkPropAdd) {
		this.equipAtkPropAdd = equipAtkPropAdd;
	}
	public String getEquipAgiPropAdd() {
		return equipAgiPropAdd;
	}
	public void setEquipAgiPropAdd(String equipAgiPropAdd) {
		this.equipAgiPropAdd = equipAgiPropAdd;
	}
	public String getEquipDefPropAdd() {
		return equipDefPropAdd;
	}
	public void setEquipDefPropAdd(String equipDefPropAdd) {
		this.equipDefPropAdd = equipDefPropAdd;
	}
	public String getEquipDurPropAdd() {
		return equipDurPropAdd;
	}
	public void setEquipDurPropAdd(String equipDurPropAdd) {
		this.equipDurPropAdd = equipDurPropAdd;
	}
	public String getEquipHpPropAdd() {
		return equipHpPropAdd;
	}
	public void setEquipHpPropAdd(String equipHpPropAdd) {
		this.equipHpPropAdd = equipHpPropAdd;
	}
	public String getStrengthenWeightPropAdd() {
		return strengthenWeightPropAdd;
	}
	public void setStrengthenWeightPropAdd(String strengthenWeightPropAdd) {
		this.strengthenWeightPropAdd = strengthenWeightPropAdd;
	}
	public String getStrengthenAtkPropAdd() {
		return strengthenAtkPropAdd;
	}
	public void setStrengthenAtkPropAdd(String strengthenAtkPropAdd) {
		this.strengthenAtkPropAdd = strengthenAtkPropAdd;
	}
	public String getStrengthenAgiPropAdd() {
		return strengthenAgiPropAdd;
	}
	public void setStrengthenAgiPropAdd(String strengthenAgiPropAdd) {
		this.strengthenAgiPropAdd = strengthenAgiPropAdd;
	}
	public String getStrengthenDefPropAdd() {
		return strengthenDefPropAdd;
	}
	public void setStrengthenDefPropAdd(String strengthenDefPropAdd) {
		this.strengthenDefPropAdd = strengthenDefPropAdd;
	}
	public String getStrengthenDurPropAdd() {
		return strengthenDurPropAdd;
	}
	public void setStrengthenDurPropAdd(String strengthenDurPropAdd) {
		this.strengthenDurPropAdd = strengthenDurPropAdd;
	}
	public String getStrengthenHpPropAdd() {
		return strengthenHpPropAdd;
	}
	public void setStrengthenHpPropAdd(String strengthenHpPropAdd) {
		this.strengthenHpPropAdd = strengthenHpPropAdd;
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
	public String getEquipRes2() {
		return equipRes2;
	}
	public void setEquipRes2(String equipRes2) {
		this.equipRes2 = equipRes2;
	}
	public Integer getIsMarket() {
		return isMarket;
	}
	public void setIsMarket(Integer isMarket) {
		this.isMarket = isMarket;
	}
	public Integer getIsGoodFree() {
		return isGoodFree;
	}
	public void setIsGoodFree(Integer isGoodFree) {
		this.isGoodFree = isGoodFree;
	}
	public Integer getIsBattleGift() {
		return isBattleGift;
	}
	public void setIsBattleGift(Integer isBattleGift) {
		this.isBattleGift = isBattleGift;
	}
	public String getEquipArmType() {
		return equipArmType;
	}
	public void setEquipArmType(String equipArmType) {
		this.equipArmType = equipArmType;
	}
	public String getEquipArmPrecision() {
		return equipArmPrecision;
	}
	public void setEquipArmPrecision(String equipArmPrecision) {
		this.equipArmPrecision = equipArmPrecision;
	}
	public String getEquipName() {
		return equipName;
	}
	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}
	public String getEquipDesc() {
		return equipDesc;
	}
	public void setEquipDesc(String equipDesc) {
		this.equipDesc = equipDesc;
	}
	public Integer getEquipSellGold() {
		return equipSellGold;
	}
	public void setEquipSellGold(Integer equipSellGold) {
		this.equipSellGold = equipSellGold;
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
