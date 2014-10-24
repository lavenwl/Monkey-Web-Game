package com.stang.game.ffd.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.stang.game.ffd.client.Client;
import com.stang.game.ffd.common.Config;
import com.stang.game.ffd.entity.detail.GMRejectChatIdsDetail;
import com.stang.game.ffd.entity.detail.GMRejectIpsDetail;
import com.stang.game.ffd.entity.detail.GMRejectLoginIdsDetail;
import com.stang.game.ffd.entity.detail.MessageManagerDetail;
import com.stang.game.ffd.service.IGMRejectChatIdsService;
import com.stang.game.ffd.service.IGMRejectIpsService;
import com.stang.game.ffd.service.IGMRejectLoginIdsService;
import com.stang.game.ffd.service.ILogRejectService;
import com.stang.game.ffd.service.impl.GMRejectChatIdsServiceImpl;
import com.stang.game.ffd.service.impl.GMRejectIpsServiceImpl;
import com.stang.game.ffd.service.impl.GMRejectLoginIdsServiceImpl;
import com.stang.game.ffd.service.impl.LogRejectServiceImpl;
import com.stang.game.ffd.service.impl.MessageManagerServiceImpl;

public class WebInitListener implements ServletContextListener {
	boolean flag = true;
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		flag=false;
	}

	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		new SendMessageTimer().start();
		new RejectCancelTimer().start();
	}

	
	class SendMessageTimer extends Thread {
		public void run() {
			MessageManagerServiceImpl getMessageManagerService = new MessageManagerServiceImpl();
			while (flag) {
				new Client(Config.getConfig("serverip"), 9200).start();
				Date nextTime = new Date();
				nextTime.setTime(nextTime.getTime() + 50000);
				List<MessageManagerDetail> msgl = getMessageManagerService
						.findMessageManagerByTime(nextTime);
				MessageManagerDetail mmd;
				for (int i = 0; i < msgl.size(); i++) {
					mmd = msgl.get(i);
					HashMap<String, Object> params = new HashMap<String, Object>();
					params.put("msg", mmd.getMessage());
					
					
					if (mmd.getType() == 2) {
						new Timer(params, mmd.getNext_time(),"gm.systemMessage","noCachekey").run();
					} else {
						params.put("href", mmd.getHerf());
						new Timer(params, mmd.getNext_time(),"gm.adMessage","noCachekey").run();
					}	
					mmd.setTimes(mmd.getTimes() - 1);
					if (mmd.getTimes() == 0) {
						getMessageManagerService.updateMessageManagerDetail(mmd);
						continue;
					}
					mmd.setNext_time(new Date(mmd.getNext_time().getTime()
							+ mmd.getInt_time() * 60 * 1000));
					for (; mmd.getInt_time() != 0 && mmd.getTimes() != 0
							&& mmd.getNext_time().before(new Date());) {
						mmd.setNext_time(new Date(mmd.getNext_time().getTime()
								+ mmd.getInt_time() * 60 * 1000));
					}
					getMessageManagerService.updateMessageManagerDetail(mmd);
				}

				try {
					Thread.sleep(50000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	class RejectCancelTimer extends Thread {
		public void run() {
			IGMRejectIpsService igmris = new GMRejectIpsServiceImpl();
			IGMRejectChatIdsService igmcis = new GMRejectChatIdsServiceImpl();
			IGMRejectLoginIdsService igmlis = new GMRejectLoginIdsServiceImpl();
			HashMap<String, Object> sqlParam = new HashMap<String, Object>();
			while (flag) {
				new Client(Config.getConfig("serverip"), 8000).start();
				Date nextTime = new Date();
				nextTime.setTime(nextTime.getTime() + 50000);
				sqlParam.put("endTime", nextTime);
				List<GMRejectIpsDetail> rids = igmris.findGMRejectIpsDetailByTime(sqlParam);
				for(GMRejectIpsDetail rid:rids){
					HashMap<String, Object> params = new HashMap<String, Object>();
					params.put("startIp", rid.getStartIp());
					params.put("endIp", rid.getEndIp());
					new Timer(params, rid.getOverTime(),"gm.delRejectIp","noCachekey").run();
				}
				List<GMRejectLoginIdsDetail> rlids = igmlis.findGMRejectLoginIdsDetailByTime(sqlParam);
				for(GMRejectLoginIdsDetail rlid:rlids){
					HashMap<String, Object> params = new HashMap<String, Object>();
					params.put("type", 1);
					params.put("roleId", rlid.getRoleId());
					new Timer(params, rlid.getEndTime(),"gm.delReject","noCachekey").run();
				}
				List<GMRejectChatIdsDetail> rcids = igmcis.findGMRejectChatIdsByTime(sqlParam);
				for(GMRejectChatIdsDetail rcid:rcids){
					HashMap<String, Object> params = new HashMap<String, Object>();
					params.put("type", 2);
					params.put("roleId", rcid.getRoleId());
					new Timer(params, rcid.getEndTime(),"gm.delReject","noCachekey").run();
				}
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	// 定时器 发送精度误差1秒
	class Timer extends Thread {
		private HashMap<String, Object> infoMap;
		private Date sendTime;

		public Timer(HashMap<String, Object> _params, Date sendTime,String _cmd ,String _cachekey) {
			infoMap = new HashMap<String, Object>();
			infoMap.put("_guid", 0);
			infoMap.put("_cachekey", _cachekey);
			infoMap.put("_sig", "robot");
			infoMap.put("_serverId", 1);
			infoMap.put("_pid", 1);
			infoMap.put("_cmd", _cmd);
			infoMap.put("_params", _params);
			this.sendTime = sendTime;
		}

		public void run() {
			while (flag&&sendTime.getTime() - new Date().getTime() > 0) {
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//startSend();

		}

//		boolean startSend() {
//			int i = 0;
//			while (!Client.flag) {
//				try {
//					Thread.sleep(20);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				i++;
//				if (i == 200) {
//					return false;
//				}
//			}
//
//			for (i = 0; i < 5; i++) {
//				if (Client.flag && Client.cf.isConnected()) {
//					Client.smcHander.sendData(infoMap);
//					return true;
//				}
//				try {
//					Thread.sleep(300);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//
//			return false;
//		}
	}
}
