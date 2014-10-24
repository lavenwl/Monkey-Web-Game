package com.stang.game.ffd.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityGameAstrologyBagDetail;

public interface IGameAstrologyBagDao extends IEntityDao<EntityGameAstrologyBagDetail>{
	/**
	 * 获取占星背包的数据
	 * @param Map<String,Object>
	 *  @return List<EntityGameAstrologyBagDetail>
	 */
	public List<EntityGameAstrologyBagDetail> findAllGameAstrologyBag(Map<String,Object> params);
	
	/**
	 * 插入新的数据进入占星背包
	 * @param Map<String,Object>
	 * @return int
	 */
	public int addGameAstrologyBag(Map<String,Object> params);
	
	/**
	 * 更新占星背包数据 主要的作用就是告诉前段随机算出来的占星球目前处于 外背包还是里背包
	 * @param Map<String,Object>
	 * @return int
	 */
	public int updateGameAstrologyBag(Map<String,Object> params);	
}
