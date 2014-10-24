package com.stang.game.ffd.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGameEquipDao;
import com.stang.game.ffd.dao.impl.GameEquipDaoImpl;

import com.stang.game.ffd.entity.detail.EntityGameEquipDetail;

import com.stang.game.ffd.service.IGameEquipService;

public class GameEquipServiceImpl extends BaseServiceImpl<EntityGameEquipDetail> implements IGameEquipService {
	public IGameEquipDao getBaseDao(){
		if(this.baseDao==null){
			baseDao = new GameEquipDaoImpl();
		}
		return (IGameEquipDao)baseDao;
	}
	
	public List<EntityGameEquipDetail> getAllInfo(Map<String, Object> parm) {
		return getBaseDao().getallinfo(parm);
	}

	public String getEquipNameById(Map<String, Object> param) {
		return getBaseDao().getEquipNameById(param);
	}

}
