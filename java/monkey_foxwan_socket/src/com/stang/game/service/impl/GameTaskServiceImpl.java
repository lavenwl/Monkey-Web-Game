package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.cache.CacheGameTask;
import com.stang.game.dao.IGameTaskDao;
import com.stang.game.dao.impl.GameTaskDaoImpl;
import com.stang.game.entity.detail.GameRoleDetail;
import com.stang.game.entity.detail.GameTaskDetail;
import com.stang.game.service.IGameTaskService;

public class GameTaskServiceImpl extends BaseServiceImpl<GameTaskDetail>
		implements IGameTaskService {
	CacheGameTask c0;
	private CacheGameTask c(){
		if(c0==null){
		 c0=new CacheGameTask();
		}
		return c0;
	}
	protected IGameTaskDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GameTaskDaoImpl();
		}
		return (IGameTaskDao) baseDao;
	}

	@Override
	public List<GameTaskDetail> getAllGameTask() {
		return c().getAllGameTask();
		//return getBaseDao().getAllGameTask();
	}

	@Override
	public List<GameTaskDetail> getGameTaskDetail(Map<String, Object> map) {
		return c().getGameTaskDetail(map);
		//return getBaseDao().getGameTaskDetail(map);
	}

	@Override
	public List<GameTaskDetail> getGameTaskDetailById(int id) {
		return c().getGameTaskDetailById(id);

		//return getBaseDao().getGameTaskDetailById(id);
	}

	@Override
	public List<GameTaskDetail> getGameTaskDetailByLv(int rolelevel) {
		return c().getGameTaskDetailByLv(rolelevel);

		//return getBaseDao().getGameTaskDetailByLv(rolelevel);
	}

	@Override
	public List<GameTaskDetail> getGameTaskDetailByType(int type) {
		return c().getGameTaskDetailByType(type);

		//return getBaseDao().getGameTaskDetailByType(type);
	}

	@Override
	public List<GameTaskDetail> getGameTaskDetailByLvandold(int level, int old) {
		return c().getGameTaskDetailByLvandold(level, old);

		//return getBaseDao().getGameTaskDetailByLvandold(level, old);
	}

	@Override
	public List<GameTaskDetail> getGameTaskDetailByoId(int oid) {
		return c().getGameTaskDetailByoId(oid);

		//return getBaseDao().getGameTaskDetailByoId(oid);
	}

	@Override
	public List<GameTaskDetail> getGameTaskDetailByTypeTasktype(int type,
			int tasktype) {
		return c().getGameTaskDetailByTypeTasktype(type, tasktype);

		//return getBaseDao().getGameTaskDetailByTypeTasktype(type, tasktype);
	}
    
	@Override
	public GameTaskDetail findGameTaskDetailById(int id) {
		return c().findGameTaskDetailById(id);

		//return getBaseDao().findGameTaskDetailById(id);
	}

	@Override
	public List<GameTaskDetail> findAllGameTask() {
		// TODO Auto-generated method stub
		return getBaseDao().findAllGameTask();
	}


}
