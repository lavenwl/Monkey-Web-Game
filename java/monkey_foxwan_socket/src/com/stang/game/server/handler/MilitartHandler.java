package com.stang.game.server.handler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.sojo.interchange.json.JsonSerializer;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.mina.core.session.IoSession;

import com.alibaba.fastjson.JSON;
import com.stang.game.cache.GlobalData;
import com.stang.game.common.GameConstants;
import com.stang.game.entity.detail.ActivityDetail;
import com.stang.game.entity.detail.DeliveryDetail;
import com.stang.game.entity.detail.GamblingItemDetail;
import com.stang.game.entity.detail.GameChLevelDetail;
import com.stang.game.entity.detail.GameEquipDetail;
import com.stang.game.entity.detail.GameItemDetail;
import com.stang.game.entity.detail.GameMLevelDetail;
import com.stang.game.entity.detail.GameMilitaryDetail;
import com.stang.game.entity.detail.GamePriceDetail;
import com.stang.game.entity.detail.GameRoleDetail;
import com.stang.game.entity.detail.GameStarDetail;
import com.stang.game.entity.detail.GameTowerDetail;
import com.stang.game.entity.detail.GameVipDetail;
import com.stang.game.entity.detail.HostDetail;
import com.stang.game.entity.detail.MemberDetail;
import com.stang.game.entity.detail.RoleChallengeDetail;
import com.stang.game.entity.detail.RoleDaytaskDetail;
import com.stang.game.entity.detail.RoleEquipDetail;
import com.stang.game.entity.detail.RoleItemDetail;
import com.stang.game.entity.detail.RoleMapDetail;
import com.stang.game.entity.detail.RoleMilitaryDetail;
import com.stang.game.entity.detail.RoleQuicktimeDetail;
import com.stang.game.entity.detail.RoleTaskTaskDetail;
import com.stang.game.server.ServerHandler;
import com.stang.game.service.IGamblingItemService;
import com.stang.game.service.IGameChLevelService;
import com.stang.game.service.IGameEquipService;
import com.stang.game.service.IGameMLevelService;
import com.stang.game.service.IGameStarService;
import com.stang.game.service.IGameTowerService;
import com.stang.game.service.IGameVipService;
import com.stang.game.service.IRoleDaytaskService;
import com.stang.game.service.IRoleEquipService;
import com.stang.game.service.IRoleItemService;
import com.stang.game.service.IRoleMapService;
import com.stang.game.service.IRoleMilitaryService;
import com.stang.game.service.IRoleQuicktimeService;
import com.stang.game.service.ITempPackageService;
import com.stang.game.service.impl.GamblingItemServiceImpl;
import com.stang.game.service.impl.GameChLevelServiceImpl;
import com.stang.game.service.impl.GameEquipServiceImpl;
import com.stang.game.service.impl.GameMLevelServiceImpl;
import com.stang.game.service.impl.GameStarServiceImpl;
import com.stang.game.service.impl.GameTowerServiceImpl;
import com.stang.game.service.impl.GameVipServiceImpl;
import com.stang.game.service.impl.RoleDaytaskServiceImpl;
import com.stang.game.service.impl.RoleEquipServiceImpl;
import com.stang.game.service.impl.RoleItemServiceImpl;
import com.stang.game.service.impl.RoleMapServiceImpl;
import com.stang.game.service.impl.RoleMilitaryServiceImpl;
import com.stang.game.service.impl.RoleQuicktimeServiceImpl;
import com.stang.game.service.impl.TempPackageServiceImpl;

public class MilitartHandler extends BaseHandler {
	private static IRoleMapService roleMapService;
	static private IGamblingItemService gamblingItemService;
	static private ITempPackageService tempPackageService;
	static private PlayerHandler playerHandler;
	static private XiulianHandler xiulianHandler;
	private static IGameMLevelService gameMlevelService;

	private static IGameTowerService gameTowerService;

	private IGameTowerService getGameTowerService() {
		if (gameTowerService == null) {
			gameTowerService = new GameTowerServiceImpl();
		}
		return gameTowerService;
	}

	static private SystemHandler systemHandler;

	private SystemHandler getsystemHandler() {
		if (systemHandler == null) {
			systemHandler = new SystemHandler();
		}
		return systemHandler;
	}

	private IGameMLevelService getGameMlevelService() {
		if (gameMlevelService == null) {
			gameMlevelService = new GameMLevelServiceImpl();
		}
		return gameMlevelService;
	}

	static private TaskHandler taskHandler;

	private TaskHandler getTaskHandler() {
		if (taskHandler == null) {
			taskHandler = new TaskHandler(gameApiName, globalIdentifier,
					encryptedSignature, playerId, cacheKey, params, session);
		}
		return taskHandler;
	}

	private PlayerHandler getplayerHandler() {
		if (playerHandler == null) {
			playerHandler = new PlayerHandler(gameApiName, globalIdentifier,
					encryptedSignature, playerId, cacheKey, params, session);
		}
		return playerHandler;
	}

	private XiulianHandler getxiulianHandler() {
		if (xiulianHandler == null) {
			xiulianHandler = new XiulianHandler(gameApiName, globalIdentifier,
					encryptedSignature, playerId, cacheKey, params, session);
		}
		return xiulianHandler;
	}

	private ITempPackageService getTempPackageService() {
		if (tempPackageService == null) {
			tempPackageService = new TempPackageServiceImpl();
		}
		return tempPackageService;
	}

	private static IGameStarService gameStarService;

	private IGameStarService getGameStarService() {
		if (gameStarService == null) {
			gameStarService = new GameStarServiceImpl();
		}
		return gameStarService;
	}

	private static IGameMLevelService gameMLevelService;

	private IGameMLevelService getGameMLevelService() {
		if (gameMLevelService == null) {
			gameMLevelService = new GameMLevelServiceImpl();
		}
		return gameMLevelService;
	}

	private IRoleMapService getRoleMapService() {
		if (roleMapService == null) {
			roleMapService = new RoleMapServiceImpl();
		}
		return roleMapService;
	}

	private IGamblingItemService getGamblingItemService() {
		if (gamblingItemService == null) {
			gamblingItemService = new GamblingItemServiceImpl();
		}
		return gamblingItemService;
	}

	private static IGameVipService gameVipService;

	private IGameVipService getGameVipService() {
		if (gameVipService == null) {
			gameVipService = new GameVipServiceImpl();
		}
		return gameVipService;
	}

	private static IRoleItemService roleItemService;

	private IRoleItemService getRoleItemService() {
		if (roleItemService == null) {
			roleItemService = new RoleItemServiceImpl();
		}
		return roleItemService;
	}

	private static IRoleQuicktimeService roleQuicktimeService;

	private IRoleQuicktimeService getRoleQuicktimeService() {
		if (roleQuicktimeService == null) {
			roleQuicktimeService = new RoleQuicktimeServiceImpl();
		}
		return roleQuicktimeService;

	}

	private static IRoleMilitaryService roleMilitaryService;

	private IRoleMilitaryService getRoleMilitaryService() {
		if (roleMilitaryService == null) {
			roleMilitaryService = new RoleMilitaryServiceImpl();
		}
		return roleMilitaryService;
	}

	private static IRoleEquipService roleEquipService;

	private IRoleEquipService getRoleEquipService() {
		if (roleEquipService == null) {
			roleEquipService = new RoleEquipServiceImpl();
		}
		return roleEquipService;
	}

	private static IGameEquipService gameEquipService;

	private IGameEquipService getGameEquipService() {
		if (gameEquipService == null) {
			gameEquipService = new GameEquipServiceImpl();
		}
		return gameEquipService;
	}

	private static IGameChLevelService gameChLevelService;

	private IGameChLevelService getGameChLevelService() {
		if (gameChLevelService == null) {
			gameChLevelService = new GameChLevelServiceImpl();
		}
		return gameChLevelService;
	}

	private static IRoleDaytaskService roleDaytask;

	private IRoleDaytaskService getRoleDaytaskService() {
		if (roleDaytask == null) {
			roleDaytask = new RoleDaytaskServiceImpl();
		}
		return roleDaytask;
	}

	public MilitartHandler() {
	};

	public MilitartHandler(String gameApiName, String globalIdentifier,
			String encryptedSignature, String playerId, String cacheKey,
			Map params, IoSession session) {
		super(gameApiName, globalIdentifier, encryptedSignature, playerId,
				cacheKey, params, session);
		if (gameApiName.equals("mil.xunxian")) {
			/** 寻仙 */
			this.xunxian();
		} else if (gameApiName.equals("mil.goxunxian")) {
			/** 开始寻仙 */
			this.goxunxian();
		} else if (gameApiName.equals("mil.getmilitary")) {
			/** 查看武将信息 修炼按钮 */
			this.getmilitarys();
		} else if (gameApiName.equals("mil.gamestart")) {
			/** 开始游戏 */
			this.gemestart();
		} else if (gameApiName.equals("mil.addjunling")) {
			/** 每一个小时增加军令1 */
			this.addjunling();
		} else if (gameApiName.equals("mil.changeequips")) {
			/** 武将换装 */
			this.changeequips();
		} else if (gameApiName.equals("mil.fire")) {
			/** 解雇武将 */
			this.fire();
		} else if (gameApiName.equals("mil.promotion")) {
			/** 晋级武将 */
			this.promotion();
		} else if (gameApiName.equals("mil.useyaopai")) {
			/** 使用妖牌战斗 */
			this.useyaopai();
		} else if (gameApiName.equals("mil.buyItems")) {
			/** 购买道具 mil.goods2 */
			this.buyItems();
		} else if (gameApiName.equals("mil.buyvip")) {
			/** 购买vip礼包 mil.goods3 */
			buyvip();
		} else if (gameApiName.equals("mil.midexist")) {
			/** 合成武将给奖励，活动 */
			midexist();
		} else if (gameApiName.equals("mil.openmidexist")) {
			/** 打开 合成武将给奖励，活动 */
			openmidexist();
		} else if (gameApiName.equals("mil.friendrise")) {
			/** 好友升级奖励 */
			friendrise();
		} else if (gameApiName.equals("mil.friendcost")) {
			/** 好友消费奖励 */
			friendcost();
		} else if (gameApiName.equals("mil.openfriendcost")) {
			/** 好友消费奖励打开界面 */
			openfriendcost();
		} else if (gameApiName.equals("mil.allfriend")) {
			/** 要求的所有好友 */
			allfriend();
		} else if (gameApiName.equals("mil.openfriendrise")) {
			/** 要求的好友升级的打开界面 */
			openfriendrise();
		}
		// else if (gameApiName.equals("mil.activeinvite")){
		// /**活跃邀请*/
		// activeinvite();
		// }

	}

	// private void activeinvite(){//活跃邀请
	// Map<String,Object> rid = new HashMap<String,Object>();
	// int roilid = Integer.parseInt(playerId);
	//
	// }

	private void openfriendcost() {// 好友消费奖励
		Map<String, Object> rlt = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		JSONArray mapjs = new JSONArray();

		int roleid = Integer.parseInt(playerId);

		String ids = this.getGameRoleService().findRoleById(roleid).getIds();
		String yu1 = this.getGameItemService().getGameItemByIdtwo(218).get(0)
				.getItemprop();
		String yu2 = this.getGameItemService().getGameItemByIdtwo(219).get(0)
				.getItemprop();
		String yu3 = this.getGameItemService().getGameItemByIdtwo(220).get(0)
				.getItemprop();
		String yu4 = this.getGameItemService().getGameItemByIdtwo(221).get(0)
				.getItemprop();
		String yu5 = this.getGameItemService().getGameItemByIdtwo(222).get(0)
				.getItemprop();
		String yu6 = this.getGameItemService().getGameItemByIdtwo(223).get(0)
				.getItemprop();
		String yu7 = this.getGameItemService().getGameItemByIdtwo(224).get(0)
				.getItemprop();
		String yu8 = this.getGameItemService().getGameItemByIdtwo(225).get(0)
				.getItemprop();
		String yu9 = this.getGameItemService().getGameItemByIdtwo(226).get(0)
				.getItemprop();
		String yu10 = this.getGameItemService().getGameItemByIdtwo(227).get(0)
				.getItemprop();

		if ("null".equals(String.valueOf(ids))) {// 没有邀请过

			map.put("targetCoin", 100);
			map.put("targetNum", 0);// 可领取次数
			map.put("info", yu1);
			map.put("canget", 0);
			mapjs.add(map);
			map.clear();

			map.put("targetCoin", 400);// 等级领取
			map.put("targetNum", 0);// 可领取次数
			map.put("info", yu2);
			map.put("canget", 0);
			mapjs.add(map);
			map.clear();

			map.put("targetCoin", 900);
			map.put("targetNum", 0);// 可领取次数
			map.put("info", yu3);
			map.put("canget", 0);
			mapjs.add(map);
			map.clear();

			map.put("targetCoin", 1700);
			map.put("targetNum", 0);// 可领取次数
			map.put("info", yu4);
			map.put("canget", 0);
			mapjs.add(map);
			map.clear();

			map.put("targetCoin", 2900);
			map.put("targetNum", 0);// 可领取次数
			map.put("info", yu5);
			map.put("canget", 0);
			mapjs.add(map);
			map.clear();

			map.put("targetCoin", 7000);
			map.put("targetNum", 0);// 可领取次数
			map.put("info", yu6);
			map.put("canget", 0);
			mapjs.add(map);
			map.clear();

			map.put("targetCoin", 13000);
			map.put("targetNum", 0);// 可领取次数
			map.put("info", yu7);
			map.put("canget", 0);
			mapjs.add(map);
			map.clear();

			map.put("targetCoin", 27000);
			map.put("targetNum", 0);// 可领取次数
			map.put("info", yu8);
			map.put("canget", 0);
			mapjs.add(map);
			map.clear();

			map.put("targetCoin", 59000);
			map.put("targetNum", 0);// 可领取次数
			map.put("info", yu9);
			map.put("canget", 0);
			mapjs.add(map);
			map.clear();

			map.put("targetCoin", 100000);
			map.put("targetNum", 0);// 可领取次数
			map.put("info", yu10);
			map.put("canget", 0);
			mapjs.add(map);
			map.clear();

		} else {// 邀请的有好友

			/***
			 * 邀请好友不同消费不同元宝的数量
			 * */
			JSONArray ids2 = JSONArray.fromObject(ids);
			Set set = new HashSet();
			for (int k = 0; k < ids2.size(); k++) {// 去重
				set.add(ids2.get(k));
			}
			ids2.clear();
			Iterator it = set.iterator();
			while (it.hasNext()) {
				ids2.add(it.next());
			}

			int num1 = 0;// 等级为100的数量
			int num2 = 0;// 等级为400的数量
			int num3 = 0;// 等级为900的数量
			int num4 = 0;// 等级为1700的数量
			int num5 = 0;// 等级为2900的数量
			int num6 = 0;// 等级为7000的数量
			int num7 = 0;// 等级为13000的数量
			int num8 = 0;// 等级为27000的数量
			int num9 = 0;// 等级为59000的数量
			int num10 = 0;// 等级为100000的数量
			for (int i = 0; i < ids2.size(); i++) {

				int frid = ids2.getInt(i);
				GameRoleDetail gr = this.getGameRoleService()
						.findRoleById(frid);
				if (gr == null) {
					continue;
				}

				int coinspend = gr.getCoinspend();
				if (coinspend > 99) {// 邀请成功条件设置为被邀请玩家消耗元宝达到100
					if (coinspend > 99) {// 等级为10
						num1++;
					}
					if (coinspend > 399) {
						num2++;
					}
					if (coinspend > 899) {
						num3++;
					}
					if (coinspend > 1699) {
						num4++;
					}
					if (coinspend >= 2900) {
						num5++;
					}
					if (coinspend > 7000) {
						num6++;
					}
					if (coinspend > 13000) {
						num7++;
					}
					if (coinspend > 27000) {
						num8++;
					}
					if (coinspend > 59000) {
						num9++;
					}
					if (coinspend > 100000) {
						num10++;
					}

				}
			}
			/**
		    	 * **/
			String friendcost = this.getGameRoleService().findRoleById(roleid)
					.getFriendcost();
			List list = new ArrayList();
			JSONArray roleinfo = JSONArray.fromObject(friendcost);
			/***
			 * 邀请的好友没有领取过奖励
			 * */
			if (roleinfo.size() == 0) {
				map.put("targetCoin", 100);
				map.put("targetNum", num1);// 可领取次数
				map.put("info", yu1);
				map.put("canget", num1);
				mapjs.add(map);
				map.clear();

				map.put("targetCoin", 400);// 等级领取
				map.put("targetNum", num2);// 可领取次数
				map.put("info", yu2);
				map.put("canget", num2);
				mapjs.add(map);
				map.clear();

				map.put("targetCoin", 900);
				map.put("targetNum", num3);// 可领取次数
				map.put("info", yu3);
				map.put("canget", num3);
				mapjs.add(map);
				map.clear();

				map.put("targetCoin", 1700);
				map.put("targetNum", num4);// 可领取次数
				map.put("info", yu4);
				map.put("canget", num4);
				mapjs.add(map);
				map.clear();

				map.put("targetCoin", 2900);
				map.put("targetNum", num5);// 可领取次数
				map.put("info", yu5);
				map.put("canget", num5);
				mapjs.add(map);
				map.clear();

				map.put("targetCoin", 7000);
				map.put("targetNum", num6);// 可领取次数
				map.put("info", yu6);
				map.put("canget", num6);
				mapjs.add(map);
				map.clear();

				map.put("targetCoin", 13000);
				map.put("targetNum", num7);// 可领取次数
				map.put("info", yu7);
				map.put("canget", num7);
				mapjs.add(map);
				map.clear();

				map.put("targetCoin", 27000);
				map.put("targetNum", num8);// 可领取次数
				map.put("info", yu8);
				map.put("canget", num8);
				mapjs.add(map);
				map.clear();

				map.put("targetCoin", 59000);
				map.put("targetNum", num9);// 可领取次数
				map.put("info", yu9);
				map.put("canget", num9);
				mapjs.add(map);
				map.clear();

				map.put("targetCoin", 100000);
				map.put("targetNum", num10);// 可领取次数
				map.put("info", yu10);
				map.put("canget", num10);
				mapjs.add(map);
				map.clear();

			}
			/****/

			/***
			 * 邀请的好友领取过奖励
			 * */
			else {
				if (roleinfo.size() > 0) {
					for (int i = 0; i < roleinfo.size(); i++) {
						JSONArray ro = JSONArray.fromObject(roleinfo.get(i));
						if (ro.getInt(0) == 100) {
							num1 = num1 - ro.getInt(1);
						} else if (ro.getInt(0) == 400) {
							num2 = num2 - ro.getInt(1);
						} else if (ro.getInt(0) == 900) {
							num3 = num3 - ro.getInt(1);
						} else if (ro.getInt(0) == 1700) {
							num4 = num4 - ro.getInt(1);
						} else if (ro.getInt(0) == 2900) {
							num5 = num5 - ro.getInt(1);
						} else if (ro.getInt(0) == 7000) {
							num6 = num6 - ro.getInt(1);
						} else if (ro.getInt(0) == 13000) {
							num7 = num7 - ro.getInt(1);
						} else if (ro.getInt(0) == 27000) {
							num8 = num8 - ro.getInt(1);
						} else if (ro.getInt(0) == 59000) {
							num9 = num9 - ro.getInt(1);
						} else if (ro.getInt(0) == 100000) {
							num10 = num10 - ro.getInt(1);
						}
					}

					if (num1 < 0) {
						num1 = 0;
					}
					if (num2 < 0) {
						num2 = 0;
					}
					if (num3 < 0) {
						num3 = 0;
					}
					if (num4 < 0) {
						num4 = 0;
					}
					if (num5 < 0) {
						num5 = 0;
					}
					if (num6 < 0) {
						num6 = 0;
					}
					if (num7 < 0) {
						num7 = 0;
					}
					if (num8 < 0) {
						num8 = 0;
					}
					if (num9 < 0) {
						num9 = 0;
					}
					if (num10 < 0) {
						num10 = 0;
					}
					map.put("targetCoin", 100);
					map.put("targetNum", num1);// 可领取次数
					map.put("info", yu1);
					map.put("canget", num1);
					mapjs.add(map);
					map.clear();

					map.put("targetCoin", 400);// 等级领取
					map.put("targetNum", num2);// 可领取次数
					map.put("info", yu2);
					map.put("canget", num2);
					mapjs.add(map);
					map.clear();

					map.put("targetCoin", 900);
					map.put("targetNum", num3);// 可领取次数
					map.put("info", yu3);
					map.put("canget", num3);
					mapjs.add(map);
					map.clear();

					map.put("targetCoin", 1700);
					map.put("targetNum", num4);// 可领取次数
					map.put("info", yu4);
					map.put("canget", num4);
					mapjs.add(map);
					map.clear();

					map.put("targetCoin", 2900);
					map.put("targetNum", num5);// 可领取次数
					map.put("info", yu5);
					map.put("canget", num5);
					mapjs.add(map);
					map.clear();

					map.put("targetCoin", 7000);
					map.put("targetNum", num6);// 可领取次数
					map.put("info", yu6);
					map.put("canget", num6);
					mapjs.add(map);
					map.clear();

					map.put("targetCoin", 13000);
					map.put("targetNum", num7);// 可领取次数
					map.put("info", yu7);
					map.put("canget", num7);
					mapjs.add(map);
					map.clear();

					map.put("targetCoin", 27000);
					map.put("targetNum", num8);// 可领取次数
					map.put("info", yu8);
					map.put("canget", num8);
					mapjs.add(map);
					map.clear();

					map.put("targetCoin", 59000);
					map.put("targetNum", num9);// 可领取次数
					map.put("info", yu9);
					map.put("canget", num9);
					mapjs.add(map);
					map.clear();

					map.put("targetCoin", 100000);
					map.put("targetNum", num10);// 可领取次数
					map.put("info", yu10);
					map.put("canget", num10);
					mapjs.add(map);
					map.clear();
				} else {
					map.put("targetCoin", 100);
					map.put("targetNum", num1);// 可领取次数
					map.put("info", yu1);
					map.put("canget", num1);
					mapjs.add(map);
					map.clear();

					map.put("targetCoin", 400);// 等级领取
					map.put("targetNum", num2);// 可领取次数
					map.put("info", yu2);
					map.put("canget", num2);
					mapjs.add(map);
					map.clear();

					map.put("targetCoin", 900);
					map.put("targetNum", num3);// 可领取次数
					map.put("info", yu3);
					map.put("canget", num3);
					mapjs.add(map);
					map.clear();

					map.put("targetCoin", 1700);
					map.put("targetNum", num4);// 可领取次数
					map.put("info", yu4);
					map.put("canget", num4);
					mapjs.add(map);
					map.clear();

					map.put("targetCoin", 2900);
					map.put("targetNum", num5);// 可领取次数
					map.put("info", yu5);
					map.put("canget", num5);
					mapjs.add(map);
					map.clear();

					map.put("targetCoin", 7000);
					map.put("targetNum", num6);// 可领取次数
					map.put("info", yu6);
					map.put("canget", num6);
					mapjs.add(map);
					map.clear();

					map.put("targetCoin", 13000);
					map.put("targetNum", num7);// 可领取次数
					map.put("info", yu7);
					map.put("canget", num7);
					mapjs.add(map);
					map.clear();

					map.put("targetCoin", 27000);
					map.put("targetNum", num8);// 可领取次数
					map.put("info", yu8);
					map.put("canget", num8);
					mapjs.add(map);
					map.clear();

					map.put("targetCoin", 59000);
					map.put("targetNum", num9);// 可领取次数
					map.put("info", yu9);
					map.put("canget", num9);
					mapjs.add(map);
					map.clear();

					map.put("targetCoin", 100000);
					map.put("targetNum", num10);// 可领取次数
					map.put("info", yu10);
					map.put("canget", num10);
					mapjs.add(map);
					map.clear();

				}

			}
		}

		rlt.put("list", mapjs);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);

		rlt = null;
	}

	private void friendcost() {
		/** 好友消费奖励 */
		/** 好友升级奖励 */
		if (params.containsKey("coin")) {
			Map<String, Object> rlt = new HashMap<String, Object>();
			int roleid = Integer.parseInt(playerId);
			int coin = Integer.parseInt(String.valueOf(params.get("coin")));// 前端传来领取消费总金额
			String friendcost = this.getGameRoleService().findRoleById(roleid)
					.getFriendcost();
			JSONArray roleinfo = JSONArray.fromObject(friendcost);

			/****/
			int num = 0;
			String ids = this.getGameRoleService().findRoleById(roleid)
					.getIds();
			if (!"null".equals(String.valueOf(ids))) {//
				JsonSerializer json = new JsonSerializer();

				JSONArray ids2 = JSONArray.fromObject(ids);// 得到好友的Id

				Set set = new HashSet();
				for (int k = 0; k < ids2.size(); k++) {
					set.add(ids2.get(k));
				}
				ids2.clear();
				Iterator it = set.iterator();
				while (it.hasNext()) {
					ids2.add(it.next());
				}

				int size = ids2.size();
				if (coin > 99) {
					for (int i = 0; i < size; i++) {
						int frid = ids2.getInt(i);
						GameRoleDetail gr = this.getGameRoleService()
								.findRoleById(frid);
						if (gr == null) {
							continue;
						}
						int fl = gr.getCoinspend();
						if (coin <= fl) {// 邀请成功条件设置为被邀请玩家消耗金额达到100
							num++;
						}
					}
				}
			}
			/****/

			if (roleinfo.size() > 0) {// 玩家已经领取过
				int yilnum = 0;// 已经领取
				int a = 0;
				for (int i = 0; i < roleinfo.size(); i++) {
					JSONArray ro = JSONArray.fromObject(roleinfo.get(i));
					if (coin == ro.getInt(0)) {
						a = 1;
						yilnum = ro.getInt(1);
						roleinfo.remove(i);
						break;

					}

				}
				if (a == 1) {// coin消费的奖品玩家领取过
					rlt.put("targetNum", num - (yilnum + 1));
					if ((yilnum + 1) > num) {
						// 已领取完了
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-1);
						ServerHandler.sendData(session, respMap);
						return;
					} else {
						JSONArray list = new JSONArray();
						if (coin > 99) {

							if (coin == 100) {
								getLiveItem(roleid, 218, 1, 5, list);

							} else if (coin == 400) {
								getLiveItem(roleid, 219, 1, 5, list);

							} else if (coin == 900) {
								getLiveItem(roleid, 220, 1, 5, list);

							} else if (coin == 1700) {
								getLiveItem(roleid, 221, 1, 5, list);

							} else if (coin == 2900) {
								getLiveItem(roleid, 222, 1, 5, list);

							} else if (coin == 7000) {
								getLiveItem(roleid, 223, 1, 5, list);

							} else if (coin == 13000) {
								getLiveItem(roleid, 224, 1, 5, list);

							} else if (coin == 27000) {
								getLiveItem(roleid, 225, 1, 5, list);

							} else if (coin == 59000) {
								getLiveItem(roleid, 226, 1, 5, list);

							} else if (coin == 100000) {
								getLiveItem(roleid, 227, 1, 5, list);

							}
							rlt.put("reward", list);

							// 标记已领取
							JSONArray rol = new JSONArray();
							rol.add(coin);
							rol.add(yilnum + 1);
							roleinfo.add(rol);
							Map<String, Object> param = new HashMap<String, Object>();
							param.put("id", roleid);
							param.put("friendcost", roleinfo.toString());
							this.getGameRoleService().updateRoleVip(param);

						} else {// 等级不符合条件
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									-2);
							ServerHandler.sendData(session, respMap);
							return;
						}
					}

				} else {
					if (num == 0) {
						// 已领取完了
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-1);
						ServerHandler.sendData(session, respMap);
						return;
					}

					rlt.put("targetNum", num - 1);

					JSONArray list = new JSONArray();
					if (coin > 9) {

						if (coin == 100) {
							getLiveItem(roleid, 218, 1, 5, list);

						} else if (coin == 400) {
							getLiveItem(roleid, 219, 1, 5, list);

						} else if (coin == 900) {
							getLiveItem(roleid, 220, 1, 5, list);

						} else if (coin == 1700) {
							getLiveItem(roleid, 221, 1, 5, list);

						} else if (coin == 2900) {
							getLiveItem(roleid, 222, 1, 5, list);

						} else if (coin == 7000) {
							getLiveItem(roleid, 223, 1, 5, list);

						} else if (coin == 13000) {
							getLiveItem(roleid, 224, 1, 5, list);

						} else if (coin == 27000) {
							getLiveItem(roleid, 225, 1, 5, list);

						} else if (coin == 59000) {
							getLiveItem(roleid, 226, 1, 5, list);

						} else if (coin == 100000) {
							getLiveItem(roleid, 227, 1, 5, list);

						}

						rlt.put("reward", list);
						// 标记已领取
						JSONArray rol = new JSONArray();
						rol.add(coin);
						rol.add(1);
						roleinfo.add(rol);
						Map<String, Object> param = new HashMap<String, Object>();
						param.put("id", roleid);
						param.put("friendcost", roleinfo.toString());
						this.getGameRoleService().updateRoleVip(param);
					}
				}

			}

			else {// 玩家从来没有领取过
				JSONArray list = new JSONArray();
				if (coin > 99) {
					// 已领取完了
					if (num == 0) {
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-1);
						ServerHandler.sendData(session, respMap);
						return;
					}

					rlt.put("targetNum", num - 1);

					if (coin == 100) {
						getLiveItem(roleid, 218, 1, 5, list);

					} else if (coin == 400) {
						getLiveItem(roleid, 219, 1, 5, list);

					} else if (coin == 900) {
						getLiveItem(roleid, 220, 1, 5, list);

					} else if (coin == 1700) {
						getLiveItem(roleid, 221, 1, 5, list);

					} else if (coin == 2900) {
						getLiveItem(roleid, 222, 1, 5, list);

					} else if (coin == 7000) {
						getLiveItem(roleid, 223, 1, 5, list);

					} else if (coin == 13000) {
						getLiveItem(roleid, 224, 1, 5, list);

					} else if (coin == 27000) {
						getLiveItem(roleid, 225, 1, 5, list);

					} else if (coin == 59000) {
						getLiveItem(roleid, 226, 1, 5, list);

					} else if (coin == 100000) {
						getLiveItem(roleid, 227, 1, 5, list);

					}
					rlt.put("reward", list);
					// 标记已领取
					JSONArray rol = new JSONArray();
					rol.add(coin);
					rol.add(1);
					roleinfo.add(rol);
					Map<String, Object> param = new HashMap<String, Object>();
					param.put("id", roleid);
					param.put("friendcost", roleinfo.toString());
					this.getGameRoleService().updateRoleVip(param);

				} else {// 等级不符合条件
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
					ServerHandler.sendData(session, respMap);
					return;
				}
			}

			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
			rlt = null;
		}

	}

	private void openfriendrise() {// 好友升级奖励
		// System.out.println("好友升级奖励开始执行========================");
		Map<String, Object> rlt = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		JSONArray mapjs = new JSONArray();

		int roleid = Integer.parseInt(playerId);
		String yu1 = this.getGameItemService().getGameItemByIdtwo(208).get(0)
				.getItemprop();
		String yu2 = this.getGameItemService().getGameItemByIdtwo(209).get(0)
				.getItemprop();
		String yu3 = this.getGameItemService().getGameItemByIdtwo(210).get(0)
				.getItemprop();
		String yu4 = this.getGameItemService().getGameItemByIdtwo(211).get(0)
				.getItemprop();
		String yu5 = this.getGameItemService().getGameItemByIdtwo(212).get(0)
				.getItemprop();
		String yu6 = this.getGameItemService().getGameItemByIdtwo(213).get(0)
				.getItemprop();
		String yu7 = this.getGameItemService().getGameItemByIdtwo(214).get(0)
				.getItemprop();
		String yu8 = this.getGameItemService().getGameItemByIdtwo(215).get(0)
				.getItemprop();
		String yu9 = this.getGameItemService().getGameItemByIdtwo(216).get(0)
				.getItemprop();
		String yu10 = this.getGameItemService().getGameItemByIdtwo(217).get(0)
				.getItemprop();

		String ids = this.getGameRoleService().findRoleById(roleid).getIds();

		if ("null".equals(String.valueOf(ids))) {// 没有邀请过

			map.put("targetLevel", 10);
			map.put("targetNum", 0);// 可领取次数
			map.put("info", yu1);
			map.put("canget", 0);
			mapjs.add(map);
			map.clear();

			map.put("targetLevel", 20);// 等级领取
			map.put("targetNum", 0);// 可领取次数
			map.put("info", yu2);
			map.put("canget", 0);
			mapjs.add(map);
			map.clear();

			map.put("targetLevel", 30);
			map.put("targetNum", 0);// 可领取次数
			map.put("info", yu3);
			map.put("canget", 0);
			mapjs.add(map);
			map.clear();

			map.put("targetLevel", 40);
			map.put("targetNum", 0);// 可领取次数
			map.put("info", yu4);
			map.put("canget", 0);
			mapjs.add(map);
			map.clear();

			map.put("targetLevel", 50);
			map.put("targetNum", 0);// 可领取次数
			map.put("info", yu5);
			map.put("canget", 0);
			mapjs.add(map);
			map.clear();

			map.put("targetLevel", 60);
			map.put("targetNum", 0);// 可领取次数
			map.put("info", yu6);
			map.put("canget", 0);
			mapjs.add(map);
			map.clear();

			map.put("targetLevel", 65);
			map.put("targetNum", 0);// 可领取次数
			map.put("info", yu7);
			map.put("canget", 0);
			mapjs.add(map);
			map.clear();

			map.put("targetLevel", 70);
			map.put("targetNum", 0);// 可领取次数
			map.put("info", yu8);
			map.put("canget", 0);
			mapjs.add(map);
			map.clear();

			map.put("targetLevel", 75);
			map.put("targetNum", 0);// 可领取次数
			map.put("info", yu9);
			map.put("canget", 0);
			mapjs.add(map);
			map.clear();

			map.put("targetLevel", 80);
			map.put("targetNum", 0);// 可领取次数
			map.put("info", yu10);
			map.put("canget", 0);
			mapjs.add(map);
			map.clear();

		}

		else {// 邀请的有好友

			/***
			 * 邀请好友不同等级的数量
			 * */
			JSONArray ids2 = JSONArray.fromObject(ids);

			Set set = new HashSet();
			for (int k = 0; k < ids2.size(); k++) {
				set.add(ids2.get(k));
			}
			ids2.clear();
			Iterator it = set.iterator();
			while (it.hasNext()) {
				ids2.add(it.next());
			}
			int num1 = 0;// 等级为10的数量
			int num2 = 0;// 等级为20的数量
			int num3 = 0;// 等级为30的数量
			int num4 = 0;// 等级为40的数量
			int num5 = 0;// 等级为50的数量
			int num6 = 0;// 等级为60的数量
			int num7 = 0;// 等级为65的数量
			int num8 = 0;// 等级为70的数量
			int num9 = 0;// 等级为75的数量
			int num10 = 0;// 等级为80的数量
			int level = 0;
			int x = 0;
			for (int i = 0; i < ids2.size(); i++) {
				// System.out.println(ids2.getInt(i)+"===============ids2.getInt(i)==============");
				int frid = ids2.getInt(i);
				GameRoleDetail gr = this.getGameRoleService()
						.findRoleById(frid);
				if (gr == null) {
					continue;
				}
				level = gr.getLevel();
				// System.out.println(level+"=====level==============");
				if (level > 9) {// 邀请成功条件设置为被邀请玩家达到10级
					if (level > 9) {// 等级为10
						num1++;
					}
					if (level > 19) {
						num2++;
					}
					if (level > 29) {
						num3++;
					}
					if (level > 39) {
						num4++;
					}
					if (level > 49) {
						num5++;
					}
					if (level > 59) {
						num6++;
					}
					if (level > 64) {
						num7++;
					}
					if (level > 69) {
						num8++;
					}
					if (level > 74) {
						num9++;
					}
					if (level > 79) {
						num10++;
					}

				}
			}
			/**
	    	 * **/

			String friendlevel = this.getGameRoleService().findRoleById(roleid)
					.getFriendlevel();
			List list = new ArrayList();
			JSONArray roleinfo = JSONArray.fromObject(friendlevel);
			/***
			 * 邀请的好友没有领取过奖励
			 * */
			if (roleinfo.size() == 0) {
				// System.out.println("没有领取过=================================");
				map.put("targetLevel", 10);
				map.put("targetNum", num1);// 可领取次数
				map.put("info", yu1);
				map.put("canget", num1);
				mapjs.add(map);
				map.clear();

				map.put("targetLevel", 20);// 等级领取
				map.put("targetNum", num2);// 可领取次数
				map.put("info", yu2);
				map.put("canget", num2);
				mapjs.add(map);
				map.clear();

				map.put("targetLevel", 30);
				map.put("targetNum", num3);// 可领取次数
				map.put("info", yu3);
				map.put("canget", num3);
				mapjs.add(map);
				map.clear();

				map.put("targetLevel", 40);
				map.put("targetNum", num4);// 可领取次数
				map.put("info", yu4);
				map.put("canget", num4);
				mapjs.add(map);
				map.clear();

				map.put("targetLevel", 50);
				map.put("targetNum", num5);// 可领取次数
				map.put("info", yu5);
				map.put("canget", num5);
				mapjs.add(map);
				map.clear();

				map.put("targetLevel", 60);
				map.put("targetNum", num6);// 可领取次数
				map.put("info", yu6);
				map.put("canget", num6);
				mapjs.add(map);
				map.clear();

				map.put("targetLevel", 65);
				map.put("targetNum", num7);// 可领取次数
				map.put("info", yu7);
				map.put("canget", num7);
				mapjs.add(map);
				map.clear();

				map.put("targetLevel", 70);
				map.put("targetNum", num8);// 可领取次数
				map.put("info", yu8);
				map.put("canget", num8);
				mapjs.add(map);
				map.clear();

				map.put("targetLevel", 75);
				map.put("targetNum", num9);// 可领取次数
				map.put("info", yu9);
				map.put("canget", num9);
				mapjs.add(map);
				map.clear();

				map.put("targetLevel", 80);
				map.put("targetNum", num10);// 可领取次数
				map.put("info", yu10);
				map.put("canget", num10);
				mapjs.add(map);
				map.clear();
			}
			/****/

			/***
			 * 邀请的好友领取过奖励
			 * */
			else {
				// System.out.println("邀请的好友领取过奖励===================");
				if (roleinfo.size() > 0) {
					for (int i = 0; i < roleinfo.size(); i++) {
						JSONArray ro = JSONArray.fromObject(roleinfo.get(i));
						if (ro.getInt(0) == 10) {
							num1 = num1 - ro.getInt(1);
						} else if (ro.getInt(0) == 20) {
							num2 = num2 - ro.getInt(1);
						} else if (ro.getInt(0) == 30) {
							num3 = num3 - ro.getInt(1);
						} else if (ro.getInt(0) == 40) {
							num4 = num4 - ro.getInt(1);
						} else if (ro.getInt(0) == 50) {
							num5 = num5 - ro.getInt(1);
						} else if (ro.getInt(0) == 60) {
							num6 = num6 - ro.getInt(1);
						} else if (ro.getInt(0) == 65) {
							num7 = num7 - ro.getInt(1);
						} else if (ro.getInt(0) == 70) {
							num8 = num8 - ro.getInt(1);
						} else if (ro.getInt(0) == 75) {
							num9 = num9 - ro.getInt(1);
						} else if (ro.getInt(0) == 80) {
							num10 = num10 - ro.getInt(1);
						}
					}
					if (num1 < 0) {
						num1 = 0;
					}
					if (num2 < 0) {
						num2 = 0;
					}
					if (num3 < 0) {
						num3 = 0;
					}
					if (num4 < 0) {
						num4 = 0;
					}
					if (num5 < 0) {
						num5 = 0;
					}
					if (num6 < 0) {
						num6 = 0;
					}
					if (num7 < 0) {
						num7 = 0;
					}
					if (num8 < 0) {
						num8 = 0;
					}
					if (num9 < 0) {
						num9 = 0;
					}
					if (num10 < 0) {
						num10 = 0;
					}

					map.put("targetLevel", 10);
					map.put("targetNum", num1);// 可领取次数
					map.put("info", yu1);
					map.put("canget", num1);
					mapjs.add(map);
					map.clear();

					map.put("targetLevel", 20);// 等级领取
					map.put("targetNum", num2);// 可领取次数
					map.put("info", yu2);
					map.put("canget", num2);
					mapjs.add(map);
					map.clear();

					map.put("targetLevel", 30);
					map.put("targetNum", num3);// 可领取次数
					map.put("info", yu3);
					map.put("canget", num3);
					mapjs.add(map);
					map.clear();

					map.put("targetLevel", 40);
					map.put("targetNum", num4);// 可领取次数
					map.put("info", yu4);
					map.put("canget", num4);
					mapjs.add(map);
					map.clear();

					map.put("targetLevel", 50);
					map.put("targetNum", num5);// 可领取次数
					map.put("info", yu5);
					map.put("canget", num5);
					mapjs.add(map);
					map.clear();

					map.put("targetLevel", 60);
					map.put("targetNum", num6);// 可领取次数
					map.put("info", yu6);
					map.put("canget", num6);
					mapjs.add(map);
					map.clear();

					map.put("targetLevel", 65);
					map.put("targetNum", num7);// 可领取次数
					map.put("info", yu7);
					map.put("canget", num7);
					mapjs.add(map);
					map.clear();

					map.put("targetLevel", 70);
					map.put("targetNum", num8);// 可领取次数
					map.put("info", yu8);
					map.put("canget", num8);
					mapjs.add(map);
					map.clear();

					map.put("targetLevel", 75);
					map.put("targetNum", num9);// 可领取次数
					map.put("info", yu9);
					map.put("canget", num9);
					mapjs.add(map);
					map.clear();

					map.put("targetLevel", 80);
					map.put("targetNum", num10);// 可领取次数
					map.put("info", yu10);
					map.put("canget", num10);
					mapjs.add(map);
					map.clear();
				} else {

					map.put("targetLevel", 10);
					map.put("targetNum", num1);// 可领取次数
					map.put("info", yu1);
					map.put("canget", num1);
					mapjs.add(map);
					map.clear();

					map.put("targetLevel", 20);// 等级领取
					map.put("targetNum", num2);// 可领取次数
					map.put("info", yu2);
					map.put("canget", num2);
					mapjs.add(map);
					map.clear();

					map.put("targetLevel", 30);
					map.put("targetNum", num3);// 可领取次数
					map.put("info", yu3);
					map.put("canget", num3);
					mapjs.add(map);
					map.clear();

					map.put("targetLevel", 40);
					map.put("targetNum", num4);// 可领取次数
					map.put("info", yu4);
					map.put("canget", num4);
					mapjs.add(map);
					map.clear();

					map.put("targetLevel", 50);
					map.put("targetNum", num5);// 可领取次数
					map.put("info", yu5);
					map.put("canget", num5);
					mapjs.add(map);
					map.clear();

					map.put("targetLevel", 60);
					map.put("targetNum", num6);// 可领取次数
					map.put("info", yu6);
					map.put("canget", num6);
					mapjs.add(map);
					map.clear();

					map.put("targetLevel", 65);
					map.put("targetNum", num7);// 可领取次数
					map.put("info", yu7);
					map.put("canget", num7);
					mapjs.add(map);
					map.clear();

					map.put("targetLevel", 70);
					map.put("targetNum", num8);// 可领取次数
					map.put("info", yu8);
					map.put("canget", num8);
					mapjs.add(map);
					map.clear();

					map.put("targetLevel", 75);
					map.put("targetNum", num9);// 可领取次数
					map.put("info", yu9);
					map.put("canget", num9);
					mapjs.add(map);
					map.clear();

					map.put("targetLevel", 80);
					map.put("targetNum", num10);// 可领取次数
					map.put("info", yu10);
					map.put("canget", num10);
					mapjs.add(map);
					map.clear();

				}
			}
			/****/

		}
		rlt.put("list", mapjs);
		// System.out.println(mapjs+"=========mapjs");
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);

		rlt = null;
	}

	private void friendrise() {
		/** 好友升级奖励 */
		if (params.containsKey("level")) {
			Map<String, Object> rlt = new HashMap<String, Object>();
			int roleid = Integer.parseInt(playerId);
			int level = Integer.parseInt(String.valueOf(params.get("level")));
			String friendlevel = this.getGameRoleService().findRoleById(roleid)
					.getFriendlevel();
			JSONArray roleinfo = JSONArray.fromObject(friendlevel);

			/****/
			int num = 0;
			String ids = this.getGameRoleService().findRoleById(roleid)
					.getIds();
			if (!"null".equals(String.valueOf(ids))) {//

				JsonSerializer json = new JsonSerializer();

				JSONArray ids2 = JSONArray.fromObject(ids);// 得到好友的Id

				Set set = new HashSet();
				for (int k = 0; k < ids2.size(); k++) {
					set.add(ids2.get(k));
				}
				ids2.clear();
				Iterator it = set.iterator();
				while (it.hasNext()) {
					ids2.add(it.next());
				}

				int size = ids2.size();
				if (level > 9) {
					for (int i = 0; i < size; i++) {
						int frid = ids2.getInt(i);
						GameRoleDetail gr = this.getGameRoleService()
								.findRoleById(frid);
						if (gr == null) {
							continue;
						}
						int fl = gr.getLevel();
						if (level <= fl) {// 邀请成功条件设置为被邀请玩家达到10级
							num++;
						}
					}
				}
			}
			/****/

			if (roleinfo.size() > 0) {// 玩家已经领取过
				int allnum = 0;// 总共可以领取
				int yilnum = 0;// 已经领取
				int a = 0;
				for (int i = 0; i < roleinfo.size(); i++) {
					JSONArray ro = JSONArray.fromObject(roleinfo.get(i));
					if (level == ro.getInt(0)) {
						a = 1;
						yilnum = ro.getInt(1);
						roleinfo.remove(i);
						break;

					}

				}
				if (a == 1) {// level等级的奖品玩家领取过
					rlt.put("targetNum", num - (yilnum + 1));
					if ((yilnum + 1) > num) {
						// 已领取完了
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-1);
						ServerHandler.sendData(session, respMap);
						return;
					} else {
						JSONArray list = new JSONArray();
						if (level > 9) {

							if (level == 10) {
								getLiveItem(roleid, 208, 1, 5, list);
							} else if (level == 20) {
								getLiveItem(roleid, 209, 1, 5, list);
							} else if (level == 30) {
								getLiveItem(roleid, 210, 1, 5, list);
							} else if (level == 40) {
								getLiveItem(roleid, 211, 1, 5, list);
							} else if (level == 50) {
								getLiveItem(roleid, 212, 1, 5, list);
							} else if (level == 60) {
								getLiveItem(roleid, 213, 1, 5, list);
							} else if (level == 65) {
								getLiveItem(roleid, 214, 1, 5, list);
							} else if (level == 70) {
								getLiveItem(roleid, 215, 1, 5, list);
							} else if (level == 75) {
								getLiveItem(roleid, 216, 1, 5, list);
							} else if (level == 80) {
								getLiveItem(roleid, 217, 1, 5, list);
							}
							rlt.put("reward", list);
							// 标记已领取
							JSONArray rol = new JSONArray();
							rol.add(level);
							rol.add(yilnum + 1);
							roleinfo.add(rol);
							Map<String, Object> param = new HashMap<String, Object>();
							param.put("id", roleid);
							param.put("friendlevel", roleinfo.toString());
							this.getGameRoleService().updateRoleVip(param);

						} else {// 等级不符合条件
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									-2);
							ServerHandler.sendData(session, respMap);
							return;
						}
					}

				} else {
					if (num == 0) {
						// 已领取完了
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-1);
						ServerHandler.sendData(session, respMap);
						return;
					}
					rlt.put("targetNum", num - 1);

					JSONArray list = new JSONArray();
					if (level > 9) {
						if (level == 10) {
							getLiveItem(roleid, 208, 1, 5, list);
						} else if (level == 20) {
							getLiveItem(roleid, 209, 1, 5, list);
						} else if (level == 30) {
							getLiveItem(roleid, 210, 1, 5, list);
						} else if (level == 40) {
							getLiveItem(roleid, 211, 1, 5, list);
						} else if (level == 50) {
							getLiveItem(roleid, 212, 1, 5, list);
						} else if (level == 60) {
							getLiveItem(roleid, 213, 1, 5, list);
						} else if (level == 65) {
							getLiveItem(roleid, 214, 1, 5, list);
						} else if (level == 70) {
							getLiveItem(roleid, 215, 1, 5, list);
						} else if (level == 75) {
							getLiveItem(roleid, 216, 1, 5, list);
						} else if (level == 80) {
							getLiveItem(roleid, 217, 1, 5, list);
						}
						rlt.put("reward", list);
						// 标记已领取
						JSONArray rol = new JSONArray();
						rol.add(level);
						rol.add(1);
						roleinfo.add(rol);
						Map<String, Object> param = new HashMap<String, Object>();
						param.put("id", roleid);
						param.put("friendlevel", roleinfo.toString());
						this.getGameRoleService().updateRoleVip(param);
					}
				}

			}

			else {// 玩家从来没有领取过
				JSONArray list = new JSONArray();
				if (level > 9) {
					if (num == 0) {
						// 已领取完了
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-1);
						ServerHandler.sendData(session, respMap);
						return;
					}

					rlt.put("targetNum", num - 1);

					if (level == 10) {
						getLiveItem(roleid, 208, 1, 5, list);
					} else if (level == 20) {
						getLiveItem(roleid, 209, 1, 5, list);
					} else if (level == 30) {
						getLiveItem(roleid, 210, 1, 5, list);
					} else if (level == 40) {
						getLiveItem(roleid, 211, 1, 5, list);
					} else if (level == 50) {
						getLiveItem(roleid, 212, 1, 5, list);
					} else if (level == 60) {
						getLiveItem(roleid, 213, 1, 5, list);
					} else if (level == 65) {
						getLiveItem(roleid, 214, 1, 5, list);
					} else if (level == 70) {
						getLiveItem(roleid, 215, 1, 5, list);
					} else if (level == 75) {
						getLiveItem(roleid, 216, 1, 5, list);
					} else if (level == 80) {
						getLiveItem(roleid, 217, 1, 5, list);
					}
					rlt.put("reward", list);
					// 标记已领取
					JSONArray rol = new JSONArray();
					rol.add(level);
					rol.add(1);
					roleinfo.add(rol);
					Map<String, Object> param = new HashMap<String, Object>();
					param.put("id", roleid);
					param.put("friendlevel", roleinfo.toString());
					this.getGameRoleService().updateRoleVip(param);

				} else {// 等级不符合条件
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
					ServerHandler.sendData(session, respMap);
					return;
				}
			}

			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
			rlt = null;
		}

	}

	private void allfriend() {
		/** 要求的所有好友 */
		int roleid = Integer.parseInt(playerId);
		Map<String, Object> rlt = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		JSONArray js = new JSONArray();
		int friendnum = 0;
		String ids = this.getGameRoleService().findRoleById(roleid).getIds();
		if (!"null".equals(String.valueOf(ids))) {//

			JsonSerializer json = new JsonSerializer();
			JSONArray ids2 = JSONArray.fromObject(ids);// 得到好友的Id
			Set set = new HashSet();
			for (int k = 0; k < ids2.size(); k++) {
				set.add(ids2.get(k));
			}
			ids2.clear();
			Iterator it = set.iterator();
			while (it.hasNext()) {
				ids2.add(it.next());
			}

			int size = ids2.size();
			for (int i = 0; i < size; i++) {
				int frid = ids2.getInt(i);
				GameRoleDetail grd = this.getGameRoleService().findRoleById(
						frid);
				if (grd == null) {
					continue;
				}
				int level = grd.getLevel();
				if (level > 9) {// 邀请成功条件设置为被邀请玩家达到10级
					String name = grd.getName();// 好友名字
					int costqd = grd.getCoinspend();// 消耗的Q点数
					// String serverid=grd.getServerid();
					map.put("name", name);
					map.put("num", costqd);
					map.put("level", level);
					map.put("server", grd.getServerId());
					js.add(map);
					map.clear();
					friendnum++;
				}

			}
			// if(friendnum==0){
			// System.out.println();
			// System.out.println("没有好友");
			// map.put("name",null);
			// map.put("num", null);
			// map.put("level",null);
			// map.put("server",null);
			// js.add(map);
			// map.clear();
			// }

		}
		// else{
		// map.put("name",null);
		// map.put("num", null);
		// map.put("level",null);
		// map.put("server",null);
		// js.add(map);
		// map.clear();
		// }
		rlt.put("friends", js);
		rlt.put("friendnum", friendnum);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);
		rlt = null;

	}

	private void openmidexist() {
		int roleId = Integer.parseInt(playerId);
		Map<String, Object> rlt = new HashMap<String, Object>();
		GameRoleDetail gameRole = this.getGameRoleService()
				.findRoleById(roleId);
		if (gameRole == null) {
			return;
		}
		rlt.put("exist", gameRole.getExist());
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);
		rlt = null;
		gameRole = null;
	}

	private void midexist() {
		if (params.containsKey("t")) {
			int roleId = Integer.parseInt(playerId);
			Map<String, Object> rlt = new HashMap<String, Object>();
			Map<String, Object> param = new HashMap<String, Object>();
			int t = Integer.parseInt(String.valueOf(params.get("t")));
			JSONArray list = new JSONArray();
			// 判断活动是否已过期
			param.clear();
			param.put("id", 2);
			List<HostDetail> host = this.getHostService()
					.findHostByParam(param);
			if (host.isEmpty()) {// 活动已过期
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
				ServerHandler.sendData(session, respMap);
				return;
			} else {
				Calendar calendar = Calendar.getInstance();
				int month = calendar.get(Calendar.MONTH) + 1;
				int today = calendar.get(Calendar.DAY_OF_MONTH);
				if (month >= host.get(0).getMonth()
						&& month <= host.get(0).getMonthend()
						&& today >= host.get(0).getDay()
						&& today <= (host.get(0).getDayend() + 2)) {

				} else {
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
					ServerHandler.sendData(session, respMap);
					return;
				}
			}
			if (t == 1) {
				List<RoleMilitaryDetail> roleMili = this
						.getRoleMilitaryService().getRoleMilitarytime(4029,
								roleId);
				if (roleMili.isEmpty()) {// 武将不存在
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
					ServerHandler.sendData(session, respMap);
					return;
				} else {

					GameRoleDetail gameRole = this.getGameRoleService()
							.findRoleById(roleId);
					if (gameRole == null) {
						return;
					}
					String exist = gameRole.getExist();
					if (exist.indexOf("1") == -1) {
						String res = host.get(0).getRes1();
						List<Map> resList = JSON.parseArray(res, Map.class);
						int id = 0;
						int num = 0;
						int type = 0;
						for (int i = 0; i < resList.size(); i++) {
							id = Integer.parseInt(String.valueOf(resList.get(i)
									.get("id")));
							num = Integer.parseInt(String.valueOf(resList
									.get(i).get("num")));
							type = Integer.parseInt(String.valueOf(resList.get(
									i).get("resType")));
							this.getplayerHandler().getItem(roleId, id, num,
									type, list);
						}
						// 标记已领取
						param.clear();
						param.put("id", roleId);
						param.put("exist", exist + "1");
						this.getGameRoleService().updateRoleVip(param);
					}
					gameRole = null;
				}
			} else if (t == 2) {
				List<RoleMilitaryDetail> roleMili = this
						.getRoleMilitaryService().getRoleMilitarytime(5017,
								roleId);
				if (roleMili.isEmpty()) {// 武将不存在
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
					ServerHandler.sendData(session, respMap);
					return;
				} else {

					GameRoleDetail gameRole = this.getGameRoleService()
							.findRoleById(roleId);
					if (gameRole == null) {
						return;
					}
					String exist = gameRole.getExist();
					if (exist.indexOf("2") == -1) {
						String res = host.get(0).getRes2();
						List<Map> resList = JSON.parseArray(res, Map.class);
						int id = 0;
						int num = 0;
						int type = 0;
						for (int i = 0; i < resList.size(); i++) {
							id = Integer.parseInt(String.valueOf(resList.get(i)
									.get("id")));
							num = Integer.parseInt(String.valueOf(resList
									.get(i).get("num")));
							type = Integer.parseInt(String.valueOf(resList.get(
									i).get("resType")));
							this.getplayerHandler().getItem(roleId, id, num,
									type, list);
						}
						// 标记已领取
						param.clear();
						param.put("id", roleId);
						param.put("exist", exist + "2");
						this.getGameRoleService().updateRoleVip(param);
					}
					gameRole = null;
				}
			} else if (t == 3) {
				// System.out.println(t+"...........t");
				List<RoleMilitaryDetail> roleMili = this
						.getRoleMilitaryService().getRoleMilitarytime(4029,
								roleId);
				if (roleMili.isEmpty()) {// 武将不存在
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
					ServerHandler.sendData(session, respMap);
					return;
				} else {
					roleMili = this.getRoleMilitaryService()
							.getRoleMilitarytime(5017, roleId);
					if (roleMili.isEmpty()) {// 武将不存在
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-1);
						ServerHandler.sendData(session, respMap);
						return;
					}

					GameRoleDetail gameRole = this.getGameRoleService()
							.findRoleById(roleId);
					if (gameRole == null) {
						return;
					}
					String exist = gameRole.getExist();
					if (exist.indexOf("3") == -1) {
						String res = host.get(0).getReses();
						List<Map> resList = JSON.parseArray(res, Map.class);
						int id = 0;
						int num = 0;
						int type = 0;
						for (int i = 0; i < resList.size(); i++) {
							id = Integer.parseInt(String.valueOf(resList.get(i)
									.get("id")));
							num = Integer.parseInt(String.valueOf(resList
									.get(i).get("num")));
							type = Integer.parseInt(String.valueOf(resList.get(
									i).get("resType")));
							this.getplayerHandler().getItem(roleId, id, num,
									type, list);
						}
						// 标记已领取
						param.clear();
						param.put("id", roleId);
						param.put("exist", exist + "3");
						this.getGameRoleService().updateRoleVip(param);
					}
					gameRole = null;
				}
				roleMili = null;
			}
			rlt.put("reward", list);
			rlt.put("t", t);
			rlt.put("exist", this.getGameRoleService().findRoleById(roleId)
					.getExist());
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
			rlt = null;
			param = null;
			list = null;
		}
	}

	private void buyvip() {

		if (params.containsKey("payitem")) {
			// System.out.println("buyvip...");
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
			if (id == 92) {
				coin = 0;
			} else {
				// coin = coin*num;
				coin = 0;
			}
			List<GameItemDetail> ritem = this.getGameItemService()
					.getGameItemById(id);
			if (ritem.isEmpty()) {
				return;
			}
			int type = ritem.get(0).getItemtype();

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
				boolean b = this.getplayerHandler().getShangxian(type, resType,
						roleId, id, num);
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
							int vip = this.getGameRoleService()
									.findRoleById(roleId).getVip();
							// 消费的总金币
							int coinspendz = this.getGameRoleService()
									.findRoleById(roleId).getCoinspend();
							// 跟模型表里面进行比较看看能到达哪个等级
							int Nvip = this.getGameVipService()
									.getGameVipByAllvipRmb(coinspendz).get(0)
									.getVipLevel();
							int cha = this.getGameVipService()
									.getGameVipByLe(Nvip).get(0).getVipRmb()
									- coinspendz;
							rlt.put("cha", cha);
							if (Nvip > vip) {
								// 更改用户的vip等级
								Map<String, Object> paramv = new HashMap<String, Object>();
								paramv.put("id", roleId);
								paramv.put("vip", Nvip);
								this.getGameRoleService().updateRoleVip(paramv);
								SimpleDateFormat sdf = new SimpleDateFormat(
										"yyyy-MM-dd HH:mm:ss");
								String now = sdf.format(new Date());
								paramv.clear();
								paramv.put("id", roleId);
								paramv.put("viptime", now);
								boolean boq = this.getGameRoleService()
										.updateRoleVipGiftTime(paramv);
								// 给前端发送数据
								Map<String, Object> rlt1 = new HashMap<String, Object>();
								rlt1.put("vip", Nvip);
								Map<String, Object> res = new HashMap<String, Object>();
								res.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
										GameConstants.GAME_API_SUCCESS);
								res.put(GameConstants.GAME_API_RESPONSE_FIELD_ACTPID,
										roleId);
								res.put(GameConstants.GAME_API_RESPONSE_FIELD_CMD,
										"sys.viplevelup");
								res.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
										rlt1);
								ServerHandler.sendDataByRoleId(res, roleId);
								res.clear();
								rlt1.clear();
								// 系统公告//发送广播
//								String message = "玩家 <font color=\"#FF0000\">"
//										+ role.getName()
//										+ "</font>的VIP等级提升到了 <font color=\"#FFFF00\"><b>"
//										+ role.getVip() + "</b></font>";
////								GameConstants.log.warn("Military.buyItems:"
////										+ message);
//								this.getsystemHandler().addMessage(message);
								UtilHandler util = new UtilHandler();
								String name2 = role.getName();
								int vip2 = role.getVip();
								String where = "累计消费";
								int pinzhi = 6;//金色
								String goodsName = "尊贵称号: VIP"+vip2;
								util.sendGetMessage(name2, vip2, where, pinzhi, goodsName,"militart_vip upgrade");

								rlt1.put("vip", Nvip);
								rlt1.put("info", "购买");
								rlt1.put("place", 1);
								// 添加黄钻信息
								JsonSerializer json = new JsonSerializer();
								String Huangzuaninfo = this
										.getGameRoleService()
										.findRoleById(roleId)
										.getHuangzuaninfo();
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
										rlt1.put("yellowviplevel", roleinfo
												.get(0).get("yellow_vip_level"));
										rlt1.put(
												"isyellowyearsvip",
												roleinfo.get(0).get(
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
//									res.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
//											GameConstants.GAME_API_SUCCESS);
//									res.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
//											rlt1);
//									res.put(GameConstants.GAME_API_RESPONSE_FIELD_CMD,
//											"sys.send");
//									// ServerHandler.sendDataByRoleId(res,
//									// status.get(i).getId());
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
					// System.out.println("判断是否有任务，及是否完成");
					Map<String, Object> paramW = new HashMap<String, Object>();
					paramW.put("roleid", roleId);
					paramW.put("type", 4);
					List<RoleTaskTaskDetail> listW = this
							.getRoleTaskTaskService().findRoleTaskBytype0(
									paramW);
					// System.out.println(listW.size()+".........size");
					for (int i = 0; i < listW.size(); i++) {
						if (listW.get(i).getTasklevel() == id) {
							Map<String, Object> paramI = new HashMap<String, Object>();
							paramI.put("roleid", roleId);
							paramI.put("taskid", listW.get(i).getTaskid());
							paramI.put("progress", 1);
							// System.out.println(listW.get(i).getTaskid());
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

	private void buyItems() {
		// System.out.println("MilitaryHandler.buyItems()");
		if (params.containsKey("payitem")) {
			int roleId = Integer.parseInt(playerId);
			String payitem = String.valueOf(params.get("payitem"));// ID*price*num
			// 获取购买信息
			List<MemberDetail> member = this.getMemberService().findMemberByid(
					roleId);
			String openid = "";
			String serverid = "";
			if (!member.isEmpty()) {
				openid = member.get(0).getUsername();
				serverid = member.get(0).getServerId();
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("openid", openid);
				param.put("serverid", serverid);
				List<DeliveryDetail> delivery = this.getDeliveryService()
						.findeDeliveryByList(param);
				if (!delivery.isEmpty()) {
					if (delivery.get(0).getStatus() == 0) {
						System.out.println("非法购买！！");
						GameConstants.log.info("illegal trade！！roleid:"
								+ roleId);
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
			if (id == 281 || id == 282 || id == 283) {
				GameRoleDetail gameRole = this.getGameRoleService()
						.findRoleById(roleId);
				String buyitem = gameRole.getBuyitem();
				JSONArray ary = JSONArray.fromObject(buyitem);
				JSONArray list = new JSONArray();
				if (ary.getInt(0) == 1 && ary.getInt(1) == 1
						&& ary.getInt(2) == 1) {
					return;
				}
				if (id == 281) {// 281 282 283
					ary.set(1, 1);
					id = 13;
				}
				if (id == 282) {
					ary.set(2, 1);
					id = 73;
				}
				if (id == 283) {
					ary.set(0, 1);
					id = 12;
				}
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("id", roleId);
				param.put("buyitem", ary.toString());
				this.getGameRoleService().updatebuyitem(param);
			}
			JSONArray list11 = new JSONArray();
			if (id == 119 || id == 120 || id == 121 || id == 122 || id == 123) {

			} else if (id == 320) {// 购买的新手成长基金，不放进背包
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("id", roleId);
				param.put("fundsstatu", 2);
				this.getGameRoleService().updateRoleVip(param);
			} else {
				this.getplayerHandler().getItem(roleId, id, num, 5, list11);
			}
			list11.clear();
			List<GameItemDetail> ritem = this.getGameItemService()
					.getGameItemById(id);
			int daycoin = coin * num;// 记录每日消费q点
			if (id == 92) {
				coin = 0;
			} else {
				coin = 0;
			}
			if (ritem.isEmpty()) {
				return;
			}
			int type = ritem.get(0).getItemtype();
			int resType = 5;
			int isover = 0;
			Map<String, Object> rlt = new HashMap<String, Object>();
			Map<String, Object> paramp = new HashMap<String, Object>();
			paramp.put("resType", resType);
			paramp.put("resId", id);
			List<GamePriceDetail> list = this.getGamePriceService()
					.getGamePrice(paramp);
			if (!list.isEmpty()) {
				GameRoleDetail role = this.getGameRoleService().findRoleById(
						roleId);
				boolean b = this.getplayerHandler().getShangxian(type, resType,
						roleId, id, num);
				if (b == true) {
					if (list.get(0).getCostType() == 1) {
					} else {
						Map<String, Object> paramc = new HashMap<String, Object>();
						paramc.put("id", roleId);
						paramc.put("coinspend", coin);
						boolean boo = this.getGameRoleService()
								.addRolecoinspend(paramc);
						if (boo == true) {
							// 获取人物VIP等级
							int vip = this.getGameRoleService()
									.findRoleById(roleId).getVip();
							// 消费的总金币
							int coinspendz = this.getGameRoleService()
									.findRoleById(roleId).getCoinspend();
							// 跟模型表里面进行比较看看能到达哪个等级
							int Nvip = this.getGameVipService()
									.getGameVipByAllvipRmb(coinspendz).get(0)
									.getVipLevel();
							int cha = this.getGameVipService()
									.getGameVipByLe(Nvip).get(0).getVipRmb()
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
								res.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
										GameConstants.GAME_API_SUCCESS);
								res.put(GameConstants.GAME_API_RESPONSE_FIELD_ACTPID,
										roleId);
								res.put(GameConstants.GAME_API_RESPONSE_FIELD_CMD,
										"sys.viplevelup");
								res.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
										rlt1);
								ServerHandler.sendDataByRoleId(res, roleId);
								res.clear();
								rlt1.clear();
								// 系统公告//发送广播
								UtilHandler util = new UtilHandler();
								String name2 = role.getName();
								int vip2 = role.getVip();
								String where = "累计消费";
								int pinzhi = 6;//金色
								String goodsName = "尊贵称号: VIP"+vip2;
								util.sendGetMessage(name2, vip2, where, pinzhi, goodsName,"militart_vip upgrade");

								rlt1.put("vip", Nvip);
								rlt1.put("info", "购买");
								rlt1.put("place", 1);
								// 添加黄钻信息
								JsonSerializer json = new JsonSerializer();
								String Huangzuaninfo = this
										.getGameRoleService()
										.findRoleById(roleId)
										.getHuangzuaninfo();
								if ("null"
										.equals(String.valueOf(Huangzuaninfo))) {
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
										rlt1.put("isyellowvip", roleinfo.get(0)
												.get("is_yellow_vip"));
										rlt1.put("yellowviplevel", roleinfo
												.get(0).get("yellow_vip_level"));
										rlt1.put(
												"isyellowyearsvip",
												roleinfo.get(0).get(
														"is_yellow_year_vip"));
									} else {
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
//									res.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
//											GameConstants.GAME_API_SUCCESS);
//									res.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
//											rlt1);
//									res.put(GameConstants.GAME_API_RESPONSE_FIELD_CMD,
//											"sys.send");
//									// ServerHandler.sendDataByRoleId(res,
//									// status.get(i).getId());
//								}
							}
						}
					}
					Map<String, Object> items = new HashMap<String, Object>();
					// 判断是否购买的是元宝
					if (id == 119 || id == 120 || id == 121 || id == 122
							|| id == 123) {
						// 只增加coin
						if (ritem.isEmpty()) {
							return;
						}
						rlt.put("items", items);
					} else if (id == 320) {
						if (ritem.isEmpty()) {
							return;
						}
						rlt.put("items", items);
					} else {
						// 道具信息
						Map<String, Object> param = new HashMap<String, Object>();
						param.put("roleid", roleId);
						param.put("itemid", id);
						List<RoleItemDetail> item = this.getRoleItemService()
								.getRoleItem(param);
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
						param = null;
						item = null;
						listW = null;
					}
					Map<String, Object> money = new HashMap<String, Object>();
					GameRoleDetail r = this.getGameRoleService().findRoleById(
							roleId);
					money.put("yin", r.getYin());
					money.put("coin", r.getCoin());
					rlt.put("money", money);
					JSONArray byle = JSONArray.fromObject(r.getBylevel());
					rlt.put("bylevel", byle);
					rlt.put("coinspend", this.getGameRoleService()
							.findRoleById(roleId).getCoinspend());
					rlt.put("consume", coin);// 本次消费的金币数
					GameRoleDetail gameRole = this.getGameRoleService()
							.findRoleById(roleId);
					Map<String, Object> rlt1 = new HashMap<String, Object>();
					rlt1.put("items", items);
					rlt1.put("coin", gameRole.getCoin());
					rlt1.put("coinspend", gameRole.getCoinspend());
					rlt1.put("yin", gameRole.getYin());
					rlt1.put("buy", 1);
					rlt1.put("id", id);
					this.getsystemHandler().pacMes(rlt1, roleId);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
					ServerHandler.sendData(session, respMap);
					items = null;
					byle = null;
					rlt = null;
					rlt1 = null;
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
			// 记录活动信息
			// 活动记录购买数量
			System.out.println("活动记录购买数量");
			param.clear();
			param.put("type", 1);
			List<ActivityDetail> activity = this.getActivityService()
					.getActivityByParams(param);
			if (!activity.isEmpty()) {
				Calendar calendar = Calendar.getInstance();
				int month0 = calendar.get(Calendar.MONTH) + 1;
				int day0 = calendar.get(Calendar.DAY_OF_MONTH);
				int month = activity.get(0).getMonth();
				int day = activity.get(0).getDay();
				int monthend = activity.get(0).getMonthend();
				int dayend = activity.get(0).getDayend();
				int status = 0;
				if(month!=monthend){
					if(month0>=month && month0<=monthend){
						if(month0==month){
							if(day0>=day){
								status = 1;
							}
						}else if(month0==monthend){
							if(day0<=dayend){
								status = 1;
							}
						}else if(month0!=month&&month0!=monthend){
							status = 1;
						}
					}
				}
				if(month == monthend){
					if(day0>=day&&day0<=dayend){
						status = 1;
					}
				}
				
				if (status == 1) {// 记录数量
					System.out.println("开始记录");
					param.clear();
					param.put("roleid", roleId);
					param.put("itemid", id);
					List<RoleItemDetail> item = this.getRoleItemService()
							.getRoleItem(param);
					if (item.size() != 0 && activity.size() != 0) {
						if (item.get(0).getIsnew() != activity.get(0)
								.getIsnew()) {
							param.clear();
							param.put("isnew", activity.get(0).getIsnew());
							param.put("roleid", roleId);
							param.put("itemid", id);
							param.put("activitynum", num);
							this.getRoleItemService().updateRoleItemByParams(
									param);
						} else {// 增加
							param.clear();
							param.put("roleid", roleId);
							param.put("itemid", id);
							param.put("activitynum", item.get(0)
									.getActivitynum() + num);
							this.getRoleItemService().updateRoleItemByParams(
									param);
						}
					} else {
						GameConstants.log
								.warn("MilitaryHandler.buyItems:nullPointException:item.size:"
										+ item.size()
										+ " activity.size():"
										+ activity.size()
										+ " param:"
										+ param.toString());
					}
					item = null;
				}
			}
			// 判断是否是活动第一次购买
			param.clear();
			param.put("type", 3);
			System.out.println("进入type3");
			activity = this.getActivityService().getActivityByParams(param);
			if (!activity.isEmpty()) {
				Calendar calendar = Calendar.getInstance();
				int month0 = calendar.get(Calendar.MONTH) + 1;
//				System.out.println(month0);//4
				int day0 = calendar.get(Calendar.DAY_OF_MONTH);
//				System.out.println(day0);//3
				int month = activity.get(0).getMonth();
//				System.out.println(month);//3
				int day = activity.get(0).getDay();
//				System.out.println(day);//1
				int monthend = activity.get(0).getMonthend();
//				System.out.println(monthend);//4
				int dayend = activity.get(0).getDayend();
//				System.out.println(dayend);//31
				int status = 0;
//				if (month == month0 && month0 == monthend) {
//					if (day0 >= day && day0 <= dayend) {
//						status = 1;
//					}
//				} else if (month0 >= month && month0 < monthend) {
//					// 不用判断day
//					status = 1;
//				}
				if(month!=monthend){
					if(month0>=month && month0<=monthend){
						if(month0==month){
							if(day0>=day){
								status = 1;
							}
						}else if(month0==monthend){
							if(day0<=dayend){
								status = 1;
							}
						}else if(month0!=month&&month0!=monthend){
							status = 1;
						}
					}
				}
				if(month == monthend){
					if(day0>=day&&day0<=dayend){
						status = 1;
					}
				}
				
				if (status == 1) {
					param.clear();
					param.put("id", roleId);
					param.put("daycoin", daycoin);
//					System.out.println("开始修改每日消费");
					this.getGameRoleService().updateRoleVip(param);
				}
			}
			activity = null;
			param = null;
			// 判断是否有任务完成
			this.getTaskHandler().taskcomplete(roleId);
//			System.out.println("购买方法完毕");
		}
	}

	private void useyaopai() {
		if (params.containsKey("t")) {
			int t = Integer.parseInt(String.valueOf(params.get("t")));
			int roleid = Integer.parseInt(playerId);
			Map<String, Object> rlt = new HashMap<String, Object>();
			Map<String, Object> param = new HashMap<String, Object>();
			if(params.containsKey("number")){
				int number = Integer.parseInt(String.valueOf(params.get("number")));
				if (t == 1) {// 使用妖牌战斗
					// 判断新的一天使用妖牌数量更新0
					GameRoleDetail gamerole = this.getGameRoleService()
							.findRoleById(roleid);
					long nowtime = new Date().getTime();
					int day = (int) ((nowtime - gamerole.getTasktime()) / 1000 / 60
							/ 60 / 24 + 1);
					if (day > gamerole.getDay()) {// 新的一天，dailynum应设为0，day增加1，今天还没有领取礼包
						if (day > this.getRoleTaskService().findRoleTask(roleid)
								.get(0).getDay()) {
							param.clear();
							param.put("roleId", roleid);
							param.put("dailynum", 0);
							param.put("day", day);
							param.put("status", 1);
							this.getRoleTaskService().updateRoleTasknumday(param);
						}
	
						// 恢复妖牌为0
	
						// 标记今天上线，将今天的放到昨天
						JSONArray ary = new JSONArray();
						Map<String, Object> pp = new HashMap<String, Object>();
						pp.put("day", day);
						ary.add(pp);
						param.clear();
						param.put("id", roleid);
						param.put("day", day);
						param.put("num", 0);
						param.put("yesterday", gamerole.getToday());
						param.put("today", ary.toString());
						param.put("live", 0);// 好友活跃度奖励
						param.put("huangzuangift", 0);// 黄钻礼包
						this.getGameRoleService().updateRoleVip(param);
						pp = null;
					}
					gamerole = this.getGameRoleService().findRoleById(roleid);
					// 判断使用妖牌是否达到上限
					int vip = gamerole.getVip();
					int gnum = gamerole.getNum();
					int ypnumtop = this.getGameVipService().getGameVipByLe(vip)
							.get(0).getDhjlTop();
					if (gnum < ypnumtop) {// 可以使用妖牌
//						System.out.println("兑换军令次数:"+gnum);
//						System.out.println("兑换军令上限"+ypnumtop);
						if(gnum + number <= ypnumtop){
							param.clear();
							param.put("roleid", roleid);
							param.put("itemid", 1);
							List<RoleItemDetail> role = this.getRoleItemService()
									.getRoleItem(param);
							// System.out.println("////////////////////////////////////////////////////////////");
							if (role.isEmpty()) {
								respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
										-2);
								ServerHandler.sendData(session, respMap);
								return;
							}
							int ypnum = role.get(0).getNum();
							// .....
							int canuseypnum = 0;
							for (int i = 0; i < number; i++) {
								if(((gnum + 2) / 2) < 10){
									canuseypnum += (gnum + 2) / 2;
								}else{
									canuseypnum += 10;
								}
								gnum ++;
							}
//							System.out.println("兑换次数:"+number);
//							System.out.println("拥有腰牌数量:"+ypnum);
//							System.out.println("消耗腰牌数量"+canuseypnum);
//							System.out.println("应该剩余腰牌数量"+(ypnum-canuseypnum));
							if (ypnum >= canuseypnum) {// 可以使用
								param.clear();
								param.put("roleid", roleid);
								param.put("itemid", 1);
								param.put("num", canuseypnum);
								this.getRoleItemService().subRoleItem(param);// 减少妖牌
								
								// 增加军令,和num
								param.clear();
								param.put("id", roleid);
								param.put("num", gnum);
								param.put("junling", number);
								this.getGameRoleService().updateRoleVip(param);
//								System.out.println("拥有腰牌数量:"+role.get(0).getNum());
								List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
								param.clear();
								param.put("bid", role.get(0).getId());
								// param.put("id", 1);
								// param.put("resType", 5);
								param.put("num", ypnum - canuseypnum);
								rlt.put("item", param);
								rlt.put("junling", number);
							} else {// 妖牌数量不足
								respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
										-2);
								ServerHandler.sendData(session, respMap);
								return;
							}
						}else{//兑换数量超过兑换上限
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
							ServerHandler.sendData(session, respMap);
							return;
						}
					} else {// 今天妖牌使用上限已达最大
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
						ServerHandler.sendData(session, respMap);
						return;
					}
				} else {// 军令不足，返回给客户端数据
					int ypnum = this.getGameRoleService().findRoleById(roleid)
							.getNum();
					rlt.put("ypnum", ypnum);
					rlt.put("ypnums", (ypnum + 2) / 2);
				}
				rlt.put("t", t);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
				rlt = null;
				param = null;
			
			}else{
				if (t == 1) {// 使用妖牌战斗
					// 判断新的一天使用妖牌数量更新0
					GameRoleDetail gamerole = this.getGameRoleService()
							.findRoleById(roleid);
					long nowtime = new Date().getTime();
					int day = (int) ((nowtime - gamerole.getTasktime()) / 1000 / 60
							/ 60 / 24 + 1);
					if (day > gamerole.getDay()) {// 新的一天，dailynum应设为0，day增加1，今天还没有领取礼包
						if (day > this.getRoleTaskService().findRoleTask(roleid)
								.get(0).getDay()) {
							param.clear();
							param.put("roleId", roleid);
							param.put("dailynum", 0);
							param.put("day", day);
							param.put("status", 1);
							this.getRoleTaskService().updateRoleTasknumday(param);
						}
	
						// 恢复妖牌为0
	
						// 标记今天上线，将今天的放到昨天
						JSONArray ary = new JSONArray();
						Map<String, Object> pp = new HashMap<String, Object>();
						pp.put("day", day);
						ary.add(pp);
						param.clear();
						param.put("id", roleid);
						param.put("day", day);
						param.put("num", 0);
						param.put("yesterday", gamerole.getToday());
						param.put("today", ary.toString());
						param.put("live", 0);// 好友活跃度奖励
						param.put("huangzuangift", 0);// 黄钻礼包
						this.getGameRoleService().updateRoleVip(param);
						pp = null;
					}
					gamerole = this.getGameRoleService().findRoleById(roleid);
					// 判断使用妖牌是否达到上限
					int vip = gamerole.getVip();
					int gnum = gamerole.getNum();
					int ypnumtop = this.getGameVipService().getGameVipByLe(vip)
							.get(0).getDhjlTop();
					if (gnum < ypnumtop) {// 可以使用妖牌
						param.clear();
						param.put("roleid", roleid);
						param.put("itemid", 1);
						List<RoleItemDetail> role = this.getRoleItemService()
								.getRoleItem(param);
						// System.out.println("////////////////////////////////////////////////////////////");
						if (role.isEmpty()) {
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									-2);
							ServerHandler.sendData(session, respMap);
							return;
						}
						int ypnum = role.get(0).getNum();
						// .....
						if (ypnum >= (gnum + 1) / 2) {// 可以使用
							param.clear();
							param.put("roleid", roleid);
							param.put("itemid", 1);
							param.put("num", (gnum + 2) / 2);
							this.getRoleItemService().subRoleItem(param);// 减少妖牌
							// 增加军令,和num
							param.clear();
							param.put("id", roleid);
							param.put("num", gnum + 1);
							param.put("junling", 1);
							this.getGameRoleService().updateRoleVip(param);
							List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
							param.clear();
							param.put("bid", role.get(0).getId());
							// param.put("id", 1);
							// param.put("resType", 5);
							param.put("num", role.get(0).getNum() - (gnum + 2) / 2);
							rlt.put("item", param);
							rlt.put("junling", 1);
	
						} else {// 妖牌数量不足
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									-2);
							ServerHandler.sendData(session, respMap);
							return;
						}
					} else {// 今天妖牌使用上限已达最大
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
						ServerHandler.sendData(session, respMap);
						return;
					}
				} else {// 军令不足，返回给客户端数据
					int ypnum = this.getGameRoleService().findRoleById(roleid)
							.getNum();
					rlt.put("ypnum", ypnum);
//					rlt.put("ypnums", (ypnum + 2) / 2);
					rlt.put("t", 0);
				}
				
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
				rlt = null;
				param = null;
			}
		}
	}

	private void promotion() {
		if (params.containsKey("id")) {
			int id = NumberUtils
					.createInteger(String.valueOf(params.get("id")));
			int roleid = Integer.parseInt(playerId);
			Map<String, Object> rlt = new HashMap<String, Object>();
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id", id);
			param.put("roleId", roleid);
			List<RoleMilitaryDetail> military = this.getRoleMilitaryService()
					.getRoleMilitaryByparam(param);
			if (military.isEmpty()) {
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -4);
				ServerHandler.sendData(session, respMap);
				return;
			}
			RoleMilitaryDetail rmilitary = military.get(0);
			int mtype = rmilitary.getType();// 类型
			int mtypes = rmilitary.getTypes();// 初中终
			int mlevel = rmilitary.getLevel();
			int gongxun = this.getGameRoleService().findRoleById(roleid)
					.getGongxun();
			if (mtypes == 1) {// 可以升中级
				// 判断武将大于10级
				if (mlevel >= 10) {// 可以升级
					// 判断功勋
					param.clear();
					param.put("type", mtype);
					param.put("level", 10);
					List<GameChLevelDetail> ch = this.getGameChLevelService()
							.findGameChLevelByparas(param);
					int ggongxun = ch.get(0).getGongxun();
					if (gongxun >= ggongxun) {// 可以晋级
						// 减少功勋，增加types+1
						this.getGameRoleService().subRoleGongxun(roleid,
								ggongxun);
						param.clear();
						param.put("id", id);
						param.put("roleId", roleid);
						param.put("types", (mtypes + 1));
						this.getRoleMilitaryService().updateRoleMilitary(param);
						rlt.put("id", id);
						rlt.put("types", (mtypes + 1));
						rlt.put("gongxun", (gongxun - ggongxun));
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								GameConstants.GAME_API_SUCCESS);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
								rlt);
						ServerHandler.sendData(session, respMap);
					} else {// 功勋不足
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-1);
						ServerHandler.sendData(session, respMap);
						return;
					}
				} else {// 等级不够
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
					ServerHandler.sendData(session, respMap);
					return;
				}
			} else if (mtypes == 2) {// 可以升终级
				if (mlevel >= 25) {// 可以升级
					// 判断功勋
					param.clear();
					param.put("type", mtype);
					param.put("level", 25);
					int ggongxun = this.getGameChLevelService()
							.findGameChLevelByparas(param).get(0).getGongxun();
					if (gongxun >= ggongxun) {// 可以晋级
						// 减少功勋，增加types+1
						this.getGameRoleService().subRoleGongxun(roleid,
								ggongxun);
						param.clear();
						param.put("id", id);
						param.put("roleId", roleid);
						param.put("types", (mtypes + 1));
						this.getRoleMilitaryService().updateRoleMilitary(param);
						rlt.put("id", id);
						rlt.put("types", (mtypes + 1));
						rlt.put("gongxun", (gongxun - ggongxun));
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								GameConstants.GAME_API_SUCCESS);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
								rlt);
						ServerHandler.sendData(session, respMap);
					} else {// 功勋不足
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-1);
						ServerHandler.sendData(session, respMap);
						return;
					}
				} else {// 等级不够
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
					ServerHandler.sendData(session, respMap);
					return;
				}
			} else if (mtypes == 3) {
				if (mlevel >= 45) {// 可以升级
					// 判断功勋
					param.clear();
					param.put("type", mtype);
					param.put("level", 45);
					int ggongxun = this.getGameChLevelService()
							.findGameChLevelByparas(param).get(0).getGongxun();
					if (gongxun >= ggongxun) {// 可以晋级
						// 减少功勋，增加types+1
						this.getGameRoleService().subRoleGongxun(roleid,
								ggongxun);
						param.clear();
						param.put("id", id);
						param.put("roleId", roleid);
						param.put("types", (mtypes + 1));
						this.getRoleMilitaryService().updateRoleMilitary(param);
						rlt.put("id", id);
						rlt.put("types", (mtypes + 1));
						rlt.put("gongxun", (gongxun - ggongxun));
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								GameConstants.GAME_API_SUCCESS);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
								rlt);
						ServerHandler.sendData(session, respMap);
					} else {// 功勋不足
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-1);
						ServerHandler.sendData(session, respMap);
						return;
					}
				} else {// 等级不够
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
					ServerHandler.sendData(session, respMap);
					return;
				}
			} else if (mtypes == 4) {// 升级已达最大，不可以升级了
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);
				ServerHandler.sendData(session, respMap);
				return;
			}
			rlt = null;
			param = null;
		}
	}

	private void fire() {
		// System.out.println("Militarty。fire（）：");
		if (params.containsKey("id")) {
			int id = NumberUtils
					.createInteger(String.valueOf(params.get("id")));
			int roleid = Integer.parseInt(playerId);
//			System.out.println("roleid=" + roleid);
			Map<String, Object> rlt = new HashMap<String, Object>();
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id", id);
			param.put("roleId", roleid);
			// System.out.println("param:" + param.toString());
			RoleMilitaryDetail rmilitary = this.getRoleMilitaryService()
					.getRoleMilitaryByparam(param).get(0);
			// int mid = rmilitary.getMilitaryid();
			int wuqi = rmilitary.getWuqi();
			int huwan = rmilitary.getHuwan();
			int yifu = rmilitary.getYifu();
			int touguan = rmilitary.getTouguan();
			int xiezi = rmilitary.getXiezi();
			int shipin = rmilitary.getShipin();
			// System.out.println("pp:" +
			// (wuqi==0&&huwan==0&&yifu==0&&touguan==0&&xiezi==0&&shipin==0));
			if (wuqi == 0 && huwan == 0 && yifu == 0 && touguan == 0
					&& xiezi == 0 && shipin == 0) {// 可以解雇武将
				int size = this.getRoleMilitaryService()
						.getRoleMilitary(roleid).size();
				if (size > 1) {// 可以解雇武将
					// 将出战列表的武将也解雇了
					param.clear();
					param.put("roleid", roleid);
					// System.out.println("param44:" + param.toString());

					List<RoleChallengeDetail> challenge = this
							.getRoleChallengeService().findRoleChallengeById(
									param);
					// System.out.println("dd:" + !challenge.isEmpty());
					if (!challenge.isEmpty()) {
						JsonSerializer json = new JsonSerializer();
						List mids = (List) json.deserialize(challenge.get(0)
								.getMilitaryid());
						for (int i = 0; i < mids.size(); i++) {
							if (id == Integer.parseInt(String.valueOf(mids
									.get(i)))) {
								mids.remove(i);
								break;
							}
						}
						param.clear();
						param.put("roleid", roleid);
						param.put("militaryid", String.valueOf(mids));
						// System.out.println("paramaa:" + param.toString());

						this.getRoleChallengeService().updateRoleChallenge(
								param);
					}
					// r_m删除武将
					param.clear();
					param.put("id", id);
					param.put("roleId", roleid);
					int militaryid = this.getRoleMilitaryService()
							.getRoleMilitaryById(id).getMilitaryid();
					this.getRoleMilitaryService().deleteRoleMilitary(param);
					// r_map判断有没有mid，有了将其id更新0
					param.clear();
					param.put("roleId", roleid);
					param.put("militaryid", id);// 数据id
					// System.out.println("paramee:" + param.toString());
					// 增加玩家的魔魂
					int change = this.getGameMilitaryService()
							.getGameMilitaryBymid(militaryid).get(0)
							.getMohunchange();
					this.getGameRoleService()
							.findRoleById(roleid)
							.setMohun(
									this.getGameRoleService()
											.findRoleById(roleid).getMohun()
											+ change);
					List<RoleMapDetail> mapmilitary = this.getRoleMapService()
							.getRoleMapByParam(param);
					if (!mapmilitary.isEmpty()) {// 不为空，将mid=0
						for (int i = 0; i < mapmilitary.size(); i++) {
							int mapid = mapmilitary.get(i).getId();
							param.clear();
							param.put("id", mapid);
							param.put("roleId", roleid);
							param.put("militaryid", 0);
							boolean bo = this.getRoleMapService()
									.updateRoleMap(param);
							// System.out.println("bo=="+bo);
						}
					}
					rlt.put("id", id);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
				} else {// 不可以解雇，就剩一个了
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
				}
			} else {// 不可以解雇武将
				// TODO
				List test = this.getRoleMilitaryService()
						.getRoleMilitaryByMilitaryId(id);// test代表根据武将ID获得有几个武将
															// 用来测试重复数据
				if (test.size() > 1) {
					// 可以解雇武将
					int size = this.getRoleMilitaryService()
							.getRoleMilitary(roleid).size();

					if (size > 1) {// 可以解雇武将
						/** 强制卸装 */
						System.out.println("重复数据的武将  强制卸装删除逻辑开始---roleId:" + roleid+"militaryid="+rmilitary.getId());

						wuqi = rmilitary.getWuqi();
						// System.out.println("强制卸装,装备ID为:"+wuqi);
						param.clear();
						param.put("id", wuqi);
						if (this.getRoleEquipService().getRoleEquip(param)
								.isEmpty()) {
							// System.out.println("什么也管不管");
						} else {
							this.getRoleEquipService().getRoleEquip(param)
									.get(0).setUser("0");
						}

						touguan = rmilitary.getTouguan();
						// System.out.println("强制卸装,装备ID为:"+touguan);
						param.clear();
						param.put("id", touguan);
						if (this.getRoleEquipService().getRoleEquip(param)
								.isEmpty()) {
							// System.out.println("什么也管不管");
						} else {
							this.getRoleEquipService().getRoleEquip(param)
									.get(0).setUser("0");
						}

						yifu = rmilitary.getYifu();
						// System.out.println("强制卸装,装备ID为:"+yifu);
						param.clear();
						param.put("id", yifu);
						if (this.getRoleEquipService().getRoleEquip(param)
								.isEmpty()) {
							// System.out.println("什么也管不管");
						} else {
							this.getRoleEquipService().getRoleEquip(param)
									.get(0).setUser("0");
						}

						huwan = rmilitary.getHuwan();
						// System.out.println("强制卸装,装备ID为:"+huwan);
						param.clear();
						param.put("id", huwan);
						if (this.getRoleEquipService().getRoleEquip(param)
								.isEmpty()) {
							// System.out.println("什么也管不管");
						} else {
							this.getRoleEquipService().getRoleEquip(param)
									.get(0).setUser("0");
						}

						xiezi = rmilitary.getXiezi();
						// System.out.println("强制卸装,装备ID为:"+xiezi);
						param.clear();
						param.put("id", xiezi);
						if (this.getRoleEquipService().getRoleEquip(param)
								.isEmpty()) {
							// System.out.println("什么也管不管");
						} else {
							this.getRoleEquipService().getRoleEquip(param)
									.get(0).setUser("0");
						}

						shipin = rmilitary.getShipin();
						// System.out.println("强制卸装,装备ID为:"+shipin);
						param.clear();
						param.put("id", shipin);
						if (this.getRoleEquipService().getRoleEquip(param)
								.isEmpty()) {
							// System.out.println("什么也管不管");
						} else {
							this.getRoleEquipService().getRoleEquip(param)
									.get(0).setUser("0");
						}

						// 将出战列表的武将也解雇了
						param.clear();
						param.put("roleid", roleid);
						List<RoleChallengeDetail> challenge = this
								.getRoleChallengeService()
								.findRoleChallengeById(param);
						// System.out.println("dd:" + !challenge.isEmpty());
						if (!challenge.isEmpty()) {
							JsonSerializer json = new JsonSerializer();
							List mids = (List) json.deserialize(challenge
									.get(0).getMilitaryid());
							for (int i = 0; i < mids.size(); i++) {
								if (id == Integer.parseInt(String.valueOf(mids
										.get(i)))) {
									mids.remove(i);
									break;
								}
							}
							param.clear();
							param.put("roleid", roleid);
							param.put("militaryid", String.valueOf(mids));
							// System.out.println("paramaa:" +
							// param.toString());

							this.getRoleChallengeService().updateRoleChallenge(
									param);
						}
						// r_m删除武将
						param.clear();
						param.put("id", id);
						param.put("roleId", roleid);
						int militaryid = this.getRoleMilitaryService()
								.getRoleMilitaryById(id).getMilitaryid();
						this.getRoleMilitaryService().deleteRoleMilitary(param);
						// r_map判断有没有mid，有了将其id更新0
						param.clear();
						param.put("roleId", roleid);
						param.put("militaryid", id);// 数据id
						// System.out.println("paramee:" + param.toString());
						// 增加玩家的魔魂
						int change = this.getGameMilitaryService()
								.getGameMilitaryBymid(militaryid).get(0)
								.getMohunchange();
						this.getGameRoleService()
								.findRoleById(roleid)
								.setMohun(
										this.getGameRoleService()
												.findRoleById(roleid)
												.getMohun()
												+ change);
						List<RoleMapDetail> mapmilitary = this
								.getRoleMapService().getRoleMapByParam(param);
						if (!mapmilitary.isEmpty()) {// 不为空，将mid=0
							for (int i = 0; i < mapmilitary.size(); i++) {
								int mapid = mapmilitary.get(i).getId();
								param.clear();
								param.put("id", mapid);
								param.put("roleId", roleid);
								param.put("militaryid", 0);
								boolean bo = this.getRoleMapService()
										.updateRoleMap(param);
								// System.out.println("bo=="+bo);
							}
						}
						rlt.put("id", id);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								GameConstants.GAME_API_SUCCESS);
					} else {// 不可以解雇，就剩一个了
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-2);
					}
				} else {
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
				}
			}
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
			rlt = null;
			param = null;
		}
	}

	private void changeequips() {
		if (params.containsKey("t") && params.containsKey("bid")
				&& params.containsKey("mid")) {
			Map<String, Object> rlt = new HashMap<String, Object>();
			int t = NumberUtils.createInteger(String.valueOf(params.get("t")));// 装备还是卸装
			int bid = NumberUtils.createInteger(String.valueOf(params
					.get("bid")));
			int id = NumberUtils
					.createInteger(String.valueOf(params.get("mid")));
			int roleid = Integer.parseInt(playerId);
			Map<String, Object> param = new HashMap<String, Object>();
			// mid是前端传来的roleMilitary数据Id bid是用户装备表的数据id
			// System.out.println("魔将装备前端传来的mid::::"+id);
			param.put("id", bid);
			param.put("roleId", roleid);
			List<RoleEquipDetail> requip = this.getRoleEquipService()
					.getRoleEquipDetail(param);

			if (requip.isEmpty()) {// 装备不存在
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -5);
				ServerHandler.sendData(session, respMap);
				return;
			}
			int eid = requip.get(0).getEquipId();
			int user = Integer.parseInt(requip.get(0).getUser());// 武将id
			GameEquipDetail gequip = this.getGameEquipService()
					.getGameEquipById(eid).get(0);

			int glevel = gequip.getLevel();// 模型装备等级
			int etype = gequip.getEquiptype();// 谁可以穿戴，1的话只能武将type=1的才能穿
			int type = gequip.getType();// 判断是什么装备，衣服等
			param.clear();
			param.put("roleId", roleid);
			param.put("id", id);
			List<RoleMilitaryDetail> rmilitary = this.getRoleMilitaryService()
					.getRoleMilitaryByparam(param);
			if (rmilitary.isEmpty()) {// 魔将不存在
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -4);
				ServerHandler.sendData(session, respMap);
				return;
			} else {// 魔将存在

			}
			int mid = rmilitary.get(0).getMilitaryid();// 重设mid
			int mlevel = rmilitary.get(0).getLevel();
			List<GameMilitaryDetail> gmilitary = this.getGameMilitaryService()
					.getGameMilitaryBymid(mid);
			int mtype = gmilitary.get(0).getType();
			List<RoleMilitaryDetail> military = this.getRoleMilitaryService()
					.getRoleMilitarytime(mid, roleid);
			// mid roleid
			if (t == 1) {// 装备
				// 判断模型装备等级是否大于武将等级
				if (mlevel >= glevel) {// 等级够了，可以装备上
					if (etype == 1) {// 装备type=1的只能被武将type=1的使用
						if (etype == mtype) {// 此武将可以穿戴,武将和装备type都是1
							// 判断user是否已在装备中
							if (user == 0) {// 可以换装
								// 将user更新
								// param.clear();
								// param.put("id", bid);
								// param.put("user", id);
								// boolean bo =
								// this.getRoleEquipService().updateRoleEquipById(param);
								// 将id更新到武将表中
								RoleMilitaryDetail role = this
										.getRoleMilitaryService()
										.getRoleMilitarytime(mid, roleid)
										.get(0);
								if (type == 1) {// 武器
									// 判断该类型的是否已装备了，若是调换一下
									int wuqi = role.getWuqi();
									if (wuqi == 0) {// 没有装备呢
										rlt.put("oldid", 0);
									} else {// 已装备了，换一下，将此id的roleequip的user=0
										param.clear();
										param.put("user", 0);
										param.put("id", wuqi);
										this.getRoleEquipService()
												.updateRoleEquipById(param);
										rlt.put("oldid", wuqi);
									}
									param.clear();
									param.put("roleId", roleid);
									param.put("militaryid", mid);
									param.put("wuqi", bid);
									this.getRoleMilitaryService()
											.updateRoleMilitary(param);
								} else if (type == 2) {// 衣服
									int yifu = role.getYifu();
									if (yifu == 0) {// 没有装备呢
										rlt.put("oldid", 0);
									} else {// 已装备了，换一下，将此id的roleequip的user=0
										param.clear();
										param.put("user", 0);
										param.put("id", yifu);
										this.getRoleEquipService()
												.updateRoleEquipById(param);
										rlt.put("oldid", yifu);
									}
									param.clear();
									param.put("roleId", roleid);
									param.put("militaryid", mid);
									param.put("yifu", bid);
									this.getRoleMilitaryService()
											.updateRoleMilitary(param);
								} else if (type == 3) {// 护腕
									int huwan = role.getHuwan();
									if (huwan == 0) {// 没有装备呢
										rlt.put("oldid", 0);
									} else {// 已装备了，换一下，将此id的roleequip的user=0
										param.clear();
										param.put("user", 0);
										param.put("id", huwan);
										this.getRoleEquipService()
												.updateRoleEquipById(param);
										rlt.put("oldid", huwan);
									}
									param.clear();
									param.put("roleId", roleid);
									param.put("militaryid", mid);
									param.put("huwan", bid);
									this.getRoleMilitaryService()
											.updateRoleMilitary(param);
								} else if (type == 4) {// 鞋子
									int xiezi = role.getXiezi();
									if (xiezi == 0) {// 没有装备呢
										rlt.put("oldid", 0);
									} else {// 已装备了，换一下，将此id的roleequip的user=0
										param.clear();
										param.put("user", 0);
										param.put("id", xiezi);
										this.getRoleEquipService()
												.updateRoleEquipById(param);
										rlt.put("oldid", xiezi);
									}
									param.clear();
									param.put("roleId", roleid);
									param.put("militaryid", mid);
									param.put("xiezi", bid);
									this.getRoleMilitaryService()
											.updateRoleMilitary(param);
								} else if (type == 5) {// 头冠
									int touguan = role.getTouguan();
									if (touguan == 0) {// 没有装备呢
										rlt.put("oldid", 0);
									} else {// 已装备了，换一下，将此id的roleequip的user=0
										param.clear();
										param.put("user", 0);
										param.put("id", touguan);
										this.getRoleEquipService()
												.updateRoleEquipById(param);
										rlt.put("oldid", touguan);
									}
									param.clear();
									param.put("roleId", roleid);
									param.put("militaryid", mid);
									param.put("touguan", bid);
									this.getRoleMilitaryService()
											.updateRoleMilitary(param);
								} else if (type == 6) {// 法宝 饰品
									int shipin = role.getShipin();
									if (shipin == 0) {// 没有装备呢
										rlt.put("oldid", 0);
									} else {// 已装备了，换一下，将此id的roleequip的user=0
										param.clear();
										param.put("user", 0);
										param.put("id", shipin);
										this.getRoleEquipService()
												.updateRoleEquipById(param);
										rlt.put("oldid", shipin);
									}
									param.clear();
									param.put("roleId", roleid);
									param.put("militaryid", mid);
									param.put("shipin", bid);
									this.getRoleMilitaryService()
											.updateRoleMilitary(param);
								}
								param.clear();
								param.put("id", bid);
								param.put("user", id);
								boolean bo = this.getRoleEquipService()
										.updateRoleEquipById(param);
							} else {// 已使用了，user不等于0，已装备，不可以换装
								respMap.put(
										GameConstants.GAME_API_RESPONSE_FIELD_CODE,
										-1);
								ServerHandler.sendData(session, respMap);
								return;
							}
						} else {// 类型不对，不可以装备上
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									-2);
							ServerHandler.sendData(session, respMap);
							return;
						}
					} else {// 装备type不等于1............
						if (mtype == 1) {// 类型不匹配，不可以装备上
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									-2);
							ServerHandler.sendData(session, respMap);
							return;
						} else {// 可以装备上
							// 判断user是否已在装备中
							if (user == 0) {// 可以换装
								// 将user更新
								param.clear();
								param.put("id", bid);
								param.put("user", id);
								boolean bo = this.getRoleEquipService()
										.updateRoleEquipById(param);
								// 将id更新到武将表中
								RoleMilitaryDetail role = this
										.getRoleMilitaryService()
										.getRoleMilitarytime(mid, roleid)
										.get(0);
								if (type == 1) {// 武器
									// 判断该类型的是否已装备了，若是调换一下
									int wuqi = role.getWuqi();
									if (wuqi == 0) {// 没有装备呢
										rlt.put("oldid", 0);
									} else {// 已装备了，换一下，将此id的roleequip的user=0
										param.clear();
										param.put("user", 0);
										param.put("id", wuqi);
										this.getRoleEquipService()
												.updateRoleEquipById(param);
										rlt.put("oldid", wuqi);
									}
									param.clear();
									param.put("roleId", roleid);
									param.put("militaryid", mid);
									param.put("wuqi", bid);
									this.getRoleMilitaryService()
											.updateRoleMilitary(param);
								} else if (type == 2) {// 衣服
									int yifu = role.getYifu();
									if (yifu == 0) {// 没有装备呢
										rlt.put("oldid", 0);
									} else {// 已装备了，换一下，将此id的roleequip的user=0
										param.clear();
										param.put("user", 0);
										param.put("id", yifu);
										this.getRoleEquipService()
												.updateRoleEquipById(param);
										rlt.put("oldid", yifu);
									}
									param.clear();
									param.put("roleId", roleid);
									param.put("militaryid", mid);
									param.put("yifu", bid);
									this.getRoleMilitaryService()
											.updateRoleMilitary(param);
								} else if (type == 3) {// 护腕
									int huwan = role.getHuwan();
									if (huwan == 0) {// 没有装备呢
										rlt.put("oldid", 0);
									} else {// 已装备了，换一下，将此id的roleequip的user=0
										param.clear();
										param.put("user", 0);
										param.put("id", huwan);
										this.getRoleEquipService()
												.updateRoleEquipById(param);
										rlt.put("oldid", huwan);
									}
									param.clear();
									param.put("roleId", roleid);
									param.put("militaryid", mid);
									param.put("huwan", bid);
									this.getRoleMilitaryService()
											.updateRoleMilitary(param);
								} else if (type == 4) {// 鞋子
									int xiezi = role.getXiezi();
									if (xiezi == 0) {// 没有装备呢
										rlt.put("oldid", 0);
									} else {// 已装备了，换一下，将此id的roleequip的user=0
										param.clear();
										param.put("user", 0);
										param.put("id", xiezi);
										this.getRoleEquipService()
												.updateRoleEquipById(param);
										rlt.put("oldid", xiezi);
									}
									param.clear();
									param.put("roleId", roleid);
									param.put("militaryid", mid);
									param.put("xiezi", bid);
									this.getRoleMilitaryService()
											.updateRoleMilitary(param);
								} else if (type == 5) {// 头冠
									int touguan = role.getTouguan();
									if (touguan == 0) {// 没有装备呢
										rlt.put("oldid", 0);
									} else {// 已装备了，换一下，将此id的roleequip的user=0
										param.clear();
										param.put("user", 0);
										param.put("id", touguan);
										this.getRoleEquipService()
												.updateRoleEquipById(param);
										rlt.put("oldid", touguan);
									}
									param.clear();
									param.put("roleId", roleid);
									param.put("militaryid", mid);
									param.put("touguan", bid);
									this.getRoleMilitaryService()
											.updateRoleMilitary(param);
								} else if (type == 6) {// 法宝 饰品
									int shipin = role.getShipin();
									if (shipin == 0) {// 没有装备呢
										rlt.put("oldid", 0);
									} else {// 已装备了，换一下，将此id的roleequip的user=0
										param.clear();
										param.put("user", 0);
										param.put("id", shipin);
										this.getRoleEquipService()
												.updateRoleEquipById(param);
										rlt.put("oldid", shipin);
									}
									param.clear();
									param.put("roleId", roleid);
									param.put("militaryid", mid);
									param.put("shipin", bid);
									this.getRoleMilitaryService()
											.updateRoleMilitary(param);
								}

							} else {// 已使用了，user不等于0，已装备，不可以换装
								respMap.put(
										GameConstants.GAME_API_RESPONSE_FIELD_CODE,
										-1);
								ServerHandler.sendData(session, respMap);
								return;
							}
						}
					}
				} else {// 等级不足，不可以装备
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);
					ServerHandler.sendData(session, respMap);
					return;
				}
			} else {// 卸下装备

				// 判断格子是否已满
				int vip = this.getGameRoleService().findRoleById(roleid)
						.getVip();
				GameVipDetail gvip = this.getGameVipService()
						.getGameVipByLe(vip).get(0);
				int backtop = gvip.getBackTop();// 最多放几个
				param.clear();
				param.put("roleId", roleid);
				param.put("user", 0);
				List<RoleEquipDetail> re = this.getRoleEquipService()
						.getRoleEquip(param);
				if (re.size() >= backtop) {// 格子已满，不可以卸下装备
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -6);
					ServerHandler.sendData(session, respMap);
					return;
				} else {

				}

				RoleMilitaryDetail role = this.getRoleMilitaryService()
						.getRoleMilitarytime(mid, roleid).get(0);
				if (type == 1) {// 武器
					// 判断该类型的是否已装备了，若是调换一下
					int wuqi = role.getWuqi();
					if (wuqi == 0) {// 没有装备呢

					} else {// 已装备了，换一下，将此id的roleequip的user=0
						param.clear();
						param.put("user", 0);
						param.put("id", wuqi);
						this.getRoleEquipService().updateRoleEquipById(param);
					}
					param.clear();
					param.put("roleId", roleid);
					param.put("militaryid", mid);
					param.put("wuqi", 0);
					this.getRoleMilitaryService().updateRoleMilitary(param);
					rlt.put("oldid", wuqi);
				} else if (type == 2) {// 衣服
					int yifu = role.getYifu();
					if (yifu == 0) {// 没有装备呢

					} else {// 已装备了，换一下，将此id的roleequip的user=0
						param.clear();
						param.put("user", 0);
						param.put("id", yifu);
						this.getRoleEquipService().updateRoleEquipById(param);
					}
					param.clear();
					param.put("roleId", roleid);
					param.put("militaryid", mid);
					param.put("yifu", 0);
					this.getRoleMilitaryService().updateRoleMilitary(param);
					rlt.put("oldid", yifu);
				} else if (type == 3) {// 护腕
					int huwan = role.getHuwan();
					if (huwan == 0) {// 没有装备呢

					} else {// 已装备了，换一下，将此id的roleequip的user=0
						param.clear();
						param.put("user", 0);
						param.put("id", huwan);
						this.getRoleEquipService().updateRoleEquipById(param);

					}
					param.clear();
					param.put("roleId", roleid);
					param.put("militaryid", mid);
					param.put("huwan", 0);
					this.getRoleMilitaryService().updateRoleMilitary(param);
					rlt.put("oldid", huwan);
				} else if (type == 4) {// 鞋子
					int xiezi = role.getXiezi();
					if (xiezi == 0) {// 没有装备呢

					} else {// 已装备了，换一下，将此id的roleequip的user=0
						param.clear();
						param.put("user", 0);
						param.put("id", xiezi);
						this.getRoleEquipService().updateRoleEquipById(param);
					}
					param.clear();
					param.put("roleId", roleid);
					param.put("militaryid", mid);
					param.put("xiezi", 0);
					this.getRoleMilitaryService().updateRoleMilitary(param);
					rlt.put("oldid", xiezi);
				} else if (type == 5) {// 头冠
					int touguan = role.getTouguan();
					if (touguan == 0) {// 没有装备呢

					} else {// 已装备了，换一下，将此id的roleequip的user=0
						param.clear();
						param.put("user", 0);
						param.put("id", touguan);
						this.getRoleEquipService().updateRoleEquipById(param);
					}
					param.clear();
					param.put("roleId", roleid);
					param.put("militaryid", mid);
					param.put("touguan", 0);
					this.getRoleMilitaryService().updateRoleMilitary(param);
					rlt.put("oldid", touguan);
				} else if (type == 6) {// 法宝 饰品
					int shipin = role.getShipin();
					if (shipin == 0) {// 没有装备呢

					} else {// 已装备了，换一下，将此id的roleequip的user=0
						param.clear();
						param.put("user", 0);
						param.put("id", shipin);
						this.getRoleEquipService().updateRoleEquipById(param);
					}
					param.clear();
					param.put("roleId", roleid);
					param.put("militaryid", mid);
					param.put("shipin", 0);
					this.getRoleMilitaryService().updateRoleMilitary(param);
					rlt.put("oldid", shipin);
				}
			}

			rlt.put("bid", bid);
			rlt.put("t", t);
			rlt.put("mid", id);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
			rlt = null;
			param = null;
		}
	}

	private void addjunling() {
		Map<String, Object> rlt = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		int id = Integer.parseInt(playerId);
		GameRoleDetail gr = this.getGameRoleService().findRoleById(id);
		int vip = gr.getVip();
		// 黄钻享受vip2待遇
		if (vip < 2) {
			int huangzuan = 0;
			JsonSerializer json = new JsonSerializer();
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
		List<GameVipDetail> gamevip = this.getGameVipService().getGameVipByLe(
				vip);
		int maxjl = gamevip.get(0).getJunlingTop();// 最大军令数
		int maxnum = gamevip.get(0).getChallengTop();// 最大挑战令

		int num = gr.getJunling();// 获得军令数
		int cnum = gr.getChallengenum();// 挑战令

		// 诛仙令
		if (gr.getZhuxianling() < gamevip.get(0).getZhuxianTop()) {
			long hour = (System.currentTimeMillis() - gr.getZxtime()) / 1000 / 60 / 60;
			long h = gamevip.get(0).getHour();
			if (hour >= h) {
				int zx = (int) (hour / h);
				if ((zx + gr.getZhuxianling()) >= gamevip.get(0)
						.getZhuxianTop()) {
					param.clear();
					param.put("id", id);
					param.put("zhuxianling", gamevip.get(0).getZhuxianTop());
					this.getGameRoleService().updateRoleVip(param);
				} else {
					if (zx > 0) {
						long t = System.currentTimeMillis() - (hour - h * zx)
								* 1000 * 60 * 60;
						param.clear();
						param.put("id", id);
						param.put("zxtime", t);
						param.put("zhuxianling", gr.getZhuxianling() + zx);
						this.getGameRoleService().updateRoleVip(param);
					}
				}
			}
		}
		// 争霸令
		if (cnum <= maxnum) {// 挑战令小于10
			long time = gr.getChallengetime();
			long nowtime = new Date().getTime();
			long h = (nowtime - time);
			int hour = (int) (h / 1000 / 60 / 60);// 军令累计了多少小时
			if (hour >= 1) {//
				if ((hour + cnum) >= maxnum) {// 大于10
					param.clear();
					param.put("id", id);
					param.put("challengenum", maxnum);
					this.getGameRoleService().updateRoleVip(param);
					rlt.put("challenge", maxnum);
				} else {// 没有达到最大
					param.clear();
					param.put("id", id);
					param.put("challengenum", (hour + cnum));
					param.put("challengetime",
							(gr.getChallengetime() + (hour * 60 * 60 * 1000)));
					this.getGameRoleService().updateRoleVip(param);
					rlt.put("challenge", (hour + cnum));
				}
			} else {// 没有到1小时
				rlt.put("challenge", cnum);
			}
		} else {// 挑战令大于10
			rlt.put("challenge", cnum);
		}
		// ............下面是军令

		if (num <= maxjl) {// 军令小于15
			long time = gr.getJltime();
			long nowtime = new Date().getTime();
			long h = (nowtime - time);
			int hour = (int) (h / 1000 / 60 / 60);// 军令累计了多少小时
			if (hour >= 1) {// 过了一小时
				if ((hour + num) >= maxjl) {// 大于15
					this.getGameRoleService().addRolejunling(id, maxjl);
					this.getGameRoleService().addRolejunlingtime(id, nowtime);
					rlt.put("junling", maxjl);
				} else {// 累计时间加上num不大于15
					this.getGameRoleService().addRolejunling(id, (num + hour));
					if (h == 0) {
						this.getGameRoleService().addRolejunlingtime(id,
								nowtime);
						rlt.put("junling", num);
					} else {
						this.getGameRoleService().addRolejunlingtime(id,
								(time + hour * 60 * 60 * 1000));
						rlt.put("junling", (num + hour));
					}
				}
			} else {// 累计时间不到一小时
				rlt.put("junling", num);
			}
		} else {// 军令大于15
			rlt.put("junling", num);
		}
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);
		rlt = null;
		param = null;
		gr = null;
		gamevip = null;
	}

	private void gemestart() {
		// System.out.println("战斗开始：");
		// long a =System.currentTimeMillis();
		Map<String, Object> rlt = new HashMap<String, Object>();
		int id = Integer.parseInt(playerId);
		GameRoleDetail gr = this.getGameRoleService().findRoleById(id);
		int num = gr.getJunling();// 获得军令数
		int vip = gr.getVip();
		zhandou(session, id);
		// 更新每日任务
		long nowtime = System.currentTimeMillis();
		int day = (int) ((nowtime - gr.getTasktime()) / 1000 / 60 / 60 / 24 + 1);
		RoleDaytaskDetail roledaytask = this.getRoleDaytaskService()
				.findRoleDaytaskByRId(id);
		if (roledaytask.getDay() < day) {
			this.getplayerHandler().dayTask(id, day);
		}
		roledaytask = null;

		// 黄钻享受vip2待遇
		if (vip < 2) {
			int huangzuan = 0;
			JsonSerializer json = new JsonSerializer();
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

		int jlnum = this.getGameVipService().getGameVipByLe(vip).get(0)
				.getJunlingTop();
		// 军令=15时，开始没小时增加一个军令倒计时
		if (num == jlnum) {
			this.getGameRoleService().addRolejunlingtime(id,
					(new Date().getTime()));
		}
		if (num > 0) {// 军令数够，可以开始游戏
			// 开始游戏，军令数减少1
			// 减少军令放到战斗结束领取奖励
			boolean bo = this.getGameRoleService().subRolejunling(id, 1);
			if (bo == true) {// 减少军令成功
				GameRoleDetail gamerole = this.getGameRoleService()
						.findRoleById(id);
				num = gamerole.getJunling();// 获得军令数
				rlt.put("junling", num);
				// 将signjl=1,可以领取战后道具
				int signjl = gamerole.getSignjl();
				if (signjl != 1) {
					Map<String, Object> param = new HashMap<String, Object>();
					param.put("id", id);
					param.put("signjl", 1);
					this.getGameRoleService().updateRoleVip(param);
					param = null;
				}
				// 查询是否有战斗任务
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("roleid", id);
				param.put("tasktype", 17);
				List<RoleTaskTaskDetail> list = this.getRoleTaskTaskService()
						.findRoleTask0(param);
				// System.out.println("list_____________________isEmpty:" +
				// list.isEmpty());
				if (!list.isEmpty()) {
					param.clear();
					param.put("num", 1);
					param.put("tasktype", 17);
					param.put("roleid", id);
					this.getRoleTaskTaskService().updateRoleTaskNum(param);
					// 任务提示
					this.getTaskHandler().taskcomplete(id);
					param = null;
				}
				// System.out.println("military:gamestart返回:" + rlt.toString());
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);

			} else {// 减少军令不成功
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "");
				ServerHandler.sendData(session, respMap);
			}
			Map<String, Object> pa = new HashMap<String, Object>();
			RoleDaytaskDetail roletask = this.getRoleDaytaskService()
					.findRoleDaytaskByRId(id);
			int zhangdou = roletask.getZhangdou();
			int abc = zhangdou + 1;
			pa.clear();
			pa.put("roleid", id);
			pa.put("zhangdou", abc);
			this.getRoleDaytaskService().updateRoleDaytask(pa);
			pa = null;
			// Map<String,Object> param = new HashMap<String,Object>();
			// param.put("equipId", 1);
			// param.put("roleId", id);
			// List<RoleEquipDetail> list=
			// this.getRoleEquipService().getRoleEquipByEquipId(param);
		} else {// 军令数小于1，不可以开始游戏
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
			ServerHandler.sendData(session, respMap);
		}
		// long b=System.currentTimeMillis();
		// System.out.println("开始战斗结束花费时间："+(b-a));
		rlt = null;
	}

	private void getmilitarys() {
		int roleid = Integer.parseInt(playerId);
		// this.getxiulianHandler().computexl(roleid);
		List<RoleMilitaryDetail> rolem = this.getRoleMilitaryService()
				.getRoleMilitary(roleid);
		Map<String, Object> rlt = new HashMap<String, Object>();
		// 看看修炼是不是终结
		JSONArray lists = new JSONArray();
		// 获得冷却时间
		Map<String, Object> param1 = new HashMap<String, Object>();// 存放冷却时间
		param1.put("roleid", roleid);
		List<RoleQuicktimeDetail> quick = this.getRoleQuicktimeService()
				.getQuicktime(param1);
		if (quick.isEmpty()) {// 数据表为空
			// 插入数据就行，不用判断
			RoleQuicktimeDetail detail = new RoleQuicktimeDetail();
			detail.setRoleid(roleid);
			detail.setQuicktime(0);
			// 插入数据就行，不用判断
			this.getRoleQuicktimeService().insertRolequicktime(detail);
		}
		long now = new Date().getTime();
		GameRoleDetail gamerole = this.getGameRoleService()
				.findRoleById(roleid);
		// 更新每日任务
		int day = (int) ((now - gamerole.getTasktime()) / 1000 / 60 / 60 / 24 + 1);
		RoleDaytaskDetail roletask = this.getRoleDaytaskService()
				.findRoleDaytaskByRId(roleid);
		if (roletask.getDay() < day) {
			this.getplayerHandler().dayTask(roleid, day);
		}
		roletask = null;
		// System.out.println("MilitaryHanler.getQuicktimeServ ice: param1:" +
		// param1.toString());
		long quicktime = this.getRoleQuicktimeService().getQuicktime(param1)
				.get(0).getQuicktime();
		long temptime = quicktime - now;// 获取差时
		if (temptime <= 0 * 60 * 1000) {
			temptime = 0;
		}

		int levels = gamerole.getLevel();
		List<GameMLevelDetail> as = this.getGameMlevelService()
				.getGameMLevelBylevel(levels);
		if (!rolem.isEmpty()) {
			Map<String, Object> param = new HashMap<String, Object>();
			for (int i = 0; i < rolem.size(); i++) {
				param.clear();
				param.put("bid", rolem.get(i).getId());
				param.put("militaryid", rolem.get(i).getMilitaryid());

				long timer = rolem.get(i).getTime();
				// 判断修炼是否完成
				int xltype = rolem.get(i).getXltype();
				int mlevel = rolem.get(i).getLevel();
				if (xltype != 0) {// 修炼中
					if (timer - now <= 0) {
						// 更改数据，增加经验
						int exp = rolem.get(i).getExp();
						if (xltype == 1) {
							exp += 800;
						} else if (xltype == 2) {
							exp += 1500;
						} else if (xltype == 3) {
							exp += 4800;
						}
						if (mlevel == 1) {
							exp = exp;
						} else {
							exp = exp
									+ this.getGameMLevelService()
											.getGameMLevelBylevel(mlevel - 1)
											.get(0).getAllexp();
						}
						List<GameMLevelDetail> gameM = this
								.getGameMlevelService().getGameMLevelByAllexp(
										exp);
						if (!gameM.isEmpty()) {
							mlevel = gameM.get(0).getLevel();
							exp = exp
									- this.getGameMLevelService()
											.getGameMLevelBylevel(mlevel - 1)
											.get(0).getAllexp();
							if (exp == 0) {//
								mlevel = gameM.get(0).getLevel();
								exp = 0;

							}
							// 更新到数据库
							// 判断是否超过任务等级
							if (mlevel < gamerole.getLevel()) {
								Map<String, Object> map = new HashMap<String, Object>();
								map.put("exp", exp);
								map.put("level", mlevel);
								map.put("xltype", 0);
								map.put("roleId", roleid);
								map.put("militaryid", rolem.get(i)
										.getMilitaryid());
								this.getRoleMilitaryService()
										.addMilitayExp(map);
								param.put("level", mlevel);
								param.put("exp", exp);
							} else {
								Map<String, Object> map = new HashMap<String, Object>();
								map.put("exp", 0);
								map.put("level", gamerole.getLevel());
								map.put("xltype", 0);
								map.put("roleId", roleid);
								map.put("militaryid", rolem.get(i)
										.getMilitaryid());
								this.getRoleMilitaryService()
										.addMilitayExp(map);
								param.put("level", gamerole.getLevel());
								param.put("exp", 0);
							}
						}

						param.put("time", 0);
						param.put("xltype", 0);
					} else if (timer - now > 0) {
						param.put("level", rolem.get(i).getLevel());
						param.put("exp", rolem.get(i).getExp());
						param.put("time", (timer - now));
						param.put("xltype", rolem.get(i).getXltype());
					}

				} else {// 没有在修炼
					param.put("level", rolem.get(i).getLevel());
					param.put("exp", rolem.get(i).getExp());
					param.put("time", 0);
					param.put("xltype", rolem.get(i).getXltype());
				}
				lists.add(param);
			}
			param = null;
		}
		rlt.put("temptime", temptime);
		rlt.put("militaryList", lists);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);
		param1 = null;
		rlt = null;
	}

	private void goxunxian() {
		long a = System.currentTimeMillis();
		// System.out.println("=========1==========");
		if (params.containsKey("id") && params.containsKey("type")) {
			// System.out.println("=========2==========");
			int roleid = Integer.parseInt(playerId);
			int type = NumberUtils.createInteger(String.valueOf(params
					.get("type")));
			int id = NumberUtils
					.createInteger(String.valueOf(params.get("id")));
			Map<String, Object> rlt = new HashMap<String, Object>();
			Map<String, Object> param = new HashMap<String, Object>();
			rlt.clear();
			param.clear();
			if (id == 1 || id == 10) {// id 代表寻宝的次数 10为寻宝10次
				// TODO 从这里开始写逻辑
				// System.out.println("开始寻宝");
				JSONArray list = new JSONArray();
				param.clear();
				List<GamblingItemDetail> gidList = null;
				// long bl=System.currentTimeMillis();
				// System.out.println("开始寻仙："+(bl-a));
				if (1 == type) {// 初级寻仙
					gidList = this.getGamblingItemService()
							.getGamblingItemBytype(1);
					if (!gidList.isEmpty()) {
						param.clear();
						param.put("roleid", roleid);
						param.put("itemid", 6);
						List<RoleItemDetail> item = this.getRoleItemService()
								.getRoleItem(param);
						boolean bo = false;
						if (!item.isEmpty()) {
							if (id == 1) {
								if (id == 1 && item.get(0).getNum() > 0) {
									bo = true;
								} else {
									bo = false;
								}
							} else {
								if (id == 10 && item.get(0).getNum() >= 10) {
									bo = true;
								} else {
									bo = false;
								}
							}
							// bl=System.currentTimeMillis();
							// System.out.println("开始循环："+(bl-a));
							if (bo == true) {
								for (int j = 0; j < 1; j++) {
									for (int i = 0; i < id; i++) {
										int resultid = 0;
										resultid = getItem(gidList);
										// resultid是一个id 不是mid 所以要转换
										int mid = 0;
										int resulttype = 0;
										for (int k = 0; k < gidList.size(); k++) {
											if (resultid == gidList.get(k)
													.getId()) {
												mid = gidList.get(k).getMId();
												resulttype = gidList.get(k)
														.getTypeId();
												// System.out.println(resulttype);
												break;
											}
										}
										param.clear();
										param.put("MId", mid);
										param.put("type", type);
										boolean b = this.getGifts(roleid, mid,
												resulttype, 1, type, list);
										if (b == false) {
										ServerHandler.sendData(session,
													respMap);
											return;
										}
									}
									// bl=System.currentTimeMillis();
									// System.out.println("开始寻仙第" + j +
									// "次：用时"+(bl-a));
								}

								rlt.put("reward", list);
								if (id == 1) {
									if (id == 1 && item.get(0).getNum() > 0) {
										param.clear();
										param.put("roleid", roleid);
										param.put("itemid", 6);
										param.put("num", 1);
										bo = this.getRoleItemService()
												.sbRoleItemNum(param);
										rlt.put("num", item.get(0).getNum());
										rlt.put("id", 6);
										rlt.put("bid", item.get(0).getId());
									} else {
										bo = false;
									}
								} else {
									if (id == 10 && item.get(0).getNum() >= 10) {
										param.clear();
										param.put("roleid", roleid);
										param.put("itemid", 6);
										param.put("num", 10);
										bo = this.getRoleItemService()
												.sbRoleItemNum(param);
										rlt.put("num", item.get(0).getNum());
										rlt.put("id", 6);
										rlt.put("bid", item.get(0).getId());
									} else {
										bo = false;
									}
								}
								respMap.put(
										GameConstants.GAME_API_RESPONSE_FIELD_CODE,
										GameConstants.GAME_API_SUCCESS);
								respMap.put(
										GameConstants.GAME_API_RESPONSE_FIELD_RLT,
										rlt);
								ServerHandler.sendData(session, respMap);
							} else {
								respMap.put(
										GameConstants.GAME_API_RESPONSE_FIELD_CODE,
										-2);// 寻仙另不够
								respMap.put(
										GameConstants.GAME_API_RESPONSE_FIELD_RLT,
										"");
								ServerHandler.sendData(session, respMap);
							}
						} else {
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									-2);// 寻仙另不够
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_RLT,
									"");
							ServerHandler.sendData(session, respMap);
						}
					}
				} else if (type == 2) {// 中级寻仙
					gidList = this.getGamblingItemService()
							.getGamblingItemBytype(2);
					if (!gidList.isEmpty()) {
						int num1 = 0;
						// System.out.println("gidList.size():" +
						// gidList.size());
						for (int i = 0; i < gidList.size(); i++) {
							if (num1 < gidList.get(i).getCost()) {
								num1 = gidList.get(i).getCost();
							}
						}
						param.clear();
						param.put("roleid", roleid);
						param.put("itemid", 7);
						List<RoleItemDetail> item = this.getRoleItemService()
								.getRoleItem(param);
						boolean bo = false;
						if (!item.isEmpty()) {
							if (id == 1) {
								if (id == 1 && item.get(0).getNum() > 0) {
									bo = true;
								} else {
									bo = false;
								}
							} else {
								if (id == 10 && item.get(0).getNum() >= 10) {
									bo = true;
								} else {
									bo = false;
								}
							}
							// bl=System.currentTimeMillis();
							// System.out.println("开始循环："+(bl-a));
							if (bo == true) {
								for (int j = 0; j < 2; j++) {
									for (int i = 0; i < id; i++) {
										int resultid = 0;
										while (true) {
											resultid = getItem(gidList);
											if (resultid != 0) {
												break;
											}
										}
										// resultid是一个id 不是mid 所以要转换
										int mid = 0;
										int resulttype = 0;
										for (int k = 0; k < gidList.size(); k++) {
											if (resultid == gidList.get(k)
													.getId()) {
												mid = gidList.get(k).getMId();
												resulttype = gidList.get(k)
														.getTypeId();
												break;
											}
										}
										param.clear();
										param.put("MId", mid);
										param.put("type", type);
										boolean b = this.getGifts(roleid, mid,
												resulttype, 1, type, list);
										if (b == false) {
											ServerHandler.sendData(session,
													respMap);
											return;
										}
									}
									// bl=System.currentTimeMillis();
									// System.out.println("开始寻仙第" + j +
									// "次：用时"+(bl-a));
								}

								rlt.put("reward", list);
								if (id == 1) {
									if (id == 1 && item.get(0).getNum() > 0) {
										param.clear();
										param.put("roleid", roleid);
										param.put("itemid", 7);
										param.put("num", 1);
										bo = this.getRoleItemService()
												.sbRoleItemNum(param);
										rlt.put("num", item.get(0).getNum());
										rlt.put("id", 7);
										rlt.put("bid", item.get(0).getId());
									} else {
										bo = false;
									}
								} else {
									if (id == 10 && item.get(0).getNum() >= 10) {
										param.clear();
										param.put("roleid", roleid);
										param.put("itemid", 7);
										param.put("num", 10);
										bo = this.getRoleItemService()
												.sbRoleItemNum(param);
										rlt.put("num", item.get(0).getNum());
										rlt.put("id", 7);
										rlt.put("bid", item.get(0).getId());
									} else {
										bo = false;
									}
								}
								respMap.put(
										GameConstants.GAME_API_RESPONSE_FIELD_CODE,
										GameConstants.GAME_API_SUCCESS);
								respMap.put(
										GameConstants.GAME_API_RESPONSE_FIELD_RLT,
										rlt);
								ServerHandler.sendData(session, respMap);
							} else {
								respMap.put(
										GameConstants.GAME_API_RESPONSE_FIELD_CODE,
										-2);// 寻仙另不够
								respMap.put(
										GameConstants.GAME_API_RESPONSE_FIELD_RLT,
										"");
								ServerHandler.sendData(session, respMap);
							}
						} else {
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									-2);// 寻仙另不够
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_RLT,
									"");
							ServerHandler.sendData(session, respMap);
						}
					}
				} else if (type == 3) {// 高级寻仙
					gidList = this.getGamblingItemService()
							.getGamblingItemBytype(3);
					if (!gidList.isEmpty()) {
						int num1 = 0;
						for (int i = 0; i < gidList.size(); i++) {
							// for (int j = i; j < gidList.size(); j++) {
							// if (gidList.get(j).getCost() > gidList.get(i)
							// .getCost()) {
							// num1 = gidList.get(j).getCost();
							// }
							// }
							if (num1 < gidList.get(i).getCost()) {
								num1 = gidList.get(i).getCost();
							}
						}
						param.clear();
						param.put("roleid", roleid);
						param.put("itemid", 8);
						List<RoleItemDetail> item = this.getRoleItemService()
								.getRoleItem(param);
						boolean bo = false;
						if (!item.isEmpty()) {
							if (id == 1) {
								if (id == 1 && item.get(0).getNum() > 0) {
									bo = true;
								} else {
									bo = false;
								}
							} else {
								if (id == 10 && item.get(0).getNum() >= 10) {
									bo = true;
								} else {
									bo = false;
								}
							}
							// bl=System.currentTimeMillis();
							// System.out.println("开始循环："+(bl-a));
							if (bo == true) {
								for (int j = 0; j < 4; j++) {
									for (int i = 0; i < id; i++) {
										int resultid = 0;
										while (true) {
											resultid = getItem(gidList);
											if (resultid != 0) {
												break;
											}
										}
										// resultid是一个id 不是mid 所以要转换
										int mid = 0;
										int resulttype = 0;
										for (int k = 0; k < gidList.size(); k++) {
											if (resultid == gidList.get(k)
													.getId()) {
												mid = gidList.get(k).getMId();
												resulttype = gidList.get(k)
														.getTypeId();
												break;
											}
										}
										param.clear();
										param.put("MId", mid);
										param.put("type", type);
										int types = this
												.getGamblingItemService()
												.getGamblingItemByparam(param)
												.get(0).getTypeId();
										boolean b = this.getGifts(roleid, mid,
												resulttype, 1, type, list);
										if (b == false) {
											ServerHandler.sendData(session,
													respMap);
											return;
										}
										// bl=System.currentTimeMillis();
										// System.out.println("开始寻仙第" + j +
										// "次：用时"+(bl-a));
									}

								}

								rlt.put("reward", list);
								if (id == 1) {
									if (id == 1 && item.get(0).getNum() > 0) {
										param.clear();
										param.put("roleid", roleid);
										param.put("itemid", 8);
										param.put("num", 1);
										bo = this.getRoleItemService()
												.sbRoleItemNum(param);
										rlt.put("num", item.get(0).getNum());
										rlt.put("id", 8);
										rlt.put("bid", item.get(0).getId());
									} else {
										bo = false;
									}
								} else {
									if (id == 10 && item.get(0).getNum() >= 10) {
										param.clear();
										param.put("roleid", roleid);
										param.put("itemid", 8);
										param.put("num", 10);
										bo = this.getRoleItemService()
												.sbRoleItemNum(param);
										rlt.put("num", item.get(0).getNum());
										rlt.put("id", 8);
										rlt.put("bid", item.get(0).getId());
									} else {
										bo = false;
									}
								}
								respMap.put(
										GameConstants.GAME_API_RESPONSE_FIELD_CODE,
										GameConstants.GAME_API_SUCCESS);
								respMap.put(
										GameConstants.GAME_API_RESPONSE_FIELD_RLT,
										rlt);
								ServerHandler.sendData(session, respMap);

								/****/
								GameRoleDetail gameRole = this
										.getGameRoleService().findRoleById(
												roleid);
								String state0 = gameRole.getAimreward();
								JSONArray aimreward = JSONArray
										.fromObject(state0);// 目标大奖状态
								if (aimreward.getInt(11) == 0) {// 12。进行一次高级寻宝
									aimreward.set(11, 1);
									param.clear();
									param.put("id", roleid);
									param.put("aimreward", aimreward.toString());
									this.getGameRoleService().updateRoleVip(
											param);

								}

								/****/

							} else {
								respMap.put(
										GameConstants.GAME_API_RESPONSE_FIELD_CODE,
										-2);// 寻仙另不够
								respMap.put(
										GameConstants.GAME_API_RESPONSE_FIELD_RLT,
										rlt);
								ServerHandler.sendData(session, respMap);
							}
						} else {
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									-2);// 寻仙另不够
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_RLT,
									rlt);
							ServerHandler.sendData(session, respMap);
						}
					}
				}
				list = null;
			} else {
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);// 次数不对
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "");
				ServerHandler.sendData(session, respMap);
			}
			// long bl=System.currentTimeMillis();
			// System.out.println("寻宝花费时间："+(bl-a));
			rlt = null;
			param = null;
		}
	}

	private int getItem(List<GamblingItemDetail> gidList) {// type 为1,2,3
		int result = 0;
		int sumcost = 0;
		// System.out.println("进入挑选物品概率逻辑");
		// TODO 概率逻辑
		List<Integer> id = new ArrayList();
		for (int i = 0; i < gidList.size(); i++) {
			for (int j = 0; j < gidList.get(i).getCost(); j++) {
				id.add(gidList.get(i).getId());
			}
		}
		Random ra = new Random();
		int index = ra.nextInt(id.size());
		result = id.get(index);
		// System.out.println("id="+result);
		return result;
	}

	private void xunxian() {
		// System.out.println("寻宝开始：：：：");
		int roleid = Integer.parseInt(playerId);
		GameRoleDetail role = this.getGameRoleService().findRoleById(roleid);
		int viplev = role.getVip();
		// 黄钻享受vip2待遇
		if (viplev < 2) {
			int huangzuan = 0;
			JsonSerializer json = new JsonSerializer();
			String Huangzuaninfo = this.getGameRoleService()
					.findRoleById(roleid).getHuangzuaninfo();
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
				viplev = 2;
			}
		}
		List<GameVipDetail> vip = this.getGameVipService().getGameVipByLe(
				viplev);
		Map<String, Object> rlt = new HashMap<String, Object>();
		List cj = new ArrayList();
		List zj = new ArrayList();
		List gj = new ArrayList();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("type", 1);
		param.put("isShow", 1);
		List<GamblingItemDetail> chuji = this.getGamblingItemService()
				.getGamblingItem(param);
		for (int i = 0; i < chuji.size(); i++) {
			Map<String, Object> p = new HashMap<String, Object>();
			p.put("id", chuji.get(i).getMId());
			p.put("type", chuji.get(i).getTypeId());
			cj.add(p);
			p = null;
		}
		rlt.put("chuji", cj);

		if (vip.get(0).getZjxxTop() == 1) {
			param.clear();
			param.put("type", 2);
			param.put("isShow", 1);
			List<GamblingItemDetail> zhongji = this.getGamblingItemService()
					.getGamblingItem(param);
			for (int i = 0; i < zhongji.size(); i++) {
				Map<String, Object> p = new HashMap<String, Object>();
				p.put("id", zhongji.get(i).getMId());
				p.put("type", zhongji.get(i).getTypeId());
				zj.add(p);
				p = null;
			}
			rlt.put("zhongji", zj);
		}

		if (vip.get(0).getGjxxTop() == 1) {
			param.clear();
			param.put("type", 3);
			param.put("isShow", 1);
			List<GamblingItemDetail> gaoji = this.getGamblingItemService()
					.getGamblingItem(param);
			for (int i = 0; i < gaoji.size(); i++) {
				Map<String, Object> p = new HashMap<String, Object>();
				p.put("id", gaoji.get(i).getMId());
				p.put("type", gaoji.get(i).getTypeId());
				gj.add(p);
				p = null;
			}
			rlt.put("gaoji", gj);
		}
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);
		param = null;
	}

	/** roleId:人物id，id：道具id，type：道具类型5,6resType，num：数量,初高中寻仙：status123 */
	protected boolean getGifts(int roleId, int id, int resulttype, int num,
			int xunxian, JSONArray list) {
		// TODO
		// long a=System.currentTimeMillis();
		// System.out.println("———寻宝得到礼物开始");
		Map<String, Object> param = new HashMap<String, Object>();
		boolean shi = true;
		if (5 == resulttype) {// 道具
			param.put("roleid", roleId);
			param.put("itemid", id);
			List<RoleItemDetail> item = this.getRoleItemService().getRoleItem(
					param);
			param.put("num", num);// 获得数量
			param.put("resType", resulttype);
			// bl = System.currentTimeMillis();
			// System.out.println("————————————————获取数量"+(bl-a));
			// 判断背包格子是否已满
			int itemtype = this.getGameItemService().getGameItemById(id).get(0)
					.getItemtype();
			boolean boo = this.getplayerHandler().getShangxian(itemtype,
					resulttype, roleId, id, num);
			// bl = System.currentTimeMillis();
			// System.out.println("————————————————判断背包"+(bl-a));
			if (boo == false) {// 背包格子不足
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "道具空间不足");
				shi = false;
				return shi;
			}
			// 小喇叭
			List<GameItemDetail> gameitem = this.getGameItemService()
					.getGameItemById(id);
			// bl = System.currentTimeMillis();
			// System.out.println("————————————————gameItem"+(bl-a) +
			// gameitem.toString() + gameitem.isEmpty());
			if (!gameitem.isEmpty()) {
				int pinzhi = gameitem.get(0).getQuality();
				if (pinzhi >= 4) {
					Map<String, Object> res = new HashMap<String, Object>();
					Map<String, Object> rl = new HashMap<String, Object>();
					Map<String, Object> ress = new HashMap<String, Object>();
					// 添加黄钻信息
					JsonSerializer json = new JsonSerializer();
					// String Huangzuaninfo =
					// this.getGameRoleService().findRoleById(roleId).getHuangzuaninfo();
					GameRoleDetail gr = this.getGameRoleService()
							.findRoleById3(roleId);
					String Huangzuaninfo = gr.getHuangzuaninfo();
					if ("null".equals(String.valueOf(Huangzuaninfo))) {
						// rl.put("rname", "");
						rl.put("isyellowvip", 0);
						rl.put("yellowviplevel", 0);
						rl.put("isyellowyearsvip", 0);
					} else {
						List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
								.deserialize(Huangzuaninfo);
						int ret = Integer.parseInt(String.valueOf(roleinfo.get(
								0).get("ret")));
						if (ret == 0) {
							// rl.put("rname",
							// this.getGameRoleService().findRoleById(roleId).getName());
							rl.put("isyellowvip",
									roleinfo.get(0).get("is_yellow_vip"));
							rl.put("yellowviplevel",
									roleinfo.get(0).get("yellow_vip_level"));
							rl.put("isyellowyearsvip",
									roleinfo.get(0).get("is_yellow_year_vip"));
						} else {
							// rl.put("rname", "");
							rl.put("isyellowvip", 0);
							rl.put("yellowviplevel", 0);
							rl.put("isyellowyearsvip", 0);
						}
					}
					// rl.put("rname",
					// this.getGameRoleService().findRoleById(roleId).getName());
					rl.put("rname", gr.getName());
					rl.put("mess", gameitem.get(0).getItemname());
					rl.put("pinzhi", pinzhi);
					rl.put("info", "寻宝");
					rl.put("place", 0);
					String xun = null;
					if (xunxian == 1) {
						xun = "初级";
					} else if (xunxian == 2) {
						xun = "高级";
					} else if (xunxian == 3) {
						xun = "终级";
					}
					rl.put("xunxian", xun);

					res.put("roleline", 1);
					List<GameRoleDetail> status = this.getGameRoleService()
							.getRoleByLevel(res);
					if (status.isEmpty()) {
						return false;
					}
//					for (int i = 0; i < status.size(); i++) {
//						res.clear();
//						res.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
//								GameConstants.GAME_API_SUCCESS);
//						res.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rl);
//						res.put(GameConstants.GAME_API_RESPONSE_FIELD_CMD,
//								"cht.send");
//						ServerHandler.sendDataByRoleId(res, status.get(i)
//								.getId());
//
//						ress.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
//								GameConstants.GAME_API_SUCCESS);
//						ress.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rl);
//						ress.put(GameConstants.GAME_API_RESPONSE_FIELD_CMD,
//								"sys.send");
//						ServerHandler.sendDataByRoleId(ress, status.get(i)
//								.getId());
//					}
				}
				//判断寻宝的道具是否广播
				if(gameitem.get(0).getQuality()>4){
					// 系统公告//发送广播
					GameRoleDetail role = this.getGameRoleService().findRoleById(roleId);//造成很大的延迟?
//					int quality = Integer.valueOf(String.valueOf(gameitem.get(0).getQuality()));
//					String message = "寻宝_玩家 <font color=\"#FF0000\">" + role.getName() + "</font>" + role.getVip() + "在<font color=\"#FF0000\">寻宝</font> 中获得了 <font color=\"" + GlobalData.color.get(quality) + "\">" + gameitem.get(0).getItemname() + "</font>";
//					GameConstants.log.warn("militaryHandler.getGifts:"+ message);
//					this.getsystemHandler().addMessage(message);
					
					UtilHandler util = new UtilHandler();
					String name2 = role.getName();
					int vip2 = role.getVip();
					String where = "寻宝";
					String goodsName = gameitem.get(0).getItemname();
					util.sendGetMessage(name2, vip2, where, pinzhi, goodsName,"militart_vip goxunbao");
				}
			}
			// bl = System.currentTimeMillis();
			// System.out.println("————————————————item判断："+(bl-a) +
			// item.isEmpty());
			if (!item.isEmpty()) {// 已存在
				boolean bo = this.getRoleItemService().addRoleItemNum(param);
				if (bo == true) {
					long bid = item.get(0).getId();
					param.put("bid", bid);
					param.put("id", id);
					param.remove("roleid");
					param.remove("itemid");
					list.add(param);
				} else {

				}
			} else {// 不存在，
				// int bid = this.getAutoIdService()
				// .fingKeyValueByTableName("role_item") + 1;
				long bid = this.getAutoIdService().fingKeyValueByTableName(
						"role_item") + 0L;
				RoleItemDetail iDetail = new RoleItemDetail();
				iDetail.setId(bid);
				iDetail.setRoleid(roleId);
				iDetail.setItemid(id);
				iDetail.setNum(num);
				iDetail.setFlag(1);
				iDetail.setType(itemtype);
				boolean bo = this.getRoleItemService().insertRoleItem(iDetail);
				// this.getAutoIdService()
				// .updateKeyValueAddOneByTableName(
				// "role_item");
				if (bo == true) {
					param.put("bid", bid);
					param.remove("roleid");
					param.put("id", id);
					param.remove("itemid");
					list.add(param);

				}
			}
			
			
		} else if (6 == resulttype) {// 装备
			// 判断背包格子是否已满
			int equiptype = this.getGameEquipService().getGameEquipById(id)
					.get(0).getType();
			boolean boo = this.getplayerHandler().getShangxian(equiptype,
					resulttype, roleId, id, num);
			if (boo == false) {// 背包格子不足
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "装备空间不足");
				shi = false;
				return shi;
			}
			List<GameEquipDetail> gameequips = this.getGameEquipService()
					.getGameEquipByEid(id);
			// 小喇叭
			if (gameequips.isEmpty()) {
				return false;
			}
			int pinzhi = gameequips.get(0).getQuality();
			if (pinzhi >= 4) {
				Map<String, Object> res = new HashMap<String, Object>();
				Map<String, Object> rl = new HashMap<String, Object>();
				Map<String, Object> ress = new HashMap<String, Object>();
				// 添加黄钻信息
				JsonSerializer json = new JsonSerializer();
				// String Huangzuaninfo =
				// this.getGameRoleService().findRoleById(roleId).getHuangzuaninfo();
				GameRoleDetail gr = this.getGameRoleService().findRoleById3(
						roleId);
				String Huangzuaninfo = gr.getHuangzuaninfo();
				if ("null".equals(String.valueOf(Huangzuaninfo))) {
					// rl.put("rname", "");
					rl.put("isyellowvip", 0);
					rl.put("yellowviplevel", 0);
					rl.put("isyellowyearsvip", 0);
				} else {
					List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
							.deserialize(Huangzuaninfo);
					int ret = Integer.parseInt(String.valueOf(roleinfo.get(0)
							.get("ret")));
					if (ret == 0) {
						// rl.put("rname",
						// this.getGameRoleService().findRoleById(roleId).getName());
						rl.put("isyellowvip",
								roleinfo.get(0).get("is_yellow_vip"));
						rl.put("yellowviplevel",
								roleinfo.get(0).get("yellow_vip_level"));
						rl.put("isyellowyearsvip",
								roleinfo.get(0).get("is_yellow_year_vip"));
					} else {
						// rl.put("rname", "");
						rl.put("isyellowvip", 0);
						rl.put("yellowviplevel", 0);
						rl.put("isyellowyearsvip", 0);
					}
				}
				
				//判断寻宝的道具是否广播
				if(gameequips.get(0).getQuality()>=4){
					// 系统公告//发送广播
					GameRoleDetail role = this
							.getGameRoleService()
							.findRoleById(
									roleId);
//					int quality = Integer.valueOf(String.valueOf(gameequips.get(0).getQuality()));
//					String message = "玩家   <font color=\"#0000FF\">" + role.getName() +"</font>" 
//						+ "<font color=\"#FFD700\">VIP"+role.getVip()+"</font>" + "在<font color=\"#FF0000\">寻宝</font> 中获得了 <font color=\"" + GlobalData.color.get(quality) + "\">" + gameequips.get(0).getEquipname() + "</font>";
//					GameConstants.log
//							.warn("militaryHandler.getGifts:"
//									+ message);
//					this.getsystemHandler()
//							.addMessage(message);
					UtilHandler util = new UtilHandler();
					String name2 = role.getName();
					int vip2 = role.getVip();
					String where = "寻宝";
					String goodsName = gameequips.get(0).getEquipname();
					util.sendGetMessage(name2, vip2, where, pinzhi, goodsName,"militart_vip goxunbao");
				}
				
				// rl.put("rname",
				// this.getGameRoleService().findRoleById(roleId).getName());
				rl.put("rname", gr.getName());

				rl.put("mess", gameequips.get(0).getEquipname());
				rl.put("pinzhi", pinzhi);
				rl.put("place", 0);
				rl.put("info", "寻宝");
				String xun = null;
				if (xunxian == 1) {
					xun = "初级";
				} else if (xunxian == 2) {
					xun = "高级";
				} else if (xunxian == 3) {
					xun = "终级";
				}
				rl.put("xunxian", xun);

				res.put("roleline", 1);
				List<GameRoleDetail> status = this.getGameRoleService()
						.getRoleByLevel(res);
				if (status.isEmpty()) {
					return false;
				}
//				for (int i = 0; i < status.size(); i++) {
//					res.clear();
//					res.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
//							GameConstants.GAME_API_SUCCESS);
//					res.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rl);
//					res.put(GameConstants.GAME_API_RESPONSE_FIELD_CMD,
//							"cht.send");
//					ServerHandler.sendDataByRoleId(res, status.get(i).getId());
//					ress.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
//							GameConstants.GAME_API_SUCCESS);
//					ress.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rl);
//					ress.put(GameConstants.GAME_API_RESPONSE_FIELD_CMD,
//							"sys.send");
//					ServerHandler.sendDataByRoleId(ress, status.get(i).getId());
//				}
			}

			for (int n = 0; n < num; n++) {
				// 直接插入
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
				this.getRoleEquipService().insertRoleEquip(eDetail);
				// this.getAutoIdService()
				// .updateKeyValueAddOneByTableName(
				// "role_equip");

				param.clear();
				param.put("num", num);// 获得数量
				param.put("resType", resulttype);
				param.put("bid", bid);
				param.put("id", id);

				param.put("at", attack);
				param.put("hp", hpMax);
				param.put("spd", speed);
				param.put("rl", rectlength);
				param.put("isUsed", 0);
				param.put("sl", 1);
				list.add(param);
			}

		}
		// long bl = System.currentTimeMillis();
		// System.out.println("——寻宝得到礼物结束"+(bl-a));
		return shi;
	}

	private void zhandou(IoSession session, int roleid) {

		Map<String, Object> rlt = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		GameRoleDetail gameRole = this.getGameRoleService()
				.findRoleById(roleid);
		int mapid = gameRole.getMapid2();
		int placeid = gameRole.getPlaceid2();

		param.put("roleId", roleid);
		param.put("mapid", mapid);
		List<RoleMapDetail> roleMap = this.getRoleMapService()
				.getRoleMapByParam(param);
		JSONArray list = new JSONArray();
		if (!roleMap.isEmpty()) {
			int size = roleMap.size();
			for (int i = 0; i < size; i++) {
				int m = roleMap.get(i).getMilitaryid();// 武将数据id
				// System.out.println("MilitaryHandler.zhandou()武将的ID：" + m);
				int gongji = 0;
				// List<GameMilitaryDetail>
				// military=this.getGameMilitaryService().getManyTableSelect2(m);
				List<GameMilitaryDetail> military = new ArrayList<GameMilitaryDetail>();
				if (m != 0) {
					military = resetMilitary(m);
				}
				if (!military.isEmpty()) {// 武将存在
					gongji = military.get(0).getGongji();
					// 加上塔的攻击
					List<GameTowerDetail> gameTower = this
							.getGameTowerService().getGameTowerLevel(
									roleMap.get(i).getTowerid());
					// System.out.println("datt:" + gongji);

					if (!gameTower.isEmpty()) {
						int datt = gongji;
						gongji = (100 + gameTower.get(0).getGjextra()) * gongji
								/ 100;
						map.clear();
						map.put("placeid", roleMap.get(i).getPlaceid());
						map.put("gongji", gongji);
						map.put("datt", datt);
						// map.put("fanwei",
						// (gamemilitary.get(0).getFanwei()*(gameTower.get(0).getFwextra()+100))/100);
						map.put("fanwei",
								(military.get(0).getFanwei() * (gameTower
										.get(0).getFwextra() + 100)) / 100);
						list.add(map);
					}
				} else {// 武将不存在
					continue;
				}
			}
		}
		rlt.put("mapid", mapid);
		rlt.put("attack", list);
		rlt.put("placeid", placeid);
		session.setAttribute("zhandou", rlt);
		map = null;
		param = null;
		rlt = null;
		gameRole = null;
	}

	public List<GameMilitaryDetail> resetMilitary(int id) {
		List<GameMilitaryDetail> gameMilitary = new ArrayList<GameMilitaryDetail>();
		GameMilitaryDetail gameM = new GameMilitaryDetail();
		try {
			List<RoleMilitaryDetail> roleMilitary = this
					.getRoleMilitaryService().getRoleMilitarylevel(id);
			if (roleMilitary.size() < 1) {
				throw new Exception("roleMilitary不存在！id:" + id);
			} else {
				int mid = roleMilitary.get(0).getMilitaryid();
				gameMilitary = this.getGameMilitaryService()
						.getGameMilitaryBymid(mid);
				if (gameMilitary.size() < 1) {
					throw new Exception("gameMilitary不存在！mid:" + mid);
				} else {
					int wuqiId = roleMilitary.get(0).getWuqi();
					// System.out.println("wuqiId:" + wuqiId);
					int gongji1 = 0;
					int hpmax1 = 0;
					int speed1 = 0;
					if (wuqiId != 0) {
						List<RoleEquipDetail> roleEquip = this
								.getRoleEquipService().getRoleEquipById(wuqiId);
						// System.out.println("roleEquip:" + roleEquip.size());
						if (roleEquip.size() < 1) {
							throw new Exception("roleEquip不存在！size:"
									+ roleEquip.size());
						} else {
							// System.out.println("vvvvvvvvvvvvvvvvvv");
							// System.out.println("roleEquip.get(0).getAttack()*(this.getGameStarService().getgamestars(roleEquip.get(0).getStarlevel()).get(0).getStatusadd()):"
							// +
							// roleEquip.get(0).getAttack()*(this.getGameStarService().getgamestars(roleEquip.get(0).getStarlevel()).get(0).getStatusadd()));
							gongji1 = (int) (roleEquip.get(0).getAttack() * (this
									.getGameStarService()
									.getgamestars(
											roleEquip.get(0).getStarlevel())
									.get(0).getStatusadd() / 100.0 + 1));
							// System.out.println("gongji1:" + gongji1);
							// gameMilitary.get(0).setGongji(gameMilitary.get(0).getGongji()
							// + (int)gongji);
							hpmax1 = (int) roleEquip.get(0).getHpMax()
									* (this.getGameStarService()
											.getgamestars(
													roleEquip.get(0)
															.getStarlevel())
											.get(0).getStatusadd() / 100 + 1);
							// gameMilitary.get(0).setXueliang(gameMilitary.get(0).getXueliang()
							// + (int)hpmax);
							speed1 = (int) roleEquip.get(0).getSpeed()
									* (this.getGameStarService()
											.getgamestars(
													roleEquip.get(0)
															.getStarlevel())
											.get(0).getStatusadd() / 100 + 1);
							// gameMilitary.get(0).setGongsu(gameMilitary.get(0).getGongsu()
							// + (int)speed);
						}
					} else {
						// 魔将不存在武器相关的附加属性
					}
					int huwanId = roleMilitary.get(0).getHuwan();
					int gongji2 = 0;
					int hpmax2 = 0;
					int speed2 = 0;
					if (huwanId != 0) {
						List<RoleEquipDetail> roleEquip = this
								.getRoleEquipService()
								.getRoleEquipById(huwanId);
						if (roleEquip.size() < 1) {
							throw new Exception("roleEquip不存在！size:"
									+ roleEquip.size());
						} else {
							gongji2 = (int) (roleEquip.get(0).getAttack() * (this
									.getGameStarService()
									.getgamestars(
											roleEquip.get(0).getStarlevel())
									.get(0).getStatusadd() / 100.0 + 1));
							// gameMilitary.get(0).setGongji(gameMilitary.get(0).getGongji()
							// + (int)gongji);
							hpmax2 = (int) roleEquip.get(0).getHpMax()
									* (this.getGameStarService()
											.getgamestars(
													roleEquip.get(0)
															.getStarlevel())
											.get(0).getStatusadd() / 100 + 1);
							// gameMilitary.get(0).setXueliang(gameMilitary.get(0).getXueliang()
							// + (int)hpmax);
							speed2 = (int) roleEquip.get(0).getSpeed()
									* (this.getGameStarService()
											.getgamestars(
													roleEquip.get(0)
															.getStarlevel())
											.get(0).getStatusadd() / 100 + 1);
							// gameMilitary.get(0).setGongsu(gameMilitary.get(0).getGongsu()
							// + (int)speed);
						}
					} else {
						// 魔将不存在护腕相关的附加属性
					}
					int yifuId = roleMilitary.get(0).getYifu();
					int gongji3 = 0;
					int hpmax3 = 0;
					int speed3 = 0;
					if (yifuId != 0) {
						List<RoleEquipDetail> roleEquip = this
								.getRoleEquipService().getRoleEquipById(yifuId);
						if (roleEquip.size() < 1) {
							throw new Exception("roleEquip不存在！size:"
									+ roleEquip.size());
						} else {
							gongji3 = (int) (roleEquip.get(0).getAttack() * (this
									.getGameStarService()
									.getgamestars(
											roleEquip.get(0).getStarlevel())
									.get(0).getStatusadd() / 100.0 + 1));
							// gameMilitary.get(0).setGongji(gameMilitary.get(0).getGongji()
							// + (int)gongji);
							hpmax3 = (int) roleEquip.get(0).getHpMax()
									* (this.getGameStarService()
											.getgamestars(
													roleEquip.get(0)
															.getStarlevel())
											.get(0).getStatusadd() / 100 + 1);
							// gameMilitary.get(0).setXueliang(gameMilitary.get(0).getXueliang()
							// + (int)hpmax);
							speed3 = (int) roleEquip.get(0).getSpeed()
									* (this.getGameStarService()
											.getgamestars(
													roleEquip.get(0)
															.getStarlevel())
											.get(0).getStatusadd() / 100 + 1);
							// gameMilitary.get(0).setGongsu(gameMilitary.get(0).getGongsu()
							// + (int)speed);
						}
					} else {
						// 魔将不存在衣服相关的附加属性
					}
					int touguanId = roleMilitary.get(0).getTouguan();
					int gongji4 = 0;
					int hpmax4 = 0;
					int speed4 = 0;
					if (touguanId != 0) {
						List<RoleEquipDetail> roleEquip = this
								.getRoleEquipService().getRoleEquipById(
										touguanId);
						if (roleEquip.size() < 1) {
							throw new Exception("roleEquip不存在！size:"
									+ roleEquip.size());
						} else {
							gongji4 = (int) (roleEquip.get(0).getAttack() * (this
									.getGameStarService()
									.getgamestars(
											roleEquip.get(0).getStarlevel())
									.get(0).getStatusadd() / 100.0 + 1));
							// gameMilitary.get(0).setGongji(gameMilitary.get(0).getGongji()
							// + (int)gongji);
							hpmax4 = (int) roleEquip.get(0).getHpMax()
									* (this.getGameStarService()
											.getgamestars(
													roleEquip.get(0)
															.getStarlevel())
											.get(0).getStatusadd() / 100 + 1);
							// gameMilitary.get(0).setXueliang(gameMilitary.get(0).getXueliang()
							// + (int)hpmax);
							speed4 = (int) roleEquip.get(0).getSpeed()
									* (this.getGameStarService()
											.getgamestars(
													roleEquip.get(0)
															.getStarlevel())
											.get(0).getStatusadd() / 100 + 1);
							// gameMilitary.get(0).setGongsu(gameMilitary.get(0).getGongsu()
							// + (int)speed);
						}
					} else {
						// 魔将不存在头冠相关的附加属性
					}
					int xieziId = roleMilitary.get(0).getXiezi();
					int gongji5 = 0;
					int hpmax5 = 0;
					int speed5 = 0;
					if (xieziId != 0) {
						List<RoleEquipDetail> roleEquip = this
								.getRoleEquipService()
								.getRoleEquipById(xieziId);
						if (roleEquip.size() < 1) {
							throw new Exception("roleEquip不存在！size:"
									+ roleEquip.size());
						} else {
							gongji5 = (int) (roleEquip.get(0).getAttack() * (this
									.getGameStarService()
									.getgamestars(
											roleEquip.get(0).getStarlevel())
									.get(0).getStatusadd() / 100.0 + 1));
							// gameMilitary.get(0).setGongji(gameMilitary.get(0).getGongji()
							// + (int)gongji);
							hpmax5 = (int) roleEquip.get(0).getHpMax()
									* (this.getGameStarService()
											.getgamestars(
													roleEquip.get(0)
															.getStarlevel())
											.get(0).getStatusadd() / 100 + 1);
							// gameMilitary.get(0).setXueliang(gameMilitary.get(0).getXueliang()
							// + (int)hpmax);
							speed5 = (int) roleEquip.get(0).getSpeed()
									* (this.getGameStarService()
											.getgamestars(
													roleEquip.get(0)
															.getStarlevel())
											.get(0).getStatusadd() / 100 + 1);
							// gameMilitary.get(0).setGongsu(gameMilitary.get(0).getGongsu()
							// + (int)speed);
						}
					} else {
						// 魔将不存在鞋子相关的附加属性
					}
					int shipinId = roleMilitary.get(0).getShipin();
					int gongji6 = 0;
					int hpmax6 = 0;
					int speed6 = 0;
					if (shipinId != 0) {
						List<RoleEquipDetail> roleEquip = this
								.getRoleEquipService().getRoleEquipById(
										shipinId);
						if (roleEquip.size() < 1) {
							throw new Exception("roleEquip不存在！size:"
									+ roleEquip.size());
						} else {
							gongji6 = (int) (roleEquip.get(0).getAttack() * (this
									.getGameStarService()
									.getgamestars(
											roleEquip.get(0).getStarlevel())
									.get(0).getStatusadd() / 100.0 + 1));
							// gameMilitary.get(0).setGongji(gameMilitary.get(0).getGongji()
							// + (int)gongji);
							hpmax6 = (int) roleEquip.get(0).getHpMax()
									* (this.getGameStarService()
											.getgamestars(
													roleEquip.get(0)
															.getStarlevel())
											.get(0).getStatusadd() / 100 + 1);
							// gameMilitary.get(0).setXueliang(gameMilitary.get(0).getXueliang()
							// + (int)hpmax);
							speed6 = (int) roleEquip.get(0).getSpeed()
									* (this.getGameStarService()
											.getgamestars(
													roleEquip.get(0)
															.getStarlevel())
											.get(0).getStatusadd() / 100 + 1);
							// gameMilitary.get(0).setGongsu(gameMilitary.get(0).getGongsu()
							// + (int)speed);
						}
					} else {
						// 魔将不存在饰品相关的附加属性
					}

					gameM = (GameMilitaryDetail) gameMilitary.get(0).clone();
					// System.out.println("魔将名字：" +
					// gameMilitary.get(0).getName() + " gongji1:" + gongji1 +
					// " gongji2:" + gongji2 + " gongji3:" + gongji3 +
					// " gongji4:" + gongji4 + " gongji5:" + gongji5 +
					// " gongji6:" + gongji6 + "  gjiacheng:" +
					// gameMilitary.get(0).getGjiacheng() + "  level:" +
					// roleMilitary.get(0).getLevel() +
					// " gameMilitary.get(0).getGongji():" +
					// gameMilitary.get(0).getGongji());
					gameM.setGongji(gameMilitary.get(0).getGongji()
							+ gameMilitary.get(0).getGjiacheng()
							* (roleMilitary.get(0).getLevel() - 1) + gongji1
							+ gongji2 + gongji3 + gongji4 + gongji5 + gongji6);
					gameM.setGongsu(gameMilitary.get(0).getGongsu() + speed1
							+ speed2 + speed3 + speed4 + speed5 + speed6);
					gameM.setXueliang(gameMilitary.get(0).getXueliang()
							+ gameMilitary.get(0).getXljiacheng()
							* (roleMilitary.get(0).getLevel() - 1) + hpmax1
							+ hpmax2 + hpmax3 + hpmax4 + hpmax5 + hpmax6);
					// System.out.println("gameMilitary.get(0:.getgongji:" +
					// gameM.getGongji());
					gameM.setName(roleMilitary.get(0).getName());
					gameM.setLevel(roleMilitary.get(0).getLevel());
					gameM.setArts(gameMilitary.get(0).getArts());
					gameM.setType(roleMilitary.get(0).getType());
					gameM.setPztype(roleMilitary.get(0).getMilitaryid());
					gameM.setFanwei(roleMilitary.get(0).getTypes());
					gameM.setBagj(gameMilitary.get(0).getGongji());
					gameM.setBags(gameMilitary.get(0).getGongsu());
					gameM.setBaxl(gameMilitary.get(0).getXueliang());
					gameM.setBatype(gameMilitary.get(0).getType());
					gameM.setGjjc(gameMilitary.get(0).getGjiacheng());
					gameM.setXljc(gameMilitary.get(0).getXljiacheng());
					gameM.setGmpz(gameMilitary.get(0).getPingzhi());
					gameM.setGmfw(gameMilitary.get(0).getFanwei());
					gameM.setHeti(gameMilitary.get(0).getHeti());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		gameMilitary.clear();
		gameMilitary.add(gameM);
		return gameMilitary;
	}

	/**
	 * 
	 * @param roleId人物id
	 * @param id道具id
	 * @param num
	 * @param type道具类型
	 *            5
	 */
	void getLiveItem(int roleId, int id, int num, int type, JSONArray list) {
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
			boolean boo = this.getplayerHandler().getShangxian(itemtype, type,
					roleId, id, num);
			if (boo == false) {// 背包格子不足
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "道具空间不足");
				ServerHandler.sendData(session, respMap);
				return;
			}
			if (!item.isEmpty()) {// 已存在
				boolean bo = this.getRoleItemService().addRoleItemNum(params);
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
				long bid = this.getAutoIdService().fingKeyValueByTableName(
						"role_item") + 0L;
				RoleItemDetail iDetail = new RoleItemDetail();
				iDetail.setId(bid);
				iDetail.setRoleid(roleId);
				iDetail.setItemid(id);
				iDetail.setNum(num);
				iDetail.setFlag(1);
				iDetail.setType(itemtype);
				boolean bo = this.getRoleItemService().insertRoleItem(iDetail);
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
		} else if (type == 6) {
			// 装备
			// 判断背包格子是否已满
			int equiptype = this.getGameEquipService().getGameEquipById(id)
					.get(0).getType();
			boolean boo = this.getplayerHandler().getShangxian(equiptype, type,
					roleId, id, num);
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
				this.getRoleEquipService().insertRoleEquip(eDetail);
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

}
