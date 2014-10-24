package com.stang.game.cache;

import com.stang.game.entity.detail.*;
import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheActivity {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<Integer, ActivityDetail> activities = null;
	//变动过的对象组成的队列，由于自动同步数据库
	public static QueueCache activityQueue = null;
	//静态初始化方法
	public CacheActivity(){
		if(activities == null)
			activities = GlobalDatat.cacheActivities;
		if(activityQueue == null)
			activityQueue = new QueueCache("activity");
	}
	//根据多条件查询活动信息
	public List<ActivityDetail> getActivityByParams(Map<String, Object> param){
		List<ActivityDetail> activityList = new ArrayList<ActivityDetail>();
		Object id = param.get("id");
		Object type = param.get("type");
		Object month = param.get("month");
//		System.out.println(id);
		Iterator it = activities.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
//			System.out.println(i);
			ActivityDetail activity = activities.get(i);
//			System.out.println(activity.getDescription());
//			System.out.println(activity.getId());
//			System.out.println(activity.getType());
//			System.out.println(activity.getFlag());
//			System.out.println(activity.getMonth());
//			System.out.println(activity.getType()==activity.getType());
			if(activity.getId() == (null == id ? activity.getId() : Integer.valueOf(String.valueOf(id)))
			&& activity.getType() == (null == type ? activity.getType() : Integer.valueOf(String.valueOf(type)))
			&& activity.getFlag() == 1
			&& activity.getMonth() == (null == month ? activity.getMonth() : Integer.valueOf(String.valueOf(month)))){
				activityList.add(activity);
			}
		}
		return activityList;
	}
}
