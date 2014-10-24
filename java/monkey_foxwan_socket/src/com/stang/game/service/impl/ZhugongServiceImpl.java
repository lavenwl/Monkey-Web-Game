package com.stang.game.service.impl;

import java.util.List;

import com.stang.game.dao.IZhugongDao;
import com.stang.game.dao.impl.ZhugongDaoImpl;
import com.stang.game.entity.detail.ZhugongDetail;
import com.stang.game.service.IZhugongService;

public class ZhugongServiceImpl extends BaseServiceImpl<ZhugongDetail> implements IZhugongService{
	protected IZhugongDao getBaseDao(){
		if(baseDao == null){
			baseDao = new ZhugongDaoImpl();
		}
		return (IZhugongDao) baseDao;
	}
	
	
	@Override
	public List<ZhugongDetail> getallzhugong() {
		// TODO Auto-generated method stub
		return getBaseDao().getallzhugong();
	}

}
