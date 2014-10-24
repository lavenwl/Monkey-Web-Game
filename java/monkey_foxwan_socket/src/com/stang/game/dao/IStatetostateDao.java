package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.ChallengeRecordDetail;
import com.stang.game.entity.detail.StatetostateDetail;

public interface IStatetostateDao extends IEntityDao<StatetostateDetail>{
	public boolean insertStatetostate(StatetostateDetail statetostateDetail);
	public boolean updateStatetostate(StatetostateDetail statetostateDetail);
	public List<StatetostateDetail> findAllStatetostates1();
	public List<StatetostateDetail> findAllStatetostates2(long time);
}
