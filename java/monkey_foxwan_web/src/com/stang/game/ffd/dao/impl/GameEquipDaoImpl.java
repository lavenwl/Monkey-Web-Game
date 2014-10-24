package com.stang.game.ffd.dao.impl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGameEquipDao;
import com.stang.game.ffd.entity.detail.EntityGameEquipDetail;

public class GameEquipDaoImpl extends EntityDao<EntityGameEquipDetail> implements IGameEquipDao {

	public List<EntityGameEquipDetail> getallinfo(Map<String, Object> parm) {
		// TODO Auto-generated method stub
		List<EntityGameEquipDetail> leged=null;
		try {
			leged=this.sqlMapperFlight.queryForList("findGameEquipsByParam",parm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return leged;
	}

	public String getEquipNameById(Map<String, Object> param) {
		List<String> names = new ArrayList<String>();
		String name = null;
		try {
			names=this.sqlMapperFlight.queryForList("getEquipNameById",param);
			if(names.size()>0){
				name = names.get(0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}


}
