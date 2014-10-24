package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IGamblingItemDao;
import com.stang.game.dao.impl.GamblingItemDaoImpl;
import com.stang.game.entity.detail.GamblingItemDetail;
import com.stang.game.entity.detail.RoleMapDetail;
import com.stang.game.service.IGamblingItemService;

public class GamblingItemServiceImpl extends
		BaseServiceImpl<GamblingItemDetail> implements IGamblingItemService {

	protected IGamblingItemDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GamblingItemDaoImpl();
		}
		return (IGamblingItemDao) baseDao;
	}

	public List<GamblingItemDetail> findAllgambling_item(
			Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findAllgambling_item(param);
	}

	public List<GamblingItemDetail> findgambling_itemByid(int id) {
		// TODO Auto-generated method stub
		return getBaseDao().findgambling_itemByid(id);
	}

	public List<GamblingItemDetail> getgambling_item() {
		// TODO Auto-generated method stub
		return getBaseDao().getgambling_item();
	}

	public boolean insertgambling_item(GamblingItemDetail model) {
		// TODO Auto-generated method stub
		return getBaseDao().insertgambling_item(model);
	}

	public boolean updateGamblingItemByParam(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().updateGamblingItemByParam(param);
	}

	


}
