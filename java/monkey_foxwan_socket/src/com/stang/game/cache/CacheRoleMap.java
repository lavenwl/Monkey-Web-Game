package com.stang.game.cache;

import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheRoleMap {
	//缓存类操作的缓存对象(key:id, value:RoleMapDetail)
	private static Map<Integer, RoleMapDetail> roleMaps = null;
	//变动过的对象组成的队列，由于自动同步数据库
	public static QueueCache roleMapQueue = null;
	//静态类同步数据库线程
	public static ThreadCache thread = null;
	//静态初始化方法
	public CacheRoleMap(){
		if(thread == null){
			thread = new ThreadCache("roleMap");
			thread.start();
		}
		if(roleMaps == null)
			roleMaps = GlobalDatat.cacheRoleMapDetails;
		if(roleMapQueue == null)
			roleMapQueue = new QueueCache();
	}
	//根据roleid得到玩家地图数据
	public List<RoleMapDetail> getRoleMap(int roleid){
		//System.out.println("CacheRoleMap_________________________getRoleMap:roleid:" + roleid);
		List<RoleMapDetail> list = new ArrayList<RoleMapDetail>();
		List<Integer> maps = GlobalDatat.cacheForRoleMap.get(roleid);
		if(null != maps){
			for(int i = 0; i < maps.size(); i++){
				RoleMapDetail roleMap = roleMaps.get(maps.get(i));
				list.add(roleMap);
			}
		}
		
		return list;
	}
	//插入新数据
	public boolean insertRoleMap(Map<String, Object> param){
		//System.out.println("CacheRoleMap_____________________________insertRoleMap:param:" + param.toString());
		boolean b = false;
		try{
			Object id = param.get("id");
			Object roleId = param.get("roleId");
			Object militaryid = param.get("militaryid");
			Object towerid = param.get("towerid");
			Object mapid = param.get("mapid");
			Object placeid = param.get("placeid");
			Object flag = param.get("flag");
			RoleMapDetail roleMap = new RoleMapDetail();
			if(null != id)
				roleMap.setId(Integer.valueOf(String.valueOf(id)));
			if(null != roleId)
				roleMap.setRoleId(Integer.valueOf(String.valueOf(roleId)));
			if(null != militaryid)
				roleMap.setMilitaryid(Integer.valueOf(String.valueOf(militaryid)));
			if(null != towerid)
				roleMap.setTowerid(Integer.valueOf(String.valueOf(towerid)));
			if(null != mapid)
				roleMap.setMapid(Integer.valueOf(String.valueOf(mapid)));
			if(null != placeid)
				roleMap.setPlaceid(Integer.valueOf(String.valueOf(placeid)));
			if(null != flag)
				roleMap.setFlag(Integer.valueOf(String.valueOf(flag)));
			if(GlobalDatat.cacheForRoleMap.get(roleMap.getRoleId()) == null){
				List<Integer> maps = new ArrayList<Integer>();
				maps.add(roleMap.getId());
				GlobalDatat.cacheForRoleMap.put(roleMap.getRoleId(), maps);
			}else{
				GlobalDatat.cacheForRoleMap.get(roleMap.getRoleId()).add(roleMap.getId());
			}
			//更新缓存
				roleMaps.put(roleMap.getId(), roleMap);
			//更新队列
				roleMap.setIsUpdate(2);
				roleMapQueue.enqueue(roleMap);
				b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//根据map映射更新数据
	public boolean updateRoleMap(Map<String, Object> param){
		//System.out.println("CacheRoleMap_____________________updateRoleMap:param:" + param.toString());
		boolean b = false;
		try{
			Object militaryid = param.get("militaryid");
			Object placeid = param.get("placeid");
			Object towerid = param.get("towerid");
			Object mapid = param.get("mapid");
			Object roleId = param.get("roleId");
			Object id = param.get("id");
			RoleMapDetail roleMap = new RoleMapDetail();
			if(null != id){
				roleMap = (RoleMapDetail)roleMaps.get(Integer.valueOf(String.valueOf(id))).clone();
			}else{
				int roleIdd = 0;
				int mapidd = 0;
				int placeidd = 0;
				if(null != roleId)
					roleIdd = Integer.valueOf(String.valueOf(roleId));
				if(null != mapid)
					mapidd = Integer.valueOf(String.valueOf(mapid));
				if(null != placeid)
					placeidd = Integer.valueOf(String.valueOf(placeid));
				if(roleIdd != 0){
					List maps = GlobalDatat.cacheForRoleMap.get(roleIdd);
					if(null != maps){
						for(int i = 0; i < maps.size(); i++){
							roleMap = roleMaps.get(maps.get(i));
							if(roleMap.getRoleId() == (roleIdd == 0 ? roleMap.getRoleId() : roleIdd) &&
									roleMap.getPlaceid() == (placeidd == 0 ? roleMap.getPlaceid() : placeidd) &&
									roleMap.getMapid() == (mapidd == 0 ? roleMap.getMapid() : mapidd)){
								RoleMapDetail roleMap1 = new RoleMapDetail();
								roleMap1 = (RoleMapDetail)roleMap.clone();
								roleMap = roleMap1;
								break;
							}
						}
					}
					
				}else{
					Iterator it = roleMaps.keySet().iterator();
					while(it.hasNext()){
						Integer i = Integer.valueOf(it.next().toString());
						roleMap = roleMaps.get(i);
						if(roleMap.getRoleId() == (roleIdd == 0 ? roleMap.getRoleId() : roleIdd) &&
								roleMap.getPlaceid() == (placeidd == 0 ? roleMap.getPlaceid() : placeidd) &&
								roleMap.getMapid() == (mapidd == 0 ? roleMap.getMapid() : mapidd)){
							RoleMapDetail roleMap1 = new RoleMapDetail();
							roleMap1 = (RoleMapDetail)roleMap.clone();
							roleMap = roleMap1;
							break;
						}
					}
				}
			}
			if(null != mapid)
				roleMap.setMapid(Integer.valueOf(String.valueOf(mapid)));
			if(null != placeid)
				roleMap.setPlaceid(Integer.valueOf(String.valueOf(placeid)));
			if(null != militaryid)
				roleMap.setMilitaryid(Integer.valueOf(String.valueOf(militaryid)));
			if(null != towerid)
				roleMap.setTowerid(Integer.valueOf(String.valueOf(towerid)));
			//更新缓存
//			roleMaps.remove(roleMap.getId());
			roleMaps.put(roleMap.getId(), roleMap);
			//更新队列
			roleMap.setIsUpdate(1);
			roleMapQueue.enqueue(roleMap);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//根据映射map得到数据
	public List<RoleMapDetail> getRoleMapByParam(Map<String, Object> param){
		//System.out.println("CacheROleMap________________________________getRolemapByParam:" + param.toString());
		List<RoleMapDetail> list = new ArrayList<RoleMapDetail>();
		Object roleId = param.get("roleId");
		Object mapid = param.get("mapid");
		Object placeid = param.get("placeid");
		Object id = param.get("id");
		Object militaryid = param.get("militaryid");
		Object towerid = param.get("towerid");
		if(null != id){
			if(null != roleMaps.get(Integer.valueOf(String.valueOf(id))))
				list.add(roleMaps.get(Integer.valueOf(String.valueOf(id))));
		}else{
			int roleIdd = 0;
			int mapidd = 0;
			int placeidd = 0;
			int militaryidd = 0;
			int toweridd = 0;
			if(null != roleId)
				roleIdd = Integer.valueOf(String.valueOf(roleId));
			if(null != mapid)
				mapidd = Integer.valueOf(String.valueOf(mapid));
			if(null != placeid)
				placeidd = Integer.valueOf(String.valueOf(placeid));
			if(null != militaryid)
				militaryidd = Integer.valueOf(String.valueOf(militaryid));
			if(null != towerid)
				toweridd = Integer.valueOf(String.valueOf(towerid));
			RoleMapDetail roleMap = new RoleMapDetail();
			
			if(roleIdd != 0){
				List<Integer> maps = GlobalDatat.cacheForRoleMap.get(roleIdd);
				if(null != maps){
					for(int i = 0; i < maps.size(); i ++){
						roleMap = roleMaps.get(maps.get(i));
						if(roleMap.getRoleId() == (roleIdd == 0 ? roleMap.getRoleId() : roleIdd) &&
								roleMap.getPlaceid() == (placeidd == 0 ? roleMap.getPlaceid() : placeidd) &&
								roleMap.getMapid() == (mapidd == 0 ? roleMap.getMapid() : mapidd) &&
								roleMap.getMilitaryid() == (militaryidd == 0 ? roleMap.getMilitaryid() : militaryidd) &&
								roleMap.getTowerid() == (toweridd == 0 ? roleMap.getTowerid() : toweridd)){
							list.add(roleMap);
						}
					}
				}
				
			}else{
				Iterator it = roleMaps.keySet().iterator();
				while(it.hasNext()){
					Integer i = Integer.valueOf(it.next().toString());
					roleMap = roleMaps.get(i);
					if(roleMap.getRoleId() == (roleIdd == 0 ? roleMap.getRoleId() : roleIdd) &&
							roleMap.getPlaceid() == (placeidd == 0 ? roleMap.getPlaceid() : placeidd) &&
							roleMap.getMapid() == (mapidd == 0 ? roleMap.getMapid() : mapidd) &&
							roleMap.getMilitaryid() == (militaryidd == 0 ? roleMap.getMilitaryid() : militaryidd) &&
							roleMap.getTowerid() == (toweridd == 0 ? roleMap.getTowerid() : toweridd)){
						list.add(roleMap);
					}
				}
			}
		}
		return list;
	}
	public void updateRoleMap(RoleMapDetail roleMapDetail) {
		// TODO Auto-generated method stub

		//System.out.println("CacheRoleMap_____________________updateRoleMap:param:" + param.toString());
		boolean b = false;
		try{
			RoleMapDetail roleMap = new RoleMapDetail();
			roleMap = roleMapDetail;
			
			//更新缓存
//			roleMaps.remove(roleMap.getId());
			roleMaps.put(roleMap.getId(), roleMap);
			//更新队列
			roleMap.setIsUpdate(1);
			roleMapQueue.enqueue(roleMap);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
}
