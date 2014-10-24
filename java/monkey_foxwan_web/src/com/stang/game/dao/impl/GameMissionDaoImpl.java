package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameMissionDao;
import com.stang.game.entity.detail.GameMissionDetail;
import com.stang.game.entity.detail.GameTaskDetail;

public class GameMissionDaoImpl extends EntityDao<GameMissionDetail> implements IGameMissionDao{

	public List<GameMissionDetail> findAllMission(Map<String, Object> param) {
		List<GameMissionDetail> list=null;
		try {
			list = sqlMapper.queryForList("findAllMission", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	
	
	}

	public List<GameMissionDetail> findGameMissionByid(int id) {
		List<GameMissionDetail> list = null;
		try {
			list = sqlMapper.queryForList("findGameMissionByid", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<GameMissionDetail> getGameMission() {
		List<GameMissionDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameMission");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public boolean insertGameMission(GameMissionDetail model) {

		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertGameMission", model);
			sqlMapper.commitTransaction();
			isSuccess = true;
		} catch (Exception e) {
			GameConstants.log.warn("", e);
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("", e);
			}
		}
		return isSuccess;
	
	
	}

	public boolean updateGameMission(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateGameMission", param);
			sqlMapper.commitTransaction();
			isSuccess = true;
		} catch (Exception e) {
			GameConstants.log.warn("", e);
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("", e);
			}
		}
		return isSuccess;
	
	}


}
