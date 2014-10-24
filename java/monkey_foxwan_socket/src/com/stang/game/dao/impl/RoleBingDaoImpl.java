package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IRoleBingDao;
import com.stang.game.entity.detail.RoleBingDetail;

public class RoleBingDaoImpl extends EntityDao<RoleBingDetail> implements IRoleBingDao{

	@Override
	public List<RoleBingDetail> findRoleBingByParams(Map<String, Object> param) {
		List<RoleBingDetail> list =null;
		try {
			list = sqlMapper.queryForList("findRoleBingByParams",param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public boolean insertRoleBing(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertRoleBing",param);
			sqlMapper.commitTransaction();
			isSuccess = true;
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}finally{
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("", e);
			}
		}
		return isSuccess;
	}

	@Override
	public boolean updateRoleBing(Map<String, Object> param) {
		boolean bo = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateRoleBing",param);
			sqlMapper.commitTransaction();
			bo = true;
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}finally{
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("", e);
			}
		}
		return bo;
	}

	@Override
	public List<RoleBingDetail> findAllRoleBing() {
		List<RoleBingDetail> list =null;
		try {
			list = sqlMapper.queryForList("findAllRoleBing");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public boolean insertRoleBing(RoleBingDetail roleBingDetail) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertRoleBingtwo",roleBingDetail);
			sqlMapper.commitTransaction();
			isSuccess = true;
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}finally{
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("", e);
			}
		}
		return isSuccess;
	}

	@Override
	public boolean updateRoleBing(RoleBingDetail roleBingDetail) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("updateRoleBingtwo",roleBingDetail);
			sqlMapper.commitTransaction();
			isSuccess = true;
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}finally{
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("", e);
			}
		}
		return isSuccess;
	}

}
