package com.stang.game.ffd.controller;

import java.util.HashMap;
import java.util.List;

import com.stang.game.entity.detail.GameEPropertyDetail;
import com.stang.game.service.IGameEPropertyService;
import com.stang.game.service.impl.GameEPropertyServiceImpl;

public class EquippropertyListAction {



	private static IGameEPropertyService gameEquippropertyService=new GameEPropertyServiceImpl();
	HashMap<String, Object> param = new HashMap<String, Object>();
//	List<GameItemDetail> equipList = new GameItemServiceImpl()
//			.getGameItem();
	//input 
	private int page = 1;//��ǰ��ʾ��ҳ��
	//output
	private int totalPages;//��ҳ��
	private List<GameEPropertyDetail> gameequippropertys;
	//injection
	private int pageSize = 15;
	private int id;
	public int getId() {
		return id;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	
	
	

	
	public String execute(){
		int begin = (page-1)*pageSize;
		param.put("page", begin);
		param.put("pageSize", pageSize);
		
		try {
			
			//gametasks=gameTaskService.findAllTask(param);
			gameequippropertys=gameEquippropertyService.findAllEProperty(param);
			List<GameEPropertyDetail> alltie=gameEquippropertyService.getGameEProperty();
			int totalRows =alltie.size();
			//根据totalRows和pageSize计算总页数totalPages
			if(totalRows == 0){
				totalPages= 1;//没有记录认为1页
				
			}else if(totalRows%pageSize == 0){
				totalPages= totalRows/pageSize;
			}else{
				totalPages= totalRows/pageSize+1;
				
			}
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	


	public List<GameEPropertyDetail> getGameequippropertys() {
		return gameequippropertys;
	}

	public void setGameequippropertys(List<GameEPropertyDetail> gameequippropertys) {
		this.gameequippropertys = gameequippropertys;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	





}
