package com.stang.game.cache;

import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheRoleTask {
	//缓存类操作的缓存对象(key:roleid, value:RoleTaskDetail)
	private static Map<Integer, RoleTaskDetail> roleTasks = null;
	//变动过的对象组成的队列，由于自动同步数据库
	public static QueueCache roleTaskQueue = null;
	public static QueueCache roleTaskQueue_in = null;
	//静态类同步数据库线程
	public static ThreadCache thread = null;
	//静态初始化方法
	public CacheRoleTask(){
		if(thread == null){
			thread = new ThreadCache("roleTask");
			thread.start();
		}
		if(roleTasks == null)
			roleTasks = GlobalDatat.cacheRoleTaskDetails;
		if(roleTaskQueue == null)
			roleTaskQueue = new QueueCache("roleTask");
		if(roleTaskQueue_in == null)
			roleTaskQueue_in = new QueueCache("roleTask_in");
	}
	//插入数据
	public boolean insertRoleTask(Map<String, Object> param){
		boolean b = false;
		try{
			Object id = param.get("id");
			Object roleId = param.get("roleId");
			Object type = param.get("type");
			Object tasktype = param.get("tasktype");
			Object dailynum = param.get("dailynum");
			Object taskid = param.get("taskid");
			Object taskoldid = param.get("taskoldid");
			Object day = param.get("day");
			Object status = param.get("status");
			RoleTaskDetail roleTask = new RoleTaskDetail();
			if(null != id)
				roleTask.setId(Integer.valueOf(String.valueOf(id)));
			if(null != roleId)
				roleTask.setRoleId(Integer.valueOf(String.valueOf(roleId)));
			if(null != type)
				roleTask.setType(Integer.valueOf(String.valueOf(type)));
			if(null != tasktype)
				roleTask.setTasktype(Integer.valueOf(String.valueOf(tasktype)));
			if(null != dailynum)
				roleTask.setDailynum(Integer.valueOf(String.valueOf(dailynum)));
			if(null != taskid)
				roleTask.setTaskid(Integer.valueOf(String.valueOf(taskid)));
			if(null != taskoldid)
				roleTask.setTaskoldid(Integer.valueOf(String.valueOf(taskoldid)));
			if(null != day)
				roleTask.setDay(Integer.valueOf(String.valueOf(day)));
			if(null != status)
				roleTask.setStatus(Integer.valueOf(String.valueOf(status)));
			//更新缓存
			roleTasks.put(roleTask.getRoleId(), roleTask);
			//更新队列
			roleTask.setIsUpdate(2);
			roleTaskQueue_in.enqueue(roleTask);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//根据roleid找到玩家任务
	public List<RoleTaskDetail> findRoleTask(int roleid){
//		System.out.println("在线奖励缓存查询任务开始=====");
		List<RoleTaskDetail> list = new ArrayList<RoleTaskDetail>();
		if(null != roleTasks.get(roleid))
			list.add(roleTasks.get(roleid));
		return list;
		
	}
	//更新updateRoleTaskTye
	public boolean updateRoleTask(Map<String, Object> param){
		boolean b = false;
		try{
			Object type = param.get("type");
			Object time = param.get("time");
			Object taskid = param.get("taskid");
			Object dailynum = param.get("dailynum");
			Object day = param.get("day");
			Object status = param.get("status");
			Object tasktype = param.get("tasktype");
			int roleId = Integer.valueOf(String.valueOf(param.get("roleId")));
			RoleTaskDetail roleTask = null;
			roleTask = roleTasks.get(roleId);
			if(null != type)
				roleTask.setType(Integer.valueOf(String.valueOf(type)));
			if(null != time)
				roleTask.setTime(Long.valueOf(String.valueOf(time)));
			if(null != taskid)
				roleTask.setTaskid(Integer.valueOf(String.valueOf(taskid)));
			if(null != dailynum)
				roleTask.setDailynum(Integer.valueOf(String.valueOf(dailynum)));
			if(null != day)
				roleTask.setDay(Integer.valueOf(String.valueOf(day)));
			if(null != status)
				roleTask.setStatus(Integer.valueOf(String.valueOf(status)));
			if(null != tasktype)
				roleTask.setTasktype(Integer.valueOf(String.valueOf(tasktype)));
			//更新缓存
		//	roleTasks.remove(roleId);
			roleTasks.put(roleId, roleTask);
			//更新队列
			roleTask.setIsUpdate(1);
			if(roleTaskQueue.indexMap.containsKey(roleTask.getRoleId())){
				//System.out.println("roleTask避免了一次插入！");
			}else{
				roleTaskQueue.indexMap.put(roleTask.getRoleId(), null);
				roleTaskQueue.enqueue(roleTask);
			}
			
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//更新updateRoleTaskDailynum
	public boolean updateRoleTaskDailynum(Map<String, Object> param){
	//	System.out.println("缓存updateRoleTaskDailynum开始=========");
		boolean b = false;
		try{
			int roleid = Integer.valueOf(String.valueOf(param.get("roleId")));
			int dailynum = Integer.valueOf(String.valueOf(param.get("dailynum")));
			RoleTaskDetail roleTask = null; 
			roleTask = roleTasks.get(roleid);
			roleTask.setDailynum(roleTask.getDailynum()+dailynum);
			//更新缓存
		//	roleTasks.remove(roleid);
			roleTasks.put(roleid, roleTask);
			//更新队列
			roleTask.setIsUpdate(1);
			if(roleTaskQueue.indexMap.containsKey(roleTask.getRoleId())){
				//System.out.println("roleTask避免了一次插入！");
			}else{
				roleTaskQueue.indexMap.put(roleTask.getRoleId(), null);
				roleTaskQueue.enqueue(roleTask);
			}
			b = true;
//			System.out.println("缓存updateRoleTaskDailynum结束=======原有dailynum=="+roleTask.getDailynum()+"参数dailynum"+dailynum+"  总数dailynum"+roleTask.getDailynum());
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	public void insertRoleTask(RoleTaskDetail roleTaskDetail) {
		// TODO Auto-generated method stub

		boolean b = false;
		try{
			RoleTaskDetail roleTask = roleTaskDetail;
			//更新缓存
			roleTasks.put(roleTask.getRoleId(), roleTask);
			//更新队列
			roleTask.setIsUpdate(2);
			roleTaskQueue_in.enqueue(roleTask);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
	public void updateRoleTask(RoleTaskDetail roleTaskDetail) {
		// TODO Auto-generated method stub

		//	System.out.println("缓存updateRoleTaskDailynum开始=========");
			boolean b = false;
			try{
				RoleTaskDetail roleTask = roleTaskDetail;
				//更新缓存
			//	roleTasks.remove(roleid);
				roleTasks.put(roleTask.getRoleId(), roleTask);
				//更新队列
				roleTask.setIsUpdate(1);
				if(roleTaskQueue.indexMap.containsKey(roleTask.getRoleId())){
					//System.out.println("roleTask避免了一次插入！");
				}else{
					roleTaskQueue.indexMap.put(roleTask.getRoleId(), null);
					roleTaskQueue.enqueue(roleTask);
				}
				b = true;
//				System.out.println("缓存updateRoleTaskDailynum结束=======原有dailynum=="+roleTask.getDailynum()+"参数dailynum"+dailynum+"  总数dailynum"+roleTask.getDailynum());
			}catch(Exception e){
				e.printStackTrace();
			}
		
	}
}
