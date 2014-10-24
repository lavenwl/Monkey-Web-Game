package com.stang.game.ffd.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGameRaceConfDao;
import com.stang.game.ffd.entity.detail.GameRaceConfDetail;


public class GameRaceConfDaoImpl extends EntityDao<GameRaceConfDetail>
		implements IGameRaceConfDao {

	public List<GameRaceConfDetail> getGameRaceConfDetail(
			Map<String, Object> map) {
		List<GameRaceConfDetail> races = null;

		try {
			races = sqlMapperFlight.queryForList("getGameRaceConfDetail", map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return races;
	}

	public void insertGameRaceConfDetail(GameRaceConfDetail grbd) {
		try {
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.insert("insertGameRaceConfDetail", grbd);
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
	public void updateGameRaceConfDetail(GameRaceConfDetail grbd) {
		try {
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.insert("updateGameRaceConfDetail", grbd);
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

	public int getGameRaceConfCount() {
		List<Integer> list = null;
		try {
			list = this.sqlMapperFlight.queryForList("getGameRaceConfCount");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(list.size()>0){
			return list.get(0);
		}
		return 0;
	}



}
