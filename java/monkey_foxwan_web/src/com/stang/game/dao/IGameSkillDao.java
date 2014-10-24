package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameSkillDetail;

public interface IGameSkillDao extends IEntityDao<GameSkillDetail>{
	public List<GameSkillDetail> getGameSkill();
	public List<GameSkillDetail> findAllSkill(Map<String,Object> param);
	public List<GameSkillDetail> findGameSkillByid(int id);
	public boolean insertGameSkill(GameSkillDetail model);
	public boolean updateGameSkill(Map<String, Object> param);
}
