package com.stang.game.cache;

import com.stang.game.entity.detail.*;
import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheRoleChallenge {
	//缓存类操作的缓存对象(key:roleid, value:RoleChallengeDetail)
	private static Map<Integer, RoleChallengeDetail> roleChallenges = null;
	//变动过的对象组成的队列，由于自动同步数据库
	public static QueueCache roleChallengeQueue = null;
	//静态类同步数据库线程
	public static ThreadCache thread = null;
	//静态初始化方法
	public CacheRoleChallenge(){
		if(thread == null){
			thread = new ThreadCache("roleChallenge");
			thread.start();
		}
		if(roleChallenges == null)
			roleChallenges = GlobalDatat.cacheRoleChallengeDetails;
		if(roleChallengeQueue == null)
			roleChallengeQueue = new QueueCache("roleChallenge");
	}
	//插入新的数据
	public boolean insertRoleChallenge(Map<String, Object> param){
		//System.out.println("插入新数据CacheRoleChallenge.inertRoleChallenge():param:" + param.toString() );
		boolean b = false;
		try{
			int id = Integer.valueOf(String.valueOf(param.get("id")));
			Object militaryid = param.get("militaryid");
			Object roleid = param.get("roleid");
			Object flag = param.get("flag");
			Object success = param.get("success");
			Object totals = param.get("totals");
			RoleChallengeDetail roleChallenge = new RoleChallengeDetail();
			roleChallenge.setId(id);
			if(null != militaryid)
				roleChallenge.setMilitaryid(String.valueOf(militaryid));
			if(null != roleid)
				roleChallenge.setRoleid(Integer.valueOf(String.valueOf(roleid)));
			if(null != flag)
				roleChallenge.setFlag(Integer.valueOf(String.valueOf(flag)));
			if(null != success)
				roleChallenge.setSuccess(Integer.valueOf(String.valueOf(success)));
			if(null != totals)
				roleChallenge.setTotals(Integer.valueOf(String.valueOf(totals)));
			roleChallenge.setFlag(1);
			//更新缓存
			roleChallenges.put(roleChallenge.getRoleid(), roleChallenge);
			//更新队列
			roleChallenge.setIsUpdate(2);
			roleChallengeQueue.enqueue(roleChallenge);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//根据roleid更新数据
	public boolean updateRoleChallenge(Map<String, Object> param){
		boolean b = false;
		try{
			//System.out.println("________CacheRoleChallenge.updateRoleChallenge():param:" + param.toString());
			int roleid = Integer.valueOf(String.valueOf(param.get("roleid")));
			Object militaryid = param.get("militaryid");
			Object win = param.get("win");
			Object success = param.get("success");
			Object totals = param.get("totals");
//			List<RoleChallengeDetail> list = new ArrayList<RoleChallengeDetail>(); 
//			Iterator it = roleChallenges.keySet().iterator();
//			while(it.hasNext()){
//				Integer i = Integer.valueOf(it.next().toString());
				RoleChallengeDetail roleChallenge = new RoleChallengeDetail();
				roleChallenge = (RoleChallengeDetail)roleChallenges.get(roleid).clone();
			//	System.out.println("更新前roleChallenge：id：" + roleChallenge.getId() + "  militaryids" + roleChallenge.getMilitaryid() );
				if(null != militaryid)
					roleChallenge.setMilitaryid(String.valueOf(militaryid));
				if(null != win)
					//roleChallenge.setFlag(Integer.valueOf(String.valueOf(win)));
					roleChallenge.setWin(Integer.valueOf(String.valueOf(win)));
                   if(null != success)
					roleChallenge.setSuccess(Integer.valueOf(String.valueOf(success)));
				if(null != totals)
					roleChallenge.setTotals(Integer.valueOf(String.valueOf(totals)));
//				list.add(roleChallenge);
//			}
//			for(int i = 0; i < list.size(); i++){
//				RoleChallengeDetail roleChallenge = new RoleChallengeDetail();
//				try{
//					roleChallenge = (RoleChallengeDetail)list.get(i).clone();
//				}catch(Exception e){
//					e.printStackTrace();
//				}
			//	System.out.println("更新后roleChallenge：id：" + roleChallenge.getId() + "  militaryids" + roleChallenge.getMilitaryid() + "   roleId():" + roleChallenge.getRoleid());

				//更新缓存
				//roleChallenges.remove(roleChallenge.getRoleid());
				roleChallenges.put(roleChallenge.getRoleid(), roleChallenge);
				//更新队列
				roleChallenge.setIsUpdate(1);
				roleChallengeQueue.enqueue(roleChallenge);
//			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	
	//根据roleid更新数据
		public boolean updateRoleChallenge(RoleChallengeDetail detail){
			boolean b = false;
			try{
				int roleid = detail.getRoleid();
					RoleChallengeDetail roleChallenge = detail;
					//更新缓存
					//roleChallenges.remove(roleChallenge.getRoleid());
					roleChallenges.put(roleChallenge.getRoleid(), roleChallenge);
					//更新队列
					roleChallenge.setIsUpdate(1);
					roleChallengeQueue.enqueue(roleChallenge);
//				}
				b = true;
			}catch(Exception e){
				e.printStackTrace();
			}
			return b;
		}
	
	//根据roleid查询数据
	public List<RoleChallengeDetail> findRoleChallengeById(Map<String, Object> param){
		//System.out.println("CacheRoleChallenge.findRoleChallengeById(); param:" + param.toString());
		int roleid = Integer.valueOf(String.valueOf(param.get("roleid")));
		List<RoleChallengeDetail> list = new ArrayList<RoleChallengeDetail>();
		if(null != roleChallenges.get(roleid))
			list.add(roleChallenges.get(roleid));
//		System.out.println("list:" + list.size());
//		Iterator it = roleChallenges.keySet().iterator();
//		while(it.hasNext()){
//			Integer i = Integer.valueOf(it.next().toString());
//			RoleChallengeDetail roleChallenge = roleChallenges.get(i);
//			if(roleChallenge.getRoleid() == roleid && roleChallenge.getFlag() == 1){
//				list.add(roleChallenge);
//				System.out.println("i:" + i + "     rolechallenge.roleId:" + roleChallenge.getRoleid());
//			}
//		}
		//System.out.println("list:" + list.size());
		return list;
	}
}
