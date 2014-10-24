package com.stang.game.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.stang.game.dao.IRightUserDao;
import com.stang.game.dao.IRightValueDao;
import com.stang.game.dao.impl.RightUserDaoImpl;
import com.stang.game.dao.impl.RightValueDaoImpl;
import com.stang.game.entity.detail.EntityRightUserDetail;
import com.stang.game.entity.detail.EntityRightValueDetail;
import com.stang.game.service.IRightValueService;

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
