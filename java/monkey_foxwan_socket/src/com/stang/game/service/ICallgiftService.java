package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.CallGiftDetail;

public interface ICallgiftService extends IBaseService<CallGiftDetail>{
	public List<CallGiftDetail> getcallgift(int id);
	public List<CallGiftDetail> findAllCallGift();
}
