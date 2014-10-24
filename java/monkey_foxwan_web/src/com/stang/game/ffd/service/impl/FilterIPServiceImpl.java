package com.stang.game.ffd.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.common.PageProperty;
import com.stang.game.ffd.common.Response;
import com.stang.game.ffd.dao.IFilterIPDao;
import com.stang.game.ffd.dao.IFilterRoleDao;
import com.stang.game.ffd.dao.impl.FilterIPDaoImpl;
import com.stang.game.ffd.dao.impl.FilterRoleDaoImpl;
import com.stang.game.ffd.entity.detail.EntityFilterIPDetail;
import com.stang.game.ffd.entity.detail.EntityFilterRoleDetail;
import com.stang.game.ffd.service.IFilterIPService;

public class FilterIPServiceImpl extends BaseServiceImpl<EntityFilterIPDetail>
		implements IFilterIPService {

	public IFilterIPDao getBaseDao(){
		if(this.baseDao==null){
			baseDao = new FilterIPDaoImpl();
		}
		return (IFilterIPDao)baseDao;
	}
	public List<EntityFilterIPDetail> findFilterIPByMap(
			Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findFilterIPByMap(param);
	}

	public int insertFilterIPDetail(EntityFilterIPDetail entity) {
		// TODO Auto-generated method stub
		return getBaseDao().insertFilterIPDetail(entity);
	}

	public int updateFilterIPDetail(EntityFilterIPDetail entity) {
		// TODO Auto-generated method stub
		return getBaseDao().updateFilterIPDetail(entity);
	}



}
