package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IActivityDao;
import com.stang.game.entity.detail.ActivityDetail;

public class ActivityDaoImpl extends EntityDao<ActivityDetail> implements IActivityDao{

	@Override
	public List<ActivityDetail> getActivityByParams(Map<String, Object> param) {
		List<ActivityDetail> list = null;
		try {
			list = sqlMapper.queryForList("getActivityByParams",param);
		} catch (SQLException e) {
			GameConstants.log.warn("",e);
		}
		return list;
	}

	@Override
	public List<ActivityDetail> findAllActivity() {
		List<ActivityDetail> list = null;
		try {
			list = sqlMapper.queryForList("findAllActivity");
		} catch (SQLException e) {
			GameConstants.log.warn("",e);
		}
		return list;
	}

}
