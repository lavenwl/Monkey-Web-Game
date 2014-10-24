package com.stang.game.ffd.dao.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.common.GameConstants;
import com.stang.game.ffd.entity.detail.GameSceneDetail;

public class GameSceneDaoImpl extends EntityDao<GameSceneDetail> {
	
	public List<GameSceneDetail> getGameScene(Map<String, Object> param){
		List<GameSceneDetail> list = null;
		try {
			list = this.sqlMapperFlight.queryForList("GameScene",param);
		} catch (Exception e) {
			//GameConstants.log.warn("", e);
			e.printStackTrace();
		}
		return list;
	}

}
