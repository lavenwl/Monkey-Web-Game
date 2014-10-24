package com.stang.game.server.handler;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.sojo.interchange.json.JsonSerializer;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.mina.core.session.IoSession;

import com.stang.game.common.GameConstants;
import com.stang.game.entity.detail.ActivityDetail;
import com.stang.game.entity.detail.GameMilitaryDetail;
import com.stang.game.entity.detail.GameRoleDetail;
import com.stang.game.entity.detail.GameTaskDetail;
import com.stang.game.entity.detail.GameTowerDetail;
import com.stang.game.entity.detail.RoleDaytaskDetail;
import com.stang.game.entity.detail.RoleEquipDetail;
import com.stang.game.entity.detail.RoleImposeDetail;
import com.stang.game.entity.detail.RoleItemDetail;
import com.stang.game.entity.detail.RoleMapDetail;
import com.stang.game.entity.detail.RoleMilitaryDetail;
import com.stang.game.entity.detail.RoleTaskDetail;
import com.stang.game.server.ServerHandler;
import com.stang.game.service.IGameTowerService;
import com.stang.game.service.IGameVipService;
import com.stang.game.service.IRoleDaytaskService;
import com.stang.game.service.IRoleEquipService;
import com.stang.game.service.IRoleImposeService;
import com.stang.game.service.IRoleItemService;
import com.stang.game.service.IRoleMapService;
import com.stang.game.service.IRoleMilitaryService;
import com.stang.game.service.impl.GameTowerServiceImpl;
import com.stang.game.service.impl.GameVipServiceImpl;
import com.stang.game.service.impl.RoleDaytaskServiceImpl;
import com.stang.game.service.impl.RoleEquipServiceImpl;
import com.stang.game.service.impl.RoleImposeServiceImpl;
import com.stang.game.service.impl.RoleItemServiceImpl;
import com.stang.game.service.impl.RoleMapServiceImpl;
import com.stang.game.service.impl.RoleMilitaryServiceImpl;

public class TowerHandler extends BaseHandler {
	private static IRoleMapService roleMapService;
	private static IGameTowerService gameTowerService;
	private static IRoleMilitaryService roleMilitaryService;
	private static IRoleImposeService roleImposeService;
	private static IRoleItemService roleItemService;
	private static IRoleDaytaskService roleDaytask;

	
	private static IRoleEquipService roleEquipService;

	private IRoleEquipService getRoleEquipService() {
		if (roleEquipService == null) {
			roleEquipService = new RoleEquipServiceImpl();
		}
		return roleEquipService;
	}
	
	
	static private TaskHandler taskHandler;

	private TaskHandler getTaskHandler() {
		if (taskHandler == null) {
			taskHandler = new TaskHandler(gameApiName, globalIdentifier,
					encryptedSignature, playerId, cacheKey, params, session);
		}
		return taskHandler;
	}
	
	private IRoleDaytaskService getRoleDaytaskService() {
		if (roleDaytask == null) {
			roleDaytask = new RoleDaytaskServiceImpl();
		}
		return roleDaytask;
	}
	private IRoleMapService getRoleMapService() {
		if (roleMapService == null) {
			roleMapService = new RoleMapServiceImpl();
		}
		return roleMapService;
	}

	private IRoleMilitaryService getRoleMilitaryService() {
		if (roleMilitaryService == null) {
			roleMilitaryService = new RoleMilitaryServiceImpl();
		}
		return roleMilitaryService;
	}

	private IRoleItemService getRoleItemService() {
		if (roleItemService == null) {
			roleItemService = new RoleItemServiceImpl();
		}
		return roleItemService;
	}

	private IGameTowerService getGameTowerService() {
		if (gameTowerService == null) {
			gameTowerService = new GameTowerServiceImpl();
		}
		return gameTowerService;
	}

	private IRoleImposeService getRoleImposeService() {
		if (roleImposeService == null) {
			roleImposeService = new RoleImposeServiceImpl();
		}
		return roleImposeService;
	}

	private static IGameVipService gameVipService;

	private IGameVipService getGameVipService() {
		if (gameVipService == null) {
			gameVipService = new GameVipServiceImpl();
		}
		return gameVipService;
	}

	public TowerHandler(String gameApiName, String globalIdentifier,
			String encryptedSignature, String playerId, String cacheKey,
			Map params, IoSession session) {
		super(gameApiName, globalIdentifier, encryptedSignature, playerId,
				cacheKey, params, session);
		if (gameApiName.equals("tower.build")) {
			build();
			/** 建塔 */
		} else if (gameApiName.equals("tower.off")) {
			off();
			/** 拆塔 */
		} else if (gameApiName.equals("tower.militaryoff")) {
			militaryoff();
			/** 派离武将 */
		} else if (gameApiName.equals("tower.militaryon")) {
			militaryon();
			/** 武将上阵 */
		} else if (gameApiName.equals("tower.lueduo")) {
			lueduo();
			/** 点击掠夺,打开界面 */
		} else if (gameApiName.equals("tower.golueduo")) {
			golueduo();
			/** 进行掠夺 */
		} else if (gameApiName.equals("tower.ldjiasu")) {
			ldjiasu();
			/** 掠夺加速 */
		}else if (gameApiName.equals("tower.attack")) {
			attack();
			/** 开始战斗塔的攻击力 */
		}
	}

	private void attack() {
		Map<String, Object> rlt = new HashMap<String, Object>();
		rlt = (Map<String, Object>) session.getAttribute("zhandou");
	//	System.out.println("TowerHandler.attack():rlt:" + rlt.toString());
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);
		rlt=null;
	}

	private void ldjiasu() {
		int roleId = Integer.parseInt(playerId);
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> rlt = new HashMap<String, Object>();
		param.put("roleid", roleId);
		param.put("itemid", 2);
		List<RoleItemDetail> itm = this.getRoleItemService().getRoleItem(param);
		if (!itm.isEmpty()) {
			int numtitem=itm.get(0).getNum();
			if (itm.get(0).getNum() > 0) {
				Map<String, Object> p = new HashMap<String, Object>();
				p.put("roleid", roleId);
				p.put("id", itm.get(0).getId());
				p.put("num", 1);
				boolean bo = this.getRoleItemService().sbRoleItemNum(p);
				Map<String, Object> ps = new HashMap<String, Object>();
				ps.put("roleid", roleId);
				ps.put("imposetime", 0);
				this.getRoleImposeService().updateImpose(ps);
				ps = null;
				if (bo == true) {
					rlt.put("bid", itm.get(0).getId());
					rlt.put("numitem",numtitem-1);
				}
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				ServerHandler.sendData(session, respMap);
			}
		} else {
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);// 没加速用品
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "");
			ServerHandler.sendData(session, respMap);
		}
	}

	
	private void golueduo() {
		long ab = System.currentTimeMillis();
//		System.out.println("高掠夺开始" +  Integer.parseInt(playerId));
		if (params.containsKey("t") && params.containsKey("num")) {
			int roleId = Integer.parseInt(playerId);
			int t = Integer.parseInt(String.valueOf(params.get("t")));
//			int num = Integer.parseInt(String.valueOf(params.get("num")));// 消耗道具数量
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> rlt = new HashMap<String, Object>();
			GameRoleDetail gameRole = this.getGameRoleService().findRoleById(roleId);
			if(gameRole==null){
				return;
			}
			int vip = gameRole.getVip();
			if(vip<2){
				int huangzuan = 0;
				JsonSerializer json = new JsonSerializer();
				String Huangzuaninfo = this.getGameRoleService().findRoleById(roleId).getHuangzuaninfo();
				if("null".equals(String.valueOf(Huangzuaninfo))){
					
				}else{
					List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
					.deserialize(Huangzuaninfo);
					int ret = Integer.parseInt(String.valueOf(roleinfo.get(0).get("ret")));
					if(ret==0){
						huangzuan = Integer.parseInt(String.valueOf(roleinfo.get(0).get("is_yellow_vip")));
					}
				}
				if(huangzuan==1){
					vip =2;
				}
			}
			int top = this.getGameVipService().getGameVipByLe(vip).get(0).getQiangzhengTop();
			long date = new Date().getTime();
			List<RoleImposeDetail> impose = this.getRoleImposeService().getRoleImpose(roleId);
			if(impose.isEmpty()){
				return;
			}
			int level = gameRole.getLevel();
			if(t==1){// 普通征收
				if(impose.get(0).getImposenum()>=10){
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -5);// 今日已用完
					ServerHandler.sendData(session, respMap);
					return;
				}
				long time = impose.get(0).getImposetime()-date;
				if(time<=0){
					// 减少征收次数
					param.clear();
					param.put("roleid", roleId);
					param.put("imposenum", impose.get(0).getImposenum()+1);
					param.put("imposetime",date + 150 * 1000);
					this.getRoleImposeService().updateImpose(param);
					// 查看可以获得多少钱
					int yin = gameRole.getYin();
					int a = (int) (yin + 1500 + 5*Math.pow(level, 2)-25*level);
					this.getGameRoleService().upRoleYin(roleId, a);
					rlt.put("num", impose.get(0).getImposenum()+1);
					rlt.put("yin", a);
					rlt.put("timer", 150 * 1000);
					rlt.put("money", a-yin);
				}else if(time>0 && time<(12 * 60 * 1000)){
					// 减少征收次数
					param.clear();
					param.put("roleid", roleId);
					param.put("imposenum", impose.get(0).getImposenum()+1);
					param.put("imposetime",impose.get(0).getImposetime() + 150 * 1000);
					this.getRoleImposeService().updateImpose(param);
					// 查看可以获得多少钱
					int yin = gameRole.getYin();
					int a = (int) (yin + 1500 + 5*Math.pow(level, 2)-25*level);
					this.getGameRoleService().upRoleYin(roleId, a);
					rlt.put("num", impose.get(0).getImposenum()+1);
					rlt.put("yin", a);
					rlt.put("timer", impose.get(0).getImposetime() + 150 * 1000-date);
					rlt.put("money", a-yin);
				}else if(time>(12 * 60 * 1000)){
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);//等待冷却时间
					ServerHandler.sendData(session, respMap);
					return;
				}
				
			    RoleDaytaskDetail roletask = this.getRoleDaytaskService().findRoleDaytaskByRId(roleId);
			      int lueduo=roletask.getLueduo();
			      int abc=lueduo+1;
			      param.clear();
			      param.put("roleid",roleId);
			      param.put("lueduo", abc);
			 this.getRoleDaytaskService().updateRoleDaytask(param);
			
			//记录掠夺次数，完成5次掠夺任务
			int imposenum = this.getGameRoleService().findRoleById(roleId).getImposenum();
			//System.out.println("TowerHandler.294//记录掠夺次数，完成5次掠夺任务：" + imposenum);
			if(imposenum<=6){//多一个
				param.clear();
				param.put("id", roleId);
				param.put("imposenum", (imposenum+1));
			//	System.out.println("this.getGameRoleService().updateRoleVip(param);" + param.toString());
				this.getGameRoleService().updateRoleVip(param);
				//判断任务是否完成提示
				this.getTaskHandler().taskcomplete(roleId);
			}
			}else{
				
				
				//抢夺
				if (impose.get(0).getImposenums() >= top) {// 有没有机会征收
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -5);// 今日已用完
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "");
					ServerHandler.sendData(session, respMap);
					return;
				}
				
				/****/
				int whetherstrike=0;
				int multiple=1;//在设置的时间内奖品
				int month=0;
				int dayn=0;
				int monthend=0;
				int dayend=0;
				Calendar calendar = Calendar.getInstance();
				int month0 = calendar.get(Calendar.MONTH) + 1;
				int day0 = calendar.get(Calendar.DAY_OF_MONTH);
				params.clear();
				params.put("id", 21);
				List<ActivityDetail> activity=this.getActivityService().getActivityByParams(params);
				if(!activity.isEmpty()){
					whetherstrike=1;
					month = activity.get(0).getMonth();
					dayn = activity.get(0).getDay();
					monthend = activity.get(0).getMonthend();
					dayend = activity.get(0).getDayend();
					int serverid=activity.get(0).getServerid();
	               if(month0==month&&month0==monthend){
						if(day0>=dayn&&day0<=dayend){
				multiple=Integer.valueOf(String.valueOf(activity.get(0).getReward()));
				//System.out.println("活动强行掠夺   暴击:::::::::");
						}
						}else if(month0>=month&&month0<=monthend){
				multiple=Integer.valueOf(String.valueOf(activity.get(0).getReward()));
				//System.out.println("活动强行掠夺   暴击:::::::::");		
					}
				}
					
				/****/
				
				
				int num =impose.get(0).getImposenums();
				int itemnum = (num+2)/3;//本次减少掠夺领
				num = (num+3)/3;//下次显示需要多少掠夺领
//				System.out.println("itemnum:"+itemnum+">>>num:"+num);
				if (itemnum != 0) {
					param.clear();
					param.put("roleid", roleId);
					param.put("itemid", 11);
					List<RoleItemDetail> list = this.getRoleItemService().getRoleItem(param);
					if(list.isEmpty()){//掠夺令不足
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);
						ServerHandler.sendData(session, respMap);
						return;
					}
					if (list.get(0).getNum() - itemnum >= 0) {
						param.clear();
						param.put("roleid", roleId);
						param.put("id", list.get(0).getId());
		//				System.out.println("33Item:num:" + list.get(0).getNum());
						param.put("num", itemnum);
						this.getRoleItemService().sbRoleItemNum(param);
		//				System.out.println("33finish!!");
						rlt.put("bid", list.get(0).getId());
		//				System.out.println("33Item:num:" + list.get(0).getNum());
						rlt.put("numitem", list.get(0).getNum());//无缓存框架使用使用 - itemnum);
		//				System.out.println("33Item:num:" + list.get(0).getNum());
						param.clear();
						param.put("roleid", roleId);
						param.put("imposenums", impose.get(0).getImposenums()+1);
						this.getRoleImposeService().updateImpose(param);
						double n = Math.random();
						int yin = gameRole.getYin();
						if(whetherstrike==1){
							n=0.1;
						}
						if (n<=0.6) {
							int a = (int) (yin + (1500 + 5*Math.pow(level, 2)-25*level)*2*multiple);
							this.getGameRoleService().upRoleYin(roleId, a);
							rlt.put("yin", a);
							rlt.put("baoji", 1);
							rlt.put("money", a-yin);
							//System.out.println("强行掠夺原奖励："+( (1500 + 5*Math.pow(level, 2)-25*level)*2)+"强行掠夺活动奖励：："+((1500 + 5*Math.pow(level, 2)-25*level)*2*multiple));
						} else {
							int a = (int) (yin + 1500 + 5*Math.pow(level, 2)-25*level);
							this.getGameRoleService().upRoleYin(roleId, a);
							rlt.put("yin", a);
							rlt.put("baoji", 0);
							rlt.put("money", a-yin);
						}
						rlt.put("num", impose.get(0).getImposenums()+1);
						rlt.put("qz", num);
						
						list = null;
					} else {
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);// 抢夺令不足
						ServerHandler.sendData(session, respMap);
						return;
					}
				} else {
					rlt.put("bid", 0);
					param.clear();
					param.put("roleid", roleId);
					param.put("imposenums", impose.get(0).getImposenums()+1);
					this.getRoleImposeService().updateImpose(param);
					double n = Math.random();
					int yin = gameRole.getYin();
					if(whetherstrike==1){
						n=0.1;
					}
					if (n<0.6) {
						int a = (int) (yin + (1500 + 5*Math.pow(level, 2)-25*level)*2*multiple);
						this.getGameRoleService().upRoleYin(roleId, a);
						rlt.put("yin", a);
						rlt.put("baoji", 1);
						rlt.put("money", a-yin);
						//System.out.println("强行掠夺原奖励："+((1500 + 5*Math.pow(level, 2)-25*level)*2)+"强行掠夺活动奖励：："+((1500 + 5*Math.pow(level, 2)-25*level)*2*multiple));
					} else {
						int a = (int) (yin + 1500 + 5*Math.pow(level, 2)-25*level);
						this.getGameRoleService().upRoleYin(roleId, a);
						rlt.put("yin", a);
						rlt.put("baoji", 0);
						rlt.put("money", a-yin);
					}
					rlt.put("num", impose.get(0).getImposenums()+1);
					rlt.put("qz", 1);
					
				}
				
				RoleDaytaskDetail roletask = this.getRoleDaytaskService().findRoleDaytaskByRId(roleId);
				int qiangduo=roletask.getQiangduo();
				int abc=qiangduo+1;
				param.clear();
				param.put("roleid",roleId);
				param.put("qiangduo", abc);
				this.getRoleDaytaskService().updateRoleDaytask(param);;
			}
			rlt.put("t", t);

			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,GameConstants.GAME_API_SUCCESS);
			ServerHandler.sendData(session, respMap);
			rlt = null;
			param = null;
			gameRole = null;
			impose = null;
		}
		long b = System.currentTimeMillis();
//		System.out.println("掠夺结束" +  Integer.parseInt(playerId) + "用时：" + (b-ab));
	}
	

	private void lueduo() {
		long a = System.currentTimeMillis();
//		System.out.println("掠夺开始" +  Integer.parseInt(playerId));
		int roleId = Integer.parseInt(playerId);
		Map<String,Object> rlt = new HashMap<String,Object>();
		GameRoleDetail gameRole = this.getGameRoleService().findRoleById(roleId);
		if(gameRole==null){
			return;
		}
		int vip = gameRole.getVip();
		if(vip<2){
			int huangzuan = 0;
			JsonSerializer json = new JsonSerializer();
			String Huangzuaninfo = this.getGameRoleService().findRoleById(roleId).getHuangzuaninfo();
			if("null".equals(String.valueOf(Huangzuaninfo))){
				
			}else{
				List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
				.deserialize(Huangzuaninfo);
				int ret = Integer.parseInt(String.valueOf(roleinfo.get(0).get("ret")));
				if(ret==0){
					huangzuan = Integer.parseInt(String.valueOf(roleinfo.get(0).get("is_yellow_vip")));
				}
			}
			if(huangzuan==1){
				vip =2;
			}
		}
		int top = this.getGameVipService().getGameVipByLe(vip).get(0).getQiangzhengTop();
		long nowtime = new Date().getTime();
		long tt = gameRole.getTasktime();
		int day = (int) ((nowtime - tt) / 1000 / 60 / 60/24 + 1);
		//更新每日任务
		RoleDaytaskDetail roletask = this.getRoleDaytaskService().findRoleDaytaskByRId(roleId);
		if(roletask.getDay()<day){
			dayTask(roleId, day);
		}
		roletask=null;
		List<RoleImposeDetail> impose = this.getRoleImposeService().getRoleImpose(roleId);
		int num = 0;
		if(!impose.isEmpty()){
			int roleday = impose.get(0).getDay();
			num = impose.get(0).getImposenums();
			if (day == roleday) {
				rlt.put("imposenum", impose.get(0).getImposenum());
				rlt.put("imposenums", impose.get(0).getImposenums());
				if((impose.get(0).getImposetime()-nowtime)<=0){
					rlt.put("time", 0);
				}else{
					rlt.put("time", impose.get(0).getImposetime()-nowtime);
				}
			}else{
				//零点掠夺更新
	//			System.out.println("零点掠夺更新");
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("roleid", roleId);
				param.put("imposenum", 0);
				param.put("imposenums", 0);
				param.put("isnew", 1);
				param.put("day", day);
				param.put("imposetime", nowtime);
				this.getRoleImposeService().updateImpose(param);
				num = 0;
				rlt.put("imposenum", 0);
				rlt.put("imposenums", 0);
				rlt.put("time", 0);
				param = null;
			}
		}else{
			RoleImposeDetail aDetail = new RoleImposeDetail();
			aDetail.setRoleid(roleId);
			aDetail.setImposenum(0);
			aDetail.setImposenums(0);
			aDetail.setImposetime(0);
			aDetail.setDay(day);
			this.getRoleImposeService().insertRoleImpose(aDetail);
			rlt.put("imposenum", 0);
			rlt.put("imposenums", 0);
			rlt.put("time", 0);
			num = 0;
		}
		int level = gameRole.getLevel();
		rlt.put("coin",(int) (1500 + 5*Math.pow(level, 2)-25*level));
		rlt.put("qz", ((num+2)/3));
		rlt.put("top", top);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		ServerHandler.sendData(session, respMap);
		impose = null;
		gameRole = null;
		long b = System.currentTimeMillis();
//		System.out.println("掠夺结束" +  Integer.parseInt(playerId) + "用时：" + (b-a));
	}
	

	private void militaryon() {
		/** 武将上阵 */
		try {
			if (params.containsKey("mapid") && params.containsKey("placeid")
					&& params.containsKey("miltype")
					&& params.containsKey("mid")) {
				int roleId = Integer.parseInt(playerId);
				int mapid = Integer.parseInt(String
						.valueOf(params.get("mapid")));
				int placeid = Integer.parseInt(String.valueOf(params
						.get("placeid")));
				int miltype = Integer.parseInt(String.valueOf(params
						.get("miltype")));
				int militaryid = Integer.parseInt(String.valueOf(params
						.get("mid")));
				Map<String, Object> rlt = new HashMap<String, Object>();
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("roleId", roleId);
				param.put("mapid", mapid);
				param.put("militaryid", militaryid);
			//	System.out.println("TowerHandler();param:" + param.toString());
				List<RoleMapDetail> rolemap = this.getRoleMapService().getRoleMapByParam(param);
				//判断武将是否正确
				param.clear();
				param.put("roleId", roleId);
				param.put("id", militaryid);
				List<RoleMilitaryDetail> rmi = this.getRoleMilitaryService().getRoleMilitaryByparam(param);
				if(rmi.isEmpty()){//不是自己的武将
					return;
				}
				rmi=null;
				param = null;
				if (rolemap.isEmpty()) {
					Map<String, Object> params = new HashMap<String, Object>();
					params.put("roleId", roleId);
					params.put("mapid", mapid);
					params.put("placeid", placeid);
					List<RoleMapDetail> rolemaps = this.getRoleMapService()
							.getRoleMapByMapPlace(params);
					params = null;
					if (!rolemaps.isEmpty()) {
						List<GameTowerDetail> gametower = this
								.getGameTowerService().getGameTowerLevel(
										rolemaps.get(0).getTowerid());
						List<RoleMilitaryDetail> rolemil = this
								.getRoleMilitaryService().getRoleMilitarylevel(
										militaryid);
						if (!gametower.isEmpty() & !rolemil.isEmpty()) {
							int level = gametower.get(0).getLevel();
							int towertype = gametower.get(0).getType();
							int types = rolemil.get(0).getTypes();
							if (level <= types) {
								if (rolemaps.get(0).getMilitaryid() != 0) {
									respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);// 塔中有武将
								} else if (towertype == miltype) {
									Map<String, Object> p = new HashMap<String, Object>();
									p.put("roleId", roleId);
									p.put("id", rolemaps.get(0).getId());
									p.put("militaryid", militaryid);
									boolean bo = this.getRoleMapService()
											.updateRoleMap(p);
									if (bo == true) {
										rlt.put("mapid", mapid);
										rlt.put("placeid", placeid);
										rlt.put("militaryid", militaryid);
										respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
									}
								}
							} else {
								respMap
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
												-4);// 没等级不符
							}
						} else {
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									-3);// 没有此塔
						}
					}
					rolemap = null;
				} else {
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);// 武将已用
				}
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
				
			}
		} catch (Exception e) {
			GameConstants.log.warn("", e);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_ERROR_PROCESS_FAILURE);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
					GameConstants.GAME_API_ERROR_PROCESS_FAILURE_INFO);
		}
	}

	private void militaryoff() {
		/** 派离武将 */
		try {
			if (params.containsKey("mapid") && params.containsKey("placeid")) {
				int roleId = Integer.parseInt(playerId);
				int mapid = Integer.parseInt(String
						.valueOf(params.get("mapid")));
				int placeid = Integer.parseInt(String.valueOf(params
						.get("placeid")));
				Map<String, Object> rlt = new HashMap<String, Object>();
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("roleId", roleId);
				param.put("placeid", placeid);
				param.put("mapid", mapid);
				List<RoleMapDetail> rolemap = this.getRoleMapService()
						.getRoleMapByMapPlace(param);
				param = null;
				int id = 0;
				int oldid = 0;
				if (!rolemap.isEmpty()) {
					id = rolemap.get(0).getId();
					oldid = rolemap.get(0).getMilitaryid();
				}else{
					return;
				}
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("roleId", roleId);
				params.put("id", id);
				params.put("militaryid", 0);
				boolean bo = this.getRoleMapService().updateRoleMap(params);
				params = null;
				if (bo == true) {
					rlt.put("mapid", mapid);
					rlt.put("placeid", placeid);
					rlt.put("militaryid", 0);
					rlt.put("oldid", oldid);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
				} else {
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
				}
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
			}
		} catch (Exception e) {
			GameConstants.log.warn("", e);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_ERROR_PROCESS_FAILURE);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
					GameConstants.GAME_API_ERROR_PROCESS_FAILURE_INFO);
		}
	}

	private void off() {
		/** tower.off 拆塔 */
		try {
			if (params.containsKey("mapid") && params.containsKey("placeid")) {
				int roleId = Integer.parseInt(playerId);
				int mapid = Integer.parseInt(String
						.valueOf(params.get("mapid")));
				int placeid = Integer.parseInt(String.valueOf(params
						.get("placeid")));
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("roleId", roleId);
				param.put("placeid", placeid);
				param.put("mapid", mapid);
				List<RoleMapDetail> rolemap = this.getRoleMapService()
						.getRoleMapByMapPlace(param);
				param = null;
				int oldid = 0;
				int id = 0;
				if (!rolemap.isEmpty()) {
					oldid = rolemap.get(0).getMilitaryid();
					id = rolemap.get(0).getId();
				}else{
					return;
				}
				Map<String, Object> rlt = new HashMap<String, Object>();
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("roleId", roleId);
				params.put("id", id);
				params.put("militaryid", 0);
				params.put("towerid", 0);
				boolean bo = this.getRoleMapService().updateRoleMap(params);
				params = null;
				if (bo == true) {
					rlt.put("mapid", mapid);
					rlt.put("placeid", placeid);
					rlt.put("towerid", 0);
					rlt.put("militaryid", 0);
					rlt.put("oldid", oldid);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
					ServerHandler.sendData(session, respMap);
				}
			}
		} catch (Exception e) {
			GameConstants.log.warn("", e);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_ERROR_PROCESS_FAILURE);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
					GameConstants.GAME_API_ERROR_PROCESS_FAILURE_INFO);
		}
	}

	private void build() {
		/** 建塔 tower.build */
		try {
			if (params.containsKey("mapid") && params.containsKey("towerid")
					&& params.containsKey("placeid")) {
				int roleId = Integer.parseInt(playerId);
				int mapid = Integer.parseInt(String
						.valueOf(params.get("mapid")));
				int towerid = Integer.parseInt(String.valueOf(params
						.get("towerid")));
				int placeid = Integer.parseInt(String.valueOf(params
						.get("placeid")));
				Map<String, Object> rlt = new HashMap<String, Object>();
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("roleId", roleId);
				param.put("mapid", mapid);
				param.put("placeid", placeid);
				List<RoleMapDetail> list = this.getRoleMapService()
						.getRoleMapByMapPlace(param);
				Map<String, Object> params = new HashMap<String, Object>();
				if (list.isEmpty()) {
					int mid = this.getAutoIdService().fingKeyValueByTableName(
							"role_map");
					params.put("id", mid);
					params.put("roleId", roleId);
					params.put("placeid", placeid);
					params.put("mapid", mapid);
					params.put("militaryid", 0);
					params.put("towerid", towerid);
					params.put("flag", 1);
					boolean bo = this.getRoleMapService().insertRoleMap(params);
					if (bo == true) {
//						this.getAutoIdService()
//								.updateKeyValueAddOneByTableName("role_map");
						rlt.put("mapid", mapid);
						rlt.put("placeid", placeid);
						rlt.put("towerid", towerid);
					}
					params = null;
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
					ServerHandler.sendData(session, respMap);	
				} else {
					if (list.get(0).getTowerid() == 0) {
						params.put("roleId", roleId);
						params.put("towerid", towerid);
						params.put("militaryid", 0);
						params.put("id", list.get(0).getId());
						this.getRoleMapService().updateRoleMap(params);
						rlt.put("mapid", mapid);
						rlt.put("placeid", placeid);
						rlt.put("towerid", towerid);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
								rlt);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								GameConstants.GAME_API_SUCCESS);
						ServerHandler.sendData(session, respMap);
					} else {
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
								"");
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-1);
						ServerHandler.sendData(session, respMap);
					
					}
				
				}
				//判断是否有任务完成
				this.getTaskHandler().taskcomplete(roleId);
			}
		} catch (Exception e) {
			GameConstants.log.warn("", e);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_ERROR_PROCESS_FAILURE);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
					GameConstants.GAME_API_ERROR_PROCESS_FAILURE_INFO);
		}
	}
	
	/**
	 * 每日任务更新
	 * @param roleid
	 * @param day
	 */
	void dayTask(int roleid,int day){
		// 更新roledaytask
			Map<String, Object> paramd = new HashMap<String, Object>();
			JSONArray ary3 = new JSONArray();
			String baoxiang = ary3.toString();
			ary3.add(0, 0);
			ary3.add(1, 0);
			ary3.add(2, 0);
			ary3.add(3, 0);
			ary3.add(4, 0);
			ary3.add(5, 0);
			
			ary3.add(6, 0);
			ary3.add(7, 0);
			String integralstatue = ary3.toString();
			ary3.clear();
			ary3.add(0, 0);
			ary3.add(1, 0);
			ary3.add(2, 0);
			ary3.add(3, 0);
			
			ary3.add(4, 0);
			String box = ary3.toString();
			paramd.put("roleid", roleid);
			paramd.put("qianghua", 0);
			paramd.put("lueduo", 0);
			paramd.put("qiangduo", 0);
			paramd.put("zhaomu", 0);
			paramd.put("xiulian", 0);
			paramd.put("zhangdou", 0);
			paramd.put("baoxiang", baoxiang);
			paramd.put("integralstatue", integralstatue);
			paramd.put("box", box);
			
			paramd.put("middlerecruit", 0);
			paramd.put("toprecruit", 0);
			this.getRoleDaytaskService().updateRoleDaytask(paramd);
			paramd.clear();
			paramd.put("id", roleid);
			paramd.put("integral", 0);
			this.getGameRoleService().updateRoleintegral(paramd);
			paramd.clear();
			paramd.put("roleid", roleid);
			paramd.put("day", day);
			this.getRoleDaytaskService().updateRoleDaytask(paramd);
			paramd=null;
			ary3=null;
	 }
}
