package com.stang.game.ffd.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.common.PageProperty;
import com.stang.game.ffd.dao.ILogRejectDao;
import com.stang.game.ffd.entity.detail.LogRejectDetail;
import com.stang.game.ffd.entity.detail.LogSendGiftDetail;
import com.stang.game.ffd.service.ILogRejectService;
import com.sun.xml.internal.stream.Entity;

public class LogRejectDaoImpl extends EntityDao<LogRejectDetail> implements ILogRejectDao {

	public List<LogRejectDetail> getLogRejectByParam(Map<String, Object> param) {
		List<LogRejectDetail> legrd = null;
		try {
			legrd = this.sqlMapper.queryForList("getLogRejectByParam", param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return legrd;

	}


	public void updateLogRejectByParam(Map<String, Object> param) {
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateLogRejectByParam", param);
			sqlMapper.commitTransaction();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		
	}

	public void insertLogReject(LogRejectDetail lrd) {
		try {
			this.sqlMapper.startTransaction();
			this.sqlMapper.insert("insertLogReject", lrd);
			this.sqlMapper.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.sqlMapper.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public int getLogRejectCount(Map<String, Object> param) {
		List<Integer> list = null;
		try {
			list = this.sqlMapper.queryForList("getLogRejectCount", param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(list.size()>0){
			return list.get(0);
		}
		return 0;

	}

}
