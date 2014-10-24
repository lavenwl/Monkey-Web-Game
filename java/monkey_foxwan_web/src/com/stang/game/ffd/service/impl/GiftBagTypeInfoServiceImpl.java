package com.stang.game.ffd.service.impl;


import java.util.List;

import com.stang.game.ffd.dao.IGiftBagTypeInfoDao;
import com.stang.game.ffd.dao.impl.GiftBagTypeInfoDaoImpl;
import com.stang.game.ffd.entity.detail.EntityGiftBagTypeInfoDetail;
import com.stang.game.ffd.service.IGiftBagTypeInfoService;

public class GiftBagTypeInfoServiceImpl extends BaseServiceImpl<EntityGiftBagTypeInfoDetail> implements IGiftBagTypeInfoService{

	public IGiftBagTypeInfoDao getBaseDao(){
		if(this.baseDao==null){
			this.baseDao=new GiftBagTypeInfoDaoImpl();
		}
		return (IGiftBagTypeInfoDao)baseDao;
	}
	
	public boolean AddGiftBagType(EntityGiftBagTypeInfoDetail param) {
		// TODO Auto-generated method stub
		return getBaseDao().AddGiftBagType(param);
	}

	public boolean EditGiftBagType(EntityGiftBagTypeInfoDetail param) {
		// TODO Auto-generated method stub
		return this.getBaseDao().EditGiftBagType(param);
	}
	
	public List<EntityGiftBagTypeInfoDetail> findGiftBagType(EntityGiftBagTypeInfoDetail param){
		return this.getBaseDao().findGiftBagType(param);
	}

	public List<EntityGiftBagTypeInfoDetail> findGiftBagType(){
		return this.getBaseDao().findGiftBagType();
	}
	public  List<EntityGiftBagTypeInfoDetail> findGiftBagTypeByName(EntityGiftBagTypeInfoDetail param){
		return this.getBaseDao().findGiftBagTypeByName(param);
	}
	public int editGiftBagTypeByFlag(EntityGiftBagTypeInfoDetail param){
		return this.getBaseDao().editGiftBagTypeByFlag(param);
	}
	
	public void editetest(){
		this.getBaseDao().editetest();
	}
	public List<EntityGiftBagTypeInfoDetail> findGiftAll(){
		return this.getBaseDao().findGiftAll();
	}
}
