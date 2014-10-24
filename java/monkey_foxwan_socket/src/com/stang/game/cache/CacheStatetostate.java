package com.stang.game.cache;

import com.stang.game.common.GameConstants;
import com.stang.game.entity.detail.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheStatetostate {
	//缓存类操作的缓存对象(key:id, value:ChallengeRecordDetail)
	private static Map<Integer, StatetostateDetail> statetostates = null;
	//变动过的对象组成的队列，由于自动同步数据库
	public static QueueCache statetostateQueue = null;
	//静态类同步数据库线程
	public static ThreadCache thread = null;
	//id 的最大值
	public static int index = 0;
	//静态初始化方法
	public CacheStatetostate(){
		if(thread == null){
			thread = new ThreadCache("statetostate");
			thread.start();
		}
		if(statetostates == null){
			statetostates = GlobalDatat.cacheStatetostateDetails;
			statetostates.putAll(GlobalDatat.cacheStatetostateDetails2);
		}
			
		if(statetostateQueue == null)
			statetostateQueue = new QueueCache("statetostate");
		if(index == 0){
			Iterator it = statetostates.keySet().iterator();
			while(it.hasNext()){
				Integer i = Integer.valueOf(it.next().toString());
				if(i > index)
					index = i;
			}
		}
	}

	public boolean updateStatetostate(StatetostateDetail statetostateDetail) {
		boolean b = false;
		try{
			//更新缓存
			statetostates.put(statetostateDetail.getId(), statetostateDetail);
			//更新队列
			statetostateDetail.setIsUpdate(1);
			statetostateQueue.enqueue(statetostateDetail);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}

	public boolean insertStatetostateDetail(StatetostateDetail statetostateDetail) {
	//GameConstants.log.warn("CacheStatetostate.insertStatetostateDetail():index:" + (index + 1));
		boolean b = false;
		try{
			index = index + 1;
			statetostateDetail.setId(index);
			//插入缓存
			statetostates.put(index, statetostateDetail);
			//插入辅助数据结构
			if(statetostateDetail.getFlag() == 1){
				Map<Integer, List<Integer>> mapForStatetostate = null;
				List<Integer> listForStatetostate1 = null;
				List<Integer> listForStatetostate2 = null;	
				if(GlobalDatat.cacheForStatetostate.containsKey(statetostateDetail.getReceiver())){
					if(statetostateDetail.getType() == 1 || statetostateDetail.getType() == 2){
							GlobalDatat.cacheForStatetostate.get(statetostateDetail.getReceiver()).get(statetostateDetail.getType()).add(statetostateDetail.getId());
					}else{
						GameConstants.log.warn("init statetostate haven an wrong data: id:" + statetostateDetail.getId() + "  type:" + statetostateDetail.getType());
					}
				}else{
					mapForStatetostate = new HashMap<Integer, List<Integer>>();
					listForStatetostate1 = new ArrayList<Integer>();
					listForStatetostate2 = new ArrayList<Integer>();
					mapForStatetostate.put(1, listForStatetostate1);
					mapForStatetostate.put(2, listForStatetostate2);
					if(statetostateDetail.getType() == 1 || statetostateDetail.getType() == 2){
						mapForStatetostate.get(statetostateDetail.getType()).add(statetostateDetail.getId());
					}else{
						GameConstants.log.warn("init statetostate haven an wrong data: id:" + statetostateDetail.getId() + "  type:" + statetostateDetail.getType());
					}
					GlobalDatat.cacheForStatetostate.put(statetostateDetail.getReceiver(), mapForStatetostate);
				}
			}else if(statetostateDetail.getFlag() == 2){
				//GameConstants.log.warn("insert flag = 2");
				Map<Integer, List<Integer>> mapForStatetostate2 = null;
				List<Integer> listForStatetostate12 = null;
				List<Integer> listForStatetostate22 = null;	
				//GameConstants.log.warn("GlobalDatat.cacheForStatetostate2.containsKey(statetostateDetail.getReceiver()):" + GlobalDatat.cacheForStatetostate2.containsKey(statetostateDetail.getReceiver()));
					if(GlobalDatat.cacheForStatetostate2.containsKey(statetostateDetail.getReceiver())){
						GameConstants.log.warn("statetostateDetail.getType() == 1 || statetostateDetail.getType() == 2:"  + (statetostateDetail.getType() == 1 || statetostateDetail.getType() == 2));
						if(statetostateDetail.getType() == 1 || statetostateDetail.getType() == 2){
							GlobalDatat.cacheForStatetostate2.get(statetostateDetail.getReceiver()).get(statetostateDetail.getType()).add(statetostateDetail.getId());
						}else{
							GameConstants.log.warn("init statetostate haven an wrong data: id:" + statetostateDetail.getId() + "  type:" + statetostateDetail.getType());
						}
					}else{
						//GameConstants.log.warn("statetostateDetail.getReceiver():" + statetostateDetail.getReceiver());
						mapForStatetostate2 = new HashMap<Integer, List<Integer>>();
						listForStatetostate12 = new ArrayList<Integer>();
						listForStatetostate22 = new ArrayList<Integer>();
						mapForStatetostate2.put(1, listForStatetostate12);
						mapForStatetostate2.put(2, listForStatetostate22);
						if(statetostateDetail.getType() == 1 || statetostateDetail.getType() == 2){
							mapForStatetostate2.get(statetostateDetail.getType()).add(statetostateDetail.getId());
						}else{
							GameConstants.log.warn("init statetostate haven an wrong data: id:" + statetostateDetail.getId() + "  type:" + statetostateDetail.getType());
						}
					//	GameConstants.log.warn("statetostateDetail.mapForStatetostate2:" + mapForStatetostate2.toString());
						GlobalDatat.cacheForStatetostate2.put(statetostateDetail.getReceiver(), mapForStatetostate2);
					}
					//GameConstants.log.warn("insertStatetostate:size" + getRequestByRoleid2(statetostateDetail.getReceiver()).size());
			}
			
			//插入队列
			statetostateDetail.setIsUpdate(2);
			statetostateQueue.enqueue(statetostateDetail);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}

	public List<StatetostateDetail> getRequestByRoleid(int roleid) {
		List<StatetostateDetail> slist = new ArrayList<StatetostateDetail>();
		if(GlobalDatat.cacheForStatetostate.containsKey(roleid)){
			List<Integer> list = GlobalDatat.cacheForStatetostate.get(roleid).get(1);
			for(int i = 0; i < list.size(); i++){
				if(statetostates.containsKey(list.get(i))){
					slist.add(statetostates.get(list.get(i)));
				}
			}
		}
		//按照是否处理和数据产生时间排序
		Collections.sort(slist, new Comparator<StatetostateDetail>(){
            public int compare(StatetostateDetail s1, StatetostateDetail s2) {
            	Long t1 = null;
            	Long t2 = null;
            	try{
            		t1 = s1.getTime();
	            	t2 = s2.getTime();
            	}catch(Exception e){
            		e.printStackTrace();
            	}
      
                return t2.compareTo(t1);
            }
    });
		Collections.sort(slist, new Comparator<StatetostateDetail>(){
            public int compare(StatetostateDetail s1, StatetostateDetail s2) {
            	return s1.getStatue()>s2.getStatue()?1:(s1.getStatue()==s2.getStatue()?0:(s2.getTime()>s1.getTime()?-1:0));
            }
    });
 		return slist;
	}

	public List<StatetostateDetail> getFreeGiftByRoleid(int roleid) {
		List<StatetostateDetail> slist = new ArrayList<StatetostateDetail>();
		if(GlobalDatat.cacheForStatetostate.containsKey(roleid)){
			List<Integer> list = GlobalDatat.cacheForStatetostate.get(roleid).get(2);
			for(int i = 0; i < list.size(); i++){
				if(statetostates.containsKey(list.get(i))){
					slist.add(statetostates.get(list.get(i)));
				}
			}
		}
		//按照是否处理和数据产生时间排序
		Collections.sort(slist, new Comparator<StatetostateDetail>(){
            public int compare(StatetostateDetail s1, StatetostateDetail s2) {
            	Long t1 = null;
            	Long t2 = null;
            	try{
            		t1 = s1.getTime();
	            	t2 = s2.getTime();
            	}catch(Exception e){
            		e.printStackTrace();
            	}
      
                return t2.compareTo(t1);
            }
    });
		Collections.sort(slist, new Comparator<StatetostateDetail>(){
            public int compare(StatetostateDetail s1, StatetostateDetail s2) {
            	return s1.getStatue()>s2.getStatue()?1:(s1.getStatue()==s2.getStatue()?0:(s2.getTime()>s1.getTime()?-1:0));
            }
    });
 		return slist;
	}

	public StatetostateDetail getStatetostateById(int id) {
		// TODO Auto-generated method stub
		return statetostates.get(id);
	}

		public List<StatetostateDetail> getRequestByRoleid2(int roleid) {
		List<StatetostateDetail> slist = new ArrayList<StatetostateDetail>();
		if(GlobalDatat.cacheForStatetostate2.containsKey(roleid)){
			List<Integer> list = GlobalDatat.cacheForStatetostate2.get(roleid).get(1);
			//GameConstants.log.warn("CacheStatetostate.getRequsestByRoleid:roleid:" + roleid + " list.size:" + list.size());
			for(int i = 0; i < list.size(); i++){
				if(statetostates.containsKey(list.get(i))){
					slist.add(statetostates.get(list.get(i)));
				}
			}
		}
		//按照是否处理和数据产生时间排序
		Collections.sort(slist, new Comparator<StatetostateDetail>(){
            public int compare(StatetostateDetail s1, StatetostateDetail s2) {
            	Long t1 = null;
            	Long t2 = null;
            	try{
            		t1 = s1.getTime();
	            	t2 = s2.getTime();
            	}catch(Exception e){
            		e.printStackTrace();
            	}
      
                return t2.compareTo(t1);
            }
    });
		Collections.sort(slist, new Comparator<StatetostateDetail>(){
            public int compare(StatetostateDetail s1, StatetostateDetail s2) {
            	return s1.getStatue()>s2.getStatue()?1:(s1.getStatue()==s2.getStatue()?0:(s2.getTime()>s1.getTime()?-1:0));
            }
    });
 		return slist;
	}

	public List<StatetostateDetail> getFreeGiftByRoleid2(int roleid) {
		List<StatetostateDetail> slist = new ArrayList<StatetostateDetail>();
		if(GlobalDatat.cacheForStatetostate2.containsKey(roleid)){
			List<Integer> list = GlobalDatat.cacheForStatetostate2.get(roleid).get(2);
			for(int i = 0; i < list.size(); i++){
				if(statetostates.containsKey(list.get(i))){
					slist.add(statetostates.get(list.get(i)));
				}
			}
		}
		//按照是否处理和数据产生时间排序
		Collections.sort(slist, new Comparator<StatetostateDetail>(){
            public int compare(StatetostateDetail s1, StatetostateDetail s2) {
            	Long t1 = null;
            	Long t2 = null;
            	try{
            		t1 = s1.getTime();
	            	t2 = s2.getTime();
            	}catch(Exception e){
            		e.printStackTrace();
            	}
      
                return t2.compareTo(t1);
            }
    });
		Collections.sort(slist, new Comparator<StatetostateDetail>(){
            public int compare(StatetostateDetail s1, StatetostateDetail s2) {
            	return s1.getStatue()>s2.getStatue()?1:(s1.getStatue()==s2.getStatue()?0:(s2.getTime()>s1.getTime()?-1:0));
            }
    });
 		return slist;
	}
	
}
