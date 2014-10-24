package com.stang.game.ffd.controller;

import java.util.HashMap;
import java.util.List;

import com.stang.game.entity.detail.GameLevelDetail;
import com.stang.game.service.IGameLevelService;
import com.stang.game.service.impl.GameLevelServiceImpl;

public class ProjectActionlevel {


	private static IGameLevelService gameLevelService=new GameLevelServiceImpl();
	HashMap<String, Object> param = new HashMap<String, Object>();
	//input
	private int id;
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	private GameLevelDetail pro=new GameLevelDetail();
	private GameLevelDetail proo=new GameLevelDetail();
	public String load(){
		try {
			List<GameLevelDetail> gamelevels = gameLevelService.findGameLevelByid(id);
			pro=gamelevels.get(0);
			return "update";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public String update(){
		System.out.println("更新表开始执行=================================");
		try {
			
			param.put("level",pro.getLevel());
			param.put("getcoin",pro.getGetcoin());
			param.put("getgongxun",pro.getGetgongxun() );
			param.put("getexp",pro.getGetexp());
			param.put("needexp",pro.getNeedexp());
			param.put("flag", pro.getFlag());
		param.put("id", pro.getId());
			// gameTaskService.updateGameTask(param);
			gameLevelService.updateGameLevel(param);
			 System.out.println("更新的task表========="+param);
				param.clear();
			return "listlevel";
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
			gameLevelService.insertGameLevel(pro);
			 System.out.println("插入的task表========="+pro.toString());
			return "listlevel";
		} catch (Exception e) {
		
			e.printStackTrace();
			return "error";
		}
	}



	public GameLevelDetail getPro() {
		return pro;
	}



	public void setPro(GameLevelDetail pro) {
		this.pro = pro;
	}



	



	




	



}
