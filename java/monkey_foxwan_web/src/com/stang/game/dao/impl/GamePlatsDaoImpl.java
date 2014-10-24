package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGamePlatsDao;
import com.stang.game.entity.detail.GamePlatsDetail;
import com.stang.game.entity.detail.GameTaskDetail;
import com.stang.game.entity.detail.RoleMilitaryDetail;

public class GamePlatsDaoImpl extends EntityDao<GamePlatsDetail> implements
		IGamePlatsDao {

	public List<GamePlatsDetail> findAllPlat(Map<String, Object> param) {
		List<GamePlatsDetail> list=null;
		try {
			list = sqlMapper.queryForList("findAllPlat", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	
	
	}

	public List<GamePlatsDetail> findGamePlatByid(Map<String,Object> param) {
		List<GamePlatsDetail> list = null;
		try {
			list = sqlMapper.queryForList("findGamePlatByid",param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<GamePlatsDetail> getGamePlat() {
		List<GamePlatsDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGamePlat");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public boolean insertGameplat(GamePlatsDetail model) {

		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertGameplat", model);
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

	public boolean updateGameplat(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateGameplat", param);
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
