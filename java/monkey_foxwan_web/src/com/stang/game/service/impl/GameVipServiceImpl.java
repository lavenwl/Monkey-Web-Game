package com.stang.game.service.impl;

import java.util.List;

import com.stang.game.dao.IGameVipDao;
import com.stang.game.dao.impl.GameVipDaoImpl;
import com.stang.game.entity.detail.GameVipDetail;
import com.stang.game.service.IGameVipService;

public class GameVipServiceImpl extends BaseServiceImpl<GameVipDetail>
		implements IGameVipService {
	protected IGameVipDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GameVipDaoImpl();
		}
		return (IGameVipDao) baseDao;
	}

	public List<GameVipDetail> allGameVips() {
		return getBaseDao().allGameVips();
	}

	public List<GameVipDetail> getGameVipByLe(int level) {
		return getBaseDao().getGameVipByLe(level);
	}

	public List<GameVipDetail> getGameVipByAllvipRmb(int vipRmb) {
		return getBaseDao().getGameVipByAllvipRmb(vipRmb);
	}

}
