package com.stang.game.ffd.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityGameAvatarDetail;

public interface IGameAvatarDao extends IEntityDao<EntityGameAvatarDetail> {
	
	public List<EntityGameAvatarDetail> getAllInfo(Map<String,Object> parm);

	public String getAvatarNameById(Map<String, Object> param);
}
