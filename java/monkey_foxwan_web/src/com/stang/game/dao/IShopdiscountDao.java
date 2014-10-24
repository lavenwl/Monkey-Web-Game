package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.ShopdiscountDetail;

public interface IShopdiscountDao extends IEntityDao<ShopdiscountDetail>{

	public List<ShopdiscountDetail> getShopdiscount(Map<String,Object> param);
	public boolean updateShop(Map<String, Object> param);
}
