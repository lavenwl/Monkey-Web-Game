package com.stang.game.dao;

import java.util.List;

import com.stang.game.entity.detail.GameSkillDetail;

public interface IGameSkillDao extends IEntityDao<GameSkillDetail>{
	public List<GameSkillDetail> getGameSkill();
	
	public List<GameSkillDetail> getGameSkillById(int id);
}
