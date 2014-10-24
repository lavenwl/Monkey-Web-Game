package com.stang.game.ffd.controller;

import java.util.HashMap;
import java.util.List;

import com.stang.game.entity.detail.GameTaskDetail;
import com.stang.game.service.IGameTaskService;
import com.stang.game.service.impl.GameTaskServiceImpl;


public class ProjectActionTask {

	private static IGameTaskService gameTaskService=new GameTaskServiceImpl();
	HashMap<String, Object> param = new HashMap<String, Object>();
	//input
	private int id;
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	private GameTaskDetail pro=new GameTaskDetail();
	private GameTaskDetail proo=new GameTaskDetail();
	public String load(){
		try {
			List<GameTaskDetail> gametasks = gameTaskService.findGameTaskByid(id);
			pro=gametasks.get(0);
			return "update";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public String update(){
		System.out.println("更新表开始执行=================================");
		try {
			
			param.put("oldid",pro.getOldid());
			param.put("taskname",pro.getTaskname());
			param.put("taskdesc",pro.getTaskdesc() );
			param.put("taskdesc",pro.getTime() );
			param.put("type",pro.getType());
			param.put("tasktype", pro.getTasktype());
			param.put("tasklevel",pro.getTasklevel());
			param.put("tasksx", pro.getTasksx());
			param.put("tasknum", pro.getTasknum());
			param.put("exp", pro.getExp());
			param.put("taskcoin", pro.getTaskcoin());
			param.put("cointype", pro.getCointype());
			param.put("taskres", pro.getTaskres());
			param.put("taskres2", pro.getTaskres2());
			param.put("taskgoal", pro.getTaskgoal());
			param.put("flag", pro.getFlag());
			param.put("gongxun",pro.getGongxun());
			param.put("junling", pro.getJunling());
			param.put("id", pro.getId());
			// gameTaskService.updateGameTask(param);
			 gameTaskService.updateGametask(param);
			 System.out.println("更新的task表========="+param);
				param.clear();
			return "listtask";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	
	//output-->list.action
	public String add(){
		System.out.println("添加表开始执行===========================");
		try {
			//System.out.println(pro.getItemname()+"名字====="+pro.getItemres()+"===res=="+pro.getItemprop()+"====prop=====");
		//gameTaskService.insertGameMap(pro);
			gameTaskService.insertGametask(pro);
			 System.out.println("插入的task表========="+pro.toString());
			return "listtask";
		} catch (Exception e) {
		
			e.printStackTrace();
			return "error";
		}
	}



	public GameTaskDetail getPro() {
		return pro;
	}



	public void setPro(GameTaskDetail pro) {
		this.pro = pro;
	}




	




	


}
