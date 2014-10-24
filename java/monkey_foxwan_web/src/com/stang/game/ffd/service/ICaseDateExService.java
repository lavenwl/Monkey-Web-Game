package com.stang.game.ffd.service;

import java.util.List;

import com.stang.game.ffd.entity.detail.EntityCaseDateExDetail;

public interface ICaseDateExService extends IBaseService<EntityCaseDateExDetail> {
	
	public List<EntityCaseDateExDetail> getTableName();
}
