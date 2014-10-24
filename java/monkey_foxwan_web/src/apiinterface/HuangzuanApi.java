package apiinterface;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
import com.stang.game.ffd.client.Client;
import com.stang.game.ffd.client.ClientManager;

import dbconn.DBConnectionManager;
import entity.Huangzuan;

public class HuangzuanApi extends HttpServlet {
	final static String appid = "100719210";
	final static String appkey = "cd9da8b634c25e0e2eb683fe56c1f268";
	static OpenApiV3 sdk = new OpenApiV3(appid, appkey);

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println("..................HuangzuanApi");
		String serverName = "openapi.tencentyun.com";//正式上线用
//		String serverName = "119.147.19.43";
		sdk.setServerName(serverName);
		String scriptName = "/v3/user/is_vip ";//获取用户的基本资料：昵称、性别、头像、所在地
		String protocol = "http";
		// 填充URL请求参数
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("openid", request.getParameter("openid"));
		params.put("openkey", request.getParameter("openkey"));
		params.put("pf", request.getParameter("pf"));
		int serverid = 1;
		DBConnectionManager dbpF = DBConnectionManager.getInstance();
		Connection coF = dbpF.getConnection("server");
		PreparedStatement stF = null;
		try {
			stF = coF.prepareStatement("select s.id from member m left join server_table s on m.serverid = s.id where member_username = ? order by last_time");
			stF.setString(1, request.getParameter("openid"));
			ResultSet rsF = stF.executeQuery();
			while(rsF.next()){
				serverid = rsF.getInt("id");
			}
			rsF.close();
			stF.close();
			coF.close();
			dbpF.freeConnection("server", coF);
		}catch(Exception e){
			e.printStackTrace();
		}
		//本地测试用
//		params.put("openid", "440BC8E0DBDC3DE79F1B3447DCC53561");
//		params.put("openkey", "3CDED6A76E68E639F6701CCFEE0858D8");
//		params.put("pf", "qzone");
		try {
			String resp = sdk.api(scriptName, (HashMap<String, String>) params,
					protocol);
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			List list = new ArrayList();
			Huangzuan h = new Huangzuan();
			h.setId(0);
			h.setName(resp);
			list.add(h);
			JSONArray obj = JSONArray.fromObject(list);
			out.println(obj.toString());
			out.close();
			//黄钻，更新数据库
		//	System.out.println("更新黄钻信息");
//			DBConnectionManager dbp = DBConnectionManager.getInstance();
//			Connection co = dbp.getConnection("server1");
//			Statement st = null;
			try {
				//st = co.createStatement();
				int id = Integer.parseInt(request.getParameter("id"));
//				int id = 1212;
				List<Map> resList = JSON.parseArray(String.valueOf("["+resp+"]"), Map.class);
				if(resList.get(0).get("is_yellow_vip")!=null){
					int huangzuan = Integer.parseInt(String.valueOf(resList.get(0).get("is_yellow_vip")));
					//int rs = st.executeUpdate("update game_role set huangzuan = '"+huangzuan+"' where id = " + id);
					
					//new Client(outIP, 8008).start();
					HashMap<String, Object> papa = new HashMap<String, Object>();
					HashMap<String, Object> infoMap=new HashMap<String, Object>();
					papa.put("roleid", id);
					papa.put("huangzuan", huangzuan);
					infoMap.put("_guid", 0);
					infoMap.put("_cachekey", "noCachekey");
					infoMap.put("_sig", "robot");
					infoMap.put("_serverId", 1);
					infoMap.put("_pid", 1);
					infoMap.put("_cmd", "sys.cacheGameRolethree");
					infoMap.put("_params", papa);
					infoMap.put("_key1", "1");
					infoMap.put("_key2", "0000");
					infoMap.put("_key3", "12");
					infoMap.put("_key3tang", "12");
					ClientManager cm = ClientManager.getInstance();
					cm.getClient(serverid).smcHander.sendData(infoMap);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			//st.close();
			//co.close();
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
