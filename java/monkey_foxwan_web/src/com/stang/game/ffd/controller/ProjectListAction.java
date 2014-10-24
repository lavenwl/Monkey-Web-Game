package com.stang.game.ffd.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.BuyDetail;
import com.stang.game.service.IBuyService;
import com.stang.game.service.impl.BuyServiceImpl;


public class ProjectListAction {
	private static IBuyService buyService=new BuyServiceImpl();
	Map<String,Object> param = new HashMap<String,Object>();
	//input 
	private int page = 1;//��ǰ��ʾ��ҳ��
	//output
	private int totalPages;//��ҳ��
	double allmoney=0;
	double allmoneysj=0;
	int hznum;
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



	String cxtime;
	int tiaojian;
	public int getTiaojian() {
		return tiaojian;
	}

	public void setTiaojian(int tiaojian) {
		this.tiaojian = tiaojian;
	}

	private List<BuyDetail> pros;
	//injection
	private int pageSize = 10;
	
	public double getAllmoney() {
		return allmoney;
	}

	public String getCxtime() {
		return cxtime;
	}

	public void setCxtime(String cxtime) {
		this.cxtime = cxtime;
	}

	public void setAllmoney(double allmoney) {
		this.allmoney = allmoney;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<BuyDetail> getPros() {
		return pros;
	}

	public void setPros(List<BuyDetail> pros) {
		this.pros = pros;
	}
	
	public String execute(){
		
		/**得到当天充值的所有金钱**/
//		Date dt=new Date();
//		SimpleDateFormat matter1=new SimpleDateFormat("yyyy-MM-dd");
//		cxtime=matter1.format(dt);//得到当前的时间st 
//		
//		String[] as=cxtime.split("-");
//		int as2=(Integer.valueOf(as[2]))-1;
//		String endtime;
//		if(as2<10){
//			endtime=as[0]+"-"+as[1]+"-0"+as2;
//			
//		}else{
//		 endtime=as[0]+"-"+as[1]+"-"+as2;
//			
//		}
//	System.out.println(cxtime+"得到页面时间"+endtime+"字符串加1后");  
//		String time=cxtime;
//		param.clear();
//		param.put("time", endtime);
//		param.put("timet",time);
		List<BuyDetail> allmoneys=buyService.getAllBuy();//根据时间得到了所有的数据
		int size=allmoneys.size();
		System.out.println(size);
		for(int i=0;i<size;i++){
			BuyDetail bd=allmoneys.get(i);
			String payitem=bd.getPayitem();
			double money = Double.valueOf(payitem);
			//String as1="77*88*99";
//			String[] qiege=payitem.split("\\*");
//			double a2=Double.valueOf(qiege[1]);
//			int a3=Integer.valueOf(qiege[2]);
//			double money=a2*a3;
//			int a22=(int) a2;
//			if(a22!=650){
				allmoney=allmoney+money;//遍历累加玩家充值的金钱,650黄钻不累加
//			}else{
//		hznum++;
//			}
			
			
		}
		allmoneysj=allmoney*0.8/10;
//		System.out.println(allmoney+"得到所有的金钱================"+allmoneysj+"得到实际金钱");
		/****/
		
		
		
		/**计算充值表payitem字段的总和**/
		
		/****/
		
		param.clear();
		int begin = (page-1)*pageSize;
		param.put("page", begin);
		param.put("pageSize", pageSize);
		
		try {
			
			pros=buyService.findAll(param);
			
			
			/****/
			int size2=pros.size();
			for(int i=0;i<size2;i++){
				BuyDetail byd=pros.get(i);
				String payitem=byd.getPayitem();
				//String as1="77*88*99";
//				String[] qiege=payitem.split("\\*");
//				double a2=Double.valueOf(qiege[1]);
//				int a3=Integer.valueOf(qiege[2]);
//				double money=a2*a3;//遍历累加玩家充值的金钱
//				String pay=String.valueOf(money);
				byd.setTotalmoney(payitem);
				
			}
			
			/****/
			
//			System.out.println(pros.size()+"得1到每页数===========================");
			List<BuyDetail> alltiem=buyService.getAllBuy();
			int totalRows =alltiem.size();
			//根据totalRows和pageSize计算总页数totalPages
			if(totalRows == 0){
				totalPages= 1;//没有记录认为1页
//				System.out.println(totalPages+"总2页数==="+totalRows+"总行数==================");
				
			}else if(totalRows%pageSize == 0){
				totalPages= totalRows/pageSize;
//				System.out.println(totalPages+"总3页数==="+totalRows+"总行数==================");
			}else{
				totalPages= totalRows/pageSize+1;
//				System.out.println(totalPages+"总4页数==="+totalRows+"总行数==================");
				
			}
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	
	public String select(){
		if(tiaojian==1){//按时间查询
			
		}else if(tiaojian==2){//按openid查询
			
		}else{
			return "listt";
		}
		
		return null;
		
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
}
