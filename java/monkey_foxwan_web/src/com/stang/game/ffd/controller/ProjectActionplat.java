package com.stang.game.ffd.controller;

import java.util.HashMap;
import java.util.List;

import com.stang.game.entity.detail.GamePlatsDetail;
import com.stang.game.service.IGamePlatsService;
import com.stang.game.service.impl.GamePlatsServiceImpl;

public class ProjectActionplat {


	private static IGamePlatsService gamePlatService=new GamePlatsServiceImpl();
	HashMap<String, Object> param = new HashMap<String, Object>();
	//input
	private int id;
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}
private int mid;


	public int getMid() {
	return mid;
}



public void setMid(int mid) {
	this.mid = mid;
}

	private GamePlatsDetail pro=new GamePlatsDetail();
	private GamePlatsDetail proo=new GamePlatsDetail();
	public String load(){
		System.out.println(mid+"============mid=============="+id+"========================");
		try {
			
			param.put("id",id);
			param.put("mid",mid);
			List<GamePlatsDetail> gameplats = gamePlatService.findGamePlatByid(param);
			pro=gameplats.get(0);
			return "update";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public String update(){
		System.out.println("更新表开始执行=================================");
		try {
			param.clear();
			param.put("mid",pro.getMid());
			param.put("res",pro.getRes());
			param.put("resodds",pro.getResodds() );
			param.put("flag",pro.getFlag() );
			param.put("id", pro.getId());
			// gameTaskService.updateGameTask(param);
			gamePlatService.updateGameplat(param);
			 System.out.println("更新的task表========="+param);
				param.clear();
			return "listplat";
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
			gamePlatService.insertGameplat(pro);
			 System.out.println("插入的task表========="+pro.toString());
			return "listplat";
		} catch (Exception e) {
		
			e.printStackTrace();
			return "error";
		}
	}



	public GamePlatsDetail getPro() {
		return pro;
	}



	public void setPro(GamePlatsDetail pro) {
		this.pro = pro;
	}







	




	



}
