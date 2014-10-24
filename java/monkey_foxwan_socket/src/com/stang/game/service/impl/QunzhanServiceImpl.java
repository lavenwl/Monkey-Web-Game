package com.stang.game.service.impl;

import java.util.List;

import com.stang.game.dao.IQunzhanDao;
import com.stang.game.dao.impl.QunzhanDaoImpl;
import com.stang.game.entity.detail.QunzhanDetail;
import com.stang.game.service.IQunzhanService;

public class QunzhanServiceImpl extends BaseServiceImpl<QunzhanDetail> implements IQunzhanService{
	protected IQunzhanDao getBaseDao(){
		if(baseDao == null){
			baseDao = new QunzhanDaoImpl();
		}
		return (IQunzhanDao) baseDao;
	}
	@Override
	public List<QunzhanDetail> getallqunzhan() {
		// TODO Auto-generated method stub
		return getBaseDao().getallqunzhan();
	}

}
