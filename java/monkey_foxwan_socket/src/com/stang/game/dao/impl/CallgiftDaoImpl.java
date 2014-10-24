package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.ICallgiftDao;
import com.stang.game.entity.detail.CallGiftDetail;
public class CallgiftDaoImpl extends EntityDao<CallGiftDetail>
implements ICallgiftDao{

	@Override
	public List<CallGiftDetail> getcallgift(int id) {
		List<CallGiftDetail> list = null;
		try {
			list = sqlMapper.queryForList("getcallgift",id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<CallGiftDetail> findAllCallGift() {
		List<CallGiftDetail> list = null;
		try {
			list = sqlMapper.queryForList("findAllCallGift");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}}
