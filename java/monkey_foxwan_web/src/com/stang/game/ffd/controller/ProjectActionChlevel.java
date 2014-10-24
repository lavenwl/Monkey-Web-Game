package com.stang.game.ffd.controller;

import java.util.HashMap;
import java.util.List;

import com.stang.game.entity.detail.GameChLevelDetail;
import com.stang.game.service.IGameChLevelService;
import com.stang.game.service.impl.GameChLevelServiceImpl;

public class ProjectActionChlevel {


	private static IGameChLevelService gameChLevelService=new GameChLevelServiceImpl();
	HashMap<String, Object> param = new HashMap<String, Object>();
	//input
	private int id;
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	private GameChLevelDetail pro=new GameChLevelDetail();
	private GameChLevelDetail proo=new GameChLevelDetail();
	public String load(){
		try {
			List<GameChLevelDetail> gametasks = gameChLevelService.findGameChlevelByid(id);
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
			
			param.put("name",pro.getName());
			param.put("level",pro.getLevel());
			param.put("gongxun",pro.getGongxun() );
			param.put("ta",pro.getTa());
			param.put("type",pro.getType());
			param.put("flag", pro.getFlag());
		param.put("id", pro.getId());
			// gameTaskService.updateGameTask(param);
			gameChLevelService.updateGameGameCHLevel(param);
			 System.out.println("更新的task表========="+param);
				param.clear();
			return "listchlevel";
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
			gameChLevelService.insertGameCHLevel(pro);
			 System.out.println("插入的task表========="+pro.toString());
			return "listchlevel";
		} catch (Exception e) {
		
			e.printStackTrace();
			return "error";
		}
	}



	public GameChLevelDetail getPro() {
		return pro;
	}



	public void setPro(GameChLevelDetail pro) {
		this.pro = pro;
	}







	




	



}
