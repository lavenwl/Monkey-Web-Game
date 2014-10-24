package com.stang.game.ffd.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGameRaceMapDao;
import com.stang.game.ffd.entity.detail.GameRaceMapDetail;

public class GameRaceMapDaoImpl extends EntityDao<GameRaceMapDetail> implements
		IGameRaceMapDao {

	public List<GameRaceMapDetail> getGameRaceMapDetail(
			Map<String, Object> map) {
		List<GameRaceMapDetail> races = null;

		try {
			races = sqlMapperFlight.queryForList("getGameRaceMapDetail", map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return races;
	}

	public void insertGameRaceMapDetail(GameRaceMapDetail grbd) {
		try {
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.insert("insertGameRaceMapDetail", grbd);
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
	public void updateGameRaceMapDetail(GameRaceMapDetail grbd) {
		try {
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.insert("updateGameRaceMapDetail", grbd);
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
