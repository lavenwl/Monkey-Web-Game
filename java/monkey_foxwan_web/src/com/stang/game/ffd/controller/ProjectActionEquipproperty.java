package com.stang.game.ffd.controller;

import java.util.HashMap;
import java.util.List;

import com.stang.game.entity.detail.GameEPropertyDetail;
import com.stang.game.service.IGameEPropertyService;
import com.stang.game.service.impl.GameEPropertyServiceImpl;

public class ProjectActionEquipproperty {



	private static IGameEPropertyService gameEquippropertyService=new GameEPropertyServiceImpl();
	HashMap<String, Object> param = new HashMap<String, Object>();
	//input
	private int id;
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	private GameEPropertyDetail pro=new GameEPropertyDetail();
	private GameEPropertyDetail proo=new GameEPropertyDetail();
	public String load(){
		try {
			List<GameEPropertyDetail> gameequippropertys = gameEquippropertyService.findGameEPropertyByid(id);
			pro=gameequippropertys.get(0);
			return "update";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public String update(){
		System.out.println("更新表开始执行=================================");
		try {
			
			param.put("type",pro.getType());
			param.put("speed",pro.getSpeed());
			param.put("attack",pro.getAttack());
			param.put("quality",pro.getQuality());
			param.put("hp",pro.getHp());
			param.put("id", pro.getId());
			// gameTaskService.updateGameTask(param);
			gameEquippropertyService.updateGameEProperty(param);
			 System.out.println("更新的task表========="+param);
				param.clear();
			return "listequipproperty";
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
			gameEquippropertyService.insertGameEProperty(pro);
			return "listequipproperty";
		} catch (Exception e) {
		
			e.printStackTrace();
			return "error";
		}
	}



	public GameEPropertyDetail getPro() {
		return pro;
	}



	public void setPro(GameEPropertyDetail pro) {
		this.pro = pro;
	}










	




	




}
