package com.stang.game.cache;

import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheRoleImpose {
	//缓存类操作的缓存对象(key:id, value:RoleImposeDetail)
	private static Map<Integer, RoleImposeDetail> roleImposes = null;
	//变动过的对象组成的队列，由于自动同步数据库
	public static QueueCache roleImposeQueue = null;
	//静态类同步数据库线程
	public static ThreadCache thread = null;
	//静态初始化方法
	public CacheRoleImpose(){
		if(thread == null){
			thread = new ThreadCache("roleImpose");
			thread.start();
		}
		if(roleImposes == null)
			roleImposes = GlobalDatat.cacheRoleImposeDetails;
		if(roleImposeQueue == null)
			roleImposeQueue = new QueueCache();
	}
	//getRoleImposeDetail
	public List<RoleImposeDetail> getRoleImposeDetail(Map<String, Object> param){
		//System.out.println("CacheRoleItempose:____________________________param:" + param.toString());
		int roleid = Integer.valueOf(String.valueOf(param.get("roleid")));
		List<RoleImposeDetail> list = new ArrayList<RoleImposeDetail>();
		if(null != roleImposes.get(roleid)){
			try{
				RoleImposeDetail r = new RoleImposeDetail();
				r = (RoleImposeDetail)roleImposes.get(roleid).clone();
				list.add(r);

			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return list;
	}
	//insertRoleImpose
	public boolean insertRoleImpose(RoleImposeDetail model1){
		boolean b = false;
		try{
			model1.setFlag(1);
			RoleImposeDetail model = new RoleImposeDetail();
			model = (RoleImposeDetail)model1.clone();
			//update cache
			roleImposes.put(model.getRoleid(), model);
			//update queue
			model.setIsUpdate(2);
			roleImposeQueue.enqueue(model);
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//根据roleid更新roleImpose数据
	public boolean updateImpose(Map<String, Object> param){
		boolean b = false;
		try{
			int roleid = Integer.valueOf(String.valueOf(param.get("roleid")));
			Object imposetime = param.get("imposetime");
			Object impose = param.get("impose");
			Object imposenums = param.get("imposenums");
			Object imposenum = param.get("imposenum");
			Object isnew = param.get("isnew");
			Object day = param.get("day");
			RoleImposeDetail roleImpose = new RoleImposeDetail();
			roleImpose = (RoleImposeDetail)roleImposes.get(roleid);
			if(null != imposetime)
				roleImpose.setImposetime(Long.valueOf(String.valueOf(imposetime)));
			if(null != impose)
				roleImpose.setImpose(Integer.valueOf(String.valueOf(impose)));
			if(null != imposenums)
				roleImpose.setImposenums(Integer.valueOf(String.valueOf(imposenums)));
			if(null != imposenum)
				roleImpose.setImposenum(Integer.valueOf(String.valueOf(imposenum)));
			if(null != isnew)
				roleImpose.setIsnew(Integer.valueOf(String.valueOf(isnew)));
			if(null != day)
				roleImpose.setDay(Integer.valueOf(String.valueOf(day)));
			roleImpose.setFlag(1);
			//update cache
			//roleImposes.remove(roleid);
			//roleImposes.put(roleid, roleImpose);
			//update queue
			roleImpose.setIsUpdate(1);
			roleImposeQueue.enqueue(roleImpose);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//getRoleImposeDetail
	public List<RoleImposeDetail> getRoleImposeDetail(int roleId){
		//System.out.println("_____________________________________________roleid：" + roleId);
		int roleid = roleId;
		List<RoleImposeDetail> list = new ArrayList<RoleImposeDetail>();
		//System.out.println("list:" + list.size());
		if(null != roleImposes.get(roleid)){
			try{
				RoleImposeDetail r = new RoleImposeDetail();
				r = (RoleImposeDetail)roleImposes.get(roleid).clone();
				list.add(r);

			}catch(Exception e){
				e.printStackTrace();
			}
		}
	//		System.out.println("list:" + list.size());
		return list;
	}
	//更新isnew
	public void updateImposeIsnew(int isnew){
		Iterator it = roleImposes.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			RoleImposeDetail roleImpose = roleImposes.get(i);
			roleImpose.setIsnew(isnew);
			//roleImposes.remove(i);
			//roleImposes.put(i, roleImpose);
		}
	}
	public void updateImpose(RoleImposeDetail roleImposeDetail) {
		// TODO Auto-generated method stub

		boolean b = false;
		try{
			int roleid = roleImposeDetail.getRoleid();
			RoleImposeDetail roleImpose = new RoleImposeDetail();
			roleImpose = roleImposeDetail;
			roleImpose.setFlag(1);
			//update cache
			//roleImposes.remove(roleid);
			//roleImposes.put(roleid, roleImpose);
			//update queue
			roleImpose.setIsUpdate(1);
			roleImposeQueue.enqueue(roleImpose);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
}
