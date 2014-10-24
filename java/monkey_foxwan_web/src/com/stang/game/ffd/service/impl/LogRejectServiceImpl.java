package com.stang.game.ffd.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.common.PageProperty;
import com.stang.game.ffd.common.Response;
import com.stang.game.ffd.dao.ILogRejectDao;
import com.stang.game.ffd.dao.impl.LogRejectDaoImpl;
import com.stang.game.ffd.entity.detail.LogRejectDetail;
import com.stang.game.ffd.service.ILogRejectService;
import com.stang.game.ffd.service.impl.BaseServiceImpl;

public class LogRejectServiceImpl extends BaseServiceImpl<LogRejectDetail>
		implements ILogRejectService {
	protected ILogRejectDao getBaseDao() {
		if(baseDao == null){
			baseDao = new LogRejectDaoImpl();
		}
		return (ILogRejectDao) baseDao;
		
	}

	public List<LogRejectDetail> getLogRejectByParam(Map<String,Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().getLogRejectByParam(param);
	}


	public void updateLogRejectByParam(Map<String,Object> param) {
		// TODO Auto-generated method stub
		getBaseDao().updateLogRejectByParam(param);
	}

	public void insertLogReject(LogRejectDetail lrd) {
		// TODO Auto-generated method stub
		getBaseDao().insertLogReject(lrd);
	}

	public int getLogRejectCount(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().getLogRejectCount(param);
	}
}
