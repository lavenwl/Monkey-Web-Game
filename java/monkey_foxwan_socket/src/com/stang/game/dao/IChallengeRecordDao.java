package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.ChallengeRecordDetail;

public interface IChallengeRecordDao extends IEntityDao<ChallengeRecordDetail>{
	public boolean insertChallengeRecord(ChallengeRecordDetail challengeRecordDetail);
	public boolean updateChallengeRecord(ChallengeRecordDetail challengeRecordDetail);
	public List<ChallengeRecordDetail> findAllChallengeRecord();
	
	public boolean insertChallengerecord(Map<String,Object> param);
	public List<ChallengeRecordDetail> findBychallengetime(Map<String,Object> param);
	public List<ChallengeRecordDetail> findallchallenge(Map<String,Object> param);
	public boolean updateChallenge(Map<String,Object>param);
	public List<ChallengeRecordDetail> findallchallengetwo(Map<String,Object> param);
	public boolean insertChallengeRecords(
			List<ChallengeRecordDetail> challengerecords);
	public List<ChallengeRecordDetail> findallchallengeId(Map<String,Object> param);
	

}
