package com.stang.game.cache;

import com.stang.game.entity.Roletotem;
import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheRoletotme {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<Integer, RoletotemDetail>  gameRoletotmes = null;
	//变动过的对象组成的队列，由于自动同步数据库
	public static QueueCache gameRoletotmeQueue = null;
	//静态类同步数据库线程
	public static ThreadCache thread = null;
	//静态初始化方法
	public CacheRoletotme(){
		if(thread == null){
			thread = new ThreadCache("Roletotme");
			thread.start();
		}
		if(gameRoletotmes == null)
			gameRoletotmes = GlobalDatat.cacheRoletotemDetails;
		if(gameRoletotmeQueue == null)
			gameRoletotmeQueue = new QueueCache("Roletotme");
	}
	public boolean insertRoletotem(RoletotemDetail model1) {
		boolean b = false;
		try{
			int id=0;
			if(gameRoletotmes.isEmpty()){
				
			}else{
			Iterator it = gameRoletotmes.keySet().iterator();
			while(it.hasNext()){
				Integer i = Integer.valueOf(it.next().toString());
				if(i>id){
					id=i;
				}
			}
			}
			RoletotemDetail model = new RoletotemDetail();
			//RoletotemDetail model2 = new RoletotemDetail();
			model = (RoletotemDetail)model1.clone();
			model.setFlag(1);
			model.setId(id+1);
			//model2= (RoletotemDetail)model1.clone();
			//gameRoletotmes.put(id+1, model);
			gameRoletotmes.put(model.getId(), model);
			RoletotemDetail model2=(RoletotemDetail) model.clone();
			model2.setIsUpdate(2);
			gameRoletotmeQueue.enqueue(model2);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	public boolean sbRoletotemNum(Map<String, Object> param) {
		// TODO Auto-generated method stub
		boolean b=false;
		
		List<RoletotemDetail> roletotemDetailList=new ArrayList<RoletotemDetail>();
//		int num = Integer.valueOf(String.valueOf(param.get("num")));
//		Object roleid = param.get("roleid");
//		Object totemid = param.get("totemid");
//		Object type = param.get("type");
//		Object level = param.get("level");
//		try {
//			List<RoletotemDetail> list = new ArrayList<RoletotemDetail>();
//			Iterator it = gameRoletotmes.keySet().iterator();
//			while(it.hasNext()){
//				Integer i = Integer.valueOf(it.next().toString());
//				RoletotemDetail roletotemDetail = gameRoletotmes.get(i);
//				if(roletotemDetail.getRoleid() == (null == roleid ? (roletotemDetail.getRoleid()+1) : Integer.valueOf(String.valueOf(roleid)))
//				&& roletotemDetail.getTotemid() == (null == totemid ? roletotemDetail.getTotemid() : Integer.valueOf(String.valueOf(totemid)))
//				&& roletotemDetail.getType() == (null == type ? roletotemDetail.getTotemid() : Integer.valueOf(String.valueOf(type)))
//	            && roletotemDetail.getLevel() == (null == level ? roletotemDetail.getLevel() : Integer.valueOf(String.valueOf(level)))){
//					RoletotemDetail roletotemDetail1 = new RoletotemDetail(); 
//					roletotemDetail1 = (RoletotemDetail)roletotemDetail.clone();
//					roletotemDetail = roletotemDetail1;
//					list.add(roletotemDetail);
//					break;
//				}
//			}
			
			
			/****/
		   Object num=param.get("num");
			//int num = Integer.valueOf(String.valueOf(param.get("num")));
			Object roleid = param.get("roleid");
			Object totemid = param.get("totemid");
			Object type = param.get("type");
			Object level = param.get("level");
			Object equiptotem = param.get("equiptotem");
			int roleid2=0;
			int totemid2=0;
			int type2=0;
			int level2=0;
			try {
				if(null!=roleid){
					roleid2=Integer.valueOf(String.valueOf(roleid));
				}
				if(null!=totemid){
					totemid2=Integer.valueOf(String.valueOf(totemid));
				}
				if(null!=type){
					type2=Integer.valueOf(String.valueOf(type));
				}
				if(null!=level){
					level2=Integer.valueOf(String.valueOf(level));
				}
				List<RoletotemDetail> list = new ArrayList<RoletotemDetail>();
				Iterator it = gameRoletotmes.keySet().iterator();
				RoletotemDetail roletotemDetail=new RoletotemDetail();
				while(it.hasNext()){
					Integer i = Integer.valueOf(it.next().toString());
					//RoletotemDetail roletotemDetail = (RoletotemDetail) gameRoletotmes.get(i).clone();
					roletotemDetail = (RoletotemDetail) gameRoletotmes.get(i).clone();
					//RoletotemDetail roletotemDetail = gameRoletotmes.get(i);
					if(roletotemDetail.getRoleid() == (roleid2==0 ? (roletotemDetail.getRoleid()) : roleid2)
					&& roletotemDetail.getTotemid() == (totemid2==0 ? roletotemDetail.getTotemid() :totemid2 )
					&& roletotemDetail.getType() == (type2==0 ? roletotemDetail.getType() :type2 )
		            && roletotemDetail.getLevel() == (level2==0 ? roletotemDetail.getLevel() : level2)){
						//RoletotemDetail roletotemDetail1 = new RoletotemDetail(); 
						//roletotemDetail1 = (RoletotemDetail)roletotemDetail.clone();
						//roletotemDetail = roletotemDetail1;
						//list.add(roletotemDetail1);
						//roletotemDetail1=null;
      //                 System.out.println("原来数量：："+roletotemDetail.getNum());
						//gameRoletotmes.remove(roletotemDetail.getId());
						if(null!=equiptotem){
							roletotemDetail.setEquiptotem(1);
							//System.out.println("玩家装备图腾：：：：：");
						}
						if(null!=num){
							roletotemDetail.setNum(roletotemDetail.getNum()-Integer.valueOf(String.valueOf(param.get("num"))));
						}
						//roletotemDetail.setNum(roletotemDetail.getNum()-num);
						gameRoletotmes.put(roletotemDetail.getId(), roletotemDetail);
						RoletotemDetail roletotemDetail2=(RoletotemDetail) roletotemDetail.clone();
						roletotemDetail2.setIsUpdate(1);
						gameRoletotmeQueue.enqueue(roletotemDetail2);
		//				System.out.println("减过后的总数量：：："+roletotemDetail.getNum());
						b=true;
						break;
						
					}
				}
			/****/
			
//			for(int i = 0; i < list.size(); i++){
//				
//				RoletotemDetail roletotemDetail = list.get(i);
//				System.out.println("减图腾："+"原数量："+roletotemDetail.getNum()+"要减去的数量："+num);
//				
//				gameRoletotmes.remove(list.get(i).getId());
//				roletotemDetail.setNum(roletotemDetail.getNum()-num);
//				gameRoletotmes.put(roletotemDetail.getId(), roletotemDetail);
//				roletotemDetail.setIsUpdate(1);
//				gameRoletotmeQueue.enqueue(roletotemDetail);
//				System.out.println("减过后的总数量：：："+roletotemDetail.getNum());
//			}
			//b=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
		
	}
	public boolean addRoletotemNum(Map<String, Object> param) {
		// TODO Auto-generated method stub
		boolean b=false;
		
		List<RoletotemDetail> roletotemDetailList=new ArrayList<RoletotemDetail>();
		//int num = Integer.valueOf(String.valueOf(param.get("num")));
		Object num=param.get("num");
		Object roleid = param.get("roleid");
		Object totemid = param.get("totemid");
		Object type = param.get("type");
		Object level = param.get("level");
		Object equiptotem = param.get("equiptotem");
		int roleid2=0;
		int totemid2=0;
		int type2=0;
		int level2=0;
		
		try {
			
			if(null!=roleid){
				roleid2=Integer.valueOf(String.valueOf(roleid));
			}
			if(null!=totemid){
				totemid2=Integer.valueOf(String.valueOf(totemid));
			}
			if(null!=type){
				type2=Integer.valueOf(String.valueOf(type));
			}
			if(null!=level){
				level2=Integer.valueOf(String.valueOf(level));
			}
			
			List<RoletotemDetail> list = new ArrayList<RoletotemDetail>();
			Iterator it = gameRoletotmes.keySet().iterator();
			RoletotemDetail roletotemDetail=new RoletotemDetail();
			while(it.hasNext()){
				Integer i = Integer.valueOf(it.next().toString());
				//RoletotemDetail roletotemDetail = gameRoletotmes.get(i);
				//RoletotemDetail roletotemDetail = (RoletotemDetail) gameRoletotmes.get(i).clone();
				roletotemDetail = (RoletotemDetail) gameRoletotmes.get(i).clone();
				if(roletotemDetail.getRoleid() == (roleid2==0 ? (roletotemDetail.getRoleid()) :roleid2 )
				&& roletotemDetail.getTotemid() == (totemid2==0 ? roletotemDetail.getTotemid() :totemid2 )
				&& roletotemDetail.getType() == (type2==0 ? roletotemDetail.getTotemid() : type2)
	            && roletotemDetail.getLevel() == (level2==0 ? roletotemDetail.getLevel() :level2 )){
					//RoletotemDetail roletotemDetail1 = new RoletotemDetail(); 
					//roletotemDetail1 = (RoletotemDetail)roletotemDetail.clone();
					//roletotemDetail = roletotemDetail1;
//					list.add(roletotemDetail1);
//					roletotemDetail1=null;
	//				System.out.println("原来的总数量：："+roletotemDetail.getNum());
					if(null!=equiptotem){
						roletotemDetail.setEquiptotem(0);
						//System.out.println("玩家褪下图腾：：：");
					}
					if(null!=num){
						roletotemDetail.setNum(roletotemDetail.getNum()+Integer.valueOf(String.valueOf(param.get("num"))));
					}
					//roletotemDetail.setNum(roletotemDetail.getNum()+num);
					gameRoletotmes.put(roletotemDetail.getId(), roletotemDetail);
					RoletotemDetail roletotemDetail2=(RoletotemDetail) roletotemDetail.clone();
	//				System.out.println("加后的总数量：："+roletotemDetail.getNum());
					roletotemDetail2.setIsUpdate(1);
					gameRoletotmeQueue.enqueue(roletotemDetail2);
					break;
				}
			}
//			for(int i = 0; i < list.size(); i++){
//				RoletotemDetail roletotemDetail = list.get(i); 
//				System.out.println("加图腾："+"原数量："+roletotemDetail.getNum()+"要加的数量："+num);
//				gameRoletotmes.remove(roletotemDetail.getId());
//				roletotemDetail.setNum(roletotemDetail.getNum()+num);
//				System.out.println("加后的总数量：："+roletotemDetail.getNum());
//				
//				gameRoletotmes.put(roletotemDetail.getId(), roletotemDetail);
//				roletotemDetail.setIsUpdate(1);
//				gameRoletotmeQueue.enqueue(roletotemDetail);
//			}
			b=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
		
	}
	public boolean delRoletotem(Map<String, Object> param) {
		// TODO Auto-generated method stub
		boolean b=false;
		
		List<RoletotemDetail> roletotemDetailList=new ArrayList<RoletotemDetail>();
	
		int roleid = Integer.valueOf(String.valueOf(param.get("roleid")));
		int type = Integer.valueOf(String.valueOf(param.get("type")));
		int level = Integer.valueOf(String.valueOf(param.get("level")));
		try {
			List<RoletotemDetail> list = new ArrayList<RoletotemDetail>();
			Iterator it = gameRoletotmes.keySet().iterator();
			while(it.hasNext()){
				Integer i = Integer.valueOf(it.next().toString());
				RoletotemDetail roletotemDetail = gameRoletotmes.get(i);
				if(roletotemDetail.getRoleid() == roleid
				&& roletotemDetail.getType() == type
	            && roletotemDetail.getLevel() == level){
					//RoletotemDetail roletotemDetail1 = new RoletotemDetail(); 
					RoletotemDetail roletotemDetail1 = (RoletotemDetail)roletotemDetail.clone();
					roletotemDetail1.setFlag(0);
					gameRoletotmes.put(roletotemDetail1.getId(), roletotemDetail1);
					RoletotemDetail roletotemDetail2=(RoletotemDetail) roletotemDetail.clone();
					roletotemDetail2.setIsUpdate(3);
			        gameRoletotmeQueue.enqueue(roletotemDetail2);
					//roletotemDetail = roletotemDetail1;
//					list.add(roletotemDetail1);
//					roletotemDetail1=null;
					break;
				}
			}
//			for(int i = 0; i < list.size(); i++){
//				RoletotemDetail roletotemDetail =list.get(i); 
//				//gameRoletotmes.remove(roletotemDetail.getId());
//				roletotemDetail.setFlag(0);
//				gameRoletotmes.put(roletotemDetail.getId(), roletotemDetail);
//				//gameRoletotmes.get(roletotemDetail.getId()).setFlag(0);
//				RoletotemDetail roletotemDetail2=(RoletotemDetail) roletotemDetail.clone();
//				roletotemDetail2.setIsUpdate(3);
//				gameRoletotmeQueue.enqueue(roletotemDetail2);
//			}
			b=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
		
	}
	public List<RoletotemDetail> getRoletotem(Map<String, Object> param) {
		// TODO Auto-generated method stub
		List<RoletotemDetail> roletotemDetailList=new ArrayList<RoletotemDetail>();
		int roleid = Integer.valueOf(String.valueOf(param.get("roleid")));
		Object totemid = param.get("totemid");
		Object type = param.get("type");
		Object level = param.get("level");
		
		int totemid2=0;
		int type2=0;
		int level2=0;
		  if(null!=totemid){
			  totemid2=Integer.valueOf(String.valueOf(totemid));
		  }
			if(null!=type){
				type2=Integer.valueOf(String.valueOf(type));
			}
			if(null!=level){
				level2=Integer.valueOf(String.valueOf(level));
			}
			
		
		Iterator it = gameRoletotmes.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			RoletotemDetail roletotemDetail = gameRoletotmes.get(i);
			if(roletotemDetail.getRoleid()==roleid){
				if(roletotemDetail.getFlag()==1
					&&roletotemDetail.getTotemid() == (totemid2==0 ? roletotemDetail.getTotemid() :totemid2 )
			      && roletotemDetail.getType() == (type2==0 ? roletotemDetail.getType() : type2)
			      && roletotemDetail.getLevel() == (level2==0 ? roletotemDetail.getLevel() :level2 )){
							roletotemDetailList.add(roletotemDetail);
							//System.out.println("执行================");
						//	break;
						}
			}
		}
//		System.out.println("查询图腾roleid:"+roleid+"   cacheRoletotemDetails.size"+gameRoletotmes.size()+"    roletotemDetailList.size"+roletotemDetailList.size());
		return roletotemDetailList;
	}
	public void update(RoletotemDetail roletotemDetaill) {
		try{
			RoletotemDetail roletotemDetail = roletotemDetaill;
			gameRoletotmes.put(roletotemDetail.getId(), roletotemDetail);
			RoletotemDetail roletotemDetail2=roletotemDetail;
			roletotemDetail2.setIsUpdate(1);
			gameRoletotmeQueue.enqueue(roletotemDetail2);
		}catch(Exception e){
			e.printStackTrace();
		}
			
	}
	
}
