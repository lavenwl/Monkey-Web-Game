package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameBbuffDao;
import com.stang.game.entity.detail.GameBbuffDetail;
import com.stang.game.entity.detail.GameBuffDetail;

public class GameBbuffDaoImpl extends EntityDao<GameBbuffDetail> implements IGameBbuffDao{

	@Override
	public List<GameBbuffDetail> getGameBbuff() {
		List<GameBbuffDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameBbuff");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

}
