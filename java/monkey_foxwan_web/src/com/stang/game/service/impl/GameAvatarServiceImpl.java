package com.stang.game.service.impl;

import java.util.List;

import com.stang.game.dao.IGameAvatarDao;
import com.stang.game.dao.impl.GameAvatarDaoImpl;
import com.stang.game.entity.detail.GameAvatarDetail;
import com.stang.game.service.IGameAvatarService;

/**
 * @author jianbo.feng
 * @company 上海三唐信息科技有限公司
 * @description 游戏装饰信息逻辑处理
 */
public class GameAvatarServiceImpl extends BaseServiceImpl<GameAvatarDetail>
		implements IGameAvatarService {
	protected IGameAvatarDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GameAvatarDaoImpl();
		}
		return (IGameAvatarDao) baseDao;
	}

	public List<GameAvatarDetail> findGameAvatarsByIds(List<Integer> ids) {
		// TODO Auto-generated method stub
		return getBaseDao().findGameAvatarsByIds(ids);
	}

	public List<GameAvatarDetail> allGameAvatars() {
		// TODO Auto-generated method stub
		return getBaseDao().allGameAvatars();
	}

	public GameAvatarDetail getGameAvatarDetail(int id) {
		return getBaseDao().getGameAvatarDetail(id);
	}

}
