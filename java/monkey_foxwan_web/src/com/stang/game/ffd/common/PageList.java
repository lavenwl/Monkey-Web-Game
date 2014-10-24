package com.stang.game.ffd.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 包装了列表信息，和处理分页情况属性的类
 * 
 * */

public class PageList<T> implements Serializable {
	
	public PageList() {

	}

	public PageList(PageProperty pp, int allCount, List<T> list) {	
		if(pp.getNpage()>0){
			this.page = pp.getNpage();
		}
		if(pp.getNpagesize()>0){
			this.pageSize = pp.getNpagesize();
		}
		this.totalRecords = allCount;
		if (totalRecords % pageSize > 0) {
			this.totalPages = totalRecords / pageSize + 1;
		} else {
			this.totalPages = totalRecords / pageSize;
		}
		this.setRecords(list);
	}
    //当前页
	private int page = 1;
    //总记录条数
	private int totalRecords;
    //总页数
	private int totalPages;
    //一页显示条数
	private int pageSize = 20;
    //跳页
	private int numbersPerBlock = 10;
    //记录列表
	private List<T> records = new ArrayList<T>();
    
	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page < 1)
			page = 1;
		this.page = page;
	}
    
	/**
	 * 获取总页码
	 * */
	public int getPageNumber() {
		int pageNumber = 0;
		if (totalRecords % pageSize == 0)
			pageNumber = totalRecords / pageSize;
		else
			pageNumber = 1 + totalRecords / pageSize;

		return pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	/**
	 * first row count of current page, start from 1
	 * 
	 * @return
	 */
	public int getFirstRow() {
		return (page - 1) * pageSize + 1;
	}

	/**
	 * last row count of current page
	 * 
	 * @return
	 */
	public int getLastRow() {
		return page == getPageNumber() ? getTotalRecords() : page * pageSize;
	}
    /**
     * 获取前页码
     * */
	public int getPreviousPage() {
		return page > 1 ? page - 1 : page;
	}
    /**
     * 获取后页码
     * */
	public int getNextPage() {
		return page < getPageNumber() ? page + 1 : page;
	}
    /**
     * 获取跳页间隔
     * */
	public int getBlocks() {
		if (this.getPageNumber() % this.numbersPerBlock == 0) {
			return this.getPageNumber() / this.numbersPerBlock;
		} else {
			return 1 + this.getPageNumber() / this.numbersPerBlock;
		}
	}
    
	/**
	 * 获取跳页页码
	 * */
	public int getBlock() {
		if (this.getPage() % this.numbersPerBlock == 0) {
			return this.getPage() / this.numbersPerBlock;
		} else {
			return 1 + this.getPage() / this.numbersPerBlock;
		}
	}

	public int getNumbersPerBlock() {
		return numbersPerBlock;
	}

	public void setNumbersPerBlock(int numberPerBlock) {
		this.numbersPerBlock = numberPerBlock;
	}
	/**
	 * 获取前跳页页码
	 * */
	public int getPageOfPrevBlock() {
		if (this.getBlock() > 1) {
			return (this.getBlock() - 1) * this.getNumbersPerBlock();
		} else {
			return 1;
		}
	}
	/**
	 * 获取后跳页页码
	 * */
	public int getPageOfNextBlock() {
		if (this.getBlock() < this.getBlocks()) {
			return this.getBlock() * this.getNumbersPerBlock() + 1;
		} else {
			return this.getTotalRecords();
		}
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
}
