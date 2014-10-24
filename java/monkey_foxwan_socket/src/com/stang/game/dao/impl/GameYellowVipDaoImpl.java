package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameYellowVipDao;
import com.stang.game.entity.detail.GameYellowVipDetail;
public class GameYellowVipDaoImpl extends EntityDao<GameYellowVipDetail>
implements IGameYellowVipDao{

	
	public List<GameYellowVipDetail> findAllYellowVip() {
		List<GameYellowVipDetail> list = null;
		try {
			list = sqlMapper.queryForList("findAllYellowVip");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}}
