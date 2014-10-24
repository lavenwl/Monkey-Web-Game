package com.stang.game.cache;

import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheTempPackage {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<Integer, TempPackageDetail>  gameTempPackages = null;
	//变动过的对象组成的队列，由于自动同步数据库
	public static QueueCache gameTempPackageQueue = null;
	//静态类同步数据库线程
	public static ThreadCache thread = null;
	//静态初始化方法
	public CacheTempPackage(){
		if(thread == null){
			thread = new ThreadCache("TempPackage");
			thread.start();
		}
		if(gameTempPackages == null)
			gameTempPackages = GlobalDatat.cacheTempPackageDetails;
		if(gameTempPackageQueue == null)
			gameTempPackageQueue = new QueueCache();
	}
	public List<TempPackageDetail> getTempPackage(Map<String, Object> param) {
		List<TempPackageDetail> tempPackageDetailList = new ArrayList<TempPackageDetail>();
		Object id = param.get("id");
		Object mId = param.get("mId");
		Object typeId = param.get("typeId");
		Object pId = param.get("pId");
		Object flag = param.get("flag");
		Object num = param.get("num");
		Object time = param.get("time");
		
		
		Iterator it = gameTempPackages.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			TempPackageDetail tempPackageDetail = gameTempPackages.get(i);
			if(tempPackageDetail.getId() == (null == id ? tempPackageDetail.getId() : Integer.valueOf(String.valueOf(id)))
			&& tempPackageDetail.getMId() == (null == mId ? tempPackageDetail.getMId() : Integer.valueOf(String.valueOf(mId)))
			&& tempPackageDetail.getTypeId() == (null == typeId ? tempPackageDetail.getTypeId() : Integer.valueOf(String.valueOf(typeId)))
			&& tempPackageDetail.getPId() == (null == pId ? tempPackageDetail.getPId() : Integer.valueOf(String.valueOf(pId)))
			&& tempPackageDetail.getFlag() == (null == flag ? tempPackageDetail.getFlag() : Integer.valueOf(String.valueOf(flag)))
			&& tempPackageDetail.getNum() == (null == num ? tempPackageDetail.getNum() : Integer.valueOf(String.valueOf(num)))
			&& tempPackageDetail.getTime() == (null == time ? tempPackageDetail.getTime() : Integer.valueOf(String.valueOf(time)))){
				tempPackageDetailList.add(tempPackageDetail);
			}
		}
		return tempPackageDetailList;
	}
	public void updateTempPackageByParam(Map<String, Object> param) {
		boolean b = false;
		int id = Integer.valueOf(String.valueOf(param.get("id")));
		Object mId = param.get("mId");
		Object typeId = param.get("typeId");
		Object pId = param.get("pId");
		Object flag = param.get("flag");
		Object num = param.get("num");
		try{
			TempPackageDetail tempPackageDetail = gameTempPackages.get(id);
			if(null!=mId){
				tempPackageDetail.setMId(Integer.valueOf(String.valueOf(mId)));
			}if(null!=typeId){
				tempPackageDetail.setTypeId(Integer.valueOf(String.valueOf(typeId)));
			}if(null!=pId){
				tempPackageDetail.setPId(Integer.valueOf(String.valueOf(pId)));
			}if(null!=flag){
				tempPackageDetail.setFlag(Integer.valueOf(String.valueOf(flag)));
			}if(null!=num){
				tempPackageDetail.setNum(Integer.valueOf(String.valueOf(num)));
			}
			gameTempPackages.remove(id);
			gameTempPackages.put(id, tempPackageDetail);
			tempPackageDetail.setIsUpdate(1);
			gameTempPackageQueue.enqueue(tempPackageDetail);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void insertTempPackageDetail(List<TempPackageDetail> list) {
		// TODO Auto-generated method stub
		
	}
	public void updateTempPackageByList(List<TempPackageDetail> updateList) {
		boolean b = false;
		int id = Integer.valueOf(String.valueOf(updateList.get(0)));
		Object mId = updateList.get(1);
		Object typeId = updateList.get(2);
		Object pId = updateList.get(3);
		Object flag = updateList.get(4);
		Object num = updateList.get(5);
		try{
			TempPackageDetail tempPackageDetail = gameTempPackages.get(id);
			if(null!=mId){
				tempPackageDetail.setMId(Integer.valueOf(String.valueOf(mId)));
			}if(null!=typeId){
				tempPackageDetail.setTypeId(Integer.valueOf(String.valueOf(typeId)));
			}if(null!=pId){
				tempPackageDetail.setPId(Integer.valueOf(String.valueOf(pId)));
			}if(null!=flag){
				tempPackageDetail.setFlag(Integer.valueOf(String.valueOf(flag)));
			}if(null!=num){
				tempPackageDetail.setNum(Integer.valueOf(String.valueOf(num)));
			}
			gameTempPackages.remove(id);
			gameTempPackages.put(id, tempPackageDetail);
			tempPackageDetail.setIsUpdate(1);
			gameTempPackageQueue.enqueue(tempPackageDetail);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void insertTempPackage(Map<String, Object> param) {
		// TODO Auto-generated method stub
		
	}
	public void deleteTempPackageDetailByParam(Map<String, Object> param) {
		// TODO Auto-generated method stub
		
	}
	
}
