package com.stang.game.dao;

import java.util.List;

import com.stang.game.entity.detail.CdkStoreDetail;

public interface ICdkStoreDao extends IEntityDao<CdkStoreDetail>{
	public List<CdkStoreDetail> findCdkStoreBycdk(String cdk);
	public boolean Updatemploy(CdkStoreDetail iDetail);
	public boolean Updatemploy(String employ, String cdk);
}
