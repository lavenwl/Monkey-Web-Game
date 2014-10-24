package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameSkillDao;
import com.stang.game.entity.detail.GameSkillDetail;

public class GameSkillDaoImpl extends EntityDao<GameSkillDetail> 
	implements IGameSkillDao{

	@Override
	public List<GameSkillDetail> getGameSkill() {
		List<GameSkillDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameSkill");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameSkillDetail> getGameSkillById(int id) {
		List<GameSkillDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameSkillById",id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}
	
}
