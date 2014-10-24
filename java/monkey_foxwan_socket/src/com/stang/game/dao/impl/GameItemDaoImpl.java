package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameItemDao;
import com.stang.game.entity.detail.GameItemDetail;

public class GameItemDaoImpl extends EntityDao<GameItemDetail> implements
		IGameItemDao {

	@Override
	public List<GameItemDetail> getGameItem() {
		List<GameItemDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameItem");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameItemDetail> getGameItemById(int id) {
		List<GameItemDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameItemById", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public void ClrAllModel() {
		sqlMapper.flushDataCache();
	}

	@Override
	public List<GameItemDetail> getGameItemByIdtwo(int id) {
		List<GameItemDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameItemByIdtwo", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameItemDetail> getGameItemByItemtype() {
		List<GameItemDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameItemByItemtype");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

}
