package com.stang.game.cache;

import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheGameAvatar {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<Integer, GameAvatarDetail> gameAvatars = null;
	//变动过的对象组成的队列，由于自动同步数据库
	public static QueueCache gameAvatarQueue = null;
	//静态初始化方法
	public CacheGameAvatar(){
		if(gameAvatars == null)
			gameAvatars = GlobalDatat.cacheGameAvatarDetails;
		if(gameAvatarQueue == null)
			gameAvatarQueue = new QueueCache("gameAvatars");
	}
	public GameAvatarDetail getGameAvatarDetail(int id) {
		// TODO Auto-generated method stub
		return gameAvatars.get(id);
	}
	
}
