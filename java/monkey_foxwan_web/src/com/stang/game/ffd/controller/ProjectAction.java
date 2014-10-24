package com.stang.game.ffd.controller;

import java.util.HashMap;
import java.util.List;

import com.stang.game.entity.detail.GameItemDetail;
import com.stang.game.service.IGameItemService;
import com.stang.game.service.impl.GameItemServiceImpl;

public class ProjectAction {
	private static IGameItemService gameItemService=new GameItemServiceImpl();
	HashMap<String, Object> param = new HashMap<String, Object>();
	//input
	private int id;
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	private GameItemDetail pro=new GameItemDetail();
	private GameItemDetail proo=new GameItemDetail();
	public String load(){
		try {
			List<GameItemDetail> gameitems = gameItemService.getGameItemById(id);
			pro=gameitems.get(0);
			return "update";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public String update(){
		try {
			System.out.println(pro.getId()+"==主键=="+pro.getItemres()+"名字"+pro.getItemprop()+"道具说明=="+pro.getItemres()+"资源"+pro.getItemtype()+"==类型===");
			param.put("itemname", pro.getItemname());
			param.put("itemres", pro.getItemres());
			param.put("itemprop", pro.getItemprop());
			param.put("itemtype", pro.getItemtype());
			param.put("itemlevel", pro.getItemlevel());
			param.put("isover", pro.getIsover());
			param.put("isuse", pro.getIsuse());
			param.put("isshop", pro.getIsshop());
			param.put("coin", pro.getCoin());
			param.put("cointype", pro.getCointype());
			param.put("flag", pro.getFlag());
			param.put("reward", pro.getReward());
			param.put("quality", pro.getQuality());
			param.put("itemvip", pro.getItemvip());
			param.put("yuanbao", pro.getYuanbao());
			param.put("id", pro.getId());
			 gameItemService.updateGameItem(param);
			 param.clear();
			return "listitem";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	
	//output-->list.action
	public String add(){
		try {
			System.out.println(pro.getItemname()+"名字====="+pro.getItemres()+"===res=="+pro.getItemprop()+"====prop=====");
		gameItemService.insertGameItem(pro);
			System.out.println("====插入道具表信息成功=====================");
			return "listitem";
		} catch (Exception e) {
			System.out.println("====插入道具表信息失败=====================");
			
			e.printStackTrace();
			return "error";
		}
	}
	
	

	public GameItemDetail getPro() {
		return pro;
	}



	public void setPro(GameItemDetail pro) {
		this.pro = pro;
	}


	
}
