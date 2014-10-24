package com.stang.game.ffd.service;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityFilterRoleDetail;

public interface IFilterRoleService extends IBaseService<EntityFilterRoleDetail> {
	public List<EntityFilterRoleDetail> findFilterRoleByMap(Map<String,Object> param);
	public int updateFilterIPDetail(EntityFilterRoleDetail entity);
	public int insertFilterIPDetail(EntityFilterRoleDetail entity);
}
