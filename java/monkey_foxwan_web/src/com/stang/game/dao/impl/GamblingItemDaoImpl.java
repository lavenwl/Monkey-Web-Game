package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGamblingItemDao;

import com.stang.game.entity.detail.GamblingItemDetail;
import com.stang.game.entity.detail.GameTaskDetail;
import com.stang.game.entity.detail.RoleMapDetail;

public class GamblingItemDaoImpl extends EntityDao<GamblingItemDetail>
		implements IGamblingItemDao {

	public List<GamblingItemDetail> findAllgambling_item(
			Map<String, Object> param) {
		List<GamblingItemDetail> list=null;
		try {
			list = sqlMapper.queryForList("findAllgambling_item", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	
	
	}

	public List<GamblingItemDetail> findgambling_itemByid(int id) {
		List<GamblingItemDetail> list = null;
		try {
			list = sqlMapper.queryForList("findgambling_itemByid", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<GamblingItemDetail> getgambling_item() {
		List<GamblingItemDetail> list = null;
		try {
			list = sqlMapper.queryForList("getgambling_item");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public boolean insertgambling_item(GamblingItemDetail model) {

		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertgambling_item", model);
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

	public boolean updateGamblingItemByParam(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateGamblingItemByParam", param);
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
	
	}}
