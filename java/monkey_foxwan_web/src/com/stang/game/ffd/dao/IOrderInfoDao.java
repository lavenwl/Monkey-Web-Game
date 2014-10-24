package com.stang.game.ffd.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityOrderInfoDetail;

public interface IOrderInfoDao extends IEntityDao<EntityOrderInfoDetail> {
	public List<EntityOrderInfoDetail> getAllInfoOrderInfo(Map<String,Object> parm);
}
