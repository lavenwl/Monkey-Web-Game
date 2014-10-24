package com.stang.game.service;

import java.util.List;

import com.stang.game.entity.detail.GameSkillDetail;

public interface IGameSkillService extends IBaseService<GameSkillDetail>{
	public List<GameSkillDetail> getGameSkill();
	
	public List<GameSkillDetail> getGameSkillById(int id);
}
