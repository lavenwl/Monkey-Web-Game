package com.stang.game.ffd.service.impl;


import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGameConsortiaDao;
import com.stang.game.ffd.dao.impl.GameConsortiaDaoImpl;
import com.stang.game.ffd.entity.EntityGameConsortia;
import com.stang.game.ffd.entity.detail.EntityGameConsortiaDetail;
import com.stang.game.ffd.service.IGameConsortiaService;

public class GameConsortialServiceImpl extends BaseServiceImpl<EntityGameConsortiaDetail> implements IGameConsortiaService {
	
	public IGameConsortiaDao getBaseDao(){
		if(baseDao==null){
			baseDao= new GameConsortiaDaoImpl();
		}
		return (IGameConsortiaDao)baseDao;
	}

	public List<EntityGameConsortiaDetail> getAllConsortiaInfo(Map<String,Object> parm) {
		// TODO Auto-generated method stub
		return this.getBaseDao().getAllConsortiaInfo(parm);
	}
	
	public int searchCountConsortia(Map<String,Object> param){
		return this.getBaseDao().searchCountConsortia(param);
	}
	
}
