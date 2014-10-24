package com.stang.game.ffd.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGameAstrologyDao;
import com.stang.game.ffd.entity.detail.EntityGameAstrologyDetail;

public class GameAstrologyDaoImpl extends EntityDao<EntityGameAstrologyDetail> implements IGameAstrologyDao {

	public int addGameAstrology(EntityGameAstrologyDetail params) {
		int result=0;
		try {
			this.sqlMapperFlight.insert("addGameAstrology", params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@SuppressWarnings({ "unchecked", "static-access" })
	public List<EntityGameAstrologyDetail> findAllGameAstrology(
			Map<String, Object> params) {
		// TODO Auto-generated method stub
		List<EntityGameAstrologyDetail> legad= new ArrayList<EntityGameAstrologyDetail>();
		try {
			legad=this.sqlMapperFlight.queryForList("findGameAstrology",params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return legad;
	}

	public int updateGameAstrology(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
