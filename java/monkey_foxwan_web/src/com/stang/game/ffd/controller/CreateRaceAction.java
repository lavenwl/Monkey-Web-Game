package com.stang.game.ffd.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Action;
import com.stang.game.ffd.client.Client;
import com.stang.game.ffd.common.Config;
import com.stang.game.ffd.entity.detail.GameRaceConfDetail;
import com.stang.game.ffd.service.IGameRaceConfService;
import com.stang.game.ffd.service.impl.GameRaceConfServiceImpl;

public class CreateRaceAction implements Action, ServletResponseAware,
		ServletRequestAware {
	private HttpServletResponse response;
	private HttpServletRequest request;
	private String raceName;
	private Integer maxNum;
	private String startTime;
	private Integer teamNum;
	private String signUpStartTime;
	private String signUpEndTime;
	private Integer battleNum;
	private String[] map;
	private String[] items;
	private String tip;
	private Integer timeBetweenTwoTace;
	private String raceDes;
	private Integer batchRaceTime;
	private Integer batchRaceSpacing;
	private Integer startLevel;
	private Integer endLevel;
	private Integer signUpMoney;
	private Integer signUpMoneyType;
	private Integer raceId;
	public static Vector<String> cacheKeyList = new Vector<String>();
	private static Random random = new Random();
	private HashMap<String, Object> infoMap = new HashMap<String, Object>();

	public String[] getItems() {
		return items;
	}

	public void setItems(String[] items) {
		this.items = items;
	}

	public Integer getTimeBetweenTwoTace() {
		return timeBetweenTwoTace;
	}

	public void setTimeBetweenTwoTace(Integer timeBetweenTwoTace) {
		this.timeBetweenTwoTace = timeBetweenTwoTace;
	}
	public String delRace() throws Exception{
		int raceId=Integer.parseInt(request.getParameter("raceId")+"");
		String _cachekey = random.nextLong() + "";
			
		new Client(Config.getConfig("serverip"), 8000).start();
		infoMap = new HashMap<String, Object>();
		infoMap.put("_guid", 0);
		infoMap.put("_cachekey", _cachekey);
		infoMap.put("_sig", "robot");
		infoMap.put("_serverId", 1);
		infoMap.put("_pid", 1);
		infoMap.put("_cmd", "gm.delRace");
		Map<String, Object> _params = new HashMap<String, Object>();
		_params.put("id", raceId);
		IGameRaceConfService igrcf = new GameRaceConfServiceImpl();
		List<GameRaceConfDetail> grc = igrcf.getGameRaceConfDetail(_params);
		if(grc.size()<1){
			tip = "没有这场比赛";
			return SUCCESS;
		}
		if(grc.get(0).getFlag()!=1){
			tip = "只能删除未报名状态的比赛";
			return SUCCESS;
		}
		infoMap.put("_params", _params);
		if (!startSend()) {
			tip = "UNKONWN ERROR!";
			return SUCCESS;
		}
		for (int j = 0; j < 5; j++) {
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
	public String execute() throws Exception {
		String _cachekey = random.nextLong() + "";
		int i = 1;
		if ((raceName == null || raceName.equals(""))
				|| (maxNum == null || maxNum.equals(""))
				|| (startTime == null || startTime.equals(""))
				|| (teamNum == null || teamNum.equals(""))
				|| (signUpStartTime == null || signUpStartTime.equals(""))
				|| (signUpEndTime == null || signUpEndTime.equals(""))
				|| (battleNum == null || battleNum.equals(""))
				|| (map == null || map.length < 1)
				|| (request.getParameter("gifts1") == null)
				|| (raceDes == null || raceDes.equals(""))
				|| (batchRaceTime == null || batchRaceTime.equals(""))
				|| (batchRaceSpacing == null || batchRaceSpacing.equals(""))) {
			tip = "ERROR!!WRONG OPERAT";
			return SUCCESS;
		}
		new Client(Config.getConfig("serverip"), 8000).start();
		infoMap = new HashMap<String, Object>();
		infoMap.put("_guid", 0);
		infoMap.put("_cachekey", _cachekey);
		infoMap.put("_sig", "robot");
		infoMap.put("_serverId", 1);
		infoMap.put("_pid", 1);
		infoMap.put("_cmd", "gm.createRace");
		Map<String, Object> _params = new HashMap<String, Object>();
		_params.put("raceName", this.raceName);
		_params.put("raceDes", this.raceDes);
		_params.put("maxNum", this.maxNum);
		_params.put("startTime", this.startTime);
		_params.put("teamNum", this.teamNum);
		_params.put("signUpStartTime", this.signUpStartTime);
		_params.put("signUpEndTime", this.signUpEndTime);
		_params.put("battleNum", this.battleNum);
		_params.put("map", this.map);
		_params.put("items", this.items);
		_params.put("timeBetweenTwoTace", this.timeBetweenTwoTace * 1000 * 60);
		_params.put("batchRaceTime", this.batchRaceTime);
		_params.put("batchRaceSpacing", this.batchRaceSpacing);
		_params.put("startLevel", this.startLevel);
		_params.put("endLevel", this.endLevel);
		_params.put("signUpMoney", this.signUpMoney);
		_params.put("signUpMoneyType", this.signUpMoneyType);
		// 时间判定
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date sTime = format.parse(this.startTime);
		Date signUpStart = format.parse(this.signUpStartTime);
		Date signUpEnd = format.parse(this.signUpEndTime);
		if (sTime.getTime() < signUpEnd.getTime()
				|| signUpEnd.getTime() < signUpStart.getTime()) {
			tip = "比赛时间设置顺序出错！！！！！！！！";
			return SUCCESS;
		}
		Map<String, Object> giftMap = new HashMap<String, Object>();
		while (request.getParameter("gifts" + i) != null
				&& request.getParameter("content" + i) != null
				&& request.getParameter("title" + i) != null) {
			String gifts[] = request.getParameterValues("gifts" + i);
			String content = request.getParameter("content" + i);
			String title = request.getParameter("title" + i);
			List<Map<String, Integer>> list = new ArrayList<Map<String, Integer>>();
			for (String gift : gifts) {
				HashMap<String, Integer> map = new HashMap<String, Integer>();
				String[] g = gift.split("-");
				if (g.length != 4) {
					continue;
				}
				map.put("type", Integer.parseInt(g[0]));
				map.put("num", Integer.parseInt(g[1]));
				map.put("id", Integer.parseInt(g[2]));

				list.add(map);
			}
			giftMap.put("content" + i, content);
			giftMap.put("title" + i, title);
			giftMap.put("gifts" + i, list);
			i *= 2;
		}
		_params.put("giftMap", giftMap);
		infoMap.put("_params", _params);
		if (!startSend()) {
			tip = "UNKONWN ERROR!";
			return SUCCESS;
		}
		for (int j = 0; j < 5; j++) {
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

	public String updateRace() throws Exception {
		String _cachekey = random.nextLong() + "";
		int i = 1;
		IGameRaceConfService igrcs = new GameRaceConfServiceImpl();
		Map<String,Object> raceMap = new HashMap<String, Object>();
		raceMap.put("id", this.raceId);
		List<GameRaceConfDetail> grcdList = igrcs.getGameRaceConfDetail(raceMap);
		if(grcdList.size()<1){
			tip="没有这场比赛~~~";
			return SUCCESS;
		}
		GameRaceConfDetail grcd = grcdList.get(0);
		if(grcd.getFlag()!=1){
			tip="比赛只能在未开始报名的状态下修改！";
			return SUCCESS;
		}
		
		if ((raceName == null || raceName.equals(""))
				|| (maxNum == null || maxNum.equals(""))
				|| (startTime == null || startTime.equals(""))
				|| (teamNum == null || teamNum.equals(""))
				|| (signUpStartTime == null || signUpStartTime.equals(""))
				|| (signUpEndTime == null || signUpEndTime.equals(""))
				|| (battleNum == null || battleNum.equals(""))
				|| (map == null || map.length < 1)
				|| (request.getParameter("gifts1") == null)
				|| (raceDes == null || raceDes.equals(""))) {
			tip = "ERROR!!WRONG OPERAT";
			return SUCCESS;
		}
		new Client(Config.getConfig("serverip"), 8000).start();
		infoMap = new HashMap<String, Object>();
		infoMap.put("_guid", 0);
		infoMap.put("_cachekey", _cachekey);
		infoMap.put("_sig", "robot");
		infoMap.put("_serverId", 1);
		infoMap.put("_pid", 1);
		infoMap.put("_cmd", "gm.updateRace");
		Map<String, Object> _params = new HashMap<String, Object>();
		_params.put("id", this.raceId);
		_params.put("raceName", this.raceName);
		_params.put("raceDes", this.raceDes);
		_params.put("maxNum", this.maxNum);
		_params.put("startTime", this.startTime);
		_params.put("teamNum", this.teamNum);
		_params.put("signUpStartTime", this.signUpStartTime);
		_params.put("signUpEndTime", this.signUpEndTime);
		_params.put("battleNum", this.battleNum);
		_params.put("map", this.map);
		_params.put("items", this.items);
		_params.put("timeBetweenTwoTace", this.timeBetweenTwoTace * 1000 * 60);
		_params.put("batchRaceTime", this.batchRaceTime);
		_params.put("batchRaceSpacing", this.batchRaceSpacing);
		_params.put("startLevel", this.startLevel);
		_params.put("endLevel", this.endLevel);
		_params.put("signUpMoney", this.signUpMoney);
		_params.put("signUpMoneyType", this.signUpMoneyType);
		// 时间判定
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date sTime = format.parse(this.startTime);
		Date signUpStart = format.parse(this.signUpStartTime);
		Date signUpEnd = format.parse(this.signUpEndTime);
		if (sTime.getTime() < signUpEnd.getTime()
				|| signUpEnd.getTime() < signUpStart.getTime()) {
			tip = "比赛时间设置顺序出错！！！！！！！！";
			return SUCCESS;
		}
		Map<String, Object> giftMap = new HashMap<String, Object>();
		while (request.getParameter("gifts" + i) != null
				&& request.getParameter("content" + i) != null
				&& request.getParameter("title" + i) != null) {
			String gifts[] = request.getParameterValues("gifts" + i);
			String content = request.getParameter("content" + i);
			String title = request.getParameter("title" + i);
			List<Map<String, Integer>> list = new ArrayList<Map<String, Integer>>();
			for (String gift : gifts) {
				HashMap<String, Integer> map = new HashMap<String, Integer>();
				String[] g = gift.split("-");
				if (g.length != 4) {
					continue;
				}
				map.put("type", Integer.parseInt(g[0]));
				map.put("num", Integer.parseInt(g[1]));
				map.put("id", Integer.parseInt(g[2]));

				list.add(map);
			}
			giftMap.put("content" + i, content);
			giftMap.put("title" + i, title);
			giftMap.put("gifts" + i, list);
			i *= 2;
		}
		_params.put("giftMap", giftMap);
		infoMap.put("_params", _params);
		if (!startSend()) {
			tip = "UNKONWN ERROR!";
			return SUCCESS;
		}
		for (int j = 0; j < 5; j++) {
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
////			if (Client.flag && Client.cf.isConnected()) {
////				Client.smcHander.sendData(infoMap);
////				return true;
////			}
////			try {
////				Thread.sleep(300);
////			} catch (InterruptedException e) {
////				e.printStackTrace();
////			}
//		}

		return false;
	}

	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public String getRaceName() {
		return raceName;
	}

	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}

	public Integer getMaxNum() {
		return maxNum;
	}

	public void setMaxNum(Integer maxNum) {
		this.maxNum = maxNum;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Integer getTeamNum() {
		return teamNum;
	}

	public void setTeamNum(Integer teamNum) {
		this.teamNum = teamNum;
	}

	public String getSignUpStartTime() {
		return signUpStartTime;
	}

	public void setSignUpStartTime(String signUpStartTime) {
		this.signUpStartTime = signUpStartTime;
	}

	public String getSignUpEndTime() {
		return signUpEndTime;
	}

	public void setSignUpEndTime(String signUpEndTime) {
		this.signUpEndTime = signUpEndTime;
	}

	public Integer getBattleNum() {
		return battleNum;
	}

	public void setBattleNum(Integer battleNum) {
		this.battleNum = battleNum;
	}

	public String[] getMap() {
		return map;
	}

	public void setMap(String[] map) {
		this.map = map;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getRaceDes() {
		return raceDes;
	}

	public void setRaceDes(String raceDes) {
		this.raceDes = raceDes;
	}

	public Integer getBatchRaceTime() {
		return batchRaceTime;
	}

	public void setBatchRaceTime(Integer batchRaceTime) {
		this.batchRaceTime = batchRaceTime;
	}

	public Integer getBatchRaceSpacing() {
		return batchRaceSpacing;
	}

	public void setBatchRaceSpacing(Integer batchRaceSpacing) {
		this.batchRaceSpacing = batchRaceSpacing;
	}

	public Integer getStartLevel() {
		return startLevel;
	}

	public void setStartLevel(Integer startLevel) {
		this.startLevel = startLevel;
	}

	public Integer getEndLevel() {
		return endLevel;
	}

	public void setEndLevel(Integer endLevel) {
		this.endLevel = endLevel;
	}

	public Integer getSignUpMoney() {
		return signUpMoney;
	}

	public void setSignUpMoney(Integer signUpMoney) {
		this.signUpMoney = signUpMoney;
	}

	public Integer getSignUpMoneyType() {
		return signUpMoneyType;
	}

	public void setSignUpMoneyType(Integer signUpMoneyType) {
		this.signUpMoneyType = signUpMoneyType;
	}

	public Integer getRaceId() {
		return raceId;
	}

	public void setRaceId(Integer raceId) {
		this.raceId = raceId;
	}



}
