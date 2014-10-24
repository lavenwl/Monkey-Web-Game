package com.stang.game.service;

import java.util.List;

import com.stang.game.entity.detail.CdkStoreDetail;

public interface ICdkStoreService extends IBaseService<CdkStoreDetail> {
	public List<CdkStoreDetail> findCdkStoreBycdk(String cdk);
	public boolean Updatemploy(String employ, String cdk);
}
