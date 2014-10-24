package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameBuffDao;
import com.stang.game.entity.detail.GameBuffDetail;
import com.stang.game.entity.detail.GameSkillDetail;

public class GameBuffDaoImpl extends EntityDao<GameBuffDetail> 
	implements IGameBuffDao{

	@Override
	public List<GameBuffDetail> getGameBuff() {
		List<GameBuffDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameBuff");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameBuffDetail> getGameBuffById(int id) {
		List<GameBuffDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameBuffById", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

}
