package com.stang.game.ffd.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.stang.game.ffd.client.Client;
import com.stang.game.ffd.common.Config;
import com.stang.game.ffd.common.Response;
import com.stang.game.ffd.entity.detail.EntityKeyWordDetail;
import com.stang.game.ffd.entity.detail.LogRejectDetail;
import com.stang.game.ffd.service.ILogRejectService;
import com.stang.game.ffd.service.impl.GMRejectChatIdsServiceImpl;
import com.stang.game.ffd.service.impl.GMRejectLoginIdsServiceImpl;
import com.stang.game.ffd.service.impl.LogRejectServiceImpl;
import com.opensymphony.xwork2.Action;

public class RejectAction implements Action, ServletResponseAware,
		ServletRequestAware {
	private HttpServletResponse response;
	private HttpServletRequest request;
	private String[] unames;
	private String timeEnd;
	private String tip;
	private String rejectType;
	HashMap<String, Object> infoMap = new HashMap<String, Object>();
	private static Random random = new Random();
	public static Vector<String> cacheKeyList = new Vector<String>();
	public static ConcurrentHashMap<String, HashMap<String, Object>> cacheSqlMap = new ConcurrentHashMap<String, HashMap<String, Object>>();

	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

	boolean startSend() {
//		int i = 0;
//		while (!Client.flag) {
//			try {
//				Thread.sleep(20);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			i++;
//			if (i == 200) {
//				return false;
//			}
//		}
//
//		for (i = 0; i < 5; i++) {
//			if (Client.flag && Client.cf.isConnected()) {
//				Client.smcHander.sendData(infoMap);
//				return true;
//			}
//			try {
//				Thread.sleep(300);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}

		return false;
	}

	public String reject() throws Exception {
		HttpSession session = ((HttpServletRequest) request).getSession();
		String _cachekey = random.nextLong() + "";
		new Client(Config.getConfig("serverip"), 9200).start();

		infoMap.put("_guid", 0);
		infoMap.put("_cachekey", _cachekey);
		infoMap.put("_sig", "robot");
		infoMap.put("_serverId", 1);
		infoMap.put("_pid", 1);
		infoMap.put("_cmd", "gm.reject");
		Map<String, Object> params = new HashMap<String, Object>();
		if (unames == null) {
			tip = "ERROR!!WRONG OPERAT";
			return SUCCESS;
		}
		params.put("roleName", unames);
		if (timeEnd == null || timeEnd.equals("")) {
			params.put("endTime", null);
		} else {
			params.put("endTime", timeEnd);
		}
		// type=request.getParameter("type");
		params.put("type", rejectType);
		LogRejectDetail lrd = new LogRejectDetail();
		StringBuffer sbUnames = new StringBuffer(" ");
		for (String un : unames) {
			sbUnames.append("[" + un + "]");
		}
		lrd.setRoleName(sbUnames.toString());
		Date date = new Date();
		lrd.setOpTime(date);
		lrd.setType(Integer.parseInt(rejectType));
		lrd.setUid(Integer.parseInt((String
				.valueOf(session.getAttribute("uid")))));
		lrd.setUname(String.valueOf(session.getAttribute("uname")));
		ILogRejectService ilrs = new LogRejectServiceImpl();
		ilrs.insertLogReject(lrd);
		HashMap<String, Object> sqlProperty = new HashMap<String, Object>();
		sqlProperty.put("roleName", sbUnames.toString());
		sqlProperty.put("opTime", date);
		// SQL其他属性
		cacheSqlMap.put(_cachekey, sqlProperty);
		infoMap.put("_params", params);
		if (!startSend()) {
			tip = "UNKONWN ERROR!";
			return SUCCESS;
		}
		for (int i = 0; i < 5; i++) {
			Thread.sleep(500);
			// System.out.println(cacheKeyList.size());
			if (cacheKeyList.contains(_cachekey)) {
				tip = "SEND SUCCESS";
				cacheKeyList.remove(_cachekey);
				return SUCCESS;
			}
			Thread.sleep(1000);
		}
		tip = "SEND FAILURE!";
		return SUCCESS;
	}

	public String delReject() throws Exception {
		HttpSession session = ((HttpServletRequest) request).getSession();
		String role_id = request.getParameter("roleId");
		String _type = request.getParameter("type");
		String _cachekey = random.nextLong() + "";
		new Client(Config.getConfig("serverip"), 8000).start();

		LogRejectDetail lrd = new LogRejectDetail();

		infoMap.put("_guid", 0);
		infoMap.put("_cachekey", _cachekey);
		infoMap.put("_sig", "robot");
		infoMap.put("_serverId", 1);
		infoMap.put("_pid", 1);
		infoMap.put("_cmd", "gm.delReject");
		Map<String, Object> params = new HashMap<String, Object>();
		if (role_id == null || _type == null || role_id.equals("")
				|| _type.equals("")) {
			tip = "ERROR!!WRONG OPERAT";
			return SUCCESS;
		}
		int roleId = Integer.parseInt(role_id);
		int type = Integer.parseInt(_type);
		if (type == 1) {
			lrd.setType(3);
		} else if (type == 2) {
			lrd.setType(4);
		}
		params.put("type", type);
		params.put("roleId", roleId);
		infoMap.put("_params", params);
		Date date = new Date();

		lrd.setOpTime(date);
		lrd.setUid(Integer.parseInt((String
				.valueOf(session.getAttribute("uid")))));
		lrd.setUname(String.valueOf(session.getAttribute("uname")));
		ILogRejectService ilrs = new LogRejectServiceImpl();
		ilrs.insertLogReject(lrd);
		 HashMap<String, Object> sqlProperty= new HashMap<String, Object>();
		 sqlProperty.put("opTime", date);
		 sqlProperty.put("type", lrd.getType());
		 sqlProperty.put("uid", lrd.getUid());
		 sqlProperty.put("uname", lrd.getUname());
		 sqlProperty.put("flag", 1);
		 
		// SQL其他属性
		cacheSqlMap.put(_cachekey, sqlProperty);
		if (!startSend()) {
			tip = "UNKONWN ERROR!";
			return SUCCESS;
		}
		for (int i = 0; i < 5; i++) {
			Thread.sleep(500);
			// System.out.println(cacheKeyList.size());
			if (cacheKeyList.contains(_cachekey)) {
				tip = "SEND SUCCESS";
				cacheKeyList.remove(_cachekey);
				if (type == 1) {
					return "1";
				} else if (type == 2) {
					return "2";
				}
			}
			Thread.sleep(1000);
		}
		tip = "SEND FAILURE!";

		return "1";

	}

	public String[] getUnames() {
		return unames;
	}

	public void setUnames(String[] unames) {
		this.unames = unames;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRejectType() {
		return rejectType;
	}

	public void setRejectType(String rejectType) {
		this.rejectType = rejectType;
	}
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}

}
