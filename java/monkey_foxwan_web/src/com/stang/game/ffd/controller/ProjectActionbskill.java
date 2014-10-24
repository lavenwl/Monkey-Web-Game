package com.stang.game.ffd.controller;

import java.util.HashMap;
import java.util.List;

import com.stang.game.entity.detail.GameBskillDetail;
import com.stang.game.service.IGameBskillService;
import com.stang.game.service.impl.GameBskillServiceImpl;

public class ProjectActionbskill {

	private static IGameBskillService gameBskillService=new GameBskillServiceImpl();
	HashMap<String, Object> param = new HashMap<String, Object>();
	//input
	private int id;
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	private GameBskillDetail pro=new GameBskillDetail();
	private GameBskillDetail proo=new GameBskillDetail();
	public String load(){
		try {
			List<GameBskillDetail> gamebmaps = gameBskillService.findGameBskillByid(id);
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
			param.put("artdesc",pro.getArtdesc());
			param.put("buffid",pro.getBuffid());
			param.put("type",pro.getType());
			param.put("target",pro.getTarget());
			param.put("jilv", pro.getJilv());
			param.put("chufa",pro.getChufa());
			param.put("fanwei", pro.getFanwei());
			param.put("shanghai", pro.getShanghai());
			param.put("cishu", pro.getCishu());
			param.put("time", pro.getTime());
			param.put("bullet", pro.getBullet());
			param.put("cd", pro.getCd());
			param.put("flag", pro.getFlag());
			param.put("id", pro.getId());
			gameBskillService.updateGameBskill(param);
			 System.out.println("更新的task表========="+param);
				param.clear();
			return "listbskill";
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
			gameBskillService.insertGameBskill(pro);
			 System.out.println("插入的task表========="+pro.toString());
			return "listbskill";
		} catch (Exception e) {
		
			e.printStackTrace();
			return "error";
		}
	}



	public GameBskillDetail getPro() {
		return pro;
	}



	public void setPro(GameBskillDetail pro) {
		this.pro = pro;
	}










	




	


}
