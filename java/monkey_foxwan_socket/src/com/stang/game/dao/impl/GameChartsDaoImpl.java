package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameChartsDao;
import com.stang.game.entity.detail.GameChartsDetail;

public class GameChartsDaoImpl extends EntityDao<GameChartsDetail> implements IGameChartsDao{

	@Override
	public boolean insertGameCharts(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertGameCharts",param);
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
	public List<GameChartsDetail> findByNum(Map<String, Object> param) {
		List<GameChartsDetail> list=null;
		try {
			list = sqlMapper.queryForList("findByNum", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public boolean updateGameCharts(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateGameCharts", param);
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
	public List<GameChartsDetail> findByDT(Map<String, Object> param) {
		List<GameChartsDetail> list=null;
		try {
			list = sqlMapper.queryForList("findByDT", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	}

	@Override
	public List<GameChartsDetail> findByQZ(Map<String, Object> param) {

		List<GameChartsDetail> list=null;
		try {
			list = sqlMapper.queryForList("findByQZ", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameChartsDetail> findalllie() {

		List<GameChartsDetail> list=null;
		try {
			list = sqlMapper.queryForList("findalllie");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameChartsDetail> getid(int roleId) {
		System.out.println("===getid执行dao=====");
		List<GameChartsDetail> list=null;
		try {
			list = sqlMapper.queryForList("getid", roleId);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
		
	}

	@Override
	public List<GameChartsDetail> getiddt(int roleId) {
		List<GameChartsDetail> list=null;
		try {
			list = sqlMapper.queryForList("getiddt", roleId);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
		
	
	}

	@Override
	public List<GameChartsDetail> getidqz(int roleId) {
		List<GameChartsDetail> list=null;
		try {
			list = sqlMapper.queryForList("getidqz", roleId);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
		
	
	
	}

	@Override
	public List<GameChartsDetail> findallliet() {

		List<GameChartsDetail> list=null;
		try {
			list = sqlMapper.queryForList("findallliet");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameChartsDetail> findalllief() {

		List<GameChartsDetail> list=null;
		try {
			list = sqlMapper.queryForList("findalllief");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	}

	@Override
	public List<GameChartsDetail> getall() {
		List<GameChartsDetail> list=null;
		try {
			list = sqlMapper.queryForList("getall");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
		
	
	
	}

	@Override
	public List<GameChartsDetail> findAllGameCharts() {
		List<GameChartsDetail> list=null;
		try {
			list = sqlMapper.queryForList("findAllGameCharts");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameChartsDetail> findByQZFirstTen(Map<String, Object> param) {

		List<GameChartsDetail> list=null;
		try {
			list = sqlMapper.queryForList("findByQZFirstTen", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	
}
