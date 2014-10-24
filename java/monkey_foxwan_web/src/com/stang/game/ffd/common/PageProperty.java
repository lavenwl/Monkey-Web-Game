package com.stang.game.ffd.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * @author jianbo.feng
 * @company 上海三唐信息科技有限公司
 * @description 整合供分页处理所有属性类 
 */
public class PageProperty {
    private int npage;//页码
	private int nfirstindex;//查询起点
	private int npagesize;//查询数量，0表示全部
	private String searchString;//查询条件 where field=?
	private String orderString;//排序条件 order by id desc
	private List parameterList;// 查询条件参数列表
	private HashMap paramMap; //参数map

	public PageProperty(int page, int pagesize,String searchString, String orderString){
		this.npagesize = pagesize;
		this.npage = page;
		this.searchString = searchString;
		this.orderString = orderString;
	}
	public PageProperty(){
	    	this.npage=1;
		this.npagesize = 0;
		this.nfirstindex = 0;
		this.searchString = "";
		this.orderString = "";
	}

	public int getNfirstindex() {
	    	nfirstindex=(npage-1)*npagesize;
		return nfirstindex;
	}

	public void setNfirstindex(int nfirstindex) {
		this.nfirstindex = nfirstindex;
	}

	public int getNpagesize() {
		return npagesize;
	}

	public void setNpagesize(int npagesize) {
		this.npagesize = npagesize;
	}

	public String getOrderString() {
		return orderString;
	}

	public void setOrderString(String orderString) {
		this.orderString = orderString;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	public List getParameterList() {
		return parameterList;
	}
	public void setParameterList(List parameterList) {
		this.parameterList = parameterList;
	}
	public void addParamter(Object o){//增加参数
		initParameterList();
		parameterList.add(o);
	}
	public void addParamter(int index,Object o){ //增加参数
		initParameterList();
		parameterList.add(index,o);
	}
	public void clearParamter(){ //增加参数
		initParameterList();
		parameterList.clear();
	}
	public void initParameterList(){//初始化参数列表
		if(parameterList==null){
			parameterList=new ArrayList();
		}
	}
	public int getNpage() {
	    return npage;
	}
	public void setNpage(int page) {
	    npage = page;
	}


	public HashMap getParamMap() {
		initParamMap();
		return paramMap;
	}

	public void putParamMap(String name,Object o){ //增加参数
		initParamMap();
		paramMap.put(name,o);
	}
	public void clearParamMap(){ //增加参数
		initParamMap();
		paramMap.clear();
	}
	public void initParamMap(){//初始化参数列表
		if(paramMap==null){
			paramMap=new HashMap();
		}
	}

}
