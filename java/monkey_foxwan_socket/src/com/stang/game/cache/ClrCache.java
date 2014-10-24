package com.stang.game.cache;

import java.util.List;

import com.stang.game.dao.IGameItemDao;
import com.stang.game.dao.impl.GameChLevelDaoImpl;
import com.stang.game.dao.impl.GameItemDaoImpl;
import com.stang.game.dao.impl.GameTaskDaoImpl;
import com.stang.game.entity.detail.GameBbuffDetail;
import com.stang.game.entity.detail.GameBmapDetail;
import com.stang.game.entity.detail.GameBskillDetail;
import com.stang.game.entity.detail.GameMissionDetail;
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

public class ClrCache extends GlobalData{

	public void clrAllModel(){
		IGameItemDao dao = new GameItemDaoImpl();
		dao.ClrAllModel();
		dao = null;
		
		//要更新的模型数据
		cacheGameMap = null;
		cacheGameFTa = null;
		cacheGameMilitary = null;
		cacheMlevel = null;
		cacheGameFoe = null;
		cacheGamepList = null;
		cacheModelItems = null;
		cacheGameEquip = null;
		cacheGameVip = null;
		cacheModelGamblingItemList = null;
		cacheGameEProperty = null;
		cacheGameEIns = null;
		cacheGameSkill = null;
		cacheGameBuff = null;
		cacheGameStar = null;
		cacheGameChLevel = null;
		cacheGameTask = null;
		cacheGameBing = null;
		cacheGameMission = null;
		cacheGameBmap=null;
		cacheGameBskill = null;
		cacheGameBbuff =null;
		
		if (cacheGameMap == null) {
			cacheGameMap = (new GameMapServiceImpl()).getGameMap();
			System.out.println("更新模型map>>>>");
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

		if (cacheGameEquip == null) {
			cacheGameEquip = (new GameEquipServiceImpl()).getGameEquip();
		}
		if (cacheModelGamblingItemList == null) {
			cacheModelGamblingItemList = (new GamblingItemServiceImpl())
					.getGamblingItem(null);
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
