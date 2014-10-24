package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameBskillDao;
import com.stang.game.entity.detail.GameBskillDetail;

public class GameBskillDaoImpl  extends EntityDao<GameBskillDetail> implements IGameBskillDao{

	@Override
	public List<GameBskillDetail> getGameBskill() {
		List<GameBskillDetail> list =null;
		try {
			list = sqlMapper.queryForList("getGameBskill");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

}
