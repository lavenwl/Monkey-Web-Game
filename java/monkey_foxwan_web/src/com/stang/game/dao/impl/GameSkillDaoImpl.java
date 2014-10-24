package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameSkillDao;
import com.stang.game.entity.detail.GameSkillDetail;

public class GameSkillDaoImpl extends EntityDao<GameSkillDetail> 
	implements IGameSkillDao{

	public List<GameSkillDetail> findAllSkill(Map<String, Object> param) {
		List<GameSkillDetail> list=null;
		try {
			list = sqlMapper.queryForList("findAllSkill", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	
	
	}

	public List<GameSkillDetail> findGameSkillByid(int id) {
		List<GameSkillDetail> list = null;
		try {
			list = sqlMapper.queryForList("findGameSkillByid", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<GameSkillDetail> getGameSkill() {
		List<GameSkillDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameSkill");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public boolean insertGameSkill(GameSkillDetail model) {

		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertGameSkill", model);
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

	public boolean updateGameSkill(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateGameSkill", param);
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
