package apiinterface;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
import com.stang.game.entity.detail.GameRoleDetail;

import dbconn.DBConnectionManager;

import entity.Huangzuan;

public class GroupFriends extends HttpServlet {
	final static String appid = "100719210";
	final static String appkey = "cd9da8b634c25e0e2eb683fe56c1f268";
	static OpenApiV3 sdk = new OpenApiV3(appid, appkey);

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 //获取用户加入群的groupopenid和unionid
//		System.out.println("qqopenapi.............");
		String serverName = "openapi.tencentyun.com";//正式上线用
//		String serverName = "119.147.19.43";
		sdk.setServerName(serverName);
		String scriptName = "/v3/qqgroup/is_group_member";//
		String protocol = "http";
		String serverId = request.getParameter("serverId");
		// 填充URL请求参数
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("openid", request.getParameter("openid"));
		params.put("openkey", request.getParameter("openkey"));
		params.put("pf", request.getParameter("pf"));
		params.put("appid", appid);
		int id = Integer.parseInt(request.getParameter("id"));
		//本地测试用
//		params.put("openid", "214D4174967FF66142504046722ED178");
//		params.put("openkey", "0FA25D47BF9E5838DFA08ED94C8F671F");
//		params.put("pf", "qzone");
		try {
			String resp = sdk.api(scriptName, (HashMap<String, String>) params,
					protocol);
//			System.out.println("resp`````````````"+resp);
//				int id = 6004;
				List<Map> resList = JSON.parseArray(String.valueOf("["+resp+"]"), Map.class);
//				System.out.println("resList:------"+resList);
//				System.out.println("resList.get(0).get(items):---"+resList.get(0).get("items"));
//				System.out.println("resList.get(0).get('count'):````"+resList.get(0).get("count"));
				String count = resList.get(0).get("count").toString();//用户QQ号里一共有几个游戏应用群
//				int n = Integer.parseInt("count");
//				System.out.println("count:::"+count);
				if(count.equals("0")){
					response.setContentType("text/html;charset=UTF-8");
					//黄钻，更新数据库
					DBConnectionManager dbp = DBConnectionManager.getInstance();
					Connection co = dbp.getConnection("server" + serverId);
					Statement st = null;
					try {
						st = co.createStatement();
						
							int res = st.executeUpdate("update member set allgroupfriends = null where id = " + id);
							int res1 = st.executeUpdate("update game_role set groupopenid = null where id = " + id);
							
//							System.out.println("插入变成Null的sql语句");
						st.close();
						co.close();
						dbp.freeConnection("server" + serverId, co);
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} 
				}else{
//					int count1=Integer.parseInt(count);
					String groupopenids = resList.get(0).get("items").toString();
					List<Map> rList = JSON.parseArray(String.valueOf(groupopenids), Map.class);
					int aa = 0;  //如果没加入官方QQ群 aa为0，加入官方QQ群 aa为1
					for(int n = 0;n<rList.size();n++){
//						System.out.println("openids:------------"+groupopenids);
//						System.out.println("rList:::::"+rList);
						 String groupopenid = rList.get(n).get("groupopenid").toString();
						 String unionid = rList.get(n).get("unionid").toString();
//						 System.out.println("unionid:::"+unionid);
						if(unionid.equals("900000001")){//900000001是官方群的unionid
//					 System.out.println("Groupopenid::::::"+groupopenid);
//					 System.out.println("unionid::::"+unionid);
					 params.clear();
				 	 params.put("openid", request.getParameter("openid"));
				     params.put("openkey", request.getParameter("openkey"));
					 params.put("pf", request.getParameter("pf"));
						params.put("appid", appid);
						//本地测试用
//						params.put("openid", "214D4174967FF66142504046722ED178");
//						params.put("openkey", "0FA25D47BF9E5838DFA08ED94C8F671F");
//						params.put("pf", "qzone");
						params.put("group_openid", groupopenid);
						params.put("unionid", unionid);
						scriptName = "/v3/qqgroup/get_app_groupmembers";
						//groupinfo得到群里的好友信息
						String groupinfo = sdk.api(scriptName, (HashMap<String, String>) params,
								protocol);
						List<Map> groupList = JSON.parseArray(String.valueOf("["+groupinfo+"]"), Map.class);
						String total_page = groupList.get(0).get("total_page").toString();//当前群成员的总页数
						String groupfriends = "";//群内的成员信息
						for (int i = 1; i < Integer.parseInt(total_page)+1; i++) {
							String ii = String.valueOf(i);
							params.put("page", ii);
							String groupinfo1 = sdk.api(scriptName, (HashMap<String, String>) params,
									protocol);
							List<Map> groupList1 = JSON.parseArray(String.valueOf("["+groupinfo1+"]"), Map.class);
							String openids1 = groupList1.get(0).get("items").toString();
							String a = openids1.replace("[", "").replace("]", "");
							groupfriends+=a;
						}
						groupfriends=groupopenid+groupfriends;
//						System.out.println("groupfriends:::::"+groupfriends);
//						String s = groupfriends.subSequence(0, 32).toString();
//						System.out.println("打印出截取的字符串---"+s);
//						System.out.println("groupfriends------------"+groupfriends);
//						System.out.println("groupfriends.substring(1, groupfriends.length() - 32):---"+groupfriends.substring(32));
//						System.out.println("groupfriends:::::"+groupfriends);
//						System.out.println("resList1::::"+resList1);
//						System.out.println("resList1.get(0).get(openid):::"+resList1.get(0).get("openid"));
//					int res = st.executeUpdate("update member set allfriends = '"+openids+"'where id = " + id);
						response.setContentType("text/html;charset=UTF-8");
						//黄钻，更新数据库
						DBConnectionManager dbp = DBConnectionManager.getInstance();
						Connection co = dbp.getConnection("server" + serverId);
						Statement st = null;
						try {
							st = co.createStatement();
							
								int res = st.executeUpdate("update member set allgroupfriends = '"+groupfriends+"'where id = " + id);
//								System.out.println("插入群好友sql语句");
							st.close();
							co.close();
							dbp.freeConnection("server" + serverId, co);
						} catch (NumberFormatException e) {
							e.printStackTrace();
						} 
						//把参数传给socket
//						response.setContentType("text/html;charset=UTF-8");
//						PrintWriter out = response.getWriter();
//						List list = new ArrayList();
//						Huangzuan h = new Huangzuan();
//						h.setId(0);
//						h.setName(groupfriends);
//						list.add(h);
//						JSONArray obj = JSONArray.fromObject(list);
//						out.println(obj.toString());
//						out.close();
						aa=1;
						break;
					}
				}
//					System.out.println("aa::::"+aa);
					if(aa==0){
						 String groupopenid = rList.get(0).get("groupopenid").toString();
						 String unionid = rList.get(0).get("unionid").toString();
//						 System.out.println("unionid:::"+unionid);
					 params.clear();
				 	 params.put("openid", request.getParameter("openid"));
				     params.put("openkey", request.getParameter("openkey"));
					 params.put("pf", request.getParameter("pf"));
						params.put("appid", appid);
						//本地测试用
//						params.put("openid", "214D4174967FF66142504046722ED178");
//						params.put("openkey", "0FA25D47BF9E5838DFA08ED94C8F671F");
//						params.put("pf", "qzone");
						params.put("group_openid", groupopenid);
						params.put("unionid", unionid);
						scriptName = "/v3/qqgroup/get_app_groupmembers";
						//groupinfo得到群里的好友信息
						String groupinfo = sdk.api(scriptName, (HashMap<String, String>) params,
								protocol);
						List<Map> groupList = JSON.parseArray(String.valueOf("["+groupinfo+"]"), Map.class);
						String total_page = groupList.get(0).get("total_page").toString();//当前群成员的总页数
						String groupfriends = "";//群内的成员信息
						for (int i = 1; i < Integer.parseInt(total_page)+1; i++) {
							String ii = String.valueOf(i);
							params.put("page", ii);
							String groupinfo1 = sdk.api(scriptName, (HashMap<String, String>) params,
									protocol);
							List<Map> groupList1 = JSON.parseArray(String.valueOf("["+groupinfo1+"]"), Map.class);
							String openids1 = groupList1.get(0).get("items").toString();
							String a = openids1.replace("[", "").replace("]", "");
							groupfriends+=a;
						}
						groupfriends=groupopenid+groupfriends;
//						System.out.println("groupfriends:::::"+groupfriends);
//						String s = groupfriends.subSequence(0, 32).toString();
//						System.out.println("打印出截取的字符串---"+s);
//						System.out.println("groupfriends------------"+groupfriends);
//						System.out.println("groupfriends.substring(1, groupfriends.length() - 32):---"+groupfriends.substring(32));
//						System.out.println("groupfriends:::::"+groupfriends);
//						System.out.println("resList1::::"+resList1);
//						System.out.println("resList1.get(0).get(openid):::"+resList1.get(0).get("openid"));
//					int res = st.executeUpdate("update member set allfriends = '"+openids+"'where id = " + id);
						response.setContentType("text/html;charset=UTF-8");
						//黄钻，更新数据库
						DBConnectionManager dbp = DBConnectionManager.getInstance();
						Connection co = dbp.getConnection("server" + serverId);
						Statement st = null;
						try {
							st = co.createStatement();
							
								int res = st.executeUpdate("update member set allgroupfriends = '"+groupfriends+"'where id = " + id);
//								System.out.println("插入fei群好友sql语句");
							st.close();
							co.close();
							dbp.freeConnection("server" + serverId, co);
						} catch (NumberFormatException e) {
							e.printStackTrace();
						} 
						//把参数传给socket
//						response.setContentType("text/html;charset=UTF-8");
//						PrintWriter out = response.getWriter();
//						List list = new ArrayList();
//						Huangzuan h = new Huangzuan();
//						h.setId(0);
//						h.setName(groupfriends);
//						list.add(h);
//						JSONArray obj = JSONArray.fromObject(list);
//						out.println(obj.toString());
//						out.close();
					}
				}
		} catch (OpensnsException e) {
			System.out.printf("Request Failed. code:%d, msg:%s\n", e
					.getErrorCode(), e.getMessage());
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.format("Request Failed. code:%d, msg:%s\n", e.getErrorCode(), e
					.getMessage());
			out.flush();
			out.close();
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
