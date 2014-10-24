package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameMLevelDao;
import com.stang.game.entity.detail.GameMLevelDetail;

public class GameMLevelDaoImpl extends EntityDao<GameMLevelDetail> implements
		IGameMLevelDao {

	@Override
	public List<GameMLevelDetail> getGameMLevel() {
		List<GameMLevelDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameMLevel");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameMLevelDetail> getGameMLevelBylevel(int level) {
		List<GameMLevelDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameMLevelBylevel",level);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameMLevelDetail> getGameMLevelByAllexp(int allexp) {
		List<GameMLevelDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameMLevelByAllexp",allexp);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

}
