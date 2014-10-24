package com.stang.game.cache;

import com.stang.game.entity.GameEquip;
import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheGameMilitary {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<Integer, GameMilitaryDetail>  gameMilitarys = null;
	//静态初始化方法
	public CacheGameMilitary(){
		if(gameMilitarys == null)
			gameMilitarys = GlobalDatat.cacheGameMilitaryDetails;
	}
	public List<GameMilitaryDetail> getGameMilitaryByBz(int pinzhi) {
		List<GameMilitaryDetail> gameMilitaryDetailList = new ArrayList<GameMilitaryDetail>();
		Iterator it = gameMilitarys.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GameMilitaryDetail gameMilitaryDetail = gameMilitarys.get(i);
			if(gameMilitaryDetail.getIsshow() == 1
			&& gameMilitaryDetail.getPingzhi() == (Integer.valueOf(String.valueOf(pinzhi)))){
				gameMilitaryDetailList.add(gameMilitaryDetail);
			}
		}
		return gameMilitaryDetailList;
	}

	public List<GameMilitaryDetail> getGameMilitaryBymid(int mid) {
		// TODO Auto-generated method stub
		List<GameMilitaryDetail> gameMilitaryDetailList=new ArrayList<GameMilitaryDetail>();
		gameMilitaryDetailList.add(gameMilitarys.get(mid));
		return gameMilitaryDetailList;
	}
	public List<GameMilitaryDetail> getGameMilitaryByparam(
			Map<String, Object> param) {
		int roleid = Integer.valueOf(String.valueOf(param.get("roleId")));
		int pingzhi = Integer.valueOf(String.valueOf(param.get("pingzhi")));
		
		
		List<GameMilitaryDetail> gameMilitaryDetailList = new ArrayList<GameMilitaryDetail>();
		
		/****/
		List<Integer> militaries = GlobalDatat.cacheForRoleMilitary.get(roleid);
		Map<Integer, RoleMilitaryDetail> roleMilitaries = GlobalDatat.cacheRoleMilitaryDetails;
		Map<Integer, Integer> mis = new HashMap<Integer, Integer>();;
		if(militaries != null){
			for(int j = 0; j< militaries.size(); j++){
				mis.put(roleMilitaries.get(militaries.get(j)).getMilitaryid(), roleMilitaries.get(militaries.get(j)).getId());
				
				}
		}
		/****/
		Iterator it = gameMilitarys.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GameMilitaryDetail gameMilitaryDetail = gameMilitarys.get(i);
			if(gameMilitaryDetail.getIsshow() == 1
			&& gameMilitaryDetail.getPingzhi() == (pingzhi)){
				if(!mis.containsKey(gameMilitaryDetail.getId())){
					gameMilitaryDetailList.add(gameMilitaryDetail);
				}
			}
		}
		mis=null;
		return gameMilitaryDetailList;
	}


}
