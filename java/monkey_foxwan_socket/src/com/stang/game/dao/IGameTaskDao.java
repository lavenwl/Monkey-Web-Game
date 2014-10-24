package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameRoleDetail;
import com.stang.game.entity.detail.GameTaskDetail;

public interface IGameTaskDao extends IEntityDao<GameTaskDetail> {
	List<GameTaskDetail> findAllGameTask();
	List<GameTaskDetail> getGameTaskDetail(Map<String, Object> map);

	List<GameTaskDetail> getAllGameTask();

	List<GameTaskDetail> getGameTaskDetailById(int id);

	List<GameTaskDetail> getGameTaskDetailByoId(int oid);

	List<GameTaskDetail> getGameTaskDetailByLv(int rolelevel);

	List<GameTaskDetail> getGameTaskDetailByLvandold(int level, int old);

	List<GameTaskDetail> getGameTaskDetailByType(int type);
	
	//每日在线礼包，根据num获取
	List<GameTaskDetail> getGameTaskDetailByTypeTasktype(int type, int tasktype);
	
	public GameTaskDetail findGameTaskDetailById(int id);
	

}
