package com.stang.game.ffd.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGameRaceBattleDao;
import com.stang.game.ffd.entity.detail.GameRaceBattleDetail;


public class GameRaceBattleDaoImpl extends EntityDao<GameRaceBattleDetail>
		implements IGameRaceBattleDao {

	public List<GameRaceBattleDetail> getGameRaceBattleDetail(
			Map<String, Object> map) {
		List<GameRaceBattleDetail> races = null;

		try {
			races = sqlMapperFlight.queryForList("getGameRaceBattleDetail", map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return races;
	}

	public void insertGameRaceBattleDetail(GameRaceBattleDetail grbd) {
		try {
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.insert("insertGameRaceBattleDetail", grbd);
			sqlMapperFlight.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				sqlMapperFlight.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void updateGameRaceBattleDetail(GameRaceBattleDetail grbd) {
		try {
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.insert("updateGameRaceBattleDetail", grbd);
			sqlMapperFlight.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				sqlMapperFlight.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
