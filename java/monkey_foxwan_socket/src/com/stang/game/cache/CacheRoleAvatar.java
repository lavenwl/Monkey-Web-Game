package com.stang.game.cache;

import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheRoleAvatar {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<Integer, RoleAvatarDetail> roleAvatars = null;
	//变动过的对象组成的队列，由于自动同步数据库
	public static QueueCache  roleAvatarQueue = null;
	//静态类同步数据库线程
	public static ThreadCache thread = null;
	//静态初始化方法
	public CacheRoleAvatar(){
		if(thread == null){
			thread = new ThreadCache("roleAvatar");
			thread.start();
		}
		if(roleAvatars == null)
			roleAvatars = GlobalDatat.cacheRoleAvatarDetails;
		if(roleAvatarQueue == null)
			roleAvatarQueue = new QueueCache();
	}
	public boolean deleteRoleAvatar(Map<String, Object> param) {
		// TODO Auto-generated method stub
		boolean b=false;
		
		List<RoleAvatarDetail> roleAvatarDetailList=new ArrayList<RoleAvatarDetail>();
		Object roleid = param.get("roleid");
        Object avatarid = param.get("avatarid");
        Object id = param.get("id");
        Object isused = param.get("isused");
        Object address = param.get("address");
		try {
			Iterator it = roleAvatars.keySet().iterator();
			while(it.hasNext()){
				Integer i = Integer.valueOf(it.next().toString());
				RoleAvatarDetail roleAvatarDetail = new RoleAvatarDetail();
				try{
					roleAvatarDetail = (RoleAvatarDetail)roleAvatars.get(i).clone();
				}catch(Exception e){
					e.printStackTrace();
				}
				if(roleAvatarDetail.getRoleid()!=Integer.valueOf(String.valueOf(roleid))){
					continue;
				}
				if(roleAvatarDetail.getAvatarid() == (null == avatarid ? (roleAvatarDetail.getAvatarid()) : Integer.valueOf(String.valueOf(avatarid)))
				&& roleAvatarDetail.getId()== (null == id ? (roleAvatarDetail.getId()) : Integer.valueOf(String.valueOf(id)))
	            && roleAvatarDetail.getIsused() == (null == isused ? (roleAvatarDetail.getIsused()) : Integer.valueOf(String.valueOf(isused)))
	            && roleAvatarDetail.getAddress() == (null == address ? (roleAvatarDetail.getAddress()) : Integer.valueOf(String.valueOf(address)))
	            ){
					//roleAvatars.remove(roleAvatarDetail.getId());
					roleAvatars.get(roleAvatarDetail.getId()).setFlag(0);
					roleAvatarDetail.setIsUpdate(3);
					roleAvatarQueue.enqueue(roleAvatarDetail);
					
				}
			}
			b=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
		
	}
	public List<RoleAvatarDetail> getRoleAvatarDetail(Map<String, Object> param) {
		List<RoleAvatarDetail> roleAvatarList = new ArrayList<RoleAvatarDetail>();
		Object id = param.get("id");
		Object roleid = param.get("roleid");
		Object avatarid = param.get("avatarid");
		Object isused = param.get("isused");
		Iterator it = roleAvatars.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			RoleAvatarDetail roleAvatar = roleAvatars.get(i);
			if(roleAvatar.getId() == (null == id ? roleAvatar.getId() : Integer.valueOf(String.valueOf(id)))
			&& roleAvatar.getRoleid() == (null == roleid ? roleAvatar.getRoleid() : Integer.valueOf(String.valueOf(roleid)))
			&& roleAvatar.getAvatarid() == (null == avatarid ? roleAvatar.getAvatarid() : Integer.valueOf(String.valueOf(avatarid)))
			&&roleAvatar.getIsused() == (null == isused ? roleAvatar.getIsused() : Integer.valueOf(String.valueOf(isused)))){
				roleAvatarList.add(roleAvatar);
			}
		}
		return roleAvatarList;
	}
	public boolean insertRoleAvatar(RoleAvatarDetail detail1) {
		boolean b = false;
		try{
			RoleAvatarDetail detail = new RoleAvatarDetail();
			detail = (RoleAvatarDetail)detail1.clone();
			roleAvatars.put(detail.getId(), detail);
			detail.setIsUpdate(2);
			roleAvatarQueue.enqueue(detail);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	public boolean updateAvatar(Map<String, Object> param) {
		boolean b = false;
		Object roleid = Integer.valueOf(String.valueOf(param.get("roleid")));
		Object isused = Integer.valueOf(String.valueOf(param.get("isused")));
		int id = Integer.valueOf(String.valueOf(param.get("id")));
		try{
			RoleAvatarDetail roleAvatarDetail = new RoleAvatarDetail();
			try{
				roleAvatarDetail = (RoleAvatarDetail)roleAvatars.get(id).clone();
			}catch(Exception e){
				e.printStackTrace();
			}
			if(null!=roleid){
				roleAvatarDetail.setRoleid(Integer.valueOf(String.valueOf(roleid)));
			}
			if(null!=isused){
			roleAvatarDetail.setIsused(Integer.valueOf(String.valueOf(isused)));
			}
			//roleAvatars.remove(id);
			roleAvatars.put(id, roleAvatarDetail);
			roleAvatarDetail.setIsUpdate(1);
			roleAvatarQueue.enqueue(roleAvatarDetail);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	
}
