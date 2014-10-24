package com.stang.game.cache;

import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheRoleDaytask {
	//缓存类操作的缓存对象(key:roleid, value:RoleDayTaskDetail)
	private static Map<Integer, RoleDaytaskDetail> roleDaytasks = null;
	//变动过的对象组成的队列，由于自动同步数据库
	public static QueueCache roleDaytaskQueue = null;
	public static QueueCache roleDaytaskQueue_in = null;
	//静态类同步数据库线程
	public static ThreadCache thread = null;
	//静态初始化方法
	public CacheRoleDaytask(){
		if(thread == null){
			thread = new ThreadCache("roleDaytask");
			thread.start();
		}
		if(roleDaytasks == null)
			roleDaytasks = GlobalDatat.cacheRoleDaytaskDetails;
		if(roleDaytaskQueue == null)
			roleDaytaskQueue = new QueueCache("roleDaytask");
		if(roleDaytaskQueue_in == null)
			roleDaytaskQueue_in = new QueueCache("roleDaytask_in");
	}
	//根据roleid查询玩家的任务
	public RoleDaytaskDetail findRoleDaytaskByRId(int roleid){
		RoleDaytaskDetail roleDaytask = new RoleDaytaskDetail();
		//System.out.println(roleid + "++++++++++++++++++++++++++++++++++++++++++++++++++++CacheRoleDaytask中查询roleDaytask：" + roleDaytasks.get(roleid));
		roleDaytask = (RoleDaytaskDetail)roleDaytasks.get(roleid);
		return roleDaytask;
	}
	//根据玩家roleid更新玩家的任务信息
	public boolean udpateRoleDaytask(Map<String, Object> param){
		boolean b = false;
		try{
			int roleid = Integer.valueOf(String.valueOf(param.get("roleid")));
			Object qianghua = param.get("qianghua");
			Object lueduo = param.get("lueduo");
			Object qiangduo = param.get("qiangduo");
			Object zhaomu = param.get("zhaomu");
			Object xiulian = param.get("xiulian");
			Object zhangdou = param.get("zhangdou");
			Object baoxiang = param.get("baoxiang");
			Object integralstatue = param.get("integralstatue");
			Object box = param.get("box");
			Object day = param.get("day");
			Object middlerecruit = param.get("middlerecruit");
			Object toprecruit = param.get("toprecruit");
			RoleDaytaskDetail roleDaytask = null;
			try{
				roleDaytask = roleDaytasks.get(roleid);
			}catch(Exception e){
				e.printStackTrace();
			}
			if(null!=middlerecruit)
				roleDaytask.setMiddlerecruit(Integer.valueOf(String.valueOf(middlerecruit)));
			if(null!=toprecruit)
				roleDaytask.setToprecruit(Integer.valueOf(String.valueOf(toprecruit)));
			if(null != qianghua)
				roleDaytask.setQianghua(Integer.valueOf(String.valueOf(qianghua)));
			if(null != lueduo)
				roleDaytask.setLueduo(Integer.valueOf(String.valueOf(lueduo)));
			if(null != qiangduo)
				roleDaytask.setQiangduo(Integer.valueOf(String.valueOf(qiangduo)));
			if(null != zhaomu)
				roleDaytask.setZhaomu(Integer.valueOf(String.valueOf(zhaomu)));
			if(null != xiulian)
				roleDaytask.setXiulian(Integer.valueOf(String.valueOf(xiulian)));
			if(null != zhangdou)
				roleDaytask.setZhangdou(Integer.valueOf(String.valueOf(zhangdou)));
			if(null != baoxiang)
				roleDaytask.setBaoxiang(String.valueOf(baoxiang));
//			if(null != integralstatue)
//				roleDaytask.setIntegralstatue(String.valueOf(integralstatue));
			if(null != integralstatue){
				if(String.valueOf(integralstatue).equals("[0,0,0,0,0,0]")){
					roleDaytask.setIntegralstatue("[0,0,0,0,0,0,0,0]");
				}else{
					roleDaytask.setIntegralstatue(String.valueOf(integralstatue));
				}
			}
//			if(null != box)
//				roleDaytask.setBox(String.valueOf(box));
			if(null != box){
				if(String.valueOf(box).equals("[0,0,0,0]")){
					roleDaytask.setBox("[0,0,0,0,0]");
				}else{
					roleDaytask.setBox(String.valueOf(box));
				}
			}
			if(null != day)
				roleDaytask.setDay(Integer.valueOf(String.valueOf(day)));
			//roleDaytasks.put(roleDaytask.getRoleid(), roleDaytask);
			//更新队列
			roleDaytask.setIsUpdate(1);
			//System.out.println("CacheRleDaytask.updateRoleDaytask:roleDaytask:" + roleDaytask.getRoleid());
			//System.out.println("CacheRoleDaytask.updateRoleDaytask:indexMap:" + roleDaytaskQueue.indexMap.size());
			if(roleDaytaskQueue.indexMap.containsKey(roleDaytask.getRoleid())){
				//System.out.println("避免一次数据库插入！roleID:" + roleDaytask.getRoleid() + " indexMap.size:" + roleDaytaskQueue.indexMap.size() + " roleDaytaskQueue.size:" + roleDaytaskQueue.size());
			}else{
				roleDaytaskQueue.enqueue(roleDaytask);
				roleDaytaskQueue.indexMap.put(roleDaytask.getRoleid(), null);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//插入新数据
	public boolean insertRoleDaytask(Map<String, Object> param){
		//System.out.println("CacheRoleDayTask.insert ROleDaytask()_____________________________:param:" + param.toString() );
		boolean b = false;
		try{
			Object id = param.get("id");
			Object roleid = param.get("roleid");
			Object qianghua = param.get("qianghua");
			Object lueduo = param.get("lueduo");
			Object qiangduo = param.get("qiangduo");
			Object zhaomu = param.get("zhaomu");
			Object xiulian = param.get("xiulian");
			Object zhangdou = param.get("zhangdou");
			Object baoxiang = param.get("baoxiang");
			Object integralstatue = param.get("integralstatue");
			Object box = param.get("box");
			Object day = param.get("day");
			Object middlerecruit = param.get("middlerecruit");
			Object toprecruit = param.get("toprecruit");
			RoleDaytaskDetail roleDaytask = new RoleDaytaskDetail();
			if(null!=middlerecruit)
				roleDaytask.setMiddlerecruit(Integer.valueOf(String.valueOf(middlerecruit)));
			if(null!=toprecruit)
				roleDaytask.setToprecruit(Integer.valueOf(String.valueOf(toprecruit)));
			if(null != id)
				roleDaytask.setId(Integer.valueOf(String.valueOf(id)));
			if(null != roleid)
				roleDaytask.setRoleid(Integer.valueOf(String.valueOf(roleid)));
			if(null != qianghua)
				roleDaytask.setQianghua(Integer.valueOf(String.valueOf(qianghua)));
			if(null != lueduo)
				roleDaytask.setLueduo(Integer.valueOf(String.valueOf(lueduo)));
			if(null != qiangduo)
				roleDaytask.setQiangduo(Integer.valueOf(String.valueOf(qiangduo)));
			if(null != zhaomu)
				roleDaytask.setZhaomu(Integer.valueOf(String.valueOf(zhaomu)));
			if(null != xiulian)
				roleDaytask.setXiulian(Integer.valueOf(String.valueOf(xiulian)));
			if(null != zhangdou)
				roleDaytask.setZhangdou(Integer.valueOf(String.valueOf(zhangdou)));
			if(null != baoxiang)
				roleDaytask.setBaoxiang(String.valueOf(baoxiang));
//			if(null != integralstatue)
//				roleDaytask.setIntegralstatue(String.valueOf(integralstatue));
//			if(null != box)
//				roleDaytask.setBox(String.valueOf(box));
			if(null != integralstatue){
				if(String.valueOf(integralstatue).equals("[0,0,0,0,0,0]")){
					roleDaytask.setIntegralstatue("[0,0,0,0,0,0,0,0]");
				}else{
					roleDaytask.setIntegralstatue(String.valueOf(integralstatue));
				}
			}
			if(null != box){
				if(String.valueOf(box).equals("[0,0,0,0]")){
					roleDaytask.setBox("[0,0,0,0,0]");
				}else{
					roleDaytask.setBox(String.valueOf(box));
				}
			}
			if(null != day)
				roleDaytask.setDay(Integer.valueOf(String.valueOf(day)));
			//更新缓存
			roleDaytasks.put(roleDaytask.getRoleid(), roleDaytask);
			//System.out.println("++++++++++++++++++++++++++++++++++++++++++CacheRoleDayTask:插入了新的数据：" + roleDaytask.getRoleid());
			//更新队列
			roleDaytask.setIsUpdate(2);
			roleDaytaskQueue_in.enqueue(roleDaytask);
			//System.out.println("_+++++++++++++++++++++++++++++++++++size:RoleDattaskQueeu:" + roleDaytaskQueue_in.size());
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	public void updateRoleDaytask(RoleDaytaskDetail roleDaytaskDetail) {
		// TODO Auto-generated method stub

		boolean b = false;
		try{
			int roleid = roleDaytaskDetail.getRoleid();
			RoleDaytaskDetail roleDaytask = null;
			try{
				roleDaytask = roleDaytasks.get(roleid);
			}catch(Exception e){
				e.printStackTrace();
			}
			//更新队列
			roleDaytask.setIsUpdate(1);
			//System.out.println("CacheRleDaytask.updateRoleDaytask:roleDaytask:" + roleDaytask.getRoleid());
			//System.out.println("CacheRoleDaytask.updateRoleDaytask:indexMap:" + roleDaytaskQueue.indexMap.size());
			if(roleDaytaskQueue.indexMap.containsKey(roleDaytask.getRoleid())){
				//System.out.println("避免一次数据库插入！roleID:" + roleDaytask.getRoleid() + " indexMap.size:" + roleDaytaskQueue.indexMap.size() + " roleDaytaskQueue.size:" + roleDaytaskQueue.size());
			}else{
				roleDaytaskQueue.enqueue(roleDaytask);
				roleDaytaskQueue.indexMap.put(roleDaytask.getRoleid(), null);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
	public void insertRoleDaytask(RoleDaytaskDetail roleDaytaskDetail) {
		// TODO Auto-generated method stub

		//System.out.println("CacheRoleDayTask.insert ROleDaytask()_____________________________:param:" + param.toString() );
		boolean b = false;
		try{
			RoleDaytaskDetail roleDaytask = roleDaytaskDetail;
			//更新缓存
			roleDaytasks.put(roleDaytask.getRoleid(), roleDaytask);
			//System.out.println("++++++++++++++++++++++++++++++++++++++++++CacheRoleDayTask:插入了新的数据：" + roleDaytask.getRoleid());
			//更新队列
			roleDaytask.setIsUpdate(2);
			roleDaytaskQueue_in.enqueue(roleDaytask);
			//System.out.println("_+++++++++++++++++++++++++++++++++++size:RoleDattaskQueeu:" + roleDaytaskQueue_in.size());
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
}
