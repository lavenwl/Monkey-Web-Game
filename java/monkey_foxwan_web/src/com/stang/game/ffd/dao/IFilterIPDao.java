package com.stang.game.ffd.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityFilterIPDetail;
import com.stang.game.ffd.service.impl.FilterIPServiceImpl;

public interface IFilterIPDao extends IEntityDao<EntityFilterIPDetail>{

	public List<EntityFilterIPDetail> findFilterIPByMap(Map<String, Object> param);

	public int insertFilterIPDetail(EntityFilterIPDetail entity);

	public int updateFilterIPDetail(EntityFilterIPDetail entity);

}
