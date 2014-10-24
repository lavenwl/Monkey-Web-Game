package com.stang.game.cache;

import com.stang.game.common.GameConstants;
import com.stang.game.entity.GameEquip;
import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheGameItem {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<Integer, GameItemDetail>  gameItems = null;
	//静态初始化方法
	public CacheGameItem(){
		if(gameItems == null)
			gameItems = GlobalDatat.cacheGameItemDetails;
	}
	public List<GameItemDetail> getGameItemById(int id) {
		List<GameItemDetail> gameItemDetailList = new ArrayList<GameItemDetail>();
		
		gameItemDetailList.add(gameItems.get(id));
		
		return gameItemDetailList;
	}
	public List<GameItemDetail> getGameItemRequest() {
		List<GameItemDetail> list = new ArrayList<GameItemDetail>();
		if(gameItems.containsKey(3001))
		list.add(gameItems.get(3001));
		if(gameItems.containsKey(3002))
		list.add(gameItems.get(3002));
		if(gameItems.containsKey(3003))
		list.add(gameItems.get(3003));
		if(gameItems.containsKey(3004))
		list.add(gameItems.get(3004));
		if(gameItems.containsKey(3005))
		list.add(gameItems.get(3005));
		return list;
	}
	public List<GameItemDetail> getGameItemRequest2() {
		List<GameItemDetail> list = new ArrayList<GameItemDetail>();
		if(gameItems.containsKey(3006))
		list.add(gameItems.get(3006));
		if(gameItems.containsKey(3007))
		list.add(gameItems.get(3007));
		if(gameItems.containsKey(3008))
		list.add(gameItems.get(3008));
		if(gameItems.containsKey(3009))
		list.add(gameItems.get(3009));
		if(gameItems.containsKey(3010))
		list.add(gameItems.get(3010));
		return list;
	}
	public List<GameItemDetail> getGameItemTurntable() {//大转盘12个道具
		List<GameItemDetail> list = new ArrayList<GameItemDetail>();
		for (int i = GameConstants.TURNTABLE_START_ID; i <= GameConstants.TURNTABLE_END_ID; i++) {
			if(gameItems.containsKey(i)){
				list.add(gameItems.get(i));
			}
		}
		return list;
	}
	public List<GameItemDetail> getGameItemHappyTurntable() {//摇摇乐物品
		List<GameItemDetail> list = new ArrayList<GameItemDetail>();
		for (int i = GameConstants.HAPPY_TURNTABLE_START_ID; i <= GameConstants.HAPPY_TURNTABLE_END_ID; i++) {
			if(gameItems.containsKey(i)){
				list.add(gameItems.get(i));
			}
		}
		return list;
	}
	public List<GameItemDetail> getGameItemZillionaire() {//大富翁物品 zillionaire
		List<GameItemDetail> list = new ArrayList<GameItemDetail>();
		for (int i = GameConstants.ZILLIONAIRE_START_ID; i <= GameConstants.ZILLIONAIRE_END_ID; i++) {
			if(gameItems.containsKey(i)){
				list.add(gameItems.get(i));
			}
		}
		return list;
	}
}
