package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameEInsDao;
import com.stang.game.entity.detail.GameEInsDetail;
import com.stang.game.entity.detail.GameEPropertyDetail;
import com.stang.game.entity.detail.GameEquipDetail;
public class GameEInsDaoImpl extends EntityDao<GameEInsDetail> implements
IGameEInsDao{

	public List<GameEInsDetail> getGameEIns() {
		List<GameEInsDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameEIns");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<GameEInsDetail> getGameEInsById(int id) {
		List<GameEInsDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameEInsById", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

}
