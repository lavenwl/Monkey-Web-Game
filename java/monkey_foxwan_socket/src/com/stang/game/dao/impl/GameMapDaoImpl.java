package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameMapDao;
import com.stang.game.entity.detail.GameMapDetail;
import com.stang.game.entity.detail.GameMilitaryDetail;

public class GameMapDaoImpl extends EntityDao<GameMapDetail> implements
		IGameMapDao {

	@Override
	public List<GameMapDetail> getGameMap() {
		List<GameMapDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameMap");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameMapDetail> findGameMapByid(int id) {
		List<GameMapDetail> list = null;
		try {
			list = sqlMapper.queryForList("findGameMapByid", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}
}
