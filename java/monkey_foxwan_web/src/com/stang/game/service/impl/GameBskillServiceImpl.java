package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IGameBskillDao;
import com.stang.game.dao.impl.GameBskillDaoImpl;
import com.stang.game.entity.detail.GameBskillDetail;
import com.stang.game.service.IGameBskillService;

public class GameBskillServiceImpl extends BaseServiceImpl<GameBskillDetail> implements IGameBskillService{

	protected IGameBskillDao getBaseDao(){
		if(baseDao==null){
			baseDao = new GameBskillDaoImpl();
		}
		return (IGameBskillDao) baseDao;
	}

	public List<GameBskillDetail> findAllBskill(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findAllBskill(param);
	}

	public List<GameBskillDetail> findGameBskillByid(int id) {
		// TODO Auto-generated method stub
		return getBaseDao().findGameBskillByid(id);
	}

	public List<GameBskillDetail> getGameBskill() {
		// TODO Auto-generated method stub
		return getBaseDao().getGameBskill();
	}

	public boolean insertGameBskill(GameBskillDetail model) {
		// TODO Auto-generated method stub
		return getBaseDao().insertGameBskill(model);
	}

	public boolean updateGameBskill(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().updateGameBskill(param);
	}
	


}
