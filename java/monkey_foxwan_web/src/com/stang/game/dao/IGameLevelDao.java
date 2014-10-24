package com.stang.game.dao;

/**
 * @author jack.fei
 * @company 上海三唐信息科技有限公司 
 * @description 实体数据库处理实现 
 */
import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameLevelDetail;

public interface IGameLevelDao extends IEntityDao<GameLevelDetail> {

	public List<GameLevelDetail> getGameLevel();
	public List<GameLevelDetail> findAllLevel(Map<String,Object> param);
	public List<GameLevelDetail> findGameLevelByid(int id);
	public boolean insertGameLevel(GameLevelDetail model);
	public boolean updateGameLevel(Map<String, Object> param);

	
	
	
	
	
	
	public List<GameLevelDetail> allGameLevelDetail();

	public GameLevelDetail getGameLevelByRoleLevel(int roleLevel);
}
