package buyapi;

import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import com.stang.game.entity.detail.GameRoleDetail;

/**
 * 队列模型类
 * @author Laven Wang
 *
 */
public class QueueCache {
	 //字段
	 private LinkedList list;
	 public Map<Integer, Object> indexMap;
	 private String name;
	 //无参数构造
	 public QueueCache(String name){
		  list=new LinkedList();
		  this.name = name;
		  indexMap = new HashMap<Integer, Object>();
	 }
	 public QueueCache(){
		  list=new LinkedList();
		  indexMap = new HashMap<Integer, Object>();
	}
	 //队列元素的个数
	 public int size(){
		 return list.size();
	 }
	 //进入队列
	 public void enqueue(Object obj){
		 if(null != this.name){
			 if(this.name.equals("roleQuicktime")){
			 }	
		 }
		 list.addLast(obj); 
	 }
	 //置换头元素
	 public void nextHeader(){
		 Object obj = new Object();
		 int i = 0;
		 Object o = list.set(0, i);
		 o = obj;
	 }
	 //清空队列
	 public void clear(){
		 list.clear();
	 }
	//对头出来
	 public Object dequeue(){
		 if(null != this.name){
			 if(this.name.equals("roleQuicktime")){
			 }
		 }
	  return list.removeFirst();
	 }
	 //浏览对头元素
	 public Object front(){
	  return list.peekFirst();
	 }
	 //判断队列是否为空
	 public boolean isEmpty(){
	  return list.isEmpty();
	 }

	 public static void main(String[] args) {
	  try{
		  QueueCache llq=new QueueCache("test");
		 // System.out.println(llq.isEmpty());
		  GameRoleDetail role = new GameRoleDetail();
		  role.setId(34);
		//  System.out.println("role.id:" + role.getId());
		  String str = "laven";
		  llq.enqueue("147");
		  llq.nextHeader();
		  llq.enqueue(role);
		  llq.enqueue(str);
		  llq.enqueue("258");
		  llq.enqueue("369");
		  //System.out.println(llq.size());
		  System.out.println("移除队列头元素："+llq.dequeue());
		  str = "laavveenn";
		  System.out.println(llq.front().toString());
		  System.out.println(llq.size());
		  llq.enqueue("abc");
		  llq.enqueue("def");
		  System.out.println(llq.size());
		  str = null;
		  System.out.println("查看队列的头元素："+((GameRoleDetail)llq.front()).getId());
		  System.out.println(llq.size());
		  System.out.println(llq.isEmpty());
		  llq.list.clear();
		  System.out.println(llq.isEmpty());
		  System.out.println(role.getId());

	  }catch(Exception e){
		  e.printStackTrace();
	  }
	  
	 }

	
	
	
	

}
