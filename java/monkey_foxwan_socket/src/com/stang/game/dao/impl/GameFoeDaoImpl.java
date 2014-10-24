package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameFoeDao;
import com.stang.game.entity.detail.GameFoeDetail;

public class GameFoeDaoImpl extends EntityDao<GameFoeDetail> implements
		IGameFoeDao {

	@Override
	public List<GameFoeDetail> getGameFoe() {
		List<GameFoeDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameFoe");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

}
