package com.stang.game.ffd.controller;

import java.util.HashMap;
import java.util.List;

import com.stang.game.entity.detail.GameSkillDetail;
import com.stang.game.service.IGameSkillService;
import com.stang.game.service.impl.GameSkillServiceImpl;

public class ProjectActionSkill {



	private static IGameSkillService gameSkillService=new GameSkillServiceImpl();
	HashMap<String, Object> param = new HashMap<String, Object>();
	//input
	private int id;
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	private GameSkillDetail pro=new GameSkillDetail();
	private GameSkillDetail proo=new GameSkillDetail();
	public String load(){
		try {
			List<GameSkillDetail> gameskills = gameSkillService.findGameSkillByid(id);
			pro=gameskills.get(0);
			return "update";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public String update(){
		System.out.println("更新表开始执行=================================");
		try {
			
			param.put("skillName",pro.getSkillName());
			param.put("skillDesc",pro.getSkillDesc());
			param.put("skillIcon",pro.getSkillIcon() );
			param.put("skillMc",pro.getSkillMc());
			param.put("type",pro.getType());
			param.put("skillMcclip", pro.getSkillMcclip());
			param.put("skillType",pro.getSkillType());
			param.put("mpcost", pro.getMpcost());
			param.put("skillCd", pro.getSkillCd());
			param.put("skillArea", pro.getSkillArea());
			param.put("flag", pro.getFlag());
			param.put("skillBuffId", pro.getSkillBuffId());
			param.put("nameurl", pro.getNameurl());
			param.put("id", pro.getId());
			// gameTaskService.updateGameTask(param);
			 gameSkillService.updateGameSkill(param);
			 System.out.println("更新的task表========="+param);
				param.clear();
			return "listskill";
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
			gameSkillService.insertGameSkill(pro);
			return "listskill";
		} catch (Exception e) {
		
			e.printStackTrace();
			return "error";
		}
	}



	public GameSkillDetail getPro() {
		return pro;
	}



	public void setPro(GameSkillDetail pro) {
		this.pro = pro;
	}










	




	





}
