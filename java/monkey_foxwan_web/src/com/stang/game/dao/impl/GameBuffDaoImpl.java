package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameBuffDao;
import com.stang.game.entity.detail.GameBuffDetail;
import com.stang.game.entity.detail.GameSkillDetail;
import com.stang.game.entity.detail.GameTaskDetail;

public class GameBuffDaoImpl extends EntityDao<GameBuffDetail> 
	implements IGameBuffDao{

	public List<GameBuffDetail> findAllBuff(Map<String, Object> param) {
		List<GameBuffDetail> list=null;
		try {
			list = sqlMapper.queryForList("findAllBuff", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	
	
	}

	public List<GameBuffDetail> findGameBuffByid(int id) {
		List<GameBuffDetail> list = null;
		try {
			list = sqlMapper.queryForList("findGameBuffByid", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<GameBuffDetail> getGameBuff() {
		List<GameBuffDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameBuff");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public boolean insertGameBuff(GameBuffDetail model) {

		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertGameBuff", model);
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

	public boolean updateGameBuff(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateGameBuff", param);
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
