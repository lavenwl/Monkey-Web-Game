package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IGameEquipDao;
import com.stang.game.dao.impl.GameEquipDaoImpl;
import com.stang.game.entity.detail.GameEquipDetail;
import com.stang.game.service.IGameEquipService;

public class GameEquipServiceImpl extends BaseServiceImpl<GameEquipDetail>
		implements IGameEquipService {
	protected IGameEquipDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GameEquipDaoImpl();
		}
		return (IGameEquipDao) baseDao;
	}

	public List<GameEquipDetail> getGameEquip() {
		return getBaseDao().getGameEquip();

	}

	public List<GameEquipDetail> getGameEquipById(int id) {
		return getBaseDao().getGameEquipById(id);
	}

	public List<GameEquipDetail> getGameEquipByEid(int eid) {
		return getBaseDao().getGameEquipByEid(eid);
	}

	public List<GameEquipDetail> findAllEquip(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findAllEquip(param);
	}

	public List<GameEquipDetail> findGameEquipByid(int id) {
		// TODO Auto-generated method stub
		return getBaseDao().findGameEquipByid(id);
	}

	public boolean insertGameequip(GameEquipDetail model) {
		// TODO Auto-generated method stub
		return getBaseDao().insertGameequip(model);
	}

	public boolean updateGameequip(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().updateGameequip(param);
	}

}
