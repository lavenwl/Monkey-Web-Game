package com.stang.game.ffd.controller;

import java.util.HashMap;
import java.util.Map;

import com.stang.game.service.IShopdiscountService;
import com.stang.game.service.impl.ShopdiscountServiceImpl;


public class Updateshop {


	private static IShopdiscountService hostSatatusService=new ShopdiscountServiceImpl();
	Map<String,Object> param = new HashMap<String,Object>();
	
	private int id;
	
	private int flag;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
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
	private int month;
	private int day;
	private int monthend;
	private int dayend;
	private int discount;
	//
	public String execute() {
		try{
			param.put("discount",discount);
			param.put("flag",flag);
			param.put("month",month);
			param.put("day",day);
			param.put("monthend",monthend);
			param.put("dayend",dayend);
			param.put("id",id);
			
			hostSatatusService.updateShop(param);
			//List<HostStatusDetail> hoststatus=hostSatatusService.getHostStatus();
		System.out.println("========更新商城打折成功=============================================");
		
			return "success";
		}catch (Exception e) {
			return "error";
		}
		
	}






}
