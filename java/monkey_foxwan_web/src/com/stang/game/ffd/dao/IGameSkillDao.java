package com.stang.game.ffd.dao;

import java.util.List;

import com.stang.game.ffd.entity.detail.EntityGameSkillDetail;

public interface IGameSkillDao extends IEntityDao<EntityGameSkillDetail> {
	public List<EntityGameSkillDetail> getAllInfo();
}
