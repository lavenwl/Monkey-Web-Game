package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameFoeDao;
import com.stang.game.entity.detail.GameFoeDetail;
import com.stang.game.entity.detail.GameTaskDetail;

public class GameFoeDaoImpl extends EntityDao<GameFoeDetail> implements
		IGameFoeDao {

	public List<GameFoeDetail> findAllFoe(Map<String, Object> param) {
		List<GameFoeDetail> list=null;
		try {
			list = sqlMapper.queryForList("findAllFoe", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	
	
	}

	public List<GameFoeDetail> findGameFoeByid(int id) {
		List<GameFoeDetail> list = null;
		try {
			list = sqlMapper.queryForList("findGameFoeByid", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<GameFoeDetail> getGameFoe() {
		List<GameFoeDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameFoe");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public boolean insertGameFoe(GameFoeDetail model) {

		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertGameFoe", model);
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

	public boolean updateGameFoe(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateGameFoe", param);
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
