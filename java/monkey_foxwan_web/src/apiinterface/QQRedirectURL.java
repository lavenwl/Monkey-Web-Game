package apiinterface;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconn.DBConnectionManager;

public class QQRedirectURL extends HttpServlet {
	private static String key = null;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//long o = System.currentTimeMillis();
		//long p = System.currentTimeMillis();
		response.setCharacterEncoding("utf-8");
		//String err = checkQQ(request);
		if (true){//("null".equals(String.valueOf(err))) {
			int uid = Integer.parseInt(request.getParameter("uid"));
			String openid = request.getParameter("openid");
			String p = request.getParameter("p");
			String time = request.getParameter("time");
			String isadult = request.getParameter("isadult");
			String flag = request.getParameter("flag");
			String serverId = request.getParameter("serverId");
			String serverIp = request.getParameter("serverIp");
		//	request.getSession().setAttribute("pid", uid + "");
			String priKey = new Date().getTime() + "";
			request.getSession().setAttribute("time", time);
			request.getSession().setAttribute("isadult", isadult);
			request.getSession().setAttribute("flag", flag);
			request.getSession().setAttribute("openid", openid);
			request.getSession().setAttribute("serverId", serverId);
			request.getSession().setAttribute("serverIp", serverIp);
			request.getSession().setAttribute("p", p);
			request.getSession().setAttribute("roleId", uid + "");
			//p = System.currentTimeMillis();
			//System.out.println("in QQRedirectURL.java:" + (p - o));
			request.getRequestDispatcher("server1" + "/in.jsp").forward(
					request, response);
		} else {
			response.setContentType("text/html");
			String url = request.getHeader("Referer");
			PrintWriter out = response.getWriter();
			String htmltext = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">"
					+ "<HTML>"
					+ "  <HEAD><TITLE>颠倒西游</TITLE></HEAD>"
					+ "  <BODY>"
					+ "<script>alert(\""
					+ "err"
					+ "\");\n"
					+ "window.location.href=\"";

			if (url != null) {
				htmltext = htmltext + url;
			} else {
				htmltext = "";
			}
			htmltext = htmltext + "\"</script>" + "  </BODY>" + "</HTML>";
			out.print(htmltext);
			out.flush();
			out.close();
		}
	}

	private String checkQQ(HttpServletRequest request) {// 确认是否从QQ传来的合法性
//		String ip = request.getRemoteAddr();
//		if (key == null) {
//			InputStream is = getClass().getResourceAsStream("key.properties");
//			Properties keyProps = new Properties();
//			try {
//				keyProps.load(is);
//			} catch (Exception e) {
//				System.err.println("不能读取属性文件。请确保key.properties在你的CLASSPATH中");
//				return "无法获知KEY，请联系运营商";
//			}
//			key = keyProps.getProperty("qqredirecturl", "123");
//		}

		int tmp1 = checkDb(request);
		if (tmp1 == -1) {
			return "出错4:数据库链接出错";
		}
		request.getSession().setAttribute("roleId", tmp1 + "");
		return null;
	}

	private int checkDb(HttpServletRequest request) {
		int uid = Integer.parseInt(request.getParameter("uid"));
		String openid = request.getParameter("openid");
		String openkey = request.getParameter("openkey");
		String serverId = request.getParameter("serverId");
		String serverIp = request.getParameter("serverIp");
		//System.out.println("QQRequest:接收到的serverId:" + serverId);
		int rt = -1;
		DBConnectionManager dbp = DBConnectionManager.getInstance();
		Connection co = dbp.getConnection("server" + serverId);
		boolean isNew = false;
		try {
			Statement st = co.createStatement();
			ResultSet rs = st.executeQuery("select id from game_role where id = '"+uid+"' and serverid = '" + serverId + "'");
			if (rs.next()) {
				rt = rs.getInt(1);
				isNew = false;
				request.getSession().setAttribute("isNew", isNew);
				rs.close();
			} else {
				rt = uid;
				isNew = true;
				request.getSession().setAttribute("isNew", isNew);
			}
			request.getSession().setAttribute("pid", rt + "");
			String priKey = new Date().getTime() + "";
			request.getSession().setAttribute("openid", openid);
			request.getSession().setAttribute("openkey", openkey);
			request.getSession().setAttribute("serverId", serverId);
			request.getSession().setAttribute("serverIp", serverIp);
			st.close();
			dbp.freeConnection("server" + serverId, co);
		} catch (Exception e) {
			e.printStackTrace();
			dbp.freeConnection("server" + serverId, co);
			return -1;
		}
		return rt;
	}
}
