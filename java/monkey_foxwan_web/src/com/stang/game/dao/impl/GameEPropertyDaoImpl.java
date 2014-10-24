package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameEPropertyDao;
import com.stang.game.entity.detail.GameEPropertyDetail;
import com.stang.game.entity.detail.GameTaskDetail;
import com.stang.game.entity.detail.RoleItemDetail;
public class GameEPropertyDaoImpl extends EntityDao<GameEPropertyDetail> implements
IGameEPropertyDao {

	public List<GameEPropertyDetail> findAllEProperty(Map<String, Object> param) {
		List<GameEPropertyDetail> list=null;
		try {
			list = sqlMapper.queryForList("findAllEProperty", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	
	
	}

	public List<GameEPropertyDetail> findGameEPropertyByid(int id) {
		List<GameEPropertyDetail> list = null;
		try {
			list = sqlMapper.queryForList("findGameEPropertyByid", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<GameEPropertyDetail> getGameEProperty() {
		List<GameEPropertyDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameEProperty");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public boolean insertGameEProperty(GameEPropertyDetail model) {

		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertGameEProperty", model);
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

	public boolean updateGameEProperty(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateGameEProperty", param);
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
	
	}}
