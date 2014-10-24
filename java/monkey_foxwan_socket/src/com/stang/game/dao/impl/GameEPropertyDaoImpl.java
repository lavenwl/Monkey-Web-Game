package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameEPropertyDao;
import com.stang.game.entity.detail.GameEPropertyDetail;
import com.stang.game.entity.detail.RoleItemDetail;
public class GameEPropertyDaoImpl extends EntityDao<GameEPropertyDetail> implements
IGameEPropertyDao {

	@Override
	public List<GameEPropertyDetail> getGameEPropertyById(int id) {
		List<GameEPropertyDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameEPropertyById", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameEPropertyDetail> getGameEProperty() {
		List<GameEPropertyDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameEProperty");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameEPropertyDetail> getGameEPropertyBytypequality(
			Map<String, Object> param) {
		List<GameEPropertyDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameEPropertyBytypequality", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	

}
