package com.stang.game.cache;

import com.stang.game.entity.GameEquip;
import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheRoleTarven {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<Integer, RoleTavernDetail>  RoleTarvens = null;
	//变动过的对象组成的队列，由于自动同步数据库
	public static QueueCache RoleTarvenQueue = null;
	public static QueueCache RoleTarvenQueue_in = null;
	//静态类同步数据库线程
	public static ThreadCache thread = null;
	//静态初始化方法
	public CacheRoleTarven(){
		if(thread == null){
			thread = new ThreadCache("RoleTarven");
			thread.start();
		}
		if(RoleTarvens == null)
			RoleTarvens = GlobalDatat.cacheRoleTavernDetails;
		if(RoleTarvenQueue == null)
			RoleTarvenQueue = new QueueCache("RoleTarven");
		if(RoleTarvenQueue_in == null)
			RoleTarvenQueue_in = new QueueCache("RoleTarven_in");
	}
	public boolean insertRoleTavern(Map<String, Object> param) {
		//System.out.println("执行了insertR___________________________oleTavern！！！！！！！！！！" + param.toString());
		RoleTavernDetail rt=new RoleTavernDetail();
		Object id1 = param.get("id1");
		Object id2 = param.get("id2");
		Object id3 = param.get("id3");
		Object id4 = param.get("id4");
		Object id5 = param.get("id5");
		Object id6 = param.get("id6");
		Object time = param.get("time");
		Object flag = param.get("flag");
		Object roleId = param.get("roleId");
		if(null!=id1){
			rt.setId(Integer.valueOf(String.valueOf(id1)));
		}if(null!=id2){
			rt.setId2(Integer.valueOf(String.valueOf(id2)));
		}if(null!=id3){
			rt.setId3(Integer.valueOf(String.valueOf(id3)));
		}if(null!=id4){
			rt.setId4(Integer.valueOf(String.valueOf(id4)));
		}if(null!=id5){
			rt.setId5(Integer.valueOf(String.valueOf(id5)));
		}if(null!=id6){
			rt.setId6(Integer.valueOf(String.valueOf(id6)));
		}if(null!=time){
			rt.setTime(Long.valueOf(String.valueOf(time)));
		}if(null!=flag){
			rt.setFlag(Integer.valueOf(String.valueOf(flag)));
		}if(null!=roleId){
			rt.setRoleId(Integer.valueOf(String.valueOf(roleId)));
		}
		rt.setFlag(1);
		boolean b = false;
		try{
			int id=0;
			if(RoleTarvens.isEmpty()){
				
			}else{
			Iterator it = RoleTarvens.keySet().iterator();
			while(it.hasNext()){
				Integer i = Integer.valueOf(it.next().toString());
				if(i>id){
					id=i;
				}
			}
			}
			rt.setId(id+1);
			RoleTavernDetail ro=new RoleTavernDetail();
			ro = (RoleTavernDetail)rt.clone();
			rt = ro;
			RoleTarvens.put(rt.getRoleId(), rt);
			rt.setIsUpdate(2);
			RoleTarvenQueue_in.enqueue(rt);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	public boolean updateRoleTavern(Map<String, Object> param) {
		//System.out.println("执行了updateR___________________________oleTavern！！！！！！！！！！" + param.toString());

		Object id1 = param.get("id1");
		Object id2 = param.get("id2");
		Object id3 = param.get("id3");
		Object id4 = param.get("id4");
		Object id5 = param.get("id5");
		Object id6 = param.get("id6");
		Object time = param.get("time");
		Object chuji = param.get("chuji");
		Object jifen = param.get("jifen");
		Object roleId = param.get("roleId");
	
		boolean b = false;
		try{
			//List<RoleTavernDetail> list = new ArrayList<RoleTavernDetail>();
//			Iterator it = RoleTarvens.keySet().iterator();
//			while(it.hasNext()){
//				Integer i = Integer.valueOf(it.next().toString());
				RoleTavernDetail rt = null;
				if(null != RoleTarvens.get(Integer.valueOf(String.valueOf(roleId))))
				rt = RoleTarvens.get(Integer.valueOf(String.valueOf(roleId)));
				if(rt.getRoleId()==Integer.valueOf(String.valueOf(roleId))){
					if(null!=id1){
						rt.setId1(Integer.valueOf(String.valueOf(id1)));
					}if(null!=id2){
						rt.setId2(Integer.valueOf(String.valueOf(id2)));
					}if(null!=id3){
						rt.setId3(Integer.valueOf(String.valueOf(id3)));
					}if(null!=id4){
						rt.setId4(Integer.valueOf(String.valueOf(id4)));
					}if(null!=id5){
						rt.setId5(Integer.valueOf(String.valueOf(id5)));
					}if(null!=id6){
						rt.setId6(Integer.valueOf(String.valueOf(id6)));
					}if(null!=time){
						rt.setTime(Long.valueOf(String.valueOf(time)));
					}if(null!=chuji){
						rt.setChuji(Integer.valueOf(String.valueOf(chuji)));
					}if(null!=jifen){
						rt.setJifen(Integer.valueOf(String.valueOf(jifen)));
					}
					RoleTavernDetail r = new RoleTavernDetail();
					r = (RoleTavernDetail)rt.clone();
					rt = r;
					//RoleTarvens.remove(rt.getRoleId());
					RoleTarvens.put(rt.getRoleId(), rt);
					rt.setIsUpdate(1);
					if(RoleTarvenQueue.indexMap.containsKey(rt.getRoleId())){
						//System.out.println("CacheRoleTarven避免了一次写入！");
					}else{
						RoleTarvenQueue.indexMap.put(rt.getRoleId(), null);
						RoleTarvenQueue.enqueue(rt);
					}	
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	public List<RoleTavernDetail> getRoleTavern(int roleId) {
	//	System.out.println("__________________CacheRoleTarvrn_________________________roleId:"+roleId);
		List<RoleTavernDetail> RoleTavernDetailList = new ArrayList<RoleTavernDetail>();
		RoleTavernDetail roleTavernDetail = null;
		try{
			if(null != RoleTarvens.get(roleId)){
				roleTavernDetail = RoleTarvens.get(roleId);
				RoleTavernDetailList.add(roleTavernDetail);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return RoleTavernDetailList;
	}
	public void insertRoleTavern(RoleTavernDetail roleTavernDetail) {
		// TODO Auto-generated method stub

		//System.out.println("执行了insertR___________________________oleTavern！！！！！！！！！！" + param.toString());
		RoleTavernDetail rt = roleTavernDetail;
		rt.setFlag(1);
		boolean b = false;
		try{
			RoleTavernDetail ro=new RoleTavernDetail();
			ro = (RoleTavernDetail)rt.clone();
			rt = ro;
			RoleTarvens.put(rt.getRoleId(), rt);
			rt.setIsUpdate(2);
			RoleTarvenQueue_in.enqueue(rt);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
	public void updateRoleTavern(RoleTavernDetail roleTavernDetail) {
		// TODO Auto-generated method stub

	
		boolean b = false;
		try{
				RoleTavernDetail rt = null;
				rt = roleTavernDetail;
					
					RoleTavernDetail r = new RoleTavernDetail();
					r = (RoleTavernDetail)rt.clone();
					rt = r;
					//RoleTarvens.remove(rt.getRoleId());
					RoleTarvens.put(rt.getRoleId(), rt);
					rt.setIsUpdate(1);
					if(RoleTarvenQueue.indexMap.containsKey(rt.getRoleId())){
						//System.out.println("CacheRoleTarven避免了一次写入！");
					}else{
						RoleTarvenQueue.indexMap.put(rt.getRoleId(), null);
						RoleTarvenQueue.enqueue(rt);
					}	
			
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}


}
