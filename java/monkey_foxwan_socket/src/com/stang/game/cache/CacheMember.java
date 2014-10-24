package com.stang.game.cache;

import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheMember {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<Integer, MemberDetail> members = null;
	//变动过的对象组成的队列，由于自动同步数据库
	public static QueueCache memberQueue = null;
	//静态类同步数据库线程
	public static ThreadCache thread = null;
	//静态初始化方法
	public CacheMember(){
		if(thread == null){
			thread = new ThreadCache("member");
			thread.start();
		}
		if(members == null)
			members = GlobalDatat.cacheMemberDetails;
		if(memberQueue == null)
			memberQueue = new QueueCache();
	}
	public List<MemberDetail> findMemberByOpenid(String openid) {
		List<MemberDetail> memberList = new ArrayList<MemberDetail>();
		
		Iterator it = members.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			MemberDetail md = members.get(i);
			if(md.getUsername().equals(openid)){
				memberList.add(md);
				break;
			}
		}
		return memberList;
	}
	public boolean insertMember(MemberDetail model1) {
		boolean b = false;
		try{
			MemberDetail model = new MemberDetail();
			try{
				model = (MemberDetail)model1.clone();
			}catch(Exception e){
				e.printStackTrace();
			}
			members.put(model.getId(), model);
//			model.setIsUpdate(2);
//			memberQueue.enqueue(model);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	public List<MemberDetail> findMemberByid(int id) {
		List<MemberDetail> memberList = new ArrayList<MemberDetail>();
		
		Iterator it = members.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			MemberDetail md = members.get(i);
			if(md.getId()==id){
				memberList.add(md);
				break;
			}
		}
		return memberList;
	}
	
}
