package com.stang.game.ffd.service;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityGameAstrologyCapacityDetail;

public interface IGameAstrologyCapacityService extends IBaseService<EntityGameAstrologyCapacityDetail> {
	/**
	 * 查询到所有 玩家的扩展背包，8格意外的数据
	 * @param Map<String,Object> param
	 * @return List<EntityGameAstrologyCapacityDetail>
	 */
	public List<EntityGameAstrologyCapacityDetail> findAllGameAstrologyCapacity(Map<String,Object> param);
	
	/**
	 * 对 玩家背包扩张进行插入操作
	 * @param param
	 * @return int
	 */
	public int addGameAstrologyCapacity(Map<String,Object> param);
	
	/**
	 * 对玩家的背包扩展超过1格的进行更新操作。
	 * @param param
	 * @return int
	 */
	public int updateGameAstrologyCapacity(Map<String,Object> param);
	
}
