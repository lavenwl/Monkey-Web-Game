package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GamblingItemDetail;
import com.stang.game.entity.detail.RoleMapDetail;

public interface IGamblingItemService extends IBaseService<GamblingItemDetail> {

	public List<GamblingItemDetail> getGamblingItem(Map<String, Object> param);

	public void updateGamblingItemByParam(Map<String, Object> param);

	public List<GamblingItemDetail> getGamblingItemBytype(int type);

	public List<GamblingItemDetail> getGamblingItemBymid(int mid);
	
	public List<GamblingItemDetail> getGamblingItemByparam(Map<String, Object> param);
	public List<GamblingItemDetail> findAllGamblingItem();
}
