package com.stang.game.ffd.dao.impl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.stang.game.ffd.dao.IGameAvatarDao;
import com.stang.game.ffd.entity.detail.EntityGameAvatarDetail;

public class GameAvatarDaoImpl extends EntityDao<EntityGameAvatarDetail> implements IGameAvatarDao {

	public List<EntityGameAvatarDetail> getAllInfo(Map<String, Object> parm) {
		// TODO Auto-generated method stub
		List<EntityGameAvatarDetail> legad= new ArrayList<EntityGameAvatarDetail>();
		try {
			legad=sqlMapperFlight.queryForList("getEntityGameAvatarDetail",parm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return legad;
	}

	public String getAvatarNameById(Map<String, Object> param) {
		List<String> names = new ArrayList<String>();
		String name = null;
		try {
			names=this.sqlMapperFlight.queryForList("getAvatarNameById",param);
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
