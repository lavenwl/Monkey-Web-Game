package com.stang.game.service.impl;

import java.util.List;

import com.stang.game.dao.IDantiaoDao;
import com.stang.game.dao.impl.DantiaoDaoImpl;
import com.stang.game.entity.detail.DantiaoDetail;
import com.stang.game.service.IDantiaoService;

public class DantiaoServiceImpl extends BaseServiceImpl<DantiaoDetail> implements IDantiaoService{
	protected IDantiaoDao getBaseDao(){
		if(baseDao == null){
			baseDao = new DantiaoDaoImpl();
		}
		return (IDantiaoDao) baseDao;
	}

	@Override
	public List<DantiaoDetail> getalldantiao() {
		// TODO Auto-generated method stub
		return getBaseDao().getalldantiao();
	}

}
