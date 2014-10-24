package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.ICoinDao;
import com.stang.game.dao.IEntityDao;
import com.stang.game.entity.detail.CoinDetail;

public class CoinDaoImpl extends EntityDao<CoinDetail> implements ICoinDao{

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

	public List<CoinDetail> findAllcoin(Map<String, Object> param) {
		List<CoinDetail> list = null;
		try {
			list = sqlMapper.queryForList("findAllcoin", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	
	
	}

	public List<CoinDetail> getAllBuycoin() {
		List<CoinDetail> list = null;
		try {
			list = sqlMapper.queryForList("getAllBuycoin");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	
	}

	public List<CoinDetail> getBuycoin(int roleid) {
		List<CoinDetail> list = null;
		try {
			list = sqlMapper.queryForList("getBuycoin", roleid);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	
	}

	public List<CoinDetail> findcoinbytime(Map<String, Object> param) {
		List<CoinDetail> list=null;
		try {
			list = sqlMapper.queryForList("findcoinbytime", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	
	
	
	
	}

	public List<CoinDetail> findcoinbytimeandopenid(Map<String, Object> param) {
		List<CoinDetail> list=null;
		try {
			list = sqlMapper.queryForList("findcoinbytimeandopenid", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	
	}

}
