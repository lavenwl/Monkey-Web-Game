package com.stang.game.ffd.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.common.PageProperty;
import com.stang.game.ffd.dao.ILogSendGiftDetailDao;
import com.stang.game.ffd.dao.impl.EntityDao;
import com.stang.game.ffd.entity.detail.EntityKeyWordDetail;
import com.stang.game.ffd.entity.detail.LogSendGiftDetail;

public class LogSendGiftDetailDaoImpl extends EntityDao<LogSendGiftDetail>
		implements ILogSendGiftDetailDao {

	public void deleteLogSendGiftDetail(Map<String, Object> param) {
		// TODO Auto-generated method stub
		try {
			this.sqlMapper.startTransaction();
			this.sqlMapper.insert("deleteLogSendGiftDetail", param);
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

	public List<LogSendGiftDetail> getLogSendGiftDetail(
			Map<String, Object> param) {
		List<LogSendGiftDetail> legrd = null;
		try {
			legrd = this.sqlMapper.queryForList("getLogSendGiftDetail", param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return legrd;
	}

	public void insertLogSendGiftDetail(Map<String, Object> param) {
		try {
			this.sqlMapper.startTransaction();
			this.sqlMapper.insert("insertLogSendGiftDetail", param);
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

	public void updateLogSendGiftDetail(Map<String, Object> param) {
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateLogSendGiftDetail", param);
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

	public int getLogSendGiftDetailCount() {
		List<Integer> legrd = null;
		try {
			legrd = this.sqlMapper.queryForList("getLogSendGiftDetailCount");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (legrd.size() > 0) {
			return legrd.get(0);
		} else {
			return 0;
		}
	}

}
