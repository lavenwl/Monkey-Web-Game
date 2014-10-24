package com.stang.game.cache;

import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheRoleItem {
	//缓存类操作的缓存对象(key:id, value:RoleItemDetail)
	private static Map<Long, RoleItemDetail> roleItems = null;
	//变动过的对象组成的队列，由于自动同步数据库
	public static QueueCache roleItemQueue = null;
	public static QueueCache roleItemQueue_in = null;
	//静态类同步数据库线程
	public static ThreadCache thread = null;
	//静态初始化方法
	public CacheRoleItem(){
		if(thread == null){
			thread = new ThreadCache("roleItem");
			thread.start();
		}
		if(roleItems == null)
			roleItems = GlobalDatat.cacheRoleItemDetails;
		if(roleItemQueue == null)
			roleItemQueue = new QueueCache("roleItem");
		if(roleItemQueue_in == null)
			roleItemQueue_in = new QueueCache("roleItem_in");
	}
	//更新玩家道具的数量
	public boolean addRoleItemNum(Map<String, Object> param){
	//	System.out.println("_________________________________________________addRoleItemNum()param:" + param.toString() );
		boolean b = false;
		long idd = 0L;
		try{
			int num = Integer.valueOf(String.valueOf(param.get("num")));
			Object id = param.get("id");
			Object roleid = param.get("roleid");
			Object itemid = param.get("itemid");
			RoleItemDetail roleItem = null;
			if(null != roleid && null != itemid){
				long nid = -1;
				if(null != GlobalDatat.cacheForRoleItem.get(Integer.valueOf(String.valueOf(roleid))).get(itemid)){
					nid = GlobalDatat.cacheForRoleItem.get(Integer.valueOf(String.valueOf(roleid))).get(itemid);
				}
			//	System.out.println("nid:" + nid);
				if(nid != -1)
					roleItem = roleItems.get(nid);
			}else{
				if(null != id){
					idd = Long.valueOf(String.valueOf(id));
					roleItem = roleItems.get(idd);
				}		
			}
			//System.out.println("添加前道具数量：："+roleItem.getNum());
			roleItem.setNum(roleItem.getNum() + num);
			//System.out.println("添加后道具数量：："+roleItem.getNum());
			//更新缓存
			//roleItems.remove(roleItem.getId());
			roleItems.put(roleItem.getId(), roleItem);
			//更新队列
			roleItem.setIsUpdate(1);
			if(roleItemQueue.indexMapl.containsKey(roleItem.getId())){
				//System.out.println("CacheRoleItem避免了一次插入！");
			}else{
				roleItemQueue.indexMapl.put(roleItem.getId(), null);
				roleItemQueue.enqueue(roleItem);
			}
			
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//根据id查询玩家道具
	public List<RoleItemDetail> findRoleItemById(long id){
		//System.out.println("____________________________________________________________________findRoleItemById()id:" + id);
		List<RoleItemDetail> list = new ArrayList<RoleItemDetail>();
		RoleItemDetail roleItem = null;
		roleItem = roleItems.get(id);
		if(null != roleItem)
			list.add(roleItem);
		return list;
	}
	//插入新数据
	public boolean insertRoleItem(RoleItemDetail model){
		boolean b = false;
		try{
			//更新缓存
			roleItems.put(model.getId(), model);
			//更新辅助数据结构
			if(GlobalDatat.cacheForRoleItem.containsKey(model.getRoleid())){
				GlobalDatat.cacheForRoleItem.get(model.getRoleid()).put(model.getItemid(), model.getId());
			}else{
				HashMap<Integer, Long> mapForRoleItem = new HashMap<Integer, Long>();
				mapForRoleItem.put(model.getItemid(), model.getId());
				GlobalDatat.cacheForRoleItem.put(model.getRoleid(), mapForRoleItem);
			}
			//更新队列
			model.setIsUpdate(2);
			roleItemQueue_in.enqueue(model);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}

	//减少玩家道具数量
	public boolean sbRoleItemNum(Map<String, Object> param){
		//System.out.println("________________________________________________减少道具sbRoleItemNum():param开始:" + param);
		boolean b = false;
		try{
			int num = Integer.valueOf(String.valueOf(param.get("num")));
			Object id = param.get("id");
			Object roleid = param.get("roleid");
			Object itemid = param.get("itemid");
			List<RoleItemDetail> roleItems = new ArrayList<RoleItemDetail>();
			if(null != roleid && null != itemid){
				long nid = 0L;
				if(null != GlobalDatat.cacheForRoleItem.get(Integer.valueOf(String.valueOf(roleid)))){
					nid = GlobalDatat.cacheForRoleItem.get(Integer.valueOf(String.valueOf(roleid))).get(Integer.valueOf(String.valueOf(itemid)));
				}
				RoleItemDetail roleItem = null;
				if(null != this.roleItems.get(nid) && nid != 0L){
					roleItem= this.roleItems.get(nid);
					roleItems.add(roleItem);
				}
				//更新队列
				roleItem.setNum(roleItem.getNum() - num);
				this.roleItems.put(roleItem.getId(), roleItem);
				roleItem.setIsUpdate(1);
				if(roleItemQueue.indexMapl.containsKey(roleItem.getId())){
					//System.out.println("CacheRoleItem避免了一次插入！");
				}else{
					roleItemQueue.indexMapl.put(roleItem.getId(), null);
					roleItemQueue.enqueue(roleItem);
				}
			}else{
				long idd = 0L;
				if(null != id)
					idd = Long.valueOf(String.valueOf(id));
					RoleItemDetail roleItem1 = this.roleItems.get(idd);
					if(roleItem1.getId() == (idd)){
						roleItems.add(roleItem1);
						//更新队列
						roleItem1.setNum(roleItem1.getNum() - num);
						roleItem1.setIsUpdate(1);
						if(roleItemQueue.indexMapl.containsKey(roleItem1.getId())){
							//System.out.println("CacheRoleItem避免了一次插入！");
						}else{
							roleItemQueue.indexMapl.put(roleItem1.getId(), null);
							roleItemQueue.enqueue(roleItem1);
						}
					}
				
			}
			b = true;
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//根据id删除玩家道具
	public boolean delRoleItem(Map<String, Object> param){
		//System.out.println("__________________________________________________delRoleItem:param:" + param.toString());
		boolean b = false;
		try{
			Object id = param.get("id");
			Object roleid = param.get("roleid");
			List<RoleItemDetail> roleItems = new ArrayList<RoleItemDetail>();
			long idd = 0L;
			int roleidd = 0;
			if(null != id)
				idd = Long.valueOf(String.valueOf(id));
			if(null != roleid)
				roleidd = Integer.valueOf(String.valueOf(roleid));
			if(idd != 0L){
				RoleItemDetail roleItem1 = this.roleItems.get(idd);
				RoleItemDetail roleItem = new RoleItemDetail();
				roleItem = (RoleItemDetail)roleItem1.clone();
				roleItems.add(roleItem);
			}else{
				HashMap<Integer, Long> mapForRoleItem = GlobalDatat.cacheForRoleItem.get(roleidd);
				if(mapForRoleItem != null){
					Iterator it = mapForRoleItem.keySet().iterator();
					while(it.hasNext()){
						long i = Long.valueOf(it.next().toString());
						RoleItemDetail roleItem1 = this.roleItems.get(mapForRoleItem.get(i));
						if(roleItem1.getRoleid() == (roleidd == 0 ? roleItem1.getRoleid() : roleidd)
								 && roleItem1.getId() == (idd == 0 ? roleItem1.getId() : idd)){
							RoleItemDetail roleItem = new RoleItemDetail();
							roleItem = (RoleItemDetail)roleItem1.clone();
							roleItems.add(roleItem);
						}
					}
				}
				
			}
			for(int i = 0; i < roleItems.size(); i++){
				RoleItemDetail roleItem = roleItems.get(i);
				//更新缓存
				//roleItems.remove(roleItem.getId());
				this.roleItems.get(roleItem.getId()).setFlag(0);
				//更新辅助数据结构
				GlobalDatat.cacheForRoleItem.get(roleItem.getRoleid()).remove(roleItem.getItemid());
				//更新队列
				roleItem.setIsUpdate(3);
				roleItemQueue.enqueue(roleItem);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//根据roleid，itemid，id更新缓存
	public boolean updateRoleItemByParams(Map<String, Object> param){
		//System.out.println("_________________________________________________________updateRoleITemByParams:param:" + param.toString());
		boolean b = false;
		int flag = 1;
		try{
			Object activitynum = param.get("activitynum");
			Object isnew = param.get("isnew");
			Object roleid = param.get("roleid");
			Object itemid = param.get("itemid");
			Object id = param.get("id");
			if(null != roleid && null != itemid){
				RoleItemDetail roleItem1 = null;
				if(null != GlobalDatat.cacheForRoleItem.get(Integer.valueOf(String.valueOf(roleid)))){
					long nid = GlobalDatat.cacheForRoleItem.get(Integer.valueOf(String.valueOf(roleid))).get(Integer.valueOf(String.valueOf(itemid)));
					roleItem1 = this.roleItems.get(nid);
				}
				if(null != roleItem1){
					if(null != activitynum)
						roleItem1.setActivitynum(Integer.valueOf(String.valueOf(activitynum)));
					if(null != isnew)
						roleItem1.setIsnew(Integer.valueOf(String.valueOf(isnew)));
					//更新缓存
					//this.roleItems.remove(roleItem1.getId());
					//this.roleItems.put(roleItem1.getId(), roleItem1);
					//更新队列
					roleItem1.setIsUpdate(1);
					if(roleItemQueue.indexMapl.containsKey(roleItem1.getId())){
						//System.out.println("CacheRoleItem避免了一次插入！");
					}else{
						roleItemQueue.indexMapl.put(roleItem1.getId(), null);
						roleItemQueue.enqueue(roleItem1);
					}
				}
			}else{
				long idd = 0L;
				if(null != id){
					idd = Long.valueOf(String.valueOf(id));
					RoleItemDetail roleItem1 = this.roleItems.get(idd);
						if(null != activitynum)
							roleItem1.setActivitynum(Integer.valueOf(String.valueOf(activitynum)));
						if(null != isnew)
							roleItem1.setIsnew(Integer.valueOf(String.valueOf(isnew)));
						//更新缓存
						//this.roleItems.remove(roleItem1.getId());
						//this.roleItems.put(roleItem1.getId(), roleItem1);
						//更新队列
						roleItem1.setIsUpdate(1);
						if(roleItemQueue.indexMapl.containsKey(roleItem1.getId())){
							//System.out.println("CacheRoleItem避免了一次插入！");
						}else{
							roleItemQueue.indexMapl.put(roleItem1.getId(), null);
							roleItemQueue.enqueue(roleItem1);
						}
				}
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	public List<RoleItemDetail> getRoleItemByitem(Map<String, Object> param) {
		//System.out.println("CacheROleItem._____________________getRoleItemByitem:param:" + param.toString());
		List<RoleItemDetail> list = new ArrayList<RoleItemDetail>();
		Object roleid=param.get("roleid");
		Object itemid=param.get("itemid");
		if(null != roleid && null != itemid){
			RoleItemDetail itemRole = null;
			if (null != GlobalDatat.cacheForRoleItem.get(Integer.valueOf(String
					.valueOf(roleid))) && 
					null != GlobalDatat.cacheForRoleItem.get(Integer
							.valueOf(String.valueOf(roleid)))
							.get(Integer.valueOf(String
									.valueOf(itemid)))){
				long nid = GlobalDatat.cacheForRoleItem.get(Integer.valueOf(String.valueOf(roleid))).get(Integer.valueOf(String.valueOf(itemid)));
				itemRole = this.roleItems.get(nid);
			}
			if(null != itemRole)
				list.add(itemRole);
		}
		return list;
	}
	
//	public List<RoleItemDetail> getRoleItemByNum(Map<String, Object> param){
//		List<RoleItemDetail> list = new ArrayList<RoleItemDetail>();
//		Object roleid = param.get("roleid");
//		Object num = param.get("num");
//		Object isuse = param.get("isuse");
//		Object type = param.get("type");
//		return list;
//	}
	public List<RoleItemDetail> getRoleItem(Map<String, Object> param) {
	//	System.out.println("____________________________________________________________CacheRoleItem.getRoleItem.param:" + param.toString());
		List<RoleItemDetail> list = new ArrayList<RoleItemDetail>();
		Object id=param.get("id");
		Object roleid=param.get("roleid");
		Object itemid=param.get("itemid");
		Object isuse=param.get("isuse");
		Object type=param.get("type");
		RoleItemDetail roleItem = null;
//		if(null != GlobalDatat.cacheForRoleItem.get(Integer.valueOf(String.valueOf(roleid))).get(Integer.valueOf(String.valueOf(itemid)))){
//			int nid = GlobalDatat.cacheForRoleItem.get(Integer.valueOf(String.valueOf(roleid))).get(Integer.valueOf(String.valueOf(itemid)));
//			roleItem = this.roleItems.get(nid);
//		}
		
		Long id2=0L;
		int roleid2=-7;
		int itemid2=-7;
		int isuse2=-7;
		int type2=-7;
		if(null!=id){
			id2=Long.valueOf(String.valueOf(id));
			//System.out.println("id::"+id);
		}
		if(null!=roleid){
			roleid2=Integer.valueOf(String.valueOf(roleid));
		}
		if(null!=itemid){
			itemid2=Integer.valueOf(String.valueOf(itemid));
		}
		if(null!=isuse){
			isuse2=Integer.valueOf(String.valueOf(isuse));
		}
		if(null!=type){
			type2=Integer.valueOf(String.valueOf(type));
		}
		if(roleid2 != -7){
			HashMap<Integer, Long> items = GlobalDatat.cacheForRoleItem.get(roleid2);
			if(items != null){
				Iterator it = items.keySet().iterator();
				while(it.hasNext()){
					int i = Integer.valueOf(it.next().toString());
					roleItem = roleItems.get(items.get(i));
					if(roleItem.getId()==(id2==0L?roleItem.getId():id2)&&
					  roleItem.getRoleid()==(roleid2==-7?roleItem.getRoleid():roleid2)&&
					  roleItem.getItemid()==(itemid2==-7?roleItem.getItemid():itemid2)&&
					  roleItem.getIsnew()==(isuse2==-7?roleItem.getIsnew():isuse2)&&
					  roleItem.getType()==(type2==-7?roleItem.getType():type2)){
						list.add(roleItem);
					}
				}
			}
		}
		
		//System.out.println("查询getRoleItem得到的总数量：：："+list.size() + list.isEmpty());
		if(!list.isEmpty()){
			//System.out.println("查询getRoleItem得到的num总数量：：："+list.get(0).getNum());
		}
//		if(null != roleItem)
//			list.add(roleItem);
//		System.out.println("查询getRoleItem得到的总数量：：："+list.size() + list.isEmpty());
		return list;
	}
	public void updateRoleItem(RoleItemDetail roleItemDetail) {
		// TODO Auto-generated method stub

		//System.out.println("_________________________________________________________updateRoleITemByParams:param:" + param.toString());
		boolean b = false;
		int flag = 1;
		try{
					RoleItemDetail roleItem1 = roleItemDetail;
						//更新缓存
						//this.roleItems.remove(roleItem1.getId());
						//this.roleItems.put(roleItem1.getId(), roleItem1);
						//更新队列
						roleItem1.setIsUpdate(1);
						if(roleItemQueue.indexMapl.containsKey(roleItem1.getId())){
							//System.out.println("CacheRoleItem避免了一次插入！");
						}else{
							roleItemQueue.indexMapl.put(roleItem1.getId(), null);
							roleItemQueue.enqueue(roleItem1);
						}
				
			
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
}
