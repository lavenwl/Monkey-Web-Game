package com.stang.game.cache;

import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import com.stang.game.entity.detail.GameRoleDetail;
import com.stang.game.common.*;

/**
 * 队列模型类
 * @author Laven Wang
 *
 */
public class QueueCache {
	 //字段
	 private LinkedList list;
	 public Map<Integer, Object> indexMap;
	 public Map<Long, Object> indexMapl;
	 private String name;
	 public static int updateFlag;//判断存储过程是否在执行，避免数据库死锁。
	 //无参数构造
	 public QueueCache(String name){
	  list=new LinkedList();
	  this.name = name;
	  indexMap = new HashMap<Integer, Object>();
	  indexMapl = new HashMap<Long, Object>();
	  updateFlag = 1;
	 }
	 public QueueCache(){
		  list=new LinkedList();
		  indexMap = new HashMap<Integer, Object>();
		  indexMapl = new HashMap<Long, Object>();
		 }
	 //队列元素的个数
	 public int size(){
	  return list.size();
	 }
	 
	 //进入队列
	 public void enqueue(Object obj){
		 if(null != this.name){
			 if(this.name.equals("roleQuicktime")){
//				 System.out.println("________________________________enqueue___________________________________" + this.name + size());
			 }	
		 }
		 
		 list.addLast(obj); 
	 }
	 //置换头元素
	 public void nextHeader(){
		 Object obj = new Object();
		 System.out.println("obj___:" + obj);
		 int i = 0;
		 Object o = list.set(0, i);
		 System.out.println("o_____:" + o);
		 o = obj;
	 }
	 //清空队列
	 public void clear(){
		 if(size() != 0){
			 GameConstants.log.warn(name + "	******QUEUE CLEAR FUNCTION******	last size:"+ size());
		 }
		 //System.out.println(name + "	******QUEUE CLEAR FUNCTION******	last size:"+ size());
		 list.clear();
		 indexMap.clear();
		 indexMapl.clear();
	 }
	 
	//对头出来
	 public Object dequeue(){
		 if(null != this.name){
			 if(this.name.equals("roleQuicktime")){
				// System.out.println("________________________________dequeue___________________________________" + this.name + size());
			 }
		 }
		 
	  return list.removeFirst();
	 }
	 
	 //浏览对头元素
	 public Object front(){
	  //return list.getFirst();
	  return list.peekFirst();
	 }

	 //判断队列是否为空
	 public boolean isEmpty(){
	  return list.isEmpty();
	 }

	/**
	  * @param args
	  */
	 public static void main(String[] args) {
	  // TODO Auto-generated method stub
	  try{
		  QueueCache llq=new QueueCache("test");
		  System.out.println(llq.isEmpty());
//		  llq.enqueue("147");
//		  for(int i = 0; i < 10; i++){
//			
//			  llq.enqueue("258");
////			  llq.enqueue("369");
//			  System.out.println("移除队列头元素："+llq.dequeue());
//			  System.out.println(llq.size());
//			    
//		  }
		  GameRoleDetail role = new GameRoleDetail();
		  role.setId(34);
		  System.out.println("role.id:" + role.getId());
		  String str = "laven";
		  llq.enqueue("147");
		  llq.nextHeader();
		  
		  llq.enqueue(role);
		  llq.enqueue(str);
		  llq.enqueue("258");
		  llq.enqueue("369");
		  System.out.println(llq.size());
		  System.out.println("移除队列头元素："+llq.dequeue());
		  str = "laavveenn";
		  System.out.println(llq.front().toString());
		  System.out.println(llq.size());
		  llq.enqueue("abc");
		  llq.enqueue("def");
		  System.out.println(llq.size());
		  str = null;
		 // role = null;
		  
		  //role.setId(43);
		  System.out.println("查看队列的头元素："+((GameRoleDetail)llq.front()).getId());
		  System.out.println(llq.size());
		  System.out.println(llq.isEmpty());
		  llq.list.clear();
		  System.out.println(llq.isEmpty());
		  System.out.println(role.getId());
		 // System.out.println(llq.list.);

	  }catch(Exception e){
		  e.printStackTrace();
	  }
	  
	 }

	
	
	
	

}
