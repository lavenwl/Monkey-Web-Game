package com.stang.game.ffd.service;

import java.util.List;

import com.stang.game.ffd.entity.detail.EntityGiftBagTypeInfoDetail;

public interface IGiftBagTypeInfoService extends IBaseService<EntityGiftBagTypeInfoDetail> {
	
	public boolean AddGiftBagType(EntityGiftBagTypeInfoDetail param);
	public boolean EditGiftBagType(EntityGiftBagTypeInfoDetail param);
	public List<EntityGiftBagTypeInfoDetail> findGiftBagType(EntityGiftBagTypeInfoDetail param);
	public List<EntityGiftBagTypeInfoDetail> findGiftBagType();
	public List<EntityGiftBagTypeInfoDetail> findGiftBagTypeByName(EntityGiftBagTypeInfoDetail param);
	public int editGiftBagTypeByFlag(EntityGiftBagTypeInfoDetail param);
	public void editetest();
	public List<EntityGiftBagTypeInfoDetail> findGiftAll();
	
}
