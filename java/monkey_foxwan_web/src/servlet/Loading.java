package servlet;

import java.io.IOException;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stang.game.ffd.client.Client;
import com.stang.game.ffd.controller.SendGiftAction;

import dbconn.DBConnectionManager;

public class Loading extends HttpServlet {
	static String email = "aa@ss";
	static String gameNum = "cc";
	static String key = "3tangfoxwan##$$";
	int p ;
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//long o = System.currentTimeMillis();
		//long p = System.currentTimeMillis();
		//System.out.println("......................loading");
//		String dataTime = String.valueOf(System.currentTimeMillis() / 1000);
		String memberUsername = request.getParameter("username");
		String time = request.getParameter("time");
		String isadult = request.getParameter("isadult");
		String flag = request.getParameter("flag");
		String serverId = request.getParameter("serverid");
		String serverIp = "192.168.2.63";
		//System.out.println("Loading 中接收到的serverId:" + serverId);
		DBConnectionManager dbp = DBConnectionManager.getInstance();
		Connection co = dbp.getConnection("server1");
		Statement sm = null;
		int statue = 3;
		try {
			sm = co.createStatement();
			ResultSet rs = sm.executeQuery("select statue_on from server_table where id = '"+ serverId+ "'");
			while (rs.next()) {
				statue = rs.getInt(1);
			}
			rs.close();
			sm.close();
			co.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		dbp.freeConnection("server1", co);
		if(statue==1){
		long id;
		p = 0;//如果是第一次进入游戏p=0，不是第一次p=1
		try {
			if ((id = checkUser(memberUsername,serverId)) != 0) {
				String chk = memberUsername + serverId + isadult + time
						+ key;
				String tmp = chk; // MD5加密
				StringBuffer hexString = new StringBuffer("");
				try {
					MessageDigest md = MessageDigest.getInstance("MD5");
					md.update(tmp.getBytes());
					byte[] hash = md.digest();

					for (int i = 0; i < hash.length; i++) {
						if ((0xff & hash[i]) < 0x10) {
							hexString.append("0"
									+ Integer.toHexString((0xFF & hash[i])));
						} else {
							hexString.append(Integer
									.toHexString(0xFF & hash[i]));
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
//				p = System.currentTimeMillis();
//				if(String.valueOf(hexString).equals(flag)){
					response.sendRedirect("./QQRedirectURL?uid=" + id + "&openid=" + memberUsername + "&time=" 
							+ time + "&isadult=" + isadult + "&flag=" + flag + "&serverId=" + serverId + "&p=" + p + "&serverIp=" + serverIp + "");
//				}else{
//					response.sendRedirect("./error.jsp");
//				}
			} else {
				response.sendRedirect("./error.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}else if(statue==0){
		p=0;
		DBConnectionManager dbp1 = DBConnectionManager.getInstance();
		Connection co1 = dbp1.getConnection("server1");
		Statement sm1 = null;
		int numa = 0;
		try {
			sm1 = co1.createStatement();
			ResultSet rs = sm1.executeQuery("select openid from test_player");
			while (rs.next()) {
				String openid = rs.getString("openid");
				if(memberUsername.equals(openid)){
					numa=1;
					break;
				}
			}
			rs.close();
			sm1.close();
			co1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(numa==1){
			int id = 0;
				try {
					id = checkUser(memberUsername,serverId);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			response.sendRedirect("./QQRedirectURL?uid=" + id + "&openid=" + memberUsername + "&time=" 
					+ time + "&isadult=" + isadult + "&flag=" + flag + "&serverId=" + serverId + "&p=" + p + "&serverIp=" + serverIp + "");
		}
		else{
		response.sendRedirect("./home.jsp");
		}
	}else{
		response.sendRedirect("./error.jsp");
	}
	}

	private int checkUser(String memberUsername, String serverId) throws SQLException {
		DBConnectionManager dbp = DBConnectionManager.getInstance();
		Connection co = dbp.getConnection("server1");
		Statement st = null;
		int id = 0;
		try {
			st = co.createStatement();
			ResultSet rs = st.executeQuery("select id from member where member_username = '"+memberUsername+"' and  serverid = '" + serverId + "'");
			while(rs.next()){
				id = rs.getInt(1);
			}
				rs.close();
			if(id!=0){
				ResultSet rss = st.executeQuery("select name from game_role where id ='"+id+"' and  serverid = '" + serverId + "'");
				while(rss.next()){
					p=1;
				}
				rss.close();
			}
			if(id==0){
				if(!"null".equals(memberUsername)){
					st.execute("insert into member(member_username, serverid, last_time) values('"+memberUsername+"','" + serverId +"',now())");
					ResultSet s = st.executeQuery("select id from member where member_username = '"+memberUsername+"' and  serverid = '" + serverId + "'");
					while(s.next()){
						id = s.getInt(1);
					}
					s.close();
				}
				//分数据库同步主数据库的数据
//				if(!serverId.equals("1")){
//					Connection coF = dbp.getConnection("server" + serverId);
//					Statement stF = null;
//					try {
//						stF = coF.createStatement();
//							if(!"null".equals(memberUsername)){
//								stF.execute("insert into member(id, member_username, serverid, last_time) values('"+id+"','"+memberUsername+"','" + serverId +"',now())");
//							}
//						co.close();
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//					stF.close();
//					dbp.freeConnection("server" + serverId, coF);
//				}
				
			}else{
				st.executeUpdate("update member set last_time = now() where id = " + id+ "");
			}
			co.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		dbp.freeConnection("server1", co);
		return id;
	}
}
