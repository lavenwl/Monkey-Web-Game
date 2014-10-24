package com.stang.game.cache;

import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheRoleQuicktime {
	//缓存类操作的缓存对象(key:id, value:RoleQuicktimeDetail)
	private static Map<Integer, RoleQuicktimeDetail> roleQuicktimes = null;
	//变动过的对象组成的队列，由于自动同步数据库
	public static QueueCache roleQuicktimeQueue = null;
	//静态类同步数据库线程
	public static ThreadCache thread = null;
	//静态初始化方法
	public CacheRoleQuicktime(){
		if(thread == null){
			thread = new ThreadCache("roleQuicktime");
			thread.start();
		}
		if(roleQuicktimes == null)
			roleQuicktimes = GlobalDatat.cacheRoleQuicktimeDetails;
		if(roleQuicktimeQueue == null)
			roleQuicktimeQueue = new QueueCache("roleQuicktime");
	}
	//根据roleid得到数据
	public List<RoleQuicktimeDetail> getQuicktime(Map<String, Object> param){
//		System.out.println("CacheROleQuicktime():param:" + param.toString() + "size:" + roleQuicktimes.size());
		int roleid = Integer.valueOf(String.valueOf(param.get("roleid")));
		List<RoleQuicktimeDetail> list = new ArrayList<RoleQuicktimeDetail>();
//		System.out.println("list.size();" + list.size());
		if(null != roleQuicktimes.get(roleid))
			list.add(roleQuicktimes.get(roleid));
//		System.out.println("list.size();" + list.size());
		return list;
	}
	//更新数据
	public boolean udpateQuicktime(Map<String, Object> param){
		boolean b = false;
		try{
			Object roleid = param.get("roleid");
			Object quicktime = param.get("quicktime");
			//RoleQuicktimeDetail roleQuicktime = new RoleQuicktimeDetail();
			RoleQuicktimeDetail roleQuicktime = null;
			
			if(null != roleid){
				//roleQuicktime = (RoleQuicktimeDetail)roleQuicktimes.get(Integer.valueOf(String.valueOf(roleid))).clone();
				roleQuicktime = (RoleQuicktimeDetail)roleQuicktimes.get(Integer.valueOf(String.valueOf(roleid)));
				
			}else{
				System.out.println("CacheRoleQuicktime.updateQuicktime()方法没有传入roleid！应该进行全表更新？");				
			}
			if(null != quicktime){
				roleQuicktime.setQuicktime(Long.valueOf(String.valueOf(quicktime)));
			}else{
				System.out.println("CacheRoleQuicktime.updateQuicktime()方法没有传入quicktime！更新失败！");				
			}
			//更新缓存
			//roleQuicktimes.remove(roleQuicktime.getRoleid());
			//roleQuicktimes.put(roleQuicktime.getRoleid(), roleQuicktime);
			//更新队列
			roleQuicktime.setIsUpdate(1);
			roleQuicktimeQueue.enqueue(roleQuicktime);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//插入新数据
	public boolean insertRolequicktime(RoleQuicktimeDetail model1){
		boolean b = false;
		try{
			RoleQuicktimeDetail model = new RoleQuicktimeDetail();
			model = (RoleQuicktimeDetail)model1.clone();
			//更新缓存
			roleQuicktimes.put(model.getRoleid(), model);
			//更新队列
			model.setIsUpdate(2);
			roleQuicktimeQueue.enqueue(model);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	public void udpateQuicktime(RoleQuicktimeDetail roleQuicktimeDetail) {
		// TODO Auto-generated method stub

		boolean b = false;
		try{
			RoleQuicktimeDetail roleQuicktime = null;
				//roleQuicktime = (RoleQuicktimeDetail)roleQuicktimes.get(Integer.valueOf(String.valueOf(roleid))).clone();
				roleQuicktime = roleQuicktimeDetail;
			
			//更新缓存
			//roleQuicktimes.remove(roleQuicktime.getRoleid());
			//roleQuicktimes.put(roleQuicktime.getRoleid(), roleQuicktime);
			//更新队列
			roleQuicktime.setIsUpdate(1);
			roleQuicktimeQueue.enqueue(roleQuicktime);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
}
