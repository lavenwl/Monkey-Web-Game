package com.stang.game.ffd.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.stang.game.entity.detail.BuyDetail;
import com.stang.game.entity.detail.GameItemDetail;
import com.stang.game.entity.detail.GameRoleDetail;
import com.stang.game.entity.detail.RoleItemDetail;
import com.stang.game.ffd.common.GameConstants;
import com.stang.game.ffd.common.StringUtil;
import com.stang.game.ffd.entity.detail.EntityKeyWordDetail;
import com.stang.game.ffd.service.IKeyWordService;
import com.stang.game.ffd.service.impl.KeyWordServiceImpl;
import com.stang.game.service.IAutoIdService;
import com.stang.game.service.IBuyService;
import com.stang.game.service.IGameItemService;
import com.stang.game.service.IGameRoleService;
import com.stang.game.service.IRoleItemService;
import com.stang.game.service.impl.AutoIdServiceImpl;
import com.stang.game.service.impl.BuyServiceImpl;
import com.stang.game.service.impl.GameItemServiceImpl;
import com.stang.game.service.impl.GameRoleServiceImpl;
import com.stang.game.service.impl.RoleItemServiceImpl;

public class SearchPayAction implements ServletRequestAware {
	private static IBuyService buyService=new BuyServiceImpl();

	private HttpServletResponse response;
	private String openid=null;
	private HttpServletRequest request;
	Map<String,Object> param = new HashMap<String,Object>();
	private String payitem;
	private String cxtime=null;
	double allmoney=0;
	double allmoneysj=0;
	int hznum=0;
	public double getAllmoneysj() {
		return allmoneysj;
	}
	public void setAllmoneysj(double allmoneysj) {
		this.allmoneysj = allmoneysj;
	}
	public int getHznum() {
		return hznum;
	}
	public void setHznum(int hznum) {
		this.hznum = hznum;
	}
	public double getAllmoney() {
		return allmoney;
	}
	public void setAllmoney(double allmoney) {
		this.allmoney = allmoney;
	}
	public String getCxtime() {
		return cxtime;
	}
	public void setCxtime(String cxtime) {
		this.cxtime = cxtime;
	}

	private String time;
	List<BuyDetail> buyAllDetail;
	List<BuyDetail> buyDetails;
	public List<BuyDetail> getBuyAllDetail() {
		return buyAllDetail;
	}
	public void setBuyAllDetail(List<BuyDetail> buyAllDetail) {
		this.buyAllDetail = buyAllDetail;
	}

	public static ConcurrentHashMap<String,HashMap<String,Object>> cacheSqlMap= new ConcurrentHashMap<String,HashMap<String,Object>>();

	public String execute() throws Exception {
		//根据前端得到的openid去购买道具表查询详细信息
		System.out.println(openid+"得到openid========"+cxtime+"+++++得到查询时间========");
		
		
		if(!cxtime.isEmpty()&&!openid.isEmpty()){//时间和openid都不为为空，用此两个字段查询
			//String time="2013-07-29";
			String[] as=cxtime.split("-");
			int as2=(Integer.valueOf(as[2]))+1;
			String endtime;
			if(as2<10){
				endtime=as[0]+"-"+as[1]+"-0"+as2;
			}else{
				endtime=as[0]+"-"+as[1]+"-"+as2;
			}
		
		System.out.println(cxtime+"得到页面时间"+endtime+"字符串加1后");  
			
			
			param.put("time", cxtime);
			param.put("timet", endtime);
	       	param.put("openid", openid);
			
			buyDetails=buyService.findbytimeandopenid(param);
			
			int size2=buyDetails.size();
			for(int i=0;i<size2;i++){
				BuyDetail byd=buyDetails.get(i);
				String payitem=byd.getPayitem();
				//String as1="77*88*99";
				//String[] qiege=payitem.split("\\*");
				//double a2=Double.valueOf(qiege[1]);
				//int a3=Integer.valueOf(qiege[2]);
				//double money=a2*a3/10;//遍历累加玩家充值的金钱
				//int a22=(int) a2;
				//if(a22!=650){
					allmoney=allmoney+Integer.valueOf(payitem);//遍历累加玩家充值的金钱
				//}else{
				//	hznum=hznum+1;
				//}
				
				String pay=String.valueOf(payitem);
				System.out.println(pay+"得到string类型的pay");
				byd.setTotalmoney(pay);
				
			}
			allmoneysj=allmoney*0.8;
			if(buyDetails.size()!=0){
				payitem=buyDetails.get(0).getPayitem();
				time=buyDetails.get(0).getTime();
				
				return "succ";
			}else{
			return "error";
			}
		}
		
		else if(!openid.isEmpty()){//根据openid查询
			buyDetails=buyService.getBuy(openid);
			int size2=buyDetails.size();
			for(int i=0;i<size2;i++){
				BuyDetail byd=buyDetails.get(i);
				String payitem=byd.getPayitem();
				//String as1="77*88*99";
				//String[] qiege=payitem.split("\\*");
				//double a2=Double.valueOf(qiege[1]);
				//int a3=Integer.valueOf(qiege[2]);
				//double money=a2*a3;//遍历累加玩家充值的金钱
				//int a22=(int) a2;
				//if(a22!=650){
					allmoney=allmoney+Integer.valueOf(payitem);//遍历累加玩家充值的金钱
				//}else{
				//	hznum=hznum+1;
				//}
				
				String pay=String.valueOf(payitem);
				System.out.println(pay+"得到string类型的pay");
				byd.setTotalmoney(pay);
				
			}
			allmoneysj=allmoney*0.8/10;
			if(buyDetails.size()!=0){
				payitem=buyDetails.get(0).getPayitem();
				time=buyDetails.get(0).getTime();
				
				
				return "succ";
			}else{
			return "error";
			}
			
		}
		
		else if(!cxtime.isEmpty()){////时间不为空，根据时间查询
			
			String[] as=cxtime.split("-");
			int as2=(Integer.valueOf(as[2]))+1;
			String endtime;
			if(as2<10){
				endtime=as[0]+"-"+as[1]+"-0"+as2;
			}else{
				endtime=as[0]+"-"+as[1]+"-"+as2;
			}
		System.out.println(cxtime+"得到页面时间"+endtime+"字符串加1后");
			param.clear();
			param.put("time", cxtime);
			param.put("timet", endtime);
	       	buyDetails=buyService.findbytime(param);
	       	int size2=buyDetails.size();
			for(int i=0;i<size2;i++){
				BuyDetail byd=buyDetails.get(i);
				String payitem=byd.getPayitem();
				//String as1="77*88*99";
				//String[] qiege=payitem.split("\\*");
				//double a2=Double.valueOf(qiege[1]);
				//int a3=Integer.valueOf(qiege[2]);
			//	double money=a2*a3;//遍历累加玩家充值的金钱
			//	int a22=(int) a2;
			//	if(a22!=650){
					allmoney=allmoney+Integer.valueOf(payitem);//遍历累加玩家充值的金钱
			//	}else{
			//		hznum=hznum+1;
			//	}
				
				String pay=String.valueOf(payitem);
				System.out.println(pay+"得到string类型的pay");
				byd.setTotalmoney(pay);
				
			}
			allmoneysj=allmoney*0.8/10;
			if(buyDetails.size()!=0){
				payitem=buyDetails.get(0).getPayitem();
				time=buyDetails.get(0).getTime();
				
				return "succ";
			}else{
			return "error";
			}
		}
		
		else{
			//时间和openid都为为空，查询所有用户
			//String time="2013-07-29";
	
			return "listys";
		}
		
		
		
	}
	public List<BuyDetail> getBuyDetails() {
		return buyDetails;
	}
	public void setBuyDetails(List<BuyDetail> buyDetails) {
		this.buyDetails = buyDetails;
	}
	public String list(){
		//从充值表里查询所有的信息给前端页面
		 buyAllDetail=buyService.getAllBuy();
		return "list";
		
	}
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response=arg0;
	}
	
	

	
	


	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getPayitem() {
		return payitem;
	}

	public void setPayitem(String payitem) {
		this.payitem = payitem;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}
	
	
}
