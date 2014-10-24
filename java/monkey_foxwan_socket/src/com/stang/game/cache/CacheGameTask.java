package com.stang.game.cache;

import com.stang.game.entity.GameEquip;
import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheGameTask {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<Integer, GameTaskDetail>  gameTasks = null;
	//静态初始化方法
	public CacheGameTask(){
		if(gameTasks == null)
			gameTasks = GlobalDatat.cacheGameTaskDetails;
	}
	public List<GameTaskDetail> getAllGameTask() {
		List<GameTaskDetail> gameTaskDetailList = new ArrayList<GameTaskDetail>();
		Iterator it = gameTasks.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GameTaskDetail gameTaskDetail = gameTasks.get(i);
			if(gameTaskDetail.getId()>34){
				gameTaskDetailList.add(gameTaskDetail);
			}
		}
		return gameTaskDetailList;
	}
	public List<GameTaskDetail> getGameTaskDetail(Map<String, Object> param) {
		List<GameTaskDetail> gameTaskDetailList = new ArrayList<GameTaskDetail>();
		Object flag = param.get("flag");
		Object id = param.get("id");
		Object oldid = param.get("oldid");
		Object type = param.get("type");
		Object tasktype = param.get("tasktype");
		Object tasklevel = param.get("tasklevel");
		
		Iterator it = gameTasks.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GameTaskDetail gameTaskDetail = gameTasks.get(i);
			if(gameTaskDetail.getFlag() == (null==flag?gameTaskDetail.getFlag():Integer.valueOf(String.valueOf(flag)))
			&& gameTaskDetail.getId() == (null==id?gameTaskDetail.getId():Integer.valueOf(String.valueOf(id)))
			&& gameTaskDetail.getOldid() == (null==oldid?gameTaskDetail.getOldid():Integer.valueOf(String.valueOf(oldid)))
			&& gameTaskDetail.getType() == (null==type?gameTaskDetail.getType():Integer.valueOf(String.valueOf(type)))
			&& gameTaskDetail.getTasktype() == (null==tasktype?gameTaskDetail.getTasktype():Integer.valueOf(String.valueOf(tasktype)))
			&& gameTaskDetail.getTasklevel() == (null==tasklevel?gameTaskDetail.getTasklevel():Integer.valueOf(String.valueOf(tasklevel)))){
				gameTaskDetailList.add(gameTaskDetail);
			}
		}
		return gameTaskDetailList;
	}
	public List<GameTaskDetail> getGameTaskDetailById(int id) {
		// TODO Auto-generated method stub
		//System.out.println("_____________________CacheGameTask.getGameTaskDetailById:" + id + "size():" + gameTasks.size());
		List<GameTaskDetail> gameTaskDetailList = new ArrayList<GameTaskDetail>();
		if(null != gameTasks.get(id) && gameTasks.get(id).getFlag() == 1)
			gameTaskDetailList.add(gameTasks.get(id));
	//	System.out.println("list:" + gameTaskDetailList.size() + "  gameTasks.get(id):" + gameTasks.get(id).getTaskdesc());
		return gameTaskDetailList;
	}
	public List<GameTaskDetail> getGameTaskDetailByLv(int rolelevel) {
		List<GameTaskDetail> gameTaskDetailList = new ArrayList<GameTaskDetail>();
		Iterator it = gameTasks.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GameTaskDetail gameTaskDetail = gameTasks.get(i);
			if(gameTaskDetail.getTasklevel()==rolelevel){
				gameTaskDetailList.add(gameTaskDetail);
			}
		}
		return gameTaskDetailList;
	}
	public List<GameTaskDetail> getGameTaskDetailByType(int type) {
		List<GameTaskDetail> gameTaskDetailList = new ArrayList<GameTaskDetail>();
		Iterator it = gameTasks.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GameTaskDetail gameTaskDetail = gameTasks.get(i);
			if(gameTaskDetail.getType()==type){
				gameTaskDetailList.add(gameTaskDetail);
			}
		}
		return gameTaskDetailList;
	}
	public List<GameTaskDetail> getGameTaskDetailByLvandold(int level, int old) {
		List<GameTaskDetail> gameTaskDetailList = new ArrayList<GameTaskDetail>();
		Iterator it = gameTasks.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GameTaskDetail gameTaskDetail = gameTasks.get(i);
			if(gameTaskDetail.getOldid()==0&&
			   gameTaskDetail.getTasklevel()==level){
				gameTaskDetailList.add(gameTaskDetail);
			}
		}
		return gameTaskDetailList;
	}
	public List<GameTaskDetail> getGameTaskDetailByoId(int oid) {
		List<GameTaskDetail> gameTaskDetailList = new ArrayList<GameTaskDetail>();
		Iterator it = gameTasks.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GameTaskDetail gameTaskDetail = gameTasks.get(i);
			if(gameTaskDetail.getOldid()==oid){
				gameTaskDetailList.add(gameTaskDetail);
			}
		}
		return gameTaskDetailList;
	}
	public List<GameTaskDetail> getGameTaskDetailByTypeTasktype(int type,
			int tasktype) {
		List<GameTaskDetail> gameTaskDetailList = new ArrayList<GameTaskDetail>();
		Iterator it = gameTasks.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GameTaskDetail gameTaskDetail = gameTasks.get(i);
			if(gameTaskDetail.getType()==type&&
			   gameTaskDetail.getTasktype()==tasktype){
				gameTaskDetailList.add(gameTaskDetail);
			}
		}
		return gameTaskDetailList;
	}
	public GameTaskDetail findGameTaskDetailById(int id) {
		// TODO Auto-generated method stub
		
		return gameTasks.get(id);
	}
	
}
