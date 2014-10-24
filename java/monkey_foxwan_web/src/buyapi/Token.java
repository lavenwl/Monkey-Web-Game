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
 * 黄钻送红将碎片
 * @author Administrator
 *
 */
public class Token extends HttpServlet {
	final static String appid = "100719210";
	final static String appkey = "cd9da8b634c25e0e2eb683fe56c1f268";
	static OpenApiV3 sdk = new OpenApiV3(appid, appkey);

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String serverName = "openapi.tencentyun.com";//正式上线用
		//System.out.println("tooooooooooooooooooooooooooooooooooooooooken");
		//String serverName = "119.147.19.43";
		sdk.setServerName(serverName);
		String scriptName = "/v3/pay/get_token";
		String protocol = "http";
		String serverId = request.getParameter("zoneid");
		// 填充URL请求参数
		request.setCharacterEncoding("utf-8");
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("pfkey", request.getParameter("pfkey"));
		params.put("tokentype", String.valueOf(1));
		params.put("discountid", String.valueOf("UM130704104643962"));//TODO
		params.put("ts", String.valueOf(System.currentTimeMillis()/1000));
		
		params.put("version", String.valueOf("v3"));
		
		params.put("openid", request.getParameter("openid"));
		params.put("openkey", request.getParameter("openkey"));
		params.put("pf", request.getParameter("pf"));
		String openid = request.getParameter("openid");
		String zoneid = request.getParameter("zoneid");
		params.put("zoneid", zoneid);
		
		try {
			String resp = sdk.api(scriptName, (HashMap<String, String>) params,
					protocol);
			//System.out.println("token response message:" + resp);
			List<Map> list = JSON.parseArray("["+resp+"]",Map.class);
						
			if(Integer.parseInt(String.valueOf(list.get(0).get("ret")))==0){
				String token = String.valueOf(list.get(0).get("token"));
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				
				List list2 = new ArrayList();
				Huangzuan h = new Huangzuan();
				h.setId(0);
				h.setName(token);
				list2.add(h);
				
				JSONArray obj = JSONArray.fromObject(list2);
				out.println(obj.toString());
				out.close();
				//将token保存到数据库
				DBConnectionManager dbp = DBConnectionManager.getInstance();
				Connection coS = dbp.getConnection("server");
				Connection co = dbp.getConnection("server" + serverId);
				Statement st = null;
				Statement stS = null;
				try {
					st = co.createStatement();
					stS = coS.createStatement();
					ResultSet rs = st.executeQuery("select openid from delivery where openid ='"+openid+"' and zoneid = '" + zoneid + "'");
					ResultSet rsS = st.executeQuery("select openid from delivery where openid ='"+openid+"' and zoneid = '" + zoneid + "'");
					String id ="0";
					String idS ="0";
					while(rs.next()){
						id = rs.getString("openid");
					}
					while(rsS.next()){
						idS = rsS.getString("openid");
					}
					if("0".equals(id)){//插入数据
						st.execute("insert into delivery(openid,token_id,zoneid) values('"+openid+"','"+token+"','" + zoneid + "')");
					}else{//更新
						st.executeUpdate("update delivery set token_id = '"+token+"',zoneid = '" + zoneid + "' where openid = '"+openid+"' and zoneid = '" + zoneid + "'");
					}
					if("0".equals(idS)){//插入数据
						stS.execute("insert into delivery(openid,token_id,zoneid) values('"+openid+"','"+token+"','" + zoneid + "')");
					}else{//更新
						stS.executeUpdate("update delivery set token_id = '"+token+"',zoneid = '" + zoneid + "' where openid = '"+openid+"' and zoneid = '" + zoneid + "'");
					}
					rs.close();
					st.close();
					co.close();
					rsS.close();
					stS.close();
					coS.close();
					dbp.freeConnection("server" + serverId, co);
					dbp.freeConnection("server", coS);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		} catch (OpensnsException e) {
			e.printStackTrace();
		} 
	}
}
