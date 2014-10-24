package com.stang.game.ffd.controller;

import java.util.HashMap;
import java.util.List;

import com.stang.game.entity.detail.GameBuffDetail;
import com.stang.game.service.IGameBuffService;
import com.stang.game.service.impl.GameBuffServiceImpl;

public class ProjectActionbuff {


	private static IGameBuffService gameBuffService=new GameBuffServiceImpl();
	HashMap<String, Object> param = new HashMap<String, Object>();
	//input
	private int id;
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	private GameBuffDetail pro=new GameBuffDetail();
	private GameBuffDetail proo=new GameBuffDetail();
	public String load(){
		try {
			List<GameBuffDetail> gamebuffs = gameBuffService.findGameBuffByid(id);
			pro=gamebuffs.get(0);
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
			param.put("buffdip",pro.getBuffDip());
			param.put("type",pro.getType());
			param.put("buffatktime",pro.getBuffAtktime());
			param.put("buffkeeptime",pro.getBuffKeeptime());
			param.put("atkperson", pro.getAtkperson());
			param.put("flag",pro.getFlag());
			param.put("bufftype", pro.getBufftype());
			param.put("bufftime", pro.getBufftime());
		param.put("id", pro.getId());
			// gameTaskService.updateGameTask(param);
			 gameBuffService.updateGameBuff(param);
			 System.out.println("更新的task表========="+param);
				param.clear();
			return "listbuff";
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
			gameBuffService.insertGameBuff(pro);
			 System.out.println("插入的task表========="+pro.toString());
			return "listbuff";
		} catch (Exception e) {
		
			e.printStackTrace();
			return "error";
		}
	}



	public GameBuffDetail getPro() {
		return pro;
	}



	public void setPro(GameBuffDetail pro) {
		this.pro = pro;
	}






	




	



}
