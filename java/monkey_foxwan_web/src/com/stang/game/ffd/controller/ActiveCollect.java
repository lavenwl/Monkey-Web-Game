package com.stang.game.ffd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.stang.game.ffd.dao.ITyroCardDao;
import com.stang.game.ffd.entity.detail.TyroCardDetail;
import com.stang.game.ffd.service.ITyroCardService;
import com.stang.game.ffd.service.impl.TyroCardServiceImpl;

public class ActiveCollect extends ActionSupport implements ServletRequestAware  {
	private HttpServletRequest request;
	private HttpSession session;
	private String active_code;
	private int code_counts;
	private ITyroCardService tyroCardService;
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
		this.session = ServletActionContext.getRequest().getSession();
	}
	public String getActive_code() {
		return active_code;
	}
	public void setActive_code(String active_code) {
		this.active_code = active_code;
	}
	public int getCode_counts() {
		return code_counts;
	}
	public void setCode_counts(int code_counts) {
		this.code_counts = code_counts;
	}
	
	public ITyroCardService getTyroCardService(){
		if(tyroCardService==null){
			tyroCardService = new TyroCardServiceImpl();
		}
		return tyroCardService;
	}
	
	public String createActiveCode(){
		if(code_counts<=0){
			this.setCode_counts(1);
		}
		for(int i=0;i<code_counts;i++){
		Map<String,Object> map = new HashMap<String,Object>();
		TyroCardDetail tcd=new TyroCardDetail();
		map.put("flag", 1);
		map.put("lim", 1);
		tcd.setServerId(Integer.parseInt(active_code));
		List<TyroCardDetail> ltcd=this.getTyroCardService().findTryoCardDetailByParam(map);
		if(ltcd.size()>0){//说明已经有数据了。获取当前的卡号并且加1
			tcd.setCard(Integer.parseInt(ltcd.get(0).getCard())+1+"");
			tcd.setMd5card(encode(tcd.getCard()).substring(0,12));
			tcd.setFlag(1);
			
			this.getTyroCardService().insertTryoCardDetail(tcd);
		}else{//第一个卡号
			tcd.setCard(1000+"");
			tcd.setMd5card(encode(1000+"").substring(0,12));
			tcd.setFlag(1);
			this.getTyroCardService().insertTryoCardDetail(tcd);
		}
		}
		return "succ";
	}
	
	/**
	 * 激活码列表
	 * @return
	 */
	public String ActiveCodeList(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("flag", 1);
		List<TyroCardDetail> ltcd=this.getTyroCardService().findTryoCardDetailByParam(map);
		request.setAttribute("rsList", ltcd);
		return "succ";
	}
	
	//md5 生成器
	public final static String encode(String s) {  
	    char hexDigits[] = {  
	        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',  
	        'e', 'f'};  
	    try {  
	      byte[] strTemp = s.getBytes();  
	      MessageDigest mdTemp = MessageDigest.getInstance("MD5");  
	      mdTemp.update(strTemp);  
	      byte[] md = mdTemp.digest();  
	      int j = md.length;  
	      char str[] = new char[j * 2];  
	      int k = 0;  
	      for (int i = 0; i < j; i++) {  
	        byte byte0 = md[i];  
	        str[k++] = hexDigits[byte0 >>> 4 & 0xf];  
	        str[k++] = hexDigits[byte0 & 0xf];  
	      }  
	      return new String(str);  
	    }  
	    catch (Exception e) {  
	      return null;  
	    }  
	  }  
	

}
