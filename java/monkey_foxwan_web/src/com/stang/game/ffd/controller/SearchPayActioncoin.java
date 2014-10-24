package com.stang.game.ffd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stang.game.entity.detail.CoinDetail;
import com.stang.game.entity.detail.MemberDetail;
import com.stang.game.service.ICoinService;
import com.stang.game.service.IMemberService;
import com.stang.game.service.impl.CoinServiceImpl;
import com.stang.game.service.impl.MemberServiceImpl;


public class SearchPayActioncoin {
	private static IMemberService memberservice=new MemberServiceImpl();
	private static ICoinService coinService=new CoinServiceImpl();

	private HttpServletResponse response;
	private String roleid;
	private String cxtime;

	public String getCxtime() {
		return cxtime;
	}
	public void setCxtime(String cxtime) {
		this.cxtime = cxtime;
	}
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	private HttpServletRequest request;

	private int coin;
	private int num;
	List<CoinDetail> coinAllDetail;
	List<CoinDetail> coinDetails;
	public List<CoinDetail> getcoinAllDetail() {
		return coinAllDetail;
	}
	public void setcoinAllDetail(List<CoinDetail> buyAllDetail) {
		this.coinAllDetail = buyAllDetail;
	}

	public static ConcurrentHashMap<String,HashMap<String,Object>> cacheSqlMap= new ConcurrentHashMap<String,HashMap<String,Object>>();

	public String execute() throws Exception {
		//根据前端得到的openid去购买道具表查询详细信息
		Map<String,Object> param = new HashMap<String,Object>();
		List<MemberDetail> members=memberservice.findMemberByOpenid(roleid);//roleid即是openid
		if(members.size()==0){
			return "error";
		}
		int roleId=members.get(0).getId();
		/****/
		if(!cxtime.isEmpty()&&!roleid.isEmpty()){//时间和openid都不为为空，用此两个字段查询
			//String time="2013-07-29";
			String[] as=cxtime.split("-");
			int as2=(Integer.valueOf(as[2]))+1;
			String endtime;
			if(as2<10){
				endtime=as[0]+"-"+as[1]+"-0"+as2;
			}else{
				endtime=as[0]+"-"+as[1]+"-"+as2;
			}
		
			param.put("time", cxtime);
			param.put("timet", endtime);
	       	param.put("roleid", roleId);
	coinDetails=coinService.findcoinbytimeandopenid(param);
int size=coinDetails.size();
for(int i=0;i<size;i++){
	coinDetails.get(i).setOpenid(roleid);
}
			if(coinDetails.size()!=0){
				coin=coinDetails.get(0).getCoin();
				num=coinDetails.get(0).getNum();
				return "succ";
			}else{
			return "error";
			}
		
		}
		
		else if(!roleid.isEmpty()){//根据openid查询，即roleId
		coinDetails=coinService.getBuycoin(roleId);
		int size=coinDetails.size();
		for(int i=0;i<size;i++){
			coinDetails.get(i).setOpenid(roleid);
		}
			if(coinDetails.size()!=0){
				coin=coinDetails.get(0).getCoin();
				num=coinDetails.get(0).getNum();
				return "succ";
			}else{
			return "error";
			}
		}
		
		else if(!cxtime.isEmpty()){//根据时间查询
			String[] as=cxtime.split("-");
			int as2=(Integer.valueOf(as[2]))+1;
			String endtime;
			if(as2<10){
				endtime=as[0]+"-"+as[1]+"-0"+as2;
			}else{
				endtime=as[0]+"-"+as[1]+"-"+as2;
			}
		param.clear();
			param.put("time", cxtime);
			param.put("timet", endtime);
	coinDetails=coinService.findcoinbytime(param);
	int size=coinDetails.size();
	for(int i=0;i<size;i++){
		int roleid2=coinDetails.get(i).getRoleid();
		List<MemberDetail> members2=memberservice.findMemberByid(roleid2);
		String openid=members2.get(0).getUsername();
		coinDetails.get(i).setOpenid(openid);
		
	}		
	
	
			if(coinDetails.size()!=0){
				coin=coinDetails.get(0).getCoin();
				num=coinDetails.get(0).getNum();
				
				return "succ";
			}else{
			return "error";
			}
		}else{
			//时间和openid都为为空，查询所有用户
			
	
			return "listci";
		}
		/****/
		
		
		
		
		
		
	
		
		
	}

	public List<CoinDetail> getCoinDetails() {
		return coinDetails;
	}
	public void setCoinDetails(List<CoinDetail> coinDetails) {
		this.coinDetails = coinDetails;
	}
	public String list(){
		//从充值表里查询所有的信息给前端页面
		 coinAllDetail=coinService.getAllBuycoin();
		return "listcoin";
		
	}
	

	
	


	


	public int getCoin() {
		return coin;
	}
	public void setCoin(int coin) {
		this.coin = coin;
	}
	

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

}
