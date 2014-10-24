package buyapi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.qq.open.SigApi;
import com.stang.game.ffd.client.Client;
import com.stang.game.ffd.client.ClientManager;

import dbconn.DBConnectionManager;

public class Send extends HttpServlet{
	final static String appid = "100719210";
	final static String appkey = "cd9da8b634c25e0e2eb683fe56c1f268";
	public static QueueCache buyBeanQueue = null;
	public static ThreadCache thread = null;
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//public void service(int i) throws ServletException, IOException {
		if(buyBeanQueue == null)
			buyBeanQueue = new QueueCache();
		if(thread == null){
			thread = new ThreadCache("SendAPI");
			thread.start();
		}
		BuyBean bb = new BuyBean();
		//得到服务器的IP地址
		String openid = request.getParameter("openid");
		String payitem = request.getParameter("payitem")==null?"":request.getParameter("payitem");
		String billno = request.getParameter("billno");
		String zoneid = request.getParameter("zoneid");
		String amt = request.getParameter("amt")==null?"":request.getParameter("amt");
		String payamt_coins = request.getParameter("payamt_coins")==null?"":request.getParameter("payamt_coins");
		String token = request.getParameter("token");//备用
//		String openid = "5F15C42E27D3678EE10FC7DB1F243163";
//		String payitem = i + "*98*1";
//		String billno = "XXJZGW-20131006-0931427877";
//		String zoneid = "3";
//		String amt = "0";
//		String payamt_coins = "0";
//		String token = "";//备用
		int serverid = Integer.valueOf(zoneid);
		bb.setOpenid(openid);
		bb.setPayitem(payitem);
		bb.setBillno(billno);
		bb.setZoneid(zoneid);
		bb.setAmt(amt);
		bb.setPayamt_coins(payamt_coins);
		bb.setToken(token);
		bb.setServerid(serverid);
		buyBeanQueue.enqueue(bb);	
		
		//将数据保存在数据库
		String provide_errno = String.valueOf(0);
		ClientManager cm = ClientManager.getInstance();
		DBConnectionManager dbp = DBConnectionManager.getInstance();
		Connection co = dbp.getConnection("server" + zoneid);
		Connection coS = dbp.getConnection("server");
		PreparedStatement st = null;
		PreparedStatement stS = null;
		try {
			st = co.prepareStatement("select openid from delivery where openid =? and zoneid =?");
			st.setString(1, openid);
			st.setString(2, zoneid);
			ResultSet rs = st.executeQuery();
			String id ="0";
			while(rs.next()){
				id = rs.getString("openid");
			}
			if("0".equals(id)){//插入数据
				st = co.prepareStatement("insert into delivery(openid,payitem,token_id,billno,zoneid,provide_errno,amt,payamt_coins,status) values(?,?,?,?,?,?,?,?,1)");
				st.setString(1, openid);
				st.setString(2, payitem);
				st.setString(3, token);
				st.setString(4, billno);
				st.setString(5, zoneid);
				st.setString(6, provide_errno);
				st.setString(7, amt);
				st.setString(8, payamt_coins);
				st.execute();
			}else{//更新
				st = co.prepareStatement("update delivery set payitem =?,billno=?,zoneid=?,provide_errno=?,amt=?,payamt_coins=?,status=1 where openid = ?");
				st.setString(1, payitem);
				st.setString(2, billno);
				st.setString(3, zoneid);
				st.setString(4, provide_errno);
				st.setString(5, amt);
				st.setString(6, payamt_coins);
				st.setString(7, openid);
				st.executeUpdate();
			}
			stS = coS.prepareStatement("select openid from delivery where openid =? and zoneid =?");
			stS.setString(1, openid);
			stS.setString(2, zoneid);
			ResultSet rsS = stS.executeQuery();
			String idS ="0";
			while(rsS.next()){
				idS = rsS.getString("openid");
			}
			if("0".equals(idS)){//插入数据
				stS = coS.prepareStatement("insert into delivery(openid,payitem,token_id,billno,zoneid,provide_errno,amt,payamt_coins,status) values(?,?,?,?,?,?,?,?,1)");
				stS.setString(1, openid);
				stS.setString(2, payitem);
				stS.setString(3, token);
				stS.setString(4, billno);
				stS.setString(5, zoneid);
				stS.setString(6, provide_errno);
				stS.setString(7, amt);
				stS.setString(8, payamt_coins);
				stS.execute();
			}else{//更新
				stS = coS.prepareStatement("update delivery set payitem =?,billno=?,zoneid=?,provide_errno=?,amt=?,payamt_coins=?,status=1 where openid = ?");
				stS.setString(1, payitem);
				stS.setString(2, billno);
				stS.setString(3, zoneid);
				stS.setString(4, provide_errno);
				stS.setString(5, amt);
				stS.setString(6, payamt_coins);
				stS.setString(7, openid);
				stS.executeUpdate();
				
			}
			//记录当前购买的东西
			ThreadCache.log("note the payitem:" + payitem + " serverid:" + serverid + " openid:" + openid);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String currenttime = df.format(new Date());// new Date()为获取当前系统时间
			st = coS.prepareStatement("insert into buy(openid,payitem,time,serverid) values(?,?,?,?)");
			st.setString(1, openid);
			st.setString(2, payitem);
			st.setString(3, currenttime);
			st.setString(4, zoneid);
			st.execute();
			rs.close();
			st.close();
			co.close();
			rsS.close();
			stS.close();
			coS.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Map map = new HashMap();
		map.put("ret", 0);
		map.put("msg", "OK");//发货
		JSONObject obj = JSONObject.fromObject(map);
		out.println(obj);
		out.flush();
		out.close();
		map=null;
	}
}
