package com.stang.game.cache;

import com.stang.game.entity.detail.*;
import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheRoleBing {
	//缓存类操作的缓存对象(key:id, value:RoleBingDetail)
	private static Map<Integer, RoleBingDetail> roleBings = null;
	//变动过的对象组成的队列，由于自动同步数据库
	public static QueueCache roleBingQueue = null;
	//数据index
	public static int index = 0;
	//静态类同步数据库线程
	public static ThreadCache thread = null;
	//静态初始化方法
	public CacheRoleBing(){
		if(thread == null){
			thread = new ThreadCache("roleBing");
			thread.start();
		}
		if(roleBings == null)
			roleBings = GlobalDatat.cacheRoleBingDetails;
		if(roleBingQueue == null)
			roleBingQueue = new QueueCache();
		if(index == 0){
			Iterator it = roleBings.keySet().iterator();
			while(it.hasNext()){
				Integer i = Integer.valueOf(it.next().toString());
				if(i > index)
					index = i;
			}
		}
	}
	//根据ID得到数据
	public List<RoleBingDetail> findRoleBingByParams(Map<String, Object> param){
		//System.out.println("CacheRoleBing.findRoleBingByParams();param:" + param.toString());
		int roleid = Integer.valueOf(String.valueOf(param.get("roleid")));
		int mapid = Integer.valueOf(String.valueOf(param.get("mapid")));
		List<RoleBingDetail> list = new ArrayList<RoleBingDetail>();
        Iterator it = roleBings.keySet().iterator();
      if(mapid >= 2){//特殊从   新开服15天的副本排行榜
    	  while(it.hasNext()){
				Integer i = Integer.valueOf(it.next().toString());
				RoleBingDetail roleBing = roleBings.get(i);
				if(roleBing.getRoleid() == roleid&&roleBing.getStars()>0){
					list.add(roleBing);
				}
			}
		}else{
			while(it.hasNext()){
				Integer i = Integer.valueOf(it.next().toString());
				RoleBingDetail roleBing = roleBings.get(i);
				if(roleBing.getRoleid() == roleid && roleBing.getMapid() == mapid){
					list.add(roleBing);
				}
			}
		}
		return list;
	}
	//插入新的数据
	public boolean insertRoleBing(Map<String, Object> param){
		System.out.println("CacheROleBIng_______________________________________________________insertROleBingparam:" + param.toString());
		boolean b = false;
		try{
			Object roleid = param.get("roleid");
			Object nandu = param.get("nandu");
			Object stars = param.get("stars");
			Object mapid = param.get("mapid");
			RoleBingDetail roleBing = new RoleBingDetail();
			if(null != roleid)
				roleBing.setRoleid(Integer.valueOf(String.valueOf(roleid)));
			if(null != nandu)
				roleBing.setNandu(Integer.valueOf(String.valueOf(nandu)));
			if(null != stars)
				roleBing.setStars(Integer.valueOf(String.valueOf(stars)));
			if(null != mapid)
				roleBing.setMapid(Integer.valueOf(String.valueOf(mapid)));
			roleBing.setStatus(0);
			index = index + 1;
			roleBing.setId(index);
			roleBing.setIsUpdate(2);
			//插入缓存
			roleBings.put(index, roleBing);
			//插入队列
			roleBingQueue.enqueue(roleBing);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//更新语句
	public boolean updateRoleBing(Map<String, Object> param){
			boolean b = false;
			int roleidd = 0;
			int mapidd = 0;
			try{
				Object nandu2 = param.get("nandu2");
				Object nandu = param.get("nandu");
				Object status = param.get("status");
				Object stars = param.get("stars");
				Object roleid = param.get("roleid");
				Object mapid = param.get("mapid");
				if(null != roleid){
					roleidd = Integer.valueOf(String.valueOf(roleid));
				}else if(null != mapid){
					mapidd = Integer.valueOf(String.valueOf(mapid));
				}
				Iterator it = roleBings.keySet().iterator();
				while(it.hasNext()){
					Integer i = Integer.valueOf(it.next().toString());
					RoleBingDetail roleBing = new RoleBingDetail();
					try{
						roleBing = (RoleBingDetail)roleBings.get(i).clone();
					}catch(Exception e){
						e.printStackTrace();
					}
					if(roleBing.getRoleid() == roleidd && roleBing.getMapid() == mapidd){
						roleBing.setFlag(1);
						if(null != nandu2)
							roleBing.setNandu2(Integer.valueOf(String.valueOf(nandu2)));
						if(null != nandu)
							roleBing.setNandu(Integer.valueOf(String.valueOf(nandu)));
						if(null != status)
							roleBing.setStatus(Integer.valueOf(String.valueOf(status)));
						if(null != stars)
							roleBing.setStars(Integer.valueOf(String.valueOf(stars)));
						//更新缓存
						//roleBings.remove(i);
						roleBings.put(i, roleBing);
						//更新队列
						roleBing.setIsUpdate(1);
						roleBingQueue.enqueue(roleBing);
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			return b;
		}
}
