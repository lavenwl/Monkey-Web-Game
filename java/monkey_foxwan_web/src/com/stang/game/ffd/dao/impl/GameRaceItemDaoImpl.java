package com.stang.game.ffd.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGameRaceItemDao;
import com.stang.game.ffd.entity.detail.GameRaceItemDetail;



public class GameRaceItemDaoImpl extends EntityDao<GameRaceItemDetail>
		implements IGameRaceItemDao {

	public List<GameRaceItemDetail> getGameRaceItemDetail(
			Map<String, Object> map) {
		List<GameRaceItemDetail> races = null;

		try {
			races = sqlMapperFlight.queryForList("getGameRaceItemDetail", map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return races;
	}

	public void insertGameRaceItemDetail(GameRaceItemDetail grbd) {
		try {
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.insert("insertGameRaceItemDetail", grbd);
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
	public void updateGameRaceItemDetail(GameRaceItemDetail grbd) {
		try {
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.insert("updateGameRaceItemDetail", grbd);
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
