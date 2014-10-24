package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameChLevelDao;
import com.stang.game.entity.detail.GameChLevelDetail;
import com.stang.game.entity.detail.RoleMilitaryDetail;

public class GameChLevelDaoImpl extends EntityDao<GameChLevelDetail> implements
		IGameChLevelDao {

	@Override
	public List<GameChLevelDetail> getGameChLevel() {
		List<GameChLevelDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameChLevel");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameChLevelDetail> findGameChLevelByparas(
			Map<String, Object> param) {
		List<GameChLevelDetail> list = null;
		try {
			list = sqlMapper.queryForList("findGameChLevelByparas",param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

}
