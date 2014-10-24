package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.cache.CacheGameCharts;
import com.stang.game.dao.IGameChartsDao;
import com.stang.game.dao.impl.GameChartsDaoImpl;
import com.stang.game.entity.detail.GameChartsDetail;
import com.stang.game.service.IGameChartsService;

public class GameChartsServiceImpl extends BaseServiceImpl<GameChartsDetail> implements IGameChartsService{
        CacheGameCharts c0;
        private CacheGameCharts c(){
			if(c0==null){
				c0=new CacheGameCharts();
			}
        	return c0;
        	
        }
	protected IGameChartsDao getBaseDao(){
		if(baseDao == null){
			baseDao = new GameChartsDaoImpl();
		}
		return (IGameChartsDao) baseDao;
	}

	@Override
	public boolean insertGameCharts(Map<String, Object> param) {
		return getBaseDao().insertGameCharts(param);
	}

	@Override
	public List<GameChartsDetail> findByNum(Map<String, Object> param) {
		return getBaseDao().findByNum(param);
	}

	@Override
	public boolean updateGameCharts(Map<String, Object> param) {
		return getBaseDao().updateGameCharts(param);
	}

	@Override
	public List<GameChartsDetail> findByDT(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findByDT(param);
	}

	@Override
	public List<GameChartsDetail> findByQZ(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findByQZ(param);
	}

	@Override
	public List<GameChartsDetail> findalllie() {
		// TODO Auto-generated method stub
		return c().findalllie();
		//return getBaseDao().findalllie();
	}

	@Override
	public List<GameChartsDetail> getid(int roleId) {
		// TODO Auto-generated method stub
		return c().getid(roleId);

		//return getBaseDao().getid(roleId);
	}

	@Override
	public List<GameChartsDetail> getiddt(int roleId) {
		// TODO Auto-generated method stub
		return c().getiddt(roleId);

		//return getBaseDao().getiddt(roleId);
	}

	@Override
	public List<GameChartsDetail> getidqz(int roleId) {
		// TODO Auto-generated method stub
		return c().getidqz(roleId);

		//return getBaseDao().getidqz(roleId);
	}

	@Override
	public List<GameChartsDetail> findallliet() {
		// TODO Auto-generated method stub
		return c().findallliet();

		//return getBaseDao().findallliet();
	}

	@Override
	public List<GameChartsDetail> findalllief() {
		// TODO Auto-generated method stub
		return c().findalllief();

		//return getBaseDao().findalllief();
	}

	@Override
	public List<GameChartsDetail> getall() {
		// TODO Auto-generated method stub
		return c().getall();

		//return getBaseDao().getall();
	}

	@Override
	public List<GameChartsDetail> findAllGameCharts() {
		// TODO Auto-generated method stub
		return getBaseDao().findAllGameCharts();
	}
	@Override
	public List<GameChartsDetail> findByQZFirstTen(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findByQZFirstTen(param);
	}
	@Override
	public List<GameChartsDetail> getidByParamt(Map<String, Object> paramt) {
		// TODO Auto-generated method stub
		return c().getidByParamt(paramt);
	}
	
}
