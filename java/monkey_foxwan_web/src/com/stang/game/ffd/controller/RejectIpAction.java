package com.stang.game.ffd.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Action;
import com.stang.game.ffd.client.Client;
import com.stang.game.ffd.common.Config;
import com.stang.game.ffd.common.StangUtil;
import com.stang.game.ffd.entity.detail.GMRejectIpsDetail;
import com.stang.game.ffd.entity.detail.LogRejectIpsDetail;
import com.stang.game.ffd.service.IGMRejectIpsService;
import com.stang.game.ffd.service.ILogRejectIpsService;
import com.stang.game.ffd.service.impl.GMRejectIpsServiceImpl;
import com.stang.game.ffd.service.impl.LogRejectIpsServiceImpl;
import com.stang.game.ffd.service.impl.LogSendGiftDetailServiceImpl;

public class RejectIpAction implements Action, ServletResponseAware,
		ServletRequestAware {
	private HttpServletResponse response;
	private HttpServletRequest request;
	private static Random random = new Random();
	private String timeEnd;
	private String startIp;
	private String endIp;
	private String tip;
	public static Vector<String> cacheKeyList = new Vector<String>();
	public static ConcurrentHashMap<String, HashMap<String, Object>> cacheSqlMap = new ConcurrentHashMap<String, HashMap<String, Object>>();

	HashMap<String, Object> infoMap = new HashMap<String, Object>();

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	public String getStartIp() {
		return startIp;
	}

	public void setStartIp(String startIp) {
		this.startIp = startIp;
	}

	public String getEndIp() {
		return endIp;
	}

	public void setEndIp(String endIp) {
		this.endIp = endIp;
	}

	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}

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

	public String addRejectIps() throws Exception {
		HashMap<String, Object> _params = new HashMap<String, Object>();
		HttpSession session = ((HttpServletRequest) request).getSession();
		String _cachekey = random.nextLong() + "";
		new Client(Config.getConfig("serverip"), 8000).start();
		IGMRejectIpsService igmris = new GMRejectIpsServiceImpl();
		infoMap = new HashMap<String, Object>();
		infoMap.put("_guid", 0);
		infoMap.put("_cachekey", _cachekey);
		infoMap.put("_sig", "robot");
		infoMap.put("_serverId", 1);
		infoMap.put("_pid", 1);
		infoMap.put("_cmd", "gm.rejectIps");

		ILogRejectIpsService ilris = new LogRejectIpsServiceImpl();
		LogRejectIpsDetail lrd = new LogRejectIpsDetail();
		HashMap<String, Object> sqlProperty = new HashMap<String, Object>(); // SQL其他属性

		if (timeEnd == null || timeEnd.equals("")) {
			_params.put("overTime", null);
			lrd.setOverTime(null);
			sqlProperty.put("ovetTime", null);
		} else {
			_params.put("overTime", timeEnd);
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			lrd.setOverTime(format.parse(timeEnd));
			sqlProperty.put("ovetTime", format.parse(timeEnd));
		}
		_params.put("startIpNum", StangUtil.ip2long(this.startIp));
		_params.put("endIpNum", StangUtil.ip2long(this.endIp));
		_params.put("startIp", this.startIp);
		_params.put("endIp", this.endIp);
		infoMap.put("_params", _params);

		Date opDate = new Date();
		// 插入日志

		lrd.setEndIp(this.endIp);
		lrd.setOpTime(opDate);
		lrd.setStartIp(this.startIp);
		lrd.setType(1);
		lrd.setUid(Integer.parseInt((String
				.valueOf(session.getAttribute("uid")))));
		lrd.setUname(String.valueOf(session.getAttribute("uname")));
		ilris.insertLogRejectIpsDetail(lrd);

		sqlProperty.put("endIp", this.endIp);
		sqlProperty.put("opTime", opDate);
		sqlProperty.put("startIp", this.startIp);
		sqlProperty.put("type", 1);
		sqlProperty.put("uid", Integer.parseInt((String.valueOf(session
				.getAttribute("uid")))));
		sqlProperty.put("uname", String.valueOf(session.getAttribute("uname")));
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
				return SUCCESS;
			}
			Thread.sleep(1000);
		}
		tip = "SEND FAILURE!";
		return SUCCESS;
	}

	public String delRejectIp() throws Exception {
		Date opDate = new Date();
		String _cachekey = random.nextLong() + "";
		new Client(Config.getConfig("serverip"), 8000).start();
		HttpSession session = ((HttpServletRequest) request).getSession();
		String startIp = request.getParameter("startIp");
		String endIp = request.getParameter("endIp");
		IGMRejectIpsService igmris = new GMRejectIpsServiceImpl();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("startIp", startIp);
		param.put("endIp", endIp);

		List<GMRejectIpsDetail> list = new GMRejectIpsServiceImpl()
				.findGMRejectIpsDetailByParam(param);
		if (list.size() > 0) {
			infoMap = new HashMap<String, Object>();
			infoMap.put("_guid", 0);
			infoMap.put("_cachekey", _cachekey);
			infoMap.put("_sig", "robot");
			infoMap.put("_serverId", 1);
			infoMap.put("_pid", 1);
			infoMap.put("_cmd", "gm.delRejectIp");
			infoMap.put("_params", param);

			// 插入日志
			ILogRejectIpsService ilris = new LogRejectIpsServiceImpl();
			LogRejectIpsDetail lrd = new LogRejectIpsDetail();
			lrd.setEndIp(endIp);
			lrd.setOpTime(opDate);
			lrd.setStartIp(startIp);
			lrd.setType(2);
			lrd.setUid(Integer.parseInt((String.valueOf(session
					.getAttribute("uid")))));
			lrd.setUname(String.valueOf(session.getAttribute("uname")));
			if (list.get(0).getOverTime() != null) {
				lrd.setOverTime(list.get(0).getOverTime());
			}else{
				lrd.setOverTime(null);
			}
			ilris.insertLogRejectIpsDetail(lrd);

			HashMap<String, Object> sqlProperty = new HashMap<String, Object>(); // SQL其他属性
			sqlProperty.put("endIp", endIp);
			sqlProperty.put("opTime", opDate);
			sqlProperty.put("startIp", startIp);
			sqlProperty.put("type", 2);
			sqlProperty.put("uid", Integer.parseInt((String.valueOf(session
					.getAttribute("uid")))));
			sqlProperty.put("uname", String.valueOf(session
					.getAttribute("uname")));
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
					return SUCCESS;
				}
				Thread.sleep(1000);
			}
			tip = "SEND FAILURE!";
			return SUCCESS;
		} else {
			tip = "SEND FAILURE!";
			return SUCCESS;
		}
	}
}
