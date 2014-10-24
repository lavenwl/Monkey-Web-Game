package com.stang.game.ffd.service;

import java.util.List;
import java.util.Map;


import com.stang.game.ffd.entity.detail.TyroCardDetail;

public interface ITyroCardService extends IBaseService<TyroCardDetail> {

	public int insertTryoCardDetail(TyroCardDetail tcd);

	public List<TyroCardDetail> findTryoCardDetailByParam(
			Map<String, Object> map);

	public int updateTryoCardDetail(TyroCardDetail tcd);

}
