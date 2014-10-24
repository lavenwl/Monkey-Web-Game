package apiinterface;

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

public class Friends extends HttpServlet {
	final static String appid = "100719210";
	final static String appkey = "cd9da8b634c25e0e2eb683fe56c1f268";
	static OpenApiV3 sdk = new OpenApiV3(appid, appkey);

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println("qqopenapi.............");
		String serverName = "openapi.tencentyun.com";//正式上线用
//		String serverName = "119.147.19.43";
		sdk.setServerName(serverName);
		String scriptName = "/v3/relation/get_app_friends";//
		String protocol = "http";
		String serverId = request.getParameter("serverId");
		// 填充URL请求参数
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("openid", request.getParameter("openid"));
		params.put("openkey", request.getParameter("openkey"));
		params.put("pf", request.getParameter("pf"));
		params.put("appid", appid);
		int id = Integer.parseInt(request.getParameter("id"));
		
		//本地测试用
//		params.put("openid", "440BC8E0DBDC3DE79F1B3447DCC53561");
//		params.put("openkey", "3CDED6A76E68E639F6701CCFEE0858D8");
//		params.put("pf", "qzone");
		try {
			String resp = sdk.api(scriptName, (HashMap<String, String>) params,
					protocol);
			//System.out.println(resp+".............resp");
			response.setContentType("text/html;charset=UTF-8");
			//黄钻，更新数据库
			DBConnectionManager dbp = DBConnectionManager.getInstance();
			Connection co = dbp.getConnection("server" + serverId);
			Statement st = null;
			try {
				st = co.createStatement();
//				int id = 6004;
				List<Map> resList = JSON.parseArray(String.valueOf("["+resp+"]"), Map.class);
				if(resList.get(0).get("items")!=null){
					String openids = resList.get(0).get("items").toString();
					int res = st.executeUpdate("update member set allfriends = '"+openids+"'where id = " + id);
					//System.out.println("插入QQ好友sql");
				}
				st.close();
				co.close();
				dbp.freeConnection("server" + serverId, co);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			PrintWriter out = response.getWriter();
			List list = new ArrayList();
			Huangzuan h = new Huangzuan();
			h.setId(0);
			h.setName(resp);
			list.add(h);
			JSONArray obj = JSONArray.fromObject(list);
			out.println(obj.toString());
			out.close();
			
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
