package com.stang.game.ffd.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGameTaskFormalDao;
import com.stang.game.ffd.entity.detail.GameTaskFormalDetail;

public class GameTaskFormalDaoImpl extends EntityDao<GameTaskFormalDetail> implements IGameTaskFormalDao {
	public List<GameTaskFormalDetail> getAllInfo(Map<String,Object> parms){
		List<GameTaskFormalDetail> legtfd= new ArrayList<GameTaskFormalDetail>();
		try {
			legtfd=this.sqlMapperFlight.queryForList("getGameTaskFormals",parms);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return legtfd;
	}

	public List<GameTaskFormalDetail> getGameTaskFormal(
			Map<String, Object> param) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateGameTaskFormal(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int addTaskFormal(GameTaskFormalDetail param){
		try {
			this.sqlMapperFlight.insert("insertGameTaskFormalDetail",param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public int getGameTaskFormalsId(){
		List<GameTaskFormalDetail> lgtfd=null;
		int id=0;
		try {
			lgtfd=this.sqlMapperFlight.queryForList("getGameTaskFormalsId");
			if(lgtfd.size()>0){
				id=lgtfd.get(0).getId();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	
	
}
