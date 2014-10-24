package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;
import com.stang.game.cache.CacheChallengeRecord;
import com.stang.game.dao.IChallengeRecordDao;
import com.stang.game.dao.impl.ChallengeRecordDaoImpl;
import com.stang.game.entity.detail.ChallengeRecordDetail;
import com.stang.game.service.IChallengeRecordService;

public class ChallengeRecordServiceImpl extends BaseServiceImpl<ChallengeRecordDetail> 
implements IChallengeRecordService{
	 
	private static CacheChallengeRecord cacheChallengeRecord = null;
	private static CacheChallengeRecord getCacheChallengeRecord(){
		if(cacheChallengeRecord == null){
			cacheChallengeRecord = new CacheChallengeRecord();
		}
		return cacheChallengeRecord;
	}
	
	protected IChallengeRecordDao getBaseDao(){
		if(baseDao == null){
			baseDao = new ChallengeRecordDaoImpl();
		}
		return (IChallengeRecordDao) baseDao;
	}

	@Override
	public List<ChallengeRecordDetail> findBychallengetime(Map<String, Object> param) {
		return getBaseDao().findBychallengetime(param);
	}

	@Override
	public boolean insertChallengerecord(Map<String, Object> param) {
		return getCacheChallengeRecord().insertChallengerecord(param);
//		return getBaseDao().insertChallengerecord(param);
	}

	@Override
	public List<ChallengeRecordDetail> findallchallenge(
			Map<String, Object> param) {
		return getCacheChallengeRecord().findallchallenge(param);
//		return getBaseDao().findallchallenge(param);
	}

	@Override
	public boolean updateChallenge(Map<String, Object> param) {
		return getCacheChallengeRecord().updateChallenge(param);
//		return getBaseDao().updateChallenge(param);
	}

	@Override
	public List<ChallengeRecordDetail> findallchallengetwo(Map<String, Object> param) {
		return getCacheChallengeRecord().findallchallengetwo(param);
//		return getBaseDao().findallchallengetwo(param);
	}

	@Override
	public boolean insertChallengerecords(List<ChallengeRecordDetail> challengerecords) {
		return getCacheChallengeRecord().insertChallengerecords(challengerecords);
//		return getBaseDao().insertChallengeRecords(challengerecords);
	}

	@Override
	public List<ChallengeRecordDetail> findallchallengeId(Map<String, Object> param) {
		return getCacheChallengeRecord().findallchallengeId(param);
//		return getBaseDao().findallchallengeId(param);
	}

	@Override
	public List<ChallengeRecordDetail> findAllChallengeRecord() {
		// TODO Auto-generated method stub
		return getBaseDao().findAllChallengeRecord();
	}
	


}
