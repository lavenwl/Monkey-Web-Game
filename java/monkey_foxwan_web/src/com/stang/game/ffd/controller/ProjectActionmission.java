package com.stang.game.ffd.controller;

import java.util.HashMap;
import java.util.List;

import com.stang.game.entity.detail.GameMissionDetail;
import com.stang.game.service.IGameMissionService;
import com.stang.game.service.impl.GameMissionServiceImpl;

public class ProjectActionmission {


	private static IGameMissionService gameMissionService=new GameMissionServiceImpl();
	HashMap<String, Object> param = new HashMap<String, Object>();
	//input
	private int id;
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	private GameMissionDetail pro=new GameMissionDetail();
	private GameMissionDetail proo=new GameMissionDetail();
	public String load(){
		try {
			List<GameMissionDetail> gametasks = gameMissionService.findGameMissionByid(id);
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
			param.put("artdesc",pro.getArtdesc());
			param.put("goal",pro.getGoal());
			param.put("jiangli",pro.getJiangli());
			param.put("flag",pro.getFlag());
		    param.put("id", pro.getId());
			// gameTaskService.updateGameTask(param);
			gameMissionService.updateGameMission(param);
			 System.out.println("更新的task表========="+param);
				param.clear();
			return "listmission";
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
			gameMissionService.insertGameMission(pro);
			 System.out.println("插入的task表========="+pro.toString());
			return "listmission";
		} catch (Exception e) {
		
			e.printStackTrace();
			return "error";
		}
	}



	public GameMissionDetail getPro() {
		return pro;
	}



	public void setPro(GameMissionDetail pro) {
		this.pro = pro;
	}







	




	



}
