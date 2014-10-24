package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IZhugongDao;
import com.stang.game.entity.detail.DantiaoDetail;
import com.stang.game.entity.detail.ZhugongDetail;

public class ZhugongDaoImpl extends EntityDao<ZhugongDetail> implements IZhugongDao{

	public List<ZhugongDetail> getallzhugong() {
		List<ZhugongDetail> list=null;
		try {
			list = sqlMapper.queryForList("getallzhugong");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;}

}
