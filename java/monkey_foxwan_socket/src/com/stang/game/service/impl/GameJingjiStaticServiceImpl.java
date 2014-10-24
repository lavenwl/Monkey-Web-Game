package com.stang.game.service.impl;
import java.util.List;
import java.util.Map;

import com.stang.game.dao.IGameJingjiStaticDao;
import com.stang.game.dao.impl.GameJingjiStaticDaoImpl;
import com.stang.game.entity.detail.GameJingjiStaticDetail;
import com.stang.game.service.IGameJingjiStaticService;
public class GameJingjiStaticServiceImpl extends BaseServiceImpl<GameJingjiStaticDetail> implements IGameJingjiStaticService{

	protected IGameJingjiStaticDao getBaseDao(){
		if(baseDao == null){
			baseDao = new GameJingjiStaticDaoImpl();
		}
		return (IGameJingjiStaticDao) baseDao;
	}

	@Override
	public List<GameJingjiStaticDetail> getGameJingjiByServerid(
			Map<String, Object> param) {
		return getBaseDao().getGameJingjiByServerid(param);
	}

	@Override
	public boolean insertGameJingji(Map<String, Object> param) {
		return getBaseDao().insertGameJingji(param);
	}

	@Override
	public List<GameJingjiStaticDetail> getGameJingjiMax(Map<String, Object> param) {
		return getBaseDao().getGameJingjiMax(param);
	}

	@Override
	public boolean updateGameJingjiByParams(Map<String, Object> param) {
		return getBaseDao().updateGameJingjiByParams(param);
	}

	@Override
	public boolean addGameJingjiIndexes(Map<String, Object> param) {
		return getBaseDao().addGameJingjiIndexes(param);
	}

	@Override
	public List<GameJingjiStaticDetail> getGameJingjiByLimit(
			Map<String, Object> param) {
		return getBaseDao().getGameJingjiByLimit(param);
	}

	@Override
	public List<GameJingjiStaticDetail> getGameJingjiByIndexes(
			Map<String, Object> param) {
		return getBaseDao().getGameJingjiByIndexes(param);
	}

	@Override
	public List<GameJingjiStaticDetail> getGameJingjiByServeridtwo(
			Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().getGameJingjiByServeridtwo(param);
	}

	@Override
	public List<GameJingjiStaticDetail> getGameJingjiByIndexestwo(
			Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().getGameJingjiByIndexestwo(param);
	}

	@Override
	public List<GameJingjiStaticDetail> findAllGameJingjiStatic() {
		// TODO Auto-generated method stub
		return getBaseDao().findAllGameJingjiStatic();
	}
}
