package com.stang.game.ffd.dao.impl;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.ILogRejectIpsDao;
import com.stang.game.ffd.entity.detail.LogRejectDetail;
import com.stang.game.ffd.entity.detail.LogRejectIpsDetail;

public class LogRejectIpsDaoImpl extends EntityDao<LogRejectIpsDetail>
		implements ILogRejectIpsDao {

	public List<LogRejectIpsDetail> getLogRejectIpsDetailByParam(
			Map<String, Object> param) {
		List<LogRejectIpsDetail> legrd = null;
		try {
			legrd = this.sqlMapper.queryForList("getLogRejectIpsDetailByParam", param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return legrd;
	}

	public int getLogRejectIpsDetailCount() {
		List<Integer> list = null;
		try {
			list = this.sqlMapper.queryForList("getLogRejectIpsDetailCount");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(list.size()>0){
			return list.get(0);
		}
		return 0;
	}

	public void insertLogRejectIpsDetail(LogRejectIpsDetail lrd) {
		try {
			this.sqlMapper.startTransaction();
			this.sqlMapper.insert("insertLogRejectIpsDetail", lrd);
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

	public void updateLogRejectIpsByParam(Map<String, Object> param) {
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateLogRejectIpsByParam", param);
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




}
