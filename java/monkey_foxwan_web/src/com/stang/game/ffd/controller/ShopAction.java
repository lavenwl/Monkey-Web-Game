package com.stang.game.ffd.controller;

import java.util.HashMap;
import java.util.List;

import com.stang.game.entity.Shopdiscount;
import com.stang.game.entity.detail.ShopdiscountDetail;
import com.stang.game.service.IShopdiscountService;
import com.stang.game.service.impl.ShopdiscountServiceImpl;



public class ShopAction {

	private static IShopdiscountService shopService=new ShopdiscountServiceImpl();
	HashMap<String, Object> param = new HashMap<String, Object>();
	private List<ShopdiscountDetail> gametasks;
	//injection
	private int pageSize = 15;
	private int id;
    private int month;
    private int day;
    private int monthend;
    private int dayend;
    private int discount;
    private int flag;
	

	
	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonthend() {
		return monthend;
	}

	public void setMonthend(int monthend) {
		this.monthend = monthend;
	}

	public int getDayend() {
		return dayend;
	}

	public void setDayend(int dayend) {
		this.dayend = dayend;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getId() {
		return id;
	}

	public String execute(){
		
		try {
			
			gametasks=shopService.getShopdiscount(param);
			System.out.println("查询商店打折========"+gametasks.size());
			id=gametasks.get(0).getId();
			month=gametasks.get(0).getMonth();
			day=gametasks.get(0).getDay();
			monthend=gametasks.get(0).getMonthend();
			dayend=gametasks.get(0).getDayend();
			discount=gametasks.get(0).getDiscount();
			flag=gametasks.get(0).getFlag();
		
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public List<ShopdiscountDetail> getGametasks() {
		return gametasks;
	}

	public void setGametasks(List<ShopdiscountDetail> gametasks) {
		this.gametasks = gametasks;
	}

	public void setId(int id) {
		this.id = id;
	}

	


}
