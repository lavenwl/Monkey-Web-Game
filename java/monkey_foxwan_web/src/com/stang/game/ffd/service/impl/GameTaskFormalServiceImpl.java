package com.stang.game.ffd.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGameTaskFormalDao;
import com.stang.game.ffd.dao.impl.GameTaskFormalDaoImpl;
import com.stang.game.ffd.entity.detail.GameTaskFormalDetail;

import com.stang.game.ffd.service.IGameTaskFormalService;

public class GameTaskFormalServiceImpl extends BaseServiceImpl<GameTaskFormalDetail> implements IGameTaskFormalService {

	public IGameTaskFormalDao getBaseDao(){
		if(this.baseDao == null){
			this.baseDao = new GameTaskFormalDaoImpl();
		}
		return (IGameTaskFormalDao)baseDao;
	}
	
	public List<GameTaskFormalDetail> getAllInfo(Map<String,Object> parms){
		return this.getBaseDao().getAllInfo(parms);
	}
	
	public List<GameTaskFormalDetail> getGameTaskFormal(
			Map<String, Object> param){
		return this.getBaseDao().getGameTaskFormal(param);
	}

	public int updateGameTaskFormal(Map<String, Object> param){
		return this.getBaseDao().updateGameTaskFormal(param);
	}
	
	public int addTaskFormal(GameTaskFormalDetail param){
		return this.getBaseDao().addTaskFormal(param);
	}
	public int getGameTaskFormalsId(){
		return this.getBaseDao().getGameTaskFormalsId();
	}
}
