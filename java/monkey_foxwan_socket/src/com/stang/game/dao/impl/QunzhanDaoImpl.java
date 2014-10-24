package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IQunzhanDao;
import com.stang.game.entity.detail.QunzhanDetail;

public class QunzhanDaoImpl extends EntityDao<QunzhanDetail> implements IQunzhanDao{

	@Override
	public List<QunzhanDetail> getallqunzhan() {
		List<QunzhanDetail> list=null;
		try {
			list = sqlMapper.queryForList("getallqunzhan");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
		
	
	
	}

}
