package com.stang.game.ffd.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.common.PageProperty;
import com.stang.game.ffd.common.Response;
import com.stang.game.ffd.dao.IGmLogDao;
import com.stang.game.ffd.dao.IKeyWordDao;
import com.stang.game.ffd.dao.impl.GmLogDaoImpl;
import com.stang.game.ffd.dao.impl.KeyWordDaoImpl;
import com.stang.game.ffd.entity.detail.EntityKeyWordDetail;
import com.stang.game.ffd.service.IKeyWordService;

public class KeyWordServiceImpl extends BaseServiceImpl<EntityKeyWordDetail>
		implements IKeyWordService {
	public IKeyWordDao getBaseDao(){
		if(this.baseDao==null){
			baseDao = new KeyWordDaoImpl();
		}
		return (IKeyWordDao)baseDao;
	}
	
	public void deleteEntityKeyWordDetaill(EntityKeyWordDetail keyWord) {
		getBaseDao().deleteEntityKeyWordDetaill(keyWord);
		
	}

	public List<EntityKeyWordDetail> findEntityKeyWordDetailByParam(
			Map<String, Object> map) {
		// TODO Auto-generated method stub
		return this.getBaseDao().findEntityKeyWordDetailByParam(map);
	}

	public void insertEntityKeyWordDetaill(EntityKeyWordDetail keyWord) {
		
		getBaseDao().insertEntityKeyWordDetaill(keyWord);
	}

	public void updateEntityKeyWordDetail(EntityKeyWordDetail keyWord) {
		// TODO Auto-generated method stub
		getBaseDao().updateEntityKeyWordDetail(keyWord);
	}

}
