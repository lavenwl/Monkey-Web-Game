package buyapi;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

public class Goods extends HttpServlet {
	private static PrintWriter logs;
	final static String appid = "100719210";
	final static String appkey = "cd9da8b634c25e0e2eb683fe56c1f268";
	static OpenApiV3 sdk = new OpenApiV3(appid, appkey);
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String logFile = "Goods.txt";
		try {
			logs = new PrintWriter(new FileWriter(logFile, true), true);
		} catch (IOException e) {
			System.err.println("无法打开日志文件：" + logFile);
			logs = new PrintWriter(System.err);
		}
		this.logs("==============================================GOODS DEBUG BEGAIN!=================================================================");
		
//		Send send = new Send();
//		send.service(request, response);
//		System.out.println("执行了send————————————————————————————————————————————————————————————方法：send");
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
		params.put("zoneid", request.getParameter("zoneid"));
		//System.out.println("goods得到的zoneid：" + request.getParameter("zoneid"));
		
		params.put("goodsmeta", request.getParameter("goodsmeta"));
		params.put("goodsurl", request.getParameter("goodsurl"));
		params.put("openid", request.getParameter("openid"));
		params.put("openkey", request.getParameter("openkey"));
		params.put("pf", request.getParameter("pf"));
		String openid = request.getParameter("openid");
		String zoneid = request.getParameter("zoneid");
		//判断payitem num
		String payitem = request.getParameter("payitem");
		//System.out.println(":::::::::::::::payitem::"+payitem);
		String[] strs = payitem.split("\\*");
		int itemid = Integer.parseInt(strs[0]);
		DBConnectionManager dbp = DBConnectionManager.getInstance();
		Connection co = dbp.getConnection("server" + zoneid);
		Connection coS = dbp.getConnection("server");
		Statement st = null;
		Statement stS = null;
		Statement sp = null;
		String payitem2=null;
		try {
			st = co.createStatement();
			ResultSet itemRes = st.executeQuery("select resCost,onsale from game_price where costType=2 and resId ='"+itemid+"'");
			int coin = 0;
			int onsale=0;
			while(itemRes.next()){
				coin = itemRes.getInt(1);
				onsale=itemRes.getInt(2);
			}
			//System.out.println(itemid+"itemid"+"coin原价====="+coin+"onsale打折价======="+onsale);
			if(itemid==281){
				coin=(int) (coin*0.15);
				params.put("appmode", String.valueOf(1));//不可修改数量
			}if(itemid==282){
				coin=(int) (coin*0.1);
				//System.out.println("::::::282::::::::::::");
				params.put("appmode", String.valueOf(1));//不可修改数量
			}if(itemid==283){
				coin=(int) (coin*0.2);
				params.put("appmode", String.valueOf(1));//不可修改数量
			}if(itemid==320){
				params.put("appmode", String.valueOf(1));//不可修改数量
			}
			/****/
			sp=co.createStatement();
			ResultSet shop = st.executeQuery("select month,day,monthend,dayend,discount from shopdiscount where flag=1");
			Calendar calendar = Calendar.getInstance();
			int month0 = calendar.get(Calendar.MONTH) + 1;
			int day0 = calendar.get(Calendar.DAY_OF_MONTH);
			int month=0;
			int day=0;
			int monthend=0;
			int dayend =0;
			int discount=0;
			while(shop.next()){
				month = shop.getInt(1);
			    day = shop.getInt(2);
				monthend =shop.getInt(3);
				dayend = shop.getInt(4);
			}
			if(month0==month&&month0==monthend){
				if(day0>=day&&day0<=dayend){
					if(onsale!=0){
						coin=(int)coin*onsale/10;
						//System.out.println("打折后的coin价格==="+coin);
					}
				}
				}else if(month0>=month&&month0<=monthend){
					if(onsale!=0){
						coin=(int)coin*onsale/10;
						//System.out.println("打折后的coin价格==="+coin);
					}
				}
			if(coin==0){
				return;//不存在
			}
			payitem = itemid+"*"+coin+"*"+1;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		//System.out.println("::::::::::::final:::payitem::"+payitem);
		params.put("payitem", payitem);
		//System.out.println(params.get("payitem")+"::::::payitem:::");
		this.logs("The data from request:params:" + params.toString());
		try {
			String resp = sdk.api(scriptName, (HashMap<String, String>) params, protocol);
			this.logs("Get data from tencent:resp:" + resp);
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
				this.logs("response to webpages:out.println:" + obj.toString());
				//将token保存到数据库
//				DBConnectionManager dbp = DBConnectionManager.getInstance();
//				Connection co = dbp.getConnection("server1");
//				Statement st = null;
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
				this.logs("insert into databases!");
			}
		} catch (OpensnsException e) {
			e.printStackTrace();
		} 
	}
	public static void logs(String msg) {
		logs.println(new Date() + ":" + msg);
	}
}
