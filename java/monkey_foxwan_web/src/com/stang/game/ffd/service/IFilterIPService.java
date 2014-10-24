package com.stang.game.ffd.service;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityFilterIPDetail;
import com.stang.game.ffd.entity.detail.EntityFilterRoleDetail;

public interface IFilterIPService extends IBaseService<EntityFilterIPDetail> {
	public List<EntityFilterIPDetail> findFilterIPByMap(Map<String,Object> param);
	public int updateFilterIPDetail(EntityFilterIPDetail entity);
	public int insertFilterIPDetail(EntityFilterIPDetail entity);
}
