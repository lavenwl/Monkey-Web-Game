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

	public List<GamblingItemDetail> getGamblingItem(Map<String, Object> param) {
		long t1 = new Date().getTime();
		List<GamblingItemDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGamblingItem", param);
		} catch (Exception e) {
			GameConstants.log.warn("", e);
		}
		long t2 = new Date().getTime();
		if (t2 - t1 > 300) {
			GameConstants.log.error("服务器卡 数据库连接" + "getGamblingItem");
		}
		return list;
	}

	public boolean insertGamblingItem(GamblingItemDetail model){
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertGamblingItem", model);
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
	
	public boolean updateGamblingItem(GamblingItemDetail model){
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateGamblingItem", model);
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
	
	public void updateGamblingItemByParam(Map<String, Object> param) {
		long t1 = new Date().getTime();
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateGamblingItemByParam", param);
			sqlMapper.commitTransaction();
		} catch (Exception e) {
			GameConstants.log.warn("", e);
		} finally {
			try {
				sqlMapper.endTransaction();
				long t2 = new Date().getTime();
				if (t2 - t1 > 300) {
					GameConstants.log.error("服务器卡 数据库连接"
							+ "updateGamblingItemByParam");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				GameConstants.log.warn("", e);
			}
		}

	}

	public void insertGamblingItemByParam(Map<String, Object> param) {
	}

	@Override
	public List<GamblingItemDetail> getGamblingItemBytype(int type) {
		long t1 = new Date().getTime();
		List<GamblingItemDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGamblingItemBytype", type);
		} catch (Exception e) {
			GameConstants.log.warn("", e);
		}
		long t2 = new Date().getTime();
		if (t2 - t1 > 300) {
			GameConstants.log.error("服务器卡 数据库连接" + "getGamblingItem");
		}
		return list;
	}

	@Override
	public List<GamblingItemDetail> getGamblingItemBymid(int mid) {
		long t1 = new Date().getTime();
		List<GamblingItemDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGamblingItemBymid", mid);
		} catch (Exception e) {
			GameConstants.log.warn("", e);
		}
		long t2 = new Date().getTime();
		if (t2 - t1 > 300) {
			GameConstants.log.error("服务器卡 数据库连接" + "getGamblingItem");
		}
		return list;
	}

	@Override
	public List<GamblingItemDetail> getGamblingItemByparam(Map<String, Object> param) {
		List<GamblingItemDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGamblingItemByparam", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GamblingItemDetail> findAllGamblingItem() {
		List<GamblingItemDetail> list = null;
		try {
			list = sqlMapper.queryForList("findAllGamblingItem");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

}
