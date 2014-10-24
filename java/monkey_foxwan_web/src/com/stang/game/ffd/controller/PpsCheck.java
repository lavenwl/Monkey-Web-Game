package com.stang.game.ffd.controller;

import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.stang.game.ffd.service.ICaseLogService;
import com.stang.game.ffd.service.IOrderInfoService;
import com.stang.game.ffd.service.impl.CaseLogServiceImpl;
import com.stang.game.ffd.service.impl.OrderInfoServiceImpl;
import com.stang.game.ffd.entity.detail.EntityCaseLogDetail;
import com.stang.game.ffd.entity.detail.EntityOrderInfoDetail;

public class PpsCheck extends ActionSupport implements
ServletRequestAware {
	private HttpServletRequest request;
	private HttpSession session;
	private String date;//** 传送过来的日期
	private String token;//** 随机10位
	private String sign;//** 充值货币
	
	
	private static final String orderKey ="f2$IOsks2f*LJO123";//** 订单密钥
	private static final String key_shenji = "6cz$8aNnU6@TudWRw";	
	private static final int sign_err=-1;
	private static final int token_err=-2;
	private static final int sid_or_platid_err=-3;
	private static final int system_err=-5;

	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
		this.session = ServletActionContext.getRequest().getSession();
	}
	
	public String getData() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
	/**
	 * 返回充值记录
	 * 
	 * @return
	 */
	public String recRecord(){
		String dateS="";
		if(date.length()<10){
			String [] arrTemp=date.split("-");
			if(arrTemp[1].length()<2)
				arrTemp[1]="0"+arrTemp[1];
			if(arrTemp[2].length()<2)
				arrTemp[2]="0"+arrTemp[2];
			dateS=arrTemp[0]+"-"+arrTemp[1]+"-"+arrTemp[2];
			
		}
		String tmp = date + token +  orderKey; 
		StringBuffer hexString = new StringBuffer("");
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(tmp.getBytes());
			byte[] hash = md.digest();

			for (int i = 0; i < hash.length; i++) {
				if ((0xff & hash[i]) < 0x10) {
					hexString.append("0"
							+ Integer.toHexString((0xFF & hash[i])));
				} else {
					hexString.append(Integer.toHexString(0xFF & hash[i]));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("md5____"+hexString.toString()+"_date"+date+"__token"+token+"__sign"+sign);
		if(!hexString.toString().equals(sign)){
			request.setAttribute("errCode",sign_err );return "succ";
		}
		
//		if(token==null || token.length()<10){
//			request.setAttribute("errCode",token_err );return "succ";
//		}
		
		IOrderInfoService getOrderInfoService= new OrderInfoServiceImpl();
		if(sign==null || sign.length()<10){
			//** 日期格式不正确
			request.setAttribute("results",sign_err);
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date yesterday_time=null;
		Date ytTime=null;
		String yesterTime="";
		try {
			yesterday_time=format.parse(dateS);
			ytTime=new Date(yesterday_time.getTime()+(1000*60*60*24));
			yesterTime=format.format(ytTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("@@@@@@@"+yesterTime);
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("dataTime", date);
		param.put("dataTime2", yesterTime);
		List<EntityOrderInfoDetail> leoid = new ArrayList<EntityOrderInfoDetail>();
		leoid=getOrderInfoService.getAllInfoOrderInfo(param);
		request.setAttribute("results", leoid);
		return "succ";
	}
	
	/**
	 * 查看所有的金币消费记录
	 * @return
	 */
	public String buyRecord(){
		String dateS="";
		if(date.length()<10){
			String [] arrTemp=date.split("-");
			if(arrTemp[1].length()<2)
				arrTemp[1]="0"+arrTemp[1];
			if(arrTemp[2].length()<2)
				arrTemp[2]="0"+arrTemp[2];
			dateS=arrTemp[0]+"-"+arrTemp[1]+"-"+arrTemp[2];
			
		}
		String tmp = date + token +  key_shenji; 
		StringBuffer hexString = new StringBuffer("");
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(tmp.getBytes());
			byte[] hash = md.digest();

			for (int i = 0; i < hash.length; i++) {
				if ((0xff & hash[i]) < 0x10) {
					hexString.append("0"
							+ Integer.toHexString((0xFF & hash[i])));
				} else {
					hexString.append(Integer.toHexString(0xFF & hash[i]));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("md5____"+hexString.toString()+"__data"+date+"__token"+token+"__sign"+sign);
		if(!hexString.toString().equals(sign)){
			request.setAttribute("errCode",sign_err );return "succ";
		}
	
		if(sign==null || sign.length()<10){
			//** 日期格式不正确
			request.setAttribute("results",sign_err);
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date yesterday_time=null;
		Date ytTime=null;
		String yesterTime="";
		try {
			yesterday_time=format.parse(dateS);
			ytTime=new Date(yesterday_time.getTime()+(1000*60*60*24));
			yesterTime=format.format(ytTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ICaseLogService icls = new CaseLogServiceImpl();
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("CASE_ID",70);
		params.put("createTime1", dateS);
		params.put("createTime2", yesterTime);
		List<EntityCaseLogDetail> lecld= icls.getQh(params);
		request.setAttribute("results",lecld);
		return "succ";
	}
}
