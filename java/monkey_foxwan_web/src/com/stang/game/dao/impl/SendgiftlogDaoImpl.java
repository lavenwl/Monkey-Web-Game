package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.SendgiftlogDao;
import com.stang.game.entity.detail.SendgiftlogDetail;

public class SendgiftlogDaoImpl extends EntityDao<SendgiftlogDetail> implements SendgiftlogDao{

	public boolean insertsendgift(SendgiftlogDetail model) {

		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertsendgift", model);
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

	public List<SendgiftlogDetail> getAllsfg() {
		List<SendgiftlogDetail> list = null;
		try {
			list = sqlMapper.queryForList("getAllsfg");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	}

}
