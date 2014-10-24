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

import dbconn.DBConnectionManager;

import entity.Huangzuan;

public class GetMoney extends HttpServlet {
	final static String appid = "100719210";
	final static String appkey = "cd9da8b634c25e0e2eb683fe56c1f268";
	static OpenApiV3 sdk = new OpenApiV3(appid, appkey);

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String serverName = "openapi.tencentyun.com";
//		String serverName = "119.147.19.43";
		sdk.setServerName(serverName);
		String scriptName = "/v3/pay/get_balance";//游戏币余额查询
		String protocol = "http";
		String ts = String.valueOf(System.currentTimeMillis() / 1000);
		String z = String.valueOf(0);
		// 填充URL请求参数
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("openid", request.getParameter("openid"));
		params.put("openkey", request.getParameter("openkey"));
		params.put("pf", request.getParameter("pf"));
		params.put("pfkey", request.getParameter("pfkey"));
		params.put("ts", ts);
		params.put("zoneid", z);
		int id = Integer.parseInt(request.getParameter("uid"));
		try {
			String resp = sdk.api(scriptName, (HashMap<String, String>) params,
					protocol);
			Object s = JSON.parseObject(resp);
			Map map = (Map) s;
			Object balance = map.get("balance");
			if(balance==null){
				balance=0;
			}
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			List list = new ArrayList();
			Huangzuan h = new Huangzuan();
			h.setId((Integer) balance);
			h.setName("");
			list.add(h);
			JSONArray obj = JSONArray.fromObject(list);
			out.println(obj.toString());
			out.flush();
			out.close();
			DBConnectionManager dbp = DBConnectionManager.getInstance();
			Connection co = dbp.getConnection("server1");
			Statement st = null;
			try {
				st = co.createStatement();
				int coin = Integer.parseInt(String.valueOf(balance));
				st.executeUpdate("update game_role set coin = '"+coin+"'where id = '"+id+"'");
			} catch (SQLException e) {
				e.printStackTrace();
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
		}
	}
}
