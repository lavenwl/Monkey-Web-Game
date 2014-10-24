package com.stang.game.ffd.controller;

import java.util.HashMap;
import java.util.List;

import com.stang.game.entity.detail.GameFoeDetail;
import com.stang.game.service.IGameFoeService;
import com.stang.game.service.impl.GameFoeServiceImpl;

public class ProjectActionfoe {


	private static IGameFoeService gameFoeService=new GameFoeServiceImpl();
	HashMap<String, Object> param = new HashMap<String, Object>();
	//input
	private int foeid;
	



	public int getFoeid() {
		return foeid;
	}

	public void setFoeid(int foeid) {
		this.foeid = foeid;
	}



	private GameFoeDetail pro=new GameFoeDetail();
	private GameFoeDetail proo=new GameFoeDetail();
	public String load(){
		try {
			System.out.println(foeid+"foeid===================");
			List<GameFoeDetail> gamefoes = gameFoeService.findGameFoeByid(foeid);
			pro=gamefoes.get(0);
			return "update";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public String update(){
		System.out.println("更新表开始执行=================================");
		try {
			
			param.put("foename",pro.getFoename());
			param.put("foedesc",pro.getFoedesc());
			param.put("type",pro.getType());
			param.put("fangyu",pro.getFangyu());
			param.put("xueliang",pro.getXueliang());
			param.put("sudu", pro.getSudu());
			param.put("flag",pro.getFlag());
			param.put("id", pro.getFoeid());
			// gameTaskService.updateGameTask(param);
			 gameFoeService.updateGameFoe(param);
			 System.out.println("更新的task表========="+param);
				param.clear();
			return "listfoe";
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
			gameFoeService.insertGameFoe(pro);
			 System.out.println("插入的task表========="+pro.toString());
			return "listfoe";
		} catch (Exception e) {
		
			e.printStackTrace();
			return "error";
		}
	}



	public GameFoeDetail getPro() {
		return pro;
	}



	public void setPro(GameFoeDetail pro) {
		this.pro = pro;
	}







	




	



}
