package com.stang.game.ffd.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGamePlaneDao;
import com.stang.game.ffd.dao.impl.GamePlaneDaoImpl;
import com.stang.game.ffd.entity.detail.EntityGamePlaneDetail;
import com.stang.game.ffd.service.IGamePlaneService;

public class GamePlaneServiceImpl extends BaseServiceImpl<EntityGamePlaneDetail> implements IGamePlaneService {
	public IGamePlaneDao getBaseDao(){
		if(this.baseDao==null){
			baseDao = new GamePlaneDaoImpl();
		}
		return (IGamePlaneDao)baseDao;
	}

	public List<EntityGamePlaneDetail> getAllInfo(Map<String, Object> parm) {
		// TODO Auto-generated method stub
		return getBaseDao().getAllInfo(parm);
	}
	public String getPlaneNameById(Map<String,Object> param){
		return getBaseDao().getPlaneNameById(param);
	}
}
