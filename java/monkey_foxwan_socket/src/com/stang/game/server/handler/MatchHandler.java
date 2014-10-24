package com.stang.game.server.handler;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.sf.json.JSONArray;
import net.sf.sojo.interchange.json.JsonSerializer;

import org.apache.mina.core.session.IoSession;

import com.alibaba.fastjson.JSON;
import com.stang.game.cache.GlobalData;
import com.stang.game.cache.GlobalDatat;
import com.stang.game.common.GameConstants;
import com.stang.game.entity.GameJingjiStatic;
import com.stang.game.entity.detail.GameEquipDetail;
import com.stang.game.entity.detail.GameJingjiFinalDetail;
import com.stang.game.entity.detail.GameJingjiStaticDetail;
import com.stang.game.entity.detail.GameLevelDetail;
import com.stang.game.entity.detail.GameMilitaryDetail;
import com.stang.game.entity.detail.GamePriceDetail;
import com.stang.game.entity.detail.GameRoleDetail;
import com.stang.game.entity.detail.GametotemDetail;
import com.stang.game.entity.detail.RoleChallengeDetail;
import com.stang.game.entity.detail.RoleEquipDetail;
import com.stang.game.entity.detail.RoleItemDetail;
import com.stang.game.entity.detail.RoleMilitaryDetail;
import com.stang.game.entity.detail.RoletotemDetail;
import com.stang.game.server.ServerHandler;
import com.stang.game.service.IGameEquipService;
import com.stang.game.service.IGameJingjiFinalService;
import com.stang.game.service.IGameJingjiStaticService;
import com.stang.game.service.IGameLevelService;
import com.stang.game.service.IGameVipService;
import com.stang.game.service.IGametotemService;
import com.stang.game.service.IRoleEquipService;
import com.stang.game.service.IRoleItemService;
import com.stang.game.service.IRoleMapService;
import com.stang.game.service.IRoleMilitaryService;
import com.stang.game.service.IRoleTavernService;
import com.stang.game.service.IRoletotemService;
import com.stang.game.service.IServerService;
import com.stang.game.service.impl.GameEquipServiceImpl;
import com.stang.game.service.impl.GameJingjiFinalServiceImpl;
import com.stang.game.service.impl.GameJingjiStaticServiceImpl;
import com.stang.game.service.impl.GameLevelServiceImpl;
import com.stang.game.service.impl.GameVipServiceImpl;
import com.stang.game.service.impl.GametotemServiceImpl;
import com.stang.game.service.impl.RoleEquipServiceImpl;
import com.stang.game.service.impl.RoleItemServiceImpl;
import com.stang.game.service.impl.RoleMapServiceImpl;
import com.stang.game.service.impl.RoleMilitaryServiceImpl;
import com.stang.game.service.impl.RoleTavernServiceImpl;
import com.stang.game.service.impl.RoletotemServiceImpl;
import com.stang.game.service.impl.ServerServiceImpl;

public class MatchHandler extends BaseHandler {
	static private PlayerHandler playerHandler;

	private PlayerHandler getplayerHandler() {
		if (playerHandler == null) {
			playerHandler = new PlayerHandler(gameApiName, globalIdentifier,
					encryptedSignature, playerId, cacheKey, params, session);
		}
		return playerHandler;
	}
	
	static private SystemHandler systemHandler;

	private SystemHandler getsystemHandler() {
		if (systemHandler == null) {
			systemHandler = new SystemHandler();
		}
		return systemHandler;
	}
	
	private static IGameEquipService gameEquipService;

	private IGameEquipService getGameEquipService() {
		if (gameEquipService == null) {
			gameEquipService = new GameEquipServiceImpl();
		}
		return gameEquipService;
	}
	static private MapHandler mapHandler;

	private MapHandler getMapHandler() {
		if (mapHandler == null) {
			mapHandler = new MapHandler(gameApiName, globalIdentifier,
					encryptedSignature, playerId, cacheKey, params, session);
		}
		return mapHandler;
	}
	
	private static IGameLevelService gameLevelService;

	private IGameLevelService getGameLevelService() {
		if (gameLevelService == null) {
			gameLevelService = new GameLevelServiceImpl();
		}
		return gameLevelService;
	}
	
	private static IGameJingjiStaticService gameJingjiStaticService;
	
	private IGameJingjiStaticService getGameJingjiStaticService(){
		if(gameJingjiStaticService == null){
			gameJingjiStaticService = new GameJingjiStaticServiceImpl();
		}
		return gameJingjiStaticService;
	}
	private static IServerService serverservice;
	private IServerService getServerservice(){
		if(serverservice==null){
			serverservice=new ServerServiceImpl();
		}
		return serverservice;
	}
	private static IGameJingjiFinalService gameJingjiFinalService;
	
	private IGameJingjiFinalService getGameJingjiFinalService(){
		if(gameJingjiFinalService == null){
			gameJingjiFinalService = new GameJingjiFinalServiceImpl();
		}
		return gameJingjiFinalService;
	}
	
	private static IGameVipService gameVipService;

	private IGameVipService getGameVipService() {
		if (gameVipService == null) {
			gameVipService = new GameVipServiceImpl();
		}
		return gameVipService;
	}

	private static IRoleTavernService roleTavernService;

	private IRoleTavernService getRoleTavernService() {
		if (roleTavernService == null) {
			roleTavernService = new RoleTavernServiceImpl();
		}
		return roleTavernService;
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
	private static IGametotemService gametotemService;
	private IGametotemService getGametotemService(){
		if(gametotemService==null){
			gametotemService=new GametotemServiceImpl();
		}
		return gametotemService;
	}
	
	private static IRoletotemService roletotemService;
	private IRoletotemService getRoletotemService(){
		if(roletotemService==null){
			roletotemService=new RoletotemServiceImpl();
		}
		return roletotemService;
	}
	private static IRoleItemService roleItem;

	private IRoleItemService getRoleItemService() {
		if (roleItem == null) {
			roleItem = new RoleItemServiceImpl();
		}
		return roleItem;
	}

	private static IRoleMapService rolemap;

	private IRoleMapService getRoleMapService() {
		if (rolemap == null) {
			rolemap = new RoleMapServiceImpl();
		}
		return rolemap;
	}

	public MatchHandler(){};
	
	public MatchHandler(String gameApiName, String globalIdentifier,
			String encryptedSignature, String playerId, String cacheKey,
			Map params, IoSession session) {
		super(gameApiName, globalIdentifier, encryptedSignature, playerId,
				cacheKey, params, session);
		if (gameApiName.equals("match.buyshop")) {
			/* 竞技场商店购买 */
			buyshop();
		}else if(gameApiName.equals("match.openchallenge")){
			/* 打开竞技场 */
			openchallenge();
		}else if(gameApiName.equals("match.addnum")){
			/* 增加竞技次数 */
			addnum();
		}else if(gameApiName.equals("match.getgoods")){
			/* 领取每日排名奖励 */
			getgoods();
		}else if(gameApiName.equals("match.subtime")){
			/* 减少冷却时间 */
			subtime();
		}else if(gameApiName.equals("match.fight")){
			/* 战斗 */
			fight();
		}else if(gameApiName.equals("match.changefight")){
			/* 更换出战武将 */
			changefight();
		}else if(gameApiName.equals("match.openchange")){
			/* 打开显示出战武将 */
			openchange();
		}else if(gameApiName.equals("match.openranklist")){
			/* 打开全服排行榜*/
			openranklist();
		}else if(gameApiName.equals("match.ranklistreg")){
			/* 分页查询固定排行榜*/
			ranklistreg();
		}else if(gameApiName.equals("match.ranklistss")){
			/* 实时排行榜分页查询*/
			ranklistss();
		}else if(gameApiName.equals("match.opentotem")){
			/*打开图腾按钮*/
			opentotem();
		}else if(gameApiName.equals("match.totemcompound")){
			/*图腾的合成*/
			totemcompound();
		}else if(gameApiName.equals("match.openmountain")){
			/*打开下山掠夺界面*/
			openmountain();
		}else if(gameApiName.equals("match.mountaingift")){
			/*领取下山掠夺奖励*/
			mountaingift();
		}else if(gameApiName.equals("match.mountainchoise")){
			/*选择下山掠夺*/
			mountainchoise();
		}else if(gameApiName.equals("match.mountainflush")){
			/*刷新下山掠夺*/
			mountainflush();
		}else if(gameApiName.equals("match.openghost")){
			/*打开魔壂*/
			openghost();
		}else if(gameApiName.equals("match.deskcheck")){
			/*更新用户桌面登录奖励领取*/
			deskCheck();
		}else if(gameApiName.equals("match.opendeskgame")){
			/*打开桌面登录奖励领取界面*/
			opendeskgame();
		}else if(gameApiName.equals("match.deskgift")){
			/*领取桌面登录奖励*/
			deskgift();
		}
	}
	
	private void deskgift(){
		Map<String, Object> rlt = new HashMap<String, Object>();
		int roleId = Integer.parseInt(playerId);
		GameRoleDetail role = this.getGameRoleService().findRoleById(roleId);
		if(role.getDeskcheck() == 1){
			
			//String res = "[{"id":30,"resType":5,"num":4},{"id":31,"resType":5,"num":4}]"
			List<Map> resList = JSON.parseArray("[]", Map.class);
			Map<String, Integer> map1 = new HashMap<String, Integer>();
			Map<String, Integer> map2 = new HashMap<String, Integer>();
			Map<String, Integer> map3 = new HashMap<String, Integer>();
			resList.add(map1);
			resList.add(map2);
			resList.add(map3);
			resList.get(0).put("resType", 5);
			resList.get(0).put("id", 3);
			resList.get(0).put("num", 1);
			resList.get(1).put("resType", 5);
			resList.get(1).put("id", 4);
			resList.get(1).put("num", 1);
			resList.get(2).put("resType", 5);
			resList.get(2).put("id", 356);
			resList.get(2).put("num", 1);
			//System.out.println("MathchHandler.deskgift():resList:" + resList.toString());
			JSONArray list = new JSONArray();// 用list<map>type=6会报错
			for (int i = 0; i < resList.size(); i++) {
				Map<String, Object> params = new HashMap<String, Object>();
				Map map = resList.get(i);
				int type = Integer.parseInt(String.valueOf(map.get("resType")));
				int id = Integer.parseInt(String.valueOf(map.get("id")));
				int num = Integer.parseInt(String.valueOf(map.get("num")));
				if (type == 5) {// 道具
					params.clear();
					params.put("roleid", roleId);
					params.put("itemid", id);
					List<RoleItemDetail> item = this
							.getRoleItemService().getRoleItem(params);
					params.put("num", num);// 获得数量
					params.put("resType", type);
					// 判断背包格子是否已满
					int itemtype = this.getGameItemService().getGameItemById(id).get(0).getItemtype();
					PlayerHandler p = new PlayerHandler();
					boolean boo = p.getShangxian(itemtype, type, roleId, id, num);
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
//						int bid = this.getAutoIdService()
//								.fingKeyValueByTableName("role_item") + 1;
						long bid = this.getAutoIdService().fingKeyValueByTableName("role_item");
	//					System.out.println("playerHandler得到long类型的id:::"+bid);
						
						RoleItemDetail iDetail = new RoleItemDetail();
						iDetail.setId(bid);
						iDetail.setRoleid(roleId);
						iDetail.setItemid(id);
						iDetail.setNum(num);
						iDetail.setFlag(1);
						iDetail.setType(itemtype);
						boolean bo = this.getRoleItemService()
								.insertRoleItem(iDetail);
//						this.getAutoIdService()
//								.updateKeyValueAddOneByTableName(
//										"role_item");
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
					int equiptype = this.getGameEquipService().getGameEquipById(id).get(0).getType();
					PlayerHandler p = new PlayerHandler();
					boolean boo = p.getShangxian(equiptype, type, roleId, id, num);
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
//						this.getAutoIdService()
//								.updateKeyValueAddOneByTableName(
//										"role_equip");

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
			role.setDeskcheck(2);
			
			
			rlt.put("reward", list);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
		}else{
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
			ServerHandler.sendData(session, respMap);
		}
		
	}
	
	private void opendeskgame(){
		Map<String, Object> rlt = new HashMap<String, Object>();
		int roleid = Integer.parseInt(playerId);
		GameRoleDetail role = this.getGameRoleService().findRoleById(roleid);
		if(role.getDeskcheck() == 1){
			rlt.put("get", 1);
		}else{
			rlt.put("get", null);
		}
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
		ServerHandler.sendData(session, respMap);
	}
	
	private void  deskCheck(){
		//GameConstants.log.warn("MathHandler.deskCheck():params:" + params.toString());
		if(params.containsKey("roleid")){
			int roleid = Integer.valueOf(String.valueOf(params.get("roleid")));
			GameRoleDetail role = this.getGameRoleService().findRoleById(roleid);
			if(null != role){
				GameConstants.log.warn("MathHandler.deskCheck():roleid:" + roleid + " Deskcheck:" + role.getDeskcheck());
				if(role.getDeskcheck() == 0){
					role.setDeskcheck(1);
				}
			}else{
				GameConstants.log.warn("MathHandler.deskCheck():there is no gameRole:roleid:" + roleid);
			}
		}else{
			GameConstants.log.warn("MathcHandler.deskCheck():the params is not exist!");
		}
	}
	private void openghost(){
		Map<String, Object> rlt = new HashMap<String, Object>();
		List<Integer> militaryList = new ArrayList<Integer>();
		int roleid = Integer.parseInt(playerId);
		if(GlobalDatat.cacheForRoleMilitaryGhost.containsKey(roleid)){
			militaryList = GlobalDatat.cacheForRoleMilitaryGhost.get(roleid);
		}else{
			List<Integer> mList = new ArrayList<Integer>();
			Map<Integer, Map<Integer, List<Integer>>> pinMap = new HashMap<Integer, Map<Integer, List<Integer>>>();
			Map<Integer, List<Integer>> typeMap3 = new HashMap<Integer, List<Integer>>();
			Map<Integer, List<Integer>> typeMap4 = new HashMap<Integer, List<Integer>>();
			Map<Integer, List<Integer>> typeMap5 = new HashMap<Integer, List<Integer>>();
			List<Integer> list1 = new ArrayList<Integer>();
			List<Integer> list2 = new ArrayList<Integer>();
			List<Integer> list3 = new ArrayList<Integer>();
			List<Integer> list4 = new ArrayList<Integer>();
			List<Integer> list5 = new ArrayList<Integer>();
			List<Integer> list6 = new ArrayList<Integer>();
			List<Integer> list7 = new ArrayList<Integer>();
			List<Integer> list8 = new ArrayList<Integer>();
			List<Integer> list9 = new ArrayList<Integer>();
			typeMap3.put(1, list1);
			typeMap3.put(2, list2);
			typeMap3.put(3, list3);
			typeMap4.put(1, list4);
			typeMap4.put(2, list5);
			typeMap4.put(3, list6);
			typeMap5.put(1, list7);
			typeMap5.put(2, list8);
			typeMap5.put(3, list9);
			pinMap.put(3, typeMap3);
			pinMap.put(4, typeMap4);
			pinMap.put(5, typeMap5);
			
			Map<Integer, GameMilitaryDetail> cacheData = GlobalDatat.cacheGameMilitaryDetails;
			Iterator it = cacheData.keySet().iterator();
			while(it.hasNext()){
				int militaryId = (Integer) it.next();
				GameMilitaryDetail gMilitary = cacheData.get(militaryId);
				if(gMilitary.getMohunboolean() == 1){
					if(gMilitary.getPingzhi() == 3){
						if(gMilitary.getType() == 1){
							pinMap.get(3).get(1).add(gMilitary.getId());
						}else if(gMilitary.getType() == 2){
							pinMap.get(3).get(2).add(gMilitary.getId());
						}else if(gMilitary.getType() == 3){
							pinMap.get(3).get(3).add(gMilitary.getId());
						}
					}else if (gMilitary.getPingzhi() == 4){
						if(gMilitary.getType() == 1){
							pinMap.get(4).get(1).add(gMilitary.getId());
						}else if(gMilitary.getType() == 2){
							pinMap.get(4).get(2).add(gMilitary.getId());
						}else if(gMilitary.getType() == 3){
							pinMap.get(4).get(3).add(gMilitary.getId());
						}
					}else if(gMilitary.getPingzhi() == 5){
						if(gMilitary.getType() == 1){
							pinMap.get(5).get(1).add(gMilitary.getId());
						}else if(gMilitary.getType() == 2){
							pinMap.get(5).get(2).add(gMilitary.getId());
						}else if(gMilitary.getType() == 3){
							pinMap.get(5).get(3).add(gMilitary.getId());
						}
					}
				}
			}
			Random r = new Random();
			mList.add(pinMap.get(3).get(1).get(r.nextInt(pinMap.get(3).get(1).size())));
			mList.add(pinMap.get(3).get(2).get(r.nextInt(pinMap.get(3).get(2).size())));
			mList.add(pinMap.get(3).get(3).get(r.nextInt(pinMap.get(3).get(3).size())));
			mList.add(pinMap.get(4).get(1).get(r.nextInt(pinMap.get(4).get(1).size())));
			mList.add(pinMap.get(4).get(2).get(r.nextInt(pinMap.get(4).get(2).size())));
			mList.add(pinMap.get(4).get(3).get(r.nextInt(pinMap.get(4).get(3).size())));
			mList.add(pinMap.get(5).get(1).get(r.nextInt(pinMap.get(5).get(1).size())));
			mList.add(pinMap.get(5).get(2).get(r.nextInt(pinMap.get(5).get(2).size())));
			mList.add(pinMap.get(5).get(3).get(r.nextInt(pinMap.get(5).get(3).size())));
			GlobalDatat.cacheForRoleMilitaryGhost.put(roleid, mList);
			militaryList = GlobalDatat.cacheForRoleMilitaryGhost.get(roleid);

			//System.out.println("MathHandler.openGhost.pinMap:" + pinMap.toString());
		}
		rlt.put("b", this.getGameRoleService().findRoleById(roleid).getMohunboolean());
		rlt.put("time", System.currentTimeMillis());
		rlt.put("num", this.getGameRoleService().findRoleById(roleid).getMohun());
		rlt.put("type", militaryList);
		//System.out.println("MathHandler.openGhost.rlt:" + rlt.toString());
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
		ServerHandler.sendData(session, respMap);
	}
	private void mountainflush() {
		/***
		 * ary.getInt(0)==1取原来的数据(!=1随机刷新奖励给玩家)
		 * ary.getInt(1)玩家选择的是哪个时间的下山掠夺（1：8小时   2：12小时  3：24小时）
		 * ary.getInt(2)  8小时的随机奖励
		 * ary.getInt(3)  12小时的随机奖励
		 * ary.getInt(4)  24小时的随机奖励
		 * *//****/
		if(params.containsKey("type")){
			int type = Integer.valueOf(String.valueOf(params.get("type")));
			int roleid = Integer.parseInt(playerId);
			GameRoleDetail role = this.getGameRoleService().findRoleById(roleid);
			int yin = role.getYin();
			int level = role.getLevel();
			Map<String, Object> rlt = new HashMap<String, Object>();
			String openmountain=role.getOpenmountain();
			JSONArray ary = JSONArray.fromObject(openmountain);
			Random random = new Random();
			Map<String,Object> param = new HashMap<String,Object>();
			//System.out.println("重新选择奖励刷新类型：：：：：："+type);
			if(type==1){//使用铜钱刷新
            if(yin>=level*500){
            	JSONArray pinz=new JSONArray();
				ary.set(0, 1);
				ary.set(1, 0);
				int k=2;
				for(int i=2;i<500;i++){
					if(random.nextInt(100)<30){//1 白色奖励
						pinz.add(1);
						ary.set(k, 1);
						k++;
					}else if(random.nextInt(100)>=30&&random.nextInt(100)<55){
						//2绿色奖励
						pinz.add(2);
						ary.set(k,2);
						k++;
					}else if(random.nextInt(100)>=55&&random.nextInt(100)<75){//3 蓝色奖励
						pinz.add(3);
						ary.set(k, 3);
						k++;
					}else if(random.nextInt(100)>=75&&random.nextInt(100)<90){//4 红色奖励
						pinz.add(4);
						ary.set(k,4);
						k++;
					}else if(random.nextInt(100)>=90){
						pinz.add(5);
						ary.set(k,5);
						k++;
					}
					if(pinz.size()==3){
						break;
					}
				}
				param.clear();
				param.put("roleid", roleid);
				param.put("itemid", 286);
				List<RoleItemDetail> ri=this.getRoleItemService().getRoleItemByitem(param);
				if(ri.isEmpty()){
					rlt.put("bid", 0);
					rlt.put("num",0);
				}else{
					rlt.put("bid", ri.get(0).getId());
					rlt.put("num", ri.get(0).getNum());
				}
				rlt.put("yin", yin-level*500);
				
				param.clear();
				param.put("id", roleid);
				param.put("yin", yin-level*500);
				param.put("openmountain", ary.toString());
				this.getGameRoleService().updateRoleVip(param);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
				ServerHandler.sendData(session, respMap);
				
            }else{
            	 respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							-1);//铜钱不够
					ServerHandler.sendData(session, respMap);
					return;
            }
			
			}else if(type==2){//使用巡山令刷新
				param.clear();
				param.put("roleid", roleid);
				param.put("itemid", 286);
				List<RoleItemDetail> ri=this.getRoleItemService().getRoleItemByitem(param);
				if(ri.isEmpty()){
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							-2);//巡山令不足
					ServerHandler.sendData(session, respMap);
					return;
				}
				int num=ri.get(0).getNum();
				//System.out.println("巡山令数量：：：："+num);
				if(num>=1){
					JSONArray pinz=new JSONArray();
					ary.set(0, 1);
					ary.set(1, 0);
					int k=2;
					for(int i=2;i<500;i++){
						if(random.nextInt(100)<40){//3 蓝色奖励
							pinz.add(3);
							ary.set(k, 3);
							k++;
						}else if(random.nextInt(100)>=40&&random.nextInt(100)<70){//4 红色奖励
							pinz.add(4);
							ary.set(k,4);
							k++;
						}else if(random.nextInt(100)>=70){
							pinz.add(5);
							ary.set(k,5);
							k++;
						}
						if(pinz.size()==3){
							break;
						}
					}
					param.clear();
					param.put("num", 1);
					param.put("roleid", roleid);
					param.put("itemid", 286);
					this.getRoleItemService().sbRoleItemNum(param);
					rlt.put("num", num-1);
					rlt.put("bid",ri.get(0).getId());
					rlt.put("yin", yin);
					param.clear();
					param.put("id", roleid);
					param.put("openmountain", ary.toString());
					this.getGameRoleService().updateRoleVip(param);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
					ServerHandler.sendData(session, respMap);
				}else{//巡山令不足
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							-2);//巡山令不足
					ServerHandler.sendData(session, respMap);
					return;
				}
			}
			
		}
		
	}

	private void mountainchoise() {
		/***
		 * ary.getInt(0)==1取原来的数据(!=1随机刷新奖励给玩家)
		 * ary.getInt(1)玩家选择的是哪个时间的下山掠夺（1：8小时   2：12小时  3：24小时）
		 * ary.getInt(2)  8小时的随机奖励
		 * ary.getInt(3)  12小时的随机奖励
		 * ary.getInt(4)  24小时的随机奖励
		 * *//****/
		if(params.containsKey("type")){
			int type = Integer.valueOf(String.valueOf(params.get("type")));
			int roleid = Integer.parseInt(playerId);
			GameRoleDetail role = this.getGameRoleService().findRoleById(roleid);
			String openmountain=role.getOpenmountain();
			JSONArray ary = JSONArray.fromObject(openmountain);
			
			Map<String, Object> rlt = new HashMap<String, Object>();
			//System.out.println("选择下山掠夺的时间类型：：：：：："+type);
			if(ary.getInt(1)!=0){//已经选择了，不能在选
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						-1);
				ServerHandler.sendData(session, respMap);
			}
			if(type==8){//玩家选择8小时下山掠夺
				long time = new Date().getTime();
				long nowtime = time + 8*60*60*1000;
				Map<String, Object> pa = new HashMap<String, Object>();
				pa.put("nowtime", nowtime);
				pa.put("id", roleid);
				this.getGameRoleService().updateRolenowtime(pa);
				
				pa.clear();
				ary.set(1, 1);
				pa.put("id", roleid);
				pa.put("openmountain", ary.toString());
				this.getGameRoleService().updateRoleVip(pa);
				
				rlt.put("type",type);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
				ServerHandler.sendData(session, respMap);
			}else if(type==12){
				long time = new Date().getTime();
				long nowtime = time + 12*60*60*1000;
				Map<String, Object> pa = new HashMap<String, Object>();
				pa.put("nowtime", nowtime);
				pa.put("id", roleid);
				this.getGameRoleService().updateRolenowtime(pa);
				pa.clear();
				ary.set(1, 2);
				pa.put("id", roleid);
				pa.put("openmountain", ary.toString());
				this.getGameRoleService().updateRoleVip(pa);
				rlt.put("type",type);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
				ServerHandler.sendData(session, respMap);
			}else if(type==24){
				long time = new Date().getTime();
				long nowtime = time + 24*60*60*1000;
				Map<String, Object> pa = new HashMap<String, Object>();
				pa.put("nowtime", nowtime);
				pa.put("id", roleid);
				this.getGameRoleService().updateRolenowtime(pa);
				pa.clear();
				ary.set(1, 3);
				pa.put("id", roleid);
				pa.put("openmountain", ary.toString());
				this.getGameRoleService().updateRoleVip(pa);
				rlt.put("type",type);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
				ServerHandler.sendData(session, respMap);
			}
		}
	
	}

	private void mountaingift() {
		int roleid = Integer.parseInt(playerId);
		GameRoleDetail role = this.getGameRoleService().findRoleById(roleid);
		String openmountain=role.getOpenmountain();
		JSONArray ary = JSONArray.fromObject(openmountain);
		Map<String, Object> rlt = new HashMap<String, Object>();
		Map<String,Object> param = new HashMap<String,Object>();
		int yin = role.getYin();
		int rlevel = role.getLevel();
		int junling = role.getJunling();
		int yin1 =rlevel;
		long nowtime = role.getNowtime();
		long time=System.currentTimeMillis();
		//System.out.println("玩家领取奖励的等级：：：：："+yin1+":::::openmountain::"+ary);
		int huangzuan = 0;//判断黄钻
		JsonSerializer json = new JsonSerializer();
		
		String Huangzuaninfo = role.getHuangzuaninfo();
		if("null".equals(String.valueOf(Huangzuaninfo))){
			
		}else{
			List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
			.deserialize(Huangzuaninfo);
			int ret = Integer.parseInt(String.valueOf(roleinfo.get(0).get("ret")));
			if(ret==0){
				huangzuan = Integer.parseInt(String.valueOf(roleinfo.get(0).get("is_yellow_vip")));
			}
			roleinfo=null;
		}
		if(huangzuan==1){
			huangzuan=2;//黄钻用户享受双倍领取奖励时间
		}else{
			huangzuan=1;
		}
		
		if(ary.getInt(1)==0){//玩家没有选择时间不能领取奖励
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					-1);
			ServerHandler.sendData(session, respMap);
			return;
		}else if(ary.getInt(1)==1){//玩家选择8小时
           if(time - nowtime < 2*60*60*1000*huangzuan&& time - nowtime >= 0){//可以领奖
			if(ary.getInt(2)==1){//白
   				junling=junling+3;
   				yin1=(int)(yin1*0.3*800);
   				rlt.put("junling",3 );
   			}else if(ary.getInt(2)==2){//绿
   				junling=junling+4;
   				yin1=(int)(yin1*0.4*800);
   				rlt.put("junling",4 );
   			}else if(ary.getInt(2)==3){//蓝
   				junling=junling+5;
   				rlt.put("junling",5 );
   				yin1=(int)(yin1*0.5*800);
   			}else if(ary.getInt(2)==4){//红
   				junling=junling+7;
   				rlt.put("junling",7 );
   				yin1=(int)(yin1*0.7*800);
   			}else if(ary.getInt(2)==5){//金
   				junling=junling+10;
   				rlt.put("junling",10 );
   				yin1=(int)(yin1*800);
   			}
   			this.getGameRoleService().upRoleYin(roleid, yin1+yin);
   			this.getGameRoleService().addRolejunling(roleid, junling);
   			
   			param.clear();
   			ary.set(0, 0);
   			ary.set(1, 0);
   			ary.set(2, 0);
   			ary.set(3, 0);
   			ary.set(4, 0);
   			param.put("id", roleid);
   			param.put("openmountain", ary.toString());
   			this.getGameRoleService().updateRoleVip(param);
   			param.clear();
   			param.put("nowtime", 0);
   			param.put("id", roleid);
   			this.getGameRoleService().updateRolenowtime(param);
   		 rlt.put("yin",yin1);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
			ServerHandler.sendData(session, respMap);
           }else{//已经领取过了
        		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
    					-2);
    			ServerHandler.sendData(session, respMap);
           }
			
		}else if(ary.getInt(1)==2){//玩家选择12小时
			
			if (time - nowtime < 3*60*60*1000*huangzuan&& time - nowtime >= 0){
			if(ary.getInt(3)==1){//白
					junling=junling+4;
					rlt.put("junling",4 );
					yin1=(int)(yin1*0.4*1200);
				}else if(ary.getInt(3)==2){//绿
					junling=junling+5;
					rlt.put("junling",5 );
					yin1=(int)(yin1*0.5*1200);
				}else if(ary.getInt(3)==3){//蓝
					junling=junling+7;
					rlt.put("junling",7 );
					yin1=(int)(yin1*0.7*1200);
				}else if(ary.getInt(3)==4){//红
					junling=junling+10;
					rlt.put("junling",10 );
					yin1=(int)(yin1*1200);
				}else if(ary.getInt(3)==5){//金
					junling=junling+14;
					rlt.put("junling",14 );
					yin1=(int)(yin1*1.4*1200);
				}
				this.getGameRoleService().upRoleYin(roleid, yin1+yin);
				this.getGameRoleService().addRolejunling(roleid, junling);
				
				param.clear();
				ary.set(0, 0);
				ary.set(1, 0);
				ary.set(2, 0);
				ary.set(3, 0);
				ary.set(4, 0);
				param.put("id", roleid);
				param.put("openmountain", ary.toString());
				this.getGameRoleService().updateRoleVip(param);
				param.clear();
				param.put("nowtime", 0);
				param.put("id", roleid);
				this.getGameRoleService().updateRolenowtime(param);
				 rlt.put("yin",yin1);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
					ServerHandler.sendData(session, respMap);
			}else{
				//已经领取过了
        		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
    					-2);
    			ServerHandler.sendData(session, respMap);
			}
			
		}else if(ary.getInt(1)==3){//玩家选择24小时
			
			if (time - nowtime < 6*60*60*1000*huangzuan&& time - nowtime >= 0){
			if(ary.getInt(4)==1){//白
					junling=junling+6;
					rlt.put("junling",6);
					yin1=(int)(yin1*0.6*2400);
				}else if(ary.getInt(4)==2){//绿
					junling=junling+8;
					rlt.put("junling",8 );
					yin1=(int)(yin1*0.8*2400);
				}else if(ary.getInt(4)==3){//蓝
					junling=junling+10;
					rlt.put("junling",10 );
					yin1=(int)(yin1*2400);
				}else if(ary.getInt(4)==4){//红
					junling=junling+15;
					rlt.put("junling",15);
					yin1=(int)(yin1*1.5*2400);
				}else if(ary.getInt(4)==5){//金
					junling=junling+20;
					rlt.put("junling",20);
					yin1=(int)(yin1*2*2400);
				}
				this.getGameRoleService().upRoleYin(roleid, yin1+yin);
				this.getGameRoleService().addRolejunling(roleid, junling);
				
				param.clear();
				ary.set(0, 0);
				ary.set(1, 0);
				ary.set(2, 0);
				ary.set(3, 0);
				ary.set(4, 0);
				param.put("id", roleid);
				param.put("openmountain", ary.toString());
				this.getGameRoleService().updateRoleVip(param);
				param.clear();
				param.put("nowtime", 0);
				param.put("id", roleid);
				this.getGameRoleService().updateRolenowtime(param);
				  rlt.put("yin",yin1);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
					ServerHandler.sendData(session, respMap);
			}else{
				//已经领取过了
        		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
    					-2);
    			ServerHandler.sendData(session, respMap);
			}
			
		}
		
		
		
	}

	private void openmountain() {
		int type=0;
		try {
			if(params.containsKey("type")){
			    type = Integer.valueOf(String.valueOf(params.get("type")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map<String, Object> rlt = new HashMap<String, Object>();
		int roleid = Integer.parseInt(playerId);
		GameRoleDetail role = this.getGameRoleService().findRoleById(roleid);
		String openmountain=role.getOpenmountain();
		JSONArray ary = JSONArray.fromObject(openmountain);
		if(type==1){
			ary.set(0, 0);
			ary.set(2, 0);
			ary.set(3, 0);
			ary.set(4, 0);
		}
		//System.out.println(":：：：：:::::::openmountain:::ary:"+ary);
		Random random = new Random();
		Map<String,Object> param = new HashMap<String,Object>();
		/***
		 * ary.getInt(0)==1取原来的数据(!=1随机刷新奖励给玩家)
		 * ary.getInt(1)玩家选择的是哪个时间的下山掠夺（1：8小时   2：12小时  3：24小时）
		 * ary.getInt(2)  8小时的随机奖励
		 * ary.getInt(3)  12小时的随机奖励
		 * ary.getInt(4)  24小时的随机奖励
		 * *//****/
		
		if(ary.getInt(0)==1){//取原来的数据
			JSONArray pinz=new JSONArray();
			pinz.add(ary.getInt(2));
			pinz.add(ary.getInt(3));
			pinz.add(ary.getInt(4));
			rlt.put("pinzhi", pinz);
			//System.out.println("原来数据的品质：：："+pinz);
			
		}else{
			JSONArray pinz=new JSONArray();
			ary.set(0, 1);
			int k=2;
			for(int i=2;i<500;i++){
				if(random.nextInt(100)<30){//1 白色奖励
					pinz.add(1);
					ary.set(k, 1);
					k++;
				}else if(random.nextInt(100)>=30&&random.nextInt(100)<55){
					//2绿色奖励
					pinz.add(2);
					ary.set(k,2);
					k++;
				}else if(random.nextInt(100)>=55&&random.nextInt(100)<75){//3 蓝色奖励
					pinz.add(3);
					ary.set(k, 3);
					k++;
				}else if(random.nextInt(100)>=75&&random.nextInt(100)<90){//4 红色奖励
					pinz.add(4);
					ary.set(k,4);
					k++;
				}else if(random.nextInt(100)>=90){
					pinz.add(5);
					ary.set(k,5);
					k++;
				}
				if(pinz.size()==3){
					break;
				}
			}
			rlt.put("pinzhi", pinz);
			//System.out.println(k+"K心随机数据的品质：：："+pinz);
			param.clear();
			param.put("id", roleid);
			param.put("openmountain", ary.toString());
			this.getGameRoleService().updateRoleVip(param);
			
			
		}
		if(type==1){
			//System.out.println("type=1::::::::::ary::::"+ary);
			rlt.put("choise",0);
		}else{
			rlt.put("choise", ary.getInt(1));//玩家选择的哪个时间段掠夺
		}
		
		
		/****/
		
		int huangzuan = 0;//判断黄钻
		JsonSerializer json = new JsonSerializer();
		
		String Huangzuaninfo = role.getHuangzuaninfo();
		if("null".equals(String.valueOf(Huangzuaninfo))){
			
		}else{
			List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
			.deserialize(Huangzuaninfo);
			int ret = Integer.parseInt(String.valueOf(roleinfo.get(0).get("ret")));
			if(ret==0){
				huangzuan = Integer.parseInt(String.valueOf(roleinfo.get(0).get("is_yellow_vip")));
			}
			roleinfo=null;
		}
		if(huangzuan==1){
			huangzuan=2;//黄钻用户享受双倍领取奖励时间
		}else{
			huangzuan=1;
		}
		//System.out.println("黄钻信息：：：1不是黄钻2是黄钻：：："+huangzuan);
		long nowtime = role.getNowtime();
		
		if(ary.getInt(1)==0){//玩家没有选择下山掠夺
			 rlt.put("loot", 0);
			 rlt.put("lootTime",0);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
			ServerHandler.sendData(session, respMap);
			rlt = null;
		}else if(ary.getInt(1)==1){//玩家选择8小时下山掠夺
			if (nowtime == 0) {// 默认状态
				long time = new Date().getTime();
				nowtime = time + 8*60*60*1000;
				Map<String, Object> pa = new HashMap<String, Object>();
				pa.put("nowtime", nowtime);
				pa.put("id", roleid);
				this.getGameRoleService().updateRolenowtime(pa);
				 rlt.put("loot", 0);
				 rlt.put("lootTime", 8*60*60);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
				pa=null;
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
					 rlt.put("loot", 0);
					rlt.put("lootTime", m);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
					ServerHandler.sendData(session, respMap);
				}
				else if (time - nowtime < 2*60*60*1000*huangzuan&& time - nowtime >= 0) {// 可以领取状态
						
				long k = 2*60*60*1000*huangzuan-(time-nowtime);
					long p;
					if (n % 1000 == 0) {
						p = k/ 1000;
					} else {
						p = k/ 1000 + 1;
					}
					//long d=20-p;
			
	                rlt.put("loot", p);
	                rlt.put("lootTime", 0);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
					ServerHandler.sendData(session, respMap);

				}
				else if (time - nowtime > 2*60*60*1000*huangzuan) {// 超过领取时间状态
				if(type==1){
					//System.out.println(":1::::::::::::::::::::::");
					rlt.put("lootTime",0);
				    rlt.put("loot", 0);
				}else{
					//System.out.println(":2::::::::::::::::::::::");
					rlt.put("lootTime", -1);
				    rlt.put("loot", 0);
				}
					
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
					ServerHandler.sendData(session, respMap);
					// 更新数据库
					if(type==1){
						param.clear();
						ary.set(0, 0);
						ary.set(1, 0);
						ary.set(2, 0);
						ary.set(3, 0);
						ary.set(4, 0);
						param.put("id", roleid);
						param.put("openmountain", ary.toString());
						this.getGameRoleService().updateRoleVip(param);
					}
					
//					nowtime = 0;
//					Map<String, Object> pa = new HashMap<String, Object>();
//					pa.put("nowtime", nowtime);
//					pa.put("id", roleid);
//					this.getGameRoleService().updateRolenowtime(pa);
				}
			}
			rlt=null;	
		}else if(ary.getInt(1)==2){//玩家选择的12小时下山掠夺
			if (nowtime == 0) {// 默认状态
				long time = new Date().getTime();
				nowtime = time + 12*60*60*1000;
				Map<String, Object> pa = new HashMap<String, Object>();
				pa.put("nowtime", nowtime);
				pa.put("id", roleid);
				this.getGameRoleService().updateRolenowtime(pa);
				 rlt.put("loot", 0);
				 rlt.put("lootTime", 12*60*60);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
				pa=null;
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
					 rlt.put("loot", 0);
					rlt.put("lootTime", m);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
					ServerHandler.sendData(session, respMap);
				}
				else if (time - nowtime < 3*60*60*1000*huangzuan&& time - nowtime >= 0) {// 可以领取状态
						
				long k = 3*60*60*1000*huangzuan-(time-nowtime);
					long p;
					if (n % 1000 == 0) {
						p = k/ 1000;
					} else {
						p = k/ 1000 + 1;
					}
					//long d=20-p;
			
	                rlt.put("loot", p);
	                rlt.put("lootTime", 0);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
					ServerHandler.sendData(session, respMap);

				}
				else if (time - nowtime > 3*60*60*1000*huangzuan) {// 超过领取时间状态
					if(type==1){
						//System.out.println(":11::::::::::::::::::::::");
						rlt.put("lootTime",0);
					    rlt.put("loot", 0);
					}else{
						rlt.put("lootTime", -1);
					    rlt.put("loot", 0);
					    //System.out.println(":22::::::::::::::::::::::");
					}
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
					ServerHandler.sendData(session, respMap);
					// 更新数据库
					if(type==1){
						param.clear();
						ary.set(0, 0);
						ary.set(1, 0);
						ary.set(2, 0);
						ary.set(3, 0);
						ary.set(4, 0);
						param.put("id", roleid);
						param.put("openmountain", ary.toString());
						this.getGameRoleService().updateRoleVip(param);
					}
					
//					nowtime = 0;
//					Map<String, Object> pa = new HashMap<String, Object>();
//					pa.put("nowtime", nowtime);
//					pa.put("id", roleid);
//					this.getGameRoleService().updateRolenowtime(pa);
				}
			}
			rlt=null;	
		}else if(ary.getInt(1)==3){//玩家选择24小时下山掠夺
			if (nowtime == 0) {// 默认状态
				long time = new Date().getTime();
				nowtime = time + 24*60*60*1000;
				Map<String, Object> pa = new HashMap<String, Object>();
				pa.put("nowtime", nowtime);
				pa.put("id", roleid);
				this.getGameRoleService().updateRolenowtime(pa);
				 rlt.put("loot", 0);
				 rlt.put("lootTime", 24*60*60);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
				pa=null;
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
					 rlt.put("loot", 0);
					rlt.put("lootTime", m);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
					ServerHandler.sendData(session, respMap);
				} 
				else if (time - nowtime < 6*60*60*1000*huangzuan&& time - nowtime >= 0) {// 可以领取状态
			    long k = 6*60*60*1000*huangzuan-(time-nowtime);
				long p;
					if (n % 1000 == 0) {
						p = k/ 1000;
					} else {
						p = k/ 1000 + 1;
					}
					//long d=20-p;
			
	                rlt.put("loot", p);
	                rlt.put("lootTime", 0);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
					ServerHandler.sendData(session, respMap);

				} 
				else if (time - nowtime >6*60*60*1000*huangzuan) {// 超过领取时间状态
				if(type==1){
						//System.out.println(":111::::::::::::::::::::::");
						rlt.put("lootTime",0);
					    rlt.put("loot", 0);
					}else{
						rlt.put("lootTime", -1);
					    rlt.put("loot", 0);
					   // System.out.println(":222::::::::::::::::::::::");
					}
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
					ServerHandler.sendData(session, respMap);
					// 更新数据库
					if(type==1){
						param.clear();
						ary.set(0, 0);
						ary.set(1, 0);
						ary.set(2, 0);
						ary.set(3, 0);
						ary.set(4, 0);
						param.put("id", roleid);
						param.put("openmountain", ary.toString());
						this.getGameRoleService().updateRoleVip(param);
					}
					
//					nowtime = 0;
//					Map<String, Object> pa = new HashMap<String, Object>();
//					pa.put("nowtime", nowtime);
//					pa.put("id", roleid);
//					this.getGameRoleService().updateRolenowtime(pa);
				}
			}
			rlt=null;	
		}
		/*****/
		
		
//		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
//				GameConstants.GAME_API_SUCCESS);
//		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
//				rlt);
//		ServerHandler.sendData(session, respMap);
//		rlt = null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	private void totemcompound() {//2图腾的合�? 1装备此图�?   3卸下装备
		if(params.containsKey("type")&&params.containsKey("totemid")&&params.containsKey("num")){
			int roleid = Integer.parseInt(playerId);
			int flag = Integer.valueOf(String.valueOf(params.get("type")));
			int totemid = Integer.valueOf(String.valueOf(params.get("totemid")));
			Map<String,Object> param = new HashMap<String,Object>();
			if(flag==2){//合成的�?�?
				int jic = Integer.valueOf(String.valueOf(params.get("num")));//合成几次
				//System.out.println("type===="+flag+"totemid======="+totemid+"num======="+jic);
				
				if(jic<1){
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							-3);
					ServerHandler.sendData(session, respMap);
					return;
				}  
				param.clear();
				param.put("roleid", roleid);
				param.put("totemid", totemid);
				List<RoletotemDetail> to=this.getRoletotemService().getRoletotem(param);
				int num=0;
				if(to.get(0).getEquiptotem()==1){
					num=to.get(0).getNum()-1;//图腾数量	
				}else{
					num=to.get(0).getNum();//图腾数量	
				}
				//int num=to.get(0).getNum();//图腾数量
				int type=to.get(0).getType();
				int level=to.get(0).getLevel();
				GametotemDetail gtotem = new GametotemDetail();
				if(num<jic*3){
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							-3);
					ServerHandler.sendData(session, respMap);
					return;
				}else{
					if(num>2&&level<12){//装备�?，插入合成后的装�?
					    param.clear();
						param.put("num", jic*3);
						param.put("roleid", roleid);
						param.put("totemid", totemid);
						this.getRoletotemService().sbRoletotemNum(param);
						param.clear();
						param.put("roleid", roleid);
						param.put("type", type);
						param.put("level", level+1);//查询合成后的装备
						List<RoletotemDetail> to2=this.getRoletotemService().getRoletotem(param);
						if(to2.isEmpty()){//插入
							param.clear();
							param.put("type", type);
							param.put("level", level+1);
							List<GametotemDetail> gt=this.getGametotemService().getGametotembyparam(param);
							gtotem = gt.get(0);
							RoletotemDetail mo = new RoletotemDetail();
							mo.setRoleid(roleid);
							mo.setType(type);
							mo.setLevel(level+1);
							mo.setNum(jic);
							mo.setQuality(gt.get(0).getQuality());
							mo.setTotemid(gt.get(0).getId());
							this.getRoletotemService().insertRoletotem(mo);
							mo=null;
						}else{//更新数量�?
							   param.clear();
							   param.put("roleid", roleid);
							   param.put("type", type);
							   param.put("level", level+1);
							   List<GametotemDetail> gt=this.getGametotemService().getGametotembyparam(param);
							   gtotem = gt.get(0);
							   param.put("num",jic);
							   this.getRoletotemService().addRoletotemNum(param);
						}
					
				}else{//不能合成
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							-4);
					ServerHandler.sendData(session, respMap);
					return;
				}	
			}
				if((level + 1) > 4){
					// 系统公告//发送广播
//					int quality = Integer.valueOf(String.valueOf(gtotem.getQuality()));
					GameRoleDetail role = this.getGameRoleService().findRoleById(roleid);
//					String message= "玩家   <font color=\"#FF0000\">" + role.getName() + "</font>" + "<font color=\"#FFD700\">VIP"+role.getVip() + "</font>" + "  成功合成了    "+ gtotem.getLevel() +"级"+ "<font color=\"#CC3366\">"+gtotem.getName() +"</font>"+ "  图腾";
//					//GameConstants.log.warn("MathHandler.totemcompound:" + message);
//					this.getsystemHandler().addMessage(message);
					UtilHandler util = new UtilHandler();
					String name2 = role.getName();
					int vip2 = role.getVip();
					String where = "图腾合成";
					int pinzhi = gtotem.getType();
					if(pinzhi>6){
						pinzhi = 6;
					}
					String goodsName = gtotem.getLevel()+"级"+gtotem.getName()+"图腾";
					util.sendGetMessage(name2, vip2, where, pinzhi, goodsName,"match_getTuTeng");
				}
				
				
				Map<String,Object> rlt = new HashMap<String,Object>();
				rlt.put("type",flag);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
						rlt);
				ServerHandler.sendData(session, respMap);
				rlt = null;
				
			}else if(flag==1){//装备图腾的�?�?
				GameRoleDetail gamerole = this.getGameRoleService()
				.findRoleById3(roleid);
				int type=this.getGametotemService().getGametotembyid(totemid).get(0).getType();
				String totem=gamerole.getTotem();
				JsonSerializer json=new JsonSerializer();
				List roleinfo = (List) json
				.deserialize(totem);
			//	System.out.println("装备的图腾ids========"+roleinfo);
				if(roleinfo.isEmpty()){//第一次装备图�?
//					  JSONArray li = new JSONArray();
//					  li.add(totemid);
//					  param.clear();
//					  param.put("totem", li.toString());
//					  param.put("id", roleid);
//					  this.getGameRoleService().updateTotem(param);
					  param.clear();
						//param.put("num", 1);//背包图腾�?
						param.put("roleid", roleid);
						param.put("totemid", totemid);
						param.put("equiptotem", 1);
						Map<String,Object> rlt = new HashMap<String,Object>();
					   boolean a=this.getRoletotemService().sbRoletotemNum(param);
					   if(a){
						   JSONArray li = new JSONArray();
							  li.add(totemid);
							  param.clear();
							  param.put("totem", li.toString());
							  param.put("id", roleid);
							  this.getGameRoleService().updateTotem(param);  
					   }else{
						   respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									-5);//装备失败
							ServerHandler.sendData(session, respMap);
							return;
					   }
					   rlt.put("type",flag);
					   respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								GameConstants.GAME_API_SUCCESS);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
								rlt);
						ServerHandler.sendData(session, respMap);
						rlt = null;
				}else{
					if(roleinfo.size()<5){

						for(int i=0;i<roleinfo.size();i++){
							int td=Integer.valueOf(String.valueOf(roleinfo.get(i)));
							if(td==totemid){//已经装备了此类型的战�?
								respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
										-1);
								ServerHandler.sendData(session, respMap);
								return;
								
							}
							int ty=this.getGametotemService().getGametotembyid(td).get(0).getType();
							if(type==ty){
								respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
										-1);
								ServerHandler.sendData(session, respMap);
								return;
								
							}
							
							
						}
//						roleinfo.add(totemid);
//					    param.clear();
//					    param.put("totem",roleinfo.toString());
//					    param.put("id", roleid);
//				        this.getGameRoleService().updateTotem(param);
				        param.clear();
						//param.put("num", 1);//背包图腾�?
						param.put("roleid", roleid);
						param.put("totemid", totemid);
						param.put("equiptotem", 1);
					   boolean a=this.getRoletotemService().sbRoletotemNum(param);
					   if(a){
						   roleinfo.add(totemid);
						    param.clear();
						    param.put("totem",roleinfo.toString());
						    param.put("id", roleid);
					        this.getGameRoleService().updateTotem(param);   
					   }else{
						   respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									-5);//装备失败
							ServerHandler.sendData(session, respMap);
							return;
					   }
						Map<String,Object> rlt = new HashMap<String,Object>();
    					rlt.put("type",flag);
//						rlt.put("equiptotem", roleinfo);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								GameConstants.GAME_API_SUCCESS);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
								rlt);
						ServerHandler.sendData(session, respMap);
						rlt = null;
					
					}else{//装备已满
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-2);
						ServerHandler.sendData(session, respMap);
						return;
					}
				
				}
				
			}
			else if(flag==3){//卸下图腾
		//		System.out.println("卸装�?========");
				GameRoleDetail gamerole = this.getGameRoleService().findRoleById3(roleid);
				String totem=gamerole.getTotem();
				JsonSerializer json=new JsonSerializer();
				List ro = (List) json.deserialize(totem);//装备的所有图�?
				int a=0;
				for(int i=0;i<ro.size();i++){
					 if(totemid==Integer.parseInt(String.valueOf( ro.get(i)))){
						 ro.remove(i);//删除卸下的图�?
						 a=1;
					 }
				}
				 param.clear();
				    param.put("totem",ro.toString());
				    param.put("id", roleid);
			        this.getGameRoleService().updateTotem(param);
			
				param.clear();
				param.put("roleid", roleid);
				param.put("totemid", totemid);
				if(a==0){//数据异常
					 respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-5);//装备失败
						ServerHandler.sendData(session, respMap);
						return;
				}
				List<RoletotemDetail> to=this.getRoletotemService().getRoletotem(param);
//				int num=to.get(0).getNum();//图腾数量
//				int type=to.get(0).getType();
//				int level=to.get(0).getLevel();
				if(!to.isEmpty()){//背包里存在，更新到背包里�?
					   param.clear();
					   param.put("roleid", roleid);
					   param.put("type", to.get(0).getType());
					   param.put("level", to.get(0).getLevel());
					  // param.put("num", 1);
					   param.put("equiptotem",0);
					  boolean b= this.getRoletotemService().addRoletotemNum(param);
	//			System.out.println("更新背包1======="+b);
				}else{//不存在，插入
					List<GametotemDetail> gt=this.getGametotemService().getGametotembyid(totemid);
					RoletotemDetail mo = new RoletotemDetail();
					mo.setRoleid(roleid);
					mo.setType(gt.get(0).getType());
					mo.setLevel(gt.get(0).getLevel());
					//mo.setNum(1);
					mo.setQuality(gt.get(0).getQuality());
					mo.setTotemid(totemid);
					mo.setEquiptotem(0);
					this.getRoletotemService().insertRoletotem(mo);
	//				System.out.println("插入背包1=======");
				}
				Map<String,Object> rlt = new HashMap<String,Object>();
				rlt.put("type",flag);
				   respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
							rlt);
					ServerHandler.sendData(session, respMap);
					rlt = null;
			}	
		}
	}

	private void opentotem() {
		//打开图腾按钮
		int roleid = Integer.parseInt(playerId);
		GameRoleDetail gr=this.getGameRoleService().findRoleById3(roleid);
		// JSONArray li = new JSONArray();//玩家装备的图�?
		 JSONArray li2 = new JSONArray();//
		 //li.add(gr.getTotem());
		 JsonSerializer json = new JsonSerializer();
		List li=(List) json.deserialize(gr.getTotem());
		 Map<String,Object> param = new HashMap<String,Object>();
		 Map<String,Object> map = new HashMap<String,Object>();
		 param.put("roleid", roleid);
		List<RoletotemDetail> rt= this.getRoletotemService().getRoletotem(param);
		if(!rt.isEmpty()){
			
			for(int i=0;i<rt.size();i++){
				int num=0;
				if(rt.get(i).getEquiptotem()==1){
					num=rt.get(i).getNum()-1;
				}else{
					num=rt.get(i).getNum();	
				}
				if(num==0){
					continue;
				}
//				if(rt.get(i).getNum()==0){
//					continue;
//				}
				map.put("totemid", rt.get(i).getTotemid());
				map.put("num",num);
				//map.put("num",rt.get(i).getNum());
				map.put("type",rt.get(i).getType());
				map.put("level",rt.get(i).getLevel());
				li2.add(map);
				map.clear();
			}
			
		}
		Map<String,Object> rlt = new HashMap<String,Object>();
		rlt.put("totem", li2);
		rlt.put("equiptotem", li);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
				rlt);
		ServerHandler.sendData(session, respMap);
		rlt = null;
	//	System.out.println(li+"=�?��的图�?==="+li2+"=====装备的图�?====");
	}
	private void ranklistss(){
	//	System.out.println("走到了ranklistss:3");
		if(params.containsKey("page") && params.containsKey("type")&& Integer.valueOf(String.valueOf(params.get("page")))<11){
	//		System.out.println("得到的数据：page:" + Integer.valueOf(String.valueOf(params.get("page"))) + ",type:" +  Integer.valueOf(String.valueOf(params.get("type"))));
			int page = (Integer.valueOf(String.valueOf(params.get("page"))) -1) * 10;
			int roleId = Integer.parseInt(playerId);
			int type = Integer.valueOf(String.valueOf(params.get("type")));
			Map<String,Object> param = new HashMap<String,Object>();
			Map<String,Object> rlt = new HashMap<String,Object>();
			GameRoleDetail gameRole = this.getGameRoleService().findRoleById(roleId);
			if(gameRole==null){
				return;
			}
			int serverid = Integer.parseInt(gameRole.getServerId());
			//int serverid=1;
			int mapreg = 1;
//			if(mapreg<11){
//				mapreg = 1;
//			}else if(mapreg >10 && mapreg <21){
//				mapreg = 2;
//			}else if(mapreg > 20 && mapreg < 31){
//				mapreg = 3;
//			}else if(mapreg > 30 && mapreg < 41){
//				mapreg = 4;
//			//}else if(mapreg > 40 && mapreg < 51){
//			}else if(mapreg > 40 && mapreg < 61){
//				mapreg = 5;
//			}
			if(type == 0){
	//			System.out.println("走到了ranklistss:3:0");
				param.clear();
				param.put("serverid", serverid);
				param.put("mapreg", mapreg);
				param.put("page", 0);
				param.put("size", 300);
				List<GameJingjiStaticDetail> listsize = this.getGameJingjiStaticService().getGameJingjiByLimit(param);
				param.clear();
				param.put("serverid", serverid);
				param.put("mapreg", mapreg);
				param.put("page", page);
				param.put("size", 10);
				List<GameJingjiStaticDetail> jjlist1 = this.getGameJingjiStaticService().getGameJingjiByLimit(param);
				JSONArray jsont = new JSONArray();
				if(jjlist1.size()!=0){
					for(int i = 0; i < jjlist1.size(); i ++){
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("t", jjlist1.get(i).getIndexes());
						map.put("name", jjlist1.get(i).getName());
						map.put("lev", jjlist1.get(i).getLevel());
						map.put("atk", jjlist1.get(i).getSum());
						map.put("hp", jjlist1.get(i).getZxueliang());
						jsont.add(map);
					}
				}
				param.clear();
				param.put("serverid", serverid);
				param.put("roleid", roleId);
				List<GameJingjiStaticDetail> jjlistmy = this.getGameJingjiStaticService().getGameJingjiByServerid(param);
				rlt.put("top", jsont);
				rlt.put("inx", page/10 + 1);
				rlt.put("mytop", jjlistmy.get(0).getIndexes());
				rlt.put("max", listsize.size()/10+1);
	//			System.out.println("jsont:" + jsont);
				if(jsont.size() ==0){
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							-2);
				}else{
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
				}
				
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
				ServerHandler.sendData(session, respMap);
				rlt = null;
				param = null;
				gameRole = null;
				jsont = null;
			}else if(type == 1){
	//			System.out.println("走到了ranklistss:3:1");
				param.clear();
				param.put("serverid", serverid);
				param.put("roleid", roleId);
				List<GameJingjiStaticDetail> jjlistmy = this.getGameJingjiStaticService().getGameJingjiByServerid(param);
				int inx = 0;
				if(jjlistmy.size()!=0){
					inx = jjlistmy.get(0).getIndexes(); 
				}
				int p = inx/10;
				page = p*10;
				param.clear();
				param.put("serverid", serverid);
				param.put("mapreg", mapreg);
				param.put("page", 0);
				param.put("size", 300);
				List<GameJingjiStaticDetail> listsize = this.getGameJingjiStaticService().getGameJingjiByLimit(param);
				param.clear();
				param.put("serverid", serverid);
				param.put("mapreg", mapreg);
				param.put("page", page);
				param.put("size", 10);
				List<GameJingjiStaticDetail> jjlist1 = this.getGameJingjiStaticService().getGameJingjiByLimit(param);
				JSONArray jsont = new JSONArray();
				if(jjlist1.size()!=0){
					for(int i = 0; i < jjlist1.size(); i ++){
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("t", jjlist1.get(i).getIndexes());
						map.put("name", jjlist1.get(i).getName());
						map.put("lev", jjlist1.get(i).getLevel());
						map.put("atk", jjlist1.get(i).getSum());
						map.put("hp", jjlist1.get(i).getZxueliang());
						jsont.add(map);
					}
				}
		//		System.out.println("jsont:" + jsont);
				rlt.put("top", jsont);
				rlt.put("inx", p + 1);
				rlt.put("mytop", jjlistmy.get(0).getIndexes());
				rlt.put("max", listsize.size()/10+1);
				if(jsont.size() ==0){
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							-2);
				}else{
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
				}
				
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
				ServerHandler.sendData(session, respMap);
				rlt = null;
				param = null;
				gameRole = null;
				jsont = null;
				jjlist1 = null;
				
			}
			
		}else{
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					-1);
			ServerHandler.sendData(session, respMap);
		}
		
	}
	
	private void ranklistreg(){
		if(params.containsKey("t") && params.containsKey("page") && Integer.valueOf(String.valueOf(params.get("page")))<11){
			int mapreg = Integer.valueOf(String.valueOf(params.get("t"))) + 1;
			int pagea = Integer.valueOf(String.valueOf(params.get("page")));
			int page = ((pagea > 0 ? pagea : 1) -1) * 10;
			int type = 0;
			int roleId = Integer.parseInt(playerId);
			Map<String,Object> param = new HashMap<String,Object>();
			Map<String,Object> rlt = new HashMap<String,Object>();
			GameRoleDetail gameRole = this.getGameRoleService().findRoleById(roleId);
			if(gameRole==null){
				return;
			}
			int serverid = Integer.parseInt(gameRole.getServerId());
			//int serverid=1;
			if(type ==0){
				param.clear();
				param.put("serverid", serverid);
				param.put("mapreg", mapreg);
				param.put("page", 0);
				param.put("size", 300);
				List<GameJingjiFinalDetail> listsize = this.getGameJingjiFinalService().getGameJingjiByLimit(param);
				param.clear();
				param.put("serverid", serverid);
				param.put("mapreg", mapreg);
				param.put("page", page);
				param.put("size", 10);
				List<GameJingjiFinalDetail> jjlist1 = this.getGameJingjiFinalService().getGameJingjiByLimit(param);
				JSONArray jsont = new JSONArray();
				if(!jjlist1.isEmpty()){
					for(int i = 0; i < jjlist1.size(); i ++){
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("t", jjlist1.get(i).getIndexes());
						map.put("name", jjlist1.get(i).getName());
						map.put("lev", jjlist1.get(i).getLevel());
						jsont.add(map);
					}
				}
				int pp = listsize.size()/10 + 1;
				if(pp > 10){
					pp = 10;
				}
				rlt.put("top", jsont);
				rlt.put("inx", page/10 + 1);
				rlt.put("max", pp);
				if(jsont.size() ==0){
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							-2);
				}else{
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
				}
				
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
				ServerHandler.sendData(session, respMap);
				rlt = null;
				param = null;
				gameRole = null;
				jsont = null;
				jjlist1 = null;
			}else if(type==1){
				param.clear();
				param.put("serverid", serverid);
				param.put("mapreg", mapreg);
				param.put("page", 0);
				param.put("size", 300);
				List<GameJingjiFinalDetail> listsize = this.getGameJingjiFinalService().getGameJingjiByLimit(param);
				param.clear();
				param.put("serverid", serverid);
				param.put("roleid", roleId);
				List<GameJingjiFinalDetail> jjlistmy = this.getGameJingjiFinalService().getGameJingjiByServerid(param);
				int inx = 0;
				if(jjlistmy.size()!=0){
					inx = jjlistmy.get(0).getIndexes(); 
				}
				int p = inx/10;
				page = p*10;
				param.clear();
				param.put("serverid", serverid);
				param.put("mapreg", mapreg);
				param.put("page", page);
				param.put("size", 10);
				List<GameJingjiStaticDetail> jjlist1 = this.getGameJingjiStaticService().getGameJingjiByLimit(param);
				JSONArray jsont = new JSONArray();
				if(jjlist1.size()!=0){
					for(int i = 0; i < jjlist1.size(); i ++){
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("t", jjlist1.get(i).getIndexes());
						map.put("name", jjlist1.get(i).getName());
						map.put("lev", jjlist1.get(i).getLevel());
						jsont.add(map);
					}
				}
				int pp = listsize.size()/10 + 1;
				if(pp > 10){
					pp = 10;
				}
				rlt.put("top", jsont);
				rlt.put("inx", p + 1);
				rlt.put("max", pp);
				if(jsont.size() ==0){
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							-2);
				}else{
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
				}
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
		//		System.out.println("rolt:" + rlt.toString());
				ServerHandler.sendData(session, respMap);
				rlt = null;
				param = null;
				gameRole = null;
				jsont = null;
				jjlist1 = null;
				
			}
			
		}else{
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					-1);
			ServerHandler.sendData(session, respMap);
		}
		
	}
	
	private void openranklist(){
		int roleId = Integer.parseInt(playerId);
		Map<String,Object> param = new HashMap<String,Object>();
		Map<String,Object> rlt = new HashMap<String,Object>();
		GameRoleDetail gameRole = this.getGameRoleService().findRoleById(roleId);
		if(gameRole==null){
			return;
		}
		int serverid = Integer.parseInt(gameRole.getServerId());
		//int serverid=1;
		param.clear();
		param.put("serverid", serverid);
		param.put("mapreg", 1);
		param.put("page", 0);
		param.put("size", 300);
		List<GameJingjiFinalDetail> listsize = this.getGameJingjiFinalService().getGameJingjiByLimit(param);
		param.clear();
		param.put("serverid", serverid);
		param.put("mapreg", 1);
		param.put("page", 0);
		param.put("size", 10);
		List<GameJingjiFinalDetail> jjlist1 = this.getGameJingjiFinalService().getGameJingjiByLimit(param);
		param.clear();
		param.put("serverid", serverid);
		param.put("mapreg", 2);
		param.put("page", 0);
		param.put("size", 10);
		List<GameJingjiFinalDetail> jjlist2 = this.getGameJingjiFinalService().getGameJingjiByLimit(param);
		param.clear();
		param.put("serverid", serverid);
		param.put("mapreg", 3);
		param.put("page", 0);
		param.put("size", 10);
		List<GameJingjiFinalDetail> jjlist3 = this.getGameJingjiFinalService().getGameJingjiByLimit(param);
		param.clear();
		param.put("serverid", serverid);
		param.put("mapreg", 4);
		param.put("page", 0);
		param.put("size", 10);
		List<GameJingjiFinalDetail> jjlist4 = this.getGameJingjiFinalService().getGameJingjiByLimit(param);
		param.clear();
		param.put("serverid", serverid);
		param.put("mapreg", 5);
		param.put("page", 0);
		param.put("size", 10);
		List<GameJingjiFinalDetail> jjlist5 = this.getGameJingjiFinalService().getGameJingjiByLimit(param);
		param.clear();
		param.put("serverid", serverid);
		param.put("roleid", roleId);
		List<GameJingjiFinalDetail> jjlistmy = this.getGameJingjiFinalService().getGameJingjiByServerid(param);
		JSONArray json1 = new JSONArray();
		JSONArray json2 = new JSONArray();
		JSONArray json3 = new JSONArray();
		JSONArray json4 = new JSONArray();
		JSONArray json5 = new JSONArray();
		if(jjlist1.size()!=0){
			for(int i = 0; i < jjlist1.size(); i ++){
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("name", jjlist1.get(i).getName());
				map.put("lev", jjlist1.get(i).getLevel());
				json1.add(map);
				if(i >= 2){
					break;
				}
			}
		}
		if(jjlist2.size()!=0){
			for(int i = 0; i < jjlist2.size(); i ++){
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("name", jjlist2.get(i).getName());
				map.put("lev", jjlist2.get(i).getLevel());
				json2.add(map);
				if(i >= 2){
					break;
				}
			}
		}
		if(jjlist3.size()!=0){
			for(int i = 0; i < jjlist3.size(); i ++){
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("name", jjlist3.get(i).getName());
				map.put("lev", jjlist3.get(i).getLevel());
				json3.add(map);
				if(i >= 2){
					break;
				}
			}
		}
		if(jjlist4.size()!=0){
			for(int i = 0; i < jjlist4.size(); i ++){
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("name", jjlist4.get(i).getName());
				map.put("lev", jjlist4.get(i).getLevel());
				json4.add(map);
				if(i >= 2){
					break;
				}
			}
		}
		if(jjlist5.size()!=0){
			for(int i = 0; i < jjlist5.size(); i ++){
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("name", jjlist5.get(i).getName());
				map.put("lev", jjlist5.get(i).getLevel());
				json5.add(map);
				if(i >= 2){
					break;
				}
			}
		}
		JSONArray jsonz = new JSONArray();
		jsonz.add(json1);
		jsonz.add(json2);
		jsonz.add(json3);
		jsonz.add(json4);
		jsonz.add(json5);
		JSONArray jsont = new JSONArray();
		if(jjlist1.size()!=0){
			for(int i = 0; i < jjlist1.size(); i ++){
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("t", jjlist1.get(i).getIndexes());
				map.put("name", jjlist1.get(i).getName());
				map.put("lev", jjlist1.get(i).getLevel());
				jsont.add(map);
			}
		}
		int pp = listsize.size()/10+1;
		if(pp>10){
			pp=10;
		}
		rlt.put("rank", jsonz);
		rlt.put("top", jsont);
		rlt.put("max", pp);
		if(jjlistmy.size()!=0){
			rlt.put("mytop", jjlistmy.get(0).getIndexes());
		}
		if(false){
		//if(jsonz.size()==0 || jjlistmy.size()==0){
			//if(jsont.size()==0 || jsonz.size()==0 || jjlistmy.size()==0){
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
		}else{
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
		}
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
	//	System.out.println("rolt:" + rlt.toString());
		ServerHandler.sendData(session, respMap);
		rlt = null;
		param = null;
		gameRole = null;
		jjlist1 = null;
		jjlist2 = null;
		jjlist3 = null;
		jjlist4 = null;
		jjlistmy = null;
		json1 = null;
		json2 = null;
		json3 = null;
		json4 = null;
		jsonz = null;
		jsont = null;
	}

	 private void openchange() {
		Map<String, Object> rlt = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		int roleid = Integer.parseInt(playerId);
		param.put("roleid", roleid);
		String mids = this.getRoleChallengeService().findRoleChallengeById(
				param).get(0).getMilitaryid();
	//	System.out.println(JSONArray.fromObject(mids));
		rlt.put("mids", JSONArray.fromObject(mids));
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);
		rlt=null;
		param=null;
	}

	private void changefight() {
		if (params.containsKey("mids")) {
			String mids = String.valueOf(params.get("mids"));
			int roleid = Integer.parseInt(playerId);
			Map<String, Object> rlt = new HashMap<String, Object>();
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("roleid", roleid);
			param.put("militaryid", mids);
			this.getRoleChallengeService().updateRoleChallenge(param);
			param.clear();
			param.put("roleid", roleid);
			List<RoleChallengeDetail> rolechallenge = this
					.getRoleChallengeService().findRoleChallengeById(param);
			JsonSerializer json = new JsonSerializer();
			List militaryids =  (List) json
					.deserialize(rolechallenge.get(0).getMilitaryid());
			//更新标记出战武将
			param.clear();
			param.put("roleId", roleid);
			param.put("challenge", 0);
			this.getRoleMilitaryService().updateRoleMilitary(param);
			for(int i=0;i<militaryids.size();i++){
				int mid = Integer.parseInt(String.valueOf(militaryids.get(i)));
				param.clear();
				param.put("roleId", roleid);
				param.put("challenge", 1);
				param.put("id", mid);
				this.getRoleMilitaryService().updateRoleMilitary(param);
			}
			rlt.put("mids", militaryids);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
			rlt=null;
			param=null;
			rolechallenge=null;
			militaryids=null;
		}
	 }

	private void fight() {


		 if(params.containsKey("t")){
			 int roleId = Integer.parseInt(playerId);
			 int indexes2 = Integer.parseInt(String.valueOf(params.get("t")));
			 Map<String,Object> param = new HashMap<String,Object>();
			 Map<String,Object> rlt = new HashMap<String,Object>();
			 Calendar calendar = Calendar.getInstance();
			 int hour = calendar.get(Calendar.HOUR_OF_DAY);
			 int minute = calendar.get(Calendar.MINUTE);
			 if(hour==21){
				 if(minute>=0 && minute<=30){
					 respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
					 ServerHandler.sendData(session, respMap);
					 return;
				 }
			 }
			 GameRoleDetail gameRole = this.getGameRoleService().findRoleById(roleId);
				if(gameRole==null){
					return;
				}
				
				long time = gameRole.getJjtime() - System.currentTimeMillis();
				if(time>0){
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);
					ServerHandler.sendData(session, respMap);
					return;
				}
				
				if(gameRole.getJingji()<=0){//竞技令不足
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -4);
					ServerHandler.sendData(session, respMap);
					return;
				}
				
				int serverid = Integer.parseInt(gameRole.getServerId());
				//int serverid=1;
				param.clear();
				param.put("serverid", serverid);
				param.put("roleid", roleId);
				List<GameJingjiStaticDetail> jingji = this.getGameJingjiStaticService().getGameJingjiByServerid(param);
				int mapid = gameRole.getMapid();
				
				if(jingji.isEmpty()){
					return;
				}
				int mapreg = jingji.get(0).getMapreg();
				int indexes = jingji.get(0).getIndexes();
				//挑战魔王排行
				List arys = new ArrayList();
				
				if(indexes<=10){
					for(int i=1;i<11;i++){
						arys.add(i);
					}
				}else if(indexes>10 && indexes<=100){//间隔1
					int n = indexes;
					for(int i=0;i<10;i++){
						arys.add(--n);
					}
				}else if(indexes>100 && indexes<=150){//间隔2
					if(indexes<120){
						int num = (indexes-100)/2;
						for(int j=0;j<num;j++){
							arys.add(indexes-2*(j+1));
						}
						int p = 100 -1 + indexes%2;
						for(int t=0;t<(10-num);t++){
							arys.add(p);
							p--;
						}
					}else{
						for(int i=0;i<10;i++){
							arys.add((indexes-2*(1+i)));
						}
					}
				}else if(indexes>150 && indexes<=500){//间隔5
					if(indexes<200){
						int num = (indexes-150)/5;
						for(int i=0;i<num;i++){
							arys.add((indexes-5*(1+i)));
						}
						int p = 150 - 2 + indexes%2;
						for(int t=0;t<(10-num);t++){
							arys.add(p);
							p -= 2;
						}
					}else{
						for(int i=0;i<10;i++){
							arys.add((indexes-5*(1+i)));
						}
					}
				}else if(indexes>500){//间隔10
					if(indexes<600){
						int num = (indexes-500)/10;
						for(int i=0;i<num;i++){
							arys.add((indexes-10*(1+i)));
						}
						int p = 500 - 5 + indexes%5;
						for(int t=0;t<(10-num);t++){
							arys.add(p);
							p -= 5;
						}
					}else{
						for(int i=0;i<10;i++){
							arys.add((indexes-10*(1+i)));
						}
					}
				}
				if(arys.contains(indexes2)){
					param.clear();
					param.put("serverid", serverid);
					param.put("mapreg", mapreg);
					param.put("indexes", indexes2);
					List<GameJingjiStaticDetail> jingji2 = this.getGameJingjiStaticService().getGameJingjiByIndexes(param);
					if(jingji2.isEmpty()){//对手不存在
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -5);
						ServerHandler.sendData(session, respMap);
						return;
					}
					if(jingji2.get(0).getRoleid()==roleId){//不能和自己战斗
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -6);
						ServerHandler.sendData(session, respMap);
						return;
					}
					int id = jingji2.get(0).getRoleid();//对手id
					//开始竞技战斗
					GameRoleDetail gameRole2 = this.getGameRoleService().findRoleById(id);
					JsonSerializer json1 = new JsonSerializer();
					String totem=gameRole.getTotem();
					List litotem=(List) json1.deserialize(totem);
					String totem2=gameRole2.getTotem();
					List litotem2=(List) json1.deserialize(totem2);
					if(gameRole2==null){
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -5);
						ServerHandler.sendData(session, respMap);
						return;
					}
					rlt.put("totem",litotem2);
					//减少竞技令
					param.clear();
					param.put("id", roleId);
					param.put("jingji", gameRole.getJingji()-1);
					param.put("jjtime", System.currentTimeMillis()+600000);
					this.getGameRoleService().updateRoleVip(param);
					
					JSONArray list1 = new JSONArray();//本家
					JSONArray list2 = new JSONArray();//对手mids
					JSONArray list3 = new JSONArray();//对手总攻击
					JSONArray list = new JSONArray();
					param.clear();
					param.put("roleid", roleId);
					List<RoleChallengeDetail> rolechallenge = this
							.getRoleChallengeService().findRoleChallengeById(param);
					if (!rolechallenge.isEmpty()) {//获得自己
						//判断出战武将是否为空
						JsonSerializer json = new JsonSerializer();
						List mids0 = (List) json.deserialize(rolechallenge.get(0)
					.getMilitaryid());
						if(mids0.isEmpty()){//随机选取一定武将，放入rolechallenge
							param.clear();
							param.put("roleId", roleId);
							List<RoleMilitaryDetail> roe = this.getRoleMilitaryService().getRoleMilitaryByparam(param);
							if(roe.isEmpty()){
								respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-7);
								ServerHandler.sendData(session, respMap);
								return;
							}
		//根据等级出战数量
							List ary = new ArrayList();
							int num=0;//出战武将数
							if(gameRole.getLevel()<=10){
								num = 3;
							}else if(gameRole.getLevel()>10 && gameRole.getLevel()<=15){
								num = 6;
							}else if(gameRole.getLevel()>15){
								num = 9;
							}
							if(roe.size()>=num){//只取6个
								for(int i=0;i<num;i++){
									ary.add(roe.get(i).getId());
								}
							}else{
								for(int i=0;i<roe.size();i++){
									ary.add(roe.get(i).getId());
								}
							}
							this.getMapHandler().militaryDetail(ary,roleId, list1,litotem);
							rlt.put("mid", ary);
							roe=null;
							ary=null;
						}else{
							this.getMapHandler().militaryDetail(mids0,roleId, list1,litotem);// 获得武将列表信息
							rlt.put("mid", mids0);
						}
						List url= new ArrayList();//头像地址
						//获取自己头像
						String Huangzuaninfo = gameRole.getHuangzuaninfo();
						JsonSerializer js = new JsonSerializer();
						List<Map<String, Object>> roleinfo = null;
						if("null".equals(String.valueOf(Huangzuaninfo))){
							url.add("http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
						}else{
							roleinfo = (List<Map<String, Object>>) js.deserialize(Huangzuaninfo);
							url.add(roleinfo.get(0).get("figureurl"));
							roleinfo=null;
						}
						//获得对手的头像信息
						Huangzuaninfo = gameRole2.getHuangzuaninfo();
						if("null".equals(String.valueOf(Huangzuaninfo))){
							url.add("http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
						}else{
							roleinfo = (List<Map<String, Object>>) js.deserialize(Huangzuaninfo);
							url.add(roleinfo.get(0).get("figureurl"));
						}
						roleinfo=null;
						// 获得对手信息
						param.clear();
						param.put("roleid", id);
						List<RoleChallengeDetail> foe = this.getRoleChallengeService().findRoleChallengeById(param);
						Map<String,Object> map = new HashMap<String,Object>();
						if (!foe.isEmpty()) {
							List mids = (List) js.deserialize(foe.get(0).getMilitaryid());
							
							js = null;
							
							if(mids.isEmpty()){//随机选取一定武将，放入rolechallenge
								param.clear();
								param.put("roleId", id);
								List<RoleMilitaryDetail> roe = this.getRoleMilitaryService().getRoleMilitaryByparam(param);
								if(roe.isEmpty()){
									respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-7);
									ServerHandler.sendData(session, respMap);
									return;
								}
		//根据等级出战数量
								List ary = new ArrayList();
								int num=0;//出战武将数
								int level = gameRole2.getLevel();
							
								if(level<=10){
									num = 3;
								}else if(level>10 && level<=15){
									num = 6;
								}else if(level>15){
									num = 9;
								}
								if(roe.size()>=num){//只取6个
									for(int i=0;i<num;i++){
										ary.add(roe.get(i).getId());
									}
								}else{
									for(int i=0;i<roe.size();i++){
										ary.add(roe.get(i).getId());
									}
								}
								this.getMapHandler().militaryDetail(ary,id, list3,litotem2);
								this.getMapHandler().foeMilitary(ary,id, list2,litotem2);
								roe=null;
								ary=null;
							}else{
								this.getMapHandler().militaryDetail(mids,id, list3,litotem2);// 获得武将列表信息
								this.getMapHandler().foeMilitary(mids,id, list2,litotem2);
							}
							map.clear();
							map.put("mids", list2);
							mids=null;
							foe = null;
						} else {// 对手不存在
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-8);
							ServerHandler.sendData(session, respMap);
							return;
						}
						map.put("level", gameRole2.getLevel());
						map.put("name", gameRole2.getName());
						if(jingji2.get(0).getTotals()==0){
							map.put("percent",100);
						}else{
							map.put("percent", (jingji2.get(0).getSuccess())*100/(jingji2.get(0).getTotals()+1));
							
						}
						rlt.put("foe", map);
						// 开始攻击
						if(list1.size()>list3.size()){//最大回合数
							int size1 = list1.size();
							for(int i=0;i<50;i++){
								if(list1.isEmpty() || list3.isEmpty()){
									break;
								}
								this.getMapHandler().faight(list1, list3, list,roleId,id);
							}
						}else{
							int size3 = list3.size();
							for(int i=0;i<50;i++){
								if(list1.isEmpty() || list3.isEmpty()){
									break;
								}
								this.getMapHandler().faight(list1, list3, list,roleId,id);
							}
						}
						//判断谁胜利了
						int win = 1;
						if(list1.isEmpty()){
							rlt.put("win", id);//对手胜利
							if(jingji.get(0).getTotals()==0){
								rlt.put("percent",100);
							}else{
								rlt.put("percent", (jingji.get(0).getSuccess())*100/(jingji.get(0).getTotals()+1));
								
							}
//							rlt.put("percent", " ");
							win=0;
						}else if(list3.isEmpty()){
							rlt.put("win", roleId);//本家胜利
							if(jingji.get(0).getTotals()==0){
								rlt.put("percent",100);
							}else{
								rlt.put("percent", (jingji.get(0).getSuccess()+1)*100/(jingji.get(0).getTotals()+1));
							}
							//判断是否广播：对手等级前三名
							if(indexes2 <= 3){
								GameRoleDetail role1 = this.getGameRoleService().findRoleById(roleId);
								GameRoleDetail role2 = this.getGameRoleService().findRoleById(id);
								//发送广播
								String message= "玩家 <font color=\"#FF80FF\">" +"【"+ role1.getName() +"】"+ "</font>" +"<font color="+"\"" + GlobalData.messageColor.get("vip")+"\">" + "VIP"+role1.getVip() + "</font> "+ "在 <font color=\"#FF0000\">" + mapreg + "级竞技场</font>中战胜了第" + indexes2 + "名的<font color=\"#00FFFF\">" + role2.getName() + "</font>";
								//GameConstants.log.warn("MatchHanler.fight:" + message);
								this.getsystemHandler().addMessage(message);
							}
					 	}
						rlt.put("list", list);
						map = null;
						foe = null;
						mids0=null;
						
						//领取奖励
						jingjiover(gameRole2.getLevel(), roleId, win, mapreg, rlt);
						rlt.put("url", url);
						gameRole = this.getGameRoleService().findRoleById(roleId);
						gameRole2 = this.getGameRoleService().findRoleById(id);
						//更新排名
						if(win==1){
	//						System.out.println(">>>>win");
							if(indexes>indexes2){
								//更新我 
								param.clear();
								param.put("serverid", serverid);
								param.put("roleid", id);
								jingji2 = this.getGameJingjiStaticService().getGameJingjiByServerid(param);
	//							System.out.println("size:"+jingji2.size()+"indexes:"+jingji2.get(0).getIndexes());
								param.clear();
								if(!jingji2.isEmpty()){
									param.put("indexes", jingji2.get(0).getIndexes());
								}else{
									param.put("indexes", indexes2);
								}
								param.put("serverid", serverid);
								param.put("roleid", roleId);
								param.put("name", gameRole.getName());
								param.put("vip", gameRole.getVip());
//								param.put("indexes", indexes2);
								
								param.put("num", jingji.get(0).getNum()+1);
								param.put("level", gameRole.getLevel());
								param.put("totals", jingji.get(0).getTotals()+1);
								param.put("success", jingji.get(0).getSuccess()+1);
								this.getGameJingjiStaticService().updateGameJingjiByParams(param);
								jingji2 = null;
								//更新对手
								param.clear();
								param.put("serverid", serverid);
								param.put("roleid", id);
								param.put("name", gameRole2.getName());
								param.put("vip", gameRole2.getVip());
								param.put("indexes", indexes);
								this.getGameJingjiStaticService().updateGameJingjiByParams(param);
								
							}
						}else{
						//System.out.println("win");
							param.clear();
							param.put("indexes", indexes);
							param.put("serverid", serverid);
							param.put("roleid", roleId);
							param.put("name", gameRole.getName());
							param.put("vip", gameRole.getVip());
							param.put("num", 0);
							param.put("level", gameRole.getLevel());
							param.put("totals", jingji.get(0).getTotals()+1);
							this.getGameJingjiStaticService().updateGameJingjiByParams(param);
						}
						url = null;
						list1 = null;
						list2 = null;
						list3 = null;
						list = null;
						gameRole2 = null;
						rolechallenge = null;
					} else {// 用户不存在
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-8);
						ServerHandler.sendData(session, respMap);
						return;
					}
				}else{//不在挑战范围之内
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-9);
					ServerHandler.sendData(session, respMap);
					return;
				}
				
	//			System.out.println(rlt);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
				rlt = null;
				param = null;
				gameRole = null;
				arys = null;
		 }
	}

	private void subtime() {
		 int roleId = Integer.parseInt(playerId);
		 Map<String,Object> param = new HashMap<String,Object>();
		 Map<String,Object> rlt = new HashMap<String,Object>();
		 param.clear();
		 param.put("roleid", roleId);
		 param.put("itemid", 2);
		 List<RoleItemDetail> rItem = this.getRoleItemService().getRoleItemByitem(param);
		 if(rItem.isEmpty()){
			 respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
			 ServerHandler.sendData(session, respMap);
			 return;
		 }
		 if(rItem.get(0).getNum()>0){
	//		 System.out.println("MatchHandler减少道具原道具数量：："+rItem.get(0).getNum());
			 param.clear();
			 param.put("roleid", roleId);
			 param.put("num", 1);
			 param.put("itemid", 2);
			 this.getRoleItemService().sbRoleItemNum(param);
			 param.clear();
			 param.put("id", roleId);
			 param.put("jjtime", System.currentTimeMillis());
			 this.getGameRoleService().updateRoleVip(param);
		 }else{
			 respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
			 ServerHandler.sendData(session, respMap);
			 return;
		 }
		 GameRoleDetail gameRole = this.getGameRoleService().findRoleById(roleId);
		 if(gameRole == null){
			 return;
		 }
		 Map<String,Object> map = new HashMap<String,Object>();
		 map.put("bid", rItem.get(0).getId());
		 map.put("num", rItem.get(0).getNum()-1);
		 rlt.put("items", map);
		 rlt.put("num", gameRole.getJingji());
		 respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
		 respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
		 ServerHandler.sendData(session, respMap);
		 rlt = null;
		 param = null;
		 rItem = null;
		 gameRole = null;
		 map = null;
	}

	private void getgoods() {
		 int roleId = Integer.parseInt(playerId);
		 Map<String,Object> param = new HashMap<String,Object>();
		 Map<String,Object> rlt = new HashMap<String,Object>();
		 Calendar calendar = Calendar.getInstance();
		 int hour = calendar.get(Calendar.HOUR_OF_DAY);
		 int minute = calendar.get(Calendar.MINUTE);
		 if(hour==21){
			 if(minute>=0 && minute<=30){
				 respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
				 ServerHandler.sendData(session, respMap);
				 return;
			 }
		 }
		 GameRoleDetail gameRole = this.getGameRoleService().findRoleById(roleId);
		 if(gameRole == null){
			 return;
		 }
	//	 System.out.println("MathHandler礼包领取：名字：" + gameRole.getName() + ",是否可领取：" + gameRole.getJjstatus());
		 if(gameRole.getJjstatus()==0){
			 respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -9);
			 ServerHandler.sendData(session, respMap);
			 return;
		 }
		 int serverid = Integer.parseInt(String.valueOf(gameRole.getServerId()));
		//int serverid=1;
		 param.clear();
		 param.put("roleid", roleId);
		 param.put("serverid", serverid);
		 List<GameJingjiFinalDetail> jingji = this.getGameJingjiFinalService().getGameJingjiByServerid(param);
		 if(jingji.isEmpty()){
			 respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
			 ServerHandler.sendData(session, respMap);
			 return;
		 }
		 int mapreg = jingji.get(0).getMapreg();
		 int level = 1000;//那个区
		 int itemid = 250;
		 int mapid = gameRole.getMapid();
			if(mapid>0 && mapid<=10){
				mapreg = 1;
			}else if(mapid>10 && mapid<=20){
				mapreg = 2;
			}else if(mapid>20 && mapid<=30){
				mapreg = 3;
			}else if(mapid>30 && mapid<=40){
				mapreg = 4;
			//}else if(mapid>40 && mapid<=50){
			}else if(mapid>40 && mapid<=60){
				mapreg = 5;
			}
		 if(mapreg==1){
			 level = 1000;
		 }else if(mapreg == 2){
			 level = 2000;
		 }else if(mapreg == 3){
			 level = 3000;
			 itemid = 251;
		 }else if(mapreg == 4){
			 level = 4000;
			 itemid = 251;
		 }else if(mapreg == 5){
			 level = 5000;
			 itemid = 252;
		 }
		 int needexp = jingji.get(0).getIndexes();//名次
		 if(needexp>10 && needexp<50){
			 needexp = 50;
		 }else if(needexp>50 && needexp<100){
			 needexp = 100;
		 }else if(needexp>100){
			 needexp = 101;
		 }
		 param.clear();
		 param.put("level", level);
		 param.put("needexp", needexp);
		 List<GameLevelDetail> gameLevel = this.getGameLevelService().getGaemLevelByParams(param);
		 if(gameLevel.isEmpty()){
			 respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);
			 ServerHandler.sendData(session, respMap);
			 return;
		 }
		 param.clear();
		 param.put("id", roleId);
		 param.put("exp", gameLevel.get(0).getGetexp()+gameRole.getExp());
		 param.put("yin", gameLevel.get(0).getGetcoin()+gameRole.getYin());
		 param.put("jjstatus", 0);
		 this.getGameRoleService().updateRoleVip(param);
		 GameRoleDetail game = this.getGameRoleService().findRoleById4(roleId);
		 int exp = game.getExp();
		 int gongxun = game.getGongxun();
		 int yin = game.getYin();
		 int upplevel = 0;//判断是否升级
			// 判断是否可以升级
		upplevel = this.getplayerHandler().shengji(roleId, game.getLevel(), exp,gameLevel.get(0).getGetexp());	
		JSONArray list = new JSONArray();
		this.getplayerHandler().getItem(roleId, itemid, gameLevel.get(0).getGetgongxun(), 5, list);
		GameRoleDetail gamerole = this.getGameRoleService().findRoleById4(roleId);//用作获取最后刷新的用户数据
		int needexp2 = this.getGameLevelService().getGameLevelByRoleLevel(gamerole.getLevel()).getNeedexp();// 升级所需经验
		rlt.put("rcoin", gamerole.getYin());
		rlt.put("rexp", gamerole.getExp());
		rlt.put("upplevel", upplevel);
		rlt.put("level", gamerole.getLevel());
		rlt.put("needexp", needexp2);
		param.clear();
		param.put("flag", 1);
		param.put("num", gameLevel.get(0).getGetcoin());
		list.add(param);
		param.clear();
		param.put("flag", 3);
		param.put("num", gameLevel.get(0).getGetexp());
		list.add(param);
		rlt.put("reward", list);
	//	System.out.println(list);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
		ServerHandler.sendData(session, respMap);
		rlt = null;
		param = null;
		list = null;
		gameRole = null;
		gameLevel = null;
		jingji = null;
	}

	private void addnum() {
		 int roleId = Integer.parseInt(playerId);
		 Map<String,Object> param = new HashMap<String,Object>();
		 Map<String,Object> rlt = new HashMap<String,Object>();
		 param.clear();
		 param.put("roleid", roleId);
		 param.put("itemid", 171);
		 List<RoleItemDetail> rItem = this.getRoleItemService().getRoleItemByitem(param);
		 if(rItem.isEmpty()){
			 respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
			 ServerHandler.sendData(session, respMap);
			 return;
		 }
		 GameRoleDetail gameRole = this.getGameRoleService().findRoleById(roleId);
		 if(gameRole==null){
			 return;
		 }
		 int jjnum = gameRole.getJjnum();
		 if(rItem.get(0).getNum()>=(jjnum+1)){
			 //减少道具
			 param.clear();
			 param.put("num", jjnum+1);
			 param.put("roleid", roleId);
			 param.put("itemid", 171);
			 this.getRoleItemService().subRoleItem(param);
			 Map<String,Object> map = new HashMap<String,Object>();
			 map.put("bid", rItem.get(0).getId());
			 map.put("num", rItem.get(0).getNum()-jjnum-1);
			 rlt.put("item", map);
			 //增加
			 param.clear();
			 param.put("id", roleId);
			 param.put("jingji", gameRole.getJingji()+1);
			 param.put("jjnum", jjnum+1);
			 this.getGameRoleService().updateRoleVip(param);
		 }else{//道具不足
			 respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
			 ServerHandler.sendData(session, respMap);
			 return;
		 }
		 rlt.put("num", gameRole.getJingji()+1);
		 rlt.put("nums", gameRole.getJjnum()+1);
		 rlt.put("jjnum", gameRole.getJjnum()+2);
		 int time = (int) ((gameRole.getJjtime() - System.currentTimeMillis())/1000);
		 if(time<=0){
			 time = 0;
		 }
		 rlt.put("time", time);
		 respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
		 respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
		 ServerHandler.sendData(session, respMap);
		 rlt = null;
		 param = null;
		 gameRole = null;
		 rItem = null;
	}

	void openchallenge() {
		long a=System.currentTimeMillis();
		//System.out.println("打开竞技场=============");
		int roleId = Integer.parseInt(playerId);
		Map<String,Object> param = new HashMap<String,Object>();
		Map<String,Object> rlt = new HashMap<String,Object>();
		GameRoleDetail gameRole = this.getGameRoleService().findRoleById(roleId);
		if(gameRole==null){
			return;
		}
		if(gameRole.getMapid()<3){
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
			ServerHandler.sendData(session, respMap);
			return;
		}
//		if(gameRole.getVip()<2){
//			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
//			ServerHandler.sendData(session, respMap);
//			return;
//		}
		//判断是否是新的一天
		long nowtime2 = new Date().getTime();
		int day2 = (int) ((nowtime2 - gameRole.getTasktime()) / 1000 / 60 / 60 / 24 + 1);
		int roleday = gameRole.getDay();
		if (day2 > roleday) {// 新的一天，dailynum应设为0，day增加1，今天还没有领取礼包
			if(day2>this.getRoleTaskService().findRoleTask(roleId).get(0).getDay()){
				param.clear();
				param.put("roleId", roleId);
				param.put("dailynum", 0);
				param.put("day", day2);
				param.put("status", 1);
				this.getRoleTaskService().updateRoleTasknumday(param);
			}
			
			// 恢复妖牌为0

			//标记今天上线，将今天的放到昨天
			JSONArray ary = new JSONArray();
			Map<String, Object> pp = new HashMap<String, Object>();
			pp.put("day", day2);
			ary.add(pp);
			param.clear();
			param.put("id", roleId);
			param.put("day", day2);
			param.put("num", 0);
			param.put("yesterday", gameRole.getToday());
			param.put("today", ary.toString());
			param.put("live", 0);//好友活跃度奖励
			param.put("huangzuangift", 0);//黄钻礼包
			param.put("jingji", 10);
			param.put("jjnum", 0);
			this.getGameRoleService().updateRoleVip(param);
			this.getplayerHandler().updateActivity(roleId);//更新每日活动
			pp=null;
		}
		
		int serverid = Integer.parseInt(gameRole.getServerId());
		//int serverid =1;
		param.clear();
		param.put("serverid", serverid);
		param.put("roleid", roleId);
		List<GameJingjiStaticDetail> jingji = this.getGameJingjiStaticService().getGameJingjiByServerid(param);
		int mapid = gameRole.getMapid();
		int mapreg = 1;
//		if(mapid>0 && mapid<=10){
//			mapreg = 1;
//		}else if(mapid>10 && mapid<=20){
//			mapreg = 2;
//		}else if(mapid>20 && mapid<=30){
//			mapreg = 3;
//		}else if(mapid>30 && mapid<=40){
//			mapreg = 4;
//		//}else if(mapid>40 && mapid<=50){
//		}else if(mapid>40 && mapid<=60){
//			mapreg = 5;
//		}
		rlt.put("zone", mapreg-1);
		//System.out.println("MatchHandler 得到竞技场list：param:" + jingji.size());
		if(jingji.isEmpty()){
			param.clear();
			param.put("serverid", serverid);
			param.put("mapreg", mapreg);
//			System.out.println("serverid:"+serverid+"<<<"+mapreg);
			
			List<GameJingjiStaticDetail> gameMax = this.getGameJingjiStaticService().getGameJingjiMax(param);
			int max=0;
			if(!gameMax.isEmpty()){
				max = gameMax.get(0).getIndexes();
			}
			MapHandler mh = new MapHandler();
			Map<String, String> map = mh.jingji_sum_zxueliang(roleId);
	//		System.out.println("_________map:" + map.toString());
			gameMax=null;
			param.clear();
			param.put("indexes", max+1);
			param.put("roleid", roleId);
			param.put("name", gameRole.getName());
			param.put("mapid", mapid);
			param.put("vip", gameRole.getVip());
			param.put("level", gameRole.getLevel());
			param.put("num", 0);
			param.put("serverid", serverid);
			param.put("mapreg", mapreg);
			param.put("sum", Integer.parseInt(map.get("sum")));
			param.put("zxueliang", Integer.parseInt(map.get("zxueliang")));
			this.getGameJingjiStaticService().insertGameJingji(param);
		}else{//存在该用户
			//判断mapid是否还正确
			if(mapreg!=jingji.get(0).getMapreg()){
				 
				//更新当前用户排行
				int indexes = jingji.get(0).getIndexes();
				param.clear();
				param.put("serverid", serverid);
				param.put("mapreg", mapreg);
				List<GameJingjiStaticDetail> gameMax = this.getGameJingjiStaticService().getGameJingjiMax(param);
				int mx = 0;
				if(!gameMax.isEmpty()){
					mx = gameMax.get(0).getIndexes();
				}
				gameMax=null;
				param.clear();
				param.put("roleid", roleId);
				param.put("serverid", serverid);
				param.put("indexes", mx+1);
				param.put("mapreg", mapreg);
				param.put("mapid", mapid);
				param.put("name", gameRole.getName());
				param.put("vip", gameRole.getVip());
				param.put("level", gameRole.getLevel());
				this.getGameJingjiStaticService().updateGameJingjiByParams(param);
				//调整原来的排行
				param.clear();
				param.put("serverid", serverid);
				param.put("indexes", indexes);
				param.put("mapreg", jingji.get(0).getMapreg());
				this.getGameJingjiStaticService().addGameJingjiIndexes(param);
			}else{//更新必要实时字段
				//更新当前用户排行
				int indexes = jingji.get(0).getIndexes();
				param.clear();
				param.put("roleid", roleId);
				param.put("serverid", serverid);
				param.put("indexes", indexes);
				param.put("mapreg", mapreg);
				param.put("mapid", mapid);
				param.put("name", gameRole.getName());
				param.put("vip", gameRole.getVip());
				param.put("level", gameRole.getLevel());
				this.getGameJingjiStaticService().updateGameJingjiByParams(param);
			}
		}
		//开始
		param.clear();
		param.put("serverid", serverid);
		param.put("roleid", roleId);
		jingji = this.getGameJingjiStaticService().getGameJingjiByServerid(param);
		int indexes = jingji.get(0).getIndexes();
		rlt.put("mytop", indexes);
		rlt.put("win", jingji.get(0).getNum());
		param.clear();
		param.put("serverid", serverid);
		param.put("mapreg", mapreg);
		param.put("page", 0);
		param.put("size", 3);
	//	System.out.println("serverid:"+serverid+">>mapreg:"+mapreg);
		List<GameJingjiFinalDetail> limitList = this.getGameJingjiFinalService().getGameJingjiByLimit(param);
		JSONArray list = new JSONArray();
		Map<String,Object> map = new HashMap<String,Object>();
		int s = limitList.size();
//		System.out.println("size:"+s);
		for(int i=0;i<s;i++){
			map.clear();
			map.put("t", limitList.get(i).getIndexes());
			map.put("name", limitList.get(i).getName());
			map.put("lv", limitList.get(i).getLevel());
			list.add(map);
		}
		map = null;
		rlt.put("list", list);
		rlt.put("num", gameRole.getJingji());
		int jjtime = (int) ((gameRole.getJjtime() - System.currentTimeMillis())/1000);
		if(jjtime<=0){
			rlt.put("time", 0);
		}else{
			rlt.put("time", jjtime);
		}
		//挑战魔王排行
		List ary = new ArrayList();
		
		if(indexes<=10){
			for(int i=1;i<11;i++){
				ary.add(i);
			}
		}else if(indexes>10 && indexes<=100){//间隔1
			int n = indexes;
			for(int i=0;i<10;i++){
				ary.add(--n);
			}
		}else if(indexes>100 && indexes<=150){//间隔2
			if(indexes<120){
				int num = (indexes-100)/2;
				for(int j=0;j<num;j++){
					ary.add(indexes-2*(j+1));
				}
				int p = 100 -1 + indexes%2;
				for(int t=0;t<(10-num);t++){
					ary.add(p);
					p--;
				}
			}else{
				for(int i=0;i<10;i++){
					ary.add((indexes-2*(1+i)));
				}
			}
		}else if(indexes>150 && indexes<=500){//间隔5
			if(indexes<200){
				int num = (indexes-150)/5;
				for(int i=0;i<num;i++){
					ary.add((indexes-5*(1+i)));
				}
				int p = 150 - 2 + indexes%2;
				for(int t=0;t<(10-num);t++){
					ary.add(p);
					p -= 2;
				}
			}else{
				for(int i=0;i<10;i++){
					ary.add((indexes-5*(1+i)));
				}
			}
		}else if(indexes>500){//间隔10
			if(indexes<600){
				int num = (indexes-500)/10;
				for(int i=0;i<num;i++){
					ary.add((indexes-10*(1+i)));
				}
				int p = 500 - 5 + indexes%5;
				for(int t=0;t<(10-num);t++){
					ary.add(p);
					p -= 5;
				}
			}else{
				for(int i=0;i<10;i++){
					ary.add((indexes-10*(1+i)));
				}
			}
		}
		String str = ary.toString();
		str = str.replace("[", "").replace("]", "");
		param.clear();
		param.put("serverid", serverid);
	    param.put("indexes", str);
		param.put("mapreg", mapreg);
		//System.out.println("MatchHandler 得到竞技场list：param:" + param.toString());
		List<GameJingjiStaticDetail> rightTop = this.getGameJingjiStaticService().getGameJingjiByServeridtwo(param);
		int size = rightTop.size();
		//System.out.println("MatchHandler 得到竞技场list：size:" + size);
		JSONArray json = new JSONArray();
		Map<String,Object> map2 = new HashMap<String,Object>();
		if(size>0){
			for(int i=0;i<size;i++){
				//String servername=this.getServerservice().getnamebyid(rightTop.get(i).getServerid()).get(0).getName();
				int roleid=rightTop.get(i).getRoleid();
				//GameConstants.log.warn("roleid:" + roleid);
				String serid=this.getGameRoleService().findRoleById2(roleid).getServerId();
				//GameConstants.log.warn("serid:" + serid);
				int servid = Integer.valueOf(serid);
				String servername=this.getServerservice().getnamebyid(servid).get(0).getName();
				
				map2.clear();
				map2.put("servername",servername);
				map2.put("t", rightTop.get(i).getIndexes());
				map2.put("name", rightTop.get(i).getName());
				map2.put("lv", rightTop.get(i).getLevel());
				if(roleId==rightTop.get(i).getRoleid()){
					map2.put("id", 1);
				}else{
					map2.put("id", 0);
				}
				json.add(map2);
			}
		}
		
		
		rlt.put("top", json);
		rlt.put("jjstatus", gameRole.getJjstatus());
		rlt.put("nums", gameRole.getJjnum());
		rlt.put("jjnum", gameRole.getJjnum()+1);
		json = null;
		map2 = null;
		rightTop = null;
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
		ServerHandler.sendData(session, respMap);
		
		list = null;
		limitList = null;
		gameRole = null;
		jingji = null;
		long b=System.currentTimeMillis();
//		System.out.println("打开竞技场花费的时间："+(b-a));
	}

	private void buyshop() {
		if(params.containsKey("id")&&params.containsKey("t")&&params.containsKey("num")){
			int roleId = Integer.parseInt(playerId);
			int id = Integer.parseInt(String.valueOf(params.get("id")));//道具id
			int t = Integer.parseInt(String.valueOf(params.get("t")));
			int n = Integer.parseInt(String.valueOf(params.get("num")));
			
			if(n<=0){
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);
				ServerHandler.sendData(session, respMap);
				return;
			}
			Map<String, Object> rlt = new HashMap<String, Object>();
			Map<String, Object> param = new HashMap<String, Object>();
			int type = 0;
			if(t==0){
				type = 3;
			}else if(t==1){
				type = 4;
			}else if(t==2){
				type = 5;
			}
			param.clear();
			param.put("resId", id);
			param.put("costType", type);
			List<GamePriceDetail> gamePrice = this.getGamePriceService().getGamePrice(param);
			if(gamePrice.isEmpty()){
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
				ServerHandler.sendData(session, respMap);
				return;
			}
			int num = gamePrice.get(0).getResCost() * n;
			int itemId = gamePrice.get(0).getCostitemid();//使用的道具id
			param.clear();
			param.put("roleid", roleId);
			param.put("itemid", itemId);
			List<RoleItemDetail> rItem = this.getRoleItemService().getRoleItemByitem(param);
			if(rItem.isEmpty()){
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
				ServerHandler.sendData(session, respMap);
				return;
			}
			if(rItem.get(0).getNum()<num){//数量不足
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
				ServerHandler.sendData(session, respMap);
				return;
			}
			
			//增加道具
			JSONArray list = new JSONArray();
			/****/
			int s=0;
			//if(id==10000||id==130000||id==250000||id==370000||id==490000||id==610000||id==730000||id==850000){
			if(id>=10000){
			//b=true;   特殊的道具图腾，不插入到背包里面
				//查看玩家是否有这个图腾，有就更新，没有就插入
				param.clear();
				param.put("roleid", roleId);
				param.put("totemid", id/10000);
				List<RoletotemDetail> to=this.getRoletotemService().getRoletotem(param);
				if(to.isEmpty()){//第一次购买，插入
					List<GametotemDetail> gt=this.getGametotemService().getGametotembyid(id/10000);
					RoletotemDetail mo = new RoletotemDetail();
					mo.setRoleid(roleId);
					mo.setType(gt.get(0).getType());
					mo.setLevel(gt.get(0).getLevel());
					mo.setNum(num);
					mo.setQuality(gt.get(0).getQuality());
					mo.setTotemid(gt.get(0).getId());
					boolean c=this.getRoletotemService().insertRoletotem(mo);
		//			System.out.println("插入图腾========"+c);
					param.clear();
					param.put("roleid", roleId);
					param.put("itemid", itemId);
					param.put("num", num);
					this.getRoleItemService().subRoleItem(param);
					Map<String,Object> map = new HashMap<String,Object>();
					param.clear();
					param.put("roleid", roleId);
					param.put("itemid", itemId);
					rItem = this.getRoleItemService().getRoleItemByitem(param);
					map.put("bid", rItem.get(0).getId());
					map.put("id", itemId);
					map.put("num", rItem.get(0).getNum());
					rlt.put("items", map);
					
					rlt.put("id", id);
					rlt.put("t", t);
					rlt.put("s", s);//1是道具，2是图腾
					//System.out.println("前端传来的Id======"+id+"====1是道具，2是图腾===="+s);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
					ServerHandler.sendData(session, respMap);
					return;
				}else{//更新
					List<GametotemDetail> gt=this.getGametotemService().getGametotembyid(id/10000);
					   param.clear();
					   param.put("roleid", roleId);
					   param.put("type",gt.get(0).getType() );
					   param.put("level", gt.get(0).getLevel());
					   param.put("num", n);
					  boolean a=this.getRoletotemService().addRoletotemNum(param);	
					  // System.out.println("更新图腾========"+a);
					   param.clear();
						param.put("roleid", roleId);
						param.put("itemid", itemId);
						param.put("num", num);
						this.getRoleItemService().subRoleItem(param);
						Map<String,Object> map = new HashMap<String,Object>();
						param.clear();
						param.put("roleid", roleId);
						param.put("itemid", itemId);
						rItem = this.getRoleItemService().getRoleItemByitem(param);
						map.put("bid", rItem.get(0).getId());
						map.put("id", itemId);
						map.put("num", rItem.get(0).getNum());
						rlt.put("items", map);
						
						rlt.put("id", id);
						rlt.put("t", t);
						rlt.put("s", s);//1是道具，2是图腾
						//System.out.println("前端传来的Id======"+id+"====1是道具，2是图腾===="+s);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								GameConstants.GAME_API_SUCCESS);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
						ServerHandler.sendData(session, respMap);
				return;
				}
				
			}
			/****/
			else{
				this.getplayerHandler().getItem(roleId, id, n, 5, list);
				s=1;
			}
			List<Map<String,Object>> list2 = JSONArray.fromObject(list);
			param.clear();
			param.put("roleid", roleId);
			param.put("itemid", id);
			rItem = this.getRoleItemService().getRoleItemByitem(param);
			Map<String,Object> map2 = new HashMap<String,Object>();
			map2.put("bid", list2.get(0).get("bid"));
			map2.put("id", list2.get(0).get("id"));
			map2.put("num", n);
			map2.put("resType", list2.get(0).get("resType"));
			rlt.put("reward", map2);
	//		System.out.println(map2);
			map2 = null;
			list2 = null;
			//减少道具
			param.clear();
			param.put("roleid", roleId);
			param.put("itemid", itemId);
			param.put("num", num);
			this.getRoleItemService().subRoleItem(param);
			Map<String,Object> map = new HashMap<String,Object>();
			param.clear();
			param.put("roleid", roleId);
			param.put("itemid", itemId);
			rItem = this.getRoleItemService().getRoleItemByitem(param);
			map.put("bid", rItem.get(0).getId());
			map.put("id", itemId);
			map.put("num", rItem.get(0).getNum());
			rlt.put("items", map);
			
			rlt.put("id", id);
			rlt.put("t", t);
			rlt.put("s", s);//1是道具，2是图腾
	//		System.out.println("前端传来的Id======"+id+"====1是道具，2是图腾===="+s);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
			ServerHandler.sendData(session, respMap);
			rItem = null;
			gamePrice = null;
			rlt = null;
			param = null;
			map = null;
			list = null;
		}
	}
static int i=0;
	public void jiesuan(){
		
//		if(i==0){
//			
//		}else{
			GameConstants.log.warn("MatchHandler竞技场结算更新表GameJingjiFinal:true______before the first time______jingjistatus:num:" + this.getGameRoleService().getnum(1));
			this.getGameRoleService().updateJingji(1);
			GameConstants.log.warn("MatchHandler竞技场结算更新表GameJingjiFinal:true______before the second time______jingjistatus:num:" + this.getGameRoleService().getnum(1));

//		}
//		boolean d = this.getGameJingjiFinalService().dropzhugong();
//		System.out.println("删除主公表：" + d);
//		boolean c = this.getGameJingjiFinalService().createzhugong();
//		System.out.println("创建主公表：" + c);
//		boolean e = this.getGameJingjiFinalService().alterzhugong();
//		System.out.println("主公表加索引：" + e);
		boolean a = this.getGameJingjiFinalService().dropGameJingjiFinal();
		System.out.println("竞技场结算删除表GameJingjiFinal：" + a);
		boolean b = this.getGameJingjiFinalService().createGameJingjiFinal();
		//System.out.println("b:" + b);
		if(b == false){
			boolean c = this.getGameJingjiFinalService().createGameJingjiFinal();
			//System.out.println("c:" + c);
			if(c == false){
				boolean d = this.getGameJingjiFinalService().createGameJingjiFinal();
				//System.out.println("d:" + d);
			}
		}
		
		
		this.getGameRoleService().updateJingji(1);
		System.out.println("竞技场结算创建表GameJingjiFinal：" + "true");
		List<GameJingjiFinalDetail> gamJingjiFinalList = this.getGameJingjiFinalService().findAllGameJingji();
		for(int i = 0; i < gamJingjiFinalList.size(); i++){
			GlobalDatat.cacheGameJingjiFinalDetails.put(gamJingjiFinalList.get(i).getId(), gamJingjiFinalList.get(i))	;
		}
		//System.out.println("gamJingjiFinalList:	" + GlobalDatat.cacheGameJingjiFinalDetails.size());
		System.out.println("MatchHandler竞技场结算更新表GameJingjiFinal:true____________jingjistatus:num:" + this.getGameRoleService().getnum(1));
		GameConstants.log.warn("MatchHandler竞技场结算更新表GameJingjiFinal:true______before the third time______jingjistatus:num:" + this.getGameRoleService().getnum(1));
		this.getGameRoleService().updateJingji(1);
		GameConstants.log.warn("MatchHandler竞技场结算更新表GameJingjiFinal:true______after the third time______jingjistatus:num:" + this.getGameRoleService().getnum(1));

//		boolean f = this.getGameJingjiFinalService().dropzhugong();
//		System.out.println("删除主公表：" + d);
		i++;
		if(i>500){
			i=1;
		}
	}
	/**
	 * 
	 * @param level对手等级
	 * @param roleid
	 * @param win 1:胜利 0:失败
	 * @param mapreg 当前竞技区1 2 3 4
	 * @param rlt
	 */
	void jingjiover(int level,int roleid,int win,int mapreg,Map<String, Object> rlt){
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		GameLevelDetail gamelevel = null ;
		GameRoleDetail game = this.getGameRoleService().findRoleById(roleid);
		//和玩家战斗
		gamelevel = this.getGameLevelService().getGameLevelByRoleLevel(level);
		//获得奖励
		int needexp = gamelevel.getNeedexp();// 升级所需经验
		int exp = game.getExp();
		int gongxun = game.getGongxun();
		int yin = game.getYin();
		int upplevel = 0;//判断是否升级
		JSONArray reward = new JSONArray();
		int mapid = game.getMapid();
		if(mapid>0 && mapid<=10){
			mapreg = 1;
		}else if(mapid>10 && mapid<=20){
			mapreg = 2;
		}else if(mapid>20 && mapid<=30){
			mapreg = 3;
		}else if(mapid>30 && mapid<=40){
			mapreg = 4;
		//}else if(mapid>40 && mapid<=50){
		}else if(mapid>40 && mapid<=60){
			mapreg = 5;
		}
		int jjid = 250;
		if(mapreg==3 || mapreg==4){
			jjid = 251;
		}else if(mapreg==5){
			jjid=252;
		}
		if(win==1){//胜利
			param.clear();
			param.put("id", roleid);
			param.put("yin", ((int)(gamelevel.getGetcoin()*0.1)+yin));
			param.put("gongxun", ((int)(gamelevel.getGetgongxun()*0.1)+gongxun));
			param.put("exp", ((int)(gamelevel.getGetexp()*0.1)+exp));
			this.getGameRoleService().updateRoleVip(param);
			map.clear();
			map.put("yin", (int)(gamelevel.getGetcoin()*0.1));
			map.put("gongxun", (int)(gamelevel.getGetgongxun()*0.1));
			map.put("exp", (int)(gamelevel.getGetexp()*0.1));
			
			// 判断是否可以升级
			upplevel = this.getplayerHandler().shengji(roleid, game.getLevel(), exp, (int)(gamelevel.getGetexp()*0.1));	
			// 更改下次升级所需经验
			GameRoleDetail gamerole = this.getGameRoleService().findRoleById(roleid);
			needexp = this.getGameLevelService()
					.getGameLevelByRoleLevel(gamerole.getLevel()).getNeedexp();
			map.put("totalyin", gamerole.getYin());
			map.put("totalgongxun", gamerole.getGongxun());
			map.put("totalexp", gamerole.getExp());
			map.put("needexp", needexp);
			map.put("level", gamerole.getLevel());
			map.put("upplevel", upplevel);
			rlt.put("gift", map);
			//获得道具
			this.getplayerHandler().getItem(roleid, jjid, 5, 5, reward);
			rlt.put("reward", reward);
			gamerole=null;
		}else if(win==0){//失败
			param.clear();
			param.put("id", roleid);
			param.put("yin", (int) (gamelevel.getGetcoin()*0.1)+yin);
			param.put("gongxun", (int) (gamelevel.getGetgongxun()*0.1)+gongxun);
			param.put("exp", (int) (gamelevel.getGetexp()*0.1)+exp);
			this.getGameRoleService().updateRoleVip(param);
			map.clear();
			map.put("yin", (int) (gamelevel.getGetcoin()*0.1));
			map.put("gongxun", (int) (gamelevel.getGetgongxun()*0.1));
			map.put("exp", (int) (gamelevel.getGetexp()*0.1));
			
			// 判断是否可以升级
			upplevel = this.getplayerHandler().shengji(roleid, game.getLevel(), exp, (int) (gamelevel.getGetexp()*0.1));
			// 更改下次升级所需经验
			GameRoleDetail gamerole = this.getGameRoleService().findRoleById(roleid);
			needexp = this.getGameLevelService()
					.getGameLevelByRoleLevel(gamerole.getLevel()).getNeedexp();
			map.put("totalyin", gamerole.getYin());
			map.put("totalgongxun", gamerole.getGongxun());
			map.put("totalexp", gamerole.getExp());
			map.put("level", gamerole.getLevel());
			map.put("needexp", needexp);
			map.put("upplevel", upplevel);
			rlt.put("gift", map);
			//增加道具
			this.getplayerHandler().getItem(roleid, jjid, 1, 5, reward);
			rlt.put("reward", reward);
			gamerole=null;
		}
	
		rlt=null;
		param=null;
		map=null;
		gamelevel=null;
		game=null;
		reward=null;
	}
	
}
