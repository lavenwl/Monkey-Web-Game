package com.stang.game.cache;

import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheHost {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<Integer, HostDetail> hosts = null;
	//静态初始化方法
	public CacheHost(){
		if(hosts == null)
			hosts = GlobalDatat.cacheHostDetails;
	}
	public List<HostDetail> findHostByParam(Map<String, Object> param) {
		// TODO Auto-generated method stub
		List<HostDetail> hostList=new ArrayList<HostDetail>();
		Object id = param.get("id");
		Object mid1 = param.get("mid1");
		Object mid2 = param.get("mid2");
		Iterator it = hosts.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			HostDetail host = hosts.get(i);
			if(host.getId() == (null == id ? host.getId() : Integer.valueOf(String.valueOf(id)))
			&& host.getMid1() == (null == mid1 ? host.getMid1() : Integer.valueOf(String.valueOf(mid1)))
			&& host.getMid2() == (null == mid2 ? host.getMid2() : Integer.valueOf(String.valueOf(mid2)))){
				hostList.add(host);
			}
		}
		return hostList;
	}
	public List<HostDetail> findHostById(int id) {
		// TODO Auto-generated method stub
		List<HostDetail> hostList=new ArrayList<HostDetail>();
		Iterator it = hosts.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			HostDetail host = hosts.get(i);
			if(host.getId()==id){
				hostList.add(host);
				break;
			}
		}
		return hostList;
	}
	
}
