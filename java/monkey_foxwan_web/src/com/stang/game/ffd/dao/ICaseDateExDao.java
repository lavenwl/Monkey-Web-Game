package com.stang.game.ffd.dao;

import java.util.List;

import com.stang.game.ffd.entity.detail.EntityCaseDateExDetail;

public interface ICaseDateExDao extends IEntityDao<EntityCaseDateExDetail> {
		/*
		 * 查询当前用的数据采集的tableName
		 * */
	public List<EntityCaseDateExDetail> getTableName();
}
