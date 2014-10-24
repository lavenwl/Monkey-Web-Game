package com.stang.game.ffd.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityGmLogDetail;

public interface IGmLogDao extends IEntityDao<EntityGmLogDetail> {

	public	List<EntityGmLogDetail> findGmLogByMap(Map<String, Object> param);

	public	int insertGmLogDetail(EntityGmLogDetail entity);

	public int updateGmLogDetai(EntityGmLogDetail entity);

}
