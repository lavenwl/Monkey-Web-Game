package com.stang.game.service.impl;
import java.util.List;
import java.util.Map;

import com.stang.game.dao.IGameChartstwoDao;
import com.stang.game.dao.IGameJingjiFinalDao;
import com.stang.game.dao.IGameJingjiStaticDao;
import com.stang.game.dao.impl.GameChartstwoDaoImpl;
import com.stang.game.dao.impl.GameJingjiFinalDaoImpl;
import com.stang.game.dao.impl.GameJingjiStaticDaoImpl;
import com.stang.game.entity.detail.GameJingjiFinalDetail;
import com.stang.game.entity.detail.GameJingjiStaticDetail;
import com.stang.game.service.IGameJingjiFinalService;
import com.stang.game.service.IGameJingjiStaticService;

public class GameJingjiFinalServiceImpl extends BaseServiceImpl<GameJingjiFinalDetail> 
implements IGameJingjiFinalService{

	protected IGameJingjiFinalDao getBaseDao(){
		if(baseDao == null){
			baseDao = new GameJingjiFinalDaoImpl();
		}
		return (IGameJingjiFinalDao) baseDao;
	}
	
	@Override
	public boolean createGameJingjiFinal() {
		// TODO Auto-generated method stub
		return getBaseDao().createGameJingjiFinal();
	}

	@Override
	public boolean dropGameJingjiFinal() {
		// TODO Auto-generated method stub
		return getBaseDao().dropGameJingjiFinal();
	}

	@Override
	public boolean alterzhugong() {
		// TODO Auto-generated method stub
		return getBaseDao().alterzhugong();
	}

	@Override
	public boolean createzhugong() {
		// TODO Auto-generated method stub
		return getBaseDao().createzhugong();
	}

	@Override
	public boolean dropzhugong() {
		// TODO Auto-generated method stub
		return getBaseDao().dropzhugong();
	}

	@Override
	public List<GameJingjiFinalDetail> getGameJingjiByLimit(
			Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().getGameJingjiByLimit(param);
	}

	@Override
	public List<GameJingjiFinalDetail> getGameJingjiByServerid(
			Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().getGameJingjiByServerid(param);
	}

	@Override
	public List<GameJingjiFinalDetail> findAllGameJingji() {
		// TODO Auto-generated method stub
		return getBaseDao().findAllGameJingji();
	}

}
