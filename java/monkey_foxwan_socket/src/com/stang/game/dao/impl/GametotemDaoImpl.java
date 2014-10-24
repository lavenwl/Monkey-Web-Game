package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import sun.security.action.GetBooleanAction;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGametotemDao;
import com.stang.game.entity.detail.GametotemDetail;
import com.stang.game.entity.detail.RoletotemDetail;

public class GametotemDaoImpl extends EntityDao<GametotemDetail> implements IGametotemDao{

	@Override
	public List<GametotemDetail> getGametotem() {
		List<GametotemDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGametotem");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GametotemDetail> getGametotembyid(int id) {
		List<GametotemDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGametotembyid", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GametotemDetail> getGametotembyparam(Map<String, Object> param) {
		List<GametotemDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGametotembyparam", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}


}
