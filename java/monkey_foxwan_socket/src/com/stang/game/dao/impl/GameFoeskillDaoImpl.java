package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameFoeDao;
import com.stang.game.dao.IGameFoeskillDao;
import com.stang.game.entity.detail.GameFoeDetail;
import com.stang.game.entity.detail.GameFoeskillDetail;

public class GameFoeskillDaoImpl extends EntityDao<GameFoeskillDetail> implements
		IGameFoeskillDao {

	@Override
	public List<GameFoeskillDetail> getGameFoeskill() {
		List<GameFoeskillDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameFoeskill");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

}
