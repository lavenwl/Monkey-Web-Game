package com.stang.game.ffd.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGameAstrologyCorrectionDao;
import com.stang.game.ffd.entity.detail.EntityGameAstrologyCorrectionDetail;

public class GameAstrologyCorrectionDaoImpl extends EntityDao<EntityGameAstrologyCorrectionDetail> implements IGameAstrologyCorrectionDao {

	@SuppressWarnings("static-access")
	public int addGameAstrologyCorrection(
			EntityGameAstrologyCorrectionDetail params) {
		// TODO Auto-generated method stub
		try {
			this.sqlMapperFlight.insert("addGameAstrologyCorrection",params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@SuppressWarnings({ "unchecked", "static-access" })
	public List<EntityGameAstrologyCorrectionDetail> findGameAstrologyCorrection(
			Map<String, Object> params) {
		// TODO Auto-generated method stub
		List<EntityGameAstrologyCorrectionDetail> legcd=new ArrayList<EntityGameAstrologyCorrectionDetail>();
		try {
			legcd=this.sqlMapperFlight.queryForList("findGameAstrologyCorrection",params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return legcd;
	}

	public int updateGameAstrologyCorrection(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return 0;
	}

}
