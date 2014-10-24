package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameBmapDao;
import com.stang.game.entity.detail.GameBmapDetail;
import com.stang.game.entity.detail.GameTaskDetail;

public class GameBmapDaoImpl extends EntityDao<GameBmapDetail> implements IGameBmapDao{

	public List<GameBmapDetail> findAllBmap(Map<String, Object> param) {
		List<GameBmapDetail> list=null;
		try {
			list = sqlMapper.queryForList("findAllBmap", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	
	
	}

	public List<GameBmapDetail> findGameBmapByid(int id) {
		List<GameBmapDetail> list = null;
		try {
			list = sqlMapper.queryForList("findGameBmapByid", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<GameBmapDetail> getGameBmap() {
		List<GameBmapDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameBmap");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public boolean insertGameBmap(GameBmapDetail model) {

		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertGameBmap", model);
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

	public boolean updateGameBmap(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateGameBmap", param);
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
