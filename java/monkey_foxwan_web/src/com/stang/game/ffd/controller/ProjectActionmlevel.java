package com.stang.game.ffd.controller;

import java.util.HashMap;
import java.util.List;

import com.stang.game.entity.detail.GameMLevelDetail;
import com.stang.game.service.IGameMLevelService;
import com.stang.game.service.impl.GameMLevelServiceImpl;

public class ProjectActionmlevel {


	private static IGameMLevelService gameMlevelService=new GameMLevelServiceImpl();
	HashMap<String, Object> param = new HashMap<String, Object>();
	//input
	private int id;
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	private GameMLevelDetail pro=new GameMLevelDetail();
	private GameMLevelDetail proo=new GameMLevelDetail();
	public String load(){
		try {
			List<GameMLevelDetail> gamemlevels = gameMlevelService.findGameMLevelByid(id);
			pro=gamemlevels.get(0);
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
			param.put("exp",pro.getExp());
			param.put("allexp",pro.getAllexp() );
			param.put("xyin",pro.getXyin() );
			param.put("flag",pro.getFlag());
			 param.put("id", pro.getId());
			// gameTaskService.updateGameTask(param);
			gameMlevelService.updateGameMLevel(param);
			 System.out.println("更新的task表========="+param);
				param.clear();
			return "listmlevel";
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
			gameMlevelService.insertGameMLevel(pro);
			 System.out.println("插入的task表========="+pro.toString());
			return "listmlevel";
		} catch (Exception e) {
		
			e.printStackTrace();
			return "error";
		}
	}



	public GameMLevelDetail getPro() {
		return pro;
	}



	public void setPro(GameMLevelDetail pro) {
		this.pro = pro;
	}






	




	



}
