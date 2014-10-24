package com.stang.game.ffd.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGameRaceLogDao;
import com.stang.game.ffd.entity.detail.GameRaceLogDetail;


public class GameRaceLogDaoImpl extends EntityDao<GameRaceLogDetail> implements
		IGameRaceLogDao {

	public List<GameRaceLogDetail> getGameRaceLogDetail(Map<String, Object> map) {
	List<GameRaceLogDetail> races = null;
		
		try {
			races = sqlMapperFlight.queryForList("getGameRaceLogDetail",map);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return races;
	}

	public void insertGameRaceLogDetail(GameRaceLogDetail grld) {
		try {
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.insert("insertGameRaceLogDetail", grld);
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

	public void updateGameRaceLogDetail(GameRaceLogDetail grld) {
		try {
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.update("updateGameRaceLogDetail", grld);
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
