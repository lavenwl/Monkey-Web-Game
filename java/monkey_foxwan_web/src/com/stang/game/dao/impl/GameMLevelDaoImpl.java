package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameMLevelDao;
import com.stang.game.entity.detail.GameMLevelDetail;
import com.stang.game.entity.detail.GameTaskDetail;

public class GameMLevelDaoImpl extends EntityDao<GameMLevelDetail> implements
		IGameMLevelDao {

	

	public List<GameMLevelDetail> getGameMLevelBylevel(int level) {
		List<GameMLevelDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameMLevelBylevel",level);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<GameMLevelDetail> getGameMLevelByAllexp(int allexp) {
		List<GameMLevelDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameMLevelByAllexp",allexp);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<GameMLevelDetail> findAllMLevel(Map<String, Object> param) {
		List<GameMLevelDetail> list=null;
		try {
			list = sqlMapper.queryForList("findAllMLevel", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	
	
	}

	public List<GameMLevelDetail> findGameMLevelByid(int id) {
		List<GameMLevelDetail> list = null;
		try {
			list = sqlMapper.queryForList("findGameMLevelByid", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<GameMLevelDetail> getGameMLevel() {
		List<GameMLevelDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameMLevel");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public boolean insertGameMLevel(GameMLevelDetail model) {

		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertGameMLevel", model);
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

	public boolean updateGameMLevel(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateGameMLevel", param);
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
