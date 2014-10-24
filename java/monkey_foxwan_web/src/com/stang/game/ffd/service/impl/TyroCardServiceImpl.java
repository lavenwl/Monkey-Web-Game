package com.stang.game.ffd.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.ITyroCardDao;
import com.stang.game.ffd.dao.impl.TyroCardDaoImpl;
import com.stang.game.ffd.entity.detail.TyroCardDetail;
import com.stang.game.ffd.service.ITyroCardService;


public class TyroCardServiceImpl extends BaseServiceImpl<TyroCardDetail>
		implements ITyroCardService {
	protected ITyroCardDao getBaseDao() {
		if(baseDao == null) {
			baseDao = new TyroCardDaoImpl();
		}
		return (ITyroCardDao)baseDao;
	}

	public int insertTryoCardDetail(TyroCardDetail tcd) {
		// TODO Auto-generated method stub
		return getBaseDao().insertTryoCardDetail(tcd);
	}

	public List<TyroCardDetail> findTryoCardDetailByParam(
			Map<String, Object> map) {
		// TODO Auto-generated method stub
		return getBaseDao().findTryoCardDetailByParam(map);
	}

	public int updateTryoCardDetail(TyroCardDetail tcd) {
		// TODO Auto-generated method stub
		return getBaseDao().updateTryoCardDetail(tcd);
	}


}
