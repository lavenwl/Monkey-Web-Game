package apiinterface;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

import dbconn.DBConnectionManager;

public class ZqRedirectURL extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static String key = null;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		String err = checkPPS(request);

		if (err == null) {
			request.getRequestDispatcher(
					"server" + request.getParameter("serverID") + "/in.jsp")
					.forward(request, response);
			// response.sendRedirect("server"
			// + request.getParameter("serverID") + "/in.jsp");

		} else {
			response.setContentType("text/html");
			String url = request.getHeader("Referer");

			PrintWriter out = response.getWriter();
			String htmltext = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">"
					+ "<HTML>"
					+ "  <HEAD><TITLE>颠倒西游</TITLE></HEAD>"
					+ "  <BODY>"
					+ "<script>alert(\""
					+ err
					+ "\");\n"
					+ "window.location.href=\"";

			if (url != null) {
				htmltext = htmltext + url;
			} else {
				htmltext = htmltext + "index.jsp";
			}

			htmltext = htmltext + "\"</script>" + "  </BODY>" + "</HTML>";

			out.print(htmltext);
			out.flush();
			out.close();
		}
	}

	private String checkPPS(HttpServletRequest request) {// 确认是否从PPS传来的合法性
		String uid = request.getParameter("uid");
		System.out.println(uid);
		String gameNum = request.getParameter("gameNum");
		String dateTime = request.getParameter("dateTime");
		String chk = request.getParameter("chk");
		String serverID = request.getParameter("serverID");
		String ip = request.getRemoteAddr();
		if (key == null) {
			InputStream is = getClass().getResourceAsStream("key.properties");
			Properties keyProps = new Properties();
			try {
				keyProps.load(is);
			} catch (Exception e) {
				System.err.println("不能读取属性文件。请确保key.properties在你的CLASSPATH中");
				return "无法获知KEY，请联系运营商";
			}
			key = keyProps.getProperty("zqredirecturl", "123");
		}

		long nowTime = System.currentTimeMillis() / 1000;
		try {
			long dateTimel = Long.parseLong(dateTime);
			long re = nowTime - dateTimel;
			// if (re > 180l || re < -180l) {
			if (re > 5000 || re < -5000) {
				return "出错1:超时";
			}
		} catch (Exception e) {
			return "出错2:非法";
		}

		String tmp = uid + gameNum + dateTime + serverID + key; // MD5加密
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
					hexString.append(Integer.toHexString(0xFF & hash[i]));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (hexString == null || !hexString.toString().equals(chk)) {
			System.out.println(hexString);
			return "出错3:链接地址非法";
		}

		int tmp1 = checkDb(request, ip);
		if (tmp1 == -1) {
			return "出错4:数据库链接出错";
		}
		request.getSession().setAttribute("roleId", tmp1 + "");
		return null;
	}

	private int checkDb(HttpServletRequest request, String ip) {// 根据serverId确认数据库中是否存在此用户
		// 不存在则创建 返回roleId
		String uid = request.getParameter("uid");
		int rt = -1;
		String serverID = request.getParameter("serverID").trim();
		int member_username = Integer.parseInt(uid);
		DBConnectionManager dbp = DBConnectionManager.getInstance();
		Connection co = dbp.getConnection("server" + serverID);
		boolean isNew = false;
		try {
			Statement st = co.createStatement();
			ResultSet rs = st
					.executeQuery("select id from game_role where id = "
							+ member_username + "");
			if (rs.next()) {
				rt = rs.getInt(1);
				rs.close();
				isNew = false;
				request.getSession().setAttribute("isNew", isNew);// 是否需要创建角色的标志位
			} else {
				isNew = true;
				rt = member_username;
				request.getSession().setAttribute("pid", rt + "");
				request.getSession().setAttribute("isNew", isNew);
			}
			String priKey = new Date().getTime() + "";
			request.getSession().setAttribute("priKey", priKey);
			rs.close();
			st.close();
			dbp.freeConnection("server" + serverID, co);
			return rt;
		} catch (Exception e) {
			e.printStackTrace();
			dbp.freeConnection("server" + serverID, co);
			return -1;
		}

	}
}
