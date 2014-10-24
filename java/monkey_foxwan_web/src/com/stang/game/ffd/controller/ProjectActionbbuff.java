package com.stang.game.ffd.controller;

import java.util.HashMap;
import java.util.List;

import com.stang.game.entity.detail.GameBbuffDetail;
import com.stang.game.service.IGameBbuffService;
import com.stang.game.service.impl.GameBbuffServiceImpl;

public class ProjectActionbbuff {


	private static IGameBbuffService gameBbuffService=new GameBbuffServiceImpl();
	HashMap<String, Object> param = new HashMap<String, Object>();
	//input
	private int id;
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	private GameBbuffDetail pro=new GameBbuffDetail();
	private GameBbuffDetail proo=new GameBbuffDetail();
	public String load(){
		try {
			List<GameBbuffDetail> gamebbuffs = gameBbuffService.findGameBbuffByid(id);
			pro=gamebbuffs.get(0);
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
			param.put("artdesc",pro.getArtdesc());
			param.put("shanghai",pro.getShanghai());
			param.put("type",pro.getType());
			param.put("time",pro.getTime());
			param.put("cishu",pro.getCishu());
			param.put("flag", pro.getFlag());
		    param.put("id", pro.getId());
			// gameTaskService.updateGameTask(param);
			gameBbuffService.updateGameBbuff(param);
			 System.out.println("更新的task表========="+param);
				param.clear();
			return "listbbuff";
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
			gameBbuffService.insertGameBbuff(pro);
			 System.out.println("插入的task表========="+pro.toString());
			return "listbbuff";
		} catch (Exception e) {
		
			e.printStackTrace();
			return "error";
		}
	}



	public GameBbuffDetail getPro() {
		return pro;
	}



	public void setPro(GameBbuffDetail pro) {
		this.pro = pro;
	}






	




	



}
