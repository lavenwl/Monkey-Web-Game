package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameVipDao;
import com.stang.game.entity.detail.GameRoleDetail;
import com.stang.game.entity.detail.GameVipDetail;

public class GameVipDaoImpl extends EntityDao<GameVipDetail> implements
		IGameVipDao {

	@Override
	public List<GameVipDetail> allGameVips() {
		List<GameVipDetail> list = null;
		try {
			list = sqlMapper.queryForList("allGameVips");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameVipDetail> getGameVipByLe(int level) {
		List<GameVipDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameVipByLe", level);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameVipDetail> getGameVipByAllvipRmb(int vipRmb) {
		List<GameVipDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameVipByAllvipRmb", vipRmb);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

}
