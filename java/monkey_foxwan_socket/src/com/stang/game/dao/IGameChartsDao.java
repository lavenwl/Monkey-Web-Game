package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameChartsDetail;

public interface IGameChartsDao extends IEntityDao<GameChartsDetail>{
	public List<GameChartsDetail> findAllGameCharts();
	public boolean insertGameCharts(Map<String,Object> param);
	
	public List<GameChartsDetail> findByNum(Map<String,Object> param);
	public List<GameChartsDetail> findByQZ(Map<String,Object> param);
	public List<GameChartsDetail> findByDT(Map<String,Object> param);
	public List<GameChartsDetail> getid(int roleId);
	public List<GameChartsDetail> getidqz(int roleId);
	public List<GameChartsDetail> getiddt(int roleId);
	public List<GameChartsDetail> getall();
public List<GameChartsDetail> findalllie();
public List<GameChartsDetail> findallliet();
public List<GameChartsDetail> findalllief();
	//public int findalllie();
	public boolean updateGameCharts(Map<String,Object> param);
	public List<GameChartsDetail> findByQZFirstTen(Map<String, Object> param);
}
