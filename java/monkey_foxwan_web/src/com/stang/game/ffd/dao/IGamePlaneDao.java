package com.stang.game.ffd.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityGamePlaneDetail;

public interface IGamePlaneDao extends IEntityDao<EntityGamePlaneDetail> {
	
	public List<EntityGamePlaneDetail> getAllInfo(Map<String,Object> parm);

	public String getPlaneNameById(Map<String, Object> param);
}
