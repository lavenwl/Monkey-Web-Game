package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.CallGiftDetail;

public interface ICallgiftDao extends IEntityDao<CallGiftDetail>{

	public List<CallGiftDetail> getcallgift(int id);
	public List<CallGiftDetail> findAllCallGift();
}
