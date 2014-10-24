package com.stang.game.ffd.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.common.PageProperty;
import com.stang.game.ffd.common.Response;
import com.stang.game.ffd.dao.ILogSendGiftDetailDao;
import com.stang.game.ffd.dao.impl.LogSendGiftDetailDaoImpl;
import com.stang.game.ffd.entity.detail.LogSendGiftDetail;
import com.stang.game.ffd.service.ILogSendGiftDetailService;
import com.stang.game.ffd.service.impl.BaseServiceImpl;

public class LogSendGiftDetailServiceImpl extends
		BaseServiceImpl<LogSendGiftDetail> implements ILogSendGiftDetailService {
	protected ILogSendGiftDetailDao getBaseDao(){
		if(baseDao==null){
			baseDao = new  LogSendGiftDetailDaoImpl();
		}
		return (ILogSendGiftDetailDao) baseDao;
		
	}

	public void deleteLogSendGiftDetail(Map<String, Object> param) {
		// TODO Auto-generated method stub
		getBaseDao().deleteLogSendGiftDetail(param);
	}

	public List<LogSendGiftDetail> getLogSendGiftDetail(
			Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().getLogSendGiftDetail(param);
	}

	public void insertLogSendGiftDetail(Map<String, Object> param) {
		// TODO Auto-generated method stub
		getBaseDao().insertLogSendGiftDetail(param);
	}

	public void updateLogSendGiftDetail(Map<String, Object> param) {
		// TODO Auto-generated method stub
		getBaseDao().updateLogSendGiftDetail(param);
	}

	public int getLogSendGiftDetailCount() {
		// TODO Auto-generated method stub
		return getBaseDao().getLogSendGiftDetailCount();

	}

}
