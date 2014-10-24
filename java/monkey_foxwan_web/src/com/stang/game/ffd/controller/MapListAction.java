package com.stang.game.ffd.controller;

import java.util.HashMap;
import java.util.List;

import com.stang.game.entity.detail.GameMapDetail;
import com.stang.game.service.IGameMapService;
import com.stang.game.service.impl.GameMapServiceImpl;


public class MapListAction {

	private static IGameMapService gameMapService=new GameMapServiceImpl();
	HashMap<String, Object> param = new HashMap<String, Object>();
//	List<GameItemDetail> equipList = new GameItemServiceImpl()
//			.getGameItem();
	//input 
	private int page = 1;//��ǰ��ʾ��ҳ��
	//output
	private int totalPages;//��ҳ��
	private List<GameMapDetail> gamemaps;
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
			
			gamemaps=gameMapService.findAllMap(param);
			System.out.println("gamemaps======="+gamemaps);
			List<GameMapDetail> alltie=gameMapService.getGameMap();
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

	public List<GameMapDetail> getGamemaps() {
		return gamemaps;
	}

	public void setGamemaps(List<GameMapDetail> gamemaps) {
		this.gamemaps = gamemaps;
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
