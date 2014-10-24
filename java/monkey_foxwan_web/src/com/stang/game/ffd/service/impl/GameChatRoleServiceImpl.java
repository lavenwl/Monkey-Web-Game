package com.stang.game.ffd.service.impl;

import java.util.List;

import com.stang.game.ffd.dao.IGameChatRoleDao;
import com.stang.game.ffd.dao.impl.GameChatRoleDaoImpl;
import com.stang.game.ffd.entity.detail.EntityAreaCountDetail;
import com.stang.game.ffd.entity.detail.EntityGameChatRoleDetail;
import com.stang.game.ffd.service.IGameChatRoleService;

public class GameChatRoleServiceImpl extends BaseServiceImpl<EntityGameChatRoleDetail> implements IGameChatRoleService {

	public IGameChatRoleDao getBase(){
		if(this.baseDao==null){
			baseDao = new GameChatRoleDaoImpl(); 
		}
		return (IGameChatRoleDao)baseDao;
	}
	
	public List<EntityGameChatRoleDetail> getAllInfo() {
		// TODO Auto-generated method stub
		return this.getBase().getAllInfo();
	}
	
	public List<EntityGameChatRoleDetail> getAreaInfo(){
		return this.getBase().getAreaInfo();
	}

}
