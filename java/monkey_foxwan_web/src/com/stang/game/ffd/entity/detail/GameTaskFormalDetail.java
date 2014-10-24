package com.stang.game.ffd.entity.detail;

import java.util.Date;

/**
 * @author jianbo.feng
 * @company 上海三唐信息科技有限公司
 * @description (正式的)任务信息
 */
public class GameTaskFormalDetail {

	private Integer id; /* 信息序列号 */
	private String taskName; /* 任务名称 */
	private String taskDesc; /* 任务描述 */
	private Integer taskType; /* 任务类型(1,日常任务;2,成长任务;3,公会任务;4,活动任务) */
	private String taskStartTime; /* 任务起始时间 */
	private String taskEndTime; /* 任务结束时间 */
	private Integer taskCycle; /* 任务周期(即此任务的时间范围),单位秒 */
	private String taskGiftIds; /* 礼品信息序列号组(以逗号分隔) */
	private Date createTime; /* 任务信息录入时间 */
	private Integer flag; /* (正式)任务信息标识位(-1,删除;0,隐藏;1,正常) */
	private Integer taskLevel; /* 任务等级 */
	private Integer giftIsMore; /* 奖品是否多选（0/不可选,1/可选1个，2/可选2个...） */
	private Integer taskGold; /* 所得金币 */
	private Integer taskExp; /* 所得经验 */
	private String taskRes; /*
							 * 任务完成需要物品
							 * 物品类型(1/飞机，2/装备，4/装扮，3/道具，6/任务，62-68/新手任务)
							 */
	private Integer taskThingNum; /* (任务)相关的次数(可以是场次数、物品个数、击毙怪物次数)、相关的级别数或需要通过的副本序号 */
	private Integer hypoType; /* 任务类型(1,收集物品数;2,杀怪物/Boss次数;3,胜利场次;4,升级;5,顺利通过副本) */
	private String detailDesc; /* 说明 */
	private Integer onlyFlag;
	private Integer taskBind;//任务前序ID
	private Integer newTask;

	public Integer getNewTask() {
		return newTask;
	}

	public void setNewTask(Integer newTask) {
		this.newTask = newTask;
	}

	public Integer getTaskBind() {
		return taskBind;
	}

	public void setTaskBind(Integer taskBind) {
		this.taskBind = taskBind;
	}

	public Integer getOnlyFlag() {
		return onlyFlag;
	}

	public void setOnlyFlag(Integer onlyFlag) {
		this.onlyFlag = onlyFlag;
	}

	public Integer getTaskGold() {
		return taskGold;
	}

	public void setTaskGold(Integer taskGold) {
		this.taskGold = taskGold;
	}

	public Integer getTaskExp() {
		return taskExp;
	}

	public void setTaskExp(Integer taskExp) {
		this.taskExp = taskExp;
	}

	public String getTaskRes() {
		return taskRes;
	}

	public void setTaskRes(String taskRes) {
		this.taskRes = taskRes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTaskType() {
		return taskType;
	}

	public void setTaskType(Integer taskType) {
		this.taskType = taskType;
	}

	public String getTaskStartTime() {
		return taskStartTime;
	}

	public void setTaskStartTime(String taskStartTime) {
		this.taskStartTime = taskStartTime;
	}

	public String getTaskEndTime() {
		return taskEndTime;
	}

	public void setTaskEndTime(String taskEndTime) {
		this.taskEndTime = taskEndTime;
	}

	public Integer getTaskCycle() {
		return taskCycle;
	}

	public void setTaskCycle(Integer taskCycle) {
		this.taskCycle = taskCycle;
	}

	public String getTaskGiftIds() {
		return taskGiftIds;
	}

	public void setTaskGiftIds(String taskGiftIds) {
		this.taskGiftIds = taskGiftIds;
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

	public Integer getTaskLevel() {
		return taskLevel;
	}

	public void setTaskLevel(Integer taskLevel) {
		this.taskLevel = taskLevel;
	}

	public Integer getGiftIsMore() {
		return giftIsMore;
	}

	public void setGiftIsMore(Integer giftIsMore) {
		this.giftIsMore = giftIsMore;
	}

	public Integer getTaskThingNum() {
		return taskThingNum;
	}

	public void setTaskThingNum(Integer taskThingNum) {
		this.taskThingNum = taskThingNum;
	}

	public Integer getHypoType() {
		return hypoType;
	}

	public void setHypoType(Integer hypoType) {
		this.hypoType = hypoType;
	}

	public String getDetailDesc() {
		return detailDesc;
	}

	public void setDetailDesc(String detailDesc) {
		this.detailDesc = detailDesc;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

}
