package apiinterface;

import com.stang.game.entity.detail.*;
import com.stang.game.ffd.client.Client;
import com.stang.game.ffd.client.ClientManager;
import com.stang.game.util.*;
import com.stang.game.service.impl.BaseServiceImpl;
import com.stang.game.dao.*;
import com.stang.game.dao.IGamblingItemDao;
import com.stang.game.dao.impl.*;

import dbconn.DBConnectionManager;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import net.sf.json.JSONArray;

public class ThreadShare extends Thread{
	private static PrintWriter log;
	public ThreadShare(){}
	public ThreadShare(String name){
		this.setName(name);
	}
	public void run(){
		String logFile = "ThreadShare.txt";
		try {
			log = new PrintWriter(new FileWriter(logFile, true), true);
		} catch (IOException e) {
			System.err.println("无法打开日志文件：" + logFile);
			log = new PrintWriter(System.err);
		}
		log("==============================================THREADSHARE DEBUG BEGAIN!=================================================================");
		String name = this.getName();
		boolean bo = true;
		//	System.out.println("同步线程启动！" + this.getName());
			log("同步线程启动！" + this.getName());
			int time = 1000;
			int l = null == Share.shareBeanQueue? 0:Share.shareBeanQueue.size();
			for(int i = 0; i <= l; ){
				try{
					if(l > 0){
						//队列有内容
						ShareBean sb = (ShareBean)Share.shareBeanQueue.front();
						if(null != sb){
							
							int id = sb.getId();
							int serverId = sb.getServerId();
							int type = sb.getType();
							int num = 1;
							int num0 = sb.getNum0();
							log("id:" + id);
							log("serverId:" + serverId);
							log("type:" + type);
							ClientManager cm = ClientManager.getInstance();
							DBConnectionManager dbp = DBConnectionManager.getInstance();
							Connection co = dbp.getConnection("server" + serverId);
							
								
								for(int j = 0; j < 1; j++){
									if(type==0){//原来的分享
										HashMap<String, Object> papa = new HashMap<String, Object>();
										HashMap<String, Object> infoMap=new HashMap<String, Object>();
										papa.put("roleid", id);
										papa.put("share", num0);
										infoMap.put("_guid", 0);
										infoMap.put("_cachekey", "noCachekey");
										infoMap.put("_sig", "robot");
										infoMap.put("_serverId", 1);
										infoMap.put("_pid", 1);
										infoMap.put("_cmd", "sys.cacheGameRolethree");
										infoMap.put("_params", papa);
										infoMap.put("_key1", "1");
										infoMap.put("_key2", "0000");
										infoMap.put("_key3", "12");
										infoMap.put("_key3tang", "12");
										cm.getClient(serverId).smcHander.sendData(infoMap);
									}else if(type==1){//分享
										HashMap<String, Object> papa = new HashMap<String, Object>();
										HashMap<String, Object> infoMap=new HashMap<String, Object>();
										papa.put("roleid", id);
										papa.put("fdshare", num);
										infoMap.put("_guid", 0);
										infoMap.put("_cachekey", "noCachekey");
										infoMap.put("_sig", "robot");
										infoMap.put("_serverId", 1);
										infoMap.put("_pid", 1);
										infoMap.put("_cmd", "sys.cacheGameRolethree");
										infoMap.put("_params", papa);
										infoMap.put("_key1", "1");
										infoMap.put("_key2", "0000");
										infoMap.put("_key3", "12");
										infoMap.put("_key3tang", "12");
										cm.getClient(serverId).smcHander.sendData(infoMap);	
									}else if(type==2){//炫耀
										HashMap<String, Object> papa = new HashMap<String, Object>();
										HashMap<String, Object> infoMap=new HashMap<String, Object>();
										papa.put("roleid", id);
										papa.put("flaunt", num);
										infoMap.put("_guid", 0);
										infoMap.put("_cachekey", "noCachekey");
										infoMap.put("_sig", "robot");
										infoMap.put("_serverId", 1);
										infoMap.put("_pid", 1);
										infoMap.put("_cmd", "sys.cacheGameRolethree");
										infoMap.put("_params", papa);
										infoMap.put("_key1", "1");
										infoMap.put("_key2", "0000");
										infoMap.put("_key3", "12");
										infoMap.put("_key3tang", "12");
										cm.getClient(serverId).smcHander.sendData(infoMap);	
									}else if(type==3){//试玩
										HashMap<String, Object> papa = new HashMap<String, Object>();
										HashMap<String, Object> infoMap=new HashMap<String, Object>();
										papa.put("roleid", id);
										papa.put("sharedemo", num);
										infoMap.put("_guid", 0);
										infoMap.put("_cachekey", "noCachekey");
										infoMap.put("_sig", "robot");
										infoMap.put("_serverId", 1);
										infoMap.put("_pid", 1);
										infoMap.put("_cmd", "sys.cacheGameRolethree");
										infoMap.put("_params", papa);
										infoMap.put("_key1", "1");
										infoMap.put("_key2", "0000");
										infoMap.put("_key3", "12");
										infoMap.put("_key3tang", "12");
										cm.getClient(serverId).smcHander.sendData(infoMap);
									}else if(type==4){//挑战
										HashMap<String, Object> papa = new HashMap<String, Object>();
										HashMap<String, Object> infoMap=new HashMap<String, Object>();
										papa.put("roleid", id);
										papa.put("challenge", num);
										infoMap.put("_guid", 0);
										infoMap.put("_cachekey", "noCachekey");
										infoMap.put("_sig", "robot");
										infoMap.put("_serverId", 1);
										infoMap.put("_pid", 1);
										infoMap.put("_cmd", "sys.cacheGameRolethree");
										infoMap.put("_params", papa);
										infoMap.put("_key1", "1");
										infoMap.put("_key2", "0000");
										infoMap.put("_key3", "12");
										infoMap.put("_key3tang", "12");
										cm.getClient(serverId).smcHander.sendData(infoMap);
									}else if(type==5){//召唤老朋友
										HashMap<String, Object> papa = new HashMap<String, Object>();
										HashMap<String, Object> infoMap=new HashMap<String, Object>();
										papa.put("roleid", id);
										papa.put("oldfriend", num);
										infoMap.put("_guid", 0);
										infoMap.put("_cachekey", "noCachekey");
										infoMap.put("_sig", "robot");
										infoMap.put("_serverId", 1);
										infoMap.put("_pid", 1);
										infoMap.put("_cmd", "sys.cacheGameRolethree");
										infoMap.put("_params", papa);
										infoMap.put("_key1", "1");
										infoMap.put("_key2", "0000");
										infoMap.put("_key3", "12");
										infoMap.put("_key3tang", "12");
										cm.getClient(serverId).smcHander.sendData(infoMap);
									}
								}
								co.close();
							Share.shareBeanQueue.dequeue();
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
						l = Share.shareBeanQueue.size();
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
				l = Share.shareBeanQueue.size();
			}
	}
	public static void log(String msg) {
		log.println(new Date() + ":" + msg);
	}
}
