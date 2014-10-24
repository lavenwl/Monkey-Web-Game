package com.stang.game.ffd.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityGameAstrologyDetail;

public interface IGameAstrologyDao extends IEntityDao<EntityGameAstrologyDetail> {
	/**
	 * 查询星魂的模型数据
	 * @param params
	 * @return List<EntityGameAstrologyDetail>
	 */
	public List<EntityGameAstrologyDetail> findAllGameAstrology(Map<String,Object> params);
	
	/**
	 * 添加星魂的模型数据
	 * @param params
	 * @return int
	 */
	public int addGameAstrology(EntityGameAstrologyDetail params);
	
	/**
	 * 对星魂的属性进行修改	
	 * @param params
	 * @return int
	 */
	public int updateGameAstrology(Map<String,Object> params);
}
