package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameBmapDao;
import com.stang.game.entity.detail.GameBmapDetail;

public class GameBmapDaoImpl extends EntityDao<GameBmapDetail> implements IGameBmapDao{

	@Override
	public List<GameBmapDetail> getGameBmap() {
		List<GameBmapDetail> list=null;
		try {
			list = sqlMapper.queryForList("getGameBmap");
		} catch (SQLException e) {
			GameConstants.log.warn("",e);
		}
		return list;
	}

	@Override
	public List<GameBmapDetail> findGameBmapByParams(Map<String, Object> param) {
		List<GameBmapDetail> list =null;
		try {
			list = sqlMapper.queryForList("findGameBmapByParams", param);
		} catch (SQLException e) {
			GameConstants.log.warn("",e);
		}
		return list;
	}

}
