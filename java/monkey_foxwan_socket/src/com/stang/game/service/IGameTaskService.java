package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameTaskDetail;
import com.stang.game.entity.detail.RoleTaskDetail;

public interface IGameTaskService extends IBaseService<GameTaskDetail> {
	List<GameTaskDetail> getGameTaskDetail(Map<String, Object> map);
	List<GameTaskDetail> findAllGameTask();
	List<GameTaskDetail> getAllGameTask();

	List<GameTaskDetail> getGameTaskDetailById(int id);

	List<GameTaskDetail> getGameTaskDetailByoId(int oid);

	List<GameTaskDetail> getGameTaskDetailByLv(int rolelevel);

	List<GameTaskDetail> getGameTaskDetailByType(int type);

	List<GameTaskDetail> getGameTaskDetailByLvandold(int level, int old);
	
	//每日在线礼包，根据num获取
	List<GameTaskDetail> getGameTaskDetailByTypeTasktype(int type, int tasktype);
	
	public GameTaskDetail findGameTaskDetailById(int id);
	

}
