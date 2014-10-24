package com.stang.game.ffd.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.ICaseInfoDao;
import com.stang.game.ffd.dao.impl.CaseInfoDaoImpl;
import com.stang.game.ffd.entity.detail.EntityCaseInfoDetail;
import com.stang.game.ffd.service.ICaseInfoService;

public class CaseInfoServiceImpl extends BaseServiceImpl<EntityCaseInfoDetail> implements ICaseInfoService  {
	
	public ICaseInfoDao getBaseDao(){
		if(this.baseDao==null){
			this.baseDao = new CaseInfoDaoImpl();
		}
		return (ICaseInfoDao)baseDao;
	}
	
	public void addCaseInfo(Map<String,Object> param){
		 this.getBaseDao().addCaseInfo(param);
	}
	
	public List<EntityCaseInfoDetail> findAll(Map<String,Object> param){
		return this.getBaseDao().findAll(param);
	}
	public List<EntityCaseInfoDetail> findAllForTime(Map<String,Object> param){
		return this.getBaseDao().findAllForTime(param);
	}
	public void updateCaseInfo(Map<String,Object> param){
		this.getBaseDao().updateCaseInfo(param);
	}
	public int searchCount(Map<String,Object> param){
		return this.getBaseDao().searchCount(param);
	}
}
