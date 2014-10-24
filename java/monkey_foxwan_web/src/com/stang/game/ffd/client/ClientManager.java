package com.stang.game.ffd.client;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sun.util.logging.resources.logging;
import com.stang.game.entity.Server;
import com.stang.game.entity.detail.ServerDetail;

import dbconn.DBConnectionManager;

public class ClientManager {
	private static PrintWriter log;
	private Map<String, Client> clientMap = new HashMap<String, Client>();
	private Map<Integer, Server> serverMap = new HashMap<Integer, Server>();
	static private ClientManager instance;
	public static ClientManager getInstance(){
		if(instance == null){
			instance = new ClientManager();
		}
		return instance;
	}
	public ClientManager(){
		initClientMap();
	}
	private void initClientMap(){
		String logFile = "ClientManager.txt";
		try {
			log = new PrintWriter(new FileWriter(logFile, true), true);
		} catch (IOException e) {
			System.err.println("无法打开日志文件：" + logFile);
			log = new PrintWriter(System.err);
		}
		log("==================================================ClientManager.debug:BEGIN!====================================");
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
				serverlist.add(server);
				System.out.println("server.getId():"+String.valueOf(server.getId()));
				System.out.println("server.getIp():"+server.getIp());
				log("server.getId():"+String.valueOf(server.getId()));
				log("server.getIp():"+server.getIp());
		
			}
			co.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		dbp.freeConnection("server", co);
		for(int i = 0; i < serverlist.size(); i++){
			try{
				Server server = serverlist.get(i);
				serverMap.put(server.getId(), server);
				Client client = new Client(server.getIp(), 8008);
				client.start();
				clientMap.put("client" + server.getId(), client);
			}catch(Exception e){
				e.printStackTrace();
				continue;
			}
		}
		System.out.println("clientMap_____________________________:" + clientMap.size());
		System.out.println("serverMap_____________________________:" + serverMap.size());
	}
	
	public Client getClient(int serverid){
		Client client = clientMap.get("client" + serverid);
		log("getClient:::serverid"+serverid);
		if(client == null || client.smcHander.getSession() == null){
			System.out.println("异常情况：重新创建一个client：IP：" + serverMap.get(serverid).getIp());
			log("异常情况：重新创建一个client：IP：" + serverMap.get(serverid).getIp());
			client = new Client(serverMap.get(serverid).getIp(), 8008);
			client.start();
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
			clientMap.put("client" + serverid, client);
		}
		return client;
	}
	
	public static void log(String msg) {
		log.println(new Date() + ":" + msg);
	}
}
