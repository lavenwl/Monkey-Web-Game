package com.stang.game.service.impl;

import java.util.List;

import com.stang.game.dao.IActivityDao;
import com.stang.game.dao.IServerDao;
import com.stang.game.dao.impl.ActivityDaoImpl;
import com.stang.game.dao.impl.ServerDaoImpl;
import com.stang.game.entity.detail.ServerDetail;
import com.stang.game.service.IServerService;

public class ServerServiceImpl extends BaseServiceImpl<ServerDetail> implements IServerService{
	
	protected IServerDao getBaseDao(){
		if(baseDao==null){
			baseDao = new ServerDaoImpl();
		}
		return (IServerDao) baseDao;
	}

	public List<ServerDetail> getAllServer() {
		// TODO Auto-generated method stub
		return getBaseDao().getAllServer();
	}
	
	public boolean updateServer(ServerDetail server){
		return getBaseDao().updateServerDetail(server);
	}

}
