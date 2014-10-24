package com.stang.game.cache;

import com.stang.game.entity.detail.*;

import java.util.*;
import com.stang.game.server.ServerHandler;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheRoleTaskTask {
	//缓存类操作的缓存对象(key:id, value:RoleTaskTaskDetail)
	private static Map<Integer, RoleTaskTaskDetail> roleTaskTasks = null;
	//变动过的对象组成的队列，由于自动同步数据库
	public static QueueCache roleTaskTaskQueue = null;
	//静态类同步数据库线程
	public static ThreadCache thread = null;
	//静态初始化方法
	public CacheRoleTaskTask(){
		if(thread == null){
			thread = new ThreadCache("roleTaskTask");
			thread.start();
		}
		if(roleTaskTasks == null)
			roleTaskTasks = GlobalDatat.cacheRoleTaskTaskDetails;
		if(roleTaskTaskQueue == null)
			roleTaskTaskQueue = new QueueCache("roleTaskTask");
	}
	//根据roleid查询玩家的任务信息
	public List<RoleTaskTaskDetail> findRoleTask(int roleid){
		List<RoleTaskTaskDetail> list = new ArrayList<RoleTaskTaskDetail>();
		RoleTaskTaskDetail roleTaskTask = new RoleTaskTaskDetail();
		if(null != GlobalDatat.cacheForRoleTaskTask.get(roleid)){
			Iterator it = GlobalDatat.cacheForRoleTaskTask.get(roleid).keySet().iterator();
			while(it.hasNext()){
				Integer i = Integer.valueOf(it.next().toString());
				roleTaskTask = roleTaskTasks.get(GlobalDatat.cacheForRoleTaskTask.get(roleid).get(i));
				if(roleTaskTask.getFlag() == 1){
					list.add(roleTaskTask);
				}
			}
		}
		
		return list;
	}
	//deleteRoleTaskByTaskId0
	public boolean deleteRoleTaskByTaskId0(Map<String, Object> param){
		boolean b = false;
		try{
			int roleid = Integer.valueOf(String.valueOf(param.get("roleid")));
			int taskid = Integer.valueOf(String.valueOf(param.get("taskid")));
			RoleTaskTaskDetail roleTaskTask = new RoleTaskTaskDetail();
			int id = GlobalDatat.cacheForRoleTaskTask.get(roleid).get(taskid);
			//Iterator it = roleTaskTasks.keySet().iterator();
			//while(it.hasNext()){
				//Integer i = Integer.valueOf(it.next().toString());
				roleTaskTask = (RoleTaskTaskDetail) roleTaskTasks.get(id).clone();
				//if(roleTaskTask.getRoleId() == roleid && roleTaskTask.getTaskid() == taskid){
					RoleTaskTaskDetail roleTaskTask1 = new RoleTaskTaskDetail();
					roleTaskTask1 = (RoleTaskTaskDetail)roleTaskTask.clone();
					roleTaskTask = roleTaskTask1;
					//break;
				//}
			//}
			//更新缓存
			//roleTaskTasks.remove(roleTaskTask.getId());
			roleTaskTasks.get(roleTaskTask.getId()).setFlag(0);
			GlobalDatat.cacheForRoleTaskTask.get(roleid).remove(taskid);
			//更新队列
			roleTaskTask.setIsUpdate(3);
			roleTaskTaskQueue.enqueue(roleTaskTask);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//插入数据
	public boolean insertRoleTaskTask(Map<String, Object> param){
		//System.out.println("CacheRoleTaskTask.insertRoleTaskTask:param:" + param.toString());
//ServerHandler.debugQueue();
		boolean b = false;
		try{
			Object id = param.get("id");
			Object roleId = param.get("roleId");
			Object type = param.get("type");
			Object tasktype = param.get("tasktype");
			Object tasklevel = param.get("tasklevel");
			Object taskid = param.get("taskid");
			Object taskoldid = param.get("taskoldid");
			Object tasknum = param.get("tasknum");
			Object states = param.get("states");
			Object flag = param.get("flag");
			Object progress = param.get("progress");
			RoleTaskTaskDetail roleTaskTask = new RoleTaskTaskDetail();
			if(null != id)
				roleTaskTask.setId(Integer.valueOf(String.valueOf(id)));
			if(null != roleId)
				roleTaskTask.setRoleId(Integer.valueOf(String.valueOf(roleId)));
			if(null != type)
				roleTaskTask.setType(Integer.valueOf(String.valueOf(type)));
			if(null != tasktype)
				roleTaskTask.setTasktype(Integer.valueOf(String.valueOf(tasktype)));
			if(null != tasklevel)
				roleTaskTask.setTasklevel(Integer.valueOf(String.valueOf(tasklevel)));
			if(null != taskid)
				roleTaskTask.setTaskid(Integer.valueOf(String.valueOf(taskid)));
			if(null != taskoldid)
				roleTaskTask.setTaskoldid(Integer.valueOf(String.valueOf(taskoldid)));
			if(null != tasknum)
				roleTaskTask.setTasknum(Integer.valueOf(String.valueOf(tasknum)));
			if(null != states)
				roleTaskTask.setStates(Integer.valueOf(String.valueOf(states)));
			if(null != flag)
				roleTaskTask.setFlag(Integer.valueOf(String.valueOf(flag)));
			if(null != progress)
				roleTaskTask.setProgress(Integer.valueOf(String.valueOf(progress)));
			if(GlobalDatat.cacheForRoleTaskTask.get(roleTaskTask.getRoleId()) == null){
				//System.out.println("CacheRoleTaskTask.roleTaskTask.(if)id:" + roleTaskTask.getId());
				HashMap<Integer, Integer> maps = new HashMap<Integer, Integer>();
				maps.put(roleTaskTask.getTaskid(), roleTaskTask.getId());
				GlobalDatat.cacheForRoleTaskTask.put(roleTaskTask.getRoleId(), maps);
			}else{
				//System.out.println("CacheRoleTaskTask.roleTaskTask.(else)id:" + roleTaskTask.getId());
				GlobalDatat.cacheForRoleTaskTask.get(roleTaskTask.getRoleId()).put(roleTaskTask.getTaskid(), roleTaskTask.getId());
			}
			//更新缓存
			roleTaskTasks.put(roleTaskTask.getId(), roleTaskTask);
			//更新队列
			roleTaskTask.setIsUpdate(2);
			roleTaskTaskQueue.enqueue(roleTaskTask);
//ServerHandler.debugQueue();
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//更新updateRoleTaskState0
	public boolean updateRoleTaskState0(Map<String, Object> param){
		//System.out.println("CacheROleTask():upd___________________________ateRoleTaskState:param:" + param.toString() + "  cachedForTaskTask:" + GlobalDatat.cacheForRoleTaskTask.get(Integer.valueOf(String.valueOf(param.get("roleid")))));
		boolean b = false;
		try{
			int roleid = Integer.valueOf(String.valueOf(param.get("roleid")));
			int taskid = Integer.valueOf(String.valueOf(param.get("taskid")));
			int states = Integer.valueOf(String.valueOf(param.get("states")));
			RoleTaskTaskDetail roleTaskTask = new RoleTaskTaskDetail();
			int id = GlobalDatat.cacheForRoleTaskTask.get(roleid).get(taskid);
			//Iterator it = roleTaskTasks.keySet().iterator();
			//while(it.hasNext()){
				//Integer i = Integer.valueOf(it.next().toString());
				roleTaskTask = (RoleTaskTaskDetail) roleTaskTasks.get(id).clone();
				//if(roleTaskTask.getRoleId() == roleid && roleTaskTask.getTaskid() == taskid){
					roleTaskTask.setStates(states);
//					RoleTaskTaskDetail roleTaskTask1 = new RoleTaskTaskDetail();
//					roleTaskTask1 = (RoleTaskTaskDetail)roleTaskTask.clone();
//					roleTaskTask = roleTaskTask1;
					//break;
				//}
			//}
			//更新缓存
			//roleTaskTasks.remove(roleTaskTask.getId());
			roleTaskTasks.put(roleTaskTask.getId(), roleTaskTask);
			//更新队列
			roleTaskTask.setIsUpdate(1);
			roleTaskTaskQueue.enqueue(roleTaskTask);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//更新
	public List<RoleTaskTaskDetail> findRoleTask0(Map<String, Object> param){
		//System.out.println("打开查询所有任务findRoleTask0开始======================:" );
		//System.out.println("CacheRoleTaskTask.findRoleTask():param:" + param.toString());
		List<RoleTaskTaskDetail> list = new ArrayList<RoleTaskTaskDetail>();
		Object roleid = param.get("roleid");
		Object type = param.get("type");
		Object tasktype = param.get("tasktype");
		Object taskid = param.get("taskid");
		Object states = param.get("states");
		int roleidd = 0;
		int typed = 0;
		int tasktyped = 0;
		int statesd = -5;
		int taskidd = 0;
		if(null != roleid)
			roleidd = Integer.valueOf(String.valueOf(roleid));
		if(null != type)
			typed = Integer.valueOf(String.valueOf(type));
		if(null != tasktype)
			tasktyped = Integer.valueOf(String.valueOf(tasktype));
		if(null != taskid)
			taskidd = Integer.valueOf(String.valueOf(taskid));
		if(null != states)
			statesd = Integer.valueOf(String.valueOf(states));
			RoleTaskTaskDetail roleTaskTask = new RoleTaskTaskDetail();
		//	System.out.println("roleidd:" + roleidd + " typed:" + typed + "statesd:" + statesd + " tasktyped:" + tasktyped + " taskidd:" + taskidd + " roleTasktasksize:" + roleTaskTasks.size());
		//	System.out.println("null != GlobalDatat.cacheForRoleTaskTask.get(roleid):" + (null != GlobalDatat.cacheForRoleTaskTask.get(roleid)));
		if(null != GlobalDatat.cacheForRoleTaskTask.get(roleid)){
		//	System.out.println("GlobalDatat.cacheForRoleTaskTask.get(roleid).size:" + GlobalDatat.cacheForRoleTaskTask.get(roleid).toString());
			Iterator it = GlobalDatat.cacheForRoleTaskTask.get(roleid).keySet().iterator();
			while(it.hasNext()){
				Integer i = Integer.valueOf(it.next().toString()); 
				roleTaskTask = roleTaskTasks.get(GlobalDatat.cacheForRoleTaskTask.get(roleid).get(i));
		//		System.out.println("null != roleTaskTask:" + (null != roleTaskTask));
				if(null != roleTaskTask){
		//			System.out.println("CacheROleTaskTask:roleid:" + roleTaskTask.getRoleId() + " type:" + roleTaskTask.getType() + " taskid:" + roleTaskTask.getTaskid() + " statues:" + roleTaskTask.getStates() + " flag:" + roleTaskTask.getFlag() );
					if(roleTaskTask.getRoleId() == (roleidd == 0 ? roleTaskTask.getRoleId() : roleidd) && 
							roleTaskTask.getType() == (typed == 0 ? roleTaskTask.getType() : typed) &&
							roleTaskTask.getTasktype() == (tasktyped == 0 ? roleTaskTask.getTasktype() : tasktyped) && 
							roleTaskTask.getTaskid() == (taskidd == 0 ? roleTaskTask.getTaskid() : taskidd) &&
							roleTaskTask.getStates() == (statesd == -5 ? roleTaskTask.getStates() : statesd) &&
							roleTaskTask.getFlag() == 1){
						list.add(roleTaskTask);
		//				System.out.println("打开获取所有任务list:" + list.size());
		//				System.out.println("roleTask:" + roleTaskTask.getFlag());
					}
				}
				
			}
		}
		
		//System.out.println("打开查询所有任务findRoleTask0结束======================:list:" + list.size() );
		return list;
	}
	//findRoleTaskBytype0
	public List<RoleTaskTaskDetail> findRoleTaskBytype0(Map<String, Object> param){
		int roleid = Integer.valueOf(String.valueOf(param.get("roleid")));
		int type = Integer.valueOf(String.valueOf(param.get("type")));
		List<RoleTaskTaskDetail> list = new ArrayList<RoleTaskTaskDetail>();
		RoleTaskTaskDetail roleTaskTask = new RoleTaskTaskDetail();
		if(null != GlobalDatat.cacheForRoleTaskTask.get(roleid)){
			Iterator it = GlobalDatat.cacheForRoleTaskTask.get(roleid).keySet().iterator();
			while(it.hasNext()){
				Integer i = Integer.valueOf(it.next().toString());
				roleTaskTask = roleTaskTasks.get(GlobalDatat.cacheForRoleTaskTask.get(roleid).get(i));
				if(roleTaskTask.getRoleId() == roleid && roleTaskTask.getType() == type &&
						roleTaskTask.getFlag() == 1){
					list.add(roleTaskTask);
				}
			}
		}
		
		return list;
	}
	//updateRoleTaskProgress
	public boolean updateRoleTaskProgress(Map<String, Object> param){
		boolean b = false;
		try{
			int roleid = Integer.valueOf(String.valueOf(param.get("roleid")));
			int taskid = Integer.valueOf(String.valueOf(param.get("taskid")));
			int progress = Integer.valueOf(String.valueOf(param.get("progress")));
			int id = GlobalDatat.cacheForRoleTaskTask.get(roleid).get(taskid);
			//Iterator it = roleTaskTasks.keySet().iterator();
			RoleTaskTaskDetail roleTaskTask=null;
		//	while(it.hasNext()){
		//		Integer i = Integer.valueOf(it.next().toString());
				roleTaskTask = (RoleTaskTaskDetail) roleTaskTasks.get(id).clone();
				//if(roleTaskTask.getRoleId() == roleid && roleTaskTask.getTaskid() == taskid){
					int yl=roleTaskTask.getProgress()+progress;
					roleTaskTask.setProgress(yl);
				//break;
				//}
		//	}
			//更新缓存
		//	roleTaskTasks.remove(roleTaskTask.getId());
			RoleTaskTaskDetail roleTaskTask2=(RoleTaskTaskDetail) roleTaskTask.clone();
			roleTaskTasks.put(roleTaskTask.getId(), roleTaskTask);
			//更新队列
			roleTaskTask2.setIsUpdate(1);
			roleTaskTaskQueue.enqueue(roleTaskTask2);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//updateRoleTaskNum
	public boolean updateRoleTaskNum(Map<String, Object> param){
		//System.out.println("CacheROleTaskTask.updataROleTaskNum()________________________________________.param:" + param.toString());
		boolean b = false;
		try{
			int roleid = Integer.valueOf(String.valueOf(param.get("roleid")));
			int tasktype = Integer.valueOf(String.valueOf(param.get("tasktype")));
			int num = Integer.valueOf(String.valueOf(param.get("num")));
			RoleTaskTaskDetail roleTaskTask = new RoleTaskTaskDetail();
			if(null != GlobalDatat.cacheForRoleTaskTask.get(roleid)){
				Iterator it = GlobalDatat.cacheForRoleTaskTask.get(roleid).keySet().iterator();
				while(it.hasNext()){
					Integer i = Integer.valueOf(it.next().toString());
					roleTaskTask =  roleTaskTasks.get(GlobalDatat.cacheForRoleTaskTask.get(roleid).get(i));
					if(roleTaskTask.getRoleId() == roleid && roleTaskTask.getTasktype() == tasktype && roleTaskTask.getFlag() == 1){
						//System.out.println("CacheRoleTaskTask._________________________________roleTaskTask.getNum():" + roleTaskTask.getNum() + "   roleTaskTask.ID():" + roleTaskTask.getId());

						roleTaskTask.setNum(roleTaskTask.getNum() + num);
//						RoleTaskTaskDetail roleTaskTask1 = new RoleTaskTaskDetail();
//						roleTaskTask1 = (RoleTaskTaskDetail)roleTaskTask.clone();
//						roleTaskTask = roleTaskTask1;
						//System.out.println("CacheRoleTaskTask._________________________________roleTaskTask.getNum():" + roleTaskTask.getNum() + "   roleTaskTask.ID():" + roleTaskTask.getId());
						break;
					}
				}
			}
			
			//更新缓存
		//	roleTaskTasks.remove(roleTaskTask.getId());
			//System.out.println("CacheRoleTaskTask._________________________________roleTaskTask.getNum():" + roleTaskTasks.get(roleTaskTask.getId()).getNum() + "   roleTaskTask.ID():" + roleTaskTask.getId());

			roleTaskTasks.put(roleTaskTask.getId(), roleTaskTask);
			//System.out.println("CacheRoleTaskTask._________________________________roleTaskTask.getNum():" + roleTaskTasks.get(roleTaskTask.getId()).getNum() + "   roleTaskTask.ID():" + roleTaskTask.getId());

			//更新队列
			roleTaskTask.setIsUpdate(1);
			//System.out.println("CacheRoleTaskTask._________________________________roleTaskTask.getNum():" + roleTaskTask.getNum() + "   roleTaskTask.ID():" + roleTaskTask.getId());

			roleTaskTaskQueue.enqueue(roleTaskTask);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	public void updateRoleTask(RoleTaskTaskDetail roleTaskTaskDetail) {
		// TODO Auto-generated method stub

		//System.out.println("CacheROleTaskTask.updataROleTaskNum()________________________________________.param:" + param.toString());
		boolean b = false;
		try{
			RoleTaskTaskDetail roleTaskTask = roleTaskTaskDetail;
			
			//更新缓存
	
			roleTaskTasks.put(roleTaskTask.getId(), roleTaskTask);
			
			//更新队列
			roleTaskTask.setIsUpdate(1);
			//System.out.println("CacheRoleTaskTask._________________________________roleTaskTask.getNum():" + roleTaskTask.getNum() + "   roleTaskTask.ID():" + roleTaskTask.getId());

			roleTaskTaskQueue.enqueue(roleTaskTask);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
}
