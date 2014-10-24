package com.stang.game.ffd.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGameConsortiaDao;
import com.stang.game.ffd.entity.detail.EntityGameConsortiaDetail;

public class GameConsortiaDaoImpl extends EntityDao<EntityGameConsortiaDetail> implements IGameConsortiaDao {

	
	//@SuppressWarnings({ "unchecked", "static-access" })
	public List<EntityGameConsortiaDetail> getAllConsortiaInfo(Map<String,Object> parm) {
		// TODO Auto-generated method stub
		List<EntityGameConsortiaDetail> res=null;
		try {
			res=this.sqlMapperFlight.queryForList("listGameConsortiaDetail",parm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public int searchCountConsortia(Map<String,Object> param){
		int res=0;
		try{
		res=Integer.parseInt(this.sqlMapperFlight.queryForList("searchCountConsortia",param).get(0)+"");	
		}catch(SQLException e){
			e.printStackTrace();
		}
		return res;
	}

}
