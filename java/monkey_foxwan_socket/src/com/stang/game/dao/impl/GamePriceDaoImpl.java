package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGamePriceDao;
import com.stang.game.entity.detail.GamePriceDetail;

public class GamePriceDaoImpl extends EntityDao<GamePriceDetail> implements
		IGamePriceDao {

	@Override
	public List<GamePriceDetail> getAllGamePrice() {
		List<GamePriceDetail> list = null;
		try {
			list = sqlMapper.queryForList("getAllGamePrice");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GamePriceDetail> getGamePriceById(int resId) {
		List<GamePriceDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGamePriceById", resId);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GamePriceDetail> getGamePrice(Map<String, Object> param) {
		List<GamePriceDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGamePrice", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

}
