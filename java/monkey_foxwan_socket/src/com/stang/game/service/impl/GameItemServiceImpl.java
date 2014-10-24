package com.stang.game.service.impl;

import java.util.List;

import com.stang.game.cache.CacheGameItem;
import com.stang.game.dao.IGameItemDao;
import com.stang.game.dao.impl.GameItemDaoImpl;
import com.stang.game.entity.detail.GameItemDetail;
import com.stang.game.service.IGameItemService;

public class GameItemServiceImpl extends BaseServiceImpl<GameItemDetail>
		implements IGameItemService {
	CacheGameItem c0;
	private CacheGameItem c(){
		if(c0==null){
			c0=new CacheGameItem();
		}
		return c0;
		
	}
	protected IGameItemDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GameItemDaoImpl();
		}
		return (IGameItemDao) baseDao;
	}

	@Override
	public List<GameItemDetail> getGameItem() {
		return getBaseDao().getGameItem();
	}

	@Override
	public List<GameItemDetail> getGameItemById(int getGameItemById) {
		return c().getGameItemById(getGameItemById);
		//return getBaseDao().getGameItemById(getGameItemById);
	}

	@Override
	public List<GameItemDetail> getGameItemByIdtwo(int id) {
		// TODO Auto-generated method stub
		return c().getGameItemById(id);
		//return getBaseDao().getGameItemByIdtwo(id);
	}
	@Override
	public List<GameItemDetail> getGameItemByItemtype() {
		// TODO Auto-generated method stub
		return getBaseDao().getGameItemByItemtype();
	}
	@Override
	public List<GameItemDetail> getGameItemRequest() {
		// TODO Auto-generated method stub
		return c().getGameItemRequest();
	}
	@Override
	public List<GameItemDetail> getGameItemRequest2() {
		// TODO Auto-generated method stub
		return c().getGameItemRequest2();
	}
	@Override
	public List<GameItemDetail> getGameItemTurntable() {
		// TODO Auto-generated method stub
		return c().getGameItemTurntable();
	}
	@Override
	public List<GameItemDetail> getGameItemHappyTurntable() {
		// TODO Auto-generated method stub
		return c().getGameItemHappyTurntable();
	}
	@Override
	public List<GameItemDetail> getGameItemZillionaire() {
		// TODO Auto-generated method stub
		return c().getGameItemZillionaire();
	}
}
