package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameBbuffDao;
import com.stang.game.entity.detail.GameBbuffDetail;
import com.stang.game.entity.detail.GameBuffDetail;
import com.stang.game.entity.detail.GameTaskDetail;

public class GameBbuffDaoImpl extends EntityDao<GameBbuffDetail> implements IGameBbuffDao{

	public List<GameBbuffDetail> findAllBbuff(Map<String, Object> param) {
		List<GameBbuffDetail> list=null;
		try {
			list = sqlMapper.queryForList("findAllBbuff", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	
	
	}

	public List<GameBbuffDetail> findGameBbuffByid(int id) {
		List<GameBbuffDetail> list = null;
		try {
			list = sqlMapper.queryForList("findGameBbuffByid", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<GameBbuffDetail> getGameBbuff() {
		List<GameBbuffDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameBbuff");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public boolean insertGameBbuff(GameBbuffDetail model) {

		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertGameBbuff", model);
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

	public boolean updateGameBbuff(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateGameBbuff", param);
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
