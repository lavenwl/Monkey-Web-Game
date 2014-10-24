package com.stang.game.ffd.controller;

import java.util.HashMap;
import java.util.List;

import com.stang.game.entity.detail.GameMilitaryDetail;
import com.stang.game.service.IGameMilitaryService;
import com.stang.game.service.impl.GameMilitaryServiceImpl;
public class ProjectActionmilitary {


	private static IGameMilitaryService gameMilitaryService=new GameMilitaryServiceImpl();
	HashMap<String, Object> param = new HashMap<String, Object>();
	//input
	private int id;
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	private GameMilitaryDetail pro=new GameMilitaryDetail();
	private GameMilitaryDetail proo=new GameMilitaryDetail();
	public String load(){
		try {
			List<GameMilitaryDetail> gametasks = gameMilitaryService.findGameMilitaryByid(id);
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
			param.put("pingzhi",pro.getPingzhi());
			param.put("pztype",pro.getPztype() );
			param.put("gongji",pro.getGongji() );
			param.put("type",pro.getType());
			param.put("gongsu", pro.getGongsu());
			param.put("fanwei",pro.getFanwei());
			param.put("gjiacheng", pro.getGjiacheng());
			param.put("xljiacheng", pro.getXljiacheng());
			param.put("xueliang", pro.getXueliang());
			param.put("level", pro.getLevel());
			param.put("art", pro.getArt());
			param.put("arts", pro.getArts());
			param.put("flag", pro.getFlag());
			
			param.put("isshow", pro.getIsshow());
			param.put("iscompose", pro.getIscompose());
			param.put("isaddcompose", pro.getIsaddcompose());
			param.put("needcompose", pro.getNeedcompose());
			param.put("composeid", pro.getComposeid());
			param.put("id", pro.getId());
			gameMilitaryService.updateGameMilitary(param);
				param.clear();
			return "listmilitary";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	
	//output-->list.action
	public String add(){
		System.out.println(pro.getDesc()+"==============得到的desc==============");
		try {
			//System.out.println(pro.getItemname()+"名字====="+pro.getItemres()+"===res=="+pro.getItemprop()+"====prop=====");
		//gameTaskService.insertGameMap(pro);
			gameMilitaryService.insertGameMilitary(pro);
			return "listmilitary";
		} catch (Exception e) {
		
			e.printStackTrace();
			return "error";
		}
	}



	public GameMilitaryDetail getPro() {
		return pro;
	}



	public void setPro(GameMilitaryDetail pro) {
		this.pro = pro;
	}








	




	



}
