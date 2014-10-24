package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameMissionDao;
import com.stang.game.entity.detail.GameMissionDetail;

public class GameMissionDaoImpl extends EntityDao<GameMissionDetail> implements IGameMissionDao{

	@Override
	public List<GameMissionDetail> getGameMission() {
		List<GameMissionDetail> list =null;
		try {
			list = sqlMapper.queryForList("getGameMission");
		} catch (SQLException e) {
			GameConstants.log.warn("",e);
		}
		return list;
	}

	@Override
	public List<GameMissionDetail> findGameMissionById(int id) {
		List<GameMissionDetail> list =null;
		try {
			list = sqlMapper.queryForList("findGameMissionById",id);
		} catch (SQLException e) {
			GameConstants.log.warn("",e);
		}
		return list;
	}

}
