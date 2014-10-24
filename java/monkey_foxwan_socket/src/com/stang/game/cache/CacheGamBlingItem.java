package com.stang.game.cache;

import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheGamBlingItem {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<Integer, GamblingItemDetail> gamblingItems = null;
	//变动过的对象组成的队列，由于自动同步数据库
	public static QueueCache gamblingItemQueue = null;
	//静态类同步数据库线程
	public static ThreadCache thread = null;
	//静态初始化方法
	public CacheGamBlingItem(){
		if(thread == null){
			thread = new ThreadCache("gamblingItem");
			thread.start();
		}
		if(gamblingItems == null)
			gamblingItems = GlobalDatat.cacheGamblingItemDetails;
		if(gamblingItemQueue == null)
			gamblingItemQueue = new QueueCache("gamblingItem");
	}
	public List<GamblingItemDetail> getGamblingItem(Map<String, Object> param) {
		//System.out.println("打开寻宝查询缓存开始：：：");
		List<GamblingItemDetail> gamblingItemList = new ArrayList<GamblingItemDetail>();
		Object id = param.get("id");
		Object mId = param.get("mId");
		Object typeId = param.get("typeId");
		Object type = param.get("type");
		Object cost = param.get("cost");
		Object isRare = param.get("isRare");
		Object rareNum = param.get("rareNum");
		Object rareNumNow = param.get("rareNumNow");
		Object isShow = param.get("isShow");
		int id2=-7;
		int mid2=-7;
		int typeid2=-7;
		int type2=-7;
		int cost2=-7;
		int israre2=-7;
		int rarenum2=-7;
		int rarenumnow2=-7;
		int isshow2=-7;
		if(null!=id){
			id2=Integer.valueOf(String.valueOf(id));
			//System.out.println("id2::"+id2);
		}
		if(null!=mId){
			mid2=Integer.valueOf(String.valueOf(mId));
			//System.out.println("mid2::"+mid2);
		}
		if(null!=typeId){
			typeid2=Integer.valueOf(String.valueOf(typeId));
			//System.out.println("typeid2::"+typeid2);
		}
		if(null!=type){
			type2=Integer.valueOf(String.valueOf(type));
			//System.out.println("type2::"+type2);
		}
		if(null!=cost){
			cost2=Integer.valueOf(String.valueOf(cost));
			//System.out.println("cost2::"+cost2);
		}
		if(null!=isRare){
			israre2=Integer.valueOf(String.valueOf(isRare));
			//System.out.println("israre2::"+israre2);
		}
		if(null!=rareNum){
			rarenum2=Integer.valueOf(String.valueOf(rareNum));
			//System.out.println("rarenum2::"+rarenum2);
		}
		if(null!=rareNumNow){
			rarenumnow2=Integer.valueOf(String.valueOf(rareNumNow));
			//System.out.println("rarenumnow2::"+rarenumnow2);
		}
		if(null!=isShow){
			isshow2=Integer.valueOf(String.valueOf(isShow));
			//System.out.println("isshow::"+isshow2);
		}
		
		
		Iterator it = gamblingItems.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GamblingItemDetail gamblingItem = gamblingItems.get(i);
			if(gamblingItem.getId() == (id2==-7 ? gamblingItem.getId() : id2)
			&& gamblingItem.getMId() == (mid2==-7 ? gamblingItem.getMId() : mid2)
			&& gamblingItem.getTypeId() == (typeid2==-7 ? gamblingItem.getTypeId() :typeid2)
			&& gamblingItem.getType() == (type2==-7 ? gamblingItem.getType() :type2 )
			&& gamblingItem.getCost() == (cost2==-7? gamblingItem.getCost() :cost2)
			&& gamblingItem.getIsRare() == (israre2==-7 ? gamblingItem.getIsRare() :israre2 )
			&& gamblingItem.getRareNum() == (rarenum2==-7? gamblingItem.getRareNum() :rarenum2 )
			&& gamblingItem.getRareNumNow() == (rarenumnow2==-7? gamblingItem.getRareNumNow() : rarenumnow2)
			&& gamblingItem.getIsShow() == (isshow2==-7 ? gamblingItem.getIsShow() : isshow2)){
				gamblingItemList.add(gamblingItem);
				//System.out.println("打开寻宝查询缓存得到数据："+gamblingItemList.size());
			}
		}
		return gamblingItemList;
	}
	public void updateGamblingItemByParam(Map<String, Object> param) {
		boolean b = false;
		int id = Integer.valueOf(String.valueOf(param.get("id")));
		try{
			Object mId = param.get("mId");
			Object typeId = param.get("typeId");
			Object cost = param.get("cost");
			Object isRare = param.get("isRare");
			Object rareNum = param.get("rareNum");
			Object rareNumNow = param.get("rareNumNow");
			Object flag = param.get("flag");
			Object isShow = param.get("isShow");
		
			GamblingItemDetail gamblingItemDetail = new GamblingItemDetail();
			try{
				gamblingItemDetail = (GamblingItemDetail)gamblingItems.get(id).clone();
			}catch(Exception e){
				e.printStackTrace();
			}
			if(null != mId){
				gamblingItemDetail.setMId(Integer.valueOf(String.valueOf(mId)));
			}
			if(null != typeId){
				gamblingItemDetail.setTypeId(Integer.valueOf(String.valueOf(typeId)));
			}
			if(null != cost){
				gamblingItemDetail.setCost(Integer.valueOf(String.valueOf(cost)));
			}
			if(null != isRare){
				gamblingItemDetail.setIsRare(Integer.valueOf(String.valueOf(isRare)));
			}
			if(null != rareNum){
				gamblingItemDetail.setRareNum(Integer.valueOf(String.valueOf(rareNum)));
			}
			if(null != rareNumNow){
				gamblingItemDetail.setRareNumNow(Integer.valueOf(String.valueOf(rareNumNow)));
			}
			if(null != flag){
				gamblingItemDetail.setFlag(Integer.valueOf(String.valueOf(flag)));
			}
			if(null != isShow){
				gamblingItemDetail.setIsShow(Integer.valueOf(String.valueOf(isShow)));
			}
			
			
		//	gamblingItems.remove(id);
			gamblingItems.put(id, gamblingItemDetail);
			gamblingItemDetail.setIsUpdate(1);
			gamblingItemQueue.enqueue(gamblingItemDetail);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public List<GamblingItemDetail> getGamblingItemBytype(int type) {
		List<GamblingItemDetail> gamblingItemList = new ArrayList<GamblingItemDetail>();
	
		Iterator it = gamblingItems.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GamblingItemDetail gamblingItem = gamblingItems.get(i);
			if(gamblingItem.getType()== type){
				gamblingItemList.add(gamblingItem);
			}
		}
		return gamblingItemList;
	}
	public List<GamblingItemDetail> getGamblingItemBymid(int mid) {
		List<GamblingItemDetail> gamblingItemList = new ArrayList<GamblingItemDetail>();
	
		Iterator it = gamblingItems.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GamblingItemDetail gamblingItem = gamblingItems.get(i);
			if(gamblingItem.getMId()== mid)
		{
				gamblingItemList.add(gamblingItem);
			}
		}
		return gamblingItemList;
	}
	public List<GamblingItemDetail> getGamblingItemByparam(
			Map<String, Object> param) {
		List<GamblingItemDetail> gamblingItemList = new ArrayList<GamblingItemDetail>();
		Object mId = param.get("mId");
		Object type = param.get("type");
		int mid2=0;
		int type2=0;
		if(null!=mId){
			mid2=Integer.valueOf(String.valueOf(mId));
		}
		if(null!=type){
			type2=Integer.valueOf(String.valueOf(type));
		}
		//int mId=47;
		//int type=1;
		//System.out.println("mid2"+mid2+"  type2"+type2);
		Iterator it = gamblingItems.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GamblingItemDetail gamblingItem = gamblingItems.get(i);
			if( gamblingItem.getMId() == (mid2==0 ? gamblingItem.getMId() : mid2)
			&& gamblingItem.getType() == (type2==0 ? gamblingItem.getType() : type2)){
				gamblingItemList.add(gamblingItem);
			}
		

		}
		//System.out.println("gamblingItems.size"+gamblingItems.size()+" mId"+mId+"  type"+type+"  gamblingItemList.size"+gamblingItemList.size());
		
		return gamblingItemList;
	}

}
