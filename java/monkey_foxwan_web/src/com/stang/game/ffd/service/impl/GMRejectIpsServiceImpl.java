package com.stang.game.ffd.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.common.PageProperty;
import com.stang.game.ffd.common.Response;
import com.stang.game.ffd.dao.IGMRejectIpsDao;
import com.stang.game.ffd.dao.impl.GMRejectIpsDaoImpl;
import com.stang.game.ffd.entity.detail.GMRejectIpsDetail;
import com.stang.game.ffd.service.IGMRejectIpsService;

public class GMRejectIpsServiceImpl extends BaseServiceImpl<GMRejectIpsDetail>
		implements IGMRejectIpsService {
	protected IGMRejectIpsDao getBaseDao() {
		if(baseDao == null){
			baseDao = new GMRejectIpsDaoImpl();
		}
		return (IGMRejectIpsDao) baseDao;
		
	}

	public void deleteGMRejectIpsDetail(Map<String,Object> param) {
		getBaseDao().deleteGMRejectIpsDetail(param);
		
	}

	public List<GMRejectIpsDetail> findGMRejectIpsDetailByParam(
			Map<String, Object> param) {
		return getBaseDao().findGMRejectIpsDetailByParam(param);
	}

	public void insertGMRejectIpsDetail(GMRejectIpsDetail grid) {
		// TODO Auto-generated method stub
		getBaseDao().insertGMRejectIpsDetail(grid);
	}

	public void updateGMRejectIpsDetail(Map<String,Object> param) {
		// TODO Auto-generated method stub
		getBaseDao().updateGMRejectIpsDetail(param);
	}

	public int getGMRejectIpsCount() {
		// TODO Auto-generated method stub
		return getBaseDao().getGMRejectIpsCount();
	}

	public List<GMRejectIpsDetail> findGMRejectIpsDetailByTime(
			Map<String, Object> param) {
		// TODO Auto-generated method stub
		return 	getBaseDao().findGMRejectIpsDetailByTime(param);
	}

}
