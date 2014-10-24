package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;
import com.stang.game.server.handler.MilitartHandler;
import com.stang.game.cache.CacheGameMilitary;
import com.stang.game.dao.IGameMilitaryDao;
import com.stang.game.dao.impl.GameMilitaryDaoImpl;
import com.stang.game.entity.detail.GameMilitaryDetail;
import com.stang.game.service.IGameMilitaryService;

public class GameMilitaryServiceImpl extends BaseServiceImpl<GameMilitaryDetail> implements IGameMilitaryService {
	private static MilitartHandler m = null;
	private static MilitartHandler getMilitaryHandler(){
		if(m == null){
			m = new MilitartHandler();
		}
		return m;
	}
	CacheGameMilitary c0;
	private CacheGameMilitary c(){
		if(c0==null){
			c0=new CacheGameMilitary();
		}
		return c0;
		
	}
	
	protected IGameMilitaryDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GameMilitaryDaoImpl();
		}
		return (IGameMilitaryDao) baseDao;
	}

	@Override
	public List<GameMilitaryDetail> getGameMilitary() {
		return getBaseDao().getGameMilitary();
	}

	@Override
	public List<GameMilitaryDetail> getGameMilitaryByBz(int pinzhi) {
		return c().getGameMilitaryByBz(pinzhi);

		//return getBaseDao().getGameMilitaryByBz(pinzhi);
	}

	@Override
	public List<GameMilitaryDetail> getGameMilitaryBymid(int mid) {
		return c().getGameMilitaryBymid(mid);

//		return getBaseDao().getGameMilitaryBymid(mid);
	}

	@Override
	public List<GameMilitaryDetail> getGameMilitaryByparam(
			Map<String, Object> param) {
		//return getBaseDao().getGameMilitaryByparam(param);
		return c().getGameMilitaryByparam(param);
	}

	@Override
	public List<GameMilitaryDetail> getGameMilitaryBymid2(int mid) {
		// TODO Auto-generated method stub
		return c().getGameMilitaryBymid(mid);
		//return getBaseDao().getGameMilitaryBymid2(mid);
	}

	@Override
	public List<GameMilitaryDetail> getManyTableSelect(int mid) {
		// TODO Auto-generated method stub
		return this.getMilitaryHandler().resetMilitary(mid);
		//return getBaseDao().getManyTableSelect(mid);
	}

	@Override
	public List<GameMilitaryDetail> getManyTableSelect2(int mid) {
		// TODO Auto-generated method stub
		return getBaseDao().getManyTableSelect2(mid);
	}

	@Override
	public List<GameMilitaryDetail> getMilitaryPinzhi(int mid) {
		// TODO Auto-generated method stub
		return getBaseDao().getMilitaryPinzhi(mid);
	}
}
