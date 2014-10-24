package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IActivityDao;
import com.stang.game.entity.detail.ActivityDetail;


public class ActivityDaoImpl extends EntityDao<ActivityDetail> implements IActivityDao{

	
	public List<ActivityDetail> getActivityByParams(Map<String, Object> param) {
		List<ActivityDetail> list = null;
		try {
			list = sqlMapper.queryForList("getActivityByParams",param);
		} catch (SQLException e) {
			GameConstants.log.warn("",e);
		}
		return list;
	}

	public boolean updateActivityById(Map<String,Object> param) {
		boolean bo = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateActivityById", param);
			sqlMapper.commitTransaction();
			bo = true;
		} catch (SQLException e) {
			GameConstants.log.warn("",e);
		}
		return bo;
	}

}
