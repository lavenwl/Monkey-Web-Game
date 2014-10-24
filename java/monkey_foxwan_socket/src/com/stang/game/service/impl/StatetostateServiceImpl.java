package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;
import com.stang.game.cache.CacheChallengeRecord;
import com.stang.game.cache.CacheStatetostate;
import com.stang.game.dao.IChallengeRecordDao;
import com.stang.game.dao.IStatetostateDao;
import com.stang.game.dao.impl.ChallengeRecordDaoImpl;
import com.stang.game.dao.impl.StatetostateDaoImpl;
import com.stang.game.entity.detail.ChallengeRecordDetail;
import com.stang.game.entity.detail.StatetostateDetail;
import com.stang.game.service.IChallengeRecordService;
import com.stang.game.service.IStatetostateService;

public class StatetostateServiceImpl extends BaseServiceImpl<StatetostateDetail> 
implements IStatetostateService{
	 
	private static CacheStatetostate cacheStatetostate = null;
	private static CacheStatetostate getStatetostate(){
		if(cacheStatetostate == null){
			cacheStatetostate = new CacheStatetostate();
		}
		return cacheStatetostate;
	}
	
	protected IStatetostateDao getBaseDao(){
		if(baseDao == null){
			baseDao = new StatetostateDaoImpl();
		}
		return (IStatetostateDao) baseDao;
	}

	@Override
	public boolean updateStatetostate(StatetostateDetail statetostateDetail) {
		return getStatetostate().updateStatetostate(statetostateDetail);
	}

	@Override
	public boolean insertStatetostate(StatetostateDetail statetostateDetail) {
		return getStatetostate().insertStatetostateDetail(statetostateDetail);
	}

	@Override
	public List<StatetostateDetail> findAllStatetostate1() {
		return getBaseDao().findAllStatetostates1();
	}
	
	@Override
	public List<StatetostateDetail> findAllStatetostate2() {
		//查询三天内的数据
		long time = System.currentTimeMillis();
		time = time - (86400000 * 2 + 1000 * 60 * 60 * 4);
		return getBaseDao().findAllStatetostates2(time);
	}

	@Override
	public List<StatetostateDetail> getRequestByRoleid(int roleid) {
		return getStatetostate().getRequestByRoleid(roleid);
	}

	@Override
	public List<StatetostateDetail> getFreeGiftByRoleid(int roleid) {
		return getStatetostate().getFreeGiftByRoleid(roleid);
	}

	@Override
	public StatetostateDetail getStatetostateById(int id) {
		return getStatetostate().getStatetostateById(id);
	}

	@Override
	public List<StatetostateDetail> getRequestByRoleid2(int roleid) {
		return getStatetostate().getRequestByRoleid2(roleid);
	}

	@Override
	public List<StatetostateDetail> getFreeGiftByRoleid2(int roleid) {
		return getStatetostate().getFreeGiftByRoleid2(roleid);
	}


}
