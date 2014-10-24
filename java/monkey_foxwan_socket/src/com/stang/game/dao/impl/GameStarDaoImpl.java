package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameStarDao;
import com.stang.game.entity.detail.GameStarDetail;

public class GameStarDaoImpl extends EntityDao<GameStarDetail> implements IGameStarDao{

	@Override
	public List<GameStarDetail> getgamestars(int starlevel) {
		List<GameStarDetail> list = null;
		try {
			list = sqlMapper.queryForList("getgamestars", starlevel);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameStarDetail> getallgamestar() {
		List<GameStarDetail> list = null;
		try {
			list = sqlMapper.queryForList("getallgamestar");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

}
