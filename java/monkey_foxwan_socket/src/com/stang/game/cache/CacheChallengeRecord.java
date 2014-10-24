package com.stang.game.cache;

import com.stang.game.entity.detail.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheChallengeRecord {
	//缓存类操作的缓存对象(key:id, value:ChallengeRecordDetail)
	private static Map<Integer, ChallengeRecordDetail> challengeRecords = null;
	//变动过的对象组成的队列，由于自动同步数据库
	public static QueueCache challengeRecordQueue = null;
	//静态类同步数据库线程
	public static ThreadCache thread = null;
	//id 的最大值
	public static int index = 0;
	//静态初始化方法
	public CacheChallengeRecord(){
		if(thread == null){
			thread = new ThreadCache("challengeRecord");
			thread.start();
		}
		if(challengeRecords == null)
			challengeRecords = GlobalDatat.cacheChallengeRecordDetails;
		if(challengeRecordQueue == null)
			challengeRecordQueue = new QueueCache("challengeRecord");
		if(index == 0){
			Iterator it = challengeRecords.keySet().iterator();
			while(it.hasNext()){
				Integer i = Integer.valueOf(it.next().toString());
				if(i > index)
					index = i;
			}
		}
	}
	//插入新的记录
	public boolean insertChallengerecord(Map<String, Object> param){
		boolean b = false;
		try{
			Object hitid = param.get("hitid");
			Object beihitid = param.get("beihitid");
			Object time = param.get("time");
			Object record = param.get("record");
			Object mids = param.get("mids");
			Object hitmids = param.get("hitmids");
			Object hitname = param.get("hitname");
			Object beihitname = param.get("beihitname");
			Object winid = param.get("winid");
			Object hitrate = param.get("hitrate");
			Object beihitrate = param.get("beihitrate");
			Object hittoux = param.get("hittoux");
			Object hitlevel = param.get("hitlevel");
			Object beihitlevel = param.get("beihitlevel");
			Object totem = param.get("totem");
			Object totemtwo = param.get("totemtwo");
			ChallengeRecordDetail challengeRecord = new ChallengeRecordDetail();
			if(null!=totemtwo)
				challengeRecord.setTotemtwo(String.valueOf(totemtwo));
			if(null!=totem)
				challengeRecord.setTotem(String.valueOf(totem));
			if(null != hitid)
				challengeRecord.setHitid(Integer.valueOf(String.valueOf(hitid)));
			if(null != beihitid)
			challengeRecord.setBeihitid(Integer.valueOf(String.valueOf(beihitid)));
			if(null != time)
			challengeRecord.setTime(String.valueOf(time));
			if(null != record)
			challengeRecord.setRecord(String.valueOf(record));
			if(null != mids)
			challengeRecord.setMids(String.valueOf(mids));
			if(null != hitmids)
			challengeRecord.setHitmids(String.valueOf(hitmids));
			if(null != hitname)
			challengeRecord.setHitname(String.valueOf(hitname));
			if(null != beihitname)
			challengeRecord.setBeihitname(String.valueOf(beihitname));
			if(null != winid)
			challengeRecord.setWinid(Integer.valueOf(String.valueOf(winid)));
			if(null != hitrate)
			challengeRecord.setHitrate(Integer.valueOf(String.valueOf(hitrate)));
			if(null != beihitrate)
			challengeRecord.setBeihitrate(Integer.valueOf(String.valueOf(beihitrate)));
			if(null != hittoux)
			challengeRecord.setHittoux(String.valueOf(hittoux));
			if(null != hitlevel)
			challengeRecord.setHitlevel(Integer.valueOf(String.valueOf(hitlevel)));
			if(null != beihitlevel)
			challengeRecord.setBeihitlevel(Integer.valueOf(String.valueOf(beihitlevel)));
			index = index + 1;
			challengeRecord.setId(index);
			//System.out.println("CacheChallengerRecord执行了插入操作，新数据的id：" + index);
			//插入缓存
			challengeRecords.put(index, challengeRecord);
			//插入队列
			challengeRecord.setIsUpdate(2);
			challengeRecordQueue.enqueue(challengeRecord);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//得到被打（挑战）记录
	public List<ChallengeRecordDetail> findallchallenge(Map<String, Object> param){
		int beihitid = Integer.valueOf(String.valueOf(param.get("beihitid")));
		List<ChallengeRecordDetail> list = new ArrayList<ChallengeRecordDetail>();
		Iterator it = challengeRecords.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			ChallengeRecordDetail challengeRecord = challengeRecords.get(i);
			if(challengeRecord.getBeihitid() == beihitid){
				list.add(challengeRecord);
			}
		}
		Collections.sort(list, new Comparator<ChallengeRecordDetail>(){
					            public int compare(ChallengeRecordDetail arg0, ChallengeRecordDetail arg1) {
					            	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					            	Long t1 = null;
					            	Long t2 = null;
					            	try{
					            		t1 = Long.valueOf(sdf.parse(arg0.getTime()).getTime());
						            	t2 = Long.valueOf(sdf.parse(arg1.getTime()).getTime());
					            	}catch(Exception e){
					            		e.printStackTrace();
					            	}
					                return t1.compareTo(t2);
					            }
				        });
		return list;
	}
	//更新挑战记录
	public boolean updateChallenge(Map<String, Object> param){
		boolean b = false;
		try{
			Object hitid = param.get("hitid");
			Object beihitid = param.get("beihitid");
			Object time = param.get("time");
			Object record = param.get("record");
			Object mids = param.get("mids");
			Object hitmids = param.get("hitmids");
			Object hitname = param.get("hitname");
			Object beihitname = param.get("beihitname");
			Object winid = param.get("winid");
			Object hitrate = param.get("hitrate");
			Object beihitrate = param.get("beihitrate");
			Object hittoux = param.get("hittoux");
			Object beihittoux = param.get("beihittoux");
			Object hitlevel = param.get("hitlevel");
			Object beihitlevel = param.get("beihitlevel");
			Object id = param.get("id");
			ChallengeRecordDetail challengeRecord = null;
			try{
				challengeRecord = (ChallengeRecordDetail)challengeRecords.get(Integer.valueOf(String.valueOf(id))).clone();
			}catch(Exception e){
				e.printStackTrace();
			}
			Object totem = param.get("totem");
			Object totemtwo = param.get("totemtwo");
			if(null!=totemtwo)
				challengeRecord.setTotemtwo(String.valueOf(totemtwo));
			if(null!=totem)
				challengeRecord.setTotem(String.valueOf(totem));
			if(null != hitid)
				challengeRecord.setHitid(Integer.valueOf(String.valueOf(hitid)));
			if(null != beihitid)
				challengeRecord.setBeihitid(Integer.valueOf(String.valueOf(beihitid)));
			if(null != time)
				challengeRecord.setTime(String.valueOf(time));
			if(null != record)
				challengeRecord.setRecord(String.valueOf(record));
			if(null != mids)
				challengeRecord.setMids(String.valueOf(mids));
			if(null != hitmids)
				challengeRecord.setHitmids(String.valueOf(hitmids));
			if(null != hitname)
				challengeRecord.setHitname(String.valueOf(hitname));
			if(null != beihitname)
				challengeRecord.setBeihitname(String.valueOf(beihitname));
			if(null != winid)
				challengeRecord.setWinid(Integer.valueOf(String.valueOf(winid)));
			if(null != hitrate)
				challengeRecord.setHitrate(Integer.valueOf(String.valueOf(hitrate)));
			if(null != beihitrate)
				challengeRecord.setBeihitrate(Integer.valueOf(String.valueOf(beihitrate)));
			if(null != hittoux)
				challengeRecord.setHittoux(String.valueOf(hittoux));
			if(null != beihittoux)
				challengeRecord.setBeihittoux(String.valueOf(beihittoux));
			if(null != hitlevel)
				challengeRecord.setHitlevel(Integer.valueOf(String.valueOf(hitlevel)));
			if(null != beihitlevel)
				challengeRecord.setBeihitlevel(Integer.valueOf(String.valueOf(beihitlevel)));
			//更新缓存
			//challengeRecords.remove(Integer.valueOf(String.valueOf(id)));
			challengeRecords.put(Integer.valueOf(String.valueOf(id)), challengeRecord);
			//更新队列
			challengeRecord.setIsUpdate(1);
			challengeRecordQueue.enqueue(challengeRecord);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
				return b;
	}
	//得到被打（挑战）记录2
	public List<ChallengeRecordDetail> findallchallengetwo(Map<String, Object> param){
		int beihitid = Integer.valueOf(String.valueOf(param.get("beihitid")));
		int hitid = Integer.valueOf(String.valueOf(param.get("hitid")));
		List<ChallengeRecordDetail> list = new ArrayList<ChallengeRecordDetail>();
		Iterator it = challengeRecords.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			ChallengeRecordDetail challengeRecord = challengeRecords.get(i);
			if(challengeRecord.getBeihitid() == beihitid && challengeRecord.getHitid() == hitid){
				list.add(challengeRecord);
			}
		}
		Collections.sort(list, new Comparator<ChallengeRecordDetail>(){
					            public int compare(ChallengeRecordDetail arg0, ChallengeRecordDetail arg1) {
					            	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					            	Long t1 = null;
					            	Long t2 = null;
					            	try{
					            		t1 = Long.valueOf(sdf.parse(arg0.getTime()).getTime());
						            	t2 = Long.valueOf(sdf.parse(arg1.getTime()).getTime());
					            	}catch(Exception e){
					            		e.printStackTrace();
					            	}
					                return t1.compareTo(t2);
					            }
				        });
		return list;
	}
	//批量插入新的记录
	public boolean insertChallengerecords(List<ChallengeRecordDetail> challengerecords){
		boolean b = false;
		try{
			for(int i = 0; i < challengerecords.size(); i++){
				ChallengeRecordDetail challengeRecord = new ChallengeRecordDetail();
				try{
					challengeRecord = (ChallengeRecordDetail)challengerecords.get(i).clone();
				}catch(Exception e){
					e.printStackTrace();
				}
				index = index + 1;
				challengeRecord.setId(index);
			//	System.out.println("CacheChallengerRecord执行了插入操作，新数据的id：" + index);
				//插入缓存
				challengeRecords.put(index, challengeRecord);
				//插入队列
				challengeRecord.setIsUpdate(2);
				challengeRecordQueue.enqueue(challengeRecord);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//得到被打（挑战）记录id
	public List<ChallengeRecordDetail> findallchallengeId(Map<String, Object> param){
		int beihitid = Integer.valueOf(String.valueOf(param.get("beihitid")));
		List<ChallengeRecordDetail> list = new ArrayList<ChallengeRecordDetail>();
		Iterator it = challengeRecords.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			ChallengeRecordDetail challengeRecord = new ChallengeRecordDetail();
			try{
				challengeRecord = (ChallengeRecordDetail)challengeRecords.get(i).clone();
			}catch(Exception e){
				e.printStackTrace();
			}
			if(challengeRecord.getBeihitid() == beihitid){
				list.add(challengeRecord);
			}
		}
		Collections.sort(list, new Comparator<ChallengeRecordDetail>(){
					            public int compare(ChallengeRecordDetail arg0, ChallengeRecordDetail arg1) {
					            	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					            	Long t1 = null;
					            	Long t2 = null;
					            	try{
					            		t1 = Long.valueOf(sdf.parse(arg0.getTime()).getTime());
						            	t2 = Long.valueOf(sdf.parse(arg1.getTime()).getTime());
					            	}catch(Exception e){
					            		e.printStackTrace();
					            	}
					                return t1.compareTo(t2);
					            }
				        });
		return list;
	}
}
