package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IDantiaoDao;
import com.stang.game.entity.detail.DantiaoDetail;
public class DantiaoDaoImpl extends EntityDao<DantiaoDetail>
implements IDantiaoDao{

	@Override
	public List<DantiaoDetail> getalldantiao() {
		List<DantiaoDetail> list=null;
		try {
			list = sqlMapper.queryForList("getalldantiao");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
		
	
	
	}

}
