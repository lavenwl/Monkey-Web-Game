package com.stang.game.ffd.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.common.PageProperty;
import com.stang.game.ffd.common.Response;
import com.stang.game.ffd.dao.IRightUserDao;
import com.stang.game.ffd.dao.IRightValueDao;
import com.stang.game.ffd.dao.impl.RightUserDaoImpl;
import com.stang.game.ffd.dao.impl.RightValueDaoImpl;
import com.stang.game.ffd.entity.detail.EntityRightUserDetail;
import com.stang.game.ffd.entity.detail.EntityRightValueDetail;
import com.stang.game.ffd.service.IRightValueService;

public class RightValueServiceImpl extends
		BaseServiceImpl<EntityRightValueDetail> implements IRightValueService {

	public IRightValueDao getBaseDao(){
		if(this.baseDao==null){
			baseDao = new RightValueDaoImpl();
		}
		return (IRightValueDao)baseDao;
	}
	public List<EntityRightValueDetail> findRightValueByMap(
			Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findRightValueByMap(param);
	}

	public int insertRightValueDetail(EntityRightValueDetail entity) {
		// TODO Auto-generated method stub
		return getBaseDao().insertRightValueDetail(entity);
	}

	public int updateRightValueDetail(EntityRightValueDetail entity) {
		// TODO Auto-generated method stub
		return getBaseDao().updateRightValueDetail(entity);
	}


}
