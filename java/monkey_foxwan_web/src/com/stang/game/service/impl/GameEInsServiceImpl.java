package com.stang.game.service.impl;

import java.util.List;

import com.stang.game.dao.IGameEInsDao;
import com.stang.game.dao.impl.GameEInsDaoImpl;
import com.stang.game.entity.detail.GameEInsDetail;
import com.stang.game.service.IGameEInsService;
public class GameEInsServiceImpl  extends BaseServiceImpl<GameEInsDetail>
   implements IGameEInsService{
	
	protected IGameEInsDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GameEInsDaoImpl();
		}
		return (IGameEInsDao) baseDao;
	}
	

	public List<GameEInsDetail> getGameEIns() {
		return getBaseDao().getGameEIns();
	}

	public List<GameEInsDetail> getGameEInsById(int id) {
		return getBaseDao().getGameEInsById(id);
	}

}
