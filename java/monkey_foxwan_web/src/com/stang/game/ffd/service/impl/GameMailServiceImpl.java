package com.stang.game.ffd.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGameMailDao;
import com.stang.game.ffd.dao.impl.GameMailDaoImpl;
import com.stang.game.ffd.entity.detail.GameMailDetail;
import com.stang.game.ffd.service.IGameMailService;


public class GameMailServiceImpl extends BaseServiceImpl<GameMailDetail> implements
		IGameMailService {

	protected IGameMailDao getBaseDao() {
		if(baseDao == null) {
			baseDao = new GameMailDaoImpl();
		}
		return (IGameMailDao)baseDao;
	}

	public boolean batchDeleteGameMails(List<Integer> ids) {
		// TODO Auto-generated method stub
		return getBaseDao().batchDeleteGameMails(ids);
	}

	public boolean deleteGameMailById(Integer id) {
		// TODO Auto-generated method stub
		return getBaseDao().deleteGameMailById(id);
	}

	public boolean updateGameMailIsOpen(Integer id) {
		// TODO Auto-generated method stub
		return getBaseDao().updateGameMailIsOpen(id);
	}

	public List<GameMailDetail> findGameMailDetailByParam(
			Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findGameMailDetailByParam(param);
	}

	public GameMailDetail getGameMailDetailById(Integer id) {
		// TODO Auto-generated method stub
		return getBaseDao().getGameMailDetailById(id);
	}
	
	public int updateGameMailIsGold(Integer mId){
		return getBaseDao().updateGameMailIsGold(mId);
	}
	
	public List<GameMailDetail> getGameMailsByTime(Map<String, Object> param){
		return getBaseDao().getGameMailsByTime(param);
	}
	
}
