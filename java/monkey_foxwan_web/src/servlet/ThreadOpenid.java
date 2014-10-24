package servlet;

import com.stang.game.ffd.client.Client;
import com.stang.game.ffd.client.ClientManager;
import com.stang.game.util.*;
import com.stang.game.service.impl.BaseServiceImpl;
import com.stang.game.dao.*;
import com.stang.game.dao.IGamblingItemDao;
import com.stang.game.dao.impl.*;

import dbconn.DBConnectionManager;
import flex.messaging.io.ArrayList;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;
import net.sf.json.JSONArray;

public class ThreadOpenid extends Thread{
	private static PrintWriter log;
	public ThreadOpenid(){}
	public ThreadOpenid(String name){
		this.setName(name);
	}
	public void run(){
		String logFile = "ThreadOpenid.txt";
		try {
			log = new PrintWriter(new FileWriter(logFile, true), true);
		} catch (IOException e) {
			System.err.println("无法打开日志文件：" + logFile);
			log = new PrintWriter(System.err);
		}
		log("==============================================THREADOPENID DEBUG BEGAIN!=================================================================");
		String name = this.getName();
		boolean bo = false;
			System.out.println("同步线程启动！" + this.getName());
			log("同步线程启动！" + this.getName());
			int time = 2000;
			int l = null == Loadingtohomejsp.openidQueue? 0:Loadingtohomejsp.openidQueue.size();
			for(int i = 0; i <= l; ){
				try{
					if(l > 0){
						//队列有内容
						String openid = (String)Loadingtohomejsp.openidQueue.front();
						if(null != openid){
							String memberUsername = openid;
							DBConnectionManager dbp = DBConnectionManager.getInstance();
							Connection co = dbp.getConnection("server");
							Statement st = null;
							int id = 0;
							int serverid = 0;
							ArrayList list = new ArrayList();
							try {
								st = co.createStatement();
								ResultSet rs = st.executeQuery("select id, serverid from member where member_username = '"+memberUsername+ "'");
								while(rs.next()){
									id = rs.getInt(1);
									serverid = rs.getInt(2);
									Map<String, Integer> map = new HashMap<String, Integer>();
									map.put("roleid", id);
									map.put("serverid", serverid);
									list.add(map);
								}
								co.close();
								st.close();
							} catch (Exception e) {
								e.printStackTrace();
							}
							log("list.size:" + list.size());
							for(int j = 0; j < list.size(); j++){
								try{
									log("roleid:" + ((HashMap<String, Integer>)list.get(j)).get("roleid") + "   serverid:" + ((HashMap<String, Integer>)list.get(i)).get("serverid"));
									int serverdid = ((HashMap<String, Integer>)list.get(j)).get("serverid");
									int roledid = ((HashMap<String, Integer>)list.get(j)).get("roleid");
									HashMap<String, Object> papa = new HashMap<String, Object>();
									HashMap<String, Object> infoMap=new HashMap<String, Object>();
									papa.put("roleid", roledid);
									infoMap.put("_guid", 0);
									infoMap.put("_cachekey", "noCachekey");
									infoMap.put("_sig", "robot");
									infoMap.put("_serverId", 1);
									infoMap.put("_pid", 1);
									infoMap.put("_cmd", "match.deskcheck");
									infoMap.put("_params", papa);
									infoMap.put("_key1", "1");
									infoMap.put("_key2", "0000");
									infoMap.put("_key3", "12");
									infoMap.put("_key3tang", "12");
									ClientManager cm = ClientManager.getInstance();
									cm.getClient(serverdid).smcHander.sendData(infoMap);
								}catch(Exception e){
									log("list for xun huan exception!" );
									e.printStackTrace();
								}
							}
							Loadingtohomejsp.openidQueue.dequeue();
						}
					}else{
						//队列为空，一秒钟一次的定时器检测SendQueue
						try{
							if(bo){
								bo = false;
								//System.out.println(this.getName() + "队列内无内容：" + l + "进入休眠时间：" + time);
								log(this.getName() + "队列内无内容：" + l + "进入休眠时间：" + time);
							}
							this.sleep(time);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
						if(Loadingtohomejsp.openidQueue == null){
							l=0;
						}else{
							l = Loadingtohomejsp.openidQueue.size();
						}
						
						if(l != 0){
							bo = true;
							//System.out.println(this.getName() + "得到的队列长度：" + l);
							log(this.getName() + "得到的队列长度：" + l);
						}		
					}
				}catch(Exception e){
					e.printStackTrace();
					try {
						this.sleep(time);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(Loadingtohomejsp.openidQueue == null){
					l=0;
				}else{
					l = Loadingtohomejsp.openidQueue.size();
				}
			}
		
	}
void sendApi(String payitem,int id,Client client){
		
		HashMap<String, Object> papa = new HashMap<String, Object>();
		HashMap<String, Object> infoMap=new HashMap<String, Object>();
		papa.put("payitem", payitem);
		infoMap.put("_guid", 0);
		infoMap.put("_cachekey", "noCachekey");
		infoMap.put("_sig", "robot");
		infoMap.put("_serverId", 1);
		infoMap.put("_pid", id);
		infoMap.put("_cmd", "mil.buyItems");
		infoMap.put("_params", papa);
		infoMap.put("_key1", "1");
		infoMap.put("_key2", "0000");
		infoMap.put("_key3", "12");
		infoMap.put("_key3tang", "12");
		client.smcHander.sendData(infoMap);
		papa=null;
		infoMap=null;
	}
	

	void updateRoleItemNum(int num,int rid, int itemid,Client client){
		
		
		HashMap<String, Object> papa = new HashMap<String, Object>();
		HashMap<String, Object> infoMap=new HashMap<String, Object>();
		papa.put("rid", rid);
		papa.put("num", num);
		papa.put("itemid", itemid);
		infoMap.put("_guid", 0);
		infoMap.put("_cachekey", "noCachekey");
		infoMap.put("_sig", "robot");
		infoMap.put("_serverId", 1);
		infoMap.put("_pid", rid);
		infoMap.put("_cmd", "sys.insertRoleItem");
		infoMap.put("_params", papa);
		infoMap.put("_key1", "1");
		infoMap.put("_key2", "0000");
		infoMap.put("_key3", "12");
		infoMap.put("_key3tang", "12");
		client.smcHander.sendData(infoMap);
		papa=null;
		infoMap=null;
	}
	
	void updateGameRoleCoinAndCoinspend(int coin,int coinspend, int rid,Client client){
		
		HashMap<String, Object> papa = new HashMap<String, Object>();
		HashMap<String, Object> infoMap=new HashMap<String, Object>();
		papa.put("rid", rid);
		papa.put("coin", coin);
		papa.put("coinspend", coinspend);
		infoMap.put("_guid", 0);
		infoMap.put("_cachekey", "noCachekey");
		infoMap.put("_sig", "robot");
		infoMap.put("_serverId", 1);
		infoMap.put("_pid", rid);
		infoMap.put("_cmd", "sys.udpateGameRoleCoinAndCoinspend");
		infoMap.put("_params", papa);
		infoMap.put("_key1", "1");
		infoMap.put("_key2", "0000");
		infoMap.put("_key3", "12");
		infoMap.put("_key3tang", "12");
		client.smcHander.sendData(infoMap);
		papa=null;
		infoMap=null;
	}
	
	void updateGameRoleCoinspend(int coinspend, int rid,Client client){
		
		HashMap<String, Object> papa = new HashMap<String, Object>();
		HashMap<String, Object> infoMap=new HashMap<String, Object>();
		papa.put("rid", rid);
		papa.put("coinspend", coinspend);
		infoMap.put("_guid", 0);
		infoMap.put("_cachekey", "noCachekey");
		infoMap.put("_sig", "robot");
		infoMap.put("_serverId", 1);
		infoMap.put("_pid", rid);
		infoMap.put("_cmd", "sys.udpateGameRoleCoinAndCoinspend");
		infoMap.put("_params", papa);
		infoMap.put("_key1", "1");
		infoMap.put("_key2", "0000");
		infoMap.put("_key3", "12");
		infoMap.put("_key3tang", "12");
		client.smcHander.sendData(infoMap);
		papa=null;
		infoMap=null;
	}
	
	void insertRoleItem(long id, int rid, int itemid, int num, int type,Client client){
		
		HashMap<String, Object> papa = new HashMap<String, Object>();
		HashMap<String, Object> infoMap=new HashMap<String, Object>();
		papa.put("rid", rid);
		papa.put("id", id);
		papa.put("itemid", itemid);
		papa.put("num", num);
		papa.put("type", type);
		infoMap.put("_guid", 0);
		infoMap.put("_cachekey", "noCachekey");
		infoMap.put("_sig", "robot");
		infoMap.put("_serverId", 1);
		infoMap.put("_pid", rid);
		infoMap.put("_cmd", "sys.insertRoleItem");
		infoMap.put("_params", papa);
		infoMap.put("_key1", "1");
		infoMap.put("_key2", "0000");
		infoMap.put("_key3", "12");
		infoMap.put("_key3tang", "12");
		client.smcHander.sendData(infoMap);
		papa=null;
		infoMap=null;
	}
	
	void updateGameRoleBylevel(String bylevel, int rid,Client client){
		
		HashMap<String, Object> papa = new HashMap<String, Object>();
		HashMap<String, Object> infoMap=new HashMap<String, Object>();
		papa.put("rid", rid);
		papa.put("bylevel", bylevel);
		infoMap.put("_guid", 0);
		infoMap.put("_cachekey", "noCachekey");
		infoMap.put("_sig", "robot");
		infoMap.put("_serverId", 1);
		infoMap.put("_pid", rid);
		infoMap.put("_cmd", "sys.updateGameRoleBylevel");
		infoMap.put("_params", papa);
		infoMap.put("_key1", "1");
		infoMap.put("_key2", "0000");
		infoMap.put("_key3", "12");
		infoMap.put("_key3tang", "12");
		client.smcHander.sendData(infoMap);
		papa=null;
		infoMap=null;
	}
	public static void log(String msg) {
		log.println(new Date() + ":" + msg);
	}
}
