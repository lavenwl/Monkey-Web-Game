package com.stang.game.service.impl;

import java.util.List;

import com.stang.game.cache.CacheServer;
import com.stang.game.dao.IActivityDao;
import com.stang.game.dao.IServerDao;
import com.stang.game.dao.impl.ActivityDaoImpl;
import com.stang.game.dao.impl.ServerDaoImpl;
import com.stang.game.entity.detail.ServerDetail;
import com.stang.game.service.IServerService;

public class ServerServiceImpl extends BaseServiceImpl<ServerDetail> implements IServerService{
      CacheServer cacheServer0;
      private CacheServer cacheServer(){
    	  if(cacheServer0==null){
    		  cacheServer0=new CacheServer();
    	  }
		return cacheServer0;
    	  
      }
	protected IServerDao getBaseDao(){
		if(baseDao==null){
			baseDao = new ServerDaoImpl();
		}
		return (IServerDao) baseDao;
	}
	@Override
	public List<ServerDetail> getAllServer() {
		// TODO Auto-generated method stub
 		return getBaseDao().getAllServer();
	}
	@Override
	public List<ServerDetail> getAllNewServer() {
		// TODO Auto-generated method stub
		return cacheServer().getAllNewServer();
		//return getBaseDao().getAllNewServer();
	}
	@Override
	public List<ServerDetail> getnamebyid(int id) {
		// TODO Auto-generated method stub
		return cacheServer().getnamebyid(id);
		//return getBaseDao().getnamebyid(id);
	}
	@Override
	public void updateOnlineUserNumber(int serverid, int num) {
		cacheServer().updateOnlineUserNumber(serverid, num);
	}

}
