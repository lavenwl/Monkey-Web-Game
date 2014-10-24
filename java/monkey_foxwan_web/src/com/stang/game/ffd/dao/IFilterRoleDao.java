package com.stang.game.ffd.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityFilterRoleDetail;

public interface IFilterRoleDao extends IEntityDao<EntityFilterRoleDetail> {

	public List<EntityFilterRoleDetail> findFilterRoleByMap(Map<String, Object> param);

	public int updateFilterRoleDetail(EntityFilterRoleDetail entity);

	public int insertFilterRoleDetail(EntityFilterRoleDetail entity);

}
