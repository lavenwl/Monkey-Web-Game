package com.stang.game.ffd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.CoinDetail;
import com.stang.game.entity.detail.MemberDetail;
import com.stang.game.service.ICoinService;
import com.stang.game.service.IMemberService;
import com.stang.game.service.impl.CoinServiceImpl;
import com.stang.game.service.impl.MemberServiceImpl;


public class ProjectListActionCoin {
	private static IMemberService memberservice=new MemberServiceImpl();
	private static ICoinService coinService=new CoinServiceImpl();
	Map<String,Object> param = new HashMap<String,Object>();
	//input 
	private int page = 1;//��ǰ��ʾ��ҳ��
	//output
	private int totalPages;//��ҳ��
	private List<CoinDetail> pros;
	//injection
	private int pageSize = 10;
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<CoinDetail> getPros() {
		return pros;
	}

	public void setPros(List<CoinDetail> pros) {
		this.pros = pros;
	}
	
	public String execute(){
		int begin = (page-1)*pageSize;
		param.put("page", begin);
		param.put("pageSize", pageSize);
		//ProjectDAO proDao = new ProjectDAO();
		
		try {
			
			//pros = proDao.findAll(page,pageSize);
			pros=coinService.findAllcoin(param);
			int size=pros.size();
			for(int i=0;i<size;i++){
				int roleid=pros.get(i).getRoleid();
				List<MemberDetail> members=memberservice.findMemberByid(roleid);
				String openid=members.get(0).getUsername();
				
				pros.get(i).setOpenid(openid);
				System.out.println(openid+"得到openId=============================");
				if(members.size()==0){
					return "error";
				}
			}
			System.out.println(pros.size()+"得1到每页数===========================");
			List<CoinDetail> alltiem=coinService.getAllBuycoin();
			int totalRows =alltiem.size();
			//根据totalRows和pageSize计算总页数totalPages
			if(totalRows == 0){
				totalPages= 1;//没有记录认为1页
				System.out.println(totalPages+"总2页数==="+totalRows+"总行数==================");
				
			}else if(totalRows%pageSize == 0){
				totalPages= totalRows/pageSize;
				System.out.println(totalPages+"总3页数==="+totalRows+"总行数==================");
			}else{
				totalPages= totalRows/pageSize+1;
				System.out.println(totalPages+"总4页数==="+totalRows+"总行数==================");
				
			}
		//	totalPages = proDao.countTotalPage(pageSize);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
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
