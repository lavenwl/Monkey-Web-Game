package com.stang.game.cache;

import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheRoleIns {
	//缓存类操作的缓存对象(key:id, value:RoleInsDetail)
	private static Map<Integer, RoleInsDetail> roleInss = null;
	//变动过的对象组成的队列，由于自动同步数据库
	public static QueueCache roleInsQueue = null;
	//静态类同步数据库线程
	public static ThreadCache thread = null;
	//静态初始化方法
	public CacheRoleIns(){
		if(thread == null){
			thread = new ThreadCache("roleIns");
			thread.start();
		}
		if(roleInss == null)
			roleInss = GlobalDatat.cacheRoleInsDetails;
		if(roleInsQueue == null)
			roleInsQueue = new QueueCache();
	}
	//根据roleid得到玩家数据
	public List<RoleInsDetail> getRoleIns(int roleId){
		List<RoleInsDetail> list = new ArrayList<RoleInsDetail>();
		if(null != roleInss.get(roleId))
			list.add(roleInss.get(roleId));
		return list;
	}
	//插入数据
	public boolean insertRoleIns(RoleInsDetail model1){
		boolean b = false;
		try{
			RoleInsDetail model = new RoleInsDetail();
			model = (RoleInsDetail)model1.clone();
			//更新缓存
			roleInss.put(model.getRoleId(), model);
			//更新队列
			model.setIsUpdate(2);
			roleInsQueue.enqueue(model);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//更新数据
	public boolean updateIns(Map<String, Object> param){
		boolean b = false;
		try{
			int roleid = Integer.valueOf(String.valueOf(param.get("roleId")));
			Object intensifytime = param.get("intensifytime");
			Object intensify = param.get("intensify");
			RoleInsDetail roleIns = new RoleInsDetail(); 
			roleIns = (RoleInsDetail)roleInss.get(roleid).clone();
			if(null != intensifytime)
				roleIns.setIntensifytime(Long.valueOf(String.valueOf(intensifytime)));
			if(null != intensify)
				roleIns.setIntensify(Long.valueOf(String.valueOf(intensify)));
			//更新缓存
			//roleInss.remove(roleid);
			roleInss.put(roleid, roleIns);
			//更新队列
			roleIns.setIsUpdate(1);
			roleInsQueue.enqueue(roleIns);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	public void updateIns(RoleInsDetail roleInsDetail) {
		// TODO Auto-generated method stub

		boolean b = false;
		try{
			int roleid = roleInsDetail.getRoleId();
			RoleInsDetail roleIns = roleInsDetail;
			//更新缓存
			//roleInss.remove(roleid);
			roleInss.put(roleid, roleIns);
			//更新队列
			roleIns.setIsUpdate(1);
			roleInsQueue.enqueue(roleIns);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
}
