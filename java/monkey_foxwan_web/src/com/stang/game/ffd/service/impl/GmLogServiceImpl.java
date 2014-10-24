package com.stang.game.ffd.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.common.PageProperty;
import com.stang.game.ffd.common.Response;
import com.stang.game.ffd.dao.IFilterIPDao;
import com.stang.game.ffd.dao.IGmLogDao;
import com.stang.game.ffd.dao.impl.FilterIPDaoImpl;
import com.stang.game.ffd.dao.impl.GmLogDaoImpl;
import com.stang.game.ffd.entity.detail.EntityFilterIPDetail;
import com.stang.game.ffd.entity.detail.EntityGmLogDetail;
import com.stang.game.ffd.service.IGmLogService;

public class GmLogServiceImpl extends BaseServiceImpl<EntityGmLogDetail>
		implements IGmLogService {
	public IGmLogDao getBaseDao(){
		if(this.baseDao==null){
			baseDao = new GmLogDaoImpl();
		}
		return (IGmLogDao)baseDao;
	}
	public List<EntityGmLogDetail> findGmLogByMap(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findGmLogByMap(param);
	}

	public int insertGmLogDetail(EntityGmLogDetail entity) {
		// TODO Auto-generated method stub
		return getBaseDao().insertGmLogDetail(entity);
	}

	public int updateGmLogDetail(EntityGmLogDetail entity) {
		// TODO Auto-generated method stub
		return getBaseDao().updateGmLogDetai(entity);
	}



}
