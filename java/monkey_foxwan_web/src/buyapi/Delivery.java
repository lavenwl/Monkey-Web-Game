package buyapi;

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

import dbconn.DBConnectionManager;
import entity.Huangzuan;
/**
 * 发货通知接口
 * @author Administrator
 *
 */
public class Delivery extends HttpServlet {
	final static String appid = "100719210";
	final static String appkey = "cd9da8b634c25e0e2eb683fe56c1f268";
	static OpenApiV3 sdk = new OpenApiV3(appid, appkey);

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//	System.out.println("deliver_____________________________________________________________________y:");
		String serverName = "openapi.tencentyun.com";//正式上线用
//		String serverName = "119.147.19.43";
		sdk.setServerName(serverName);
		String scriptName = "/v3/pay/confirm_delivery";//
		String protocol = "https";
		// 填充URL请求参数
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("openid", request.getParameter("openid"));
		params.put("openkey", request.getParameter("openkey"));
		params.put("pf", request.getParameter("pf"));
		params.put("ts", String.valueOf(System.currentTimeMillis()/1000));
		String openid = request.getParameter("openid");
		String zoneid = request.getParameter("zoneid");
		//从数据库取出数据
		DBConnectionManager dbp = DBConnectionManager.getInstance();
		Connection co = dbp.getConnection("server" + zoneid);
		Statement st = null;
		try {
			st = co.createStatement();
			ResultSet rs = st.executeQuery("select * from delivery where openid ='"+openid+"' and zoneid = '" + zoneid + "'");
			while(rs.next()){
				params.put("payitem", rs.getString("payitem"));
				params.put("token_id", rs.getString("token_id"));
				params.put("billno", rs.getString("billno"));
				params.put("zoneid", rs.getString("zoneid"));
				params.put("provide_errno", rs.getString("provide_errno"));
				params.put("amt", rs.getString("amt"));
				params.put("payamt_coins", rs.getString("payamt_coins"));
			}
			rs.close();
			st.close();
			co.close();
			dbp.freeConnection("server" + zoneid, co);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			String resp = sdk.api(scriptName, (HashMap<String, String>) params,protocol);
			//System.out.println("delivery confirme message:" + resp);
		} catch (OpensnsException e) {
			e.printStackTrace();
		}
	}
}
