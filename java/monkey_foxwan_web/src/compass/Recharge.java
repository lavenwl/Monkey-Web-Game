package compass;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qq.open.CompassApi;

import dbconn.DBConnectionManager;
/**
 * 充值元宝
 * @author Administrator
 *
 */
public class Recharge extends HttpServlet{
	
	final static String appid = "100719210";
	final static String appkey = "cd9da8b634c25e0e2eb683fe56c1f268";
	static CompassApi sdk = new CompassApi(appid, appkey);
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String serverName = "tencentlog.com";
		sdk.setServerName(serverName);
		String scriptName = "/stat/report_recharge.php";//
		String protocol = "http";
		//用户数据
		String userip = String.valueOf(QQIpConverter.ipToLong(request.getRemoteAddr()));
		String svrip = String.valueOf(QQIpConverter.ipToLong("10.142.35.79"));
		String time = String.valueOf(System.currentTimeMillis()/1000);
		// 
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("appid", appid);
		params.put("userip", userip);
		params.put("svrip", svrip);
		params.put("time", time);
		String pf = request.getParameter("pf");
		if("qzone".equals(pf)){
			params.put("domain", String.valueOf(1));
		}else if("pengyou".equals(pf)){
			params.put("domain", String.valueOf(2));
		}else if("3366".equals(pf)){
			params.put("domain", String.valueOf(11));
		}
		
		params.put("worldid", "1");
		params.put("opuid", request.getParameter("uid"));
		params.put("opopenid", request.getParameter("openid"));
		int modifyfee = Integer.parseInt(request.getParameter("modifyfee"))*10;
		params.put("modifyfee", String.valueOf(modifyfee));//充值了多少元宝：Q点*10
		//获取level
		DBConnectionManager dbp = DBConnectionManager.getInstance();
		Connection co = dbp.getConnection("server1");
		Statement st = null;
		int id = Integer.parseInt(request.getParameter("uid"));
		int level = 0;
		try {
			st = co.createStatement();
			ResultSet rs = st.executeQuery("select level from game_role where id ="+id);
			while(rs.next()){
				level = rs.getInt(1);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		params.put("level", String.valueOf(level));
		//只为通过api的验证！
//		params.put("openid", request.getParameter("openid"));
//		params.put("openkey", request.getParameter("openkey"));
//		params.put("pf", request.getParameter("pf"));
		try {
			String resp = sdk.api(scriptName, (HashMap<String, String>) params, protocol);
		//	System.out.println("loginData得到的数据是：" + resp);
		} catch (Exception e) {
			System.out.println("读取数据失败！");
			e.printStackTrace();
		}
	}
}
