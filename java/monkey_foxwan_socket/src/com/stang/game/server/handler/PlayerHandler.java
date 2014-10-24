package com.stang.game.server.handler;

/**
 * @author wei
 * @company 上海三唐信息科技有限公司
 * @description 人物信息
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.net.*;

import com.stang.game.cache.*;

import net.sf.json.JSONArray;
import net.sf.sojo.interchange.json.JsonSerializer;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.mina.core.session.IoSession;

import com.alibaba.fastjson.JSON;
import com.stang.game.common.GameConstants;
import com.stang.game.entity.GameRole;
import com.stang.game.entity.Gametotem;
import com.stang.game.entity.Member;
import com.stang.game.entity.RoleDaytask;
import com.stang.game.entity.detail.ActivityDetail;
import com.stang.game.entity.detail.DeliveryDetail;
import com.stang.game.entity.detail.GamblingItemDetail;
import com.stang.game.entity.detail.GameEPropertyDetail;
import com.stang.game.entity.detail.GameEquipDetail;
import com.stang.game.entity.detail.GameItemDetail;
import com.stang.game.entity.detail.GameLevelDetail;
import com.stang.game.entity.detail.GameMapDetail;
import com.stang.game.entity.detail.GameMilitaryDetail;
import com.stang.game.entity.detail.GamePlatsDetail;
import com.stang.game.entity.detail.GamePriceDetail;
import com.stang.game.entity.detail.GameRoleDetail;
import com.stang.game.entity.detail.GameStarDetail;
import com.stang.game.entity.detail.GameTaskDetail;
import com.stang.game.entity.detail.GameVipDetail;
import com.stang.game.entity.detail.GametotemDetail;
import com.stang.game.entity.detail.HostDetail;
import com.stang.game.entity.detail.MemberDetail;
import com.stang.game.entity.detail.RoleDaytaskDetail;
import com.stang.game.entity.detail.RoleEquipDetail;
import com.stang.game.entity.detail.RoleInsDetail;
import com.stang.game.entity.detail.RoleItemDetail;
import com.stang.game.entity.detail.RoleMapDetail;
import com.stang.game.entity.detail.RoleMilitaryDetail;
import com.stang.game.entity.detail.RoleTaskDetail;
import com.stang.game.entity.detail.RoleTaskTaskDetail;
import com.stang.game.entity.detail.RoleTavernDetail;
import com.stang.game.entity.detail.RoletotemDetail;
import com.stang.game.entity.detail.ServerDetail;
import com.stang.game.server.ServerHandler;
import com.stang.game.service.IGameEInsService;
import com.stang.game.service.IGameEPropertyService;
import com.stang.game.service.IGameEquipService;
import com.stang.game.service.IGameLevelService;
import com.stang.game.service.IGameStarService;
import com.stang.game.service.IGameVipService;
import com.stang.game.service.IGametotemService;
import com.stang.game.service.IRoleDaytaskService;
import com.stang.game.service.IRoleEquipService;
import com.stang.game.service.IRoleImposeService;
import com.stang.game.service.IRoleInsService;
import com.stang.game.service.IRoleItemService;
import com.stang.game.service.IRoleMapService;
import com.stang.game.service.IRoleMilitaryService;
import com.stang.game.service.IRoleTavernService;
import com.stang.game.service.IRoletotemService;
import com.stang.game.service.IServerService;
import com.stang.game.service.impl.GameEInsServiceImpl;
import com.stang.game.service.impl.GameEPropertyServiceImpl;
import com.stang.game.service.impl.GameEquipServiceImpl;
import com.stang.game.service.impl.GameLevelServiceImpl;
import com.stang.game.service.impl.GameStarServiceImpl;
import com.stang.game.service.impl.GameVipServiceImpl;
import com.stang.game.service.impl.GametotemServiceImpl;
import com.stang.game.service.impl.RoleDaytaskServiceImpl;
import com.stang.game.service.impl.RoleEquipServiceImpl;
import com.stang.game.service.impl.RoleImposeServiceImpl;
import com.stang.game.service.impl.RoleInsServiceImpl;
import com.stang.game.service.impl.RoleItemServiceImpl;
import com.stang.game.service.impl.RoleMapServiceImpl;
import com.stang.game.service.impl.RoleMilitaryServiceImpl;
import com.stang.game.service.impl.RoleTavernServiceImpl;
import com.stang.game.service.impl.RoletotemServiceImpl;
import com.stang.game.service.impl.ServerServiceImpl;

public class PlayerHandler extends BaseHandler {

	static private Random random = new Random();
	private static Map<Integer, Integer> serveridmap = null;
	private static IRoleInsService roleInsService;

	private IRoleInsService getRoleInsService() {
		if (roleInsService == null) {
			roleInsService = new RoleInsServiceImpl();
		}
		return roleInsService;
	}

	private static IGameStarService gameStarService;

	private IGameStarService getGameStarService() {
		if (gameStarService == null) {
			gameStarService = new GameStarServiceImpl();
		}
		return gameStarService;
	}

	
	static private SystemHandler systemHandler;
	private SystemHandler getsystemHandler() {
		if (systemHandler == null) {
			systemHandler = new SystemHandler();
		}
		return systemHandler;
	}	
	
	private static IServerService ServerService;

	private static IServerService getServerService() {
		if (ServerService == null) {
			ServerService = new ServerServiceImpl();
		}
		return ServerService;
	}

	static private TaskHandler taskHandler;

	private TaskHandler getTaskHandler() {
		if (taskHandler == null) {
			taskHandler = new TaskHandler(gameApiName, globalIdentifier,
					encryptedSignature, playerId, cacheKey, params, session);
		}
		return taskHandler;
	}

	static private XiulianHandler xiulianHandler;

	private XiulianHandler getXiulianHandler() {
		if (xiulianHandler == null) {
			xiulianHandler = new XiulianHandler(gameApiName, globalIdentifier,
					encryptedSignature, playerId, cacheKey, params, session);
		}
		return xiulianHandler;
	}

	private static IRoleMapService roleMapService;

	private IRoleMapService getRoleMapService() {
		if (roleMapService == null) {
			roleMapService = new RoleMapServiceImpl();
		}
		return roleMapService;
	}

	private static IGametotemService gametotemService;

	private IGametotemService getGametotemService() {
		if (gametotemService == null) {
			gametotemService = new GametotemServiceImpl();
		}
		return gametotemService;
	}

	private static IRoleMilitaryService roleMilitaryService;

	private IRoleMilitaryService getRoleMilitaryService() {
		if (roleMilitaryService == null) {
			roleMilitaryService = new RoleMilitaryServiceImpl();
		}
		return roleMilitaryService;
	}

	private static IGameLevelService gameLevelService;

	private IGameLevelService getGameLevelService() {
		if (gameLevelService == null) {
			gameLevelService = new GameLevelServiceImpl();
		}
		return gameLevelService;
	}

	private static IGameEquipService gameEquipService;

	private IGameEquipService getGameEquipService() {
		if (gameEquipService == null) {
			gameEquipService = new GameEquipServiceImpl();
		}
		return gameEquipService;
	}

	private static IGameEPropertyService gameEPropertyService;

	private IGameEPropertyService getGameEPropertyService() {
		if (gameEPropertyService == null) {
			gameEPropertyService = new GameEPropertyServiceImpl();
		}
		return gameEPropertyService;
	}

	private static IRoletotemService roletotemService;

	private IRoletotemService getRoletotemService() {
		if (roletotemService == null) {
			roletotemService = new RoletotemServiceImpl();
		}
		return roletotemService;
	}

	private static IGameEInsService gameEInsService;

	private IGameEInsService getGameEInsService() {
		if (gameEInsService == null) {
			gameEInsService = new GameEInsServiceImpl();
		}
		return gameEInsService;
	}

	private static IRoleEquipService roleEquipService;

	private IRoleEquipService getRoleEquipService() {
		if (roleEquipService == null) {
			roleEquipService = new RoleEquipServiceImpl();
		}
		return roleEquipService;
	}

	private static IRoleItemService roleItemService;

	private IRoleItemService getRoleItemService() {
		if (roleItemService == null) {
			roleItemService = new RoleItemServiceImpl();
		}
		return roleItemService;
	}

	private static IRoleTavernService roleTavernService;

	private IRoleTavernService getRoleTavernService() {
		if (roleTavernService == null) {
			roleTavernService = new RoleTavernServiceImpl();
		}
		return roleTavernService;
	}

	private static IGameVipService gameVipService;

	private IGameVipService getGameVipService() {
		if (gameVipService == null) {
			gameVipService = new GameVipServiceImpl();
		}
		return gameVipService;
	}

	private static IRoleImposeService roleImposeService;

	private IRoleImposeService getRoleImposeService() {
		if (roleImposeService == null) {
			roleImposeService = new RoleImposeServiceImpl();
		}
		return roleImposeService;
	}

	private static IRoleDaytaskService roleDaytask;

	private IRoleDaytaskService getRoleDaytaskService() {
		if (roleDaytask == null) {
			roleDaytask = new RoleDaytaskServiceImpl();
		}
		return roleDaytask;
	}

	public PlayerHandler(String gameApiName, String globalIdentifier,
			String encryptedSignature, String playerId, String cacheKey,
			Map params, IoSession session) {
		super(gameApiName, globalIdentifier, encryptedSignature, playerId,
				cacheKey, params, session);
		if (gameApiName.equals("ply.get")) {
			get();
			/** 得到玩家信息 */
		} else if (gameApiName.equals("ply.create")) {
			create();
			/** 创建玩家信息 */
		} else if (gameApiName.equals("ply.buyres")) {
			buyres();
			/** 购买物品 */
		} else if (gameApiName.equals("ply.delres")) {
			delres();
			/** 出售物品 */
		} else if (gameApiName.equals("ply.recruit")) {
			recruit();
			/** 招募武将 */
		} else if (gameApiName.equals("ply.kqzm")) {
			kqzm();
			/** 点击酒馆 */
		} else if (gameApiName.equals("ply.buymilitary")) {
			buymilitary();
			/** 购买武将 */
		} else if (gameApiName.equals("ply.taskStartOnLine")) {
			taskStartOnLine();
			/** 三日在线礼包，每日礼包 */
		} else if (gameApiName.equals("ply.getTaskGift")) {
			getTaskGift();
			/** 三日在线礼包，每日礼包,领取 */
		} else if (gameApiName.equals("ply.intensify")) {
			intensify();
			/** 强化页面登录 */
		} else if (gameApiName.equals("ply.getintensify")) {
			getintensify();
			/** 强化 */
		} else if (gameApiName.equals("ply.cleartime")) {
			cleartime();
			/** 强化加速 */
		} else if (gameApiName.equals("ply.giftseven")) {
			/** 七天在线领取礼物 */
			giftseven();
		} else if (gameApiName.equals("ply.receive")) {
			/** 领取七天礼包 */
			receive();
		} else if (gameApiName.equals("ply.attendance")) {
			/** 签到打开界面 */
			attendance();
		} else if (gameApiName.equals("ply.sign")) {
			/** 签到 */
			sign();
		} else if (gameApiName.equals("ply.supplement")) {
			/** 补签 */
			supplement();
		} else if (gameApiName.equals("ply.daysreceive")) {
			/** 领取连续几天签到的奖励 */
			daysreceive();
		} else if (gameApiName.equals("ply.gameover")) {
			/** 战斗结束，获得奖励 */
			gameover();
		} else if (gameApiName.equals("ply.yamashitarob")) {
			/** 下山掠夺 */
			yamashitarob();
		} else if (gameApiName.equals("ply.dailyquest")) {
			/** 每日任务 */
			dailyquest();
		} else if (gameApiName.equals("ply.dailyreward")) {
			/** 完成每日任务获得的奖励 */
			dailyreward();
		} else if (gameApiName.equals("ply.itemgift")) {
			/** 购买领取奖励 */
			this.itemgift();
		} else if (gameApiName.equals("ply.supplementsign")) {
			/** 补签 */
			this.supplementsign();
		} else if (gameApiName.equals("ply.awakemahatmagift")) {
			/** 唤醒大圣许心愿领取礼物 */
			this.awakemahatmagift();
		}
	}

	private void rolename() {
		if(params.containsKey("name")){
			String name = String.valueOf(params.get("name"));
			int roleid = Integer.parseInt(String.valueOf(playerId));
			List<GameRoleDetail> gr = this.getGameRoleService().findAllGameRole();
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> rlt = new HashMap<String, Object>();
			int name1 = 0;//如果有重名的就返回1
			for(int i = 0 ;i<gr.size();i++){
				String names = gr.get(i).getName();
				if(names.equals(name)){
					name1 = 1;
					break;
				}
			}
			if(name1==0){
				param.put("roleid", roleid);
				param.put("name", name);
				this.getGameRoleService().cacheGameRolethree(param);
			}
			rlt.put("ids", name1);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
					rlt);
			ServerHandler.sendData(session, respMap);
			rlt=null;
		}
		
	}

	public PlayerHandler() {
		// TODO Auto-generated constructor stub
	}

	private void awakemahatmagift() {// 唤醒大圣许心愿领取礼物
		if (params.containsKey("num") && params.containsKey("t")) {// 领取第几个奖励
			// 0-6
			int num = Integer.valueOf(String.valueOf(params.get("num")));
			int t = Integer.valueOf(String.valueOf(params.get("t")));
			// System.out.println("前端传递过来的t::"+t+"    num::"+num);
			int roleid = Integer.parseInt(String.valueOf(playerId));
			GameRoleDetail role = this.getGameRoleService()
					.findRoleById(roleid);
			Map<String, Object> param = new HashMap<String, Object>();
			String awakenstatu = role.getAwakenstatu();
			JSONArray statu = JSONArray.fromObject(awakenstatu);// 目标大奖状态 0：没完成
			// 1：可以领取 2：已领取
			if (t == 1) {// 前7个大圣的奖励 前端传递num 0-6
				if (statu.getInt(num) == 1) {// 可以领取奖励
					List<GameTaskDetail> list = new ArrayList();
					list = this.getGameTaskService().getGameTaskDetailById(
							2000 + num);
					String task = list.get(0).getTaskres();
					List<Map> tasks = JSON.parseArray(String.valueOf(task),
							Map.class);
					JSONArray temptask = new JSONArray();
					Map<String, JSONArray> result = collect(tasks, roleid);
					JSONArray flag = result.get("flag");
					if (!flag.contains(false)) {
						Map<String, Object> rlt = new HashMap<String, Object>();
						temptask = result.get("temptask");
						rlt.put("reward", temptask);
						rlt.put("t", t);
						rlt.put("num", num);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								GameConstants.GAME_API_SUCCESS);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
								rlt);
						ServerHandler.sendData(session, respMap);
						// 领取奖励之后更新状态
						statu.set(num, 2);
						param.clear();
						param.put("id", roleid);
						param.put("awakenstatu", statu.toString());
						this.getGameRoleService().updateRoleVip(param);

						// for 结束后加改变state状态，存入数据库
					} else {// 背包空间不足
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-6);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
								"背包空间不足");
						ServerHandler.sendData(session, respMap);
					}
				} else {
					// 已经领取过
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);// 冷却中
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
							"已经领取过");
					ServerHandler.sendData(session, respMap);
					return;
				}

			} else {// 许愿的四个愿望任选一个 0-2
				if (statu.getInt(7) == 1) {// 可以许愿
					param.clear();
					Map<String, Object> rlt = new HashMap<String, Object>();
					if (num == 0) {// 加50000经验
						int exp = role.getExp();
						int level = role.getLevel();
						// param.put("exp", exp+50000);
						// rlt.put("exp", exp+50000);
						// this.getGameRoleService().addRoleExp(roleid, 50000);
						/****/
						Map<String, Object> map = new HashMap<String, Object>();

						/** roleid:人物id，level：人物等级，exp：原有经验，uppexp：本次获得经验 */
						// protected int shengji(int roleid,int level,int
						// exp,int uppexp){
						shengji(roleid, level, exp, 50000);
						// 更改下次升级所需经验

						// System.out.println("=============9===============");
						GameRoleDetail gamerole = this.getGameRoleService()
								.findRoleById4(roleid);
						rlt.put("totalexp", gamerole.getExp());
						rlt.put("level", gamerole.getLevel());
						this.getGameLevelService().getGameLevelByRoleLevel(
								gamerole.getLevel()).getNeedexp();
						rlt.put("needexp", this.getGameLevelService()
								.getGameLevelByRoleLevel(gamerole.getLevel())
								.getNeedexp());

						/****/
						// System.out.println("许愿前总exp::"+exp+"    许愿前总level::"+level+"    许愿后得到经验后总exp::"+this.getGameRoleService().findRoleById(roleid).getExp()+"    许愿后得到经验后总level::"+this.getGameRoleService().findRoleById(roleid).getLevel());
					} else if (num == 1) {// 加50万铜钱
						int yin = role.getYin();
						param.put("yin", yin + 500000);
						rlt.put("yin", yin + 500000);
					} else if (num == 2) {// 加5万功勋
						int gongxun = role.getGongxun();
						// param.put("gongxun", gongxun+50000);
						rlt.put("gongxun", gongxun + 50000);
						this.getGameRoleService().addRoleGongxun(roleid, 50000);
					}

					rlt.put("t", t);
					rlt.put("num", num);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
					ServerHandler.sendData(session, respMap);
					statu.set(7, 2 + num);
					param.put("id", roleid);
					param.put("awakenstatu", statu.toString());
					this.getGameRoleService().updateRoleVip(param);
				}
			}

		}

	}

	private void supplementsign() {// 补签第几天
		if (params.containsKey("day")) {
			int t = Integer.valueOf(String.valueOf(params.get("day"))) - 1;// 补签第几天
			int roleid = Integer.parseInt(playerId);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("roleid", roleid);
			param.put("itemid", 321);
			List<RoleItemDetail> ri = this.getRoleItemService()
					.getRoleItemByitem(param);
			if (ri.isEmpty() || ri.get(0).getNum() < 1) {// 道具不足，不能刷新
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
				ServerHandler.sendData(session, respMap);
				return;
			}
			int itemnum = ri.get(0).getNum();
			param.clear();
			param.put("roleid", roleid);
			param.put("itemid", 321);
			param.put("num", 1);
			boolean b = false;
			b = this.getRoleItemService().sbRoleItemNum(param);// 道具减少1个
			if (b == false) {
				b = this.getRoleItemService().sbRoleItemNum(param);
				if (b == false) {
					b = this.getRoleItemService().sbRoleItemNum(param);
				}
			}

			List<GameTaskDetail> list = new ArrayList();
			list = this.getGameTaskService().getGameTaskDetailById(21 + t);

			GameRole role = this.getGameRoleService().findRoleById(roleid);
			String state0 = role.getStateseven();
			JSONArray stateseven = JSONArray.fromObject(state0);

			String task = list.get(0).getTaskres();

			Map<String, Object> rlt = new HashMap<String, Object>();
			if (!stateseven.contains(t)) {

				int coin = list.get(0).getTaskcoin();
				this.getGameRoleService().addRoleYin(roleid, coin);
				// [{'id':1,'type':5,'num':2}]解析要领取的礼物
				List<Map> tasks = JSON.parseArray(String.valueOf(task),
						Map.class);
				JSONArray temptask = new JSONArray();
				Map<String, JSONArray> result = collect(tasks, roleid);
				JSONArray flag = result.get("flag");
				if (!flag.contains(false)) {
					temptask = result.get("temptask");
					rlt.put("reward", temptask);
					// 查询一下rolecoin 要发的数据，coin ，reward（id,num,type,bid）
					Map<String, Object> param1 = new HashMap<String, Object>();
					param1.put("id", roleid);
					stateseven.add(t);// 添加
					String statez = stateseven.toString();// 转换类型
					param1.put("stateseven", statez);
					this.getGameRoleService().updateRolestateseven(param1);// 存放入数据库

					rlt.put("coin", this.getGameRoleService().findRoleById(
							roleid).getYin());
					rlt.put("num", itemnum - 1);
					rlt.put("bid", ri.get(0).getId());
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
					ServerHandler.sendData(session, respMap);

					// for 结束后加改变state状态，存入数据库
				} else {// 背包空间不足
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -6);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
							"背包空间不足");
					ServerHandler.sendData(session, respMap);
				}

			} else {
				// 已经领取过
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);// 冷却中
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "已经领取过");
				ServerHandler.sendData(session, respMap);
			}
			param = null;
			list = null;
			rlt = null;

		}

	}

	public static Map<Integer, Integer> getServerid() {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		try {
			Iterator it = ServerHandler.playerSessions1.keySet().iterator();
			while (it.hasNext()) {
				IoSession is = ServerHandler.playerSessions1.get(Integer
						.valueOf(String.valueOf(it.next())));
				int serverid = Integer.valueOf(String.valueOf(is
						.getAttribute("serverid")));
				if (!map.containsKey(serverid)) {
					map.put(serverid, 1);
				} else {
					map.put(serverid, Integer.valueOf(String.valueOf(map
							.get(serverid))) + 1);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// GameConstants.log.warn("PlayerHandler.getServerid():serverids:" +
		// map.toString());
		return map;
	}

	public static void updateOnlineUserNumber() {
		if (serveridmap == null) {
			getServerService().updateOnlineUserNumber(1, 0);
		}
		serveridmap = getServerid();
		// System.out.println("udpateOnlineserNumber:" +
		// ServerHandler.playerSessions1.size() + " session:" +
		// ServerHandler.playerSessions1.toString() + " serverid:" +
		// (ServerHandler.playerSessions1.get(12355099) == null ? 0 :
		// ServerHandler.playerSessions1.get(12355099).getAttribute("serverid")));
		Iterator it = serveridmap.keySet().iterator();
		while (it.hasNext()) {
			int id = Integer.valueOf(String.valueOf(it.next()));
			// System.out.println("id:" +id);
			getServerService().updateOnlineUserNumber(id, serveridmap.get(id));
		}

	}

	private void itemgift() {
		Map<String, Object> param = new HashMap<String, Object>();
		int roleid = Integer.parseInt(String.valueOf(playerId));
		GameRoleDetail gameRole = this.getGameRoleService()
				.findRoleById(roleid);
		String buyitem = gameRole.getBuyitem();
		JSONArray ary = JSONArray.fromObject(buyitem);
		JSONArray list = new JSONArray();
		int ary4 = ary.getInt(3);
		int lq = 0;
		for (int i = 0; i < 3; i++) {
			if (Integer.parseInt(String.valueOf(ary.get(i))) == 1) {
				lq++;
			}
		}
		if (lq >= ary.getInt(3)) {// 可以领取
			if (ary.getInt(3) > 3) {// 领取数据异常，不能领取
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
				ServerHandler.sendData(session, respMap);
				return;
			}
			ary.set(3, ary4 + 1);
			param.put("id", roleid);
			param.put("buyitem", ary.toString());
			this.getGameRoleService().updatebuyitem(param);

			getItem(roleid, 8, 1, 6, list);
			getItem(roleid, 277, 1, 5, list);
			getItem(roleid, 362, 10, 5, list);
			getItem(roleid, 6, 10, 5, list);
			Map<String, Object> rlt = new HashMap<String, Object>();
			rlt.put("reward", list);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
		} else {// 不可领取

		}

	}

	private void dailyquest() {
		Map<String, Object> rlt = new HashMap<String, Object>();
		Map<String, Object> pa = new HashMap<String, Object>();
		int roleid = Integer.parseInt(playerId);
		GameRoleDetail role = this.getGameRoleService().findRoleById(roleid);
		int integral = role.getIntegral();
		RoleDaytaskDetail roletask = this.getRoleDaytaskService()
				.findRoleDaytaskByRId(roleid);
		long tt = this.getGameRoleService().findRoleById(roleid).getTasktime();
		long nowtime = new Date().getTime();
		int day = (int) ((nowtime - tt) / 1000 / 60 / 60 / 24 + 1);
		int roleday = roletask.getDay();
		if (day > roleday) {// 新的一天，
			// 更新roledaytask
			Map<String, Object> paramd = new HashMap<String, Object>();
			JSONArray ary = new JSONArray();
			String baoxiang = ary.toString();
			ary.add(0, 0);
			ary.add(1, 0);
			ary.add(2, 0);
			ary.add(3, 0);
			ary.add(4, 0);
			ary.add(5, 0);
			/****/
			ary.add(6, 0);
			ary.add(7, 0);
			/****/
			String integralstatue = ary.toString();
			ary.clear();
			ary.add(0, 0);
			ary.add(1, 0);
			ary.add(2, 0);
			ary.add(3, 0);
			/****/
			ary.add(4, 0);
			/****/
			String box = ary.toString();
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
			int integral2 = role.getIntegral();
			integral2 = 0;
			paramd.clear();
			paramd.put("id", roleid);
			paramd.put("integral", integral2);
			this.getGameRoleService().updateRoleintegral(paramd);
			paramd.clear();
			paramd.put("roleid", roleid);
			paramd.put("day", day);
			this.getRoleDaytaskService().updateRoleDaytask(paramd);
			paramd = null;
		}
		int a;
		int g2;
		int h1;
		int c;
		long d;
		int h;
		int g3;
		int g1;
		int h2;
		int g;
		int b;
		int f;
		int g5;
		int e;
		int g4;
		int h4;
		int a1;
		int h3;
		RoleDaytaskDetail roletask1 = this.getRoleDaytaskService()
				.findRoleDaytaskByRId(roleid);
		int xiulian = roletask1.getXiulian();
		int qianghua = roletask1.getQianghua();
		int lueduo = roletask1.getLueduo();
		int qiangduo = roletask1.getQiangduo();
		int zhaomu = roletask1.getZhaomu();
		int zhangdou = roletask1.getZhangdou();
		String baoxiang = roletask1.getBaoxiang();
		String integralstatue = roletask1.getIntegralstatue();

		int middlerecruit = roletask1.getMiddlerecruit();// 中级招募次数
		int toprecruit = roletask1.getToprecruit();// 高级招募次数
		JSONArray integralstatue1 = JSONArray.fromObject(integralstatue);
		int k = integralstatue1.getInt(0);
		int k1 = integralstatue1.getInt(1);
		int k2 = integralstatue1.getInt(2);
		int k3 = integralstatue1.getInt(3);
		int k4 = integralstatue1.getInt(4);
		int k5 = integralstatue1.getInt(5);

		int k6 = integralstatue1.getInt(6);
		int k7 = integralstatue1.getInt(7);
		int x;// 中级招募宝箱
		int y;// 高级招募宝箱
		int x1;
		int y1;
		// System.out.println("初级招募：："+zhaomu+"：：：中级招募：："+middlerecruit+";;;高级招募;;;"+toprecruit);
		// System.out.println("：：：：：：integralstatue1：："+integralstatue1);

		if (k7 == 0) {

			// 表示积分没有加
			if (toprecruit < 1) {// 高级招募
				y = toprecruit;
				int zj = this.getGameRoleService().findRoleById(roleid)
						.getIntegral();
			} else {
				y = 1;
				y1 = this.getGameRoleService().findRoleById(roleid)
						.getIntegral() + 10;
				pa.clear();
				pa.put("id", roleid);
				pa.put("integral", y1);
				this.getGameRoleService().updateRoleintegral(pa);
				integralstatue1.set(7, 1);
				String m = integralstatue1.toString();
				pa.clear();
				pa.put("roleid", roleid);
				pa.put("integralstatue", m);
				this.getRoleDaytaskService().updateRoleDaytask(pa);
			}

		} else {

			if (toprecruit < 1) {// 高级招募
				y = toprecruit;
				int zj = this.getGameRoleService().findRoleById(roleid)
						.getIntegral();
			} else {
				y = 1;
				y1 = this.getGameRoleService().findRoleById(roleid)
						.getIntegral();
				pa.clear();
				pa.put("id", roleid);
				pa.put("integral", y1);
				this.getGameRoleService().updateRoleintegral(pa);
			}

		}

		if (k6 == 0) {
			// 表示积分没有加
			if (middlerecruit < 2) {// 中级招募
				x = middlerecruit;
				int zj = this.getGameRoleService().findRoleById(roleid)
						.getIntegral();
			} else {
				x = 2;
				x1 = this.getGameRoleService().findRoleById(roleid)
						.getIntegral() + 10;
				pa.clear();
				pa.put("id", roleid);
				pa.put("integral", x1);
				this.getGameRoleService().updateRoleintegral(pa);
				integralstatue1.set(6, 1);
				String m = integralstatue1.toString();
				pa.clear();
				pa.put("roleid", roleid);
				pa.put("integralstatue", m);
				this.getRoleDaytaskService().updateRoleDaytask(pa);
			}

		} else {

			if (middlerecruit < 2) {// 中级招募
				x = middlerecruit;
				int zj = this.getGameRoleService().findRoleById(roleid)
						.getIntegral();
			} else {
				x = 2;
				x1 = this.getGameRoleService().findRoleById(roleid)
						.getIntegral();
				pa.clear();
				pa.put("id", roleid);
				pa.put("integral", x1);
				this.getGameRoleService().updateRoleintegral(pa);
			}

		}

		if (k == 0) {// 表示积分没有加
			if (qianghua < 2) {
				a = qianghua;
				g = this.getGameRoleService().findRoleById(roleid)
						.getIntegral();
			} else {
				a = 2;
				a1 = this.getGameRoleService().findRoleById(roleid)
						.getIntegral() + 5;
				pa.clear();
				pa.put("id", roleid);
				pa.put("integral", a1);
				this.getGameRoleService().updateRoleintegral(pa);
				integralstatue1.set(0, 1);
				String m = integralstatue1.toString();
				pa.clear();
				pa.put("roleid", roleid);
				pa.put("integralstatue", m);
				this.getRoleDaytaskService().updateRoleDaytask(pa);
			}
		} else {
			if (qianghua < 2) {
				a = qianghua;
				g = this.getGameRoleService().findRoleById(roleid)
						.getIntegral();
			} else {
				a = 2;
				a1 = this.getGameRoleService().findRoleById(roleid)
						.getIntegral();
				pa.clear();
				pa.put("id", roleid);
				pa.put("integral", a1);
				this.getGameRoleService().updateRoleintegral(pa);
			}
		}
		if (k1 == 0) {
			if (lueduo < 2) {
				b = lueduo;
				g1 = this.getGameRoleService().findRoleById(roleid)
						.getIntegral();
			} else {
				b = 2;
				h = this.getGameRoleService().findRoleById(roleid)
						.getIntegral() + 5;
				pa.clear();
				pa.put("id", roleid);
				pa.put("integral", h);
				this.getGameRoleService().updateRoleintegral(pa);
				integralstatue1.set(1, 1);
				String m = integralstatue1.toString();
				pa.clear();
				pa.put("roleid", roleid);
				pa.put("integralstatue", m);
				this.getRoleDaytaskService().updateRoleDaytask(pa);
			}
		} else {
			if (lueduo < 2) {
				b = lueduo;
				g1 = this.getGameRoleService().findRoleById(roleid)
						.getIntegral();
			} else {
				b = 2;
				h = this.getGameRoleService().findRoleById(roleid)
						.getIntegral();
				pa.clear();
				pa.put("id", roleid);
				pa.put("integral", h);
				this.getGameRoleService().updateRoleintegral(pa);
			}
		}
		if (k2 == 0) {
			if (qiangduo < 5) {
				c = qiangduo;
				g2 = this.getGameRoleService().findRoleById(roleid)
						.getIntegral();
			} else {
				c = 5;
				h1 = this.getGameRoleService().findRoleById(roleid)
						.getIntegral() + 10;
				pa.clear();
				pa.put("id", roleid);
				pa.put("integral", h1);
				this.getGameRoleService().updateRoleintegral(pa);
				integralstatue1.set(2, 1);
				String m = integralstatue1.toString();
				pa.clear();
				pa.put("roleid", roleid);
				pa.put("integralstatue", m);
				this.getRoleDaytaskService().updateRoleDaytask(pa);
			}
		} else {
			if (qiangduo < 5) {
				c = qiangduo;
				g2 = this.getGameRoleService().findRoleById(roleid)
						.getIntegral();
			} else {
				c = 5;
				h1 = this.getGameRoleService().findRoleById(roleid)
						.getIntegral();
				pa.clear();
				pa.put("id", roleid);
				pa.put("integral", h1);
				this.getGameRoleService().updateRoleintegral(pa);
			}
		}
		if (k3 == 0) {
			if (zhaomu < 2) {
				d = zhaomu;
				g3 = this.getGameRoleService().findRoleById(roleid)
						.getIntegral();
			} else {
				d = 2;
				h2 = this.getGameRoleService().findRoleById(roleid)
						.getIntegral() + 10;
				pa.clear();
				pa.put("id", roleid);
				pa.put("integral", h2);
				this.getGameRoleService().updateRoleintegral(pa);
				integralstatue1.set(3, 1);
				String m = integralstatue1.toString();
				pa.clear();
				pa.put("roleid", roleid);
				pa.put("integralstatue", m);
				this.getRoleDaytaskService().updateRoleDaytask(pa);
			}
		} else {
			if (zhaomu < 2) {
				d = zhaomu;
				g3 = this.getGameRoleService().findRoleById(roleid)
						.getIntegral();
			} else {
				d = 2;
				h2 = this.getGameRoleService().findRoleById(roleid)
						.getIntegral();
				pa.clear();
				pa.put("id", roleid);
				pa.put("integral", h2);
				this.getGameRoleService().updateRoleintegral(pa);
			}
		}
		if (k4 == 0) {
			if (xiulian < 2) {
				e = xiulian;
				g4 = this.getGameRoleService().findRoleById(roleid)
						.getIntegral();
			} else {
				e = 2;
				h3 = this.getGameRoleService().findRoleById(roleid)
						.getIntegral() + 5;
				pa.clear();
				pa.put("id", roleid);
				pa.put("integral", h3);
				this.getGameRoleService().updateRoleintegral(pa);
				integralstatue1.set(4, 1);
				String m = integralstatue1.toString();
				pa.clear();
				pa.put("roleid", roleid);
				pa.put("integralstatue", m);
				this.getRoleDaytaskService().updateRoleDaytask(pa);
			}
		} else {
			if (xiulian < 2) {
				e = xiulian;
				g4 = this.getGameRoleService().findRoleById(roleid)
						.getIntegral();
			} else {
				e = 2;
				h3 = this.getGameRoleService().findRoleById(roleid)
						.getIntegral();
				pa.clear();
				pa.put("id", roleid);
				pa.put("integral", h3);
				this.getGameRoleService().updateRoleintegral(pa);
			}
		}
		if (k5 == 0) {
			if (zhangdou < 5) {
				f = zhangdou;
				g5 = this.getGameRoleService().findRoleById(roleid)
						.getIntegral();
			} else {
				f = 5;
				h4 = this.getGameRoleService().findRoleById(roleid)
						.getIntegral() + 5;
				pa.clear();
				pa.put("id", roleid);
				pa.put("integral", h4);
				this.getGameRoleService().updateRoleintegral(pa);
				integralstatue1.set(5, 1);
				String m = integralstatue1.toString();
				pa.clear();
				pa.put("roleid", roleid);
				pa.put("integralstatue", m);
				this.getRoleDaytaskService().updateRoleDaytask(pa);
			}
		} else {
			if (zhangdou < 5) {
				f = zhangdou;
				g5 = this.getGameRoleService().findRoleById(roleid)
						.getIntegral();
			} else {
				f = 5;
				h4 = this.getGameRoleService().findRoleById(roleid)
						.getIntegral();
				pa.clear();
				pa.put("id", roleid);
				pa.put("integral", h4);
				this.getGameRoleService().updateRoleintegral(pa);
			}
		}
		String name = this.getGameTaskService().findGameTaskDetailById(36)
				.getTaskname();
		String name1 = this.getGameTaskService().findGameTaskDetailById(37)
				.getTaskname();
		String name2 = this.getGameTaskService().findGameTaskDetailById(35)
				.getTaskname();
		String name3 = this.getGameTaskService().findGameTaskDetailById(39)
				.getTaskname();
		String name4 = this.getGameTaskService().findGameTaskDetailById(38)
				.getTaskname();
		String name5 = this.getGameTaskService().findGameTaskDetailById(40)
				.getTaskname();
		String name6 = this.getGameTaskService().findGameTaskDetailById(623)
				.getTaskname();
		String name7 = this.getGameTaskService().findGameTaskDetailById(624)
				.getTaskname();
		JSONArray task = new JSONArray();
		pa.clear();// 中级招募
		pa.put("taskname", name6);// 吗
		pa.put("num", 2);
		pa.put("dailynum", x);
		pa.put("integral", 10);
		task.add(pa);
		pa.clear();// 高级招募
		pa.put("taskname", name7);// 吗
		pa.put("num", 1);
		pa.put("dailynum", y);
		pa.put("integral", 10);
		task.add(pa);
		pa.clear();
		pa.put("taskname", name);
		pa.put("num", 2);
		pa.put("dailynum", a);
		pa.put("integral", 5);
		task.add(pa);
		pa.clear();
		pa.put("taskname", name1);
		pa.put("num", 2);
		pa.put("dailynum", b);
		pa.put("integral", 5);
		task.add(pa);
		pa.clear();
		pa.put("taskname", name2);
		pa.put("num", 5);
		pa.put("dailynum", c);
		pa.put("integral", 10);
		task.add(pa);
		pa.clear();
		pa.put("taskname", name3);
		pa.put("num", 2);
		pa.put("dailynum", d);
		pa.put("integral", 10);
		task.add(pa);
		pa.clear();
		pa.put("taskname", name4);
		pa.put("num", 2);
		pa.put("dailynum", e);
		pa.put("integral", 5);
		task.add(pa);
		pa.clear();
		pa.put("taskname", name5);
		pa.put("num", 5);
		pa.put("dailynum", f);
		pa.put("integral", 5);
		task.add(pa);
		int integral1 = this.getGameRoleService().findRoleById(roleid)
				.getIntegral();
		rlt.put("task", task);
		rlt.put("integrall", integral1);
		RoleDaytaskDetail detail = this.getRoleDaytaskService()
				.findRoleDaytaskByRId(roleid);
		String baoxiang0 = detail.getBaoxiang();
		JSONArray baoxiang1 = JSONArray.fromObject(baoxiang0);
		rlt.put("baoxiang", baoxiang1);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);
		if (integral1 >= 60) {
			String state0 = role.getAimreward();
			JSONArray aimreward = JSONArray.fromObject(state0);// 目标大奖状态
			if (aimreward.getInt(12) == 0) {// 13。每日任务积分达到60分
				aimreward.set(12, 1);
				pa.clear();
				pa.put("id", roleid);
				pa.put("aimreward", aimreward.toString());
				this.getGameRoleService().updateRoleVip(pa);
			}
		}
		pa = null;
		rlt = null;

	}

	private void dailyreward() {
		if (params.containsKey("t")) {
			Map<String, Object> rlt = new HashMap<String, Object>();
			Map<String, Object> pa = new HashMap<String, Object>();
			int t = NumberUtils.createInteger(String.valueOf(params.get("t")));
			int roleid = Integer.parseInt(playerId);
			GameRoleDetail role = this.getGameRoleService()
					.findRoleById(roleid);
			int integral = role.getIntegral();
			RoleDaytaskDetail roletask = this.getRoleDaytaskService()
					.findRoleDaytaskByRId(roleid);
			String box = roletask.getBox();
			JSONArray box1 = JSONArray.fromObject(box);
			int c = box1.getInt(0);
			int c1 = box1.getInt(1);
			int c2 = box1.getInt(2);
			int c3 = box1.getInt(3);
			int c4 = box1.getInt(4);// 第五个宝箱
			if (t == 1) {// 第一个宝箱
				if (c == 0) {
					if (integral >= 10) {
						// 加速卡ID是2 1000铜钱 ID 17 5
						List<Map> tasks = new ArrayList<Map>();
						// [{'id':1,'type':5,'num':2}]
						pa.put("id", 2);
						pa.put("resType", 5);
						pa.put("num", 1);
						tasks.add(pa);
						Map<String, JSONArray> result = collect(tasks, roleid);
						// 礼包
						JSONArray temptask = result.get("temptask");
						JSONArray flag = result.get("flag");
						if (!flag.contains(false)) {
							int yin = this.getGameRoleService().findRoleById(
									roleid).getYin();
							int rcoin = yin + 1000;
							this.getGameRoleService().upRoleYin(roleid, rcoin);
							pa.clear();
							pa.put("flag", 1);
							pa.put("num", 1000);
							temptask.add(pa);
							Map<String, Object> paramd = new HashMap<String, Object>();
							// JSONArray ary=new JSONArray();
							// String baoxiang=ary.toString();
							RoleDaytaskDetail detail = this
									.getRoleDaytaskService()
									.findRoleDaytaskByRId(roleid);
							String baoxiang0 = detail.getBaoxiang();
							JSONArray baoxiang = JSONArray
									.fromObject(baoxiang0);
							baoxiang.add(1);
							String baoxiangz = baoxiang.toString();
							paramd.clear();
							paramd.put("roleid", roleid);
							paramd.put("baoxiang", baoxiangz);
							this.getRoleDaytaskService().updateRoleDaytask(
									paramd);
							String s = this.getRoleDaytaskService()
									.findRoleDaytaskByRId(roleid).getBaoxiang();
							JSONArray baoxiang1 = JSONArray.fromObject(s);
							int junling = this.getGameRoleService()
									.findRoleById(roleid).getJunling();
							rlt.put("rcoin", rcoin);
							rlt.put("reward", temptask);
							rlt.put("baoxiang", baoxiang1);
							rlt.put("junling", junling);

							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									GameConstants.GAME_API_SUCCESS);
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_RLT,
									rlt);
							ServerHandler.sendData(session, respMap);

						} else {// 背包空间不足
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									-1);
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_RLT,
									"背包空间不足");
							ServerHandler.sendData(session, respMap);
						}

					} else {
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-2);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
								"积分不足");
						ServerHandler.sendData(session, respMap);
						return;
					}
					box1.set(0, 1);
					String m = box1.toString();
					pa.clear();
					pa.put("roleid", roleid);
					pa.put("box", m);
					this.getRoleDaytaskService().updateRoleDaytask(pa);
				} else {
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
							"已经领取");
					ServerHandler.sendData(session, respMap);

				}
			}
			if (t == 2) {// 第二个宝箱
				if (c1 == 0) {
					if (integral >= 20) {
						// 2000铜钱 、加速卡 2 、初级藏宝图6 5
						List<Map> tasks = new ArrayList<Map>();
						// [{'id':1,'type':5,'num':2}]
						pa.put("id", 2);
						pa.put("resType", 5);
						pa.put("num", 1);
						tasks.add(pa);
						Map<String, Object> pa1 = new HashMap<String, Object>();
						pa1.put("id", 6);
						pa1.put("resType", 5);
						pa1.put("num", 1);
						tasks.add(pa1);
						Map<String, JSONArray> result = collect(tasks, roleid);
						// 礼包
						JSONArray temptask = result.get("temptask");
						JSONArray flag = result.get("flag");
						if (!flag.contains(false)) {
							this.getGameRoleService().addRoleYin(roleid, 2000);
							int rcoin = this.getGameRoleService().findRoleById(
									roleid).getYin();
							pa.clear();
							pa.put("flag", 1);
							pa.put("num", 2000);
							temptask.add(pa);
							Map<String, Object> paramd = new HashMap<String, Object>();
							// JSONArray ary=new JSONArray();
							// String baoxiang=ary.toString();
							RoleDaytaskDetail detail = this
									.getRoleDaytaskService()
									.findRoleDaytaskByRId(roleid);
							String baoxiang0 = detail.getBaoxiang();
							JSONArray baoxiang = JSONArray
									.fromObject(baoxiang0);
							baoxiang.add(2);
							String baoxiangz = baoxiang.toString();
							paramd.clear();
							paramd.put("roleid", roleid);
							paramd.put("baoxiang", baoxiangz);
							this.getRoleDaytaskService().updateRoleDaytask(
									paramd);
							String s = this.getRoleDaytaskService()
									.findRoleDaytaskByRId(roleid).getBaoxiang();
							JSONArray baoxiang1 = JSONArray.fromObject(s);
							int junling = this.getGameRoleService()
									.findRoleById(roleid).getJunling();
							rlt.put("junling", junling);
							rlt.put("rcoin", rcoin);
							rlt.put("baoxiang", baoxiang1);
							rlt.put("reward", temptask);
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									GameConstants.GAME_API_SUCCESS);
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_RLT,
									rlt);
							ServerHandler.sendData(session, respMap);

						} else {// 背包空间不足
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									-1);
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_RLT,
									"背包空间不足");
							ServerHandler.sendData(session, respMap);
						}
					} else {
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-2);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
								"积分不足");
						ServerHandler.sendData(session, respMap);
						return;
					}
					box1.set(1, 1);
					String m = box1.toString();
					pa.clear();
					pa.put("roleid", roleid);
					pa.put("box", m);
					this.getRoleDaytaskService().updateRoleDaytask(pa);

				} else {
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
							"已经领取");
					ServerHandler.sendData(session, respMap);

				}
			}
			if (t == 3) {// 第三个宝箱
				if (c2 == 0) {
					if (integral >= 30) {
						// 强化保护*2、军令*3
						List<Map> tasks = new ArrayList<Map>();
						// [{'id':1,'type':5,'num':2}]
						pa.put("id", 10);
						pa.put("resType", 5);
						pa.put("num", 2);
						tasks.add(pa);
						Map<String, JSONArray> result = collect(tasks, roleid);
						// 礼包
						JSONArray temptask = result.get("temptask");
						JSONArray flag = result.get("flag");
						if (!flag.contains(false)) {
							int a = this.getGameRoleService().findRoleById(
									roleid).getJunling();
							this.getGameRoleService().addRolejunling(roleid,
									3 + a);
							pa.clear();
							pa.put("flag", 2);
							pa.put("num", 3);
							temptask.add(pa);
							Map<String, Object> paramd = new HashMap<String, Object>();
							// JSONArray ary=new JSONArray();
							// String baoxiang=ary.toString();
							RoleDaytaskDetail detail = this
									.getRoleDaytaskService()
									.findRoleDaytaskByRId(roleid);
							String baoxiang0 = detail.getBaoxiang();
							JSONArray baoxiang = JSONArray
									.fromObject(baoxiang0);
							baoxiang.add(3);
							String baoxiangz = baoxiang.toString();
							paramd.clear();
							paramd.put("roleid", roleid);
							paramd.put("baoxiang", baoxiangz);
							this.getRoleDaytaskService().updateRoleDaytask(
									paramd);
							String s = this.getRoleDaytaskService()
									.findRoleDaytaskByRId(roleid).getBaoxiang();
							JSONArray baoxiang1 = JSONArray.fromObject(s);
							int junling = this.getGameRoleService()
									.findRoleById(roleid).getJunling();
							// System.out.println("............当前军令..........."+junling);
							rlt.put("junling", junling);
							rlt.put("baoxiang", baoxiang1);
							rlt.put("reward", temptask);
							this.getRoleDaytaskService().updateRoleDaytask(
									paramd);
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									GameConstants.GAME_API_SUCCESS);
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_RLT,
									rlt);
							ServerHandler.sendData(session, respMap);

						} else {// 背包空间不足
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									-1);
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_RLT,
									"背包空间不足");
							ServerHandler.sendData(session, respMap);
						}

					} else {
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-2);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
								"积分不足");
						ServerHandler.sendData(session, respMap);
						return;

					}
					box1.set(2, 1);
					String m = box1.toString();
					pa.clear();
					pa.put("roleid", roleid);
					pa.put("box", m);
					this.getRoleDaytaskService().updateRoleDaytask(pa);

				} else {
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
							"已经领取");
					ServerHandler.sendData(session, respMap);

				}
			}
			if (t == 4) {// 第四个宝箱
				if (c3 == 0) {
					if (integral >= 40) {
						// 初级招妖令*3、军令*5
						List<Map> tasks = new ArrayList<Map>();
						// [{'id':1,'type':5,'num':2}]
						pa.put("id", 3);
						pa.put("resType", 5);
						pa.put("num", 3);
						tasks.add(pa);
						Map<String, JSONArray> result = collect(tasks, roleid);
						// 礼包
						JSONArray temptask = result.get("temptask");
						JSONArray flag = result.get("flag");
						if (!flag.contains(false)) {
							Map<String, Object> paramd = new HashMap<String, Object>();
							// JSONArray ary=new JSONArray();
							// String baoxiang=ary.toString();
							RoleDaytaskDetail detail = this
									.getRoleDaytaskService()
									.findRoleDaytaskByRId(roleid);
							String baoxiang0 = detail.getBaoxiang();
							JSONArray baoxiang = JSONArray
									.fromObject(baoxiang0);
							baoxiang.add(4);
							String baoxiangz = baoxiang.toString();
							paramd.clear();
							paramd.put("roleid", roleid);
							paramd.put("baoxiang", baoxiangz);
							this.getRoleDaytaskService().updateRoleDaytask(
									paramd);
							int a = this.getGameRoleService().findRoleById(
									roleid).getJunling();
							this.getGameRoleService().addRolejunling(roleid,
									5 + a);
							int rjunling = this.getGameRoleService()
									.findRoleById(roleid).getJunling();
							pa.clear();
							pa.put("flag", 2);
							pa.put("num", 5);
							temptask.add(pa);
							String s = this.getRoleDaytaskService()
									.findRoleDaytaskByRId(roleid).getBaoxiang();
							JSONArray baoxiang1 = JSONArray.fromObject(s);
							int junling = this.getGameRoleService()
									.findRoleById(roleid).getJunling();
							rlt.put("junling", junling);
							rlt.put("reward", temptask);
							rlt.put("baoxiang", baoxiang1);

							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									GameConstants.GAME_API_SUCCESS);
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_RLT,
									rlt);
							ServerHandler.sendData(session, respMap);

						} else {// 背包空间不足
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									-1);
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_RLT,
									"背包空间不足");
							ServerHandler.sendData(session, respMap);
						}
					} else {
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-2);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
								"积分不足");
						ServerHandler.sendData(session, respMap);
						return;
					}
					box1.set(3, 1);
					String m = box1.toString();
					pa.clear();
					pa.put("roleid", roleid);
					pa.put("box", m);
					this.getRoleDaytaskService().updateRoleDaytask(pa);
				} else {
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
							"已经领取");
					ServerHandler.sendData(session, respMap);
				}
			}
			if (t == 5) {
				// 第四个宝箱
				if (c4 == 0) {
					if (integral >= 60) {
						// 中级藏宝图*7、军令*5
						List<Map> tasks = new ArrayList<Map>();
						// [{'id':1,'type':5,'num':2}]
						pa.put("id", 7);
						pa.put("resType", 5);
						pa.put("num", 3);
						tasks.add(pa);
						Map<String, JSONArray> result = collect(tasks, roleid);
						// 礼包
						JSONArray temptask = result.get("temptask");
						JSONArray flag = result.get("flag");
						if (!flag.contains(false)) {
							Map<String, Object> paramd = new HashMap<String, Object>();
							// JSONArray ary=new JSONArray();
							// String baoxiang=ary.toString();
							RoleDaytaskDetail detail = this
									.getRoleDaytaskService()
									.findRoleDaytaskByRId(roleid);
							String baoxiang0 = detail.getBaoxiang();
							JSONArray baoxiang = JSONArray
									.fromObject(baoxiang0);
							baoxiang.add(5);
							String baoxiangz = baoxiang.toString();
							paramd.clear();
							paramd.put("roleid", roleid);
							paramd.put("baoxiang", baoxiangz);
							this.getRoleDaytaskService().updateRoleDaytask(
									paramd);
							int a = this.getGameRoleService().findRoleById(
									roleid).getJunling();
							this.getGameRoleService().addRolejunling(roleid,
									5 + a);
							int rjunling = this.getGameRoleService()
									.findRoleById(roleid).getJunling();
							pa.clear();
							pa.put("flag", 2);
							pa.put("num", 5);
							temptask.add(pa);
							String s = this.getRoleDaytaskService()
									.findRoleDaytaskByRId(roleid).getBaoxiang();
							JSONArray baoxiang1 = JSONArray.fromObject(s);
							int junling = this.getGameRoleService()
									.findRoleById(roleid).getJunling();
							rlt.put("junling", junling);
							rlt.put("reward", temptask);
							rlt.put("baoxiang", baoxiang1);

							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									GameConstants.GAME_API_SUCCESS);
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_RLT,
									rlt);
							ServerHandler.sendData(session, respMap);

						} else {// 背包空间不足
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									-1);
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_RLT,
									"背包空间不足");
							ServerHandler.sendData(session, respMap);
						}
					} else {
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-2);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
								"积分不足");
						ServerHandler.sendData(session, respMap);
						return;
					}
					box1.set(4, 1);
					String m = box1.toString();
					pa.clear();
					pa.put("roleid", roleid);
					pa.put("box", m);
					this.getRoleDaytaskService().updateRoleDaytask(pa);
				} else {
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
							"已经领取");
					ServerHandler.sendData(session, respMap);
				}

			}
			pa = null;
			rlt = null;
		}
	}

	@SuppressWarnings( { "static-access", "unchecked" })
	private void yamashitarob() {
		Map<String, Object> rlt = new HashMap<String, Object>();
		int roleid = Integer.parseInt(playerId);
		GameRoleDetail role = this.getGameRoleService().findRoleById(roleid);
		long nowtime = role.getNowtime();
		if (nowtime == 0) {// 默认状态
			long time = new Date().getTime();
			nowtime = time + 12 * 60 * 60 * 1000;
			// nowtime = time + 60*1000;
			Map<String, Object> pa = new HashMap<String, Object>();
			pa.put("nowtime", nowtime);
			pa.put("id", roleid);
			this.getGameRoleService().updateRolenowtime(pa);
			rlt.put("lootTime", 12 * 60 * 60);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
			pa = null;
		} else {
			long time = new Date().getTime();
			long n = nowtime - time;
			long m;
			if (n % 1000 == 0) {
				m = n / 1000;
			} else {
				m = n / 1000 + 1;
			}
			if (time < nowtime) {// 等待状态
				rlt.put("lootTime", m);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
			} else if (time - nowtime < 3 * 60 * 60 * 1000
					&& time - nowtime >= 0) {// 可以领取状态
				int yin = role.getYin();
				int rlevel = role.getLevel();
				int junling = role.getJunling();
				int yin1 = 1000 * rlevel;
				long k = time - nowtime;
				long p;
				if (n % 1000 == 0) {
					p = k / 1000;
				} else {
					p = k / 1000 + 1;
				}
				long d = 20 - p;
				Map<String, Object> pas1 = new HashMap<String, Object>();
				pas1.put("num", yin1);
				pas1.put("flag", 1);
				Map<String, Object> pas2 = new HashMap<String, Object>();
				pas2.put("num", 5);
				pas2.put("flag", 2);
				int yin2 = yin1 + yin;
				int junlingl = junling + 5;
				this.getGameRoleService().upRoleYin(roleid, yin2);
				this.getGameRoleService().addRolejunling(roleid, junlingl);
				int coins = this.getGameRoleService().findRoleById(roleid)
						.getYin();
				int token = this.getGameRoleService().findRoleById(roleid)
						.getJunling();
				ArrayList reward = new ArrayList();
				reward.add(pas1);
				reward.add(pas2);
				rlt.put("loot", d);
				rlt.put("lootTime", 0);
				rlt.put("coin", coins);
				rlt.put("token", token);
				rlt.put("reward", reward);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				ServerHandler.sendData(session, respMap);

				pas2 = null;
				// 更新数据库
				nowtime = 0;
				Map<String, Object> pa = new HashMap<String, Object>();
				pa.put("nowtime", nowtime);
				pa.put("id", roleid);
				this.getGameRoleService().updateRolenowtime(pa);

			} else if (time - nowtime > 3 * 60 * 60 * 1000) {// 超过领取时间状态
				rlt.put("lootTime", -1);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				ServerHandler.sendData(session, respMap);
				// 更新数据库
				nowtime = 0;
				Map<String, Object> pa = new HashMap<String, Object>();
				pa.put("nowtime", nowtime);
				pa.put("id", roleid);
				this.getGameRoleService().updateRolenowtime(pa);
			}
		}
		rlt = null;
	}

	private void gameover() {
		// System.out.println("战斗结束，获得道具=============================");
		if (params.containsKey("t")) {
			int t = Integer.parseInt(String.valueOf(params.get("t")));
			int roleid = Integer.parseInt(playerId);
			Map<String, Object> rlt = new HashMap<String, Object>();
			Map<String, Object> param = new HashMap<String, Object>();
			List<Map<String, Object>> rolelist = new ArrayList<Map<String, Object>>();
			JSONArray itemlist = new JSONArray();
			JSONArray placelist = new JSONArray();
			Map<String, Object> maprole = new HashMap<String, Object>();
			Map<String, Object> mapitems = new HashMap<String, Object>();
			Map<String, Object> mapplace = new HashMap<String, Object>();
			GameRoleDetail role = this.getGameRoleService()
					.findRoleById(roleid);
			int mapid = role.getMapid();// 最大战斗地图id
			int mapid2 = role.getMapid2();// 当前战斗地图
			int placeid = role.getPlaceid();// 第几波
			int placeid2 = role.getPlaceid2();
			int exp = role.getExp();
			int rlevel = role.getLevel();
			int gongxun = role.getGongxun();
			int yin = role.getYin();
			// 升级所需经验
			int needexp = this.getGameLevelService().getGameLevelByRoleLevel(
					rlevel).getNeedexp();
			int uppmapid = 0;// 是否进入新关卡
			int upplevel = 0;// 是否升级
			// 判断signjl=1,可以领取道具
			int signjl = role.getSignjl();
			if (signjl != 1) {// 非法途径战斗，不给奖励
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -4);
				ServerHandler.sendData(session, respMap);
				return;
			} else {
				// 将signjl=0
				param.put("id", roleid);
				param.put("signjl", 0);
				this.getGameRoleService().updateRoleVip(param);
			}
			// 减少军令
			// boolean bool = this.getGameRoleService().subRolejunling(roleid,
			// 1);
			// if(bool==false){
			// return;
			// }
			rlt.put("junling", this.getGameRoleService().findRoleById(roleid)
					.getJunling());
			// 开始战斗
			if (t == 1) {// 战斗胜利
				// 获得奖励：银币、功勋、经验
				List<GameMapDetail> map = this.getGameMapService()
						.findGameMapByid(mapid2);
				int mapexp = 0;
				if (!map.isEmpty()) {// 地图存在
					// ...........待写........乘以战斗波数
					int mapyin = (int) (map.get(0).getGetyin() * (1 + placeid2 / 50.0));
					int mapgongxun = (int) (map.get(0).getGetgongxun() * (1 + placeid2 / 50.0));
					mapexp = (int) (map.get(0).getGetexp() * (1 + placeid2 / 50.0));

					param.clear();
					param.put("id", roleid);
					param.put("exp", (exp + mapexp));
					param.put("yin", (yin + mapyin));
					param.put("gongxun", (gongxun + mapgongxun));
					this.getGameRoleService().updateRoleVip(param);

					maprole.put("mapyin", mapyin);
					maprole.put("mapgongxun", mapgongxun);
					maprole.put("mapexp", mapexp);
					// 获得随机道具
					param.clear();
					param.put("id", mapid2);
					param.put("mid", placeid2);
					List<GamePlatsDetail> mapitem = this.getGamePlatsService()
							.findGamePlatByparams(param);
					// System.out.println("PlayerHanler________" +
					// mapitem.size() + "_____________// 道具存在:" +
					// !mapitem.isEmpty());
					if (!mapitem.isEmpty()) {// 道具存在
						int resodds = mapitem.get(0).getResodds();// 掉奖几率
						String res = mapitem.get(0).getRes();// 道具类型
						// 判断是否获得
						Random random = new Random();
						int r = random.nextInt(100);
						if (r <= resodds) {// 获得道具成功
							JsonSerializer json = new JsonSerializer();
							List<Map<String, Object>> resList = (List<Map<String, Object>>) json
									.deserialize(res);
							Random ran = new Random();
							int size = ran.nextInt(resList.size());
							int id = Integer.parseInt(String.valueOf(resList
									.get(size).get("id")));
							int type = Integer.parseInt(String.valueOf(resList
									.get(size).get("resType")));
							int num = Integer.parseInt(String.valueOf(resList
									.get(size).get("num")));
							// 判断是装备还是道具
							if (type == 5) {// 道具
								// 判断是否还有格子
								int itemtype = this.getGameItemService()
										.getGameItemById(id).get(0)
										.getItemtype();
								boolean boo = getShangxian(itemtype, type,
										roleid, id, num);
								if (boo == false) {// 没有格子可以放
									// 奖励为空
								} else {// 背包有空间
									param.clear();
									param.put("roleid", roleid);
									param.put("itemid", id);
									List<RoleItemDetail> ritem = this
											.getRoleItemService().getRoleItem(
													param);
									// System.out.println("9999战斗结束发放道具开始：：：：：：roleid"+roleid+"  itemid::"+id+" 查询到的所有记录数：："+ritem.size());
									int num2 = 0;
									param.put("num", num);
									// long in = Long.valueOf(0);
									long bid = 0L;
									if (ritem.isEmpty()) {// 道具不存在，插入
										bid = this.getAutoIdService()
												.fingKeyValueByTableName(
														"role_item");
										// System.out.println("playerHandler得到long类型的id:::"+bid);
										RoleItemDetail iDetail = new RoleItemDetail();
										iDetail.setId(bid);
										iDetail.setRoleid(roleid);
										iDetail.setItemid(id);
										iDetail.setNum(num);
										iDetail.setFlag(1);
										iDetail.setType(itemtype);
										boolean bo = this.getRoleItemService()
												.insertRoleItem(iDetail);
										// if(bo = true)
										// //in = bid;
										// this.getAutoIdService().updateKeyValueAddOneByTableName("role_item");
									} else {// 道具存在，num+
										this.getRoleItemService()
												.addRoleItemNum(param);
										bid = ritem.get(0).getId();
									}
									param.clear();
									param.put("roleid", roleid);
									param.put("itemid", id);
									// System.out.println("PlayerHandler.1273: param:"
									// + param.toString());

									// if(in == Long.valueOf(0)){
									// bid = in;
									// }else{
									// //System.out.println("+++++++++++++++++++++++++++++param?:"
									// + param.toString());
									// // List<RoleItemDetail> item =
									// this.getRoleItemService().getRoleItem(param);
									//										
									// }
									mapitems.put("bid", bid);
									mapitems.put("id", id);
									mapitems.put("num", num);
									mapitems.put("resType", type);
								}
							} else if (type == 6) {// 装备
								int equiptype = this.getGameEquipService()
										.getGameEquipById(id).get(0).getType();
								boolean bo = getShangxian(equiptype, type,
										roleid, id, num);
								if (bo == true) {// 背包有空间，可以领取
									List<GameEquipDetail> gameequips = this
											.getGameEquipService()
											.getGameEquipByEid(id);
									GameEquipDetail gameequip = null;
									if (!gameequips.isEmpty()) {
										gameequip = gameequips.get(0);

									}
									int bid = this.getAutoIdService()
											.fingKeyValueByTableName(
													"role_equip");
									// 添加
									int speed = gameequip.getSudu();
									int attack = gameequip.getGongji();
									int hpMax = gameequip.getXueliang();
									int rectlength = gameequip.getFanwei();
									int tt = gameequip.getType();
									String user = "0";
									RoleEquipDetail eDetail = new RoleEquipDetail();
									eDetail.setId(bid);
									eDetail.setDengji(1);
									eDetail.setEquipId(id);
									eDetail.setRoleId(roleid);
									eDetail.setFlag(1);
									eDetail.setType(tt);
									eDetail.setAttack(attack);
									eDetail.setUser(user);
									eDetail.setHpMax(hpMax);
									eDetail.setRectlength(rectlength);
									eDetail.setSpeed(speed);
									this.getRoleEquipService().insertRoleEquip(
											eDetail);
									// this.getAutoIdService().updateKeyValueAddOneByTableName("role_equip");
									mapitems.put("bid", bid);
									mapitems.put("id", id);
									mapitems.put("num", num);
									mapitems.put("resType", type);
									mapitems.put("at", attack);
									mapitems.put("hp", hpMax);
									mapitems.put("spd", speed);
									mapitems.put("rl", rectlength);
									mapitems.put("isUsed", 0);
									mapitems.put("sl", 1);
								} else {// 背包格子不足
									// 奖励为空
								}
							}
						} else {// 获得道具不成功
							// item为空
						}
					} else {// 道具不存在
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-1);
						ServerHandler.sendData(session, respMap);
						return;
					}
					// 更新战斗mapid和第几波
					if (mapid == mapid2 && placeid == placeid2) {// 没有选地图战斗,最大id,都增加，判断placeid是否到20
						// 判断是否是20波
						if (placeid == 20) {// mapid+1 mapid2+1 placeid=0
							// placeid2=0
							List<GameMapDetail> maxmap = this
									.getGameMapService().getGameMap();
							if (mapid > maxmap.size()) {// 战斗mapid达到上限
								respMap
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
												-3);
								ServerHandler.sendData(session, respMap);
								return;
							} else {
								param.clear();
								param.put("id", roleid);
								param.put("mapid", (mapid + 1));
								param.put("placeid", 1);
								param.put("mapid2", (mapid2 + 1));
								param.put("placeid2", 1);
								this.getGameRoleService().updateRoleVip(param);

								// 进入新关卡，播放动画
								uppmapid = 1;
								maprole.put("mapid2", (mapid + 1));
								maprole.put("placeid2", 1);
								rlt.put("place", placelist);
							}
						} else if (placeid > 20) {
							param.clear();
							param.put("placeid", 20);
							param.put("placeid2", 20);
							this.getGameRoleService().updateRoleVip(param);
						} else {// 不是第20波,placeid+1,placeid2+1
							param.clear();
							param.put("id", roleid);
							param.put("placeid", (placeid + 1));
							param.put("placeid2", placeid2 + 1);
							this.getGameRoleService().updateRoleVip(param);
							maprole.put("mapid2", mapid);
							maprole.put("placeid2", placeid + 1);
							// 不发place
						}
					} else {// 选择以前的关卡战斗,placeid2+1
						// 判断是否是20波
						if (placeid2 == 20) {// mapid2+1,placeid2=0
							param.clear();
							param.put("id", roleid);
							param.put("mapid2", (mapid2 + 1));
							param.put("placeid2", 1);
							this.getGameRoleService().updateRoleVip(param);

							maprole.put("mapid2", (mapid2 + 1));
							maprole.put("placeid2", 1);

							// 遍历role_map，发送place
							param.clear();
							param.put("roleId", roleid);
							param.put("mapid", (mapid2 + 1));

							List<RoleMapDetail> rmap = this.getRoleMapService()
									.getRoleMapByParam(param);
							for (int i = 0; i < rmap.size(); i++) {
								mapid = rmap.get(i).getMapid();
								placeid = rmap.get(i).getPlaceid();
								int militaryid = rmap.get(i).getMilitaryid();
								int towerid = rmap.get(i).getTowerid();
								mapplace.put("mapid", mapid);
								mapplace.put("militaryid", militaryid);
								mapplace.put("placeid", placeid);
								mapplace.put("towerid", towerid);
								placelist.add(mapplace);
							}
							rlt.put("place", placelist);
						} else if (placeid > 20) {
							param.clear();
							param.put("placeid", 20);
							param.put("placeid2", 20);
							this.getGameRoleService().updateRoleVip(param);
						} else {// 不是第20波，placeid2+1
							param.clear();
							param.put("id", roleid);
							param.put("placeid2", (placeid2 + 1));
							this.getGameRoleService().updateRoleVip(param);

							maprole.put("mapid2", mapid2);
							maprole.put("placeid2", (placeid2 + 1));
						}
					}
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
				} else {// 地图不存咋
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
					ServerHandler.sendData(session, respMap);
					return;
				}
				// 判断是否可以升级
				upplevel = this.shengji(roleid, rlevel, exp, mapexp);
				// 更改下次升级所需经验
				needexp = this.getGameLevelService().getGameLevelByRoleLevel(
						this.getGameRoleService().findRoleById(roleid)
								.getLevel()).getNeedexp();

				if (mapitems.size() > 0) {
					itemlist.add(mapitems);
				}
				// 活动奖励
				// 判断活动是否开启
				param.clear();
				param.put("id", 2);
				List<HostDetail> host = this.getHostService().findHostByParam(
						param);
				if (!host.isEmpty()) {
					Calendar calendar = Calendar.getInstance();
					int mon = calendar.get(Calendar.MONTH) + 1;
					int today = calendar.get(Calendar.DAY_OF_MONTH);
					int hour = calendar.get(Calendar.HOUR_OF_DAY);
					// System.out.println(mon+"...........mon"+hour);
					// System.out.println(today+"...........day");
					if (mon >= host.get(0).getMonth()
							&& mon <= host.get(0).getMonthend()) {
						if (today >= host.get(0).getDay()
								&& today <= host.get(0).getDayend()) {
							// if(hour<16){}

							int odds = host.get(0).getOdds();// 概率
							if ((Math.random() * 100) <= odds) {
								int itemid = host.get(0).getItemid();
								int type = 5;
								int num = 1;
								// 判断是否还有格子
								int itemtype = this.getGameItemService()
										.getGameItemById(itemid).get(0)
										.getItemtype();
								boolean boo = getShangxian(itemtype, type,
										roleid, itemid, num);
								if (boo == false) {// 没有格子可以放
									// 奖励为空
								} else {// 背包有空间
									param.clear();
									param.put("roleid", roleid);
									param.put("itemid", itemid);
									List<RoleItemDetail> ritem = this
											.getRoleItemService().getRoleItem(
													param);
									param.put("num", num);

									if (ritem.isEmpty()) {// 道具不存在，插入
										// int bid = this.getAutoIdService()
										// .fingKeyValueByTableName(
										// "role_item") + 1;
										long bid = this.getAutoIdService()
												.fingKeyValueByTableName(
														"role_item");
										// System.out.println("playerHandler得到long类型的id:::"+bid);

										RoleItemDetail iDetail = new RoleItemDetail();
										iDetail.setId(bid);
										iDetail.setRoleid(roleid);
										iDetail.setItemid(itemid);
										iDetail.setNum(num);
										iDetail.setFlag(1);
										iDetail.setType(itemtype);
										boolean bo = this.getRoleItemService()
												.insertRoleItem(iDetail);
										// this
										// .getAutoIdService()
										// .updateKeyValueAddOneByTableName(
										// "role_item");
									} else {// 道具存在，num+
										this.getRoleItemService()
												.addRoleItemNum(param);
									}
									param.clear();
									param.put("roleid", roleid);
									param.put("itemid", itemid);
									List<RoleItemDetail> item = this
											.getRoleItemService().getRoleItem(
													param);
									long bid = item.get(0).getId();
									mapitems.put("bid", bid);
									mapitems.put("id", itemid);
									mapitems.put("num", num);
									mapitems.put("resType", type);
									itemlist.add(mapitems);
								}
							}
						}
					}
				}
			} else {// 战斗失败
				List<GameMapDetail> map = this.getGameMapService()
						.findGameMapByid(mapid2);
				int mapyin = (int) (map.get(0).getGetyin()
						* (1 + placeid2 / 50.0) / 2);
				int mapgongxun = (int) (map.get(0).getGetgongxun()
						* (1 + placeid2 / 50.0) / 2);
				int mapexp = (int) (map.get(0).getGetexp()
						* (1 + placeid2 / 50.0) / 2);
				param.clear();
				param.put("id", roleid);
				param.put("exp", (exp + mapexp));
				param.put("yin", (yin + mapyin));
				param.put("gongxun", (gongxun + mapgongxun));
				this.getGameRoleService().updateRoleVip(param);

				maprole.put("mapyin", mapyin);
				maprole.put("mapgongxun", mapgongxun);
				maprole.put("mapexp", mapexp);
				// 判断是否可以升级
				upplevel = this.shengji(roleid, rlevel, exp, mapexp);
				needexp = this.getGameLevelService().getGameLevelByRoleLevel(
						this.getGameRoleService().findRoleById(roleid)
								.getLevel()).getNeedexp();

				maprole.put("mapid2", mapid2);
				maprole.put("placeid2", placeid2);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
			}
			GameRoleDetail changerole = this.getGameRoleService().findRoleById(
					roleid);
			maprole.put("yin", changerole.getYin());
			maprole.put("exp", changerole.getExp());
			maprole.put("gongxun", changerole.getGongxun());
			maprole.put("level", changerole.getLevel());

			maprole.put("needexp", needexp);
			maprole.put("uppmapid", uppmapid);// 获得新地图
			maprole.put("upplevel", upplevel);// 升级了

			maprole.put("mapid", changerole.getMapid());
			maprole.put("placeid", changerole.getPlaceid());
			// 战斗判断是否有任务完成1
			this.getTaskHandler().taskcomplete(roleid);
			// 副本新手引导
			// if(changerole.getHelpstep()!=0){
			// if(changerole.getMapid()==11&&changerole.getPlaceid()>=11){
			//					
			// }else if(changerole.getMapid()>11){
			//					
			// }
			// }
			rlt.put("role", maprole);

			rlt.put("item", itemlist);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
			maprole = null;
			mapitems = null;
			mapplace = null;
			rlt = null;
			param = null;
			session.removeAttribute("zhandou");
		}
	}

	public Map<String, JSONArray> collect(List<Map> tasks, int roleid) {// 领取礼包
		int id = 0;
		int num = 0;
		int type = 0;

		JSONArray temptask = new JSONArray();
		JSONArray flag = new JSONArray();
		Map<String, JSONArray> back = new HashMap<String, JSONArray>();
		for (int i = 0; i < tasks.size(); i++) {
			id = Integer.parseInt(String.valueOf(tasks.get(i).get("id")));
			num = Integer.parseInt(String.valueOf(tasks.get(i).get("num")));
			type = Integer.parseInt(String.valueOf(tasks.get(i).get("resType")));
			// System.out.println("::::::::::::::::::::::::::::::神秘礼包图腾啊：：：：type"+type);
			if (type == 5) {
				int subtype = this.getGameItemService().getGameItemById(id)
						.get(0).getItemtype();
				boolean b = getShangxian(subtype, type, roleid, id, num);
				flag.add(b);
				// 判断是否获得特定的碎片
				if (id == 1111111) {
					Map<String, Object> param = new HashMap<String, Object>();
					param.put("id", roleid);
					param.put("three", this.getGameRoleService().findRoleById(
							roleid).getThree()
							+ "4");
					this.getGameRoleService().updateRoleVip(param);
					param = null;
				}
			} else if (type == 6) {
				int subtype = this.getGameEquipService().getGameEquipByEid(id)
						.get(0).getType();
				// type :子类型 resType:主类型 roleId:人物id id:物品
				boolean b0 = getShangxian(subtype, type, roleid, id, num);
				flag.add(b0);
			} else if (type == 10) {// 图腾的逻辑
				// System.out.println(id+":id::::::::::图腾道具:::::::::::::::::::roleid:"+roleid);
				// 成功：flag.add(true); 失败：：flag.add(false);
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("roleid", roleid);
				param.put("totemid", id);
				List<RoletotemDetail> to = this.getRoletotemService()
						.getRoletotem(param);
				if (to.isEmpty()) {// 插入图腾
					List<GametotemDetail> gt = this.getGametotemService()
							.getGametotembyid(id);
					RoletotemDetail mo = new RoletotemDetail();
					mo.setRoleid(roleid);
					mo.setType(gt.get(0).getType());
					mo.setLevel(gt.get(0).getLevel());
					mo.setNum(num);
					mo.setQuality(gt.get(0).getQuality());
					mo.setTotemid(gt.get(0).getId());
					this.getRoletotemService().insertRoletotem(mo);
					mo = null;
				} else {// 更新图腾
					param.clear();
					param.put("roleid", roleid);
					param.put("type", to.get(0).getType());
					param.put("totemid", to.get(0).getTotemid());
					param.put("num", num);
					this.getRoletotemService().addRoletotemNum(param);
				}
			}
		}
		if (!flag.contains(false)) {
			for (int i = 0; i < tasks.size(); i++) {

				id = Integer.parseInt(String.valueOf(tasks.get(i).get("id")));
				num = Integer.parseInt(String.valueOf(tasks.get(i).get("num")));
				type = Integer.parseInt(String.valueOf(tasks.get(i).get("resType")));
				// 1/地图 2/防御塔 3/武将信息 4/敌将 5/道具 6 装备/
				// 7/vip模型10/价格表
				Map<String, Object> taskff = new HashMap<String, Object>();
				taskff.put("num", num);

				if (type == 18) {
					if (id == 1) {// 1.银，2金
						boolean bo3 = this.getGameRoleService().addRoleYin(
								roleid, num);
						if (bo3 == true) {
							taskff.put("num", num);
							taskff.put("flag", 1);
							temptask.add(taskff);
						}
					} else {// 奖励金币

					}

				} else if (type == 5) {

					Map<String, Object> param = new HashMap<String, Object>();
					param.put("itemid", id);
					param.put("roleid", roleid);
					boolean bo1 = false;
					List<RoleItemDetail> item = new ArrayList<RoleItemDetail>();
					item = this.getRoleItemService().getRoleItem(param);
					param.put("num", num);
					if (!item.isEmpty()) {
						// 直接更新数据
						bo1 = this.getRoleItemService().addRoleItemNum(param);

						if (bo1 == true) {

							// 更新,增加state
							long bid = item.get(0).getId();
							taskff.put("id", id);
							taskff.put("resType", type);
							taskff.put("bid", bid);
							temptask.add(taskff);

						}
					} else if (item.isEmpty()) {

						// int bid = this.getAutoIdService()
						// .fingKeyValueByTableName("role_item") + 1;
						long bid = this.getAutoIdService()
								.fingKeyValueByTableName("role_item");
						// System.out.println("playerHandler得到long类型的id:::"+bid);

						RoleItemDetail iDetail = new RoleItemDetail();
						iDetail.setId(bid);
						iDetail.setRoleid(roleid);
						iDetail.setItemid(id);
						iDetail.setNum(num);
						iDetail.setFlag(1);
						iDetail.setType(this.getGameItemService()
								.getGameItemById(id).get(0).getItemtype());
						boolean bo2 = this.getRoleItemService().insertRoleItem(
								iDetail);
						// this.getAutoIdService()
						// .updateKeyValueAddOneByTableName("role_item");

						if (bo2 == true) {

							taskff.put("id", id);
							taskff.put("resType", type);
							taskff.put("bid", bid);
							temptask.add(taskff);
						}

					}
				} else if (type == 6) {

					List<GameEquipDetail> gameequips = this
							.getGameEquipService().getGameEquipByEid(id);
					GameEquipDetail gameequip = null;
					if (!gameequips.isEmpty()) {
						gameequip = gameequips.get(0);
					}

					for (int j = 1; j <= num; j++) {
						int bid = this.getAutoIdService()
								.fingKeyValueByTableName("role_equip");
						// 添加
						int speed = gameequip.getSudu();
						int attack = gameequip.getGongji();
						int hpMax = gameequip.getXueliang();
						int rectlength = gameequip.getFanwei();
						RoleEquipDetail eDetail = new RoleEquipDetail();
						String user = "0";
						eDetail.setId(bid);
						eDetail.setDengji(1);
						eDetail.setEquipId(id);
						eDetail.setRoleId(roleid);
						eDetail.setFlag(1);
						eDetail.setType(this.getGameEquipService()
								.getGameEquipByEid(id).get(0).getType());
						eDetail.setAttack(attack);
						eDetail.setUser(user);
						eDetail.setHpMax(hpMax);
						eDetail.setRectlength(rectlength);
						eDetail.setSpeed(speed);
						boolean bo2 = this.getRoleEquipService()
								.insertRoleEquip(eDetail);
						// this.getAutoIdService()
						// .updateKeyValueAddOneByTableName("role_equip");
						if (bo2 == true) {
							Map<String, Object> equips = new HashMap<String, Object>();
							equips.put("resType", type);
							equips.put("bid", bid);
							equips.put("num", 1);
							equips.put("at", attack);
							equips.put("hp", hpMax);
							equips.put("id", id);
							equips.put("spd", speed);
							equips.put("rl", rectlength);
							equips.put("isUsed", user);
							equips.put("sl", 1);
							equips.put("quality", this.getGameEquipService().getGameEquipByEid(id).get(0).getQuality());
							equips.put("name", this.getGameEquipService().getGameEquipByEid(id).get(0).getEquipname());
							temptask.add(equips);
						}
					}

				} else if (type == 10) {
					taskff.clear();
					taskff.put("id", id);
					taskff.put("resType", type);
					taskff.put("num", num);
					temptask.add(taskff);
				} else {// 礼物不存在
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "");
					ServerHandler.sendData(session, respMap);
				}
			}
		}
		// System.out.println("图腾：：：：：：：：：："+temptask);
		back.put("temptask", temptask);
		back.put("flag", flag);
		return back;
	}

	private void supplement() {// 补签
		// System.out.println("supplement");
		if (params.containsKey("daysup")) {
			int daysup = Integer.parseInt(String.valueOf(params.get("daysup")));

			int roleid = Integer.parseInt(playerId);
			Map<String, Object> rlt = new HashMap<String, Object>();// 发送数据
			long now = new Date().getTime();
			Calendar c = Calendar.getInstance();// 获取当前时间
			int yearN = c.get(Calendar.YEAR);// 当前年
			int monthN = (c.get(Calendar.MONTH) + 1);// 当前月
			int day = c.get(Calendar.DAY_OF_MONTH);// 当前日

			GameRole role = this.getGameRoleService().findRoleById(roleid);
			String supsign0 = role.getSupsign();
			JSONArray supsign = JSONArray.fromObject(supsign0);

			// 直接更新标记补签的信息数组，标记哪天补签了
			String state0 = role.getState();
			JSONArray state = JSONArray.fromObject(state0);

			if (!state.contains(daysup)) {
				if (!supsign.contains(day) && supsign.size() <= 5) {
					if (daysup % 2 == 0) {
						List<GameTaskDetail> list = new ArrayList();
						list = this.getGameTaskService().getGameTaskDetailById(
								28);
						String task = list.get(0).getTaskres();
						// 获取银币并写入数据库，发给前端
						int coin = list.get(0).getTaskcoin();
						this.getGameRoleService().addRoleYin(roleid, coin);

						List<Map> tasks = JSON.parseArray(String.valueOf(task),
								Map.class);
						JSONArray temptask = new JSONArray();
						Map<String, JSONArray> result = collect(tasks, roleid);
						temptask = result.get("temptask");
						JSONArray flag = result.get("flag");
						// 增加银币
						if (coin > 0) {
							Map<String, Object> map = new HashMap<String, Object>();
							map.put("num", coin);
							map.put("flag", 1);
							temptask.add(map);
							map = null;
						}
						if (!flag.contains(false)) {
							rlt.put("reward", temptask);
							Map<String, Object> params = new HashMap<String, Object>();
							state.add(daysup);
							String statez = state.toString();// 转换类型
							params.put("state", statez);
							params.put("id", roleid);
							this.getGameRoleService().updateRolestate(params);// 存放入数据库

							Map<String, Object> paramsup = new HashMap<String, Object>();
							supsign.add(day);// 并存放数据库
							String supsignz = supsign.toString();// 转换类型
							paramsup.put("supsign", supsignz);
							paramsup.put("id", roleid);
							this.getGameRoleService().updateRoleSupsign(
									paramsup);// 存放入数据库

							rlt.put("coin", this.getGameRoleService()
									.findRoleById(roleid).getYin());
							rlt.put("supsign", supsign);
							rlt.put("num", 5 - supsign.size());
							rlt.put("junling", this.getGameRoleService()
									.findRoleById(roleid).getJunling());
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									GameConstants.GAME_API_SUCCESS);
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_RLT,
									rlt);
							ServerHandler.sendData(session, respMap);
						} else {// 背包空间不足
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									-6);
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_RLT,
									"背包空间不足");
							ServerHandler.sendData(session, respMap);
						}

					} else if (daysup % 2 == 1) {
						List<GameTaskDetail> list = new ArrayList();
						list = this.getGameTaskService().getGameTaskDetailById(
								29);
						String task = list.get(0).getTaskres();

						int coin = list.get(0).getTaskcoin();
						this.getGameRoleService().addRoleYin(roleid, coin);

						List<Map> tasks = JSON.parseArray(String.valueOf(task),
								Map.class);
						JSONArray temptask = new JSONArray();
						Map<String, JSONArray> result = collect(tasks, roleid);
						JSONArray flag = result.get("flag");
						temptask = result.get("temptask");
						// 增加银币
						if (coin > 0) {
							Map<String, Object> map = new HashMap<String, Object>();
							map.put("num", coin);
							map.put("flag", 1);
							temptask.add(map);
							map = null;
						}
						if (!flag.contains(false)) {
							rlt.put("reward", temptask);
							Map<String, Object> params = new HashMap<String, Object>();
							state.add(daysup);
							String statez = state.toString();// 转换类型
							params.put("state", statez);
							params.put("id", roleid);
							this.getGameRoleService().updateRolestate(params);// 存放入数据库

							Map<String, Object> paramsup = new HashMap<String, Object>();
							supsign.add(day);// 并存放数据库
							String supsignz = supsign.toString();// 转换类型
							paramsup.put("supsign", supsignz);
							paramsup.put("id", roleid);
							this.getGameRoleService().updateRoleSupsign(
									paramsup);// 存放入数据库
							// 增加军令1
							GameRoleDetail grole = this.getGameRoleService()
									.findRoleById(roleid);
							this.getGameRoleService().addRolejunling(roleid,
									(grole.getJunling() + 1));
							rlt.put("coin", grole.getYin());
							rlt.put("supsign", supsign);
							rlt.put("num", 5 - supsign.size());
							rlt.put("junling", this.getGameRoleService()
									.findRoleById(roleid).getJunling());
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									GameConstants.GAME_API_SUCCESS);
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_RLT,
									rlt);
							ServerHandler.sendData(session, respMap);
						} else {// 背包空间不足
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									-6);
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_RLT,
									"背包空间不足");
							ServerHandler.sendData(session, respMap);
						}

					}

				} else {
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
							"今天不可重复补签");
					ServerHandler.sendData(session, respMap);
				}
			} else {
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "已经签过");
				ServerHandler.sendData(session, respMap);
			}

		}
	}

	private void sign() {
		// 获取天数，第几天，判断能否签到，把数据库中的State字段清空
		int roleid = Integer.parseInt(playerId);
		Map<String, Object> rlt = new HashMap<String, Object>();// 发送数据
		long now = new Date().getTime();
		Calendar c = Calendar.getInstance();// 获取当前时间
		int yearN = c.get(Calendar.YEAR);// 当前年
		int monthN = (c.get(Calendar.MONTH) + 1);// 当前月
		int day = c.get(Calendar.DAY_OF_MONTH);// 当前日

		// 取出state,并转化为数组对象格式
		GameRole role = this.getGameRoleService().findRoleById(roleid);
		String state0 = role.getState();
		JSONArray state = JSONArray.fromObject(state0);
		// 更改数据库中的state,并领取签到
		int level = role.getLevel();
		if (!state.contains(day)) {
			if (day % 2 == 0) {
				List<GameTaskDetail> list = new ArrayList();
				list = this.getGameTaskService().getGameTaskDetailById(28);
				String task = list.get(0).getTaskres();

				int coin = list.get(0).getTaskcoin();
				coin = coin * level;
				this.getGameRoleService().addRoleYin(roleid, coin);

				List<Map> tasks = JSON.parseArray(String.valueOf(task),
						Map.class);
				JSONArray temptask = new JSONArray();
				Map<String, JSONArray> result = collect(tasks, roleid);
				temptask = result.get("temptask");
				// 增加银币
				if (coin > 0) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("num", coin);
					map.put("flag", 1);
					temptask.add(map);
					map = null;
				}
				JSONArray flag = result.get("flag");
				if (!flag.contains(false)) {
					rlt.put("reward", temptask);
					Map<String, Object> params = new HashMap<String, Object>();
					state.add(day);
					String statez = state.toString();
					params.put("id", roleid);
					params.put("state", statez);
					this.getGameRoleService().updateRolestate(params);// 存放入数据库
					rlt.put("reward", temptask);
					GameRoleDetail grole = this.getGameRoleService()
							.findRoleById(roleid);
					rlt.put("coin", grole.getYin());
					rlt.put("junling", grole.getJunling());
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
					ServerHandler.sendData(session, respMap);
				} else {// 背包空间不足
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -6);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
							"背包空间不足");
					ServerHandler.sendData(session, respMap);
				}
			} else if (day % 2 == 1) {
				List<GameTaskDetail> list = new ArrayList();
				list = this.getGameTaskService().getGameTaskDetailById(29);
				String task = list.get(0).getTaskres();

				int coin = list.get(0).getTaskcoin();
				coin = coin * level;
				this.getGameRoleService().addRoleYin(roleid, coin);

				List<Map> tasks = JSON.parseArray(String.valueOf(task),
						Map.class);
				JSONArray temptask = new JSONArray();
				Map<String, JSONArray> result = collect(tasks, roleid);
				temptask = result.get("temptask");
				JSONArray flag = result.get("flag");
				// 增加银币
				if (coin > 0) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("num", coin);
					map.put("flag", 1);
					temptask.add(map);
					map = null;
				}
				if (!flag.contains(false)) {
					rlt.put("reward", temptask);
					Map<String, Object> params = new HashMap<String, Object>();
					state.add(day);
					String statez = state.toString();
					params.put("id", roleid);
					params.put("state", statez);
					this.getGameRoleService().updateRolestate(params);// 存放入数据库

					// 增加军令1
					GameRoleDetail grole = this.getGameRoleService()
							.findRoleById(roleid);
					this.getGameRoleService().addRolejunling(roleid,
							(grole.getJunling() + 1));
					rlt.put("coin", grole.getYin());
					rlt.put("junling", grole.getJunling());

					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
					ServerHandler.sendData(session, respMap);
				} else {// 背包空间不足
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -6);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
							"背包空间不足");
					ServerHandler.sendData(session, respMap);
				}
			}

		} else {
			// 返回-1
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "已领取过");
			ServerHandler.sendData(session, respMap);
		}

	}

	private void receive() {
		int num = 1;
		int roleid = Integer.parseInt(playerId);
		if (params.containsKey("num")) {// num=1领取每日签到奖励() num=2，4, 6，
			// 7领取连续签到的奖励
			num = Integer.valueOf(String.valueOf(params.get("num")));
		}
		// System.out.println("前端传递过来的参数num::"+num);
		if (num == 1) {
			// 只负责领取
			// 七天在线领取礼物
			// int roleid = Integer.parseInt(playerId);
			// 领了礼包,先看第几天，然后判断第几天的礼包领了没有，若是没有领，就可以领
			long now = new Date().getTime();
			long tasktime = this.getGameRoleService().findRoleById(roleid)
					.getTasktime();
			// 从数据库中获取第一次登录的时间
			double hour = (double) ((now - tasktime) / (1000 * 60 * 60.0));// 与第一天登录
			// 相差的小时
			int t = (int) (hour / 24);// 现在是第几天
			List<GameTaskDetail> list = new ArrayList();
			list = this.getGameTaskService().getGameTaskDetailById(21 + t);

			GameRole role = this.getGameRoleService().findRoleById(roleid);
			String state0 = role.getStateseven();
			JSONArray stateseven = JSONArray.fromObject(state0);

			String task = list.get(0).getTaskres();

			Map<String, Object> rlt = new HashMap<String, Object>();
			if (!stateseven.contains(t)) {

				int coin = list.get(0).getTaskcoin();
				this.getGameRoleService().addRoleYin(roleid, coin);
				// [{'id':1,'type':5,'num':2}]解析要领取的礼物
				List<Map> tasks = JSON.parseArray(String.valueOf(task),
						Map.class);
				JSONArray temptask = new JSONArray();
				Map<String, JSONArray> result = collect(tasks, roleid);
				JSONArray flag = result.get("flag");
				if (!flag.contains(false)) {
					temptask = result.get("temptask");
					rlt.put("reward", temptask);
					// 查询一下rolecoin 要发的数据，coin ，reward（id,num,type,bid）
					Map<String, Object> param1 = new HashMap<String, Object>();
					param1.put("id", roleid);
					stateseven.add(t);// 添加
					String statez = stateseven.toString();// 转换类型
					param1.put("stateseven", statez);
					this.getGameRoleService().updateRolestateseven(param1);// 存放入数据库

					rlt.put("coin", this.getGameRoleService().findRoleById(
							roleid).getYin());
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
					ServerHandler.sendData(session, respMap);

					// for 结束后加改变state状态，存入数据库
				} else {// 背包空间不足
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -6);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
							"背包空间不足");
					ServerHandler.sendData(session, respMap);
				}

			} else {
				// 已经领取过
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);// 冷却中
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "已经领取过");
				ServerHandler.sendData(session, respMap);
			}

		} else {
			GameRole role = this.getGameRoleService().findRoleById(roleid);
			String state0 = role.getSeventotal();
			JSONArray seventotal = JSONArray.fromObject(state0);
			List<GameTaskDetail> list = new ArrayList();

			Map<String, Object> rlt = new HashMap<String, Object>();
			if (num == 2) {// 累计签到两日奖励
				if (seventotal.getInt(0) != 1) {// 不可以领取
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);// 冷却中
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
							"已经领取过");
					ServerHandler.sendData(session, respMap);
					return;
				}
				list = this.getGameTaskService().getGameTaskDetailById(726);
			} else if (num == 4) {
				if (seventotal.getInt(1) != 1) {// 不可以领取
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);// 冷却中
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
							"已经领取过");
					ServerHandler.sendData(session, respMap);
					return;
				}
				list = this.getGameTaskService().getGameTaskDetailById(727);
			} else if (num == 6) {
				if (seventotal.getInt(2) != 1) {// 不可以领取
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);// 冷却中
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
							"已经领取过");
					ServerHandler.sendData(session, respMap);
					return;
				}
				list = this.getGameTaskService().getGameTaskDetailById(728);
			} else if (num == 7) {
				if (seventotal.getInt(3) != 1) {// 不可以领取
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);// 冷却中
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
							"已经领取过");
					ServerHandler.sendData(session, respMap);
					return;
				}
				list = this.getGameTaskService().getGameTaskDetailById(729);
			}
			String task = list.get(0).getTaskres();
			int coin = list.get(0).getTaskcoin();
			this.getGameRoleService().addRoleYin(roleid, coin);

			List<Map> tasks = JSON.parseArray(String.valueOf(task), Map.class);
			JSONArray temptask = new JSONArray();
			Map<String, JSONArray> result = collect(tasks, roleid);
			JSONArray flag = result.get("flag");
			if (!flag.contains(false)) {
				temptask = result.get("temptask");
				rlt.put("reward", temptask);
				rlt.put("coin", this.getGameRoleService().findRoleById(roleid)
						.getYin());
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
				if (num == 2) {
					seventotal.set(0, 2);
				} else if (num == 4) {
					seventotal.set(1, 2);
				} else if (num == 6) {
					seventotal.set(2, 2);
				} else if (num == 7) {
					seventotal.set(3, 2);
				}
				Map<String, Object> param1 = new HashMap<String, Object>();
				param1.put("id", roleid);
				param1.put("seventotal", seventotal.toString());
				this.getGameRoleService().updateRoleVip(param1);// 存放入数据库
			} else {// 背包空间不足
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -6);
				respMap
						.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
								"背包空间不足");
				ServerHandler.sendData(session, respMap);
			}
		}
	}

	private void giftseven(){
		// 打开界面
		// 七天在线领取礼物
		int roleid = Integer.parseInt(playerId);
		JsonSerializer json = new JsonSerializer();
		Map<String, Object> rlt = new HashMap<String, Object>();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		long now = System.currentTimeMillis();
		long tasktime = this.getGameRoleService().findRoleById(roleid)
				.getTasktime();// 从数据库中获取第一次登录的时间
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(now);
		String nowTime = formatter.format(calendar.getTime());
		calendar.setTimeInMillis(tasktime);
		String taskTime = formatter.format(calendar.getTime());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		long timeStart = 0;
		long timeEnd = 0;
		try {
			timeStart = sdf.parse(taskTime).getTime();
			timeEnd =sdf.parse(nowTime).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long dayCount= (timeEnd-timeStart)/(24*3600*1000);//"今天距离创建日期"+dayCount+"天"
		System.out.println("今天距离创建日期"+dayCount+"天");
		
		// 相差的小时
		int t = (int)dayCount;// 现在是第几天

		GameRole role = this.getGameRoleService().findRoleById(roleid);
		String state0 = role.getStateseven();
		if (state0.equals("null")) {
			state0 = "[]";
		}
		JSONArray state = JSONArray.fromObject(state0);

		List<Map<String, Object>> daytask = new ArrayList<Map<String, Object>>();// 存放七天的礼包信息
		List<GameTaskDetail> list0 = new ArrayList();
		list0 = this.getGameTaskService().getGameTaskDetailById(21);
		Map<String, Object> day0 = new HashMap<String, Object>();
		List<Map<String, Object>> taskres0 = (List<Map<String, Object>>) json
				.deserialize(list0.get(0).getTaskres());
		day0.put("taskres", taskres0);
		day0.put("coin", list0.get(0).getTaskcoin());
		daytask.add(0, day0);

		List<GameTaskDetail> list1 = new ArrayList();
		list1 = this.getGameTaskService().getGameTaskDetailById(22);
		Map<String, Object> day1 = new HashMap<String, Object>();
		List<Map<String, Object>> taskres1 = (List<Map<String, Object>>) json
				.deserialize(list1.get(0).getTaskres());
		day1.put("taskres", taskres1);
		day1.put("coin", list1.get(0).getTaskcoin());
		daytask.add(1, day1);

		List<GameTaskDetail> list2 = new ArrayList();
		list2 = this.getGameTaskService().getGameTaskDetailById(23);
		Map<String, Object> day2 = new HashMap<String, Object>();
		List<Map<String, Object>> taskres2 = (List<Map<String, Object>>) json
				.deserialize(list2.get(0).getTaskres());
		day2.put("taskres", taskres2);
		day2.put("coin", list2.get(0).getTaskcoin());
		daytask.add(2, day2);

		List<GameTaskDetail> list3 = new ArrayList();
		list3 = this.getGameTaskService().getGameTaskDetailById(24);
		Map<String, Object> day3 = new HashMap<String, Object>();
		List<Map<String, Object>> taskres3 = (List<Map<String, Object>>) json
				.deserialize(list3.get(0).getTaskres());
		day3.put("taskres", taskres3);
		day3.put("coin", list3.get(0).getTaskcoin());
		daytask.add(3, day3);

		List<GameTaskDetail> list4 = new ArrayList();
		list4 = this.getGameTaskService().getGameTaskDetailById(25);
		Map<String, Object> day4 = new HashMap<String, Object>();
		List<Map<String, Object>> taskres4 = (List<Map<String, Object>>) json
				.deserialize(list4.get(0).getTaskres());
		day4.put("taskres", taskres4);
		day4.put("coin", list4.get(0).getTaskcoin());
		daytask.add(4, day4);

		List<GameTaskDetail> list5 = new ArrayList();
		list5 = this.getGameTaskService().getGameTaskDetailById(26);
		Map<String, Object> day5 = new HashMap<String, Object>();
		List<Map<String, Object>> taskres5 = (List<Map<String, Object>>) json
				.deserialize(list5.get(0).getTaskres());
		day5.put("taskres", taskres5);
		day5.put("coin", list5.get(0).getTaskcoin());
		daytask.add(5, day5);

		List<GameTaskDetail> list6 = new ArrayList();
		list6 = this.getGameTaskService().getGameTaskDetailById(27);
		Map<String, Object> day6 = new HashMap<String, Object>();
		List<Map<String, Object>> taskres6 = (List<Map<String, Object>>) json
				.deserialize(list6.get(0).getTaskres());
		day6.put("taskres", taskres6);
		day6.put("coin", list6.get(0).getTaskcoin());
		daytask.add(6, day6);

		/****/
		List<GameTaskDetail> list7 = new ArrayList();
		list7 = this.getGameTaskService().getGameTaskDetailById(726);
		Map<String, Object> day7 = new HashMap<String, Object>();
		List<Map<String, Object>> taskres7 = (List<Map<String, Object>>) json
				.deserialize(list7.get(0).getTaskres());
		day7.put("taskres", taskres7);
		day7.put("coin", list7.get(0).getTaskcoin());
		daytask.add(7, day7);

		List<GameTaskDetail> list8 = new ArrayList();
		list8 = this.getGameTaskService().getGameTaskDetailById(727);
		Map<String, Object> day8 = new HashMap<String, Object>();
		List<Map<String, Object>> taskres8 = (List<Map<String, Object>>) json
				.deserialize(list8.get(0).getTaskres());
		day8.put("taskres", taskres8);
		day8.put("coin", list8.get(0).getTaskcoin());
		daytask.add(8, day8);

		List<GameTaskDetail> list9 = new ArrayList();
		list9 = this.getGameTaskService().getGameTaskDetailById(728);
		Map<String, Object> day9 = new HashMap<String, Object>();
		List<Map<String, Object>> taskres9 = (List<Map<String, Object>>) json
				.deserialize(list9.get(0).getTaskres());
		day9.put("taskres", taskres9);
		day9.put("coin", list9.get(0).getTaskcoin());
		daytask.add(9, day9);

		List<GameTaskDetail> list10 = new ArrayList();
		list10 = this.getGameTaskService().getGameTaskDetailById(729);
		Map<String, Object> day10 = new HashMap<String, Object>();
		List<Map<String, Object>> taskres10 = (List<Map<String, Object>>) json
				.deserialize(list10.get(0).getTaskres());
		day10.put("taskres", taskres10);
		day10.put("coin", list10.get(0).getTaskcoin());
		daytask.add(10, day10);
		String state1 = role.getSeventotal();
		JSONArray state11 = JSONArray.fromObject(state1);
		if (state.size() == 7) {
			for (int i = 0; i < state11.size(); i++) {
				if (state11.getInt(i) == 0) {
					state11.set(i, 1);// 1可领取状态
				}
			}
		} else if (state.size() == 6) {
			for (int i = 0; i < (state11.size() - 1); i++) {
				if (state11.getInt(i) == 0) {
					state11.set(i, 1);// 1可领取状态
				}
			}
		} else if (state.size() >= 4) {
			for (int i = 0; i < (state11.size() - 2); i++) {
				if (state11.getInt(i) == 0) {
					state11.set(i, 1);// 1可领取状态
				}
			}
		} else if (state.size() >= 2) {// 连续签到两天奖励
			if (state11.getInt(0) == 0) {
				state11.set(0, 1);
			}
		}
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", roleid);
		param.put("seventotal", state11.toString());
		this.getGameRoleService().updateRoleVip(param);
		/***/

		rlt.put("day", t);
		rlt.put("reward", daytask);
		rlt.put("state", state);
		rlt.put("state1", state11);// 连续签到四个按钮的状态

		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);

	}

	private void daysreceive() {
		// 领取连续签到的礼物
		if (params.containsKey("county")) {
			int county = Integer.parseInt(String.valueOf(params.get("county")));
			int roleid = Integer.parseInt(playerId);
			Map<String, Object> rlt = new HashMap<String, Object>();// 发�?�数�?

			GameRole role = this.getGameRoleService().findRoleById(roleid);
			String daynumstate0 = role.getDaynumstate();
			JSONArray daynumstate = JSONArray.fromObject(daynumstate0);

			// 取出state,并转化为数组对象格式
			String state0 = role.getState();
			JSONArray state = JSONArray.fromObject(state0);

			Calendar c = Calendar.getInstance();// 获取当前时间
			c.set(Calendar.DATE, 1);// 把日期设置为当月第一�?
			c.roll(Calendar.DATE, -1);// 日期回滚�?天，也就是最后一�?
			int maxDate = c.get(Calendar.DATE);

			if (!daynumstate.contains(county)) {
				List<GameTaskDetail> list = new ArrayList();
				if (county == 0 && state.size() >= 2) {
					list = this.getGameTaskService().getGameTaskDetailById(30);
				} else if (county == 1 && state.size() >= 5) {
					list = this.getGameTaskService().getGameTaskDetailById(31);
				} else if (county == 2 && state.size() >= 10) {
					list = this.getGameTaskService().getGameTaskDetailById(32);
				} else if (county == 3 && state.size() >= 20) {
					list = this.getGameTaskService().getGameTaskDetailById(33);
				} else if (county == 4 && state.size() == maxDate) {
					list = this.getGameTaskService().getGameTaskDetailById(34);
				}

				int coin = list.get(0).getTaskcoin();
				this.getGameRoleService().addRoleYin(roleid, coin);

				String task = list.get(0).getTaskres();
				List<Map> tasks = JSON.parseArray(String.valueOf(task),
						Map.class);
				JSONArray temptask = new JSONArray();
				Map<String, JSONArray> result = collect(tasks, roleid);
				temptask = result.get("temptask");
				// 增加银币
				if (coin > 0) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("num", coin);
					map.put("flag", 1);
					temptask.add(map);
					map = null;
				}

				rlt.put("reward", temptask);
				rlt.put("coin", this.getGameRoleService().findRoleById(roleid)
						.getYin());
				rlt.put("lqtype", 1);

				Map<String, Object> paramday = new HashMap<String, Object>();
				daynumstate.add(county);// 并存放数据库
				String daynumstatez = daynumstate.toString();// 转换类型
				paramday.put("daynumstate", daynumstatez);
				paramday.put("id", roleid);
				this.getGameRoleService().updateRoleDaynumstate(paramday);// 存放入数据库

				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);

			} else {
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "已领取过");
				ServerHandler.sendData(session, respMap);
			}

		}

	}

	private void attendance() {// 签到打开界面
		int roleid = Integer.parseInt(playerId);
		Map<String, Object> rlt = new HashMap<String, Object>();// 发送数据
		long now = new Date().getTime();
		Calendar c = Calendar.getInstance();// 获取当前时间
		int yearN = c.get(Calendar.YEAR);// 当前年
		int monthN = (c.get(Calendar.MONTH) + 1);// 当前月
		int day = c.get(Calendar.DAY_OF_MONTH);// 当前日
		c.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		c.roll(Calendar.DATE, -1);// 日期回滚一天，也就是最后一天
		int maxDate = c.get(Calendar.DATE);

		long timebj = this.getGameRoleService().findRoleById(roleid)
				.getRefertime();
		Date flagtime = new Date(timebj);// 取出参照时间
		Calendar cal = Calendar.getInstance();
		cal.setTime(flagtime);
		int yearO = cal.get(Calendar.YEAR);// 年
		int monthO = (cal.get(Calendar.MONTH) + 1);// 月
		if (yearN > yearO || monthN != monthO) {// 更改数据库中的state,并领取签到
			// 更改参照时间
			Map<String, Object> paramr = new HashMap<String, Object>();
			paramr.put("id", roleid);
			paramr.put("refertime", now);
			this.getGameRoleService().updateRolerefertime(paramr);
			// 更改state
			JSONArray state = new JSONArray();
			Map<String, Object> params = new HashMap<String, Object>();
			String statez = state.toString();// 转换类型
			params.put("state", statez);
			params.put("id", roleid);
			this.getGameRoleService().updateRolestate(params);// 存放入数据库
			// 更改补签
			JSONArray supsign = new JSONArray();
			Map<String, Object> paramsu = new HashMap<String, Object>();
			String supsignz = supsign.toString();// 转换类型
			paramsu.put("supsign", supsignz);
			paramsu.put("id", roleid);
			this.getGameRoleService().updateRoleSupsign(paramsu);// 存放入数据库
			// 更改按签到的天数领取礼物的标记状态
			JSONArray daynumstate = new JSONArray();
			Map<String, Object> paramd = new HashMap<String, Object>();
			String daynumstatez = supsign.toString();// 转换类型
			paramd.put("daynumstate", daynumstatez);
			paramd.put("id", roleid);
			this.getGameRoleService().updateRoleDaynumstate(paramd);// 存放入数据库

			// signin:签到记录
			// flag:今日有没有补签
			// reword:按几天一次，奖励领取记录
			rlt.put("day", day);
			rlt.put("allday", maxDate);
			rlt.put("signin", state);
			rlt.put("flag", 0);
			rlt.put("reward", daynumstate);// [0,1,2,3,4]
			rlt.put("num", 5 - supsign.size());
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);

		} else {
			// 直接取出来
			// 取出每天签到状况state,并转化为数组对象格式
			GameRole role = this.getGameRoleService().findRoleById(roleid);
			String state0 = role.getState();
			JSONArray state = JSONArray.fromObject(state0);

			// 取出补签状态supsign
			String supsign0 = role.getSupsign();
			JSONArray supsign = JSONArray.fromObject(supsign0);
			int flag = 1;
			if (!supsign.contains(day)) {
				flag = 0;
			} else {
				flag = 1;
			}
			// signin:签到记录
			// flag:今日有没有补签
			// reword:按几天一次，奖励领取记录
			String daynumstate0 = role.getDaynumstate();
			JSONArray daynumstate = JSONArray.fromObject(daynumstate0);
			rlt.put("day", day);
			rlt.put("allday", maxDate);
			rlt.put("signin", state);
			rlt.put("flag", flag);
			rlt.put("reward", daynumstate);
			rlt.put("num", 5 - supsign.size());
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
		}

	}

	private void getintensify() {
		// long ab = System.currentTimeMillis();
		// System.out.println("强化开始" + Integer.parseInt(playerId));
		if (params.containsKey("t") && params.containsKey("bid")
				&& params.containsKey("protect")) {
			Map<String, Object> rlt = new HashMap<String, Object>();
			int t = NumberUtils.createInteger(String.valueOf(params.get("t")));
			int bid = NumberUtils.createInteger(String.valueOf(params
					.get("bid")));
			int protect = NumberUtils.createInteger(String.valueOf(params
					.get("protect")));
			int roleid = Integer.parseInt(playerId);
			GameRoleDetail gameRole = this.getGameRoleService().findRoleById3(
					roleid);
			int rlevel = gameRole.getLevel();
			RoleEquipDetail requip = this.getRoleEquipService()
					.getRoleEquipById(bid).get(0);

			if (requip.getRoleId() != roleid) {
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -7);
				ServerHandler.sendData(session, respMap);
				return;
			}
			int yin = gameRole.getYin();
			int dengji = requip.getDengji();// 强化等级
			int equipid = requip.getEquipId();
			// requip=null;
			long nowtime = new Date().getTime();
			int successrate = 50;// 成功率
			long intensify = this.getRoleInsService().getRoleIns(roleid).get(0)
					.getSuccesstime();
			long a = nowtime - intensify;
			double b = (a % (60 * 60 * 1000.0)) / 60 / 1000.0;
			if (b <= 30) {
				successrate += (50 - b * 1.666);
				rlt.put("updown", 0);
			} else {
				successrate += ((b - 30) * 1.666);
				rlt.put("updown", 1);
			}
			rlt.put("successrate", successrate);
			if (t == 1) {// 强化
				if (protect == 1) {// 使用保护符1
					Map<String, Object> pa = new HashMap<String, Object>();
					pa.put("roleid", roleid);
					pa.put("itemid", 10);
					List<RoleItemDetail> ritem = this.getRoleItemService()
							.getRoleItem(pa);
					int num = ritem.get(0).getNum();
					if (num > 0) {// 守护符存在
						pa.clear();
						pa.put("roleid", roleid);
						pa.put("itemid", 10);
						pa.put("num", 1);// 减1
						this.getRoleItemService().subRoleItem(pa);
						// 成功率100
						// rlt.put("successrate", successrate);
						long id = ritem.get(0).getId();
						rlt.put("bagId", id);
						successrate = 100;
					} else {
						// 使用保护符失败
						long id = ritem.get(0).getId();
						ritem = null;
						rlt.put("bagId", id);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-6);

						rlt.put("t", 1);
						// 发送数据
						// RoleEquipDetail rq = this.getRoleEquipService()
						// .getRoleEquipById(bid).get(0);
						double attack = requip.getAttack();
						dengji = requip.getDengji();
						double hp = requip.getHpMax();
						double rang = requip.getRectlength();
						double speed = requip.getSpeed();

						requip = null;
						// yin = this.getGameRoleService().findRoleById(roleid)
						// .getYin();

						long intensifytime = this.getRoleInsService()
								.getRoleIns(roleid).get(0).getIntensifytime();
						/****/
						rlt.put("bid", bid);
						rlt.put("at", attack);
						rlt.put("dj", dengji);
						rlt.put("hp", hp);
						rlt.put("rect", rang);
						rlt.put("sp", speed);
						rlt.put("yin", yin);
						/****/
						if ((intensifytime - nowtime) > 0) {
							rlt.put("time", (intensifytime - nowtime));
						} else {
							rlt.put("time", 0);
						}
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
								rlt);
						ServerHandler.sendData(session, respMap);
						// rq=null;
						return;
					}
					pa = null;
					ritem = null;
				} else {// 不使用保护符1
					// rlt.put("successrate", successrate);
					rlt.put("bagId", 0);
				}

				if (rlevel > dengji) {// 可以强化3
					// 判断银币
					GameEquipDetail gequip = this.getGameEquipService()
							.getGameEquipById(equipid).get(0);
					int type = gequip.getType();// 类型判断为1的
					// ........................
					int quallity = gequip.getQuality();// 品质
					gequip = null;
					double price = this.getGameEInsService().getGameEInsById(
							dengji).get(0).getPrice();// 强化所需银币
					// price = price * Math.pow(1.414, (quallity - 1));
					if (quallity == 2) {
						price = price * 1.615;
					} else if (quallity == 3) {
						price = price * 2.608;
					} else if (quallity == 4) {
						price = price * 5.294;
					} else if (quallity == 5) {
						price = price * 8.55;
					}
					if (type == 1) {
						price = price * 1.5;
					}
					if (yin > price) {// 银币够用
						// 判断冷却时间
						List<RoleInsDetail> itensify = this.getRoleInsService()
								.getRoleIns(roleid);
						long itime = itensify.get(0).getIntensifytime();// 冷却时间

						itensify = null;
						long time = itime - nowtime;
						if (time <= 10 * 60 * 1000) {// 开始增加冷却时间2
							// 判断成功率
							Random random = new Random();
							int ran = random.nextInt(100);
							if (ran <= successrate) {// 成功，进行强化
								// 减少银币
								this.getGameRoleService().subRoleYin(roleid,
										(int) price);
								Map<String, Object> param = new HashMap<String, Object>();
								// 更新强化等级、攻击、血量、速度、范围
								param.clear();
								param.put("type", type);
								param.put("quality", quallity);
								List<GameEPropertyDetail> aa = this
										.getGameEPropertyService()
										.getGameEPropertyBytypequality(param);
								GameEPropertyDetail gep = aa.get(0);
								aa = null;
								// 强化获得值
								double attack = gep.getAttack();
								double hp = gep.getHp();
								double speed = gep.getSpeed();
								double rang = gep.getRange();

								gep = null;
								// 更新强化
								param.clear();
								param.put("id", bid);
								param.put("attack", attack);
								param.put("dengji", 1);
								param.put("hpMax", hp);
								param.put("speed", speed);
								param.put("rectlength", rang);
								boolean bo = this.getRoleEquipService()
										.updateRoleEquipById(param);

								/****/
								if (dengji >= 9) {
									String state0 = gameRole.getAimreward();
									JSONArray aimreward = JSONArray
											.fromObject(state0);// 目标大奖状态
									if (aimreward.getInt(7) == 0) {// 8。强化任意装备至10级
										aimreward.set(7, 1);
										param.clear();
										param.put("id", roleid);
										param.put("aimreward", aimreward
												.toString());
										this.getGameRoleService()
												.updateRoleVip(param);
									}
								}
								/****/

								if (itime < nowtime) {// nowtiem+冷却时间
									// 冷却时间增加....
									param.clear();
									param.put("roleId", roleid);
									param.put("intensifytime",
											(nowtime + 90 * 1000));
									this.getRoleInsService().updateIns(param);

								} else {// itime+冷却时间
									param.clear();
									param.put("roleId", roleid);
									param.put("intensifytime",
											(itime + 90 * 1000));
									this.getRoleInsService().updateIns(param);
								}
								respMap
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
												1);

								param = null;
								aa = null;
							} else {// 失败，减少银币，不强化
								// 减少银币
								this.getGameRoleService().subRoleYin(roleid,
										(int) price);
								respMap
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
												-2);

							}
							// ............................................

						} else {// 冷却时间大于10分钟2
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									-5);
						}
						itensify = null;
					} else {// 银币不够用
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-1);
					}
				} else {// 不可以强化rlevel<dengji3
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -4);
				}
				rlt.put("t", 1);
				Map<String, Object> pa = new HashMap<String, Object>();
				RoleDaytaskDetail roletask = this.getRoleDaytaskService()
						.findRoleDaytaskByRId(roleid);
				int qianghua = roletask.getQianghua();
				int abc = qianghua + 1;
				pa.clear();
				pa.put("roleid", roleid);
				pa.put("qianghua", abc);
				this.getRoleDaytaskService().updateRoleDaytask(pa);
				roletask = null;
				pa = null;
			} else if (t == 5) {// 快速强化不使用保护符
				if (protect == 1) {// 使用保护符1
					Map<String, Object> pa = new HashMap<String, Object>();
					pa.put("roleid", roleid);
					pa.put("itemid", 10);
					List<RoleItemDetail> ritem = this.getRoleItemService()
							.getRoleItem(pa);
					int num = ritem.get(0).getNum();
					if (num > 0) {// 守护符存在
						pa.clear();
						pa.put("roleid", roleid);
						pa.put("itemid", 10);
						pa.put("num", 1);// 减1
						this.getRoleItemService().subRoleItem(pa);
						// 成功率100
						// rlt.put("successrate", successrate);
						long id = ritem.get(0).getId();
						rlt.put("bagId", id);
						successrate = 100;
					} else {
						// 使用保护符失败
						long id = ritem.get(0).getId();
						ritem = null;
						rlt.put("bagId", id);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-6);

						rlt.put("t", 1);
						// 发送数据
						// RoleEquipDetail rq = this.getRoleEquipService()
						// .getRoleEquipById(bid).get(0);
						double attack = requip.getAttack();
						dengji = requip.getDengji();
						double hp = requip.getHpMax();
						double rang = requip.getRectlength();
						double speed = requip.getSpeed();

						requip = null;
						// yin = this.getGameRoleService().findRoleById(roleid)
						// .getYin();

						long intensifytime = this.getRoleInsService()
								.getRoleIns(roleid).get(0).getIntensifytime();
						/****/
						rlt.put("bid", bid);
						rlt.put("at", attack);
						rlt.put("dj", dengji);
						rlt.put("hp", hp);
						rlt.put("rect", rang);
						rlt.put("sp", speed);
						rlt.put("yin", yin);
						/****/
						if ((intensifytime - nowtime) > 0) {
							rlt.put("time", (intensifytime - nowtime));
						} else {
							rlt.put("time", 0);
						}
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
								rlt);
						ServerHandler.sendData(session, respMap);
						// rq=null;
						return;
					}
					pa = null;
					ritem = null;
				} else {// 不使用保护符1
					// rlt.put("successrate", successrate);
					rlt.put("bagId", 0);
				}

				if (rlevel > dengji) {// 可以强化3
					// 判断银币
					GameEquipDetail gequip = this.getGameEquipService()
							.getGameEquipById(equipid).get(0);
					int type = gequip.getType();// 类型判断为1的
					// ........................
					int quallity = gequip.getQuality();// 品质
					gequip = null;
					double price = this.getGameEInsService().getGameEInsById(
							dengji).get(0).getPrice();// 强化所需银币
					// price = price * Math.pow(1.414, (quallity - 1));
					if (quallity == 2) {
						price = price * 1.615;
					} else if (quallity == 3) {
						price = price * 2.608;
					} else if (quallity == 4) {
						price = price * 5.294;
					} else if (quallity == 5) {
						price = price * 8.55;
					}
					if (type == 1) {
						price = price * 1.5;
					}
					if (yin > price) {// 银币够用
						// 判断冷却时间
						List<RoleInsDetail> itensify = this.getRoleInsService()
								.getRoleIns(roleid);
						long itime = itensify.get(0).getIntensifytime();// 冷却时间

						itensify = null;
						long time = itime - nowtime;
						if (time <= 10 * 60 * 1000) {// 开始增加冷却时间2
							// 判断成功率
							Random random = new Random();
							int ran = random.nextInt(100);
							if (ran <= successrate) {// 成功，进行强化
								// 减少银币
								this.getGameRoleService().subRoleYin(roleid,
										(int) price);
								Map<String, Object> param = new HashMap<String, Object>();
								// 更新强化等级、攻击、血量、速度、范围
								param.clear();
								param.put("type", type);
								param.put("quality", quallity);
								List<GameEPropertyDetail> aa = this
										.getGameEPropertyService()
										.getGameEPropertyBytypequality(param);
								GameEPropertyDetail gep = aa.get(0);
								aa = null;
								// 强化获得值
								double attack = gep.getAttack();
								double hp = gep.getHp();
								double speed = gep.getSpeed();
								double rang = gep.getRange();

								gep = null;
								// 更新强化
								param.clear();
								param.put("id", bid);
								param.put("attack", attack);
								param.put("dengji", 1);
								param.put("hpMax", hp);
								param.put("speed", speed);
								param.put("rectlength", rang);
								boolean bo = this.getRoleEquipService()
										.updateRoleEquipById(param);

								/****/
								if (dengji >= 9) {
									String state0 = gameRole.getAimreward();
									JSONArray aimreward = JSONArray
											.fromObject(state0);// 目标大奖状态
									if (aimreward.getInt(7) == 0) {// 8。强化任意装备至10级
										aimreward.set(7, 1);
										param.clear();
										param.put("id", roleid);
										param.put("aimreward", aimreward
												.toString());
										this.getGameRoleService()
												.updateRoleVip(param);
									}
								}
								/****/

								if (itime < nowtime) {// nowtiem+冷却时间
									// 冷却时间增加....
									param.clear();
									param.put("roleId", roleid);
									param.put("intensifytime",
											(nowtime + 90 * 1000));
									this.getRoleInsService().updateIns(param);

								} else {// itime+冷却时间
									param.clear();
									param.put("roleId", roleid);
									param.put("intensifytime",
											(itime + 90 * 1000));
									this.getRoleInsService().updateIns(param);
								}
								respMap
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
												1);

								param = null;
								aa = null;
							} else {// 失败，减少银币，不强化
								// 减少银币
								this.getGameRoleService().subRoleYin(roleid,
										(int) price);
								respMap
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
												-2);

							}
							// ............................................

						} else {// 冷却时间大于10分钟2
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									-5);
						}
						itensify = null;
					} else {// 银币不够用
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-1);
					}
				} else {// 不可以强化rlevel<dengji3
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -4);
				}
				rlt.put("t", 5);
				Map<String, Object> pa = new HashMap<String, Object>();
				RoleDaytaskDetail roletask = this.getRoleDaytaskService()
						.findRoleDaytaskByRId(roleid);
				int qianghua = roletask.getQianghua();
				int abc = qianghua + 1;
				pa.clear();
				pa.put("roleid", roleid);
				pa.put("qianghua", abc);
				this.getRoleDaytaskService().updateRoleDaytask(pa);
				roletask = null;
				pa = null;
			} else if (t == 4) {// 快速强化,使用加速符
				if (protect == 1) {// 使用保护符1
					Map<String, Object> pa = new HashMap<String, Object>();
					pa.put("roleid", roleid);
					pa.put("itemid", 10);
					List<RoleItemDetail> ritem = this.getRoleItemService()
							.getRoleItem(pa);
					int num = ritem.get(0).getNum();
					if (num > 0) {// 守护符存在
						pa.clear();
						pa.put("roleid", roleid);
						pa.put("itemid", 10);
						pa.put("num", 1);// 减1
						this.getRoleItemService().subRoleItem(pa);
						// 成功率100
						// rlt.put("successrate", successrate);
						long id = ritem.get(0).getId();
						rlt.put("bagId", id);
						successrate = 100;
					} else {
						// 使用保护符失败
						long id = ritem.get(0).getId();
						ritem = null;
						rlt.put("bagId", id);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-6);

						rlt.put("t", 4);
						// 发送数据
						// RoleEquipDetail rq = this.getRoleEquipService()
						// .getRoleEquipById(bid).get(0);
						double attack = requip.getAttack();
						dengji = requip.getDengji();
						double hp = requip.getHpMax();
						double rang = requip.getRectlength();
						double speed = requip.getSpeed();

						requip = null;
						// yin = this.getGameRoleService().findRoleById(roleid)
						// .getYin();

						long intensifytime = this.getRoleInsService()
								.getRoleIns(roleid).get(0).getIntensifytime();
						/****/
						rlt.put("bid", bid);
						rlt.put("at", attack);
						rlt.put("dj", dengji);
						rlt.put("hp", hp);
						rlt.put("rect", rang);
						rlt.put("sp", speed);
						rlt.put("yin", yin);
						/****/
						if ((intensifytime - nowtime) > 0) {
							rlt.put("time", (intensifytime - nowtime));
						} else {
							rlt.put("time", 0);
						}
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
								rlt);
						ServerHandler.sendData(session, respMap);
						// rq=null;
						return;
					}
					pa = null;
					ritem = null;
				}
				if (rlevel > dengji) {// 可以强化3
					// 判断银币
					GameEquipDetail gequip = this.getGameEquipService()
							.getGameEquipById(equipid).get(0);
					int type = gequip.getType();// 类型判断为1的
					// ........................
					int quallity = gequip.getQuality();// 品质
					gequip = null;
					double price = this.getGameEInsService().getGameEInsById(
							dengji).get(0).getPrice();// 强化所需银币
					// price = price * Math.pow(1.414, (quallity - 1));
					if (quallity == 2) {
						price = price * 1.615;
					} else if (quallity == 3) {
						price = price * 2.608;
					} else if (quallity == 4) {
						price = price * 5.294;
					} else if (quallity == 5) {
						price = price * 8.55;
					}
					if (type == 1) {
						price = price * 1.5;
					}
					if (yin > price) {// 银币够用
						// 判断冷却时间
						List<RoleInsDetail> itensify = this.getRoleInsService()
								.getRoleIns(roleid);
						long itime = itensify.get(0).getIntensifytime();// 冷却时间

						itensify = null;
						long time = itime - nowtime;
						if (time <= 10 * 60 * 1000) {// 开始增加冷却时间2
							// 判断成功率
							Random random = new Random();
							int ran = random.nextInt(100);
							if (ran <= successrate) {// 成功，进行强化
								// 减少银币
								this.getGameRoleService().subRoleYin(roleid,
										(int) price);
								Map<String, Object> param = new HashMap<String, Object>();
								// 更新强化等级、攻击、血量、速度、范围
								param.clear();
								param.put("type", type);
								param.put("quality", quallity);
								List<GameEPropertyDetail> aa = this
										.getGameEPropertyService()
										.getGameEPropertyBytypequality(param);
								GameEPropertyDetail gep = aa.get(0);
								aa = null;
								// 强化获得值
								double attack = gep.getAttack();
								double hp = gep.getHp();
								double speed = gep.getSpeed();
								double rang = gep.getRange();

								gep = null;
								// 更新强化
								param.clear();
								param.put("id", bid);
								param.put("attack", attack);
								param.put("dengji", 1);
								param.put("hpMax", hp);
								param.put("speed", speed);
								param.put("rectlength", rang);
								boolean bo = this.getRoleEquipService()
										.updateRoleEquipById(param);

								/****/
								if (dengji >= 9) {
									String state0 = gameRole.getAimreward();
									JSONArray aimreward = JSONArray
											.fromObject(state0);// 目标大奖状态
									if (aimreward.getInt(7) == 0) {// 8。强化任意装备至10级
										aimreward.set(7, 1);
										param.clear();
										param.put("id", roleid);
										param.put("aimreward", aimreward
												.toString());
										this.getGameRoleService()
												.updateRoleVip(param);
									}
								}
								/****/

								if (itime < nowtime) {// nowtiem+冷却时间
									// 冷却时间增加....
									param.clear();
									param.put("roleId", roleid);
									param.put("intensifytime",
											(nowtime + 90 * 1000));
									this.getRoleInsService().updateIns(param);

								} else {// itime+冷却时间
									param.clear();
									param.put("roleId", roleid);
									param.put("intensifytime",
											(itime + 90 * 1000));
									this.getRoleInsService().updateIns(param);
								}
								respMap
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
												1);

								param = null;
								aa = null;
							} else {// 失败，减少银币，不强化
								// 减少银币
								this.getGameRoleService().subRoleYin(roleid,
										(int) price);
								respMap
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
												-2);

							}
							rlt.put("t", 4);
							Map<String, Object> pa = new HashMap<String, Object>();
							RoleDaytaskDetail roletask = this
									.getRoleDaytaskService()
									.findRoleDaytaskByRId(roleid);
							int qianghua = roletask.getQianghua();
							int abc = qianghua + 1;
							pa.clear();
							pa.put("roleid", roleid);
							pa.put("qianghua", abc);
							this.getRoleDaytaskService().updateRoleDaytask(pa);
							roletask = null;
							pa = null;
							// ............................................

						} else {// 冷却时间大于10分钟2
							Map<String, Object> param = new HashMap<String, Object>();
							RoleInsDetail rins = this.getRoleInsService()
									.getRoleIns(roleid).get(0);
							param.put("itemid", 2);// 加速卡id
							param.put("roleid", roleid);
							RoleItemDetail ritem = this.getRoleItemService()
									.getRoleItem(param).get(0);
							int num = ritem.getNum();
							long jid = 0;
							if (num > 0) {// 可以加速
								jid = ritem.getId();
								// num减1
								param.clear();
								param.put("roleid", roleid);
								param.put("itemid", 2);// 加速卡id
								param.put("num", 1);
								boolean bo = this.getRoleItemService()
										.subRoleItem(param);
								// 冷却时间为0
								param.clear();
								param.put("roleId", roleid);
								param.put("intensifytime", nowtime);
								boolean b1 = this.getRoleInsService()
										.updateIns(param);
								if (bo == true && b1 == true) {
									rlt.put("time", 0);
									if (protect == 1) {
										Map<String, Object> pa = new HashMap<String, Object>();
										pa.clear();
										pa.put("roleid", roleid);
										pa.put("itemid", 10);
										pa.put("num", -1);// 加回来一个守护服符
										this.getRoleItemService().subRoleItem(
												pa);
									}
									respMap
											.put(
													GameConstants.GAME_API_RESPONSE_FIELD_CODE,
													1);
								} else {
									if (time <= nowtime) {//
										rlt.put("time", 0);
									} else {
										rlt.put("time", (nowtime - time));
									}
									respMap
											.put(
													GameConstants.GAME_API_RESPONSE_FIELD_CODE,
													-1);
								}
							} else {// 加速卡不足
								if (time <= nowtime) {//
									rlt.put("time", 0);
								} else {
									rlt.put("time", (nowtime - time));
								}
								respMap
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
												-8);
							}
							rlt.put("jid", jid);
							rlt.put("bagId", 0);
							// rlt.put("t", 4);
							// Map<String, Object> pa = new HashMap<String,
							// Object>();
							// RoleDaytaskDetail roletask =
							// this.getRoleDaytaskService()
							// .findRoleDaytaskByRId(roleid);
							// int qianghua = roletask.getQianghua();
							// int abc = qianghua + 1;
							// pa.clear();
							// pa.put("roleid", roleid);
							// pa.put("qianghua", abc);
							// this.getRoleDaytaskService().updateRoleDaytask(pa);
							// roletask=null;
							// pa = null;
						}
						itensify = null;
					} else {// 银币不够用
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-1);
					}
				} else {// 不可以强化rlevel<dengji3
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -4);
				}
			} else if (t == 3) {// 直接降到1级
				rlt.put("t", 0);
				rlt.put("bagId", 0);
				// 装备等级降1，银币增加
				if (dengji > 1) {// 可以降级
					// 增加银币
					// double yinbi = 0;//降到1级返回的总钱数
					for (int y = 1; y < dengji; y++) {
						// 判断银币
						GameEquipDetail gequip = this.getGameEquipService()
								.getGameEquipById(equipid).get(0);
						int type = gequip.getType();// 等级判断为1的
						// ........................
						int quallity = gequip.getQuality();// 品质
						gequip = null;
						double price = this.getGameEInsService()
								.getGameEInsById((dengji - y)).get(0)
								.getPrice();// 强化所需银币
						price = price * 0.7;
						if (quallity == 2) {
							price = price * 1.615;
						} else if (quallity == 3) {
							price = price * 2.608;
						} else if (quallity == 4) {
							price = price * 5.294;
						} else if (quallity == 5) {
							price = price * 8.55;
						}
						if (type == 1) {
							price = price * 1.5;
						}
						// yinbi+=(int)price;
						this.getGameRoleService().addRoleYin(roleid,
								(int) price);// 增加银币
						// 减少等级、攻击、血量、速度、范围
						Map<String, Object> param = new HashMap<String, Object>();
						param.put("type", type);
						param.put("quality", quallity);
						GameEPropertyDetail gep = this
								.getGameEPropertyService()
								.getGameEPropertyBytypequality(param).get(0);

						double attack = gep.getAttack();
						double hp = gep.getHp();
						double speed = gep.getSpeed();
						double rang = gep.getRange();

						gep = null;
						// 降1级
						param.clear();
						param.put("dengji", 1);
						param.put("id", bid);
						param.put("attack", attack);
						param.put("hpMax", hp);
						param.put("speed", speed);
						param.put("rectlength", rang);
						this.getRoleEquipService().subRoleEquipById(param);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								1);

						param = null;
						gequip = null;
					}
					// System.out.println((int)yinbi);
				} else {// 等级小于1，不可以降级
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);
				}
			} else if (t == 0) {// 降级
				rlt.put("t", 0);
				rlt.put("bagId", 0);
				// 装备等级降1，银币增加
				if (dengji > 1) {// 可以降级
					// 增加银币
					// 判断银币
					GameEquipDetail gequip = this.getGameEquipService()
							.getGameEquipById(equipid).get(0);
					int type = gequip.getType();// 等级判断为1的
					// ........................
					int quallity = gequip.getQuality();// 品质
					gequip = null;
					double price = this.getGameEInsService().getGameEInsById(
							(dengji - 1)).get(0).getPrice();// 强化所需银币
					price = price * 0.7;
					if (quallity == 2) {
						price = price * 1.615;
					} else if (quallity == 3) {
						price = price * 2.608;
					} else if (quallity == 4) {
						price = price * 5.294;
					} else if (quallity == 5) {
						price = price * 8.55;
					}
					if (type == 1) {
						price = price * 1.5;
					}
					this.getGameRoleService().addRoleYin(roleid, (int) price);// 增加银币
					// 减少等级、攻击、血量、速度、范围
					Map<String, Object> param = new HashMap<String, Object>();
					param.put("type", type);
					param.put("quality", quallity);
					GameEPropertyDetail gep = this.getGameEPropertyService()
							.getGameEPropertyBytypequality(param).get(0);

					double attack = gep.getAttack();
					double hp = gep.getHp();
					double speed = gep.getSpeed();
					double rang = gep.getRange();

					gep = null;
					// 降1级
					param.clear();
					param.put("dengji", 1);
					param.put("id", bid);
					param.put("attack", attack);
					param.put("hpMax", hp);
					param.put("speed", speed);
					param.put("rectlength", rang);
					this.getRoleEquipService().subRoleEquipById(param);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, 1);

					param = null;
					gequip = null;

				} else {// 等级小于1，不可以降级
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);
				}
			}
			// 发送数据
			RoleEquipDetail rq = this.getRoleEquipService().getRoleEquipById(
					bid).get(0);
			double attack = rq.getAttack();
			dengji = rq.getDengji();
			double hp = rq.getHpMax();
			double rang = rq.getRectlength();
			double speed = rq.getSpeed();
			rq = null;
			yin = this.getGameRoleService().findRoleById(roleid).getYin();
			long intensifytime = this.getRoleInsService().getRoleIns(roleid)
					.get(0).getIntensifytime();

			rlt.put("bid", bid);
			rlt.put("at", attack);
			rlt.put("dj", dengji);
			rlt.put("hp", hp);
			rlt.put("rect", rang);
			rlt.put("sp", speed);
			rlt.put("yin", yin);
			this.getTaskHandler().taskcomplete(roleid);
			if ((intensifytime - nowtime) > 0) {
				rlt.put("time", (intensifytime - nowtime));
			} else {
				rlt.put("time", 0);
			}
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
			rlt = null;
			requip = null;
		}
		// long b = System.currentTimeMillis();
		// System.out.println("强化结束" + Integer.parseInt(playerId) + "用时：" +
		// (b-ab));
	}

	private void cleartime() {

		Map<String, Object> rlt = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		int roleid = Integer.parseInt(playerId);
		long nowtime = new Date().getTime();
		RoleInsDetail rins = this.getRoleInsService().getRoleIns(roleid).get(0);
		param.put("itemid", 2);// 加速卡id
		param.put("roleid", roleid);
		RoleItemDetail ritem = this.getRoleItemService().getRoleItem(param)
				.get(0);
		long intensify = rins.getSuccesstime();
		long time = rins.getIntensifytime();
		long bid = ritem.getId();
		int num = ritem.getNum();
		if (num > 0) {// 可以加速
			// num减1
			param.clear();
			param.put("roleid", roleid);
			param.put("itemid", 2);// 加速卡id
			param.put("num", 1);
			boolean bo = this.getRoleItemService().subRoleItem(param);
			// 冷却时间为0
			param.clear();
			param.put("roleId", roleid);
			param.put("intensifytime", nowtime);
			boolean b = this.getRoleInsService().updateIns(param);
			if (bo == true && b == true) {
				rlt.put("time", 0);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, 1);
			} else {
				if (time <= nowtime) {//
					rlt.put("time", 0);
				} else {
					rlt.put("time", (nowtime - time));
				}
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
			}
		} else {// 加速卡不足
			if (time <= nowtime) {//
				rlt.put("time", 0);
			} else {
				rlt.put("time", (nowtime - time));
			}
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
		}

		int successrate = 50;// 成功率
		long a = nowtime - intensify;
		double b = (a % (60 * 60 * 1000.0)) / 60 / 1000.0;
		if (b <= 30) {
			successrate += 50 - b * 1.666;
			rlt.put("updown", 0);
		} else {
			successrate += (b - 30) * 1.666;
			rlt.put("updown", 1);
		}
		rlt.put("successrate", successrate);
		rlt.put("bid", bid);

		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);
	}

	private void intensify() {
		int roleId = Integer.parseInt(playerId);
		List<RoleInsDetail> intensify = this.getRoleInsService().getRoleIns(
				roleId);
		long newdate = new Date().getTime();
		Map<String, Object> rlt = new HashMap<String, Object>();
		// 判断每日任务
		long nowtime = System.currentTimeMillis();
		long tt = this.getGameRoleService().findRoleById(roleId).getTasktime();
		int day = (int) ((nowtime - tt) / 1000 / 60 / 60 / 24 + 1);
		RoleDaytaskDetail roletask = this.getRoleDaytaskService()
				.findRoleDaytaskByRId(roleId);
		if (roletask.getDay() < day) {
			dayTask(roleId, day);
		}
		roletask = null;
		// 1上升0下降
		if (!intensify.isEmpty()) {
			int successrate = 50;
			long a = newdate - intensify.get(0).getSuccesstime();
			double b = (a % (60 * 60 * 1000.0)) / 60 / 1000.0;
			if (b <= 30) {
				successrate += (int) (50 - b * 1.666);
				rlt.put("updown", 0);
				rlt.put("successrate", successrate);

			} else {
				successrate += (int) ((b - 30) * 1.666);
				rlt.put("updown", 1);
				rlt.put("successrate", successrate);
			}
			long time = intensify.get(0).getIntensifytime();
			if ((newdate > time)) {
				rlt.put("time", 0);
			} else {
				rlt.put("time", (time - newdate));
			}

		} else {// 没有人的时候创建的时间表
			final long start = System.currentTimeMillis();
			RoleInsDetail aDetail = new RoleInsDetail();
			aDetail.setRoleId(roleId);
			aDetail.setSuccesstime(start);
			aDetail.setIntensifytime(0);
			this.getRoleInsService().insertRoleIns(aDetail);

			rlt.put("time", 0);
			rlt.put("successrate", 100);
			rlt.put("updown", 0);

		}
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		ServerHandler.sendData(session, respMap);

	}

	private void getTaskGift() {

		int roleId = Integer.parseInt(playerId);
		int level = this.getGameRoleService().findRoleById(roleId).getLevel();
		Map<String, Object> rlt = new HashMap<String, Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		RoleTaskDetail roletask = this.getRoleTaskService().findRoleTask(roleId).get(0);
		int status = roletask.getStatus();
		int rtype = roletask.getType();// 每日还是三日
		int tasktype = roletask.getTasktype();
		int dailynum = roletask.getDailynum();
		long time = roletask.getTime();// 倒计时再点击不执行
		long nowtime = new Date().getTime();
		// System.out.println("判断：" + (time <= nowtime));
		if (time <= nowtime) {// 可以点击领取按钮
			// System.out.println("pp:" + status);
			if (status == 0) {// 可以领取礼包

				/****/
				int multiple = 1;// 在设置的时间内奖品
				int month = 0;
				int dayn = 0;
				int monthend = 0;
				int dayend = 0;
				Calendar calendar = Calendar.getInstance();
				int month0 = calendar.get(Calendar.MONTH) + 1;
				int day0 = calendar.get(Calendar.DAY_OF_MONTH);
				params.clear();
				params.put("id", 20);
				List<ActivityDetail> activity = this.getActivityService()
						.getActivityByParams(params);
				if (!activity.isEmpty()) {
					// System.out.println("领取三日在线活动开启：：：：：：：：");
					month = activity.get(0).getMonth();
					dayn = activity.get(0).getDay();
					monthend = activity.get(0).getMonthend();
					dayend = activity.get(0).getDayend();
					int serverid = activity.get(0).getServerid();
					if (month0 == month && month0 == monthend) {
						if (day0 >= dayn && day0 <= dayend) {
							multiple = Integer.valueOf(String.valueOf(activity
									.get(0).getReward()));
						}
					} else if (month0 >= month && month0 <= monthend) {
						multiple = Integer.valueOf(String.valueOf(activity.get(
								0).getReward()));

					}
				}

				/****/

				int tid = 0;
				if (rtype == 1 && tasktype == 1) {// 每日在线roletask里的type
					tid = dailynum + 1;
				} else {
					tid = dailynum + 11;
				}

				List<GameTaskDetail> task = this.getGameTaskService()
						.getGameTaskDetailById(tid);// 获得id=1
				// System.out.println("ppp:" + !task.isEmpty());
				if (!task.isEmpty()) {// 可以领取
					// 领取装备道具
					String res = task.get(0).getTaskres();
					List<Map> resList = JSON.parseArray(String.valueOf(res),
							Map.class);

					JSONArray list = new JSONArray();// 用list<map>type=6会报错
					// System.out.println("vllll:" + resList.size());
					for (int i = 0; i < resList.size(); i++) {
						Map map = resList.get(i);
						int type = Integer.parseInt(String.valueOf(map
								.get("resType")));
						int id = Integer
								.parseInt(String.valueOf(map.get("id")));
						int num = Integer.parseInt(String.valueOf(map
								.get("num")));
						num = num * multiple;
						if (type == 5) {// 道具
							params.clear();
							params.put("roleid", roleId);
							params.put("itemid", id);
							List<RoleItemDetail> item = this
									.getRoleItemService().getRoleItem(params);
							params.put("num", num);// 获得数量
							params.put("resType", type);
							// 判断背包格子是否已满
							int itemtype = this.getGameItemService()
									.getGameItemById(id).get(0).getItemtype();
							boolean boo = getShangxian(itemtype, type, roleId,
									id, num);
							if (boo == false) {// 背包格子不足
								respMap
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
												-2);
								respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "道具空间不足");
								ServerHandler.sendData(session, respMap);
								return;
							}
							if (!item.isEmpty()) {// 已存在
								boolean bo = this.getRoleItemService()
										.addRoleItemNum(params);
								if (bo == true) {
									long bid = item.get(0).getId();
									params.put("bid", bid);
									params.put("id", id);
									params.remove("roleid");
									params.remove("itemid");
									list.add(params);
								} else {

								}
							} else {// 不存在，
								// int bid = this.getAutoIdService()
								// .fingKeyValueByTableName("role_item") + 1;
								long bid = this.getAutoIdService()
										.fingKeyValueByTableName("role_item");
								// System.out.println("playerHandler得到long类型的id:::"+bid);

								RoleItemDetail iDetail = new RoleItemDetail();
								iDetail.setId(bid);
								iDetail.setRoleid(roleId);
								iDetail.setItemid(id);
								iDetail.setNum(num);
								iDetail.setFlag(1);
								iDetail.setType(itemtype);
								boolean bo = this.getRoleItemService()
										.insertRoleItem(iDetail);
								// this.getAutoIdService()
								// .updateKeyValueAddOneByTableName(
								// "role_item");
								if (bo == true) {
									params.put("bid", bid);
									params.remove("roleid");
									params.put("id", id);
									params.remove("itemid");
									list.add(params);

								}
							}
						} else if (type == 6) {// 装备
							// 判断背包格子是否已满
							int equiptype = this.getGameEquipService()
									.getGameEquipById(id).get(0).getType();
							boolean boo = getShangxian(equiptype, type, roleId,
									id, num);
							if (boo == false) {// 背包格子不足
								respMap
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
												-2);
								respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "装备空间不足");
								ServerHandler.sendData(session, respMap);
								return;
							}
							// 判断num是几个装备，循环插入数据库
							for (int n = 0; n < num; n++) {
								// 直接插入
								List<GameEquipDetail> gameequips = this
										.getGameEquipService()
										.getGameEquipByEid(id);
								GameEquipDetail gameequip = null;
								if (!gameequips.isEmpty()) {
									gameequip = gameequips.get(0);

								}

								int bid = this.getAutoIdService()
										.fingKeyValueByTableName("role_equip");
								// 添加
								int speed = gameequip.getSudu();
								int attack = gameequip.getGongji();
								int hpMax = gameequip.getXueliang();
								int rectlength = gameequip.getFanwei();
								int t = gameequip.getType();
								String user = "0";
								RoleEquipDetail eDetail = new RoleEquipDetail();
								eDetail.setId(bid);
								eDetail.setDengji(1);
								eDetail.setEquipId(id);
								eDetail.setRoleId(roleId);
								eDetail.setFlag(1);
								eDetail.setType(t);
								eDetail.setAttack(attack);
								eDetail.setUser(user);
								eDetail.setHpMax(hpMax);
								eDetail.setRectlength(rectlength);
								eDetail.setSpeed(speed);
								this.getRoleEquipService().insertRoleEquip(
										eDetail);
								// this.getAutoIdService()
								// .updateKeyValueAddOneByTableName(
								// "role_equip");

								params.clear();
								params.put("num", 1);// 获得数量
								params.put("resType", type);
								params.put("bid", bid);
								params.put("id", id);

								params.put("at", attack);
								params.put("hp", hpMax);
								params.put("spd", speed);
								params.put("rl", rectlength);
								params.put("isUsed", 0);
								params.put("sl", 1);
								list.add(params);
							}

						}
					}
					params.clear();
					params.put("roleId", roleId);
					params.put("status", 1);
					this.getRoleTaskService().updateRoleTaskStatus(params);
					params.clear();
					params.put("dailynum", 1);
					params.put("roleId", roleId);
					this.getRoleTaskService().updateRoleTaskDailynum(params);
					// 增加倒计时，taskid+1
					RoleTaskDetail rtask = this.getRoleTaskService()
							.findRoleTask(roleId).get(0);
					int dnum = rtask.getDailynum();
					if (dnum < 10) {
						int seconds = this.getGameTaskService()
								.getGameTaskDetailById(tid + 1).get(0)
								.getTasknum();// 时间
						this.getRoleTaskService().updateRoleTaskTime(roleId,
								(nowtime + seconds * 1000), (tid + 1));
					}
					int coin = task.get(0).getTaskcoin();// 礼包银币数
					coin = coin * level * multiple;
					this.getGameRoleService().addRoleYin(roleId, coin);// 领取银币
					// ............
					// 显示总银币
					coin = this.getGameRoleService().findRoleById(roleId)
							.getYin();
					rlt.put("coin", coin);
					// 领取的次数
					int num = this.getRoleTaskService().findRoleTask(roleId)
							.get(0).getDailynum();
					rlt.put("num", num);
					// 奖励物品
					rlt.put("reward", list);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
					ServerHandler.sendData(session, respMap);

					/****/
					if (num >= 10) {
						GameRoleDetail gameRole = this.getGameRoleService()
								.findRoleById(roleId);
						String state0 = gameRole.getAimreward();
						JSONArray aimreward = JSONArray.fromObject(state0);// 目标大奖状态
						if (aimreward.getInt(13) == 0) {// 14。完成一次所有在线奖励领取
							aimreward.set(13, 1);
							params.clear();
							params.put("id", roleId);
							params.put("aimreward", aimreward.toString());
							this.getGameRoleService().updateRoleVip(params);

						}
					}
					/****/

				} else {// 不可以领取
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);
					ServerHandler.sendData(session, respMap);
				}
			} else {// status=1不可以领取礼包

			}
		} else {// 还在倒计时中
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
			ServerHandler.sendData(session, respMap);
		}

	}

	private void taskStartOnLine() {

		// System.out.println("PlayerHandler():taskStartOnline():begin;");
		int roleId = Integer.parseInt(playerId);
		Map<String, Object> rlt = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		// 零点更新
		long tt = this.getGameRoleService().findRoleById(roleId).getTasktime();
		// System.out.println("tt:" + tt);
		List<RoleTaskDetail> ro = this.getRoleTaskService()
				.findRoleTask(roleId);
		if (ro.isEmpty()) {
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
			ServerHandler.sendData(session, respMap);
			return;
		}
		int level = this.getGameRoleService().findRoleById(roleId).getLevel();
		/****/
		int multiple = 1;// 在设置的时间内奖品
		int month = 0;
		int dayn = 0;
		int monthend = 0;
		int dayend = 0;
		Calendar calendar = Calendar.getInstance();
		int month0 = calendar.get(Calendar.MONTH) + 1;
		int day0 = calendar.get(Calendar.DAY_OF_MONTH);
		param.clear();
		param.put("id", 20);
		List<ActivityDetail> activity = this.getActivityService()
				.getActivityByParams(param);
		if (!activity.isEmpty()) {
			System.out.println("每日在线奖励任务开始：：：：：：：：");
			month = activity.get(0).getMonth();
			dayn = activity.get(0).getDay();
			monthend = activity.get(0).getMonthend();
			dayend = activity.get(0).getDayend();
			int serverid = activity.get(0).getServerid();
			if (month0 == month && month0 == monthend) {
				if (day0 >= dayn && day0 <= dayend) {
					multiple = Integer.valueOf(String.valueOf(activity.get(0)
							.getReward()));
				}
			} else if (month0 >= month && month0 <= monthend) {
				multiple = Integer.valueOf(String.valueOf(activity.get(0)
						.getReward()));

			}
		}

		/****/
		int roleday = ro.get(0).getDay();
		long nowtime = new Date().getTime();
		int day = (int) ((nowtime - tt) / 1000 / 60 / 60 / 24 + 1);
		// System.out.println("panduan:" + (day > roleday));
		if (day > roleday) {
			param.clear();
			param.put("roleId", roleId);
			param.put("dailynum", 0);
			param.put("day", day);
			param.put("status", 1);
			this.getRoleTaskService().updateRoleTasknumday(param);
		}
		// System.out.println("day:" + day);
		if (day > 3) {// 每日
			// 更改type=1，tasktype=1
			if (ro.get(0).getType() == 1 && ro.get(0).getTasktype() != 1) {
				param.clear();
				param.put("roleId", roleId);
				param.put("type", 1);
				param.put("tasktype", 1);
				boolean BO = this.getRoleTaskService().updateRoleTaskStatus(
						param);
			}
		} else {// 三日
			if (ro.get(0).getType() == 1 && ro.get(0).getTasktype() != 2) {
				param.clear();
				param.put("roleId", roleId);
				param.put("type", 1);
				param.put("tasktype", 2);
				this.getRoleTaskService().updateRoleTaskStatus(param);
			}
		}

		RoleTaskDetail roletask = this.getRoleTaskService()
				.findRoleTask(roleId).get(0);
		// System.out.println("roleId:" + roleId);
		int type = roletask.getType();// 每日还是三日
		int tasktype = roletask.getTasktype();
		int dailynum = roletask.getDailynum();
		long time = roletask.getTime();// 倒计时再点击不执行
		if (dailynum < 10) {// 礼包没有领取完
			// System.out.println("time<= nowtime:" + (time <= nowtime));
			if (time <= nowtime) {// 可以领取礼包
				// 判断status是否等于0，不等于的话，更新为0
				int status = roletask.getStatus();
				// System.out.println("status:" + status);
				if (status == 1) {
					param.clear();
					param.put("roleId", roleId);
					param.put("status", 0);
					this.getRoleTaskService().updateRoleTaskStatus(param);
				} else {

				}
				// System.out.println("(type == 1 && tasktype == 1):" +type
				// +"    &     " + tasktype);
				if (type == 1 && tasktype == 1) {// 每日在线roletask里的type
					List<GameTaskDetail> task = this.getGameTaskService()
							.getGameTaskDetailById(dailynum + 1);// 获得id=1
					// System.out.println("dailnum:" + dailynum);
					// System.out.println("(!task.isEmpty()):" +
					// (!task.isEmpty()));
					if (!task.isEmpty()) {// 有任务
						// System.out.println("size:" + task.size());
						int coin = task.get(0).getTaskcoin();// 礼包银币数
						coin = coin * level * multiple;
						// System.out.println(multiple+"multiple        得到的总银币数量：：：：：：："+coin+":::原来的coin::"+task.get(0).getTaskcoin());
						JsonSerializer json = new JsonSerializer();
						List<Map<String, Object>> gifts = (List<Map<String, Object>>) json
								.deserialize(task.get(0).getTaskres());
						// System.out.println("gift.size::::::"+gifts.size());
						for (int i = 0; i < gifts.size(); i++) {
							// System.out.println("活动在线奖励道具原数量：：："+Integer.parseInt(String.valueOf(gifts.get(i).get("num"))));
							int startnum = Integer.parseInt(String
									.valueOf(gifts.get(i).get("num")))
									* multiple;
							gifts.get(i).put("num", startnum);
						}
						// 增加倒计时时间到数据库

						rlt.put("coin", coin);
						rlt.put("num", dailynum);
						rlt.put("reward", gifts);
						rlt.put("time", 0);
						// System.out.println("rlt:" + rlt.toString());
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								GameConstants.GAME_API_SUCCESS);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
								rlt);
						ServerHandler.sendData(session, respMap);
					} else {// 没有任务
					}
				} else if (type == 1 && tasktype == 2) {// 三日在线

					List<GameTaskDetail> task = this.getGameTaskService()
							.getGameTaskDetailById(dailynum + 11);// 获得id=11

					if (!task.isEmpty()) {// 有任务
						int coin = task.get(0).getTaskcoin();// 礼包银币数
						coin = coin * level * multiple;
						int minute = task.get(0).getTasknum();// 多少分钟
						JsonSerializer json = new JsonSerializer();
						List<Map<String, Object>> gifts = (List<Map<String, Object>>) json
								.deserialize(task.get(0).getTaskres());
						// 增加倒计时时间到数据库
						for (int i = 0; i < gifts.size(); i++) {
							// System.out.println("活动在线奖励道具原数量：：："+Integer.parseInt(String.valueOf(gifts.get(i).get("num"))));
							int startnum = Integer.parseInt(String
									.valueOf(gifts.get(i).get("num")))
									* multiple;
							gifts.get(i).put("num", startnum);
						}
						rlt.put("coin", coin);
						rlt.put("num", dailynum);
						rlt.put("reward", gifts);
						rlt.put("time", 0);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								GameConstants.GAME_API_SUCCESS);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
								rlt);
						ServerHandler.sendData(session, respMap);
					} else {// 没有任务
					}
				} else {// 其他

				}

			} else {// 礼包领取倒计时
				int status = roletask.getStatus();// 最好都更新0，否则的话等着点击领取按钮时,status不会更新了
				// System.out.println("status:" + status);
				if (status == 1) {
					param.clear();
					param.put("roleId", roleId);
					param.put("status", 0);
					this.getRoleTaskService().updateRoleTaskStatus(param);
				} else {

				}
				List<GameTaskDetail> task = null;
				// System.out.println("type == 1 && tasktype == 1:" + (type == 1
				// && tasktype == 1));
				if (type == 1 && tasktype == 1) {// 每日在线roletask里的type
					task = this.getGameTaskService().getGameTaskDetailById(
							dailynum + 1);// 获得id=1
				} else {
					task = this.getGameTaskService().getGameTaskDetailById(
							dailynum + 11);// 获得id=11
				}

				int coin = task.get(0).getTaskcoin();// 礼包银币数
				coin = coin * level * multiple;
				// System.out.println(multiple+"multiple得到的总银币数量：：：：：：："+coin);
				JsonSerializer json = new JsonSerializer();
				List<Map<String, Object>> gifts = (List<Map<String, Object>>) json
						.deserialize(task.get(0).getTaskres());
				for (int i = 0; i < gifts.size(); i++) {
					// System.out.println("活动在线奖励道具原数量：：："+Integer.parseInt(String.valueOf(gifts.get(i).get("num"))));
					int startnum = Integer.parseInt(String.valueOf(gifts.get(i)
							.get("num")))
							* multiple;
					gifts.get(i).put("num", startnum);
				}
				time = roletask.getTime();// 倒计时再点击不执行
				nowtime = new Date().getTime();
				rlt.put("coin", coin);
				rlt.put("num", dailynum);
				rlt.put("reward", gifts);
				// System.out.println("((time - nowtime) < 0):" + ((time -
				// nowtime) < 0));
				if ((time - nowtime) < 0) {
					rlt.put("time", 0);
				} else {
					rlt.put("time", (time - nowtime) / 1000 + 4);
				}

				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
			}
		} else {// 礼包已领取完
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
			ServerHandler.sendData(session, respMap);
			return;
		}
		rlt = null;
		param = null;

		// System.out.println("PlayerHandler():taskStartOnline():begin;");
		// int roleId = Integer.parseInt(playerId);
		// Map<String, Object> rlt = new HashMap<String, Object>();
		// Map<String, Object> param = new HashMap<String, Object>();
		// // 零点更新
		// long tt =
		// this.getGameRoleService().findRoleById(roleId).getTasktime();
		// // System.out.println("tt:" + tt);
		// List<RoleTaskDetail> ro =
		// this.getRoleTaskService().findRoleTask(roleId);
		// if(ro.isEmpty()){
		// respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
		// ServerHandler.sendData(session, respMap);
		// return;
		// }
		// int level=this.getGameRoleService().findRoleById(roleId).getLevel();
		// int roleday = ro.get(0).getDay();
		// long nowtime = new Date().getTime();
		// int day = (int) ((nowtime - tt) / 1000 / 60 / 60 / 24 + 1);
		// // System.out.println("panduan:" + (day > roleday));
		// if (day > roleday) {
		// param.clear();
		// param.put("roleId", roleId);
		// param.put("dailynum", 0);
		// param.put("day", day);
		// param.put("status", 1);
		// this.getRoleTaskService().updateRoleTasknumday(param);
		// }
		// // System.out.println("day:" + day);
		// if (day > 3) {// 每日
		// // 更改type=1，tasktype=1
		// if (ro.get(0).getType() == 1 && ro.get(0).getTasktype() != 1) {
		// param.clear();
		// param.put("roleId", roleId);
		// param.put("type", 1);
		// param.put("tasktype", 1);
		// boolean BO = this.getRoleTaskService().updateRoleTaskStatus(param);
		// }
		// } else {// 三日
		// if (ro.get(0).getType() == 1 && ro.get(0).getTasktype() != 2) {
		// param.clear();
		// param.put("roleId", roleId);
		// param.put("type", 1);
		// param.put("tasktype", 2);
		// this.getRoleTaskService().updateRoleTaskStatus(param);
		// }
		// }
		//		
		// RoleTaskDetail roletask =
		// this.getRoleTaskService().findRoleTask(roleId).get(0);
		// // System.out.println("roleId:" + roleId);
		// int type = roletask.getType();// 每日还是三日
		// int tasktype = roletask.getTasktype();
		// int dailynum = roletask.getDailynum();
		// long time = roletask.getTime();// 倒计时再点击不执行
		// if (dailynum < 10) {// 礼包没有领取完
		// //System.out.println("time<= nowtime:" + (time <= nowtime));
		// if (time <= nowtime) {// 可以领取礼包
		// // 判断status是否等于0，不等于的话，更新为0
		// int status = roletask.getStatus();
		// // System.out.println("status:" + status);
		// if (status == 1) {
		// param.clear();
		// param.put("roleId", roleId);
		// param.put("status", 0);
		// this.getRoleTaskService().updateRoleTaskStatus(param);
		// } else {
		//
		// }
		// //System.out.println("(type == 1 && tasktype == 1):" +type
		// +"    &     " + tasktype);
		// if (type == 1 && tasktype == 1) {// 每日在线roletask里的type
		// List<GameTaskDetail> task = this.getGameTaskService()
		// .getGameTaskDetailById(dailynum + 1);// 获得id=1
		// // System.out.println("dailnum:" + dailynum);
		// //System.out.println("(!task.isEmpty()):" + (!task.isEmpty()));
		// if (!task.isEmpty()) {// 有任务
		// //System.out.println("size:" + task.size());
		// int coin = task.get(0).getTaskcoin();// 礼包银币数
		// coin=coin*level;
		// //System.out.println("coin:" + coin);
		// JsonSerializer json = new JsonSerializer();
		// List<Map<String, Object>> gifts = (List<Map<String, Object>>)
		// json.deserialize(task.get(0).getTaskres());
		// // 增加倒计时时间到数据库
		//
		// rlt.put("coin", coin);
		// rlt.put("num", dailynum);
		// rlt.put("reward", gifts);
		// rlt.put("time", 0);
		// //System.out.println("rlt:" + rlt.toString());
		// respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
		// GameConstants.GAME_API_SUCCESS);
		// respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
		// rlt);
		// ServerHandler.sendData(session, respMap);
		// } else {// 没有任务
		// }
		// } else if (type == 1 && tasktype == 2) {// 三日在线
		//
		// List<GameTaskDetail> task = this.getGameTaskService()
		// .getGameTaskDetailById(dailynum + 11);// 获得id=11
		//
		// if (!task.isEmpty()) {// 有任务
		// int coin = task.get(0).getTaskcoin();// 礼包银币数
		// coin=coin*level;
		// int minute = task.get(0).getTasknum();// 多少分钟
		// JsonSerializer json = new JsonSerializer();
		// List<Map<String, Object>> gifts = (List<Map<String, Object>>) json
		// .deserialize(task.get(0).getTaskres());
		// // 增加倒计时时间到数据库
		//
		// rlt.put("coin", coin);
		// rlt.put("num", dailynum);
		// rlt.put("reward", gifts);
		// rlt.put("time", 0);
		// respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
		// GameConstants.GAME_API_SUCCESS);
		// respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
		// rlt);
		// ServerHandler.sendData(session, respMap);
		// } else {// 没有任务
		// }
		// } else {// 其他
		//
		// }
		//
		// } else {// 礼包领取倒计时
		// int status = roletask.getStatus();// 最好都更新0，否则的话等着点击领取按钮时,status不会更新了
		// //System.out.println("status:" + status);
		// if (status == 1) {
		// param.clear();
		// param.put("roleId", roleId);
		// param.put("status", 0);
		// this.getRoleTaskService().updateRoleTaskStatus(param);
		// } else {
		//
		// }
		// List<GameTaskDetail> task = null;
		// // System.out.println("type == 1 && tasktype == 1:" + (type == 1 &&
		// tasktype == 1));
		// if (type == 1 && tasktype == 1) {// 每日在线roletask里的type
		// task = this.getGameTaskService().getGameTaskDetailById(
		// dailynum + 1);// 获得id=1
		// } else {
		// task = this.getGameTaskService().getGameTaskDetailById(
		// dailynum + 11);// 获得id=11
		// }
		//
		// int coin = task.get(0).getTaskcoin();// 礼包银币数
		// coin=coin*level;
		// JsonSerializer json = new JsonSerializer();
		// List<Map<String, Object>> gifts = (List<Map<String, Object>>) json
		// .deserialize(task.get(0).getTaskres());
		//
		// time = roletask.getTime();// 倒计时再点击不执行
		// nowtime = new Date().getTime();
		// rlt.put("coin", coin);
		// rlt.put("num", dailynum);
		// rlt.put("reward", gifts);
		// // System.out.println("((time - nowtime) < 0):" + ((time - nowtime) <
		// 0));
		// if ((time - nowtime) < 0) {
		// rlt.put("time", 0);
		// } else {
		// rlt.put("time", (time - nowtime) / 1000 + 4);
		// }
		//
		// respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
		// GameConstants.GAME_API_SUCCESS);
		// respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		// ServerHandler.sendData(session, respMap);
		// }
		// } else {// 礼包已领取完
		// respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
		// ServerHandler.sendData(session, respMap);
		// return;
		// }
		// rlt=null;
		// param=null;

	}

	private void buymilitary() {
		// System.out.println("PlayerHandler.buyMilitary:params:" +
		// params.toString());
		if (params.containsKey("id")) {
			int roleid = Integer.parseInt(playerId);
			int id = Integer.parseInt(String.valueOf(params.get("id")));
			int vip = this.getGameRoleService().findRoleById(roleid).getVip();
			GameRoleDetail role = this.getGameRoleService()
					.findRoleById(roleid);
			// 黄钻享受vip2待遇
			if (vip < 2) {
				int huangzuan = 0;
				JsonSerializer json = new JsonSerializer();
				String Huangzuaninfo = this.getGameRoleService().findRoleById(
						roleid).getHuangzuaninfo();
				if ("null".equals(String.valueOf(Huangzuaninfo))) {

				} else {
					List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
							.deserialize(Huangzuaninfo);
					int ret = Integer.parseInt(String.valueOf(roleinfo.get(0)
							.get("ret")));
					if (ret == 0) {
						huangzuan = Integer.parseInt(String.valueOf(roleinfo
								.get(0).get("is_yellow_vip")));
					}
				}
				if (huangzuan == 1) {
					vip = 2;
				}
			}
			int top = this.getGameVipService().getGameVipByLe(vip).get(0)
					.getMilitaryTop();
			Map<String, Object> rlt = new HashMap<String, Object>();
			List<RoleMilitaryDetail> list = this.getRoleMilitaryService()
					.getRoleMilitary(roleid);
			String name = this.getGameMilitaryService()
					.getGameMilitaryBymid(id).get(0).getName();
			Map<String, Object> paramss = new HashMap<String, Object>();
			paramss.put("roleId", roleid);
			paramss.put("militaryid", id);
			List<RoleMilitaryDetail> lists = this.getRoleMilitaryService()
					.getRoleMilitaryByparam(paramss);
			if (!lists.isEmpty()) {
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);// 你已拥有次武将
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
			} else {
				if (list.size() < top) {
					if (Integer.parseInt(String.valueOf(params.get("g"))) == 1) {
						// 通过魔壂发送的魔将兑换请求
						List<GameMilitaryDetail> gMilitary = this
								.getGameMilitaryService().getGameMilitaryBymid(
										id);
						if (!gMilitary.isEmpty()) {
							if (role.getMohunboolean() != 0) {
								int value = gMilitary.get(0).getMohunprice();
								if (role.getMohun() > value) {
									role.setMohun(role.getMohun() - value);
									role.setMohunboolean(0);
								} else {
									// 魔魂不足
									respMap
											.put(
													GameConstants.GAME_API_RESPONSE_FIELD_CODE,
													-5);
									respMap
											.put(
													GameConstants.GAME_API_RESPONSE_FIELD_RLT,
													rlt);
									ServerHandler.sendData(session, respMap);
									return;
								}
							} else {
								respMap
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
												-6);
								respMap
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_RLT,
												rlt);
								ServerHandler.sendData(session, respMap);
								return;
							}

						} else {
							GameConstants.log
									.warn("PlayerHandler.buymilitary.militaryid is not exist in gameMilitary table(militaryid:"
											+ id + ")!");
						}
						Map<String, Object> param = new HashMap<String, Object>();
						int mid = this.getAutoIdService()
								.fingKeyValueByTableName("role_military");
						param.put("id", mid);
						param.put("militaryid", id);
						param.put("name", name);
						param.put("roleId", roleid);
						param.put("level", 1);
						param.put("exp", 0);
						param.put("type", 1);
						param.put("wuqi", 0);
						param.put("huwan", 0);
						param.put("yifu", 0);
						param.put("types", 1);
						param.put("touguan", 0);
						param.put("xiezi", 0);
						param.put("shipin", 0);
						// System.out.println("魔魂购买魔将参数：" + param.toString());
						this.getRoleMilitaryService().insertRoleMilitary(param);
						GameRoleDetail r = this.getGameRoleService()
								.findRoleById(roleid);
						Map<String, Object> moeny = new HashMap<String, Object>();
						moeny.put("yin", r.getYin());
						moeny.put("coin", r.getCoin());
						rlt.put("moeny", moeny);
						rlt.put("military", param);
						rlt.put("g", params.get("g"));
						// 系统公告
						List<GameMilitaryDetail> gameM = this
								.getGameMilitaryService().getGameMilitaryBymid(
										id);
						if (gameM.get(0).getPingzhi() >= 4) {
							Map<String, Object> res = new HashMap<String, Object>();
							Map<String, Object> rl = new HashMap<String, Object>();
							rl.put("pinzhi", gameM.get(0).getPingzhi());
							rl.put("mess", gameM.get(0).getName());
							rl.put("info", "招募");
							rl.put("place", 0);
							// 添加黄钻信息
							JsonSerializer json = new JsonSerializer();
							String Huangzuaninfo = this.getGameRoleService()
									.findRoleById(roleid).getHuangzuaninfo();
							if ("null".equals(String.valueOf(Huangzuaninfo))) {
								// rl.put("rname", "");
								rl.put("isyellowvip", 0);
								rl.put("yellowviplevel", 0);
								rl.put("isyellowyearsvip", 0);
							} else {
								List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
										.deserialize(Huangzuaninfo);
								int ret = Integer.parseInt(String
										.valueOf(roleinfo.get(0).get("ret")));
								if (ret == 0) {
									// rl.put("rname",
									// this.getGameRoleService().findRoleById(roleid).getName());
									rl.put("isyellowvip", roleinfo.get(0).get(
											"is_yellow_vip"));
									rl.put("yellowviplevel", roleinfo.get(0)
											.get("yellow_vip_level"));
									rl.put("isyellowyearsvip", roleinfo.get(0)
											.get("is_yellow_year_vip"));
								} else {
									// rl.put("rname", "");
									rl.put("isyellowvip", 0);
									rl.put("yellowviplevel", 0);
									rl.put("isyellowyearsvip", 0);
								}
							}
							rl.put("rname", this.getGameRoleService()
									.findRoleById(roleid).getName());

							res.put("roleline", 1);
							List<GameRoleDetail> status = this
									.getGameRoleService().getRoleByLevel(res);
							if (status.isEmpty()) {
								return;
							}
//							for (int i = 0; i < status.size(); i++) {
//								res.clear();
//								res
//										.put(
//												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
//												GameConstants.GAME_API_SUCCESS);
//								res
//										.put(
//												GameConstants.GAME_API_RESPONSE_FIELD_RLT,
//												rl);
//								res
//										.put(
//												GameConstants.GAME_API_RESPONSE_FIELD_CMD,
//												"sys.send");
//								ServerHandler.sendDataByRoleId(res, status.get(
//										i).getId());
//							}
						}
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								GameConstants.GAME_API_SUCCESS);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
								rlt);
						ServerHandler.sendData(session, respMap);
						param = null;

					} else {
						int yin = this.getGameRoleService()
								.findRoleById(roleid).getYin();
						int coin = this.getGamePriceService().getGamePriceById(
								id).get(0).getResCost();
						if (yin >= coin) {// 金币足够
							this.getGameRoleService().subRoleYin(roleid, coin);// 扣除银币
							List<RoleTavernDetail> tavern = this
									.getRoleTavernService().getRoleTavern(
											roleid);// 刷新酒馆武将
							Map<String, Object> p = new HashMap<String, Object>();
							p.put("roleId", roleid);
							if (id == tavern.get(0).getId1()) {
								p.put("id1", 0);
							} else if (id == tavern.get(0).getId2()) {
								p.put("id2", 0);
							} else if (id == tavern.get(0).getId3()) {
								p.put("id3", 0);
							} else if (id == tavern.get(0).getId4()) {
								p.put("id4", 0);
							} else if (id == tavern.get(0).getId5()) {
								p.put("id5", 0);
							} else if (id == tavern.get(0).getId6()) {
								p.put("id6", 0);
							} else {
								return;// 不是自己招募出来的武将
							}
							boolean bo = this.getRoleTavernService()
									.updateRoleTavern(p);
							if (bo == true) {
								Map<String, Object> param = new HashMap<String, Object>();
								int mid = this.getAutoIdService()
										.fingKeyValueByTableName(
												"role_military");
								param.put("id", mid);
								param.put("militaryid", id);
								param.put("name", name);
								param.put("roleId", roleid);
								param.put("level", 1);
								param.put("exp", 0);
								param.put("type", 1);
								param.put("wuqi", 0);
								param.put("huwan", 0);
								param.put("yifu", 0);
								param.put("types", 1);
								param.put("touguan", 0);
								param.put("xiezi", 0);
								param.put("shipin", 0);
								bo = this.getRoleMilitaryService()
										.insertRoleMilitary(param);
								GameRoleDetail r = this.getGameRoleService()
										.findRoleById(roleid);
								Map<String, Object> moeny = new HashMap<String, Object>();
								moeny.put("yin", r.getYin());
								moeny.put("coin", r.getCoin());
								rlt.put("moeny", moeny);
								rlt.put("military", param);
								rlt.put("g", params.get("g"));
								
								
								List<GameMilitaryDetail> gameM = this
										.getGameMilitaryService()
										.getGameMilitaryBymid(id);
								if (gameM.get(0).getPingzhi() >= 4) {
									// 系统公告//发送广播
//									String message= "玩家 <font color=\"#FF80FF\">" + role.getName() + "</font>" + role.getVip() + "通过 <font color=\"#FFFF00\">" + ((Integer.parseInt(String.valueOf(params.get("g"))) == 0)?"酒馆招募":"魔王之殿") + "</font> 获得了魔将 <font color=\"" + GlobalData.color.get(gameM.get(0).getPingzhi()) + "\">" + gameM.get(0).getName() + "</font>";
//									GameConstants.log.warn("PlayerHanlerHandler.buyMilitary:" + message);
//									this.getsystemHandler().addMessage(message);
									UtilHandler util = new UtilHandler();
									String name2 = role.getName();
									int vip2 = role.getVip();
									String where = (Integer.parseInt(String.valueOf(params.get("g"))) == 0)?"酒馆招募":"魔王之殿";
									int pinzhi = gameM.get(0).getPingzhi();
									String goodsName = gameM.get(0).getName();
									util.sendGetMessage(name2, vip2, where, pinzhi, goodsName,"player_zhaomu");
									
								
									Map<String, Object> res = new HashMap<String, Object>();
									Map<String, Object> rl = new HashMap<String, Object>();
									rl.put("pinzhi", gameM.get(0).getPingzhi());
									rl.put("mess", gameM.get(0).getName());
									rl.put("info", "招募");
									rl.put("place", 0);
									// 添加黄钻信息
									JsonSerializer json = new JsonSerializer();
									String Huangzuaninfo = this
											.getGameRoleService().findRoleById(
													roleid).getHuangzuaninfo();
									if ("null".equals(String
											.valueOf(Huangzuaninfo))) {
										// rl.put("rname", "");
										rl.put("isyellowvip", 0);
										rl.put("yellowviplevel", 0);
										rl.put("isyellowyearsvip", 0);
									} else {
										List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
												.deserialize(Huangzuaninfo);
										int ret = Integer.parseInt(String
												.valueOf(roleinfo.get(0).get(
														"ret")));
										if (ret == 0) {
											// rl.put("rname",
											// this.getGameRoleService().findRoleById(roleid).getName());
											rl.put("isyellowvip", roleinfo.get(
													0).get("is_yellow_vip"));
											rl
													.put(
															"yellowviplevel",
															roleinfo
																	.get(0)
																	.get(
																			"yellow_vip_level"));
											rl.put("isyellowyearsvip", roleinfo
													.get(0)
													.get("is_yellow_year_vip"));
										} else {
											// rl.put("rname", "");
											rl.put("isyellowvip", 0);
											rl.put("yellowviplevel", 0);
											rl.put("isyellowyearsvip", 0);
										}
									}
									rl.put("rname", this.getGameRoleService()
											.findRoleById(roleid).getName());

									res.put("roleline", 1);
									List<GameRoleDetail> status = this
											.getGameRoleService()
											.getRoleByLevel(res);
									if (status.isEmpty()) {
										return;
									}
//									for (int i = 0; i < status.size(); i++) {
//										res.clear();
//										res
//												.put(
//														GameConstants.GAME_API_RESPONSE_FIELD_CODE,
//														GameConstants.GAME_API_SUCCESS);
//										res
//												.put(
//														GameConstants.GAME_API_RESPONSE_FIELD_RLT,
//														rl);
//										res
//												.put(
//														GameConstants.GAME_API_RESPONSE_FIELD_CMD,
//														"sys.send");
//										ServerHandler.sendDataByRoleId(res,
//												status.get(i).getId());
//									}
								}
								respMap
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
												GameConstants.GAME_API_SUCCESS);
								respMap
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_RLT,
												rlt);
								ServerHandler.sendData(session, respMap);
								if(gameM.get(0).getPingzhi()==5){
									param.clear();
									param.put("id", roleid);
									param.put("milluck", 0);
									this.getGameRoleService().updateRoleVip(param);
//									System.out.println("清空幸运值");
								}
								param = null;
							}
						} else {// 金币不够
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									-1);
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_RLT,
									rlt);
							ServerHandler.sendData(session, respMap);
						}
					}

				} else {// 装备上线
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);// 格子满了
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
					ServerHandler.sendData(session, respMap);
				}
			}

			params = null;
			rlt = null;
		}
	}

	private void kqzm() {
		int roleid = Integer.parseInt(playerId);
		long time = new Date().getTime();
		// 更新每日任务
		long tt = this.getGameRoleService().findRoleById(roleid).getTasktime();
		int day = (int) ((time - tt) / 1000 / 60 / 60 / 24 + 1);
		RoleDaytaskDetail roletask = this.getRoleDaytaskService()
				.findRoleDaytaskByRId(roleid);
		if (roletask.getDay() < day) {
			dayTask(roleid, day);
		}
		roletask = null;

		List<GameMilitaryDetail> list = null;
		int[] shuzu = new int[6];
		int military = 0;
		Map<String, Object> rlt = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		List bool = new ArrayList();

		List<RoleTavernDetail> jiuguan = this.getRoleTavernService()
				.getRoleTavern(roleid);
		if (!jiuguan.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("roleId", roleid);
			List<RoleMilitaryDetail> ms = this.getRoleMilitaryService()
					.getRoleMilitaryByparam(map);
			int size = ms.size();
			if (time - (jiuguan.get(0).getTime()) > 8 * 60 * 60 * 1000) {
				// 开始招募
				for (int i = 0; i < 2; i++) {
					int n = (int) (Math.random() * (80 + 20 + 5 + 1));
					if (n >= 0 && n < 80) {
						list = this.getGameMilitaryService()
								.getGameMilitaryByBz(1);
						n = (int) (Math.random() * list.size());
						military = list.get(n).getId();
					} else if (n >= 80 && n < 100) {
						list = this.getGameMilitaryService()
								.getGameMilitaryByBz(2);
						n = (int) (Math.random() * list.size());
						military = list.get(n).getId();
					} else if (n >= 100 && n < 105) {
						list = this.getGameMilitaryService()
								.getGameMilitaryByBz(3);
						n = (int) (Math.random() * list.size());
						military = list.get(n).getId();
					} else if (n >= 105) {
						list = this.getGameMilitaryService()
								.getGameMilitaryByBz(4);
						n = (int) (Math.random() * list.size());
						military = list.get(n).getId();
					}
					for (int t = 0; t < size; t++) {
						if (military == ms.get(t).getMilitaryid()) {
							i--;
							break;
						}
					}
					for (int j = 0; j < bool.size(); j++) {
						if (military == Integer.parseInt(String.valueOf(bool
								.get(j)))) {
							i--;
							break;
						}
					}
					bool.add(military);
					shuzu[i] = military;
				}
				bool = null;
				ms = null;
				map = null;
				param.put("roleId", roleid);
				param.put("id1", shuzu[0]);
				param.put("id2", shuzu[1]);
				param.put("id3", 0);
				param.put("id4", 0);
				param.put("id5", 0);
				param.put("id6", 0);
				param.put("time", time);
				this.getRoleTavernService().updateRoleTavern(param);
				param = null;
				rlt.put("time", 8 * 60 * 60 * 1000);
			} else {
				shuzu[0] = jiuguan.get(0).getId1();
				shuzu[1] = jiuguan.get(0).getId2();
				shuzu[2] = jiuguan.get(0).getId3();
				shuzu[3] = jiuguan.get(0).getId4();
				shuzu[4] = jiuguan.get(0).getId5();
				shuzu[5] = jiuguan.get(0).getId6();
				rlt.put("time", (8 * 60 * 60 * 1000 - time + jiuguan.get(0)
						.getTime()));
			}
		} else {
			// System.out.println("开始招募！！！！！！！！！！！！！！！！！！！！！！！！！！！");
			// 开始招募
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("roleId", roleid);
			List<RoleMilitaryDetail> ms = this.getRoleMilitaryService()
					.getRoleMilitaryByparam(map);
			int size = ms.size();
			for (int i = 0; i < 2; i++) {
				int n = (int) (Math.random() * (80 + 20 + 5 + 1));
				if (n >= 0 && n < 80) {
					list = this.getGameMilitaryService().getGameMilitaryByBz(1);
					n = (int) (Math.random() * list.size());
					military = list.get(n).getId();
				} else if (n >= 80 && n < 100) {
					list = this.getGameMilitaryService().getGameMilitaryByBz(2);
					n = (int) (Math.random() * list.size());
					military = list.get(n).getId();
				} else if (n >= 100 && n < 105) {
					list = this.getGameMilitaryService().getGameMilitaryByBz(3);
					n = (int) (Math.random() * list.size());
					military = list.get(n).getId();
				} else if (n >= 105) {
					list = this.getGameMilitaryService().getGameMilitaryByBz(4);
					n = (int) (Math.random() * list.size());
					military = list.get(n).getId();
				}
				for (int t = 0; t < size; t++) {
					if (military == ms.get(t).getMilitaryid()) {
						i--;
						continue;
					}
				}
				for (int j = 0; j < bool.size(); j++) {
					if (military == Integer.parseInt(String
							.valueOf(bool.get(j)))) {
						i--;
						continue;
					}
				}
				bool.add(military);
				shuzu[i] = military;
			}
			param.put("roleId", roleid);
			param.put("id1", shuzu[0]);
			param.put("id2", shuzu[1]);
			param.put("id3", 0);
			param.put("id4", 0);
			param.put("id5", 0);
			param.put("id6", 0);
			param.put("time", time);
			// System.out.println("___________PlayerHanler.insertRoleTavern():______param:"
			// + param.toString());

			this.getRoleTavernService().insertRoleTavern(param);
			param = null;
			rlt.put("time", 8 * 60 * 60 * 1000);
		}
		rlt.put("militaryid", shuzu);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);

		rlt = null;
		param = null;
	}

	private void recruit() {
		long a = System.currentTimeMillis();
		// System.out.println("酒馆招募开始" + Integer.parseInt(playerId));
		// long b = System.currentTimeMillis();
		if (params.containsKey("t")) {
			int roleid = Integer.parseInt(playerId);
			// int vip =
			// this.getGameRoleService().findRoleById(roleid).getVip();
			GameRoleDetail g = (GameRoleDetail) session
					.getAttribute("gamerole");// 获取gamerole的值

			if (g == null) {
				g = this.getGameRoleService().findRoleById(roleid);

			}
			int vip = g.getVip();

			int t = Integer.parseInt(String.valueOf(params.get("t")));
			Map<String, Object> rlt = new HashMap<String, Object>();
			Map<String, Object> param = new HashMap<String, Object>();

			List<GameMilitaryDetail> list = null;

			int military = 0;
			boolean bo = false;
			long time = new Date().getTime();
			int[] shuzu = new int[6];
			long bid = 0;
			int num = 0;
			JSONArray listItem = new JSONArray();// 发放红色碎片
			List<RoleItemDetail> roleItem = null;
			int status = 0;
			// b = System.currentTimeMillis();
			// System.out.println("switch前:" + Integer.parseInt(playerId) +
			// "用时：" + (b-a));
			switch (t) {
			case 1:
				// System.out.println("初级招募========================");
				param.clear();
				param.put("roleid", roleid);
				param.put("itemid", GameConstants.GAME_chuji);
				roleItem = this.getRoleItemService().getRoleItem(param);
				// System.out.println("PlayerHanler中得到招妖令个数num:" +
				// roleItem.get(0).getNum() + "  roleItem.size:" +
				// roleItem.size());
				if (roleItem.size() > 1)
					roleItem.subList(0, roleItem.size() - 1);
				// System.out.println("PlayerHanler中得到招妖令个数num:" +
				// roleItem.get(0).getNum() + "  roleItem.size:" +
				// roleItem.size());

				if (roleItem.isEmpty()) {// 道具不存在
					return;
				}
				bid = roleItem.get(0).getId();
				num = roleItem.get(0).getNum();
				if (num > 0) {
					param.clear();
					param.put("roleid", roleid);
					param.put("num", 1);
					param.put("itemid", GameConstants.GAME_chuji);
					bo = this.getRoleItemService().sbRoleItemNum(param);
					if (bo == true) {
						for (int i = 0; i < 2; i++) {// 3103
							int n = (int) (Math.random() * (6000 + 3500 + 450 + 19 + 1));
							if (n >= 0 && n < 6000) {
								param.clear();
								param.put("roleId", roleid);
								param.put("pingzhi", 1);
								list = this.getGameMilitaryService()
										.getGameMilitaryByparam(param);
								if (!list.isEmpty()) {
									n = (int) (Math.random() * list.size());
									military = list.get(n).getId();
								} else {
									i--;
									continue;
								}

							} else if (n >= 6000 && n < 9500) {
								param.clear();
								param.put("roleId", roleid);
								param.put("pingzhi", 2);
								list = this.getGameMilitaryService()
										.getGameMilitaryByparam(param);
								if (!list.isEmpty()) {
									n = (int) (Math.random() * list.size());
									military = list.get(n).getId();
								} else {
									i--;
									continue;
								}
							} else if (n >= 9500 && n < 9950) {
								param.clear();
								param.put("roleId", roleid);
								param.put("pingzhi", 3);
								list = this.getGameMilitaryService()
										.getGameMilitaryByparam(param);
								if (!list.isEmpty()) {
									n = (int) (Math.random() * list.size());
									military = list.get(n).getId();
								} else {
									i--;
									continue;
								}
							} else if (n >= 9950 && n < 9999) {
								param.clear();
								param.put("roleId", roleid);
								param.put("pingzhi", 4);
								list = this.getGameMilitaryService()
										.getGameMilitaryByparam(param);
								if (!list.isEmpty()) {
									int id = getId(list);
									military = id;// 返回一个id
								} else {
									i--;
									continue;
								}
							}
							/*
							 * 初级招募补加金色魔将
							 */
							else if (n == 9999) {
								param.clear();
								param.put("roleId", roleid);
								param.put("pingzhi", 5);
								list = this.getGameMilitaryService()
										.getGameMilitaryByparam(param);
								if (!list.isEmpty()) {
									int id = getId(list);
									military = id;// 返回一个id
								} else {
									i--;
									continue;
								}
							}// 添加完成 概率几乎不可能
							status = 0;
							for (int k = 0; k < 6; k++) {
								if (military == shuzu[k]) {
									i--;
									status = 1;
									break;
								}
							}
							if (status == 0) {
								shuzu[i] = military;
							}
						}
						RoleDaytaskDetail roletask = this
								.getRoleDaytaskService().findRoleDaytaskByRId(
										roleid);
						long zhaomu = roletask.getZhaomu();
						long abc = zhaomu + 1;
						param.clear();
						param.put("roleid", roleid);
						param.put("zhaomu", abc);
						this.getRoleDaytaskService().updateRoleDaytaskzm(param);
					}
					// 更新武将
					List<RoleTavernDetail> jiuguan = this
							.getRoleTavernService().getRoleTavern(roleid);
					if (!jiuguan.isEmpty()) {
						param.clear();
						param.put("roleId", roleid);
						param.put("id1", shuzu[0]);
						param.put("id2", shuzu[1]);
						param.put("id3", shuzu[2]);
						param.put("id4", shuzu[3]);
						param.put("id5", shuzu[4]);
						param.put("id6", shuzu[5]);
						param.put("time", time);
						this.getRoleTavernService().updateRoleTavern(param);

						// 增加积分
						// System.out.println("增加积分");
						int jifen = jiuguan.get(0).getJifen();
						double ran = Math.random();// [0.0~1.0)
						if (0 <= ran && ran < 0.5) {// 加1
							if ((jifen + 1) < 200) {
								param.clear();
								param.put("roleId", roleid);
								param.put("jifen", jifen + 1);
								this.getRoleTavernService().updateRoleTavern(
										param);
							} else {// 发红将碎片
								getItem(roleid, 27, 1, 5, listItem);
								// 清空积分
								param.clear();
								param.put("roleId", roleid);
								param.put("jifen", 0);
								this.getRoleTavernService().updateRoleTavern(
										param);
							}
						} else {
							if ((jifen + 2) < 200) {
								param.clear();
								param.put("roleId", roleid);
								param.put("jifen", jifen + 2);
								this.getRoleTavernService().updateRoleTavern(
										param);
							} else {// 发红将碎片
								getItem(roleid, 27, 1, 5, listItem);
								// 清空积分
								param.clear();
								param.put("roleId", roleid);
								param.put("jifen", 0);
								this.getRoleTavernService().updateRoleTavern(
										param);
							}
						}
						// System.out.println("增加积分........over");
					}
					// jiuguan=null;
					// 记录招募了几次
					List<RoleTavernDetail> RoleTavern = jiuguan;// this.getRoleTavernService().getRoleTavern(roleid);
					if (!RoleTavern.isEmpty()) {
						// System.out.println("酒馆初级招募：：；第几次：："+RoleTavern.get(0).getChuji());

						if (RoleTavern.get(0).getChuji() <= 5) {
							param.clear();
							param.put("roleId", roleid);
							param.put("chuji",
									(RoleTavern.get(0).getChuji() + 1));
							this.getRoleTavernService().updateRoleTavern(param);
							// 任务提示
							this.getTaskHandler().taskcomplete(roleid);
						}
					}
					jiuguan = null;
					RoleTavern = null;
				}
				break;
			case 2:
				// System.out.println("中级招募========================");
				param.clear();
				param.put("roleid", roleid);
				param.put("itemid", GameConstants.GAME_zhongji);
				roleItem = this.getRoleItemService().getRoleItem(param);
				if (roleItem.isEmpty()) {// 道具不存在
					return;
				}
				bid = roleItem.get(0).getId();
				num = roleItem.get(0).getNum();
				if (num > 0) {
					param.clear();
					param.put("roleid", roleid);
					param.put("num", 1);
					param.put("itemid", GameConstants.GAME_zhongji);
					bo = this.getRoleItemService().sbRoleItemNum(param);
					if (bo == true) {
						String helpstep = this.getGameRoleService()
								.findRoleById(roleid).getHelpstep();

						JSONArray helpjson = JSONArray.fromObject(helpstep);

						int helps = helpjson.getInt(3);
						if (helps == 3 || helps == 2) {
							List<RoleTavernDetail> jiuguan = this
									.getRoleTavernService().getRoleTavern(
											roleid);
							if (!jiuguan.isEmpty()) {
								shuzu[0] = 3012;
								shuzu[1] = 1016;
								shuzu[2] = 1017;
								shuzu[3] = 0;
								shuzu[4] = 0;
								shuzu[5] = 0;
								param.clear();
								param.put("roleId", roleid);
								param.put("id1", shuzu[0]);
								param.put("id2", shuzu[1]);
								param.put("id3", shuzu[2]);
								param.put("id4", shuzu[3]);
								param.put("id5", shuzu[4]);
								param.put("id6", shuzu[5]);
								param.put("time", time);
								this.getRoleTavernService().updateRoleTavern(
										param);
							}
						} else {
							for (int i = 0; i < 3; i++) {// 3159
								int n = (int) (Math.random() * (5000 + 4000 + 975 + 24 + 1));
								if (n >= 0 && n < 5000) {
									param.clear();
									param.put("roleId", roleid);
									param.put("pingzhi", 1);
									list = this.getGameMilitaryService()
											.getGameMilitaryByparam(param);
									if (!list.isEmpty()) {
										n = (int) (Math.random() * list.size());
										military = list.get(n).getId();
									} else {
										i--;
										continue;
									}
								} else if (n >= 5000 && n < 9000) {
									param.clear();
									param.put("roleId", roleid);
									param.put("pingzhi", 2);
									list = this.getGameMilitaryService()
											.getGameMilitaryByparam(param);
									if (!list.isEmpty()) {
										n = (int) (Math.random() * list.size());
										military = list.get(n).getId();
									} else {
										i--;
										continue;
									}
								} else if (n >= 9000 && n < 9975) {
									param.clear();
									param.put("roleId", roleid);
									param.put("pingzhi", 3);
									list = this.getGameMilitaryService()
											.getGameMilitaryByparam(param);
									if (!list.isEmpty()) {
										n = (int) (Math.random() * list.size());
										military = list.get(n).getId();
									} else {
										i--;
										continue;
									}
								} else if (n >= 9975 && n < 9999) {
									param.clear();
									param.put("roleId", roleid);
									param.put("pingzhi", 4);
									list = this.getGameMilitaryService()
											.getGameMilitaryByparam(param);
									if (!list.isEmpty()) {
										int id = getId(list);
										military = id;// 返回一个id
									} else {
										i--;
										continue;
									}
								}
								// 中级招募添加金色魔将
								else if (n >= 9999) {
									param.clear();
									param.put("roleId", roleid);
									param.put("pingzhi", 5);
									list = this.getGameMilitaryService()
											.getGameMilitaryByparam(param);
									if (!list.isEmpty()) {
										int id = getId(list);
										military = id;// 返回一个id
									} else {
										i--;
										continue;
									}
								}// 添加完成

								status = 0;
								for (int k = 0; k < 6; k++) {
									if (military == shuzu[k]) {
										i--;
										status = 1;
										break;
									}
								}
								if (status == 0) {
									shuzu[i] = military;
								}
							}

							List<RoleTavernDetail> jiuguan = this
									.getRoleTavernService().getRoleTavern(
											roleid);
							if (!jiuguan.isEmpty()) {
								param.clear();
								param.put("roleId", roleid);
								param.put("id1", shuzu[0]);
								param.put("id2", shuzu[1]);
								param.put("id3", shuzu[2]);
								param.put("id4", shuzu[3]);
								param.put("id5", shuzu[4]);
								param.put("id6", shuzu[5]);
								param.put("time", time);
								this.getRoleTavernService().updateRoleTavern(
										param);

								// 增加积分
								// System.out.println("中级..........");
								int jifen = jiuguan.get(0).getJifen();
								double ran = Math.random();
								if (0 <= ran && ran < 0.5) {//
									if ((jifen + 3) < 200) {
										param.clear();
										param.put("roleId", roleid);
										param.put("jifen", jifen + 3);
										this.getRoleTavernService()
												.updateRoleTavern(param);
									} else {// 发红将碎片
										getItem(roleid, 27, 1, 5, listItem);
										// 清空积分
										param.clear();
										param.put("roleId", roleid);
										param.put("jifen", 0);
										this.getRoleTavernService()
												.updateRoleTavern(param);
									}
								} else if (ran >= 0.5 && ran < 0.995) {
									if ((jifen + 5) < 200) {
										param.clear();
										param.put("roleId", roleid);
										param.put("jifen", jifen + 5);
										this.getRoleTavernService()
												.updateRoleTavern(param);
									} else {// 发红将碎片
										getItem(roleid, 27, 1, 5, listItem);
										// 清空积分
										param.clear();
										param.put("roleId", roleid);
										param.put("jifen", 0);
										this.getRoleTavernService()
												.updateRoleTavern(param);
									}
								} else {// 100
									getItem(roleid, 27, 1, 5, listItem);
								}
								// System.out.println("中级..........over");
							}
							jiuguan = null;
						}
						// 每日任务添加中级招募次数
						RoleDaytaskDetail roletask = this
								.getRoleDaytaskService().findRoleDaytaskByRId(
										roleid);
						int middlerecruit = roletask.getMiddlerecruit();
						int abc = middlerecruit + 1;
						param.clear();
						param.put("roleid", roleid);
						param.put("middlerecruit", abc);
						this.getRoleDaytaskService().updateRoleDaytask(param);
						// System.out.println("原中级招募次数：：middlerecruit；："+middlerecruit+"总共中级招募次数：：：："+abc);

					}
				}
				break;
			case 3:
				// System.out.println("高级招募========================");
				if (vip >= 3) {
					// System.out.println("33333");
					param.clear();
					param.put("roleid", roleid);
					param.put("itemid", GameConstants.GAME_gaoji);
					roleItem = this.getRoleItemService().getRoleItem(param);
					if (roleItem.isEmpty()) {// 道具不存在
						return;
					}
					bid = roleItem.get(0).getId();
					num = roleItem.get(0).getNum();
					if (num > 0) {
						GameRoleDetail gamerole = this.getGameRoleService().findRoleById(roleid);
						int milluck = gamerole.getMilluck();//幸运值
//						System.out.println("本次必出金将概率=="+milluck+"/1000");
						int luckrandom = (int)(Math.random()*1000);
						int flag = 0;
						param.clear();
						param.put("roleid", roleid);
						param.put("num", 1);
						param.put("itemid", GameConstants.GAME_gaoji);
						bo = this.getRoleItemService().sbRoleItemNum(param);
						if (bo == true) {
							List<RoleMilitaryDetail> roleMilitary = this.getRoleMilitaryService().getRoleMilitary(roleid);
							int yellowMilitaryNum = 0;
							for (int i = 0; i < roleMilitary.size(); i++) {
								if(roleMilitary.get(i).getMilitaryid() >= 5000 && roleMilitary.get(i).getFlag()==1){
									yellowMilitaryNum ++ ;
								}
							}
							// 定义一个标识
//							System.out.println("yellowMilitaryNum="+yellowMilitaryNum);
							for (int i = 0; i < 6; i++) {// 2817
								int n = (int) (Math.random() * (8400 + 1500 + 90 + 10));
								if(milluck > luckrandom && i == 5){
									if(milluck >=480 && yellowMilitaryNum<=10){
										n = 9999;//强制roll点为最大值出金奖
										flag = 1;
									}
								}
								if (n >= 0 && n < 8400) {
									param.clear();
									param.put("roleId", roleid);
									param.put("pingzhi", 2);
									list = this.getGameMilitaryService()
											.getGameMilitaryByparam(param);
									if (!list.isEmpty()) {
										n = (int) (Math.random() * list.size());
										military = list.get(n).getId();
									} else {
										i--;
										continue;
									}
								} else if (n >= 8400 && n < 9900) {
									param.clear();
									param.put("roleId", roleid);
									param.put("pingzhi", 3);

									list = this.getGameMilitaryService()
											.getGameMilitaryByparam(param);

									if (!list.isEmpty()) {
										n = (int) (Math.random() * list.size());
										military = list.get(n).getId();
										// int test = list.get(n).getMjchange();
										// System.out.println(test+"ID："+list.get(n).getId()+"mjchange:"+list.get(n).getMjchange());
									} else {
										i--;
										continue;
									}
								} else if (n >= 9900 && n < 9990) {
									param.clear();
									param.put("roleId", roleid);
									param.put("pingzhi", 4);
									list = this.getGameMilitaryService()
											.getGameMilitaryByparam(param);
									if (!list.isEmpty()) {
										int id = getId(list);
										military = id;// 返回一个id
									} else {
										i--;
										continue;
									}

								} else if (n >= 9990) {
									param.clear();
									param.put("roleId", roleid);
									param.put("pingzhi", 5);
									list = this.getGameMilitaryService()
											.getGameMilitaryByparam(param);
									if (!list.isEmpty()) {
										int id = getId(list);
										military = id;// 返回一个id
									} else {
										i--;
										continue;
									}
								}
								status = 0;
								for (int k = 0; k < 6; k++) {
									if (military == shuzu[k]) {
										i--;
										status = 1;
										break;
									}
									if(flag == 1){//如果这个武将是活动武将,取消该武将被随机出来
										List<GameMilitaryDetail> gamemilitary = 
											this.getGameMilitaryService().getGameMilitaryBymid(military);
										int activityMjchance = gamemilitary.get(0).getMjchance();
//										System.out.println("activityMjchance=="+activityMjchance);
										if(activityMjchance >=300){
											i--;
											status = 1;
											break;
										}
										gamemilitary = null;
									}
								}
								if (status == 0) {
									shuzu[i] = military;
								}
							}
							// 测试
							List<RoleTavernDetail> jiuguan = this
									.getRoleTavernService().getRoleTavern(
											roleid);
							if (!jiuguan.isEmpty()) {
								param.clear();
								param.put("roleId", roleid);
								param.put("id1", shuzu[0]);
								param.put("id2", shuzu[1]);
								param.put("id3", shuzu[2]);
								param.put("id4", shuzu[3]);
								param.put("id5", shuzu[4]);
								param.put("id6", shuzu[5]);
								param.put("time", time);
								this.getRoleTavernService().updateRoleTavern(
										param);
								//增加武将幸运
								milluck += 5;
								param.clear();
								param.put("id", roleid);
								param.put("milluck", milluck);
//								System.out.println("增加一次幸运度");
								this.getGameRoleService().updateRoleVip(param);
								// 增加积分
								int jifen = jiuguan.get(0).getJifen();
								double ran = Math.random();
								if (0 <= ran && ran < 0.5) {// 加1
									if ((jifen + 10) < 200) {
										param.clear();
										param.put("roleId", roleid);
										param.put("jifen", jifen + 10);
										this.getRoleTavernService()
												.updateRoleTavern(param);
									} else {// 发红将碎片
										getItem(roleid, 27, 1, 5, listItem);
										// 清空积分
										param.clear();
										param.put("roleId", roleid);
										param.put("jifen", 0);
										this.getRoleTavernService()
												.updateRoleTavern(param);
									}
								} else if (ran >= 0.5 && ran < 0.98) {
									if ((jifen + 15) < 200) {
										param.clear();
										param.put("roleId", roleid);
										param.put("jifen", jifen + 15);
										this.getRoleTavernService()
												.updateRoleTavern(param);
									} else {// 发红将碎片
										getItem(roleid, 27, 1, 5, listItem);
										// 清空积分
										param.clear();
										param.put("roleId", roleid);
										param.put("jifen", 0);
										this.getRoleTavernService()
												.updateRoleTavern(param);
									}
								} else {// 100
									getItem(roleid, 27, 1, 5, listItem);
								}
							}
							jiuguan = null;
							// 每日任务添加高级招募次数
							RoleDaytaskDetail roletask = this
									.getRoleDaytaskService()
									.findRoleDaytaskByRId(roleid);
							int toprecruit = roletask.getToprecruit();
							int abc = toprecruit + 1;
							param.clear();
							param.put("roleid", roleid);
							param.put("toprecruit", abc);
							this.getRoleDaytaskService().updateRoleDaytask(
									param);
							
							/****/
							String state0 = g.getAimreward();
							JSONArray aimreward = JSONArray.fromObject(state0);// 目标大奖状态
							if (aimreward.getInt(10) == 0) {// 11。进行一次顶级招募
								aimreward.set(10, 1);
								param.clear();
								param.put("id", roleid);
								param.put("aimreward", aimreward.toString());
								this.getGameRoleService().updateRoleVip(param);
							}

							/****/

							// System.out.println("原高级招募次数：：toprecruit；："+toprecruit+"总共高级招募次数：：：："+abc);
							gamerole = null;
							roleMilitary = null;
						}
					} else {
						bo = false;
					}
				}
				break;
			}
			// b = System.currentTimeMillis();
			// System.out.println("switch后：" + Integer.parseInt(playerId) +
			// "用时：" + (b-a));
			if (bo == true) {
				rlt.put("militaryid", shuzu);
				rlt.put("bid", bid);
				rlt.put("t", t);
				rlt.put("res", listItem);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);

			} else {
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "");
			}
			ServerHandler.sendData(session, respMap);
			// b = System.currentTimeMillis();
			// System.out.println("更改前：" + Integer.parseInt(playerId) + "用时：" +
			// (b-a));

			// RoleDaytaskDetail roletask = this.getRoleDaytaskService()
			// .findRoleDaytaskByRId(roleid);
			// long zhaomu = roletask.getZhaomu();
			// long abc = zhaomu + 1;
			// param.clear();
			// param.put("roleid", roleid);
			// param.put("zhaomu", abc);
			// this.getRoleDaytaskService().updateRoleDaytaskzm(param);
			rlt = null;
			param = null;
			shuzu = null;
			listItem = null;
			roleItem = null;
			list = null;
			// roletask=null;
		}
		// b = System.currentTimeMillis();
		// System.out.println("酒馆招募结束:" + Integer.parseInt(playerId) + "用时：" +
		// (b-a));
	}

	private void delres() {// type：5道具 6装备 cointype 1银币2金币3魔魂
		if (params.containsKey("id") && params.containsKey("bid")
				&& params.containsKey("type")) {
			int roleid = Integer.parseInt(playerId);
			int id = Integer.parseInt(String.valueOf(params.get("id")));
			// int bid = Integer.parseInt(String.valueOf(params.get("bid")));
			long bid = Long.parseLong(String.valueOf(params.get("bid")));
			int type = Integer.parseInt(String.valueOf(params.get("type")));
			boolean bo = false;
			Map<String, Object> rlt = new HashMap<String, Object>();
			Map<String, Object> param = new HashMap<String, Object>();
			if (type == 5) {
				// List<RoleItemDetail> res = this.getRoleItemService()
				// .findRoleItemsById(bid);
				param.clear();
				param.put("roleid", roleid);
				param.put("itemid", id);
				List<RoleItemDetail> res = this.getRoleItemService()
						.getRoleItemByitem(param);
				// System.out.println("Play.delres.res:" + res.isEmpty());
				if (!res.isEmpty()) {
					int num = res.get(0).getNum();
					List<GameItemDetail> gameRes = this.getGameItemService()
							.getGameItemById(id);
					if (!gameRes.isEmpty()) {
						int cointype = gameRes.get(0).getCointype();
						int coin = gameRes.get(0).getCoin();
						if (cointype == 1) {
							this.getGameRoleService().addRoleYin(roleid,
									coin * num);
						} else if (cointype == 2) {
							this.getGameRoleService().addRoleCoin(roleid,
									coin * num);
						} else if (cointype == 3) {
							this.getGameRoleService().findRoleById(roleid)
									.setMohun(
											this.getGameRoleService()
													.findRoleById(roleid)
													.getMohun()
													+ coin * num);
						}
						// param.put("roleid", roleid);
						// param.put("id", bid);
						// bo = this.getRoleItemService().delRoleItem(param);
						param.clear();
						param.put("roleid", roleid);
						param.put("num", num);
						param.put("itemid", id);
						bo = this.getRoleItemService().sbRoleItemNum(param);
						param = null;
						gameRes = null;
						res = null;
					}
				}
			} else if (type == 6) {
				int bids = (int) bid;
				List<RoleEquipDetail> roleequip = this.getRoleEquipService()
						.getRoleEquipById(bids);
				if (!roleequip.isEmpty()) {
					if (roleequip.get(0).getRoleId() != roleid) {
						return;
					}
					int dengji = roleequip.get(0).getDengji();
					// 获取模型表里面的出售钱的类型、多少
					if (dengji == 1) {
						List<GameEquipDetail> gameequip = this
								.getGameEquipService().getGameEquipById(id);
						int cointype = gameequip.get(0).getCointype();
						int coin = gameequip.get(0).getCoin();
						if (cointype == 1) {
							this.getGameRoleService().addRoleYin(roleid, coin);
						} else if (cointype == 2) {
							this.getGameRoleService().addRoleCoin(roleid, coin);
						} else if (cointype == 3) {
							this.getGameRoleService().findRoleById(roleid)
									.setMohun(
											this.getGameRoleService()
													.findRoleById(roleid)
													.getMohun()
													+ coin);
						}
						param.clear();
						param.put("roleId", roleid);
						param.put("id", bids);

						bo = this.getRoleEquipService().deleteRoleEquip(param);
						param = null;
						roleequip = null;
						gameequip = null;

					} else {
						// 不可以出售
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-1);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
								"等级不为1，不可以出售");
						ServerHandler.sendData(session, respMap);
						return;
					}

				}
			}
			if (bo == true) {
				Map<String, Object> item = new HashMap<String, Object>();
				item.put("bid", bid);
				item.put("id", id);
				item.put("type", type);
				Map<String, Object> money = new HashMap<String, Object>();
				GameRoleDetail r = this.getGameRoleService().findRoleById(
						roleid);
				money.put("yin", r.getYin());
				money.put("coin", r.getCoin());
				rlt.put("money", money);
				rlt.put("item", item);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
				rlt = null;
				money = null;
				item = null;
			}
		}
	}

	private void buyres() {
		// System.out.println("PlayerHandler:buyres():params:" +
		// params.toString() );
		if (params.containsKey("payitem")) {
			int roleId = Integer.parseInt(playerId);
			String payitem = String.valueOf(params.get("payitem"));// ID*price*num
			// 获取购买信息
			List<MemberDetail> member = this.getMemberService().findMemberByid(
					roleId);
			String openid = "";
			if (!member.isEmpty()) {
				openid = member.get(0).getUsername();
				List<DeliveryDetail> delivery = this.getDeliveryService()
						.findDeliveryByopenid(openid);
				if (!delivery.isEmpty()) {
					if (delivery.get(0).getStatus() == 0) {
						return;// 非法购买
					}
					payitem = delivery.get(0).getPayitem();
				}
			}

			String[] strs = payitem.split("\\*");
			if (strs.length != 3) {
				return;
			}
			int id = Integer.parseInt(strs[0]);
			String[] c = strs[1].split("\\.");
			int coin = Integer.parseInt(c[0]);
			int num = Integer.parseInt(strs[2]);

			// int id = 92;
			// int coin = 650;
			// int num = 10;
			if (id == 92) {
				coin = 0;
			} else {
				// coin = coin*num;
				coin = 0;
			}
			List<GameItemDetail> ritem = this.getGameItemService()
					.getGameItemById(id);
			if (ritem.isEmpty()) {
				if (id >= 10000) {

				} else {
					return;
				}
			}
			// int type = ritem.get(0).getItemtype();
			int resType = 5;
			int isover = 0;
			Map<String, Object> rlt = new HashMap<String, Object>();
			Map<String, Object> paramp = new HashMap<String, Object>();
			paramp.put("resType", resType);
			paramp.put("resId", id);
			List<GamePriceDetail> list = this.getGamePriceService()
					.getGamePrice(paramp);
			if (!list.isEmpty()) {
				// int coin = list.get(0).getResCost();
				// //黄钻八折
				// int huangzuan =
				// this.getGameRoleService().findRoleById(roleId).getHuangzuan();
				// if(huangzuan==1){
				// if((coin * 4)%5==0){
				// coin = (int) (coin *0.8);
				// }else{
				// coin = (int) (coin * 0.8)+1;
				// }
				// }
				GameRoleDetail role = this.getGameRoleService().findRoleById(
						roleId);
				// int coins = 0;
				// if (list.get(0).getCostType() == 1) {
				// coins = role.getYin();
				// } else {
				// coins = role.getCoin();
				// }

				// type :子类型 resType:主类型 roleId:人物id id:物品
				// int num = 1;
				boolean b = false;
				int s = 0;
				if (id >= 10000) {
					b = true;
					s = 1;// 图腾
				} else {
					b = getShangxian(ritem.get(0).getItemtype(), resType,
							roleId, id, num);
				}
				if (b == true) {
					if (list.get(0).getCostType() == 1) {
						// bo = this.getGameRoleService().subRoleYin(roleId,
						// coin);

					} else {
						// bo = this.getGameRoleService().subRoleCoin(roleId,
						// coin);

						Map<String, Object> paramc = new HashMap<String, Object>();
						paramc.put("id", roleId);
						paramc.put("coinspend", coin);
						boolean boo = this.getGameRoleService()
								.addRolecoinspend(paramc);
						if (boo == true) {

							// 获取人物VIP等级
							int vip = this.getGameRoleService().findRoleById(
									roleId).getVip();
							// 消费的总金币
							int coinspendz = this.getGameRoleService()
									.findRoleById(roleId).getCoinspend();
							// 跟模型表里面进行比较看看能到达哪个等级
							int Nvip = this.getGameVipService()
									.getGameVipByAllvipRmb(coinspendz).get(0)
									.getVipLevel();
							int cha = this.getGameVipService().getGameVipByLe(
									Nvip).get(0).getVipRmb()
									- coinspendz;
							rlt.put("cha", cha);
							if (Nvip > vip) {
								// 更改用户的vip等级
								Map<String, Object> paramv = new HashMap<String, Object>();
								paramv.put("id", roleId);
								paramv.put("vip", Nvip);
								this.getGameRoleService().updateRoleVip(paramv);
								// 给前端发送数据
								Map<String, Object> rlt1 = new HashMap<String, Object>();
								rlt1.put("vip", Nvip);
								Map<String, Object> res = new HashMap<String, Object>();
								res
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
												GameConstants.GAME_API_SUCCESS);
								res
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_ACTPID,
												roleId);
								res
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CMD,
												"sys.viplevelup");
								res
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_RLT,
												rlt1);
								ServerHandler.sendDataByRoleId(res, roleId);
								res.clear();
								rlt1.clear();
								// 系统公告//发送广播
//								String message= "玩家 <font color=\"#FF0000\">" + role.getName() + "</font>的VIP等级提升到了 <font color=\"#FFFF00\"><b>" + role.getVip() + "</b></font>";
//								GameConstants.log.warn("Military.buyItems:" + message);
//								this.getsystemHandler().addMessage(message);
								UtilHandler util = new UtilHandler();
								String name = role.getName();
								int vip2 = role.getVip();
								String where = "累计消费";
								int pinzhi = 6;
								String goodsName = "尊贵称号:VIP "+vip2;
								util.sendGetMessage(name, vip2, where, pinzhi, goodsName,"player_VIP upgrade");
								
								rlt1.put("vip", Nvip);
								rlt1.put("info", "购买");
								rlt1.put("place", 1);
								// 添加黄钻信息
								JsonSerializer json = new JsonSerializer();
								String Huangzuaninfo = this
										.getGameRoleService().findRoleById(
												roleId).getHuangzuaninfo();
								if ("null"
										.equals(String.valueOf(Huangzuaninfo))) {
									// rlt1.put("rname", "");
									rlt1.put("isyellowvip", 0);
									rlt1.put("yellowviplevel", 0);
									rlt1.put("isyellowyearsvip", 0);
								} else {
									List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
											.deserialize(Huangzuaninfo);
									int ret = Integer
											.parseInt(String.valueOf(roleinfo
													.get(0).get("ret")));
									if (ret == 0) {
										// rlt1.put("rname",
										// this.getGameRoleService().findRoleById(roleId).getName());
										rlt1.put("isyellowvip", roleinfo.get(0)
												.get("is_yellow_vip"));
										rlt1
												.put(
														"yellowviplevel",
														roleinfo
																.get(0)
																.get(
																		"yellow_vip_level"));
										rlt1.put("isyellowyearsvip", roleinfo
												.get(0).get(
														"is_yellow_year_vip"));
									} else {
										// rlt1.put("rname", "");
										rlt1.put("isyellowvip", 0);
										rlt1.put("yellowviplevel", 0);
										rlt1.put("isyellowyearsvip", 0);
									}
								}
								rlt1.put("rname", this.getGameRoleService()
										.findRoleById(roleId).getName());
								res.put("roleline", 1);
								List<GameRoleDetail> status = this
										.getGameRoleService().getRoleByLevel(
												res);
								if (status.isEmpty()) {
									return;
								}
//								for (int i = 0; i < status.size(); i++) {
//									res.clear();
//									res
//											.put(
//													GameConstants.GAME_API_RESPONSE_FIELD_CODE,
//													GameConstants.GAME_API_SUCCESS);
//									res
//											.put(
//													GameConstants.GAME_API_RESPONSE_FIELD_RLT,
//													rlt1);
//									res
//											.put(
//													GameConstants.GAME_API_RESPONSE_FIELD_CMD,
//													"sys.send");
//									//ServerHandler.sendDataByRoleId(res, status.get(i).getId());
//								}
							}
						}
					}
					// 道具信息
					Map<String, Object> param = new HashMap<String, Object>();
					param.put("roleid", roleId);
					param.put("itemid", id);
					List<RoleItemDetail> item = this.getRoleItemService()
							.getRoleItem(param);
					Map<String, Object> items = new HashMap<String, Object>();
					if (!item.isEmpty()) {
						items.put("id", id);
						items.put("resType", resType);
						items.put("num", num);
						items.put("bid", item.get(0).getId());
					}
					rlt.put("items", items);

					// 判断是否有任务，及是否完成
					Map<String, Object> paramW = new HashMap<String, Object>();
					paramW.put("roleid", roleId);
					paramW.put("type", 4);
					List<RoleTaskTaskDetail> listW = this
							.getRoleTaskTaskService().findRoleTaskBytype0(
									paramW);
					for (int i = 0; i < listW.size(); i++) {
						if (listW.get(i).getTasklevel() == id) {
							Map<String, Object> paramI = new HashMap<String, Object>();
							paramI.put("roleid", roleId);
							paramI.put("taskid", listW.get(i).getTaskid());
							paramI.put("progress", 1);
							this.getRoleTaskTaskService()
									.updateRoleTaskProgress(paramI);
							// 判断是否有任务完成3
							this.getTaskHandler().taskcomplete(roleId);
						}
					}

					Map<String, Object> money = new HashMap<String, Object>();
					GameRoleDetail r = this.getGameRoleService().findRoleById(
							roleId);
					money.put("yin", r.getYin());
					money.put("coin", r.getCoin());
					rlt.put("money", money);
					rlt.put("coinspend", this.getGameRoleService()
							.findRoleById(roleId).getCoinspend());
					rlt.put("consume", coin);// 本次消费的金币数
					rlt.put("s", s);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
					ServerHandler.sendData(session, respMap);
					param = null;
					item = null;
					items = null;
				} else {
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);// 背包上限
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "");
					ServerHandler.sendData(session, respMap);
				}
				rlt = null;
			} else {
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "");
				ServerHandler.sendData(session, respMap);
			}
			// 更新token
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("openid", openid);
			param.put("status", 0);
			this.getDeliveryService().updateDelivery(param);
			param = null;
		}
	}

	/** 创建角色 ply.create */
	private void create() {
		// TODO  创建
		long bb = 0;
		try {
			int id = Integer.parseInt(playerId);
			Map<String, Object> rlt = new HashMap<String, Object>();
			rlt.put("lootTime", -2);
			GameRoleDetail model = new GameRoleDetail();
			JSONArray aryss = new JSONArray();
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("day", 0);
			aryss.add(m);
//			System.out.println("playerHandler中的id:" + id);
			List<MemberDetail> member = this.getMemberService().findMemberByid(id);
			GameRoleDetail tt = this.getGameRoleService().findRoleById(id);

			if (tt != null) {
				// System.out.println("没有创建，已经存在：" + tt.toString());
				return;
			}

			model.setServerId(member.get(0).getServerId());
			// model.setServerId("1");
			session.setAttribute("serverid", member.get(0).getServerId());
			/******/
			Map<String, Object> happyTurntableActivity = new HashMap<String, Object>();
			happyTurntableActivity.put("id",
					GameConstants.HAPPY_TURNTABLE_ACTIVITY_ID);// 转盘活动id
			List<ActivityDetail> happyNewturntableActivity = this
					.getActivityService().getActivityByParams(
							happyTurntableActivity);
			Calendar calendar = Calendar.getInstance();
			int month0 = calendar.get(Calendar.MONTH) + 1;
			int day0 = calendar.get(Calendar.DAY_OF_MONTH);
			int year = calendar.get(Calendar.YEAR);
			if (happyNewturntableActivity.isEmpty()) {
				// System.out.println("转盘活动为空");
				rlt.put("happyturntable", 0);
				// System.out.println("turntable 0   no activity");
			} else {
				int month = happyNewturntableActivity.get(0).getMonth();
				int day = happyNewturntableActivity.get(0).getDay();
				int monthend = happyNewturntableActivity.get(0)
						.getMonthend();
				int dayend = happyNewturntableActivity.get(0).getDayend();
				if (month != monthend) {
					if (month0 >= month && month0 <= monthend) {
						if (month0 == month) {
							if (day0 >= day) {
								rlt.put("happyturntable", 1);
								// System.out.println("turntable 1");
							}
						} else if (month0 == monthend) {
							if (day0 <= dayend) {
								rlt.put("happyturntable", 1);
								// System.out.println("turntable 1");
							}
						} else if (month0 != month && month0 != monthend) {
							rlt.put("happyturntable", 1);
							// System.out.println("turntable 1");
						}
					}
				}
				if (month == monthend) {
					if (day0 >= day && day0 <= dayend) {
						rlt.put("happyturntable", 1);
					}
				}
			}
			/****/
			Map<String, Object> turntableActivity = new HashMap<String, Object>();
			turntableActivity.put("id",GameConstants.TURNTABLE_ACTIVITY_ID);//转盘活动id
			List<ActivityDetail> newturntableActivity = this.getActivityService().getActivityByParams(turntableActivity);
			if(newturntableActivity.isEmpty()){
//				System.out.println("转盘活动为空");
				rlt.put("turntable", 0);
			}else{
				int month = newturntableActivity.get(0).getMonth();
				int day = newturntableActivity.get(0).getDay();
				int monthend = newturntableActivity.get(0).getMonthend();
				int dayend = newturntableActivity.get(0).getDayend();
				if(month!=monthend){
					if(month0>=month && month0<=monthend){
						if(month0==month){
							if(day0>=day){
								rlt.put("turntable", 1);
							}
						}else if(month0==monthend){
							if(day0<=dayend){
								rlt.put("turntable", 1);
							}
						}else if(month0!=month&&month0!=monthend){
							rlt.put("turntable", 1);
						}
					}
				}
				if(month == monthend){
					if(day0>=day&&day0<=dayend){
						rlt.put("turntable", 1);
					}
				}
			}
			/**四合一新服活动**/
			int serverid = Integer.valueOf(member.get(0).getServerId());
			if(GlobalDatat.newServerActivityDataMap.containsKey(serverid)){
				int month = GlobalDatat.newServerActivityDataMap.get(serverid).getMonth();
				int day = GlobalDatat.newServerActivityDataMap.get(serverid).getDay();
				int monthend = GlobalDatat.newServerActivityDataMap.get(serverid).getMonthend();
				int dayend = GlobalDatat.newServerActivityDataMap.get(serverid).getDayend();
				if(month!=monthend){
					if(month0>=month && month0<=monthend){
						if(month0==month){
							if(day0>=day){
								rlt.put("twenty", 1);
							}
						}else if(month0==monthend){
							if(day0<=dayend){
								rlt.put("twenty", 1);
							}
						}else if(month0!=month&&month0!=monthend){
							rlt.put("twenty", 1);
						}
					}
				}else if(month == monthend){
					if(day0>=day&&day0<=dayend){
						rlt.put("twenty", 1);
					}
				}else{
					rlt.put("twenty", 0);
				}
			}else{
				rlt.put("twenty", 0);
			}
			
			/*****招将有礼****/
			int statu = 0;
			if(GlobalDatat.newServerActivityDataMap.containsKey(serverid)){
				int month = GlobalDatat.newServerActivityDataMap.get(serverid).getMonth();
				int day = GlobalDatat.newServerActivityDataMap.get(serverid).getDay();
				String activityTime = year + "-" + month + "-" + day;
				long remainderDay = getDaysBetween(activityTime);
				if(remainderDay <= 7){
					statu = 1;
				}
			}
			/****************/
			model.setToday(aryss.toString());// 今天已登录
			model.setYesterday(aryss.toString());
			model.setHuangzuangift(0);
			model.setInvite(0);
			model.setVips(1);
			model.setId(id);
			model.setCoin(GameConstants.GAME_COIN);
			model.setYin(GameConstants.GAME_YIN);
			model.setGongxun(GameConstants.GAME_GONGXUN);
			model.setExp(0);
			model.setLevel(1);
			String name = String.valueOf(id);
			if(params.containsKey("name")){
				name = String.valueOf(params.get("name"));
			}
			model.setName(name);
			model.setMapid(1);
			model.setPlaceid(1);
			model.setMapid2(1);
			model.setPlaceid2(1);
			model.setFlag(1);
			model.setJunling(30);
			model.setCoinspend(0);
			model.setChallengenum(10);
			model.setGetcdk("[0,0,0,0,0]");
			model.setHelpstep("[1,1,1,1,1,1,1,1,1,1,1,1]");
			model.setJltime(new Date().getTime());// 增加军令时间，否则第一次下线后上来还是15
			long now = new Date().getTime();
			long temptime = now % (1000 * 60 * 60 * 24);
			long jian = temptime + 8 * 1000 * 60 * 60;
			long flagtime = now - jian;// 当天零点毫秒值
			model.setTasktime(flagtime);
			JSONArray ary = new JSONArray();
			String state = ary.toString();
			model.setState(state);
			model.setRefertime(now);
			JSONArray ary1 = new JSONArray();
			String stateseven = ary1.toString();
			model.setStateseven(stateseven);
			JSONArray ary2 = new JSONArray();
			String supsign = ary2.toString();
			model.setSupsign(supsign);
			JSONArray ary3 = new JSONArray();
			String daynumstate = ary3.toString();
			model.setDaynumstate(daynumstate);
			model.setOnlinetime(System.currentTimeMillis());
			model.setTotem("[]");
			boolean bo = this.getGameRoleService().insertRole(model);
			model.setVip(0);
			int needexp = this.getGameLevelService().getGameLevelByRoleLevel(1)
					.getNeedexp();
			model.setNeedexp(needexp);
			JSONArray roleMilitary = new JSONArray();
			// 插入招募令
			long bidg = this.getAutoIdService().fingKeyValueByTableName(
					"role_item");
			RoleItemDetail roleitem = new RoleItemDetail();
			roleitem.setId(bidg);
			roleitem.setRoleid(id);
			roleitem.setNum(1);
			roleitem.setItemid(3);
			roleitem.setType(1);
			roleitem.setFlag(1);
			this.getRoleItemService().insertRoleItem(roleitem);
			Map<String, Object> mapitems = new HashMap<String, Object>();
			mapitems.put("bid", bidg);
			mapitems.put("id", 3);
			mapitems.put("num", 1);
			roleMilitary.add(mapitems);
			long bidg2 = this.getAutoIdService().fingKeyValueByTableName(
					"role_item");
			RoleItemDetail roleitem2 = new RoleItemDetail();
			roleitem2.setId(bidg2);
			roleitem2.setRoleid(id);
			roleitem2.setNum(1);
			roleitem2.setItemid(9);
			roleitem2.setType(1);
			roleitem2.setFlag(1);
			this.getRoleItemService().insertRoleItem(roleitem2);
			mapitems.clear();
			mapitems.put("bid", bidg2);
			mapitems.put("id", 9);
			mapitems.put("num", 1);
			roleMilitary.add(mapitems);
			long bidk = this.getAutoIdService().fingKeyValueByTableName(
					"role_item");
			RoleItemDetail roleite = new RoleItemDetail();
			roleite.setId(bidk);
			roleite.setRoleid(id);
			roleite.setNum(1);
			roleite.setItemid(4);
			roleite.setType(1);
			roleite.setFlag(1);
			this.getRoleItemService().insertRoleItem(roleite);
			mapitems.clear();
			mapitems.put("bid", bidk);
			mapitems.put("id", 4);
			mapitems.put("num", 1);
			roleMilitary.add(mapitems);
			long bidm = this.getAutoIdService().fingKeyValueByTableName(
					"role_item");
			RoleItemDetail roleit = new RoleItemDetail();
			roleit.setId(bidm);
			roleit.setRoleid(id);
			roleit.setNum(1);
			roleit.setItemid(15);
			roleit.setType(5);
			roleit.setFlag(1);
			this.getRoleItemService().insertRoleItem(roleit);
			mapitems.clear();
			mapitems.put("bid", bidm);
			mapitems.put("id", 15);
			mapitems.put("num", 1);
			roleMilitary.add(mapitems);
			Map<String, Object> _allres = new HashMap<String, Object>();
			_allres.put("roleItem", roleMilitary);
			rlt.put("_allres", _allres);
			// roletask插入数据
			Map<String, Object> param = new HashMap<String, Object>();
			int mid = this.getAutoIdService().fingKeyValueByTableName(
					"role_task");
			param.put("roleId", id);
			param.put("id", mid);
			param.put("type", 1);
			param.put("tasktype", 2);
			param.put("dailynum", 0);// 领取了0次
			param.put("taskid", 1);
			param.put("taskoldid", 0);
			param.put("day", 1);// 第一天
			param.put("status", 0);// 不可以领取礼包
			param.put("states", 0);
			// 新注册账号给倒计时时间
			this.getRoleTaskService().insertRoleTask(param);
			// this.getAutoIdService()
			// .updateKeyValueAddOneByTableName("role_task");
			int gtime = this.getGameTaskService().getGameTaskDetailById(11)
					.get(0).getTasknum();
			long nowtime = new Date().getTime();
			this.getRoleTaskService().updateRoleTaskTime(id,
					(nowtime + gtime * 1000), 1);
			rlt.put("time", (gtime + 3));

			// 默认送一个武将
			int bid = this.getAutoIdService().fingKeyValueByTableName(
					"role_military");
			param.clear();
			param.put("id", bid);
			param.put("roleId", id);
			param.put("type", 1);
			param.put("level", 1);
			param.put("militaryid", 2001);
			param.put("name", "紫霞仙子");
			param.put("types", 1);
			param.put("exp", 0);
			param.put("wuqi", 0);
			param.put("huwan", 0);
			param.put("shipin", 0);
			param.put("touguan", 0);
			param.put("yifu", 0);
			param.put("xiezi", 0);
			param.put("bing", 1);
			this.getRoleMilitaryService().insertRoleMilitary(param);
			// this.getAutoIdService().updateKeyValueAddOneByTableName(
			// "role_military");

			int b = this.getAutoIdService().fingKeyValueByTableName(
					"role_challenge");
			param.clear();
			param.put("id", b);
			param.put("roleid", id);
			// param.put("militaryid", "["+bid+"]");
			param.put("militaryid", "[]");
			this.getRoleChallengeService().insertRoleChallenge(param);
			// this.getAutoIdService().updateKeyValueAddOneByTableName(
			// "role_challenge");

			List<RoleMilitaryDetail> military = this.getRoleMilitaryService()
					.getRoleMilitary(id);
			List<Map<String, Object>> roleM = new ArrayList<Map<String, Object>>();
			if (!military.isEmpty()) {
				for (int i = 0; i < military.size(); i++) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("id", military.get(i).getId());
					map.put("militaryid", military.get(i).getMilitaryid());
					map.put("name", military.get(i).getName());
					map.put("roleId", military.get(i).getRoleId());
					map.put("level", military.get(i).getLevel());
					map.put("exp", military.get(i).getExp());
					map.put("types", military.get(i).getTypes());
					map.put("type", military.get(i).getType());
					map.put("wuqi", military.get(i).getWuqi());
					map.put("huwan", military.get(i).getHuwan());
					map.put("yifu", military.get(i).getYifu());
					map.put("touguan", military.get(i).getTouguan());
					map.put("xiezi", military.get(i).getXiezi());
					map.put("shipin", military.get(i).getShipin());
					roleM.add(map);
					map = null;
				}
				rlt.put("roleMilitary", roleM);
			} else {
				rlt.put("roleMilitary", roleM);
			}

			// 每日任务信息
			inroledaytask(id);
			/** 向role_task_task插入数据 */
			// System.out.println("_______________________createHandelrj_____________createDaytask:id:"
			// + id);
			this.getTaskHandler().insertroletasktask(id);
			if (bo == true) {
				rlt.put("role", model);
				rlt.put("place", new ArrayList<Map<String, Object>>());
				// 标记从什么途径注册的
				rlt.put("t", this.getMemberService().findMemberByid(id).get(0)
						.getInvite());
				rlt.put("statu", statu);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				// System.out.println("crete success!!!!!!!!!!!!!!!!" +
				// rlt.toString());
				ServerHandler.sendData(session, respMap);
				rlt.clear();
				model = null;
				m.clear();
				ary.clear();
				ary1.clear();
				ary2.clear();
				ary3.clear();
				aryss.clear();
				member.clear();
				tt = null;
				turntableActivity.clear();
				newturntableActivity.clear();
				roleit = null;
				roleite = null;
				roleitem = null;
				roleitem2 = null;
				roleM.clear();
				roleMilitary = null;
				mapitems.clear();
				param.clear();
				military.clear();
				rlt = null;
				m = null;
				ary = null;
				ary1 = null;
				ary2 = null;
				ary3 = null;
				aryss = null;
				member = null;
				turntableActivity = null;
				newturntableActivity = null;
				roleM = null;
				mapitems = null;
				param = null;
				military = null;
			} else {
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "创建失败");
				ServerHandler.sendData(session, respMap);
			}

		} catch (Exception e) {
			GameConstants.log.warn("", e);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_ERROR_PROCESS_FAILURE);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
					GameConstants.GAME_API_ERROR_PROCESS_FAILURE_INFO);
		}
		// bb = System.currentTimeMillis();
		// System.out.println("create jieshu:" + Integer.parseInt(playerId) +
		// "||||||||||||||||||||||||||||||||||||||||||||||用时：");
	}

	// ..................................................................
	private void inroledaytask(int roleid) {
		// 插入数据roledaytask
		Map<String, Object> param = new HashMap<String, Object>();
		int did = this.getAutoIdService().fingKeyValueByTableName(
				"role_daytask");
		JSONArray ary11 = new JSONArray();
		String baoxiang = ary11.toString();
		ary11.add(0, 0);
		ary11.add(1, 0);
		ary11.add(2, 0);
		ary11.add(3, 0);
		ary11.add(4, 0);
		ary11.add(5, 0);
		ary11.add(6, 0);
		ary11.add(7, 0);
		String integralstatue = ary11.toString();
		JSONArray ary = new JSONArray();
		ary.add(0, 0);
		ary.add(1, 0);
		ary.add(2, 0);
		ary.add(3, 0);
		ary.add(4, 0);
		String box = ary.toString();
		param.put("id", did);
		param.put("roleid", roleid);
		param.put("lueduo", 0);
		param.put("qiangzheng", 0);
		param.put("xiulian", 0);
		param.put("zhaomu", 0);
		param.put("qianghua", 0);
		param.put("zhangdou", 0);
		param.put("day", 1);
		param.put("baoxiang", baoxiang);
		param.put("integralstatue", integralstatue);
		param.put("box", box);
		this.getRoleDaytaskService().insertRoleDaytask(param);
		// this.getAutoIdService().updateKeyValueAddOneByTableName("role_daytask");

	}

	/** 获取用户信息 ply.get */
	private void get() {
		long a = System.currentTimeMillis();
		long b = 0;
		// System.out.println("ply.get()用户ID：" + Integer.parseInt(playerId));
		try {
			long x = System.currentTimeMillis();
			long y = System.currentTimeMillis();
			// System.out.println("ply.get(1)"+(y-x));
			int id = Integer.parseInt(playerId);
			// System.out.println("PlayerHandler获取玩家_____________________________ID:" + id);
			GameRoleDetail role = this.getGameRoleService().findRoleById(id);
//			 System.out.println("PlayerHandler.get().roleHlepStep:" +
//			 role.getHelpstep());
			Map<String, Object> rlts = new HashMap<String, Object>();
			if (role != null) {
				/******/
				Map<String, Object> happyTurntableActivity = new HashMap<String, Object>();
				happyTurntableActivity.put("id",
						GameConstants.HAPPY_TURNTABLE_ACTIVITY_ID);// 转盘活动id
				List<ActivityDetail> happyNewturntableActivity = this
						.getActivityService().getActivityByParams(
								happyTurntableActivity);
				Calendar calendar = Calendar.getInstance();
				int month0 = calendar.get(Calendar.MONTH) + 1;
				int day0 = calendar.get(Calendar.DAY_OF_MONTH);
				int year = calendar.get(Calendar.YEAR);
				if (happyNewturntableActivity.isEmpty()) {
					// System.out.println("转盘活动为空");
					rlts.put("happyturntable", 0);
					// System.out.println("turntable 0   no activity");
				} else {
					int month = happyNewturntableActivity.get(0).getMonth();
					int day = happyNewturntableActivity.get(0).getDay();
					int monthend = happyNewturntableActivity.get(0)
							.getMonthend();
					int dayend = happyNewturntableActivity.get(0).getDayend();
					if (month != monthend) {
						if (month0 >= month && month0 <= monthend) {
							if (month0 == month) {
								if (day0 >= day) {
									rlts.put("happyturntable", 1);
									// System.out.println("turntable 1");
								}
							} else if (month0 == monthend) {
								if (day0 <= dayend) {
									rlts.put("happyturntable", 1);
									// System.out.println("turntable 1");
								}
							} else if (month0 != month && month0 != monthend) {
								rlts.put("happyturntable", 1);
								// System.out.println("turntable 1");
							}
						}
					}
					if (month == monthend) {
						if (day0 >= day && day0 <= dayend) {
							rlts.put("happyturntable", 1);
						}
					}
				}
				/****/
				Map<String, Object> turntableActivity = new HashMap<String, Object>();
				turntableActivity.put("id",GameConstants.TURNTABLE_ACTIVITY_ID);//转盘活动id
				List<ActivityDetail> newturntableActivity = this.getActivityService().getActivityByParams(turntableActivity);
				if(newturntableActivity.isEmpty()){
//					System.out.println("转盘活动为空");
					rlts.put("turntable", 0);
				}else{
					int month = newturntableActivity.get(0).getMonth();
					int day = newturntableActivity.get(0).getDay();
					int monthend = newturntableActivity.get(0).getMonthend();
					int dayend = newturntableActivity.get(0).getDayend();
					if(month!=monthend){
						if(month0>=month && month0<=monthend){
							if(month0==month){
								if(day0>=day){
									rlts.put("turntable", 1);
								}
							}else if(month0==monthend){
								if(day0<=dayend){
									rlts.put("turntable", 1);
								}
							}else if(month0!=month&&month0!=monthend){
								rlts.put("turntable", 1);
							}
						}
					}
					if(month == monthend){
						if(day0>=day&&day0<=dayend){
							rlts.put("turntable", 1);
						}
					}
				}
				/****/
				Map<String, Object> newServerActivity = new HashMap<String, Object>();
				newServerActivity.put("id", Integer.valueOf(role.getServerId()) + 1000);
				List<ActivityDetail> newServerActivityList = this.getActivityService()
						.getActivityByParams(newServerActivity);
//				System.out.println(newServerActivityList.get(0).getDescription());
				if (newServerActivityList.isEmpty()) {
//					System.out.println("新服活动为空2");
				}
				//TODO 更新
				int memberserverid = Integer.parseInt(String.valueOf(role.getServerId()));
				session.setAttribute("serverid", memberserverid);
				/*******四合一新服活动*******/
				int serverid = memberserverid;
				if(GlobalDatat.newServerActivityDataMap.containsKey(serverid)){
					int month = GlobalDatat.newServerActivityDataMap.get(serverid).getMonth();
					int day = GlobalDatat.newServerActivityDataMap.get(serverid).getDay();
					int monthend = GlobalDatat.newServerActivityDataMap.get(serverid).getMonthend();
					int dayend = GlobalDatat.newServerActivityDataMap.get(serverid).getDayend();
					if(month!=monthend){
						if(month0>=month && month0<=monthend){
							if(month0==month){
								if(day0>=day){
									rlts.put("twenty", 1);
								}
							}else if(month0==monthend){
								if(day0<=dayend){
									rlts.put("twenty", 1);
								}
							}else if(month0!=month&&month0!=monthend){
								rlts.put("twenty", 1);
							}
						}
					}else if(month == monthend){
						if(day0>=day&&day0<=dayend){
							rlts.put("twenty", 1);
						}
					}else{
						rlts.put("twenty", 0);
					}
				}else{
					rlts.put("twenty", 0);
				}
				/*****招将有礼******/
				int statu = 0;//显示招将有礼活动
				if(GlobalDatat.newServerActivityDataMap.containsKey(serverid)){
					int month = GlobalDatat.newServerActivityDataMap.get(serverid).getMonth();
					int day = GlobalDatat.newServerActivityDataMap.get(serverid).getDay();
					String activityTime = year + "-" + month + "-" + day;
					long remainderDay = getDaysBetween(activityTime);
					if(remainderDay <= 7){
						statu = 1;
					}
				}
				/**************/
				y = System.currentTimeMillis();
				// System.out.println("ply.get(2)"+(y-x));
				// 获取下山掠夺状态
				int huangzuan1 = 0;// 判断黄钻
				JsonSerializer json1 = new JsonSerializer();

				String Huangzuaninfo1 = role.getHuangzuaninfo();
				if ("null".equals(String.valueOf(Huangzuaninfo1))) {

				} else {
					List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json1
							.deserialize(Huangzuaninfo1);
					int ret = Integer.parseInt(String.valueOf(roleinfo.get(0)
							.get("ret")));
					if (ret == 0) {
						huangzuan1 = Integer.parseInt(String.valueOf(roleinfo
								.get(0).get("is_yellow_vip")));
					}
					roleinfo = null;
				}
				if (huangzuan1 == 1) {
					huangzuan1 = 2;// 黄钻用户享受双倍领取奖励时间
				} else {
					huangzuan1 = 1;
				}
				long time1 = role.getNowtime();
				String openmountain = role.getOpenmountain();
				JSONArray arymountain = JSONArray.fromObject(openmountain);
				long time2 = new Date().getTime();
				if (arymountain.getInt(1) == 0) {// 玩家没有选择下山掠夺

					rlts.put("lootTime", -2);
					// respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
					// rlts);
				}
				if (arymountain.getInt(1) == 1) {// 玩家选择8下山掠夺
					if (time1 == 0) {
						// rlt.put("lootTime", 8*60*60);
						rlts.put("lootTime", 8 * 60 * 60);
					} else if (time2 < time1) {// 等待状态
						long n = time1 - time2;
						long m;
						if (n % 1000 == 0) {
							m = n / 1000;
						} else {
							m = n / 1000 + 1;
						}
						rlts.put("lootTime", m);
						rlts.put("loot", 0);
					} else if (time2 - time1 < 2 * 60 * 60 * 1000 * huangzuan1
							&& time2 - time1 >= 0) {// 可以领取
						long n = time2 - time1;
						long k = 2 * 60 * 60 * 1000 * huangzuan1
								- (time2 - time1);
						long p;
						if (n % 1000 == 0) {
							p = k / 1000;
						} else {
							p = k / 1000 + 1;
						}
						rlts.put("lootTime", 0);
						rlts.put("loot", p);
					} else if (time2 - time1 > 2 * 60 * 60 * 1000 * huangzuan1) {// 超过领取时间状态
						rlts.put("lootTime", -1);
						rlts.put("loot", 0);
					}
				}
				if (arymountain.getInt(1) == 2) {// 玩家选择12下山掠夺
					if (time1 == 0) {
						rlts.put("lootTime", 12 * 60 * 60);
					} else if (time2 < time1) {// 等待状态
						long n = time1 - time2;
						long m;
						if (n % 1000 == 0) {
							m = n / 1000;
						} else {
							m = n / 1000 + 1;
						}
						rlts.put("lootTime", m);
						rlts.put("loot", 0);
					} else if (time2 - time1 < 3 * 60 * 60 * 1000 * huangzuan1
							&& time2 - time1 >= 0) {// 可以领取
						long n = time2 - time1;
						long k = 3 * 60 * 60 * 1000 * huangzuan1
								- (time2 - time1);
						long p;
						if (n % 1000 == 0) {
							p = k / 1000;
						} else {
							p = k / 1000 + 1;
						}
						rlts.put("lootTime", 0);
						rlts.put("loot", p);
						// System.out.println("ply.get获取下山掠夺状态：：可以领取：：：：");
					} else if (time2 - time1 > 3 * 60 * 60 * 1000 * huangzuan1) {// 超过领取时间状态
						// 超过领取时间状态
						rlts.put("lootTime", -1);
						rlts.put("loot", 0);
						// System.out.println("ply.get获取下山掠夺状态：：过期：：：：");

					}
				}
				if (arymountain.getInt(1) == 3) {// 玩家选择24下山掠夺
					if (time1 == 0) {
						rlts.put("lootTime", 24 * 60 * 60);
					} else if (time2 < time1) {// 等待状态
						long n = time1 - time2;
						long m;
						if (n % 1000 == 0) {
							m = n / 1000;
						} else {
							m = n / 1000 + 1;
						}
						rlts.put("lootTime", m);
						rlts.put("loot", 0);
					} else if (time2 - time1 < 6 * 60 * 60 * 1000 * huangzuan1
							&& time2 - time1 >= 0) {// 可以领取
						long n = time2 - time1;
						long k = 6 * 60 * 60 * 1000 * huangzuan1
								- (time2 - time1);
						long p;
						if (n % 1000 == 0) {
							p = k / 1000;
						} else {
							p = k / 1000 + 1;
						}
						rlts.put("lootTime", 0);
						rlts.put("loot", p);
					} else if (time2 - time1 > 6 * 60 * 60 * 1000 * huangzuan1) {// 超过领取时间状态
						// 超过领取时间状态
						rlts.put("lootTime", -1);
						rlts.put("loot", 0);

					}
				}
				y = System.currentTimeMillis();
				int num = role.getJunling();// 获得军令数
				int vip = role.getVip();
				// 黄钻享受vip2待遇
				Map<String, Object> param = new HashMap<String, Object>();
				if (vip < 2) {
					int huangzuan = 0;
					JsonSerializer json = new JsonSerializer();
					String Huangzuaninfo = role.getHuangzuaninfo();
					if ("null".equals(String.valueOf(Huangzuaninfo))) {

					} else {
						List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
								.deserialize(Huangzuaninfo);
						int ret = Integer.parseInt(String.valueOf(roleinfo.get(
								0).get("ret")));
						if (ret == 0) {
							huangzuan = Integer.parseInt(String
									.valueOf(roleinfo.get(0).get(
											"is_yellow_vip")));
						}
					}
					if (huangzuan == 1) {
						param.put("id", id);
						param.put("vip", 2);
						this.getGameRoleService().updateRoleVip(param);
						vip = 2;
						role.setVip(vip);
						// role = this.getGameRoleService().findRoleById(id);
					}
				}
				List<GameVipDetail> gv = this.getGameVipService()
						.getGameVipByLe(vip);
				// 诛仙令
				y = System.currentTimeMillis();
				// System.out.println("ply.get(4)"+(y-x));
				if (role.getZhuxianling() < gv.get(0).getZhuxianTop()) {// 诛仙令小于最大数
					long hour = (System.currentTimeMillis() - role.getZxtime()) / 1000 / 60 / 60;
					long h = gv.get(0).getHour();
					if (hour >= h) {
						int zx = (int) (hour / h);
						if ((zx + role.getZhuxianling()) >= gv.get(0)
								.getZhuxianTop()) {
							param.clear();
							param.put("id", id);
							param.put("zhuxianling", gv.get(0).getZhuxianTop());
							this.getGameRoleService().updateRoleVip(param);
						} else {
							if (zx > 0) {
								long t = System.currentTimeMillis()
										- (hour - h * zx) * 1000 * 60 * 60;
								param.clear();
								param.put("id", id);
								param.put("zxtime", t);
								param.put("zhuxianling", role.getZhuxianling()
										+ zx);
								this.getGameRoleService().updateRoleVip(param);
							}
						}
					}
				}

				int maxjl = gv.get(0).getJunlingTop();// 最大军令数
				y = System.currentTimeMillis();
				// System.out.println("ply.get(5)"+(y-x));
				if (num <= maxjl) {// 军令小于15
					long time = role.getJltime();
					long nowtime = new Date().getTime();
					long h = (nowtime - time);
					int hour = (int) (h / 1000 / 60 / 60);// 军令累计了多少小时
					if (hour >= 1) {// 过了一小时
						if ((hour + num) > maxjl) {// 大于15
							this.getGameRoleService().addRolejunling(id, maxjl);
							role.setJunling(maxjl);
							this.getGameRoleService().addRolejunlingtime(id,
									nowtime);
							role.setJltime(nowtime);
						} else {// 累计时间加上num不大于15
							this.getGameRoleService().addRolejunling(id,
									(num + hour));
							role.setJunling(num + hour);
							if (h == 0) {
								this.getGameRoleService().addRolejunlingtime(
										id, nowtime);
								role.setJltime(nowtime);
							} else {
								this.getGameRoleService().addRolejunlingtime(
										id, (time + hour * 60 * 60 * 1000));
								role.setJltime(time + hour * 60 * 60 * 1000);
							}
						}
					} else {// 累计时间不到一小时

					}
				} else {// 军令大于15

				}
				y = System.currentTimeMillis();
				// System.out.println("ply.get(6)"+(y-x));
				// 获得挑战令
				int cha = role.getChallengenum();// 获得挑战令
				int maxch = gv.get(0).getChallengTop();// 最大挑战令
				if (cha <= maxch) {// 小于15
					long time = role.getChallengetime();
					long nowtime = new Date().getTime();
					long h = (nowtime - time);
					int hour = (int) (h / 1000 / 60 / 60);// 军令累计了多少小时
					if (hour >= 1) {// 过了一小时
						// Map<String, Object> param = new HashMap<String,
						// Object>();
						if ((hour + cha) > maxch) {// 大于15
							param.clear();
							param.put("id", id);
							param.put("challengenum", maxch);
							this.getGameRoleService().updateRoleVip(param);
							role.setChallengenum(maxch);
						} else {// 累计时间加上num不大于15
							param.clear();
							param.put("id", id);
							param.put("challengenum", (cha + hour));
							role.setChallengenum(cha + hour);
							if (h == 0) {
								param.put("challengetime", nowtime);
								role.setChallengetime(nowtime);
							} else {
								param.put("challengetime",
										(time + hour * 60 * 60 * 1000));
								role.setChallengetime(time + hour * 60 * 60
										* 1000);
							}
							this.getGameRoleService().updateRoleVip(param);
						}
					} else {// 累计时间不到一小时
					}
				} else {// 军令大于15
				}
				y = System.currentTimeMillis();
				// System.out.println("ply.get(7)"+(y-x));
				// 获得应该的军令数
				// GameRoleDetail gamerole =
				// this.getGameRoleService().findRoleById(id);
				// 将signjl=0
				int signjl = role.getSignjl();
				if (signjl != 0) {
					// Map<String, Object> param = new HashMap<String,
					// Object>();
					param.clear();
					param.put("id", id);
					param.put("signjl", 0);
					this.getGameRoleService().updateRoleVip(param);
				}
				Map<String, Object> roles = new HashMap<String, Object>();
				roles.put("name", role.getName());
				roles.put("coin", role.getCoin());
				roles.put("exp", role.getExp());
				roles.put("gongxun", role.getGongxun());
				roles.put("id", role.getId());
				roles.put("level", role.getLevel());

				int needexp = 0;
				if (role.getLevel() > this.getGameLevelService()
						.allGameLevelDetail().size()) {
					needexp = this.getGameLevelService()
							.getGameLevelByRoleLevel(
									this.getGameLevelService()
											.allGameLevelDetail().size())
							.getNeedexp();
				} else {
					needexp = this.getGameLevelService()
							.getGameLevelByRoleLevel(role.getLevel())
							.getNeedexp();
				}
				roles.put("needexp", needexp);
				roles.put("yin", role.getYin());
				roles.put("placeid", role.getPlaceid());
				roles.put("mapid", role.getMapid());
				roles.put("vip", role.getVip());
				roles.put("state", role.getState());
				roles.put("tasktime", role.getTasktime());
				roles.put("refertime", role.getRefertime());
				roles.put("stateseven", role.getStateseven());
				roles.put("supsign", role.getSupsign());
				roles.put("daynumstate", role.getDaynumstate());
				roles.put("junling", role.getJunling());// 传参军令数
				roles.put("coinspend", role.getCoinspend());
				roles.put("challengenum", role.getChallengenum());
				JSONArray byle = JSONArray.fromObject(role.getBylevel());
				roles.put("bylevel", byle);
				byle = null;
				// rlts.put("role", roles);
				int mapid = role.getMapid();
				// roles = null;
				y = System.currentTimeMillis();
				// System.out.println("ply.get(8)"+(y-x));
				// 战斗结束领取道具
				Map<String, Object> pas = new HashMap<String, Object>();
				pas.put("id", id);
				pas.put("mapid2", role.getMapid());
				pas.put("placeid2", role.getPlaceid());
				this.getGameRoleService().updateRoleVip(pas);

				// 好友上线
				this.getGameRoleService().updateRoleline(id, 1);

				// 过了零点每日领取礼包数为零
				List<RoleTaskDetail> roletask = this.getRoleTaskService()
						.findRoleTask(id);
				// long tt =
				// this.getGameRoleService().findRoleById(id).getTasktime();
				long tt = role.getTasktime();
				long nowtime = new Date().getTime();
				int day = (int) ((nowtime - tt) / 1000 / 60 / 60 / 24 + 1);
//				System.out.println("PlayerHandler 7444行 day = "+day);
				// 在线礼包是否领取10次
				y = System.currentTimeMillis();
				// System.out.println("ply.get(9)"+(y-x));
				// Map<String, Object> param = new HashMap<String, Object>();
				// System.out.println("roletask.isEmpty():" +
				// roletask.isEmpty());
				if (!roletask.isEmpty()) {// 存在roleid
					// int roleday = roletask.get(0).getDay();//
					int roleday = role.getDay();
					if (day > roleday) {// 新的一天，dailynum应设为0，day增加1，今天还没有领取礼包
						if (day > roletask.get(0).getDay()) {
							param.clear();
							param.put("roleId", id);
							param.put("dailynum", 0);
							param.put("day", day);
							param.put("status", 1);
							this.getRoleTaskService().updateRoleTasknumday(
									param);
						}

						// 直接开始倒计时。。。。。
						// 恢复妖牌为0
						param.clear();
						param.put("id", id);
						param.put("day", day);
						param.put("num", 0);
						this.getGameRoleService().updateRoleVip(param);
						// 标记今天上线，将今天的放到昨天
						String today = this.getGameRoleService().findRoleById(
								id).getToday();
						JSONArray ary = new JSONArray();
						Map<String, Object> pp = new HashMap<String, Object>();
						pp.put("day", day);
						ary.add(pp);
						param.clear();
						param.put("id", id);
						param.put("yesterday", today);
						param.put("today", ary.toString());
						param.put("live", 0);// 好友活跃度奖励
						param.put("huangzuangift", 0);// 黄钻礼包
						param.put("jingji", 10);
						param.put("jjnum", 0);
						// param.put("jjstatus", 1);
						this.getGameRoleService().updateRoleVip(param);
						pp = null;
						updateActivity(id);// 更新每日活动
					}
					if (day > 3) {// 已过三，每日在线
						// 更改type=1，tasktype=1
						if (roletask.get(0).getType() == 1
								&& roletask.get(0).getTasktype() != 1) {
							param.clear();
							param.put("roleId", id);
							param.put("type", 1);
							param.put("tasktype", 1);
							this.getRoleTaskService().updateRoleTaskStatus(
									param);
						}
					} else {// 三日在线
						if (roletask.get(0).getType() == 1
								&& roletask.get(0).getTasktype() != 2) {
							param.clear();
							param.put("roleId", id);
							param.put("type", 1);
							param.put("tasktype", 2);
							this.getRoleTaskService().updateRoleTaskStatus(
									param);
						}
					}
					// 判断是否倒计时为0
					RoleTaskDetail list = this.getRoleTaskService()
							.findRoleTask(id).get(0);
					long time = list.getTime();
					int status = list.getStatus();
					int dailynum = this.getRoleTaskService().findRoleTask(id)
							.get(0).getDailynum();
					// 判断是否是三日在线,客户端判断

					if (dailynum < 10) {// 礼包没有领完

						// 判断是否是三日在线
						if (day > 3) {// 已过三，每日在线
							// 更改type=1，tasktype=1
							RoleTaskDetail ro = this.getRoleTaskService()
									.findRoleTask(id).get(0);
							if (ro.getType() == 1 && ro.getTasktype() != 1) {
								param.clear();
								param.put("roleId", id);
								param.put("type", 1);
								param.put("tasktype", 1);
								this.getRoleTaskService().updateRoleTaskStatus(
										param);
							}
							// 判断礼包领取是否在倒计时
							if (time < nowtime) {// 开始倒计时
								if (status == 1) {// 礼包不可以领取，倒计时开始
									param.clear();
									param.put("roleId", id);
									param.put("status", 0);
									boolean bo = this.getRoleTaskService()
											.updateRoleTaskStatus(param);
									if (bo == true) {
										int gtime = this.getGameTaskService()
												.getGameTaskDetailById(
														dailynum + 1).get(0)
												.getTasknum();// 所需时间
										this
												.getRoleTaskService()
												.updateRoleTaskTime(
														id,
														(nowtime + gtime * 1000),
														(dailynum + 1));
										rlts.put("time", gtime + 3);
										rlts.put("day", day);
									} else {
									}

								} else {// 还没有领取礼包，可以领礼包
									rlts.put("time", 0);
									rlts.put("day", day);
								}
							} else {// 倒计时中
								param.clear();
								param.put("roleId", id);
								param.put("status", 0);
								boolean bo = this.getRoleTaskService()
										.updateRoleTaskStatus(param);
								if ((time - nowtime) < 0) {
									// rlts.put("time",
									// (time - nowtime) / 1000+3);
									rlts.put("time", 0);
									rlts.put("day", day);
								} else {
									rlts.put("time",
											(time - nowtime) / 1000 + 3);
									rlts.put("day", day);
								}
							}
						} else if (0 < day && day <= 3) {// 三日在线
							// 更改type=1，tasktype=2
							RoleTaskDetail ro = this.getRoleTaskService()
									.findRoleTask(id).get(0);
							if (ro.getType() == 1 && ro.getTasktype() != 2) {
								param.clear();
								param.put("roleId", id);
								param.put("type", 1);
								param.put("tasktype", 2);
								this.getRoleTaskService().updateRoleTaskStatus(
										param);
							}
							status = this.getRoleTaskService().findRoleTask(id)
									.get(0).getStatus();
							// 判断礼包领取是否在倒计时
							if (time < nowtime) {// 开始倒计时
								if (status == 1) {// 礼包不可以领取，倒计时开始
									param.clear();

									param.put("roleId", id);
									param.put("status", 0);
									boolean bo = this.getRoleTaskService()
											.updateRoleTaskStatus(param);
									if (bo == true) {
										int gtime = this.getGameTaskService()
												.getGameTaskDetailById(
														dailynum + 11).get(0)
												.getTasknum();// 所需时间
										this
												.getRoleTaskService()
												.updateRoleTaskTime(
														id,
														(nowtime + gtime * 1000),
														(dailynum + 11));
										rlts.put("time", gtime + 3);
										rlts.put("day", day);
									} else {
									}

								} else {// 还没有领取礼包，可以领礼包
									rlts.put("time", 0);
									rlts.put("day", day);
								}
							} else {// 倒计时中
								param.clear();
								param.put("roleId", id);
								param.put("status", 0);
								boolean bo = this.getRoleTaskService()
										.updateRoleTaskStatus(param);
								if ((time - nowtime) < 0) {
									// rlts.put("time",
									// (time - nowtime) / 1000+3);
									rlts.put("time", 0);
									rlts.put("day", day);
								} else {
									rlts.put("time",
											(time - nowtime) / 1000 + 3);
									rlts.put("day", day);
								}

							}
						} else {// 其他

						}
					} else {// 礼包领完了
						rlts.put("day", day);
						rlts.put("time", -1);
					}
				} else {// 不存在roleid...................可以删除
					// 判断是否是三日在线
					if (day > 3) {// 已过三，每日在线
						param.clear();
						int mid = this.getAutoIdService()
								.fingKeyValueByTableName("role_task");
						param.put("roleId", id);
						param.put("id", mid);
						param.put("type", 1);
						param.put("tasktype", 1);
						param.put("dailynum", 0);// 领取了0次
						param.put("taskid", 1);
						param.put("taskoldid", 0);
						param.put("day", day);// 第一天
						param.put("status", 0);
						this.getRoleTaskService().insertRoleTask(param);
						// this.getAutoIdService()
						// .updateKeyValueAddOneByTableName("role_task");
						roletask = this.getRoleTaskService().findRoleTask(id);
						int dailynum = roletask.get(0).getDailynum();
						int gtime = this.getGameTaskService()
								.getGameTaskDetailById(dailynum + 1).get(0)
								.getTasknum();// 所需时间
						this.getRoleTaskService().updateRoleTaskTime(id,
								(nowtime + gtime * 1000), (dailynum + 1));
						rlts.put("time", (gtime + 3));
						rlts.put("day", day);
					} else if (0 < day && day <= 3) {// 三日在线
						param.clear();
						int mid = this.getAutoIdService()
								.fingKeyValueByTableName("role_task");
						param.put("roleId", id);
						param.put("id", mid);
						param.put("type", 1);
						param.put("tasktype", 2);
						param.put("dailynum", 0);// 领取了0次
						param.put("taskid", 11);
						param.put("taskoldid", 0);
						param.put("day", day);// 第一天
						param.put("status", 0);
						boolean bo = this.getRoleTaskService().insertRoleTask(
								param);
						// this.getAutoIdService()
						// .updateKeyValueAddOneByTableName("role_task");
						roletask = this.getRoleTaskService().findRoleTask(id);
						int dailynum = roletask.get(0).getDailynum();
						int gtime = this.getGameTaskService()
								.getGameTaskDetailById(dailynum + 11).get(0)
								.getTasknum();// 所需时间....11
						this.getRoleTaskService().updateRoleTaskTime(id,
								(nowtime + gtime * 1000), (dailynum + 11));
						rlts.put("time", (gtime + 3));
						rlts.put("day", day);
					} else {// 其他
					}
				}
				y = System.currentTimeMillis();
				// System.out.println("ply.get(10)"+(y-x));
				// 更新登录时间值
				param.clear();
				param.put("id", id);
				param.put("onlinetime", System.currentTimeMillis());
				this.getGameRoleService().updateRoleVip(param);
				// 更新新手引导
				// /////////////////////////////////////////int
				// helpstep=role.getHelpstep();
				String helpstep = role.getHelpstep();
				JSONArray ary = JSONArray.fromObject(helpstep);
				if (ary.getInt(0) == 7 || ary.getInt(0) == 8
						|| ary.getInt(0) == 9) {
					// System.out.println("PlayerHandler.ary:" +
					// ary.toString());
					ary.set(0, 6);
					// System.out.println("PlayerHandler.ary:" +
					// ary.toString());
					Map<String, Object> pa = new HashMap<String, Object>();
					pa.put("id", id);
					pa.put("helpstep", ary.toString());
					this.getGameRoleService().updateRolehelpstep(pa);
				}
				if (ary.getInt(1) == 7 || ary.getInt(1) == 8
						|| ary.getInt(1) == 6) {
					// System.out.println("PlayerHandler.ary:" +
					// ary.toString());
					ary.set(1, 5);
					// System.out.println("PlayerHandler.ary:" +
					// ary.toString());
					Map<String, Object> pa = new HashMap<String, Object>();
					pa.put("id", id);
					pa.put("helpstep", ary.toString());
					this.getGameRoleService().updateRolehelpstep(pa);
				}
				if (role.getMapid() == 1 && role.getPlaceid() > 2) {
					// System.out.println("PlayerHandler.ary:" +
					// ary.toString());
					ary.set(1, 0);
					ary.set(3, 0);
					// System.out.println("PlayerHandler.ary:" +
					// ary.toString());
					Map<String, Object> pa = new HashMap<String, Object>();
					pa.put("id", id);
					pa.put("helpstep", ary.toString());
					this.getGameRoleService().updateRolehelpstep(pa);
				}
				if (ary.getInt(4) != 0 || ary.getInt(5) != 0
						|| ary.getInt(10) != 0) {
					// System.out.println("PlayerHandler.ary:" +
					// ary.toString());
					ary.set(4, 1);
					ary.set(5, 1);
					ary.set(10, 1);
					// System.out.println("PlayerHandler.ary:" +
					// ary.toString());
					Map<String, Object> pa = new HashMap<String, Object>();
					pa.put("id", id);
					pa.put("helpstep", ary.toString());
					this.getGameRoleService().updateRolehelpstep(pa);
				}
				if (role.getMapid() > 1) {
					// System.out.println("PlayerHandler.ary:" +
					// ary.toString());
					ary.set(0, 0);
					ary.set(1, 0);
					ary.set(2, 0);
					ary.set(3, 0);
					ary.set(6, 0);
					ary.set(7, 0);
					ary.set(8, 0);
					ary.set(9, 0);
					// System.out.println("PlayerHandler.ary:" +
					// ary.toString());
					Map<String, Object> pa = new HashMap<String, Object>();
					pa.put("id", id);
					pa.put("helpstep", ary.toString());
					this.getGameRoleService().updateRolehelpstep(pa);
				}
				if (role.getMapid() > 2 || (role.getMapid() > 1 &&role.getPlaceid() > 11)) {
					// System.out.println("PlayerHandler.ary:" +
					// ary.toString());
					ary.set(0, 0);
					ary.set(1, 0);
					ary.set(2, 0);
					ary.set(3, 0);
					ary.set(4, 0);
					ary.set(5, 0);
					ary.set(6, 0);
					ary.set(7, 0);
					ary.set(8, 0);
					ary.set(9, 0);
					ary.set(10, 0);
					ary.set(11, 0);
					// System.out.println("PlayerHandler.ary:" +
					// ary.toString());
					Map<String, Object> pa = new HashMap<String, Object>();
					pa.put("id", id);
					pa.put("helpstep", ary.toString());
					this.getGameRoleService().updateRolehelpstep(pa);
				}
				if (ary.getInt(11) > 1) {
					// System.out.println("PlayerHandler.ary:" +
					// ary.toString());
					ary.set(0, 0);
					ary.set(1, 0);
					ary.set(2, 0);
					ary.set(3, 0);
					ary.set(4, 0);
					ary.set(5, 0);
					ary.set(6, 0);
					ary.set(7, 0);
					ary.set(8, 0);
					ary.set(9, 0);
					ary.set(10, 0);
					ary.set(11, 0);
					// System.out.println("PlayerHandler.ary:" +
					// ary.toString());
					Map<String, Object> pa = new HashMap<String, Object>();
					pa.put("id", id);
					pa.put("helpstep", ary.toString());
					this.getGameRoleService().updateRolehelpstep(pa);
				}
				if (ary.getInt(4) == 0 && ary.getInt(5) == 0
						&& ary.getInt(10) == 0) {
					// System.out.println("PlayerHandler.ary:" +
					// ary.toString());
					ary.set(0, 0);
					ary.set(1, 0);
					ary.set(2, 0);
					ary.set(3, 0);
					ary.set(4, 0);
					ary.set(5, 0);
					ary.set(6, 0);
					ary.set(7, 0);
					ary.set(8, 0);
					ary.set(9, 0);
					ary.set(10, 0);
					ary.set(11, 0);
					// System.out.println("PlayerHandler.ary:" +
					// ary.toString());
					Map<String, Object> pa = new HashMap<String, Object>();
					pa.put("id", id);
					pa.put("helpstep", ary.toString());
					this.getGameRoleService().updateRolehelpstep(pa);
				}
				// if(helpstep!=0){
				// if(helpstep==5){
				// helpstep=4;
				// Map<String, Object> pa = new HashMap<String, Object>();
				// pa.put("id", id);
				// pa.put("helpstep", 4);
				// this.getGameRoleService().updateRolehelpstep(pa);
				// }else if(helpstep==7){
				// helpstep=6;
				// Map<String, Object> pa = new HashMap<String, Object>();
				// pa.put("id", id);
				// pa.put("helpstep", 6);
				// this.getGameRoleService().updateRolehelpstep(pa);
				// }else if(helpstep>=9 && helpstep<12){
				// helpstep=8;
				// Map<String, Object> pa = new HashMap<String, Object>();
				// pa.put("id", id);
				// pa.put("helpstep", 8);
				// this.getGameRoleService().updateRolehelpstep(pa);
				// }else if(helpstep==15){
				// helpstep=14;
				// Map<String, Object> pa = new HashMap<String, Object>();
				// pa.put("id", id);
				// pa.put("helpstep", 14);
				// this.getGameRoleService().updateRolehelpstep(pa);
				// }else if(helpstep==16){
				// helpstep=17;
				// Map<String, Object> pa = new HashMap<String, Object>();
				// pa.put("id", id);
				// pa.put("helpstep", 17);
				// this.getGameRoleService().updateRolehelpstep(pa);
				//						
				// }else if(helpstep>=18 && helpstep<=21){
				// helpstep=17;
				// Map<String, Object> pa = new HashMap<String, Object>();
				// pa.put("id", id);
				// pa.put("helpstep", 17);
				// this.getGameRoleService().updateRolehelpstep(pa);
				// }else if(helpstep>=22 && helpstep<=24){
				// Map<String, Object> pa = new HashMap<String, Object>();
				// pa.put("roleid", id);
				// pa.put("itemid", 4);
				// pa.put("num", 1);
				// this.getRoleItemService().subRoleItem(pa);
				//
				// // 默认送一个武将
				// int bid = this.getAutoIdService().fingKeyValueByTableName(
				// "role_military");
				// pa.clear();
				// pa.put("id", bid);
				// pa.put("roleId", id);
				// pa.put("type",2);
				// pa.put("level", 1);
				// pa.put("militaryid", 3012);
				// pa.put("name", "千年虎前锋");
				// pa.put("types", 1);
				// pa.put("exp", 0);
				// pa.put("wuqi", 0);
				// pa.put("huwan", 0);
				// pa.put("shipin", 0);
				// pa.put("touguan", 0);
				// pa.put("yifu", 0);
				// pa.put("xiezi", 0);
				// this.getRoleMilitaryService().insertRoleMilitary(pa);
				// // this.getAutoIdService().updateKeyValueAddOneByTableName(
				// // "role_military");
				// helpstep=26;
				// pa.clear();
				// pa.put("id", id);
				// pa.put("helpstep", 26);
				// this.getGameRoleService().updateRolehelpstep(pa);
				//						
				// }else if(helpstep==25){
				// Map<String, Object> pa = new HashMap<String, Object>();
				// helpstep=26;
				// pa.clear();
				// pa.put("id", id);
				// pa.put("helpstep", 26);
				// this.getGameRoleService().updateRolehelpstep(pa);
				// }
				// else if(helpstep==27){
				// helpstep=26;
				// Map<String, Object> pa = new HashMap<String, Object>();
				// pa.put("id", id);
				// pa.put("helpstep", 26);
				// this.getGameRoleService().updateRolehelpstep(pa);
				// }else if(helpstep==29){
				// helpstep=28;
				// Map<String, Object> pa = new HashMap<String, Object>();
				// pa.put("id", id);
				// pa.put("helpstep", 28);
				// this.getGameRoleService().updateRolehelpstep(pa);
				// }else if(helpstep>=31 && helpstep<=34){
				// helpstep=30;
				// Map<String, Object> pa = new HashMap<String, Object>();
				// pa.put("id", id);
				// pa.put("helpstep", 30);
				// this.getGameRoleService().updateRolehelpstep(pa);
				// }else if(helpstep>=36 && helpstep<=37){
				// helpstep=35;
				// Map<String, Object> pa = new HashMap<String, Object>();
				// pa.put("id", id);
				// pa.put("helpstep", 35);
				// this.getGameRoleService().updateRolehelpstep(pa);
				// }else if(helpstep>=38 && helpstep<=39){
				// helpstep=40;
				// Map<String, Object> pa = new HashMap<String, Object>();
				// pa.put("id", id);
				// pa.put("helpstep", 40);
				// this.getGameRoleService().updateRolehelpstep(pa);
				// }else if(helpstep>=41 && helpstep<=43){
				// helpstep=44;
				// Map<String, Object> pa = new HashMap<String, Object>();
				// pa.put("id", id);
				// pa.put("helpstep", 44);
				// this.getGameRoleService().updateRolehelpstep(pa);
				// }else if(helpstep>=45 && helpstep<=48){
				// int days=this.getGameRoleService().findRoleById(id).getDay();
				// if(days<=7){
				// if(helpstep==47){
				// helpstep=46;
				// Map<String, Object> pa = new HashMap<String, Object>();
				// pa.put("id", id);
				// pa.put("helpstep", 46);
				// this.getGameRoleService().updateRolehelpstep(pa);
				// }else if(helpstep==48){
				// helpstep=49;
				// Map<String, Object> pa = new HashMap<String, Object>();
				// pa.put("id", id);
				// pa.put("helpstep", 49);
				// this.getGameRoleService().updateRolehelpstep(pa);
				// }
				// }else{
				// helpstep=49;
				// Map<String, Object> pa = new HashMap<String, Object>();
				// pa.put("id", id);
				// pa.put("helpstep", 49);
				// this.getGameRoleService().updateRolehelpstep(pa);
				// }
				// }else if(helpstep==50){
				// helpstep=49;
				// Map<String, Object> pa = new HashMap<String, Object>();
				// pa.put("id", id);
				// pa.put("helpstep", 49);
				// this.getGameRoleService().updateRolehelpstep(pa);
				// }else if(helpstep==51){
				// helpstep=49;
				// Map<String, Object> pa = new HashMap<String, Object>();
				// pa.put("id", id);
				// pa.put("helpstep", 49);
				// this.getGameRoleService().updateRolehelpstep(pa);
				// }else if(helpstep==54){
				// //helpstep=53;
				// System.out.println("：：helpstep=54改成55");
				// helpstep=55;
				// Map<String, Object> pa = new HashMap<String, Object>();
				// pa.put("id", id);
				// //pa.put("helpstep", 53);
				// pa.put("helpstep", 55);
				// this.getGameRoleService().updateRolehelpstep(pa);
				// }else if(helpstep>=57 && helpstep<=59){
				// helpstep=56;
				// Map<String, Object> pa = new HashMap<String, Object>();
				// pa.put("id", id);
				// pa.put("helpstep", 56);
				// this.getGameRoleService().updateRolehelpstep(pa);
				// }else if(helpstep>=60 && helpstep<=61){
				// helpstep=62;
				// Map<String, Object> pa = new HashMap<String, Object>();
				// pa.put("id", id);
				// pa.put("helpstep", 62);
				// this.getGameRoleService().updateRolehelpstep(pa);
				// }else if(helpstep>=64 && helpstep<=66){
				// helpstep=63;
				// Map<String, Object> pa = new HashMap<String, Object>();
				// pa.put("id", id);
				// pa.put("helpstep", 63);
				// this.getGameRoleService().updateRolehelpstep(pa);
				// }else if(helpstep==67){
				// helpstep=68;
				// Map<String, Object> pa = new HashMap<String, Object>();
				// pa.put("id", id);
				// pa.put("helpstep", 68);
				// this.getGameRoleService().updateRolehelpstep(pa);
				// }else if(helpstep==68){
				// helpstep=69;
				// Map<String, Object> pa = new HashMap<String, Object>();
				// pa.put("id", id);
				// pa.put("helpstep", 69);
				// this.getGameRoleService().updateRolehelpstep(pa);
				// }else if(helpstep>=71 && helpstep<=72){
				// helpstep=70;
				// Map<String, Object> pa = new HashMap<String, Object>();
				// pa.put("id", id);
				// pa.put("helpstep", 70);
				// this.getGameRoleService().updateRolehelpstep(pa);
				// }else if(helpstep>=73 && helpstep<86){
				// helpstep=76;
				// Map<String, Object> pa = new HashMap<String, Object>();
				// pa.put("id", id);
				// pa.put("helpstep", 76);
				// this.getGameRoleService().updateRolehelpstep(pa);
				// }else if(helpstep>=86){
				// helpstep=0;
				// Map<String, Object> pa = new HashMap<String, Object>();
				// pa.put("id", id);
				// pa.put("helpstep", 0);
				// this.getGameRoleService().updateRolehelpstep(pa);
				// }
				// }
				JSONArray hs = JSONArray.fromObject(helpstep);
				// System.out.println("PlayerHanlder.get().return helpstep:" +
				// ary);
				roles.put("helpstep", ary);
				y = System.currentTimeMillis();
				// System.out.println("ply.get(11)"+(y-x));
				/****/
				JsonSerializer json = new JsonSerializer();
				String totem = role.getTotem();
				List li = (List) json.deserialize(totem);
				roles.put("totem", li);
				roles.put("fundsstatu", role.getFundsstatu());
				roles.put("fundslevel", role.getFundslevel());
				rlts.put("role", roles);
				/** 塔的信息 */
				y = System.currentTimeMillis();
				// System.out.println("ply.get(12)"+(y-x));
				param.clear();
				param.put("roleId", id);
				param.put("mapid", mapid);
				List<RoleMapDetail> place = this.getRoleMapService()
						.getRoleMapByParam(param);
				param = null;
				List<Map<String, Object>> places = new ArrayList<Map<String, Object>>();
				if (!place.isEmpty()) {
					for (int i = 0; i < place.size(); i++) {
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("mapid", place.get(i).getMapid());
						map.put("placeid", place.get(i).getPlaceid());
						map.put("towerid", place.get(i).getTowerid());
						map.put("militaryid", place.get(i).getMilitaryid());
						places.add(map);
						map = null;
					}
					rlts.put("place", places);
				} else {
					rlts.put("place", places);
				}
				place = null;
				/** 判断修炼状态，结算经验 */
				this.getXiulianHandler().computexl(id);

				/****/
				y = System.currentTimeMillis();
				// System.out.println("ply.get(13)"+(y-x));
				/****/
				/** 武将的信息 */
				List<RoleMilitaryDetail> military = this
						.getRoleMilitaryService().getRoleMilitary(id);
				List<Map<String, Object>> roleMilitary = new ArrayList<Map<String, Object>>();
				if (!military.isEmpty()) {
					for (int i = 0; i < military.size(); i++) {
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("id", military.get(i).getId());
						map.put("militaryid", military.get(i).getMilitaryid());
						map.put("name", military.get(i).getName());
						map.put("roleId", military.get(i).getRoleId());
						map.put("level", military.get(i).getLevel());
						map.put("exp", military.get(i).getExp());
						map.put("types", military.get(i).getTypes());
						map.put("type", military.get(i).getType());
						map.put("wuqi", military.get(i).getWuqi());
						map.put("huwan", military.get(i).getHuwan());
						map.put("yifu", military.get(i).getYifu());
						map.put("touguan", military.get(i).getTouguan());
						map.put("xiezi", military.get(i).getXiezi());
						map.put("shipin", military.get(i).getShipin());
						map.put("bingstatus", military.get(i).getBingstatus());
						map.put("bing", military.get(i).getBing());
						map.put("fuben", military.get(i).getFuben());
						// System.out.println(i +"playerHandler.getmilitary:" +
						// map.toString());
						roleMilitary.add(map);
						map = null;
					}
					rlts.put("roleMilitary", roleMilitary);
				} else {
					rlts.put("roleMilitary", roleMilitary);
				}
				// List<RoleItemDetail> item=
				// this.getRoleItemService().findRoleItemsByRoleId(id);
				// List<Map<String, Object>> roleitem = new
				// ArrayList<Map<String, Object>>();
				// if(!item.isEmpty()){
				// for(int i=0;i<item.size();i++){
				// Map<String, Object> ma = new HashMap<String, Object>();
				// ma.put("id", item.get(i).getId());
				// ma.put("roleid", item.get(i).getRoleid());
				// ma.put("itemid", item.get(i).getItemid());
				// ma.put("nun", item.get(i).getNum());
				// ma.put("isuse", item.get(i).getIsuse());
				// ma.put("type", item.get(i).getType());
				// ma.put("flag", item.get(i).getFlag());
				// roleitem.add(ma);
				// ma=null;
				// }
				// rlts.put("roleItem", roleitem);
				// }else{
				// rlts.put("roleItem", roleitem);
				// }
				//				
				y = System.currentTimeMillis();
				// System.out.println("ply.get(14)"+(y-x));
				GameRoleDetail gameRole = getGameRoleService().findRoleById(
						currRoleId);
				y = System.currentTimeMillis();
				// System.out.println("ply.get(15)"+(y-x));
				session.setAttribute("gamerole", gameRole);
				Map<String, Object> _allres = getRoleInfo(id, gameRole);
				rlts.put("_allres", _allres);
				String str = new com.stang.game.server.handler.Test()
						.randomString(32);
				session.setAttribute("iddd", str);
				rlts.put("key_id", session.getAttribute("iddd"));
				rlts.put("statu", statu);
				y = System.currentTimeMillis();
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlts);
				ServerHandler.sendData(session, respMap);
				rlts = null;
				param = null;
				roles = null;
				pas = null;
			} else {
				String str = new com.stang.game.server.handler.Test()
						.randomString(32);
				session.setAttribute("iddd", str);
				rlts.put("key_id", session.getAttribute("iddd"));
				// rlts.put("statu",statu );
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, 2);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlts);
				ServerHandler.sendData(session, respMap);
				rlts.clear();
			}
			rlts = null;
			y = System.currentTimeMillis();
			// System.out.println("ply.get执行玩花费的时间："+(y-x));
		} catch (Exception e) {
			GameConstants.log.warn("", e);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_ERROR_PROCESS_FAILURE);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
					GameConstants.GAME_API_ERROR_PROCESS_FAILURE_INFO);
		}
	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private Map<String, Object> getRoleInfo(int id, GameRoleDetail gameRole) {
		Map<String, Object> res = new HashMap<String, Object>();
		List<RoleItemDetail> itemlist = this.getRoleItemService()
				.findRoleItemsByRoleId(id);
		List _resItem = new ArrayList();
		if (!itemlist.isEmpty()) {
			for (int i = 0; i < itemlist.size(); i++) {
				if (itemlist.get(i).getNum() > 0) {
					Map<String, Object> item = new HashMap<String, Object>();
					RoleItemDetail iDetail = itemlist.get(i);
					item.put("bid", iDetail.getId());
					item.put("id", iDetail.getItemid());
					item.put("num", iDetail.getNum());
					_resItem.add(item);
					item = null;
					iDetail = null;
				}
			}
		}
		res.put("roleItem", _resItem);

		/** 装备的信息 */
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("roleId", id);
		List<RoleEquipDetail> equip = this.getRoleEquipService()
				.getRoleEquipDetail(params);
		params = null;
		List<Map<String, Object>> equips = new ArrayList<Map<String, Object>>();
		if (!equip.isEmpty()) {
			for (int i = 0; i < equip.size(); i++) {
				Map<String, Object> map = new HashMap<String, Object>();
				// System.out.println("equipID:" + equip.get(i).getId());
				map.put("bid", equip.get(i).getId());
				map.put("id", equip.get(i).getEquipId());
				map.put("num", 1);
				map.put("at", equip.get(i).getAttack());
				map.put("hp", equip.get(i).getHpMax());
				map.put("spd", equip.get(i).getSpeed());
				map.put("rl", equip.get(i).getRectlength());
				map.put("sl", equip.get(i).getDengji());
				map.put("isUsed", equip.get(i).getUser());
				map.put("starlevel", equip.get(i).getStarlevel());
				map.put("levelexp", equip.get(i).getLevelexp());
				map.put("flag", 1);
				map.put("type", equip.get(i).getType());
				equips.add(map);
				map = null;
			}
			res.put("roleEquips", equips);

		} else {
			res.put("roleEquips", equips);
		}
		// System.out.println("PlayerHanler.getRoleInfo:equips:" +
		// equips.toString());
		equips = null;
		return res;
	}

	public boolean getShangxian(int type, int resType, int roleId, int id,
			int num) {
		boolean boo = false;
		// int vip = this.getGameRoleService().findRoleById(roleId).getVip();//
		// 查看vip等级
		GameRoleDetail gr = this.getGameRoleService().findRoleById(roleId);
		int vip = gr.getVip();
		// 黄钻享受vip2待遇
		if (vip < 2) {
			int huangzuan = 0;
			JsonSerializer json = new JsonSerializer();
			// String Huangzuaninfo =
			// this.getGameRoleService().findRoleById(roleId).getHuangzuaninfo();
			String Huangzuaninfo = gr.getHuangzuaninfo();
			if ("null".equals(String.valueOf(Huangzuaninfo))) {

			} else {
				List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
						.deserialize(Huangzuaninfo);
				int ret = Integer.parseInt(String.valueOf(roleinfo.get(0).get(
						"ret")));
				if (ret == 0) {
					huangzuan = Integer.parseInt(String.valueOf(roleinfo.get(0)
							.get("is_yellow_vip")));
				}
			}
			if (huangzuan == 1) {
				vip = 2;
			}
		}
		GameVipDetail gvip = this.getGameVipService().getGameVipByLe(vip)
				.get(0);// 得到vip 等级下的各种上限
		int backTop = gvip.getBackTop();// 背包上限
		Map<String, Object> param = new HashMap<String, Object>();
		if (resType == 5) {
			param.clear();
			param.put("roleid", roleId);
			param.put("itemid", id);
			List<RoleItemDetail> item = this.getRoleItemService()
					.getRoleItemByitem(param);// 查看有没有此物品
			if (!item.isEmpty()) {// 当表中已经有的时候
				boo = true;
			} else {
				param.clear();
				param.put("roleid", roleId);
				param.put("type", type);
				param.put("isuse", 0);
				param.put("num", 0);
				List<RoleItemDetail> lists = this.getRoleItemService()
						.getRoleItemByNum(param);// 查看这种类型有几个是否到了上线；
				if (backTop - 1 >= lists.size()) {// 判断 是否超出上限
					boo = true;
				} else {
					boo = false;
				}
			}
		} else if (resType == 6) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("roleId", roleId);
			// params.put("type", type);
			List<RoleEquipDetail> lists = this.getRoleEquipService()
					.getRoleEquip(params);// 查看这种类型有几个是否到了上线；
			int back_has_num = 0;//背包中装备的数量
			//System.out.println("PlayerHandler---lists.size=" + lists.size());// lists.size()居然等于0!!!!!这就是装备丢失原因
			for (int i = 0; i < lists.size(); i++) {
				if(lists.get(i).getUser().equals("0")){
					back_has_num++;
				}
			}
//			System.out.println("backTop=="+backTop);
//			System.out.println("back_has_num=="+back_has_num);
			if (backTop >= back_has_num+num) {// 判断 是否超出上限
				boo = true;
			} else {
				boo = false;
			}
		} else if (resType == 3) {// 武将背包格子是否足够
			int tom = gvip.getMilitaryTop();
			param.clear();
			param.put("roleId", roleId);
			List<RoleMilitaryDetail> militarys = this.getRoleMilitaryService()
					.getRoleMilitaryByparam(param);
			if (militarys.isEmpty()) {
				boo = true;
			} else {
				if (militarys.size() < tom) {
					boo = true;
				} else {
					boo = false;
				}
			}
		}
		return boo;
	}

	/** roleid:人物id，level：人物等级，exp：原有经验，uppexp：本次获得经验 */
	protected int shengji(int roleid, int level, int exp, int uppexp) {
		Map<String, Object> pm = new HashMap<String, Object>();
		int upplevel = 0;// 没有升级
		int needexp = this.getGameLevelService().getGameLevelByRoleLevel(level)
				.getNeedexp();// 升级所需经验
		int maxlevel = this.getGameLevelService().allGameLevelDetail().size();
		if (level > maxlevel) {
			pm.clear();
			pm.put("id", roleid);
			pm.put("level", maxlevel);
			this.getGameRoleService().updateRoleVip(pm);
		}
		if ((exp + uppexp) >= needexp) {// 可以升级
			// 判断是否达到最大等级，经验不增加了
			if (maxlevel == level) {
				pm.clear();
				pm.put("id", roleid);
				pm.put("exp", exp);
				this.getGameRoleService().updateRoleVip(pm);
				return upplevel;
			}
			upplevel = 1;
			// 判断连升了几级
			int lv = 0;
			int needs = needexp;
			ps: while (true) {
				for (int i = 1; i < 50; i++) {
					lv = i;
					if ((level + i) > this.getGameLevelService()
							.allGameLevelDetail().size()) {
						needexp = 0;
						exp = 0;
						uppexp = 0;
						break ps;
					}
					int need = this.getGameLevelService()
							.getGameLevelByRoleLevel(level + i).getNeedexp();
					needs += need;
					if ((exp + uppexp) < needs) {// 不可以再连升级了
						break ps;
					}
					needexp += need;
				}
			}
			pm.clear();
			pm.put("id", roleid);
			pm.put("level", (level + lv));
			pm.put("exp", (exp + uppexp - needexp));
			this.getGameRoleService().updateRoleVip(pm);
		}
		return upplevel;
	}

	/**
	 * 
	 * @param roleid
	 * @param day
	 *            当日天数
	 * @param intintegral
	 */
	void dayTask(int roleid, int day) {
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
		paramd = null;
		ary3 = null;
	}

	/**
	 * 
	 * @param roleId人物id
	 * @param id道具id
	 * @param num
	 * @param type道具类型
	 *            5
	 */
	void getItem(int roleId, int id, int num, int type, JSONArray list) {
		// long a=System.currentTimeMillis();
		if (type == 5) {

			// 活跃奖励都是道具
			// 道具
			Map<String, Object> params = new HashMap<String, Object>();
			params.clear();
			params.put("roleid", roleId);
			params.put("itemid", id);
			List<RoleItemDetail> item = this.getRoleItemService().getRoleItem(
					params);
			params.put("num", num);// 获得数量
			params.put("resType", type);
			// 判断背包格子是否已满
			int itemtype = this.getGameItemService().getGameItemById(id).get(0)
					.getItemtype();
			// long a1=System.currentTimeMillis();
			boolean boo = getShangxian(itemtype, type, roleId, id, num);
			// long b=System.currentTimeMillis();
			// System.out.println("判断背包格子花费的时间："+(b-a1));
			if (boo == false) {// 背包格子不足
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "道具空间不足");
				ServerHandler.sendData(session, respMap);
				return;
			}
			if (!item.isEmpty()) {// 已存在
				// long a02=System.currentTimeMillis();
				boolean bo = this.getRoleItemService().addRoleItemNum(params);
				// long a2=System.currentTimeMillis();
				// System.out.println("更新道具背包花费的时间："+(a2-a02));
				if (bo == true) {
					long bid = item.get(0).getId();
					params.put("bid", bid);
					params.put("id", id);
					params.remove("roleid");
					params.remove("itemid");
					// System.out.println("PlayerHandlelr7001h>>>>>params"+params);
					list.add(params);
				} else {

				}
			} else {// 不存在，
				// int bid = this.getAutoIdService()
				// .fingKeyValueByTableName("role_item") + 1;
				long bid = this.getAutoIdService().fingKeyValueByTableName(
						"role_item");
				RoleItemDetail iDetail = new RoleItemDetail();
				iDetail.setId(bid);
				iDetail.setRoleid(roleId);
				iDetail.setItemid(id);
				iDetail.setNum(num);
				iDetail.setFlag(1);
				iDetail.setType(itemtype);
				// long a02=System.currentTimeMillis();
				// System.out.println("PlayerHandler:7019h:bid:" +
				// iDetail.getId() + " roleid:" + iDetail.getRoleid() +
				// " itemid:" + iDetail.getItemid());
				boolean bo = this.getRoleItemService().insertRoleItem(iDetail);
				// this.getAutoIdService()
				// .updateKeyValueAddOneByTableName(
				// "role_item");
				// long a2=System.currentTimeMillis();
				// System.out.println("插入道具背包花费的时间："+(a2-a02));
				if (bo == true) {
					params.put("bid", bid);
					params.remove("roleid");
					params.put("id", id);
					params.remove("itemid");
					list.add(params);

				}
			}
		} else if (type == 6) {
			// 装备
			// 判断背包格子是否已满
			int equiptype = this.getGameEquipService().getGameEquipById(id)
					.get(0).getType();
			boolean boo = getShangxian(equiptype, type, roleId, id, num);
			if (boo == false) {// 背包格子不足
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "装备空间不足");
				ServerHandler.sendData(session, respMap);
				return;
			}
			// 判断num是几个装备，循环插入数据库
			for (int n = 0; n < num; n++) {
				// 直接插入
				List<GameEquipDetail> gameequips = this.getGameEquipService()
						.getGameEquipByEid(id);
				GameEquipDetail gameequip = null;
				if (!gameequips.isEmpty()) {
					gameequip = gameequips.get(0);

				}

				int bid = this.getAutoIdService().fingKeyValueByTableName(
						"role_equip");
				// 添加
				int speed = gameequip.getSudu();
				int attack = gameequip.getGongji();
				int hpMax = gameequip.getXueliang();
				int rectlength = gameequip.getFanwei();
				int t = gameequip.getType();
				String user = "0";
				RoleEquipDetail eDetail = new RoleEquipDetail();
				eDetail.setId(bid);
				eDetail.setDengji(1);
				eDetail.setEquipId(id);
				eDetail.setRoleId(roleId);
				eDetail.setFlag(1);
				eDetail.setType(t);
				eDetail.setAttack(attack);
				eDetail.setUser(user);
				eDetail.setHpMax(hpMax);
				eDetail.setRectlength(rectlength);
				eDetail.setSpeed(speed);
				// long a02=System.currentTimeMillis();
				this.getRoleEquipService().insertRoleEquip(eDetail);

				// this.getAutoIdService()
				// .updateKeyValueAddOneByTableName(
				// "role_equip");
				// long a2=System.currentTimeMillis();
				// System.out.println("插入魔将背包花费的时间："+(a2-a02));

				HashMap<String, Object> pa = new HashMap<String, Object>();
				pa.put("num", 1);// 获得数量
				pa.put("resType", type);
				pa.put("bid", bid);
				pa.put("id", id);

				pa.put("at", attack);
				pa.put("hp", hpMax);
				pa.put("spd", speed);
				pa.put("rl", rectlength);
				pa.put("isUsed", 0);
				pa.put("sl", 1);
				list.add(pa);
				pa.clear();

			}
		}
		// long b=System.currentTimeMillis();
		// System.out.println("发道具及判断背包格子花费的时间："+(b-a));
	}

	/**
	 * 每日更新活动
	 * 
	 * @param roleId
	 */
	public void updateActivity(int roleId) {
		// 更新活动：每日登陆，每日消费
		Map<String, Object> param = new HashMap<String, Object>();
		List<ActivityDetail> activity = this.getActivityService()
				.getActivityByParams(param);
		if (!activity.isEmpty()) {
			int size = activity.size();
			GameRoleDetail gameRole = this.getGameRoleService().findRoleById(
					roleId);
			if (gameRole != null) {
				List<Map> list = JSONArray.fromObject(gameRole
						.getActivitytype());
				// System.out.println("PlayerHandler().list:" +
				// gameRole.getActivitytype());
				int size2 = list.size();
				Map map = new HashMap();
				for (int i = 0; i < size; i++) {
					if (activity.get(i).getType() == 4) {// 每日登陆
						// 判断活动是否已过期
						Calendar calendar = Calendar.getInstance();
						int month0 = calendar.get(Calendar.MONTH) + 1;
						int day0 = calendar.get(Calendar.DAY_OF_MONTH);
						int month = activity.get(i).getMonth();
						int day = activity.get(i).getDay();
						int monthend = activity.get(i).getMonthend();
						int dayend = activity.get(i).getDayend();
						int status = 0;
						if (month == month0 && month0 == monthend) {
							if (day0 >= day && day0 <= dayend) {
								status = 1;
							}
							// }else if(month0>=month && month0<monthend){
						} else if (month0 >= month && month0 <= monthend) {
							// 不用判断day
							status = 1;
						}
						if (status == 1) {
							for (int j = 0; j < size2; j++) {
								if (list.get(j).get(
										activity.get(i).getId() + "") != null) {
									list.remove(j);
									size2--;
									map.clear();
									map.put("id", roleId);
									map.put("activitytype", list.toString());
									this.getGameRoleService()
											.updateRoleVip(map);
									break;
								}
							}
						}
					} else if (activity.get(i).getType() == 3) {// 每日消费Q点
						// 判断活动是否已过期
						Calendar calendar = Calendar.getInstance();
						int month0 = calendar.get(Calendar.MONTH) + 1;
						int day0 = calendar.get(Calendar.DAY_OF_MONTH);
						int month = activity.get(i).getMonth();
						int day = activity.get(i).getDay();
						int monthend = activity.get(i).getMonthend();
						int dayend = activity.get(i).getDayend();
						int status = 0;
						if (month == month0 && month0 == monthend) {
							if (day0 >= day && day0 <= dayend) {
								status = 1;
							}
						} else if (month0 >= month && month0 <= monthend) {
							// 不用判断day
							status = 1;
						}
						if (status == 1) {
							map.clear();
							map.put("id", roleId);
							for (int j = 0; j < size2; j++) {
								if (list.get(j).toString().equals("null")) {
									// System.out.println("actovity.size:" +
									// activity.size() + "     i:" + i);
									// System.out.println("list.get(j):" +
									// list.get(j).toString());
									// System.out.println("PlayerHanler.___________________activity.get(i).getId():"
									// + activity.get(i).getId());
									if (null != list.get(j).get(
											activity.get(i).getId() + "")) {
										list.remove(j);
										size2--;
										map
												.put("activitytype", list
														.toString());
										break;
									}
								}
							}
							// map.put("daycoin", gameRole.getCoinspend());
							this.getGameRoleService().updateRoleVip(map);
						}
					}
				}
				list = null;
				map = null;
			}
			gameRole = null;
		}
		activity = null;
	}

	/**
	 * 4.5品质武将挑选武将时的概率逻辑
	 */
	private int getId(List<GameMilitaryDetail> list) {
		int result = 0;
		// System.out.println("进入概率逻辑");
		List<Integer> id = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).getMjchance(); j++) {
				id.add(list.get(i).getId());
			}
		}
		Random ra = new Random();
		int index = ra.nextInt(id.size());
		result = id.get(index);
		// System.out.println("id=" + result);
		return result;
	}
	
	public long getDaysBetween(String activityTime) throws ParseException{//获取活动里当前时间已经相距多少天
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		int yearNow = calendar.get(Calendar.YEAR);
		int monthNow = calendar.get(Calendar.MONTH) + 1;
		int dayNow = calendar.get(Calendar.DAY_OF_MONTH);
		String nowTime = yearNow + "-" + monthNow + "-" + dayNow;
//		System.out.println(nowTime);
		Date d1 = sdf.parse(activityTime);
		Date d2 = sdf.parse(nowTime);
		long daysBetween = (d2.getTime()-d1.getTime()+1000000)/(3600*24*1000);
		daysBetween += 1;
//		System.out.println("现在离参数活动第" + daysBetween + "天");
		return daysBetween;
	}
}