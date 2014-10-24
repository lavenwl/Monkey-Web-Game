package com.stang.game.ffd.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.objectweb.asm.tree.TryCatchBlockNode;

import apiinterface.Home;

import com.stang.game.entity.detail.ServerDetail;
import com.stang.game.ffd.client.Client;
import com.stang.game.ffd.client.ClientManager;

import dbconn.DBConnectionManager;

public class ProjectActionRole {
	private int roleid;
	private int id;
	private int idEquip;
	public int getIdEquip() {
		return idEquip;
	}
	public void setIdEquip(int idEquip) {
		this.idEquip = idEquip;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	private int type;
	private String[] serverids;
	public String[] getServerids() {
		return serverids;
	}
	public void setServerids(String[] serverids) {
		this.serverids = serverids;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String execute(){
			try {
				if(roleid!=0){
					System.out.println("tomcat更新game_role玩家表开始执行：：");
					int serverid = 1;
					DBConnectionManager dbp = DBConnectionManager.getInstance();
					Connection co = dbp.getConnection("server");
					Statement st = null;
					try {
						st = co.createStatement();
						ResultSet rs = st.executeQuery("select serverid from member where id = " + roleid);
						while(rs.next()){
							serverid = Integer.valueOf(rs.getString("serverid"));
						}
						System.out.println("ProjectActionRole.getserverid:" + serverid);
						co.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
					dbp.freeConnection("server", co);
//					String IP = getServerIp(serverid);
//					System.out.println("MessageAction.IP:" + IP);
//					new Client(IP, 8008).start();
					HashMap<String, Object> papa = new HashMap<String, Object>();
					 HashMap<String, Object> infoMap=new HashMap<String, Object>();
					papa.put("roleid", roleid);
					infoMap.put("_guid", 0);
					infoMap.put("_cachekey", "noCachekey");
					infoMap.put("_sig", "robot");
					infoMap.put("_serverId", 1);
					infoMap.put("_pid", 1);
					infoMap.put("_cmd", "sys.cacheGameRole");
					infoMap.put("_params", papa);
					infoMap.put("_key1", "1");
					infoMap.put("_key2", "0000");
					infoMap.put("_key3", "12");
					infoMap.put("_key3tang", "12");
					ClientManager cm = ClientManager.getInstance();
					cm.getClient(serverid).smcHander.sendData(infoMap);
				}else if(id!=0){//添加或删除一条任务
					System.out.println("tomcat更新role_task_task表开始执行type：："+type);
					for(int i = 0; i < serverids.length; i++){
						int id2 = Integer.valueOf(serverids[i].substring(0, 1));
//						System.out.println("MessageAction.id:" + id);
//						String IP = getServerIp(id);
//						System.out.println("MessageAction.IP:" + IP);
//						new Client(IP, 8008).start();
						HashMap<String, Object> papa = new HashMap<String, Object>();
						HashMap<String, Object> infoMap=new HashMap<String, Object>();
						papa.put("id", id);
						papa.put("type", type);
						infoMap.put("_guid", 0);
						infoMap.put("_cachekey", "noCachekey");
						infoMap.put("_sig", "robot");
						infoMap.put("_serverId", 1);
						infoMap.put("_pid", 1);
						infoMap.put("_cmd", "sys.cacheRoletasktask");
						infoMap.put("_params", papa);
						infoMap.put("_key1", "1");
						infoMap.put("_key2", "0000");
						infoMap.put("_key3", "12");
						infoMap.put("_key3tang", "12");
						ClientManager cm = ClientManager.getInstance();
						cm.getClient(id2).smcHander.sendData(infoMap);
					}
				}else{//删除一个装备
					System.out.println("tomcat更新role_equip表开始执行：："+idEquip);
					for(int i = 0; i < serverids.length; i++){
						int id2 = Integer.valueOf(serverids[i].substring(0, 1));
                 HashMap<String, Object> papa = new HashMap<String, Object>();
						HashMap<String, Object> infoMap=new HashMap<String, Object>();
						papa.put("idEquip", idEquip);
						infoMap.put("_guid", 0);
						infoMap.put("_cachekey", "noCachekey");
						infoMap.put("_sig", "robot");
						infoMap.put("_serverId", 1);
						infoMap.put("_pid", 1);
						infoMap.put("_cmd", "sys.cacheRoleEquip");
						infoMap.put("_params", papa);
						infoMap.put("_key1", "1");
						infoMap.put("_key2", "0000");
						infoMap.put("_key3", "12");
						infoMap.put("_key3tang", "12");
						ClientManager cm = ClientManager.getInstance();
						cm.getClient(id2).smcHander.sendData(infoMap);
					}
				}
				return "success";
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
	}
	private String getServerIp(int id){
		String IP = "";
		List<ServerDetail> serverlist = null;
		List<String> l = null;
		Home home  = new Home();
		serverlist = home.getServerList();
		l = new ArrayList<String>();
		for(int i = 0; i < serverlist.size(); i++){
			if(serverlist.get(i).getId() == id){
				IP = serverlist.get(i).getIp();
			}
		}
		return IP;
	}
}
