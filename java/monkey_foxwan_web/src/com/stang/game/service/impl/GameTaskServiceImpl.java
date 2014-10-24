package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IGameTaskDao;
import com.stang.game.dao.impl.GameTaskDaoImpl;
import com.stang.game.entity.detail.GameTaskDetail;
import com.stang.game.service.IGameTaskService;

public class GameTaskServiceImpl extends BaseServiceImpl<GameTaskDetail>
		implements IGameTaskService {
	protected IGameTaskDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GameTaskDaoImpl();
		}
		return (IGameTaskDao) baseDao;
	}

	public List<GameTaskDetail> findAllTask(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findAllTask(param);
	}

	public List<GameTaskDetail> findGameTaskByid(int id) {
		// TODO Auto-generated method stub
		return getBaseDao().findGameTaskByid(id);
	}

	public List<GameTaskDetail> getGameTask() {
		// TODO Auto-generated method stub
		return getBaseDao().getGameTask();
	}

	public boolean insertGametask(GameTaskDetail model) {
		// TODO Auto-generated method stub
		return getBaseDao().insertGametask(model);
	}

	public boolean updateGametask(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().updateGametask(param);
	}

	

}
