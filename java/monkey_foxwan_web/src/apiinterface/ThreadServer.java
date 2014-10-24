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
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;
import net.sf.json.JSONArray;

public class ThreadServer extends Thread{
	private static PrintWriter log;
	public ThreadServer(){}
	public ThreadServer(String name){
		this.setName(name);
	}
	public void run(){
		String logFile = "ThreadServer.txt";
		int max = 4;
		try {
			log = new PrintWriter(new FileWriter(logFile, true), true);
		} catch (IOException e) {
			System.err.println("无法打开日志文件：" + logFile);
			log = new PrintWriter(System.err);
		}
		log("==============================================THREADSERVER DEBUG BEGAIN!=================================================================");
		String name = this.getName();
		boolean bo = true;
			//System.out.println("同步线程启动！" + this.getName());
			log("同步线程启动！" + this.getName());
			int time = 600000;
			for(int i = 0; i <= 1; ){
				try{
						try{
							List<ServerDetail> serverlist = new ArrayList<ServerDetail>();
							DBConnectionManager dbp = DBConnectionManager.getInstance();
							Connection co = dbp.getConnection("server");
							Statement st = null;
							try {
								st = co.createStatement();
								ResultSet rs = st.executeQuery("select * from server_table");
								while(rs.next()){
									ServerDetail server = new ServerDetail();
									server.setId(rs.getInt("id"));
									server.setName(rs.getString("name"));
									server.setStatue_mag(rs.getInt("statue_mag"));
									server.setStatue_tui(rs.getInt("statue_tui"));
									server.setStatue_xin(rs.getInt("statue_xin"));
									server.setStatue_on(rs.getInt("statue_on"));
									server.setIp(rs.getString("server_ip"));
									server.setOnline_num(rs.getInt("online_num"));
									serverlist.add(server);
								}
								co.close();
							} catch (Exception e) {
								e.printStackTrace();
							}
							dbp.freeConnection("server", co);
							for(int j = 0; j < serverlist.size(); j++){
								int serverid = serverlist.get(j).getId();
								System.out.println("ThreadServer.java: p76: serverid:" + serverid);
								Connection con = dbp.getConnection("server" + serverid);
								Statement stn = null;
								try {
									stn = con.createStatement();
									ResultSet rsn = stn.executeQuery("select * from server_table where id = " + serverid +"");
									while(rsn.next()){
										ServerDetail server = new ServerDetail();
										server.setId(rsn.getInt("id"));
										server.setName(rsn.getString("name"));
										server.setStatue_mag(rsn.getInt("statue_mag"));
										server.setStatue_tui(rsn.getInt("statue_tui"));
										server.setStatue_xin(rsn.getInt("statue_xin"));
										server.setStatue_on(rsn.getInt("statue_on"));
										server.setIp(rsn.getString("server_ip"));
										server.setOnline_num(rsn.getInt("online_num"));
										//System.out.println("serverid:" + serverid + " 读取的id：" + server.getId() + " onlineNum:" + server.getOnline_num());
										serverlist.get(j).setOnline_num(server.getOnline_num());
									}
									
									con.close();
								} catch (Exception e) {
									e.printStackTrace();
								}
								dbp.freeConnection("server" + serverid, co);
							}
							//计算推荐服
							Map<Integer, ServerDetail> servermap = new HashMap<Integer, ServerDetail>();
							Map<String, Map<Integer,Integer>> dip = new HashMap<String, Map<Integer, Integer>>();
							int serverid1 = 0;
							int serverid2 = 0;
							servermap.clear();
							//初始化数据，建立辅助数据结构。
							for(int t = 0; t < serverlist.size(); t++){
								ServerDetail server = serverlist.get(t);
								servermap.put(server.getId(), server);
								if(dip.containsKey(server.getIp())){
									dip.get(server.getIp()).put(server.getId(), server.getOnline_num());
								}else{
									Map<Integer, Integer> did = new HashMap<Integer, Integer>();
									did.put(server.getId(), server.getOnline_num());
									dip.put(server.getIp(), did);
								}
								if(server.getStatue_tui() == 1){
									serverid1 = server.getId();
								}
							}
							//System.out.println("原本推荐服serverid1:" + serverid1);
							if(servermap.get(serverid1).getOnline_num() > max / (dip.get(servermap.get(serverid1).getIp())).size()){
								int top = 0;
								Map<Integer, Integer> onlineMap = dip.get(servermap.get(serverid1).getIp());
								Iterator it = onlineMap.keySet().iterator();
								while(it.hasNext()){
									top = top + onlineMap.get(it.next());
								}
								//System.out.println("推荐区所在的ip物理服务器是否到达上限top:" + top);
								//判断推荐服开了多少个区
								//System.out.println("onlineMap.size:" + onlineMap.size());
								if(onlineMap.size() > 1){
									//判断推荐区所在的ip物理服务器是否到达上限
									if(top > max){
										//超过了单台物理服务器的承载，转向其他物理服务器

										//System.out.println("else:");
										Iterator it2 = dip.keySet().iterator();
										while(it2.hasNext()){
											//System.out.println("else1:");
											int top2 = 0;
											int id3 = 0;
											Map<Integer, Integer> onlineMap2 = dip.get(it2.next());
											Iterator it3 = onlineMap2.keySet().iterator();
											while(it3.hasNext()){
												//System.out.println("else2:");
												id3 = Integer.valueOf(String.valueOf(it3.next()));
												
												top2 = top2 + onlineMap2.get(id3);
											}
											if(servermap.get(id3).getStatue_on() != 0){
												//System.out.println("推荐区所在的ip物理服务器是否到达上限top2:" + top2);
												//判断其他服务器的同事在线人数
												if(top2 < max){
													//判断此服的分区情况
													if(onlineMap2.size() > 1){
														Iterator it4 = onlineMap2.keySet().iterator();
														while(it4.hasNext()){
															int id4 = Integer.valueOf(String.valueOf(it4.next()));
															if(onlineMap2.get(id4) < max / onlineMap2.size()){
																serverid2 = id4;
																break;
															}
														}
													}else{
														serverid2 = id3;
														break;
													}
												}
											}
											
										}
									
									}else{
										//在本ip内分配分区
										//System.out.println("jisuan:" + max / onlineMap.size());
										if(servermap.get(serverid1).getOnline_num() < max / onlineMap.size()){
											//不做改变
											serverid2 = serverid1;
										}else{
											Iterator it1 = onlineMap.keySet().iterator();
											while(it1.hasNext()){
												int id2 = Integer.valueOf(String.valueOf(it1.next()));
												if(onlineMap.get(id2) < max / onlineMap.size()){
													serverid2 = id2;
													break;
												}
											}
										}
									}
								}else{
									//System.out.println("else:");
									Iterator it2 = dip.keySet().iterator();
									while(it2.hasNext()){
										//System.out.println("else1:");
										int top2 = 0;
										int id3 = 0;
										Map<Integer, Integer> onlineMap2 = dip.get(it2.next());
										Iterator it3 = onlineMap2.keySet().iterator();
										while(it3.hasNext()){
											//System.out.println("else2:");
											id3 = Integer.valueOf(String.valueOf(it3.next()));
											top2 = top2 + onlineMap2.get(id3);
										}
										if(servermap.get(id3).getStatue_on() != 0){
											//System.out.println("推荐区所在的ip物理服务器是否到达上限top2:" + top2);
											//判断其他服务器的同事在线人数
											if(top2 < max){
												//判断此服的分区情况
												if(onlineMap2.size() > 1){
													Iterator it4 = onlineMap2.keySet().iterator();
													while(it4.hasNext()){
														int id4 = Integer.valueOf(String.valueOf(it4.next()));
														if(onlineMap2.get(id4) < max / onlineMap2.size()){
															serverid2 = id4;
															break;
														}
													}
												}else{
													serverid2 = id3;
													break;
												}
											}
										}
										
									}
								}
							}
							if(serverid2 == 0){
								serverid2 = serverid1;
							}
						    //更改推荐服
							for(int m = 0; m < serverlist.size(); m++){
								ServerDetail server = serverlist.get(m);
								if(server.getId() == serverid1)
									server.setStatue_tui(0);
								if(server.getId() == serverid2)
									server.setStatue_tui(1);
							}
							for(int j = 0; j < serverlist.size(); j++){
								Connection con = dbp.getConnection("server");
								Statement stn = null;
								try {
									stn = con.createStatement();
									stn.execute("update server_table set online_num = " + serverlist.get(j).getOnline_num() + ", statue_tui = " + serverlist.get(j).getStatue_tui() + " where id = " + serverlist.get(j).getId() + "");
									con.close();
								} catch (Exception e) {
									e.printStackTrace();
								}
								dbp.freeConnection("server", co);
							}
							//log("be going to sleep this time!");
//							this.sleep(time);
						}catch(Exception e){
							e.printStackTrace();
						}
						this.sleep(time);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
	}
	public static void log(String msg) {
		log.println(new Date() + ":" + msg);
	}
}
