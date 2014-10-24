package com.stang.game.ffd.controller;

import java.util.HashMap;
import java.util.Map;

import com.stang.game.entity.detail.HostStatusDetail;
import com.stang.game.service.IHostStatusService;
import com.stang.game.service.impl.HostStatusServiceImpl;

public class Updatehuodong {


	private static IHostStatusService hostSatatusService=new HostStatusServiceImpl();
	Map<String,Object> param = new HashMap<String,Object>();
	
//
	HostStatusDetail hds;
	private int id;
	private int status;
	private String message;
	private int itemid;
	private int odds;
	private int mid1;
	private int mid2;
	public HostStatusDetail getHds() {
		return hds;
	}
	public void setHds(HostStatusDetail hds) {
		this.hds = hds;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getOdds() {
		return odds;
	}
	public void setOdds(int odds) {
		this.odds = odds;
	}
	public int getMid1() {
		return mid1;
	}
	public void setMid1(int mid1) {
		this.mid1 = mid1;
	}
	public int getMid2() {
		return mid2;
	}
	public void setMid2(int mid2) {
		this.mid2 = mid2;
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
	public String getRes1() {
		return res1;
	}
	public void setRes1(String res1) {
		this.res1 = res1;
	}
	public String getRes2() {
		return res2;
	}
	public void setRes2(String res2) {
		this.res2 = res2;
	}
	public String getReses() {
		return reses;
	}
	public void setReses(String reses) {
		this.reses = reses;
	}
	private int flag;
	private int month;
	private int day;
	private int monthend;
	private int dayend;
	private String res1;
	private String res2;
	private String reses;
	//
	public String execute() {
			System.out.println(status+".."+message+".."+itemid+".."+odds+mid1+".."+mid2+".mid2.");
		System.out.println(res1+".."+res2+".."+reses+",,"+flag+".."+month);
		System.out.println(day+".."+monthend+".."+dayend+".."+id);
			try{
			param.put("status",status);
			param.put("itemid",itemid);
			param.put("odds",odds);
			param.put("mid1",mid1);
			param.put("mid2",mid2);
			param.put("res1",res1);
			param.put("res2",res2);
			param.put("reses",reses);
			param.put("flag",flag);
			param.put("month",month);
			param.put("day",day);
			param.put("monthend",monthend);
			param.put("dayend",dayend);
			param.put("id",id);
			
			hostSatatusService.updatehd(param);
			//List<HostStatusDetail> hoststatus=hostSatatusService.getHostStatus();
		System.out.println("========更新活动状态成功=============================================");
		
			return "success";
		}catch (Exception e) {
			return "error";
		}
		
	}






}
