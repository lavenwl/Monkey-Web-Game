package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.ICdkStoreDao;
import com.stang.game.entity.CdkStore;
import com.stang.game.entity.detail.CdkStoreDetail;
import com.stang.game.entity.detail.GameRoleDetail;

public class CdkStoreDaoImpl extends EntityDao<CdkStoreDetail> implements ICdkStoreDao{

	@Override
	public boolean Updatemploy(String employ, String cdk) {

		boolean isSuccess = false;
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("cdk", cdk);
			param.put("employ", employ);
			sqlMapper.startTransaction();
			sqlMapper.update("Updatemploy", param);
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

	@Override
	public List<CdkStoreDetail> findCdkStoreBycdk(String cdk) {
		List<CdkStoreDetail> roles = null;
		try {
			roles = sqlMapper.queryForList("findCdkStoreBycdk", cdk);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
			System.out.println(e);
		}
		if (!roles.isEmpty()) {
			return roles;
		} else {
			return null;
		}
	}

	@Override
	public boolean Updatemploy(CdkStoreDetail detail) {

		boolean isSuccess = false;
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("cdk", detail.getCdk());
			param.put("employ", detail.getEmploy());
			sqlMapper.startTransaction();
			sqlMapper.update("Updatemploy", param);
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
