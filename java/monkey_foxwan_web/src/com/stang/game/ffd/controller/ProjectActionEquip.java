package com.stang.game.ffd.controller;

import java.util.HashMap;
import java.util.List;

import com.stang.game.entity.detail.GameEquipDetail;
import com.stang.game.service.IGameEquipService;
import com.stang.game.service.impl.GameEquipServiceImpl;

public class ProjectActionEquip {


	private static IGameEquipService gameEquipService=new GameEquipServiceImpl();
	HashMap<String, Object> param = new HashMap<String, Object>();
	//input
	private int id;
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	private GameEquipDetail pro=new GameEquipDetail();
	private GameEquipDetail proo=new GameEquipDetail();
	public String load(){
		try {
			List<GameEquipDetail> gametasks = gameEquipService.findGameEquipByid(id);
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
			
			param.put("equipname",pro.getEquipname());
			param.put("equipurl",pro.getEquipurl());
			param.put("equiptype",pro.getEquiptype() );
			param.put("gongji",pro.getGongji());
			param.put("type",pro.getType());
			param.put("fanwei", pro.getFanwei());
			param.put("sudu",pro.getSudu());
			param.put("xueliang", pro.getXueliang());
			param.put("extra", pro.getExtra());
			param.put("level", pro.getLevel());
			param.put("flag", pro.getFlag());
			param.put("coin", pro.getCoin());
			param.put("cointype", pro.getCointype());
			param.put("isshop", pro.getIsshop());
			param.put("quality", pro.getQuality());
			param.put("id", pro.getId());
			// gameTaskService.updateGameTask(param);
			 gameEquipService.updateGameequip(param);
			 System.out.println("更新的task表========="+param);
				param.clear();
			return "listequip";
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
			gameEquipService.insertGameequip(pro);
			return "listequip";
		} catch (Exception e) {
		
			e.printStackTrace();
			return "error";
		}
	}



	public GameEquipDetail getPro() {
		return pro;
	}



	public void setPro(GameEquipDetail pro) {
		this.pro = pro;
	}







	




	



}
