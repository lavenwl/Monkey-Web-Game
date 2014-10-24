package com.stang.game.ffd.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Action;
import com.stang.game.ffd.client.Client;
import com.stang.game.ffd.common.Config;
import com.stang.game.ffd.common.GameConstants;
import com.stang.game.ffd.common.StringUtil;
import com.stang.game.ffd.service.impl.GameRoleServiceImpl;

public class ChatLogAction implements Action ,ServletResponseAware,ServletRequestAware{
	private HttpServletResponse response;
	private HttpServletRequest request;
	private static int i=0;
	private static boolean lastLogFlag = false;
	public static ConcurrentLinkedQueue<String> logQueue = new ConcurrentLinkedQueue<String>();
	public String execute() throws Exception {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml");
		PrintWriter out = response.getWriter();
		/**
		 * xml格式:
		 * <root>
		 * 		<message>
		 * 			<chn>1</chn><!--发消息的频道-->
		 * 			<fid>197</fid><!--发消息的ID-->
		 * 			<aid>0</aid><!--收消息的ID-->
		 * 			<toname>发给谁</toname>
		 * 			<mess>消息内容</mess>
		 * 			<fname>发消息的名字</fname>
		 * 		</message>
		 * </root>
		 */	
		

//		out.print("<root><message><chn>1</chn><fid>197</fid><aid>0</aid><toname>发给谁</toname><mess>有新的消息哦哦哦哦"+i++ +"</mess><fname>笑笑的猫</fname></message><message><chn>1</chn><fid>197</fid><aid>0</aid><toname>发给谁</toname><mess>有新的消息哦哦哦哦"+i++ +"</mess><fname>笑笑</fname></message></root>");
//		out.flush();
		if(logQueue.size()==0){
			out.print("<root>");
			out.print("</root>");
			out.flush();
			if(lastLogFlag){
				lastLogFlag = false;
				conServer();
			}else
			{
				lastLogFlag = true;
			}
		}else{
			out.print("<root>");
			String mess;
			while((mess=logQueue.poll())!=null){
				System.out.println(mess);
				out.print(mess);
			}
			out.print("</root>");
			out.flush();
		}
		return null;
	}
	private void conServer() {
//		new Client(Config.getConfig("serverip"), 8000).start();
//		HashMap<String, Object> infoMap = new HashMap<String, Object>();
//		infoMap.put("_guid", 0);
//		infoMap.put("_cachekey", "id:11key:11time:11111");
//		infoMap.put("_sig", "robot");
//		infoMap.put("_serverId", 1);
//		infoMap.put("_pid", 1);
//		infoMap.put("_cmd", "gm.ChatLog");
//		infoMap.put("_params", new HashMap<String, Object>());
//		while (!Client.flag) {
//			try {
//				Thread.sleep(20);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			i++;
//			if (i == 200) {
//				return;
//			}
//		}
//
//		for (i = 0; i < 5; i++) {
//			if (Client.flag && Client.cf.isConnected()) {
//				Client.smcHander.sendData(infoMap);
//				return;
//			}
//			try {
//				Thread.sleep(300);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}		
	}
	public String rejectChat() throws Exception {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("SUCCESS");
		out.flush();
		return null;
	}
	public String rejectLogin() throws Exception {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("SUCCESS");
		out.flush();
		return null;
	}

	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

}
