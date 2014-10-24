package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameChartsDetail;
import com.stang.game.entity.detail.RoleChallengeDetail;

public interface IGameChartsService extends IBaseService<GameChartsDetail>{
	public List<GameChartsDetail> findAllGameCharts();
	public boolean insertGameCharts(Map<String,Object> param);
	
	public List<GameChartsDetail> findByNum(Map<String,Object> param);
	public List<GameChartsDetail> findByQZ(Map<String,Object> param);
	public List<GameChartsDetail> findByDT(Map<String,Object> param);
	public boolean updateGameCharts(Map<String,Object> param);
	public List<GameChartsDetail> findalllie();
	public List<GameChartsDetail> getid(int roleId);
	public List<GameChartsDetail> getidqz(int roleId);
	public List<GameChartsDetail> getiddt(int roleId);
	public List<GameChartsDetail> findallliet();
	public List<GameChartsDetail> findalllief();
	public List<GameChartsDetail> getall();
	public List<GameChartsDetail> findByQZFirstTen(Map<String, Object> param);
	public List<GameChartsDetail> getidByParamt(Map<String, Object> paramt);
}
