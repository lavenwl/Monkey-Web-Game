package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IShopdiscountDao;
import com.stang.game.entity.detail.ShopdiscountDetail;
public class ShopdiscountDaoImpl extends EntityDao<ShopdiscountDetail> implements IShopdiscountDao{

	@Override
	public List<ShopdiscountDetail> getShopdiscount(Map<String, Object> param) {
		List<ShopdiscountDetail> list = null;
		try {
			list = sqlMapper.queryForList("getShopdiscount",param);
		} catch (SQLException e) {
			GameConstants.log.warn("",e);
		}
		return list;
	}

}
