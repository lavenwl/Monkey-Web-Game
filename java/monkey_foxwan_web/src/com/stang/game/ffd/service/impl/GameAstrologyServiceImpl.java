package com.stang.game.ffd.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGameAstrologyDao;
import com.stang.game.ffd.dao.impl.GameAstrologyDaoImpl;
import com.stang.game.ffd.entity.detail.EntityGameAstrologyDetail;
import com.stang.game.ffd.service.IGameAstrologyService;

public class GameAstrologyServiceImpl extends BaseServiceImpl<EntityGameAstrologyDetail> implements
IGameAstrologyService{
	public IGameAstrologyDao getBaseDao(){
		if(this.baseDao==null){
			baseDao=new GameAstrologyDaoImpl();
		}
		return (IGameAstrologyDao)baseDao;
	}
	
	public int addGameAstrology(EntityGameAstrologyDetail params) {
		// TODO Auto-generated method stub
		return this.getBaseDao().addGameAstrology(params);
	}

	public List<EntityGameAstrologyDetail> findAllGameAstrology(
			Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.getBaseDao().findAllGameAstrology(params);
	}

	public int updateGameAstrology(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.getBaseDao().updateGameAstrology(params);
	}

}
