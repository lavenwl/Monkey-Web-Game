package com.stang.game.ffd.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGameRaceRoleDao;
import com.stang.game.ffd.entity.detail.GameRaceRoleDetail;


public class GameRaceRoleDaoImpl extends EntityDao<GameRaceRoleDetail>
		implements IGameRaceRoleDao {

	public List<GameRaceRoleDetail> getGameRaceRoleDetail(
			Map<String, Object> map) {
		List<GameRaceRoleDetail> races = null;

		try {
			races = sqlMapperFlight.queryForList("getGameRaceRoleDetail", map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return races;
	}

	public void insertGameRaceRoleDetail(GameRaceRoleDetail grbd) {
		try {
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.insert("insertGameRaceRoleDetail", grbd);
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
	public void updateGameRaceRoleDetail(GameRaceRoleDetail grbd) {
		try {
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.insert("updateGameRaceRoleDetail", grbd);
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
