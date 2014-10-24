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
import com.stang.game.entity.detail.GameRoleDetail;

public class GameLevelDaoImpl extends EntityDao<GameLevelDetail> implements
		IGameLevelDao {

	@Override
	public List<GameLevelDetail> findAllGameLevel() {
		List<GameLevelDetail> levels = null;
		try {
			levels = sqlMapper.queryForList("allGameLevelDetail");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		if (!levels.isEmpty()) {
			return levels;
		} else {
			return null;
		}
	}
	
	@Override
	public List<GameLevelDetail> allGameLevelDetail() {
		List<GameLevelDetail> list = null;
		try {
			list = sqlMapper.queryForList("allGameLevelDetail");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
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

	@Override
	public List<GameLevelDetail> getGaemLevelByParams(Map<String, Object> param) {
		List<GameLevelDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGaemLevelByParams",param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

}
