package com.stang.game.cache;

import com.stang.game.entity.detail.*;
import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheAutoId {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<Integer, AutoIdDetail> autoIds = null;
	//变动过的对象组成的队列，由于自动同步数据库
	public static QueueCache autoIdQueue = null;
	//静态类同步数据库线程
	public static ThreadCache thread = null;
	//静态初始化方法
	public CacheAutoId(){
		if(thread == null){
			thread = new ThreadCache("autoId");
			thread.start();
		}
		if(autoIds == null)
			autoIds = GlobalDatat.cacheAutoIdDetails;
		if(autoIdQueue == null)
			autoIdQueue = new QueueCache("autoId");
	}
	//根据表的名字得到表内数据上线
	public synchronized Integer fingKeyValueByTableName(String tableName){
		Integer b = 0;
		Iterator it = autoIds.keySet().iterator();
		while(it.hasNext()){
			int i = Integer.valueOf(it.next().toString());
			AutoIdDetail autoId = new AutoIdDetail();
			try{
				autoId = (AutoIdDetail)autoIds.get(i).clone();
			}catch(Exception e){
				e.printStackTrace();
			}
			if(autoId.getTableName().equals(tableName)){
				b = autoId.getKeyValue();
				break;
			}
		}
		updateKeyValueAddOneByTableName(tableName);
		return b+1;
	}
	//根据表名字增加表数据上线+1
	public int updateKeyValueAddOneByTableName(String tableName){
		Integer b = -1;
		Iterator it = autoIds.keySet().iterator();
		while(it.hasNext()){
			int i = Integer.valueOf(it.next().toString());
			AutoIdDetail autoId = new AutoIdDetail();
			try{
				autoId = (AutoIdDetail)autoIds.get(i).clone();
			}catch(Exception e){
				e.printStackTrace();
			}
			if(autoId.getTableName().equals(tableName)){
				autoId.setKeyValue(autoId.getKeyValue() + 1);
				//更新缓存
				//autoIds.remove(i);
				autoIds.put(i, autoId);
				//更新队列
				autoId.setIsUpdate(1);
				autoIdQueue.enqueue(autoId);
				b = 1;
				break;
			}
		}
		
		return b;
	}
	//更新updateAutoIdDetail
	public boolean updateAutoIdDetail(AutoIdDetail model1){
		boolean b = false;
		try{
			AutoIdDetail model = new AutoIdDetail();
			model = (AutoIdDetail)model1.clone();
			//更新缓存
			//autoIds.remove(model.getId());
			autoIds.put(model.getId(), model);
			//更新队列
			model.setIsUpdate(1);
			autoIdQueue.enqueue(model); 
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//根据表名更新表内数据上线
	public boolean updateKeyValueByTableName(String tableName, int keyValue){
		boolean b = false;
		Iterator it = autoIds.keySet().iterator();
		while(it.hasNext()){
			int i = Integer.valueOf(it.next().toString());
			AutoIdDetail autoId = new AutoIdDetail();
			try{
				autoId = (AutoIdDetail)autoIds.get(i).clone();
			}catch(Exception e){
				e.printStackTrace();
			}
			if(autoId.getTableName().equals(tableName)){
				autoId.setKeyValue(keyValue);
				//更新缓存
				//autoIds.remove(i);
				autoIds.put(i, autoId);
				//更新队列
				autoId.setIsUpdate(1);
				autoIdQueue.enqueue(autoId); 
				break;
			}
		}
		return b;
	}
	//updateByTableName
	public int updateByTableName(String tableName){
		int b = -1;
		Iterator it = autoIds.keySet().iterator();
		while(it.hasNext()){
			int i = Integer.valueOf(it.next().toString());
			AutoIdDetail autoId = new AutoIdDetail();
			try{
				autoId = (AutoIdDetail)autoIds.get(i).clone();
			}catch(Exception e){
				e.printStackTrace();
			}
			if(autoId.getTableName().equals(tableName)){
				autoId.setKeyValue(autoId.getKeyValue() + 55);
				//更新缓存
				//autoIds.remove(i);
				autoIds.put(i, autoId);
				//更新队列
				autoId.setIsUpdate(1);
				autoIdQueue.enqueue(autoId); 
				b = 1;
				break;
			}
		}
		return b;
	}
	//重置表内数据
	public int updateAutoIdGamechart(int id){
		int b = -1;
		Iterator it = autoIds.keySet().iterator();
		while(it.hasNext()){
			int i = Integer.valueOf(it.next().toString());
			AutoIdDetail autoId = new AutoIdDetail();
			try{
				autoId = (AutoIdDetail)autoIds.get(i).clone();
			}catch(Exception e){
				e.printStackTrace();
			}
			if(autoId.getId() == id){
				autoId.setKeyValue(0);
				//更新缓存
				//autoIds.remove(i);
				autoIds.put(i, autoId);
				//更新队列
				autoId.setIsUpdate(1);
				autoIdQueue.enqueue(autoId); 
				b = 1;
				break;
			}
		}
		return b;
	}
}
