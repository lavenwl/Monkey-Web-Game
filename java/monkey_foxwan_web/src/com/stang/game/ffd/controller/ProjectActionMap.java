package com.stang.game.ffd.controller;

import java.util.HashMap;
import java.util.List;

import com.stang.game.entity.detail.GameItemDetail;
import com.stang.game.entity.detail.GameMapDetail;
import com.stang.game.service.IGameMapService;
import com.stang.game.service.impl.GameMapServiceImpl;

public class ProjectActionMap {

	private static IGameMapService gameMapService=new GameMapServiceImpl();
	HashMap<String, Object> param = new HashMap<String, Object>();
	//input
	private int id;
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	private GameMapDetail pro=new GameMapDetail();
	private GameMapDetail proo=new GameMapDetail();
	public String load(){
		try {
			List<GameMapDetail> gamemaps = gameMapService.findGameMapByid(id);
			pro=gamemaps.get(0);
			return "update";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public String update(){
		try {
			String bat=pro.getBattery();
			//String bat="1";
			String name=pro.getName();
			//String name="2";
			//String desc=pro.getDesc();
			//String desc="3";
			int flag=pro.getFlag();
			//int flag=4;
			int gx= pro.getGetgongxun();
			//int gx=5;
			int exp=pro.getGetexp();
			//int exp=6;
			int yin=pro.getGetyin();
			//int yin=7;
			int id=pro.getId();
			//int id=1;
			System.out.println(bat);
		
			param.put("name", name);
			param.put("battery",bat );
			param.put("flag",flag );
			param.put("getgongxun",gx);
			param.put("getexp", exp);
			param.put("getyin", yin);
			param.put("id", id);
			 gameMapService.updateGameMap(param);
				param.clear();
			return "listmap";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	
	//output-->list.action
	public String add(){
		try {
			//System.out.println(pro.getItemname()+"名字====="+pro.getItemres()+"===res=="+pro.getItemprop()+"====prop=====");
		gameMapService.insertGameMap(pro);
			System.out.println("====插入道具表信息成功=====================");
			return "listmap";
		} catch (Exception e) {
			System.out.println("====插入道具表信息失败=====================");
			
			e.printStackTrace();
			return "error";
		}
	}



	public GameMapDetail getPro() {
		return pro;
	}



	public void setPro(GameMapDetail pro) {
		this.pro = pro;
	}
	
	




	


}
