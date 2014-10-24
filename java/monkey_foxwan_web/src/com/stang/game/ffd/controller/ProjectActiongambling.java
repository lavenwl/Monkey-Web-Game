package com.stang.game.ffd.controller;

import java.util.HashMap;
import java.util.List;

import com.stang.game.entity.detail.GamblingItemDetail;
import com.stang.game.service.IGamblingItemService;
import com.stang.game.service.impl.GamblingItemServiceImpl;

public class ProjectActiongambling {


	private static IGamblingItemService gameblingService=new GamblingItemServiceImpl();
	HashMap<String, Object> param = new HashMap<String, Object>();
	//input
	private int id;
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	private GamblingItemDetail pro=new GamblingItemDetail();
	private GamblingItemDetail proo=new GamblingItemDetail();
	public String load(){
		try {
			List<GamblingItemDetail> gameblings = gameblingService.findgambling_itemByid(id);
			pro=gameblings.get(0);
			return "update";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public String update(){
		System.out.println("更新表开始执行=================================");
		try {
			
			param.put("mId",pro.getMId());
			param.put("typeId",pro.getTypeId());
			param.put("cost",pro.getCost());
			param.put("is_rare",pro.getIs_rare());
			param.put("rare_num",pro.getRare_num());
			param.put("rare_num_now", pro.getRare_num_now());
			param.put("flag",pro.getFlag());
			param.put("is_show", pro.getIs_show());
		    param.put("id", pro.getId());
			// gameTaskService.updateGameTask(param);
			gameblingService.updateGamblingItemByParam(param);
			 System.out.println("更新的task表========="+param);
				param.clear();
			return "listgambling";
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
			gameblingService.insertgambling_item(pro);
			 System.out.println("插入的task表========="+pro.toString());
			return "listgambling";
		} catch (Exception e) {
		
			e.printStackTrace();
			return "error";
		}
	}



	public GamblingItemDetail getPro() {
		return pro;
	}



	public void setPro(GamblingItemDetail pro) {
		this.pro = pro;
	}







	




	



}
