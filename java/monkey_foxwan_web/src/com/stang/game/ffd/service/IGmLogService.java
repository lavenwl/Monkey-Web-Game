package com.stang.game.ffd.service;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityFilterIPDetail;
import com.stang.game.ffd.entity.detail.EntityGmLogDetail;

public interface IGmLogService extends IBaseService<EntityGmLogDetail> {
	public List<EntityGmLogDetail> findGmLogByMap(Map<String,Object> param);
	public int updateGmLogDetail(EntityGmLogDetail entity);
	public int insertGmLogDetail(EntityGmLogDetail entity);
}
