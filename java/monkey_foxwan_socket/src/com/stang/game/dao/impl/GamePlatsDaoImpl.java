package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGamePlatsDao;
import com.stang.game.entity.detail.GamePlatsDetail;
import com.stang.game.entity.detail.RoleMilitaryDetail;

public class GamePlatsDaoImpl extends EntityDao<GamePlatsDetail> implements
		IGamePlatsDao {

	@Override
	public List<GamePlatsDetail> getGamePlats() {
		List<GamePlatsDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGamePlats");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GamePlatsDetail> findGamePlatByparams(Map<String, Object> param) {
		List<GamePlatsDetail> list = null;
		try {
			list = sqlMapper.queryForList("findGamePlatByparams",param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

}
