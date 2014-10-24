package com.stang.game.ffd.controller;

import java.util.HashMap;
import java.util.List;

import com.stang.game.entity.detail.GameBingDetail;
import com.stang.game.service.IGameBingService;
import com.stang.game.service.impl.GameBingServiceImpl;

public class ProjectActionbing {


	private static IGameBingService gameBingService=new GameBingServiceImpl();
	HashMap<String, Object> param = new HashMap<String, Object>();
	//input
	private int id;
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	private GameBingDetail pro=new GameBingDetail();
	private GameBingDetail proo=new GameBingDetail();
	public String load(){
		try {
			List<GameBingDetail> gamebings = gameBingService.findGameBingByid(id);
			pro=gamebings.get(0);
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
			param.put("icon",pro.getIcon());
			param.put("artdesc",pro.getArtdesc());
			param.put("type",pro.getType());
			param.put("isenemy",pro.getIsenemy());
			param.put("gongji", pro.getGongji());
			param.put("xishu1",pro.getXishu1());
			param.put("xueliang", pro.getXueliang());
			param.put("xishu2", pro.getXishu2());
			param.put("fangyu", pro.getFangyu());
			param.put("gongsu", pro.getGongsu());
			param.put("gongfan", pro.getGongfan());
			param.put("shangfan", pro.getShangfan());
			param.put("sudu", pro.getSudu());
			param.put("renkou", pro.getRenkou());
			param.put("jiage", pro.getJiage());
			param.put("lengque",pro.getLengque());
			param.put("bullet", pro.getBullet());
			param.put("bulletfly", pro.getBulletfly());
			param.put("bullethit", pro.getBullethit());
			param.put("flag", pro.getFlag());
			param.put("skill", pro.getSkill());
			param.put("gongjun", pro.getGongjun());
			param.put("bingfu",pro.getBingfu());
			param.put("xtype", pro.getXtype());
			param.put("id", pro.getId());
			// gameTaskService.updateGameTask(param);
			gameBingService.updateGamebing(param);
			 System.out.println("更新的task表========="+param);
				param.clear();
			return "listbing";
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
			gameBingService.insertGameBing(pro);
			 System.out.println("插入的task表========="+pro.toString());
			return "listbing";
		} catch (Exception e) {
		
			e.printStackTrace();
			return "error";
		}
	}



	public GameBingDetail getPro() {
		return pro;
	}



	public void setPro(GameBingDetail pro) {
		this.pro = pro;
	}






	




	



}
