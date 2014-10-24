package servlet;

import java.io.IOException;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stang.game.entity.detail.ServerDetail;
import com.stang.game.ffd.client.Client;

import dbconn.DBConnectionManager;

public class Server extends HttpServlet {
	static String email = "aa@ss";
	static String gameNum = "cc";
	static String serverID = "1";

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dataTime = String.valueOf(System.currentTimeMillis() / 1000);
		String memberUsername = request.getParameter("openid");
		String openkey = request.getParameter("openkey");
		String pf = request.getParameter("pf");
		String pfkey = request.getParameter("pfkey");
		String success = request.getParameter("success");//是否邀请好友成功
		
		String serverId = request.getParameter("serverId");
		long id;
		try {
			if (true) {
//				String chk = id + gameNum + dataTime + serverID
//						+ "qqgame#$%^()(&65r";
//				String tmp = chk; // MD5加密
//				StringBuffer hexString = new StringBuffer("");
//				try {
//					MessageDigest md = MessageDigest.getInstance("MD5");
//					md.update(tmp.getBytes());
//					byte[] hash = md.digest();
//
//					for (int i = 0; i < hash.length; i++) {
//						if ((0xff & hash[i]) < 0x10) {
//							hexString.append("0"
//									+ Integer.toHexString((0xFF & hash[i])));
//						} else {
//							hexString.append(Integer
//									.toHexString(0xFF & hash[i]));
//						}
//					}
//
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
			    Map<String, Object> dataMap = getList(memberUsername);
				request.getSession().setAttribute("openid", memberUsername);
				request.getSession().setAttribute("openkey", openkey);
				request.getSession().setAttribute("pfkey", pfkey);
				request.getSession().setAttribute("pf", pf);
				request.getSession().setAttribute("success", success);//邀请好友
				request.getSession().setAttribute("serverId", serverId);
				request.getSession().setAttribute("servermap", dataMap);
				//System.out.println("server.jsp");
				request.getRequestDispatcher("./server.jsp").forward(
						request, response);
			} else {
				response.sendRedirect("./home.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private Map<String, Object> getList(String memberUsername){
		int status = 0;
		DBConnectionManager dbpS = DBConnectionManager.getInstance();
		Connection coS = dbpS.getConnection("server");
		Statement stS = null;
		String oid = "";
		try {
			stS = coS.createStatement();
			ResultSet rsS = stS.executeQuery("select openid from test_player");
			while(rsS.next()){
				oid = rsS.getString(1);
				if(memberUsername.equals(oid)){
					status = 1;
					break;
				}
			}
			rsS.close();
			coS.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		dbpS.freeConnection("server", coS);
		
		//所有的server
		Map<String, Object> map = new HashMap<String, Object>();
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
				//if(server.getId() == 666){
					if(status == 1){
						server.setStatue_on(1);
					}else{
						server.setStatue_on(rs.getInt("statue_on"));
					}
//				}else{
//					server.setStatue_on(rs.getInt("statue_on"));
//				}
				server.setIp(rs.getString("server_lip"));
				serverlist.add(server);
			}
			co.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		dbp.freeConnection("server", co);
		
		//用户最近登录的server
		List<ServerDetail> roleServerlist = new ArrayList<ServerDetail>();
		DBConnectionManager dbp1 = DBConnectionManager.getInstance();
		Connection co1 = dbp1.getConnection("server");
		Statement st1 = null;
		try {
			st1 = co1.createStatement();
			ResultSet rs1 = st1.executeQuery("select m.last_time, st.* from server_table st left join member m on st.id = m.serverid where m.member_username ='" + memberUsername + "' order by last_time desc");
			while(rs1.next()){
				ServerDetail server = new ServerDetail();
				server.setId(rs1.getInt("id"));
				server.setName(rs1.getString("name"));
				//System.out.println(rs1.getString("name"));
				server.setStatue_mag(rs1.getInt("statue_mag"));
				server.setStatue_tui(rs1.getInt("statue_tui"));
				server.setStatue_xin(rs1.getInt("statue_xin"));
				server.setStatue_on(rs1.getInt("statue_on"));
				server.setIp(rs1.getString("server_lip"));
				if(rs1.getString("last_time").equals("0000-00-00 00:00:00")){
					continue;
				}
				server.setTime(rs1.getString("last_time"));
				roleServerlist.add(server);
				if(roleServerlist.size()>5){
					break;
				}
			}
			co1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		dbp1.freeConnection("server", co1);
		int ll = roleServerlist.size();
		if(ll >5 ){
			ll = 5;
			roleServerlist = roleServerlist.subList(0, 5);
		}
		map.put("serverlist", serverlist);
		map.put("roleServerlist", roleServerlist);
		return map;
	}
//	private int checkUser(String memberUsername, String serverId) throws SQLException {
//		DBConnectionManager dbp = DBConnectionManager.getInstance();
//		Connection co = dbp.getConnection("server");
//		Statement st = null;
//		int id = 0;
//		try {
//			st = co.createStatement();
//			ResultSet rs = st.executeQuery("select id from member where member_username = '"+memberUsername+"' and  serverid = '" + serverId + "'");
//			while(rs.next()){
//				id = rs.getInt(1);
//			}
//		
//			if(id==0){
//				if(!"null".equals(memberUsername)){
//					st.execute("insert into member(member_username, serverid, last_time) values('"+memberUsername+"','" + serverId +"',now())");
//					ResultSet s = st
//							.executeQuery("select id from member where member_username = '"+memberUsername+"' and  serverid = '" + serverId + "'");
//					while(s.next()){
//						id = s.getInt(1);
//						//insertMember(id, memberUsername, serverId);
//					}
//					s.close();
//				}
//			}
//			co.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		dbp.freeConnection("server", co);
//		return id;
//	}
//	
//	public void insertMember(int id, String name, String serverid){
//		//new Client("10.142.35.79", 8008).start();
//		//System.out.println("tomcat请求socket开始______________________________insertMember:name:" + name + " serverid:" + serverid);
//	    new Client("192.168.2.28", 8008).start();
//		HashMap<String, Object> papa = new HashMap<String, Object>();
//		 HashMap<String, Object> infoMap=new HashMap<String, Object>();
//		 papa.put("name", name);
//		 papa.put("serverid", serverid);
//		 papa.put("id", id);
//		infoMap.put("_guid", 0);
//		infoMap.put("_cachekey", "noCachekey");
//		infoMap.put("_sig", "robot");
//		infoMap.put("_serverId", 1);
//		infoMap.put("_pid", 1);
//		infoMap.put("_cmd", "sys.cacheMember");
//		infoMap.put("_params", papa);
//		infoMap.put("_key1", "1");
//		infoMap.put("_key2", "0000");
//		infoMap.put("_key3", "12");
//		infoMap.put("_key3tang", "12");
//		
//		
//		Client.smcHander.sendData(infoMap);
//		//System.out.println("tomcat请求socket结束____________________________________");
//	}
}
