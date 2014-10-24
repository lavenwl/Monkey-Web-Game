package com.stang.game.cache;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.dao.impl.GameChLevelDaoImpl;
import com.stang.game.dao.impl.GameTaskDaoImpl;
import com.stang.game.entity.detail.ChallengeRecordDetail;
import com.stang.game.entity.detail.GamblingItemDetail;
import com.stang.game.entity.detail.GameBbuffDetail;
import com.stang.game.entity.detail.GameBingDetail;
import com.stang.game.entity.detail.GameBmapDetail;
import com.stang.game.entity.detail.GameBskillDetail;
import com.stang.game.entity.detail.GameBuffDetail;
import com.stang.game.entity.detail.GameChLevelDetail;
import com.stang.game.entity.detail.GameChartsDetail;
import com.stang.game.entity.detail.GameEInsDetail;
import com.stang.game.entity.detail.GameEPropertyDetail;
import com.stang.game.entity.detail.GameEquipDetail;
import com.stang.game.entity.detail.GameFoeDetail;
import com.stang.game.entity.detail.GameFoeskillDetail;
import com.stang.game.entity.detail.GameItemDetail;
import com.stang.game.entity.detail.GameMLevelDetail;
import com.stang.game.entity.detail.GameMapDetail;
import com.stang.game.entity.detail.GameMilitaryDetail;
import com.stang.game.entity.detail.GameMissionDetail;
import com.stang.game.entity.detail.GamePriceDetail;
import com.stang.game.entity.detail.GameSkillDetail;
import com.stang.game.entity.detail.GameStarDetail;
import com.stang.game.entity.detail.GameTaskDetail;
import com.stang.game.entity.detail.GameTowerDetail;
import com.stang.game.entity.detail.GameVipDetail;
import com.stang.game.service.impl.ChallengeRecordServiceImpl;
import com.stang.game.service.impl.GamblingItemServiceImpl;
import com.stang.game.service.impl.GameBbuffServiceImpl;
import com.stang.game.service.impl.GameBingServiceImpl;
import com.stang.game.service.impl.GameBmapServiceImpl;
import com.stang.game.service.impl.GameBskillServiceImpl;
import com.stang.game.service.impl.GameBuffServiceImpl;
import com.stang.game.service.impl.GameEInsServiceImpl;
import com.stang.game.service.impl.GameEPropertyServiceImpl;
import com.stang.game.service.impl.GameEquipServiceImpl;
import com.stang.game.service.impl.GameFoeServiceImpl;
import com.stang.game.service.impl.GameFoeskillServiceImpl;
import com.stang.game.service.impl.GameItemServiceImpl;
import com.stang.game.service.impl.GameMLevelServiceImpl;
import com.stang.game.service.impl.GameMapServiceImpl;
import com.stang.game.service.impl.GameMilitaryServiceImpl;
import com.stang.game.service.impl.GameMissionServiceImpl;
import com.stang.game.service.impl.GamePriceServiceImpl;
import com.stang.game.service.impl.GameSkillServiceImpl;
import com.stang.game.service.impl.GameStarServiceImpl;
import com.stang.game.service.impl.GameTowerServiceImpl;
import com.stang.game.service.impl.GameVipServiceImpl;

/**
 * @author fei_wei
 * @company 上海三唐信息科技有限公司
 * @description 全局数据缓存
 */
public class GlobalData {
	public static Date today = null;
	/* 模型(或基本)信息[非统计信息] */
	public static List<GameMapDetail> cacheGameMap = null; /* 所有地图 */
	public static List<GameTowerDetail> cacheGameFTa = null; /* 所有防御塔信息 */
	public static List<GameMilitaryDetail> cacheGameMilitary = null; /* 所有防御塔信息 */
	public static List<GameMLevelDetail> cacheMlevel = null; /* 所有防武将经验信息 */
	public static List<GameFoeDetail> cacheGameFoe = null; /* 所有防御塔信息 */
	public static List<GameFoeskillDetail> cacheGameFoeskill = null; /* 所有防御塔信息 */
	public static List<GamePriceDetail> cacheGamepList = null; /* 商店价格 */
	public static List<GameItemDetail> cacheModelItems = null; /* 道具模型信息 */
	public static List<GameEquipDetail> cacheGameEquip = null; /* 装备模型信息 */
	public static List<GameVipDetail> cacheGameVip = null; /* vip模型信息 */
	public static List<GamblingItemDetail> cacheModelGamblingItemList = null;/* 抽奖物品信息 */
	public static List<GameEPropertyDetail> cacheGameEProperty = null;// 装备属性模型
	public static List<GameEInsDetail> cacheGameEIns = null;// 强化属性模型
	public static List<GameSkillDetail> cacheGameSkill = null;// 技能属性模型
	public static List<GameBuffDetail> cacheGameBuff = null;// 技能属性模型
	public static List<GameStarDetail> cacheGameStar=null;
	public static List<GameChLevelDetail> cacheGameChLevel = null;
	public static List<GameTaskDetail> cacheGameTask = null;
	public static List<GameBingDetail> cacheGameBing = null;
	public static List<GameMissionDetail> cacheGameMission = null;
	public static List<GameBmapDetail> cacheGameBmap=null;
	public static List<GameBskillDetail> cacheGameBskill = null;
	public static List<GameBbuffDetail> cacheGameBbuff =null;
	public static List<ChallengeRecordDetail> challengeRecords = null;
	public static Map<Integer, String> color = null; 
	public static Map<Integer, String> colorMission = null; 
	public static Map<String, String> messageColor = null; 
	
	static {
		/* 缓存公用信息 */
		Map<String, Object> param = new HashMap<String, Object>();
		if (cacheGameMap == null) {
			cacheGameMap = new GameMapServiceImpl().getGameMap();
		}
		
		if(messageColor == null){
			messageColor = new HashMap<String, String>();
			messageColor.put("player", "#00EEEE");
			messageColor.put("vip", "#FFFF00");
			messageColor.put("where", "#00EEEE");
			messageColor.put("adj", "#FFB90F");
		}

		if(color == null){
			color = new HashMap<Integer, String>(); 
			color.put(1, "#FFFFFF");
			color.put(2, "#00EC38");
			color.put(3, "#00AEFF");
			color.put(4, "#FF0000");
			color.put(5, "#FFC000");
			color.put(6, "#E00DFF");
		}
		
		if(colorMission == null){
			colorMission = new HashMap<Integer, String>(); 
			colorMission.put(0, "#FFFFFF");
			colorMission.put(1, "#FFFF00");
			colorMission.put(2, "#FF0000");
			colorMission.put(3, "#FF00FF");
		}
		
		if (challengeRecords == null) {
			challengeRecords = new ArrayList<ChallengeRecordDetail>();
		}
		
		if (cacheGameVip == null) {
			cacheGameVip = (new GameVipServiceImpl()).allGameVips();
		}

		if (cacheMlevel == null) {
			cacheMlevel = (new GameMLevelServiceImpl()).getGameMLevel();
		}

		if (cacheGamepList == null) {
			cacheGamepList = (new GamePriceServiceImpl()).getAllGamePrice();
		}

		if (cacheModelItems == null) {
			cacheModelItems = (new GameItemServiceImpl()).getGameItem();
		}

		if (cacheGameFTa == null) {
			cacheGameFTa = (new GameTowerServiceImpl()).getGameTower();
		}

		if (cacheGameMilitary == null) {
			cacheGameMilitary = (new GameMilitaryServiceImpl())
					.getGameMilitary();
		}

		if (cacheGameFoe == null) {
			cacheGameFoe = (new GameFoeServiceImpl()).getGameFoe();
		}
		
		if (cacheGameFoeskill == null) {
			cacheGameFoeskill = (new GameFoeskillServiceImpl()).getGameFoeskill();
		}

		if (cacheGameEquip == null) {
			cacheGameEquip = (new GameEquipServiceImpl()).getGameEquip();
		}
		if (cacheModelGamblingItemList == null) {
			cacheModelGamblingItemList = (new GamblingItemServiceImpl()).findAllGamblingItem();
		}
		if (cacheGameEProperty == null) {
			cacheGameEProperty = (new GameEPropertyServiceImpl())
					.getGameEProperty();
		}
		if (cacheGameEIns == null) {
			cacheGameEIns = (new GameEInsServiceImpl()).getGameEIns();
		}
		if (cacheGameSkill == null) {
			cacheGameSkill = (new GameSkillServiceImpl()).getGameSkill();
		}
		if (cacheGameBuff == null) {
			cacheGameBuff = (new GameBuffServiceImpl()).getGameBuff();
		}
		if (cacheGameChLevel == null) {
			cacheGameChLevel = (new GameChLevelDaoImpl()).getGameChLevel();
		}
		if (cacheGameTask == null) {
			cacheGameTask = (new GameTaskDaoImpl()).getAllGameTask();
		}
		if(cacheGameStar==null){
			cacheGameStar=(new GameStarServiceImpl()).getallgamestar();
		}
		if (cacheGameBing == null) {
			cacheGameBing = (new GameBingServiceImpl()).getGameBing();
		}
		if (cacheGameMission == null) {
			cacheGameMission = (new GameMissionServiceImpl()).getGameMission();
		}
		if(cacheGameBmap == null){
			cacheGameBmap = new GameBmapServiceImpl().getGameBmap();
		}
		if(cacheGameBskill==null){
			cacheGameBskill = new GameBskillServiceImpl().getGameBskill();
		}
		if(cacheGameBbuff==null){
			cacheGameBbuff = new GameBbuffServiceImpl().getGameBbuff();
		}
	}
}