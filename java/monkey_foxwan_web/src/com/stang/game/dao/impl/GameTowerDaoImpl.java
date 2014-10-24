package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameTowerDao;
import com.stang.game.entity.detail.GameTowerDetail;

public class GameTowerDaoImpl extends EntityDao<GameTowerDetail> implements
		IGameTowerDao {

	public List<GameTowerDetail> getGameTower() {
		List<GameTowerDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameTower");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<GameTowerDetail> getGameTowerLevel(int towerid) {
		List<GameTowerDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameTowerLevel", towerid);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

}
