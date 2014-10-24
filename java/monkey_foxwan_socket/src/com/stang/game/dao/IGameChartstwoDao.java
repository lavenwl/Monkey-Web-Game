package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameChartsDetail;
import com.stang.game.entity.detail.GameChartstwoDetail;

public interface IGameChartstwoDao extends IEntityDao<GameChartstwoDetail>{
	public List<GameChartstwoDetail> findAllGameChartstwo();
	public boolean insertGameChartstwo(Map<String,Object> param);
	public boolean insertGameChartsthree(List<GameChartsDetail> param);
	public List<GameChartstwoDetail> findByNumtwo(Map<String,Object> param);
	public List<GameChartstwoDetail> findByQZtwo(Map<String,Object> param);
	public List<GameChartstwoDetail> findByDTtwo(Map<String,Object> param);
	public void createdantiaob();
	public void createzhugongb();
	public void dropdantiao();
	public void dropzhugong();
	public boolean deletegamechart();
	public boolean deletegamechartone();
	public boolean insertGameChartstwot(List<GameChartstwoDetail> param);
	public boolean xgzdsxo();
	public boolean xgzdsxt();
	public boolean xgzdsxf();
	
	
	
	public boolean xgczsqz();
	public boolean xgczsqzt();
	public void dropqz();
	public void createqz();
	public boolean call_proc_add(int i);
	
	
}
