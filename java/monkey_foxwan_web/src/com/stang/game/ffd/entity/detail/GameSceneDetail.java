package com.stang.game.ffd.entity.detail;

import java.util.Date;

/**
 * @author jianbo.feng
 * @company 上海三唐信息科技有限公司
 * @description (游戏地图中)场景(及障碍)信息
 */
public class GameSceneDetail {

	private Integer id;
	private String sceneName; /* 场景名称 */
	private String sceneRes;
	private String sceneRes2;
	private String sceneRes3;/* 资源 */
	private String sceneRes4;
	private String sceneRes5;/* 资源 */
	private Integer sceneType; /* 场景类型(1,副本;2,竞技,3/新手,4/副本关卡) */
	private Integer sceneLevel; /* 等级限制 */
	private Integer barrierTypeNum; /* 障碍种类数量 */
	private Integer barrierMaxX; /* 障碍最大X坐标 */
	private Integer barrierMinX; /* 障碍最小X坐标 */
	private Integer barrierMaxY; /* 障碍最大Y坐标 */
	private Integer barrierMinY; /* 障碍最小Y坐标 */
	private Integer barrierCreateMin; /* 障碍生成最小数量 */
	private Integer barrierCreateMax; /* 障碍生成最大数量 */
	private Date createTime;
	private Integer flag;
	private String sceneThumb; /* 场景缩略图 */
	private String buffInfo;
	private String plainPosion;/* 当前地图的飞机刷新位置 */
	private Integer sceneGate; /* 场景关卡 */
	private String sceneBalkId;/* 场景障碍ID */
	private String sceneTalk;/* 开场白 */
	private String sceneMission;/* 副本任务目标 */
	private Integer sceneDifficult;
	private Integer sceneShow;
	private Integer sceneGroup;
	private String sceneDesc;
	private Integer sceneBarrier;
	private Integer sceneHot;

	public Integer getSceneDifficult() {
		return sceneDifficult;
	}

	public void setSceneDifficult(Integer sceneDifficult) {
		this.sceneDifficult = sceneDifficult;
	}

	public String getSceneBalkId() {
		return sceneBalkId;
	}

	public void setSceneBalkId(String sceneBalkId) {
		this.sceneBalkId = sceneBalkId;
	}

	public String getBuffInfo() {
		return buffInfo;
	}

	public void setBuffInfo(String buffInfo) {
		this.buffInfo = buffInfo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSceneRes() {
		return sceneRes;
	}

	public void setSceneRes(String sceneRes) {
		this.sceneRes = sceneRes;
	}

	public Integer getSceneType() {
		return sceneType;
	}

	public void setSceneType(Integer sceneType) {
		this.sceneType = sceneType;
	}

	public Integer getSceneLevel() {
		return sceneLevel;
	}

	public void setSceneLevel(Integer sceneLevel) {
		this.sceneLevel = sceneLevel;
	}

	public Integer getBarrierTypeNum() {
		return barrierTypeNum;
	}

	public void setBarrierTypeNum(Integer barrierTypeNum) {
		this.barrierTypeNum = barrierTypeNum;
	}

	public Integer getBarrierMaxX() {
		return barrierMaxX;
	}

	public void setBarrierMaxX(Integer barrierMaxX) {
		this.barrierMaxX = barrierMaxX;
	}

	public Integer getBarrierMinX() {
		return barrierMinX;
	}

	public void setBarrierMinX(Integer barrierMinX) {
		this.barrierMinX = barrierMinX;
	}

	public Integer getBarrierMaxY() {
		return barrierMaxY;
	}

	public void setBarrierMaxY(Integer barrierMaxY) {
		this.barrierMaxY = barrierMaxY;
	}

	public Integer getBarrierMinY() {
		return barrierMinY;
	}

	public void setBarrierMinY(Integer barrierMinY) {
		this.barrierMinY = barrierMinY;
	}

	public Integer getBarrierCreateMin() {
		return barrierCreateMin;
	}

	public void setBarrierCreateMin(Integer barrierCreateMin) {
		this.barrierCreateMin = barrierCreateMin;
	}

	public Integer getBarrierCreateMax() {
		return barrierCreateMax;
	}

	public void setBarrierCreateMax(Integer barrierCreateMax) {
		this.barrierCreateMax = barrierCreateMax;
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

	public String getSceneThumb() {
		return sceneThumb;
	}

	public void setSceneThumb(String sceneThumb) {
		this.sceneThumb = sceneThumb;
	}

	public String getSceneName() {
		return sceneName;
	}

	public void setSceneName(String sceneName) {
		this.sceneName = sceneName;
	}

	public String getPlainPosion() {
		return plainPosion;
	}

	public void setPlainPosion(String plainPosion) {
		this.plainPosion = plainPosion;
	}

	public Integer getSceneGate() {
		return sceneGate;
	}

	public void setSceneGate(Integer sceneGate) {
		this.sceneGate = sceneGate;
	}

	public String getSceneTalk() {
		return sceneTalk;
	}

	public void setSceneTalk(String sceneTalk) {
		this.sceneTalk = sceneTalk;
	}

	public String getSceneMission() {
		return sceneMission;
	}

	public void setSceneMission(String sceneMission) {
		this.sceneMission = sceneMission;
	}

	public String getSceneRes2() {
		return sceneRes2;
	}

	public void setSceneRes2(String sceneRes2) {
		this.sceneRes2 = sceneRes2;
	}

	public String getSceneRes3() {
		return sceneRes3;
	}

	public void setSceneRes3(String sceneRes3) {
		this.sceneRes3 = sceneRes3;
	}

	public Integer getSceneShow() {
		return sceneShow;
	}

	public void setSceneShow(Integer sceneShow) {
		this.sceneShow = sceneShow;
	}

	public Integer getSceneGroup() {
		return sceneGroup;
	}

	public void setSceneGroup(Integer sceneGroup) {
		this.sceneGroup = sceneGroup;
	}

	public String getSceneDesc() {
		return sceneDesc;
	}

	public void setSceneDesc(String sceneDesc) {
		this.sceneDesc = sceneDesc;
	}

	public Integer getSceneBarrier() {
		return sceneBarrier;
	}

	public void setSceneBarrier(Integer sceneBarrier) {
		this.sceneBarrier = sceneBarrier;
	}

	public Integer getSceneHot() {
		return sceneHot;
	}

	public void setSceneHot(Integer sceneHot) {
		this.sceneHot = sceneHot;
	}

	public String getSceneRes4() {
		return sceneRes4;
	}

	public void setSceneRes4(String sceneRes4) {
		this.sceneRes4 = sceneRes4;
	}

	public String getSceneRes5() {
		return sceneRes5;
	}

	public void setSceneRes5(String sceneRes5) {
		this.sceneRes5 = sceneRes5;
	}

}
