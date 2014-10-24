package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameBingDao;
import com.stang.game.entity.detail.GameBingDetail;

public class GameBingDaoImpl extends EntityDao<GameBingDetail> implements IGameBingDao{

	@Override
	public List<GameBingDetail> getGameBing() {
		List<GameBingDetail> list=null;
		try {
			list = sqlMapper.queryForList("getGameBing");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameBingDetail> getGameBingById(Map<String,Object> param) {
		List<GameBingDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameBingById",param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

}
