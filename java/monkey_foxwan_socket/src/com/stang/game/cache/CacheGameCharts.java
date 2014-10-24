package com.stang.game.cache;

import com.stang.game.entity.GameEquip;
import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheGameCharts {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<Integer, GameChartsDetail>  gameChartss = null;
	//变动过的对象组成的队列，由于自动同步数据库
	public static QueueCache gameChartsQueue = null;
	//静态初始化方法
	public CacheGameCharts(){
		if(gameChartss == null)
			gameChartss = GlobalDatat.cacheGameChartsDetails;
		if(gameChartsQueue == null)
			gameChartsQueue = new QueueCache();
	}
	public List<GameChartsDetail> findalllie() {
		List<GameChartsDetail> gameChartsDetailList = new ArrayList<GameChartsDetail>();
		Iterator it = gameChartss.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GameChartsDetail gameChartsDetail = gameChartss.get(i);
			if(gameChartsDetail.getFlag() ==1){
				gameChartsDetailList.add(gameChartsDetail);
			}
		}
		return gameChartsDetailList;
	}
	public List<GameChartsDetail> findallliet() {
		List<GameChartsDetail> gameChartsDetailList = new ArrayList<GameChartsDetail>();
		Iterator it = gameChartss.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GameChartsDetail gameChartsDetail = gameChartss.get(i);
			if(gameChartsDetail.getFlag() ==2){
				gameChartsDetailList.add(gameChartsDetail);
			}
		}
		return gameChartsDetailList;
	}
	public List<GameChartsDetail> findalllief() {
		List<GameChartsDetail> gameChartsDetailList = new ArrayList<GameChartsDetail>();
		Iterator it = gameChartss.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GameChartsDetail gameChartsDetail = gameChartss.get(i);
			if(gameChartsDetail.getFlag() ==3){
				gameChartsDetailList.add(gameChartsDetail);
			}
		}
		return gameChartsDetailList;
	}
	public List<GameChartsDetail> getid(int roleId) {
		List<GameChartsDetail> gameChartsDetailList = new ArrayList<GameChartsDetail>();
		Iterator it = gameChartss.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GameChartsDetail gameChartsDetail = gameChartss.get(i);
			if(gameChartsDetail.getFlag() ==1&&
			  gameChartsDetail.getRoleId()==roleId){
				gameChartsDetailList.add(gameChartsDetail);
			}
		}
		return gameChartsDetailList;
	}
	public List<GameChartsDetail> getidqz(int roleId) {
		List<GameChartsDetail> gameChartsDetailList = new ArrayList<GameChartsDetail>();
		Iterator it = gameChartss.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GameChartsDetail gameChartsDetail = gameChartss.get(i);
			if(gameChartsDetail.getFlag() ==2&&
			  gameChartsDetail.getRoleId()==roleId){
				gameChartsDetailList.add(gameChartsDetail);
			}
		}
		return gameChartsDetailList;
	}
	public List<GameChartsDetail> getiddt(int roleId) {
		List<GameChartsDetail> gameChartsDetailList = new ArrayList<GameChartsDetail>();
		Iterator it = gameChartss.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GameChartsDetail gameChartsDetail = gameChartss.get(i);
			if(gameChartsDetail.getFlag() ==3&&
			  gameChartsDetail.getRoleId()==roleId){
				gameChartsDetailList.add(gameChartsDetail);
			}
		}
		return gameChartsDetailList;
	}
	public List<GameChartsDetail> getall() {
		List<GameChartsDetail> gameChartsDetailList = new ArrayList<GameChartsDetail>();
		Iterator it = gameChartss.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GameChartsDetail gameChartsDetail = gameChartss.get(i);
			if(gameChartsDetail.getFlag() ==1){
				gameChartsDetailList.add(gameChartsDetail);
			}
		}
		return gameChartsDetailList;
	}
	public List<GameChartsDetail> getidByParamt(Map<String, Object> paramt) {
		int roleId = Integer.valueOf(paramt.get("roleid").toString());
		String serverid = paramt.get("serverid").toString();
		int flag = Integer.valueOf(paramt.get("type").toString());
		List<GameChartsDetail> gameChartsDetailList = new ArrayList<GameChartsDetail>();
		Iterator it = gameChartss.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GameChartsDetail gameChartsDetail = gameChartss.get(i);
			if(gameChartsDetail.getFlag() == flag &&
			  gameChartsDetail.getRoleId()== roleId 
			 // gameChartsDetail.getServerId() == serverid
			  ){
				gameChartsDetailList.add(gameChartsDetail);
			}
		}
		return gameChartsDetailList;
	}
	


}
