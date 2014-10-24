package com.stang.game.dao.impl;

/**
 * @author jack.fei
 * @company 上海三唐信息科技有限公司 
 * @description 实体数据库处理实现 
 */
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameLevelDao;
import com.stang.game.entity.detail.GameLevelDetail;
import com.stang.game.entity.detail.GameTaskDetail;

public class GameLevelDaoImpl extends EntityDao<GameLevelDetail> implements
		IGameLevelDao {

	public List<GameLevelDetail> findAllLevel(Map<String, Object> param) {
		List<GameLevelDetail> list=null;
		try {
			list = sqlMapper.queryForList("findAllLevel", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	
	
	}

	public List<GameLevelDetail> findGameLevelByid(int id) {
		List<GameLevelDetail> list = null;
		try {
			list = sqlMapper.queryForList("findGameLevelByid", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<GameLevelDetail> getGameLevel() {
		List<GameLevelDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameLevel");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public boolean insertGameLevel(GameLevelDetail model) {

		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertGameLevel", model);
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

	public boolean updateGameLevel(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateGameLevel", param);
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

	
	
	
	
	
	
	
	


	public List<GameLevelDetail> allGameLevelDetail() {
		List<GameLevelDetail> list = null;
		try {
			list = sqlMapper.queryForList("allGameLevelDetail");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public GameLevelDetail getGameLevelByRoleLevel(int roleLevel) {
		GameLevelDetail gameLevelDetail = null;
		try {
			List<GameLevelDetail> list = sqlMapper.queryForList(
					"getGameLevelByRoleLevel", roleLevel);
			if (!list.isEmpty() && list != null) {
				gameLevelDetail = list.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gameLevelDetail;
	}



}
