package com.stang.game.service.impl;

import java.util.List;

import com.stang.game.dao.SendgiftlogDao;
import com.stang.game.dao.impl.SendgiftlogDaoImpl;
import com.stang.game.entity.detail.SendgiftlogDetail;
import com.stang.game.service.SendgiftlogService;

public class SendgiftlogServiceImpl extends BaseServiceImpl<SendgiftlogDetail>
implements SendgiftlogService{
	
	protected SendgiftlogDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new SendgiftlogDaoImpl();
		}
		return (SendgiftlogDao) baseDao;
	}
	

	public boolean insertsendgift(SendgiftlogDetail model) {
		// TODO Auto-generated method stub
		return getBaseDao().insertsendgift(model);
	}


	public List<SendgiftlogDetail> getAllsfg() {
		// TODO Auto-generated method stub
		return getBaseDao().getAllsfg();
	}

}
