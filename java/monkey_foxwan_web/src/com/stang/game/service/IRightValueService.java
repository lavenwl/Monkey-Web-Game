package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.EntityRightUserDetail;
import com.stang.game.entity.detail.EntityRightValueDetail;

public interface IRightValueService extends
		IBaseService<EntityRightValueDetail> {
	public List<EntityRightValueDetail> findRightValueByMap(Map<String,Object> param);
	public int updateRightValueDetail(EntityRightValueDetail entity);
	public int insertRightValueDetail(EntityRightValueDetail entity);
}
