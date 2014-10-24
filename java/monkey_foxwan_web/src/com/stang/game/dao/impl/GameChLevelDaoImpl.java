package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameChLevelDao;
import com.stang.game.entity.detail.GameChLevelDetail;
import com.stang.game.entity.detail.GameTaskDetail;
import com.stang.game.entity.detail.RoleMilitaryDetail;

public class GameChLevelDaoImpl extends EntityDao<GameChLevelDetail> implements
		IGameChLevelDao {

	public List<GameChLevelDetail> findAllChlevel(Map<String, Object> param) {
		List<GameChLevelDetail> list=null;
		try {
			list = sqlMapper.queryForList("findAllChlevel", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	
	
	}

	public List<GameChLevelDetail> findGameChlevelByid(int id) {
		List<GameChLevelDetail> list = null;
		try {
			list = sqlMapper.queryForList("findGameChlevelByid", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<GameChLevelDetail> getGameChlevel() {
		List<GameChLevelDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameChlevel");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public boolean insertGameCHLevel(GameChLevelDetail model) {

		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertGameCHLevel", model);
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

	public boolean updateGameGameCHLevel(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateGameGameCHLevel", param);
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
