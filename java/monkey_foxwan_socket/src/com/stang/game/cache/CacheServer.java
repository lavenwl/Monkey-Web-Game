package com.stang.game.cache;

import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheServer {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<Integer,ServerDetail>  gameServers = null;
	//变动过的对象组成的队列，由于自动同步数据库
	public static QueueCache gameServerQueue = null;
	//静态类同步数据库线程
	public static ThreadCache thread = null;	
	//静态初始化方法
	public CacheServer(){
		if(thread == null){
			thread = new ThreadCache("server");
			thread.start();
		}
		if(gameServers == null)
			gameServers = GlobalDatat.cacheServerDetails;
		if(gameServerQueue == null)
			gameServerQueue = new QueueCache("server");
	}
	public List<ServerDetail> getAllNewServer() {
		List<ServerDetail> ServerDetailList = new ArrayList<ServerDetail>();

		Iterator it = gameServers.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			ServerDetail serverDetail = gameServers.get(i);
			if(serverDetail.getStatue_xin()==1){
				ServerDetailList.add(serverDetail);
			}
		}
		return ServerDetailList;
	}
	public List<ServerDetail> getnamebyid(int id) {
		// TODO Auto-generated method stub
		List<ServerDetail> serverDetailList = new ArrayList<ServerDetail>();
		serverDetailList.add(gameServers.get(id));
		return serverDetailList;
	}
	public void updateOnlineUserNumber(int serverid, int num){
		ServerDetail server = gameServers.get(serverid);
		server.setOnlineNum(num);
		gameServerQueue.enqueue(server);
	}
	
	
	
}
