package com.stang.game.cache;

import com.stang.game.entity.detail.*;
import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheCallGift {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<Integer, CallGiftDetail> callGifts = null;
	//变动过的对象组成的队列，由于自动同步数据库
	public static QueueCache callGiftQueue = null;
	//静态类同步数据库线程
	public static ThreadCache thread = null;
	//静态初始化方法
	public CacheCallGift(){
		if(thread == null){
			thread = new ThreadCache("callGift");
			thread.start();
		}
		if(callGifts == null)
			callGifts = GlobalDatat.cacheCallGiftDetails;
		if(callGiftQueue == null)
			callGiftQueue = new QueueCache("callGift");
	}
	//根据id查找getcallgift
	public List<CallGiftDetail> getcallgift(int id){
		List<CallGiftDetail> bList = new ArrayList<CallGiftDetail>();
		bList.add(callGifts.get(id));
		return bList;
	}
}
