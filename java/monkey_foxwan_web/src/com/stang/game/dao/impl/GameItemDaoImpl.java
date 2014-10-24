package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameItemDao;
import com.stang.game.entity.detail.GameItemDetail;

public class GameItemDaoImpl extends EntityDao<GameItemDetail> implements
		IGameItemDao {

	public List<GameItemDetail> getGameItem() {
		List<GameItemDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameItem");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<GameItemDetail> getGameItemById(int id) {
		List<GameItemDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameItemById", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<GameItemDetail> getGameItemId(String itemname) {
		List<GameItemDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameItemId", itemname);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<GameItemDetail> findAllItem(Map<String, Object> param) {
		List<GameItemDetail> list=null;
		try {
			list = sqlMapper.queryForList("findAllItem", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	
	
	}

	public boolean insertGameItem(GameItemDetail model) {

		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertGameItem", model);
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

	public boolean updateGameItem(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateGameItem", param);
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
