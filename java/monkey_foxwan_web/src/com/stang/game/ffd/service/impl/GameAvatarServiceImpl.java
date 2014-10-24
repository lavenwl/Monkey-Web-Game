package com.stang.game.ffd.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGameAvatarDao;
import com.stang.game.ffd.dao.impl.GameAvatarDaoImpl;
import com.stang.game.ffd.entity.detail.EntityGameAvatarDetail;
import com.stang.game.ffd.service.IGameAvatarService;

public class GameAvatarServiceImpl extends BaseServiceImpl<EntityGameAvatarDetail> implements IGameAvatarService {
	
	public IGameAvatarDao getBasedao(){
		if(this.baseDao==null){
			baseDao= new GameAvatarDaoImpl();
		}
		return (IGameAvatarDao)baseDao;
	}
	
	public List<EntityGameAvatarDetail> getAllInfo(Map<String,Object> parm){
		return this.getBasedao().getAllInfo(parm);
	}

	public String getAvatarNameById(Map<String, Object> param) {
		return this.getBasedao().getAvatarNameById(param);
	}
}
