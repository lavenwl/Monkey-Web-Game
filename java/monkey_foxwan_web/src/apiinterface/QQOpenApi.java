package apiinterface;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import com.alibaba.fastjson.JSON;
import com.qq.open.OpenApiV3;
import com.qq.open.OpensnsException;
import com.stang.game.entity.detail.ServerDetail;
import com.stang.game.ffd.client.Client;
import com.stang.game.ffd.client.ClientManager;

import dbconn.DBConnectionManager;
import entity.Huangzuan;

public class QQOpenApi extends HttpServlet {
	//final static String IP = "10.142.35.79";
	
	final static String appid = "100719210";
	final static String appkey = "cd9da8b634c25e0e2eb683fe56c1f268";
	static OpenApiV3 sdk = new OpenApiV3(appid, appkey);

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//System.out.println("qqopenapi.............");
		String serverName = "openapi.tencentyun.com";//正式上线用
//		String serverName = "119.147.19.43";
		sdk.setServerName(serverName);
		String scriptName = "/v3/user/get_info";//获取用户的基本资料：昵称、性别、头像、所在地
		String protocol = "http";
		//String IP = request.getParameter("serverIp");
		String serverId = request.getParameter("serverId");
		int serverid = Integer.valueOf(serverId);
		//String IP = getServerIp(Integer.valueOf(serverId));
		// 填充URL请求参数
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("openid", request.getParameter("openid"));
		params.put("openkey", request.getParameter("openkey"));
		params.put("pf", request.getParameter("pf"));
		int id = Integer.parseInt(request.getParameter("id"));
		String success = String.valueOf(request.getParameter("success"));//邀请好友成功
		
		//本地测试用
//		params.put("openid", "440BC8E0DBDC3DE79F1B3447DCC53561");
//		params.put("openkey", "3CDED6A76E68E639F6701CCFEE0858D8");
//		params.put("pf", "qzone");
		try {
			String resp = sdk.api(scriptName, (HashMap<String, String>) params, protocol);
			//System.out.println(resp+".............resp");
			response.setContentType("text/html;charset=UTF-8");
			//黄钻，更新数据库
			//System.out.println("更新黄钻信息");
			ClientManager cm = ClientManager.getInstance();
			DBConnectionManager dbp = DBConnectionManager.getInstance();
			Connection co = dbp.getConnection("server" + serverId);
			Statement st = null;
			try {
				st = co.createStatement();
//				int id = 6004;
				
				//int res = st.executeUpdate("update game_role set huangzuaninfo = '"+'['+resp+']'+"'where id = " + id);
				String hz="["+resp+"]";
				
				HashMap<String, Object> papa = new HashMap<String, Object>();
				 HashMap<String, Object> infoMap=new HashMap<String, Object>();
				// new Client(IP, 8008).start();
				papa.put("roleid", id);
				papa.put("huangzuaninfo", hz);
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
				cm.getClient(serverid).smcHander.sendData(infoMap);
				
				//更新名字
				List<Map> list = JSON.parseArray("["+resp+"]",Map.class);
				if(Integer.parseInt(String.valueOf(list.get(0).get("ret")))==0){
					String name = String.valueOf(list.get(0).get("nickname"));
					//st.executeUpdate("update game_role set name = '"+name+"'where id = " + id);
					// new Client(IP, 8008).start();
					 papa.clear();
					 infoMap.clear();
						papa.put("roleid", id);
						papa.put("name", name);
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
						cm.getClient(serverid).smcHander.sendData(infoMap);
					
				}
				//判断邀请好友是否成功
				if(!"null".equals(String.valueOf(success))){
					int rid = Integer.parseInt(success);//邀请者id
					//标记邀请的好友
					ResultSet rs = st.executeQuery("select ids,idsold from game_role where id ="+rid);
					while(rs.next()){
						String ids = rs.getString("ids");
						String idsold=rs.getString("idsold");
						if(!"null".equals(String.valueOf(ids))){//取出再插入
							
							JSONArray ary = JSONArray.fromObject(ids);
							int size = ary.size();
							int a = 0;
							for(int i=0;i<size;i++){
								if(id==Integer.parseInt(String.valueOf(ary.get(i)))){
									a = 1;
								}
							}
							if(a==0){
								//标记是否是被邀请注册的
								st.executeUpdate("update member set invite = '"+1+"' where id = "+id);
							//	st.executeUpdate("update game_role set invite = invite +'"+1+"' where id = "+rid);
								
								ary.add(id);
								ids = ary.toString();
								//st.executeUpdate("update game_role set ids =  '"+ids+"' where id = "+rid);
								
								// new Client(IP, 8008).start();
								 papa.clear();
								 infoMap.clear();
									papa.put("roleid", rid);
									papa.put("invite", 1);
									papa.put("ids", ids);
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
									cm.getClient(serverid).smcHander.sendData(infoMap);
								
							}
							/****/
							else{//召唤的是老朋友，不是邀请好友，更新idsold
								if("null".equals(String.valueOf(idsold))){
									JSONArray aryold = new JSONArray();
									aryold.add(id);
									idsold = aryold.toString();
									//st.executeUpdate("update game_role set idsold =  '"+idsold+"' where id = "+rid);
								
									// new Client(IP, 8008).start();
									 papa.clear();
									 infoMap.clear();
										papa.put("roleid", rid);
										papa.put("idsold", idsold);
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
										cm.getClient(serverid).smcHander.sendData(infoMap);
								}else{
									JSONArray ary2 = JSONArray.fromObject(idsold);
									int size2 = ary2.size();
									int a2 = 0;
									for(int i=0;i<size2;i++){
										if(id==Integer.parseInt(String.valueOf(ary2.get(i)))){
											a2 = 1;
										}
									}
									if(a2==0){
										//JSONArray aryold = new JSONArray();
										ary2.add(id);
										idsold = ary2.toString();
										//st.executeUpdate("update game_role set idsold =  '"+idsold+"' where id = "+rid);
									//	 new Client(IP, 8008).start();
										 papa.clear();
										 infoMap.clear();
											papa.put("roleid", rid);
											papa.put("idsold", idsold);
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
											cm.getClient(serverid).smcHander.sendData(infoMap);
									}
								}
							}
							/****/
						}else{//直接插入
							//标记是否是被邀请注册的
							st.executeUpdate("update member set invite = '"+1+"' where id = "+id);
							//st.executeUpdate("update game_role set invite = invite +'"+1+"' where id = "+rid);
							
							JSONArray ary = new JSONArray();
							ary.add(id);
							ids = ary.toString();
							//st.executeUpdate("update game_role set ids =  '"+ids+"' where id = "+rid);
							
						//	new Client(IP, 8008).start();
							 papa.clear();
							 infoMap.clear();
								papa.put("roleid", rid);
								papa.put("invite", 1);
								papa.put("ids", ids);
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
								cm.getClient(serverid).smcHander.sendData(infoMap);
						}
					}
					rs.close();
				}
				st.close();
				co.close();
				dbp.freeConnection("server" + serverId, co);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			PrintWriter out = response.getWriter();
			List list = new ArrayList();
			Huangzuan h = new Huangzuan();
			h.setId(0);
			h.setName(resp);
			list.add(h);
			JSONArray obj = JSONArray.fromObject(list);
			out.println(obj.toString());
			out.close();
			
		} catch (OpensnsException e) {
			System.out.printf("Request Failed. code:%d, msg:%s\n", e.getErrorCode(), e.getMessage());
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.format("Request Failed. code:%d, msg:%s\n", e.getErrorCode(), e.getMessage());
			out.flush();
			out.close();
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
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
