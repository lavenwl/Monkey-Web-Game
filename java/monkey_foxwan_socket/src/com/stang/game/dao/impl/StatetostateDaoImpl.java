package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import com.stang.game.common.GameConstants;
import com.stang.game.dao.IStatetostateDao;
import com.stang.game.entity.detail.StatetostateDetail;

public class StatetostateDaoImpl extends EntityDao<StatetostateDetail> implements IStatetostateDao{

	@Override
	public List<StatetostateDetail> findAllStatetostates1() {
		List<StatetostateDetail> list=null;
		try {
			list = sqlMapper.queryForList("findAllStatetostate1");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	}
	
	@Override
	public List<StatetostateDetail> findAllStatetostates2(long time) {
		List<StatetostateDetail> list=null;
		try {
			list = sqlMapper.queryForList("findAllStatetostate2", time);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	}

	@Override
	public boolean insertStatetostate(StatetostateDetail statetostateDetail) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertStatetostate",statetostateDetail);
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
	public boolean updateStatetostate(StatetostateDetail statetostateDetail) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("updateStatetostate",statetostateDetail);
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
