package com.stang.game.ffd.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGamePlaneDao;
import com.stang.game.ffd.entity.detail.EntityGamePlaneDetail;

public class GamePlaneDaoImpl extends EntityDao<EntityGamePlaneDetail>
		implements IGamePlaneDao {

	public List<EntityGamePlaneDetail> getAllInfo(Map<String, Object> parm) {
		// TODO Auto-generated method stub
		List<EntityGamePlaneDetail> legpd = null;
		try {
			legpd = this.sqlMapperFlight.queryForList(
					"getEntityGamePlaneDetail", parm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return legpd;
	}

	public String getPlaneNameById(Map<String, Object> param) {
		List<String> legpd = null;
		String name = null;
		try {
			legpd = this.sqlMapperFlight
					.queryForList("getPlaneNameById", param);
			for(int i = 0; i <legpd.size();i++){
				name = legpd.get(0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
}
