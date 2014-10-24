package com.stang.game.ffd.client;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.sojo.interchange.json.JsonSerializer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
//import org.codehaus.plexus.util.cli.shell.CmdShell;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.stang.game.ffd.common.GameConstants;
import com.stang.game.ffd.common.StangUtil;
import com.stang.game.ffd.common.StringUtil;
import com.stang.game.ffd.controller.ChatLogAction;
import com.stang.game.ffd.controller.CreateRaceAction;
import com.stang.game.ffd.controller.RejectAction;
import com.stang.game.ffd.controller.RejectIpAction;
import com.stang.game.ffd.controller.SendGiftAction;
import com.stang.game.ffd.entity.detail.GMRejectChatIdsDetail;
import com.stang.game.ffd.entity.detail.GMRejectIpsDetail;
import com.stang.game.ffd.entity.detail.GMRejectLoginIdsDetail;
import com.stang.game.ffd.service.IGMRejectIpsService;
import com.stang.game.ffd.service.impl.GMRejectChatIdsServiceImpl;
import com.stang.game.ffd.service.impl.GMRejectIpsServiceImpl;
import com.stang.game.ffd.service.impl.GMRejectLoginIdsServiceImpl;
import com.stang.game.ffd.service.impl.LogRejectServiceImpl;
import com.stang.game.ffd.service.impl.LogSendGiftDetailServiceImpl;

public class SamplMinaClientHander extends IoHandlerAdapter {
	IoSession is;
	private static PrintWriter log = null;
	final String[] htmlKeys1 = new String[5];
	final String[] htmlKeys2 = new String[5];

	public SamplMinaClientHander() {
		super();
		htmlKeys1[0] = "&";
		htmlKeys1[1] = "\"";
		htmlKeys1[2] = "'";
		htmlKeys1[3] = "<";
		htmlKeys1[4] = ">";
		htmlKeys2[0] = "&amp;";
		htmlKeys2[1] = "&quot;";
		htmlKeys2[2] = "&apos;";
		htmlKeys2[3] = "&lt;";
		htmlKeys2[4] = "&gt;";
		if(log == null){
			String logFile = "SamplMinaClientHandler.txt";
			try {
				log = new PrintWriter(new FileWriter(logFile, true), true);
			} catch (IOException e) {
				System.err.println("无法打开日志文件：" + logFile);
				log = new PrintWriter(System.err);
			}
			log("========================================SAMPLMINACLIENTHANDLER DEBUG BEGAIN==============================================================");
		
		}
		}

	public static void log(String msg) {
		log.println(new Date() + ":" + msg);
	}
	
	public IoSession getSession(){
		return this.is;
	}
	
	@Override
	public void exceptionCaught(IoSession arg0, Throwable arg1)
			throws Exception {
		// TODO Auto-generated method stub
		arg1.printStackTrace();
	}

	@Override
	public void messageReceived(IoSession session, Object messageO)
			throws Exception {
		Map<String, Object> object;
		try{
			object = (Map<String, Object>) JSON.parse(
				(byte[]) messageO, features);
		}catch (Exception e) {
			if(new String((byte[]) messageO).endsWith("##$$")){
				return;
			}
			e.printStackTrace();
			return;
		}
		//System.out.println(object.get("_cmd"));
		if (object.containsKey("_cmd") && object.containsKey("_cachekey")) {
			Object _cmd = object.get("_cmd"); /* 鎺ュ彛鍚嶇О */
			Object _param = object.get("_rlt"); /* 鍙傛暟 */
			Object _cachekey = object.get("_cachekey");
			Map<String, String> map = (Map) _param;

			String _cmdName = String.valueOf(_cmd);
			// System.out.println(_cmd);
			if (_cmdName.startsWith("cht.")) {
				// <root><message><chn>1</chn><fid>197</fid><aid>0</aid><toname>鍙戠粰璋?/toname><mess>鏈夋柊鐨勬秷鎭摝鍝﹀摝鍝?+i++
				// +"</mess><fname>绗戠瑧鐨勭尗</fname></message></root>
				String chn;
				if (_cmdName.equals("cht.send"))
					chn = map.get("chn");
				else
					chn = "6";// 绉佽亰
				String fid = map.get("fid");
				String aid = map.get("aid");
				String toname = StringUtil.uriDecode(map.get("toname"),
						GameConstants.FORMAT);
				String mess = StringUtil.uriDecode(map.get("mess"),
						GameConstants.FORMAT);
				String fname = StringUtil.uriDecode(map.get("fname"),
						GameConstants.FORMAT);
				String time = map.get("time");

				for (int i = 0; i < htmlKeys1.length; i++) {
					toname = toname.replaceAll(htmlKeys1[i], htmlKeys2[i]);
					mess = mess.replaceAll(htmlKeys1[i], htmlKeys2[i]);
					fname = fname.replaceAll(htmlKeys1[i], htmlKeys2[i]);
				}

				ChatLogAction.logQueue.add("<message><chn>" + chn
						+ "</chn><fid>" + fid + "</fid><aid>" + aid
						+ "</aid><toname>" + toname + "</toname><mess>" + mess
						+ "</mess><fname>" + fname + "</fname><time>" + time
						+ "</time></message>");
			} else if (_cmdName.equals("gm.createRace")||_cmdName.equals("gm.updateRace")||_cmdName.equals("gm.delRace")) {
				CreateRaceAction.cacheKeyList.add(_cachekey.toString());
			} else if (_cmdName.equals("gm.systemGift")) {
				//SendGiftAction.cacheKeyList.add(_cachekey.toString());
				HashMap<String, Object> param = SendGiftAction.cacheSqlMap
						.remove(_cachekey.toString());
				if (param == null) {
					return;
				}
				param.put("isSuccess", 1);
				new LogSendGiftDetailServiceImpl()
						.updateLogSendGiftDetail(param);
			} else if (_cmdName.equals("gm.reject")) {
				Map<String, Object> param = (Map) _param;
				Object _code = object.get("_code");
				int code = Integer.parseInt(_code.toString());
				if (code == 1) {
					param.put("isSuccess", 1);
				} else {
					param.put("isSuccess", 0);
				}
				RejectAction.cacheKeyList.add(_cachekey.toString());

				Date endTime = new Date();
				Date startTime = new Date();
				if (param.get("endTime") == null
						|| String.valueOf(param.get("endTime")).equals("")) {
					endTime = null;
				} else {
					DateFormat format = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					endTime = format.parse(String
							.valueOf((param.get("endTime"))));
				}
				Integer type = Integer.parseInt(String.valueOf(param
						.get("type")));
				Map[] insertMap = ((JSONArray) param.get("insertMap"))
						.toArray(new Map[0]);
				Map[] updateMap = ((JSONArray) param.get("updateMap"))
						.toArray(new Map[0]);
				if (type == 1) {

					GMRejectLoginIdsServiceImpl gmrlis = new GMRejectLoginIdsServiceImpl();
					if (insertMap.length > 0) {
						ArrayList<GMRejectLoginIdsDetail> insertList = new ArrayList<GMRejectLoginIdsDetail>();
						for (int i = 0; i < insertMap.length; i++) {
							GMRejectLoginIdsDetail gmr = new GMRejectLoginIdsDetail();
							gmr.setEndTime(endTime);
							gmr.setRoleId(Integer.parseInt(String
									.valueOf(insertMap[i].get("uId"))));
							gmr.setRoleName(String.valueOf(insertMap[i]
									.get("uname")));
							gmr.setStartTime(startTime);
							insertList.add(gmr);
						}
						gmrlis.insertGMRejectLoginIdsDetails(insertList);
					}
					if (updateMap.length > 0) {
						ArrayList<GMRejectLoginIdsDetail> updateList = new ArrayList<GMRejectLoginIdsDetail>();
						for (int i = 0; i < updateMap.length; i++) {
							GMRejectLoginIdsDetail gmr = new GMRejectLoginIdsDetail();
							gmr.setEndTime(endTime);
							gmr.setRoleId(Integer.parseInt(String
									.valueOf(updateMap[i].get("uId"))));
							gmr.setRoleName(String.valueOf(updateMap[i]
									.get("uname")));
							gmr.setStartTime(startTime);
							updateList.add(gmr);
						}
						gmrlis.updateGMRejectLoginIdsDetails(updateList);
					}

				}
				if (type == 2) {
					GMRejectChatIdsServiceImpl gmrlis = new GMRejectChatIdsServiceImpl();
					if (insertMap.length > 0) {
						ArrayList<GMRejectChatIdsDetail> insertList = new ArrayList<GMRejectChatIdsDetail>();
						for (int i = 0; i < insertMap.length; i++) {
							GMRejectChatIdsDetail gmr = new GMRejectChatIdsDetail();
							gmr.setEndTime(endTime);
							gmr.setRoleId(Integer.parseInt(String
									.valueOf(insertMap[i].get("uId"))));
							gmr.setRoleName(String.valueOf(insertMap[i]
									.get("uname")));
							gmr.setStartTime(startTime);
							insertList.add(gmr);
						}
						gmrlis.insertGMRejectChatIdsDetails(insertList);
					}
					if (updateMap.length > 0) {
						ArrayList<GMRejectChatIdsDetail> updateList = new ArrayList<GMRejectChatIdsDetail>();
						for (int i = 0; i < updateMap.length; i++) {
							GMRejectChatIdsDetail gmr = new GMRejectChatIdsDetail();
							gmr.setEndTime(endTime);
							gmr.setRoleId(Integer.parseInt(String
									.valueOf(updateMap[i].get("uId"))));
							gmr.setRoleName(String.valueOf(updateMap[i]
									.get("uname")));
							gmr.setStartTime(startTime);
							updateList.add(gmr);
						}
						gmrlis.updateGMRejectChatIdsDetails(updateList);
					}
				}
				param.put("startTime", startTime);
				param.put("endTime", endTime);
				HashMap<String, Object> addparam = RejectAction.cacheSqlMap
						.remove(_cachekey.toString());
				param.put("roleName", addparam.get("roleName"));
				param.put("opTime", addparam.get("opTime"));
				new LogRejectServiceImpl().updateLogRejectByParam(param);

			} else if (_cmdName.equals("gm.delReject")) {
				boolean isTimer = true;
				RejectAction.cacheKeyList.add(_cachekey.toString());
				Map<String, Object> param = (Map) _param;
				Integer type = Integer.parseInt(String.valueOf(param
						.get("type")));
				Integer roleId = Integer.parseInt(String.valueOf(param
						.get("roleId")));
				Map<String, Object> findMap = new HashMap<String, Object>();
				findMap.put("roleId", roleId);
				HashMap<String, Object> addparam = RejectAction.cacheSqlMap
						.remove(_cachekey.toString());
				if (addparam == null) {
					addparam = new HashMap<String, Object>();
					isTimer = false;
				}
				if (type == 1) {
					GMRejectLoginIdsDetail loginDetail = new GMRejectLoginIdsServiceImpl()
							.getGMRejectLoginIdsDetailByParam(findMap).get(0);
					addparam.put("roleName1", StringUtil.uriDecode(loginDetail
							.getRoleName(), GameConstants.FORMAT));
					addparam.put("startTime", loginDetail.getStartTime());
					addparam.put("endTime", loginDetail.getEndTime());
					new GMRejectLoginIdsServiceImpl()
							.deleteGMRejectLoginIdsDetailById(roleId);
				} else if (type == 2) {
					GMRejectChatIdsDetail chatDetail = new GMRejectChatIdsServiceImpl()
							.getGMRejectChatIdsDetailByParam(findMap).get(0);
					addparam.put("roleName1", StringUtil.uriDecode(chatDetail
							.getRoleName(), GameConstants.FORMAT));
					addparam.put("startTime", chatDetail.getStartTime());
					addparam.put("endTime", chatDetail.getEndTime());
					new GMRejectChatIdsServiceImpl()
							.deleteGMRejectChatIdsDetailById(roleId);
				}
				Object _code = object.get("_code");
				int code = Integer.parseInt(_code.toString());
				if (code == 1) {
					addparam.put("isSuccess", 1);
				} else {
					addparam.put("isSuccess", 0);
				}
				if (isTimer)
					new LogRejectServiceImpl().updateLogRejectByParam(addparam);
			} else if (_cmdName.equals("gm.rejectIps")) {
				RejectIpAction.cacheKeyList.add(_cachekey.toString());
				Map<String, Object> param = (Map) _param;
				Object _code = object.get("_code");
				HashMap<String, Object> uLogMap = RejectIpAction.cacheSqlMap
						.remove(_cachekey.toString());
				int code = Integer.parseInt(_code.toString());
				Date endTime = new Date();
				if (param.get("overTime") == null
						|| String.valueOf(param.get("overTime")).equals("")) {
					endTime = null;
				} else {
					DateFormat format = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					endTime = format.parse(String.valueOf((param
							.get("overTime"))));
				}
				if (code == 1) {
					uLogMap.put("isSuccess", 1);
					Date startTime = new Date();

					Map<String, Object> findMap = new HashMap<String, Object>();
					findMap.put("startIpNum", param.get("startIpNum"));
					findMap.put("endIpNum", param.get("endIpNum"));
					findMap.put("startIp", param.get("startIp"));
					findMap.put("endIp", param.get("endIp"));
					List<GMRejectIpsDetail> list = new GMRejectIpsServiceImpl()
							.findGMRejectIpsDetailByParam(findMap);

					GMRejectIpsDetail grid = new GMRejectIpsDetail();
					if (list.size() == 0) {
						GMRejectIpsDetail gmrid = new GMRejectIpsDetail();
						gmrid.setEndIp(String.valueOf(param.get("endIp")));
						gmrid.setEndIpNum(Long.parseLong(String.valueOf(param
								.get("endIpNum"))));
						gmrid.setOverTime(endTime);
						gmrid.setStartIp(String.valueOf(param.get("startIp")));
						gmrid.setStartIpNum(Long.parseLong(String.valueOf(param
								.get("startIpNum"))));
						gmrid.setStartTime(startTime);
						IGMRejectIpsService igmris = new GMRejectIpsServiceImpl();
						igmris.insertGMRejectIpsDetail(gmrid);
					} else {
						grid = list.get(0);
						Map<String, Object> uparam = new HashMap<String, Object>();
						uparam.put("id", grid.getId());
						uparam.put("overTime", endTime);
						uparam.put("startTime", startTime);
						new GMRejectIpsServiceImpl()
								.updateGMRejectIpsDetail(uparam);
						uparam = null;

					}
					grid = null;
					findMap = null;

				} else {
					uLogMap.put("isSuccess", 0);
				}
				new LogRejectServiceImpl().updateLogRejectByParam(uLogMap);
			} else if (_cmdName.equals("gm.delRejectIp")) {
				boolean isTimer = true;
				RejectIpAction.cacheKeyList.add(_cachekey.toString());
				Map<String, Object> param = (Map) _param;
				Object _code = object.get("_code");
				int code = Integer.parseInt(_code.toString());
				HashMap<String, Object> uLogMap = RejectIpAction.cacheSqlMap
						.remove(_cachekey.toString());
				if (uLogMap == null) {
					isTimer = false;
				}
				if (code == 1) {
					Map<String, Object> delMap = new HashMap<String, Object>();
					delMap.put("startIp", String.valueOf(param.get("startIp")));
					delMap.put("endIp", String.valueOf(param.get("endIp")));
					new GMRejectIpsServiceImpl()
							.deleteGMRejectIpsDetail(delMap);
					if (uLogMap == null) {
						return;
					}
					uLogMap.put("isSuccess", 1);
				} else {
					uLogMap.put("isSuccess", 0);
				}
				if (isTimer) {
					new LogRejectServiceImpl().updateLogRejectByParam(uLogMap);
				}
			}
		}
	}

	@Override
	public void messageSent(IoSession arg0, Object arg1) throws Exception {
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		//System.out.println("one client Disconnect");
		log("one client Disconnect");
	     is = null;
	}

	@Override
	public void sessionCreated(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub
		log("one client create!");
	}

	@Override
	public void sessionIdle(IoSession arg0, IdleStatus arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}
	Feature[] features = { Feature.AutoCloseSource,
			Feature.AllowUnQuotedFieldNames };
	private JsonSerializer jsonSerializer = new JsonSerializer();

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		this.is = session;
		log("===================sessionOpened========================");
	}

	public void sendData(HashMap<String, Object> data) {
		try {
			Thread.sleep(1100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object _sendMsg = jsonSerializer.serialize(data);
		byte []_sendInfo = JSON.toJSONBytes(data, SerializerFeature.DisableCircularReferenceDetect);
		//System.out.println(this.is.getRemoteAddress() + "Client send message:" + data.toString());
		log(this.is.getRemoteAddress() + "Client send message:" + data.toString());
		is.write(_sendInfo);
	}
}