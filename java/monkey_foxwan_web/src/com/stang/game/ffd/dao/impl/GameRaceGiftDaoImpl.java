package com.stang.game.ffd.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGameRaceGiftDao;
import com.stang.game.ffd.entity.detail.GameRaceGiftDetail;


public class GameRaceGiftDaoImpl extends EntityDao<GameRaceGiftDetail>
		implements IGameRaceGiftDao {

	public List<GameRaceGiftDetail> getGameRaceGiftDetail(
			Map<String, Object> map) {
		List<GameRaceGiftDetail> races = null;

		try {
			races = sqlMapperFlight.queryForList("getGameRaceGiftDetail", map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return races;
	}

	public void insertGameRaceGiftDetail(GameRaceGiftDetail grgd) {
		try {
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.insert("insertGameRaceGiftDetail", grgd);
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
	public void updateGameRaceGiftDetail(GameRaceGiftDetail grgd) {
		try {
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.insert("updateGameRaceGiftDetail", grgd);
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
