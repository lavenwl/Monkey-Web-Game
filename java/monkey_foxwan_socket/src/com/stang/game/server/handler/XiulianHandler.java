package com.stang.game.server.handler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.sojo.interchange.json.JsonSerializer;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.mina.core.session.IoSession;

import com.alibaba.fastjson.JSON;
import com.stang.game.cache.GlobalData;
import com.stang.game.cache.GlobalDatat;
import com.stang.game.common.GameConstants;
import com.stang.game.entity.detail.ActivityDetail;
import com.stang.game.entity.detail.CallGiftDetail;
import com.stang.game.entity.detail.GameBbuffDetail;
import com.stang.game.entity.detail.GameBingDetail;
import com.stang.game.entity.detail.GameBmapDetail;
import com.stang.game.entity.detail.GameBskillDetail;
import com.stang.game.entity.detail.GameBuffDetail;
import com.stang.game.entity.detail.GameChLevelDetail;
import com.stang.game.entity.detail.GameChartsDetail;
import com.stang.game.entity.detail.GameEInsDetail;
import com.stang.game.entity.detail.GameEPropertyDetail;
import com.stang.game.entity.detail.GameEquipDetail;
import com.stang.game.entity.detail.GameFoeDetail;
import com.stang.game.entity.detail.GameFoeskillDetail;
import com.stang.game.entity.detail.GameItemDetail;
import com.stang.game.entity.detail.GameMLevelDetail;
import com.stang.game.entity.detail.GameMapDetail;
import com.stang.game.entity.detail.GameMilitaryDetail;
import com.stang.game.entity.detail.GameMissionDetail;
import com.stang.game.entity.detail.GamePriceDetail;
import com.stang.game.entity.detail.GameRoleDetail;
import com.stang.game.entity.detail.GameSkillDetail;
import com.stang.game.entity.detail.GameStarDetail;
import com.stang.game.entity.detail.GameTaskDetail;
import com.stang.game.entity.detail.GameTowerDetail;
import com.stang.game.entity.detail.GameVipDetail;
import com.stang.game.entity.detail.GametotemDetail;
import com.stang.game.entity.detail.MemberDetail;
import com.stang.game.entity.detail.RoleBingDetail;
import com.stang.game.entity.detail.RoleChallengeDetail;
import com.stang.game.entity.detail.RoleDaytaskDetail;
import com.stang.game.entity.detail.RoleEquipDetail;
import com.stang.game.entity.detail.RoleItemDetail;
import com.stang.game.entity.detail.RoleMapDetail;
import com.stang.game.entity.detail.RoleMilitaryDetail;
import com.stang.game.entity.detail.RoleQuicktimeDetail;
import com.stang.game.entity.detail.RoletotemDetail;
import com.stang.game.entity.detail.ServerDetail;
import com.stang.game.entity.detail.ShopdiscountDetail;
import com.stang.game.server.ServerHandler;
import com.stang.game.service.IAutoIdService;
import com.stang.game.service.ICallgiftService;
import com.stang.game.service.IDantiaoService;
import com.stang.game.service.IGameChartsService;
import com.stang.game.service.IGameChartstwoService;
import com.stang.game.service.IGameEInsService;
import com.stang.game.service.IGameEquipService;
import com.stang.game.service.IGameMLevelService;
import com.stang.game.service.IGameStarService;
import com.stang.game.service.IGameVipService;
import com.stang.game.service.IGametotemService;
import com.stang.game.service.IQunzhanService;
import com.stang.game.service.IRoleChallengeService;
import com.stang.game.service.IRoleDaytaskService;
import com.stang.game.service.IRoleEquipService;
import com.stang.game.service.IRoleItemService;
import com.stang.game.service.IRoleMapService;
import com.stang.game.service.IRoleMilitaryService;
import com.stang.game.service.IRoleQuicktimeService;
import com.stang.game.service.IRoletotemService;
import com.stang.game.service.IServerService;
import com.stang.game.service.IShopdiscountService;
import com.stang.game.service.IZhugongService;
import com.stang.game.service.impl.AutoIdServiceImpl;
import com.stang.game.service.impl.CallgiftServiceImpl;
import com.stang.game.service.impl.DantiaoServiceImpl;
import com.stang.game.service.impl.GameChartsServiceImpl;
import com.stang.game.service.impl.GameChartstwoServiceImpl;
import com.stang.game.service.impl.GameEInsServiceImpl;
import com.stang.game.service.impl.GameEquipServiceImpl;
import com.stang.game.service.impl.GameMLevelServiceImpl;
import com.stang.game.service.impl.GameStarServiceImpl;
import com.stang.game.service.impl.GameVipServiceImpl;
import com.stang.game.service.impl.GametotemServiceImpl;
import com.stang.game.service.impl.QunzhanServiceImpl;
import com.stang.game.service.impl.RoleChallengeServiceImpl;
import com.stang.game.service.impl.RoleDaytaskServiceImpl;
import com.stang.game.service.impl.RoleEquipServiceImpl;
import com.stang.game.service.impl.RoleItemServiceImpl;
import com.stang.game.service.impl.RoleMapServiceImpl;
import com.stang.game.service.impl.RoleMilitaryServiceImpl;
import com.stang.game.service.impl.RoleQuicktimeServiceImpl;
import com.stang.game.service.impl.RoletotemServiceImpl;
import com.stang.game.service.impl.ServerServiceImpl;
import com.stang.game.service.impl.ShopdiscountServiceImpl;
import com.stang.game.service.impl.ZhugongServiceImpl;

public class XiulianHandler extends BaseHandler {

	private static IRoleEquipService roleEquipService;

	private IRoleEquipService getRoleEquipService() {
		if (roleEquipService == null) {
			roleEquipService = new RoleEquipServiceImpl();
		}
		return roleEquipService;
	}

	private SystemHandler systemHandler;

	private SystemHandler getsystemHandler() {
		if (systemHandler == null) {
			systemHandler = new SystemHandler();
		}
		return systemHandler;
	}

	private static ICallgiftService callgiftService;

	private ICallgiftService getcallgiftService() {
		if (callgiftService == null) {
			callgiftService = new CallgiftServiceImpl();
		}
		return callgiftService;
	}

	private static IGameEquipService gameEquipService;

	private IGameEquipService getGameEquipService() {
		if (gameEquipService == null) {
			gameEquipService = new GameEquipServiceImpl();
		}
		return gameEquipService;
	}

	private static IGameStarService gameStarService;

	private IGameStarService getGameStarService() {
		if (gameStarService == null) {
			gameStarService = new GameStarServiceImpl();
		}
		return gameStarService;
	}

	private static IRoleMapService roleMapService;

	private IRoleMapService getRoleMapService() {
		if (roleMapService == null) {
			roleMapService = new RoleMapServiceImpl();
		}
		return roleMapService;
	}

	private static IDantiaoService dantiaoService;

	private IDantiaoService getDantiaoService() {
		if (dantiaoService == null) {
			dantiaoService = new DantiaoServiceImpl();
		}
		return dantiaoService;
	}

	private static IQunzhanService qunzhanService;

	private IQunzhanService getQunzhanService() {
		if (qunzhanService == null) {
			qunzhanService = new QunzhanServiceImpl();
		}
		return qunzhanService;
	}

	private static IShopdiscountService shopService = new ShopdiscountServiceImpl();
	private static IZhugongService zhugongService;

	private IZhugongService getZhugongService() {
		if (zhugongService == null) {
			zhugongService = new ZhugongServiceImpl();
		}
		return zhugongService;
	}

	static private PlayerHandler playerHandler;

	private PlayerHandler getplayerHandler() {
		if (playerHandler == null) {
			playerHandler = new PlayerHandler(gameApiName, globalIdentifier,
					encryptedSignature, playerId, cacheKey, params, session);
		}
		return playerHandler;
	}

	private static IGameChartstwoService gameChartstwoService;

	private IGameChartstwoService getgameChartstwoService() {
		if (gameChartstwoService == null) {
			gameChartstwoService = new GameChartstwoServiceImpl();
		}
		return gameChartstwoService;
	}

	private static IServerService serverService;

	private IServerService getServerService() {
		if (serverService == null) {
			serverService = new ServerServiceImpl();
		}
		return serverService;
	}

	private static IGameChartsService gameChartsService;

	private IGameChartsService getgameChartsService() {
		if (gameChartsService == null) {
			gameChartsService = new GameChartsServiceImpl();
		}
		return gameChartsService;
	}

	private static IGametotemService gametotemService;

	private IGametotemService getGametotemService() {
		if (gametotemService == null) {
			gametotemService = new GametotemServiceImpl();
		}
		return gametotemService;
	}

	private static IRoletotemService roletotemService;

	private IRoletotemService getRoletotemService() {
		if (roletotemService == null) {
			roletotemService = new RoletotemServiceImpl();
		}
		return roletotemService;
	}

	private static IRoleMilitaryService roleMilitaryService;
	private static IAutoIdService autoIdService = new AutoIdServiceImpl();

	private IRoleMilitaryService getRoleMilitaryService() {
		if (roleMilitaryService == null) {
			roleMilitaryService = new RoleMilitaryServiceImpl();
		}
		return roleMilitaryService;
	}

	private static IRoleChallengeService roleChallengeService;

	protected IRoleChallengeService getRoleChallengeService() {
		if (roleChallengeService == null) {
			roleChallengeService = new RoleChallengeServiceImpl();
		}
		return roleChallengeService;
	}

	private static IRoleDaytaskService roleDaytask;

	private IRoleDaytaskService getRoleDaytaskService() {
		if (roleDaytask == null) {
			roleDaytask = new RoleDaytaskServiceImpl();
		}
		return roleDaytask;
	}

	private static IGameMLevelService gameMLevelService;

	private IGameMLevelService getGameMLevelService() {
		if (gameMLevelService == null) {
			gameMLevelService = new GameMLevelServiceImpl();
		}
		return gameMLevelService;
	}

	private static IGameVipService gameVipService;

	private IGameVipService getGameVipService() {
		if (gameVipService == null) {
			gameVipService = new GameVipServiceImpl();
		}
		return gameVipService;
	}

	private static IGameMLevelService gameMlevelService;

	private IGameMLevelService getGameMlevelService() {
		if (gameMlevelService == null) {
			gameMlevelService = new GameMLevelServiceImpl();
		}
		return gameMlevelService;
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

	private static IGameEInsService gameEInsService;

	private IGameEInsService getGameEInsService() {
		if (gameEInsService == null) {
			gameEInsService = new GameEInsServiceImpl();
		}
		return gameEInsService;
	}

	static private TaskHandler taskHandler;

	private TaskHandler getTaskHandler() {
		if (taskHandler == null) {
			taskHandler = new TaskHandler(gameApiName, globalIdentifier,
					encryptedSignature, playerId, cacheKey, params, session);
		}
		return taskHandler;
	}

	public XiulianHandler() {
	}

	public XiulianHandler(String gameApiName, String globalIdentifier,
			String encryptedSignature, String playerId, String cacheKey,
			Map params, IoSession session) {
		super(gameApiName, globalIdentifier, encryptedSignature, playerId,
				cacheKey, params, session);
		if (gameApiName.equals("xiu.xiulian")) {
			/** 修炼 */
			this.getXiulian();
		} else if (gameApiName.equals("xiu.delxl")) {
			/** 终止修炼 */
			this.delxl();
		} else if (gameApiName.equals("xiu.quxl")) {
			/** 快速修炼 */
			this.quxl();
		} else if (gameApiName.equals("xiu.quicken")) {
			/** 使用冷却时间加速卡 */
			this.quicken();
		} else if (gameApiName.equals("xiu.showcharts")) {
			/** 打开排行榜 */
			this.showcharts();
		} else if (gameApiName.equals("xiu.starmodel")) {
			/** 星级模型 */
			this.risestar();
		}
		else if (gameApiName.equals("xiu.openrisestar")) {
			/** 打开升星按钮 */
			this.openrisestar();
		} else if (gameApiName.equals("xiu.risestar")) {
			/** 星级装备升星 */
			this.risestar();
		} else if (gameApiName.equals("xiu.compose")) {
			/** 魔将合成 */
			this.compose();
		} else if (gameApiName.equals("xiu.flaunt")) {
			/** 像好友炫耀 */
			this.flaunt();
		} else if (gameApiName.equals("xiu.receives")) {
			/**  */
			this.receives();
		} else if (gameApiName.equals("xiu.openoldfriend")) {
			/** 打开召唤老朋友界面 */
			this.openoldfriend();
		} else if (gameApiName.equals("xiu.oldfriendgift")) {
			/** 召唤老朋友成功后领取奖励 */
			this.oldfriendgift();
		} else if (gameApiName.equals("xiu.openbuyitem")) {
			/** 打开购买领取奖励 */
			this.openbuyitem();
		} else if (gameApiName.equals("xiu.itemgift")) {
			/** 购买领取奖励 */
			this.itemgift();
		} else if (gameApiName.equals("xiu.openalchemy")) {
			/** 炼丹炉打开 */
			this.openalchemy();
		} else if (gameApiName.equals("xiu.alchemyflush")) {
			/** 炼丹炉刷新 */
			this.alchemyflush();
		} else if (gameApiName.equals("xiu.clickalchemy")) {
			/** 炼丹炉物品点击 */
			this.clickalchemy();
		} else if (gameApiName.equals("xiu.lockalchemy")) {
			/** 锁住炼丹炉物品 */
			this.lockalchemy();
		} else if (gameApiName.equals("xiu.coolalchemy")) {
			/** 炼丹炉物品降温 */
			this.coolalchemy();
		} else if (gameApiName.equals("xiu.alchemygift")) {
			/** 领取炼丹炉物品奖励 */
			this.alchemygift();
		} else if (gameApiName.equals("xiu.clickcrystal")) {
			/** 点击水晶球 */
			this.clickcrystal();
		} else if (gameApiName.equals("xiu.opennewcomerfunds")) {
			/** 新手成长基金 */
			this.opennewcomerfunds();
		} else if (gameApiName.equals("xiu.newcomerfundsgift")) {
			/** 新手成长基金 */
			this.newcomerfundsgift();
		} else if (gameApiName.equals("xiu.openaimreward")) {
			/** 打开完成目标抽大奖界面 */
			this.openaimreward();
		} else if (gameApiName.equals("xiu.extractaimreward")) {
			/** 完成目标抽大奖 */
			this.extractaimreward();
		} else if (gameApiName.equals("xiu.openawakemahatma")) {
			/** 打开唤醒大圣许心愿 */
			this.openawakemahatma();
		} else if (gameApiName.equals("xiu.newserveractivity")) {
			/** 打开15天新服活动 */
			this.newserveractivity();
		} else if (gameApiName.equals("xiu.alchemypre")) {
			// 炼丹炉保存
			this.alchemypre();
		} else if (gameApiName.equals("xiu.openturntable")){
			/** 打开转盘,开始转盘*/
			this.openturntable();
		} else if (gameApiName.equals("xiu.openzillionaire")){
			/** 打开大富翁 */
			this.openzillionaire();
		}
	}
	
	@SuppressWarnings({ "static-access", "unchecked" })
	private void openzillionaire() {
		int roleid = Integer.parseInt(String.valueOf(playerId));
		Map<String, Object> param = new HashMap<String, Object>();// 返回参数
		Map<String, Object> rlt = new HashMap<String, Object>();
		
		if(params.containsKey("tm")){//打开摇摇乐
			int tm = Integer.valueOf(String.valueOf(params.get("tm")));
			if(tm == 1){
				List itemList = new ArrayList();
				List<GameItemDetail> happyturntableList = this.getGameItemService().getGameItemHappyTurntable();
				JsonSerializer json = new JsonSerializer();
				for(GameItemDetail gameItem : happyturntableList){
					List<Map<String, Object>> r = new ArrayList<Map<String, Object>>();
					Map temp = new HashMap();
					r = (List<Map<String, Object>>)json.deserialize(gameItem.getReward());
					temp.put("id",Integer.valueOf(String.valueOf(r.get(0).get("id"))));
					temp.put("num",Integer.valueOf(String.valueOf(r.get(0).get("num"))));
					itemList.add(temp);
				}	
				param.clear();
				param.put("roleid", roleid);
				param.put("itemid", 364);
				List<RoleItemDetail> roleitem = this.getRoleItemService().getRoleItem(param);//摇摇币
				GameRoleDetail gamerole = this.getGameRoleService().findRoleById(roleid);
				int place = gamerole.getZillionaireplace();
				int num = 0;
				int bid = 0;
				if(!roleitem.isEmpty()){
					num = roleitem.get(0).getNum();
					bid = Integer.parseInt(String.valueOf(roleitem.get(0).getId()));
				}
				rlt.put("reward", itemList);
				rlt.put("place", place);
				rlt.put("tm", tm);
				rlt.put("num", num);//摇摇币数量
				rlt.put("bid", bid);//摇摇币在roleitem里的id
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
			}else{
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "打开转盘失败");
				ServerHandler.sendData(session, respMap);
			}
		}else if(params.containsKey("tmm")){//开始转盘
			int tmm = Integer.valueOf(String.valueOf(params.get("tmm")));
			if(tmm != 0){
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "运行转盘失败");
				ServerHandler.sendData(session, respMap);
			}
//			System.out.println("开始转盘");
			int number = 1;//次数
			param.clear();
			param.put("roleid", roleid);
			param.put("itemid", 364);
			List<RoleItemDetail> item = this.getRoleItemService().getRoleItem(param);
			Map<Integer,Integer> probability= new HashMap<Integer,Integer>();//key:id   value:quality--概率
			List<GameItemDetail> happyturntableList = this.getGameItemService().getGameItemHappyTurntable();
			List<GameItemDetail> zillionairList = this.getGameItemService().getGameItemZillionaire();
			JSONArray list = new JSONArray();//存放大转盘以及大富翁奖励
			JsonSerializer json = new JsonSerializer();
			boolean bo = false;//测试用改我true
			if (!item.isEmpty()) {//测试用去掉item限制
				if (number == 1) {
					if (number == 1 && item.get(0).getNum() >= 1) {
						bo = true;
					} else {
						bo = false;
					}
				}				
				if(bo == true){
					for (int i = 0; i < happyturntableList.size(); i++) {//概率
						probability.put(happyturntableList.get(i).getId(), happyturntableList.get(i).getQuality());
					}
//					System.out.println(probability.size());
//					for (int i = 0; i < probability.size(); i++) {
//						System.out.println(i+","+probability.get(i));
//					}
					int quality = 0;//物品概率
					int happyturntableId = 0;//转盘id
					int i = 0;//转盘指针位置
					int randomValue = 0;
					for (int j = 0; j < number; j++) {
						//取出转盘中的奖励
						randomValue = (int)(Math.random()*10000);
//						System.out.println("此次随即值为:"+randomValue);
						for (i = 0; i < probability.size(); i++) {
							if(i > 0){
								quality = happyturntableList.get(i).getQuality();
								if(quality > randomValue && randomValue >= happyturntableList.get(i-1).getQuality()){
									happyturntableId = happyturntableList.get(i).getId();
									break;
								}
							}else{
								quality = happyturntableList.get(i).getQuality();
								if(quality > randomValue && randomValue >= 0){
									happyturntableId = happyturntableList.get(i).getId();
									break;
								}
							}
						}
//						System.out.println("happyturntableId=="+happyturntableId);
						List<GameItemDetail> gameItem = this.getGameItemService().getGameItemById(happyturntableId);
						List<Map<String, Object>> r = new ArrayList<Map<String, Object>>();
						r = (List<Map<String, Object>>) json.deserialize(gameItem.get(0).getReward());
						int id = Integer.valueOf(String.valueOf(r.get(0).get("id")));
						int resType = Integer.valueOf(String.valueOf(r.get(0).get("resType")));
						int num = Integer.valueOf(String.valueOf(r.get(0).get("num")));
						boolean boo = this.getGifts(roleid, id, resType, num, list,"摇摇乐");
						if(boo == true){
							break;
						}else if (boo == false) {
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);// 背包不足
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,"道具空间不足");
							ServerHandler.sendData(session,respMap);
							return;
						}
					}
//					System.out.println("继续走大富翁逻辑");
					rlt.put("p", i+1);
					
					/**大富翁**/
					probability.clear();
					if(zillionairList.size() != 10){
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);// 宝箱数量出错
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,"获取数据出错");
						ServerHandler.sendData(session,respMap);
						return;
					}
//					System.out.println("初始化宝箱");
					/////初始化宝箱位置
					Map<Integer, GameItemDetail> index = new HashMap<Integer, GameItemDetail>();//宝箱下标:宝箱对象
					index.put(1, zillionairList.get(0));
					index.put(7, zillionairList.get(1));
					index.put(13, zillionairList.get(2));
					index.put(20, zillionairList.get(3));
					index.put(30, zillionairList.get(4));
					index.put(35, zillionairList.get(5));
					index.put(39, zillionairList.get(6));
					index.put(46, zillionairList.get(7));
					index.put(51, zillionairList.get(8));
					index.put(59, zillionairList.get(9));
					/////////////////////////
					int place = 0;//大富翁棋子对应位置
					int randomValue_zil = 0;//返回给前端的骰子值
					int randomValue_zil2 = 0;//二次循环骰
					GameRoleDetail gamerole = this.getGameRoleService().findRoleById(roleid);
					int vip = gamerole.getVip();
					GameVipDetail gamevip = this.getGameVipService().getGameVipByLe(vip).get(0);
					int luck = gamevip.getZillionaireLuck();//根据vip获得丢出骰子M值概率
					place = gamerole.getZillionaireplace();
//					System.out.println("当前位置 : " + place);
					int flag = 0;//标记M骰出现
					/***掷骰子逻辑,当面前6格以内有宝箱,则获取宝箱对应概率来判断是否走到宝箱位置   ***/
					randomValue_zil = (int)(Math.random()*100);
					if(randomValue_zil < luck){
						flag = 1;
					}
					randomValue_zil = 0;//重新初始化随机骰子
					if(flag == 0){
						List<GameItemDetail> gameitem = null;
						ok :for (;;) {
							randomValue_zil = (int)(Math.random()*6)+1;
							if(place >= GameConstants.ZILLIONAIRE_ALL_CELL-4){
								if(randomValue_zil == place + 5){
									continue;//防止产生负数,禁止第二圈末尾位置转到1号宝箱
								}
							}
							place += randomValue_zil;
							if(place >= GameConstants.ZILLIONAIRE_ALL_CELL){
								place -= GameConstants.ZILLIONAIRE_ALL_CELL;
							}
//							System.out.println("预计到达位置:"+place);
							if(index.containsKey(place)){
								int random = (int)(Math.random()*100);
//								System.out.println("小于30获得宝藏哟!你的随机值为:" + random);
								if(random < index.get(place).getQuality()){
									List<Map<String, Object>> r = new ArrayList<Map<String, Object>>();
									gameitem = this.getGameItemService().getGameItemById(index.get(place).getId());
									r = (List<Map<String, Object>>) json.deserialize(gameitem.get(0).getReward());
									int id = Integer.valueOf(String.valueOf(r.get(0).get("id")));
									int resType = Integer.valueOf(String.valueOf(r.get(0).get("resType")));
									int num = Integer.valueOf(String.valueOf(r.get(0).get("num")));
//									System.out.println("获得宝藏咯");
									boolean boo = this.getGifts(roleid, id, resType, num, list,"大富翁");
									if (boo == false) {
										respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);// 背包不足
										respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,"道具空间不足");
										ServerHandler.sendData(session,respMap);
										return;
									}
									break ok;
								}else{
									place -= randomValue_zil;
									for(;;){
										randomValue_zil2 = (int)(Math.random()*6)+1;
										if(randomValue_zil == randomValue_zil2){
											continue;
										}else{
											randomValue_zil = randomValue_zil2;
											place += randomValue_zil;
//											System.out.println("唉,与宝藏失之交臂");
											break ok;
										}
									}
								}
							}else{
//								System.out.println("运气太差了");
								break ok;
							}
						}
					}else if(flag == 1){//强制M骰
						for (int j = 1;; j++) {
							if(place + j >= GameConstants.ZILLIONAIRE_ALL_CELL){
								place -= GameConstants.ZILLIONAIRE_ALL_CELL;
							}
							if(index.containsKey(place + j)){
								randomValue_zil = j;
								place += j;
								List<Map<String, Object>> r = new ArrayList<Map<String, Object>>();
								List<GameItemDetail> gameitem = this.getGameItemService().getGameItemById(index.get(place).getId());
								r = (List<Map<String, Object>>) json.deserialize(gameitem.get(0).getReward());
								int id = Integer.valueOf(String.valueOf(r.get(0).get("id")));
								int resType = Integer.valueOf(String.valueOf(r.get(0).get("resType")));
								int num = Integer.valueOf(String.valueOf(r.get(0).get("num")));
//								System.out.println("获得宝藏咯");
								boolean boo = this.getGifts(roleid, id, resType, num, list,"大富翁超级骰");
								if (boo == false) {
									respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);// 背包不足
									respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,"道具空间不足");
									ServerHandler.sendData(session,respMap);
									return;
								}
								rlt.put("s", 1);
								r = null;
								gameitem = null;
								break;
							}else{
//								System.out.println("这个格子不是宝箱,下一个");
							}
						}
					}else{
//						System.out.println("逻辑错误");
					}
					param.clear();
					param.put("id", roleid);
					param.put("zillionaireplace", place);
					this.getGameRoleService().updateRoleVip(param);
//					System.out.println("骰子值为 :" + randomValue_zil);
					rlt.put("zillionaireplace", place);
					rlt.put("dicenum", randomValue_zil);
					gamerole = null;
					/*********/
					rlt.put("reward", list);//综合奖励
					if (number == 1 && item.get(0).getNum() >= 1) {
						param.clear();
						param.put("roleid", roleid);
						param.put("itemid", 364);
						param.put("num", 1);
						bo = this.getRoleItemService().sbRoleItemNum(param);
						rlt.put("num", item.get(0).getNum());
						rlt.put("id", 364);
						rlt.put("bid", item.get(0).getId());
						rlt.put("tmm", 0);
					} else {
						bo = false;
					}
//					System.out.println("---------------------------------------------------------------------");
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
					ServerHandler.sendData(session, respMap);
					index = null;
				}else{
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);// 瑶瑶币不够
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,"瑶瑶币不够");
					ServerHandler.sendData(session, respMap);
				}
			}else{
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);// 用户没有这个道具
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,"用户没有瑶瑶币");
				ServerHandler.sendData(session, respMap);
			}
			param = null;
			rlt = null;
			happyturntableList = null;
			probability = null;
			zillionairList = null;
		}
	}
	
	@SuppressWarnings({ "static-access", "unchecked" })
	private void openturntable(){
		int roleid = Integer.parseInt(String.valueOf(playerId));
		Map<String, Object> param = new HashMap<String, Object>();// 返回参数
		Map<String, Object> rlt = new HashMap<String, Object>();
		
		if(params.containsKey("tm")){//打开转盘
			int tm = Integer.valueOf(String.valueOf(params.get("tm")));
			if(tm == 1){
				List itemList = new ArrayList();
				List<GameItemDetail> turntableList = this.getGameItemService().getGameItemTurntable();
				JsonSerializer json = new JsonSerializer();
				for(GameItemDetail gameItem : turntableList){
					List<Map<String, Object>> r = new ArrayList<Map<String, Object>>();
					Map temp = new HashMap();
					r = (List<Map<String, Object>>)json.deserialize(gameItem.getReward());
					temp.put("id",Integer.valueOf(String.valueOf(r.get(0).get("id"))));
					temp.put("num",Integer.valueOf(String.valueOf(r.get(0).get("num"))));
					itemList.add(temp);
				}	
				param.clear();
				param.put("roleid", roleid);
				param.put("itemid", 364);
				List<RoleItemDetail> roleitem = this.getRoleItemService().getRoleItem(param);//幸运币
				int num = 0;
				int bid = 0;
				if(!roleitem.isEmpty()){
					num = roleitem.get(0).getNum();
					bid = Integer.parseInt(String.valueOf(roleitem.get(0).getId()));
				}
				rlt.put("reward", itemList);
				rlt.put("tm", tm);
				rlt.put("p", 0);//指针位置
				rlt.put("num", num);//幸运币数量
				rlt.put("bid", bid);//幸运币在roleitem里的id
				Map<String, Object> activity = new HashMap<String, Object>();
				activity.put("id", GameConstants.TURNTABLE_ACTIVITY_ID);
				List<ActivityDetail> activityList = this.getActivityService().getActivityByParams(activity);
				Calendar calendar = Calendar.getInstance();
				int month = activityList.get(0).getMonth();
				int day = activityList.get(0).getDay();
				int monthEnd = activityList.get(0).getMonthend();
				int dayEnd = activityList.get(0).getDayend();
				int year = calendar.get(Calendar.YEAR);
				String activityStartTime = year + "-" + month + "-" + day;
				String activityEndTime = year + "-" + monthEnd + "-" + dayEnd;
				rlt.put("activityTime", activityStartTime+"至"+activityEndTime);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
			}else{
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "打开转盘失败");
				ServerHandler.sendData(session, respMap);
			}
		}else{//开始转盘
//			System.out.println("开始转盘");
			int t = Integer.valueOf(String.valueOf(params.get("t")));
			int number = 0;
			if(t == 0){
				number = 1;
			}else if(t == 1){
				number = 10;
			}
			param.clear();
			param.put("roleid", roleid);
			param.put("itemid", 364);
			List<RoleItemDetail> item = this.getRoleItemService().getRoleItem(param);
			Map<Integer,Integer> probability= new HashMap<Integer,Integer>();//key:id   value:quality--概率
			List<GameItemDetail> turntableList = this.getGameItemService().getGameItemTurntable();
			JSONArray list = new JSONArray();
			JsonSerializer json = new JsonSerializer();
			boolean bo = false;
			if (!item.isEmpty()) {//测试用去掉item限制
				if (number == 1) {
					if (number == 1 && item.get(0).getNum() >= 1) {
						bo = true;
					} else {
						bo = false;
					}
				} else {
					if (number == 10 && item.get(0).getNum() >= 10) {
						bo = true;
					} else {
						bo = false;
					}
				}
				
				if(bo == true){
					for (int i = 0; i < turntableList.size(); i++) {//概率
						probability.put(turntableList.get(i).getId(), turntableList.get(i).getQuality());
					}
					int quality = 0;//物品概率
					int turntableId = 0;//转盘id
					int i = 0;//转盘指针位置
					int randomValue = 0;
					for (int j = 0; j < number; j++) {
						//取出转盘中的奖励
						randomValue = (int)(Math.random()*10000);
//						System.out.println("此次随即值为:"+randomValue);
						for (i = 0; i < probability.size(); i++) {
							if(i > 0){
								quality = turntableList.get(i).getQuality();
								if(quality > randomValue && randomValue >= turntableList.get(i-1).getQuality()){
									turntableId = turntableList.get(i).getId();
									break;
								}
							}else{
								quality = turntableList.get(i).getQuality();
								if(quality > randomValue && randomValue >= 0){
									turntableId = turntableList.get(i).getId();
									break;
								}
							}
						}
						List<GameItemDetail> gameItem = this.getGameItemService().getGameItemById(turntableId);
						List<Map<String, Object>> r = new ArrayList<Map<String, Object>>();
						r = (List<Map<String, Object>>) json.deserialize(gameItem.get(0).getReward());
						int id = Integer.valueOf(String.valueOf(r.get(0).get("id")));
						int resType = Integer.valueOf(String.valueOf(r.get(0).get("resType")));
						int num = Integer.valueOf(String.valueOf(r.get(0).get("num")));
						boolean boo = this.getGifts(roleid, id, resType, num, list);
						if (boo == false) {
							ServerHandler.sendData(session,respMap);
							return;
						}
					}
					if(number == 1){
						rlt.put("p", i);
						rlt.put("t", 0);//指针是否旋转
					}else if(number == 10){
						rlt.put("t", 1);
					}
					rlt.put("reward", list);
					if (number == 1) {
						if (number == 1 && item.get(0).getNum() >= 1) {
							param.clear();
							param.put("roleid", roleid);
							param.put("itemid", 364);
							param.put("num", 1);
							bo = this.getRoleItemService()
									.sbRoleItemNum(param);
							rlt.put("num", item.get(0).getNum());
							rlt.put("id", 364);
							rlt.put("bid", item.get(0).getId());
						} else {
							bo = false;
						}
					} else {
						if (number == 10 && item.get(0).getNum() >= 10) {
							param.clear();
							param.put("roleid", roleid);
							param.put("itemid", 364);
							param.put("num", 10);
							bo = this.getRoleItemService()
									.sbRoleItemNum(param);
							rlt.put("num", item.get(0).getNum());
							rlt.put("id", 364);
							rlt.put("bid", item.get(0).getId());
						} else {
							bo = false;
						}
					}
					rlt.put("turntableId", turntableId);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
					ServerHandler.sendData(session, respMap);
				}else{
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);// 幸运币不够
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,"幸运币不够");
					ServerHandler.sendData(session, respMap);
				}
			}else{
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);// 用户没有这个道具
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,"用户没有幸运币");
				ServerHandler.sendData(session, respMap);
			}
	}
	}
	
	private void alchemypre() {

		int roleid = Integer.parseInt(String.valueOf(playerId));
		Map<String, Object> param = new HashMap<String, Object>();// 返回参数
		GameRoleDetail gameRole = this.getGameRoleService()
				.findRoleById(roleid);// 用户数据
		Map<String, Object> rlt = new HashMap<String, Object>();
		String alchemygift = gameRole.getAlchemygift();// 之前的数组
		int temperature = gameRole.getTemperature();// 温度
		JSONArray ary = JSONArray.fromObject(alchemygift);// 序列化数组
		List<GameItemDetail> list = this.getGameItemService()
				.getGameItemByItemtype();
		// 炼金炉里下架的物品ID
		for (int i = 0; i < ary.size(); i++) {// 创建还在架上的物品id集合
		// System.out.println("进入1次循环");
			Object temp = ary.get(i);
			String ok = temp.toString();
			StringBuilder temp2 = new StringBuilder(ok);
			// System.out.println("1");
			int itemid = Integer.valueOf(temp2.substring(1, 5));// 根据字段取出id值
			ok: for (int j = 0; j < list.size(); j++) {
				// System.out.println("进入2次循环");
				if (itemid == list.get(j).getId()) {
					// System.out.println("跳过一次");
					break ok;
				}
				if (j == list.size() - 1) {
					// System.out.println("开始修改值");
					ary.set(i, "[1003,1]");
				}
			}
		}
		// for (Object object : ary) {
		// System.out.println(object.toString());
		// }
		// for (int i = 0; i < ary.size(); i++) {
		// int itemid = ary.getInt(i);
		// }

		param.clear();
		param.put("roleid", roleid);
		param.put("itemid", 301);
		List<RoleItemDetail> ri = this.getRoleItemService().getRoleItemByitem(
				param);
		if (ri.isEmpty() || ri.size() == 0) {
			rlt.put("num", 0);
			rlt.put("bid", 0);
		} else {
			rlt.put("num", ri.get(0).getNum());
			rlt.put("bid", ri.get(0).getId());
		}

		rlt.put("reward", ary);
		rlt.put("temperature", temperature);
		// rlt.put("num",ri.get(0).getNum());
		// rlt.put("bid",ri.get(0).getId());
		// System.out.println("给前端的物品数组："+arythree);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);

	}
	
	@SuppressWarnings({ "static-access", "static-access" })
	private void newserveractivity(){   //该方法取得的数据在全局缓存中
		if(params.containsKey("t")){//1:充值  2:关卡 3:副本 4:争霸
			int roleid = Integer.parseInt(String.valueOf(playerId));
			GameRoleDetail role = this.getGameRoleService().findRoleById(roleid);
			int serverid = Integer.valueOf(role.getServerId());
			int t = Integer.valueOf(String.valueOf(params.get("t")));
			if (!GlobalDatat.newServerDataMap.containsKey(serverid)) {
//				System.out.println("获取数据失败");
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
				ServerHandler.sendData(session, respMap);
				return;
			}
			int rank = 0;// 我的名次
			int mySelf = 0;
			Map<String, Object> rlt = new HashMap<String, Object>();//返回给前端
			Calendar calendar = Calendar.getInstance();
			int yearNow = calendar.get(Calendar.YEAR);
			int monthStart = GlobalDatat.newServerDataMap.get(serverid).getInt(1);//JSON   [serverid,monthstart,daystart]
			int dayStart = GlobalDatat.newServerDataMap.get(serverid).getInt(2);//活动起始日期
			String activityTime = yearNow + "-" + monthStart + "-" + dayStart;
			long remainderDay = 0;
			try {
				remainderDay = getDaysBetween(activityTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}//第几天
			JSONArray paiMingTen = new JSONArray();//前十玩家
			rlt.put("month", monthStart);
			rlt.put("day", dayStart);
			if(t == 1){
				if(GlobalDatat.allChongZhiMap.containsKey(serverid)&&GlobalDatat.allChongZhiPaiMingMap.containsKey(serverid)){
//					System.out.println(GlobalDatat.allChongZhiMap.get(serverid));
					try {
						mySelf = role.getCoinspend();
						rank = GlobalDatat.allChongZhiPaiMingMap.get(serverid).get(roleid);
					} catch (Exception e) {
						mySelf = 0;
						rank = 0;
					}
					// TODO   充值前十
					for (int i = 1; i <= 10; i++) {
						for (Integer roleId : GlobalDatat.allChongZhiPaiMingMap.get(serverid).keySet()) {
							if(i == GlobalDatat.allChongZhiPaiMingMap.get(serverid).get(roleId)){
								JSONArray paiMingTenForOne = new JSONArray();
								paiMingTenForOne.add(this.getGameRoleService().findRoleById(roleId).getName());
								paiMingTenForOne.add(this.getGameRoleService().findRoleById(roleId).getCoinspend());
								paiMingTen.add(paiMingTenForOne);
								break ;
							}
						}
					}
					rlt.put("t", t);
					rlt.put("list", paiMingTen);
					rlt.put("rank", rank);
					rlt.put("coinspend", mySelf);
					rlt.put("statu", remainderDay >= 8?1:0);//第七天晚上12点结束
				}else{
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
					ServerHandler.sendData(session, respMap);
					return;
				}
			}else if(t == 2){
				if(GlobalDatat.allGuanKaMap.containsKey(serverid)&&GlobalDatat.allGuanKaPaiMingMap.containsKey(serverid)){
					int mapid = role.getMapid();
					try{
						mySelf = GlobalDatat.allGuanKaMap.get(serverid).get(roleid);//玩家自己的波数
					}catch(Exception e){
//						System.out.println("新玩家没有自己的数据");
						mySelf = 0;
					}
					if(mapid == 1){//第一章没通关
						rank = 0;
					}else{
						try {
							rank = GlobalDatat.allGuanKaPaiMingMap.get(serverid).get(roleid);
						} catch (Exception e) {
							rank = 0;
						}
					}
					for (int i = 1; i <= 10; i++) {//前十的波数
						for (Integer roleId : GlobalDatat.allGuanKaPaiMingMap.get(serverid).keySet()) {
							if(i == GlobalDatat.allGuanKaPaiMingMap.get(serverid).get(roleId)){
								JSONArray paiMingTenForOne = new JSONArray();
								paiMingTenForOne.add(this.getGameRoleService().findRoleById(roleId).getName());
								paiMingTenForOne.add(GlobalDatat.allGuanKaMap.get(serverid).get(roleId));
								paiMingTen.add(paiMingTenForOne);
								break ;
							}
						}
					}
					rlt.put("t", t);
					rlt.put("list", paiMingTen);
					rlt.put("rank", rank);
					rlt.put("maplevel", mySelf);
					rlt.put("statu", remainderDay >= 16?1:0);//第15天晚上12点结束
				}else{
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
					ServerHandler.sendData(session, respMap);
					return;
				}
			}else if(t == 3){
				if(GlobalDatat.allFuBenMap.containsKey(serverid)&&GlobalDatat.allFuBenPaiMingMap.containsKey(serverid)){
					try {
						rank = GlobalDatat.allFuBenPaiMingMap.get(serverid).get(roleid);
						mySelf = GlobalDatat.allFuBenMap.get(serverid).get(roleid);
					} catch (Exception e) {
						rank = 0;
						mySelf = 0;
					}
					for (int i = 1; i <= 10; i++) {//前十的波数
						for (Integer roleId : GlobalDatat.allFuBenPaiMingMap.get(serverid).keySet()) {
							if(i == GlobalDatat.allFuBenPaiMingMap.get(serverid).get(roleId)){
								JSONArray paiMingTenForOne = new JSONArray();
								paiMingTenForOne.add(this.getGameRoleService().findRoleById(roleId).getName());
								paiMingTenForOne.add(GlobalDatat.allFuBenMap.get(serverid).get(roleId));
								paiMingTen.add(paiMingTenForOne);
								break ;
							}
						}
					}
					rlt.put("t", t);
					rlt.put("list", paiMingTen);
					rlt.put("rank", rank);
					rlt.put("maplevel", mySelf);
					rlt.put("statu", remainderDay >= 16?1:0);
				}else{
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
					ServerHandler.sendData(session, respMap);
					return;
				}
			}else if(t == 4){
				if(GlobalDatat.allZhengBaMap.containsKey(serverid)&&GlobalDatat.allZhengBaPaiMingMap.containsKey(serverid)){
					try {
						rank = GlobalDatat.allZhengBaPaiMingMap.get(serverid).get(roleid);
						mySelf = GlobalDatat.allZhengBaMap.get(serverid).get(roleid);
					} catch (Exception e) {
						rank = 0;
						mySelf = 0;
					}
					for (int i = 1; i <= 10; i++) {//前十的波数
						for (Integer roleId : GlobalDatat.allZhengBaPaiMingMap.get(serverid).keySet()) {
							if(i == GlobalDatat.allZhengBaPaiMingMap.get(serverid).get(roleId)){
								JSONArray paiMingTenForOne = new JSONArray();
								paiMingTenForOne.add(this.getGameRoleService().findRoleById(roleId).getName());
								paiMingTenForOne.add(GlobalDatat.allZhengBaMap.get(serverid).get(roleId));
								paiMingTen.add(paiMingTenForOne);
								break ;
							}
						}
					}
					rlt.put("t", t);
					rlt.put("list", paiMingTen);
					rlt.put("rank", rank);
					rlt.put("attack", mySelf);
					rlt.put("statu", remainderDay >= 16?1:0);
				}else{
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
					ServerHandler.sendData(session, respMap);
					return;
				}
			}else{
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
				ServerHandler.sendData(session, respMap);
				return;
			}
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
			ServerHandler.sendData(session, respMap);
			return;
			
		}
	}

	private void openawakemahatma() {// 打开唤醒大圣许心愿
		int roleid = Integer.parseInt(String.valueOf(playerId));
		GameRoleDetail role = this.getGameRoleService().findRoleById(roleid);
		Map<String, Object> param = new HashMap<String, Object>();
		String awakenstatu = role.getAwakenstatu();
		JSONArray statu = JSONArray.fromObject(awakenstatu);// 目标大奖状态 0：没完成
															// 1：可以领取 2：已领取
		int coinspend = role.getCoinspend();
		if (coinspend >= 3000) {// 消费条件领取七个大圣奖励
			for (int i = 0; i < 7; i++) {
				if (statu.getInt(i) == 0) {
					statu.set(i, 1);
				}
			}
		} else if (coinspend >= 2500) {
			for (int i = 0; i < 6; i++) {
				if (statu.getInt(i) == 0) {
					statu.set(i, 1);
				}
			}
		} else if (coinspend >= 2000) {
			for (int i = 0; i < 5; i++) {
				if (statu.getInt(i) == 0) {
					statu.set(i, 1);
				}
			}
		} else if (coinspend >= 1500) {
			for (int i = 0; i < 4; i++) {
				if (statu.getInt(i) == 0) {
					statu.set(i, 1);
				}
			}
		} else if (coinspend >= 1000) {
			for (int i = 0; i < 3; i++) {
				if (statu.getInt(i) == 0) {
					statu.set(i, 1);
				}
			}
		} else if (coinspend >= 500) {
			for (int i = 0; i < 2; i++) {
				if (statu.getInt(i) == 0) {
					statu.set(i, 1);
				}
			}
		} else if (coinspend >= 100) {
			if (statu.getInt(0) == 0) {
				statu.set(0, 1);
			}
		}
		int a = 0;
		for (int i = 0; i < 8; i++) {
			if (statu.getInt(i) == 2) {// 前七个元素都等于2 第8个元素为1（可领取）
				a++;
			}
		}
		if (a == 7 && statu.getInt(7) == 0) {// 前七个元素都等于2 第8个元素为1（可领取）
			statu.set(7, 1);
		}

		Map<String, Object> rlt = new HashMap<String, Object>();
		rlt.put("statu", statu);
		rlt.put("coinspend", coinspend);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);
		param.clear();
		param.put("id", roleid);
		param.put("awakenstatu", statu.toString());
		this.getGameRoleService().updateRoleVip(param);

	}

	private void extractaimreward() {
		int roleid = Integer.parseInt(String.valueOf(playerId));
		GameRoleDetail role = this.getGameRoleService().findRoleById(roleid);
		Map<String, Object> param = new HashMap<String, Object>();
		int getreward = role.getGetreward();// 已经抽奖了多少次
		String state0 = role.getAimreward();
		JSONArray aimreward = JSONArray.fromObject(state0);// 目标大奖状态
		int aimnum = 0;
		for (int i = 0; i < aimreward.size(); i++) {
			if (aimreward.getInt(i) == 1) {
				aimnum++;
			}
		}
		if ((aimnum - getreward) < 1) {// 不能再抽奖
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
			ServerHandler.sendData(session, respMap);
			return;
		}

		int random = (int) (Math.random() * 100);// 得到0~~~99的一个随机数
		// System.out.println("得到的一个随机数：："+random);
		List<GameItemDetail> gm = null;
		int a = 0;
		int probability = 101;
		for (int i = 0; i < 8; i++) {
			// System.out.println("itemid=2000--2007的道具的概率：："+probability);
			gm = this.getGameItemService().getGameItemById(2000 + i);
			if (gm.isEmpty() || gm.size() < 1) {
				continue;
			}
			if (gm.get(0).getQuality() <= random && random < probability) {//
				break;
			} else {
				probability = gm.get(0).getQuality();
			}
			// System.out.println("itemid=2000--2007的道具的概率：："+probability);
			// System.out.println("=====================================================");
		}

		// List<GameItemDetail>
		// gi=this.getGameItemService().getGameItemById(itemid);
		JSONArray arytwo = new JSONArray();
		String rewards = gm.get(0).getReward();
		JsonSerializer json = new JsonSerializer();
		List<Map<String, Object>> li = (List<Map<String, Object>>) json
				.deserialize(rewards);
		if (!li.isEmpty()) {

			for (int i = 0; i < li.size(); i++) {// 判断背包上限是否足够
				int id = Integer.parseInt(String.valueOf(li.get(i).get("id")));
				int num = Integer
						.parseInt(String.valueOf(li.get(i).get("num")));
				int itemtype = this.getGameItemService().getGameItemById(id)
						.get(0).getItemtype();
				boolean b = this.getplayerHandler().getShangxian(itemtype, 5,
						roleid, id, num);
				if (b) {

				} else {// 背包格子不足
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "道具空间不足");
					ServerHandler.sendData(session, respMap);
					return;
				}
			}
			for (int i = 0; i < li.size(); i++) {
				int id = Integer.parseInt(String.valueOf(li.get(i).get("id")));
				int num = Integer
						.parseInt(String.valueOf(li.get(i).get("num")));
				this.getplayerHandler().getItem(roleid, id, num, 5, arytwo);

			}
		} else {
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
			ServerHandler.sendData(session, respMap);
			return;
		}

		// JSONArray arytwo=new JSONArray();
		// this.getplayerHandler().getItem(roleid, gm.get(0).getId(),1, 5,
		// arytwo);
		Map<String, Object> rlt = new HashMap<String, Object>();
		rlt.put("num", aimnum - getreward - 1);
		rlt.put("id", gm.get(0).getId());
		rlt.put("reward", arytwo);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);
		param.clear();
		param.put("id", roleid);
		param.put("getreward", 1);
		this.getGameRoleService().updateRoleVip(param);

	}

	private void openaimreward() {// 打开完成目标抽大奖界面
		// System.out.println("openaimreward()开始执行：：");
		int roleid = Integer.parseInt(String.valueOf(playerId));
		GameRoleDetail role = this.getGameRoleService().findRoleById(roleid);

		long now = new Date().getTime();
		long tasktime = role.getTasktime();
		// 从数据库中获取第一次登录的时间
		double hour = (double) ((now - tasktime) / (1000 * 60 * 60.0));// 与第一天登录
		// //
		// 相差的小时
		int t = (int) (hour / 24);// 现在是第几天
		// if(t>6){//新注册用户超过7天，不能再打开
		// respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
		// ServerHandler.sendData(session, respMap);
		// return;
		// }

		int level = role.getLevel();// 转盘条件任务 1
		int mapid = role.getMapid();// 2
		int getreward = role.getGetreward();// 已经抽奖了多少次
		String state = role.getStateseven();
		JSONArray stateseven = JSONArray.fromObject(state);
		Map<String, Object> param = new HashMap<String, Object>();

		String state0 = role.getAimreward();
		JSONArray aimreward = JSONArray.fromObject(state0);// 目标大奖状态
		if (level >= 20) {// 转盘条件任务 1
			if (aimreward.getInt(0) == 0) {
				aimreward.set(0, 1);
			}
		}

		if (mapid >= 2) {// 2
			if (aimreward.getInt(1) == 0) {
				aimreward.set(1, 1);
			}
		}

		if (aimreward.getInt(3) == 0 || aimreward.getInt(4) == 0) {
			List<GameMilitaryDetail> gm = this.getGameMilitaryService()
					.getMilitaryPinzhi(roleid);
			if(!gm.equals(null)){
				int red = gm.get(0).getGongsu();// 红将数量
				int legend = gm.get(0).getGongji();// 传奇魔将数量
				if (aimreward.getInt(3) == 0) {// 4。拥有1名一流魔将
					if (red > 0) {
						aimreward.set(3, 1);
					}
				}
		
				if (aimreward.getInt(4) == 0) {// 5。拥有一名传奇魔将
					if (legend > 0) {
						aimreward.set(4, 1);
					}
				}
			}
		}
		if (aimreward.getInt(6) == 0){
			GameRoleDetail gamerole = this.getGameRoleService().findRoleById(roleid);
			int yin = gamerole.getYin();
			if(yin >= 100000){
				aimreward.set(6, 1);
			}
		}
		if (aimreward.getInt(8) == 0) {// 9。任意魔将等级到达10级
			param.clear();
			param.put("roleid", roleid);
			param.put("level", 10);
			List<RoleMilitaryDetail> rm = this.getRoleMilitaryService()
					.getRoleMilitaryByLevel(param);
			if (rm.size() > 0) {
				aimreward.set(8, 1);
			}
		}

		if (stateseven.size() == 7) {// 15。完成7日连续签到
			if (aimreward.getInt(14) == 0) {
				aimreward.set(14, 1);
			}
		}

		if (aimreward.getInt(15) == 0 || aimreward.getInt(16) == 0
				|| aimreward.getInt(17) == 0) {
			param.clear();
			param.put("roleId", roleid);
			List<RoleEquipDetail> re = this.getRoleEquipService().getRoleEquip(
					param);

			if (aimreward.getInt(15) == 0) {// 16。拥有一件蓝色品质的装备
				for (int i = 0; i < re.size(); i++) {
					if (GlobalDatat.equipthree.containsKey(re.get(i)
							.getEquipId())) {
						aimreward.set(15, 1);
					}

				}

			}

			if (aimreward.getInt(16) == 0) {// 17。拥有一件红色品质的装备
				for (int i = 0; i < re.size(); i++) {
					if (GlobalDatat.equipfour.containsKey(re.get(i)
							.getEquipId())) {
						aimreward.set(16, 1);
					}

				}
			}

			if (aimreward.getInt(17) == 0) {// 18。拥有一件金色品质的装备
				for (int i = 0; i < re.size(); i++) {
					if (GlobalDatat.equipfive.containsKey(re.get(i)
							.getEquipId())) {
						aimreward.set(17, 1);
					}

				}
			}

		}
		int aimnum = 0;
		for (int i = 0; i < aimreward.size(); i++) {
			if (aimreward.getInt(i) == 1) {
				aimnum++;
			}
		}
		int num = aimnum - getreward;
		if (num < 0) {
			num = 0;
		}

		Map<String, Object> rlt = new HashMap<String, Object>();
		rlt.put("aimstatus", aimreward);// 18个任务的状态
		rlt.put("num", num);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);
		param.clear();
		param.put("id", roleid);
		param.put("aimreward", aimreward.toString());
		this.getGameRoleService().updateRoleVip(param);

	}

	private void newcomerfundsgift() {// 领取新手成长基金礼包
		int roleid = Integer.parseInt(String.valueOf(playerId));
		GameRoleDetail gameRole = this.getGameRoleService()
				.findRoleById(roleid);
		int level = gameRole.getLevel();
		int stcoin = gameRole.getCoin();
		String fundsgift = gameRole.getFundsgift();
		JSONArray ary = new JSONArray();
		ary = JSONArray.fromObject(fundsgift);
		// System.out.println("领取奖励前的ary::"+ary);
		int coin = 0;
		for (int i = 0; i < ary.size(); i++) {
			if (ary.getInt(i) == 1) {

				if (i == 0) {
					coin = coin + 300;
				} else if (i == 1) {
					coin = coin + 400;
				} else if (i == 2) {
					coin = coin + 500;
				} else if (i == 3) {
					coin = coin + 600;
				} else if (i == 4) {
					coin = coin + 800;
				} else if (i == 5) {
					coin = coin + 1000;
				} else if (i == 6) {
					coin = coin + 1300;
				} else if (i == 7) {
					coin = coin + 1600;
				}
				ary.set(i, 2);
			}
		}
		if (coin == 0) {
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
			ServerHandler.sendData(session, respMap);
			return;
		}
		// System.out.println("要添加的coin元宝："+coin);
		this.getGameRoleService().addRoleCoin(roleid, coin);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", roleid);
		param.put("fundsgift", ary.toString());
		this.getGameRoleService().updateRoleVip(param);
		// System.out.println("领取奖励后的ary::"+ary);
		Map<String, Object> rlt = new HashMap<String, Object>();
		rlt.put("coin", stcoin + coin);// 0可购买
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);
		ary = null;
		rlt = null;
		param = null;

	}

	private void opennewcomerfunds() {// 打开新手成长基金
		int roleid = Integer.parseInt(String.valueOf(playerId));
		GameRoleDetail gameRole = this.getGameRoleService()
				.findRoleById(roleid);
		// ary.get(1-8)=(10-80级) 0：不可以领取 1：可以领取 2：已经领取
		String fundsgift = gameRole.getFundsgift();
		int fundsstatu = gameRole.getFundsstatu();
		int level = gameRole.getLevel();
		int fundslevel = gameRole.getFundslevel();
		JSONArray ary = new JSONArray();
		ary = JSONArray.fromObject(fundsgift);
		if (fundsstatu == 0 && level > fundslevel) {// 玩家超过了条件还没有购买，不再显示购买框
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
			ServerHandler.sendData(session, respMap);
			return;
		}
		if (fundsstatu != 0) {
			if(level > 80){
				level = 80;
			}
			for (int i = 0; i < level / 10; i++) {
				if (ary.getInt(i) != 2) {
					ary.set(i, 1);
					fundsstatu = 1;
				} else {
					fundsstatu = 2;// 不可以领取
				}
			}
		}

		Map<String, Object> rlt = new HashMap<String, Object>();
		rlt.put("status", fundsstatu);// 0可购买
		rlt.put("list", ary);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", roleid);
		param.put("fundsgift", ary.toString());
		this.getGameRoleService().updateRoleVip(param);
		param = null;
		ary = null;
		rlt = null;
	}

	private void clickcrystal() {// 点击火晶石
		if (params.containsKey("id")) {// 0--6物品
			// System.out.println("点击火晶石API开始执行：：：：：：：：：：：：：：：：");
			Map<String, Object> param = new HashMap<String, Object>();
			int roleid = Integer.parseInt(String.valueOf(playerId));
			int sequence = Integer.valueOf(String.valueOf(params.get("id")));
			GameRoleDetail gameRole = this.getGameRoleService().findRoleById(
					roleid);
			String alchemygift = gameRole.getAlchemygift();
			int temperature = gameRole.getTemperature();
			int tem = temperature;
			JSONArray ary = new JSONArray();
			ary = JSONArray.fromObject(alchemygift);
			// System.out.println("得到点击序列的火晶石："+sequence+"得到初始化的ary:"+ary);
			JSONArray arytwo = new JSONArray();
			if (ary.getJSONArray(sequence).getInt(0) == 1002) {
				List<GameItemDetail> items = this.getGameItemService()
						.getGameItemByItemtype();
				List<GameItemDetail> theStart;
				int Probability;
				a: for (int i = 0; i < 20; i++) {// 随机刷新出来7个物品 0:不能加锁 1没锁定 2已锁定
					theStart = this.getGameItemService().getGameItemById(1000);
					Probability = theStart.get(0).getQuality();
					// System.out.println("=========================================");
					int random = (int) (Math.random() * 100);// 得到1~~~100的一个随机数
					theStart = this.getGameItemService().getGameItemById(1000);
					Probability = theStart.get(0).getQuality();
					int a = 1;
					// System.out.println("得到了一个随机数："+random);
					if (Probability <= random && random < 100) {// id=1000(第一个道具)
						arytwo.clear();
						arytwo.add(1000);
						arytwo.add(0);
						ary.set(sequence, arytwo);
						// System.out.println("覆盖后的ary:"+ary);
						break;
					}
					for (int x = 0; x < items.size(); x++) {
						// System.out.println("走到第二层：");
						theStart = this.getGameItemService().getGameItemById(
								1000 + a);
						if (theStart.isEmpty()) {
							continue;
						}
						a++;
						if (theStart.get(0).getQuality() <= random
								&& random < Probability) {//
							// System.out.println("走到第二层道具theStart.get(0).getQuality()："+theStart.get(0).getQuality());
							if (theStart.get(0).getId() == 1001
									|| theStart.get(0).getId() == 1002) {
								if (theStart.get(0).getId() == 1001) {
									temperature = temperature + 1;
								}
								arytwo.clear();
								arytwo.add(theStart.get(0).getId());
								arytwo.add(0);
								ary.set(sequence, arytwo);
								break a;
							} else {
								if (theStart.get(0).getId() == 1003) {
									temperature = temperature - 1;
								}
								arytwo.clear();
								arytwo.add(theStart.get(0).getId());
								arytwo.add(1);
								ary.set(sequence, arytwo);
								break a;
							}

						} else {
							Probability = theStart.get(0).getQuality();
							// System.out.println("走到第二层道具Probability："+Probability);

							continue;
						}
					}
					//
				}
				param.clear();
				param.put("id", roleid);
				param.put("temperature", temperature);
				param.put("alchemygift", ary.toString());
				// System.out.println("更新数据库前的ary:"+ary);
				this.getGameRoleService().updateRoleVip(param);
				param.clear();
				param.put("roleid", roleid);
				param.put("itemid", 301);
				List<RoleItemDetail> ri = this.getRoleItemService()
						.getRoleItemByitem(param);
				int itemnum = 0;
				Long bid;
				if (ri.isEmpty()) {// 不存在，插入炎魔石
					itemnum++;
					bid = this.getAutoIdService().fingKeyValueByTableName(
							"role_item") + 0L;
					RoleItemDetail iDetail = new RoleItemDetail();
					iDetail.setId(bid);
					iDetail.setRoleid(roleid);
					iDetail.setItemid(301);
					iDetail.setNum(1);
					iDetail.setFlag(1);
					iDetail.setType(this.getGameItemService()
							.getGameItemById(301).get(0).getItemtype());
					boolean bo = this.getRoleItemService().insertRoleItem(
							iDetail);
				} else {
					itemnum = ri.get(0).getNum();
					param.clear();
					param.put("roleid", roleid);
					param.put("itemid", 301);
					param.put("num", 1);
					this.getRoleItemService().addRoleItemNum(param);// 道具加1个
					bid = ri.get(0).getId();
					itemnum++;
				}

				Map<String, Object> rlt = new HashMap<String, Object>();
				rlt.put("replace", ary.getJSONArray(sequence).getInt(0));
				rlt.put("bid", bid);
				rlt.put("id", sequence);
				rlt.put("num", itemnum);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
			} else {
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
				ServerHandler.sendData(session, respMap);
				return;
			}
		}

	}

	private void alchemygift() {// 领取炼丹炉物品奖励
		if (params.containsKey("mid") && params.containsKey("id")) {// 领取哪个itemid(mid)的物品
																	// 0-6(id)
			int roleid = Integer.parseInt(String.valueOf(playerId));
			int itemid = Integer.valueOf(String.valueOf(params.get("mid")));
			int sequence = Integer.valueOf(String.valueOf(params.get("id")));
			int size = 0;
			GameRoleDetail gameRole = this.getGameRoleService().findRoleById(
					roleid);
			String alchemygift = gameRole.getAlchemygift();
			JSONArray ary = JSONArray.fromObject(alchemygift);
			JSONArray arytwo = new JSONArray();
			// int itemid=ary.getJSONArray(sequence).getInt(0);
			int itemnum = 0;
			for (int i = 0; i < ary.size(); i++) {
				if (ary.getJSONArray(i).getInt(0) == itemid
						|| ary.getJSONArray(i).getInt(0) == 1000) {
					itemnum++;
				}
			}
			// System.out.println("sequence::"+sequence+"  itemid::"+itemid+"相同道具的数量：："+itemid);
			if (itemnum < 2 || sequence == 0) {// 空奖励
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
				ServerHandler.sendData(session, respMap);
				return;
			}
			if (itemnum - 1 != sequence) {// 不能领取此奖励
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
				ServerHandler.sendData(session, respMap);
				return;
			}
			List<GameItemDetail> gi = this.getGameItemService()
					.getGameItemById(itemid);

			String rewards = gi.get(0).getReward();
			JsonSerializer json = new JsonSerializer();
			String st = JSONArray.fromObject(rewards).getString(sequence);
			// System.out.println("要领取奖励的字符串：：：：："+st);
			List<Map<String, Object>> li = (List<Map<String, Object>>) json
					.deserialize(st);
			if (!li.isEmpty()) {
				// System.out.println("奖励转换成数组：："+li);

				for (int i = 0; i < li.size(); i++) {// 判断背包上限是否足够
					int id = Integer.parseInt(String.valueOf(li.get(i)
							.get("id")));
					int num = Integer.parseInt(String.valueOf(li.get(i).get(
							"num")));
					int itemtype = this.getGameItemService()
							.getGameItemById(id).get(0).getItemtype();
					boolean b = this.getplayerHandler().getShangxian(itemtype,
							5, roleid, id, num);
					if (b) {

					} else {// 背包格子不足
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-3);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "道具空间不足");
						ServerHandler.sendData(session, respMap);
						return;
					}
				}
				for (int i = 0; i < li.size(); i++) {
					int id = Integer.parseInt(String.valueOf(li.get(i)
							.get("id")));
					int num = Integer.parseInt(String.valueOf(li.get(i).get(
							"num")));
					this.getplayerHandler().getItem(roleid, id, num, 5, arytwo);

				}
			} else {
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
				ServerHandler.sendData(session, respMap);
				return;
			}

			Map<String, Object> rlt = new HashMap<String, Object>();
			// rlt.put("temperature",0);
			rlt.put("reward", arytwo);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
			Map<String, Object> param = new HashMap<String, Object>();
			param.clear();
			param.put("id", roleid);
			param.put("temperature", 0);
			param.put("alchemygift", "[]");
			this.getGameRoleService().updateRoleVip(param);
			rlt = null;
			param = null;
		}

	}

	private void coolalchemy() {// 炼丹炉降温
		int roleid = Integer.parseInt(String.valueOf(playerId));
		Map<String, Object> param = new HashMap<String, Object>();
		GameRoleDetail gameRole = this.getGameRoleService()
				.findRoleById(roleid);
		int temperature = gameRole.getTemperature();
		if (temperature < 1) {// 不能降温
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);
			ServerHandler.sendData(session, respMap);
			return;
		}
		param.clear();
		param.put("roleid", roleid);
		param.put("itemid", 302);
		List<RoleItemDetail> ri = this.getRoleItemService().getRoleItemByitem(
				param);
		if (ri.isEmpty() || ri.get(0).getNum() < 1) {// 道具不足，不能刷新
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
			ServerHandler.sendData(session, respMap);
			return;
		}
		int num = ri.get(0).getNum();
		param.clear();
		param.put("roleid", roleid);
		param.put("itemid", 302);
		param.put("num", 1);
		this.getRoleItemService().sbRoleItemNum(param);// 道具减少1个

		param.clear();
		param.put("id", roleid);
		param.put("temperature", 0);
		this.getGameRoleService().updateRoleVip(param);
		Map<String, Object> rlt = new HashMap<String, Object>();
		// rlt.put("temperature",0);
		rlt.put("bid", ri.get(0).getId());
		rlt.put("id", 302);
		rlt.put("num", num - 1);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);
	}

	private void openalchemy() {// 打开炼丹炉
		int roleid = Integer.parseInt(String.valueOf(playerId));
		Map<String, Object> param = new HashMap<String, Object>();
		param.clear();
		param.put("id", roleid);
		param.put("temperature", 0);
		param.put("alchemygift", "[]");
		this.getGameRoleService().updateRoleVip(param);
		Map<String, Object> rlt = new HashMap<String, Object>();
		rlt.put("OK", "OK");
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);
		rlt = null;
		param = null;

	}

	private void clickalchemy() {// 点击炼丹炉的物品
		if (params.containsKey("id")) {
			int roleid = Integer.parseInt(String.valueOf(playerId));
			int itemid = Integer.valueOf(String.valueOf(params.get("id")));
			GameRoleDetail gameRole = this.getGameRoleService().findRoleById(
					roleid);
			String alchemygift = gameRole.getAlchemygift();
			JSONArray ary = JSONArray.fromObject(alchemygift);
			int num = 0;
			if (ary.size() != 0) {
				for (int i = 0; i < ary.size(); i++) {
					if (ary.getJSONArray(i).getInt(0) == 1000
							|| ary.getJSONArray(i).getInt(0) == itemid) {
						num++;
					}
				}
			}
			Map<String, Object> rlt = new HashMap<String, Object>();
			rlt.put("num", num);
			rlt.put("id", itemid);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);

		}

	}

	private void alchemyflush() {// 刷新炼丹炉
		int roleid = Integer.parseInt(String.valueOf(playerId));
		Map<String, Object> param = new HashMap<String, Object>();
		GameRoleDetail gameRole = this.getGameRoleService()
				.findRoleById(roleid);
		List<GameItemDetail> items = this.getGameItemService()
				.getGameItemByItemtype();
		// System.out.println(items.size()+":::items.size");

		int temperature = gameRole.getTemperature();
		int tem = temperature;
		param.clear();
		param.put("roleid", roleid);
		param.put("itemid", 301);
		List<RoleItemDetail> ri = this.getRoleItemService().getRoleItemByitem(
				param);
		if (ri.isEmpty() || ri.get(0).getNum() < 1) {// 道具不足，不能刷新
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
			ServerHandler.sendData(session, respMap);
			return;
		}
		if (gameRole.getTemperature() > 9) {// 温度达到上线，不能刷新
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
			ServerHandler.sendData(session, respMap);
			return;
		}
		int num = ri.get(0).getNum();
		// System.out.println("得到的玩家所有的炎魔石：："+num);

		String alchemygift = gameRole.getAlchemygift();
		JSONArray ary = JSONArray.fromObject(alchemygift);
		// System.out.println("刷新之前的所有物品ary:"+ary);
		JSONArray arytwo = new JSONArray();
		JSONArray arythree = new JSONArray();// 给前端的
		JSONArray aryfour = new JSONArray();
		alchemygift = "[[1000,5],[1000,5],[1000,5],[1000,5],[1000,5],[1000,5],[1000,5]]";
		aryfour = JSONArray.fromObject(alchemygift);
		int whetherflash = 0;
		if (ary.size() != 0) {// 得到玩家锁定的所有道具
			for (int i = 0; i < ary.size(); i++) {
				arytwo = ary.getJSONArray(i);
				if (arytwo.getInt(1) != 2) {// 刷新没锁定的全部设置为5
					// ary.remove(i);
					arytwo.set(1, 5);
					aryfour.set(i, arytwo);
				} else {
					if (arytwo.getInt(0) == 1003) {
						temperature = temperature - 1;
					} else {
						temperature = temperature + 1;
					}
					aryfour.set(i, arytwo);
					whetherflash++;
				}
			}
			// System.out.println("处理后的所有物品ary:"+ary);
		} else {
			alchemygift = "[[1000,5],[1000,5],[1000,5],[1000,5],[1000,5],[1000,5],[1000,5]]";
			ary = JSONArray.fromObject(alchemygift);
			// System.out.println("处理后的所有物品ary:"+ary);

		}
		if (whetherflash > 6) {
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);
			ServerHandler.sendData(session, respMap);
			return;
		}
		param.clear();
		param.put("roleid", roleid);
		param.put("itemid", 301);
		param.put("num", 1);
		boolean b = false;
		b = this.getRoleItemService().sbRoleItemNum(param);// 道具减少1个
		if (b == false) {
			b = this.getRoleItemService().sbRoleItemNum(param);
			if (b == false) {
				b = this.getRoleItemService().sbRoleItemNum(param);
			}
		}
		List<GameItemDetail> theStart;
		int Probability;// 得到第一个道具的概率
		// System.out.println(tem+"初始温度::刷新之前的所有物品大小ary.size:"+ary.size());
		a: for (int i = 0; i < 20; i++) {// 随机刷新出来7个物品 0:不能加锁 1没锁定 2已锁定
			// System.out.println("=========================================");
			int random = (int) (Math.random() * 100);// 得到1~~~100的一个随机数
			theStart = this.getGameItemService().getGameItemById(1000);
			Probability = theStart.get(0).getQuality();
			int a = 1;
			// System.out.println("得到了一个随机数："+random);
			if (Probability <= random && random < 100) {// id=1000(第一个道具)
				arytwo.clear();
				arytwo.add(1000);
				arytwo.add(0);
				for (int k = 0; k < aryfour.size(); k++) {
					if (aryfour.getJSONArray(k).getInt(1) == 5) {
						aryfour.set(k, arytwo);
						// System.out.println("1:替换一个没锁定的物品序列："+k+"物品是："+arytwo+"所有的物品："+aryfour);
						if (k == 6) {
							break a;
						}
						break;
					}
					if (k == 6) {
						break a;
					}
				}
				continue;
			}
			b: for (int x = 0; x < items.size(); x++) {
				// System.out.println("走到第二层：");
				theStart = this.getGameItemService().getGameItemById(1000 + a);
				if (theStart.isEmpty() || theStart.size() < 1) {
					continue;
				}
				a++;
				if (theStart.get(0).getQuality() <= random
						&& random < Probability) {//
					// System.out.println("走到第二层道具theStart.get(0).getQuality()："+theStart.get(0).getQuality());
					if (theStart.get(0).getId() == 1001
							|| theStart.get(0).getId() == 1002) {
						if (theStart.get(0).getId() == 1001) {
							temperature = temperature + 1;
						}
						arytwo.clear();
						arytwo.add(theStart.get(0).getId());
						arytwo.add(0);
						for (int k = 0; k < aryfour.size(); k++) {
							if (aryfour.getJSONArray(k).getInt(1) == 5) {
								aryfour.set(k, arytwo);
								// System.out.println("2:替换一个没锁定的物品序列："+k+"物品是："+arytwo+"所有的物品："+aryfour);
								if (k == 6) {
									break a;
								}
								break b;
							}
							if (k == 6) {
								break a;
							}
						}
						break;
					} else {
						if (theStart.get(0).getId() == 1003) {
							temperature = temperature - 1;
						}
						arytwo.clear();
						arytwo.add(theStart.get(0).getId());
						arytwo.add(1);
						for (int k = 0; k < aryfour.size(); k++) {
							if (aryfour.getJSONArray(k).getInt(1) == 5) {
								aryfour.set(k, arytwo);
								// System.out.println("3:替换一个没锁定的物品序列："+k+"物品是："+arytwo+"所有的物品："+aryfour);
								if (k == 6) {
									break a;
								}
								break b;
							}
							if (k == 6) {
								break a;
							}
						}
						break;
					}

				} else {
					Probability = theStart.get(0).getQuality();
					// System.out.println("走到第二层道具Probability："+Probability);

					continue;
				}
			}

		}
		if (temperature < 0) {
			temperature = 0;
		}
		// System.out.println("没更新数据库前最后的物品aryfour:"+aryfour);
		param.clear();
		param.put("id", roleid);
		param.put("temperature", temperature);
		param.put("alchemygift", aryfour.toString());
		this.getGameRoleService().updateRoleVip(param);

		for (int i = 0; i < aryfour.size(); i++) {
			arythree.add(aryfour.getJSONArray(i).getInt(0) + ","
					+ aryfour.getJSONArray(i).getInt(1));
		}
		Map<String, Object> rlt = new HashMap<String, Object>();
		rlt.put("reward", arythree);
		rlt.put("temperature", tem);
		rlt.put("num", num - 1);
		rlt.put("bid", ri.get(0).getId());
		// System.out.println("给前端的物品数组："+arythree);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);

	}

	private void lockalchemy() {// 锁住炼丹炉物品 0:不能加锁 1没锁定 2已锁定
		if (params.containsKey("id")) {// 第几个物品 0--6
			Map<String, Object> rlt = new HashMap<String, Object>();
			int sequence = Integer.valueOf(String.valueOf(params.get("id")));//
			// System.out.println("sequence加解锁第几个物品："+sequence);
			int type = 0;
			int roleid = Integer.parseInt(String.valueOf(playerId));
			Map<String, Object> param = new HashMap<String, Object>();
			GameRoleDetail gameRole = this.getGameRoleService().findRoleById(
					roleid);
			String alchemygift = gameRole.getAlchemygift();
			JSONArray ary = JSONArray.fromObject(alchemygift);
			JSONArray arytwo = new JSONArray();
			arytwo = ary.getJSONArray(sequence);
			if (arytwo.getInt(1) == 1) {// 加锁
				type = 2;
				arytwo.set(1, 2);
				ary.set(sequence, arytwo);
			} else if (arytwo.getInt(1) == 2) {// 解锁
				type = 1;
				arytwo.set(1, 1);
				ary.set(sequence, arytwo);
			}

			if (arytwo.getInt(0) == 1000 && arytwo.getInt(0) == 1001
					&& arytwo.getInt(0) == 1002) {// 此3个物品不能加锁
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
				ServerHandler.sendData(session, respMap);
				return;
			}

			param.clear();
			param.put("id", roleid);
			param.put("alchemygift", ary.toString());
			this.getGameRoleService().updateRoleVip(param);
			rlt.put("type", type);
			rlt.put("id", sequence);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
			rlt = null;
			param = null;
			ary = null;
			arytwo = null;

		}

	}

	private void itemgift() {
		// System.out.println("::::::itemgift开始:::::::::::::::::::::::::::::::::::::::::::::::::::::");
		Map<String, Object> param = new HashMap<String, Object>();
		int roleid = Integer.parseInt(String.valueOf(playerId));
		GameRoleDetail gameRole = this.getGameRoleService()
				.findRoleById(roleid);
		String buyitem = gameRole.getBuyitem();
		JSONArray ary = JSONArray.fromObject(buyitem);
		JSONArray list = new JSONArray();
		int ary4 = ary.getInt(3);
		int lq = 0;

		if (ary.getInt(3) == 1) {// 可以领取

			ary.set(3, 0);
			param.put("id", roleid);
			param.put("buyitem", ary.toString());
			this.getGameRoleService().updatebuyitem(param);

			playerHandler.getItem(roleid, 8, 1, 6, list);
			playerHandler.getItem(roleid, 277, 1, 5, list);
			playerHandler.getItem(roleid, 3, 10, 5, list);
			playerHandler.getItem(roleid, 6, 10, 5, list);
			Map<String, Object> rlt = new HashMap<String, Object>();
			rlt.put("reward", list);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
			// System.out.println("::::::结束:::::::::::::::::::::::::::::::::::::::::::::::::::::");
		} else {// 不可领取

		}

	}

	private void openbuyitem() {//
		int roleid = Integer.parseInt(String.valueOf(playerId));
		GameRoleDetail gameRole = this.getGameRoleService()
				.findRoleById(roleid);
		String buyitem = gameRole.getBuyitem();
		JSONArray ary = JSONArray.fromObject(buyitem);
		int lq = 0;
		for (int i = 0; i < 3; i++) {
			if (Integer.parseInt(String.valueOf(ary.get(i))) == 1) {
				lq++;
			}
		}
		if (lq > 0) {
			if (ary.getInt(3) == 0) {
				ary.set(3, 1);
			} else {
				ary.set(3, 0);
			}

		}
		Map<String, Object> rlt = new HashMap<String, Object>();
		rlt.put("list", ary);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);

	}

	private void openoldfriend() {
		int roleid = Integer.parseInt(String.valueOf(playerId));
		GameRoleDetail gameRole = this.getGameRoleService()
				.findRoleById(roleid);
		JsonSerializer json = new JsonSerializer();

		int oldfriend = gameRole.getOldfriend();
		int[] ary0 = new int[4];// 四个按钮的状态
		if (oldfriend == 0) {// 可以召唤
			ary0[0] = 1;
		} else {
			ary0[0] = 0;
		}
		// [{"one":1,"three":1,"six":0}]
		String oldfriendgift = null;
		List<Map<String, Object>> roleinfo = null;
		if (null == gameRole.getOldfriendgift()
				|| gameRole.getOldfriendgift().equals("null")) {
			Map<String, Object> par = new HashMap<String, Object>();
			roleinfo = new ArrayList<Map<String, Object>>();
			par.put("one", 0);
			par.put("three", 0);
			par.put("six", 0);
			roleinfo.add(par);
			par = null;
			// System.out.println("oldfriendgift默认值没有插进去：：：：：：");
		} else {
			oldfriendgift = gameRole.getOldfriendgift();
			roleinfo = (List<Map<String, Object>>) json
					.deserialize(oldfriendgift);
			// System.out.println("oldfriendgift有默认值：：：：：：");
		}
		// String oldfriendgift=gameRole.getOldfriendgift();
		// // System.out.println("oldfriendgift======"+oldfriendgift);
		// List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
		// .deserialize(oldfriendgift);
		if (roleinfo.isEmpty()) {
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
			ServerHandler.sendData(session, respMap);
			return;
		}
		// System.out.println("roleinfo===one="+roleinfo.get(0).get("one"));
		int one = Integer.parseInt(String.valueOf(roleinfo.get(0).get("one")));
		int three = Integer.parseInt(String.valueOf(roleinfo.get(0)
				.get("three")));
		int six = Integer.parseInt(String.valueOf(roleinfo.get(0).get("six")));

		JSONArray ary = new JSONArray();// 所有老朋友的头像地址
		String idsold = gameRole.getIdsold();
		// System.out.println("idsold=================="+idsold);
		if ("null".equals(String.valueOf(idsold))) {// 没有老朋友进入应用
			ary0[1] = 0;
			ary0[2] = 0;
			ary0[3] = 0;
		} else {

			JSONArray ary2 = JSONArray.fromObject(idsold);
			int size2 = ary2.size();

			int a2 = 0;
			for (int i = 0; i < size2; i++) {
				String url;
				int id = Integer.parseInt(String.valueOf(ary2.get(i)));
				GameRoleDetail gamerole2 = this.getGameRoleService()
						.findRoleById3(id);
				if (gamerole2 == null) {
					size2--;
					continue;
				}
				String huangzuangift = gamerole2.getHuangzuaninfo();
				if ("null".equals(String.valueOf(huangzuangift))) {
					url = "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50";
				} else {
					List<Map<String, Object>> roleinfo2 = (List<Map<String, Object>>) json
							.deserialize(huangzuangift);
					url = (String) roleinfo2.get(0).get("figureurl");

					roleinfo2 = null;
				}

				ary.add(url);

			}
			// System.out.println("one=="+one+"three"+three+"six==="+six);
			/****/
			if (size2 >= 6) {
				if (one == 0) {
					ary0[1] = 1;
					// System.out.println("1============");
				} else {
					ary0[1] = 0;
					// System.out.println("2============");
				}
				if (three == 0) {
					ary0[2] = 1;
					// System.out.println("3============");
				} else {
					ary0[2] = 0;
					// System.out.println("4============");
				}
				if (six == 0) {
					ary0[3] = 1;
					// System.out.println("5============");
				} else {
					ary0[3] = 0;
					// System.out.println("6============");
				}

			} else if (size2 >= 3 && size2 < 6) {
				if (one == 0) {
					ary0[1] = 1;
				} else {
					ary0[1] = 0;
				}
				if (three == 0) {
					ary0[2] = 1;
				} else {
					ary0[2] = 0;
				}
			} else if (size2 >= 1 && size2 < 3) {
				if (one == 0) {
					ary0[1] = 1;
				} else {
					ary0[1] = 0;
				}
			}
			/****/
		}

		Map<String, Object> rlt = new HashMap<String, Object>();
		rlt.put("canget", ary0);
		rlt.put("list", ary);
		// for(int i=0;i<4;i++){
		// System.out.println("ary0[i]==="+ary0[i]);
		// }
		// System.out.println();
		// System.out.println("ary===="+ary);

		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);

	}

	private void oldfriendgift() {

		if (params.containsKey("t")) {// 分享t=1 炫耀t=2 试玩t=3 挑战t=4
			// long a=System.currentTimeMillis();
			int t = Integer.parseInt(String.valueOf(params.get("t")));//
			// System.out.println("t====================="+t);
			JsonSerializer json = new JsonSerializer();
			int roleid = Integer.parseInt(String.valueOf(playerId));
			JSONArray list = new JSONArray();
			// GameRoleDetail
			// gameRole=this.getGameRoleService().findRoleById(roleid);
			// int oldfriend=gameRole.getOldfriend();
			GameRoleDetail gameRole = null;
			int oldfriend = 0;
			gameRole = this.getGameRoleService().findRoleById(roleid);
			oldfriend = gameRole.getOldfriend();
			if (oldfriend == 0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				gameRole = this.getGameRoleService().findRoleById(roleid);
				oldfriend = gameRole.getOldfriend();
				if (oldfriend == 0) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					gameRole = this.getGameRoleService().findRoleById(roleid);
					oldfriend = gameRole.getOldfriend();
					if (oldfriend == 0) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						gameRole = this.getGameRoleService().findRoleById(
								roleid);
						oldfriend = gameRole.getOldfriend();
					}
				}

			}
			// String oldfriendgift=gameRole.getOldfriendgift();
			// // System.out.println("activitygift======"+activitygift);
			// List<Map<String, Object>> roleinfo = (List<Map<String, Object>>)
			// json
			// .deserialize(oldfriendgift);

			String oldfriendgift = null;
			List<Map<String, Object>> roleinfo = null;
			if (null == gameRole.getOldfriendgift()
					|| gameRole.getOldfriendgift().equals("null")) {
				Map<String, Object> par = new HashMap<String, Object>();
				roleinfo = new ArrayList<Map<String, Object>>();
				par.put("one", 0);
				par.put("three", 0);
				par.put("six", 0);
				roleinfo.add(par);
				par = null;
				// System.out.println("oldfriendgift默认值没有插进去：：：：：：");
			} else {
				oldfriendgift = gameRole.getOldfriendgift();
				roleinfo = (List<Map<String, Object>>) json
						.deserialize(oldfriendgift);
				// System.out.println("oldfriendgift有默认值：：：：：：");
			}

			// System.out.println("roleinfo===one="+roleinfo.get(0).get("one"));
			int one = 0;
			int three = 0;
			int six = 0;
			one = Integer.parseInt(String.valueOf(roleinfo.get(0).get("one")));
			three = Integer.parseInt(String.valueOf(roleinfo.get(0)
					.get("three")));
			six = Integer.parseInt(String.valueOf(roleinfo.get(0).get("six")));

			List<CallGiftDetail> cg = this.getcallgiftService().getcallgift(t);
			int itemid = cg.get(0).getItemid();
			int type = cg.get(0).getType();
			int num = cg.get(0).getNum();
			// System.out.println("t=="+t+"itemid==="+itemid+"type==="+type+"num======"+num);
			if (t == 1) {
				if (oldfriend == 0) {// 不可以领取
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
					ServerHandler.sendData(session, respMap);
					return;
				} else {// 可以领取
					this.getplayerHandler().getItem(roleid, itemid, num, type,
							list);
					// getItem(int roleId,int id,int num,int type,JSONArray
					// list)

				}
			} else if (t == 2) {
				if (oldfriend == 0) {// 不可以领取
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
					ServerHandler.sendData(session, respMap);
					return;
				} else {// 可以领取
					this.getplayerHandler().getItem(roleid, itemid, num, type,
							list);
					// getItem(int roleId,int id,int num,int type,JSONArray
					// list)

				}
			} else if (t == 3) {
				if (oldfriend == 0) {// 不可以领取
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
					ServerHandler.sendData(session, respMap);
					return;
				} else {// 可以领取
					this.getplayerHandler().getItem(roleid, itemid, num, type,
							list);
					// getItem(int roleId,int id,int num,int type,JSONArray
					// list)

				}
			} else if (t == 4) {
				if (oldfriend == 0) {// 不可以领取
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
					ServerHandler.sendData(session, respMap);
					return;
				} else {// 可以领取
					this.getplayerHandler().getItem(roleid, itemid, num, type,
							list);
					// getItem(int roleId,int id,int num,int type,JSONArray
					// list)

				}
			} else if (t == 5) {
				if (oldfriend == 0) {// 不可以领取
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
					ServerHandler.sendData(session, respMap);
					return;
				} else {// 可以领取
					this.getplayerHandler().getItem(roleid, itemid, num, type,
							list);
					// getItem(int roleId,int id,int num,int type,JSONArray
					// list)

				}
			} else if (t == 6) {
				if (oldfriend == 0) {// 不可以领取
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
					ServerHandler.sendData(session, respMap);
					return;
				} else {// 可以领取
					this.getplayerHandler().getItem(roleid, itemid, num, type,
							list);
					// getItem(int roleId,int id,int num,int type,JSONArray
					// list)

				}
			} else if (t == 7) {
				if (one != 1) {// 可以领取
					this.getplayerHandler().getItem(roleid, itemid, num, type,
							list);
					one = 1;
				} else {
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
					ServerHandler.sendData(session, respMap);
					return;
				}
			} else if (t == 8) {// 领取召唤两个好友的奖励
				if (three != 1) {// 可以领取
					this.getplayerHandler().getItem(roleid, itemid, num, type,
							list);
					three = 1;
				} else {
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
					ServerHandler.sendData(session, respMap);
					return;
				}
			} else if (t == 9) {
				if (six != 1) {// 可以领取
					this.getplayerHandler().getItem(roleid, itemid, num, type,
							list);
					six = 1;
				} else {
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
					ServerHandler.sendData(session, respMap);
					return;
				}
			}
			if (t == 7 || t == 8 || t == 9) {
				Map<String, Object> map = new HashMap<String, Object>();
				JSONArray js = new JSONArray();
				map.put("one", one);
				map.put("three", three);
				map.put("six", six);
				js.add(map);
				String giftstatu = js.toString();
				// System.out.println("领取礼物状态=giftstatu========="+giftstatu);
				map.clear();
				map.put("oldfriendgift", giftstatu);
				map.put("id", roleid);
				this.getGameRoleService().upoldfriendgift(map);
			}
			Map<String, Object> rlt = new HashMap<String, Object>();
			rlt.put("reward", list);
			rlt.put("t", t);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
			// long b=System.currentTimeMillis();
			// System.out.println("好友炫耀花费的时间==========="+(b-a));
		}
	}

	private void receives() {// 奖品领取状态//分享onestatus 炫耀twostatus 试玩threestatus
								// 挑战fourstatus
		// 1不可领取 2可领取 3已领取
		// System.out.println("receives开始执行======");
		int roleid = Integer.parseInt(String.valueOf(playerId));
		GameRoleDetail gr = this.getGameRoleService().findRoleById(roleid);
		int fdshare = gr.getFdshare();
		int fdsharegift = gr.getFdsharegift();
		int flaunt = gr.getFlaunt();
		int flauntgift = gr.getFlauntgift();
		int sharedemo = gr.getSharedemo();
		int sharedemogift = gr.getSharedemogift();
		int challenge = gr.getChallenge();
		int challengegift = gr.getChallengegift();
		int allgrgift = gr.getAllfdgift();
		int onestatus = 1;// 炫耀状态
		int twostatus = 1;
		int threestatus = 1;
		int fourstatus = 1;
		int five = 1;

		if (fdshare == 1) {// 已经分享过了，判断领取状态
			if (fdsharegift == 1) {// 分享奖励已领取
				onestatus = 3;
			} else {
				onestatus = 2;
			}
		}
		if (flaunt == 1) {// 已经炫耀过了，判断领取状态
			if (flauntgift == 1) {// 炫耀奖励已领取
				twostatus = 3;
			} else {
				twostatus = 2;
			}
		}
		if (sharedemo == 1) {// 已经试玩过了，判断领取状态
			if (sharedemogift == 1) {// 试玩奖励已领取
				threestatus = 3;
			} else {
				threestatus = 2;
			}
		}
		if (challenge == 1) {// 已经挑战过了，判断领取状态
			if (challengegift == 1) {// 挑战奖励已领取
				fourstatus = 3;
			} else {
				fourstatus = 2;
			}
		}
		if (onestatus != 1 && twostatus != 1 && threestatus != 1
				&& threestatus != 1 && allgrgift == 0) {
			five = 2;
		}

		JSONArray js = new JSONArray();
		js.add(onestatus);
		js.add(twostatus);
		js.add(threestatus);
		js.add(fourstatus);
		js.add(five);
		Map<String, Object> rlt = new HashMap<String, Object>();
		rlt.put("list", js);

		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);
		// System.out.println("receives执行结束======"+js);

		js = null;

	}

	private void flaunt() {

		if (params.containsKey("t")) {// 分享t=1 炫耀t=2 试玩t=3 挑战t=4
			int t = Integer.parseInt(String.valueOf(params.get("t")));// 合成魔将的Id

			int roleid = Integer.parseInt(String.valueOf(playerId));
			// System.out.println(roleid+"========自己的id========");

			if (t == 1) {// 分享t=1

				GameRoleDetail gr = this.getGameRoleService().findRoleById(
						roleid);
				int fdshare = gr.getFdshare();
				if (fdshare == 1) {// 每天分享一次，已经分享过了，不能再分享
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
					ServerHandler.sendData(session, respMap);
					return;
				}

				Map<String, Object> rlt = new HashMap<String, Object>();
				rlt.put("openid", 1);
				rlt.put("t", t);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
				rlt = null;

			} else if (t == 2) {// 炫耀t=2
				List<MemberDetail> mem = this.getMemberService()
						.findMemberByid(roleid);
				JsonSerializer json = new JsonSerializer();
				String allfriends = mem.get(0).getAllfriends();
				// System.out.println(mem.get(0).getAllfriends()+"=========是你allfriends===========");
				if (allfriends == null) {
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
					ServerHandler.sendData(session, respMap);
					return;
				}

				List<Map<String, Object>> friendinfo = (List<Map<String, Object>>) json
						.deserialize(allfriends);

				if (friendinfo.isEmpty()) {// 没有邀请好友，不能炫耀
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
					ServerHandler.sendData(session, respMap);
					return;

				} else {// 随机选着一个好友炫耀
						// int id= (int)(Math.random()*size) ;
					GameRoleDetail gr = this.getGameRoleService().findRoleById(
							roleid);
					int flaunt = gr.getFlaunt();
					if (flaunt == 1) {// 每天炫耀一次，已经炫耀过了，不能再炫耀
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-2);
						ServerHandler.sendData(session, respMap);
						return;
					}

					int id = (int) (Math.random() * friendinfo.size());
					String openid = String.valueOf(friendinfo.get(id).get(
							"openid"));
					Map<String, Object> rlt = new HashMap<String, Object>();
					rlt.put("openid", openid);
					rlt.put("t", t);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
					ServerHandler.sendData(session, respMap);
					rlt = null;
				}
			} else if (t == 3) {// 试玩t=3

				GameRoleDetail gr = this.getGameRoleService().findRoleById(
						roleid);
				int sharedemo = gr.getSharedemo();
				if (sharedemo == 1) {// 每天试玩一次，已经试玩过了，不能再试玩
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
					ServerHandler.sendData(session, respMap);
					return;
				}

				Map<String, Object> rlt = new HashMap<String, Object>();
				rlt.put("openid", 1);
				rlt.put("t", t);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
				rlt = null;

			} else if (t == 4) {// 挑战t=4

				List<MemberDetail> mem = this.getMemberService()
						.findMemberByid(roleid);
				JsonSerializer json = new JsonSerializer();
				String allfriends = mem.get(0).getAllfriends();

				if (allfriends == null) {
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
					ServerHandler.sendData(session, respMap);
					return;
				}
				List<Map<String, Object>> friendinfo = (List<Map<String, Object>>) json
						.deserialize(allfriends);
				if (friendinfo.isEmpty()) {// 没有邀请好友，不能挑战

					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
					ServerHandler.sendData(session, respMap);
					return;
				} else {// 随机选着一个好友挑战
						// int id= (int)(Math.random()*size) ;
					GameRoleDetail gr = this.getGameRoleService().findRoleById(
							roleid);
					int challenge = gr.getChallenge();
					if (challenge == 1) {// 每天挑战一次，已经挑战过了，不能再挑战
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-2);
						ServerHandler.sendData(session, respMap);
						return;
					}

					int id = (int) (Math.random() * friendinfo.size());
					String openid = String.valueOf(friendinfo.get(id).get(
							"openid"));
					Map<String, Object> rlt = new HashMap<String, Object>();
					rlt.put("openid", openid);
					rlt.put("t", t);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
					ServerHandler.sendData(session, respMap);
					rlt = null;
				}

			}
		}
	}

	private void compose() {// 合成魔将
		// TODO
		if (params.containsKey("composeid") && params.containsKey("useida")
				&& params.containsKey("useidb") && params.containsKey("useidc")) {
			// 需要当作资源的三个魔将和需要合成的魔将id
			// System.out.println("合成魔将开始：：：：：：：：：：：：");
			Map<String, Object> param = new HashMap<String, Object>();
			JSONArray maparray = new JSONArray();
			JSONArray roleMilitaryMap = new JSONArray();
			Map<String, Object> rlt = new HashMap<String, Object>();
			int roleid = Integer.parseInt(String.valueOf(playerId));
			int composeid = Integer.parseInt(String.valueOf(params
					.get("composeid")));// 合成魔将的Id
			int useida = Integer.parseInt(String.valueOf(params.get("useida")));// 随机1魔将的Id
			int useidb = Integer.parseInt(String.valueOf(params.get("useidb")));// 随机2魔将的Id
			int useidc = Integer.parseInt(String.valueOf(params.get("useidc")));// 随机3魔将的Id
			// 判断此三个魔将有装备放回背包，在塔里或群战表里都去除。然后删除用户魔将
			// System.out.println(composeid+"composeid==="+useida+"useida===="+useidb+"useida====="+useidc+"useida");
			List<Object> li = new ArrayList<Object>();
			li.add(composeid);
			li.add(useida);
			li.add(useidb);
			li.add(useidc);

			param.clear();
			param.put("roleId", roleid);
			param.put("militaryid", composeid);
			List<RoleMilitaryDetail> rm = this.getRoleMilitaryService()
					.getRoleMilitaryByparam(param);
			// int sjid=rm.get(0).getId();
			if (rm.isEmpty()) {// 魔将不是此用户的
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -5);
				ServerHandler.sendData(session, respMap);
				return;
			}
			int sjid = rm.get(0).getId();
			List<GameMilitaryDetail> gamemi = this.getGameMilitaryService()
					.getGameMilitaryBymid(composeid);
			int resultcomposeid = gamemi.get(0).getComposeid();
			// System.out.println("魔将合成开始"+resultcomposeid+"++++++++++resultcomposeid+++++++++");
			param.clear();
			param.put("roleId", roleid);
			param.put("militaryid", resultcomposeid);
			List<RoleMilitaryDetail> rm2 = this.getRoleMilitaryService()
					.getRoleMilitaryByparam(param);
			// int sjresultcomposeid=rm2.get(0).getId();
			if (!rm2.isEmpty()) {// 已经被合成了，不能在合成
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);
				ServerHandler.sendData(session, respMap);
				return;
			}

			int iscompose = gamemi.get(0).getIscompose();
			rlt.put("resultcomposeid", resultcomposeid);
			List<GameMilitaryDetail> gamemilitary = this
					.getGameMilitaryService().getGameMilitaryBymid(
							resultcomposeid);

			if (iscompose != 1) {// 不可以合成
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -4);
				ServerHandler.sendData(session, respMap);
				return;
			}
			JsonSerializer json = new JsonSerializer();
			// 魔将合成所必须的三个魔将
			List mids = (List) json.deserialize(gamemi.get(0).getNeedcompose());

			// System.out.println(mids+"mids==========");
			int size = mids.size();
			if (size != 3) {
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -4);
				ServerHandler.sendData(session, respMap);
				return;

			}
			for (int i = 0; i < size; i++) {// 循环删除这必须的三个魔将，还要删除前端传来的三个魔将
				if (composeid == Integer.parseInt(String.valueOf(mids.get(i)))) {
					continue;
				}
				li.add(mids.get(i));// 得到了合成的所有六个魔将
			}
			// rlt.put("useide",mids.get(0));
			// rlt.put("useidf",mids.get(1));
			// maparray.add(mids.get(0));
			// maparray.add(mids.get(1));
			// 插入新合成的魔将到roleMilitary表中
			int gongji = gamemilitary.get(0).getGongji()
					+ (gamemilitary.get(0).getGjiacheng() * rm.get(0)
							.getLevel());
			int xueliang = gamemilitary.get(0).getXueliang()
					+ (gamemilitary.get(0).getXljiacheng() * rm.get(0)
							.getLevel());
			int gongsu = gamemilitary.get(0).getGongsu();
			int fanwei = gamemilitary.get(0).getFanwei();
			rlt.put("gongji", gongji);
			rlt.put("xueliang", xueliang);
			rlt.put("gongsu", gongsu);
			rlt.put("fanwei", fanwei);

			int eqnum = 0;// 放回背包的所有武器数量
			/****/
			System.out.println("li.size = "+li.size());
			for (int i = 0; i < li.size(); i++) {
				int militaryid = Integer.parseInt(String.valueOf(li.get(i)));
				List<GameMilitaryDetail> gamemil = this
						.getGameMilitaryService().getGameMilitaryBymid(
								militaryid);
				int isaddcompose = gamemil.get(0).getIsaddcompose();
				if (isaddcompose != 1) {
					// 不可以合成
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -4);
					ServerHandler.sendData(session, respMap);
					return;

				}

				param.clear();
				param.put("roleId", roleid);
				param.put("militaryid", militaryid);
				List<RoleMilitaryDetail> rma = this.getRoleMilitaryService()
						.getRoleMilitaryByparam(param);

				if (rma.isEmpty()) {// 魔将不是此用户的
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -5);
					ServerHandler.sendData(session, respMap);
					return;
				}
				int sjida = rma.get(0).getId();// 218506

				int wq = rma.get(0).getWuqi();
				int hw = rma.get(0).getHuwan();
				int yf = rma.get(0).getYifu();
				int tg = rma.get(0).getTouguan();
				int xz = rma.get(0).getXiezi();
				int sp = rma.get(0).getShipin();

				if (wq > 0) {// 放回背包
					eqnum++;
				}
				if (hw > 0) {// 放回背包
					eqnum++;
				}
				if (yf > 0) {
					eqnum++;
				}
				if (tg > 0) {
					eqnum++;
				}
				if (xz > 0) {
					eqnum++;
				}
				if (sp > 0) {
					eqnum++;
				}

			}
			System.out.println("eqnum数量:"+eqnum);
			boolean boo = this.getplayerHandler().getShangxian(1, 6, roleid, 3,
					eqnum);// 判断武器的背包格子
			if (boo == false) {// 背包格子不足
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "装备空间不足");
				ServerHandler.sendData(session, respMap);
				return;
			}
			// System.out.println(eqnum+"背包装备的所有数量==============="+boo+"背包格子是否已满=======");

			/****/

			for (int i = 0; i < li.size(); i++) {
				int militaryid = Integer.parseInt(String.valueOf(li.get(i)));
				// System.out.println(militaryid+"循环中的militaryid=============");
				List<GameMilitaryDetail> gamemil = this
						.getGameMilitaryService().getGameMilitaryBymid(
								militaryid);
				int isaddcompose = gamemil.get(0).getIsaddcompose();
				if (isaddcompose != 1) {
					// 不可以合成
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -4);
					ServerHandler.sendData(session, respMap);
					return;
				}

				/****/
				param.clear();
				param.put("roleId", roleid);
				param.put("militaryid", militaryid);
				List<RoleMilitaryDetail> rma = this.getRoleMilitaryService()
						.getRoleMilitaryByparam(param);
				int sjida = rma.get(0).getId();
				// System.out.println(sjida+"循环中的sjida=============");

				if (rma.isEmpty()) {// 魔将不是此用户的
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -5);
					ServerHandler.sendData(session, respMap);
					return;
				}

				int wq = rma.get(0).getWuqi();
				int hw = rma.get(0).getHuwan();
				int yf = rma.get(0).getYifu();
				int tg = rma.get(0).getTouguan();
				int xz = rma.get(0).getXiezi();
				int sp = rma.get(0).getShipin();
				if (wq > 0) {// 放回背包
					param.clear();
					param.put("user", 0);
					param.put("id", wq);
					boolean a = this.getRoleEquipService().updateRoleEquipById(
							param);
					// System.out.println(a+"wq装备放回背包：：：：：：："+wq);
					// map.put("wq",wq);
					roleMilitaryMap.add(wq);
				}
				if (hw > 0) {// 放回背包
					param.clear();
					param.put("user", 0);
					param.put("id", hw);
					boolean a = this.getRoleEquipService().updateRoleEquipById(
							param);
					// System.out.println(a+"hw装备放回背包：：：：：：："+hw);
					// map.put("hw",hw);
					roleMilitaryMap.add(hw);
				}
				if (yf > 0) {
					param.clear();
					param.put("user", 0);
					param.put("id", yf);
					boolean a = this.getRoleEquipService().updateRoleEquipById(
							param);
					// System.out.println(a+"yf装备放回背包：：：：：：："+yf);
					// map.put("yf",yf);
					roleMilitaryMap.add(yf);
				}
				if (tg > 0) {
					param.clear();
					param.put("user", 0);
					param.put("id", tg);
					boolean a = this.getRoleEquipService().updateRoleEquipById(
							param);
					// System.out.println(a+"tg装备放回背包：：：：：：："+tg);
					// map.put("tg",tg);
					roleMilitaryMap.add(tg);
				}
				if (xz > 0) {
					param.clear();
					param.put("user", 0);
					param.put("id", xz);
					boolean a = this.getRoleEquipService().updateRoleEquipById(
							param);
					// System.out.println(a+"xz装备放回背包：：：：：：："+xz);
					// map.put("xz",xz);
					roleMilitaryMap.add(xz);
				}
				if (sp > 0) {
					param.clear();
					param.put("user", 0);
					param.put("id", sp);
					boolean a = this.getRoleEquipService().updateRoleEquipById(
							param);
					// System.out.println(a+"sp装备放回背包：：：：：：："+sp);
					// map.put("sp",sp);
					roleMilitaryMap.add(sp);
				}

				/****/
				param.clear();
				param.put("roleid", roleid);
				List<RoleChallengeDetail> foe0 = this.getRoleChallengeService()
						.findRoleChallengeById(param);
				if (!foe0.isEmpty()) {
					for (int j = 0; j < foe0.size(); j++) {
						// System.out.println(foe0.get(j).getId()+foe0.get(j).getRoleid());
					}
					List mids2 = (List) json.deserialize(foe0.get(0)
							.getMilitaryid());
					int length = mids2.size();
					// System.out.println("mids2.length="+length);
					if (!mids2.isEmpty()) {
						for (int j = 0; j < length; j++) {
							if (sjida == Integer.parseInt(String.valueOf(mids2
									.get(j)))) {
								// System.out.println(j+"remove一次"+",sjida=="+sjida);
								mids2.remove(j);
								break;
							}
						}
						param.clear();
						param.put("roleid", roleid);
						param.put("militaryid", String.valueOf(mids2));
						this.getRoleChallengeService().updateRoleChallenge(
								param);
					}

				}

				if (militaryid != composeid) {
					// r_m删除武将
					param.clear();
					param.put("id", sjida);
					param.put("roleId", roleid);
					this.getRoleMilitaryService().deleteRoleMilitary(param);
					maparray.add(sjida);
				} else {
					rlt.put("composeid", sjida);
				}

				// r_map判断有没有mid，有了将其id更新0
				param.clear();
				param.put("roleId", roleid);
				param.put("militaryid", sjida);// 数据id

				List<RoleMapDetail> mapmilitary = this.getRoleMapService()
						.getRoleMapByParam(param);
				if (!mapmilitary.isEmpty()) {// 不为空，将mid=0
					int mapid = mapmilitary.get(0).getId();
					param.clear();
					param.put("id", mapid);
					param.put("roleId", roleid);
					param.put("militaryid", 0);
					boolean bo = this.getRoleMapService().updateRoleMap(param);
					// System.out.println("更新的updateRoleMap====================");
				}

				/****/

			}

			/****/
			param.clear();
			param.put("roleId", roleid);
			param.put("id", sjid);
			this.getRoleMilitaryService().deleteRoleMilitary(param);

			int mid = this.getAutoIdService().fingKeyValueByTableName(
					"role_military");
			boolean bo = false;
			param.clear();
			param.put("militaryid", resultcomposeid);
			param.put("name", gamemilitary.get(0).getName());
			param.put("wuqi", 0);
			param.put("huwan", 0);
			param.put("shipin", 0);
			param.put("touguan", 0);
			param.put("yifu", 0);
			param.put("xiezi", 0);
			param.put("challenge", 0);
			param.put("xltype", 0);
			param.put("roleId", roleid);
			// param.put("id",mid);
			param.put("id", sjid);

			param.put("level", rm.get(0).getLevel());
			param.put("type", rm.get(0).getType());
			param.put("types", rm.get(0).getTypes());
			param.put("exp", rm.get(0).getExp());
			param.put("fuben", rm.get(0).getFuben());
			param.put("bing", rm.get(0).getBing());
			System.out.println("bingstatus:"+rm.get(0).getBingstatus());
			String bingstatus = rm.get(0).getBingstatus();
			char[] bingstatusAry = bingstatus.toCharArray();
			System.out.println(bingstatusAry.length);
			System.out.println("bingstatusAry[0] != '1'   对吗:"+ (bingstatusAry[0] != '1'));
			if(bingstatusAry.length == 1){
				if(bingstatusAry[0] != '1'){
					rm.get(0).setBingstatus("1");
					System.out.println("强制修改为1");
					Map<String, Object> param_temp = new HashMap<String, Object>();
					param.put("bingstatusAry", "1");
				}
			}else{
				System.out.println(rm.get(0).getBingstatus());
				param.put("bingstatus", rm.get(0).getBingstatus());
			}

			bo = this.getRoleMilitaryService().insertRoleMilitary(param);
			// System.out.println(li+"合成需要的所有的魔将：：：：：：：：：：：");
			if (bo == true) {
				// this.getAutoIdService()
				// .updateKeyValueAddOneByTableName(
				// "role_military");
				// System.out.println("合成魔将结束：：：：：：：：");
			}

			rm = null;

			GameRoleDetail role = this.getGameRoleService()
					.findRoleById(roleid);
			
			// 发送广播
			UtilHandler util = new UtilHandler();
			String name = role.getName();
			int vip = role.getVip();
			String where = "魔将转世";
			int pinzhi = gamemilitary.get(0).getPingzhi();
			String goodsName = gamemilitary.get(0).getName();
			util.sendGetMessage(name, vip, where, pinzhi, goodsName,"xiulian_zhuanshi");
			
			rlt.put("devil", maparray);
			rlt.put("equips", roleMilitaryMap);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
			// GameRole role = this.getGameRoleService().findRoleById(roleid);
			String state0 = role.getAimreward();
			JSONArray aimreward = JSONArray.fromObject(state0);// 目标大奖状态
			if (aimreward.getInt(5) == 0) {// 6。完成一次魔将转生
				aimreward.set(5, 1);
				param.clear();
				param.put("id", roleid);
				param.put("aimreward", aimreward.toString());
				this.getGameRoleService().updateRoleVip(param);
			}
		}

	}

	private void openrisestar() {
		JSONArray roleMilitaryMap = new JSONArray();
		Map<String, Object> rlt = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int roleid = Integer.parseInt(String.valueOf(playerId));
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("roleId", roleid);
		List<RoleEquipDetail> roleequips = this.getRoleEquipService()
				.getRoleEquip(param);
		int size = roleequips.size();
		for (int i = 0; i < size; i++) {
			int equipId = roleequips.get(i).getEquipId();
			// 根据equipid去gamerole表里查看此准备是否是星级
			List<GameEquipDetail> gameequips = this.getGameEquipService()
					.getGameEquipById(equipId);
			int isstar = gameequips.get(i).getIsstar();// 是否是星级（神）
			if (isstar == 1) {// 是星级
				// 得到装备的总攻击
				String equipname = gameequips.get(i).getEquipname();// 星级准备名字
				int type = gameequips.get(i).getType();// 星级装备类型
				param.clear();
				param.put("roleId", roleid);
				param.put("equipId", equipId);

				List<RoleEquipDetail> wq = this.getRoleEquipService()
						.getRoleEquipDetail(param);

				int gongji = (int) wq.get(0).getAttack();// 攻击
				int dengji = wq.get(0).getDengji();
				int starlevel = wq.get(0).getStarlevel();// 星级
				int levelexp = wq.get(0).getLevelexp();// 星级经验
				int qhdengji = wq.get(0).getDengji();// 强化等级
				double hp = wq.get(0).getHpMax();
				double rang = wq.get(0).getRectlength();
				double speed = wq.get(0).getSpeed();

				map.put("at", gongji);// 攻击
				map.put("dj", dengji);// 等级
				map.put("hp", hp);// 血量
				map.put("rect", rang);// 攻击范围
				map.put("sp", speed);// 攻击速度
				map.put("starlevel", starlevel);// 强化等级
				map.put("levelexp", levelexp);// 星级经验
				roleMilitaryMap.add(map);
				map.clear();

			}
		}
		rlt.put("xjmap", roleMilitaryMap);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);
		rlt.clear();

	}

	private void risestar() {// 星级装备升星
		if (params.containsKey("riseid") && params.containsKey("beiid")) {
			int nolevelexp = 0;
			JSONArray roleMilitaryMap = new JSONArray();
			Map<String, Object> rlt = new HashMap<String, Object>();
			Map<String, Object> map = new HashMap<String, Object>();
			int roleid = Integer.parseInt(String.valueOf(playerId));
			Map<String, Object> param = new HashMap<String, Object>();
			int allprice = 0;
			int dengji = 0;
			int dengji2 = 0;
			int sjid = Integer.parseInt(String.valueOf(params.get("riseid")));
			int sjeatid = Integer.parseInt(String.valueOf(params.get("beiid")));

			// System.out.println(sjid+"====equipId======"+sjeatid+"======eatId========");
			int levelexp;
			int starlevel;
			param.clear();
			param.put("id", sjid);
			param.put("roleId", roleid);
			List<RoleEquipDetail> stars = this.getRoleEquipService()
					.getRoleEquipDetail(param);

			int chiequipid = stars.get(0).getEquipId();
			List<GameEquipDetail> gameequips = this.getGameEquipService()
					.getGameEquipById(chiequipid);
			int beichiequipid = gameequips.get(0).getEatequipid();
			int isstar = gameequips.get(0).getIsstar();
			if (isstar == 0) {// 不能被炼化
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -4);
				ServerHandler.sendData(session, respMap);
				return;
			}
			if (!stars.isEmpty()) {
				int id = stars.get(0).getId();// roleEquip主键值
				int gongji = (int) stars.get(0).getAttack();// 攻击
				int xueliang = (int) stars.get(0).getHpMax();// 血量
				int gongxu = (int) stars.get(0).getSpeed();// 攻速
				int fanwei = (int) stars.get(0).getRectlength();// 范围
				starlevel = stars.get(0).getStarlevel();// 星级等级
				if (starlevel == 10) {// 不能在升星
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
					ServerHandler.sendData(session, respMap);
					return;
				}
				levelexp = stars.get(0).getLevelexp() + 1;// levelexp

				List<GameStarDetail> gs = this.getGameStarService()
						.getgamestars(starlevel);
				int needexp = gs.get(0).getLevelexp();// 升级下一级星级需要经验
				System.out.println("levleexp:" + levelexp + " needexp:" + needexp);
				if (levelexp < needexp) {// 没有达到升级要求,经验加1(需要消耗装备)
					param.clear();
					param.put("id", sjeatid);
					param.put("roleId", roleid);
					List<RoleEquipDetail> rq = this.getRoleEquipService()
							.getRoleEquipDetail(param);
					if (rq.isEmpty()) {
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-3);
						ServerHandler.sendData(session, respMap);
						return;
					}
					int eatid = rq.get(0).getEquipId();
					if (eatid != beichiequipid) {
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-5);
						ServerHandler.sendData(session, respMap);
						return;
					}
					GameEquipDetail gequip = this.getGameEquipService()
							.getGameEquipById(eatid).get(0);
					int delid = rq.get(0).getId();
					dengji = rq.get(0).getDengji();
					dengji2 = rq.get(0).getDengji();
					int type = gequip.getType();// 等级判断为1的

					// ........................
					int quallity = gequip.getQuality();// 品质

					gequip = null;
					// System.out.println("=======没有达到升级要求等级========"+dengji);
					if (dengji > 1) {// 等级大于0，返还玩家金钱，删除此装备
						while (dengji > 1) {
							double price = this.getGameEInsService()
									.getGameEInsById((dengji - 1)).get(0)
									.getPrice();// 强化所需银币
							price = price * Math.pow(1.414, (quallity - 1))
									* 0.7;
							if (type == 1) {
								price = price * 1.5;
							}
							allprice += price;
							dengji--;
						}
						this.getGameRoleService().addRoleYin(roleid, allprice);// 增加银币
						param.clear();
						param.put("roleId", roleid);
						param.put("id", delid);
						this.getRoleEquipService().deleteRoleEquip(param);
					} else {// 直接删除此装备
						param.clear();
						param.put("roleId", roleid);
						param.put("id", delid);
						this.getRoleEquipService().deleteRoleEquip(param);
					}
				} else {// 可以升级，星级加1，经验置0(需要消耗装备)
					starlevel++;
					levelexp = 0;
					param.clear();
					param.put("id", sjeatid);
					List<RoleEquipDetail> rq = this.getRoleEquipService()
							.getRoleEquipDetail(param);
					System.out.println("XiulianHandler:param:" + param.toString());
					int eatid = rq.get(0).getEquipId();
					if (eatid != beichiequipid) {
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-5);
						ServerHandler.sendData(session, respMap);
						return;
					}
					GameEquipDetail gequip = this.getGameEquipService()
							.getGameEquipById(eatid).get(0);
					int delid = rq.get(0).getId();
					dengji = rq.get(0).getDengji();
					dengji2 = dengji;
					int type = gequip.getType();// 等级判断为1的
					// ........................
					int quallity = gequip.getQuality();// 品质

					gequip = null;

					// System.out.println("达到升级邀请dengji====="+dengji);

					if (dengji > 1) {// 等级大于0，返还玩家金钱，删除此装备
						// for(int i=1;i<dengji;i++){
						while (dengji > 1) {
							double price = this.getGameEInsService()
									.getGameEInsById((dengji - 1)).get(0)
									.getPrice();// 强化所需银币
							price = price * Math.pow(1.414, (quallity - 1))
									* 0.7;
							if (type == 1) {
								price = price * 1.5;
							}
							allprice += price;
							dengji--;
						}
						this.getGameRoleService().addRoleYin(roleid, allprice);// 增加银币
						param.clear();
						param.put("roleId", roleid);
						param.put("id", delid);
						this.getRoleEquipService().deleteRoleEquip(param);
					} else {// 直接删除此装备
						param.clear();
						param.put("roleId", roleid);
						param.put("id", delid);
						this.getRoleEquipService().deleteRoleEquip(param);
					}
					GameRoleDetail role = this.getGameRoleService()
							.findRoleById(roleid);
					List<GameEquipDetail> equips = this.getGameEquipService()
							.getGameEquipByEid(rq.get(0).getEquipId());
					System.out.println("XiulianHandler:rq:" + rq.get(0).getEquipId() );
					System.out.println("XiulianHandler:equips.size:" + equips.size());
					// 发送广播
//					String message = "玩家 <font color=\"#FFFF00\">"
//							+ role.getName() + "</font>" + role.getVip()
//							+ "将 <font color=\"#"
//							+ GlobalData.color.get(equips.get(0).getQuality())
//							+ "\">" + equips.get(0).getEquipname()
//							+ "</font> 炼化到了 <font color=\"#"
//							+ GlobalData.color.get(equips.get(0).getQuality())
//							+ "\">" + starlevel + " 星</font>";
//					GameConstants.log
//							.warn("XiulianHandler.risestar:" + message);
//					this.getsystemHandler().addMessage(message);
					UtilHandler util = new UtilHandler();
					String name = role.getName();
					int vip = role.getVip();
					String where = "装备炼化";
					int pinzhi = equips.get(0).getQuality();
					String goodsName = starlevel+"星"+equips.get(0).getEquipname();
					util.sendGetMessage(name, vip, where, pinzhi, goodsName,"xiulian_lianhua");
				}
				param.clear();
				param.put("starlevel", starlevel);
				param.put("levelexp", levelexp);
				param.put("id", sjid);
				this.getRoleEquipService().updateRoleEquipByIdtwo(param);// 更新攻击等值
				rlt.put("starlevel", starlevel);// 强化等级
				rlt.put("levelexp", levelexp);// 星级经验
				GameRoleDetail gameRole = this.getGameRoleService()
						.findRoleById(roleid);
				int yin = gameRole.getYin();// 用户的所有金币
				rlt.put("riseid", sjid);//
				rlt.put("beiid", sjeatid);// allprice
				rlt.put("allprice", yin);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
				rlt.clear();
			} else {
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
				ServerHandler.sendData(session, respMap);
				return;
			}
		}
	}

	private void showcharts() {// type=1：主公排名 2：群战排名 3：单挑排名
		if (params.containsKey("type") && params.containsKey("page")) {
			int roleid = Integer.parseInt(String.valueOf(playerId));
			// 根据Id查询玩家的名字
			GameRoleDetail gr = this.getGameRoleService().findRoleById(roleid);
			int serverid = Integer.valueOf(gr.getServerId());
			int mapd = 1;
			int type;
			int page;
			type = Integer.parseInt(String.valueOf(params.get("type")));
			page = Integer.parseInt(String.valueOf(params.get("page")));
			// System.out.println("得到的mapd:" + mapd);
			if (mapd < 11) {
				mapd = 1;
			} else if (mapd < 21 && mapd > 10) {
				mapd = 2;
			} else if (mapd < 31 && mapd > 20) {
				mapd = 3;
			} else if (mapd < 41 && mapd > 30) {
				mapd = 4;
			} else if (mapd < 51 && mapd > 40) {
				mapd = 5;
			} else if (mapd < 61 && mapd > 50) {
				mapd = 6;
			}
			// System.out.println("得到的mapd:" + mapd);
			// System.out.println(type+"是接收到的type,"+page+"是接收到的page");
			if (type == 1) {
				// List<GameChartsDetail>
				// alllies=this.getgameChartsService().findalllie();
				// int totalRows=alllies.size();
				int totalRows = 500;
				int maxpage;
				if (totalRows == 0) {
					maxpage = 1;// 没有记录认为1页
				} else if (totalRows % 15 == 0) {
					maxpage = totalRows / 15;
				} else {
					maxpage = totalRows / 15 + 1;
				}
				if (maxpage < page) {// 传过来的页数大于最大页数，给前端返回错误信息，不向下执行
					page = maxpage;
				}
				if (page < 1) {
					page = 1;
				}
				int page2 = (page - 1) * 15;

				// List<GameChartsDetail> gamecharts =
				// this.getgameChartsService().getid(roleid);
				Map<String, Object> paramt = new HashMap<String, Object>();
				paramt.put("type", 1);
				paramt.put("roleid", roleid);
				paramt.put("serverid", serverid);
				List<GameChartsDetail> gamecharts = this.getgameChartsService()
						.getidByParamt(paramt);
				int mingci = 0;
				if (gamecharts.size() == 0) {
				} else {
					mingci = gamecharts.get(0).getId();
				}
				Map<String, Object> param = new HashMap<String, Object>();
				Map<String, Object> rlt = new HashMap<String, Object>();
				Map<String, Object> map = new HashMap<String, Object>();
				JSONArray roleMilitaryMap = new JSONArray();
				param.put("type", 1);
				param.put("page", page2);
				param.put("size", 15);
				param.put("serverid", serverid);
				param.put("mapd", mapd);
				// System.out.println("XiulianHandler:showchars:param:" +
				// param.toString());
				List<GameChartsDetail> gameCharts = this.getgameChartsService()
						.findByNum(param);
				// System.out.println("gameCharts.size:" +
				// gameCharts.toString());
				int size = gameCharts.size();
				for (int i = 0; i < size; i++) {// 循环得到主公排名的信息
					GameChartsDetail gameChart = new GameChartsDetail();
					gameChart = gameCharts.get(i);
					/****/
					// String name=gameChart.getName();
					int id = gameChart.getRoleId();
					int huangzuan = 0;
					int huangzuanlevel = 0;
					int yearzuan = 0;
					JsonSerializer json = new JsonSerializer();
					String Huangzuaninfo = this.getGameRoleService()
							.findRoleById(id).getHuangzuaninfo();
					if ("null".equals(String.valueOf(Huangzuaninfo))) {
						huangzuanlevel = 0;
						yearzuan = 0;
					} else {
						List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
								.deserialize(Huangzuaninfo);
						int ret = Integer.parseInt(String.valueOf(roleinfo.get(
								0).get("ret")));
						if (ret == 0) {
							huangzuan = Integer.parseInt(String
									.valueOf(roleinfo.get(0).get(
											"is_yellow_vip")));
							if (huangzuan == 0) {
								huangzuanlevel = 0;
								yearzuan = 0;
							} else {
								huangzuanlevel = Integer.parseInt(String
										.valueOf(roleinfo.get(0).get(
												"yellow_vip_level")));
								yearzuan = Integer.parseInt(String
										.valueOf(roleinfo.get(0).get(
												"is_yellow_high_vip")));
							}
						}
					}
					map.put("key1", (page - 1) * 15 + i + 1);// 名次
					map.put("key2", gameChart.getTop());
					map.put("key3", gameChart.getHot());
					map.put("key4", gameChart.getNums());
					map.put("key5", gameChart.getName());
					map.put("key6", huangzuanlevel);
					map.put("key7", yearzuan);
					roleMilitaryMap.add(map);
					map.clear();
					int j = i + 1;
				}
				rlt.put("master", roleMilitaryMap);
				rlt.put("type", type);
				rlt.put("page", page);
				rlt.put("maxpage", maxpage);
				rlt.put("mingci", mingci);
				rlt.put("map", mapd);
				// System.out.println(mingci+"主公名次================================");
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
				rlt.clear();
			} else if (type == 2) {// 群战排名
				// List<GameChartsDetail>
				// alllies=this.getgameChartsService().findallliet();
				// int totalRows=alllies.size();
				int totalRows = 500;
				int maxpage;
				if (totalRows == 0) {
					maxpage = 1;// 没有记录认为1页
				} else if (totalRows % 15 == 0) {
					maxpage = totalRows / 15;
				} else {
					maxpage = totalRows / 15 + 1;
				}
				if (maxpage < page) {// 传过来的页数大于最大页数，给前端返回错误信息，不向下执行
					page = maxpage;

				}
				if (page < 1) {
					page = 1;
				}
				int page2 = (page - 1) * 15;
				// List<GameChartsDetail>
				// gamecharts2=this.getgameChartsService().getidqz(roleid);
				Map<String, Object> paramt = new HashMap<String, Object>();
				paramt.put("type", 2);
				paramt.put("roleid", roleid);
				paramt.put("serverid", serverid);
				List<GameChartsDetail> gamecharts2 = this
						.getgameChartsService().getidByParamt(paramt);
				int mingci2 = 0;
				if (gamecharts2.size() == 0) {
				} else {
					mingci2 = gamecharts2.get(0).getId();
				}
				Map<String, Object> param = new HashMap<String, Object>();
				Map<String, Object> rlt = new HashMap<String, Object>();
				Map<String, Object> map = new HashMap<String, Object>();
				JSONArray roleMilitaryMap = new JSONArray();
				param.put("type", 1);
				param.put("page", page2);
				param.put("size", 15);
				param.put("serverid", serverid);
				param.put("mapd", mapd);
				List<GameChartsDetail> gameCharts = this.getgameChartsService()
						.findByQZ(param);
				int size = gameCharts.size();
				for (int i = 0; i < size; i++) {// 循环得到主公排名的信息
					GameChartsDetail gameChart = new GameChartsDetail();
					gameChart = gameCharts.get(i);
					/****/
					// String name=gameChart.getName();
					int id = gameChart.getRoleId();
					int huangzuan = 0;
					int huangzuanlevel = 0;
					int yearzuan = 0;
					JsonSerializer json = new JsonSerializer();
					// String Huangzuaninfo =
					// this.getGameRoleService().findRoleByName(name).getHuangzuaninfo();
					String Huangzuaninfo = this.getGameRoleService()
							.findRoleById(id).getHuangzuaninfo();
					if ("null".equals(String.valueOf(Huangzuaninfo))) {
						huangzuanlevel = 0;
						yearzuan = 0;
					} else {
						List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
								.deserialize(Huangzuaninfo);
						int ret = Integer.parseInt(String.valueOf(roleinfo.get(
								0).get("ret")));
						if (ret == 0) {
							huangzuan = Integer.parseInt(String
									.valueOf(roleinfo.get(0).get(
											"is_yellow_vip")));
							if (huangzuan == 0) {
								huangzuanlevel = 0;
								yearzuan = 0;
							} else {
								huangzuanlevel = Integer.parseInt(String
										.valueOf(roleinfo.get(0).get(
												"yellow_vip_level")));
								yearzuan = Integer.parseInt(String
										.valueOf(roleinfo.get(0).get(
												"is_yellow_high_vip")));
							}
						}
					}
					map.put("key1", (page - 1) * 15 + i + 1);// 名次
					map.put("key2", gameChart.getTop());
					map.put("key3", gameChart.getHot());
					map.put("key4", gameChart.getAttack());
					map.put("key5", gameChart.getName());
					map.put("key6", huangzuanlevel);
					map.put("key7", yearzuan);
					roleMilitaryMap.add(map);
					map.clear();
					int j = i + 1;
				}
				rlt.put("master", roleMilitaryMap);
				rlt.put("type", type);
				rlt.put("page", page);
				rlt.put("maxpage", maxpage);
				rlt.put("mingci", mingci2);
				rlt.put("map", mapd);
				// System.out.println(mingci2+"群战名次================================");
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
				rlt.clear();
			} else {// 单挑排名
					// List<GameChartsDetail>
					// alllies=this.getgameChartsService().findalllief();
					// int totalRows=alllies.size();
				int totalRows = 500;
				int maxpage;
				if (totalRows == 0) {
					maxpage = 1;// 没有记录认为1页
				} else if (totalRows % 15 == 0) {
					maxpage = totalRows / 15;
				} else {
					maxpage = totalRows / 15 + 1;
				}
				if (maxpage < page) {// 传过来的页数大于最大页数，给前端返回错误信息，不向下执行
					page = maxpage;

				}
				if (page < 1) {
					page = 1;
				}
				int page2 = (page - 1) * 15;
				// List<GameChartsDetail>
				// gamecharts3=this.getgameChartsService().getiddt(roleid);
				Map<String, Object> paramt = new HashMap<String, Object>();
				paramt.put("type", 3);
				paramt.put("roleid", roleid);
				paramt.put("serverid", serverid);
				List<GameChartsDetail> gamecharts3 = this
						.getgameChartsService().getidByParamt(paramt);
				int mingci3 = 0;
				if (gamecharts3.size() == 0) {
				} else {
					mingci3 = gamecharts3.get(0).getId();
				}
				Map<String, Object> param = new HashMap<String, Object>();
				Map<String, Object> rlt = new HashMap<String, Object>();
				Map<String, Object> map = new HashMap<String, Object>();
				JSONArray roleMilitaryMap = new JSONArray();
				param.put("type", 1);
				param.put("page", page2);
				param.put("size", 15);
				param.put("serverid", serverid);
				param.put("mapd", mapd);
				List<GameChartsDetail> gameCharts = this.getgameChartsService()
						.findByDT(param);
				int size = gameCharts.size();
				for (int i = 0; i < size; i++) {// 循环得到主公排名的信息
					GameChartsDetail gameChart = new GameChartsDetail();
					gameChart = gameCharts.get(i);
					/****/
					String name = gameChart.getName();
					int id = gameChart.getRoleId();
					int huangzuan = 0;
					int huangzuanlevel = 0;
					int yearzuan = 0;
					JsonSerializer json = new JsonSerializer();
					// String Huangzuaninfo =
					// this.getGameRoleService().findRoleByName(name).getHuangzuaninfo();
					String Huangzuaninfo = this.getGameRoleService()
							.findRoleById(id).getHuangzuaninfo();
					if ("null".equals(String.valueOf(Huangzuaninfo))) {
						huangzuanlevel = 0;
						yearzuan = 0;
					} else {
						List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
								.deserialize(Huangzuaninfo);
						int ret = Integer.parseInt(String.valueOf(roleinfo.get(
								0).get("ret")));
						if (ret == 0) {
							huangzuan = Integer.parseInt(String
									.valueOf(roleinfo.get(0).get(
											"is_yellow_vip")));
							if (huangzuan == 0) {
								huangzuanlevel = 0;
								yearzuan = 0;
							} else {
								huangzuanlevel = Integer.parseInt(String
										.valueOf(roleinfo.get(0).get(
												"yellow_vip_level")));
								yearzuan = Integer.parseInt(String
										.valueOf(roleinfo.get(0).get(
												"is_yellow_high_vip")));
							}
						}
					}
					map.put("key1", (page - 1) * 15 + i + 1);// 名次
					map.put("key2", gameChart.getRole_name());// 魔将名字
					map.put("key3", gameChart.getOneattack());
					map.put("key4", gameChart.getBlood());
					map.put("key5", gameChart.getName());
					map.put("key6", huangzuanlevel);
					map.put("key7", yearzuan);
					roleMilitaryMap.add(map);
					map.clear();
					int j = i + 1;
				}
				rlt.put("master", roleMilitaryMap);
				rlt.put("type", type);
				rlt.put("page", page);
				rlt.put("maxpage", maxpage);
				rlt.put("mingci", mingci3);
				rlt.put("map", mapd);
				// System.out.println(mingci3+"单挑名次================================");

				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
				rlt.clear();
			}
		}
	}

	private void quicken() {
		// if (params.containsKey("bid")){//武将id存在
		int roleid = Integer.parseInt(String.valueOf(playerId));

		Map<String, Object> param = new HashMap<String, Object>();// 存放加速时间
		Map<String, Object> param1 = new HashMap<String, Object>();// 存放加速卡
		Map<String, Object> rlt = new HashMap<String, Object>();// 存放发送数据
																// 武将的等级和经验
		param.put("roleid", roleid);
		param1.put("roleid", roleid);
		param1.put("itemid", 2);

		long now = new Date().getTime();

		// 查看加速卡道具(属于role)
		List<RoleItemDetail> items = this.getRoleItemService().getRoleItem(
				param1);
		long bidj = 0;
		int numj = 0;
		if (items.isEmpty()) {
			bidj = 0;
			numj = 0;
		} else if (!items.isEmpty()) {
			numj = items.get(0).getNum();
			bidj = items.get(0).getId();
		}

		List<RoleQuicktimeDetail> quick = this.getRoleQuicktimeService()
				.getQuicktime(param);
		if (!quick.isEmpty()) {// 若quicktime表不是空
			// 获得冷却时间
			long quicktime = this.getRoleQuicktimeService()
					.getQuicktime(param1).get(0).getQuicktime();
			long temptime = quicktime - now;// 单位毫秒s
			// 判断时间
			if ((quicktime - now) > 0) {// 有冷却时间
				if (numj > 0) {// 有加速卡 消耗加速卡 把冷却时间设为0
					param1.put("num", 1);
					boolean bo = this.getRoleItemService()
							.sbRoleItemNum(param1);// 更新道具数量
					if (bo == true) {// 道具减少成功
						param.put("quicktime", 0);
						this.getRoleQuicktimeService().updateQuicktime(param);

						rlt.put("roleid", roleid);
						rlt.put("quicktime", 0);
						rlt.put("numj", numj - 1);
						rlt.put("bidj", bidj);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								GameConstants.GAME_API_SUCCESS);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
								rlt);
						ServerHandler.sendData(session, respMap);
					} else {// 道具减少不成功
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-2);// 减少道具失败
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
								"");
						ServerHandler.sendData(session, respMap);

					}

				} else if (numj == 0) {// 没有加速卡 不改变时间
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);// 减少道具失败
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "");
					ServerHandler.sendData(session, respMap);
				}

			} else if (quicktime == 0 || (quicktime - now) <= 0) {// 没有冷却时间，不需要加速
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "");
				ServerHandler.sendData(session, respMap);
			}
		} else if (quick.isEmpty()) {// quicktime表里是空
			RoleQuicktimeDetail detail = new RoleQuicktimeDetail();
			detail.setRoleid(roleid);
			detail.setQuicktime(0);
			// 插入数据就行，不用判断
			this.getRoleQuicktimeService().insertRolequicktime(detail);

			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);// 减少道具失败
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "");
			ServerHandler.sendData(session, respMap);

		}

	}

	private void quxl() {
		if (params.containsKey("bid") && params.containsKey("t")) {// 武将id存在
			int roleid = Integer.parseInt(String.valueOf(playerId));
			int t = NumberUtils.createInteger(String.valueOf(params.get("t")));
			int bid = Integer.parseInt(String.valueOf(params.get("bid")));
			Map<String, Object> rlt = new HashMap<String, Object>();// 存放发送数据
																	// 武将的等级和经验
			int level = this.getGameRoleService().findRoleById(roleid)
					.getLevel();// 查看人物等级
			Map<String, Object> param1 = new HashMap<String, Object>();// 存放冷却时间
			param1.put("roleid", roleid);
			// 该等级下最高经验 总经验
			int allexp = this.getGameMLevelService()
					.getGameMLevelBylevel(level).get(0).getAllexp();
			int gameexpn = this.getGameMlevelService()
					.getGameMLevelBylevel(level).get(0).getExp();
			// 查看人物武将等级和经验
			Map<String, Object> ps = new HashMap<String, Object>();
			ps.put("roleId", roleid);
			ps.put("id", bid);
			// 武将信息
			RoleMilitaryDetail mrole = this.getRoleMilitaryService()
					.getRoleMilitaryByparam(ps).get(0);
			int mlevel = mrole.getLevel();// 目前的等级
			int mexpn = mrole.getExp();// 目前的经验
			int e = 0;
			if (mlevel > 1) {
				e = this.getGameMLevelService()
						.getGameMLevelBylevel(mlevel - 1).get(0).getAllexp();
				// 上一级的经验
			}
			int mexp = mrole.getExp() + 100 + e;// 武将增加经验后的总经验
			// 判断时间问题
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
			if (t == 2) {// 使用加速符的一键修炼
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("roleid", roleid);
				param.put("itemid", 9);
				// 查看道具(属于role)，items
				List<RoleItemDetail> items = this.getRoleItemService()
						.getRoleItemByitem(param);
				if (mlevel > level) {
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -4);// 武将等级不能超出人物等级
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "");
					ServerHandler.sendData(session, respMap);
				} else {
					long now = new Date().getTime();
					// 获得冷却时间
					long quicktime = this.getRoleQuicktimeService()
							.getQuicktime(param1).get(0).getQuicktime();
					long temptime = quicktime - now;// 获取差时
					if (temptime < 10 * 60 * 1000) {// 冷却时间在0~10分钟之间
						if (!items.isEmpty()) {// 道具存在
							int numdan = this.getRoleItemService()
									.getRoleItem(param).get(0).getNum();
							long bidy = this.getRoleItemService()
									.getRoleItem(param).get(0).getId();
							param.put("num", 1);// 道具减少1
							boolean bo = this.getRoleItemService().subRoleItem(
									param);// 更新道具数量
							if (bo == true) {// 道具减少成功
								// 增加后的经验和对应level比较
								int newlv = this.getGameMLevelService()
										.getGameMLevelByAllexp(mexp).get(0)
										.getLevel();
								// 武将下一级的信息：升到下一级所需的经验，总经验，等级。
								GameMLevelDetail game = this
										.getGameMLevelService()
										.getGameMLevelByAllexp(mexp).get(0);
								int gameexp = game.getExp();
								int gameAllexp = game.getAllexp();
								Map<String, Object> mps = new HashMap<String, Object>();
								mps.put("id", bid);
								mps.put("roleId", roleid);
								if (newlv > mlevel) {// 若升级
									if (newlv > level) {
										param.clear();
										param.put("roleid", roleid);
										param.put("itemid", 9);
										param.put("num", 1);// 道具加1
										this.getRoleItemService()
												.addRoleItemNum(param);

										respMap.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
												-4);// 不能超出人物等级
										respMap.put(
												GameConstants.GAME_API_RESPONSE_FIELD_RLT,
												"");
										ServerHandler
												.sendData(session, respMap);

									} else {
										if (quicktime - now <= 0) {
											param1.put("quicktime",
													now + 90 * 1000);
											this.getRoleQuicktimeService()
													.updateQuicktime(param1);
											rlt.put("temptime", 90 * 1000);
										} else if (quicktime - now > 0) {
											param1.put("quicktime",
													quicktime + 90 * 1000);
											this.getRoleQuicktimeService()
													.updateQuicktime(param1);
											rlt.put("temptime", quicktime - now
													+ 90 * 1000);
										}
										mps.put("level", mlevel + 1);
										mps.put("exp", gameexp
												- (gameAllexp - mexp));
										// mexp:武将增加经验后的总经验
										// gameAllexp:武将增加经验后的等级对应的总经验
										// gameexp:该等级所需要的经验
										boolean bo0 = this
												.getRoleMilitaryService()
												.addMilitayExp(mps);
										ps.clear();
										ps.put("roleId", roleid);
										ps.put("id", bid);
										mrole = this.getRoleMilitaryService()
												.getRoleMilitaryByparam(ps)
												.get(0);
										// 存放武将的信息，等级，经验
										rlt.put("bid", bid);
										rlt.put("bidy", bidy);
										rlt.put("level", mrole.getLevel());
										rlt.put("exp", mrole.getExp());
										rlt.put("numdan", numdan - 1);
										respMap.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
												GameConstants.GAME_API_SUCCESS);
										respMap.put(
												GameConstants.GAME_API_RESPONSE_FIELD_RLT,
												rlt);
										ServerHandler
												.sendData(session, respMap);
										// 判断任务是否完成
										this.getTaskHandler().taskcomplete(
												roleid);
									}
								} else {// 若不升级
									if (quicktime - now <= 0) {
										param1.put("quicktime", now + 90 * 1000);
										this.getRoleQuicktimeService()
												.updateQuicktime(param1);
										rlt.put("temptime", 90 * 1000);
									} else if (quicktime - now > 0) {
										param1.put("quicktime",
												quicktime + 90 * 1000);
										this.getRoleQuicktimeService()
												.updateQuicktime(param1);
										rlt.put("temptime", quicktime - now
												+ 90 * 1000);
									}

									mps.put("level", mlevel);
									mps.put("exp", mexpn + 100);
									// mexp:武将增加经验后的总经验
									// gameAllexp:武将增加经验后的等级对应的总经验
									// gameexp:该等级所需要的经验
									boolean bo0 = this.getRoleMilitaryService()
											.addMilitayExp(mps);
									ps.clear();
									ps.put("roleId", roleid);
									ps.put("id", bid);
									mrole = this.getRoleMilitaryService()
											.getRoleMilitaryByparam(ps).get(0);
									// 存放武将的信息，等级，经验
									rlt.put("bid", bid);
									rlt.put("bidy", bidy);
									rlt.put("level", mrole.getLevel());
									rlt.put("exp", mrole.getExp());
									rlt.put("numdan", numdan - 1);
									respMap.put(
											GameConstants.GAME_API_RESPONSE_FIELD_CODE,
											GameConstants.GAME_API_SUCCESS);
									respMap.put(
											GameConstants.GAME_API_RESPONSE_FIELD_RLT,
											rlt);
									ServerHandler.sendData(session, respMap);

								}

							} else {// 道具减少不成功
								respMap.put(
										GameConstants.GAME_API_RESPONSE_FIELD_CODE,
										-2);// 道具不存在
								respMap.put(
										GameConstants.GAME_API_RESPONSE_FIELD_RLT,
										"");
								ServerHandler.sendData(session, respMap);
							}
						} else {// 道具不存在
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									-1);// 道具不存在
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_RLT,
									"");
							ServerHandler.sendData(session, respMap);
						}

						// .............................................
					} else if (temptime >= 10 * 60 * 1000) {
						// 冷却时间大于10分钟
						param.put("roleid", roleid);
						param1.put("roleid", roleid);
						param1.put("itemid", 2);
						int numdan = this.getRoleItemService()
								.getRoleItem(param).get(0).getNum();// 经验丹数量
						// 查看加速卡道具(属于role)
						List<RoleItemDetail> items1 = this.getRoleItemService()
								.getRoleItem(param1);
						long jid = 0;
						int numj = 0;
						if (items1.isEmpty()) {
							jid = 0;
							numj = 0;
						} else if (!items1.isEmpty()) {
							numj = items1.get(0).getNum();
							jid = items1.get(0).getId();
						}
						if (!quick.isEmpty()) {// 若quicktime表不是空
							// 判断时间
							if ((quicktime - now) > 0) {// 有冷却时间
								if (numj > 0) {// 有加速卡 消耗加速卡 把冷却时间设为0
									param1.put("num", 1);
									boolean bo = this.getRoleItemService()
											.sbRoleItemNum(param1);// 更新道具数量
									if (bo == true) {// 道具减少成功
										param.put("quicktime", 0);
										this.getRoleQuicktimeService()
												.updateQuicktime(param);

										rlt.put("roleid", roleid);
										rlt.put("quicktime", 0);
										rlt.put("numj", numj - 1);
										rlt.put("jid", jid);
										rlt.put("numdan", numdan);
										respMap.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
												GameConstants.GAME_API_SUCCESS);
										respMap.put(
												GameConstants.GAME_API_RESPONSE_FIELD_RLT,
												rlt);
									} else {// 道具减少不成功
										respMap.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
												-2);// 减少道具失败
										respMap.put(
												GameConstants.GAME_API_RESPONSE_FIELD_RLT,
												"");

									}

								} else if (numj == 0) {// 没有加速卡 不改变时间
									respMap.put(
											GameConstants.GAME_API_RESPONSE_FIELD_CODE,
											-6);
									respMap.put(
											GameConstants.GAME_API_RESPONSE_FIELD_RLT,
											"");
									// 减少道具失败
								}

							} else if (quicktime == 0 || (quicktime - now) <= 0) {// 没有冷却时间，不需要加速
								respMap.put(
										GameConstants.GAME_API_RESPONSE_FIELD_CODE,
										-3);
								respMap.put(
										GameConstants.GAME_API_RESPONSE_FIELD_RLT,
										"");
							}
						} else if (quick.isEmpty()) {// quicktime表里是空
							RoleQuicktimeDetail detail = new RoleQuicktimeDetail();
							detail.setRoleid(roleid);
							detail.setQuicktime(0);
							// 插入数据就行，不用判断
							this.getRoleQuicktimeService().insertRolequicktime(
									detail);

							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									-2);// 减少道具失败
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_RLT,
									"");

						}
						ServerHandler.sendData(session, respMap);
					}
				}
			} else if (t == 1) {// 快速修炼
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("roleid", roleid);
				param.put("itemid", 9);
				// 查看道具(属于role)，items
				List<RoleItemDetail> items = this.getRoleItemService()
						.getRoleItemByitem(param);
				if (mlevel > level) {
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -4);// 武将等级不能超出人物等级
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "");
					ServerHandler.sendData(session, respMap);
				} else {
					long now = new Date().getTime();
					// 获得冷却时间
					long quicktime = this.getRoleQuicktimeService()
							.getQuicktime(param1).get(0).getQuicktime();
					long temptime = quicktime - now;// 获取差时
					if (temptime < 10 * 60 * 1000) {// 冷却时间在0~10分钟之间
						if (!items.isEmpty()) {// 道具存在
							int numdan = this.getRoleItemService()
									.getRoleItem(param).get(0).getNum();
							long bidy = this.getRoleItemService()
									.getRoleItem(param).get(0).getId();
							param.put("num", 1);// 道具减少1
							boolean bo = this.getRoleItemService().subRoleItem(
									param);// 更新道具数量
							if (bo == true) {// 道具减少成功
								// 增加后的经验和对应level比较
								int newlv = this.getGameMLevelService()
										.getGameMLevelByAllexp(mexp).get(0)
										.getLevel();
								// 武将下一级的信息：升到下一级所需的经验，总经验，等级。
								GameMLevelDetail game = this
										.getGameMLevelService()
										.getGameMLevelByAllexp(mexp).get(0);
								int gameexp = game.getExp();
								int gameAllexp = game.getAllexp();
								Map<String, Object> mps = new HashMap<String, Object>();
								mps.put("id", bid);
								mps.put("roleId", roleid);
								if (newlv > mlevel) {// 若升级
									if (newlv > level) {
										param.clear();
										param.put("roleid", roleid);
										param.put("itemid", 9);
										param.put("num", 1);// 道具加1
										this.getRoleItemService()
												.addRoleItemNum(param);

										respMap.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
												-4);// 不能超出人物等级
										respMap.put(
												GameConstants.GAME_API_RESPONSE_FIELD_RLT,
												"");
										ServerHandler
												.sendData(session, respMap);

									} else {
										if (quicktime - now <= 0) {
											param1.put("quicktime",
													now + 90 * 1000);
											this.getRoleQuicktimeService()
													.updateQuicktime(param1);
											rlt.put("temptime", 90 * 1000);
										} else if (quicktime - now > 0) {
											param1.put("quicktime",
													quicktime + 90 * 1000);
											this.getRoleQuicktimeService()
													.updateQuicktime(param1);
											rlt.put("temptime", quicktime - now
													+ 90 * 1000);
										}
										mps.put("level", mlevel + 1);
										mps.put("exp", gameexp
												- (gameAllexp - mexp));
										// mexp:武将增加经验后的总经验
										// gameAllexp:武将增加经验后的等级对应的总经验
										// gameexp:该等级所需要的经验
										boolean bo0 = this
												.getRoleMilitaryService()
												.addMilitayExp(mps);
										ps.clear();
										ps.put("roleId", roleid);
										ps.put("id", bid);
										mrole = this.getRoleMilitaryService()
												.getRoleMilitaryByparam(ps)
												.get(0);
										// 存放武将的信息，等级，经验
										rlt.put("bid", bid);
										rlt.put("bidy", bidy);
										rlt.put("level", mrole.getLevel());
										rlt.put("exp", mrole.getExp());
										rlt.put("numdan", numdan - 1);
										respMap.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
												GameConstants.GAME_API_SUCCESS);
										respMap.put(
												GameConstants.GAME_API_RESPONSE_FIELD_RLT,
												rlt);
										ServerHandler
												.sendData(session, respMap);
										// 判断任务是否完成
										this.getTaskHandler().taskcomplete(
												roleid);
									}
								} else {// 若不升级
									if (quicktime - now <= 0) {
										param1.put("quicktime", now + 90 * 1000);
										this.getRoleQuicktimeService()
												.updateQuicktime(param1);
										rlt.put("temptime", 90 * 1000);
									} else if (quicktime - now > 0) {
										param1.put("quicktime",
												quicktime + 90 * 1000);
										this.getRoleQuicktimeService()
												.updateQuicktime(param1);
										rlt.put("temptime", quicktime - now
												+ 90 * 1000);
									}

									mps.put("level", mlevel);
									mps.put("exp", mexpn + 100);
									// mexp:武将增加经验后的总经验
									// gameAllexp:武将增加经验后的等级对应的总经验
									// gameexp:该等级所需要的经验
									boolean bo0 = this.getRoleMilitaryService()
											.addMilitayExp(mps);
									ps.clear();
									ps.put("roleId", roleid);
									ps.put("id", bid);
									mrole = this.getRoleMilitaryService()
											.getRoleMilitaryByparam(ps).get(0);
									// 存放武将的信息，等级，经验
									rlt.put("bid", bid);
									rlt.put("bidy", bidy);
									rlt.put("level", mrole.getLevel());
									rlt.put("exp", mrole.getExp());
									rlt.put("numdan", numdan - 1);
									respMap.put(
											GameConstants.GAME_API_RESPONSE_FIELD_CODE,
											GameConstants.GAME_API_SUCCESS);
									respMap.put(
											GameConstants.GAME_API_RESPONSE_FIELD_RLT,
											rlt);
									ServerHandler.sendData(session, respMap);

								}

							} else {// 道具减少不成功
								respMap.put(
										GameConstants.GAME_API_RESPONSE_FIELD_CODE,
										-2);// 道具不存在
								respMap.put(
										GameConstants.GAME_API_RESPONSE_FIELD_RLT,
										"");
								ServerHandler.sendData(session, respMap);
							}
						} else {// 道具不存在
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									-1);// 道具不存在
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_RLT,
									"");
							ServerHandler.sendData(session, respMap);
						}

						// .............................................
					} else if (temptime >= 10 * 60 * 1000) {
						// 冷却时间大于10分钟
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-5);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
								"冷却时间大于10分钟");
						ServerHandler.sendData(session, respMap);
					}
				}
			} else if (t == 3) {// 不使用加速符的一键修炼
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("roleid", roleid);
				param.put("itemid", 9);
				// 查看道具(属于role)，items
				List<RoleItemDetail> items = this.getRoleItemService()
						.getRoleItemByitem(param);
				if (mlevel > level) {
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -4);// 武将等级不能超出人物等级
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "");
					ServerHandler.sendData(session, respMap);
				} else {
					long now = new Date().getTime();
					// 获得冷却时间
					long quicktime = this.getRoleQuicktimeService()
							.getQuicktime(param1).get(0).getQuicktime();
					long temptime = quicktime - now;// 获取差时
					if (temptime < 10 * 60 * 1000) {// 冷却时间在0~10分钟之间
						if (!items.isEmpty()) {// 道具存在
							int numdan = this.getRoleItemService()
									.getRoleItem(param).get(0).getNum();
							long bidy = this.getRoleItemService()
									.getRoleItem(param).get(0).getId();
							param.put("num", 1);// 道具减少1
							boolean bo = this.getRoleItemService().subRoleItem(
									param);// 更新道具数量
							if (bo == true) {// 道具减少成功
								// 增加后的经验和对应level比较
								int newlv = this.getGameMLevelService()
										.getGameMLevelByAllexp(mexp).get(0)
										.getLevel();
								// 武将下一级的信息：升到下一级所需的经验，总经验，等级。
								GameMLevelDetail game = this
										.getGameMLevelService()
										.getGameMLevelByAllexp(mexp).get(0);
								int gameexp = game.getExp();
								int gameAllexp = game.getAllexp();
								Map<String, Object> mps = new HashMap<String, Object>();
								mps.put("id", bid);
								mps.put("roleId", roleid);
								if (newlv > mlevel) {// 若升级
									if (newlv > level) {
										param.clear();
										param.put("roleid", roleid);
										param.put("itemid", 9);
										param.put("num", 1);// 道具加1
										this.getRoleItemService()
												.addRoleItemNum(param);

										respMap.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
												-4);// 不能超出人物等级
										respMap.put(
												GameConstants.GAME_API_RESPONSE_FIELD_RLT,
												"");
										ServerHandler
												.sendData(session, respMap);

									} else {
										if (quicktime - now <= 0) {
											param1.put("quicktime",
													now + 90 * 1000);
											this.getRoleQuicktimeService()
													.updateQuicktime(param1);
											rlt.put("temptime", 90 * 1000);
										} else if (quicktime - now > 0) {
											param1.put("quicktime",
													quicktime + 90 * 1000);
											this.getRoleQuicktimeService()
													.updateQuicktime(param1);
											rlt.put("temptime", quicktime - now
													+ 90 * 1000);
										}
										mps.put("level", mlevel + 1);
										mps.put("exp", gameexp
												- (gameAllexp - mexp));
										// mexp:武将增加经验后的总经验
										// gameAllexp:武将增加经验后的等级对应的总经验
										// gameexp:该等级所需要的经验
										boolean bo0 = this
												.getRoleMilitaryService()
												.addMilitayExp(mps);
										ps.clear();
										ps.put("roleId", roleid);
										ps.put("id", bid);
										mrole = this.getRoleMilitaryService()
												.getRoleMilitaryByparam(ps)
												.get(0);
										// 存放武将的信息，等级，经验
										rlt.put("bid", bid);
										rlt.put("bidy", bidy);
										rlt.put("level", mrole.getLevel());
										rlt.put("exp", mrole.getExp());
										rlt.put("numdan", numdan - 1);
										respMap.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
												GameConstants.GAME_API_SUCCESS);
										respMap.put(
												GameConstants.GAME_API_RESPONSE_FIELD_RLT,
												rlt);
										ServerHandler
												.sendData(session, respMap);
										// 判断任务是否完成
										this.getTaskHandler().taskcomplete(
												roleid);
									}
								} else {// 若不升级
									if (quicktime - now <= 0) {
										param1.put("quicktime", now + 90 * 1000);
										this.getRoleQuicktimeService()
												.updateQuicktime(param1);
										rlt.put("temptime", 90 * 1000);
									} else if (quicktime - now > 0) {
										param1.put("quicktime",
												quicktime + 90 * 1000);
										this.getRoleQuicktimeService()
												.updateQuicktime(param1);
										rlt.put("temptime", quicktime - now
												+ 90 * 1000);
									}

									mps.put("level", mlevel);
									mps.put("exp", mexpn + 100);
									// mexp:武将增加经验后的总经验
									// gameAllexp:武将增加经验后的等级对应的总经验
									// gameexp:该等级所需要的经验
									boolean bo0 = this.getRoleMilitaryService()
											.addMilitayExp(mps);
									ps.clear();
									ps.put("roleId", roleid);
									ps.put("id", bid);
									mrole = this.getRoleMilitaryService()
											.getRoleMilitaryByparam(ps).get(0);
									// 存放武将的信息，等级，经验
									rlt.put("bid", bid);
									rlt.put("bidy", bidy);
									rlt.put("level", mrole.getLevel());
									rlt.put("exp", mrole.getExp());
									rlt.put("numdan", numdan - 1);
									respMap.put(
											GameConstants.GAME_API_RESPONSE_FIELD_CODE,
											GameConstants.GAME_API_SUCCESS);
									respMap.put(
											GameConstants.GAME_API_RESPONSE_FIELD_RLT,
											rlt);
									ServerHandler.sendData(session, respMap);

								}

							} else {// 道具减少不成功
								respMap.put(
										GameConstants.GAME_API_RESPONSE_FIELD_CODE,
										-2);// 道具不存在
								respMap.put(
										GameConstants.GAME_API_RESPONSE_FIELD_RLT,
										"");
								ServerHandler.sendData(session, respMap);
							}
						} else {// 道具不存在
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									-1);// 道具不存在
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_RLT,
									"");
							ServerHandler.sendData(session, respMap);
						}

						// .............................................
					} else if (temptime >= 10 * 60 * 1000) {
						// 冷却时间大于10分钟
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-5);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
								"冷却时间大于10分钟");
						ServerHandler.sendData(session, respMap);
					}
				}
			}
		} else {// 武将id不存在
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);// 武将不存在
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "");
			ServerHandler.sendData(session, respMap);
		}

	}

	private void delxl() {
		if (params.containsKey("bid")) {
			int roleid = Integer.parseInt(playerId);
			int bid = Integer.parseInt(String.valueOf(params.get("bid")));
			long now = new Date().getTime();

			Map<String, Object> ps = new HashMap<String, Object>();
			Map<String, Object> maps = new HashMap<String, Object>();
			Map<String, Object> param = new HashMap<String, Object>();

			maps.clear();
			ps.put("roleId", roleid);
			ps.put("id", bid);
			List<RoleMilitaryDetail> mtary = this.getRoleMilitaryService()
					.getRoleMilitaryByparam(ps);// 得到武将信息

			long time = mtary.get(0).getTime();// 得到武将的修炼时间
			int type = mtary.get(0).getXltype();// 得到武将的修炼类型
			int exp = mtary.get(0).getExp();// 武将当前经验
			int level = mtary.get(0).getLevel();// 武将当前等级

			long t = time - now;// 得到还剩下多少时间没有去修炼
			// 修改武将修炼状态

			maps.put("roleId", roleid);
			maps.put("id", bid);
			maps.put("time", 0);
			maps.put("xltype", 0);
			boolean bo = this.getRoleMilitaryService().updateRoleMilitary(maps);// 更新修炼状态

			int x = 0;
			if (type == 1) {
				// 修炼时间（//修炼得到的经验）
				x = (int) (8 * 60 * 60 * 1000 - t) / (1000 * 60);
				exp = exp + x;// 当前经验加修炼得到经验
			} else if (type == 2) {
				x = (int) (12 * 60 * 60 * 1000 - t) / (1000 * 60);
				exp = exp + x;
			} else if (type == 3) {
				x = (int) (24 * 60 * 60 * 1000 - t) / (1000 * 60);
				exp = exp + x;
			}
			if (level > 1) {
				exp = exp
						+ this.getGameMLevelService()
								.getGameMLevelBylevel(level - 1).get(0)
								.getAllexp();// 总的经验
			}

			List<GameMLevelDetail> all = this.getGameMLevelService()
					.getGameMLevelByAllexp(exp);
			// 根据总经验得到可以升级到哪个等级
			// 人物目前等级
			int levels = this.getGameRoleService().findRoleById(roleid)
					.getLevel();
			// 武将能拥有的最高经验
			List<GameMLevelDetail> as = this.getGameMlevelService()
					.getGameMLevelBylevel(levels);

			maps.clear();
			maps.put("roleId", roleid);
			maps.put("id", bid);
			int e = 0;
			int newlv = this.getGameMLevelService().getGameMLevelByAllexp(exp)
					.get(0).getLevel();
			int roleexp;
			if (newlv > levels) {
				int allexpz = this.getGameMLevelService()
						.getGameMLevelBylevel(level).get(0).getAllexp();
				int expz = this.getGameMLevelService()
						.getGameMLevelBylevel(level).get(0).getExp();
				Map<String, Object> mps = new HashMap<String, Object>();
				mps.put("id", mtary.get(0).getId());
				mps.put("roleId", roleid);
				mps.put("level", levels);
				mps.put("exp", expz - 1);
				param.put("level", levels);
				param.put("exp", expz - 1);
				boolean bo0 = this.getRoleMilitaryService().addMilitayExp(mps);
			} else {
				GameMLevelDetail game = this.getGameMLevelService()
						.getGameMLevelByAllexp(exp).get(0);
				int gameexp = game.getExp();
				int gameAllexp = game.getAllexp();
				Map<String, Object> mps = new HashMap<String, Object>();
				mps.put("id", mtary.get(0).getId());
				mps.put("roleId", roleid);
				mps.put("level", newlv);
				mps.put("exp", gameexp - (gameAllexp - exp));
				param.put("level", newlv);
				param.put("exp", gameexp - (gameAllexp - exp));
				// mexp:武将增加经验后的总经验
				// gameAllexp:武将增加经验后的等级对应的总经验
				// gameexp:该等级所需要的经验
				boolean bo0 = this.getRoleMilitaryService().addMilitayExp(mps);
			}
			maps.clear();
			param.put("bid", bid);

			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, param);
			ServerHandler.sendData(session, respMap);
		}

	}

	protected void computexl(int roleid) {// 八个小时//12小时
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("roleid", roleid);
		GameRoleDetail gamerole = this.getGameRoleService()
				.findRoleById(roleid);
		int levels = gamerole.getLevel();
		List<RoleMilitaryDetail> rolem = this.getRoleMilitaryService()
				.getRoleMilitary(roleid);
		long now = new Date().getTime();
		if (!rolem.isEmpty()) {
			param.clear();
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
							if (mlevel < levels) {
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
							}
						}
					}
				}
			}
		}
	}

	private void getXiulian() {
		if (params.containsKey("t") && params.containsKey("id")) {
			int roleid = Integer.parseInt(playerId);
			// 首先判断是否有钱
			GameRoleDetail role = this.getGameRoleService()
					.findRoleById(roleid);
			int vip = role.getVip();// 人物的vip，0,3
			// 可以有几个同时训练
			// 黄钻享受vip2待遇
			if (vip < 2) {
				int huangzuan = 0;
				JsonSerializer json = new JsonSerializer();
				String Huangzuaninfo = this.getGameRoleService()
						.findRoleById(roleid).getHuangzuaninfo();
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

			int train = this.getGameVipService().getGameVipByLe(vip).get(0)
					.getTrainTop();
			Map<String, Object> pa = new HashMap<String, Object>();
			pa.put("roleId", roleid);
			int xl = this.getRoleMilitaryService().getRoleMilitaryBynotType(pa)
					.size();
			// 判断时间问题

			Map<String, Object> param1 = new HashMap<String, Object>();
			param1.put("roleid", roleid);
			// 修炼类型1、2、3

			if (xl < train) {// 若还有修炼位置
				int t = Integer.parseInt(String.valueOf(params.get("t")));
				// 获取传入的t值
				int id = Integer.parseInt(String.valueOf(params.get("id")));
				// 获取人物id
				long now = new Date().getTime();
				Map<String, Object> params = new HashMap<String, Object>();
				Map<String, Object> rlt = new HashMap<String, Object>();
				Map<String, Object> ps = new HashMap<String, Object>();
				ps.put("roleId", roleid);
				ps.put("militaryid", id);
				// 武将目前等级
				int mlv = this.getRoleMilitaryService()
						.getRoleMilitaryByparam(ps).get(0).getLevel();
				// 修炼等级所需要的银币
				int yins = this.getGameMlevelService()
						.getGameMLevelBylevel(mlv).get(0).getXyin();
				int level = role.getLevel();
				int yin = role.getYin();
				// System.out.println("XiulianHandler.xiulian.mlv:" + mlv +
				// " level:" + level + " roleid:" + roleid + " militaryid:" +
				// id);
				if (mlv < level) {
					if (t == 1) {
						if (yin > (yins)) {
							List<RoleMilitaryDetail> list = this
									.getRoleMilitaryService()
									.getRoleMilitarytime(id, roleid);// 是不是在修炼
							// SELECT * FROM role_military WHERE roleId
							// =#roleId# and flag=1 and militaryid=#militaryid#
							if (list.size() != 0) {// 若是有这个人
								if (now < list.get(0).getTime()) {// 判断他的修炼时间，若是在修炼时间内
									respMap.put(
											GameConstants.GAME_API_RESPONSE_FIELD_CODE,
											-5);
									respMap.put(
											GameConstants.GAME_API_RESPONSE_FIELD_RLT,
											"正在修炼中");
									ServerHandler.sendData(session, respMap);
								} else {
									boolean bo = this.getGameRoleService()
											.subRoleYin(roleid, yins);
									params.put("militaryid", id);
									params.put("roleId", roleid);
									params.put("time", now + 8 * 60 * 60 * 1000);
									// params.put("time", now + 8 * 1000);
									params.put("xltype", 1);
									bo = this.getRoleMilitaryService()
											.updateRoleMilitarytime(params);
									if (bo == true) {// 更新成功
										rlt.put("time", 8 * 60 * 60 * 1000);
										rlt.put("xltype", 1);
										rlt.put("id", id);
										rlt.put("t", t);

										GameRoleDetail roles = this
												.getGameRoleService()
												.findRoleById(roleid);
										rlt.put("yin", roles.getYin());
										rlt.put("bid", list.get(0).getId());
										rlt.put("coin", roles.getCoin());
										respMap.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
												GameConstants.GAME_API_SUCCESS);

										respMap.put(
												GameConstants.GAME_API_RESPONSE_FIELD_RLT,
												rlt);
										ServerHandler
												.sendData(session, respMap);

									}
								}

							} else {
								boolean bo = this.getGameRoleService()
										.subRoleYin(roleid, yins);
								params.put("militaryid", id);
								params.put("roleId", roleid);
								params.put("time", now + 8 * 60 * 60 * 1000);
								params.put("xltype", 1);
								bo = this.getRoleMilitaryService()
										.updateRoleMilitarytime(params);
								if (bo == true) {
									rlt.put("time", 8 * 60 * 60 * 1000);
									rlt.put("xltype", 1);
									rlt.put("id", id);
									rlt.put("t", t);
									GameRoleDetail roles = this
											.getGameRoleService().findRoleById(
													roleid);
									rlt.put("yin", roles.getYin());
									rlt.put("coin", roles.getCoin());
									rlt.put("bid", list.get(0).getId());
									// rlt.put("quicktime", quicktime);
									respMap.put(
											GameConstants.GAME_API_RESPONSE_FIELD_CODE,
											GameConstants.GAME_API_SUCCESS);
									respMap.put(
											GameConstants.GAME_API_RESPONSE_FIELD_RLT,
											rlt);
									ServerHandler.sendData(session, respMap);
								}
							}
						} else {
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									-4);
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_RLT,
									"银币不足");
							ServerHandler.sendData(session, respMap);
						}
						Map<String, Object> pak = new HashMap<String, Object>();
						RoleDaytaskDetail roletask = this
								.getRoleDaytaskService().findRoleDaytaskByRId(
										roleid);
						int xiulian = roletask.getXiulian();
						int abc = xiulian + 1;
						pak.clear();
						pak.put("roleid", roleid);
						pak.put("xiulian", abc);
						this.getRoleDaytaskService().updateRoleDaytask(pak);
					} else if (t == 2) {
						if (yin > (int) 1.5 * yins) {
							List<RoleMilitaryDetail> list = this
									.getRoleMilitaryService()
									.getRoleMilitarytime(id, roleid);// 是不是在上课
							if (list.size() != 0) {
								if (now < list.get(0).getTime()) {
									respMap.put(
											GameConstants.GAME_API_RESPONSE_FIELD_CODE,
											-5);
									respMap.put(
											GameConstants.GAME_API_RESPONSE_FIELD_RLT,
											"正在修炼中");
									ServerHandler.sendData(session, respMap);
								} else {
									boolean bo = this.getGameRoleService()
											.subRoleYin(roleid,
													(int) 1.5 * yins);
									params.put("militaryid", id);
									params.put("roleId", roleid);
									params.put("time", now + 12 * 60 * 60
											* 1000);
									// params.put("time", now + 12 * 1000);
									params.put("xltype", 2);
									bo = this.getRoleMilitaryService()
											.updateRoleMilitarytime(params);
									if (bo == true) {
										rlt.put("time", 12 * 60 * 60 * 1000);
										rlt.put("xltype", 2);
										rlt.put("bid", list.get(0).getId());
										rlt.put("id", id);
										rlt.put("t", t);
										GameRoleDetail roles = this
												.getGameRoleService()
												.findRoleById(roleid);
										rlt.put("yin", roles.getYin());
										rlt.put("coin", roles.getCoin());
										// rlt.put("quicktime", quicktime);
										respMap.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
												GameConstants.GAME_API_SUCCESS);
										respMap.put(
												GameConstants.GAME_API_RESPONSE_FIELD_RLT,
												rlt);
										ServerHandler
												.sendData(session, respMap);
									}
								}

							} else {
								boolean bo = this.getGameRoleService()
										.subRoleYin(roleid, (int) 1.5 * yins);
								params.put("militaryid", id);
								params.put("roleId", roleid);
								params.put("time", now + 12 * 60 * 60 * 1000);
								params.put("xltype", 2);
								bo = this.getRoleMilitaryService()
										.updateRoleMilitarytime(params);
								if (bo == true) {
									rlt.put("time", 12 * 60 * 60 * 1000);
									rlt.put("xltype", 2);
									rlt.put("id", id);
									rlt.put("t", t);
									GameRoleDetail roles = this
											.getGameRoleService().findRoleById(
													roleid);
									rlt.put("yin", roles.getYin());
									rlt.put("coin", roles.getCoin());
									rlt.put("bid", list.get(0).getId());
									// rlt.put("quicktime", quicktime);
									respMap.put(
											GameConstants.GAME_API_RESPONSE_FIELD_CODE,
											GameConstants.GAME_API_SUCCESS);
									respMap.put(
											GameConstants.GAME_API_RESPONSE_FIELD_RLT,
											rlt);
									ServerHandler.sendData(session, respMap);
								}

							}
						} else {
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									-4);
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_RLT,
									"银币不足");
							ServerHandler.sendData(session, respMap);
						}
						Map<String, Object> pak = new HashMap<String, Object>();
						RoleDaytaskDetail roletask = this
								.getRoleDaytaskService().findRoleDaytaskByRId(
										roleid);
						int xiulian = roletask.getXiulian();
						int abc = xiulian + 1;
						pak.clear();
						pak.put("roleid", roleid);
						pak.put("xiulian", abc);
						this.getRoleDaytaskService().updateRoleDaytask(pak);
					} else if (t == 3) {
						params.put("itemid", 21);
						params.put("roleid", roleid);
						List<RoleItemDetail> lists = this.getRoleItemService()
								.getRoleItemByitem(params);
						if (lists.size() != 0) {
							List<RoleMilitaryDetail> list = this
									.getRoleMilitaryService()
									.getRoleMilitarytime(id, roleid);// 是不是在上课
							if (list.size() != 0) {
								if (now < list.get(0).getTime()) {
									respMap.put(
											GameConstants.GAME_API_RESPONSE_FIELD_CODE,
											-5);
									respMap.put(
											GameConstants.GAME_API_RESPONSE_FIELD_RLT,
											"正在修炼中");
									ServerHandler.sendData(session, respMap);
								} else {
									Map map = new HashMap();
									map.put("roleid", roleid);
									map.put("itemid", 21);
									List<RoleItemDetail> item = this
											.getRoleItemService().getRoleItem(
													map);
									if (!item.isEmpty()) {
										map.put("num", 1);
										boolean bo = this.getRoleItemService()
												.subRoleItem(map);
										map = null;
										params.put("militaryid", id);
										params.put("roleId", roleid);
										params.put("time", now + 24 * 60 * 60
												* 1000);
										// params.put("time", now + 24 * 1000);
										params.put("xltype", 3);
										bo = this.getRoleMilitaryService()
												.updateRoleMilitarytime(params);
										if (bo == true) {
											rlt.put("time", 24 * 60 * 60 * 1000);
											rlt.put("xltype", 3);
											rlt.put("id", id);
											rlt.put("t", t);
											GameRoleDetail roles = this
													.getGameRoleService()
													.findRoleById(roleid);
											rlt.put("yin", roles.getYin());
											rlt.put("coin", roles.getCoin());
											rlt.put("biditem", item.get(0)
													.getId());
											rlt.put("bid", list.get(0).getId());
											// rlt.put("quicktime", quicktime);
											respMap.put(
													GameConstants.GAME_API_RESPONSE_FIELD_CODE,
													GameConstants.GAME_API_SUCCESS);
											respMap.put(
													GameConstants.GAME_API_RESPONSE_FIELD_RLT,
													rlt);
											ServerHandler.sendData(session,
													respMap);
										}
									}
								}

							} else {
								Map map = new HashMap();
								map.put("roleid", roleid);
								map.put("itemid", 21);
								List<RoleItemDetail> item = this
										.getRoleItemService().getRoleItem(map);
								if (!item.isEmpty()) {
									map.put("num", 1);
									boolean bo = this.getRoleItemService()
											.subRoleItem(map);
									map = null;
									params.put("militaryid", id);
									params.put("roleId", roleid);
									params.put("time", 24 * 60 * 60 * 1000);
									params.put("xltype", 3);
									bo = this.getRoleMilitaryService()
											.updateRoleMilitarytime(params);
									if (bo == true) {
										rlt.put("time", 24 * 60 * 60 * 1000);
										rlt.put("xltype", 3);
										rlt.put("id", id);
										rlt.put("t", t);
										GameRoleDetail roles = this
												.getGameRoleService()
												.findRoleById(roleid);
										rlt.put("yin", roles.getYin());
										rlt.put("coin", roles.getCoin());
										rlt.put("biditem", item.get(0).getId());
										rlt.put("bid", list.get(0).getId());
										// rlt.put("quicktime", quicktime);

										respMap.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
												GameConstants.GAME_API_SUCCESS);
										respMap.put(
												GameConstants.GAME_API_RESPONSE_FIELD_RLT,
												rlt);
										ServerHandler
												.sendData(session, respMap);
									}
								}
							}
						} else {
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									-3);
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_RLT,
									"修炼令不足");
							ServerHandler.sendData(session, respMap);
						}
						Map<String, Object> pak = new HashMap<String, Object>();
						RoleDaytaskDetail roletask = this
								.getRoleDaytaskService().findRoleDaytaskByRId(
										roleid);
						int xiulian = roletask.getXiulian();
						int abc = xiulian + 1;
						pak.clear();
						pak.put("roleid", roleid);
						pak.put("xiulian", abc);
						this.getRoleDaytaskService().updateRoleDaytask(pak);
					}

				} else {
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
							"武将等级不能超过玩家等级");
					ServerHandler.sendData(session, respMap);
				}

			} else {
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "修炼位置已满");
				ServerHandler.sendData(session, respMap);
			}
		}
	}
	
	public void openchartstwo(){//排行榜初始化
		//魔壂数据初始化
		GlobalDatat.cacheForRoleMilitaryGhost.clear();
		//十二点初始化数据
		GameConstants.log.warn("BEFOR updatedeskcheck:" + this.getGameRoleService().getnum(3));
		this.getGameRoleService().updateDeskcheck(1);//更新deskcheck,stsdnum,stsfriend,groupactive
		GameConstants.log.warn("AFTER updatedeskcheck:" + this.getGameRoleService().getnum(3));
		long time=System.currentTimeMillis();
		//每天更新一次，先删除在插入
		this.getgameChartstwoService().deletegamechartone();
		// 读取当前服务器的编号
		List<ServerDetail> host = this.getServerService().getAllServer();
		GameConstants.log.warn("得到的server数量：" + host.size());
		for (int j = 0; j < host.size(); j++) {
			// System.out.println("j:" + j);
			// if(host.get(j).getStatue_on() == 1){
			boolean b = this.getgameChartstwoService().call_proc_add(
					host.get(j).getId());
			GameConstants.log.warn("服务器" + host.get(j).getId() + ":"
					+ host.get(j).getName() + "排行榜信息更新：" + b);
			// }

		}
	}

	public void upfriendchallenge() {// 更新挑战炫耀的状态
		// this.getGameRoleService().updatefrinedchallenge();
		/****/
		// GameConstants.log.warn("XiulianHandler.updatefriendchallenge:0_____before the first time_______gamerole:num:"
		// + this.getGameRoleService().getnum(2));
		this.getGameRoleService().updatefrinedchallenge(0);
		// GameConstants.log.warn("XiulianHandler.updatefriendchallenge:0_____before the second time_______gamerole:num:"
		// + this.getGameRoleService().getnum(2));

		Map<String, Object> compensate = new HashMap<String, Object>();
		compensate.put("id", 16);
		List<ActivityDetail> activitycompensate = this.getActivityService()
				.getActivityByParams(compensate);
		if (activitycompensate.isEmpty()) {// 活动已下架
			// System.out.println("更新用户炫耀挑战：：：：：：：1");
			this.getGameRoleService().updatefrinedchallenge(1);
			// this.getGameRoleService().updatefrinedchallenge(1);
			return;
		}
		Calendar calendar = Calendar.getInstance();
		int monthcompensate = calendar.get(Calendar.MONTH) + 1;
		int daycompensate = calendar.get(Calendar.DAY_OF_MONTH);
		int monthc = activitycompensate.get(0).getMonth();
		int dayc = activitycompensate.get(0).getDay();
		int monthendc = activitycompensate.get(0).getMonthend();
		int dayendc = activitycompensate.get(0).getDayend();
		// System.out.println("sysmonth::"+daycompensate+"monthendc:::::"+monthendc+"sysday:::"+daycompensate+"dayendc:::"+dayendc);
		if (monthcompensate == monthendc && daycompensate > dayendc) {// 特殊判断
			this.getGameRoleService().updatefrinedchallenge(1);
			// System.out.println("更新用户炫耀挑战：：：：：：：1");
		} else {
			this.getGameRoleService().updatefrinedchallenge(0);
			// System.out.println("更新用户炫耀挑战：：：：：：：0");
		}
		// GameConstants.log.warn("XiulianHandler.updatefriendchallenge:0_____after the second time_______gamerole:num:"
		// + this.getGameRoleService().getnum(2));

	}
	/***
	 * 四合一模型信息
	 */
	public void newServerActivity(){
		GameConstants.log.info("------------------------------------------");
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int monthNow = calendar.get(Calendar.MONTH) + 1;// 当前的月份
		int dayNow = calendar.get(Calendar.DAY_OF_MONTH);// 当前的天数
		if(GlobalDatat.newServerActivityDataMap.size() != 0){
			for (Integer serverid : GlobalDatat.newServerActivityDataMap.keySet()) {
//				System.out.println("serverid"+serverid);
				getChongZhiData(serverid);
				getGuanKaData(serverid);
				getFuBenData(serverid);
				getZhengBaData(serverid);
				sendReward(serverid);
				GameConstants.log.info("------------------------------------------");
			}
		}else{
			GameConstants.log.warn("GlobalDatat.newServerActivityDataMap don't has data");
		}
	}

	/**
	 * @method allModels
	 * @description 所有模型信息
	 */
	public void allModels() {
//		 System.out.println("请求x次");
		long a = System.currentTimeMillis();
		// if (params.containsKey("t")) {
		// Object _t = params.get("t");
		// if (!String.valueOf(_t).equals("")
		// && NumberUtils.isNumber(String.valueOf(_t))
		// && NumberUtils.createInteger(String.valueOf(_t)) > 0) {
		// int t = NumberUtils.createInteger(String.valueOf(_t))
		// .intValue();

		/**
		 * 分类 resType: 1/地图 2/防御塔 3/武将信息 4/敌将 5/道具 6 装备/ 7/vip模型10/价格表 *9/任务
		 * 14/技能 18/coin 16:兵/17:game_mission 18:game_bmap 19:game_bskill
		 * 21:game_bbuff //武将经验
		 */
		// switch (t) {
		// case 1:
		GlobalDatat.rlt.clear();
		GlobalDatat.rlttwo.clear();
		List<Map<String, Object>> maplist = new ArrayList<Map<String, Object>>();
		if (!GlobalData.cacheGameMap.isEmpty()) {
			int size = GlobalData.cacheGameMap.size();
			// System.out.println("SystemHandler,size:" + size);
			for (int i = 0; i < size; i++) {
				GameMapDetail gamemap = GlobalData.cacheGameMap.get(i);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", gamemap.getId());
				map.put("name", gamemap.getName());
				map.put("desc", gamemap.getDesc());
				map.put("battery", gamemap.getBattery());
				map.put("tower", gamemap.getTower());
				map.put("dongwu", gamemap.getDongwu());
				map.put("zuobiao", gamemap.getZuobiao());
				maplist.add(map);
				map = null;
			}
		}
		GlobalDatat.rlt.put("gamemap", maplist);
		// System.out.println("rlt:" + rlt.toString());
		maplist = null;
		// break;
		// case 2:
		List<Map<String, Object>> tlist = new ArrayList<Map<String, Object>>();
		if (!GlobalData.cacheGameFTa.isEmpty()) {
			int size = GlobalData.cacheGameFTa.size();
			for (int i = 0; i < size; i++) {
				GameTowerDetail gamet = GlobalData.cacheGameFTa.get(i);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", gamet.getId());
				map.put("name", gamet.getName());
				map.put("desc", gamet.getDesc());
				map.put("level", gamet.getLevel());
				map.put("type", gamet.getType());
				map.put("shottype", gamet.getShottype());
				map.put("bombtype", gamet.getBombtype());
				map.put("description", gamet.getDescription());
				map.put("fwextra", gamet.getFwextra());
				map.put("gjextra", gamet.getGjextra());
				map.put("gsextra", gamet.getGsextra());
				map.put("fanwei", gamet.getFanwei());
				tlist.add(map);
				map = null;
			}
		}
		GlobalDatat.rlt.put("gametower", tlist);
		tlist = null;
		// break;
		// case 3:
		List<Map<String, Object>> mlist = new ArrayList<Map<String, Object>>();
		if (!GlobalData.cacheGameMilitary.isEmpty()) {
			int size = GlobalData.cacheGameMilitary.size();
			for (int i = 0; i < size; i++) {
				GameMilitaryDetail gamem = GlobalData.cacheGameMilitary.get(i);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("desc", gamem.getDesc());
				map.put("name", gamem.getName());
				map.put("art", gamem.getArt());
				map.put("arts", gamem.getArts());
				map.put("fanwei", gamem.getFanwei());
				map.put("gjiachenhg", gamem.getGjiacheng());
				map.put("gongji", gamem.getGongji());
				map.put("gongsu", gamem.getGongsu());
				map.put("id", gamem.getId());
				map.put("level", gamem.getLevel());
				map.put("pingzhi", gamem.getPingzhi());
				map.put("pztype", gamem.getPztype());
				map.put("type", gamem.getType());
				map.put("xljiacheng", gamem.getXljiacheng());
				map.put("xueliang", gamem.getXueliang());
				map.put("iscompose", gamem.getIscompose());
				map.put("isaddcompose", gamem.getIsaddcompose());
				map.put("needcompose", gamem.getNeedcompose());
				map.put("composeid", gamem.getComposeid());
				map.put("mohunprice", gamem.getMohunprice());
				map.put("mohunchange", gamem.getMohunchange());
				map.put("ismaterial", gamem.getIsmaterial());
				map.put("source", gamem.getSource());
				map.put("heti", gamem.getHeti());
				String describe = "0";
				if (gamem.getDescribe() == null) {

				} else {
					describe = gamem.getDescribe();
				}
				map.put("describe", describe);
				mlist.add(map);
				map = null;
			}
		}
		GlobalDatat.rlt.put("gamemilitary", mlist);
		mlist = null;
		// break;
		// case 4:
		List<Map<String, Object>> flist = new ArrayList<Map<String, Object>>();
		if (!GlobalData.cacheGameFoe.isEmpty()) {
			int size = GlobalData.cacheGameFoe.size();
			for (int i = 0; i < size; i++) {
				GameFoeDetail gamef = GlobalData.cacheGameFoe.get(i);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("foeid", gamef.getFoeid());
				map.put("foename", gamef.getFoename());
				map.put("foedesc", gamef.getFoedesc());
				map.put("foefangyu", gamef.getFangyu());
				map.put("foesudu", gamef.getSudu());
				map.put("foetype", gamef.getType());
				map.put("foexueliang", gamef.getXueliang());
				map.put("skill", gamef.getSkill());
				flist.add(map);
				map = null;
			}
		}
		GlobalDatat.rlttwo.put("gamefoe", flist);
		flist = null;
		List<Map<String, Object>> fslist = new ArrayList<Map<String, Object>>();
		if (!GlobalData.cacheGameFoeskill.isEmpty()) {
			int size = GlobalData.cacheGameFoeskill.size();
			for (int i = 0; i < size; i++) {
				GameFoeskillDetail gamefs = GlobalData.cacheGameFoeskill.get(i);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", gamefs.getId());
				map.put("name", gamefs.getName());
				map.put("type", gamefs.getType());
				map.put("summon", gamefs.getSummon());
				map.put("number", gamefs.getNumber());
				map.put("desc", gamefs.getDesc());
				map.put("bufftype", gamefs.getBufftype());
				map.put("fanwei", gamefs.getFanwei());
				map.put("effect", gamefs.getEffect());
				fslist.add(map);
				map = null;
			}
		}
		GlobalDatat.rlttwo.put("gamefoeskill", fslist);
		flist = null;
		// break;
		// case 5:
		List<Map<String, Object>> itemShopList = new ArrayList<Map<String, Object>>();
		if (!GlobalData.cacheModelItems.isEmpty()) {
			int size = GlobalData.cacheModelItems.size();
			for (int i = 0; i < size; i++) {
				GameItemDetail item = GlobalData.cacheModelItems.get(i);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", item.getId()); /* 道具模型序号 */
				map.put("itemtype", item.getItemtype()); /* 道具类型() */
				map.put("itemname", item.getItemname());
				map.put("itemres", item.getItemres()); /* 资源名称 */
				map.put("itemprop", item.getItemprop()); /* 道具说明 */
				map.put("itemlevel", item.getItemlevel());
				map.put("itemurl", item.getItemurl());
				map.put("isover", item.getIsover());
				map.put("isuse", item.getIsuse());
				map.put("isshop", item.getIsshop());
				map.put("coin", item.getCoin());
				map.put("cointype", item.getCointype());
				map.put("flg", item.getFlag());
				map.put("quality", item.getQuality());
				map.put("reward", item.getReward());
				map.put("itemvip", item.getItemvip());
				map.put("indexs", item.getIndexs());
				map.put("cointype", item.getCointype());
				itemShopList.add(map);
				item = null;
				map = null;
			}
		}
		GlobalDatat.rlt.put("items", itemShopList);
		itemShopList = null;
		// break;
		// case 6:
		List<Map<String, Object>> gameEquipList = new ArrayList<Map<String, Object>>();
		if (!GlobalData.cacheGameEquip.isEmpty()) {
			int size = GlobalData.cacheGameEquip.size();
			for (int i = 0; i < size; i++) {
				GameEquipDetail equip = GlobalData.cacheGameEquip.get(i);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", equip.getId()); /* 道具模型序号 */
				map.put("equipname", equip.getEquipname()); /* 道具类型() */
				map.put("equipurl", equip.getEquipurl());
				map.put("equiptype", equip.getEquiptype()); /* 资源名称 */
				map.put("type", equip.getType()); /* 道具说明 */
				map.put("gongji", equip.getGongji());
				map.put("fanwei", equip.getFanwei());
				map.put("sudu", equip.getSudu());
				map.put("extra", equip.getExtra());
				map.put("xueliang", equip.getXueliang());
				map.put("level", equip.getLevel());
				map.put("flg", equip.getFlag());
				map.put("isshop", equip.getIsshop());
				map.put("desc", equip.getDesc());
				map.put("quality", equip.getQuality());
				map.put("coin", equip.getCoin());
				map.put("isstar", equip.getIsstar());
				map.put("eatequipid", equip.getEatequipid());
				gameEquipList.add(map);
				equip = null;
				map = null;
			}
		}

		GlobalDatat.rlt.put("equip", gameEquipList);
		itemShopList = null;
		// break;

		// case 7:
		List<Map<String, Object>> viplist = new ArrayList<Map<String, Object>>();
		if (!GlobalData.cacheGameVip.isEmpty()) {
			int size = GlobalData.cacheGameVip.size();
			for (int i = 0; i < size; i++) {
				GameVipDetail gamevip = GlobalData.cacheGameVip.get(i);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", gamevip.getId());
				map.put("vipLevel", gamevip.getVipLevel());
				map.put("vipRmb", gamevip.getVipRmb());
				map.put("militaryTop", gamevip.getMilitaryTop());
				map.put("junlingTop", gamevip.getJunlingTop());
				map.put("backTop", gamevip.getBackTop());
				map.put("challengTop", gamevip.getChallengTop());
				map.put("trainTop", gamevip.getTrainTop());
				map.put("qiangzhengTop", gamevip.getQiangzhengTop());
				map.put("dhjlTop", gamevip.getDhjlTop());
				map.put("zjxxTop", gamevip.getZjxxTop());
				map.put("gjxxTop", gamevip.getGjxxTop());
				map.put("vipsli", gamevip.getVipsli());
				map.put("djzmTop", gamevip.getDjzmTop());
				map.put("zjxlTop", gamevip.getZjxlTop());
				map.put("yptop", gamevip.getYptop());
				map.put("missionTop", gamevip.getMissionTop());
				viplist.add(map);
				map = null;
			}
		}
		GlobalDatat.rlt.put("gamevip", viplist);
		maplist = null;
		// break;
		// case 8:
		List<Map<String, Object>> chlevellist = new ArrayList<Map<String, Object>>();
		if (!GlobalData.cacheGameChLevel.isEmpty()) {
			int size = GlobalData.cacheGameChLevel.size();
			for (int i = 0; i < size; i++) {
				GameChLevelDetail gamechlevle = GlobalData.cacheGameChLevel
						.get(i);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", gamechlevle.getId());
				map.put("name", gamechlevle.getName());
				map.put("level", gamechlevle.getLevel());
				map.put("gongxun", gamechlevle.getGongxun());
				map.put("ta", gamechlevle.getTa());
				map.put("type", gamechlevle.getType());

				chlevellist.add(map);
				map = null;
				gamechlevle = null;
			}
		}
		GlobalDatat.rlt.put("chlevel", chlevellist);
		chlevellist = null;
		// break;
		// case 10:
		List<Map<String, Object>> priceMap = new ArrayList<Map<String, Object>>();
		if (!GlobalData.cacheGamepList.isEmpty()) {

			int size = GlobalData.cacheGamepList.size();
			Map<String, Object> param = new HashMap<String, Object>();
			List<ShopdiscountDetail> sp = shopService.getShopdiscount(param);
			// System.out.println("month"+sp.get(0).getMonth()+"day"+sp.get(0).getDay()+"monthend"+sp.get(0).getMonth()+"dayend"+sp.get(0).getDayend());

			for (int i = 0; i < size; i++) {

				int onsale = 0;

				GamePriceDetail gresp = GlobalData.cacheGamepList.get(i);

				/****/

				if (!sp.isEmpty()) {
					// System.out.println("1=====================");
					Calendar calendar = Calendar.getInstance();
					int month0 = calendar.get(Calendar.MONTH) + 1;
					int day0 = calendar.get(Calendar.DAY_OF_MONTH);
					int month = sp.get(0).getMonth();
					int day = sp.get(0).getDay();
					int monthend = sp.get(0).getMonthend();
					int dayend = sp.get(0).getDayend();
					if (month0 == month && month0 == monthend) {
						if (day0 >= day && day0 <= dayend) {
							onsale = gresp.getOnsale();
						}
					} else if (month0 >= month && month0 <= monthend) {
						onsale = gresp.getOnsale();
					}

				}

				/****/
				double x = onsale / 10.0;
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", gresp.getId());
				map.put("resId", gresp.getResId());
				map.put("resCost", gresp.getResCost());
				map.put("resType", gresp.getResType());
				map.put("costType", gresp.getCostType());
				map.put("keepTime", gresp.getKeepTime());
				map.put("discount", x);
				// System.out.println("道具模型价格打折========="+onsale+"====x===="+x);
				priceMap.add(map);
				map = null;
				gresp = null;
			}
			// System.out.println("discount======="+discount);
		}
		GlobalDatat.rlt.put("price", priceMap);

		priceMap = null;
		// break;
		// case 11:
		List<Map<String, Object>> mlevelList = new ArrayList<Map<String, Object>>();
		if (!GlobalData.cacheMlevel.isEmpty()) {
			int size = GlobalData.cacheMlevel.size();
			for (int i = 0; i < size; i++) {
				GameMLevelDetail mlevel = GlobalData.cacheMlevel.get(i);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", mlevel.getId());
				map.put("level", mlevel.getLevel());
				map.put("exp", mlevel.getExp());
				map.put("xyin", mlevel.getXyin());
				mlevelList.add(map);
				map = null;
				mlevel = null;
			}
		}
		GlobalDatat.rlt.put("mlevel", mlevelList);
		mlevelList = null;
		// break;

		// case 12:
		List<Map<String, Object>> insList = new ArrayList<Map<String, Object>>();// 装备属性表
		if (!GlobalData.cacheGameEIns.isEmpty()) {
			int size = GlobalData.cacheGameEIns.size();
			for (int i = 0; i < size; i++) {
				GameEInsDetail ins = GlobalData.cacheGameEIns.get(i);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("level", ins.getLevel());
				map.put("price", ins.getPrice());
				insList.add(map);
				map = null;
				ins = null;
			}
		}
		GlobalDatat.rlttwo.put("ins", insList);
		insList = null;
		// break;

		// case 13:
		List<Map<String, Object>> proList = new ArrayList<Map<String, Object>>();// 装备属性表
		if (!GlobalData.cacheGameEProperty.isEmpty()) {
			int size = GlobalData.cacheGameEProperty.size();
			for (int i = 0; i < size; i++) {
				GameEPropertyDetail pro = GlobalData.cacheGameEProperty.get(i);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", pro.getId());
				map.put("hp", pro.getHp());
				map.put("speed", pro.getSpeed());
				map.put("range", pro.getRange());
				map.put("quality", pro.getQuality());
				map.put("at", pro.getAttack());
				map.put("type", pro.getType());
				proList.add(map);
				map = null;
				pro = null;
			}
		}
		GlobalDatat.rlt.put("pro", proList);
		proList = null;
		// break;

		// case 14:
		List<Map<String, Object>> skillList = new ArrayList<Map<String, Object>>();// 技能属性表
		if (!GlobalData.cacheGameSkill.isEmpty()) {
			int size = GlobalData.cacheGameSkill.size();
			for (int i = 0; i < size; i++) {
				GameSkillDetail skill = GlobalData.cacheGameSkill.get(i);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", skill.getId());
				map.put("skillName", skill.getSkillName());
				map.put("skillDesc", skill.getSkillDesc());
				map.put("skillIcon", skill.getSkillIcon());
				map.put("skillMc", skill.getSkillMc());
				map.put("skillMcclip", skill.getSkillMcclip());
				map.put("type", skill.getType());
				map.put("skillType", skill.getSkillType());
				map.put("mpcost", skill.getMpcost());
				map.put("skillCd", skill.getSkillCd());
				map.put("skillArea", skill.getSkillArea());
				map.put("skillBuffId", skill.getSkillBuffId());
				map.put("nameurl", skill.getNameurl());
				skillList.add(map);
				map = null;
				skill = null;
			}
		}
		GlobalDatat.rlttwo.put("skill", skillList);
		skillList = null;
		// break;

		// case 15:
		List<Map<String, Object>> buffList = new ArrayList<Map<String, Object>>();// 属性表
		if (!GlobalData.cacheGameBuff.isEmpty()) {
			int size = GlobalData.cacheGameBuff.size();
			for (int i = 0; i < size; i++) {
				GameBuffDetail buff = GlobalData.cacheGameBuff.get(i);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", buff.getId());
				map.put("name", buff.getName());
				map.put("buffDip", buff.getBuffDip());
				map.put("type", buff.getType());
				map.put("buffAlktime", buff.getBuffAtktime());
				map.put("buffKeeptime", buff.getBuffKeeptime());
				map.put("atkperson", buff.getAtkperson());
				map.put("bufftype", buff.getBufftype());
				map.put("bufftime", buff.getBufftime());
				buffList.add(map);
				map = null;
				buff = null;
			}
		}
		GlobalDatat.rlttwo.put("buff", buffList);
		insList = null;
		// break;

		// case 9:
		List<Map<String, Object>> taskList = new ArrayList<Map<String, Object>>();// 装备属性表
		if (!GlobalData.cacheGameTask.isEmpty()) {
			int size = GlobalData.cacheGameTask.size();
			for (int i = 0; i < size; i++) {
				GameTaskDetail task = GlobalData.cacheGameTask.get(i);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", task.getId());
				map.put("taskname", task.getTaskname());
				map.put("taskdesc", task.getTaskdesc());
				map.put("tasktype", task.getTasktype());
				map.put("taskgoal", task.getTaskgoal());
				map.put("taskcoin", task.getTaskcoin());
				map.put("gongxun", task.getGongxun());
				map.put("junling", task.getJunling());
				map.put("type", task.getType());
				map.put("exp", task.getExp());
				String taskres = task.getTaskres();

				// GameConstants.log.warn("task模型信息：id："+task.getId()+"    taskres"+taskres);
				List<Map> tasks = JSON.parseArray(String.valueOf(taskres),
						Map.class);
				map.put("taskres", tasks);
				taskList.add(map);
				map = null;
				task = null;
			}
		}
		GlobalDatat.rlttwo.put("task", taskList);
		taskList = null;
		// break;
		// case 16:
		List<Map<String, Object>> gamebingList = new ArrayList<Map<String, Object>>();// 兵属性表
		if (!GlobalData.cacheGameBing.isEmpty()) {
			int size = GlobalData.cacheGameBing.size();
			for (int i = 0; i < size; i++) {
				GameBingDetail task = GlobalData.cacheGameBing.get(i);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", task.getId());
				map.put("name", task.getName());
				map.put("icon", task.getIcon());
				map.put("desc", task.getArtdesc());
				map.put("type", task.getType());
				map.put("isenemy", task.getIsenemy());
				map.put("gongji", task.getGongji());
				map.put("xishu1", task.getXishu1());
				map.put("xueliang", task.getXueliang());
				map.put("xishu2", task.getXishu2());
				map.put("fangyu", task.getFangyu());
				map.put("gongsu", task.getGongsu());
				map.put("gongfan", task.getGongfan());
				map.put("shangfan", task.getShangfan());
				map.put("sudu", task.getSudu());
				map.put("renkou", task.getRenkou());
				map.put("jiage", task.getJiage());
				map.put("lengque", task.getLengque());
				map.put("bullet", task.getBullet());
				map.put("bulletfly", task.getBulletfly());
				map.put("bullethit", task.getBullethit());
				map.put("speakdesc", task.getSpeakdesc());
				map.put("speaktext", task.getSpeaktext());
				List skill = JSON.parseArray(task.getSkill());
				map.put("skill", skill);
				map.put("xtype", task.getXtype());
				skill = null;
				List accord = JSON.parseArray(task.getAccord());
				map.put("gongjun", task.getGongjun());
				map.put("bingfu", task.getBingfu());
				map.put("xixue", task.getXixue());
				map.put("accord", accord);
				map.put("qty", task.getQty());
				gamebingList.add(map);
				map = null;
				task = null;
			}
		}
		GlobalDatat.rlttwo.put("gamebing", gamebingList);
		gamebingList = null;
		// break;
		// case 17:
		List<Map<String, Object>> gamemisssionList = new ArrayList<Map<String, Object>>();// 副本限制属性表
		if (!GlobalData.cacheGameMission.isEmpty()) {
			int size = GlobalData.cacheGameMission.size();
			for (int i = 0; i < size; i++) {
				GameMissionDetail task = GlobalData.cacheGameMission.get(i);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", task.getId());
				map.put("name", task.getName());
				map.put("desc", task.getArtdesc());
				List goal = JSON.parseArray(task.getGoal());
				map.put("goal", goal);
				List jiangli = JSON.parseArray(task.getJiangli());
				map.put("jiangli", jiangli);
				gamemisssionList.add(map);
				goal = null;
				jiangli = null;
				map = null;
				task = null;
			}
		}
		GlobalDatat.rlttwo.put("mission", gamemisssionList);
		gamemisssionList = null;
		// break;
		// case 18:
		List<Map<String, Object>> gameBmapList = new ArrayList<Map<String, Object>>();
		if (!GlobalData.cacheGameBmap.isEmpty()) {
			int size = GlobalData.cacheGameBmap.size();
			for (int i = 0; i < size; i++) {
				GameBmapDetail task = GlobalData.cacheGameBmap.get(i);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", task.getId());
				map.put("name", task.getName());
				map.put("nandu", task.getNandu());
				// List chubing = JSON.parseArray(task.getChubing());
				String chubing = task.getChubing();
				/****/
				// ob=chubing;
				/****/

				map.put("chubing", chubing);
				chubing = null;
				map.put("isagain", task.getIsagain());
				map.put("startlv", task.getStartlv());
				map.put("startnum", task.getStartnum());
				map.put("getexp", task.getGetexp());
				map.put("getgongxun", task.getGetgongxun());
				map.put("getyin", task.getGetyin());
				map.put("dengji", task.getDengji());
				gameBmapList.add(map);
				map = null;
				task = null;
			}
		}
		GlobalDatat.rlttwo.put("gamebmap", gameBmapList);
		gameBmapList = null;
		// break;

		// case 19:
		List<Map<String, Object>> gameBskillList = new ArrayList<Map<String, Object>>();
		if (!GlobalData.cacheGameBskill.isEmpty()) {
			int size = GlobalData.cacheGameBskill.size();
			for (int i = 0; i < size; i++) {
				GameBskillDetail task = GlobalData.cacheGameBskill.get(i);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", task.getId());
				map.put("name", task.getName());
				map.put("desc", task.getArtdesc());
				map.put("type", task.getType());
				List buffid = JSON.parseArray(task.getBuffid());
				map.put("buffid", buffid);
				buffid = null;
				map.put("target", task.getTarget());
				map.put("jilv", task.getJilv());
				map.put("chufa", task.getChufa());
				map.put("fanwei", task.getFanwei());
				map.put("shanghai", task.getShanghai());
				map.put("cishu", task.getCishu());
				map.put("time", task.getTime());
				map.put("bullet", task.getBullet());
				map.put("cd", task.getCd());
				gameBskillList.add(map);
				map = null;
				task = null;
			}
		}
		GlobalDatat.rlttwo.put("gamebskill", gameBskillList);
		gameBskillList = null;
		// break;

		// case 20:
		List<Map<String, Object>> starlist = new ArrayList<Map<String, Object>>();// 属性表
		List<GameStarDetail> gs = (new GameStarServiceImpl()).getallgamestar();
		if (!gs.isEmpty()) {
			int size = gs.size();
			for (int i = 0; i < size; i++) {
				GameStarDetail star = gs.get(i);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", star.getId());
				map.put("starlevel", star.getStarlevel());
				map.put("levelexp", star.getLevelexp());
				map.put("statusadd", star.getStatusadd());
				map.put("flag", star.getFlag());
				starlist.add(map);
				map = null;
				star = null;
			}
		}
		GlobalDatat.rlttwo.put("star", starlist);
		starlist = null;
		// break;

		// case 22:
		List<Map<String, Object>> totemlist = new ArrayList<Map<String, Object>>();
		List<GametotemDetail> to = (new GametotemServiceImpl()).getGametotem();
		if (!to.isEmpty()) {
			int size = to.size();
			for (int i = 0; i < size; i++) {
				GametotemDetail gt = to.get(i);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", gt.getId());
				map.put("name", gt.getName());
				map.put("type", gt.getType());
				map.put("level", gt.getLevel());
				map.put("quality", gt.getQuality());
				map.put("flag", gt.getFlag());
				map.put("icon", gt.getIcon());
				map.put("halo", gt.getHalo());
				map.put("isshop", gt.getIsshop());
				map.put("indexs", gt.getIndexs());
				totemlist.add(map);
				map = null;
				gt = null;
			}
		}
		GlobalDatat.rlttwo.put("totem", totemlist);
		starlist = null;
		// break;

		// case 21:
		List<Map<String, Object>> gameBbuffList = new ArrayList<Map<String, Object>>();
		if (!GlobalData.cacheGameBbuff.isEmpty()) {
			int size = GlobalData.cacheGameBbuff.size();
			for (int i = 0; i < size; i++) {
				GameBbuffDetail task = GlobalData.cacheGameBbuff.get(i);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", task.getId());
				map.put("name", task.getName());
				map.put("desc", task.getArtdesc());
				map.put("cishu", task.getCishu());
				map.put("time", task.getTime());
				map.put("shanghai", task.getShanghai());
				map.put("type", task.getType());
				gameBbuffList.add(map);
				map = null;
				task = null;
			}
		}
		GlobalDatat.rlttwo.put("gamebbuff", gameBbuffList);
		gameBbuffList = null;
		GlobalDatat.rlt.put("t", 1);
		GlobalDatat.rlttwo.put("t", 2);
		// break;

		// default:
		// break;
		// }
		// respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		// respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
		// GameConstants.GAME_API_SUCCESS);
		// ServerHandler.sendData(session, respMap);
		// }
		// }
		long b = System.currentTimeMillis();
		// System.out.println("获取模型信息所用的时间："+(b-a));
		GlobalDatat.equipthree.clear();
		GlobalDatat.equipfour.clear();
		GlobalDatat.equipfive.clear();
		Iterator it = GlobalDatat.cacheGameEquipDetails.keySet().iterator();
		while (it.hasNext()) {
			Integer i = Integer.valueOf(it.next().toString());
			if (GlobalDatat.cacheGameEquipDetails.get(i).getQuality() == 3) {
				GlobalDatat.equipthree.put(GlobalDatat.cacheGameEquipDetails
						.get(i).getId(),
						GlobalDatat.cacheGameEquipDetails.get(i).getId());
			} else if (GlobalDatat.cacheGameEquipDetails.get(i).getQuality() == 4) {
				GlobalDatat.equipfour.put(GlobalDatat.cacheGameEquipDetails
						.get(i).getId(),
						GlobalDatat.cacheGameEquipDetails.get(i).getId());
			} else if (GlobalDatat.cacheGameEquipDetails.get(i).getQuality() == 5) {
				GlobalDatat.equipfive.put(GlobalDatat.cacheGameEquipDetails
						.get(i).getId(),
						GlobalDatat.cacheGameEquipDetails.get(i).getId());
			}
		}
		
//		if (GlobalDatat.newserverdataMap.size() == 0
//				|| GlobalDatat.newserverdataMap.isEmpty()) {// 没有新服数据
//		} else {
//			try {
//				for (Integer serverid : GlobalDatat.newserverdataMap.keySet()) {
//					// 15天开服活动（4合1）
//					int year = calendar.get(Calendar.YEAR);
//					int hour = calendar.get(calendar.HOUR_OF_DAY);
//					int month = GlobalDatat.newserverdataMap.get(serverid).getInt(0);
//					int day = GlobalDatat.newserverdataMap.get(serverid).getInt(1);
//					String activityTime = year + "-" + month + "-" + day;
//					try {
//						remainnum = this.getDaysBetween(activityTime);
//					} catch (ParseException e) {
//						e.printStackTrace();
//					}
//					if (remainnum <= 20) {// 四合一排行缓存
//						frontten(serverid);//充值排行
//						zhengbaten(serverid);//争霸排行
//						maplevel(serverid);//关卡排行
//						duplicatesort(serverid);//副本排行
//						if ((remainnum == 8 && hour <= 1)) {// 第8天，把前十名的奖励发给玩家
//							int plyid = 0;
//							List<GameTaskDetail> list = new ArrayList();
//							for (int i = 0; i < GlobalDatat.pretenchargeMap.get(serverid).size(); i++) {
//								plyid = GlobalDatat.pretenchargeMap.get(serverid).get(i);
//								try {
//									list = this.getGameTaskService()
//									.getGameTaskDetailById(3000 + i);
//									String task = list.get(0).getTaskres();
//									List<Map> tasks = JSON.parseArray(
//											String.valueOf(task), Map.class);
//									Map<String, JSONArray> result = collect(tasks, plyid);// 发放奖励
//								} catch (Exception e) {
//									e.printStackTrace();
//								}
//							}
//						}
//						if ((remainnum == 16 && hour <= 1)) {// 第16天，把前十名的奖励发给玩家
//							try {
//								GlobalDatat.extrashow.add(2);
//								List<GameTaskDetail> list = new ArrayList();
//								for (int i = 0; i < GlobalDatat.pretenlevel
//										.size(); i++) {// 15天的关卡排行榜奖励
//									list = this
//											.getGameTaskService()
//											.getGameTaskDetailById(3010 + i);
//									String task = list.get(0).getTaskres();
//									List<Map> tasks = JSON
//											.parseArray(
//													String.valueOf(task),
//													Map.class);
//									// JSONArray temptask = new JSONArray();
//									Map<String, JSONArray> result = collect(
//											tasks,
//											GlobalDatat.pretenlevel.get(i));// 发放奖励
//
//								}
//								for (int i = 0; i < GlobalDatat.pretenfuben
//										.size(); i++) {// 15天的副本排行榜奖励
//									list = this
//											.getGameTaskService()
//											.getGameTaskDetailById(3020 + i);
//									String task = list.get(0).getTaskres();
//									List<Map> tasks = JSON
//											.parseArray(
//													String.valueOf(task),
//													Map.class);
//									// JSONArray temptask = new JSONArray();
//									Map<String, JSONArray> result = collect(
//											tasks,
//											GlobalDatat.pretenfuben.get(i));// 发放奖励
//
//								}
//								for (int i = 0; i < GlobalDatat.newserverchallenge
//										.size(); i++) {// 15天的争霸战排行榜奖励
//									list = this
//											.getGameTaskService()
//											.getGameTaskDetailById(3030 + i);
//									String task = list.get(0).getTaskres();
//									List<Map> tasks = JSON
//											.parseArray(
//													String.valueOf(task),
//													Map.class);
//									// JSONArray temptask = new JSONArray();
//									Map<String, JSONArray> result = collect(
//											tasks,
//											GlobalDatat.newserverchallenge
//													.get(i).getRoleId());// 发放奖励
//
//								}
//
//							} catch (Exception e) {
//								e.printStackTrace();
//							}
//						}
//					}
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
	}
	/**
	 * 初始化四合一对象缓存
	 */
	private void getChongZhiData(int serverid){
		try{
			Map<Integer,Integer> allChongZhi = new HashMap<Integer,Integer>();
			Map<Integer,Integer> allChongZhiPaiMing = new HashMap<Integer, Integer>();
			List<GameRoleDetail> gamerolelist = this.getGameRoleService().findAllGameRole();
			for (int i = 0; i < gamerolelist.size(); i++) {
				if(Integer.valueOf(gamerolelist.get(i).getServerId()) == serverid){
					allChongZhi.put(gamerolelist.get(i).getId(), gamerolelist.get(i).getCoinspend());
				}
			}
//			System.out.println(allChongZhi);
			GameConstants.log.info("allChongZhi:	" + "for No."+serverid+" server	" + allChongZhi.size());
			GlobalDatat.allChongZhiMap.put(serverid, allChongZhi);
			//排序
			List<Map.Entry<Integer, Integer>> paixu = new ArrayList<Map.Entry<Integer,Integer>>(allChongZhi.entrySet());
			Collections.sort(paixu, new Comparator<Map.Entry<Integer, Integer>>(){
				public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2){
					 return (o2.getValue() - o1.getValue());
				}
			});
			for (int i = 0; i < paixu.size(); i++) {
				int roleid = paixu.get(i).getKey();
				allChongZhiPaiMing.put(roleid, i+1);
			}
			GlobalDatat.allChongZhiPaiMingMap.put(serverid, allChongZhiPaiMing);
//			System.out.println(GlobalDatat.allChongZhiPaiMingMap.get(serverid));
//			paixu = null;
			gamerolelist = null;
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void getGuanKaData(int serverid){
		try {
			Map<Integer,Integer> allGuanKa = new HashMap<Integer,Integer>();
			Map<Integer,Integer> allGuanKaPaiMing = new HashMap<Integer, Integer>();
			List<GameRoleDetail> gamerolelist = this.getGameRoleService().findAllGameRole();
			for (int i = 0; i < gamerolelist.size(); i++) {
				if(Integer.valueOf(gamerolelist.get(i).getServerId()) == serverid){
					allGuanKa.put(gamerolelist.get(i).getId(), (gamerolelist.get(i).getMapid()-1)*20 + gamerolelist.get(i).getPlaceid());//每刷一个图,增加一积分
				}
			}
			GameConstants.log.info("allGuanKa:	" + "for No."+serverid+" server	" + allGuanKa.size());
			GlobalDatat.allGuanKaMap.put(serverid, allGuanKa);
//			System.out.println(GlobalDatat.allGuanKaMap.get(serverid));
			//排序
			List<Map.Entry<Integer, Integer>> paixu = new ArrayList<Map.Entry<Integer,Integer>>(allGuanKa.entrySet());
			Collections.sort(paixu, new Comparator<Map.Entry<Integer, Integer>>(){
				public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2){
					 return (o2.getValue() - o1.getValue());
				}
			});
			for (int i = 0; i < paixu.size(); i++) {
				int roleid = paixu.get(i).getKey();
				allGuanKaPaiMing.put(roleid, i+1);
			}
			GlobalDatat.allGuanKaPaiMingMap.put(serverid, allGuanKaPaiMing);
			paixu = null;
			gamerolelist = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void getFuBenData(int serverid){
		try {
			Map<Integer,Integer> allFuBen = new HashMap<Integer,Integer>();
			Map<Integer,Integer> allFuBenPaiMing = new HashMap<Integer, Integer>();
			List<RoleBingDetail> roleBingList = this.getRoleBingService().findAllRoleBing();
			List<GameRoleDetail> gamerolelist = this.getGameRoleService().findAllGameRole();
			int nandu = 0;
			int statrs = 0;
			for (int i = 0; i < gamerolelist.size(); i++) {
				if(Integer.valueOf(gamerolelist.get(i).getServerId()) == serverid){
					int jifen = 0;
					for (int j = 0; j < roleBingList.size(); j++) {
						if(gamerolelist.get(i).getId() == roleBingList.get(j).getRoleid()){
							nandu = roleBingList.get(j).getNandu();
							statrs = roleBingList.get(j).getStars();
							jifen += getMathForFuBenData(nandu, statrs);
						}
					}
					allFuBen.put(gamerolelist.get(i).getId(), jifen);
				}
			}
			GameConstants.log.info("allFuBen:	" + "for No."+serverid+" server	" + allFuBen.size());
			GlobalDatat.allFuBenMap.put(serverid, allFuBen);
//			System.out.println(GlobalDatat.allFuBenMap.get(serverid));
			//排序
			List<Map.Entry<Integer, Integer>> paixu = new ArrayList<Map.Entry<Integer,Integer>>(allFuBen.entrySet());
			Collections.sort(paixu, new Comparator<Map.Entry<Integer, Integer>>(){
				public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2){
					 return (o2.getValue() - o1.getValue());
				}
			});
			for (int i = 0; i < paixu.size(); i++) {
				int roleid = paixu.get(i).getKey();
				allFuBenPaiMing.put(roleid, i+1);
			}
			GlobalDatat.allFuBenPaiMingMap.put(serverid, allFuBenPaiMing);
			paixu = null;
			roleBingList = null;
			gamerolelist = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void getZhengBaData(int serverid){//争霸战刷新
		Map<Integer,Integer> allZhengBa = new HashMap<Integer,Integer>();
		Map<Integer,Integer> allZhengBaPaiMing = new HashMap<Integer, Integer>();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("type", 1);
		param.put("page", 0);
		param.put("size", 10);
		param.put("serverid", serverid);
		List<GameChartsDetail> gcs = this
		.getgameChartsService()
		.findByQZFirstTen(param);// 15天的争霸战排行榜
		try {
			for (int i = 0; i < gcs.size(); i++) {
				allZhengBa.put(gcs.get(i).getRoleId(),(int)gcs.get(i).getAttack());
				allZhengBaPaiMing.put(gcs.get(i).getRoleId(), i + 1);
			}
			GlobalDatat.allZhengBaMap.put(serverid, allZhengBa);
			GlobalDatat.allZhengBaPaiMingMap.put(serverid, allZhengBaPaiMing);
			GameConstants.log.info("allZhengBa:	" + "for No."+serverid+" server	" + allZhengBa.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private int getMathForFuBenData(int nandu,int statrs){//计算副本积分    普通1分,困难2分,以此类推,但是数据库计算值有问题,所以模糊计算
		int sum = 0;
		for (int i = nandu; i >= 0; i--) {
			if(statrs == 3){
				statrs = 0;
			}
			sum = nandu * 3 + statrs;
		}
		return sum;
	}
	
	private void sendReward(int serverid){
		// TODO 
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int monthStart = GlobalDatat.newServerDataMap.get(serverid).getInt(1);
		int dayStart = GlobalDatat.newServerDataMap.get(serverid).getInt(2);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		String activityTime = year + "-" + monthStart + "-" + dayStart;
		try {
			long remainderDay = getDaysBetween(activityTime);
			if(remainderDay == 8 && hour < 1){//充值排行奖励
//			if(true){
				List<GameTaskDetail> list = new ArrayList();
				for (int i = 1; i <= 10; i++) {
					for (Integer roleId : GlobalDatat.allChongZhiPaiMingMap.get(serverid).keySet()) {
						if(i == GlobalDatat.allChongZhiPaiMingMap.get(serverid).get(roleId)){
							try {
								list = this.getGameTaskService().getGameTaskDetailById(3000 + i - 1);//充值礼物
								String task = list.get(0).getTaskres();
								List<Map> tasks = JSON.parseArray(String.valueOf(task), Map.class);
								GameConstants.log.warn("奖品：：task;:"+task+"   roleid::"+roleId+"     tasks.toString::"+tasks.toString());
								Map<String, JSONArray> result = collect(tasks, roleId);// 发放奖励
								break ;
							} catch (Exception e) {
								GameConstants.log.warn("用户:" + roleId + "发放充值奖励失败");
							}
						}
					}
				}
			}else if(remainderDay == 16 && hour < 1){//关卡,副本,争霸战攻击力排行奖励
				List<GameTaskDetail> list = new ArrayList();
				/******关卡奖励*******/
				for (int i = 1; i <= 10; i++) {
					for (Integer roleId : GlobalDatat.allGuanKaPaiMingMap.get(serverid).keySet()) {
						if(i == GlobalDatat.allGuanKaPaiMingMap.get(serverid).get(roleId)){
							try {
								list = this.getGameTaskService().getGameTaskDetailById(3010 + i - 1);//关卡礼物
								String task = list.get(0).getTaskres();
								List<Map> tasks = JSON.parseArray(String.valueOf(task), Map.class);
								GameConstants.log.warn("奖品：：task;:"+task+"   roleid::"+roleId+"     tasks.toString::"+tasks.toString());
								Map<String, JSONArray> result = collect(tasks, roleId);// 发放奖励
								break ;
							} catch (Exception e) {
								GameConstants.log.warn("用户:" + roleId + "发放充值奖励失败");
							}
						}
					}
				}
				/******副本奖励********/
				for (int i = 1; i <= 10; i++) {
					for (Integer roleId : GlobalDatat.allFuBenPaiMingMap.get(serverid).keySet()) {
						if(i == GlobalDatat.allFuBenPaiMingMap.get(serverid).get(roleId)){
							try {
								list = this.getGameTaskService().getGameTaskDetailById(3020 + i - 1);//副本礼物
								String task = list.get(0).getTaskres();
								List<Map> tasks = JSON.parseArray(String.valueOf(task), Map.class);
								GameConstants.log.warn("奖品：：task;:"+task+"   roleid::"+roleId+"     tasks.toString::"+tasks.toString());
								Map<String, JSONArray> result = collect(tasks, roleId);// 发放奖励
								break ;
							} catch (Exception e) {
								GameConstants.log.warn("用户:" + roleId + "发放充值奖励失败");
							}
						}
					}
				}
				/*******争霸奖励********/
				for (int i = 1; i <= 10; i++) {
					for (Integer roleId : GlobalDatat.allZhengBaPaiMingMap.get(serverid).keySet()) {
						if(i == GlobalDatat.allZhengBaPaiMingMap.get(serverid).get(roleId)){
							try {
								list = this.getGameTaskService().getGameTaskDetailById(3030 + i - 1);//争霸礼物
								String task = list.get(0).getTaskres();
								List<Map> tasks = JSON.parseArray(String.valueOf(task), Map.class);
								GameConstants.log.warn("奖品：：task;:"+task+"   roleid::"+roleId+"     tasks.toString::"+tasks.toString());
								Map<String, JSONArray> result = collect(tasks, roleId);// 发放奖励
								break ;
							} catch (Exception e) {
								GameConstants.log.warn("用户:" + roleId + "发放充值奖励失败");
							}
						}
					}
				}
				list = null;
			}else{
				GameConstants.log.warn("Dont't in send reward time		!");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	/********************/
//	public void zhengbaten(int serverid){
//		System.out.println("zhengbaten serverid == " + serverid);
//		GlobalDatat.newserverchallenge.clear();
//		/** 15天的争霸战排行榜 **/
//		// int serverid=1;
//		Map<String, Object> param = new HashMap<String, Object>();
//		param.put("type", 1);
//		param.put("page", 0);
//		param.put("size", 10);
//		param.put("serverid", serverid);
//		List<GameChartsDetail> gcs = this
//				.getgameChartsService()
//				.findByQZFirstTen(param);// 15天的争霸战排行榜
//		try {
//			for (int i = 0; i < gcs.size(); i++) {
//				if (i < 10) {
//					GlobalDatat.newserverchallenge
//							.add(gcs.get(i));
//				}
//				GlobalDatat.newserverchallengemap.put(
//						gcs.get(i).getRoleId(),
//						gcs.get(i));
//				GlobalDatat.newserverchallengemaptwo
//						.put(gcs.get(i).getRoleId(),
//								i + 1);
//			}
//			GlobalDatat.newserverchallengeMap.put(serverid, GlobalDatat.newserverchallenge);//前十
//			GlobalDatat.newserverchallengemapMap.put(serverid, GlobalDatat.newserverchallengemap);//所有人的战斗力(目测)
//			GlobalDatat.newserverchallengemaptwoMap.put(serverid, GlobalDatat.newserverchallengemaptwo);//所有人排名(目测)
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
//	public void frontten(int serverid) {//刷新充值排行
//		GlobalDatat.listmapcharge.clear();
//		System.out.println("frontten serverid == " + serverid);
//		Iterator ittwo = GlobalDatat.mapChargeMap.get(serverid).keySet().iterator();
//		while (ittwo.hasNext()) {
//			Integer i = Integer.valueOf(ittwo.next().toString());
//			GlobalDatat.listmapcharge.add(GlobalDatat.mapChargeMap.get(serverid).get(i));
//		}
//		/*****/
//		for(int i=0;i<GlobalDatat.listmapcharge.size();i++){//去重
//	        for(int j=i;j<GlobalDatat.listmapcharge.size();j++){//从每一个索引开始比对其之后的所有内容
//	            if(GlobalDatat.listmapcharge.get(i)==GlobalDatat.listmapcharge.get(j) && i!=j){//如果内容相同并且不是相同索引
//	            	GlobalDatat.listmapcharge.remove(j);
//	            	j=0;//这里一定要清零
//	            }
//	        }
//	    }
//		/*****/
//		
//		Collections.sort(GlobalDatat.listmapcharge, new ByLength());
//		GlobalDatat.pretencharge.clear();
//		for (int i = 0; i < GlobalDatat.listmapcharge.size(); i++) {
//			Iterator itthree = GlobalDatat.mapChargeMap.get(serverid).keySet().iterator();
//			while (itthree.hasNext()) {
//				Integer j = Integer.valueOf(itthree.next().toString());
//				if (GlobalDatat.mapChargeMap.get(serverid).get(j) == GlobalDatat.listmapcharge.get(i)) {
//					GlobalDatat.mapcharge2.put(j, i + 1);
//					if (GlobalDatat.pretencharge.size() < 10) {
//						GlobalDatat.pretencharge.add(j);// 前十名玩家id
//					}
//				}
//			}
//		}
//		GlobalDatat.mapcharge2Map.put(serverid, GlobalDatat.mapcharge2);
//		GlobalDatat.listmapchargeMap.put(serverid, GlobalDatat.listmapcharge);
//		GlobalDatat.pretenchargeMap.put(serverid, GlobalDatat.pretencharge);
//	}
	
//	public void maplevel(int serverid) {//刷新关卡排行
//		System.out.println("maplevel serverid == " + serverid);
//		GlobalDatat.maplevel.clear();
//		Iterator it = GlobalDatat.cacheGameRoleDetails.keySet().iterator();
//		GameRoleDetail gr = null;
//		while (it.hasNext()) {
//			Integer i = Integer.valueOf(it.next().toString());
//			gr = GlobalDatat.cacheGameRoleDetails.get(i);
//			if(serverid == Integer.valueOf(gr.getServerId())){
//				int mapid = gr.getMapid();
//				int placeid = gr.getPlaceid();
//				if (mapid > 1) {
//					GlobalDatat.maplevel.put(i, mapid * 20 + placeid- 1);
//				}
//			}
//		}
////		Arrays.sort(test);
////		System.out.println(Arrays.toString(test));
//		if(GlobalDatat.maplevel.isEmpty()){//如果排行榜没东西  就没必要继续下去
//			return;
//		}
//		
//		GlobalDatat.listmaplevel.clear();
//		Iterator ittwo = GlobalDatat.maplevel.keySet().iterator();
//		while (ittwo.hasNext()) {
//			Integer i = Integer.valueOf(ittwo.next().toString());
//			GlobalDatat.listmaplevel.add(GlobalDatat.maplevel.get(i));
//		}
//		Collections.sort(GlobalDatat.listmaplevel, new ByLength());
//		
//		Integer strings = null;
//		/*****/
//		for(int i=0;i<GlobalDatat.listmaplevel.size();i++){//去重
//	        for(int j=i;j<GlobalDatat.listmaplevel.size();j++){//从每一个索引开始比对其之后的所有内容
//	            if(GlobalDatat.listmaplevel.get(i)==GlobalDatat.listmaplevel.get(j) && i!=j){//如果内容相同并且不是相同索引
//	            	GlobalDatat.listmaplevel.remove(j);
//	            	j=0;//这里一定要清零
//	            }
//	        }
//	    }
//		/*****/
//		
//		GlobalDatat.maplevelMap.put(serverid, GlobalDatat.maplevel);//写在这里是因为上面要排序以及去重
//		GlobalDatat.listmaplevelMap.put(serverid, GlobalDatat.listmaplevel);
//		// GameConstants.log.warn("GlobalDatat.listmaplevel.size::"+GlobalDatat.listmaplevel.size()+"得到从大到小排序后的总波说：："+GlobalDatat.listmaplevel);
//		GlobalDatat.pretenlevel.clear();
//		for (int i = 0; i < GlobalDatat.listmaplevel.size(); i++) {
//			Iterator itthree = GlobalDatat.maplevel.keySet().iterator();
//			while (itthree.hasNext()) {
//				Integer j = Integer.valueOf(itthree.next().toString());
//				if (GlobalDatat.maplevel.get(j) == GlobalDatat.listmaplevel.get(i)) {
//					GlobalDatat.maplevel2.put(j, i + 1);
//					if (GlobalDatat.pretenlevel.size() < 10) {//抽取所有玩家的百分之十来进行排序
//						GlobalDatat.pretenlevel.add(j);// 前十名玩家id
//					}
//				}
//			}
//		}
//		GlobalDatat.maplevel2Map.put(serverid, GlobalDatat.maplevel2);
////		for (Integer ok : GlobalDatat.pretenlevel) {
////			System.out.println(ok);
////		}
//		
//		for (int i = 0; i < GlobalDatat.pretenlevel.size(); i++) {
//			for (int k = i + 1; k < GlobalDatat.pretenlevel.size(); k++) {// k是后一个元素
//				if (GlobalDatat.maplevel.get(GlobalDatat.pretenlevel.get(i)) == GlobalDatat.maplevel
//						.get(GlobalDatat.pretenlevel.get(k))) {
//					// 总关卡数相同 等级低的拍前面 等级相同，经验低的放前面
//					if (GlobalDatat.cacheGameRoleDetails.get(
//							GlobalDatat.pretenlevel.get(i)).getLevel() < GlobalDatat.cacheGameRoleDetails
//							.get(GlobalDatat.pretenlevel.get(k)).getLevel()) {
//
//					} else if (GlobalDatat.cacheGameRoleDetails.get(
//							GlobalDatat.pretenlevel.get(i)).getLevel() == GlobalDatat.cacheGameRoleDetails
//							.get(GlobalDatat.pretenlevel.get(k)).getLevel()) {
//						if (GlobalDatat.cacheGameRoleDetails.get(
//								GlobalDatat.pretenlevel.get(i)).getExp() < GlobalDatat.cacheGameRoleDetails
//								.get(GlobalDatat.pretenlevel.get(k)).getExp()) {
//						} else {
//							Integer temp = GlobalDatat.pretenlevel.get(i);
//							GlobalDatat.pretenlevel.set(i,
//									GlobalDatat.pretenlevel.get(k));
//							GlobalDatat.pretenlevel.set(k,temp);
//						}
//					} else {
//						Integer temp = GlobalDatat.pretenlevel.get(i);
//						GlobalDatat.pretenlevel.set(i,
//								GlobalDatat.pretenlevel.get(k));
//						GlobalDatat.pretenlevel.set(k,temp);
//					}
//
//				}
//
//			}
//		}
//		GlobalDatat.pretenlevelMap.put(serverid, GlobalDatat.pretenlevel);//maplevel2Map
//	}

//	public void duplicatesort(int serverid) {// 副本积分排行榜
//		System.out.println("duplicatesort serverid == " + serverid);
//		if (!GlobalDatat.newserverdataMap.containsKey(serverid)) {
//			return;
//		}
//		GlobalDatat.mapfuben.clear();
//		Map<String, Object> param = new HashMap<String, Object>();
//		Iterator it = GlobalDatat.cacheGameRoleDetails.keySet().iterator();
//		try {
//			GameRoleDetail gr = null;
//			while (it.hasNext()) {
//				Integer i = Integer.valueOf(it.next().toString());
//				gr = GlobalDatat.cacheGameRoleDetails.get(i);
//				if (serverid == Integer.parseInt(String.valueOf(gr.getServerId()))) {
//					int mapid = gr.getMapid();
//					if (mapid > 1) {
//						param.clear();
//						param.put("roleid", i);// i--roleid
//						param.put("mapid", 5000);
//						List<RoleBingDetail> rb = this.getRoleBingService()
//										.findRoleBingByParam(param);
//						if (rb.isEmpty() || rb.size() < 1) {
//	
//						} else {
//							GlobalDatat.mapfuben.put(i, (rb.get(0).getNandu() + 1)
//											* rb.get(0).getStars());
//							for (int j = 1; j < rb.size(); j++) {
//								GlobalDatat.mapfuben.put(i,
//									GlobalDatat.mapfuben.get(i)+ (rb.get(j)
//											.getNandu() + 1) * rb.get(j).getStars());
//							}
//						}
//					}
//				}
//			}	
//			GlobalDatat.mapfubenMap.put(serverid, GlobalDatat.mapfuben);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		// GameConstants.log.warn("GlobalDatat.mapfuben.size::"+GlobalDatat.mapfuben.size()+"   GlobalDatat.mapfuben::"+GlobalDatat.mapfuben);
//		GlobalDatat.listmapfuben.clear();
//		Iterator ittwo = GlobalDatat.mapfuben.keySet().iterator();
//		while (ittwo.hasNext()) {
//			Integer i = Integer.valueOf(ittwo.next().toString());
//			// GlobalDatat.listmaplevel.add(GlobalDatat.sevencharge.get(Integer.valueOf(ittwo.next().toString())));
//			GlobalDatat.listmapfuben.add(GlobalDatat.mapfuben.get(i));
//		}
//		
//		/*****/
//		for(int i=0;i<GlobalDatat.listmapfuben.size();i++){//去重
//	        for(int j=i;j<GlobalDatat.listmapfuben.size();j++){//从每一个索引开始比对其之后的所有内容
//	            if(GlobalDatat.listmapfuben.get(i)==GlobalDatat.listmapfuben.get(j) && i!=j){//如果内容相同并且不是相同索引
//	            	GlobalDatat.listmapfuben.remove(j);
//	            	j=0;//这里一定要清零
//	            }
//	        }
//	    }
//		/*****/
//		
//		Collections.sort(GlobalDatat.listmapfuben, new ByLength());
//		// GameConstants.log.warn("GlobalDatat.listmapfuben.size::"+GlobalDatat.listmapfuben.size()+"得到从大到小排序后的总积分：："+GlobalDatat.listmapfuben);
//
//		GlobalDatat.pretenfuben.clear();
//		for (int i = 0; i < GlobalDatat.listmapfuben.size(); i++) {
//			Iterator itthree = GlobalDatat.mapfuben.keySet().iterator();
//			while (itthree.hasNext()) {
//				// int
//				// mapid=GlobalDatat.cacheGameRoleDetails.get(Integer.valueOf(it.next().toString())).getMapid();
//				// int
//				// placeid=GlobalDatat.cacheGameRoleDetails.get(Integer.valueOf(it.next().toString())).getPlaceid();
//				// GlobalDatat.maplevel.put((Integer) it.next(),
//				// mapid*20+placeid-1);
//				Integer j = Integer.valueOf(itthree.next().toString());
//				if (GlobalDatat.mapfuben.get(j) == GlobalDatat.listmapfuben
//						.get(i)) {
//					GlobalDatat.mapfuben2.put(j, i + 1);
//					if (GlobalDatat.pretenfuben.size() < 10) {
//						GlobalDatat.pretenfuben.add(j);// 前十名玩家id
//					}
//				}
//			}
//			GlobalDatat.mapfuben2Map.put(serverid, GlobalDatat.mapfuben2);
//			GlobalDatat.pretenfubenMap.put(serverid, GlobalDatat.pretenfuben);
//		}
//	}

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
			type = Integer
					.parseInt(String.valueOf(tasks.get(i).get("resType")));
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
					param.put("three",
							this.getGameRoleService().findRoleById(roleid)
									.getThree()
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
				type = Integer.parseInt(String.valueOf(tasks.get(i).get(
						"resType")));
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

	public boolean getShangxian(int type, int resType, int roleId, int id,
			int num) {
		boolean boo = false;
		// int vip = this.getGameRoleService().findRoleById(roleId).getVip();//
		// 查看vip等级
		GameRoleDetail gr = this.getGameRoleService().findRoleById3(roleId);
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
			params.put("itemid", id);
			// params.put("type", type);
			List<RoleEquipDetail> lists = this.getRoleEquipService()
					.getRoleEquipUser(params);// 查看这种类型有几个是否到了上线；
			if (backTop - num >= lists.size()) {// 判断 是否超出上限
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
	
	/** roleId:人物id，id：道具id，type：道具类型5,6resType，num：数量 */
	protected boolean getGifts(int roleId, int id, int resType, int num,JSONArray list) {
		Map<String, Object> param = new HashMap<String, Object>();
		boolean shi = true;
		if (5 == resType) {// 道具
			param.put("roleid", roleId);
			param.put("itemid", id);
			List<RoleItemDetail> item = this.getRoleItemService().getRoleItem(
					param);
			param.put("num", num);// 获得数量
			param.put("resType", resType);
			// System.out.println("————————————————获取数量"+(bl-a));
			// 判断背包格子是否已满
			int itemtype = this.getGameItemService().getGameItemById(id).get(0)
					.getItemtype();
			boolean boo = this.getplayerHandler().getShangxian(itemtype,
					resType, roleId, id, num);
			// System.out.println("————————————————判断背包"+(bl-a));
			if (boo == false) {// 背包格子不足
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "道具空间不足");
				shi = false;
				return shi;
			}
			List<GameItemDetail> gameitem = this.getGameItemService()
					.getGameItemById(id);
			if (!gameitem.isEmpty()) {
				int pinzhi = gameitem.get(0).getQuality();
				//判断寻宝的道具是否广播
				if(gameitem.get(0).getQuality()>=4){
					// 系统公告//发送广播
					GameRoleDetail role = this.getGameRoleService().findRoleById(roleId);
					int quality = Integer.valueOf(String.valueOf(gameitem.get(0).getQuality()));
					
					UtilHandler util = new UtilHandler();
					String name2 = role.getName();
					int vip2 = role.getVip();
					String where = "幸运大转盘";
					String goodsName = gameitem.get(0).getItemname();
					util.sendGetMessage(name2, vip2, where, pinzhi, goodsName,"xiulian gozhuanpan");
				}
			}
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
				if (bo == true) {
					param.put("bid", bid);
					param.remove("roleid");
					param.put("id", id);
					param.remove("itemid");
					list.add(param);

				}
			}
		}
//		 System.out.println("——转盘得到礼物结束");
		return shi;
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
	
	
	private List removeSame(List<Integer> list){//去重
	    for(int i=0;i<list.size();i++){
	 
	        for(int j=i;j<list.size();j++){//从每一个索引开始比对其之后的所有内容
	           if(list.get(i)==list.get(j) && i!=j){//如果内容相同并且不是相同索引
	        	   list.remove(j);
	        	   j=0;//这里一定要清零
	           }
	        }
	    }
	    return list;
	}
	
	/** roleId:人物id，id：道具id，type：道具类型5,6resType，num：数量 */
	protected boolean getGifts(int roleId, int id, int resType, int num,JSONArray list,String where) {
		// TODO
//		 System.out.println("转盘礼物开始");
		Map<String, Object> param = new HashMap<String, Object>();
		boolean shi = true;
		if (5 == resType) {// 道具
			param.put("roleid", roleId);
			param.put("itemid", id);
			List<RoleItemDetail> item = this.getRoleItemService().getRoleItem(
					param);
			param.put("num", num);// 获得数量
			param.put("resType", resType);
			// System.out.println("————————————————获取数量"+(bl-a));
			// 判断背包格子是否已满
			int itemtype = this.getGameItemService().getGameItemById(id).get(0)
					.getItemtype();
			boolean boo = this.getplayerHandler().getShangxian(itemtype,
					resType, roleId, id, num);
			// System.out.println("————————————————判断背包"+(bl-a));
			if (boo == false) {// 背包格子不足
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "道具空间不足");
				shi = false;
				return shi;
			}
			List<GameItemDetail> gameitem = this.getGameItemService()
					.getGameItemById(id);
			if (!gameitem.isEmpty()) {
				int pinzhi = gameitem.get(0).getQuality();
				//判断寻宝的道具是否广播
				if(gameitem.get(0).getQuality()>=4){
					// 系统公告//发送广播
					GameRoleDetail role = this.getGameRoleService().findRoleById(roleId);
					int quality = Integer.valueOf(String.valueOf(gameitem.get(0).getQuality()));
					
					UtilHandler util = new UtilHandler();
					String name2 = role.getName();
					int vip2 = role.getVip();
					String goodsName = gameitem.get(0).getItemname();
					util.sendGetMessage(name2, vip2, where, pinzhi, goodsName,"xiulian gozhuanpan");
				}
			}
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
					System.out.println("怎么走到这里了???");
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
				if (bo == true) {
					param.put("bid", bid);
					param.put("id", id);
					param.remove("roleid");
					param.remove("itemid");
					list.add(param);
				}else{
					System.out.println("怎么走到这里了???!!!");
				}
			}
		}
//		 System.out.println("——转盘得到礼物结束");
		return shi;
	}
}