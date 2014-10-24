package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameMapDao;
import com.stang.game.entity.detail.GameMapDetail;

public class GameMapDaoImpl extends EntityDao<GameMapDetail> implements
		IGameMapDao {

	public List<GameMapDetail> getGameMap() {
		List<GameMapDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameMap");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<GameMapDetail> findGameMapByid(int id) {
		List<GameMapDetail> list = null;
		try {
			list = sqlMapper.queryForList("findGameMapByid", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<GameMapDetail> findAllMap(Map<String, Object> param) {
		List<GameMapDetail> list=null;
		try {
			list = sqlMapper.queryForList("findAllMap", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	
	
	}

	public boolean insertGameMap(GameMapDetail model) {

		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertGameMap", model);
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

	public boolean updateGameMap(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateGameMapps", param);
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
