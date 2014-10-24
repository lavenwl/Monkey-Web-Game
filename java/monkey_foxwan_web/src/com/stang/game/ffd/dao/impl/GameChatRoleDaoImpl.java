package com.stang.game.ffd.dao.impl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stang.game.ffd.dao.IGameChatRoleDao;
import com.stang.game.ffd.entity.detail.EntityAreaCountDetail;
import com.stang.game.ffd.entity.detail.EntityGameChatRoleDetail;

public class GameChatRoleDaoImpl extends EntityDao<EntityGameChatRoleDetail> implements IGameChatRoleDao {

	public List<EntityGameChatRoleDetail> getAllInfo() {
		// TODO Auto-generated method stub
		List<EntityGameChatRoleDetail> legcrd = new ArrayList<EntityGameChatRoleDetail>();
		try {
			legcrd=sqlMapperFlight.queryForList("getmember");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return legcrd;
	}
	
	public List<EntityGameChatRoleDetail> getAreaInfo(){
		List<EntityGameChatRoleDetail> legcrd = new ArrayList<EntityGameChatRoleDetail>();
		try{
			legcrd=sqlMapperFlight.queryForList("getareainfo");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return legcrd;
	}
	

}
