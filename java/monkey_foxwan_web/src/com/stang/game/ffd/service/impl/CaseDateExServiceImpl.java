package com.stang.game.ffd.service.impl;

import java.util.List;

import com.stang.game.ffd.dao.ICaseDateExDao;
import com.stang.game.ffd.dao.impl.CaseDateExDaoImpl;
import com.stang.game.ffd.entity.detail.EntityCaseDateExDetail;
import com.stang.game.ffd.service.ICaseDateExService;

public class CaseDateExServiceImpl extends BaseServiceImpl<EntityCaseDateExDetail> implements ICaseDateExService {
	
	protected ICaseDateExDao getBaseDao(){
		if(baseDao==null){
			baseDao= new CaseDateExDaoImpl();
		}
		return (ICaseDateExDao)baseDao;
	}

	public List<EntityCaseDateExDetail> getTableName() {
		// TODO Auto-generated method stub
		return getBaseDao().getTableName();
	}
}
