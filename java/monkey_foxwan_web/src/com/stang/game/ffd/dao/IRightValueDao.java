package com.stang.game.ffd.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.common.PageProperty;
import com.stang.game.ffd.entity.detail.EntityRightValueDetail;

public interface IRightValueDao extends IEntityDao<EntityRightValueDetail> {

	public List<EntityRightValueDetail> findRightValueByMap(Map<String, Object> param);

	public int insertRightValueDetail(EntityRightValueDetail entity);

	public int updateRightValueDetail(EntityRightValueDetail entity);

}
