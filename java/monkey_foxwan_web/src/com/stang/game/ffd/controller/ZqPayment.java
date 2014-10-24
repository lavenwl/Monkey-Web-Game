//package apiinterface;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.PrintWriter;
//import java.security.MessageDigest;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Properties;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import dbconn.DBConnectionManager;
//
//public class ZqPayment extends HttpServlet {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	private static String key = null;
//	private static String ip1 = "8.8.8.8";
//	private static String ip2 = "8.8.8.8";
//	private static String ip3 = "8.8.8.8";
//	private static String ip4 = "8.8.8.8";
//	private static String ip5 = "8.8.8.8";
//
//	private static final int RLT_FAILURE = 0;// 失败
//	private static final int RLT_NOUSER = 1;// 无该用户
//	private static final int RLT_DOUBLEID = 2;// 订单号重复
//	private static final int RLT_WRONGNUM = 3;// 充值数量错误
//	private static final int RLT_WRONGIP = 4;// 错误IP
//	private static final int RLT_WRONGCHK = 5;// 验证错误
//	private static final int RLT_SUCCESS = 11;// 成功
//
//	public void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		int rlt = checkPPS(request);
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.print(rlt + "");
//		out.flush();
//		out.close();
//	}
//
//	private int checkPPS(HttpServletRequest request) {// 确认是否从PPS传来的合法性
//		String uid = request.getParameter("uid");
//		String point = request.getParameter("point");
//		String dateTime = request.getParameter("dateTime");
//		String chk = request.getParameter("chk");
//		String orderid = request.getParameter("orderid");
//		String serverID = request.getParameter("serverID");
//		String ip = request.getRemoteAddr();// 获取反向代理IP不做考虑
//		//System.out.println(ip1+","+ip2+","+ip3);
//
//		int point_i = 0;
//
//		// 判断金额是否合法
//		try {
//			point_i = Integer.valueOf(point);
//			if (point_i < 1)
//				return RLT_WRONGNUM;
//			point_i*=100;
//		} catch (Exception e) {
//			return RLT_WRONGNUM;
//		}
//
//		// 判断连接ID是否合法
//		if (key == null) {
//			InputStream is = getClass().getResourceAsStream("key.properties");
//			Properties keyProps = new Properties();
//			try {
//				keyProps.load(is);
//			} catch (Exception e) {
//				System.err.println("不能读取属性文件。请确保key.properties在你的CLASSPATH中");
//				return RLT_FAILURE;
//			}
//			key = keyProps.getProperty("zqpayment", "123");
//			ip1 = keyProps.getProperty("ip1", "8.8.8.8");
//			ip2 = keyProps.getProperty("ip2", "8.8.8.8");
//			ip3 = keyProps.getProperty("ip3", "8.8.8.8");
//			ip4 = keyProps.getProperty("ip4", "8.8.8.8");
//			ip5 = keyProps.getProperty("ip5", "8.8.8.8");
//			//System.out.println(key+","+ip1+","+ip2+","+ip3);
//		}
//		if (!(ip.equals(ip1) || ip.equals(ip2) || ip.equals(ip3) || ip.equals(ip4) || ip.equals(ip5))) {
//			System.out.println(ip);
//			return RLT_WRONGIP;
//		}
//
//		String tmp = uid + orderid + dateTime + point + serverID + key; // MD5加密
//		StringBuffer hexString = new StringBuffer("");
//		try {
//			MessageDigest md = MessageDigest.getInstance("MD5");
//			md.update(tmp.getBytes());
//			byte[] hash = md.digest();
//
//			for (int i = 0; i < hash.length; i++) {
//				if ((0xff & hash[i]) < 0x10) {
//					hexString.append("0"
//							+ Integer.toHexString((0xFF & hash[i])));
//				} else {
//					hexString.append(Integer.toHexString(0xFF & hash[i]));
//				}
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		//System.out.println(hexString.toString());
//
//		if (!hexString.toString().equals(chk)) {
//			System.out.println(hexString.toString());
//			return RLT_WRONGCHK;// MD5验证失败
//		}
//
//		// 充值事件失败则回滚
//		String member_username = serverID + "_" + uid;
//		DBConnectionManager dbp = DBConnectionManager.getInstance();
//		Connection co = dbp.getConnection("server" + serverID);
//		int rt = RLT_FAILURE;
//		Statement st_log = null;
//		boolean flag = false;// 标记事务是否需要回滚
//		try {
//			st_log = co.createStatement();
//			ResultSet rs = st_log
//					.executeQuery("select orderid from order_info where orderid = \""
//							+ orderid + "\"");
//			if (!rs.next()) {// 是否已经错在该订单
//				
//				int tmp_1=0;
//				String sqls="insert into order_info values(\""
//					+ orderid + "\",\"" + member_username + "\"," + point
//					+ ",FROM_UNIXTIME(" + dateTime + "000)," + serverID + ",1)";
//				try{
//					tmp_1 = st_log.executeUpdate(sqls);
//				}catch (Exception e) {
//					rt = RLT_DOUBLEID;// 如果在这里产生异常，则服务器并发量高的离谱 返回已存在订单
//					System.err.println(e+"sql:"+sqls);
//				}
//				if ( tmp_1 == 1) {
//
//					Statement st = co.createStatement();
//					rs = st
//							.executeQuery("select id from member where member_username = \""
//									+ member_username + "\"");
//					if (rs.next()) {
//						int roleId = rs.getInt(1);
//						rs.close();
//						rs = st
//								.executeQuery("select role_money from game_role where id="
//										+ roleId);
//						if (rs.next()) {
//							rs.close();
//							if (st
//									.executeUpdate("update game_role set role_money = role_money+"
//											+ point_i 
//											+ " where id = " + roleId + "") == 1) {
//								flag = true;
//								rt = RLT_SUCCESS;
//								// 成功
//							} else {
//								rt = RLT_FAILURE;
//							}
//						} else {
//							rs.close();
//							rt = RLT_NOUSER;// 没有该用户
//						}
//					} else {
//						rs.close();
//						rt = RLT_NOUSER;// 没有该用户
//					}
//					st.close();
//				} else {
//					rt = RLT_DOUBLEID;
//				}
//			} else {
//				rt = RLT_DOUBLEID;// 订单重复
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			rt = RLT_FAILURE;
//		}
//
//		if (!flag && rt != RLT_DOUBLEID) {
//			// 订单失败 事务回滚
//			try {
//				st_log
//						.executeUpdate("delete from order_info where orderid = \""
//								+ orderid + "\"");
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//		try {
//			st_log.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		dbp.freeConnection("server" + serverID, co);
//		if (flag)
//			return RLT_SUCCESS;
//		return rt;
//	}
//}
