package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameBingDao;
import com.stang.game.entity.detail.GameBingDetail;
import com.stang.game.entity.detail.GameTaskDetail;

public class GameBingDaoImpl extends EntityDao<GameBingDetail> implements IGameBingDao{

	public List<GameBingDetail> findAllBing(Map<String, Object> param) {
		List<GameBingDetail> list=null;
		try {
			list = sqlMapper.queryForList("findAllBing", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	
	
	}

	public List<GameBingDetail> findGameBingByid(int id) {
		List<GameBingDetail> list = null;
		try {
			list = sqlMapper.queryForList("findGameBingByid", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<GameBingDetail> getGameBing() {
		List<GameBingDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameBing");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public boolean insertGameBing(GameBingDetail model) {

		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertGameBing", model);
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

	public boolean updateGamebing(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateGamebing", param);
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
