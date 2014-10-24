package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameMilitaryDao;
import com.stang.game.entity.detail.GameMilitaryDetail;
import com.stang.game.entity.detail.GameTaskDetail;

public class GameMilitaryDaoImpl extends EntityDao<GameMilitaryDetail>
		implements IGameMilitaryDao {

	public List<GameMilitaryDetail> findAllMilitary(Map<String, Object> param) {
		List<GameMilitaryDetail> list=null;
		try {
			list = sqlMapper.queryForList("findAllMilitary", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	
	
	}

	public List<GameMilitaryDetail> findGameMilitaryByid(int id) {
		List<GameMilitaryDetail> list = null;
		try {
			list = sqlMapper.queryForList("findGameMilitaryByid", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<GameMilitaryDetail> getGameMilitary() {
		List<GameMilitaryDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameMilitary");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public boolean insertGameMilitary(GameMilitaryDetail model) {

		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertGameMilitary", model);
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

	public boolean updateGameMilitary(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateGameMilitary", param);
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
