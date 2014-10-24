package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.ChallengeRecordDetail;
import com.stang.game.entity.detail.StatetostateDetail;

public interface IStatetostateService extends IBaseService<StatetostateDetail>{
	public List<StatetostateDetail> findAllStatetostate1();
	public boolean insertStatetostate(StatetostateDetail statetostateDetail);
	public boolean updateStatetostate(StatetostateDetail statetostateDetail);
	public List<StatetostateDetail> getRequestByRoleid(int roleid);
	public List<StatetostateDetail> getFreeGiftByRoleid(int roleid);
	public StatetostateDetail getStatetostateById(int id);
	public List<StatetostateDetail> findAllStatetostate2();
	public List<StatetostateDetail> getRequestByRoleid2(int roleid);
	public List<StatetostateDetail> getFreeGiftByRoleid2(int roleid);
}
