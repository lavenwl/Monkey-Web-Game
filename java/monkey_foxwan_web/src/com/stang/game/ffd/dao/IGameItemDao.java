package com.stang.game.ffd.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityGameItemDetail;

public interface IGameItemDao extends IEntityDao<EntityGameItemDetail> {
	public List<EntityGameItemDetail> getAllInfo(Map<String,Object> parm);
}
