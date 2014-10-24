package com.stang.game.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.stang.game.dao.IRightUserDao;
import com.stang.game.dao.impl.RightUserDaoImpl;
import com.stang.game.entity.detail.EntityRightUserDetail;
import com.stang.game.service.IRightUserService;

public class RightUserServiceImpl extends BaseServiceImpl<EntityRightUserDetail>
		implements IRightUserService {
	
	public IRightUserDao getBaseDao(){
		if(this.baseDao==null){
			baseDao = new RightUserDaoImpl();
		}
		return (IRightUserDao)baseDao;
	}

	public List<EntityRightUserDetail> findRightUserByMap(
			Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findRightUserByMap(param);
	}

	public int insertRightUserDetail(EntityRightUserDetail entity) {
		// TODO Auto-generated method stub
		return getBaseDao().insertRightUserDetail(entity);
	}

	public int updateRightUserDetail(EntityRightUserDetail entity) {
		// TODO Auto-generated method stub
		return getBaseDao().updateRightUserDetail(entity);
	}
	public EntityRightUserDetail findPasswordByRoleName(String uname){
		return getBaseDao().findPasswordByRoleName(uname);
	}

	public int deleteRightUserDetail(int id) {
		// TODO Auto-generated method stub
		return  getBaseDao().deleteRightUserDetail(id);
	}

}
