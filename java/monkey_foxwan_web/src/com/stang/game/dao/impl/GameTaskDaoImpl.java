package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameTaskDao;
import com.stang.game.entity.detail.GameTaskDetail;

public class GameTaskDaoImpl extends EntityDao<GameTaskDetail> implements
		IGameTaskDao {

	public List<GameTaskDetail> findAllTask(Map<String, Object> param) {
		List<GameTaskDetail> list=null;
		try {
			list = sqlMapper.queryForList("findAllTask", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	
	
	}

	public List<GameTaskDetail> findGameTaskByid(int id) {
		List<GameTaskDetail> list = null;
		try {
			list = sqlMapper.queryForList("findGameTaskByid", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<GameTaskDetail> getGameTask() {
		List<GameTaskDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameTask");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public boolean insertGametask(GameTaskDetail model) {

		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertGametask", model);
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

	public boolean updateGametask(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateGametask", param);
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