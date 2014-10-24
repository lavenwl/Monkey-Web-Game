package com.stang.game.cache;

import com.stang.game.entity.GameEquip;
import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheGameLevel {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<Integer, GameLevelDetail>  gameLevels = null;
	//静态初始化方法
	public CacheGameLevel(){
		if(gameLevels == null)
			gameLevels = GlobalDatat.cacheGameLevelDetails;
	}
	public GameLevelDetail getGameLevelByRoleLevel(Integer roleLevel) {
		 return gameLevels.get(roleLevel);
		
	}
	public List<GameLevelDetail> getGaemLevelByParams(Map<String, Object> param) {
		System.out.println("CacheGameLevel.g_____________________etgameLewvelByParams:" + param.toString());
		List<GameLevelDetail> gameLevelDetailList = new ArrayList<GameLevelDetail>();
		Object level = param.get("level");
		Object needexp = param.get("needexp");
		System.out.println("Integer.valueOf(String.valueOf(level));" + Integer.valueOf(String.valueOf(level)) + " Integer.valueOf(String.valueOf(needexp)):" + Integer.valueOf(String.valueOf(needexp)));
		Iterator it = gameLevels.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GameLevelDetail gameLevelDetail = new GameLevelDetail();
			try{
				gameLevelDetail = (GameLevelDetail)gameLevels.get(i).clone();
			}catch(Exception e){
				e.printStackTrace();
			}
			if(gameLevelDetail.getLevel() == (Integer.valueOf(String.valueOf(level)))
			&& gameLevelDetail.getNeedexp() == (Integer.valueOf(String.valueOf(needexp)))){
				gameLevelDetailList.add(gameLevelDetail);
			}
		}
		return gameLevelDetailList;
	}
	
	public List<GameLevelDetail> allGameLevelDetail(){
		List<GameLevelDetail> list = new ArrayList<GameLevelDetail>();
		Iterator it = gameLevels.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GameLevelDetail gameLevelDetail = gameLevels.get(i);
			list.add(gameLevelDetail);
		}
		return list;
	}

}
