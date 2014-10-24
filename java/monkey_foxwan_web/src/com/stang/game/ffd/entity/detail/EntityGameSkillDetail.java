package com.stang.game.ffd.entity.detail;

import java.util.Date;

/**
 * @author jianbo.feng 
 * @company 上海三唐信息科技有限公司
 * @description 技能信息
 */
public class EntityGameSkillDetail {

	private Integer id;		/*序列号*/
	private String skillCode;	/*技能编码*/
	private String skillName;	/*技能名称*/
	private String skillDesc;	/*技能描述*/
	private String skillIcon;	/*图标资源*/
	private String skillMeclip;	/*已方效果资源*/
	private String skillToclip;	/*对方效果资源*/
	private Integer skillEthnicity;	/*技能对应的种族(0,公共;1,精灵;2,恶魔;3,人类)*/
	private Integer skillDeparttype;/*技能对应的系(0,公共)*/
	private Integer skillActive;	/*是否主动(0,否;1,是)*/
	private Integer skillMpcost;	/*消耗魔法值*/
	private String skillMppercost;	/*魔法值消耗比例*/
	private Integer skillMaxlevel;	/*技能最高等级*/
	private Integer skillNeedlv;	/*等级要求*/
	private Integer skillNeedrank;	/*军衔要求 (1,菜鸟学员;2,初级学员;3,中级学员;4,高级学员;5,初级飞行员;
		6,中级飞行员;7,高级飞行员;8,初级飞行专家;9,中级飞行专家;10,高级飞行专家;
		11,王牌飞行员;12,王牌飞行员;13,飞行少尉;14,飞行少尉;15,飞行中尉;
		16,飞行中尉;17,飞行上尉;18,飞行上尉;19,飞行少校;20,飞行少校;
		21,飞行中校;22,飞行中校;23,飞行上校;24,飞行上校;25,飞行少将;
		26,飞行少将;27,飞行中将;28,飞行中将;29,飞行上将30,飞行上将)*/
	private String skillTargettype;	/*释放目标类型*/
	private Integer skillLv;		/*技能等级*/
	private Integer skillCd;		/*技能冷却*/
	private Integer skillPoint;		/*学习此技能所需技能点*/
	private Integer skillNeedmoney;	/*技能学习所需金钱*/
	private Integer skillNeedcoin;	/*学习所需点卷*/
	private String skillNeedskills;	/*学习所需技能*/
	private String skillCleartypestate;	/*清除目标某类型状态*/
	private String skillClearstate;	/*清除目标状态*/
	private String skillMestate;	/*己方状态*/
	private String skillFdstate;	/*友方状态*/
	private String skillEnstate;	/*敌方目标状态*/
	private String skillEnallstate;	/*敌方友军状态*/
	private Integer skillPower;		/*增加力量值*/
	private Integer skillAgility;	/*增加敏捷值*/
	private Integer skillStamina;	/*增加耐力值*/
	private Integer skillSpirit;	/*增加精神值*/
	private Date createTime;		/*信息录入时间*/
	private Integer flag;			/*信息标识位(-1,删除;0,隐藏;1,正常)*/
	private String skillBeacon;     /*信标影响范围*/
	private String skillNeedbuffkey;/*需求属性buff关键字 飞机装备类型*/
	private String skillNeedtype;   /*需求属性值  武器飞机种类*/
	private String skillFireaction; 
	private String skillFireactionparam;
	private long useCount=0;//使用数量
	
	public String getSkillFireaction() {
		return skillFireaction;
	}
	public void setSkillFireaction(String skillFireaction) {
		this.skillFireaction = skillFireaction;
	}
	public String getSkillFireactionparam() {
		return skillFireactionparam;
	}
	public void setSkillFireactionparam(String skillFireactionparam) {
		this.skillFireactionparam = skillFireactionparam;
	}
	public String getSkillNeedbuffkey() {
		return skillNeedbuffkey;
	}
	public void setSkillNeedbuffkey(String skillNeedbuffkey) {
		this.skillNeedbuffkey = skillNeedbuffkey;
	}
	public String getSkillNeedtype() {
		return skillNeedtype;
	}
	public void setSkillNeedtype(String skillNeedtype) {
		this.skillNeedtype = skillNeedtype;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSkillCode() {
		return skillCode;
	}
	public void setSkillCode(String skillCode) {
		this.skillCode = skillCode;
	}
	public String getSkillIcon() {
		return skillIcon;
	}
	public void setSkillIcon(String skillIcon) {
		this.skillIcon = skillIcon;
	}
	public String getSkillMeclip() {
		return skillMeclip;
	}
	public void setSkillMeclip(String skillMeclip) {
		this.skillMeclip = skillMeclip;
	}
	public String getSkillToclip() {
		return skillToclip;
	}
	public void setSkillToclip(String skillToclip) {
		this.skillToclip = skillToclip;
	}
	public Integer getSkillEthnicity() {
		return skillEthnicity;
	}
	public void setSkillEthnicity(Integer skillEthnicity) {
		this.skillEthnicity = skillEthnicity;
	}
	public Integer getSkillDeparttype() {
		return skillDeparttype;
	}
	public void setSkillDeparttype(Integer skillDeparttype) {
		this.skillDeparttype = skillDeparttype;
	}
	public Integer getSkillActive() {
		return skillActive;
	}
	public void setSkillActive(Integer skillActive) {
		this.skillActive = skillActive;
	}
	public Integer getSkillMpcost() {
		return skillMpcost;
	}
	public void setSkillMpcost(Integer skillMpcost) {
		this.skillMpcost = skillMpcost;
	}
	public String getSkillMppercost() {
		return skillMppercost;
	}
	public void setSkillMppercost(String skillMppercost) {
		this.skillMppercost = skillMppercost;
	}
	public Integer getSkillMaxlevel() {
		return skillMaxlevel;
	}
	public void setSkillMaxlevel(Integer skillMaxlevel) {
		this.skillMaxlevel = skillMaxlevel;
	}
	public Integer getSkillNeedlv() {
		return skillNeedlv;
	}
	public void setSkillNeedlv(Integer skillNeedlv) {
		this.skillNeedlv = skillNeedlv;
	}
	public Integer getSkillNeedrank() {
		return skillNeedrank;
	}
	public void setSkillNeedrank(Integer skillNeedrank) {
		this.skillNeedrank = skillNeedrank;
	}
	public String getSkillTargettype() {
		return skillTargettype;
	}
	public void setSkillTargettype(String skillTargettype) {
		this.skillTargettype = skillTargettype;
	}
	public Integer getSkillLv() {
		return skillLv;
	}
	public void setSkillLv(Integer skillLv) {
		this.skillLv = skillLv;
	}
	public Integer getSkillCd() {
		return skillCd;
	}
	public void setSkillCd(Integer skillCd) {
		this.skillCd = skillCd;
	}
	public Integer getSkillPoint() {
		return skillPoint;
	}
	public void setSkillPoint(Integer skillPoint) {
		this.skillPoint = skillPoint;
	}
	public Integer getSkillNeedmoney() {
		return skillNeedmoney;
	}
	public void setSkillNeedmoney(Integer skillNeedmoney) {
		this.skillNeedmoney = skillNeedmoney;
	}
	public Integer getSkillNeedcoin() {
		return skillNeedcoin;
	}
	public void setSkillNeedcoin(Integer skillNeedcoin) {
		this.skillNeedcoin = skillNeedcoin;
	}
	public String getSkillNeedskills() {
		return skillNeedskills;
	}
	public void setSkillNeedskills(String skillNeedskills) {
		this.skillNeedskills = skillNeedskills;
	}
	public String getSkillCleartypestate() {
		return skillCleartypestate;
	}
	public void setSkillCleartypestate(String skillCleartypestate) {
		this.skillCleartypestate = skillCleartypestate;
	}
	public String getSkillClearstate() {
		return skillClearstate;
	}
	public void setSkillClearstate(String skillClearstate) {
		this.skillClearstate = skillClearstate;
	}
	public String getSkillMestate() {
		return skillMestate;
	}
	public void setSkillMestate(String skillMestate) {
		this.skillMestate = skillMestate;
	}
	public String getSkillFdstate() {
		return skillFdstate;
	}
	public void setSkillFdstate(String skillFdstate) {
		this.skillFdstate = skillFdstate;
	}
	public String getSkillEnstate() {
		return skillEnstate;
	}
	public void setSkillEnstate(String skillEnstate) {
		this.skillEnstate = skillEnstate;
	}
	public String getSkillEnallstate() {
		return skillEnallstate;
	}
	public void setSkillEnallstate(String skillEnallstate) {
		this.skillEnallstate = skillEnallstate;
	}
	public Integer getSkillPower() {
		return skillPower;
	}
	public void setSkillPower(Integer skillPower) {
		this.skillPower = skillPower;
	}
	public Integer getSkillAgility() {
		return skillAgility;
	}
	public void setSkillAgility(Integer skillAgility) {
		this.skillAgility = skillAgility;
	}
	public Integer getSkillStamina() {
		return skillStamina;
	}
	public void setSkillStamina(Integer skillStamina) {
		this.skillStamina = skillStamina;
	}
	public Integer getSkillSpirit() {
		return skillSpirit;
	}
	public void setSkillSpirit(Integer skillSpirit) {
		this.skillSpirit = skillSpirit;
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
	public String getSkillBeacon() {
		return skillBeacon;
	}
	public void setSkillBeacon(String skillBeacon) {
		this.skillBeacon = skillBeacon;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public String getSkillDesc() {
		return skillDesc;
	}
	public void setSkillDesc(String skillDesc) {
		this.skillDesc = skillDesc;
	}
	public long getUseCount() {
		return useCount;
	}
	public void setUseCount(long useCount) {
		this.useCount = useCount;
	}
	
	
}
