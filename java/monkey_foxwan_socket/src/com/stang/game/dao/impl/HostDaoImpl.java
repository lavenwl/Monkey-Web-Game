package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IHostDao;
import com.stang.game.entity.detail.HostDetail;
import com.stang.game.entity.detail.RoleChallengeDetail;

public class HostDaoImpl extends EntityDao<HostDetail> implements IHostDao{

	@Override
	public List<HostDetail> findHostByParam(Map<String, Object> param) {
		List<HostDetail> list = null;
		try {
			list = sqlMapper.queryForList("findHostByParam", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<HostDetail> findHostById(int id) {
		List<HostDetail> host = null;
		String s = String.valueOf(id);
		try {
			host = sqlMapper.queryForList("findHostByIdd", s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return host;
	}

	@Override
	public List<HostDetail> findAllHost() {
		List<HostDetail> list = null;
		try {
			list = sqlMapper.queryForList("findAllHost");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

}
