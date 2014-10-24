package com.stang.game.ffd.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.GameTaskFormalDetail;

public interface IGameTaskFormalDao extends IEntityDao<GameTaskFormalDetail> {
	/**
	 * 查询所有的任务信息
	 * @param parms
	 * @return
	 */
	public List<GameTaskFormalDetail> getAllInfo(Map<String,Object> parms);
	
	public List<GameTaskFormalDetail> getGameTaskFormal(Map<String, Object> param);
	
	/**
	 * 
	 * @param param
	 * @return
	 * @description 更新
	 */
	public int updateGameTaskFormal(Map<String, Object> param);
	
	public int addTaskFormal(GameTaskFormalDetail param);
	
	public int getGameTaskFormalsId();
}
