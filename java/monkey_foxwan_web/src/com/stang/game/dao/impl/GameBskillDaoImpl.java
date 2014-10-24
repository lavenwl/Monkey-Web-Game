package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameBskillDao;
import com.stang.game.entity.detail.GameBskillDetail;
import com.stang.game.entity.detail.GameTaskDetail;

public class GameBskillDaoImpl  extends EntityDao<GameBskillDetail> implements IGameBskillDao{

	public List<GameBskillDetail> findAllBskill(Map<String, Object> param) {
		List<GameBskillDetail> list=null;
		try {
			list = sqlMapper.queryForList("findAllBskill", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	
	
	}

	public List<GameBskillDetail> findGameBskillByid(int id) {
		List<GameBskillDetail> list = null;
		try {
			list = sqlMapper.queryForList("findGameBskillByid", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<GameBskillDetail> getGameBskill() {
		List<GameBskillDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameBskill");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public boolean insertGameBskill(GameBskillDetail model) {

		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertGameBskill", model);
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

	public boolean updateGameBskill(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateGameBskill", param);
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
