package com.stang.game.ffd.service;

import java.util.List;

import com.stang.game.ffd.entity.detail.EntityGameSkillDetail;

public interface IGameSkillService extends IBaseService<EntityGameSkillDetail> {
	public List<EntityGameSkillDetail> getAllInfo();
}
