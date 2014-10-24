package servlet;

import java.io.IOException;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import antlr.collections.List;
import buyapi.QueueCache;
import buyapi.ThreadCache;

import com.stang.game.ffd.client.Client;
import com.stang.game.ffd.client.ClientManager;

import dbconn.DBConnectionManager;
import flex.messaging.io.ArrayList;

public class Loadingtohomejsp extends HttpServlet {
	static String email = "aa@ss";
	static String gameNum = "cc";
	static String serverID = "1";
	public static QueueCache openidQueue = null;
	public static ThreadOpenid thread = null;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//public void service(String openid) throws ServletException, IOException {
//		long o = System.currentTimeMillis();
//		long p = System.currentTimeMillis();
		if(openidQueue == null)
			openidQueue = new QueueCache();
		if(thread == null){
			thread = new ThreadOpenid("Loadingtohomejsp");
			thread.start();
		}
		String dataTime = String.valueOf(System.currentTimeMillis() / 1000);
		String memberUsername = request.getParameter("memberUsername");
		String memberPassword = request.getParameter("memberPassword");
		String openkey ="A7858238E4286A6453C6F125FBCF3CA0";
		String pf = "qzone";
		String pfkey = "8f319b550ed5639e0880efbffe2e3262";
		String success = null;
		String serverId = "1";
		//System.out.println("memberPassword:" + memberPassword);
		if("stang.com".equals(memberPassword)){
			openidQueue.enqueue(memberUsername);
			response.sendRedirect("http://rc.qzone.qq.com/100719210");
		}else{
			long id;
			try {
				if (true) {
					request.getSession().setAttribute("openid", memberUsername);
					request.getSession().setAttribute("openkey", openkey);
					request.getSession().setAttribute("pfkey", pfkey);
					request.getSession().setAttribute("pf", pf);
					request.getSession().setAttribute("success", success);//邀请好友
					request.getSession().setAttribute("serverid", serverId);
//					p = System.currentTimeMillis();
//					System.out.println("in Loadingtohomejsp:" + (p - o));
					request.getRequestDispatcher("./home.jsp").forward(
							request, response);
				} else {
					response.sendRedirect("./home.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
