package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IGameItemDao;
import com.stang.game.dao.impl.GameItemDaoImpl;
import com.stang.game.entity.detail.GameItemDetail;
import com.stang.game.service.IGameItemService;

public class GameItemServiceImpl extends BaseServiceImpl<GameItemDetail>
		implements IGameItemService {
	protected IGameItemDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GameItemDaoImpl();
		}
		return (IGameItemDao) baseDao;
	}

	public List<GameItemDetail> getGameItem() {
		return getBaseDao().getGameItem();
	}

	public List<GameItemDetail> getGameItemById(int getGameItemById) {
		return getBaseDao().getGameItemById(getGameItemById);
	}

	public List<GameItemDetail> getGameItemId(String itemname) {
		// TODO Auto-generated method stub
		return getBaseDao().getGameItemId(itemname);
	}

	public List<GameItemDetail> findAllItem(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findAllItem(param);
	}

	public boolean insertGameItem(GameItemDetail model) {
		// TODO Auto-generated method stub
		return getBaseDao().insertGameItem(model);
	}

	public boolean updateGameItem(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().updateGameItem(param);
	}

	



}
