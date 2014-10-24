package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GamblingItemDetail;

public interface IGamblingItemDao extends IEntityDao<GamblingItemDetail> {
	public List<GamblingItemDetail> getGamblingItem(Map<String, Object> param);

	public void updateGamblingItemByParam(Map<String, Object> param);

	public List<GamblingItemDetail> getGamblingItemBytype(int type);

	public List<GamblingItemDetail> getGamblingItemBymid(int mid);
	
	public List<GamblingItemDetail> getGamblingItemByparam(Map<String, Object> param);
	public List<GamblingItemDetail> findAllGamblingItem();
	public boolean updateGamblingItem(GamblingItemDetail model);
	public boolean insertGamblingItem(GamblingItemDetail model);
}
