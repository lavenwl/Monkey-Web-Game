package com.stang.game.ffd.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Action;

public class FilterRoleAction implements Action ,ServletResponseAware{
	private HttpServletResponse response;
	
	private String tip;
	private String ip;
	private String mask;
	private String releaseallTime;
	private String username;
	private String serverId;
	/*type:
	 * 1禁止发言
	 * 2禁止登录
	 * 和数据库一致
	 */
	private String type;
	/*caseType:
	 0查看禁止发言用户
	 1查看禁止登录用户
	 2查看禁止登录IP
	 3禁发言/登录
	 4禁止IP/IP段
	 5解发言/登录
	 6解禁IP/IP段*/
	private String caseType;

	public String execute() throws Exception {
		// TODO Auto-generated method stub
		int caseType;
		try{
			caseType = Integer.parseInt(getCaseType());
		}catch(Exception e){
			return ERROR;
		}
		switch (caseType){
		case 0:
			
		case 1:
		case 2:
			break;
		case 3:
			setTip("禁言/禁登录成功");
			break;
		case 4:
			setTip("禁IP/IP段成功");
			break;
		case 5:
			setTip("释放用户成功");
			break;
		case 6:
			setTip("释放IP/IP段成功");
			break;
		}
		return SUCCESS;
	}

	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response=arg0;
	}

	public void setIp(String ip){
		this.ip = ip;
	}
	public String getIp(){
		return ip;
	}
	public void setReleaseallTime(String releaseallTime){
		this.releaseallTime = releaseallTime;
	}
	public String getReleaseallTime(){
		return releaseallTime;
	}
	public void setMask(String mask){
		this.mask = mask;
	}
	public String getMask(){
		return mask;
	}
	public void setUsername(String username){
		this.username = username;
	}
	public String getUsername(){
		return username;
	}
	public void setServerId(String serverId){
		this.serverId = serverId;
	}
	public String getServerId(){
		return serverId;
	}
	public void setType(String type){
		this.type = type;
	}
	public String getType(){
		return type;
	}
	public void setCaseType(String caseType){
		this.caseType = caseType;
	}
	public String getCaseType(){
		return caseType;
	}
	public void setTip(String tip){
		this.tip = tip;
	}
	public String getTip(){
		return tip;
	}
	
}
