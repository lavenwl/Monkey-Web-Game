package com.stang.game.ffd.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityGameAstrologyCorrectionDetail;

public interface IGameAstrologyCorrectionDao extends IEntityDao<EntityGameAstrologyCorrectionDetail> {
	
	/**
	 * 查询 修正值的设定
	 * @param params
	 * @return List<EntityGameAstrologyCorrectionDetail>
	 */
	public List<EntityGameAstrologyCorrectionDetail> findGameAstrologyCorrection (Map<String,Object> params); 
	
	/**
	 * 添加 新的修正值
	 * @param params
	 * @return int
	 */
	public int addGameAstrologyCorrection (EntityGameAstrologyCorrectionDetail params);
	
	/**
	 * 修改 修正值的属性
	 * @param params
	 * @return int
	 */
	public int updateGameAstrologyCorrection (Map<String,Object> params);
}
