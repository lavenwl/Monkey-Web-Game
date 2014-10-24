package com.stang.game.util;

/**
 * 分页工具类
 */
public class PageUtil {

	/* 分页中每页最大记录数 */
	// public static final int PAGE_SIZE = 15;
	/**
	 * 根据当前页面序号得到查询数据的起始记录位
	 * 
	 * @param pageNo
	 *            当前页面数
	 * @param count
	 *            记录总数
	 * @param pageSize
	 *            每页显示条数
	 * @return 开始记录
	 */
	public static int getStart(int pageNo, int count, int pageSize) {
		if (pageNo < 1) {
			pageNo = 1;
		}
		if ((pageNo - 1) * pageSize >= count) {
			if (count % pageSize > 0) {
				pageNo = count / pageSize + 1;
			} else {
				pageNo = count / pageSize;
			}
		}
		return (pageNo - 1) * pageSize;
	}

	/**
	 * 根据当前页面序号得到查询数据的起始记录位
	 * 
	 * @param pageNo
	 *            当前页面数
	 * @param pageSize
	 *            每页显示条数
	 */
	public static int getStart(int pageNo, int pageSize) {
		if (pageNo < 1) {
			pageNo = 1;
		}
		return (pageNo - 1) * pageSize;
	}

	/**
	 * 根据当前页面序号和记录总数得到查询数据的结束的最大记录位
	 * 
	 * @param pageNo当前页面数
	 * @param count记录总数
	 */
	public static int getEnd(int pageNo, int count, int pageSize) {
		if (pageNo < 1) {
			pageNo = 1;
		}
		if (count < 0) {
			count = 0;
		}
		int end = 0;
		if (count - (pageNo - 1) * pageSize >= pageSize) {
			end = getStart(pageNo, pageSize) + pageSize;
		} else {
			end = count;
		}
		return end;
	}
}
