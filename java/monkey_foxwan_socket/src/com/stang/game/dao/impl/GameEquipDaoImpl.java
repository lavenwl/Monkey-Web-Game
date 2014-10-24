package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameEquipDao;
import com.stang.game.entity.detail.GameEquipDetail;

public  class GameEquipDaoImpl extends EntityDao<GameEquipDetail> implements
		IGameEquipDao {

	@Override
	public List<GameEquipDetail> getGameEquip() {
		List<GameEquipDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameEquip");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameEquipDetail> getGameEquipById(int id) {
		List<GameEquipDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameEquipById", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameEquipDetail> getGameEquipByEid(int eid) {
		List<GameEquipDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameEquipByEid", eid);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

}
