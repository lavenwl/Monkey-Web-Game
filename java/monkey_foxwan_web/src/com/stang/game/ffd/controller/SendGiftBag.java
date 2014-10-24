package com.stang.game.ffd.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Action;
import com.stang.game.ffd.client.Client;
import com.stang.game.ffd.common.Config;
import com.stang.game.ffd.common.GameConstants;
import com.stang.game.ffd.common.StringUtil;
import com.stang.game.ffd.entity.detail.EntityRightUserDetail;
import com.stang.game.ffd.service.impl.GameRoleServiceImpl;
import com.stang.game.ffd.service.impl.LogSendGiftDetailServiceImpl;
import com.stang.game.ffd.service.impl.RightUserServiceImpl;


public class SendGiftBag implements Action ,ServletResponseAware,ServletRequestAware{
	private HttpServletResponse response;
	private String roleName;
	private String[] unames;
	private String[] gifts;
	private String title;
	private String context;
	private int isGift;
	private String tip;
	private HashMap<String, Object>infoMap = new HashMap<String, Object>();
	private HttpServletRequest request;
	private static Random random = new Random();
	public static Vector<String> cacheKeyList = new Vector<String>();
	public static ConcurrentHashMap<String,HashMap<String,Object>> cacheSqlMap= new ConcurrentHashMap<String,HashMap<String,Object>>();
	public String execute() throws Exception {
		String _cachekey = random.nextLong()+"";
		final int WEB_RIGHT=16;
		HashMap<String, Object> param = new HashMap<String, Object>();
		HttpSession session = ((HttpServletRequest)request).getSession();
		param.put("uid", (Integer)session.getAttribute("uid"));
		List<EntityRightUserDetail> eruds = new RightUserServiceImpl().findRightUserByMap(param);
		if(eruds.size()!=1){
			return ERROR;
		}
		if(!((eruds.get(0).getRight_value()&1)==1||(eruds.get(0).getRight_value()&WEB_RIGHT)==WEB_RIGHT)){
			return ERROR;
		}
		// TODO Auto-generated method stub
		if(unames==null||title==null||context==null)
		{
			tip="ERROR!!WRONG OPERAT";
			return SUCCESS;
		}
		
		//开始组装并发送消息
		new Client(Config.getConfig("serverip"), 8000).start();

		HashMap<String, Object> _params = new HashMap<String, Object>();
		if(isGift==1&&gifts.length==0){
			isGift=0;
		}
		List<Map<String, Integer>> attachsList = new ArrayList<Map<String, Integer>>();
		StringBuffer sb = new StringBuffer(" ");
		if(isGift==1){
			for(String gift:gifts){
				HashMap<String, Integer> attachs= new HashMap<String, Integer>();
				String[] g=gift.split("-");
				if(g.length!=4)
				{
					continue;
				}
				attachs.put("type", Integer.parseInt(g[0]));
				attachs.put("num", Integer.parseInt(g[1]));
				attachs.put("id", Integer.parseInt(g[2]));
				sb.append("["+g[3]+"]");
				attachsList.add(attachs);
			}
		}
		_params.put("attachs",attachsList);
		_params.put("names",unames);
		_params.put("title",title);
		_params.put("content",context);
		_params.put("isAttach",isGift);

		
		HashMap<String, Object> sqlProperty= new HashMap<String, Object>();		//SQL其他属性
		StringBuffer sbUnames = new StringBuffer(" ");
		for(String un:unames){
			sbUnames.append("["+un+"]");
		}
		sqlProperty.put("names",sbUnames.toString());
		sqlProperty.put("title",title);
		sqlProperty.put("content",context);
		sqlProperty.put("attachsContent", sb.toString());
		sqlProperty.put("uid",String.valueOf(session.getAttribute("uid")));
		sqlProperty.put("uname",String.valueOf(session.getAttribute("uname")));
		sqlProperty.put("opTime",System.currentTimeMillis()/1000);
		new LogSendGiftDetailServiceImpl().insertLogSendGiftDetail(sqlProperty);
		cacheSqlMap.put(_cachekey, sqlProperty);
		infoMap = new HashMap<String, Object>();
		infoMap.put("_guid", 0);
		infoMap.put("_cachekey", _cachekey);
		infoMap.put("_sig", "robot");
		infoMap.put("_serverId", 1);
		infoMap.put("_pid", 1);
		infoMap.put("_cmd", "gm.addGiftBag");
		infoMap.put("_params", _params);
//		if(!startSend()){
//			tip="UNKONWN ERROR!";
//			return SUCCESS;
//		}
		for(int i=0;i<5;i++){
			Thread.sleep(500);
//			System.out.println(cacheKeyList.size());
			if(cacheKeyList.contains(_cachekey)){
				tip="SEND SUCCESS";
				cacheKeyList.remove(_cachekey);
				return SUCCESS;
			}
			Thread.sleep(1000);
		}
		tip="SEND FAILURE!";
		return SUCCESS;
	}
	public String getRoleNames() throws Exception {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		List<String> strings = new GameRoleServiceImpl().getRoleNameByIllegibleName(StringUtil.uriEncode(roleName,GameConstants.FORMAT));
		for(String str:strings){
			out.write(StringUtil.uriDecode(str,GameConstants.FORMAT));
			out.write(",");
		}
		out.flush();
		return null;
	}
	
//	boolean startSend() {
//		int i = 0;
//		while (!Client.flag) {
//			try {
//				Thread.sleep(20);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			i++;
//			if (i == 200) {
//				return false;
//			}
//		}
//
//		for (i = 0; i < 5; i++) {
//			if (Client.flag && Client.cf.isConnected()) {
//				Client.smcHander.sendData(infoMap);
//				return true;
//			}
//			try {
//				Thread.sleep(300);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//
//		return false;
//	}
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response=arg0;
	}
	
	
	public String[] getUnames() {
		return unames;
	}
	public void setUnames(String[] unames) {
		this.unames = unames;
	}
	public String[] getGifts() {
		return gifts;
	}
	public void setGifts(String[] gifts) {
		this.gifts = gifts;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public int getIsGift() {
		return isGift;
	}
	public void setIsGift(int isGift) {
		this.isGift = isGift;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}
}
