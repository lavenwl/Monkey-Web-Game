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
 * 不能修改数量
 * @author Administrator
 *
 */
public class Goods2 extends HttpServlet {
	final static String appid = "100719210";
	final static String appkey = "cd9da8b634c25e0e2eb683fe56c1f268";
	static OpenApiV3 sdk = new OpenApiV3(appid, appkey);

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String serverName = "openapi.tencentyun.com";//正式上线用
		//String serverName = "119.147.19.43";
		sdk.setServerName(serverName);
		String scriptName = "/v3/pay/buy_goods";//点击购买按钮
		String protocol = "https";
		// 填充URL请求参数
		request.setCharacterEncoding("utf-8");
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("pfkey", request.getParameter("pfkey"));
		params.put("ts", String.valueOf(System.currentTimeMillis()/1000));
		params.put("appmode", String.valueOf(1));//不可修改数量
		params.put("zoneid",request.getParameter("zoneid"));
		//System.out.println("goods2得到的zoneid：" + request.getParameter("zoneid"));
		
		
		params.put("goodsmeta", request.getParameter("goodsmeta"));
		params.put("goodsurl", request.getParameter("goodsurl"));
		params.put("openid", request.getParameter("openid"));
		params.put("openkey", request.getParameter("openkey"));
		params.put("pf", request.getParameter("pf"));
		String openid = request.getParameter("openid");
		String zoneid = request.getParameter("zoneid");
		//判断payitem num
		String payitem = request.getParameter("payitem");
		String[] strs = payitem.split("\\*");
		int itemid = Integer.parseInt(strs[0]);
		DBConnectionManager dbp = DBConnectionManager.getInstance();
		Connection co = dbp.getConnection("server" + zoneid);
		Connection coS = dbp.getConnection("server");
		Statement st = null;
		Statement stS = null;
		try {
			st = co.createStatement();
			ResultSet itemRes = st.executeQuery("select resCost from game_price where costType=2 and resId ='"+itemid+"'");
			int coin = 0;
			while(itemRes.next()){
				coin = itemRes.getInt(1);
			}
			if(coin==0){
				return;//不存在
			}
			payitem = itemid+"*"+coin+"*"+"1";
			//判断是否达到一定等级
			ResultSet rs = st.executeQuery("select id from member where member_username='"+openid+"' and serverid = '" + zoneid + "'");
			int roleId = 0;
			while(rs.next()){
				roleId = rs.getInt("id");
			}
			if(roleId!=0){
				rs = st.executeQuery("select level,bylevel from game_role where id='"+roleId+"'");
				int level=1;
				String bylevel ="0";
				while(rs.next()){
					level = rs.getInt("level");
					bylevel = rs.getString("bylevel");
				}
				rs = st.executeQuery("select itemlevel from game_item where id='"+itemid+"'");
				int itemlevel = 0;
				while(rs.next()){
					itemlevel = rs.getInt("itemlevel");
				}
				if(itemlevel<=level){
					if(bylevel.contains(itemlevel+"")){
						return;
					}
				}else{
					return;
				}
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		params.put("payitem", payitem);
		
		try {
			//System.out.println("得到的参数：" +  params.toString());
			String resp = sdk.api(scriptName, (HashMap<String, String>) params,
					protocol);
			//System.out.println(resp+".............resp2");
			List<Map> list = JSON.parseArray("["+resp+"]",Map.class);
			if(Integer.parseInt(String.valueOf(list.get(0).get("ret")))==0){
				String url_params = String.valueOf(list.get(0).get("url_params"));
				String token = String.valueOf(list.get(0).get("token"));
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				
				List list2 = new ArrayList();
				Huangzuan h = new Huangzuan();
				h.setId(0);
				h.setName(url_params);
				list2.add(h);
				
				JSONArray obj = JSONArray.fromObject(list2);
				out.println(obj.toString());
				out.close();
				list2=null;
				obj=null;
				//将token保存到数据库
				try {
					st = co.createStatement();
					stS = coS.createStatement();
					ResultSet rs = st.executeQuery("select openid from delivery where openid ='"+openid+"' and zoneid = '" + zoneid + "'");
					ResultSet rsS = stS.executeQuery("select openid from delivery where openid ='"+openid+"' and zoneid = '" + zoneid + "'");
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
					dbp.freeConnection("server" + zoneid, co);
					dbp.freeConnection("server", coS);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			list=null;
			params=null;
		} catch (OpensnsException e) {
			e.printStackTrace();
		} 
	}
}
