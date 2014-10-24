package com.stang.game.dao.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IEntityDao;
import com.stang.game.entity.detail.GamblingItemDetail;

public interface IGamblingItemDao extends IEntityDao<GamblingItemDetail> {
	public List<GamblingItemDetail> getGamblingItem(Map<String, Object> param);

	public void updateGamblingItemByParam(Map<String, Object> param);
}
