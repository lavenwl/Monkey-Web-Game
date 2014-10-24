package apiinterface;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import org.apache.struts2.ServletActionContext;

import com.stang.game.entity.Server;
import com.stang.game.entity.detail.HostStatusDetail;
import com.stang.game.entity.detail.ServerDetail;
import com.stang.game.ffd.client.ClientManager;
import com.stang.game.service.IHostStatusService;
import com.stang.game.service.impl.HostStatusServiceImpl;

import dbconn.DBConnectionManager;



public class Home extends HttpServlet {
	private static IHostStatusService hostSatatusService=new HostStatusServiceImpl();
	public static ThreadServer thread = null;
	public static int home()throws ServletException, IOException {
		System.out.println("home Servlet!");
		int status = 0;
		String message = null;
		List<HostStatusDetail> hoststatus=hostSatatusService.getHostStatus();
		for(int j = 0; j < 5; j++){
			if(!hoststatus.equals(null)){
				break;
			}
		}
		int size=hoststatus.size();
		
		for(int i=0;i<size;i++){
			int id0=hoststatus.get(i).getId();
			if(id0==1){
				status=hoststatus.get(i).getStatus();
				message=hoststatus.get(i).getMessage();
			}
		}
			ServletActionContext.getRequest().setAttribute("message", message);
		System.out.println(status+"1========status========"+message+"========message============");
		return status;
	}
	public static int home(String openid, int s)throws ServletException, IOException {
		//System.out.println("home.home");
		if(thread == null){
			thread = new ThreadServer("server");
			thread.start();
		}
		int status = 0;
		DBConnectionManager dbp = DBConnectionManager.getInstance();
		Connection co = dbp.getConnection("server");
		Statement st = null;
		String oid = "";
		try {
			st = co.createStatement();
			ResultSet rs = st.executeQuery("select openid from test_player");
			while(rs.next()){
				oid = rs.getString(1);
				if(openid.equals(oid)){
					status = 1;
					break;
				}
			}
			rs.close();
			co.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		dbp.freeConnection("server", co);
		if(status!=1){
			//System.out.println("正常进入" + openid);
			String message = null;
			List<HostStatusDetail> hoststatus=hostSatatusService.getHostStatus();
			for(int j = 0; j < 5; j++){
				if(!hoststatus.equals(null)){
					break;
				}
			}
			int size=hoststatus.size();
			
			for(int i=0;i<size;i++){
				int id0=hoststatus.get(i).getId();
				if(id0==1){
					status=hoststatus.get(i).getStatus();
					message=hoststatus.get(i).getMessage();
				}
			}
			if(status == 0 || s == 0){
				ServletActionContext.getRequest().setAttribute("message", message);
			}
			
			//System.out.println(status+"2========status========"+message+"========message============");
			
			return status;
		}else{
			//System.out.println("测试进入");
			return 1;
		}
	}
	public static void main(String[] args) {
		
	}
	//推荐服务器
	public int getServerid(){
		System.out.println("home.getServerid");
		int serverid = 1;
		List<ServerDetail> serverlist = new ArrayList<ServerDetail>();
		DBConnectionManager dbp = DBConnectionManager.getInstance();
		Connection co = dbp.getConnection("server");
		Statement st = null;
		try {
			st = co.createStatement();
			ResultSet rs = st.executeQuery("select * from server_table");
			while(rs.next()){
				ServerDetail server = new ServerDetail();
				server.setId(rs.getInt("id"));
				server.setName(rs.getString("name"));
				server.setStatue_mag(rs.getInt("statue_mag"));
				server.setStatue_tui(rs.getInt("statue_tui"));
				server.setStatue_xin(rs.getInt("statue_xin"));
				server.setStatue_on(rs.getInt("statue_on"));
				serverlist.add(server);
			}
			co.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		dbp.freeConnection("server", co);
		
		int l = serverlist.size();
		if(l!=0){
			for(int i = 0; i < l; i++){
				ServerDetail server = serverlist.get(i);
				if(server.getStatue_on()==1){
					if(server.getStatue_tui()==1){
					i=l;
					serverid = server.getId();  
					}
				}
			}
		} 
		return serverid;
	}
	//最近服务器
	public ServerDetail getRoleServer(String member_Username){
		//System.out.println("home.getRoleServer member_username:" + member_Username);
		List<ServerDetail> roleServerlist = new ArrayList<ServerDetail>();
		DBConnectionManager dbp1 = DBConnectionManager.getInstance();
		Connection co1 = dbp1.getConnection("server");
		Statement st1 = null;
		try {
			st1 = co1.createStatement();
			ResultSet rs1 = st1.executeQuery("select m.last_time, st.* from server_table st left join member m on st.id = m.serverid where m.member_username ='" + member_Username + "' order by last_time desc");
			while(rs1.next()){
				ServerDetail server = new ServerDetail();
				server.setId(rs1.getInt("id"));
				server.setName(rs1.getString("name"));
				//System.out.println(rs1.getString("name"));
				server.setStatue_mag(rs1.getInt("statue_mag"));
				server.setStatue_tui(rs1.getInt("statue_tui"));
				server.setStatue_xin(rs1.getInt("statue_xin"));
				server.setStatue_on(rs1.getInt("statue_on"));
				server.setIp(rs1.getString("server_lip"));
				//System.out.println("last_time:" + rs1.getString("last_time"));
				if(rs1.getString("last_time").equals("0000-00-00 00:00:00")){
					continue;
				}
				server.setTime(rs1.getString("last_time"));
				roleServerlist.add(server);
				if(roleServerlist.size()>5){
					break;
				}
			}
			co1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		dbp1.freeConnection("server", co1);
		ServerDetail server = null;
		if(roleServerlist.size()>=1){
			server = roleServerlist.get(0);
		}else{
			server = getServer();
		}
	//	System.out.println("返回的serverid：" + server.getId());
		if(server.getId() == 666){
			server.setStatue_on(1);
		}
		return server;
	}
	
	//最近服务器
		public ServerDetail getRoleServerByServerid(int serverid){
			System.out.println("home.getRoleServerByServerid");
			List<ServerDetail> roleServerlist = new ArrayList<ServerDetail>();
			DBConnectionManager dbp1 = DBConnectionManager.getInstance();
			Connection co1 = dbp1.getConnection("server");
			Statement st1 = null;
			try {
				st1 = co1.createStatement();
				ResultSet rs1 = st1.executeQuery("select m.last_time, st.* from server_table st left join member m on st.id = m.serverid where m.serverid ='" + serverid + "' order by last_time desc");
				while(rs1.next()){
					ServerDetail server = new ServerDetail();
					server.setId(rs1.getInt("id"));
					server.setName(rs1.getString("name"));
					//System.out.println(rs1.getString("name"));
					server.setStatue_mag(rs1.getInt("statue_mag"));
					server.setStatue_tui(rs1.getInt("statue_tui"));
					server.setStatue_xin(rs1.getInt("statue_xin"));
					server.setStatue_on(rs1.getInt("statue_on"));
					server.setIp(rs1.getString("server_lip"));
					//System.out.println("last_time:" + rs1.getString("last_time"));
					if(rs1.getString("last_time").equals("0000-00-00 00:00:00")){
						continue;
					}
					server.setTime(rs1.getString("last_time"));
					roleServerlist.add(server);
					if(roleServerlist.size()>5){
						break;
					}
				}
				co1.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			dbp1.freeConnection("server", co1);
			ServerDetail server = null;
			if(roleServerlist.size()>=1){
				server = roleServerlist.get(0);
			}else{
				server = getServer();
			}
		//	System.out.println("返回的serverid：" + server.getId());
			if(server.getId() == 666){
				server.setStatue_on(1);
			}
			return server;
		}
	
	public ServerDetail getServer(){
		System.out.println("home.getServer");
		ServerDetail server1 = new ServerDetail();
		List<ServerDetail> serverlist = new ArrayList<ServerDetail>();
		DBConnectionManager dbp = DBConnectionManager.getInstance();
		Connection co = dbp.getConnection("server");
		Statement st = null;
		try {
			st = co.createStatement();
			ResultSet rs = st.executeQuery("select * from server_table");
			while(rs.next()){
				ServerDetail server = new ServerDetail();
				server.setId(rs.getInt("id"));
				server.setName(rs.getString("name"));
				server.setStatue_mag(rs.getInt("statue_mag"));
				server.setStatue_tui(rs.getInt("statue_tui"));
				server.setStatue_xin(rs.getInt("statue_xin"));
				server.setStatue_on(rs.getInt("statue_on"));
				server.setIp(rs.getString("server_lip"));
				serverlist.add(server);
			}
			co.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("freeConnection!");
		dbp.freeConnection("server", co);
		
		int l = serverlist.size();
		if(l!=0){
			for(int i = 0; i < l; i++){
				ServerDetail server = serverlist.get(i);
				if(server.getStatue_on()==1){
					if(server.getStatue_tui()==1){
					i=l;
					server1 = server;  
					}
				}
			}
		} 
		return server1;
	}
	
	public List<ServerDetail> getServerList(){
//		System.out.println("home.getServerList");
		List<ServerDetail> serverlist = new ArrayList<ServerDetail>();
		DBConnectionManager dbp = DBConnectionManager.getInstance();
		Connection co = dbp.getConnection("server");
		Statement st = null;
		try {
			st = co.createStatement();
			ResultSet rs = st.executeQuery("select * from server_table");
			while(rs.next()){
				ServerDetail server = new ServerDetail();
				server.setId(rs.getInt("id"));
				server.setName(rs.getString("name"));
				server.setStatue_mag(rs.getInt("statue_mag"));
				server.setStatue_tui(rs.getInt("statue_tui"));
				server.setStatue_xin(rs.getInt("statue_xin"));
				server.setStatue_on(rs.getInt("statue_on"));
				server.setIp(rs.getString("server_ip"));
				server.setOnline_num(rs.getInt("online_num"));
				serverlist.add(server);
			}
			co.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < serverlist.size(); i++){
			int serverid = serverlist.get(i).getId();
			//System.out.println("Home.serverid:" + serverid);
			Connection con = dbp.getConnection("server" + serverid);
	
			Statement stn = null;
			try {
				stn = con.createStatement();
				ResultSet rsn = stn.executeQuery("select * from server_table where id = " + serverid +"");
				while(rsn.next()){
					ServerDetail server = new ServerDetail();
					server.setId(rsn.getInt("id"));
					server.setName(rsn.getString("name"));
					server.setStatue_mag(rsn.getInt("statue_mag"));
					server.setStatue_tui(rsn.getInt("statue_tui"));
					server.setStatue_xin(rsn.getInt("statue_xin"));
					server.setStatue_on(rsn.getInt("statue_on"));
					server.setIp(rsn.getString("server_ip"));
					server.setOnline_num(rsn.getInt("online_num"));
					serverlist.get(i).setOnline_num(server.getOnline_num());
				}
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			dbp.freeConnection("server" + serverid, co);
		}
		dbp.freeConnection("server", co);
		return serverlist;
	}
	public boolean updateServer(Server server){
		System.out.println("home.updateServer");
		DBConnectionManager dbp = DBConnectionManager.getInstance();
		Connection co = dbp.getConnection("server");
		Statement st = null;
		boolean su = false;
		try {
			st = co.createStatement();
			int rs = st.executeUpdate("update server_table set name = '" + server.getName() + "', statue_mag = " + server.getStatue_mag() + ", statue_tui = " + server.getStatue_tui() + ", statue_xin = " + server.getStatue_xin() + ", statue_on = " + server.getStatue_on() + " where id = " + server.getId() + ";");
			co.close();
			su = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		dbp.freeConnection("server", co);
		return su;
	}
	public boolean addServer(ServerDetail server) {
		System.out.println("home.addServer");
		DBConnectionManager dbp = DBConnectionManager.getInstance();
		Connection co = dbp.getConnection("server");
		Statement st = null;
		boolean a = false;
		int id = 0;
		try {
			st = co.createStatement();
			st.execute("insert into server_table(name, statue_mag, statue_xin, statue_tui, statue_on) values('"+server.getName()+"','" + server.getStatue_mag() +"','" +server.getStatue_xin()+"','" + server.getStatue_tui()+"','" + server.getStatue_on()+"')");
			co.close();
			a = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		dbp.freeConnection("server", co);
		return a;
	
	}
	
}
