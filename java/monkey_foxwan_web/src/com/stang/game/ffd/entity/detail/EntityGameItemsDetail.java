package com.stang.game.ffd.entity.detail;

import java.util.Date;

/**
 * @author jianbo.feng 
 * @company 上海三唐信息科技有限公司
 * @description 战斗性道具信息
 */
public class EntityGameItemsDetail {

	private Integer id;			/*主键，序列号*/
	private Integer itemType;	/*道具类型(0:战斗,1:强化,2:合成,3:防爆,4:幸运,5:催化剂,6:图,7:宝箱,41:矿石,23:炸弹,26:强心针)*/
	private String itemName;	/*道具名称*/
	private String itemRes;		/*资源名称*/
	private String itemProp;	/*道具说明*/
	private Integer coinBuy;	/*金币购买价格*/
	private Integer rmbBuy;		/*点券购买价格*/
	private String hpUp;		/*回复HP（h）*/
	private String hpAllup;		/*回复己方阵营HP*/
	private String oilUp;		/*增加油量(o)*/
	private String oilDown;		/*消耗油量(o)*/
	private String powerUp;		/*增加威力(p)*/
	private String agiUp;		/*增加敏捷（a）*/
	private String defUp;		/*增加防御（f）*/
	private Integer timeKeep;	/*持续时间（t） 单位：秒*/
	private Date createTime;	/*信息录入时间*/
	private Integer flag;		/*信息标识位(-1,删除;0,隐藏/关闭;1,正常)*/
	private Integer grade;		/*品级(1:白;2:绿;3:蓝;4:紫;5:金)*/
	private Integer isBind;		/*是否已绑定(0,否;1,;是)*/
	private Integer isOver;		/*是否可叠加（0/不叠加，1/可叠加）*/
	private String itemUrl;		/*动画资源地址*/
	private String meState;		/*己方状态*/
	private String fdState;		/*友方状态*/
	private Integer isMarket;	/*是否在商城中出售（0/否，1/是）*/
	private Integer isGoodFree;	/*是否为推荐或免费领取（0/否，1/推荐，2/免费会员领取，3/免费每日领取，4/免费活动领取）*/
	private Integer itemLevel;	/*道具等级*/
	private Integer isBattleGift;/*是否为战斗后赠送的为物品（0/否，1/是）*/
	private Integer equipIntensifyGold; /*合成所需金币*/
	private Integer  equipIntensiftyOdds; /*合成概率(0-100)*/
	private Integer equipWeight;	/*影响装备的重量*/
	private Integer isUse;       /*是否可以使用 0/否,1/是 */
	private Integer itemSellGold; /*出售所得金币*/
	private Integer snsMaxNum; /*收获sns物品最大数量*/
	private Integer snsGainOdds;/*收获矿石所得经验*/
	private String snsConfParam; /*配置参数*/
	private Integer snsGainSortnum; /*收获种类*/
	
	private String dcuUp;/*增加防爆*/
	private String cuUp;/*增加暴击*/
	private Integer num=0;/*数量*/
	private int sellnum=0;/* 已经使用掉的数量 */
	private String item_name_gk;
	private int taskType; /* 查询当前的礼包有没有生成为任务模式 1为启用 0为不启用 */
	
	
	public Integer getIsUse() {
		return isUse;
	}
	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getItemType() {
		return itemType;
	}
	public void setItemType(Integer itemType) {
		this.itemType = itemType;
	}

	public String getItemRes() {
		return itemRes;
	}
	public void setItemRes(String itemRes) {
		this.itemRes = itemRes;
	}

	public Integer getCoinBuy() {
		return coinBuy;
	}
	public void setCoinBuy(Integer coinBuy) {
		this.coinBuy = coinBuy;
	}
	public String getHpUp() {
		return hpUp;
	}
	public void setHpUp(String hpUp) {
		this.hpUp = hpUp;
	}
	public String getHpAllup() {
		return hpAllup;
	}
	public void setHpAllup(String hpAllup) {
		this.hpAllup = hpAllup;
	}
	public String getOilUp() {
		return oilUp;
	}
	public void setOilUp(String oilUp) {
		this.oilUp = oilUp;
	}
	public String getPowerUp() {
		return powerUp;
	}
	public void setPowerUp(String powerUp) {
		this.powerUp = powerUp;
	}
	public String getAgiUp() {
		return agiUp;
	}
	public void setAgiUp(String agiUp) {
		this.agiUp = agiUp;
	}
	public String getDefUp() {
		return defUp;
	}
	public void setDefUp(String defUp) {
		this.defUp = defUp;
	}
	public Integer getTimeKeep() {
		return timeKeep;
	}
	public void setTimeKeep(Integer timeKeep) {
		this.timeKeep = timeKeep;
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
	public Integer getIsBind() {
		return isBind;
	}
	public void setIsBind(Integer isBind) {
		this.isBind = isBind;
	}
	public Integer getRmbBuy() {
		return rmbBuy;
	}
	public void setRmbBuy(Integer rmbBuy) {
		this.rmbBuy = rmbBuy;
	}
	public Integer getIsOver() {
		return isOver;
	}
	public void setIsOver(Integer isOver) {
		this.isOver = isOver;
	}
	public String getItemUrl() {
		return itemUrl;
	}
	public void setItemUrl(String itemUrl) {
		this.itemUrl = itemUrl;
	}
	public String getMeState() {
		return meState;
	}
	public void setMeState(String meState) {
		this.meState = meState;
	}
	public String getFdState() {
		return fdState;
	}
	public void setFdState(String fdState) {
		this.fdState = fdState;
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
	public Integer getItemLevel() {
		return itemLevel;
	}
	public void setItemLevel(Integer itemLevel) {
		this.itemLevel = itemLevel;
	}
	public Integer getIsBattleGift() {
		return isBattleGift;
	}
	public void setIsBattleGift(Integer isBattleGift) {
		this.isBattleGift = isBattleGift;
	}
	public Integer getEquipIntensifyGold() {
		return equipIntensifyGold;
	}
	public void setEquipIntensifyGold(Integer equipIntensifyGold) {
		this.equipIntensifyGold = equipIntensifyGold;
	}
	public Integer getEquipIntensiftyOdds() {
		return equipIntensiftyOdds;
	}
	public void setEquipIntensiftyOdds(Integer equipIntensiftyOdds) {
		this.equipIntensiftyOdds = equipIntensiftyOdds;
	}
	public Integer getEquipWeight() {
		return equipWeight;
	}
	public void setEquipWeight(Integer equipWeight) {
		this.equipWeight = equipWeight;
	}
	public String getOilDown() {
		return oilDown;
	}
	public void setOilDown(String oilDown) {
		this.oilDown = oilDown;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemProp() {
		return itemProp;
	}
	public void setItemProp(String itemProp) {
		this.itemProp = itemProp;
	}
	public Integer getItemSellGold() {
		return itemSellGold;
	}
	public void setItemSellGold(Integer itemSellGold) {
		this.itemSellGold = itemSellGold;
	}
	public Integer getSnsMaxNum() {
		return snsMaxNum;
	}
	public void setSnsMaxNum(Integer snsMaxNum) {
		this.snsMaxNum = snsMaxNum;
	}
	public Integer getSnsGainOdds() {
		return snsGainOdds;
	}
	public void setSnsGainOdds(Integer snsGainOdds) {
		this.snsGainOdds = snsGainOdds;
	}
	public String getSnsConfParam() {
		return snsConfParam;
	}
	public void setSnsConfParam(String snsConfParam) {
		this.snsConfParam = snsConfParam;
	}
	public Integer getSnsGainSortnum() {
		return snsGainSortnum;
	}
	public void setSnsGainSortnum(Integer snsGainSortnum) {
		this.snsGainSortnum = snsGainSortnum;
	}
	public String getDcuUp() {
		return dcuUp;
	}
	public void setDcuUp(String dcuUp) {
		this.dcuUp = dcuUp;
	}

	public String getCuUp() {
		return cuUp;
	}
	public void setCuUp(String cuUp) {
		this.cuUp = cuUp;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public int getSellnum() {
		return sellnum;
	}
	public void setSellnum(int sellnum) {
		this.sellnum = sellnum;
	}
	public String getItem_name_gk() {
		return item_name_gk;
	}
	public void setItem_name_gk(String item_name_gk) {
		this.item_name_gk = item_name_gk;
	}
	public int getTaskType() {
		return taskType;
	}
	public void setTaskType(int taskType) {
		this.taskType = taskType;
	}
	
}
