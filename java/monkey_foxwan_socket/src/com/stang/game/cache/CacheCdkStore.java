package com.stang.game.cache;

import java.util.Map;

import com.stang.game.entity.detail.CdkStoreDetail;

public class CacheCdkStore {
	/**
	 * 具体对象的缓存类
	 * @author Laven Wang
	 *
	 */
	//缓存类操作的缓存对象(key:cdk, value:RoleItemDetail)
	private static Map<String, CdkStoreDetail> cdkStore = null;
	//变动过的对象组成的队列，由于自动同步数据库
	public static QueueCache cdkStoreQueue = null;
	public static QueueCache cdkStoreQueue_in = null;
	//静态类同步数据库线程
	public static ThreadCache thread = null;
	//静态初始化方法
	public CacheCdkStore(){
		if(thread == null){
			thread = new ThreadCache("cdkStore");
			thread.start();
		}
		if(cdkStore == null)
			cdkStore = GlobalDatat.cacheCdkStoreDetails;
		if(cdkStoreQueue == null)
			cdkStoreQueue = new QueueCache("cdkStore");
		if(cdkStoreQueue_in == null)
			cdkStoreQueue_in = new QueueCache("cdkStore_in");
	}
	//根据玩家cdk查询玩家的具体数据
	public CdkStoreDetail findCdkStoreBycdk(String cdk){
		return cdkStore.get(cdk);
	}
	//更新cdk是否被领取
	public boolean Updatemploy(String employ, String cdk){
		boolean b = false;
		try{
			CdkStoreDetail cdkStoreDetail = null;
			try{
				cdkStoreDetail = cdkStore.get(cdk);
			}catch(Exception e){
				e.printStackTrace();
			}
			cdkStoreDetail.setEmploy(employ);
			cdkStore.put(cdk, cdkStoreDetail);
			cdkStoreDetail.setEmploy(employ);
			if(cdkStoreQueue.indexMap.containsKey(cdkStoreDetail.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				cdkStoreQueue.indexMap.put(cdkStoreDetail.getId(), null);
				cdkStoreQueue.enqueue(cdkStoreDetail);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
}
