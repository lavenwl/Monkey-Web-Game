package com.stang.game.ffd.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.ILogRejectIpsDao;
import com.stang.game.ffd.dao.impl.LogRejectIpsDaoImpl;
import com.stang.game.ffd.entity.detail.LogRejectIpsDetail;
import com.stang.game.ffd.service.ILogRejectIpsService;

public class LogRejectIpsServiceImpl extends
		BaseServiceImpl<LogRejectIpsDetail> implements ILogRejectIpsService {
	protected ILogRejectIpsDao getBaseDao() {
		if(baseDao == null){
			baseDao = new LogRejectIpsDaoImpl();
		}
		return (ILogRejectIpsDao) baseDao;
	}

	public List<LogRejectIpsDetail> getLogRejectIpsDetailByParam(
			Map<String, Object> param) {
		return getBaseDao().getLogRejectIpsDetailByParam(param);
	}

	public int getLogRejectIpsDetailCount() {
		return getBaseDao().getLogRejectIpsDetailCount();
	}

	public void insertLogRejectIpsDetail(LogRejectIpsDetail lrd) {
		getBaseDao().insertLogRejectIpsDetail(lrd);
	}

	public void updateLogRejectIpsByParam(Map<String, Object> param) {
		getBaseDao().updateLogRejectIpsByParam(param);
	}
}
