package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.ICoinDao;
import com.stang.game.dao.IEntityDao;
import com.stang.game.entity.detail.CoinDetail;

public class CoinDaoImpl extends EntityDao<CoinDetail> implements ICoinDao{

	@Override
	public boolean insertCoin(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertCoin",param);
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
	public List<CoinDetail> findAllCoin() {
		List<CoinDetail> list = null;
		try {
			list = sqlMapper.queryForList("findAllCoin");
		} catch (SQLException e) {
			GameConstants.log.warn("",e);
		}
		return list;
	}

	@Override
	public boolean insertCoin(CoinDetail CoinDetail) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertCointwo",CoinDetail);
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
