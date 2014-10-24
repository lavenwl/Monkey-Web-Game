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

import buyapi.QueueCache;
import buyapi.ThreadCache;

import com.alibaba.fastjson.JSON;
import com.qq.open.OpenApiV3;
import com.qq.open.OpensnsException;
import com.stang.game.entity.detail.ServerDetail;
import com.stang.game.ffd.client.Client;
import com.stang.game.ffd.client.ClientManager;

import dbconn.DBConnectionManager;
import entity.Huangzuan;

public class Share extends HttpServlet {
	public static QueueCache shareBeanQueue = null;
	public static ThreadShare thread = null;
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//public void service(int roleid, int serverid, int type, int i) throws ServletException, IOException {
		if(shareBeanQueue == null)
			shareBeanQueue = new QueueCache();
		if(thread == null){
			thread = new ThreadShare("share");
			thread.start();
		}
		ShareBean sb = new ShareBean();
		
		int id = Integer.parseInt(request.getParameter("id"));
		int type = Integer.parseInt(request.getParameter("type"));
		int serverId = Integer.valueOf(request.getParameter("serverId"));
		
		sb.setId(id);
		sb.setServerId(serverId);
		sb.setType(type);
		if(type == 0){
			sb.setNum0(Integer.parseInt(request.getParameter("num")));
		}
		
		
//		sb.setId(roleid);
//		sb.setNum0(i);
//		sb.setServerId(serverid);
//		sb.setType(type);
		
		
		shareBeanQueue.enqueue(sb);
		try {
			ClientManager cm = ClientManager.getInstance();
			response.setContentType("text/html;charset=UTF-8");
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private String getServerIp(int id){
		String IP = "";
		List<ServerDetail> serverlist = null;
		List<String> l = null;
		Home home  = new Home();
		serverlist = home.getServerList();
		l = new ArrayList<String>();
		for(int i = 0; i < serverlist.size(); i++){
			if(serverlist.get(i).getId() == id){
				IP = serverlist.get(i).getIp();
			}
		}
		return IP;
	}
}
