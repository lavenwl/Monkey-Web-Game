package com.stang.game.ffd.entity.detail;

import java.util.Date;

/**
 * @author jianbo.feng 
 * @company 上海三唐信息科技有限公司
 * @description 飞机(模型/基本)信息
 */
public class EntityGamePlaneDetail {

	private Integer id;				/*序列号*/
	private Integer isBind;			/*是否已绑定(0:未;1;绑定)*/
	private Integer pbookId;		/*图鉴ID*/
	private String planeName;		/*飞机名称*/
	private String planeDesc;		/*飞机描述*/
	private String planeRes;		/*飞机(对应)资源名称*/
	private Integer planeType;		/*飞机类型(0:直升机;1:战斗机;2:侦察机)*/
	private Integer planeStar;		/*飞机星级(强化前)*/
	private Integer planeAtk;		/*攻击值(未鉴定状态)*/
	private Integer planeDef;		/*防御值(未鉴定状态)*/
	private Integer planeAgi;		/*速度值(未鉴定状态)*/
	private Integer planeHp;		/*体力值(未鉴定状态)*/
	private Integer planeWeight;	/*负重上限(未鉴定状态)*/
	private Integer planeOil;		/*储油量(未鉴定状态)*/
	private String planeAtkPropAdd;	/*鉴定后攻击加成值（a）*/
	private String planeDefPropAdd;	/*鉴定后防御加成值(f)*/
	private String planeAgiPropAdd;	/*鉴定后速度加成值(s)*/
	private String planeHpPropAdd;	/*鉴定后体力加成值(h)*/
	private String planeWeightPropAdd;	/*鉴定后负重加成值(w)*/
	private String planeOilPropAdd;	/*鉴定后油量加成值(o)*/
	private Date createTime;		/*信息录入时间*/
	private Integer flag;			/*信息标识位(-1,删除;0,隐藏;1,正常;)*/
	private Integer grade;			/*品级(1:白;2:绿;3:蓝;4:紫;5:金)*/
	private String planeRes2;		/*飞机正面资源名称*/
	private Integer planeLevel;		/*飞机等级*/
	private String planeAtkX;		/*飞机攻击范围(X轴)*/
	private String planeAtkY;		/*飞机攻击范围(Y轴)*/
	private Integer coinBuy;		/*购买所需金币数*/
	private Integer rmbBuy;			/*购买所需点券数*/
	private Integer isBase;			/*是否为每个角色的基本飞机(不可以取下来只能换,不可出售);0-否;1-是*/
	private Integer isMarket;	/*是否在商城出售（0/否，1/是）*/
	private Integer isGoodFree;	/*是否为推荐或免费领取（0/否，1/推荐，2/免费会员领取，3/免费每日领取，4/免费活动领取）*/
	private Integer isBattleGift;/*是否为战斗后赠送的为物品（0/否，1/是）*/
	private Integer planeSellGold;/*出售所得金币*/
	private Integer num=0;/* 当前销量 */
	private Integer sellNum=0;/* 当前消耗量  */
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIsBind() {
		return isBind;
	}
	public void setIsBind(Integer isBind) {
		this.isBind = isBind;
	}
	public Integer getPbookId() {
		return pbookId;
	}
	public void setPbookId(Integer pbookId) {
		this.pbookId = pbookId;
	}
	public String getPlaneName() {
		return planeName;
	}
	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}
	public String getPlaneDesc() {
		return planeDesc;
	}
	public void setPlaneDesc(String planeDesc) {
		this.planeDesc = planeDesc;
	}
	public String getPlaneRes() {
		return planeRes;
	}
	public void setPlaneRes(String planeRes) {
		this.planeRes = planeRes;
	}
	public Integer getPlaneType() {
		return planeType;
	}
	public void setPlaneType(Integer planeType) {
		this.planeType = planeType;
	}
	public Integer getPlaneStar() {
		return planeStar;
	}
	public void setPlaneStar(Integer planeStar) {
		this.planeStar = planeStar;
	}
	public Integer getPlaneAtk() {
		return planeAtk;
	}
	public void setPlaneAtk(Integer planeAtk) {
		this.planeAtk = planeAtk;
	}
	public Integer getPlaneDef() {
		return planeDef;
	}
	public void setPlaneDef(Integer planeDef) {
		this.planeDef = planeDef;
	}
	public Integer getPlaneAgi() {
		return planeAgi;
	}
	public void setPlaneAgi(Integer planeAgi) {
		this.planeAgi = planeAgi;
	}
	public Integer getPlaneHp() {
		return planeHp;
	}
	public void setPlaneHp(Integer planeHp) {
		this.planeHp = planeHp;
	}
	public Integer getPlaneWeight() {
		return planeWeight;
	}
	public void setPlaneWeight(Integer planeWeight) {
		this.planeWeight = planeWeight;
	}
	public Integer getPlaneOil() {
		return planeOil;
	}
	public void setPlaneOil(Integer planeOil) {
		this.planeOil = planeOil;
	}
	public String getPlaneAtkPropAdd() {
		return planeAtkPropAdd;
	}
	public void setPlaneAtkPropAdd(String planeAtkPropAdd) {
		this.planeAtkPropAdd = planeAtkPropAdd;
	}
	public String getPlaneDefPropAdd() {
		return planeDefPropAdd;
	}
	public void setPlaneDefPropAdd(String planeDefPropAdd) {
		this.planeDefPropAdd = planeDefPropAdd;
	}
	public String getPlaneAgiPropAdd() {
		return planeAgiPropAdd;
	}
	public void setPlaneAgiPropAdd(String planeAgiPropAdd) {
		this.planeAgiPropAdd = planeAgiPropAdd;
	}
	public String getPlaneHpPropAdd() {
		return planeHpPropAdd;
	}
	public void setPlaneHpPropAdd(String planeHpPropAdd) {
		this.planeHpPropAdd = planeHpPropAdd;
	}
	public String getPlaneWeightPropAdd() {
		return planeWeightPropAdd;
	}
	public void setPlaneWeightPropAdd(String planeWeightPropAdd) {
		this.planeWeightPropAdd = planeWeightPropAdd;
	}
	public String getPlaneOilPropAdd() {
		return planeOilPropAdd;
	}
	public void setPlaneOilPropAdd(String planeOilPropAdd) {
		this.planeOilPropAdd = planeOilPropAdd;
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
	public String getPlaneRes2() {
		return planeRes2;
	}
	public void setPlaneRes2(String planeRes2) {
		this.planeRes2 = planeRes2;
	}
	public Integer getPlaneLevel() {
		return planeLevel;
	}
	public void setPlaneLevel(Integer planeLevel) {
		this.planeLevel = planeLevel;
	}
	public String getPlaneAtkX() {
		return planeAtkX;
	}
	public void setPlaneAtkX(String planeAtkX) {
		this.planeAtkX = planeAtkX;
	}
	public String getPlaneAtkY() {
		return planeAtkY;
	}
	public void setPlaneAtkY(String planeAtkY) {
		this.planeAtkY = planeAtkY;
	}
	public Integer getIsBase() {
		return isBase;
	}
	public void setIsBase(Integer isBase) {
		this.isBase = isBase;
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
	public Integer getPlaneSellGold() {
		return planeSellGold;
	}
	public void setPlaneSellGold(Integer planeSellGold) {
		this.planeSellGold = planeSellGold;
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
