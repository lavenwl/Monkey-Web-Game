package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameMilitaryDao;
import com.stang.game.entity.detail.GameMilitaryDetail;

public class GameMilitaryDaoImpl extends EntityDao<GameMilitaryDetail>
		implements IGameMilitaryDao {

	@Override
	public List<GameMilitaryDetail> getGameMilitary() {
		List<GameMilitaryDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameMilitary");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameMilitaryDetail> getGameMilitaryByBz(int pinzhi) {
		List<GameMilitaryDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameMilitaryByBz", pinzhi);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameMilitaryDetail> getGameMilitaryBymid(int mid) {
		List<GameMilitaryDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameMilitaryBymid", mid);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameMilitaryDetail> getGameMilitaryByparam(
			Map<String, Object> param) {
		List<GameMilitaryDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameMilitaryByparam", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameMilitaryDetail> getGameMilitaryBymid2(int mid) {
		System.out.println("getGameMilitaryBymid2");
		List<GameMilitaryDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameMilitaryBymid2", mid);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameMilitaryDetail> getManyTableSelect(int mid) {
		List<GameMilitaryDetail> list = null;
		try {
			list = sqlMapper.queryForList("getManyTableSelect", mid);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameMilitaryDetail> getManyTableSelect2(int mid) {
		List<GameMilitaryDetail> list = null;
		try {
			list = sqlMapper.queryForList("getManyTableSelect2", mid);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameMilitaryDetail> getMilitaryPinzhi(int mid) {
		List<GameMilitaryDetail> list = null;
		try {
			list = sqlMapper.queryForList("getMilitaryPinzhi", mid);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

}
