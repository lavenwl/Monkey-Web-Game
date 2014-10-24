package com.stang.game.ffd.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.common.PageProperty;
import com.stang.game.ffd.common.Response;
import com.stang.game.ffd.dao.IFilterRoleDao;
import com.stang.game.ffd.dao.IGameRoleDao;
import com.stang.game.ffd.dao.impl.FilterRoleDaoImpl;
import com.stang.game.ffd.dao.impl.GameRoleDaoImpl;
import com.stang.game.ffd.entity.detail.EntityFilterRoleDetail;
import com.stang.game.ffd.service.IFilterRoleService;

public class FilterRoleServiceImpl extends
		BaseServiceImpl<EntityFilterRoleDetail> implements IFilterRoleService {

	public IFilterRoleDao getBaseDao(){
		if(this.baseDao==null){
			baseDao = new FilterRoleDaoImpl();
		}
		return (IFilterRoleDao)baseDao;
	}
	public List<EntityFilterRoleDetail> findFilterRoleByMap(
			Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findFilterRoleByMap(param);
	}

	public int insertFilterIPDetail(EntityFilterRoleDetail entity) {
		// TODO Auto-generated method stub
		return getBaseDao().insertFilterRoleDetail(entity);
	}

	public int updateFilterIPDetail(EntityFilterRoleDetail entity) {
		// TODO Auto-generated method stub
		return getBaseDao().updateFilterRoleDetail(entity);
	}

}
