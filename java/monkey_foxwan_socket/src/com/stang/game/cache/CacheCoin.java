package com.stang.game.cache;

import com.stang.game.entity.detail.*;
import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheCoin {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<Integer, CoinDetail> coins = null;
	//变动过的对象组成的队列，由于自动同步数据库
	public static QueueCache coinQueue = null;
	//静态类同步数据库线程
	public static ThreadCache thread = null;
	//静态初始化方法
	public CacheCoin(){
		if(thread == null){
			thread = new ThreadCache("coin");
			thread.start();
		}
		if(coins == null)
			coins = GlobalDatat.cacheCoindetails;
		if(coinQueue == null)
			coinQueue = new QueueCache("coin");
	}
	public boolean insertCoin(Map<String, Object> p) {
		boolean b = false;
		try{
			int id=0;
			if(coins.isEmpty()){
				
			}else{
			Iterator it = coins.keySet().iterator();
			while(it.hasNext()){
				Integer i = Integer.valueOf(it.next().toString());
				if(i>id){
					id=i;
				}
			}
			}
			CoinDetail m=new CoinDetail();
			m.setRoleid(Integer.valueOf(String.valueOf(p.get("roleid"))));
			m.setNum(Integer.valueOf(String.valueOf(p.get("num"))));
			m.setCoin(Integer.valueOf(String.valueOf(p.get("coin"))));
			m.setTime(String.valueOf(p.get("time")));
			coins.put(id+1, m);
			m.setIsUpdate(2);
			coinQueue.enqueue(m);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	
}
