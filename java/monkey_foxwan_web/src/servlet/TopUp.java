package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import buyapi.ThreadCache;

import com.stang.game.ffd.client.ClientManager;

import dbconn.DBConnectionManager;

public class TopUp extends HttpServlet {
	static String key = "3tangfoxwan##$$";

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String num = "1";
		String serverId = request.getParameter("serverid");
		String orderno = request.getParameter("orderno");// 订单号,不允许重复
		String addgold = request.getParameter("addgold");// 充值金币数量
		String rmb = request.getParameter("rmb");// 充值金额
		String sign = request.getParameter("sign");// MD5(orderNo+ passport +
													// serverId+addGold +
													// rmb+payTime+key)key是充值接口双方提前约定的密钥
		String memberUsername = request.getParameter("passport");// 用户名
		String paytime = request.getParameter("paytime");// 玩家实际充值时间， 值为秒数

		String chk = orderno + memberUsername + serverId + addgold + rmb
				+ paytime + key;
		String tmp = chk; // MD5加密
		StringBuffer hexString = new StringBuffer("");
		 response.setContentType("text/html");
         PrintWriter out = response.getWriter();
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
		if(String.valueOf(hexString).equals(sign)){
			int serverid = Integer.valueOf(serverId);
			int id;
			try {
				id = checkUser(memberUsername,serverId);
			if(id!=0){
			HashMap<String, Object> papa = new HashMap<String, Object>();
			HashMap<String, Object> infoMap=new HashMap<String, Object>();
			ClientManager cm = ClientManager.getInstance();
			papa.put("roleid", id);
			papa.put("coin", addgold);
			infoMap.put("_guid", 0);
			infoMap.put("_cachekey", "noCachekey");
			infoMap.put("_sig", "robot");
			infoMap.put("_serverId", serverid);
			infoMap.put("_pid", 1);
			infoMap.put("_cmd", "sys.cacheGameRolethree");
			infoMap.put("_params", papa);
			infoMap.put("_key1", "1");
			infoMap.put("_key2", "0000");
			infoMap.put("_key3", "12");
			infoMap.put("_key3tang", "12");
			cm.getClient(serverid).smcHander.sendData(infoMap);
			out.write(num);
			//记录充值的钱数
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String currenttime = df.format(new Date());// new Date()为获取当前系统时间
			DBConnectionManager dbp = DBConnectionManager.getInstance();
			Connection coS = dbp.getConnection("server");
			PreparedStatement st = null;
			st = coS.prepareStatement("insert into buy(openid,payitem,time,serverid) values(?,?,?,?)");
			st.setString(1, memberUsername);
			st.setString(2, rmb);
			st.setString(3, currenttime);
			st.setString(4, serverId);
			st.execute();
			st.close();
			coS.close();
			}else{
				num = "-2";
				out.write(num);
			}
		} catch (SQLException e) {
			num = "-1";
			out.write(num);
			e.printStackTrace();
		}
		}else{
			num = "-4";
			out.write(num);
			//request.setAttribute("test",num);
			//response.sendRedirect(request.getHeader(num));
			//response.sendRedirect("./topup.jsp?topup="+num+"");
		}
	}

	private int checkUser(String memberUsername, String serverId)
			throws SQLException {
		DBConnectionManager dbp = DBConnectionManager.getInstance();
		Connection co = dbp.getConnection("server");
		Statement st = null;
		int id = 0;
		try {
			st = co.createStatement();
			ResultSet rs = st
					.executeQuery("select id from member where member_username = '"
							+ memberUsername
							+ "' and  serverid = '"
							+ serverId
							+ "'");
			while (rs.next()) {
				id = rs.getInt(1);
			}
			co.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		dbp.freeConnection("server", co);
		return id;
	}
}
