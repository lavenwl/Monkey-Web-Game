package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IGameChartstwoDao;
import com.stang.game.dao.impl.GameChartstwoDaoImpl;
import com.stang.game.entity.detail.GameChartsDetail;
import com.stang.game.entity.detail.GameChartstwoDetail;
import com.stang.game.service.IGameChartstwoService;


public class GameChartstwoServiceImpl extends BaseServiceImpl<GameChartstwoDetail> 
implements IGameChartstwoService{
	protected IGameChartstwoDao getBaseDao(){
		if(baseDao == null){
			baseDao = new GameChartstwoDaoImpl();
		}
		return (IGameChartstwoDao) baseDao;
	}
	
	@Override
	public boolean insertGameChartstwo(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().insertGameChartstwo(param);
	}

	@Override
	public List<GameChartstwoDetail> findByDTtwo(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findByDTtwo(param);
	}

	@Override
	public List<GameChartstwoDetail> findByNumtwo(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findByNumtwo(param);
	}

	@Override
	public List<GameChartstwoDetail> findByQZtwo(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findByQZtwo(param);
	}

	public boolean insertGameChartsthree(List<GameChartsDetail> param) {
		// TODO Auto-generated method stub
		return getBaseDao().insertGameChartsthree(param);
	}

	@Override
	public boolean deletegamechart() {
		// TODO Auto-generated method stub
		return getBaseDao().deletegamechart();
	}

	@Override
	public boolean insertGameChartstwot(List<GameChartstwoDetail> param) {
		// TODO Auto-generated method stub
		return getBaseDao().insertGameChartstwot(param);
	}

	@Override
	public boolean deletegamechartone() {
		// TODO Auto-generated method stub
		return getBaseDao().deletegamechartone();
	}

	@Override
	public void createdantiaob() {
		getBaseDao().createdantiaob();
		
	}

	@Override
	public void dropdantiao() {
		getBaseDao().dropdantiao();
		
	}

	@Override
	public void dropzhugong() {
		getBaseDao().dropzhugong();
		
	}

	@Override
	public void createzhugongb() {
		getBaseDao().createzhugongb();
		
	}

	@Override
	public boolean xgzdsxf() {
		// TODO Auto-generated method stub
		return getBaseDao().xgzdsxf();
	}

	@Override
	public boolean xgzdsxo() {
		// TODO Auto-generated method stub
		return getBaseDao().xgzdsxo();
	}

	@Override
	public boolean xgzdsxt() {
		// TODO Auto-generated method stub
		return getBaseDao().xgzdsxt();
	}

	@Override
	public void createqz() {
		// TODO Auto-generated method stub
		getBaseDao().createqz();
	}

	@Override
	public void dropqz() {
		// TODO Auto-generated method stub
		getBaseDao().dropqz();
	}

	@Override
	public boolean xgczsqz() {
		// TODO Auto-generated method stub
		return getBaseDao().xgczsqz();
	}

	@Override
	public boolean xgczsqzt() {
		// TODO Auto-generated method stub
		return getBaseDao().xgczsqzt();
	}

	@Override
	public boolean call_proc_add(int i) {
		// TODO Auto-generated method stub
		return getBaseDao().call_proc_add(i);
	}

	@Override
	public List<GameChartstwoDetail> findAllGameChartstwo() {
		// TODO Auto-generated method stub
		return getBaseDao().findAllGameChartstwo();
	}}
