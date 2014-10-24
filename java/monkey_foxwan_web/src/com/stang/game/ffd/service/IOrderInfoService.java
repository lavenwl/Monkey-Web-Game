package com.stang.game.ffd.service;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityOrderInfoDetail;

public interface IOrderInfoService extends IBaseService<EntityOrderInfoDetail> {
	public List<EntityOrderInfoDetail> getAllInfoOrderInfo(Map<String,Object> parm);
}
