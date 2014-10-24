package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameEquipDao;
import com.stang.game.entity.detail.GameEquipDetail;
import com.stang.game.entity.detail.GameTaskDetail;

public  class GameEquipDaoImpl extends EntityDao<GameEquipDetail> implements
		IGameEquipDao {

	public List<GameEquipDetail> getGameEquip() {
		List<GameEquipDetail> list = null;
		Map<String, Object> param=new HashMap<String, Object>();
		try {
			list = sqlMapper.queryForList("getGameEquip");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<GameEquipDetail> getGameEquipById(int id) {
		List<GameEquipDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameEquipById", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<GameEquipDetail> getGameEquipByEid(int eid) {
		List<GameEquipDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameEquipByEid", eid);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<GameEquipDetail> findAllEquip(Map<String, Object> param) {
		List<GameEquipDetail> list=null;
		try {
			list = sqlMapper.queryForList("findAllEquip", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	
	
	}

	public List<GameEquipDetail> findGameEquipByid(int id) {
		List<GameEquipDetail> list = null;
		try {
			list = sqlMapper.queryForList("findGameEquipByid", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public boolean insertGameequip(GameEquipDetail model) {

		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertGameEquip", model);
			sqlMapper.commitTransaction();
			isSuccess = true;
		} catch (Exception e) {
			GameConstants.log.warn("", e);
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("", e);
			}
		}
		return isSuccess;
	
	
	}

	public boolean updateGameequip(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateGameEquip", param);
			sqlMapper.commitTransaction();
			isSuccess = true;
		} catch (Exception e) {
			GameConstants.log.warn("", e);
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("", e);
			}
		}
		return isSuccess;
	
	}

}
