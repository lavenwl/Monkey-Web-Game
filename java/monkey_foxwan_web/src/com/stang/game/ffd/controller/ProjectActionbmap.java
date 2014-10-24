package com.stang.game.ffd.controller;

import java.util.HashMap;
import java.util.List;

import com.stang.game.entity.detail.GameBmapDetail;
import com.stang.game.service.IGameBmapService;
import com.stang.game.service.impl.GameBmapServiceImpl;

public class ProjectActionbmap {


	private static IGameBmapService gameBmapService=new GameBmapServiceImpl();
	HashMap<String, Object> param = new HashMap<String, Object>();
	//input
	private int id;
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	private GameBmapDetail pro=new GameBmapDetail();
	private GameBmapDetail proo=new GameBmapDetail();
	public String load(){
		try {
			List<GameBmapDetail> gamebmaps = gameBmapService.findGameBmapByid(id);
			pro=gamebmaps.get(0);
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
			param.put("dengji",pro.getDengji());
			param.put("nandu",pro.getNandu());
			param.put("chubing",pro.getChubing());
			param.put("isagain",pro.getIsagain());
			param.put("flag", pro.getFlag());
			param.put("startlv",pro.getStartlv());
			param.put("startnum", pro.getStartnum());
			param.put("getexp", pro.getGetexp());
			param.put("getyin", pro.getGetyin());
			param.put("getgongxun", pro.getGetgongxun());
			param.put("id", pro.getId());
			// gameTaskService.updateGameTask(param);
			gameBmapService.updateGameBmap(param);
			 System.out.println("更新的task表========="+param);
				param.clear();
			return "listbmap";
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
			gameBmapService.insertGameBmap(pro);
			 System.out.println("插入的task表========="+pro.toString());
			return "listbmap";
		} catch (Exception e) {
		
			e.printStackTrace();
			return "error";
		}
	}



	public GameBmapDetail getPro() {
		return pro;
	}



	public void setPro(GameBmapDetail pro) {
		this.pro = pro;
	}






	




	



}
