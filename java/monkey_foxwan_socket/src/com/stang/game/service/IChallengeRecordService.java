package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.ChallengeRecordDetail;

public interface IChallengeRecordService extends IBaseService<ChallengeRecordDetail>{
	public List<ChallengeRecordDetail> findAllChallengeRecord();
	public boolean insertChallengerecord(Map<String,Object> param);
	public List<ChallengeRecordDetail> findBychallengetime(Map<String,Object> param);
	public List<ChallengeRecordDetail> findallchallenge(Map<String,Object> param);
	public boolean updateChallenge(Map<String,Object>param);
	public List<ChallengeRecordDetail> findallchallengetwo(Map<String,Object> param);
	public boolean insertChallengerecords(List<ChallengeRecordDetail> challengerecords);
	public List<ChallengeRecordDetail> findallchallengeId(Map<String,Object> param);
	
}
