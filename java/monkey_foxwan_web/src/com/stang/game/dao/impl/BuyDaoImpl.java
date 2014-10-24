package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IBuyDao;
import com.stang.game.entity.detail.BuyDetail;
import com.stang.game.entity.detail.GameItemDetail;

public class BuyDaoImpl extends EntityDao<BuyDetail> implements IBuyDao{

	public List<BuyDetail> getBuy(String openid) {
		List<BuyDetail> list = null;
		try {
			list = sqlMapper.queryForList("getBuy", openid);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	}

	public List<BuyDetail> getAllBuy() {
		List<BuyDetail> list = null;
		try {
			list = sqlMapper.queryForList("getAllBuy");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	}

	public List<BuyDetail> findAll(Map<String, Object> param) {
		List<BuyDetail> list=null;
		try {
			list = sqlMapper.queryForList("findAll", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	
	}

	public List<BuyDetail> findbytime(Map<String, Object> param) {
		List<BuyDetail> list=null;
		try {
			list = sqlMapper.queryForList("findbytime", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	
	
	
	
	}

	public List<BuyDetail> findbytimeandopenid(Map<String, Object> param) {
		List<BuyDetail> list=null;
		try {
			list = sqlMapper.queryForList("findbytimeandopenid", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	
	}

}
