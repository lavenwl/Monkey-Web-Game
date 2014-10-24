package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;


import com.stang.game.dao.IRoleQuicktimeDao;
import com.stang.game.dao.impl.RoleQuicktimeDaoImpl;
import com.stang.game.entity.detail.RoleQuicktimeDetail;
import com.stang.game.service.IRoleQuicktimeService;

public class RoleQuicktimeServiceImpl extends BaseServiceImpl<RoleQuicktimeDetail>
implements IRoleQuicktimeService {
	protected IRoleQuicktimeDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new RoleQuicktimeDaoImpl();
		}
		return (IRoleQuicktimeDao) baseDao;
	}

	public List<RoleQuicktimeDetail> getQuicktime(Map<String, Object> param) {
		return getBaseDao().getQuicktime(param);
	}

	public boolean updateQuicktime(Map<String, Object> param) {
		return getBaseDao().updateQuicktime(param);
	}

	public boolean insertRolequicktime(RoleQuicktimeDetail detail) {
		return getBaseDao().insertRolequicktime(detail);
	}

}
