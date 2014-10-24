package com.stang.game.server.handler;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Timer;

import net.sf.json.JSONArray;
import net.sf.sojo.interchange.json.JsonSerializer;

import org.apache.mina.core.session.IoSession;

import com.alibaba.fastjson.JSON;
import com.google.gson.JsonArray;
import com.stang.game.cache.GlobalData;
import com.stang.game.cache.GlobalDatat;
import com.stang.game.common.GameConstants;
import com.stang.game.entity.GameRole;
import com.stang.game.entity.detail.CdkStoreDetail;
import com.stang.game.entity.detail.ChallengeRecordDetail;
import com.stang.game.entity.detail.GameBuffDetail;
import com.stang.game.entity.detail.GameEquipDetail;
import com.stang.game.entity.detail.GameItemDetail;
import com.stang.game.entity.detail.GameLevelDetail;
import com.stang.game.entity.detail.GameMapDetail;
import com.stang.game.entity.detail.GameMilitaryDetail;
import com.stang.game.entity.detail.GamePlatsDetail;
import com.stang.game.entity.detail.GameRobotDetail;
import com.stang.game.entity.detail.GameRoleDetail;
import com.stang.game.entity.detail.GameSkillDetail;
import com.stang.game.entity.detail.GameStarDetail;
import com.stang.game.entity.detail.GameTowerDetail;
import com.stang.game.entity.detail.GametotemDetail;
import com.stang.game.entity.detail.MemberDetail;
import com.stang.game.entity.detail.RoleChallengeDetail;
import com.stang.game.entity.detail.RoleDaytaskDetail;
import com.stang.game.entity.detail.RoleEquipDetail;
import com.stang.game.entity.detail.RoleItemDetail;
import com.stang.game.entity.detail.RoleMapDetail;
import com.stang.game.entity.detail.RoleMilitaryDetail;
import com.stang.game.entity.detail.RoleTaskDetail;
import com.stang.game.entity.detail.StatetostateDetail;
import com.stang.game.server.ServerHandler;
import com.stang.game.service.IChallengeRecordService;
import com.stang.game.service.IGameChLevelService;
import com.stang.game.service.IGameEquipService;
import com.stang.game.service.IGameLevelService;
import com.stang.game.service.IGameRobotService;
import com.stang.game.service.IGameStarService;
import com.stang.game.service.IGameTowerService;
import com.stang.game.service.IGameVipService;
import com.stang.game.service.IGametotemService;
import com.stang.game.service.IRoleDaytaskService;
import com.stang.game.service.IRoleEquipService;
import com.stang.game.service.IRoleItemService;
import com.stang.game.service.IRoleMapService;
import com.stang.game.service.IRoleMilitaryService;
import com.stang.game.service.IStatetostateService;
import com.stang.game.service.impl.ChallengeRecordServiceImpl;
import com.stang.game.service.impl.GameChLevelServiceImpl;
import com.stang.game.service.impl.GameEquipServiceImpl;
import com.stang.game.service.impl.GameLevelServiceImpl;
import com.stang.game.service.impl.GameRobotServiceImpl;
import com.stang.game.service.impl.GameStarServiceImpl;
import com.stang.game.service.impl.GameTowerServiceImpl;
import com.stang.game.service.impl.GameVipServiceImpl;
import com.stang.game.service.impl.GametotemServiceImpl;
import com.stang.game.service.impl.RoleDaytaskServiceImpl;
import com.stang.game.service.impl.RoleEquipServiceImpl;
import com.stang.game.service.impl.RoleItemServiceImpl;
import com.stang.game.service.impl.RoleMapServiceImpl;
import com.stang.game.service.impl.RoleMilitaryServiceImpl;

public class MapHandler extends BaseHandler implements GlobalDatat {
	
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
		//if (systemHandler == null) {
			systemHandler = new SystemHandler(gameApiName, globalIdentifier,
					encryptedSignature, playerId, cacheKey, params, session);
		//}
		return systemHandler;
	}	
	
	
	private static IRoleMapService roleMapService;

	private IRoleMapService getRoleMapService() {
		if (roleMapService == null) {
			roleMapService = new RoleMapServiceImpl();
		}
		return roleMapService;
	}
	
	private static IChallengeRecordService challengeRecordService;

	private IChallengeRecordService getChallengeRecordService() {
		if (challengeRecordService == null) {
			challengeRecordService = new ChallengeRecordServiceImpl();
		}
		return challengeRecordService;
	}

	private static IRoleMilitaryService roleMilitaryService;

	private IRoleMilitaryService getRoleMilitaryService() {
		if (roleMilitaryService == null) {
			roleMilitaryService = new RoleMilitaryServiceImpl();
		}
		return roleMilitaryService;
	}

	private static IGameTowerService gameTowerService;

	private IGameTowerService getGameTowerService() {
		if (gameTowerService == null) {
			gameTowerService = new GameTowerServiceImpl();
		}
		return gameTowerService;
	}
	private static IRoleDaytaskService roleDaytask;

	private IRoleDaytaskService getRoleDaytaskService() {
		if (roleDaytask == null) {
			roleDaytask = new RoleDaytaskServiceImpl();
		}
		return roleDaytask;
	}
	private static IGameVipService gameVipService;

	private IGameVipService getGameVipService() {
		if (gameVipService == null) {
			gameVipService = new GameVipServiceImpl();
		}
		return gameVipService;
	}
	private static IGameStarService gameStarService;
	private IGameStarService getGameStarService(){
		if(gameStarService==null){
			gameStarService=new GameStarServiceImpl();
		}
		return gameStarService;
	}
	private static IRoleEquipService roleEquipService;

	private IRoleEquipService getRoleEquipService() {
		if (roleEquipService == null) {
			roleEquipService = new RoleEquipServiceImpl();
		}
		return roleEquipService;
	}

	private static IGameRobotService gameRobotService;

	private IGameRobotService getGameRobotService() {
		if (gameRobotService == null) {
			gameRobotService = new GameRobotServiceImpl();
		}
		return gameRobotService;
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
	private static IGametotemService gametotemService;
	private static int grouppeople1 = 20 ;//群里应该达到的总人数为20，才会发送奖励；
	private IGametotemService getGametotemService(){
		if(gametotemService==null){
			gametotemService=new GametotemServiceImpl();
		}
		return gametotemService;
	}
	private static IGameLevelService gameLevelService;

	private IGameLevelService getGameLevelService() {
		if (gameLevelService == null) {
			gameLevelService = new GameLevelServiceImpl();
		}
		return gameLevelService;
	}
	
	private static IRoleItemService roleItemService;

	private IRoleItemService getRoleItemService() {
		if (roleItemService == null) {
			roleItemService = new RoleItemServiceImpl();
		}
		return roleItemService;
	}
	public MapHandler(){};
	public MapHandler(String gameApiName, String globalIdentifier,
			String encryptedSignature, String playerId, String cacheKey,
			Map params, IoSession session) {
		super(gameApiName, globalIdentifier, encryptedSignature, playerId,
				cacheKey, params, session);
		if (gameApiName.equals("map.changemap")) {
			/** 换地图 */
			this.changemap();
		} else if (gameApiName.equals("map.upgrademap")) {
			/** 升级地图 塔 */
			this.upgrademap();
		} else if (gameApiName.equals("map.openchallenge")) {
			/** 打开争霸战 */
			this.openfight();
		} else if (gameApiName.equals("map.changemilitary")) {
			/** 更换武将出战 确认按钮 */
			this.changemilitary();
		} else if (gameApiName.equals("map.changebutton")) {
			/** 更换武将出战 */
			this.changebutton();
		} else if (gameApiName.equals("map.updateroles")) {
			/** 刷新显示对手 */
			this.updateroles();
		} else if (gameApiName.equals("map.attack")) {
			/** 争霸战攻击 */
			this.attack();
		}else if (gameApiName.equals("map.attacktwo")) {
			/** 争霸战好友对战攻击 */
			this.attacktwo();
		}else if (gameApiName.equals("map.openlive")) {
			/** 打开活跃*/
			openlive();
		}else if (gameApiName.equals("map.getlive")) {
			/** 领取活跃奖励 */
			getlive();
		}else if (gameApiName.equals("map.huangzuangift")) {
			/** 黄钻每日奖励 */
			huangzuangift();
		}else if (gameApiName.equals("map.friends")) {
			/** 领取邀请好友奖励 */
			friends();
		}else if (gameApiName.equals("map.openfriends")) {
			/** 打开邀请好友 */
			openfriends();
		}else if (gameApiName.equals("map.getallfriends")) {
			/** 打开好友界面 */
			getallfriends();
		}else if (gameApiName.equals("map.getgroupfriends")) {
			/** 打开群好友界面 */
			getgroupfriends();
		}else if (gameApiName.equals("map.joinfriends")) {
			/** 领取加群奖励 */
			joinfriends();
		}else if (gameApiName.equals("map.friendactive")) {
			/** 领取群活跃奖励 */
			friendactive();
		}else if (gameApiName.equals("map.gotofriend")) {
			/** 去好友家 */
			gotofriend();
		}else if (gameApiName.equals("map.gohome")) {
			/** 回家 */
			gohome();
		}else if (gameApiName.equals("map.share")) {
			/** 分享 */
			share();
		}else if (gameApiName.equals("map.quit")) {
			/** 罗盘 退出 */
			quit();
		}else if (gameApiName.equals("map.goods1")) {
			/** 购买道具 */
			goods();
		}else if (gameApiName.equals("map.goods2")) {
			/** 购买道具 */
			goods();
		}else if (gameApiName.equals("map.goods3")) {
			/** 购买道具 */
			goods();
		}else if (gameApiName.equals("map.getItem")) {
			/** 购买道具 */
			getItem();
		}else if (gameApiName.equals("map.rezhandou")) {
			/** 扫荡 */
			rezhandou();
		}else if (gameApiName.equals("map.openhuangzuan")) {
			/** 打开黄钻界面 */
			openhuangzuan();
		}
		else if (gameApiName.equals("map.challengerecord")) {
			/** 被打记录 */
			challengerecord();
		}else if(gameApiName.equals("map.invitesomefriend")){
			/** 累计邀请好友奖励*/
			invitesomefriend();
		}
		else if(gameApiName.equals("map.openinvitefriend")){
			/** 打开累计邀请好友奖励*/
			openinvitefriend();
		}
		else if(gameApiName.equals("map.flauntgift")){
			/** 领取炫耀分享等奖励*/
			flauntgift();
		}else if(gameApiName.equals("map.fastattack")){
			fastattack();//快速战斗
		}else if(gameApiName.equals("map.newcomer")){
			newcomer();//跳过新手引导
		}else if(gameApiName.equals("map.openpp")){
			openPassPlayer();//打开通关玩家界面
		}else if(gameApiName.equals("map.opengifteachother")){
			openGiftEachOther();//打开礼尚往来页面
		}else if(gameApiName.equals("map.opengifteachother2")){
			openGiftEachOther2();//打开游戏内部礼尚往来页面
		}else if(gameApiName.equals("map.dealwithstatetostatedata")){
			dealWithStatetoStateData();//处理礼尚往来数据
		}else if(gameApiName.equals("map.dealwithstatetostatedata2")){
			dealWithStatetoStateData2();//游戏内部礼尚往来数据处理
		}else if(gameApiName.equals("map.freegift")){
			freegift();//打开礼尚往来页面
		}else if(gameApiName.equals("map.updateData")){
			updateData(null);//更新礼尚往来数据
		}else if(gameApiName.equals("map.getStsGift")){
			getStsGift();//领取礼尚往来次数礼包
		}

	}
	
	public void getStsGift(){
		int roleid = Integer.parseInt(String.valueOf(playerId));
		Map<String, Object> rlt = new HashMap<String, Object>();
		GameRoleDetail role = this.getGameRoleService().findRoleById(roleid);
		JsonSerializer json = new JsonSerializer();
		if(role.getStsnum() >= 100){
			List<Map<String, Object>> r = new ArrayList<Map<String, Object>>();
			List<GameItemDetail> useList = this.getGameItemService().getGameItemRequest2();
			GameItemDetail gameItem = useList.get(useList.size()-1);
			Map<String, Object> params = new HashMap<String, Object>();
			JSONArray list = new JSONArray();// 用list<map>type=6会报错
			r = (List<Map<String, Object>>) json.deserialize(gameItem.getReward());
			for (int i = 0; i < r.size(); i++) {
				Map map = r.get(i);
				int type = Integer.parseInt(String.valueOf(map.get("resType")));
				int id = Integer.parseInt(String.valueOf(map.get("id")));
				int num = Integer.parseInt(String.valueOf(map.get("num")));
				if (type == 5) {// 道具
					params.clear();
					params.put("roleid", roleid);
					params.put("itemid", id);
					List<RoleItemDetail> item = this.getRoleItemService().getRoleItem(params);
					params.put("num", num);// 获得数量
					params.put("resType", type);
					// 判断背包格子是否已满
					int itemtype = this.getGameItemService().getGameItemById(id).get(0).getItemtype();
					boolean boo = this.getplayerHandler().getShangxian(itemtype, type, roleid,id, num);
					if (boo == false) {// 背包格子不足
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -4);
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
						long bid = this.getAutoIdService().fingKeyValueByTableName("role_item");
						RoleItemDetail iDetail = new RoleItemDetail();
						iDetail.setId(bid);
						iDetail.setRoleid(roleid);
						iDetail.setItemid(id);
						iDetail.setNum(num);
						iDetail.setFlag(1);
						iDetail.setType(itemtype);
						boolean bo = this.getRoleItemService().insertRoleItem(iDetail);
						if (bo == true) {
							params.put("bid", bid);
							params.remove("roleid");
							params.put("id", id);
							params.remove("itemid");
							list.add(params);
						}
					}
				} else if (type == 6) {// 装备// 判断背包格子是否已满
					int equiptype = this.getGameEquipService().getGameEquipById(id).get(0).getType();
					boolean boo = this.getplayerHandler().getShangxian(equiptype, type, roleid, id, num);
					if (boo == false) {// 背包格子不足
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -4);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "装备空间不足");
						ServerHandler.sendData(session, respMap);
						return;
					}
					for (int n = 0; n < num; n++) {// 判断num是几个装备，循环插入数据库// 直接插入
						List<GameEquipDetail> gameequips = this.getGameEquipService().getGameEquipByEid(id);
						GameEquipDetail gameequip = null;
						if (!gameequips.isEmpty()) {
							gameequip = gameequips.get(0);
						}
						int bid = this.getAutoIdService().fingKeyValueByTableName("role_equip");
						// 添加
						int speed = gameequip.getSudu();
						int attack = gameequip.getGongji();
						int hpMax = gameequip.getXueliang();
						int rectlength = gameequip.getFanwei();
						int ty = gameequip.getType();
						String user = "0";
						RoleEquipDetail eDetail = new RoleEquipDetail();
						eDetail.setId(bid);
						eDetail.setDengji(1);
						eDetail.setEquipId(id);
						eDetail.setRoleId(roleid);
						eDetail.setFlag(1);
						eDetail.setType(ty);
						eDetail.setAttack(attack);
						eDetail.setUser(user);
						eDetail.setHpMax(hpMax);
						eDetail.setRectlength(rectlength);
						eDetail.setSpeed(speed);
						this.getRoleEquipService().insertRoleEquip(eDetail);
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
			role.setStsnum(0);
			this.getGameRoleService().updateRole(role);
			rlt.put("reward", list);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, 1);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
		}else{
			//没有自个领取奖励
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
		}
	}
	
	private void freegift(){
		//System.out.println("MapHandler.freegift:params:" + params.toString());
		//GameConstants.log.warn("MapHandler.freegift:params:" + params.toString());
		if(params.containsKey("froleid") && params.containsKey("type") && params.containsKey("flag")){
			boolean b = true;
			boolean bb = false;
			int froleid = Integer.valueOf(String.valueOf(params.get("froleid")));
			int roleid = Integer.parseInt(String.valueOf(playerId));
			int type = Integer.parseInt(String.valueOf(params.get("type")));
			int flag = Integer.parseInt(String.valueOf(params.get("flag")));
			Map<String, Object> rlt = new HashMap<String, Object>();
			GameRoleDetail role = this.getGameRoleService().findRoleById(roleid);
			JsonSerializer json = new JsonSerializer();
			List<StatetostateDetail> receiverFriends = new ArrayList<StatetostateDetail>();
			if(flag == 1){
				if(type == 1){
					receiverFriends = this.getStatetostateService().getRequestByRoleid(froleid);
				}else if( type == 2){
					receiverFriends = this.getStatetostateService().getFreeGiftByRoleid(froleid);
				}
			}else if(flag == 2){
				if(type == 1){
					receiverFriends = this.getStatetostateService().getRequestByRoleid2(froleid);
				}else if( type == 2){
					receiverFriends = this.getStatetostateService().getFreeGiftByRoleid2(froleid);
				}
			}else{
				GameConstants.log.warn("MapHandler.freegift().params has an error! flag:" + flag);
			}
			
			for(int i = 0; i < receiverFriends.size(); i++){
				StatetostateDetail s =  receiverFriends.get(i);
				GameConstants.log.warn("MapHandler.freeGift:iscontains:" + s.getSource());
				if(s.getSource() == roleid){
					bb = time(s.getTime());
					if(bb){
						b = false;
						break;
					}
				}
			}
			if(b == true){
				//正常开启
				rlt.put("flag", flag);
				rlt.put("type", type);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, 1);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
			}else{
				//不可以执行，已经存在数据
				rlt.put("type", type);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
			}
			
		}else{
			//参数不完整
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
		}
	}
	
	private boolean time(long time){
		boolean b = false;
		long begain = 0L;
		long end = 0L;
		SimpleDateFormat sdfb = new SimpleDateFormat("yyyy-MM-dd '00:00:00'");
		SimpleDateFormat sdfe = new SimpleDateFormat("yyyy-MM-dd '23:59:59'");
		try {
			Date startTimeb = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(sdfb.format(new Date()));
			Date startTimee = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(sdfe.format(new Date()));
			begain = startTimeb.getTime();
			end = startTimee.getTime();
			//System.out.println("statb:" + startTimeb.getTime());
			//System.out.println("stime:" + time);
			//System.out.println("state:" + startTimee.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(time <= end && time >= begain){
			b = true;
		}
		return b;
	}
	
	private void dealWithStatetoStateData(){
		//System.out.println("MapHandler.dealWithStatetostateData:params:" + params.toString());
		//GameConstants.log.warn("MapHandler.dealWithStatetostateData:params:" + params.toString());
		if(params.containsKey("t")){
			int t = Integer.valueOf(String.valueOf(params.get("t")));
			int roleid = Integer.parseInt(String.valueOf(playerId));
			Map<String, Object> rlt = new HashMap<String, Object>();
			GameRoleDetail role = this.getGameRoleService().findRoleById(roleid);
			JsonSerializer json = new JsonSerializer();
			if(t == 0){
				int roleid1 = Integer.valueOf(String.valueOf(params.get("roleid1")));
				int roleid2 = Integer.valueOf(String.valueOf(params.get("roleid2")));
				int type = Integer.valueOf(String.valueOf(params.get("type")));
				int itemid = Integer.valueOf(String.valueOf(params.get("itemid")));
				String des = String.valueOf(params.get("msg"));
				StatetostateDetail s = new StatetostateDetail();
				//System.out.println("roleid:" + roleid1 + " roleid1:" + roleid1);
				if(roleid == roleid1){
					s.setSource(roleid1);
					s.setReceiver(roleid2);
					s.setType(type);
					s.setItemid(itemid);
					s.setDescribe(des);
					s.setStatue(0);
					s.setFlag(1);
					s.setTime(System.currentTimeMillis());
					//System.out.println("MapHandler insert Statetostate!");
					this.getStatetostateService().insertStatetostate(s);
					//updateData(s);
					rlt.put("t", t);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, 1);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
					ServerHandler.sendData(session, respMap);
				}else{
					//玩家数据不匹配
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
					ServerHandler.sendData(session, respMap);
				}
			}else if(t == 1){
				if(params.containsKey("id")){
					int idd = Integer.valueOf(String.valueOf(params.get("id")));
					StatetostateDetail s = this.getStatetostateService().getStatetostateById(idd);
					if(s.getStatue() == 0){
						if(s.getType() == 1){//request
							s.setStatue(1);
							this.getStatetostateService().updateStatetostate(s);
							GameItemDetail gameItem = new GameItemDetail();
							gameItem = (this.getGameItemService().getGameItemById(s.getItemid())).get(0);
							List<Map<String, Object>> r = (List<Map<String, Object>>) json.deserialize(gameItem.getReward());
							gameItem = (this.getGameItemService().getGameItemById(Integer.valueOf(String.valueOf(r.get(0).get("id"))))).get(0);
							StatetostateDetail sNew = new StatetostateDetail();
							sNew.setSource(s.getReceiver());
							sNew.setReceiver(s.getSource());
							sNew.setType(2);
							sNew.setItemid(s.getItemid());
							sNew.setDescribe("满足了你的愿望,给了你一个" + gameItem.getItemname() + "!");
							sNew.setStatue(0);
							sNew.setFlag(1);
							sNew.setTime(System.currentTimeMillis());
							this.getStatetostateService().insertStatetostate(sNew);
							//updateData(sNew);
							Map<String, Object> map = new HashMap<String, Object>();
							map.put("statue", s.getStatue());
							rlt.put("map", map);
							rlt.put("type", 1);
							rlt.put("t", t);
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
							ServerHandler.sendData(session, respMap);
						}else if(s.getType() == 2){//freegift
							s.setStatue(1);
							this.getStatetostateService().updateStatetostate(s);
							int iid = s.getItemid();
							List<GameItemDetail> itemList = this.getGameItemService().getGameItemById(iid);
							if(itemList != null){
								String res = itemList.get(0).getReward();
								List<Map> resList = JSON.parseArray(String.valueOf(res), Map.class);
								JSONArray list = new JSONArray();// 用list<map>type=6会报错
								for (int i = 0; i < resList.size(); i++) {
									Map map = resList.get(i);
									int type = Integer.parseInt(String.valueOf(map.get("resType")));
									int id = Integer.parseInt(String.valueOf(map.get("id")));
									int num = Integer.parseInt(String.valueOf(map.get("num")));
									if (type == 5) {// 道具
										params.clear();
										params.put("roleid", roleid);
										params.put("itemid", id);
										List<RoleItemDetail> item = this.getRoleItemService().getRoleItem(params);
										params.put("num", num);// 获得数量
										params.put("resType", type);
										// 判断背包格子是否已满
										int itemtype = this.getGameItemService().getGameItemById(id).get(0).getItemtype();
										boolean boo = this.getplayerHandler().getShangxian(itemtype, type, roleid,id, num);
										if (boo == false) {// 背包格子不足
											respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -4);
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
											long bid = this.getAutoIdService().fingKeyValueByTableName("role_item");
											RoleItemDetail iDetail = new RoleItemDetail();
											iDetail.setId(bid);
											iDetail.setRoleid(roleid);
											iDetail.setItemid(id);
											iDetail.setNum(num);
											iDetail.setFlag(1);
											iDetail.setType(itemtype);
											boolean bo = this.getRoleItemService().insertRoleItem(iDetail);
											if (bo == true) {
												params.put("bid", bid);
												params.remove("roleid");
												params.put("id", id);
												params.remove("itemid");
												list.add(params);
											}
										}
									} else if (type == 6) {// 装备// 判断背包格子是否已满
										int equiptype = this.getGameEquipService().getGameEquipById(id).get(0).getType();
										boolean boo = this.getplayerHandler().getShangxian(equiptype, type, roleid, id, num);
										if (boo == false) {// 背包格子不足
											respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -4);
											respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "装备空间不足");
											ServerHandler.sendData(session, respMap);
											return;
										}
										for (int n = 0; n < num; n++) {// 判断num是几个装备，循环插入数据库// 直接插入
											List<GameEquipDetail> gameequips = this.getGameEquipService().getGameEquipByEid(id);
											GameEquipDetail gameequip = null;
											if (!gameequips.isEmpty()) {
												gameequip = gameequips.get(0);
											}
											int bid = this.getAutoIdService().fingKeyValueByTableName("role_equip");
											// 添加
											int speed = gameequip.getSudu();
											int attack = gameequip.getGongji();
											int hpMax = gameequip.getXueliang();
											int rectlength = gameequip.getFanwei();
											int ty = gameequip.getType();
											String user = "0";
											RoleEquipDetail eDetail = new RoleEquipDetail();
											eDetail.setId(bid);
											eDetail.setDengji(1);
											eDetail.setEquipId(id);
											eDetail.setRoleId(roleid);
											eDetail.setFlag(1);
											eDetail.setType(ty);
											eDetail.setAttack(attack);
											eDetail.setUser(user);
											eDetail.setHpMax(hpMax);
											eDetail.setRectlength(rectlength);
											eDetail.setSpeed(speed);
											this.getRoleEquipService().insertRoleEquip(eDetail);
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
								Map<String, Object> map = new HashMap<String, Object>();
								map.put("statue", s.getStatue());
								rlt.put("map", map);
								// 奖励物品
								rlt.put("reward", list);
								rlt.put("t", 1);
								rlt.put("type", 2);
								//System.out.println("mapHandler.rlt:" + rlt.toString());
								respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
								respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
								ServerHandler.sendData(session, respMap);
							}
						}
					}else{
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -5);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
						ServerHandler.sendData(session, respMap);
					}
					
				}else{
					//参数不完整
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
					ServerHandler.sendData(session, respMap);
				}
			}else if(t == 2){
				if(params.containsKey("id")){
					int id = Integer.valueOf(String.valueOf(params.get("id")));
					StatetostateDetail s = this.getStatetostateService().getStatetostateById(id);
					if(s.getStatue() == 0){
						s.setStatue(2);
						this.getStatetostateService().updateStatetostate(s);
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("statue", s.getStatue());
						rlt.put("map", map);
						rlt.put("t", 2);
						rlt.put("type", s.getType());
					//	System.out.println("mapHandler.rlt:" + rlt.toString());
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, 1);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
						ServerHandler.sendData(session, respMap);
					}else{
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -5);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
						ServerHandler.sendData(session, respMap);
					}
					
				}else{
					//参数不完整
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
					ServerHandler.sendData(session, respMap);
				}
			}else if(t == 3){//集中处理request
				List<StatetostateDetail> list = this.getStatetostateService().getRequestByRoleid(roleid);
				for(int i = 0; i < list.size(); i++){
					if(list.get(i).getStatue() == 0){
						StatetostateDetail s = list.get(i);
						s.setStatue(1);
						this.getStatetostateService().updateStatetostate(s);
						GameItemDetail gameItem = new GameItemDetail();
						gameItem = (this.getGameItemService().getGameItemById(s.getItemid())).get(0);
						List<Map<String, Object>> r = (List<Map<String, Object>>) json.deserialize(gameItem.getReward());
						gameItem = (this.getGameItemService().getGameItemById(Integer.valueOf(String.valueOf(r.get(0).get("id"))))).get(0);
						GameRoleDetail gameRole = this.getGameRoleService().findRoleById(s.getReceiver());
						StatetostateDetail sNew = new StatetostateDetail();
						sNew.setSource(s.getReceiver());
						sNew.setReceiver(s.getSource());
						sNew.setType(2);
						sNew.setItemid(s.getItemid());
						sNew.setDescribe(gameRole.getName() + "满足了你的愿望,给了你一个" + gameItem.getItemname() + "!");
						sNew.setStatue(0);
						sNew.setFlag(1);
						sNew.setTime(System.currentTimeMillis());
						this.getStatetostateService().insertStatetostate(sNew);
						//updateData(sNew);
					}
				}
				
//				Map<String, Object> map = new HashMap<String, Object>();
//				map.put("statue", s.getStatue());
				rlt.put("t", 3);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
			}else if(t == 4){//集中处理freegift
				List<StatetostateDetail> lista = this.getStatetostateService().getFreeGiftByRoleid(roleid);
				JSONArray list = new JSONArray();// 用list<map>返回奖励
				for(int r = 0; r < lista.size(); r++){
					if(lista.get(r).getStatue() == 0){
						StatetostateDetail s = lista.get(r);
						s.setStatue(1);
						this.getStatetostateService().updateStatetostate(s);
						int iid = s.getItemid();
						List<GameItemDetail> itemList = this.getGameItemService().getGameItemById(iid);
						if(itemList != null){
							String res = itemList.get(0).getReward();
							List<Map> resList = JSON.parseArray(String.valueOf(res), Map.class);
							for (int i = 0; i < resList.size(); i++) {
								Map map = resList.get(i);
								int type = Integer.parseInt(String.valueOf(map.get("resType")));
								int id = Integer.parseInt(String.valueOf(map.get("id")));
								int num = Integer.parseInt(String.valueOf(map.get("num")));
								if (type == 5) {// 道具
									params.clear();
									params.put("roleid", roleid);
									params.put("itemid", id);
									List<RoleItemDetail> item = this.getRoleItemService().getRoleItem(params);
									params.put("num", num);// 获得数量
									params.put("resType", type);
									// 判断背包格子是否已满
									int itemtype = this.getGameItemService().getGameItemById(id).get(0).getItemtype();
									boolean boo = this.getplayerHandler().getShangxian(itemtype, type, roleid,id, num);
									if (boo == false) {// 背包格子不足
										respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -4);
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
										long bid = this.getAutoIdService().fingKeyValueByTableName("role_item");
										RoleItemDetail iDetail = new RoleItemDetail();
										iDetail.setId(bid);
										iDetail.setRoleid(roleid);
										iDetail.setItemid(id);
										iDetail.setNum(num);
										iDetail.setFlag(1);
										iDetail.setType(itemtype);
										boolean bo = this.getRoleItemService().insertRoleItem(iDetail);
										if (bo == true) {
											params.put("bid", bid);
											params.remove("roleid");
											params.put("id", id);
											params.remove("itemid");
											list.add(params);
										}
									}
								} else if (type == 6) {// 装备// 判断背包格子是否已满
									int equiptype = this.getGameEquipService().getGameEquipById(id).get(0).getType();
									boolean boo = this.getplayerHandler().getShangxian(equiptype, type, roleid, id, num);
									if (boo == false) {// 背包格子不足
										respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -4);
										respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "装备空间不足");
										ServerHandler.sendData(session, respMap);
										return;
									}
									for (int n = 0; n < num; n++) {// 判断num是几个装备，循环插入数据库// 直接插入
										List<GameEquipDetail> gameequips = this.getGameEquipService().getGameEquipByEid(id);
										GameEquipDetail gameequip = null;
										if (!gameequips.isEmpty()) {
											gameequip = gameequips.get(0);
										}
										int bid = this.getAutoIdService().fingKeyValueByTableName("role_equip");
										// 添加
										int speed = gameequip.getSudu();
										int attack = gameequip.getGongji();
										int hpMax = gameequip.getXueliang();
										int rectlength = gameequip.getFanwei();
										int ty = gameequip.getType();
										String user = "0";
										RoleEquipDetail eDetail = new RoleEquipDetail();
										eDetail.setId(bid);
										eDetail.setDengji(1);
										eDetail.setEquipId(id);
										eDetail.setRoleId(roleid);
										eDetail.setFlag(1);
										eDetail.setType(ty);
										eDetail.setAttack(attack);
										eDetail.setUser(user);
										eDetail.setHpMax(hpMax);
										eDetail.setRectlength(rectlength);
										eDetail.setSpeed(speed);
										this.getRoleEquipService().insertRoleEquip(eDetail);
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
					}
				}
				// 奖励物品
				rlt.put("t", 4);
				rlt.put("reward", list);
				//System.out.println("mapHandler.rlt:" + rlt.toString());
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
			}
		}else{
			//参数不完整
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
		}
		updateData(null);
	}
	//游戏内部礼尚往来
	private void dealWithStatetoStateData2(){
		//System.out.println("MapHandler.dealWithStatetostateData:params:" + params.toString());
		//GameConstants.log.warn("MapHandler.dealWithStatetostateData2:params:" + params.toString());
		if(params.containsKey("t")){
			int t = Integer.valueOf(String.valueOf(params.get("t")));
			int roleid = Integer.parseInt(String.valueOf(playerId));
			Map<String, Object> rlt = new HashMap<String, Object>();
			GameRoleDetail role = this.getGameRoleService().findRoleById(roleid);
			JsonSerializer json = new JsonSerializer();
			JsonSerializer jsont = new JsonSerializer();
			List<MemberDetail> openids = this.getMemberService().findMemberByid(roleid);
			Map<String, String> friendy = new HashMap<String, String>();
			if(role.getStsfriend() == null || role.getStsfriend().toString().length() < 3){
				friendy = null;
			}else{
				friendy = (Map<String, String>) jsont.deserialize(role.getStsfriend(), Map.class);
			}
			if(t == 0){//t=0:保存数据；t=1:处理数据；t=2:批量处理数据
				int roleid1 = Integer.valueOf(String.valueOf(params.get("roleid1")));
				int roleid2 = Integer.valueOf(String.valueOf(params.get("roleid2")));
				if(roleid1 != roleid2){
					int type = Integer.valueOf(String.valueOf(params.get("type")));
					int itemid = Integer.valueOf(String.valueOf(params.get("itemid")));
					String des = String.valueOf(params.get("msg"));
					if(type == 1 || (role.getLevel()/5 + 5) > role.getStsdnum()){
						StatetostateDetail s = new StatetostateDetail();
						if(roleid == roleid1){
							s.setSource(roleid1);
							s.setReceiver(roleid2);
							s.setType(type);
							s.setItemid(itemid);
							s.setDescribe(des);
							s.setStatue(0);
							s.setFlag(2);
							s.setTime(System.currentTimeMillis());
							//System.out.println("MapHandler insert Statetostate!");
							this.getStatetostateService().insertStatetostate(s);
							//updateData(s);
							//记录好友礼尚往来状态
							Map<String, String> friend = new HashMap<String, String>();
							if(role.getStsfriend() == null ? false :(role.getStsfriend().toString().length() > 3 ? true : false)){
								friend = (Map<String, String>) json.deserialize(role.getStsfriend(), Map.class);
								if(friend.containsKey(String.valueOf(roleid2))){
									String value = friend.get(String.valueOf(roleid2)).toString() + type;
									friend.put(String.valueOf(roleid2), value);
								}else{
									friend.put(String.valueOf(roleid2), String.valueOf(type));
								}
							}else{
								friend.put(String.valueOf(roleid2), String.valueOf(type));
							}
							String f = (String) json.serialize(friend);
							role.setStsfriend(f);
							if(type == 2){
								role.setStsdnum(role.getStsdnum() + 1);
								if(role.getStsnum() < 100){
									role.setStsnum(role.getStsnum() + 1);
								}
							}
							this.getGameRoleService().updateRole(role);
							rlt.put("t", t);
							rlt.put("stsdnum", role.getStsdnum());
							rlt.put("stsnum", role.getStsnum());
							rlt.put("type", s.getType());
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, 1);
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
							ServerHandler.sendData(session, respMap);
						}else{
							//玩家数据不匹配
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
							ServerHandler.sendData(session, respMap);
						}
					}else{
						//玩家当日送礼次数已经达到上线
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -6);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
						ServerHandler.sendData(session, respMap);
					}
				}else{
					//玩家无法自己礼尚往来
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -8);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
					ServerHandler.sendData(session, respMap);
				}
				
				
			}else if(t == 1){//t=0:保存数据；t=1:处理数据；t=2:批量处理数据
				if(params.containsKey("id")){
					int idd = Integer.valueOf(String.valueOf(params.get("id")));
					StatetostateDetail s = this.getStatetostateService().getStatetostateById(idd);
					if(s.getStatue() == 0 || s.getStatue() == 1){
						if(s.getType() == 1){//request
							if(s.getStatue() == 0){
								if((role.getLevel()/5 + 5) > role.getStsdnum()){
									if(friendy != null){
										if(!friendy.containsKey(String.valueOf(s.getSource()))){
											s.setStatue(1);
											this.getStatetostateService().updateStatetostate(s);
											GameItemDetail gameItem = new GameItemDetail();
											gameItem = (this.getGameItemService().getGameItemById(s.getItemid())).get(0);
											List<Map<String, Object>> r = (List<Map<String, Object>>) json.deserialize(gameItem.getReward());
											gameItem = (this.getGameItemService().getGameItemById(Integer.valueOf(String.valueOf(r.get(0).get("id"))))).get(0);
											StatetostateDetail sNew = new StatetostateDetail();
											sNew.setSource(s.getReceiver());
											sNew.setReceiver(s.getSource());
											sNew.setType(2);
											sNew.setItemid(s.getItemid());
											sNew.setDescribe("满足了你的愿望,给了你一个" + gameItem.getItemname() + "!");
											sNew.setStatue(0);
											sNew.setFlag(2);
											sNew.setTime(System.currentTimeMillis());
											this.getStatetostateService().insertStatetostate(sNew);
											//updateData(sNew);
											//记录好友礼尚往来状态
											Map<String, String> friend = new HashMap<String, String>();
											if(role.getStsfriend() == null ? false :(role.getStsfriend().toString().length() > 3 ? true : false)){
												friend = (Map<String, String>) json.deserialize(role.getStsfriend(), Map.class);
												if(friend.containsKey(String.valueOf(sNew.getReceiver()))){
													String value = friend.get(String.valueOf(sNew.getReceiver())).toString() + sNew.getType();
													friend.put(String.valueOf(sNew.getReceiver()), value);
												}else{
													friend.put(String.valueOf(sNew.getReceiver()), String.valueOf(sNew.getType()));
												}
											}else{
												friend.put(String.valueOf(sNew.getReceiver()), String.valueOf(sNew.getType()));
											}
											String f = (String) json.serialize(friend);
											role.setStsfriend(f);
											role.setStsdnum(role.getStsdnum() + 1);
											if(role.getStsnum() < 100){
												role.setStsnum(role.getStsnum() + 1);
											}
											this.getGameRoleService().updateRole(role);
											Map<String, Object> map = new HashMap<String, Object>();
											map.put("statue", s.getStatue());
											rlt.put("map", map);
											rlt.put("t", t);
											rlt.put("type", s.getType());
											rlt.put("stsdMaxnum", (role.getLevel()/5 + 5));
											rlt.put("stsdnum", role.getStsdnum());
											rlt.put("stsnum", role.getStsnum());
											respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
											respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
											ServerHandler.sendData(session, respMap);
										}else{
											//玩家已经发送到好友
											respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -9);
											respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
											ServerHandler.sendData(session, respMap);
										}
									}else{

										s.setStatue(1);
										this.getStatetostateService().updateStatetostate(s);
										GameItemDetail gameItem = new GameItemDetail();
										gameItem = (this.getGameItemService().getGameItemById(s.getItemid())).get(0);
										List<Map<String, Object>> r = (List<Map<String, Object>>) json.deserialize(gameItem.getReward());
										gameItem = (this.getGameItemService().getGameItemById(Integer.valueOf(String.valueOf(r.get(0).get("id"))))).get(0);
										StatetostateDetail sNew = new StatetostateDetail();
										sNew.setSource(s.getReceiver());
										sNew.setReceiver(s.getSource());
										sNew.setType(2);
										sNew.setItemid(s.getItemid());
										sNew.setDescribe("满足了你的愿望,给了你一个" + gameItem.getItemname() + "!");
										sNew.setStatue(0);
										sNew.setFlag(2);
										sNew.setTime(System.currentTimeMillis());
										this.getStatetostateService().insertStatetostate(sNew);
										//updateData(sNew);
										//记录好友礼尚往来状态
										Map<String, String> friend = new HashMap<String, String>();
										if(role.getStsfriend() == null ? false :(role.getStsfriend().toString().length() > 3 ? true : false)){
											friend = (Map<String, String>) json.deserialize(role.getStsfriend(), Map.class);
											if(friend.containsKey(String.valueOf(sNew.getReceiver()))){
												String value = friend.get(String.valueOf(sNew.getReceiver())).toString() + sNew.getType();
												friend.put(String.valueOf(sNew.getReceiver()), value);
											}else{
												friend.put(String.valueOf(sNew.getReceiver()), String.valueOf(sNew.getType()));
											}
										}else{
											friend.put(String.valueOf(sNew.getReceiver()), String.valueOf(sNew.getType()));
										}
										String f = (String) json.serialize(friend);
										role.setStsfriend(f);
										role.setStsdnum(role.getStsdnum() + 1);
										if(role.getStsnum() < 100){
											role.setStsnum(role.getStsnum() + 1);
										}
										this.getGameRoleService().updateRole(role);
										Map<String, Object> map = new HashMap<String, Object>();
										map.put("statue", s.getStatue());
										rlt.put("map", map);
										rlt.put("t", t);
										rlt.put("type", s.getType());
										rlt.put("stsdMaxnum", (role.getLevel()/5 + 5));
										rlt.put("stsdnum", role.getStsdnum());
										rlt.put("stsnum", role.getStsnum());
										respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
										respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
										ServerHandler.sendData(session, respMap);
									
									}
									
								}else{
									//玩家当日送礼次数已经达到上线
									respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -6);
									respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
									ServerHandler.sendData(session, respMap);
								}
							}else{
								//已处理数据
								respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -7);
								respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
								ServerHandler.sendData(session, respMap);
							}
						}else if(s.getType() == 2){//freegift
							if(s.getStatue() == 0){
								if(s.getDescribe().startsWith("回赠")){//通过des“回赠”关键字判断词条数据是否为回赠数据
									s.setStatue(3);
								}else{
									s.setStatue(1);
								}
								this.getStatetostateService().updateStatetostate(s);
								int iid = s.getItemid();
								List<GameItemDetail> itemList = this.getGameItemService().getGameItemById(iid);
								if(itemList != null){
									String res = itemList.get(0).getReward();
									List<Map> resList = JSON.parseArray(String.valueOf(res), Map.class);
									JSONArray list = new JSONArray();// 用list<map>type=6会报错
									for (int i = 0; i < resList.size(); i++) {
										Map map = resList.get(i);
										int type = Integer.parseInt(String.valueOf(map.get("resType")));
										int id = Integer.parseInt(String.valueOf(map.get("id")));
										//System.out.println("MapHandler:id:" + id);
										int num = Integer.parseInt(String.valueOf(map.get("num")));
										if (type == 5) {// 道具
											params.clear();
											params.put("roleid", roleid);
											params.put("itemid", id);
											List<RoleItemDetail> item = this.getRoleItemService().getRoleItem(params);
											params.put("num", num);// 获得数量
											params.put("resType", type);
											// 判断背包格子是否已满
											int itemtype = this.getGameItemService().getGameItemById(id).get(0).getItemtype();
											boolean boo = this.getplayerHandler().getShangxian(itemtype, type, roleid,id, num);
											if (boo == false) {// 背包格子不足
												respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -4);
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
												long bid = this.getAutoIdService().fingKeyValueByTableName("role_item");
												RoleItemDetail iDetail = new RoleItemDetail();
												iDetail.setId(bid);
												iDetail.setRoleid(roleid);
												iDetail.setItemid(id);
												iDetail.setNum(num);
												iDetail.setFlag(1);
												iDetail.setType(itemtype);
												boolean bo = this.getRoleItemService().insertRoleItem(iDetail);
												if (bo == true) {
													params.put("bid", bid);
													params.remove("roleid");
													params.put("id", id);
													params.remove("itemid");
													list.add(params);
												}
											}
										} else if (type == 6) {// 装备// 判断背包格子是否已满
											int equiptype = this.getGameEquipService().getGameEquipById(id).get(0).getType();
											boolean boo = this.getplayerHandler().getShangxian(equiptype, type, roleid, id, num);
											if (boo == false) {// 背包格子不足
												respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -4);
												respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "装备空间不足");
												ServerHandler.sendData(session, respMap);
												return;
											}
											for (int n = 0; n < num; n++) {// 判断num是几个装备，循环插入数据库// 直接插入
												List<GameEquipDetail> gameequips = this.getGameEquipService().getGameEquipByEid(id);
												GameEquipDetail gameequip = null;
												if (!gameequips.isEmpty()) {
													gameequip = gameequips.get(0);
												}
												int bid = this.getAutoIdService().fingKeyValueByTableName("role_equip");
												// 添加
												int speed = gameequip.getSudu();
												int attack = gameequip.getGongji();
												int hpMax = gameequip.getXueliang();
												int rectlength = gameequip.getFanwei();
												int ty = gameequip.getType();
												String user = "0";
												RoleEquipDetail eDetail = new RoleEquipDetail();
												eDetail.setId(bid);
												eDetail.setDengji(1);
												eDetail.setEquipId(id);
												eDetail.setRoleId(roleid);
												eDetail.setFlag(1);
												eDetail.setType(ty);
												eDetail.setAttack(attack);
												eDetail.setUser(user);
												eDetail.setHpMax(hpMax);
												eDetail.setRectlength(rectlength);
												eDetail.setSpeed(speed);
												this.getRoleEquipService().insertRoleEquip(eDetail);
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
									Map<String, Object> map = new HashMap<String, Object>();
									map.put("statue", s.getStatue());
									rlt.put("map", map);
									// 奖励物品
									rlt.put("reward", list);
									rlt.put("type", s.getType());
									rlt.put("t", 1);
									//System.out.println("mapHandler.rlt:" + rlt.toString());
									respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
									respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
									ServerHandler.sendData(session, respMap);
								}
							}else if(s.getStatue() == 1){
								if((role.getLevel()/5 + 5) > role.getStsdnum()){
									if(friendy != null){
										if(!friendy.containsKey(String.valueOf(s.getSource()))){
											s.setStatue(3);
											this.getStatetostateService().updateStatetostate(s);
											int roleid1 = s.getReceiver();
											int roleid2 = s.getSource();
											int type = 2;//Integer.valueOf(String.valueOf(params.get("type")));
											int itemid = s.getItemid();//Integer.valueOf(String.valueOf(params.get("itemid")));
											GameItemDetail gameItem = new GameItemDetail();
											gameItem = (this.getGameItemService().getGameItemById(s.getItemid())).get(0);
											List<Map<String, Object>> r = (List<Map<String, Object>>) json.deserialize(gameItem.getReward());
											gameItem = (this.getGameItemService().getGameItemById(Integer.valueOf(String.valueOf(r.get(0).get("id"))))).get(0);
											String des = "回赠你一个" + gameItem.getItemname() + "!";//通过des“回赠”关键字判断词条数据是否为回赠数据
											StatetostateDetail ss = new StatetostateDetail();
											if(roleid == roleid1){
												ss.setSource(roleid1);
												ss.setReceiver(roleid2);
												ss.setType(type);
												ss.setItemid(itemid);
												ss.setDescribe(des);
												ss.setStatue(0);
												ss.setFlag(2);
												ss.setTime(System.currentTimeMillis());
												this.getStatetostateService().insertStatetostate(ss);
												//updateData(ss);
												//记录好友礼尚往来状态
												Map<String, String> friend = new HashMap<String, String>();
												if(role.getStsfriend() == null ? false :(role.getStsfriend().toString().length() > 3 ? true : false)){
													friend = (Map<String, String>) json.deserialize(role.getStsfriend(), Map.class);
													if(friend.containsKey(String.valueOf(roleid2))){
														String value = friend.get(String.valueOf(roleid2)).toString() + type;
														friend.put(String.valueOf(roleid2), value);
													}else{
														friend.put(String.valueOf(roleid2), String.valueOf(type));
													}
												}else{
													friend.put(String.valueOf(roleid2), String.valueOf(type));
												}
												String f = (String) json.serialize(friend);
												role.setStsfriend(f);
												role.setStsdnum(role.getStsdnum() + 1);
												if(role.getStsnum() < 100){
													role.setStsnum(role.getStsnum() + 1);
												}
												this.getGameRoleService().updateRole(role);
												Map<String, Object> map = new HashMap<String, Object>();
												map.put("statue", s.getStatue());
												rlt.put("map", map);
												rlt.put("t", t);
												rlt.put("type", s.getType());
												rlt.put("stsdnum", role.getStsdnum());
												rlt.put("stsnum", role.getStsnum());
												rlt.put("stsdMaxnum", (role.getLevel()/5 + 5));
												respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, 1);
												respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
												ServerHandler.sendData(session, respMap);
											}else{
												//玩家数据不匹配
												respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
												respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
												ServerHandler.sendData(session, respMap);
											}
										}else{
											//玩家已经发送到好友
											respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -9);
											respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
											ServerHandler.sendData(session, respMap);
										}
									}else{

										s.setStatue(3);
										this.getStatetostateService().updateStatetostate(s);
										int roleid1 = s.getReceiver();
										int roleid2 = s.getSource();
										int type = 2;//Integer.valueOf(String.valueOf(params.get("type")));
										int itemid = s.getItemid();//Integer.valueOf(String.valueOf(params.get("itemid")));
										GameItemDetail gameItem = new GameItemDetail();
										gameItem = (this.getGameItemService().getGameItemById(s.getItemid())).get(0);
										List<Map<String, Object>> r = (List<Map<String, Object>>) json.deserialize(gameItem.getReward());
										gameItem = (this.getGameItemService().getGameItemById(Integer.valueOf(String.valueOf(r.get(0).get("id"))))).get(0);
										String des = "回赠你一个" + gameItem.getItemname() + "!";//通过des“回赠”关键字判断词条数据是否为回赠数据
										StatetostateDetail ss = new StatetostateDetail();
										if(roleid == roleid1){
											ss.setSource(roleid1);
											ss.setReceiver(roleid2);
											ss.setType(type);
											ss.setItemid(itemid);
											ss.setDescribe(des);
											ss.setStatue(0);
											ss.setFlag(2);
											ss.setTime(System.currentTimeMillis());
											this.getStatetostateService().insertStatetostate(ss);
											//updateData(ss);
											//记录好友礼尚往来状态
											Map<String, String> friend = new HashMap<String, String>();
											if(role.getStsfriend() == null ? false :(role.getStsfriend().toString().length() > 3 ? true : false)){
												friend = (Map<String, String>) json.deserialize(role.getStsfriend(), Map.class);
												if(friend.containsKey(String.valueOf(roleid2))){
													String value = friend.get(String.valueOf(roleid2)).toString() + type;
													friend.put(String.valueOf(roleid2), value);
												}else{
													friend.put(String.valueOf(roleid2), String.valueOf(type));
												}
											}else{
												friend.put(String.valueOf(roleid2), String.valueOf(type));
											}
											String f = (String) json.serialize(friend);
											role.setStsfriend(f);
											role.setStsdnum(role.getStsdnum() + 1);
											if(role.getStsnum() < 100){
												role.setStsnum(role.getStsnum() + 1);
											}
											this.getGameRoleService().updateRole(role);
											Map<String, Object> map = new HashMap<String, Object>();
											map.put("statue", s.getStatue());
											rlt.put("map", map);
											rlt.put("t", t);
											rlt.put("type", s.getType());
											rlt.put("stsdnum", role.getStsdnum());
											rlt.put("stsnum", role.getStsnum());
											rlt.put("stsdMaxnum", (role.getLevel()/5 + 5));
											respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, 1);
											respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
											ServerHandler.sendData(session, respMap);
										}else{
											//玩家数据不匹配
											respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
											respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
											ServerHandler.sendData(session, respMap);
										}
									
									}
									
								}else{
									//玩家当日送礼次数已经达到上线
									respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -6);
									respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
									ServerHandler.sendData(session, respMap);
								}
							}
						}
					}else{
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -5);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
						ServerHandler.sendData(session, respMap);
					}
				}else{
					//参数不完整
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
					ServerHandler.sendData(session, respMap);
				}
			}else if(t == 2){//t=0:保存数据；t=1:处理数据；t=2:批量处理数据
				System.out.println("MapHandler.dealWithGiftEachOtherData.批量处理数据");
				List<StatetostateDetail> list1 = this.getStatetostateService().getFreeGiftByRoleid2(roleid);
				List<StatetostateDetail> list2 = this.getStatetostateService().getRequestByRoleid2(roleid);
				list1.addAll(list2);
				JSONArray rewardList = new JSONArray();// 用list<map>type=6会报错
				//System.out.println("size:________________:" + list1.size());
				for(int k = 0; k < list1.size(); k++){
					StatetostateDetail s = list1.get(k);
					if(s.getStatue() == 0 || s.getStatue() == 1){
						if((role.getLevel()/5 + 5) > role.getStsdnum()){
							//System.out.println("MapHandler.dealWith:s:id:" + s.getId() + " source:" + s.getSource() + " receiver:" + s.getReceiver() + " itemid:" + s.getItemid() + " type:" + s.getType() + " statue:" + s.getStatue() + " flag:" + s.getFlag());
							
							
							
							
							
							

							if(s.getType() == 1){//request
								if(s.getStatue() == 0){
									if((role.getLevel()/5 + 5) > role.getStsdnum()){
										if(friendy != null){
											if(!friendy.containsKey(String.valueOf(s.getSource()))){
												s.setStatue(1);
												this.getStatetostateService().updateStatetostate(s);
												GameItemDetail gameItem = new GameItemDetail();
												gameItem = (this.getGameItemService().getGameItemById(s.getItemid())).get(0);
												List<Map<String, Object>> r = (List<Map<String, Object>>) json.deserialize(gameItem.getReward());
												gameItem = (this.getGameItemService().getGameItemById(Integer.valueOf(String.valueOf(r.get(0).get("id"))))).get(0);
												StatetostateDetail sNew = new StatetostateDetail();
												sNew.setSource(s.getReceiver());
												sNew.setReceiver(s.getSource());
												sNew.setType(2);
												sNew.setItemid(s.getItemid());
												sNew.setDescribe("满足了你的愿望,给了你一个" + gameItem.getItemname() + "!");
												sNew.setStatue(0);
												sNew.setFlag(1);
												sNew.setTime(System.currentTimeMillis());
												this.getStatetostateService().insertStatetostate(sNew);
												//updateData(sNew);
												//记录好友礼尚往来状态
												Map<String, String> friend = new HashMap<String, String>();
												if(role.getStsfriend() == null ? false :(role.getStsfriend().toString().length() > 3 ? true : false)){
													friend = (Map<String, String>) json.deserialize(role.getStsfriend(), Map.class);
													if(friend.containsKey(String.valueOf(sNew.getReceiver()))){
														String value = friend.get(String.valueOf(sNew.getReceiver())).toString() + sNew.getType();
														friend.put(String.valueOf(sNew.getReceiver()), value);
													}else{
														friend.put(String.valueOf(sNew.getReceiver()), String.valueOf(sNew.getType()));
													}
												}else{
													friend.put(String.valueOf(sNew.getReceiver()), String.valueOf(sNew.getType()));
												}
												String f = (String) json.serialize(friend);
												role.setStsfriend(f);
												role.setStsdnum(role.getStsdnum() + 1);
												if(role.getStsnum() < 100){
													role.setStsnum(role.getStsnum() + 1);
												}
												this.getGameRoleService().updateRole(role);
											}else{
												//玩家已经发送到好友
												respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -9);
												respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
												ServerHandler.sendData(session, respMap);
												continue;
											}
										}else{
											s.setStatue(1);
											this.getStatetostateService().updateStatetostate(s);
											GameItemDetail gameItem = new GameItemDetail();
											gameItem = (this.getGameItemService().getGameItemById(s.getItemid())).get(0);
											List<Map<String, Object>> r = (List<Map<String, Object>>) json.deserialize(gameItem.getReward());
											gameItem = (this.getGameItemService().getGameItemById(Integer.valueOf(String.valueOf(r.get(0).get("id"))))).get(0);
											StatetostateDetail sNew = new StatetostateDetail();
											sNew.setSource(s.getReceiver());
											sNew.setReceiver(s.getSource());
											sNew.setType(2);
											sNew.setItemid(s.getItemid());
											sNew.setDescribe("满足了你的愿望,给了你一个" + gameItem.getItemname() + "!");
											sNew.setStatue(0);
											sNew.setFlag(1);
											sNew.setTime(System.currentTimeMillis());
											this.getStatetostateService().insertStatetostate(sNew);
											//updateData(sNew);
											//记录好友礼尚往来状态
											Map<String, String> friend = new HashMap<String, String>();
											if(role.getStsfriend() == null ? false :(role.getStsfriend().toString().length() > 3 ? true : false)){
												friend = (Map<String, String>) json.deserialize(role.getStsfriend(), Map.class);
												if(friend.containsKey(String.valueOf(sNew.getReceiver()))){
													String value = friend.get(String.valueOf(sNew.getReceiver())).toString() + sNew.getType();
													friend.put(String.valueOf(sNew.getReceiver()), value);
												}else{
													friend.put(String.valueOf(sNew.getReceiver()), String.valueOf(sNew.getType()));
												}
											}else{
												friend.put(String.valueOf(sNew.getReceiver()), String.valueOf(sNew.getType()));
											}
											String f = (String) json.serialize(friend);
											role.setStsfriend(f);
											role.setStsdnum(role.getStsdnum() + 1);
											if(role.getStsnum() < 100){
												role.setStsnum(role.getStsnum() + 1);
											}
											this.getGameRoleService().updateRole(role);
										}
									}
								}
							}else if(s.getType() == 2){//freegift
								if(s.getStatue() == 0){
									if(s.getDescribe().startsWith("回赠")){//通过des“回赠”关键字判断词条数据是否为回赠数据
										s.setStatue(3);
									}else{
										s.setStatue(1);
									}
									this.getStatetostateService().updateStatetostate(s);
									int iid = s.getItemid();
									List<GameItemDetail> itemList = this.getGameItemService().getGameItemById(iid);
									if(itemList != null){
										String res = itemList.get(0).getReward();
										List<Map> resList = JSON.parseArray(String.valueOf(res), Map.class);
										for (int i = 0; i < resList.size(); i++) {
											Map map = resList.get(i);
											int type = Integer.parseInt(String.valueOf(map.get("resType")));
											int id = Integer.parseInt(String.valueOf(map.get("id")));
											int num = Integer.parseInt(String.valueOf(map.get("num")));
											if (type == 5) {// 道具
												params.clear();
												params.put("roleid", roleid);
												params.put("itemid", id);
												List<RoleItemDetail> item = this.getRoleItemService().getRoleItem(params);
												params.put("num", num);// 获得数量
												params.put("resType", type);
												// 判断背包格子是否已满
												int itemtype = this.getGameItemService().getGameItemById(id).get(0).getItemtype();
												boolean boo = this.getplayerHandler().getShangxian(itemtype, type, roleid,id, num);
												if (boo == false) {// 背包格子不足
													respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -4);
													respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "道具空间不足");
													ServerHandler.sendData(session, respMap);
													break;
												}
												if (!item.isEmpty()) {// 已存在
													boolean bo = this.getRoleItemService().addRoleItemNum(params);
													if (bo == true) {
														long bid = item.get(0).getId();
														params.put("bid", bid);
														params.put("id", id);
														params.remove("roleid");
														params.remove("itemid");
														rewardList.add(params);
													} else {

													}
												} else {// 不存在，
													long bid = this.getAutoIdService().fingKeyValueByTableName("role_item");
													RoleItemDetail iDetail = new RoleItemDetail();
													iDetail.setId(bid);
													iDetail.setRoleid(roleid);
													iDetail.setItemid(id);
													iDetail.setNum(num);
													iDetail.setFlag(1);
													iDetail.setType(itemtype);
													boolean bo = this.getRoleItemService().insertRoleItem(iDetail);
													if (bo == true) {
														params.put("bid", bid);
														params.remove("roleid");
														params.put("id", id);
														params.remove("itemid");
														rewardList.add(params);
													}
												}
											} else if (type == 6) {// 装备// 判断背包格子是否已满
												int equiptype = this.getGameEquipService().getGameEquipById(id).get(0).getType();
												boolean boo = this.getplayerHandler().getShangxian(equiptype, type, roleid, id, num);
												if (boo == false) {// 背包格子不足
													respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -4);
													respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "装备空间不足");
													ServerHandler.sendData(session, respMap);
													break;
												}
												for (int n = 0; n < num; n++) {// 判断num是几个装备，循环插入数据库// 直接插入
													List<GameEquipDetail> gameequips = this.getGameEquipService().getGameEquipByEid(id);
													GameEquipDetail gameequip = null;
													if (!gameequips.isEmpty()) {
														gameequip = gameequips.get(0);
													}
													int bid = this.getAutoIdService().fingKeyValueByTableName("role_equip");
													// 添加
													int speed = gameequip.getSudu();
													int attack = gameequip.getGongji();
													int hpMax = gameequip.getXueliang();
													int rectlength = gameequip.getFanwei();
													int ty = gameequip.getType();
													String user = "0";
													RoleEquipDetail eDetail = new RoleEquipDetail();
													eDetail.setId(bid);
													eDetail.setDengji(1);
													eDetail.setEquipId(id);
													eDetail.setRoleId(roleid);
													eDetail.setFlag(1);
													eDetail.setType(ty);
													eDetail.setAttack(attack);
													eDetail.setUser(user);
													eDetail.setHpMax(hpMax);
													eDetail.setRectlength(rectlength);
													eDetail.setSpeed(speed);
													this.getRoleEquipService().insertRoleEquip(eDetail);
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
													rewardList.add(params);
												}
											}
										}
									}
								}else if(s.getStatue() == 1){
									if((role.getLevel()/5 + 5) > role.getStsdnum()){
										if(friendy != null){
											if(!friendy.containsKey(String.valueOf(s.getSource()))){
												s.setStatue(3);
												this.getStatetostateService().updateStatetostate(s);
												int roleid1 = s.getReceiver();
												int roleid2 = s.getSource();
												int type = 2;//Integer.valueOf(String.valueOf(params.get("type")));
												int itemid = s.getItemid();//Integer.valueOf(String.valueOf(params.get("itemid")));
												GameItemDetail gameItem = new GameItemDetail();
												gameItem = (this.getGameItemService().getGameItemById(s.getItemid())).get(0);
												List<Map<String, Object>> r = (List<Map<String, Object>>) json.deserialize(gameItem.getReward());
												gameItem = (this.getGameItemService().getGameItemById(Integer.valueOf(String.valueOf(r.get(0).get("id"))))).get(0);
												String des = "回赠你一个" + gameItem.getItemname() + "!";//通过des“回赠”关键字判断词条数据是否为回赠数据
												StatetostateDetail ss = new StatetostateDetail();
												if(roleid == roleid1){
													ss.setSource(roleid1);
													ss.setReceiver(roleid2);
													ss.setType(type);
													ss.setItemid(itemid);
													ss.setDescribe(des);
													ss.setStatue(0);
													ss.setFlag(2);
													ss.setTime(System.currentTimeMillis());
													this.getStatetostateService().insertStatetostate(ss);
													//updateData(ss);
													//记录好友礼尚往来状态
													Map<String, String> friend = new HashMap<String, String>();
													if(role.getStsfriend() == null ? false :(role.getStsfriend().toString().length() > 3 ? true : false)){
														friend = (Map<String, String>) json.deserialize(role.getStsfriend(), Map.class);
														if(friend.containsKey(String.valueOf(roleid2))){
															String value = friend.get(String.valueOf(roleid2)).toString() + type;
															friend.put(String.valueOf(roleid2), value);
														}else{
															friend.put(String.valueOf(roleid2), String.valueOf(type));
														}
													}else{
														friend.put(String.valueOf(roleid2), String.valueOf(type));
													}
													String f = (String) json.serialize(friend);
													role.setStsfriend(f);
													role.setStsdnum(role.getStsdnum() + 1);
													if(role.getStsnum() < 100){
														role.setStsnum(role.getStsnum() + 1);
													}
													this.getGameRoleService().updateRole(role);
												}
											}else{
												//玩家已经发送到好友
												respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -9);
												respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
												ServerHandler.sendData(session, respMap);
												continue;
											}
										}else{
											s.setStatue(3);
											this.getStatetostateService().updateStatetostate(s);
											int roleid1 = s.getReceiver();
											int roleid2 = s.getSource();
											int type = 2;//Integer.valueOf(String.valueOf(params.get("type")));
											int itemid = s.getItemid();//Integer.valueOf(String.valueOf(params.get("itemid")));
											GameItemDetail gameItem = new GameItemDetail();
											gameItem = (this.getGameItemService().getGameItemById(s.getItemid())).get(0);
											List<Map<String, Object>> r = (List<Map<String, Object>>) json.deserialize(gameItem.getReward());
											gameItem = (this.getGameItemService().getGameItemById(Integer.valueOf(String.valueOf(r.get(0).get("id"))))).get(0);
											String des = "回赠你一个" + gameItem.getItemname() + "!";//通过des“回赠”关键字判断词条数据是否为回赠数据
											StatetostateDetail ss = new StatetostateDetail();
											if(roleid == roleid1){
												ss.setSource(roleid1);
												ss.setReceiver(roleid2);
												ss.setType(type);
												ss.setItemid(itemid);
												ss.setDescribe(des);
												ss.setStatue(0);
												ss.setFlag(2);
												ss.setTime(System.currentTimeMillis());
												this.getStatetostateService().insertStatetostate(ss);
												//updateData(ss);
												//记录好友礼尚往来状态
												Map<String, String> friend = new HashMap<String, String>();
												if(role.getStsfriend() == null ? false :(role.getStsfriend().toString().length() > 3 ? true : false)){
													friend = (Map<String, String>) json.deserialize(role.getStsfriend(), Map.class);
													if(friend.containsKey(String.valueOf(roleid2))){
														String value = friend.get(String.valueOf(roleid2)).toString() + type;
														friend.put(String.valueOf(roleid2), value);
													}else{
														friend.put(String.valueOf(roleid2), String.valueOf(type));
													}
												}else{
													friend.put(String.valueOf(roleid2), String.valueOf(type));
												}
												String f = (String) json.serialize(friend);
												role.setStsfriend(f);
												role.setStsdnum(role.getStsdnum() + 1);
												if(role.getStsnum() < 100){
													role.setStsnum(role.getStsnum() + 1);
												}
												this.getGameRoleService().updateRole(role);
											}
										}
									}
								}
							}
						
							
							
							
							
							
							
							
							
							
							
						}else{
							//玩家当日送礼次数已经达到上线
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -6);
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
							ServerHandler.sendData(session, respMap);
							break;
						}
					}
				}
				rlt.put("stsdnum", role.getStsdnum());
				rlt.put("stsnum", role.getStsnum());
				rlt.put("stsdMaxnum", (role.getLevel()/5 + 5));
				if(rewardList.size() > 0){
					rlt.put("reward", rewardList);
				}
				rlt.put("t", 2);
				//System.out.println("mapHandler.rlt:" + rlt.toString());
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
			}
		}else{
			//参数不完整
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
		}
		updateData(null);
	}
	
	private void updateData(StatetostateDetail s) {
		//System.out.println("MapHandler.updateData:s:" + s + "cacheKey:" + cacheKey);
		int roleid = 0;
		if(s == null){
			roleid = Integer.parseInt(String.valueOf(playerId));
		}else{
			roleid = s.getReceiver();
			//System.out.println("MapHandler.updateData: s :roleid:" + s.getSource() + " frolid:" + roleid + " type:" + s.getType() + "des:" + s.getDescribe());

		}
		//System.out.println("MapHandler.containsKey:" + ServerHandler.playerSessions1.containsKey(roleid) + " roleid:" + roleid);
		if(ServerHandler.playerSessions1.containsKey(roleid)){
			if(s == null){
				Map<String, Object> rlt = new HashMap<String, Object>();
				List<StatetostateDetail> list1 = new ArrayList<StatetostateDetail>();
				List<StatetostateDetail> list2 = new ArrayList<StatetostateDetail>();
				List<StatetostateDetail> list3 = new ArrayList<StatetostateDetail>();
				List<StatetostateDetail> list4 = new ArrayList<StatetostateDetail>();
				list1 = this.getStatetostateService().getRequestByRoleid(roleid);
				list2 = this.getStatetostateService().getFreeGiftByRoleid(roleid);
				list3 = this.getStatetostateService().getRequestByRoleid2(roleid);
				list4 = this.getStatetostateService().getFreeGiftByRoleid2(roleid);
				int n = 0;
				int m = 0;
				int a = 0;
				int b = 0;
				for(int i = 0; i < list1.size(); i++){
					if(list1.get(i).getStatue() == 0){
						n = n + 1;
					}
				}
				for(int i = 0; i < list2.size(); i++){
					if(list2.get(i).getStatue() == 0){
						m = m + 1;
					}
				}
				for(int i = 0; i < list3.size(); i++){
					if(list3.get(i).getStatue() == 0){
						a = a + 1;
					}
				}
				for(int i = 0; i < list4.size(); i++){
					if(list4.get(i).getStatue() == 0){
						b = b + 1;
					}
				}
				rlt.put("name", "freeGift");
				rlt.put("request", n);
				rlt.put("freeGift", m);
				rlt.put("Nrequest", a);
				rlt.put("NfreeGift", b);
				this.getsystemHandler().pacMes2(rlt, roleid);
				//System.out.println("MapHandler.updateData:rlt:" + rlt.toString());
			}else if(s.getFlag() == 1){
				Map<String, Object> rlt = new HashMap<String, Object>();
				List<StatetostateDetail> list1 = new ArrayList<StatetostateDetail>();
				List<StatetostateDetail> list2 = new ArrayList<StatetostateDetail>();
				list1 = this.getStatetostateService().getRequestByRoleid(roleid);
				list2 = this.getStatetostateService().getFreeGiftByRoleid(roleid);
				int n = 0;
				int m = 0;
				for(int i = 0; i < list1.size(); i++){
					if(list1.get(i).getStatue() == 0){
						n = n + 1;
					}
				}
				for(int i = 0; i < list2.size(); i++){
					if(list2.get(i).getStatue() == 0){
						m = m + 1;
					}
				}
				rlt.put("name", "freeGift");
				rlt.put("request", n);
				rlt.put("freeGift", m);
				this.getsystemHandler().pacMes2(rlt, roleid);
			//	System.out.println("MapHandler.updateData:rlt:" + rlt.toString() + " flag:" + s.getFlag());
			}else if (s.getFlag() == 2){
				Map<String, Object> rlt = new HashMap<String, Object>();
				List<StatetostateDetail> list1 = new ArrayList<StatetostateDetail>();
				List<StatetostateDetail> list2 = new ArrayList<StatetostateDetail>();
				list1 = this.getStatetostateService().getRequestByRoleid2(roleid);
				list2 = this.getStatetostateService().getFreeGiftByRoleid2(roleid);
				int n = 0;
				int m = 0;
				for(int i = 0; i < list1.size(); i++){
					if(list1.get(i).getStatue() == 0){
						n = n + 1;
					}
				}
				for(int i = 0; i < list2.size(); i++){
					if(list2.get(i).getStatue() == 0){
						m = m + 1;
					}
				}
				rlt.put("name", "freeGift");
				rlt.put("request", n);
				rlt.put("freeGift", m);
				this.getsystemHandler().pacMes2(rlt, roleid);
				//System.out.println("MapHandler.updateData:rlt:" + rlt.toString() + " flag:" + s.getFlag());
			}
			
		}else{
			System.out.println("玩家：" + s.getReceiver() + "不在线！");
		}
		
	}
	
	private void openGiftEachOther(){
		if(params.containsKey("t")){
			int t = Integer.valueOf(String.valueOf(params.get("t")));
			//t:请求类型：0：打开礼尚往来页面获取好友和道具信息；1：好友请求； 2接受礼物
			int roleid = Integer.parseInt(String.valueOf(playerId));
			Map<String, Object> rlt = new HashMap<String, Object>();
			GameRoleDetail role = this.getGameRoleService().findRoleById(roleid);
			JsonSerializer json = new JsonSerializer();
			if(t == 0){
				//获取好友信息
				JSONArray list = new JSONArray();
				Map<String, Object> map = new HashMap<String, Object>();
				List<MemberDetail> openids = this.getMemberService().findMemberByid(roleid);
				if(!"null".equals(String.valueOf(openids.get(0).getAllfriends()))){
					List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json.deserialize(openids.get(0).getAllfriends());
					for(int i=0;i<roleinfo.size();i++){
						String openid = String.valueOf(roleinfo.get(i).get("openid"));
						List<MemberDetail> list2 = this.getMemberService().findMemberByOpenid(openid);
						if(!list2.isEmpty()){
							for(int g = 0; g < list2.size(); g++){
								if(list2.get(g).getServerId() != null && list2.get(g).getServerId().equals(role.getServerId())){
									int id = list2.get(g).getId();
									//判断id是否存在
									GameRoleDetail rol = this.getGameRoleService().findRoleById(id);
									if(rol!=null){
										if(rol.getServerId() == role.getServerId()){
											String huangzuaninfo = rol.getHuangzuaninfo();
											if(!"null".equals(String.valueOf(huangzuaninfo))){
												List<Map<String, Object>> roleinfo2 = (List<Map<String, Object>>) json.deserialize(huangzuaninfo);
												map.clear();
												map.put("url", roleinfo2.get(0).get("figureurl"));
												map.put("id", id);
											}else{
												map.clear();
												map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
												map.put("id", id);
											}
											map.put("name", rol.getName());
											map.put("level", rol.getLevel());
											map.put("openid", openid);
											list.add(map);
											map.clear();
										}
										String huangzuaninfo = rol.getHuangzuaninfo();
										if(!"null".equals(String.valueOf(huangzuaninfo))){
											List<Map<String, Object>> roleinfo2 = (List<Map<String, Object>>) json.deserialize(huangzuaninfo);
											map.clear();
											map.put("url", roleinfo2.get(0).get("figureurl"));
											map.put("id", id);
										}else{
											map.clear();
											map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
											map.put("id", id);
										}
										map.put("name", rol.getName());
										map.put("level", rol.getLevel());
										map.put("openid", openid);
										list.add(map);
										map.clear();
									}
								}
							}
						}
					}
					rlt.put("ids", list);
				}else{
					rlt.put("ids", list);
				}
				//获取赠送道具信息
				List<Map<String, Object>> roleinfo = new ArrayList<Map<String, Object>>();
				List<Map<String, Object>> r = new ArrayList<Map<String, Object>>();
				List<GameItemDetail> useList = this.getGameItemService().getGameItemRequest();
				for(GameItemDetail gameItem : useList){
					if(null !=gameItem.getReward()){
						r = (List<Map<String, Object>>) json.deserialize(gameItem.getReward());
						r.get(0).put("id", gameItem.getId());
						if(gameItem.getId() == 3001){
							if(role.getLevel() >= 0){
								r.get(0).put("authority", 1);
							}else{
								r.get(0).put("authority", 0);
							}	
						}
						if(gameItem.getId() == 3002){
							if(role.getLevel() >= 20){
								r.get(0).put("authority", 1);
							}else{
								r.get(0).put("authority", 0);
							}	
						}
						if(gameItem.getId() == 3003){
							if(role.getLevel() >= 40){
								r.get(0).put("authority", 1);
							}else{
								r.get(0).put("authority", 0);
							}	
						}
						if(gameItem.getId() == 3004){
							if(role.getLevel() >= 60){
								r.get(0).put("authority", 1);
							}else{
								r.get(0).put("authority", 0);
							}	
						}
						if(gameItem.getId() == 3005){
							if(role.getLevel() >= 80){
								r.get(0).put("authority", 1);
							}else{
								r.get(0).put("authority", 0);
							}	
						}
					}
					roleinfo.addAll(r);
				}
				rlt.put("t", t);
				rlt.put("items", roleinfo);
			//	System.out.println("MapHandler.opengifteachother:rlt:" + rlt.toString());
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
				rlt=null;
				map=null;
			}else if(t == 1){//t:请求类型：0：打开礼尚往来页面获取好友和道具信息；1：好友请求； 2接受礼物
				List<StatetostateDetail> list = this.getStatetostateService().getRequestByRoleid(roleid);
				List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
				if(list != null){
					for(int i = 0; i < list.size(); i++){
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("id", list.get(i).getId());
						//图像url
						int id = list.get(i).getSource();
						//判断id是否存在
						GameRoleDetail rol = this.getGameRoleService().findRoleById(id);
						if(rol!=null){
							String huangzuaninfo = rol.getHuangzuaninfo();
							if(!"null".equals(String.valueOf(huangzuaninfo))){
								List<Map<String, Object>> roleinfo2 = (List<Map<String, Object>>) json.deserialize(huangzuaninfo);
								map.put("url", roleinfo2.get(0).get("figureurl"));
							}else{
								map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
							}
						}
						map.put("name", rol.getName());
						map.put("des", list.get(i).getDescribe());
						map.put("statue", list.get(i).getStatue());
						map.put("time", list.get(i).getTime());
						mapList.add(map);
					}
				}
				rlt.put("t", t);
				rlt.put("requestList", mapList);
			//	System.out.println("MapHandler.opengifteachother:rlt:" + rlt.toString());
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
				rlt=null;
			}else if(t == 2){//t:请求类型：0：打开礼尚往来页面获取好友和道具信息；1：好友请求； 2接受礼物
				List<StatetostateDetail> list = this.getStatetostateService().getFreeGiftByRoleid(roleid);
				List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
				if(list != null){
					for(int i = 0; i < list.size(); i++){
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("id", list.get(i).getId());
						//图像url
						int id = list.get(i).getSource();
						//判断id是否存在
						GameRoleDetail rol = this.getGameRoleService().findRoleById(id);
						if(rol!=null){
							String huangzuaninfo = rol.getHuangzuaninfo();
							if(!"null".equals(String.valueOf(huangzuaninfo))){
								List<Map<String, Object>> roleinfo2 = (List<Map<String, Object>>) json.deserialize(huangzuaninfo);
								map.put("url", roleinfo2.get(0).get("figureurl"));
							}else{
								map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
							}
						}
						map.put("name", rol.getName());
						map.put("des", list.get(i).getDescribe());
						map.put("statue", list.get(i).getStatue());
						map.put("time", list.get(i).getTime());
						mapList.add(map);
					}
				}
				rlt.put("t", t);
				rlt.put("requestList", mapList);
			//	System.out.println("MapHandler.opengifteachother:rlt:" + rlt.toString());
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
				rlt=null;
			}
		}else{
			//参数不完整
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
		}
	}
	
	private void openGiftEachOther2(){
		if(params.containsKey("t")){
			int t = Integer.valueOf(String.valueOf(params.get("t")));
			//t:请求类型：0：打开游戏内部礼尚往来页面获取道具信息；1：打开消息中心
			int roleid = Integer.parseInt(String.valueOf(playerId));
			Map<String, Object> rlt = new HashMap<String, Object>();
			GameRoleDetail role = this.getGameRoleService().findRoleById(roleid);
			JsonSerializer json = new JsonSerializer();
			if(t == 0){//t:请求类型：0：打开礼尚往来页面获取道具信息；1：打开内部礼尚往来的消息中心;2领取加群奖励
				//获取赠送道具信息
				List<Map<String, Object>> roleinfo = new ArrayList<Map<String, Object>>();
				List<Map<String, Object>> r = new ArrayList<Map<String, Object>>();
				List<GameItemDetail> useList = this.getGameItemService().getGameItemRequest2();
				useList.remove(useList.size() - 1);
				for(GameItemDetail gameItem : useList){
					if(null !=gameItem.getReward()){
						r = (List<Map<String, Object>>) json.deserialize(gameItem.getReward());
						r.get(0).put("id", gameItem.getId());
					}
					roleinfo.addAll(r);
				}
				rlt.put("stsnum", role.getStsnum());
				rlt.put("stsdnum", role.getStsdnum());
				rlt.put("stsdMaxnum", role.getLevel()/5 + 5);
				rlt.put("t", t);
				rlt.put("items", roleinfo);
				//System.out.println("MapHandler.opengifteachother2:rlt:" + rlt.toString());
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
				rlt=null;
			}else if(t == 1){//t:请求类型：0：打开礼尚往来页面获取道具信息；1：打开内部礼尚往来的消息中心2领取加群奖励
				List<StatetostateDetail> list = this.getStatetostateService().getRequestByRoleid2(roleid);
				List<StatetostateDetail> list2 = this.getStatetostateService().getFreeGiftByRoleid2(roleid);
				list.addAll(list2);
				List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
				if(list != null){
					for(int i = 0; i < list.size(); i++){
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("id", list.get(i).getId());
						//图像url
						int id = list.get(i).getSource();
						//判断id是否存在
						GameRoleDetail rol = this.getGameRoleService().findRoleById(id);
						if(rol!=null){
							String huangzuaninfo = rol.getHuangzuaninfo();
							if(!"null".equals(String.valueOf(huangzuaninfo))){
								List<Map<String, Object>> roleinfo2 = (List<Map<String, Object>>) json.deserialize(huangzuaninfo);
								map.put("url", roleinfo2.get(0).get("figureurl"));
							}else{
								map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
							}
							map.put("name", rol.getName());
							map.put("des", list.get(i).getDescribe());
							map.put("statue", list.get(i).getStatue());
							map.put("time", list.get(i).getTime());
							map.put("type", list.get(i).getType());
							mapList.add(map);
						}
						
					}
				}
				rlt.put("t", t);
				rlt.put("stsdnum", role.getStsdnum());
				rlt.put("stsdMaxnum", role.getLevel()/5 + 5);
				rlt.put("requestList", mapList);
				//System.out.println("MapHandler.opengifteachother2:rlt:" + rlt.toString());
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
				rlt=null;
			}else if(t == 2){//t:请求类型：0：打开礼尚往来页面获取道具信息；1：打开内部礼尚往来的消息中心2领取加群奖励
				//打开加群奖励页面
				//int roleid = Integer.parseInt(playerId);
				GameRoleDetail grd = this.getGameRoleService().findRoleById(roleid);
				int jiaqunlingjiang = grd.getJiaqunlingjiang();
//						for (int i = 0; i < resList.size(); i++) {
//							Map map = resList.get(i);
//							int type = Integer.parseInt(String.valueOf(map.get("resType")));
//							int id = Integer.parseInt(String.valueOf(map.get("id")));
//							int num = Integer.parseInt(String.valueOf(map.get("num")));
//								params.put("itemid", id);
//								params.put("num", num);// 获得数量
//								params.put("resType", type);
//								list.add(params);
//								}
//						// 奖励物品
//						rlt.put("reward", list);
					    rlt.put("t", t);
					 	rlt.put("aa",jiaqunlingjiang);
					 	rlt.put("items", 4000);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
						ServerHandler.sendData(session, respMap);
					
			}else if(t == 3){
				//打开加群活跃奖励
				GameRoleDetail grd = this.getGameRoleService().findRoleById(roleid);
				int getGroupactive = grd.getGroupactive();
				List<Map> listb = JSON.parseArray(String.valueOf(GlobalDatat.grouplist.get(roleid)), Map.class);
				int ii = 0;
				int qunzongshu = GlobalDatat.grouplist.get(roleid).size();//群内总的人数
				if(!listb.isEmpty()){
					for(int w = 0; w < listb.size(); w++){
						int roleidj = Integer.valueOf(String.valueOf(listb.get(w).get("id")));
						GameRoleDetail grd1 = this.getGameRoleService().findRoleById(roleidj);
						int getGroupactive1 = grd1.getGroupactive();
						if(getGroupactive1!=0){
							ii++;
						}
						
					}
				}
					int num1 = 1;
					if(qunzongshu*6/10==qunzongshu*0.6){
						num1=0;
					}
						if(getGroupactive==1){
							if(qunzongshu>=grouppeople1&&ii>=qunzongshu*6/10+num1){
								getGroupactive=1;
							}else{
								getGroupactive=2;
							}
						}
						// 奖励物品
//						rlt.put("reward", list);
						rlt.put("t", t);
					 	rlt.put("aa",getGroupactive);
					 	rlt.put("items", 4001);
						rlt.put("grouppeople", qunzongshu);
						rlt.put("groupactivetotal", ii);
						//System.out.println("mapHandler.rlt:" + rlt.toString());
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
						ServerHandler.sendData(session, respMap);
					}
		}else{
			//参数不完整
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
			//respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
		}
	}
	
	
	private void newcomer() {
		int roleid = Integer.parseInt(String.valueOf(playerId));
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("helpstep", 0);
		param.put("id", roleid);
		boolean a=this.getGameRoleService().updateRolehelpstep(param);
		Map<String, Object> rlt = new HashMap<String, Object>();
		rlt.put("helpstep",94);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
						rlt);
				ServerHandler.sendData(session, respMap);
		
	}
	
	
	private void fastattack() {
		//long ab = System.currentTimeMillis();
		long b = 0;
	//	System.out.println("攻击争霸战开始" +  Integer.parseInt(playerId) + "||||||||||||||||||||||||||||||||||||||||||||||" + this.getClass().toString() + this.hashCode());
		if (params.containsKey("id")&&params.containsKey("t")&&params.containsKey("r")&&params.containsKey("num")) {
	//		System.out.println("param:" + params.toString());
			int id = Integer.parseInt(String.valueOf(params.get("id")));
			int t = Integer.parseInt(String.valueOf(params.get("t")));
			int r = Integer.parseInt(String.valueOf(params.get("r")));//是否是复仇的玩家,是复仇玩家全服通知
			int fastnum=Integer.parseInt(String.valueOf(params.get("num")));
			int roleid = Integer.parseInt(playerId);
			int winid = 0;
			String stlist02="";
			String beihitname="";
			int hitrate = 0;
			int beihitrate = 0;
			int hitlevel = 0;
			int beihitlevel = 0;
			Map<String, Object> rlt = new HashMap<String, Object>();
			Map<String, Object> param = new HashMap<String, Object>();
			//System.out.println("和机器人还是玩家战斗t:::1是玩家:::::::::::::"+t);
			//System.out.println("扫荡次数：：：："+fastnum+"::::::::r:::"+r);
			// 消耗一个挑战令
			GameRoleDetail gamerole = this.getGameRoleService().findRoleById3(roleid);
			int challengenum = gamerole.getChallengenum();
			int vip = gamerole.getVip();
			String hitname=gamerole.getName();
			String totem=gamerole.getTotem();
			List litotem;
			JsonSerializer json1 = new JsonSerializer();
			
			litotem=(List) json1.deserialize(totem);
			if(gamerole.getLevel()<15){//15级后开启快速战斗
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-10);//该功能尚未开启
				ServerHandler.sendData(session, respMap);
				return;
			}
			//黄钻享受vip2待遇
			if(vip<2){
				int huangzuan = 0;
				JsonSerializer json = new JsonSerializer();
				
				String Huangzuaninfo = gamerole.getHuangzuaninfo();
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
					vip =2;
				}
			}
			//b = System.currentTimeMillis();
//以上代码（判断黄砖）用时间为0s
			int challengetop = this.getGameVipService().getGameVipByLe(
					vip).get(0).getChallengTop();
			if (challengenum >= fastnum) {// 可以挑战
				// 判断挑战令是否等于15，开始每小时增加一个挑战令,记录时间
				if (challengenum == challengetop) {// 开始倒计时
					param.clear();
					param.put("id", roleid);
					param.put("challengetime", new Date().getTime());
					this.getGameRoleService().updateRoleVip(param);
				}
				param.clear();
				param.put("id", roleid);
				param.put("challengenum", (challengenum - fastnum));
				this.getGameRoleService().updateRoleVip(param);
				challengenum=challengenum-fastnum;
			} else {// 挑战令不足
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-3);
				ServerHandler.sendData(session, respMap);
				return;
			}
			//b = System.currentTimeMillis();
//System.out.println("开始战斗：" +  Integer.parseInt(playerId) + "用时：" + (b-ab));
			//开始战斗
			JSONArray list1 = new JSONArray();//本家
			JSONArray list02 = new JSONArray();//自己mids
			JSONArray list03 = new JSONArray();//自己总攻击
			JSONArray list2 = new JSONArray();//对手mids
			JSONArray list3 = new JSONArray();//对手总攻击
			JSONArray list = new JSONArray();
			Map<String,Object> map = new HashMap<String,Object>();
			//b = System.currentTimeMillis();
//此段消耗时间为0s
			param.clear();
			param.put("roleid", roleid);
			List<RoleChallengeDetail> rolechallenge = this.getRoleChallengeService().findRoleChallengeById(param);
			List<RoleMilitaryDetail> roe0 = null;
			if (!rolechallenge.isEmpty()) {//获得自己
				//判断出战武将是否为空
				JsonSerializer json = new JsonSerializer();
				litotem=(List) json.deserialize(totem);
				List mids = (List) json.deserialize(rolechallenge.get(0).getMilitaryid());
				if(mids.isEmpty()){//随机选取一定武将，放入rolechallenge
					param.clear();
					param.put("roleId", roleid);
					 roe0 = this.getRoleMilitaryService().getRoleMilitaryByparam(param);
					if(roe0.isEmpty()){
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-5);
						ServerHandler.sendData(session, respMap);
						return;
					}
					//根据等级出战数量
					List ary = new ArrayList();
					int num=0;//出战武将数
					if(gamerole.getLevel()<=10){
						num = 3;
					}else if(gamerole.getLevel()>10 && gamerole.getLevel()<=15){
						num = 6;
					}else if(gamerole.getLevel()>15){
						num = 9;
					}
					if(roe0.size()>=num){//只取6个
						for(int i=0;i<num;i++){
							ary.add(roe0.get(i).getId());
						}
					}else{
						for(int i=0;i<roe0.size();i++){
							ary.add(roe0.get(i).getId());
						}
					}
					this.militaryDetail(ary,roleid, list1,litotem);
					rlt.put("mid", ary);
					
					ary=null;
				}else{
					this.militaryDetail(mids,roleid, list1,litotem);// 获得武将列表信息
				}
				
				
				
				
				mids=null;
			} else {// 用户不存在
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);
				ServerHandler.sendData(session, respMap);
				return;
			}
			//b = System.currentTimeMillis();
//System.out.println("获得自己的武将：" +  Integer.parseInt(playerId) + "用时：" + (b-ab));
			String mids1=list1.toString();
			List url= new ArrayList();//头像地址
			//获取自己头像
			//String Huangzuaninfo = this.getGameRoleService().findRoleById(roleid).getHuangzuaninfo();
			//hitlevel=this.getGameRoleService().findRoleById(roleid).getLevel();
			
			String Huangzuaninfo =gamerole.getHuangzuaninfo();
			hitlevel=gamerole.getLevel();
		//	System.out.println("得到的黄砖信息：" + String.valueOf(Huangzuaninfo));
			if("null".equals(String.valueOf(Huangzuaninfo))){
				url.add("http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
			}else{
				JsonSerializer json = new JsonSerializer();
				List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
						.deserialize(Huangzuaninfo);
				if("null".equals(String.valueOf(roleinfo.get(0).get("figureurl")))){
//					System.out.println("url.add4195:" + url);
					url.add("http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
				}else{
					url.add(roleinfo.get(0).get("figureurl"));
				}
//				System.out.println("url.add4195:" + url);
				roleinfo=null;
			}
			String hittoux;
			String beihittoux;
			hittoux="http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50";
			//b = System.currentTimeMillis();
//System.out.println("得到自己的头像信息：" +  Integer.parseInt(playerId) + "用时：" + (b-ab));
			List litotem2;
			if(t==1){//和游戏玩家战斗
				//获取玩家头像url
				GameRoleDetail gamerole2 = this.getGameRoleService()
				.findRoleById3(id);
	//			System.out.println("//和游戏玩家战斗_____________________________gameRole2:id:" + gamerole2.getId() + "    totem:" + gamerole2.getTotem());
				//long x=System.currentTimeMillis();
				//System.out.println("=========findRoleById3查询======="+Integer.parseInt(playerId)+"用时:"+(x-b));
				String totem2=gamerole2.getTotem();
				
				litotem2=(List) json1.deserialize(totem2);
				rlt.put("totem",litotem2);
				beihitname=gamerole2.getName();
				beihitlevel=gamerole2.getLevel();
				String huangzuangift = gamerole2.getHuangzuaninfo();
				if("null".equals(String.valueOf(huangzuangift))){
					url.add("http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
				}else{
					JsonSerializer json = new JsonSerializer();
				
					List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
							.deserialize(huangzuangift);
					url.add(roleinfo.get(0).get("figureurl"));
				
					roleinfo=null;
				}
			beihittoux="http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50"		;
				//获得自己的信息
                /****/
				//param.clear();
				//param.put("roleid", roleid);
				//List<RoleChallengeDetail> foe0 = this.getRoleChallengeService()
					//	.findRoleChallengeById(param);
			List<RoleChallengeDetail> foe0=rolechallenge;
				if (!foe0.isEmpty()) {
					JsonSerializer json = new JsonSerializer();
					litotem2=(List) json.deserialize(totem2);
					List mids = (List) json.deserialize(foe0.get(0)
				.getMilitaryid());
					if(mids.isEmpty()){//随机选取一定武将，放入rolechallenge
						
//根据等级出战数量
						List ary = new ArrayList();
						int num=0;//出战武将数
						int level = gamerole.getLevel();
						
						if(level<=10){
							num = 3;
						}else if(level>10 && level<=15){
							num = 6;
						}else if(level>15){
							num = 9;
						}
						if(roe0.size()>=num){//只取6个
							for(int i=0;i<num;i++){
								ary.add(roe0.get(i).getId());
							}
						}else{
							for(int i=0;i<roe0.size();i++){
								ary.add(roe0.get(i).getId());
							}
						}
						this.militaryDetail(ary,roleid, list03,litotem);
						this.foeMilitary(ary,roleid, list02,litotem);
						roe0=null;
						ary=null;
					}else{
						this.militaryDetail(mids,roleid, list03,litotem);// 获得武将列表信息
						this.foeMilitary(mids,roleid, list02,litotem);
					}
					map.clear();
//					rlt.put("mids", list2);
					map.put("mids1", list02);
//					rlt.put("id", id);
//					rlt.put("name", gamerole.getName());
					int success = foe0.get(0).getSuccess();
					int total = foe0.get(0).getTotals();
					hitrate=(success*100/(total+1));
					if(total==0){
						map.put("percent", 100);
					}else{
						map.put("percent", success*100/total);
					}
					mids1=null;
				} else {// 对手不存在
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);
					ServerHandler.sendData(session, respMap);
					return;
				}
				
			
				stlist02=list02.toString();
				//System.out.println("获得list02的魔将信息不是机器人=="+stlist02);
				/****/
				
				
				
				
				// 获得对手信息
				param.clear();
				param.put("roleid", id);
				List<RoleChallengeDetail> foe = this.getRoleChallengeService()
						.findRoleChallengeById(param);
				if (!foe.isEmpty()) {
					JsonSerializer json = new JsonSerializer();
					List mids = (List) json.deserialize(foe.get(0)
				.getMilitaryid());
					if(mids.isEmpty()){//随机选取一定武将，放入rolechallenge
						param.clear();
						param.put("roleId", id);
						List<RoleMilitaryDetail> roe = this.getRoleMilitaryService().getRoleMilitaryByparam(param);
						if(roe.isEmpty()){
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-5);
							ServerHandler.sendData(session, respMap);
							return;
						}
//根据等级出战数量
						List ary = new ArrayList();
						int num=0;//出战武将数
						int level = gamerole2.getLevel();
					
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
						this.militaryDetail(ary,id, list3,litotem2);
						this.foeMilitary(ary,id, list2,litotem2);
						roe=null;
						ary=null;
					}else{
						this.militaryDetail(mids,id, list3,litotem2);// 获得武将列表信息
						this.foeMilitary(mids,id, list2,litotem2);
					}
					map.clear();
//					rlt.put("mids", list2);
					map.put("mids", list2);
//					rlt.put("id", id);
//					rlt.put("name", gamerole.getName());
					int success = foe.get(0).getSuccess();
					int total = foe.get(0).getTotals();
					beihitrate=(success*100/(total+1));
					if(total==0){
						map.put("percent", 100);
					}else{
						map.put("percent", success*100/total);
					}
					mids=null;
				} else {// 对手不存在
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);
					ServerHandler.sendData(session, respMap);
					return;
				}
				
				map.put("level", gamerole2.getLevel());
				map.put("name", gamerole2.getName());
				rlt.put("foe", map);
				// 开始攻击
				

				//b = System.currentTimeMillis();
//				System.out.println("循环战斗开始：" +  Integer.parseInt(playerId) + "用时：" + (b-ab));
				if(list1.size()>list3.size()){//最大回合数
					int size1 = list1.size();
					for(int i=0;i<50;i++){
						
					if(list1.isEmpty() || list3.isEmpty()){
							break;
						}
						faight(list1, list3, list,roleid,id);
					}
				}else{
					int size3 = list3.size();
					for(int i=0;i<50;i++){
						
						if(list1.isEmpty() || list3.isEmpty()){
							break;
						}
						faight(list1, list3, list,roleid,id);
					}
				}
				//b = System.currentTimeMillis();
//				System.out.println("循环战斗结束：" +  Integer.parseInt(playerId) + "用时：" + (b-ab));
				//判断谁胜利了
				int success = rolechallenge.get(0).getSuccess();
				int total = rolechallenge.get(0).getTotals();
				if(list1.isEmpty()){
					rlt.put("win", id);//对手胜利
					param.clear();
					param.put("roleid", roleid);
					param.put("totals", (total+1));
					param.put("win", 0);
					this.getRoleChallengeService().updateRoleChallenge(param);
					rlt.put("percent", (success*100/(total+1)));
					winid=id;
					//beihitrate=(success*100/(total+1));
//更新胜率........
				}else if(list3.isEmpty()){
					rlt.put("win", roleid);//本家胜利
					param.clear();
					param.put("roleid", roleid);
					param.put("success", (success+1));
					param.put("totals", (total+1));
					param.put("win", 1);
					this.getRoleChallengeService().updateRoleChallenge(param);
					rlt.put("percent", ((success+1)*100/(total+1)));
					winid=roleid;
					//hitrate=((success+1)*100/(total+1));
				}
				rlt.put("list", list);
				foe=null;
			}else{//和机器人战斗
				url.add("http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
				param.clear();
				param.put("id", id);
				beihittoux=url.toString();
				litotem2=(List) json1.deserialize("[]");
				rlt.put("totem",litotem2);
	//			System.out.println("和机器人战斗的totem:::::"+rlt.get("totem"));
				//litotem2=null;
				List<GameRobotDetail> robot = this.getGameRobotService().findGameRobot(param);
				if(robot.isEmpty()){//机器人不存在
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);
					ServerHandler.sendData(session, respMap);
					return;
				}else{//可以战斗
					JsonSerializer json = new JsonSerializer();
					List<Map<String, Object>> mids = (List<Map<String, Object>>) json
							.deserialize(robot.get(0).getMilitarys());
					if(mids.size()==0){
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-5);
						ServerHandler.sendData(session, respMap);
						return;
					}
					for(int i=0;i<mids.size();i++){
						int mid = Integer.parseInt(String.valueOf(mids.get(i).get("id")));//武将id
						List<GameMilitaryDetail> gamemilitary = this
						.getGameMilitaryService().getGameMilitaryBymid(mid);
					//	System.out.println(":::::::::::");
						int level = Integer.parseInt(String.valueOf(mids.get(i).get("level")));//武将等级
					
						int attack = 0;
						int speed = 0;
						int xueliang = 0;
						int types = 0;
						String name = "";//武将名字
						int pinzhi = 0;
						String desc=null;
						int artm=0;
						
						if (!gamemilitary.isEmpty()) {
							attack = gamemilitary.get(0).getGongji()+(gamemilitary.get(0).getGjiacheng()* (level-1));
							speed = gamemilitary.get(0).getGongsu();
							xueliang = gamemilitary.get(0).getXueliang()+(gamemilitary.get(0).getXljiacheng()*  (level-1));
							name = gamemilitary.get(0).getName();
							types = gamemilitary.get(0).getType();
							pinzhi = gamemilitary.get(0).getPingzhi();
							desc=gamemilitary.get(0).getDesc();
							artm=gamemilitary.get(0).getArts();
							
						} 
						
						int addattack = Integer.parseInt(String.valueOf(mids.get(i).get("addattack")));
						int addspeed = Integer.parseInt(String.valueOf(mids.get(i).get("addspeed")));
						int addxueliang = Integer.parseInt(String.valueOf(mids.get(i).get("addxueliang")));
						
						map.clear();
						map.put("gongji", attack+addattack);
						map.put("gongsu", (speed+addspeed));
						map.put("xueliang", (xueliang+addxueliang));
						
						//被动技能
						int arts = gamemilitary.get(0).getArts();
						if(arts!=0){
							List<GameSkillDetail> gameSkill = this.getGameSkillService().getGameSkillById(arts);
							if(!gameSkill.isEmpty()){
								map.put("skillid", gameSkill.get(0).getId());
								map.put("skillodd", gameSkill.get(0).getSkillodd());
								JSONArray bary = JSONArray.fromObject(gameSkill.get(0).getSkillBuffId());
								if(!bary.isEmpty()){
									bary.get(0);
									List<GameBuffDetail> gameBuff = this.getGameBuffService().getGameBuffById(Integer.parseInt(String.valueOf(bary.get(0))));
									if(!gameBuff.isEmpty()){
										map.put("buffatktime", gameBuff.get(0).getBuffAtktime());
										map.put("buffobj", gameBuff.get(0).getBuffobj());
										map.put("speed", gameBuff.get(0).getSpeed());
										map.put("attack", gameBuff.get(0).getAttack());
										map.put("health", gameBuff.get(0).getHealth());
										map.put("miss", gameBuff.get(0).getMiss());
										map.put("baoji", gameBuff.get(0).getBaoji());
									}else{
										continue;
									}
									gameBuff=null;
								}
								bary=null;
						}else{
							continue;
						}
						gameSkill=null;
						}else{//没有技能
							map.put("skillid", 0);
							map.put("skillodd", 0);
							map.put("buffatktime", 0);
							map.put("buffobj", 0);
							map.put("speed", 0);
							map.put("attack", 0);
							map.put("health", 0);
							map.put("miss", 0);
							map.put("baoji", 0);
						}
						
						list3.add(map);
						
						map.clear();
						map.put("_att", attack);
						map.put("_attsp", speed);
						map.put("_blood", xueliang);
						map.put("_att_add", addattack);
						map.put("_attsp_add", addspeed);
						map.put("_blood_add", addxueliang);
						//附加
						
						map.put("name",name);
						map.put("level", level);
						//获得jobname
						String jobname = "";
						if(level<10){
							level = 1;
						}else if(level>=10 && level<25){
							level = 10;
						}else if(level>=25 && level<45){
							level = 25;
						}else{
							level = 45;
						}
						param.clear();
						param.put("type", types);
						param.put("level", level);
						jobname  = this.getGameChLevelService().findGameChLevelByparas(param).get(0).getName();
						
						 map.put("url", desc);
					     map.put("arts", artm);
						map.put("_jobName", jobname);//职业
						map.put("types", types);
						map.put("pinzhi",pinzhi);
						list2.add(map);
						Map<String,Object> m= new HashMap<String,Object>();
						m.clear();
						m.put("mids", list2);
						m.put("level", robot.get(0).getLevel());
						m.put("name", robot.get(0).getName());
						m.put("percent", robot.get(0).getPercent());
						rlt.put("foe", m);
						beihitrate=robot.get(0).getPercent();
						gamemilitary=null;
					}
					//开始战斗
					//b = System.currentTimeMillis();
//					System.out.println("循环战斗开始：" +  Integer.parseInt(playerId) + "用时：" + (b-ab));
					
					if(list1.size()>list3.size()){//最大回合数
						int size1 = list1.size();
						
						for(int i=0;i<50;i++){
							
							if(list1.isEmpty() || list3.isEmpty()){
								break;
							}
							faight(list1, list3, list,roleid,id);
						}
					}else{
						int size3 = list3.size();
						for(int i=0;i<50;i++){
							
							if(list1.isEmpty() || list3.isEmpty()){
								break;
							}
							faight(list1, list3, list,roleid,id);
						}
						
					}
					//b = System.currentTimeMillis();
//					System.out.println("循环战斗结束：" +  Integer.parseInt(playerId) + "用时：" + (b-ab));
					//判断谁胜利了
					
					int success = rolechallenge.get(0).getSuccess();
					int total = rolechallenge.get(0).getTotals();
					if(list1.isEmpty()){
						rlt.put("win", id);//对手胜利
						param.clear();
						param.put("roleid", roleid);
						param.put("totals", (total+1));
						param.put("win", 0);
						this.getRoleChallengeService().updateRoleChallenge(param);
						rlt.put("percent", (success*100/(total+1)));
				winid=id;
			//	beihitrate=(success*100/(total+1));
//更新胜率........
					}else if(list3.isEmpty()){
						rlt.put("win", roleid);//本家胜利
						param.clear();
						param.put("roleid", roleid);
						param.put("success", (success+1));
						param.put("totals", (total+1));
						param.put("win", 1);
						this.getRoleChallengeService().updateRoleChallenge(param);
						rlt.put("percent", ((success+1)*100/(total+1)));
					winid=roleid;
					//hitrate=((success+1)*100/(total+1));
					}
					rlt.put("list", list);
					mids=null;
					robot=null;
				}
				
			}
			//b = System.currentTimeMillis();
//System.out.println("完成战斗：" +  Integer.parseInt(playerId) + "用时：" + (b-ab));
			//领取奖励
			//争霸战扫荡,xy扫荡次数
				this.challengefastover(t, id, roleid, rlt,fastnum);	
			
			//this.challengeover(t, id, roleid, rlt);
//			System.out.println("头像图片的url:" + url.toString());
			rlt.put("url", url);//url数组，第一个是自己，第二个是别人
		    //rlt.put("challengenum", this.getGameRoleService().findRoleById(roleid).getChallengenum());
			rlt.put("challengenum", challengenum);
			
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
			/****/
					int size = GlobalData.cacheGameMap.size();
					url=null;
			/****/
//此段代码耗时0s（完成全服广播）
			list1=null;
			list2=null;
			list3=null;
			list=null;
			rlt=null;
			param=null;
			
			map=null;
			rolechallenge=null;
			
		}
		//b = System.currentTimeMillis();
		//System.out.println("指控变量，攻击争霸战结束" +  Integer.parseInt(playerId) + "用时：" + (b-ab));
	}
	private void flauntgift() {
		
		if(params.containsKey("t")){//分享t=1 炫耀t=2   试玩t=3  挑战t=4   所有奖励5
			int t = Integer.parseInt(String.valueOf(params.get("t")));//合成魔将的Id
			
			int roleid = Integer.parseInt(String.valueOf(playerId));
			
		
			JSONArray list = new JSONArray();
			Map<String, Object> rlt = new HashMap<String, Object>();
			GameRoleDetail statu=this.getGameRoleService().findRoleById(roleid);
			
			
			if(t==1){//分享t=1
				GameRoleDetail gr=new GameRoleDetail();
				if(statu.getFdsharegift()==1){
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
					ServerHandler.sendData(session, respMap);
					return;
				}
				
				gr.setFdsharegift(1);
				gr.setId(roleid);
				boolean b=this.getGameRoleService().updateRoleGift4(gr);
				getLiveItem(roleid, 11, 1, 5, list);//
				
			}else if(t==2){//炫耀t=2
				GameRoleDetail gr=new GameRoleDetail();
				if(statu.getFlauntgift()==1){
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
					ServerHandler.sendData(session, respMap);
					return;
				}
				
				gr.setFlauntgift(1);
				gr.setId(roleid);
				this.getGameRoleService().updateRoleGift(gr);
				getLiveItem(roleid, 2, 1, 5, list);//
			}else if(t==3){//试玩t=3
				GameRoleDetail gr=new GameRoleDetail();
				if(statu.getSharedemogift()==1){
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
					ServerHandler.sendData(session, respMap);
					return;
				}
				
				gr.setSharedemogift(1);
				gr.setId(roleid);
				this.getGameRoleService().updateRoleGift3(gr);
				getLiveItem(roleid, 9, 3, 5, list);//
				
			}else if(t==4){//挑战t=4
				GameRoleDetail gr=new GameRoleDetail();
				if(statu.getChallengegift()==1){
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
					ServerHandler.sendData(session, respMap);
					return;
				}
				
				gr.setChallengegift(1);
				gr.setId(roleid);
				this.getGameRoleService().updateRoleGift2(gr);
				getLiveItem(roleid, 10, 1, 5, list);//
			}else if(t==5){//所有奖励5
				GameRoleDetail gr=new GameRoleDetail();
				if(statu.getAllfdgift()==1){
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
					ServerHandler.sendData(session, respMap);
					return;
				}
				gr.setAllfdgift(1);
				gr.setId(roleid);
				this.getGameRoleService().updateRoleGift5(gr);
			
				getLiveItem(roleid, 4, 1, 5, list);
				
			}
			
			rlt.put("reward", list);
			rlt.put("t", t);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
					rlt);
			ServerHandler.sendData(session, respMap);
		}
		
	}

	private void openinvitefriend() {
		
        int num=0;
		Map<String, Object> rlt = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		JSONArray mapjs = new JSONArray();
	
		int roleid = Integer.parseInt(playerId);
		int friendnum=0;
		String ids = this.getGameRoleService().findRoleById(roleid).getIds();
		String yu1=this.getGameItemService().getGameItemByIdtwo(228).get(0).getItemprop();
		String yu2=this.getGameItemService().getGameItemByIdtwo(229).get(0).getItemprop();
		String yu3=this.getGameItemService().getGameItemByIdtwo(230).get(0).getItemprop();
		String yu4=this.getGameItemService().getGameItemByIdtwo(231).get(0).getItemprop();
		String yu5=this.getGameItemService().getGameItemByIdtwo(232).get(0).getItemprop();
		String yu6=this.getGameItemService().getGameItemByIdtwo(233).get(0).getItemprop();
		String yu7=this.getGameItemService().getGameItemByIdtwo(234).get(0).getItemprop();
		String yu8=this.getGameItemService().getGameItemByIdtwo(235).get(0).getItemprop();
		String yu9=this.getGameItemService().getGameItemByIdtwo(236).get(0).getItemprop();
		String yu10=this.getGameItemService().getGameItemByIdtwo(237).get(0).getItemprop();
		
		if("null".equals(String.valueOf(ids))){//没有邀请过
			//System.out.println("====1================");
			map.put("info", yu10);
			map.put("canget", 0);
			map.put("num", 20);
			mapjs.add(map);
			map.clear();
			map.put("info", yu9);
			map.put("canget", 0);
			map.put("num", 17);
			mapjs.add(map);
			map.clear();
			map.put("info",yu8);
			map.put("canget", 0);
			map.put("num", 14);
			mapjs.add(map);
			map.clear();
			map.put("info", yu7);
			map.put("canget", 0);
			map.put("num", 11);
			mapjs.add(map);
			map.clear();
			map.put("info", yu6);
			map.put("canget", 0);
			map.put("num", 9);
			mapjs.add(map);
			map.clear();
			map.put("info", yu5);
			map.put("canget", 0);
			map.put("num", 7);
			mapjs.add(map);
			map.clear();
			map.put("info", yu4);
			map.put("canget", 0);
			map.put("num", 5);
			mapjs.add(map);
			map.clear();
			map.put("info",yu3);
			map.put("canget", 0);
			map.put("num", 3);
			mapjs.add(map);
			map.clear();
			map.put("info", yu2);
			map.put("canget", 0);
			map.put("num", 2);
			mapjs.add(map);
			map.clear();
			map.put("info",yu1);
			map.put("canget", 0);
			map.put("num", 1);
			mapjs.add(map);
			map.clear();
		
			
			
		}else{
			if(!"null".equals(String.valueOf(ids))){//
				
				//JsonSerializer json = new JsonSerializer();
				JSONArray ids2 = JSONArray.fromObject(ids);
				Set set = new HashSet();
				for(int k=0;k<ids2.size();k++){
					set.add(ids2.get(k));
				}
				ids2.clear();
				Iterator it = set.iterator();
				while(it.hasNext()){
					ids2.add(it.next());
				}
				int level=0;
		    	for(int i=0;i<ids2.size();i++){
			
					int frid=ids2.getInt(i);
					GameRoleDetail gr=this.getGameRoleService().findRoleById(frid);
					if(gr==null){
						continue;
						
					}
					
					level=gr.getLevel();
					
					if(level>=1){//邀请成功条件设置为被邀请玩家达到1级
					num++;
					}
				}
			
			

		}
		String friends = this.getGameRoleService().findRoleById(roleid).getFriends();
		List list = new ArrayList();
		JSONArray roleinfo = JSONArray.fromObject(friends);
		if(roleinfo.size()==0){
			//System.out.println(num+"==num==2================");
     map.put("info", yu10);

    map.put("num", 20);
       if(num<20){
	map.put("canget", 0);	
       }else{
	map.put("canget", 1);
       }
       mapjs.add(map);
 map.clear();
map.put("info", yu9);
map.put("num", 17);
if(num<17){
	map.put("canget", 0);	
}else{
	map.put("canget", 1);
}
mapjs.add(map);
map.clear();
map.put("info",yu8);
if(num<14){
	map.put("canget", 0);	
}else{
	map.put("canget", 1);
}
map.put("num", 14);
mapjs.add(map);
map.clear();
map.put("info",yu7);
if(num<11){
	map.put("canget", 0);	
}else{
	map.put("canget", 1);
}
map.put("num", 11);
mapjs.add(map);
map.clear();
map.put("info",yu6);
if(num<9){
	map.put("canget", 0);	
}else{
	map.put("canget", 1);
}
map.put("num", 9);
mapjs.add(map);
map.clear();
map.put("info",yu5);
if(num<7){
	map.put("canget", 0);	
}else{
	map.put("canget", 1);
}
map.put("num", 7);
mapjs.add(map);
map.clear();
map.put("info",yu4);
if(num<5){
	map.put("canget", 0);	
}else{
	map.put("canget", 1);
}
map.put("num", 5);
mapjs.add(map);
map.clear();
map.put("info",yu3);
if(num<3){
	map.put("canget", 0);	
}else{
	map.put("canget", 1);
}
map.put("num", 3);
mapjs.add(map);
map.clear();
map.put("info",yu2);
if(num<2){
	map.put("canget", 0);	
}else{
	map.put("canget", 1);
}
map.put("num", 2);
mapjs.add(map);
map.clear();
map.put("info", yu1);
if(num<1){
	map.put("canget", 0);	
}else{
	map.put("canget", 1);
}
map.put("num",1);
mapjs.add(map);
map.clear();


		}
		
		else{
			//System.out.println("====3================");
			if(roleinfo.size()>0){
				   map.put("info",yu10);

				    map.put("num", 20);
				if(num<20){
					map.put("canget", 0);	
				}else{
					int a=0;
					for(int i=0;i<roleinfo.size();i++){
						//list.add(roleinfo.get(i));
			    	
				if(roleinfo.getInt(i)==20){
					a=1;
					break;
				}
				
				}
				
					if(a==1){
						map.put("canget", 0);
					}else{
						map.put("canget", 1);
					}
					
					
					
				}
				mapjs.add(map);
				map.clear();
				map.put("info", yu9);
				map.put("num", 17);
				if(num<17){
					map.put("canget", 0);	
				}else{
					int a=0;
					for(int i=0;i<roleinfo.size();i++){
						//list.add(roleinfo.get(i));
			    	
				if(roleinfo.getInt(i)==17){
					a=1;
					break;
				}
				
				}
				
					if(a==1){
						map.put("canget", 0);
					}else{
						map.put("canget", 1);
					}
				}
				mapjs.add(map);
				map.clear();
				map.put("info", yu8);
				if(num<14){
					map.put("canget", 0);	
				}else{
					int a=0;
					for(int i=0;i<roleinfo.size();i++){
						//list.add(roleinfo.get(i));
			    	
				if(roleinfo.getInt(i)==14){
					a=1;
					break;
				}
				
				}
				
					if(a==1){
						map.put("canget", 0);
					}else{
						map.put("canget", 1);
					}
				}
				map.put("num", 14);
				mapjs.add(map);
				map.clear();
				map.put("info",yu7);
				if(num<11){
					map.put("canget", 0);	
				}else{
					int a=0;
					for(int i=0;i<roleinfo.size();i++){
						//list.add(roleinfo.get(i));
			    	
				if(roleinfo.getInt(i)==11){
					a=1;
					break;
				}
				
				}
				
					if(a==1){
						map.put("canget", 0);
					}else{
						map.put("canget", 1);
					}
				}
				map.put("num", 11);
				mapjs.add(map);
				map.clear();
				map.put("info",yu6);
				if(num<9){
					map.put("canget", 0);	
				}else{
					int a=0;
					for(int i=0;i<roleinfo.size();i++){
						//list.add(roleinfo.get(i));
			    	
				if(roleinfo.getInt(i)==9){
					a=1;
					break;
				}
				
				}
				
					if(a==1){
						map.put("canget", 0);
					}else{
						map.put("canget", 1);
					}
				}
				map.put("num", 9);
				mapjs.add(map);
				map.clear();
				map.put("info",yu5);
				if(num<7){
					map.put("canget", 0);	
				}else{
					int a=0;
					for(int i=0;i<roleinfo.size();i++){
						//list.add(roleinfo.get(i));
			    	
				if(roleinfo.getInt(i)==7){
					a=1;
					break;
				}
				
				}
				
					if(a==1){
						map.put("canget", 0);
					}else{
						map.put("canget", 1);
					}
				}
				map.put("num", 7);
				mapjs.add(map);
				map.clear();
				map.put("info",yu4);
				if(num<5){
					map.put("canget", 0);	
				}else{
					int a=0;
					for(int i=0;i<roleinfo.size();i++){
						//list.add(roleinfo.get(i));
			    	
				if(roleinfo.getInt(i)==5){
					a=1;
					break;
				}
				
				}
				
					if(a==1){
						map.put("canget", 0);
					}else{
						map.put("canget", 1);
					}
				}
				map.put("num", 5);
				mapjs.add(map);
				map.clear();
				map.put("info",yu3);
				if(num<3){
					map.put("canget", 0);	
				}else{
					int a=0;
					for(int i=0;i<roleinfo.size();i++){
						//list.add(roleinfo.get(i));
			    	
				if(roleinfo.getInt(i)==3){
					a=1;
					break;
				}
				
				}
				
					if(a==1){
						map.put("canget", 0);
					}else{
						map.put("canget", 1);
					}
				}
				map.put("num", 3);
				mapjs.add(map);
				map.clear();
				map.put("info",yu2);
				if(num<2){
					map.put("canget", 0);	
				}else{
					int a=0;
					for(int i=0;i<roleinfo.size();i++){
						//list.add(roleinfo.get(i));
			    	
				if(roleinfo.getInt(i)==2){
					a=1;
					break;
				}
				
				}
				
					if(a==1){
						map.put("canget", 0);
					}else{
						map.put("canget", 1);
					}
				}
				map.put("num", 2);
				mapjs.add(map);
				map.clear();
				map.put("info",yu1);
				if(num<1){
					map.put("canget", 0);	
				}else{
					int a=0;
					for(int i=0;i<roleinfo.size();i++){
						//list.add(roleinfo.get(i));
			    	
				if(roleinfo.getInt(i)==1){
					a=1;
					break;
				}
				
				}
				
					if(a==1){
						map.put("canget", 0);
					}else{
						map.put("canget", 1);
					}
				}
				map.put("num", 1);
				mapjs.add(map);
				map.clear();

				
			}else{


			     map.put("info",yu10);

			    map.put("num", 20);
			if(num<20){
				map.put("canget", 0);	
			}else{
				map.put("canget", 1);
			}
			mapjs.add(map);
			map.clear();
			map.put("info",yu9);
			map.put("num", 17);
			if(num<17){
				map.put("canget", 0);	
			}else{
				map.put("canget", 1);
			}
			mapjs.add(map);
			map.clear();
			map.put("info",yu8);
			if(num<14){
				map.put("canget", 0);	
			}else{
				map.put("canget", 1);
			}
			map.put("num", 14);
			mapjs.add(map);
			map.clear();
			map.put("info",yu7);
			if(num<11){
				map.put("canget", 0);	
			}else{
				map.put("canget", 1);
			}
			map.put("num", 11);
			mapjs.add(map);
			map.clear();
			map.put("info",yu6);
			if(num<9){
				map.put("canget", 0);	
			}else{
				map.put("canget", 1);
			}
			map.put("num", 9);
			mapjs.add(map);
			map.clear();
			map.put("info",yu5);
			if(num<7){
				map.put("canget", 0);	
			}else{
				map.put("canget", 1);
			}
			map.put("num", 7);
			mapjs.add(map);
			map.clear();
			map.put("info",yu4);
			if(num<5){
				map.put("canget", 0);	
			}else{
				map.put("canget", 1);
			}
			map.put("num", 5);
			mapjs.add(map);
			map.clear();
			map.put("info",3);
			if(num<3){
				map.put("canget", 0);	
			}else{
				map.put("canget", 1);
			}
			map.put("num", 3);
			mapjs.add(map);
			map.clear();
			map.put("info",2);
			if(num<2){
				map.put("canget", 0);	
			}else{
				map.put("canget", 1);
			}
			map.put("num", 2);
			mapjs.add(map);
			map.clear();
			map.put("info", 1);
			if(num<1){
				map.put("canget", 0);	
			}else{
				map.put("canget", 1);
			}
			map.put("num",1);
			mapjs.add(map);
			map.clear();


					
			}
		}
		
		}
		rlt.put("friendsnum", num);
		rlt.put("list",mapjs);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
				rlt);
		ServerHandler.sendData(session, respMap);
		rlt=null;
	}

	private void invitesomefriend() {

		if(params.containsKey("num")){
			Map<String, Object> rlt = new HashMap<String, Object>();
			int roleid = Integer.parseInt(playerId);
			int num = Integer.parseInt(String.valueOf(params.get("num")));
			String friends = this.getGameRoleService().findRoleById(roleid).getFriends();
			JSONArray roleinfo = JSONArray.fromObject(friends);

			if(roleinfo.size()>0){
				for(int i=0;i<roleinfo.size();i++){
					if(num==roleinfo.getInt(i)){
						//已领取
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
						ServerHandler.sendData(session, respMap);
						return;
					}
				}
				//判断是否邀请了num个好友
				int nums = 0;
				String ids = this.getGameRoleService().findRoleById(roleid).getIds();
				if(!"null".equals(String.valueOf(ids))){//
					
					JSONArray ids2 = JSONArray.fromObject(ids);
					
					Set set = new HashSet();
					for(int k=0;k<ids2.size();k++){
						set.add(ids2.get(k));
					}
					ids2.clear();
					Iterator it = set.iterator();
					while(it.hasNext()){
						ids2.add(it.next());
					}
					
					int size=ids2.size();
					for(int i=0;i<size;i++){
						int frid=ids2.getInt(i);
						GameRoleDetail gr=this.getGameRoleService().findRoleById(frid);
					if(gr==null){
						continue;
					}
					
						int level = gr.getLevel();
						if(level>=0){//邀请成功条件设置为被邀请玩家达到1级
							nums++;
						}
					}
					//System.out.println("前端传来num=="+num+"所有好友nums==="+nums);
					//nums = ary.size();
				}
				JSONArray list = new JSONArray();
				if(nums>=num){

					if(num==1){
						this.getGameRoleService().addRoleYin(roleid, 10000);
						getLiveItem(roleid, 228, 1, 5, list);
					}else if(num==2){
						this.getGameRoleService().addRoleYin(roleid, 10000);
						getLiveItem(roleid, 229,1, 5, list);
					}else if(num==3){
						this.getGameRoleService().addRoleYin(roleid, 30000);
						getLiveItem(roleid,230, 1, 5, list);
					}else if(num==5){
						this.getGameRoleService().addRoleYin(roleid, 30000);
						getLiveItem(roleid,231, 1, 5, list);
					}else if(num==7){
						this.getGameRoleService().addRoleYin(roleid, 50000);
						getLiveItem(roleid,232, 1, 5, list);
					}else if(num==9){
						this.getGameRoleService().addRoleYin(roleid, 100000);
						getLiveItem(roleid,233, 1, 5, list);
					}else if(num==11){
						this.getGameRoleService().addRoleYin(roleid, 150000);
						getLiveItem(roleid,234, 1, 5, list);
					}else if(num==14){
						this.getGameRoleService().addRoleYin(roleid, 200000);
						getLiveItem(roleid,235, 1, 5, list);
					}else if(num==17){
						this.getGameRoleService().addRoleYin(roleid, 250000);
						getLiveItem(roleid,236, 1, 5, list);
					}else if(num==20){
						this.getGameRoleService().addRoleYin(roleid, 300000);
						getLiveItem(roleid,237, 1, 5, list);
					}
					rlt.put("coin", this.getGameRoleService().findRoleById(roleid).getYin());
					rlt.put("reward", list);
					//标记已领取
					roleinfo.add(num);
					Map<String, Object> param = new HashMap<String, Object>();
					param.put("id", roleid);
					param.put("friends", roleinfo.toString());
					this.getGameRoleService().updateRoleVip(param);
				
				}else{//邀请好友不足
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
					ServerHandler.sendData(session, respMap);
					return;
				}
			}else{//一次都没有领取
				//判断是否邀请了num个好友
				int nums = 0;
				String ids = this.getGameRoleService().findRoleById(roleid).getIds();
				if(!"null".equals(String.valueOf(ids))){//
					JSONArray ids2 = JSONArray.fromObject(ids);
					int size=ids2.size();
					for(int i=0;i<size;i++){
						int frid=ids2.getInt(i);
						GameRoleDetail gd= this.getGameRoleService().findRoleById2(frid);
						if(gd==null){
							continue;
						}
						int level =gd.getLevel();
						gd=null;
						
						if(level>=0){//邀请成功条件设置为被邀请玩家达到10级
							nums++;
						}
					}
				}
				JSONArray list = new JSONArray();
				if(nums>=num){

					if(num==1){
						this.getGameRoleService().addRoleYin(roleid, 10000);
						getLiveItem(roleid, 228, 1, 5, list);
					}else if(num==2){
						this.getGameRoleService().addRoleYin(roleid, 10000);
						getLiveItem(roleid, 229,1, 5, list);
					}else if(num==3){
						this.getGameRoleService().addRoleYin(roleid, 30000);
						getLiveItem(roleid,230, 1, 5, list);
					}else if(num==5){
						this.getGameRoleService().addRoleYin(roleid, 30000);
						getLiveItem(roleid,231, 1, 5, list);
					}else if(num==7){
						this.getGameRoleService().addRoleYin(roleid, 50000);
						getLiveItem(roleid,232, 1, 5, list);
					}else if(num==9){
						this.getGameRoleService().addRoleYin(roleid, 100000);
						getLiveItem(roleid,233, 1, 5, list);
					}else if(num==11){
						this.getGameRoleService().addRoleYin(roleid, 150000);
						getLiveItem(roleid,234, 1, 5, list);
					}else if(num==14){
						this.getGameRoleService().addRoleYin(roleid, 200000);
						getLiveItem(roleid,235, 1, 5, list);
					}else if(num==17){
						this.getGameRoleService().addRoleYin(roleid, 250000);
						getLiveItem(roleid,236, 1, 5, list);
					}else if(num==20){
						this.getGameRoleService().addRoleYin(roleid, 300000);
						getLiveItem(roleid,237, 1, 5, list);
					}
					rlt.put("coin", this.getGameRoleService().findRoleById(roleid).getYin());
					rlt.put("reward", list);
					//标记已领取
					roleinfo.add(num);
					Map<String, Object> param = new HashMap<String, Object>();
					param.put("id", roleid);
					param.put("friends", roleinfo.toString());
					this.getGameRoleService().updateRoleVip(param);
				
				}else{//邀请好友不足
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
					ServerHandler.sendData(session, respMap);
					return;
				}
			}
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
					rlt);
			ServerHandler.sendData(session, respMap);
			rlt=null;
			
		}
	
		
	}

	private void attacktwo() {//和好友对战
		//System.out.println("好友争霸战开始" +  Integer.parseInt(playerId));
		if (params.containsKey("id")&&params.containsKey("t")) {
			int id = Integer.parseInt(String.valueOf(params.get("id")));
			int t = Integer.parseInt(String.valueOf(params.get("t")));
			int roleid = Integer.parseInt(playerId);
			Map<String, Object> rlt = new HashMap<String, Object>();
			Map<String, Object> param = new HashMap<String, Object>();
			// 消耗一个挑战令
			JsonSerializer json1 = new JsonSerializer();
			GameRoleDetail gamerole = this.getGameRoleService().findRoleById3(roleid);
			String totem=gamerole.getTotem();
			List litotem;
			litotem=(List) json1.deserialize(totem);
			GameRoleDetail gamerolee = this.getGameRoleService().findRoleById3(id);
			String totem2=gamerolee.getTotem();
			List litotem2;
			litotem2=(List) json1.deserialize(totem2);
			rlt.put("totem",litotem2);
			int vip = gamerole.getVip();
			int hitlevel=gamerole.getLevel();
			int beihitlevel=gamerolee.getLevel();
			if(hitlevel<8){//自己是新手
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);
				ServerHandler.sendData(session, respMap);
				return;
			}else if(beihitlevel<8){//好友是新手
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
				ServerHandler.sendData(session, respMap);
				return;
			}
				//黄钻享受vip2待遇
				if(vip<2){
					int huangzuan = 0;
					JsonSerializer json = new JsonSerializer();
					String Huangzuaninfo = gamerole.getHuangzuaninfo();
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
						vip =2;
					}
				}
				//开始战斗
				JSONArray list1 = new JSONArray();//本家
				JSONArray list2 = new JSONArray();//对手mids
				JSONArray list3 = new JSONArray();//对手总攻击
				JSONArray list02 = new JSONArray();//自己mids
				JSONArray list03 = new JSONArray();//自己总攻击
				JSONArray list = new JSONArray();
				Map<String,Object> map = new HashMap<String,Object>();
				param.clear();
				param.put("roleid", roleid);
				List<RoleChallengeDetail> rolechallenge = this.getRoleChallengeService().findRoleChallengeById(param);
				if (!rolechallenge.isEmpty()) {//获得自己
					//判断出战武将是否为空
					JsonSerializer json = new JsonSerializer();
					List mids = (List) json.deserialize(rolechallenge.get(0).getMilitaryid());
					if(mids.isEmpty()){//随机选取一定武将，放入rolechallenge
						param.clear();
						param.put("roleId", roleid);
						List<RoleMilitaryDetail> roe = this.getRoleMilitaryService().getRoleMilitaryByparam(param);
						if(roe.isEmpty()){
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-5);
							ServerHandler.sendData(session, respMap);
							return;
						}
						//根据等级出战数量
						List ary = new ArrayList();
						int num=0;//出战武将数
						if(gamerole.getLevel()<=10){
							num = 3;
						}else if(gamerole.getLevel()>10 && gamerole.getLevel()<=15){
							num = 6;
						}else if(gamerole.getLevel()>15){
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
						this.militaryDetail(ary,roleid, list1,litotem);
						rlt.put("mid", ary);
						roe=null;
						ary=null;
					}else{
						this.militaryDetail(mids,roleid, list1,litotem);// 获得武将列表信息
					rlt.put("mid",mids);
					}
					mids=null;
				} else {// 用户不存在
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);
					ServerHandler.sendData(session, respMap);
					return;
				}
				List url= new ArrayList();//头像地址
				//获取自己头像
				String Huangzuaninfo = gamerole.getHuangzuaninfo();
				if("null".equals(String.valueOf(Huangzuaninfo))){
					url.add("http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
				}else{
					JsonSerializer json = new JsonSerializer();
					List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json.deserialize(Huangzuaninfo);
					url.add(roleinfo.get(0).get("figureurl"));
					roleinfo=null;
				}
				if(t==1){//和游戏玩家战斗
					//获取玩家头像url
					String huangzuangift = gamerolee.getHuangzuaninfo();
					if("null".equals(String.valueOf(huangzuangift))){
						url.add("http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
					}else{
						JsonSerializer json = new JsonSerializer();
						List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
								.deserialize(huangzuangift);
						url.add(roleinfo.get(0).get("figureurl"));
						roleinfo=null;
					}
					// 获得对手信息
					param.clear();
					param.put("roleid", id);
					List<RoleChallengeDetail> foe = this.getRoleChallengeService().findRoleChallengeById(param);
					if (!foe.isEmpty()) {
						JsonSerializer json = new JsonSerializer();
						List mids = (List) json.deserialize(foe.get(0).getMilitaryid());
						if(mids.isEmpty()){//随机选取一定武将，放入rolechallenge
							param.clear();
							param.put("roleId", id);
							List<RoleMilitaryDetail> roe = this.getRoleMilitaryService().getRoleMilitaryByparam(param);
							if(roe.isEmpty()){
								respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-5);
								ServerHandler.sendData(session, respMap);
								return;
							}
							//根据等级出战数量
							List ary = new ArrayList();
							int num=0;//出战武将数
							//int level = this.getGameRoleService().findRoleById(id).getLevel();
							int level = gamerolee.getLevel();
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
							this.militaryDetail(ary,id, list3,litotem2);
							this.foeMilitary(ary,id, list2,litotem2);
							roe=null;
							ary=null;
						}else{
							this.militaryDetail(mids,id, list3,litotem2);// 获得武将列表信息
							this.foeMilitary(mids,id, list2,litotem2);
						}
						map.clear();
						map.put("mids", list2);
						int success = foe.get(0).getSuccess();
						int total = foe.get(0).getTotals();
						if(total==0){
							map.put("percent", 100);
						}else{
							map.put("percent", success*100/total);
						}
						mids=null;
					} else {// 对手不存在
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);
						ServerHandler.sendData(session, respMap);
						return;
					}
					map.put("level", gamerolee.getLevel());
					map.put("name", gamerolee.getName());
					rlt.put("foe", map);
					// 开始攻击
					if(list1.size()>list3.size()){//最大回合数
						int size1 = list1.size();
						for(int i=0;i<50;i++){
							if(list1.isEmpty() || list3.isEmpty()){
								break;
							}
							faight(list1, list3, list,roleid,id);
						}
					}else{
						int size3 = list3.size();
						for(int i=0;i<50;i++){
							if(list1.isEmpty() || list3.isEmpty()){
								break;
							}
							faight(list1, list3, list,roleid,id);
						}
					}
					//判断谁胜利了
					int success = rolechallenge.get(0).getSuccess();
					int total = rolechallenge.get(0).getTotals();
					if(list1.isEmpty()){
						rlt.put("win", id);//对手胜利
						param.clear();
						param.put("roleid", roleid);
						param.put("totals", (total+1));
						param.put("win", 0);
						this.getRoleChallengeService().updateRoleChallenge(param);
						rlt.put("percent", (success*100/(total+1)));
						//更新胜率........
					}else if(list3.isEmpty()){
						rlt.put("win", roleid);//本家胜利
						param.clear();
						param.put("roleid", roleid);
						param.put("success", (success+1));
						param.put("totals", (total+1));
						param.put("win", 1);
						this.getRoleChallengeService().updateRoleChallenge(param);
						rlt.put("percent", ((success+1)*100/(total+1)));
					}
					rlt.put("list", list);
					foe=null;
				}
				//领取奖励
				rlt.put("url", url);//url数组，第一个是自己，第二个是别人
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
				//把战斗记录存放到表里
				list1=null;
				list2=null;
				list3=null;
				list=null;
				rlt=null;
				param=null;
				url=null;
				map=null;
				rolechallenge=null;
		}
	}

	private void challengerecord() {//被虐记录回放
		if(params.containsKey("page")){
			int page;
			page = Integer.parseInt(String.valueOf(params.get("page")));
			int beihitid=Integer.parseInt(playerId);
			Map<String,Object> param = new HashMap<String,Object>();
			Map<String, Object> map = new HashMap<String, Object>();
			JSONArray roleMilitaryMap = new JSONArray();
			Map<String, Object> rlt = new HashMap<String, Object>();
			int totalRows;
			param.clear();
			param.put("beihitid",beihitid);
			List<ChallengeRecordDetail> crd=this.getChallengeRecordService().findallchallenge(param);
			totalRows=crd.size();
			if(totalRows>20){
				totalRows=20;
			}
			int maxpage;
			if(totalRows == 0){
				maxpage= 1;//没有记录认为1页
			}else if(totalRows%4 == 0){
				maxpage= totalRows/4;
			}else{
				maxpage=totalRows/4+1;
			}
			if(maxpage<page){//传过来的页数大于最大页数，给前端返回错误信息，不向下执行
				page=maxpage;	
			}if(page<1){
				page=1;
			}
			int page2=(page-1)*4;
			param.clear();
			param.put("beihitid",beihitid);
			param.put("page",page2);
			param.put("size",4);
			long time1=System.currentTimeMillis();
			List<ChallengeRecordDetail> crds=this.getChallengeRecordService().findBychallengetime(param);
			int size=crds.size();
			for(int i=0;i<size;i++){
				int hitid=crds.get(i).getHitid();
				int beidaid=crds.get(i).getBeihitid();
				String time=crds.get(i).getTime();
				String record=crds.get(i).getRecord();
				String midslist1=crds.get(i).getHitmids();
				String midslist2=crds.get(i).getMids();
				int winid=crds.get(i).getWinid();
				String hitname=crds.get(i).getHitname();
				String beihitname=crds.get(i).getBeihitname();
				String hiturl=crds.get(i).getHittoux();
				String beihitrul=crds.get(i).getBeihittoux();
				int hitrate=crds.get(i).getHitrate();
				int beihitrate=crds.get(i).getBeihitrate();
				int hitlevel=crds.get(i).getHitlevel();
				int beihitlevel=crds.get(i).getBeihitlevel();
				String totem= crds.get(i).getTotem();
				String totemtwo= crds.get(i).getTotemtwo();
				map.put("hitid",hitid);
				map.put("beidaid",beidaid);
				map.put("hitname",hitname);
				map.put("beihitname",beihitname);
				map.put("time",time);
				map.put("winid",winid);
	            map.put("hitrate",hitrate);
				map.put("beihitrate",beihitrate);
				map.put("hiturl",hiturl);
				map.put("beihiturl",beihitrul);
				map.put("hitlevel",hitlevel);
	            map.put("beihitlevel",beihitlevel);
	            map.put("list",record);
				map.put("list1",midslist1);//hit魔将
				map.put("list2",midslist2);//被hit魔将
				JsonSerializer json1 = new JsonSerializer();
				List litotem=(List) json1.deserialize(totem);
				List litotemtwo=(List) json1.deserialize(totemtwo);
				map.put("totem",litotem);
				map.put("totemtwo",litotemtwo);
				roleMilitaryMap.add(map);
				map.clear();
			}
			rlt.put("back",roleMilitaryMap);
			rlt.put("page",page);
			rlt.put("maxpage",maxpage);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
			rlt.clear();
		}
	}

	
	
	
	
	
	
	
	
	
	
	private void openhuangzuan() {
		int roleid = Integer.parseInt(playerId);
		Map<String,Object> rlt = new HashMap<String,Object>();
		Map<String,Object> param = new HashMap<String,Object>();
		GameRoleDetail gameRole = this.getGameRoleService().findRoleById(roleid);
		
		int huangzuan = 0;
		
		//添加黄钻信息
		JsonSerializer json = new JsonSerializer();
		String Huangzuaninfo = gameRole.getHuangzuaninfo();
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
			//判断是否是新的一天
			long nowtime = new Date().getTime();
			int day = (int) ((nowtime - gameRole.getTasktime()) / 1000 / 60 / 60 / 24 + 1);
			int roleday = gameRole.getDay();
			if (day > roleday) {// 新的一天，dailynum应设为0，day增加1，今天还没有领取礼包
				if(day>this.getRoleTaskService().findRoleTask(roleid).get(0).getDay()){
					param.clear();
					param.put("roleId", roleid);
					param.put("dailynum", 0);
					param.put("day", day);
					param.put("status", 1);
					this.getRoleTaskService().updateRoleTasknumday(param);
				}
				
				// 恢复妖牌为0

				//标记今天上线，将今天的放到昨天
				JSONArray ary = new JSONArray();
				Map<String, Object> pp = new HashMap<String, Object>();
				pp.put("day", day);
				ary.add(pp);
				param.clear();
				param.put("id", roleid);
				param.put("day", day);
				param.put("num", 0);
				param.put("yesterday", gameRole.getToday());
				param.put("today", ary.toString());
				param.put("live", 0);//好友活跃度奖励
				param.put("huangzuangift", 0);//黄钻礼包
				param.put("jingji", 10);
				param.put("jjnum", 0);
//				param.put("jjstatus", 1);
				this.getGameRoleService().updateRoleVip(param);
				this.getplayerHandler().updateActivity(roleid);//更新每日任务
				pp=null;
				rlt.put("t", 0);
			}else{
				rlt.put("t", gameRole.getHuangzuangift());
			}
		}else{
			rlt.put("t", 1);
		}
		
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
		ServerHandler.sendData(session, respMap);
		rlt=null;
		param=null;
		gameRole=null;
	}

	private void rezhandou() {
		if(params.containsKey("junling")&&params.containsKey("mapid")&&params.containsKey("placeid")){
			int junling = Integer.parseInt(String.valueOf(params.get("junling")));
			int addjl=junling;
			int mapid = Integer.parseInt(String.valueOf(params.get("mapid")));
			int placeid = Integer.parseInt(String.valueOf(params.get("placeid")));
			int roleid = Integer.parseInt(playerId);
			Map<String,Object> rlt = new HashMap<String,Object>();
			Map<String,Object> param = new HashMap<String,Object>();
			Map<String, Object> mapitems = new HashMap<String, Object>();
			GameRoleDetail gameRole = this.getGameRoleService().findRoleById(roleid);
			int rlevel = gameRole.getLevel();
			int rjunling = gameRole.getJunling();
			int yin = gameRole.getYin();
			int gongxun = gameRole.getGongxun();
			int rmapid = gameRole.getMapid();
			int rplaceid = gameRole.getPlaceid();
			int exp = gameRole.getExp();
			int vip = gameRole.getVip();
			JSONArray itemlist = new JSONArray();
			
			/****/
			if(rlevel<25){//玩家等级小于25级不能开启
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-10);
				ServerHandler.sendData(session, respMap);
				return;
			}
			//更新每日任务
//			long nowtime = System.currentTimeMillis();
//			int day = (int) ((nowtime - gameRole.getTasktime()) / 1000 / 60 / 60/24 + 1);
//			RoleDaytaskDetail roledaytask = this.getRoleDaytaskService().findRoleDaytaskByRId(roleid);
//			if(roledaytask.getDay()<day){
//				this.getplayerHandler().dayTask(roleid, day);
//			}
//			roledaytask = null;
			
			long nowtime = System.currentTimeMillis();
			int day = (int) ((nowtime - gameRole.getTasktime()) / 1000 / 60 / 60/24 + 1);
			RoleDaytaskDetail roledaytask = this.getRoleDaytaskService().findRoleDaytaskByRId(roleid);
			if(roledaytask.getDay()<day){
				this.getplayerHandler().dayTask(roleid, day);
			}
			roledaytask = null;
			/****/
			
			// 升级所需经验
			int needexp = this.getGameLevelService().getGameLevelByRoleLevel(rlevel).getNeedexp();
			int upplevel = 0;// 是否升级
			//本次获得的经验
			int mapyin =0;
			int mapgongxun=0;
			int mapexp=0;
			//判断军令是否足够
			if(rjunling>=junling&&rjunling>0){
				
				//黄钻享受vip2待遇
				if(vip<2){
					int huangzuan = 0;
					JsonSerializer json = new JsonSerializer();
					String Huangzuaninfo = gameRole.getHuangzuaninfo();
					if(!"null".equals(String.valueOf(Huangzuaninfo))){

						List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
						.deserialize(Huangzuaninfo);
						int ret = Integer.parseInt(String.valueOf(roleinfo.get(0).get("ret")));
						if(ret==0){
							huangzuan = Integer.parseInt(String.valueOf(roleinfo.get(0).get("is_yellow_vip")));
						}
						roleinfo=null;
					}
					if(huangzuan==1){
						vip =2;
					}
					json=null;
				}
				
				int jlnum = this.getGameVipService().getGameVipByLe(vip).get(0).getJunlingTop();
				//军令=15时，开始没小时增加一个军令倒计时
				
				if((rjunling-junling)<=jlnum){
					this.getGameRoleService().addRolejunlingtime(roleid, System.currentTimeMillis());
				}
				
				if(rmapid>=mapid){
					if(rmapid==mapid){//最大地图战斗
						if(rplaceid>=placeid){
							//可以战斗
							// 地图存在
							List<GameMapDetail> map = this.getGameMapService().findGameMapByid(mapid);
							if(map.isEmpty()){
								return;
							}
							//减少军令
							this.getGameRoleService().subRolejunling(roleid, junling);
							// 获得奖励：银币、功勋、经验
							
							//遍历道具
							for(int i=0;i<junling;i++){
								mapyin += (int) (map.get(0).getGetyin()*(placeid/50.0+1));
								mapgongxun += (int) (map.get(0).getGetgongxun() *(placeid/50.0+1));
								mapexp += (int) (map.get(0).getGetexp() *(placeid/50.0+1));

								// 获得随机道具
								param.clear();
								param.put("id", mapid);
								param.put("mid", placeid);
								List<GamePlatsDetail> mapitem = this.getGamePlatsService()
										.findGamePlatByparams(param);
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
										json=null;
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
											boolean boo = this.getplayerHandler().getShangxian(itemtype, type,
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
												param.put("num", num);

												if (ritem.isEmpty()) {// 道具不存在，插入
//													Long bid = this.getAutoIdService()
//															.fingKeyValueByTableName(
//																	"role_item") + 1;
													Long bid = this.getAutoIdService().fingKeyValueByTableName("role_item") + 0L;
													RoleItemDetail iDetail = new RoleItemDetail();
													iDetail.setId(bid);
													iDetail.setRoleid(roleid);
													iDetail.setItemid(id);
													iDetail.setNum(num);
													iDetail.setFlag(1);
													iDetail.setType(itemtype);
													boolean bo = this.getRoleItemService()
															.insertRoleItem(iDetail);
													//this.getAutoIdService().updateKeyValueAddOneByTableName("role_item");
												} else {// 道具存在，num+
													this.getRoleItemService()
															.addRoleItemNum(param);
												}
												ritem=null;
												param.clear();
												param.put("roleid", roleid);
												param.put("itemid", id);
												List<RoleItemDetail> item = this
														.getRoleItemService().getRoleItem(
																param);
												long bid = item.get(0).getId();
												mapitems.put("bid", bid);
												mapitems.put("id", id);
												mapitems.put("num", num);
												mapitems.put("resType", type);
												itemlist.add(mapitems);
											}
										} else if (type == 6) {// 装备
											int equiptype = this.getGameEquipService()
													.getGameEquipById(id).get(0).getType();
											boolean bo = this.getplayerHandler().getShangxian(equiptype, type,
													roleid, id, num);
											if (bo == true) {// 背包有空间，可以领取
												List<GameEquipDetail> gameequips = this
														.getGameEquipService()
														.getGameEquipByEid(id);
												GameEquipDetail gameequip = null;
												if (!gameequips.isEmpty()) {
													gameequip = gameequips.get(0);

												}

												int bid = this.getAutoIdService().fingKeyValueByTableName("role_equip");
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
												//this.getAutoIdService().updateKeyValueAddOneByTableName("role_equip");
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

												itemlist.add(mapitems);
												gameequips=null;
												eDetail=null;
											} else {// 背包格子不足
												// 奖励为空
											}
										}
										resList=null;
									} else {// 获得道具不成功
										// item为空
									}
								} else {// 道具不存在
								
								}
								mapitem=null;
							}
							param.clear();
							param.put("id", roleid);
							param.put("exp", (exp + mapexp));
							param.put("yin", (yin + mapyin));
							param.put("gongxun", (gongxun + mapgongxun));
							this.getGameRoleService().updateRoleVip(param);
							
							
							// 判断是否可以升级
							upplevel = this.getplayerHandler().shengji(roleid, rlevel, exp, mapexp);
							// 更改下次升级所需经验
							needexp = this.getGameLevelService()
									.getGameLevelByRoleLevel(this.getGameRoleService().findRoleById(roleid).getLevel()).getNeedexp();
							
							map=null;
						}else{//大于最大波数
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);
							ServerHandler.sendData(session, respMap);
							return;
						}
					}else{//不是在最大地图战斗
//......
						if(placeid<=20){//可以战斗
							//可以战斗
							// 地图存在
							List<GameMapDetail> map = this.getGameMapService().findGameMapByid(mapid);
							if(map.isEmpty()){
								return;
							}
							//减少军令
							this.getGameRoleService().subRolejunling(roleid, junling);
							// 获得奖励：银币、功勋、经验

							//遍历道具
							for(int i=0;i<junling;i++){
								mapyin += (int) (map.get(0).getGetyin()*(placeid/50.0+1));
								mapgongxun += (int) (map.get(0).getGetgongxun() *(placeid/50.0+1));
								mapexp += (int) (map.get(0).getGetexp() *(placeid/50.0+1));

								// 获得随机道具
								param.clear();
								param.put("id", mapid);
								param.put("mid", placeid);
								List<GamePlatsDetail> mapitem = this.getGamePlatsService()
										.findGamePlatByparams(param);
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
											boolean boo = this.getplayerHandler().getShangxian(itemtype, type,
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
												param.put("num", num);

												if (ritem.isEmpty()) {// 道具不存在，插入
//													int bid = this.getAutoIdService()
//															.fingKeyValueByTableName(
//																	"role_item") + 1;
													long bid = this.getAutoIdService()
													.fingKeyValueByTableName(
															"role_item") + 0L;
													RoleItemDetail iDetail = new RoleItemDetail();
													iDetail.setId(bid);
													iDetail.setRoleid(roleid);
													iDetail.setItemid(id);
													iDetail.setNum(num);
													iDetail.setFlag(1);
													iDetail.setType(itemtype);
													boolean bo = this.getRoleItemService()
															.insertRoleItem(iDetail);
//													this
//															.getAutoIdService()
//															.updateKeyValueAddOneByTableName(
//																	"role_item");
												} else {// 道具存在，num+
													this.getRoleItemService()
															.addRoleItemNum(param);
												}
												param.clear();
												param.put("roleid", roleid);
												param.put("itemid", id);
												List<RoleItemDetail> item = this
														.getRoleItemService().getRoleItem(
																param);
												long bid = item.get(0).getId();
												mapitems.put("bid", bid);
												mapitems.put("id", id);
												mapitems.put("num", num);
												mapitems.put("resType", type);
												itemlist.add(mapitems);
											}
										} else if (type == 6) {// 装备
											int equiptype = this.getGameEquipService()
													.getGameEquipById(id).get(0).getType();
											boolean bo = this.getplayerHandler().getShangxian(equiptype, type,
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
//												this.getAutoIdService()
//														.updateKeyValueAddOneByTableName(
//																"role_equip");
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

												itemlist.add(mapitems);
												eDetail=null;
											} else {// 背包格子不足
												// 奖励为空
											}
										}
										resList=null;
									} else {// 获得道具不成功
										// item为空
									}
								} else {// 道具不存在
								
								}
								mapitem=null;
							}
							param.clear();
							param.put("id", roleid);
							param.put("exp", (exp + mapexp));
							param.put("yin", (yin + mapyin));
							param.put("gongxun", (gongxun + mapgongxun));
							this.getGameRoleService().updateRoleVip(param);
							
							
							// 判断是否可以升级
							upplevel = this.getplayerHandler().shengji(roleid, rlevel, exp, mapexp);
							// 更改下次升级所需经验
							needexp = this.getGameLevelService()
									.getGameLevelByRoleLevel(this.getGameRoleService().findRoleById(roleid).getLevel()).getNeedexp();
						
							map=null;
						}else{//超出最大波数
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);
							ServerHandler.sendData(session, respMap);
							return;
						}
					}
				}else{//大于最大地图
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);
					ServerHandler.sendData(session, respMap);
					return;
				}
			}else{//军令不足
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
				ServerHandler.sendData(session, respMap);
				return;
			}
			//返回值
			gameRole = this.getGameRoleService().findRoleById(roleid);
			rlt.put("exp", gameRole.getExp());
			rlt.put("gongxun", gameRole.getGongxun());
			rlt.put("level", gameRole.getLevel());
			rlt.put("upplevel", upplevel);
			rlt.put("yin", gameRole.getYin());
			rlt.put("junling", gameRole.getJunling());
			rlt.put("needexp", needexp);
			
			param.clear();
			param.put("num", mapexp);
			param.put("flag", 3);
			itemlist.add(param);
			param.clear();
			param.put("num", mapyin);
			param.put("flag", 1);
			itemlist.add(param);
			param.clear();
			param.put("num", mapgongxun);
			param.put("flag", 4);
			itemlist.add(param);
			rlt.put("reward", itemlist);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
			ServerHandler.sendData(session, respMap);
			gameRole=null;
			rlt=null;
			param=null;
			mapitems=null;
			itemlist=null;
			
			/****/
			 Map<String, Object> pa = new HashMap<String, Object>();
			    RoleDaytaskDetail roletask = this.getRoleDaytaskService().findRoleDaytaskByRId(roleid);
			      int zhangdou=roletask.getZhangdou();
			         //int abc=zhangdou+1;
			      int abc=zhangdou+addjl;
			    pa.clear();
			    pa.put("roleid",roleid);
			    pa.put("zhangdou", abc);
			 this.getRoleDaytaskService().updateRoleDaytask(pa);
			 pa=null;
			/****/
		}
	}

	private void getItem() {
		int roleid = Integer.parseInt(playerId);
		Map<String,Object> rlt = new HashMap<String,Object>();
		int coin = this.getGameRoleService().findRoleById(roleid).getCoin();
		rlt.put("coin", coin);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);
		rlt=null;
	}

	private void goods() {
		if(params.containsKey("id")){
			int roleid = Integer.parseInt(playerId);
			int id = Integer.parseInt(String.valueOf(params.get("id")));
			Map<String,Object> rlt = new HashMap<String,Object>();
			if(id>=10000){
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
				return;
			}
			List<GameItemDetail> ritem = this.getGameItemService().getGameItemById(id);
			if(ritem.isEmpty()){
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "");
				ServerHandler.sendData(session, respMap);
				return;
			}
			int type = ritem.get(0).getItemtype();
			boolean b = this.getplayerHandler().getShangxian(type, 5, roleid, id, 1);
			//getShangxian(int type, int resType, int roleId, int id,int num)
			if(b==false){//判断背包格子是否已满
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "");
				ServerHandler.sendData(session, respMap);
				return;
			}
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
		}
	}

	private void quit() {
		int roleid = Integer.parseInt(playerId);
		Map<String,Object> rlt = new HashMap<String,Object>();
		long onlinetime = this.getGameRoleService().findRoleById(roleid).getOnlinetime();
		onlinetime = (System.currentTimeMillis()-onlinetime)/1000+(5*60);
	//	System.out.println(onlinetime+".....onlinetime");
		int level = this.getGameRoleService().findRoleById(roleid).getLevel();
		rlt.put("level", level);
		rlt.put("time", onlinetime);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);
		rlt=null;
	}

	private void share() {
		//System.out.println("MapHandler.share" + System.currentTimeMillis());
		JSONArray list = new JSONArray();
		try{
			Thread.sleep(4000);
		}catch(Exception e){
			e.printStackTrace();
		}
		int roleid = Integer.parseInt(playerId);
		Map<String,Object> rlt = new HashMap<String,Object>();
		int share = this.getGameRoleService().findRoleById(roleid).getShare();
		//System.out.println("MapHandler.share.roleid:" + roleid + " share:" + share + System.currentTimeMillis());
		if(share==0){
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
		}else{
			//判断是否是黄钻
			int huangzuan = 0;
			JsonSerializer json = new JsonSerializer();
			String Huangzuaninfo = this.getGameRoleService().findRoleById(roleid).getHuangzuaninfo();
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
				if(share==1){//新手
					this.getGameRoleService().addRoleYin(roleid, 6000);
					rlt.put("type", 1);
					rlt.put("num", 6000);
				}else if(share==2){//底10波
					this.getGameRoleService().addRoleYin(roleid, 2000);
					rlt.put("num", 6000);
					rlt.put("type", 1);
				}else if(share==3){//新地图
					getLiveItem(roleid, 1, 2, 5, list);
				}else if(share==4){//绿色魔将合成
					this.getGameRoleService().addRoleYin(roleid, 4000);
					rlt.put("num", 4000);
					rlt.put("type", 1);
				}else if(share==5){//蓝色魔将合成
					getLiveItem(roleid, 9, 6, 5, list);
				}else if(share==6){//红色魔将合成
					getLiveItem(roleid, 9, 12, 5, list);
				}else if(share==7){//人物升级11级
					this.getGameRoleService().addRoleYin(roleid, 2000);
					rlt.put("num", 2000);
					rlt.put("type", 1);
				}else if(share==8){//绿色装备合成
					this.getGameRoleService().addRoleYin(roleid, 2000);
					rlt.put("num", 2000);
					rlt.put("type", 1);
				}else if(share==9){//蓝色装备合成
					this.getGameRoleService().addRoleYin(roleid, 4000);
					rlt.put("num", 6000);
					rlt.put("type", 1);
				}else if(share==10){//职业晋级成功
					this.getGameRoleService().addRoleGongxun(roleid, 1000);
					rlt.put("num", 1000);
					rlt.put("type", 4);
				}
			}else{//不是黄钻
				if(share==1){//新手
					this.getGameRoleService().addRoleYin(roleid, 3000);
					rlt.put("num", 3000);
					rlt.put("type", 1);
				}else if(share==2){//底10波
					this.getGameRoleService().addRoleYin(roleid, 1000);
					rlt.put("num", 1000);
					rlt.put("type", 1);
				}else if(share==3){//新地图
					getLiveItem(roleid, 1, 1, 5, list);
				}else if(share==4){//绿色魔将合成
					this.getGameRoleService().addRoleYin(roleid, 2000);
					rlt.put("num", 2000);
					rlt.put("type", 1);
				}else if(share==5){//蓝色魔将合成
					getLiveItem(roleid, 9, 3, 5, list);
				}else if(share==6){//红色魔将合成
					getLiveItem(roleid, 9, 6, 5, list);
				}else if(share==7){//人物升级11级
					this.getGameRoleService().addRoleYin(roleid, 1000);
					rlt.put("num", 1000);
					rlt.put("type", 1);
				}else if(share==8){//绿色装备合成
					this.getGameRoleService().addRoleYin(roleid, 1000);
					rlt.put("num", 1000);
					rlt.put("type", 1);
				}else if(share==9){//蓝色装备合成
					this.getGameRoleService().addRoleYin(roleid, 2000);
					rlt.put("num", 2000);
					rlt.put("type", 1);
				}else if(share==10){//职业晋级成功
					this.getGameRoleService().addRoleGongxun(roleid, 500);
					rlt.put("num", 500);
					rlt.put("type",4);
				}
			}
			//将share=0
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("id", roleid);
			param.put("share", 0);
			this.getGameRoleService().updateRoleVip(param);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			param=null;
		}
		rlt.put("reward", list);
		rlt.put("yin", this.getGameRoleService().findRoleById(roleid).getYin());
		rlt.put("gongxun", this.getGameRoleService().findRoleById(roleid).getGongxun());
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
				rlt);
		ServerHandler.sendData(session, respMap);
		rlt=null;
		
	}

	private void gohome() {
		int roleid = Integer.parseInt(playerId);
		
		int map = this.getGameRoleService().findRoleById(roleid).getMapid2();
		int place = this.getGameRoleService().findRoleById(roleid).getPlaceid2();
		Map<String, Object> rlt = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> mapplace = new HashMap<String, Object>();
		JSONArray placelist = new JSONArray();
		// 换新地图了,发送place
		// 遍历role_map，发送place
		param.clear();
		param.put("roleId", roleid);
		param.put("mapid", map);
		List<RoleMapDetail> rmap = this.getRoleMapService()
				.getRoleMapByParam(param);
		int mapid = 0;
		int placeid = 0;
		int militaryid = 0;
		int towerid = 0;
		for (int i = 0; i < rmap.size(); i++) {
			mapid = rmap.get(i).getMapid();
			placeid = rmap.get(i).getPlaceid();
			militaryid = rmap.get(i).getMilitaryid();
			towerid = rmap.get(i).getTowerid();
			mapplace.put("mapid", mapid);
			mapplace.put("militaryid", militaryid);
			mapplace.put("placeid", placeid);
			mapplace.put("towerid", towerid);
			placelist.add(mapplace);
		}
		rlt.put("place", placelist);
		rlt.put("mapid2", map);
		rlt.put("placeid2", place);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
			GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);
		mapplace=null;
		rlt=null;
		param=null;
	}

	private void gotofriend() {
		//System.out.println("MapHandler.gotoFrined:params:" + params.toString());
		if (params.containsKey("id") && params.containsKey("p")) {
			int id = Integer.parseInt(String.valueOf(params.get("id")));//好友id
			int roleid = Integer.parseInt(playerId);
			int map = 0;
			if(Integer.valueOf(String.valueOf(params.get("p"))) == 1){
				map = this.getGameRoleService().findRoleById(roleid).getMapid2();
			}else if(Integer.valueOf(String.valueOf(params.get("p"))) == 0){
				map = this.getGameRoleService().findRoleById(id).getMapid();
			}
			int place = this.getGameRoleService().findRoleById(id).getPlaceid();
			Map<String, Object> rlt = new HashMap<String, Object>();
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> mapplace = new HashMap<String, Object>();
			JSONArray placelist = new JSONArray();
			// 换新地图了,发送place
			// 遍历role_map，发送place
			param.clear();
			param.put("roleId", id);
			param.put("mapid", map);
			//System.out.println("map.gotofrine():param:" + param.toString());
			List<RoleMapDetail> rmap = this.getRoleMapService()
					.getRoleMapByParam(param);
			int mapid = 0;
			int placeid = 0;
			int militaryid = 0;
			int towerid = 0;
			int size = rmap.size();
			for (int i = 0; i < size; i++) {
				mapid = rmap.get(i).getMapid();
				placeid = rmap.get(i).getPlaceid();
				militaryid = rmap.get(i).getMilitaryid();
				towerid = rmap.get(i).getTowerid();
				mapplace.put("mapid", mapid);
				mapplace.put("militaryid", militaryid);
				mapplace.put("placeid", placeid);
				mapplace.put("towerid", towerid);
				placelist.add(mapplace);
			}
			rlt.put("p", params.get("p"));
			rlt.put("place", placelist);
			rlt.put("mapid2", map);
			rlt.put("placeid2", place);
			//System.out.println("MapHandler.gotoFrined:rlt:" + rlt.toString());
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);
		mapplace=null;
		rlt=null;
		param=null;
		rmap=null;
		placelist=null;
		}
	}

	private void openPassPlayer(){
		Map<String, Object> rlt = new HashMap<String, Object>();
		int roleid = Integer.parseInt(playerId);
		JSONArray list = new JSONArray();
		JsonSerializer json = new JsonSerializer();
		Map<String, Object> map = new HashMap<String, Object>();
		GameRoleDetail grole = this.getGameRoleService().findRoleById(roleid);
		int mapid2 = grole.getMapid2();
		List<Integer> plist = new ArrayList<Integer>();
		List<Integer> plist1 = new ArrayList<Integer>();
		Iterator it = GlobalDatat.pMap.keySet().iterator();
		while(it.hasNext()){
			int id = (Integer) it.next();
			if(id > mapid2){
				plist.addAll(GlobalDatat.pMap.get(id));
			}
		}
		for(int i=0;i<plist.size();i++){
			int id = plist.get(i);
			GameRoleDetail rol = this.getGameRoleService().findRoleById(id);
			if(grole.getServerId().equals(rol.getServerId())){
				plist1.add(id);
			}
		}
		plist=plist1;
		Random r = new Random();
		List<Integer> rl = new ArrayList<Integer>();
		int f = 0;
		if(plist.size() > 10){
			f = plist.size();
		}
		if(f != 0){
			for(int i = 0; i < 6; i++){
				int id = plist.get(r.nextInt(f));
				if(!rl.contains(id)){
					rl.add(id);
				}
			}
			plist = rl;
		}
	//	System.out.println("plist:" + plist.toString());
		if(plist.size() != 0){
			for(int i=0;i<plist.size();i++){
					int id = plist.get(i);
					//判断id是否存在
					GameRoleDetail rol = this.getGameRoleService().findRoleById(id);
					if(rol!=null){
						String huangzuaninfo = rol.getHuangzuaninfo();
						if(!"null".equals(String.valueOf(huangzuaninfo))){
							List<Map<String, Object>> roleinfo2 = (List<Map<String, Object>>) json
							.deserialize(huangzuaninfo);
							map.clear();
							map.put("url", roleinfo2.get(0).get("figureurl"));
							map.put("id", id);
							
						}else{
							map.clear();
							map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
							map.put("id", id);
						}
						map.put("name", rol.getName());
						map.put("level", rol.getLevel());
						list.add(map);
						map.clear();
					}
			}
			rlt.put("ids", list);
		}else{
			rlt.put("ids", list);
		}
		//自己的信息
		String Huangzuaninfo = this.getGameRoleService().findRoleById(roleid).getHuangzuaninfo();
		if("null".equals(String.valueOf(Huangzuaninfo))){
			rlt.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
		}else{
			List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
			.deserialize(Huangzuaninfo.toString());
			rlt.put("url", roleinfo.get(0).get("figureurl"));
		}
		rlt.put("name", this.getGameRoleService().findRoleById(roleid).getName());
		rlt.put("level", this.getGameRoleService().findRoleById(roleid).getLevel());
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
				rlt);
		ServerHandler.sendData(session, respMap);
		rlt=null;
		map=null;
	
	}
	
	private void getallfriends() {
		//System.out.println("打开好友界面===============================");
		Map<String, Object> rlt = new HashMap<String, Object>();
		int roleid = Integer.parseInt(playerId);
		GameRoleDetail role = this.getGameRoleService().findRoleById(roleid);
		GameRoleDetail list3 = this.getGameRoleService().findRoleById(roleid);
		String serverid = list3.getServerId();
		JSONArray list = new JSONArray();
		JsonSerializer jsont = new JsonSerializer();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MemberDetail> openids = this.getMemberService().findMemberByid(roleid);
		Map<String, String> friend = new HashMap<String, String>();
		if(role.getStsfriend() == null || role.getStsfriend().toString().length() < 3){
			friend = null;
		}else{
			friend = (Map<String, String>) jsont.deserialize(role.getStsfriend(), Map.class);
		}
		if(!"null".equals(String.valueOf(openids.get(0).getAllfriends()))){
			List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) jsont.deserialize(openids.get(0).getAllfriends());
			for(int i=0;i<roleinfo.size();i++){
				String openid = String.valueOf(roleinfo.get(i).get("openid"));
				List<MemberDetail> list2 = this.getMemberService().findMemberByOpenid(openid);
				if(!list2.isEmpty()){
					for(int u = 0; u < list2.size(); u++){
						int id = list2.get(u).getId();
						//判断id是否存在
						GameRoleDetail rol = this.getGameRoleService().findRoleById(id);
						if(rol!=null){
							if(rol.getServerId().equals(role.getServerId())){
								String huangzuaninfo = rol.getHuangzuaninfo();
								if(!"null".equals(String.valueOf(huangzuaninfo))){
									List<Map<String, Object>> roleinfo2 = (List<Map<String, Object>>) jsont
									.deserialize(huangzuaninfo);
									map.clear();
//									map.put("name", this.getGameRoleService().findRoleById(id).getName());
									map.put("url", roleinfo2.get(0).get("figureurl"));
//									map.put("level", this.getGameRoleService().findRoleById(id).getLevel());
									map.put("id", id);
									
								}else{
									map.clear();
//									map.put("name", "");
									map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
//									map.put("level", this.getGameRoleService().findRoleById(id).getLevel());
									map.put("id", id);
									
								}
								if(friend != null){
									if(friend.containsKey(String.valueOf(id))){
										map.put("statue", String.valueOf(friend.get(String.valueOf(id))));
									}
								}
								map.put("name", rol.getName());
								map.put("level", rol.getLevel());
								list.add(map);
								map.clear();
							}
							
						}
					}
					
				}
			}
			rlt.put("ids", list);
		}else{
			rlt.put("ids", list);
		}
		//自己的信息
		JsonSerializer json = new JsonSerializer();
		String Huangzuaninfo = this.getGameRoleService().findRoleById(roleid).getHuangzuaninfo();
		if("null".equals(String.valueOf(Huangzuaninfo))){
//			rlt.put("name", "");
			rlt.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
		}else{
			List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
			.deserialize(Huangzuaninfo.toString());
//			rlt.put("name", this.getGameRoleService().findRoleById(roleid).getName());
			rlt.put("url", roleinfo.get(0).get("figureurl"));
		}
		//System.out.println("this.getMemberService().findMemberByid(roleid)"+this.getMemberService().findMemberByid(roleid));
		//System.out.println("this.getMemberService().findMemberByid(roleid)"+this.getMemberService().findMemberByid(roleid));
		List<MemberDetail> lists = this.getMemberService().findMemberByid(roleid);
		int joingroup = 0;//joingroup 是否加群了，加群为1，没加群为0
		String Allgroupfriends = lists.get(0).getAllgroupfriends();
		//System.out.println("Allgroupfriends:::"+Allgroupfriends);
		//System.out.println("Allgroupfriends:::"+Allgroupfriends);
		if(Allgroupfriends!=null){
			joingroup=1;
			GameRoleDetail grl = this.getGameRoleService().findRoleById(roleid);
			int jiaqunlingjiang = grl.getJiaqunlingjiang();
			if(jiaqunlingjiang==0){
				grl.setJiaqunlingjiang(1);
				 this.getGameRoleService().updateRole(grl);
			}
			int Groupactive = grl.getGroupactive();
			if(Groupactive==0){
				grl.setGroupactive(1);
				 this.getGameRoleService().updateRole(grl);
			}
		}
		rlt.put("joingroup", joingroup);
		rlt.put("name", this.getGameRoleService().findRoleById(roleid).getName());
		rlt.put("level", this.getGameRoleService().findRoleById(roleid).getLevel());
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);
		rlt=null;
		map=null;
	}

	private void getgroupfriends() {
//		System.out.println("getgroupfriends()");
//		System.out.println("打开群好友界面===============================");
//			if (params.containsKey("groupinfo")) {
			int roleid = Integer.parseInt(playerId);
			List<MemberDetail> openids = this.getMemberService().findMemberByid(roleid);
			String groupinfo = openids.get(0).getAllgroupfriends();
			JSONArray list1 = new JSONArray();
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> rlt = new HashMap<String, Object>();
			GameRoleDetail grd = this.getGameRoleService().findRoleById(roleid);
			int jiaqunlingjiang = grd.getJiaqunlingjiang();
			GameRoleDetail role = this.getGameRoleService().findRoleById(roleid);
			JsonSerializer jsont = new JsonSerializer();
			Map<String, String> friend = new HashMap<String, String>();
			if(role.getStsfriend() == null || role.getStsfriend().toString().length() < 3){
				friend = null;
			}else{
				friend = (Map<String, String>) jsont.deserialize(role.getStsfriend(), Map.class);
			}
//			System.out.println("GlobalDatat.grouplist.get(roleid1)::::::"+GlobalDatat.grouplist.get(roleid1));
			if(GlobalDatat.grouplist.get(roleid)==null||GlobalDatat.grouplist.get(roleid).isEmpty()){
//				System.out.println("groupinfo::"+groupinfo);
			if(groupinfo!=null){
//				System.out.println("没读缓存");
//			String groupinfo = String.valueOf(params.get("groupinfo"));
			String groupopenid = groupinfo.subSequence(0, 32).toString();
			String groupinfo1 = groupinfo.substring(32);
			List<Map> resList1 = JSON.parseArray(String.valueOf("["+groupinfo1+"]"), Map.class);
			
//				System.out.println("jiaqunlingjiang:::"+jiaqunlingjiang);
				String groupopenid1 = grd.getGroupopenid();
					grd.setGroupopenid(groupopenid);
					this.getGameRoleService().updateRole(grd);
			String serverid = grd.getServerId();
//			grouppeople=0;
			for (int i = 0; i < resList1.size(); i++) {
				String openid = String.valueOf(resList1.get(i).get("openid"));
//				String name = String.valueOf(resList1.get(i).get("name"));
//				String portrait_1 = String.valueOf(resList1.get(i).get("portrait_1"));
//				map.put("openid", openid);
//				map.put("name", name);
//				map.put("url", portrait_1);
				 List<MemberDetail> list2 = this.getMemberService().findMemberByOpenid(openid);
				 if(!list2.isEmpty()){
				 for(int h = 0;h<list2.size();h++){
					 if(serverid.equals(list2.get(h).getServerId())){
						int id = list2.get(h).getId();
						GameRoleDetail rol = this.getGameRoleService().findRoleById(id);
						if(rol!=null){
							if(friend != null){
								if(friend.containsKey(String.valueOf(id))){
									map.put("statue", String.valueOf(friend.get(String.valueOf(id))));
								}
							}
								String portrait_1 = String.valueOf(resList1.get(i).get("portrait_1"));
								map.put("name", rol.getName());
								map.put("url", portrait_1);
								map.put("level", rol.getLevel());
								map.put("id", id);
								list1.add(map);
								map.clear();
								break;
							 }
						 }
				 }
			}
			}
			}
			GlobalDatat.grouplist.put(roleid, list1);//把遍历好的群好友放入缓存
	}
			List<Map> listb = JSON.parseArray(String.valueOf(GlobalDatat.grouplist.get(roleid)), Map.class);
//			JSONArray listb = new JSONArray();
//				listb = GlobalDatat.grouplist.get(roleid1);
			if(!listb.isEmpty()){
				for(int w = 0; w < listb.size(); w++){
					int roleidj = Integer.valueOf(String.valueOf(listb.get(w).get("id")));
					if(friend != null){
						if(friend.containsKey(String.valueOf(roleidj))){
							listb.get(w).put("statue", String.valueOf(friend.get(String.valueOf(roleidj))));
						}
					}
					
				}
			}
			rlt.put("jiaqun",jiaqunlingjiang);
			rlt.put("ids", listb);
//		rlt.put("name", this.getGameRoleService().findRoleById(roleid).getName());
//		rlt.put("level", this.getGameRoleService().findRoleById(roleid).getLevel());
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
				rlt);
		ServerHandler.sendData(session, respMap);
		rlt=null;
		map=null;
//			}
	}
	/**
	 * 领取加群奖励
	 */
	private void joinfriends(){
		int roleid = Integer.parseInt(playerId);
		GameRoleDetail grd = this.getGameRoleService().findRoleById(roleid);
		int jiaqunlingjiang = grd.getJiaqunlingjiang();
		if(jiaqunlingjiang==1){
			Map<String, Object> rlt = new HashMap<String, Object>();
			Map<String, Object> params = new HashMap<String, Object>();
			 List<GameItemDetail> itemList = this.getGameItemService().getGameItemById(4000);
			 if(!itemList.isEmpty()){
			 String res = itemList.get(0).getReward();
				List<Map> resList = JSON.parseArray(String.valueOf(res), Map.class);
				JSONArray list = new JSONArray();
				for (int i = 0; i < resList.size(); i++) {//3个   第二个是初级招妖令
					Map map = resList.get(i);
					int type = Integer.parseInt(String.valueOf(map.get("resType")));//5
					int id = Integer.parseInt(String.valueOf(map.get("id")));//3
					int num = Integer.parseInt(String.valueOf(map.get("num")));//3
					if (type == 5) {// 道具
						params.clear();
						params.put("roleid", roleid);
						params.put("itemid", id);
						List<RoleItemDetail> item = this.getRoleItemService().getRoleItem(params);
//						params.put("num", num);// 获得数量
//						params.put("resType", type);
						// 判断背包格子是否已满
						int itemtype = this.getGameItemService().getGameItemById(id).get(0).getItemtype();
						boolean boo = this.getplayerHandler().getShangxian(itemtype, type, roleid,id, num);
						if (boo == false) {// 背包格子不足
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -4);
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "道具空间不足");
							ServerHandler.sendData(session, respMap);
							return;
						}
						if (!item.isEmpty()) {// 已存在
							params.clear();
							params.put("roleid", roleid);
							params.put("num", num);
							params.put("itemid", id);
							boolean bo = this.getRoleItemService().addRoleItemNum(params);
							if (bo == true) {
								long bid = item.get(0).getId();
								params.clear();
								params.put("bid", bid);
								params.put("id", id);
								params.put("resType", type);
								params.put("num", num);
								list.add(params);
							} else {

							}
						} else {// 不存在，
							long bid = this.getAutoIdService().fingKeyValueByTableName("role_item");
							RoleItemDetail iDetail = new RoleItemDetail();
							iDetail.setId(bid);
							iDetail.setRoleid(roleid);
							iDetail.setItemid(id);
							iDetail.setNum(num);
							iDetail.setFlag(1);
							iDetail.setType(itemtype);
							boolean bo = this.getRoleItemService().insertRoleItem(iDetail);
							if (bo == true) {
								params.clear();
								params.put("bid", bid);
								params.put("id", id);
								params.put("resType", type);
								params.put("num", num);
								list.add(params);
							}
						}
					}
				}
//				Map<String, Object> map = new HashMap<String, Object>();
//				rlt.put("map", map);
				GameRoleDetail grl = this.getGameRoleService().findRoleById(roleid);
				grl.setJiaqunlingjiang(2);
				 this.getGameRoleService().updateRole(grl);//把加群状态改成2，标识以后不会弹出领奖窗口
				// 奖励物品
				rlt.put("reward", list);
//				rlt.put("t", 1);
				//System.out.println("mapHandler.rlt:" + rlt.toString());
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
			}
	   }else if (jiaqunlingjiang==2){//表示已经领取过奖励
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
		ServerHandler.sendData(session, respMap);
		return;
	}else{//表示没有加群
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
		ServerHandler.sendData(session, respMap);
		return;
	}
	}
	/**
	 * 领取群活跃奖励
	 */
	private void friendactive(){
		Map<String, Object> rlt = new HashMap<String, Object>();
		//领取加群活跃奖励
		//int roleid = Integer.parseInt(playerId);
		int roleid = Integer.parseInt(playerId);
		GameRoleDetail grd = this.getGameRoleService().findRoleById(roleid);
		int getGroupactive = grd.getGroupactive();
		if(getGroupactive==1){
//			if(grouppeople>=grouppeople1){
//				if(groupactivetotal>=grouppeople*6/10){
			//Map<String, Object> rlt = new HashMap<String, Object>();
			Map<String, Object> params = new HashMap<String, Object>();
			 List<GameItemDetail> itemList = this.getGameItemService().getGameItemById(4001);
			 if(!itemList.isEmpty()){
			 String res = itemList.get(0).getReward();
//			 List<Map> resList = JSONArray.fromObject(itemList.get(0).getReward());
				List<Map> resList = JSON.parseArray(String.valueOf(res), Map.class);//size 为3
				JSONArray list = new JSONArray();
				for (int i = 0; i < resList.size(); i++) {//3个   第二个是初级招妖令
					Map map = resList.get(i);
					int type = Integer.parseInt(String.valueOf(map.get("resType")));//5
					int id = Integer.parseInt(String.valueOf(map.get("id")));//3
					int num = Integer.parseInt(String.valueOf(map.get("num")));//3
					if (type == 5) {// 道具
						params.clear();
						params.put("roleid", roleid);
						params.put("itemid", id);
						List<RoleItemDetail> item = this.getRoleItemService().getRoleItem(params);
//						params.put("num", num);// 获得数量
//						params.put("resType", type);
						// 判断背包格子是否已满
						int itemtype = this.getGameItemService().getGameItemById(id).get(0).getItemtype();
						boolean boo = this.getplayerHandler().getShangxian(itemtype, type, roleid,id, num);
						if (boo == false) {// 背包格子不足
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -4);
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "道具空间不足");
							ServerHandler.sendData(session, respMap);
							return;
						}
						if (!item.isEmpty()) {// 已存在
							params.clear();
							params.put("roleid", roleid);
							params.put("id", item.get(0).getId());
							params.put("itemid", id);
							params.put("num", num);
							params.put("itemid", id);
							boolean bo = this.getRoleItemService().addRoleItemNum(params);
							if (bo == true) {
								long bid = item.get(0).getId();
								params.clear();
								params.put("bid", bid);
								params.put("id", id);
								params.put("resType", type);
								params.put("num", num);
								list.add(params);
							} else {

							}
						} else {// 不存在，
							long bid = this.getAutoIdService().fingKeyValueByTableName("role_item");
							RoleItemDetail iDetail = new RoleItemDetail();
							iDetail.setId(bid);
							iDetail.setRoleid(roleid);
							iDetail.setItemid(id);
							iDetail.setNum(num);
							iDetail.setFlag(1);
							iDetail.setType(itemtype);
							boolean bo = this.getRoleItemService().insertRoleItem(iDetail);
							if (bo == true) {
								params.clear();
								params.put("bid", bid);
								params.put("id", id);
								params.put("resType", type);
								params.put("num", num);
								list.add(params);
							}
						}
					}
				}
//				Map<String, Object> map = new HashMap<String, Object>();
//				rlt.put("map", map);
				GameRoleDetail grl = this.getGameRoleService().findRoleById(roleid);
				grl.setGroupactive(2);
				 this.getGameRoleService().updateRole(grl);//把群活跃状态改成2，表示今天已经领过
				// 奖励物品
				rlt.put("reward", list);
				//System.out.println("mapHandler.rlt:" + rlt.toString());
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
			}
//				}else{
//					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);//群活跃人数不够
//					ServerHandler.sendData(session, respMap);
//					return;
//				}
//			}else{
//				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);//群内游戏应用总数要超过20
//				ServerHandler.sendData(session, respMap);
//				return;
//			}
	   }else if (getGroupactive==2){//表示已经领取过奖励
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
		ServerHandler.sendData(session, respMap);
		return;
	}else{
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);
		ServerHandler.sendData(session, respMap);
		return;
	}
	}
	
	private void openfriends() {
		//System.out.println("打开邀请好友=============================");
		Map<String, Object> rlt = new HashMap<String, Object>();
		int roleid = Integer.parseInt(playerId);
		String ids = this.getGameRoleService().findRoleById(roleid).getIds();
		if("null".equals(String.valueOf(ids))){//
			rlt.put("num", 0);
		}else{
			JSONArray ary = JSONArray.fromObject(ids);
			//去重
			Set set = new HashSet();
			for(int i=0;i<ary.size();i++){
				set.add(ary.get(i));
			}
			rlt.put("num", set.size());
		}
		String friends = this.getGameRoleService().findRoleById(roleid).getFriends();
		List list = new ArrayList();
		JSONArray roleinfo = JSONArray.fromObject(friends);
		if(roleinfo.size()==0){
			rlt.put("receive", list);
		}else{
			if(roleinfo.size()>0){//
				for(int i=0;i<roleinfo.size();i++){
					list.add(roleinfo.get(i));
				}
				rlt.put("receive", list);
			}else{
				rlt.put("receive", list);
			}
		}
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
				rlt);
		ServerHandler.sendData(session, respMap);
		rlt=null;
	}

	private void friends() {
		if(params.containsKey("num")){
			Map<String, Object> rlt = new HashMap<String, Object>();
			int roleid = Integer.parseInt(playerId);
			int num = Integer.parseInt(String.valueOf(params.get("num")));
			String friends = this.getGameRoleService().findRoleById(roleid).getFriends();
			JSONArray roleinfo = JSONArray.fromObject(friends);
			if(roleinfo.size()>0){
				for(int i=0;i<roleinfo.size();i++){
					if(num==roleinfo.getInt(i)){
						//已领取
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
						ServerHandler.sendData(session, respMap);
						return;
				}
				}
				//判断是否邀请了num个好友
				int nums = 0;
				String ids = this.getGameRoleService().findRoleById(roleid).getIds();
				if(!"null".equals(String.valueOf(ids))){//
					JSONArray ary = JSONArray.fromObject(ids);
					nums = ary.size();
				}
				JSONArray list = new JSONArray();
				if(nums>=num){
					if(num==3){
						this.getGameRoleService().addRoleYin(roleid, 10000);
					}else if(num==7){
						this.getGameRoleService().addRoleYin(roleid, 10000);
						getLiveItem(roleid, 6, 5, 5, list);
					}else if(num==14){
						this.getGameRoleService().addRoleYin(roleid, 30000);
						getLiveItem(roleid, 9, 10, 5, list);
					}else if(num==25){
						this.getGameRoleService().addRoleYin(roleid, 30000);
						getLiveItem(roleid, 5, 1, 6, list);
					}else if(num==40){
						this.getGameRoleService().addRoleYin(roleid, 50000);
						getLiveItem(roleid, 3, 20, 5, list);
					}else if(num==60){
						this.getGameRoleService().addRoleYin(roleid, 100000);
						getLiveItem(roleid, 12, 1, 5, list);
					}else if(num==85){
						this.getGameRoleService().addRoleYin(roleid, 150000);
						getLiveItem(roleid, 9, 99, 5, list);
					}else if(num==110){
						this.getGameRoleService().addRoleYin(roleid, 200000);
						getLiveItem(roleid, 6, 1, 6, list);
					}else if(num==130){
						this.getGameRoleService().addRoleYin(roleid, 250000);
						getLiveItem(roleid, 27, 1, 6, list);
					}else if(num==150){
						this.getGameRoleService().addRoleYin(roleid, 300000);
						getLiveItem(roleid, 8, 1, 6, list);
					}
					rlt.put("coin", this.getGameRoleService().findRoleById(roleid).getYin());
					rlt.put("reward", list);
					//标记已领取
					roleinfo.add(num);
					Map<String, Object> param = new HashMap<String, Object>();
					param.put("id", roleid);
					param.put("friends", roleinfo.toString());
					this.getGameRoleService().updateRoleVip(param);
				}else{//邀请好友不足
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
					ServerHandler.sendData(session, respMap);
					return;
				}
			}else{//一次都没有领取
				//判断是否邀请了num个好友
				int nums = 0;
				String ids = this.getGameRoleService().findRoleById(roleid).getIds();
				if(!"null".equals(String.valueOf(ids))){//
					JSONArray ary = JSONArray.fromObject(ids);
					nums = ary.size();
				}
				JSONArray list = new JSONArray();
				if(nums>=num){
					if(num==3){
						this.getGameRoleService().addRoleYin(roleid, 10000);
					}else if(num==7){
						this.getGameRoleService().addRoleYin(roleid, 10000);
						getLiveItem(roleid, 6, 5, 5, list);
					}else if(num==14){
						this.getGameRoleService().addRoleYin(roleid, 30000);
						getLiveItem(roleid, 9, 10, 5, list);
					}else if(num==25){
						this.getGameRoleService().addRoleYin(roleid, 30000);
						getLiveItem(roleid, 5, 1, 6, list);
					}else if(num==40){
						this.getGameRoleService().addRoleYin(roleid, 50000);
						getLiveItem(roleid, 3, 20, 5, list);
					}else if(num==60){
						this.getGameRoleService().addRoleYin(roleid, 100000);
						getLiveItem(roleid, 12, 1, 5, list);
					}else if(num==85){
						this.getGameRoleService().addRoleYin(roleid, 1500000);
						getLiveItem(roleid, 9, 99, 5, list);
					}else if(num==110){
						this.getGameRoleService().addRoleYin(roleid, 2000000);
						getLiveItem(roleid, 6, 1, 6, list);
					}else if(num==130){
						this.getGameRoleService().addRoleYin(roleid, 2500000);
						getLiveItem(roleid, 27, 1, 6, list);
					}else if(num==150){
						this.getGameRoleService().addRoleYin(roleid, 3000000);
						getLiveItem(roleid, 8, 1, 6, list);
					}
					rlt.put("coin", this.getGameRoleService().findRoleById(roleid).getYin());
					rlt.put("reward", list);
					//标记已领取
					roleinfo.add(num);
					Map<String, Object> param = new HashMap<String, Object>();
					param.put("id", roleid);
					param.put("friends", roleinfo.toString());
					this.getGameRoleService().updateRoleVip(param);
					param=null;
				}else{//邀请好友不足
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
					ServerHandler.sendData(session, respMap);
					return;
				}
			}
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
					rlt);
			ServerHandler.sendData(session, respMap);
			rlt=null;
			
		}
	}

	private void huangzuangift() {
		Map<String, Object> rlt = new HashMap<String, Object>();
		int roleid = Integer.parseInt(playerId);
//		int huangzuan = this.getGameRoleService().findRoleById(roleid).getHuangzuan();
		int huangzuan = 0;
		
		//添加黄钻信息
		JsonSerializer json = new JsonSerializer();
		String Huangzuaninfo = this.getGameRoleService().findRoleById(roleid).getHuangzuaninfo();
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
			int status = this.getGameRoleService().findRoleById(roleid).getHuangzuangift();
			if(status==0){//还没有领取
				JSONArray list = new JSONArray();
				getLiveItem(roleid, 3, 1, 5, list);
				rlt.put("reward", list);
				//标记今日已领取
				Map<String,Object> param = new HashMap<String,Object>();
				param.put("id", roleid);
				param.put("huangzuangift", 1);
				this.getGameRoleService().updateRoleVip(param);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
			}else{//今日已领取
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
			}
		}else{//不是黄钻
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
		}
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
		ServerHandler.sendData(session, respMap);
		rlt=null;
	}

	private void getlive() {
		Map<String, Object> rlt = new HashMap<String, Object>();
		int roleid = Integer.parseInt(playerId);
		int live = this.getGameRoleService().findRoleById(roleid).getLive();
		if(live==0){//可以领取
			String ids = this.getGameRoleService().findRoleById(roleid).getIds();
			JSONArray ary = JSONArray.fromObject(ids);
			
//			//去重
			Set set = new HashSet();
			for(int i=0;i<ary.size();i++){
				set.add(ary.get(i));
			}
			
			ary.clear();
			Iterator it = set.iterator();
			while(it.hasNext()){
				ary.add(it.next());
			}
			
			int num =0;
			for(int i=0;i<ary.size();i++){
				int idss = Integer.parseInt(String.valueOf(ary.get(i)));
				GameRoleDetail gamerole = this.getGameRoleService().findRoleById(idss);
				if(gamerole==null){
					continue;
				}
//				if(gamerole==null){
//					continue;
//				}
				String yesterday = gamerole.getYesterday();
				String today = gamerole.getToday();
				long tt = gamerole.getTasktime();
				long nowtime = new Date().getTime();
				int day = (int) ((nowtime - tt) / 1000 / 60 / 60 / 24 + 1);
				JsonSerializer json = new JsonSerializer();
				List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json.deserialize(yesterday);
				if(roleinfo.size()>0){
					int d =0;
					if(roleinfo.get(0).get("day")!=null){
						d = Integer.parseInt(String.valueOf(roleinfo.get(0).get("day")))+1;
					}
					List<Map<String, Object>> roleinfo2 = (List<Map<String, Object>>) json.deserialize(today);
					if(roleinfo2.get(0).get("day")!=null){
						int today2 = Integer.parseInt(String.valueOf(roleinfo2.get(0).get("day")));
						if(today2==day){
							if(day==d){
								num++;
							}
						}else if(day==(today2+1)){
							num++;
						}
					}
					
				}
			}
			JSONArray list = new JSONArray();
			if(num>=1){
				if(1<=num&&num<=4){//初级招妖另
					getLiveItem(roleid, 3, num, 5, list);
				}else if(5<=num&&num<=10){
					getLiveItem(roleid, 3, num, 5, list);//初级招募领
					getLiveItem(roleid, 4, 1, 5, list);//中级招募令
					getLiveItem(roleid, 9, 5, 5, list);//灵丹
				}else if(11<=num&&num<=40){
					getLiveItem(roleid, 3, num, 5, list);//初级招募领
					getLiveItem(roleid, 4, 2, 5, list);//中级招募令
					getLiveItem(roleid, 9, 10, 5, list);//灵丹
				}else if(41<=num&&num<=69){
					getLiveItem(roleid, 3, num, 5, list);//初级招募领
					getLiveItem(roleid, 4, 3, 5, list);//中级招募令
					getLiveItem(roleid, 9, 15, 5, list);//灵丹
				}else if(70<=num&&num<=109){
					getLiveItem(roleid, 3, 70, 5, list);//初级招募领
					getLiveItem(roleid, 4, 3, 5, list);//中级招募令
					getLiveItem(roleid, 9, 25, 5, list);//灵丹
					getLiveItem(roleid, 17, 2, 5, list);//铜钱卡
				}else if(110<=num&&num<=149){
					getLiveItem(roleid, 3, 70, 5, list);//初级招募领
					getLiveItem(roleid, 4, 4, 5, list);//中级招募令
					getLiveItem(roleid, 9, 40, 5, list);//灵丹
					getLiveItem(roleid, 20, 1, 5, list);//铜钱卡
					getLiveItem(roleid, 8, 1, 5, list);//高级藏宝图
				}else if(num>=150){
					getLiveItem(roleid, 3, 70, 5, list);//初级招募领
					getLiveItem(roleid, 4, 5, 5, list);//中级招募令
					getLiveItem(roleid, 9, 40, 5, list);//灵丹
					getLiveItem(roleid, 20, 2, 5, list);//铜钱卡
					getLiveItem(roleid, 8, 2, 5, list);//高级藏宝图
					getLiveItem(roleid, 5, 1, 5, list);//高级招妖另
				}
			}
			if(list.size() > 0){
				rlt.put("reward", list);
			}
//			//标记已领取
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("id", roleid);
			param.put("live", 1);
			this.getGameRoleService().updateRoleVip(param);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
					rlt);
			ServerHandler.sendData(session, respMap);
		}else{//今日已领过
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "");
			ServerHandler.sendData(session, respMap);
		}
		rlt=null;
	}

	private void openlive() {
		Map<String, Object> rlt = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		int roleid = Integer.parseInt(playerId);
		GameRoleDetail gameRole = this.getGameRoleService().findRoleById(roleid);
		String ids = gameRole.getIds();
		int live = gameRole.getLive();
		
		//判断是否是新的一天
		long nowtime2 = new Date().getTime();
		int day2 = (int) ((nowtime2 - gameRole.getTasktime()) / 1000 / 60 / 60 / 24 + 1);
		int roleday = gameRole.getDay();
		if (day2 > roleday) {// 新的一天，dailynum应设为0，day增加1，今天还没有领取礼包
			if(day2>this.getRoleTaskService().findRoleTask(roleid).get(0).getDay()){
				param.clear();
				param.put("roleId", roleid);
				param.put("dailynum", 0);
				param.put("day", day2);
				param.put("status", 1);
				this.getRoleTaskService().updateRoleTasknumday(param);
			}
			
//			// 恢复妖牌为0
//
			//标记今天上线，将今天的放到昨天
			JSONArray ary = new JSONArray();
			Map<String, Object> pp = new HashMap<String, Object>();
			pp.put("day", day2);
			ary.add(pp);
			param.clear();
			param.put("id", roleid);
			param.put("day", day2);
			param.put("num", 0);
			param.put("yesterday", gameRole.getToday());
			param.put("today", ary.toString());
			param.put("live", 0);//好友活跃度奖励
			param.put("huangzuangift", 0);//黄钻礼包
			param.put("jingji", 10);
			param.put("jjnum", 0);
//			param.put("jjstatus", 1);
			this.getGameRoleService().updateRoleVip(param);
			this.getplayerHandler().updateActivity(roleid);//更新每日活动
			pp=null;
		}
		
		
		if("null".equals(String.valueOf(ids))){//
			rlt.put("num", 0);
			rlt.put("live", live);
		}else{
			JSONArray ary = JSONArray.fromObject(ids);
			
			//去重
			Set set = new HashSet();
			for(int i=0;i<ary.size();i++){
				set.add(ary.get(i));
			}
			
			ary.clear();
			Iterator it = set.iterator();
			while(it.hasNext()){
				ary.add(it.next());
			}
			
			int num =0;
			for(int i=0;i<set.size();i++){
				int idss = Integer.parseInt(String.valueOf(ary.get(i)));
				GameRoleDetail gamerole = this.getGameRoleService().findRoleById(idss);
				if(gamerole==null){
					continue;
				}
//				if(gamerole==null){
//					continue;
//				}
				String yesterday = gamerole.getYesterday();
				String today = gamerole.getToday();
				long tt = gamerole.getTasktime();
				long nowtime = new Date().getTime();
				int day = (int) ((nowtime - tt) / 1000 / 60 / 60 / 24 + 1);
				JsonSerializer json = new JsonSerializer();
				List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json.deserialize(yesterday);
				if(roleinfo.size()>0){
					int d =0;
					if(roleinfo.get(0).get("day")!=null){
						d = Integer.parseInt(String.valueOf(roleinfo.get(0).get("day")))+1;
					}
					List<Map<String, Object>> roleinfo2 = (List<Map<String, Object>>) json.deserialize(today);
					if(roleinfo2.get(0).get("day")!=null){
						int today2 = Integer.parseInt(String.valueOf(roleinfo2.get(0).get("day")));
						if(today2==day){
							if(day==d){
								num++;
							}
						}else if(day==(today2+1)){
							num++;
						}
					}
				}
			}
			rlt.put("num", num);
			rlt.put("live", live);
		}
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
				rlt);
		ServerHandler.sendData(session, respMap);
		rlt=null;
		param=null;
	}

	/** t:是否和机器人战斗,id:对手id */
	private void challengeover(int t,int id,int roleid,Map<String, Object> rlt) {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		param.clear();
		param.put("roleid", roleid);
		List<RoleChallengeDetail> challenge = this.getRoleChallengeService().findRoleChallengeById(param);
		GameLevelDetail gamelevel = null ;
		 GameRoleDetail game = this.getGameRoleService().findRoleById4(roleid);
		 int level = 0;//对手等级
		if(t==1){//和玩家战斗
			level =this.getGameRoleService().findRoleById4(id).getLevel();//对手等级
			gamelevel = this.getGameLevelService().getGameLevelByRoleLevel(level);
		}else{//和机器人战斗
			param.clear();
			param.put("id", id);
			List<GameRobotDetail> gamerobot = this.getGameRobotService().findGameRobot(param);
			if(!challenge.isEmpty()){
				if(!gamerobot.isEmpty()){
					level = gamerobot.get(0).getLevel();
					gamelevel = this.getGameLevelService().getGameLevelByRoleLevel(level);
				}else{//机器人不存在
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
					ServerHandler.sendData(session, respMap);
					return;
				}
			}
			gamerobot=null;
		}
		//获得奖励
		int needexp = this.getGameLevelService().getGameLevelByRoleLevel(game.getLevel()).getNeedexp();// 升级所需经验
		int exp = game.getExp();
		int gongxun = game.getGongxun();
		int yin = game.getYin();
		int upplevel = 0;//判断是否升级
		JSONArray reward = new JSONArray();
		if(!challenge.isEmpty()){
			int win = challenge.get(0).getWin();
			if(win==1){//胜利
				param.clear();
				param.put("id", roleid);
				param.put("yin", (gamelevel.getGetcoin()+yin));
				param.put("gongxun", (gamelevel.getGetgongxun()+gongxun));
				param.put("exp", (gamelevel.getGetexp()+exp));
				this.getGameRoleService().updateRoleVip(param);
				map.clear();
				map.put("yin", gamelevel.getGetcoin());
				map.put("gongxun", gamelevel.getGetgongxun());
				map.put("exp", gamelevel.getGetexp());
				// 判断是否可以升级
				upplevel = this.getplayerHandler().shengji(roleid, game.getLevel(), exp, gamelevel.getGetexp());	
				// 更改下次升级所需经验
				int junling;
				if(upplevel==1){//已升级
					GameRoleDetail gamerole = this.getGameRoleService().findRoleById4(roleid);
					map.put("totalyin", gamerole.getYin());
					map.put("totalgongxun", gamerole.getGongxun());
					map.put("totalexp", gamerole.getExp());
					map.put("level", gamerole.getLevel());
					needexp = this.getGameLevelService()
					.getGameLevelByRoleLevel(gamerole.getLevel()).getNeedexp();
					map.put("needexp", needexp);
					map.put("upplevel", upplevel);
  		        	//rlt.put("gift", map);
					junling = gamerole.getJunling();
				}else{//没有升级
					map.put("totalyin",(gamelevel.getGetcoin()+yin));
					map.put("totalgongxun", (gamelevel.getGetgongxun()+gongxun));
					map.put("totalexp",(gamelevel.getGetexp()+exp));
					map.put("level", game.getLevel());
					needexp = this.getGameLevelService()
					.getGameLevelByRoleLevel(game.getLevel()).getNeedexp();
					map.put("needexp", needexp);
					map.put("upplevel", upplevel);
  		        	//rlt.put("gift", map);
					junling = game.getJunling();
				}
				//获得道具
				int a=0;
				int[] ary = {0,2,9,10,11,17};//0是军令
				Random random = new Random();
				if(random.nextInt(100)<50){
					int itemid = ary[random.nextInt(ary.length)];
					if(itemid==0){//获得军令
						a=a+1;
						param.clear();
						param.put("id", roleid);
						param.put("junling", (junling+1));
						this.getGameRoleService().updateRoleVip(param);
						param.clear();
						param.put("num", 1);
						param.put("flag", 1);//代表军令
						reward.add(param);
						rlt.put("reward", reward);
					}else{//获得道具
						List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
						Map<String, Object> params = new HashMap<String, Object>();
						params.clear();
						params.put("roleid", roleid);
						params.put("itemid", itemid);
						List<RoleItemDetail> item = this
								.getRoleItemService().getRoleItem(params);
						params.put("num", 1);// 获得数量
						params.put("resType", 5);
						// 判断背包格子是否已满
						int itemtype = this.getGameItemService()
								.getGameItemById(itemid).get(0).getItemtype();
						boolean boo = this.getplayerHandler().getShangxian(itemtype, 5, roleid,
								itemid, 1);
						if (boo == false) {// 背包格子不足
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "道具空间不足");
							ServerHandler.sendData(session, respMap);
							return;
						}
						if (!item.isEmpty()) {// 已存在
							boolean bo = this.getRoleItemService().addRoleItemNum(params);
							if (bo == true) {
								long bid = item.get(0).getId();
								params.put("bid", bid);
								params.put("id", itemid);
								params.remove("roleid");
								params.remove("itemid");
								list.add(params);
							} else {
							}
						} else {// 不存在，
							long bid = this.getAutoIdService().fingKeyValueByTableName("role_item") + 0L;
							RoleItemDetail iDetail = new RoleItemDetail();
							iDetail.setId(bid);
							iDetail.setRoleid(roleid);
							iDetail.setItemid(itemid);
							iDetail.setNum(1);
							iDetail.setFlag(1);
							iDetail.setType(itemtype);
							boolean bo = this.getRoleItemService().insertRoleItem(iDetail);
							if (bo == true) {
								params.put("bid", bid);
								params.remove("roleid");
								params.put("id", itemid);
								params.remove("itemid");
								list.add(params);
							}
							iDetail=null;
						}
						rlt.put("reward", list);
						list=null;
						params=null;
						item=null;
					}
				}
				map.put("junling", junling+a);
				rlt.put("gift", map);
				ary=null;
			}else if(win==0){//失败
				param.clear();
				param.put("id", roleid);
				param.put("yin", (int) (gamelevel.getGetcoin()*0.5)+yin);
				param.put("gongxun", (int) (gamelevel.getGetgongxun()*0.5)+gongxun);
				param.put("exp", (int) (gamelevel.getGetexp()*0.5)+exp);
				this.getGameRoleService().updateRoleVip(param);
				map.clear();
				map.put("yin", (int) (gamelevel.getGetcoin()*0.5));
				map.put("gongxun", (int) (gamelevel.getGetgongxun()*0.5));
				map.put("exp", (int) (gamelevel.getGetexp()*0.5));
				// 判断是否可以升级
				upplevel = this.getplayerHandler().shengji(roleid, game.getLevel(), exp, (int) (gamelevel.getGetexp()*0.5));
				// 更改下次升级所需经验
				int junling;
				if(upplevel==1){//已升级
					GameRoleDetail gamerole = this.getGameRoleService().findRoleById4(roleid);
					map.put("totalyin", gamerole.getYin());
					map.put("totalgongxun", gamerole.getGongxun());
					map.put("totalexp", gamerole.getExp());
					map.put("level", gamerole.getLevel());
					needexp = this.getGameLevelService()
					.getGameLevelByRoleLevel(gamerole.getLevel()).getNeedexp();
					map.put("needexp", needexp);
					map.put("upplevel", upplevel);
					junling = gamerole.getJunling();
					map.put("junling", junling);
  		        	rlt.put("gift", map);
				}else{//没有升级
					map.put("totalyin",(gamelevel.getGetcoin()+yin));
					map.put("totalgongxun", (gamelevel.getGetgongxun()+gongxun));
					map.put("totalexp",(gamelevel.getGetexp()+exp));
					map.put("level", game.getLevel());
					needexp = this.getGameLevelService()
					.getGameLevelByRoleLevel(game.getLevel()).getNeedexp();
					map.put("needexp", needexp);
					map.put("upplevel", upplevel);
					junling = game.getJunling();
					map.put("junling", junling);
  		        	rlt.put("gift", map);
				}
			}
		}
		rlt=null;
		challenge=null;
		param=null;
		map=null;
		gamelevel=null;
		game=null;
		reward=null;
	}

	/** 战斗过程 */
	protected void faight(JSONArray list1, JSONArray list2, JSONArray list, int roleid,int id) {
		long a = System.currentTimeMillis();
		Map<String, Integer> map = new HashMap<String, Integer>();
		Map mp = new HashMap();
		JsonSerializer json = new JsonSerializer();
		List<Map<String, Integer>> mattack = (List<Map<String, Integer>>) json.deserialize(list1);
		int a1 = Integer.parseInt(String.valueOf(mattack.get(0).get("gongji")));
		int s1 = Integer.parseInt(String.valueOf(mattack.get(0).get("gongsu")));
		int f1 = Integer.parseInt(String.valueOf(mattack.get(0).get("xueliang")));
		String cf0=String.valueOf(mattack.get(0).get("chufa"));
		String mz0=String.valueOf(mattack.get(0).get("mingzhong"));
		String sb0=String.valueOf(mattack.get(0).get("shanbi"));
		String bj0=String.valueOf(mattack.get(0).get("xbaoji"));
		String js0=String.valueOf(mattack.get(0).get("jianshang"));
		int chufa0=0;
		int mingzhong0=0;
		int jianshang0=0;
		int shanbi0=0;
		int baoj0=0;
		if(!cf0.equals("null")){
			chufa0=Integer.parseInt(String.valueOf(mattack.get(0).get("chufa")));
		}
		if(!mz0.equals("null")){
		  mingzhong0= Integer.parseInt(String.valueOf(mattack.get(0).get("mingzhong")));
		}
		if(!js0.equals("null")){
			jianshang0= Integer.parseInt(String.valueOf(mattack.get(0).get("jianshang")));
		}
		if(!sb0.equals("null")){
			 shanbi0= Integer.parseInt(String.valueOf(mattack.get(0).get("shanbi")));
		}
		if(!bj0.equals("null")){
			baoj0= Integer.parseInt(String.valueOf(mattack.get(0).get("xbaoji")));
		}
		
		//技能
		int skillid0 = Integer.parseInt(String.valueOf(mattack.get(0).get("skillid")));//是技能id
		int skillodd0 = Integer.parseInt(String.valueOf(mattack.get(0).get("skillodd")))+chufa0;//几率
		int buffatktime0 = Integer.parseInt(String.valueOf(mattack.get(0).get("buffatktime")));
		int buffobj0 = Integer.parseInt(String.valueOf(mattack.get(0).get("buffobj")));//
		int speed0 = Integer.parseInt(String.valueOf(mattack.get(0).get("speed")));
		int attack0 = Integer.parseInt(String.valueOf(mattack.get(0).get("attack")));
		int health0 = Integer.parseInt(String.valueOf(mattack.get(0).get("health")));
		int miss0 = Integer.parseInt(String.valueOf(mattack.get(0).get("miss")));
		int baoji0 = Integer.parseInt(String.valueOf(mattack.get(0).get("baoji")));
		shanbi0=shanbi0+miss0;
		int copysb0=shanbi0;
		List<Map<String, Integer>> rattack = (List<Map<String, Integer>>) json.deserialize(list2);
		int a2 = Integer.parseInt(String.valueOf(rattack.get(0).get("gongji")));
		int s2 = Integer.parseInt(String.valueOf(rattack.get(0).get("gongsu")));
		int f2 = Integer.parseInt(String.valueOf(rattack.get(0).get("xueliang")));
		String cf1=String.valueOf(rattack.get(0).get("chufa"));
		String sb1=String.valueOf(rattack.get(0).get("shanbi"));
		String bj1=String.valueOf(rattack.get(0).get("xbaoji"));
		String mz1=String.valueOf(rattack.get(0).get("mingzhong"));
		String js1=String.valueOf(rattack.get(0).get("jianshang"));
		int chufa1=0;
		int mingzhong1=0;
		int shanbi1=0;
		int baoj1=0;
		int jianshang1= 0;
		if(!cf1.equals("null")){
			chufa1= Integer.parseInt(String.valueOf(rattack.get(0).get("chufa")));
		}
		if(!sb1.equals("null")){
			 shanbi1= Integer.parseInt(String.valueOf(rattack.get(0).get("shanbi")));
		}
		if(!bj1.equals("null")){
			baoj1= Integer.parseInt(String.valueOf(rattack.get(0).get("xbaoji")));
		}
		if(!mz1.equals("null")){
		   mingzhong1= Integer.parseInt(String.valueOf(rattack.get(0).get("mingzhong")));
	    }
		if(!js1.equals("null")){
			jianshang1= Integer.parseInt(String.valueOf(rattack.get(0).get("jianshang")));
		}
		int skillid1 = Integer.parseInt(String.valueOf(rattack.get(0).get("skillid")));
		int skillodd1 = Integer.parseInt(String.valueOf(rattack.get(0).get("skillodd")))+chufa1;
		int buffatktime1 = Integer.parseInt(String.valueOf(rattack.get(0).get("buffatktime")));
		int buffobj1 = Integer.parseInt(String.valueOf(rattack.get(0).get("buffobj")));
		int speed1 = Integer.parseInt(String.valueOf(rattack.get(0).get("speed")));
		int attack1 = Integer.parseInt(String.valueOf(rattack.get(0).get("attack")));
		int health1 = Integer.parseInt(String.valueOf(rattack.get(0).get("health")));
		int miss1 = Integer.parseInt(String.valueOf(rattack.get(0).get("miss")));
		int baoji1 = Integer.parseInt(String.valueOf(rattack.get(0).get("baoji")));
		shanbi1=shanbi1+miss1;
		int copysb1=shanbi1;
		if(shanbi0>=90){
			shanbi0=80;
		}
		if(shanbi1>=90){
			shanbi1=80;
		}
		if(baoji0>100){
			baoji0=100;
		}
		if(baoji1>100){
			baoji1=100;
		}
	   if(mingzhong1>shanbi0){
		   shanbi0=0;
	   }else{
		   shanbi0=shanbi0-mingzhong1;
		}
	   if(mingzhong0>shanbi1){
		   shanbi1=0;
	   }else{
		   shanbi1=shanbi1-mingzhong0;
		}
		int a11=a1;
		int f11=f1;
		int baoji11 = 10;
		int miss11 = 10;
		int a22=a2;
		int f22=f2;
		int baoji22 = 10;
		int miss22 = 10;
		int max = s1 * s2*50;
		Random random = new Random();
		int me = 0;//自己是否连续使用技能(伤害)
		int foe = 0;
		int me2 = 0;//自己是否连续使用技能(特效技能)
		int foe2 = 0;//对手是否连续使用技能
		int p0 = 0;
		int p1=0;
		int ss1=0;//不适用技能时用
		int ss2=0;
		int s1_1=0;//f1使用技能时用
		int s1_2=0;
		int s2_1=0;//f2使用技能使用
		int s2_2=0;
		//判断交战次数
		//f1使用技能
//		System.out.println("------------------------------------------");
//		System.out.println("我的速度：："+s1);
//		System.out.println("对面的速度：："+s2);
//		System.out.println("我技能的速度：："+speed0);
//		if(buffobj0==1){//
//			if(s1>s2-speed0){
//				if(s1>(s2-speed0)*6){
//					s1_1=3;
//					s1_2=1;
//				}else{
//					s1_1=s1;
//					s1_2=s2-speed0;
//				}
//			}else if(s1<s2-speed0){
//				if(s1*6<s2-speed0){
//					s1_1=1;
//					s1_2=3;
//				}else{
//					s1_1=s1;
//					s1_2=s2-speed0;
//				}
//			}else{
//				s1_1=1;
//				s1_2=1;
//			}
////		}else{//给自己加血
//			if(s1+speed0>s2){
//				if(s1+speed0>s2*6){
//					s1_1=3;
//					s1_2=1;
//				}else{
//					s1_1=s1+speed0;
//					s1_2=s2;
//				}
//			}else if(s1+speed0<s2){
//				if((s1+speed0)*6<s2){
//					s1_1=1;
//					s1_2=3;
//				}else{
//					s1_1=s1+speed0;
//					s1_2=s2;
//				}
//			}else{
//				s1_1=1;
//				s1_2=1;
//			}
//		}
		//f2使用技能
		if(buffobj1==1){//使用技能
			if(s1+speed0>s2+speed1){
				if(s1+speed0>(s2+speed1)*3){
					s2_1=3;
					s2_2=1;
				}else{
					s2_1=s1+speed0;
					s2_2=s2+speed1;
				}
			}else if(s1+speed0<s2+speed1){
				if(s2+speed1>(s1+speed0)*3){
					s2_1=1;
					s2_2=3;
				}else{
					s2_1=s1+speed0;
					s2_2=s2+speed1;
				}
			}else{
				s2_1=1;
				s2_2=1;
			}
		}else{//给自己加血
			if(s1+speed0>s2+speed1){
				if((s2+speed1)*3<s1+speed0){
					s2_1=3;
					s2_2=1;
				}else{
					s2_1=s1+speed0;
					s2_2=s2+speed1;
				}
			}else if(s1+speed0<s2+speed1){
				if(s2+speed1>(s1+speed0)*3){
					s2_1=1;
					s2_2=3;
				}else{
					s2_1=s1+speed0;
					s2_2=s2+speed1;
				}
			}else{
				s2_1=1;
				s2_2=1;
			}
		}
		//不实用技能
		if(s1>s2){
			if(s1>3*s2){
				ss1=3;
				ss2=1;
			}else{
				ss1=s1;
				ss2=s2;
			}
		}else if(s1<s2){
			if(s2>3*s1){
				ss1=1;
				ss2=3;
			}else{
				ss1=s1;
				ss2=s2;
			}
		}else{
			ss1=1;
			ss2=1;
		}
		ps: while (true) {
			
			for (int i = 1; i <=max; i++) {
				p0=(int) (Math.random()*100);
				p1 = (int) (Math.random()*100);
				if (i % s2_2 == 0) {
					if(me!=buffatktime0){
						if(p0<=skillodd0){//f1使用技能
							//首次使用技能
							//判断f2的技能是否在持续，减少自己的攻击力
							if(buffobj0==0){//给自己f1加血
								a11 = (int) (a1 *(1 + attack0/100.0));
								baoji11 = 10+baoji0+baoj0;
								miss11 = 10+shanbi0;
								f1 = (int) (f1 + a11*(health0/100.0));
							}else{
								a22 = (int) (a2 * (1 - attack0/100.0));
								if(baoji1+baoj1>100){
									baoji22 = 100 - baoji0;
								}else{
									baoji22 = baoji1+baoj1 - baoji0;
								}
								if(baoji22<0){
									baoji22=0;
								}
							    if(shanbi1==80){
							    	miss22 = 10+shanbi1 - miss0;
							    }else{
							    	miss22 = shanbi1 - miss0;
							    }
							}
							me=buffatktime0;
							me2=buffatktime0;
						}else{//重设f2
							if(me<=0){
								a22 = a2;
								baoji22 = 10+baoj1;
								if(buffobj1==0){
									miss22 = 10+shanbi1;
								}else{
                                  miss22 = 10+copysb1-miss1;
								}
							}
						}
					}
				}
				if (i % s2_1 == 0) {
					if(foe!=buffatktime1){
						if(p1<=skillodd1){
							if(buffobj1==0){//给自己f2加血
								a22 = (int) (a2 *(1 + attack1/100.0));
								
								baoji22 = 10+baoji1+baoj1;
								miss22 = 10+shanbi1;
								f2 = (int) (f2 + a22*(health1/100.0));
							}else{
								a11 = (int) (a1 * (1 - attack1/100.0));
								if(baoji0+baoj0>100){
									baoji11 = 100 - baoji1;
								}else{
									baoji11 = baoji0+baoj0 - baoji1;
								}
							if(baoji11<0){
								baoji11=0;
							}
							if(shanbi0==80){
								miss11 = 10+shanbi0 - miss1;
							}else{
								miss11 = shanbi0 - miss1;
							}
							}
							foe=buffatktime1;
							foe2=buffatktime1;
						}else{
							if(foe<=0){
								a11 = a1;
								baoji11 = 10+baoj0;
								if(buffobj0==0){
									miss11 = 10+shanbi0;
								}else{
									miss11 = 10+copysb0-miss0;
								}
								
							}
						}
					}
				}
				if(me>0){
					p0=0;
				}
				if(foe>0){
					p1=0;
				}//开始1.。。
				if(p0<=skillodd0){//使用技能，f1放技能
					if(buffobj0==1){//给对手f2减血
						if (i % s2_2 == 0) {//f2掉血
							if(random.nextInt(100)<=baoji11){//暴击
								if(random.nextInt(100)>miss22){//不闪避
									map.clear();
									map.put("flood", (int)(a11*1.5)-(int)(a11*1.5)*jianshang1/100);
									f2 -= (int)(a11*1.5)-(int)(a11*1.5)*jianshang1/100;
									map.put("baoji", 1);
								}else{//闪避
									map.clear();
									map.put("baoji", 1);
									map.put("shanbi", 1);
								}
							}else{//不暴击
								if(random.nextInt(100)>miss22){//不闪避
									f2-=a11-(int)a11*jianshang1/100;
									map.clear();
									map.put("flood", a11-(int)a11*jianshang1/100);
								}else{//闪避
									map.clear();
									map.put("shanbi", 1);
								}
							}
							if (f2 <= 0) {// f2死了
								list2.remove(0);
								mp.clear();
								mp.put("xueliang", f1);
								mp.put("gongji", a1);
								mp.put("gongsu", s1);
								mp.put("skillid", skillid0);
								mp.put("skillodd", skillodd0-chufa0);
								mp.put("buffatktime", buffatktime0);
								mp.put("buffobj", buffobj0);
								mp.put("speed", speed0);
								mp.put("attack", attack0);
								mp.put("health", health0);
								mp.put("miss", miss0);
								mp.put("baoji", baoji0);
							
								mp.put("chufa", chufa0);
								mp.put("shanbi", shanbi0-miss0);
								mp.put("mingzhong", mingzhong0);
								mp.put("xbaoji", baoj0);
								mp.put("jianshang", jianshang0);
							    list1.set(0, mp);
								map.put("live", 0);
								map.put("who", id);
								if(buffatktime0==me2&&me2>0){
									map.put("buffid", skillid0);
									me2--;
								}else{
									map.put("buffid", 0);
								}
								map.put("addflood", 0);
								list.add(map);
								break ps;
							}
							map.put("live", 1);
							map.put("who", id);
							//技能
							if(buffatktime0==me2&&me2>0){
								map.put("buffid", skillid0);
								me2--;
							}else{
								map.put("buffid", 0);
							}
							map.put("addflood", 0);
							
							list.add(map);
							me--;
						}
					}else{//给自己f1加血
						if (i % s2_2 == 0) {//f2掉血
							if(random.nextInt(100)<=baoji11){//暴击
								if(random.nextInt(100)>miss22){//不闪避
									map.clear();
									map.put("flood",(int)(a11*1.5)-(int)(a11*1.5)*jianshang1/100);
									f2 -= (int)(a11*1.5)-(int)(a11*1.5)*jianshang1/100;
									map.put("baoji", 1);
								}else{//闪避
									map.clear();
									map.put("baoji", 1);
									map.put("shanbi", 1);
								}
							}else{//不暴击
								if(random.nextInt(100)>miss22){//不闪避
									f2-=a11-(int)a11*jianshang1/100;
									map.clear();
									map.put("flood",a11-(int)a11*jianshang1/100);
								}else{//闪避
									map.clear();
									map.put("shanbi", 1);
								}
							}
							if (f2 <= 0) {// f2死了
								list2.remove(0);
								mp.clear();
								mp.put("xueliang", f1);
								mp.put("gongji", a1);
								mp.put("gongsu", s1);
								mp.put("skillid", skillid0);
								mp.put("skillodd", skillodd0-chufa0);
								mp.put("buffatktime", buffatktime0);
								mp.put("buffobj", buffobj0);
								mp.put("speed", speed0);
								mp.put("attack", attack0);
								mp.put("health", health0);
								mp.put("miss", miss0);
								mp.put("baoji", baoji0);
								
								mp.put("chufa", chufa0);
								mp.put("shanbi", shanbi0-miss0);
								mp.put("mingzhong", mingzhong0);
								mp.put("xbaoji", baoj0);
								mp.put("jianshang", jianshang0);
								
								list1.set(0, mp);
								map.put("live", 0);
								map.put("who", id);
								if(buffatktime0==me2&&me2>0){
									map.put("buffid", skillid0);
									map.put("addflood", (int)(a11*(health0/100.0)));
									me2--;
								}else{
									map.put("buffid", 0);
									map.put("addflood", 0);
								}
								list.add(map);
								break ps;
							}
							map.put("live", 1);
							map.put("who", id);
							if(buffatktime0==me2&&me2>0){
								map.put("buffid", skillid0);
								map.put("addflood", (int)(a11*(health0/100.0)));
								me2--;
							}else{
								map.put("buffid", 0);
								map.put("addflood", 0);
							}
							
							list.add(map);
							me--;
						}
					}
				}else{//f1不实用技能
					if (i % ss2 == 0) {//f2掉血
						if(random.nextInt(100)<=baoji11){//暴击
							if(random.nextInt(100)>miss22){//不闪避
								map.clear();
								map.put("flood", (int)(a11*1.5)-(int)(a11*1.5)*jianshang1/100);
								f2 -= (int)(a11*1.5)-(int)(a11*1.5)*jianshang1/100;
								map.put("baoji", 1);
							}else{//闪避
								map.clear();
								map.put("baoji", 1);
								map.put("shanbi", 1);
							}
						}else{//不暴击
							if(random.nextInt(100)>miss22){//不闪避
								f2-=a11-(int)a11*jianshang1/100;
								map.clear();
								map.put("flood",a11-(int)a11*jianshang1/100);
							}else{//闪避
								map.clear();
								map.put("shanbi", 1);
							}
						}
						if (f2 <= 0) {// f2死了
							list2.remove(0);
							mp.clear();
							mp.put("xueliang", f1);
							mp.put("gongji", a1);
							mp.put("gongsu", s1);
							mp.put("skillid", skillid0);
							mp.put("skillodd", skillodd0-chufa0);
							mp.put("buffatktime", buffatktime0);
							mp.put("buffobj", buffobj0);
							mp.put("speed", speed0);
							mp.put("attack", attack0);
							mp.put("health", health0);
							mp.put("miss", miss0);
							mp.put("baoji", baoji0);
							
							mp.put("chufa", chufa0);
							mp.put("shanbi", shanbi0-miss0);
							mp.put("mingzhong", mingzhong0);
							mp.put("xbaoji", baoj0);
							mp.put("jianshang", jianshang0);
							
							list1.set(0, mp);
							map.put("live", 0);
							map.put("who", id);
							map.put("buffid", 0);
							map.put("addflood", 0);
							list.add(map);
							break ps;
						}
						map.put("live", 1);
						map.put("who", id);
						map.put("buffid", 0);
						map.put("addflood", 0);
						list.add(map);
						
					}
				}
				//开始2。。。
				if(p1<=skillodd1){//使用技能,f2放技能
					if (i % s2_1 == 0) {//f1掉血
						if(buffobj1==1){//给对手f1减血
							//闪避
							if(random.nextInt(100)<=baoji22){//暴击
								if(random.nextInt(100)>miss11){//不闪避
									map.clear();
									map.put("baoji", 1);//对方f2暴击，我掉血1.5倍
									f1 -= (int) (a22*1.5)-(int)(a22*1.5)*jianshang0/100;
									map.put("flood",(int) (a22*1.5)-(int)(a22*1.5)*jianshang0/100);
								}else{
									map.clear();
									map.put("baoji", 1);//闪避,我闪避
									map.put("shanbi", 1);
								}
							}else{//没暴击
								if(random.nextInt(100)>miss11){//不闪避
									map.clear();
									f1 -= a22-(int)a22*jianshang0/100;
									map.put("flood",a22-(int)a22*jianshang0/100);
								}else{
									map.clear();
									map.put("shanbi", 1);//闪避
								}
							}
							if (f1 <= 0) {// f1死了
								list1.remove(0);
								mp.clear();
								mp.put("xueliang", f2);
								mp.put("gongji", a2);
								mp.put("gongsu", s2);
								mp.put("skillid", skillid1);
								mp.put("skillodd", skillodd1-chufa1);
								mp.put("buffatktime", buffatktime1);
								mp.put("buffobj", buffobj1);
								mp.put("speed", speed1);
								mp.put("attack", attack1);
								mp.put("health", health1);
								mp.put("miss", miss1);
								mp.put("baoji", baoji1);
								
								mp.put("chufa", chufa1);
								mp.put("shanbi", shanbi1-miss1);
								mp.put("mingzhong", mingzhong1);
								mp.put("xbaoji", baoj1);
								mp.put("jianshang", jianshang1);
								
								list2.set(0, mp);
								map.put("live", 0);
//								map.put("flood", a2);
								map.put("who", roleid);//自己掉血
								//技能
								if(buffatktime1==foe2&&foe2>0){
									map.put("buffid", skillid1);
									map.put("addflood", 0);
									foe2--;
								}else{
									map.put("buffid", 0);
									map.put("addflood", 0);
								}
								list.add(map);
								break ps;
							} 
							map.put("live", 1);
							map.put("who", roleid);
//							map.put("flood", a2);// 掉血量
							//技能
							if(buffatktime1==foe2&&foe2>0){
								map.put("buffid", skillid1);
								map.put("addflood", 0);
								foe2--;
							}else{
								map.put("buffid", 0);
								map.put("addflood", 0);
							}
							
							list.add(map);
							//判断技能是否连放
							foe--;
						}else{//给自己f2加血
							//闪避
							if(random.nextInt(100)<=baoji22){//暴击
								if(random.nextInt(100)>miss11){//不闪避
									map.clear();
									map.put("baoji", 1);//对方f2暴击，我掉血1.5倍
									f1 -= (int) (a22*1.5)-(int)(a22*1.5)*jianshang0/100;
									map.put("flood",(int) (a22*1.5)-(int)(a22*1.5)*jianshang0/100);
								}else{
									map.clear();
									map.put("baoji", 1);//闪避,我闪避
									map.put("shanbi", 1);
								}
							}else{//没暴击
								if(random.nextInt(100)>miss11){//不闪避
									map.clear();
									f1 -= a22-(int)a22*jianshang0/100;
									map.put("flood", a22-(int)a22*jianshang0/100);
								}else{
									map.clear();
									map.put("shanbi", 1);//闪避
								}
							}
							if (f1 <= 0) {// f1死了
								list1.remove(0);
								mp.clear();
								mp.put("xueliang", f2);
								mp.put("gongji", a2);
								mp.put("gongsu", s2);
								mp.put("skillid", skillid1);
								mp.put("skillodd", skillodd1-chufa1);
								mp.put("buffatktime", buffatktime1);
								mp.put("buffobj", buffobj1);
								mp.put("speed", speed1);
								mp.put("attack", attack1);
								mp.put("health", health1);
								mp.put("miss", miss1);
								mp.put("baoji", baoji1);
								
								mp.put("chufa", chufa1);
								mp.put("shanbi", shanbi1-miss1);
								mp.put("mingzhong", mingzhong1);
								mp.put("xbaoji", baoj1);
								mp.put("jianshang", jianshang1);
								
								list2.set(0, mp);
								map.put("live", 0);
//								map.put("flood", a2);
								//技能
								if(buffatktime1==foe2&&foe2>0){
									map.put("buffid", skillid1);
									map.put("addflood", (int)(a22*(health1/100.0)));
									foe2--;
								}else{
									map.put("buffid", 0);
									map.put("addflood", 0);
								}
								map.put("who", roleid);//自己掉血
								list.add(map);
								break ps;
							} 
							map.put("live", 1);
							map.put("who", roleid);
//							map.put("flood", a2);// 掉血量
							//技能
							if(buffatktime1==foe2&&foe2>0){
								map.put("buffid", skillid1);
								map.put("addflood", (int)(a22*(health1/100.0)));
								foe2--;
							}else{
								map.put("buffid", 0);
								map.put("addflood", 0);
							}
							list.add(map);
							//判断技能是否连放
							foe--;
						}
					}
				}else{//不实用技能
					if (i % ss1 == 0) {//f1掉血
						//闪避
						if(random.nextInt(100)<=baoji22){//暴击
							if(random.nextInt(100)>miss11){//不闪避
								map.clear();
								map.put("baoji", 1);//对方f2暴击，我掉血1.5倍
								f1 -= (int) (a22*1.5)-(int)(a22*1.5)*jianshang0/100;
								map.put("flood",(int) (a22*1.5)-(int)(a22*1.5)*jianshang0/100);
							}else{
								map.clear();
								map.put("baoji", 1);//闪避,我闪避
								map.put("shanbi", 1);
							}
						}else{//没暴击
							if(random.nextInt(100)>miss11){//不闪避
								map.clear();
								f1 -= a22-(int)a22*jianshang0/100;
								map.put("flood", a22-(int)a22*jianshang0/100);
							}else{
								map.clear();
								map.put("shanbi", 1);//闪避
							}
						}
						if (f1 <= 0) {// f1死了
							list1.remove(0);
							mp.clear();
							mp.put("xueliang", f2);
							mp.put("gongji", a2);
							mp.put("gongsu", s2);
							mp.put("skillid", skillid1);
							mp.put("skillodd", skillodd1-chufa1);
							mp.put("buffatktime", buffatktime1);
							mp.put("buffobj", buffobj1);
							mp.put("speed", speed1);
							mp.put("attack", attack1);
							mp.put("health", health1);
							mp.put("miss", miss1);
							mp.put("baoji", baoji1);
							
							mp.put("chufa", chufa1);
							mp.put("shanbi", shanbi1-miss1);
							mp.put("mingzhong", mingzhong1);
							mp.put("xbaoji", baoj1);
							mp.put("jianshang", jianshang1);
							
							list2.set(0, mp);
							map.put("live", 0);
//							map.put("flood", a2);
							map.put("who", roleid);//自己掉血
							//技能
							map.put("buffid", 0);
							map.put("addflood", 0);
							list.add(map);
							break ps;
						} 
						map.put("live", 1);
						map.put("who", roleid);
//						map.put("flood", a2);// 掉血量
						//技能
						map.put("buffid", 0);
						map.put("addflood", 0);
						list.add(map);
					}
				}
			}
		}
		map=null;
		mp=null;
		mattack=null;
		mattack=null;
		rattack=null;
	}
	/** 获得出战武将信息列*/
	protected void militaryDetail(List mids,int roleid,
			JSONArray list,List totem) {

		//long a=System.currentTimeMillis();
		/****/
		int type1=0;//攻击
		int quality1=0;
		int type2=0;//攻速
		int quality2=0;
		int type3=0;//减伤
		int quality3=0;
		int type4=0;//血量（生命）
		int quality4=0;
		int type5=0;//命中
		int quality5=0;
		int type6=0;//闪避
		int quality6=0;
		int type7=0;//暴击
		int quality7=0;
		int type8=0;//触发
		int quality8=0;
		for(int i=0;i<totem.size();i++){
			
			if(totem.size()<1){
				break;
			}
			//System.out.println("totem======="+totem.get(i));
			int totemid=Integer.parseInt(String.valueOf(totem.get(i)));
			List<GametotemDetail> gt=this.getGametotemService().getGametotembyid(totemid);
	       if(gt.isEmpty()){
	    	   continue;
	       }
			int ty=gt.get(0).getType();
	        if(ty==1){
	        	type1=gt.get(0).getType();
	        	quality1=gt.get(0).getQuality();
	        }else if(ty==2){
	        	type2=gt.get(0).getType();
	        	quality2=gt.get(0).getQuality();
	        }else if(ty==3){
	        	type3=gt.get(0).getType();
	        	quality3=gt.get(0).getQuality();
	        }else if(ty==4){
	        	type4=gt.get(0).getType();
	        	quality4=gt.get(0).getQuality();
	        }else if(ty==5){
	        	type5=gt.get(0).getType();
	        	quality5=gt.get(0).getQuality();
	        }else if(ty==6){
	        	type6=gt.get(0).getType();
	        	quality6=gt.get(0).getQuality();
	        }else if(ty==7){
	        	type7=gt.get(0).getType();
	        	quality7=gt.get(0).getQuality();
	        }else if(ty==8){
	        	type8=gt.get(0).getType();
	        	quality8=gt.get(0).getQuality();
	        }
	        
		}
		/****/
		  
		//System.out.println("==========militaryDetail==================");
//		System.out.println("==========militaryDetail==================");
		Map<String,Object> param = new HashMap<String,Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		for (int i = 0; i < mids.size(); i++) {
		int m = Integer.parseInt(String.valueOf(mids.get(i)));//武将数据id
			
//			List<RoleMilitaryDetail> military = this.getRoleMilitaryService()
//					.getRoleMilitarylevel(m);
			//long a1=System.currentTimeMillis();
			List<GameMilitaryDetail> military=this.getGameMilitaryService().getManyTableSelect(m);
			//long a2=System.currentTimeMillis();
			//System.out.println("1查询getManyTableSelect花费时间："+(a2-a1));
			
			if (!military.isEmpty()) {// 武将存在
				int gongji =military.get(0).getGongji();
				int gongsu = military.get(0).getGongsu();
				int xueliang = military.get(0).getXueliang();
				
				int level = 0;
				if(military.get(0).getLevel()<10){
					level = 1;
				}else if(military.get(0).getLevel()>=10 && military.get(0).getLevel()<25){
					level = 10;
				}else if(military.get(0).getLevel()>=25 && military.get(0).getLevel()<45){
					level = 25;
				}else{
					level = 45;
				}
				param.clear();
				param.put("level", level);
				param.put("type", military.get(0).getType());
				//long b=System.currentTimeMillis();
				//System.out.println("getGameChLevelService||||||||||||||||||||||||||||||||||||||||||||||");
				if(this.getGameChLevelService().findGameChLevelByparas(param).size() == 0){
					GameConstants.log.warn("MapHandler.MilitartyDetail()param:" + param.toString());
				}
				String name = this.getGameChLevelService().findGameChLevelByparas(param).get(0).getName();
				//long a3=System.currentTimeMillis();
				//System.out.println("2查询findGameChLevelByparas花费时间："+(a3-a2));
				map.clear();
				map.put("gongji",(int) (gongji+gongji*(quality1/100.0)));
				map.put("gongsu",gongsu+quality2);
				map.put("xueliang",(int)(xueliang+xueliang*(quality4/100.0)));
				
				map.put("mingzhong",quality5);
				map.put("jianshang",quality3);
				map.put("shanbi",quality6);
				map.put("xbaoji",quality7);
				map.put("chufa",quality8);
				//System.out.println("玩家roleid:"+roleid+"mingzhong==="+quality5+"jianshang====="+quality3+"shanbi"+quality6+"baoji"+quality7);
				//System.out.println("gongji==="+((int) (gongji+gongji*(quality1/100.0)))+"gongsu======"+(gongsu+quality2)+"xueliang====="+((int)(xueliang+xueliang*(quality4/100.0))));
				//附加
				map.put("name", military.get(0).getName());
				map.put("level", military.get(0).getLevel());
				map.put("vocation", name);//职业
				
				//被动技能
				int arts = military.get(0).getArts();
				
				if(arts!=0){
					long x=System.currentTimeMillis();
					List<GameSkillDetail> gameSkill = this.getGameSkillService().getGameSkillById(arts);
				    //long a4=System.currentTimeMillis();
					//System.out.println("3查询getGameSkillService花费时间："+(a4-a3));
					//System.out.println("gameSkill|||||||||||||||||||||||执行用时："+(y-x));
					if(!gameSkill.isEmpty()){
						map.put("skillid", gameSkill.get(0).getId());
						map.put("skillodd", gameSkill.get(0).getSkillodd());
						//触发
						JSONArray bary = JSONArray.fromObject(gameSkill.get(0).getSkillBuffId());
						if(!bary.isEmpty()){
							bary.get(0);
							List<GameBuffDetail> gameBuff = this.getGameBuffService().getGameBuffById(Integer.parseInt(String.valueOf(bary.get(0))));
							//long a5=System.currentTimeMillis();
							//System.out.println("4查询getGameBuffById花费时间："+(a5-a4));
							if(!gameBuff.isEmpty()){
								map.put("buffatktime", gameBuff.get(0).getBuffAtktime());
								map.put("buffobj", gameBuff.get(0).getBuffobj());
								map.put("speed", gameBuff.get(0).getSpeed());
								map.put("attack", gameBuff.get(0).getAttack());
								map.put("health", gameBuff.get(0).getHealth());
								//map.put("miss", (int)(gameBuff.get(0).getMiss()+gameBuff.get(0).getMiss()*(quality6/100.0)));
								//闪避
								map.put("miss",gameBuff.get(0).getMiss());
								map.put("baoji", gameBuff.get(0).getBaoji());
								//map.put("baoji", (int)(gameBuff.get(0).getBaoji()+gameBuff.get(0).getBaoji()*(quality7/100.0)));
								//暴击
								//map.put("mingzhong",(int)quality5);
								//map.put("jianshang", (int)quality3);
								//System.out.println("有技能魔将信息=="+"quality5==="+quality5+"quality3====="+quality3);
								
							}else{
								continue;
							}
							gameBuff=null;
						}
						bary=null;
				}else{
					continue;
				}
				gameSkill=null;
				}else{//没有技能
					map.put("skillid", 0);
					map.put("skillodd", 0);
					map.put("buffatktime", 0);
					map.put("buffobj", 0);
					map.put("speed", 0);
					map.put("attack", 0);
					map.put("health", 0);
					map.put("miss", 0);
					map.put("baoji", 0);
					//map.put("mingzhong",(int)quality5);
					//map.put("jianshang", (int)quality3);
					
				}
				
			} else {// 武将不存在
				//map.put("mingzhong",(int)quality5);
				//map.put("jianshang", (int)quality3);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-5);
				ServerHandler.sendData(session, respMap);
				return;
			}
			//map.put("mingzhong",(int)quality5);
			//map.put("jianshang", (int)quality3);
			list.add(map);
			military=null;
			//System.out.println(gongji+"攻击"+gongsu+"攻速"+xueliang+"血量==================================");
//			System.out.println(gongji+"攻击"+gongsu+"攻速"+xueliang+"血量==================================");
		}
		//map.put("mingzhong",(int)quality5);
		//map.put("jianshang", (int)quality3);
		//list.add(map);
		param=null;
		map=null;
		//long b=System.currentTimeMillis();
	
		//System.out.println("militaryDetail方法总用时："+(b-a));
//		System.out.println("militaryDetail方法总用时："+(b-a));
	
	}
	
	void foeMilitary(List mids,int roleid,JSONArray list,List totem){
		//System.out.println("=============foeMilitary====================");
		//long a0=System.currentTimeMillis();

		/****/
//		int type1=0;//攻击
//		int quality1=0;
//		int type2=0;//攻速
//		int quality2=0;
//		int type3=0;//减伤
//		int quality3=0;
//		int type4=0;//血量（生命）
//		int quality4=0;
//		int type5=0;//命中
//		int quality5=0;
//		int type6=0;//闪避
//		int quality6=0;
//		int type7=0;//暴击
//		int quality7=0;
//		int type8=0;//触发
//		int quality8=0;
//		for(int i=0;i<totem.size();i++){
//			
//			if(totem.size()<1){
//				break;
//			}
//			//System.out.println("totem======="+totem.get(i));
//			int totemid=Integer.parseInt(String.valueOf(totem.get(i)));
//			List<GametotemDetail> gt=this.getGametotemService().getGametotembyid(totemid);
//	       if(gt.isEmpty()){
//	    	   continue;
//	       }
//			int ty=gt.get(0).getType();
//	        if(ty==1){
//	        	type1=gt.get(0).getType();
//	        	quality1=gt.get(0).getQuality();
//	        }else if(ty==2){
//	        	type2=gt.get(0).getType();
//	        	quality2=gt.get(0).getQuality();
//	        }else if(ty==3){
//	        	type3=gt.get(0).getType();
//	        	quality3=gt.get(0).getQuality();
//	        }else if(ty==4){
//	        	type4=gt.get(0).getType();
//	        	quality4=gt.get(0).getQuality();
//	        }else if(ty==5){
//	        	type5=gt.get(0).getType();
//	        	quality5=gt.get(0).getQuality();
//	        }else if(ty==6){
//	        	type6=gt.get(0).getType();
//	        	quality6=gt.get(0).getQuality();
//	        }else if(ty==7){
//	        	type7=gt.get(0).getType();
//	        	quality7=gt.get(0).getQuality();
//	        }else if(ty==8){
//	        	type8=gt.get(0).getType();
//	        	quality8=gt.get(0).getQuality();
//	        }
//	        
//		}
		/****/
		
		
		Map<String,Object> param = new HashMap<String,Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		for (int i = 0; i < mids.size(); i++) {
			//long a=System.currentTimeMillis();
			int m = Integer.parseInt(String.valueOf(mids.get(i)));//武将数据id
			List<GameMilitaryDetail> military=this.getGameMilitaryService().getManyTableSelect(m);
			
			int mjid=0;
			String desc=null;
			int artm=0;
			List<RoleMilitaryDetail> rm=this.getRoleMilitaryService().getRoleMilitarylevel(m);
			
			if(!rm.isEmpty()){
			 mjid=rm.get(0).getMilitaryid();
			}
			List<GameMilitaryDetail> gm=this.getGameMilitaryService().getGameMilitaryBymid(mjid);
			if(!gm.isEmpty()){
				desc=gm.get(0).getDesc();
                artm=gm.get(0).getArts();
			}//long a2=System.currentTimeMillis();
			//System.out.println("11查询getManyTableSelect花费时间："+(a2-a));
			
//			List<RoleMilitaryDetail> military = this.getRoleMilitaryService()
//					.getRoleMilitarylevel(m);
//			param.clear();
//			param.put("id", m);
//			param.put("roleid", roleid);
//			List<RoleMilitaryDetail> military = this.getRoleMilitaryService()
//	.getRoleMilitarylevel2(param);
			
			
			if (!military.isEmpty()) {// 武将存在
				int basegongji = 0;
				int basegongsu = 0;
				int basexueliang = 0;
				int gongji=0;
				int gongsu=0;
				int xueliang=0;
				gongji =military.get(0).getGongji();
				//gongji=(int) (gongji+gongji*(quality1/100.0));
			   gongsu =military.get(0).getGongsu();
				//gongsu=gongsu+quality2;
				xueliang = military.get(0).getXueliang();
				//xueliang=(int)(xueliang+xueliang*(quality4/100.0));
				//List<GameMilitaryDetail> gamemilitary = this
				//.getGameMilitaryService().getGameMilitaryBymid2(military.get(0).getPztype());
				
//					param.clear();
//					param.put("roleId", roleid);
//					param.put("militaryid", military.get(0).getMilitaryid());
					//List<RoleMilitaryDetail> rm = this.getRoleMilitaryService().getRoleMilitaryByparam(param);
//					if(rm.isEmpty()){
//						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-5);
//						ServerHandler.sendData(session, respMap);
//						return;
//					}
//					basegongji = gamemilitary.get(0).getGongji()+(gamemilitary.get(0).getGjiacheng()* (rm.get(0).getLevel()-1));
//					basexueliang = gamemilitary.get(0).getXueliang()+(gamemilitary.get(0).getXljiacheng()* (rm.get(0).getLevel()-1));
     				//System.out.println(military.get(0).getGjjc()+"攻击加成"+military.get(0).getXljc()+"血量加成");
				//System.out.println(military.get(0).getBatype()+"====gm.type=="+military.get(0).getBagj()+"基础攻击"+military.get(0).getBags()+"基础攻速"+military.get(0).getBaxl()+"基础血量");
				//System.out.println(military.get(0).getGmpz()+"====品质===="+military.get(0).getGjjc()+"攻击加成"+military.get(0).getXljc()+"血量加成");
				
				    basegongsu = military.get(0).getBags(); 
     				basegongji = military.get(0).getBagj()+(military.get(0).getGjjc()* (military.get(0).getLevel()-1));
					basexueliang =military.get(0).getBaxl()+(military.get(0).getXljc()* (military.get(0).getLevel()-1));
		    		//rm=null;
				 
			
				int level = 0;
				if(military.get(0).getLevel()<10){
					level = 1;
				}else if(military.get(0).getLevel()>=10 && military.get(0).getLevel()<25){
					level = 10;
				}else if(military.get(0).getLevel()>=25 && military.get(0).getLevel()<45){
					level = 25;
				}else{
					level = 45;
				}
				param.clear();
				param.put("type", military.get(0).getBatype());
				param.put("level", level);
				String name = this.getGameChLevelService().findGameChLevelByparas(param).get(0).getName();
				long a3=System.currentTimeMillis();
				//System.out.println("22查询findGameChLevelByparas花费时间："+(a3-a2));
				map.clear();
				
				/****/
//				map.put("mingzhong",quality5);
//				map.put("jianshang",quality3);
//				map.put("shanbi",quality6);
//				map.put("xbaoji",quality7);
				/****/
			     map.put("url", desc);
			     map.put("arts", artm);
				map.put("_att", basegongji);
				map.put("_attsp", basegongsu);
				map.put("_blood", basexueliang);
				map.put("_att_add", gongji-basegongji);
				map.put("_attsp_add", gongsu-basegongsu);
				map.put("_blood_add", xueliang-basexueliang);
				//附加
				map.put("name", military.get(0).getName());
				map.put("level", military.get(0).getLevel());
				map.put("_jobName", name);//职业
				map.put("types", military.get(0).getFanwei());//即types
				map.put("pinzhi", military.get(0).getGmpz());
				map.put("militaryid", military.get(0).getId());
				/****/
				//map.put("mingzhong",(int)quality5);
				//map.put("jianshang", (int)quality3);
				/****/
				
				//被动技能
				int arts = military.get(0).getArts();
				if(arts!=0){
					List<GameSkillDetail> gameSkill = this.getGameSkillService().getGameSkillById(arts);
					
					//long a4=System.currentTimeMillis();
					//System.out.println("33查询getGameSkillById花费时间:"+(a4-a3));
					if(!gameSkill.isEmpty()){
						map.put("skillid", gameSkill.get(0).getId());
						map.put("skillodd", gameSkill.get(0).getSkillodd());
						JSONArray bary = JSONArray.fromObject(gameSkill.get(0).getSkillBuffId());
						if(!bary.isEmpty()){
							bary.get(0);
							List<GameBuffDetail> gameBuff = this.getGameBuffService().getGameBuffById(Integer.parseInt(String.valueOf(bary.get(0))));
							//long a5=System.currentTimeMillis();
//							System.out.println("查询getGameBuffById花费时间："+(a5-a4));
							if(!gameBuff.isEmpty()){
								map.put("buffatktime", gameBuff.get(0).getBuffAtktime());
								map.put("buffobj", gameBuff.get(0).getBuffobj());
								map.put("speed", gameBuff.get(0).getSpeed());
								map.put("attack", gameBuff.get(0).getAttack());
								map.put("health", gameBuff.get(0).getHealth());
								map.put("miss", gameBuff.get(0).getMiss());
								map.put("baoji", gameBuff.get(0).getBaoji());
							}else{
								continue;
							}
							gameBuff=null;
						}
						bary=null;
				}else{
					continue;
				}
				gameSkill=null;
				}else{//没有技能
					map.put("skillid", 0);
					map.put("skillodd", 0);
					map.put("buffatktime", 0);
					map.put("buffobj", 0);
					map.put("speed", 0);
					map.put("attack", 0);
					map.put("health", 0);
					map.put("miss", 0);
					map.put("baoji", 0);
				}
				
				list.add(map);
			} else {// 武将不存在
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-5);
				ServerHandler.sendData(session, respMap);
				return;
			}
			military=null;
		}
		param=null;
		map=null;
		//long b=System.currentTimeMillis();
		//System.out.println("==============foeMilitary方法调用用时："+(b-a0));
	}

	public Map<String, String> jingji_sum_zxueliang(int roleid){
		Map<String, String> map = new HashMap<String, String>();
		Map<String, Object> param = new HashMap<String, Object>();
		param.clear();
		param.put("roleid", roleid);
		List<RoleChallengeDetail> rolechallenge = this.getRoleChallengeService().findRoleChallengeById(param);
		JsonSerializer json = new JsonSerializer();
		List mids = (List) json.deserialize(rolechallenge.get(0).getMilitaryid());
		int sum = 0;
		int zxueliang = 0;
		for (int i = 0; i < mids.size(); i++) {
			int m = Integer.parseInt(String.valueOf(mids.get(i)));//武将数据id
			List<GameMilitaryDetail> military=this.getGameMilitaryService().getManyTableSelect(m);
			if (!military.isEmpty()) {// 武将存在
				sum = sum + military.get(0).getGongji();
				zxueliang = zxueliang + military.get(0).getXueliang();
			}
		}
		map.put("sum", String.valueOf(sum));
		map.put("zxueliang", String.valueOf(zxueliang));
		return map;
	}
	
	private void attack() {
		long b = 0;
		//System.out.println("攻击争霸战开始" +  Integer.parseInt(playerId) + ", " + this.getClass().toString() + this.hashCode());
		if (params.containsKey("id")&&params.containsKey("t")&&params.containsKey("r")) {
			int id = Integer.parseInt(String.valueOf(params.get("id")));
			int t = Integer.parseInt(String.valueOf(params.get("t")));
			int r = Integer.parseInt(String.valueOf(params.get("r")));//是否是复仇的玩家,是复仇玩家全服通知
			int roleid = Integer.parseInt(playerId);
			int winid = 0;
			String stlist02="";
			String beihitname="";
			int hitrate = 0;
			int beihitrate = 0;
			int hitlevel = 0;
			int beihitlevel = 0;
			Map<String, Object> rlt = new HashMap<String, Object>();
			Map<String, Object> param = new HashMap<String, Object>();
			// 消耗一个挑战令
			GameRoleDetail gamerole = this.getGameRoleService().findRoleById3(roleid);
			int challengenum = gamerole.getChallengenum();
			int vip = gamerole.getVip();
			String hitname=gamerole.getName();
			String totem=gamerole.getTotem();
			List litotem;
			JsonSerializer json1 = new JsonSerializer();
			litotem=(List) json1.deserialize(totem);
			//黄钻享受vip2待遇
			if(vip<2){
				int huangzuan = 0;
				JsonSerializer json = new JsonSerializer();
				String Huangzuaninfo = gamerole.getHuangzuaninfo();
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
					vip =2;
				}
			}
			int challengetop = this.getGameVipService().getGameVipByLe(vip).get(0).getChallengTop();
			if (challengenum > 0) {// 可以挑战
				// 判断挑战令是否等于15，开始每小时增加一个挑战令,记录时间
				if (challengenum == challengetop) {// 开始倒计时
					param.clear();
					param.put("id", roleid);
					param.put("challengetime", new Date().getTime());
					this.getGameRoleService().updateRoleVip(param);
				}
				param.clear();
				param.put("id", roleid);
				param.put("challengenum", (challengenum - 1));
				this.getGameRoleService().updateRoleVip(param);
				challengenum--;
			} else {// 挑战令不足
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-3);
				ServerHandler.sendData(session, respMap);
				return;
			}
			//开始战斗
			JSONArray list1 = new JSONArray();//本家
			JSONArray list02 = new JSONArray();//自己mids
			JSONArray list03 = new JSONArray();//自己总攻击
			JSONArray list2 = new JSONArray();//对手mids
			JSONArray list3 = new JSONArray();//对手总攻击
			JSONArray list = new JSONArray();
			Map<String,Object> map = new HashMap<String,Object>();
			param.clear();
			param.put("roleid", roleid);
			List<RoleChallengeDetail> rolechallenge = this.getRoleChallengeService().findRoleChallengeById(param);
			List<RoleMilitaryDetail> roe0 = null;
			if (!rolechallenge.isEmpty()) {//获得自己
				//判断出战武将是否为空
				JsonSerializer json = new JsonSerializer();
				litotem=(List) json.deserialize(totem);
				List mids = (List) json.deserialize(rolechallenge.get(0).getMilitaryid());
				if(mids.isEmpty()){//随机选取一定武将，放入rolechallenge
					param.clear();
					param.put("roleId", roleid);
					 roe0 = this.getRoleMilitaryService().getRoleMilitaryByparam(param);
					if(roe0.isEmpty()){
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-5);
						ServerHandler.sendData(session, respMap);
						return;
					}
					//根据等级出战数量
					List ary = new ArrayList();
					int num=0;//出战武将数
					if(gamerole.getLevel()<=10){
						num = 3;
					}else if(gamerole.getLevel()>10 && gamerole.getLevel()<=15){
						num = 6;
					}else if(gamerole.getLevel()>15){
						num = 9;
					}
					if(roe0.size()>=num){//只取6个
						for(int i=0;i<num;i++){
							ary.add(roe0.get(i).getId());
						}
					}else{
						for(int i=0;i<roe0.size();i++){
							ary.add(roe0.get(i).getId());
						}
					}
					this.militaryDetail(ary,roleid, list1,litotem);
					rlt.put("mid", ary);
					ary=null;
				}else{
					this.militaryDetail(mids,roleid, list1,litotem);// 获得武将列表信息
				}
				mids=null;
			} else {// 用户不存在
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);
				ServerHandler.sendData(session, respMap);
				return;
			}
			String mids1=list1.toString();
			List url= new ArrayList();//头像地址
			//获取自己头像
			String Huangzuaninfo =gamerole.getHuangzuaninfo();
			hitlevel=gamerole.getLevel();
			if("null".equals(String.valueOf(Huangzuaninfo))){
				url.add("http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
			}else{
				JsonSerializer json = new JsonSerializer();
				List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
						.deserialize(Huangzuaninfo);
				if("null".equals(String.valueOf(roleinfo.get(0).get("figureurl")))){
					url.add("http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
				}else{
					url.add(roleinfo.get(0).get("figureurl"));
				}
				roleinfo=null;
			}
			String hittoux;
			String beihittoux;
			hittoux="http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50";
			List litotem2;
			if(t==1){//和游戏玩家战斗
				//获取玩家头像url
				GameRoleDetail gamerole2 = this.getGameRoleService().findRoleById3(id);
				String totem2=gamerole2.getTotem();
				litotem2=(List) json1.deserialize(totem2);
				rlt.put("totem",litotem2);
				beihitname=gamerole2.getName();
				beihitlevel=gamerole2.getLevel();
				String huangzuangift = gamerole2.getHuangzuaninfo();
				if("null".equals(String.valueOf(huangzuangift))){
					url.add("http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
				}else{
					JsonSerializer json = new JsonSerializer();
					List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json.deserialize(huangzuangift);
					url.add(roleinfo.get(0).get("figureurl"));
					roleinfo=null;
				}
				beihittoux="http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50"		;
				//获得自己的信息
				List<RoleChallengeDetail> foe0=rolechallenge;
				if (!foe0.isEmpty()) {
					JsonSerializer json = new JsonSerializer();
					litotem2=(List) json.deserialize(totem2);
					List mids = (List) json.deserialize(foe0.get(0).getMilitaryid());
					if(mids.isEmpty()){//随机选取一定武将，放入rolechallenge
						//根据等级出战数量
						List ary = new ArrayList();
						int num=0;//出战武将数
						int level = gamerole.getLevel();
						
						if(level<=10){
							num = 3;
						}else if(level>10 && level<=15){
							num = 6;
						}else if(level>15){
							num = 9;
						}
						if(roe0.size()>=num){//只取6个
							for(int i=0;i<num;i++){
								ary.add(roe0.get(i).getId());
							}
						}else{
							for(int i=0;i<roe0.size();i++){
								ary.add(roe0.get(i).getId());
							}
						}
						this.militaryDetail(ary,roleid, list03,litotem);
						this.foeMilitary(ary,roleid, list02,litotem);
						roe0=null;
						ary=null;
					}else{
						this.militaryDetail(mids,roleid, list03,litotem);// 获得武将列表信息
						this.foeMilitary(mids,roleid, list02,litotem);
					}
					map.clear();
//					rlt.put("mids", list2);
					map.put("mids1", list02);
//					rlt.put("id", id);
//					rlt.put("name", gamerole.getName());
					int success = foe0.get(0).getSuccess();
					int total = foe0.get(0).getTotals();
					hitrate=(success*100/(total+1));
					if(total==0){
						map.put("percent", 100);
					}else{
						map.put("percent", success*100/total);
					}
					mids1=null;
				} else {// 对手不存在
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);
					ServerHandler.sendData(session, respMap);
					return;
				}
				stlist02=list02.toString();
				// 获得对手信息
				param.clear();
				param.put("roleid", id);
				List<RoleChallengeDetail> foe = this.getRoleChallengeService().findRoleChallengeById(param);
				if (!foe.isEmpty()) {
					JsonSerializer json = new JsonSerializer();
					List mids = (List) json.deserialize(foe.get(0).getMilitaryid());
					if(mids.isEmpty()){//随机选取一定武将，放入rolechallenge
						param.clear();
						param.put("roleId", id);
						List<RoleMilitaryDetail> roe = this.getRoleMilitaryService().getRoleMilitaryByparam(param);
						if(roe.isEmpty()){
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-5);
							ServerHandler.sendData(session, respMap);
							return;
						}
						//根据等级出战数量
						List ary = new ArrayList();
						int num=0;//出战武将数
						int level = gamerole2.getLevel();
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
						this.militaryDetail(ary,id, list3,litotem2);
						this.foeMilitary(ary,id, list2,litotem2);
						roe=null;
						ary=null;
					}else{
						this.militaryDetail(mids,id, list3,litotem2);// 获得武将列表信息
						this.foeMilitary(mids,id, list2,litotem2);
					}
					map.clear();
//					rlt.put("mids", list2);
					map.put("mids", list2);
//					rlt.put("id", id);
//					rlt.put("name", gamerole.getName());
					int success = foe.get(0).getSuccess();
					int total = foe.get(0).getTotals();
					beihitrate=(success*100/(total+1));
					if(total==0){
						map.put("percent", 100);
					}else{
						map.put("percent", success*100/total);
					}
					mids=null;
				} else {// 对手不存在
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);
					ServerHandler.sendData(session, respMap);
					return;
				}
				map.put("level", gamerole2.getLevel());
				map.put("name", gamerole2.getName());
				rlt.put("foe", map);
				// 开始攻击
				if(list1.size()>list3.size()){//最大回合数
					int size1 = list1.size();
					for(int i=0;i<50;i++){
						
					if(list1.isEmpty() || list3.isEmpty()){
							break;
						}
						faight(list1, list3, list,roleid,id);
					}
				}else{
					int size3 = list3.size();
					for(int i=0;i<50;i++){
						
						if(list1.isEmpty() || list3.isEmpty()){
							break;
						}
						faight(list1, list3, list,roleid,id);
					}
				}
				//判断谁胜利了
				int success = rolechallenge.get(0).getSuccess();
				int total = rolechallenge.get(0).getTotals();
				String state0 = gamerole.getAimreward();
				JSONArray aimreward = JSONArray.fromObject(state0);//目标大奖状态
				if(aimreward.getInt(9)==0){//10。争霸战取得10场胜利
					if(success>=10){
						aimreward.set(9, 1);
						param.clear();
						param.put("id", roleid);
						param.put("aimreward", aimreward.toString());
						this.getGameRoleService().updateRoleVip(param);
					}
				}
				if(list1.isEmpty()){
					rlt.put("win", id);//对手胜利
					param.clear();
					param.put("roleid", roleid);
					param.put("totals", (total+1));
					param.put("win", 0);
					this.getRoleChallengeService().updateRoleChallenge(param);
					rlt.put("percent", (success*100/(total+1)));
					winid=id;
					//更新胜率........
				}else if(list3.isEmpty()){
					rlt.put("win", roleid);//本家胜利
					param.clear();
					param.put("roleid", roleid);
					param.put("success", (success+1));
					param.put("totals", (total+1));
					param.put("win", 1);
					this.getRoleChallengeService().updateRoleChallenge(param);
					rlt.put("percent", ((success+1)*100/(total+1)));
					winid=roleid;
				}
				rlt.put("list", list);
				foe=null;
			}else{//和机器人战斗
				url.add("http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
				param.clear();
				param.put("id", id);
				beihittoux=url.toString();
				litotem2=(List) json1.deserialize("[]");
				rlt.put("totem",litotem2);
				List<GameRobotDetail> robot = this.getGameRobotService().findGameRobot(param);
				if(robot.isEmpty()){//机器人不存在
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);
					ServerHandler.sendData(session, respMap);
					return;
				}else{//可以战斗
					JsonSerializer json = new JsonSerializer();
					List<Map<String, Object>> mids = (List<Map<String, Object>>) json.deserialize(robot.get(0).getMilitarys());
					if(mids.size()==0){
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-5);
						ServerHandler.sendData(session, respMap);
						return;
					}
					for(int i=0;i<mids.size();i++){
						int mid = Integer.parseInt(String.valueOf(mids.get(i).get("id")));//武将id
						List<GameMilitaryDetail> gamemilitary = this
						.getGameMilitaryService().getGameMilitaryBymid(mid);
						int level = Integer.parseInt(String.valueOf(mids.get(i).get("level")));//武将等级
						int attack = 0;
						int speed = 0;
						int xueliang = 0;
						int types = 0;
						String name = "";//武将名字
						int pinzhi = 0;
						String desc=null;
						int artm=0;
						if (!gamemilitary.isEmpty()) {
							attack = gamemilitary.get(0).getGongji()+(gamemilitary.get(0).getGjiacheng()* (level-1));
							speed = gamemilitary.get(0).getGongsu();
							xueliang = gamemilitary.get(0).getXueliang()+(gamemilitary.get(0).getXljiacheng()*  (level-1));
							name = gamemilitary.get(0).getName();
							types = gamemilitary.get(0).getType();
							pinzhi = gamemilitary.get(0).getPingzhi();
							desc=gamemilitary.get(0).getDesc();
							artm=gamemilitary.get(0).getArts();
							
						} 
						int addattack = Integer.parseInt(String.valueOf(mids.get(i).get("addattack")));
						int addspeed = Integer.parseInt(String.valueOf(mids.get(i).get("addspeed")));
						int addxueliang = Integer.parseInt(String.valueOf(mids.get(i).get("addxueliang")));
						map.clear();
						map.put("gongji", attack+addattack);
						map.put("gongsu", (speed+addspeed));
						map.put("xueliang", (xueliang+addxueliang));
						//被动技能
						int arts = gamemilitary.get(0).getArts();
						if(arts!=0){
							List<GameSkillDetail> gameSkill = this.getGameSkillService().getGameSkillById(arts);
							if(!gameSkill.isEmpty()){
								map.put("skillid", gameSkill.get(0).getId());
								map.put("skillodd", gameSkill.get(0).getSkillodd());
								JSONArray bary = JSONArray.fromObject(gameSkill.get(0).getSkillBuffId());
								if(!bary.isEmpty()){
									bary.get(0);
									List<GameBuffDetail> gameBuff = this.getGameBuffService().getGameBuffById(Integer.parseInt(String.valueOf(bary.get(0))));
									if(!gameBuff.isEmpty()){
										map.put("buffatktime", gameBuff.get(0).getBuffAtktime());
										map.put("buffobj", gameBuff.get(0).getBuffobj());
										map.put("speed", gameBuff.get(0).getSpeed());
										map.put("attack", gameBuff.get(0).getAttack());
										map.put("health", gameBuff.get(0).getHealth());
										map.put("miss", gameBuff.get(0).getMiss());
										map.put("baoji", gameBuff.get(0).getBaoji());
									}else{
										continue;
									}
									gameBuff=null;
								}
								bary=null;
						}else{
							continue;
						}
						gameSkill=null;
						}else{//没有技能
							map.put("skillid", 0);
							map.put("skillodd", 0);
							map.put("buffatktime", 0);
							map.put("buffobj", 0);
							map.put("speed", 0);
							map.put("attack", 0);
							map.put("health", 0);
							map.put("miss", 0);
							map.put("baoji", 0);
						}
						list3.add(map);
						map.clear();
						map.put("_att", attack);
						map.put("_attsp", speed);
						map.put("_blood", xueliang);
						map.put("_att_add", addattack);
						map.put("_attsp_add", addspeed);
						map.put("_blood_add", addxueliang);
						//附加
						map.put("militaryid", mid);
						map.put("name",name);
						map.put("level", level);
						//获得jobname
						String jobname = "";
						if(level<10){
							level = 1;
						}else if(level>=10 && level<25){
							level = 10;
						}else if(level>=25 && level<45){
							level = 25;
						}else{
							level = 45;
						}
						param.clear();
						param.put("type", types);
						param.put("level", level);
						jobname  = this.getGameChLevelService().findGameChLevelByparas(param).get(0).getName();
						map.put("url", desc);
					    map.put("arts", artm);
						map.put("_jobName", jobname);//职业
						map.put("types", types);
						map.put("pinzhi",pinzhi);
						list2.add(map);
						Map<String,Object> m= new HashMap<String,Object>();
						m.clear();
						m.put("mids", list2);
						m.put("level", robot.get(0).getLevel());
						m.put("name", robot.get(0).getName());
						m.put("percent", robot.get(0).getPercent());
						rlt.put("foe", m);
						beihitrate=robot.get(0).getPercent();
						gamemilitary=null;
					}
					//开始战斗
					if(list1.size()>list3.size()){//最大回合数
						int size1 = list1.size();
						for(int i=0;i<50;i++){
							if(list1.isEmpty() || list3.isEmpty()){
								break;
							}
							faight(list1, list3, list,roleid,id);
						}
					}else{
						int size3 = list3.size();
						for(int i=0;i<50;i++){
							if(list1.isEmpty() || list3.isEmpty()){
								break;
							}
							faight(list1, list3, list,roleid,id);
						}
					}
					//判断谁胜利了
					int success = rolechallenge.get(0).getSuccess();
					int total = rolechallenge.get(0).getTotals();
					if(list1.isEmpty()){
						rlt.put("win", id);//对手胜利
						param.clear();
						param.put("roleid", roleid);
						param.put("totals", (total+1));
						param.put("win", 0);
						this.getRoleChallengeService().updateRoleChallenge(param);
						rlt.put("percent", (success*100/(total+1)));
						winid=id;
						//更新胜率........
					}else if(list3.isEmpty()){
						rlt.put("win", roleid);//本家胜利
						param.clear();
						param.put("roleid", roleid);
						param.put("success", (success+1));
						param.put("totals", (total+1));
						param.put("win", 1);
						this.getRoleChallengeService().updateRoleChallenge(param);
						rlt.put("percent", ((success+1)*100/(total+1)));
						winid=roleid;
					}
					rlt.put("list", list);
					mids=null;
					robot=null;
				}
				
			}
			//领取奖励
			this.challengeover(t, id, roleid, rlt);
			rlt.put("url", url);//url数组，第一个是自己，第二个是别人
		    //rlt.put("challengenum", this.getGameRoleService().findRoleById(roleid).getChallengenum());
			rlt.put("challengenum", challengenum);
			rlt.put("r", r);
			//System.out.println("map.attack:rlt:" + rlt.toString());
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
			String stlist=list.toString();
			String midslist2=list2.toString();
			Date dt=new Date();
			SimpleDateFormat matter1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dqtime=matter1.format(dt);//得到当前时间
			 //根据hitid判断数据表里面beihitid的数据是否大于20，大于就更新，小于就插入
			 //得到第一条数据，即时间最小的，根据Id更新
			 param.clear();
			 param.put("beihitid",id);
			 List<ChallengeRecordDetail> crd=this.getChallengeRecordService().findallchallengeId(param);
					if(crd.size()>=20){//只插入20个数据，大于20就更新
						int bid=crd.get(0).getId();
						param.clear();
						param.put("hitid",roleid );
						param.put("beihitid", id);
						param.put("time", dqtime);
						param.put("record",stlist );
						param.put("mids",midslist2 );
						param.put("hitmids",stlist02 );
						param.put("hitname",hitname);
						param.put("beihitname",beihitname );
						param.put("winid", winid);
						param.put("hitrate", hitrate);
						param.put("beihitrate", beihitrate);
						param.put("hittoux", hittoux);
						param.put("beihittoux", beihittoux);
						param.put("hitlevel", hitlevel);
						param.put("beihitlevel", beihitlevel);
						param.put("id",bid);
						param.put("totem",litotem2.toString());
						param.put("totemtwo", litotem.toString());
						this.getChallengeRecordService().updateChallenge(param);
					}else{
						param.clear();
						param.put("hitid",roleid );
						param.put("beihitid", id);
						param.put("time", dqtime);
						param.put("record",stlist );
						param.put("mids",midslist2 );
						param.put("hitmids",stlist02 );
						param.put("hitname",hitname);
						param.put("beihitname",beihitname );
						param.put("winid", winid);
						param.put("hitrate", hitrate);
						param.put("beihitrate", beihitrate);
						param.put("hittoux", hittoux);
						param.put("beihittoux", beihittoux);
						param.put("hitlevel", hitlevel);
						param.put("beihitlevel", beihitlevel);
						param.put("totem", litotem2.toString());
						param.put("totemtwo", litotem.toString());
						this.getChallengeRecordService().insertChallengerecord(param);
					}
					//把战斗记录存放到表里
					int size = GlobalData.cacheGameMap.size();
					url=null;
					//r =1;
					//System.out.println("是否全服通知：：r:" + r);
					if(r==1){//全服通知玩家复仇
						if(winid==roleid){//复仇成功
							String message="玩家<font color="+"\"#FF8000\">"+hitname+"</font>向玩家<font color=\"#FF8000\">"+beihitname+"</font>复仇成功。";
							//this.getsystemHandler().messagetwo(message);
							this.getsystemHandler().addMessage(message);
						}else{
							String message="玩家<font color="+"\"#FF8000\">"+hitname+"</font>向玩家<font color=\"#FF8000\">"+beihitname+"</font>复仇失败。";
							//this.getsystemHandler().messagetwo(message);
							this.getsystemHandler().addMessage(message);
						}
					}
			list1=null;
			list2=null;
			list3=null;
			list=null;
			rlt=null;
			param=null;
			map=null;
			rolechallenge=null;
		}
	}

	private void challengefastover(int t, int id, int roleid,
			Map<String, Object> rlt, int xy) {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		param.clear();
		param.put("roleid", roleid);
		List<RoleChallengeDetail> challenge = this.getRoleChallengeService().findRoleChallengeById(param);
		GameLevelDetail gamelevel = null ;
//		System.out.println("=============5===============");
		 GameRoleDetail game = this.getGameRoleService().findRoleById4(roleid);
//		 System.out.println("=============6===============");
		 int level = 0;//对手等级
		if(t==1){//和玩家战斗
//			System.out.println("=============7===============");
			level =this.getGameRoleService().findRoleById4(id).getLevel();//对手等级
//			System.out.println("=============8===================");
			gamelevel = this.getGameLevelService().getGameLevelByRoleLevel(level);
		}else{//和机器人战斗
			param.clear();
			param.put("id", id);
			List<GameRobotDetail> gamerobot = this.getGameRobotService().findGameRobot(param);
			if(!challenge.isEmpty()){
				if(!gamerobot.isEmpty()){
					level = gamerobot.get(0).getLevel();
					gamelevel = this.getGameLevelService()
						.getGameLevelByRoleLevel(level);
				}else{//机器人不存在
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
					ServerHandler.sendData(session, respMap);
					return;
				}
			}
			gamerobot=null;
		}
		//获得奖励
		int needexp = this.getGameLevelService().getGameLevelByRoleLevel(
				game.getLevel()).getNeedexp();// 升级所需经验
		int exp = game.getExp();
		int gongxun = game.getGongxun();
		int yin = game.getYin();
		int upplevel = 0;//判断是否升级
		//JSONArray rewardjl = new JSONArray();//添加军令
		JSONArray reward = new JSONArray();
		//List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		if(!challenge.isEmpty()){
			int win = challenge.get(0).getWin();
			if(win==1){//胜利
				param.clear();
				param.put("id", roleid);
				param.put("yin", (gamelevel.getGetcoin()*xy+yin));
				param.put("gongxun", (gamelevel.getGetgongxun()*xy+gongxun));
				param.put("exp", (gamelevel.getGetexp()*xy+exp));
				this.getGameRoleService().updateRoleVip(param);
				map.clear();
				map.put("flag",1);
				map.put("num", gamelevel.getGetcoin()*xy);
				reward.add(map);
				map.clear();
				map.put("flag",3);
				map.put("num", gamelevel.getGetexp()*xy);
				reward.add(map);
				map.clear();
				map.put("flag",4);
				map.put("num",  gamelevel.getGetgongxun()*xy);
				reward.add(map);
				map.clear();
				
				map.put("yin", gamelevel.getGetcoin()*xy);
				map.put("gongxun", gamelevel.getGetgongxun()*xy);
				map.put("exp", gamelevel.getGetexp()*xy);
				//System.out.println("争霸战自己胜利：：：：：：gongxun：：："+gamelevel.getGetgongxun()+"::::::exp::"+gamelevel.getGetexp());
				
				// 判断是否可以升级
				upplevel = this.getplayerHandler().shengji(roleid, game.getLevel(), exp, gamelevel.getGetexp()*xy);	
				// 更改下次升级所需经验
				int junling;
				if(upplevel==1){//已升级
//					System.out.println("=============9===============");
					GameRoleDetail gamerole = this.getGameRoleService().findRoleById4(roleid);
					map.put("totalyin", gamerole.getYin());
					map.put("totalgongxun", gamerole.getGongxun());
					map.put("totalexp", gamerole.getExp());
					map.put("level", gamerole.getLevel());
					needexp = this.getGameLevelService()
					.getGameLevelByRoleLevel(gamerole.getLevel()).getNeedexp();
					map.put("needexp", needexp);
					map.put("upplevel", upplevel);
  		        	//rlt.put("gift", map);
					junling = gamerole.getJunling();
//					System.out.println("===============99=====================");
				
				}else{//没有升级
//					System.out.println("=============10===============");
//					map.put("totalyin",(gamelevel.getGetcoin()+yin));
//					map.put("totalgongxun", (gamelevel.getGetgongxun()+gongxun));
//					map.put("totalexp",(gamelevel.getGetexp()+exp));
					map.put("totalyin",(gamelevel.getGetcoin()*xy+yin));
					map.put("totalgongxun", (gamelevel.getGetgongxun()*xy+gongxun));
					map.put("totalexp",(gamelevel.getGetexp()*xy+exp));
					map.put("level", game.getLevel());
					needexp = this.getGameLevelService()
					.getGameLevelByRoleLevel(game.getLevel()).getNeedexp();
					map.put("needexp", needexp);
					map.put("upplevel", upplevel);
  		        	//rlt.put("gift", map);
					junling = game.getJunling();
//					System.out.println("===============1010=====================");
				}
	
				//获得道具
				int[] ary = {0,2,9,10,11,17};//0是军令
				Random random = new Random();
				 int addjjnum=0;
				Map<String, Object> params = new HashMap<String, Object>();
				for(int i=0;i<xy;i++){//扫荡n，循环n次随机给奖励
					if(random.nextInt(100)<50){

						int itemid = ary[random.nextInt(ary.length)];
						if(itemid==0){//获得军令
							addjjnum++;
//							param.clear();
//							param.put("id", roleid);
//							param.put("junling", (junling+1));
//							this.getGameRoleService().updateRoleVip(param);
							param.clear();
							param.put("num", 1);
							param.put("flag", 2);//代表军令
							reward.add(param);
							
						}else{//获得道具
							// 道具
//							List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
							params.clear();
							params.put("roleid", roleid);
							params.put("itemid", itemid);
							List<RoleItemDetail> item = this
									.getRoleItemService().getRoleItem(params);
							params.put("num", 1);// 获得数量
							params.put("resType", 5);
							// 判断背包格子是否已满
							int itemtype = this.getGameItemService()
									.getGameItemById(itemid).get(0).getItemtype();
							boolean boo = this.getplayerHandler().getShangxian(itemtype, 5, roleid,
									itemid, 1);
							if (boo == false) {// 背包格子不足
								respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);
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
									params.put("id", itemid);
									params.remove("roleid");
									params.remove("itemid");
									reward.add(params);
								} else {

								}
							} else {// 不存在，
//								int bid = this.getAutoIdService()
//										.fingKeyValueByTableName("role_item") + 1;
								long bid = this.getAutoIdService().fingKeyValueByTableName("role_item") + 0L;
								RoleItemDetail iDetail = new RoleItemDetail();
								iDetail.setId(bid);
								iDetail.setRoleid(roleid);
								iDetail.setItemid(itemid);
								iDetail.setNum(1);
								iDetail.setFlag(1);
								iDetail.setType(itemtype);
								boolean bo = this.getRoleItemService().insertRoleItem(iDetail);
								//this.getAutoIdService().updateKeyValueAddOneByTableName("role_item");
								if (bo == true) {
									params.put("bid", bid);
									params.remove("roleid");
									params.put("id", itemid);
									params.remove("itemid");
									reward.add(params);
								}
								iDetail=null;
							}
							item=null;
						}
						
					}
				}
				param.clear();
				param.put("id", roleid);
				param.put("junling", (junling+addjjnum));
				this.getGameRoleService().updateRoleVip(param);
				map.put("junling", junling+addjjnum);
				rlt.put("gift", map);
				//gamerole=null;
				ary=null;
			}else if(win==0){//失败
				param.clear();
				param.put("id", roleid);
				param.put("yin", (int) (gamelevel.getGetcoin()*0.5*xy)+yin);
				param.put("gongxun", (int) (gamelevel.getGetgongxun()*0.5*xy)+gongxun);
				param.put("exp", (int) (gamelevel.getGetexp()*0.5*xy)+exp);
				this.getGameRoleService().updateRoleVip(param);
				map.clear();
				map.put("flag",1);
				map.put("num", gamelevel.getGetcoin()*0.5*xy);
				reward.add(map);
				map.clear();
				map.put("flag",3);
				map.put("num",gamelevel.getGetexp()*0.5*xy);
				reward.add(map);
				map.clear();
				map.put("flag",4);
				map.put("num",  gamelevel.getGetgongxun()*0.5*xy);
				reward.add(map);
				map.clear();
				
				map.clear();
				map.put("yin", (int) (gamelevel.getGetcoin()*0.5*xy));
				map.put("gongxun", (int) (gamelevel.getGetgongxun()*0.5*xy));
				map.put("exp", (int) (gamelevel.getGetexp()*0.5*xy));
				
				//System.out.println("争霸战自己失败：：：：：：gongxun：：："+(gamelevel.getGetgongxun()*0.5)+"::::::exp::"+gamelevel.getGetexp()*0.5);
				
				// 判断是否可以升级
				upplevel = this.getplayerHandler().shengji(roleid, game.getLevel(), exp, (int) (gamelevel.getGetexp()*0.5)*xy);
				// 更改下次升级所需经验
				int junling;
				if(upplevel==1){//已升级
//					System.out.println("=============11===============");
					GameRoleDetail gamerole = this.getGameRoleService().findRoleById4(roleid);
					map.put("totalyin", gamerole.getYin());
					map.put("totalgongxun", gamerole.getGongxun());
					map.put("totalexp", gamerole.getExp());
					map.put("level", gamerole.getLevel());
					needexp = this.getGameLevelService()
					.getGameLevelByRoleLevel(gamerole.getLevel()).getNeedexp();
					map.put("needexp", needexp);
					map.put("upplevel", upplevel);
  		        	rlt.put("gift", map);
					junling = gamerole.getJunling();
//					System.out.println("===============1111=====================");
				
				}else{//没有升级
//					System.out.println("=============12===============");
//					map.put("totalyin",(gamelevel.getGetcoin()+yin));
//					map.put("totalgongxun", (gamelevel.getGetgongxun()+gongxun));
//					map.put("totalexp",(gamelevel.getGetexp()+exp));
					map.put("totalyin",(gamelevel.getGetcoin()*0.5*xy+yin));
					map.put("totalgongxun", (gamelevel.getGetgongxun()*0.5*xy+gongxun));
					map.put("totalexp",(gamelevel.getGetexp()*0.5*xy+exp));
					map.put("level", game.getLevel());
					needexp = this.getGameLevelService()
					.getGameLevelByRoleLevel(game.getLevel()).getNeedexp();
					map.put("needexp", needexp);
					map.put("upplevel", upplevel);
  		        	rlt.put("gift", map);
					junling = game.getJunling();
//					System.out.println("===============1212=====================");
				}
				
				
			}
		}
		//reward.add(rewardjl);
		//reward.add(list);
		rlt.put("reward", reward);
		rlt=null;
		challenge=null;
		param=null;
		map=null;
		gamelevel=null;
		game=null;
		//rewardjl=null;
	
	
	}
	
	
	private void changebutton() {
		Map<String, Object> rlt = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		int roleid = Integer.parseInt(playerId);
		param.put("roleid", roleid);
		String mids = this.getRoleChallengeService().findRoleChallengeById(
				param).get(0).getMilitaryid();
		JsonSerializer json = new JsonSerializer();
		List<Map<String, Object>> militaryids = (List<Map<String, Object>>) json
				.deserialize(mids);
		rlt.put("mids", militaryids);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);
		rlt=null;
		param=null;
		militaryids=null;
	}

	private void updateroles() {
		long a = System.currentTimeMillis();
//		System.out.println("更新争霸战开始" +  Integer.parseInt(playerId));
		int roleid = Integer.parseInt(playerId);
		Map<String, Object> rlt = new HashMap<String, Object>();
		JSONArray ary = new JSONArray();
		GameRoleDetail gameRole = this.getGameRoleService().findRoleById(roleid);
		int level = gameRole.getLevel();
//		GameRoleDetail gameRole = (GameRoleDetail) session.getAttribute("gamerole");
//		if(gameRole==null){
//			gameRole=this.getGameRoleService().findRoleById(roleid);
//		}
//		int level=gameRole.getLevel();
		JSONArray roleIds=null;
		int serverid=0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
//		System.out.println("level:" + level);
			if(level<11){//创建机器人
				int size = ary0.size();
				if (size >= 20) {
					int[] ints = ran(size, 20);
					for (int i = 0; i < 20; i++) {
						ary.add(ary0.get(ints[i]));
					}
					rlt.put("roles", ary);
				}
			//	System.out.println(ary+"=============ary");
			} else{
					if(level>1&&level<21){//ary1
						int size = 0;
						if(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).containsKey(1)){
							size=GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(1).size();
						}
//						System.out.println("size:" + size);
						if (size > 20) {
//							System.out.println("ary1==========200");
							int[] ints = ran(size, 20);
							JSONArray ary2 = new JSONArray();
							for(int i=0;i<20;i++){
//								int id=Integer.parseInt(String.valueOf(ary11.get(ints[i])));
//								if(id==roleid){
//									continue;
//								}
								 Map map1=	(Map) GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(1).get(ints[i]);
									int id=Integer.parseInt(String.valueOf( map1.get("id")));
										if(roleid==id){
											continue;
										}
								ary2.add(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(1).get(ints[i]));
							}
							rlt.put("roles", ary2);
//							System.out.println("ary2:" + ary2.toString());
						} else {// 小于20个玩家
							
						//	System.out.println("ary1==========2");
							JSONArray aryy = new JSONArray();
							int[] ints0 = ran(size, size);
							for(int i=0;i<size;i++){
		                  Map map1=	(Map) GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(1).get(ints0[i]);
							int id=Integer.parseInt(String.valueOf( map1.get("id")));
								if(roleid==id){
									continue;
								}
									
								aryy.add(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(1).get(ints0[i]));
							}
							// 添加机器人
							param.clear();
							param.put("level", level);
							List<GameRobotDetail> robot = this.getGameRobotService()
									.findGameRobot(param);
							int num = robot.size();
							int[] ints = ran(num, (20-size));
							Map<String, Object> m = new HashMap<String, Object>();
							int r = 0;
							for (int i = 0; i < (20 - size); i++) {
								r = ints[i];
								map.clear();
								map.put("name", robot.get(r).getName());
								map.put("level", robot.get(r).getLevel());
								map.put("percent", robot.get(r).getPercent());
								// 机器人
								map.put("t", 0);
								map.put("id", robot.get(r).getId());
								map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
								aryy.add(map);
							}
							robot.clear();
							rlt.put("roles", aryy);
						}
					}else if(level>20&&level<31){//ary2
						
						int size = 0;
						if(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).containsKey(2)){
							size=GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(2).size();
						}
						if (size > 20) {
							//System.out.println("ary2==========200");
							int[] ints = ran(size, 20);
							JSONArray ary02 = new JSONArray();
							for(int i=0;i<20;i++){
								 Map map1=	(Map) GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(2).get(ints[i]);
									int id=Integer.parseInt(String.valueOf( map1.get("id")));
										if(roleid==id){
											continue;
										}
								ary02.add(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(2).get(ints[i]));
							}
							rlt.put("roles", ary02);
							
						} else {// 小于20个玩家
							//System.out.println("ary2==========2");
							JSONArray aryy = new JSONArray();
							int[] ints0 = ran(size, size);
							for(int i=0;i<size;i++){
							Map map1=	(Map) GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(2).get(ints0[i]);
							int id=Integer.parseInt(String.valueOf( map1.get("id")));
								if(roleid==id){
									continue;
								}
									
								aryy.add(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(2).get(ints0[i]));
							}
							// 添加机器人
							param.clear();
							param.put("level", level);
							List<GameRobotDetail> robot = this.getGameRobotService()
									.findGameRobot(param);
							int num = robot.size();
							int[] ints = ran(num, (20-size));
							Map<String, Object> m = new HashMap<String, Object>();
							int r = 0;
							for (int i = 0; i < (20 - size); i++) {
								r = ints[i];
								map.clear();
								map.put("name", robot.get(r).getName());
								map.put("level", robot.get(r).getLevel());
								map.put("percent", robot.get(r).getPercent());
								// 机器人
								map.put("t", 0);
								map.put("id", robot.get(r).getId());
								map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
								aryy.add(map);
							}
							robot.clear();
							rlt.put("roles", aryy);
						}
					
						
					}else if(level>30&&level<41){//ary3
						int size = 0;
						if(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).containsKey(3)){
							size=GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(3).size();
						}
						if (size > 20) {
							//System.out.println("ary3==========200");
							int[] ints = ran(size, 20);
							JSONArray ary2 = new JSONArray();
							for(int i=0;i<20;i++){
								 Map map1=	(Map) GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(3).get(ints[i]);
									int id=Integer.parseInt(String.valueOf( map1.get("id")));
										if(roleid==id){
											continue;
										}
								ary2.add(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(3).get(ints[i]));
							}
							rlt.put("roles", ary2);
							
						} else {// 小于20个玩家
							//System.out.println("ary1==========2");
							JSONArray aryy = new JSONArray();
							int[] ints0 = ran(size, size);
							for(int i=0;i<size;i++){
		                  Map map1=	(Map) GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(3).get(ints0[i]);
							int id=Integer.parseInt(String.valueOf( map1.get("id")));
								if(roleid==id){
									continue;
								}
									
								aryy.add(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(3).get(ints0[i]));
							}
							// 添加机器人
							param.clear();
							param.put("level", level);
							List<GameRobotDetail> robot = this.getGameRobotService()
									.findGameRobot(param);
							int num = robot.size();
							int[] ints = ran(num, (20-size));
							Map<String, Object> m = new HashMap<String, Object>();
							int r = 0;
							for (int i = 0; i < (20 - size); i++) {
								r = ints[i];
								map.clear();
								map.put("name", robot.get(r).getName());
								map.put("level", robot.get(r).getLevel());
								map.put("percent", robot.get(r).getPercent());
								// 机器人
								map.put("t", 0);
								map.put("id", robot.get(r).getId());
								map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
								aryy.add(map);
							}
							robot.clear();
							rlt.put("roles", aryy);
						}
					
					}else if(level>40&&level<51){//ary4
						int size = 0;
						if(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).containsKey(4)){
							size=GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(4).size();
						}
						if (size > 20) {
							//System.out.println("ary4==========200");
							int[] ints = ran(size, 20);
							JSONArray ary2 = new JSONArray();
							for(int i=0;i<20;i++){
								 Map map1=	(Map) GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(4).get(ints[i]);
									int id=Integer.parseInt(String.valueOf( map1.get("id")));
										if(roleid==id){
											continue;
										}
								ary2.add(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(4).get(ints[i]));
							}
							rlt.put("roles", ary2);
							
						} else {// 小于20个玩家
							//System.out.println("ary4==========2");
							JSONArray aryy = new JSONArray();
							int[] ints0 = ran(size, size);
							for(int i=0;i<size;i++){
		                  Map map1=	(Map) GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(4).get(ints0[i]);
							int id=Integer.parseInt(String.valueOf( map1.get("id")));
								if(roleid==id){
									continue;
								}
									
								aryy.add(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(4).get(ints0[i]));
							}
							// 添加机器人
							param.clear();
							param.put("level", level);
							List<GameRobotDetail> robot = this.getGameRobotService()
									.findGameRobot(param);
							int num = robot.size();
							int[] ints = ran(num, (20-size));
							Map<String, Object> m = new HashMap<String, Object>();
							int r = 0;
							for (int i = 0; i < (20 - size); i++) {
								r = ints[i];
								map.clear();
								map.put("name", robot.get(r).getName());
								map.put("level", robot.get(r).getLevel());
								map.put("percent", robot.get(r).getPercent());
								// 机器人
								map.put("t", 0);
								map.put("id", robot.get(r).getId());
								map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
								aryy.add(map);
							}
							robot.clear();
							rlt.put("roles", aryy);
						}
					
					}else if(level>50&&level<61){//ary5
						int size = 0;
						if(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).containsKey(5)){
							size=GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(5).size();
						}
						if (size > 20) {
							//System.out.println("ary5==========200");
							int[] ints = ran(size, 20);
							JSONArray ary2 = new JSONArray();
							for(int i=0;i<20;i++){
								 Map map1=	(Map) GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(5).get(ints[i]);
									int id=Integer.parseInt(String.valueOf( map1.get("id")));
										if(roleid==id){
											continue;
										}
								ary2.add(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(5).get(ints[i]));
							}
							rlt.put("roles", ary2);
							
						} else {// 小于20个玩家
							
							//("ary5==========2");
							JSONArray aryy = new JSONArray();
							int[] ints0 = ran(size, size);
							for(int i=0;i<size;i++){
		                  Map map1=	(Map) GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(5).get(ints0[i]);
							int id=Integer.parseInt(String.valueOf( map1.get("id")));
								if(roleid==id){
									continue;
								}
									
								aryy.add(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(5).get(ints0[i]));
							}
							// 添加机器人
							param.clear();
							param.put("level", level);
							List<GameRobotDetail> robot = this.getGameRobotService()
									.findGameRobot(param);
							int num = robot.size();
							int[] ints = ran(num, (20-size));
							Map<String, Object> m = new HashMap<String, Object>();
							int r = 0;
							for (int i = 0; i < (20 - size); i++) {
								r = ints[i];
								map.clear();
								map.put("name", robot.get(r).getName());
								map.put("level", robot.get(r).getLevel());
								map.put("percent", robot.get(r).getPercent());
								// 机器人
								map.put("t", 0);
								map.put("id", robot.get(r).getId());
								map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
								aryy.add(map);
							}
							robot.clear();
							rlt.put("roles", aryy);
						}
					
					}else if(level>60&&level<71){//ary6
						int size = 0;
						if(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).containsKey(6)){
							size=GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(6).size();
						}
						if (size > 20) {
							//System.out.println("ary6==========200");
							int[] ints = ran(size, 20);
							JSONArray ary2 = new JSONArray();
							for(int i=0;i<20;i++){
								 Map map1=	(Map) GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(6).get(ints[i]);
									int id=Integer.parseInt(String.valueOf( map1.get("id")));
										if(roleid==id){
											continue;
										}
								ary2.add(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(6).get(ints[i]));
							}
							rlt.put("roles", ary2);
							
						} else {// 小于20个玩家
							
							//System.out.println("ary6==========2");
							JSONArray aryy = new JSONArray();
							int[] ints0 = ran(size, size);
							for(int i=0;i<size;i++){
		                  Map map1=	(Map) GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(6).get(ints0[i]);
							int id=Integer.parseInt(String.valueOf( map1.get("id")));
								if(roleid==id){
									continue;
								}
									
								aryy.add(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(6).get(ints0[i]));
							}
							// 添加机器人
							param.clear();
							param.put("level", level);
							List<GameRobotDetail> robot = this.getGameRobotService()
									.findGameRobot(param);
							int num = robot.size();
							int[] ints = ran(num, (20-size));
							Map<String, Object> m = new HashMap<String, Object>();
							int r = 0;
							for (int i = 0; i < (20 - size); i++) {
								r = ints[i];
								map.clear();
								map.put("name", robot.get(r).getName());
								map.put("level", robot.get(r).getLevel());
								map.put("percent", robot.get(r).getPercent());
								// 机器人
								map.put("t", 0);
								map.put("id", robot.get(r).getId());
								map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
								aryy.add(map);
							}
							robot.clear();
							rlt.put("roles", aryy);
						}
					
					}else if(level>70&&level<101){//ary7
						int size = 0;
						if(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).containsKey(7)){
							size=GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(7).size();
						}
						if (size > 20) {
							//System.out.println("ary7==========200");
							int[] ints = ran(size, 20);
							JSONArray ary2 = new JSONArray();
							for(int i=0;i<20;i++){
								 Map map1=	(Map) GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(7).get(ints[i]);
									int id=Integer.parseInt(String.valueOf( map1.get("id")));
										if(roleid==id){
											continue;
										}
								ary2.add(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(7).get(ints[i]));
							}
							rlt.put("roles", ary2);
							
						} else {// 小于20个玩家
							//System.out.println("ary7==========2");
							JSONArray aryy = new JSONArray();
							int[] ints0 = ran(size, size);
							for(int i=0;i<size;i++){
		                  Map map1=	(Map) GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(7).get(ints0[i]);
							int id=Integer.parseInt(String.valueOf( map1.get("id")));
								if(roleid==id){
									continue;
								}
									
								aryy.add(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(7).get(ints0[i]));
							}
							// 添加机器人
							param.clear();
							param.put("level", level);
							List<GameRobotDetail> robot = this.getGameRobotService()
									.findGameRobot(param);
							int num = robot.size();
							int[] ints = ran(num, (20-size));
							Map<String, Object> m = new HashMap<String, Object>();
							int r = 0;
							for (int i = 0; i < (20 - size); i++) {
								r = ints[i];
								map.clear();
								map.put("name", robot.get(r).getName());
								map.put("level", robot.get(r).getLevel());
								map.put("percent", robot.get(r).getPercent());
								// 机器人
								map.put("t", 0);
								map.put("id", robot.get(r).getId());
								map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
								aryy.add(map);
							}
							robot.clear();
							rlt.put("roles", aryy);
						}
					
					}
				
			}
//		if(level>10&&level<21){
//			    roleIds = ary1;
//			  
//		}else if(level>20&&level<31){
//		       roleIds = ary2;
//		}else if(level>30&&level<41){
//			   roleIds = ary3;
//		}else if(level>40&&level<51){
//			   roleIds = ary4;
//		}else if(level>50&&level<61){
//		       roleIds = ary5;
//		}else if(level>60&&level<71){
//		        roleIds = ary6;
//		}else if(level>70&&level<81){
//		        roleIds = ary7;
//		}  
//		
//		//JSONArray roleIds = (JSONArray) session.getAttribute("challenge");
//		int size = roleIds.size();
//		if (size >= 20) {
//			int[] ints = ran(size, 20);
//			for (int i = 0; i < 20; i++) {
//				ary.add(roleIds.get(ints[i]));
//			}
//			rlt.put("roles", ary);
//		} else {// 小于20个玩家
//			Map<String, Object> map = new HashMap<String, Object>();
//			Map<String, Object> param = new HashMap<String, Object>();
//			int[] ints = ran(size, size);
//			for (int i = 0; i < size; i++) {
//				ary.add(roleIds.get(ints[i]));
//				
//			}
//			// 添加机器人
//			param.clear();
//			param.put("level", level);
//			List<GameRobotDetail> robot = this.getGameRobotService()
//					.findGameRobot(param);
//			int num = robot.size();
//			ints = ran(num, (20-size));
//			Map<String, Object> m = new HashMap<String, Object>();
//			int r = 0;
//			for (int i = 0; i < (20 - size); i++) {
//				r = ints[i];
//				map.clear();
//				map.put("name", robot.get(r).getName());
//				map.put("level", robot.get(r).getLevel());
//				map.put("percent", robot.get(r).getPercent());
//				// 机器人
//				map.put("t", 0);
//				map.put("id", robot.get(r).getId());
//				map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
//				ary.add(map);
//			}
//			robot.clear();
//			rlt.put("roles", ary);
//			param=null;
//			map=null;
//			m=null;
//		}
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);
		rlt=null;
		roleIds=null;
		ary=null;
		long b = System.currentTimeMillis();
		//System.out.println("更新争霸战结束_________________________________________________________________________________________" +  Integer.parseInt(playerId) + "用时：" + (b-a));
	}

	private void changemilitary() {
//		System.out.println("Maphaneler.chageMIlitary:params." + params.toString());
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
		//	System.out.println("Maphandelr.getRoleChallenge:" + rolechallenge.get(0).getMilitaryid());
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
//	private void openfight() {
//		long a = System.currentTimeMillis();
//		System.out.println("打开争霸战开始" +  Integer.parseInt(playerId));
//		Map<String, Object> param = new HashMap<String, Object>();
//		Map<String, Object> rlt = new HashMap<String, Object>();
//		int roleid = Integer.parseInt(playerId);
//		GameRoleDetail gameRole = this.getGameRoleService().findRoleById(roleid);
//		int helpstep = gameRole.getHelpstep();
//		int level = gameRole.getLevel();
//		
//		
//		String serverId = gameRole.getServerId();
//		//System.out.println("MapHandler中的serverId：" + serverId);
//		
//		
//		param.clear();
//		param.put("roleid", roleid);
//		List<RoleChallengeDetail> rolechallenge = this
//				.getRoleChallengeService().findRoleChallengeById(param);
//		if (rolechallenge.isEmpty()) {
//			int b = this.getAutoIdService()
//					.fingKeyValueByTableName("role_challenge") + 1;
//			param.clear();
//			param.put("roleid", roleid);
//			param.put("id", b);
//			param.put("militaryid", "[]");
//			this.getRoleChallengeService().insertRoleChallenge(
//					param);
//			this.getAutoIdService()
//					.updateKeyValueAddOneByTableName(
//							"role_challenge");
//		}
//		if(helpstep!=64){//不是新手引导
//		session.removeAttribute("challenge");
//		//System.out.println("不是新手引导");
//			param.clear();
//			param.put("level", level);
//			param.put("id", roleid);
//			param.put("serverId", serverId);
//			List<GameRoleDetail> rc = this.getGameRoleService().getRoleByLevels(
//					param);
//			int size = rc.size();
//			JSONArray ary = new JSONArray();
//			Map<String, Object> map = new HashMap<String, Object>();
//			if (size > 20) {
//				for (int i = 0; i < size; i++) {
//					// 插入数据...... 判断是否存在
//					param.clear();
//					param.put("roleid", rc.get(i).getId());
//					RoleChallengeDetail ro = this.getRoleChallengeService()
//							.findRoleChallengeById(param).get(0);
//					map.put("level", rc.get(i).getLevel());
//			    	int success = ro.getSuccess();
//					int totals = ro.getTotals();
//					if (totals == 0) {
//						map.put("percent", 100);
//					} else {
//						map.put("percent", success * 100 / totals);
//					}
//					map.put("id", rc.get(i).getId());// 人物id
//					//添加黄钻信息
//					JsonSerializer json = new JsonSerializer();
//					if(!"null".equals(String.valueOf(rc.get(i).getHuangzuaninfo()))){
//						List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
//						.deserialize(rc.get(i).getHuangzuaninfo());
//						int ret = Integer.parseInt(String.valueOf(roleinfo.get(0).get("ret")));
//						if(ret==0){
////							map.put("name", this.getGameRoleService().findRoleById(id).getName());
//							map.put("isyellowvip", roleinfo.get(0).get("is_yellow_vip"));
//							map.put("yellowviplevel", roleinfo.get(0).get("yellow_vip_level"));
//							map.put("isyellowyearsvip", roleinfo.get(0).get("is_yellow_year_vip"));
//							map.put("url", roleinfo.get(0).get("figureurl"));
//						}else{
////							map.put("name", "");
//							map.put("isyellowvip", 0);
//							map.put("yellowviplevel", 0);
//							map.put("isyellowyearsvip", 0);
//							map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
//						}
//						roleinfo=null;
//					}else{
////						map.put("name", "");
//						map.put("isyellowvip", 0);
//						map.put("yellowviplevel", 0);
//						map.put("isyellowyearsvip", 0);
//						map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
//					}
//					map.put("name", rc.get(i).getName());
//					map.put("t", 1);
//					ary.add(map);
//					ro=null;
//				}
//				session.setAttribute("challenge", ary);//缓存
//				int[] ints = ran(size, size>=20?20:size);
//				JSONArray ary2 = new JSONArray();
//				for(int i=0;i<ints.length;i++){
//					ary2.add(ary.get(ints[i]));
//				}
//				rlt.put("roles", ary2);
//				rc=null;
//			} else {// 小于20个玩家
//				for (int i = 0; i < size; i++) {
//					// 插入数据..........
//					param.clear();
//					param.put("roleid", rc.get(i).getId());
//					RoleChallengeDetail ro = this.getRoleChallengeService()
//							.findRoleChallengeById(param).get(0);
//					map.put("level", rc.get(i).getLevel());
//					int success = ro.getSuccess();
//					int totals = ro.getTotals();
//					if (totals == 0) {
//						map.put("percent", 100);
//					} else {
//						map.put("percent", success * 100 / totals);
//					}
//					map.put("id", rc.get(i).getId());
//					//添加黄钻信息
//					JsonSerializer json = new JsonSerializer();
//					if(!"null".equals(String.valueOf(rc.get(i).getHuangzuaninfo()))){
//						List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
//						.deserialize(rc.get(i).getHuangzuaninfo());
//						int ret = Integer.parseInt(String.valueOf(roleinfo.get(0).get("ret")));
//						if(ret==0){
//							map.put("isyellowvip", roleinfo.get(0).get("is_yellow_vip"));
//							map.put("yellowviplevel", roleinfo.get(0).get("yellow_vip_level"));
//							map.put("isyellowyearsvip", roleinfo.get(0).get("is_yellow_year_vip"));
//							map.put("url", roleinfo.get(0).get("figureurl"));
//						}else{
//							map.put("isyellowvip", 0);
//							map.put("yellowviplevel", 0);
//							map.put("isyellowyearsvip", 0);
//							map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
//						}
//					}else{
//						map.put("isyellowvip", 0);
//						map.put("yellowviplevel", 0);
//						map.put("isyellowyearsvip", 0);
//						map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
//					}
//					map.put("name", rc.get(i).getName());
//					map.put("t", 1);
//					ary.add(map);
//				}
//				session.setAttribute("challenge", ary);//缓存
//				rc=null;
//				// 添加机器人
//				param.clear();
//				param.put("level", level);
//				List<GameRobotDetail> robot = this.getGameRobotService()
//						.findGameRobot(param);
//				int num = robot.size();
//				int[] ints = ran(num, (20-size));
//				Map<String, Object> m = new HashMap<String, Object>();
//				int r = 0;
//				for (int i = 0; i < (20 - size); i++) {
//					r = ints[i];
//					map.clear();
//					map.put("name", robot.get(r).getName());
//					map.put("level", robot.get(r).getLevel());
//					map.put("percent", robot.get(r).getPercent());
//					// 机器人
//					map.put("t", 0);
//					map.put("id", robot.get(r).getId());
//					map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
//					ary.add(map);
//				}
//				robot.clear();
//				rlt.put("roles", ary);
//			}
//				JsonSerializer json = new JsonSerializer();
//				param.clear();
//				param.put("roleid", roleid);
//				rolechallenge = this
//						.getRoleChallengeService().findRoleChallengeById(param);
//				List<Map<String, Object>> mids = (List<Map<String, Object>>) json
//						.deserialize(rolechallenge.get(0).getMilitaryid());
//				rlt.put("mids", mids);
//
//			if (rolechallenge.get(0).getTotals() == 0) {
//				rlt.put("rpercent", 100);// 玩家胜率
//			} else {
//				rlt.put("rpercent", rolechallenge.get(0).getSuccess() * 100 / rolechallenge.get(0).getTotals());
//			}
//			rolechallenge.clear();
//			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
//					GameConstants.GAME_API_SUCCESS);
//			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
//			ServerHandler.sendData(session, respMap);
//			ary=null;
//			map=null;
//			rlt=null;
//			param=null;
//			gameRole=null;
//			rc=null;
//		}else{//新手引导
//			// 添加机器人
//			Map<String, Object> map = new HashMap<String, Object>();
//			JSONArray ary = new JSONArray();
//			param.clear();
//			param.put("level", level);
//			List<GameRobotDetail> robot = this.getGameRobotService()
//					.findGameRobot(param);
//			int num = robot.size();
//			int[] ints = ran(num, 30);
//			int r = 0;
//			for (int i = 0; i < 30; i++) {
//				r = ints[i];
//				map.clear();
//				map.put("name", robot.get(r).getName());
//				map.put("level", robot.get(r).getLevel());
//				map.put("percent", robot.get(r).getPercent());
//				// 机器人
//				map.put("t", 0);
//				map.put("id", robot.get(r).getId());
//				map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
//				ary.add(map);
//				rlt.put("roles", ary);
//			}
//			session.setAttribute("challenge", ary);//缓存
//			JsonSerializer json = new JsonSerializer();
//			param.clear();
//			param.put("roleid", roleid);
//			rolechallenge = this
//					.getRoleChallengeService().findRoleChallengeById(param);
//			List<Map<String, Object>> mids = (List<Map<String, Object>>) json
//					.deserialize(rolechallenge.get(0).getMilitaryid());
//			rlt.put("mids", mids);
//			
//			if (rolechallenge.get(0).getTotals() == 0) {
//				rlt.put("rpercent", 100);// 玩家胜率
//			} else {
//				rlt.put("rpercent", rolechallenge.get(0).getSuccess() * 100 / rolechallenge.get(0).getTotals());
//			}
//			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
//					GameConstants.GAME_API_SUCCESS);
//			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
//			ServerHandler.sendData(session, respMap);
//			param=null;
//			rlt=null;
//			map=null;
//			robot=null;
//			mids=null;
//		}
//		rolechallenge=null;
//		gameRole=null;
//		param=null;
//		long b = System.currentTimeMillis();
//		System.out.println("打开争霸战结束" +  Integer.parseInt(playerId) + "用时：" + (b-a));
//		
//	}

	

	private void upgrademap() {
		if (params.containsKey("mapid") && params.containsKey("placeid")
				&& params.containsKey("tower")) {
			int mapid = Integer.parseInt(String.valueOf(params.get("mapid")));
			int placeid = Integer.parseInt(String
					.valueOf(params.get("placeid")));
			int tower = Integer.parseInt(String.valueOf(params.get("tower")));// 塔的id
			int roleid = Integer.parseInt(playerId);
			Map<String, Object> rlt = new HashMap<String, Object>();
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("roleId", roleid);
			param.put("mapid", mapid);
			param.put("placeid", placeid);
			RoleMapDetail rtower = this.getRoleMapService().getRoleMapByParam(
					param).get(0);
			int militaryid = rtower.getMilitaryid();
			int tow = rtower.getTowerid();
			int nowlevel = this.getGameTowerService().getGameTowerLevel(tow)
					.get(0).getLevel();
			if (nowlevel == 4) {// 塔不可在升级了
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);
				ServerHandler.sendData(session, respMap);
				return;
			}
			param.clear();
			param.put("roleId", roleid);
			param.put("id", militaryid);
			int types = this.getRoleMilitaryService().getRoleMilitaryByparam(
					param).get(0).getTypes();// 初中高终
			List<GameTowerDetail> gametower = this.getGameTowerService()
					.getGameTowerLevel(tower);// 塔的等级
			int level = 0;
			if (!gametower.isEmpty()) {
				level = gametower.get(0).getLevel();
			} else {// 塔不存在
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
				ServerHandler.sendData(session, respMap);
				return;
			}

			if (types >= level && types < 5) {// 可以升级
				param.clear();
				param.put("roleId", roleid);
				param.put("mapid", mapid);
				param.put("placeid", placeid);
				param.put("towerid", tower);
				this.getRoleMapService().updateRoleMap(param);
				rlt.put("mapid", mapid);
				rlt.put("placeid", placeid);
				rlt.put("towerid", tower);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
			} else {// 武将等级不符合
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
				ServerHandler.sendData(session, respMap);
			}

			rlt=null;
			param=null;
		}
		
	}

	private void changemap() {
		if (params.containsKey("mapid2") && params.containsKey("placeid2")) {
			int map = Integer.parseInt(String.valueOf(params.get("mapid2")));
			int place = Integer
					.parseInt(String.valueOf(params.get("placeid2")));
			int roleid = Integer.parseInt(playerId);
			Map<String, Object> rlt = new HashMap<String, Object>();
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> mapplace = new HashMap<String, Object>();
			JSONArray placelist = new JSONArray();
			GameRoleDetail role = this.getGameRoleService()
					.findRoleById(roleid);
			int mapid = role.getMapid();
			int placeid = role.getPlaceid();
			int mapid2 = role.getMapid2();
			int placeid2 = role.getPlaceid2();
			if (map < mapid) {
				if (place <= 20) {
					// 更新mapid2 placeid2
					param.clear();
					param.put("id", roleid);
					param.put("mapid2", map);
					param.put("placeid2", place);
					this.getGameRoleService().updateRoleVip(param);
					// 是否在当前地图换波
					if (map == mapid2) {
						// place为空
					} else {// 换新地图了,发送place
						// 遍历role_map，发送place
						param.clear();
						param.put("roleId", roleid);
						param.put("mapid", (map));
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
					}
				} else {// 大于最大波数
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
					ServerHandler.sendData(session, respMap);
					return;
				}
			} else if (map == mapid) {//
				if (place <= placeid) {
					param.clear();
					param.put("id", roleid);
					param.put("mapid2", map);
					param.put("placeid2", place);
					this.getGameRoleService().updateRoleVip(param);
					// 是否在当前地图换波
					if (map == mapid2) {
						// place为空
					} else {// 换新地图了
						// 遍历role_map，发送place
						param.clear();
						param.put("roleId", roleid);
						param.put("mapid", (map));
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
					}
				} else {// 大于当前最大波数
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
					ServerHandler.sendData(session, respMap);
					return;
				}
			} else {// 大于最大地图
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
				ServerHandler.sendData(session, respMap);
				return;
			}
			rlt.put("mapid2", map);
			rlt.put("placeid2", place);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
			mapplace=null;
			rlt=null;
			param=null;
		}
	}
	
	/**
	 * 
	 * @param roleId人物id
	 * @param id道具id
	 * @param num
	 * @param type道具类型 5
	 */
	void getLiveItem(int roleId,int id,int num,int type,JSONArray list){
		//long a=System.currentTimeMillis();
		//System.out.println("领取奖励开始=========");
		if(type==5){
			//活跃奖励都是道具
			// 道具
			Map<String,Object> params = new HashMap<String,Object>();
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
			//long a0=System.currentTimeMillis();
			boolean boo = this.getplayerHandler().getShangxian(itemtype, type, roleId,
					id, num);
			//long aa=System.currentTimeMillis();
			//System.out.println("判断背包格子花费的时间："+(aa-a0));
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
				/****/
//				RoleItemDetail ro=new RoleItemDetail();
//				ro.setRoleid(roleId);
//				ro.setItemid(id);
//				ro.setNum(num);
//				itemcache.add(ro);
//				boolean bo=true;
				/****/
				long x=System.currentTimeMillis();
			   boolean bo = this.getRoleItemService().addRoleItemNum(params);
				//long y=System.currentTimeMillis();
				//System.out.println("更新道具花费的时间："+(y-x));
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
				long x=System.currentTimeMillis();
//				int bid = this.getAutoIdService()
//						.fingKeyValueByTableName("role_item") + 1;
				long bid = this.getAutoIdService().fingKeyValueByTableName("role_item") + 0L;
				RoleItemDetail iDetail = new RoleItemDetail();
				iDetail.setId(bid);
				iDetail.setRoleid(roleId);
				iDetail.setItemid(id);
				iDetail.setNum(num);
				iDetail.setFlag(1);
				iDetail.setType(itemtype);
				boolean bo = this.getRoleItemService()
						.insertRoleItem(iDetail);
				//this.getAutoIdService().updateKeyValueAddOneByTableName("role_item");
				//long y=System.currentTimeMillis();
				//System.out.println("插入道具花费的时间："+(y-x));
				if (bo == true) {
					params.put("bid", bid);
					params.remove("roleid");
					params.put("id", id);
					params.remove("itemid");
					list.add(params);

				}
			}
		}else if(type==6){
			// 装备
			// 判断背包格子是否已满
			int equiptype = this.getGameEquipService()
					.getGameEquipById(id).get(0).getType();
			boolean boo = this.getplayerHandler().getShangxian(equiptype, type, roleId,
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

				int bid = this.getAutoIdService().fingKeyValueByTableName("role_equip");
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
				//this.getAutoIdService().updateKeyValueAddOneByTableName("role_equip");

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
		//long b=System.currentTimeMillis();
		//System.out.println("领取奖励及判断背包格子花费时间："+(b-a));
	}
	
	/***
	 * 不重复随机数生成方法
	 * @param max 最大值
	 * @param num 生成个数
	 * @return
	 */
	public static int[] ran(int max,int num){
		long time = System.currentTimeMillis();
		int[] res = new int[num];
		int cach = 0;
		int count = 0;
		int flag = 0;
		Random random = new Random(System.currentTimeMillis());
		while(count<num){
			cach = random.nextInt(max);
			for(int i=0;i<count;i++){
				if(res[i]==cach){
					flag = 1;
					break;
				}else{
					flag = 0;
				}
			}
			if(flag==0){
				res[count] = cach;
				count++;
			}
		}
		return res;
	}
	
	
	private void openfight() {
//		System.out.println("打开争霸战");
		//List<GameMilitaryDetail> gmd=this.getGameMilitaryService().getManyTableSelect(30);
		//System.out.println(gmd.get(0).getFanwei()+"===types=="+gmd.get(0).getPztype()+"=======id==="+gmd.get(0).getType()+"type"+gmd.get(0).getLevel()+"level"+gmd.get(0).getArts()+"arts======="+gmd.get(0).getGongsu()+"gongsu");
		//System.out.println(gmd.get(0).getName()+"name"+gmd.get(0).getArts()+"== arts====="+gmd.get(0).getGongji()+"==攻击====="+gmd.get(0).getXueliang()+"====血量=======");
		long a = System.currentTimeMillis();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> rlt = new HashMap<String, Object>();
		int roleid = Integer.parseInt(playerId);
		GameRoleDetail gameRole = this.getGameRoleService().findRoleById(roleid);
		if(gameRole==null){
			gameRole = this.getGameRoleService().findRoleById(roleid);
		}
		String helpstring = gameRole.getHelpstep();
		JSONArray ary3t = JSONArray.fromObject(helpstring);
		int helpstep = ary3t.getInt(9);
		int level = gameRole.getLevel();
		int serverid=Integer.parseInt(String.valueOf(gameRole.getServerId()));
		
		param.clear();
		param.put("roleid", roleid);
		List<RoleChallengeDetail> rolechallenge = this.getRoleChallengeService().findRoleChallengeById2(param);
		if (rolechallenge.isEmpty()) {
			int b = this.getAutoIdService().fingKeyValueByTableName("role_challenge");
			param.clear();
			param.put("roleid", roleid);
			param.put("id", b);
			param.put("militaryid", "[]");
			this.getRoleChallengeService().insertRoleChallenge(param);
		}
		if(helpstep == 0){//不是新手引导
			JSONArray ary = new JSONArray();
			Map<String, Object> map = new HashMap<String, Object>();
			if(level>0&&level<21){//ary1
				int size = 0;
				if(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).containsKey(1)){
					size=GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(1).size();
				}
					if (size > 20) {
						int[] ints = ran(size, size>=20?20:size);
						JSONArray ary2 = new JSONArray();
						for(int i=0;i<ints.length;i++){
							Map map1=(Map)GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(1).get(ints[i]);
							int id=Integer.parseInt(String.valueOf( map1.get("id")));
							if(roleid==id){
								continue;
							}
							ary2.add(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(1).get(ints[i]));
						}
						rlt.put("roles", ary2);
					}else{// 小于20个玩家
						JSONArray aryy = new JSONArray();
						int[] ints0 = ran(size, size>=20?20:size);
						for(int i=0;i<ints0.length;i++){
						Map map1=	(Map) GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(1).get(ints0[i]);
						int id=Integer.parseInt(String.valueOf( map1.get("id")));
						if(roleid==id){
							continue;
						}	
						aryy.add(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(1).get(ints0[i]));
						}
						// 添加机器人
						param.clear();
						param.put("level", level);
						List<GameRobotDetail> robot = this.getGameRobotService()
								.findGameRobot(param);
						int num = robot.size();
						int[] ints = ran(num, (20-size));
						Map<String, Object> m = new HashMap<String, Object>();
						int r = 0;
						for (int i = 0; i < (20 - size); i++) {
							r = ints[i];
							map.clear();
							map.put("name", robot.get(r).getName());
							map.put("level", robot.get(r).getLevel());
							map.put("percent", robot.get(r).getPercent());
							// 机器人
							map.put("t", 0);
							map.put("id", robot.get(r).getId());
							map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
							aryy.add(map);
						}
						robot.clear();
						rlt.put("roles", aryy);
					}
				}else if(level>20&&level<31){//ary2
					int size = 0;
					if(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).containsKey(2)){
						size=GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(2).size();
					}
					if (size > 20) {
						int[] ints = ran(size, size>=20?20:size);
						JSONArray ary02 = new JSONArray();
						for(int i=0;i<ints.length;i++){
							 Map map1=	(Map) GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(2).get(ints[i]);
							int id=Integer.parseInt(String.valueOf( map1.get("id")));
							if(roleid==id){
								continue;
							}
							ary02.add(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(2).get(ints[i]));
						}
						rlt.put("roles", ary02);
					} else {// 小于20个玩家
						JSONArray aryy = new JSONArray();
						int[] ints0 = ran(size, size>=20?20:size);
						for(int i=0;i<ints0.length;i++){
		                    Map map1 = (Map)GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(2).get(ints0[i]);
							int id=Integer.parseInt(String.valueOf( map1.get("id")));
							if(roleid==id){
								continue;
							}	
							aryy.add(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(2).get(ints0[i]));
						}
						// 添加机器人
						param.clear();
						param.put("level", level);
						List<GameRobotDetail> robot = this.getGameRobotService().findGameRobot(param);
						int num = robot.size();
						int[] ints = ran(num, (20-size));
						Map<String, Object> m = new HashMap<String, Object>();
						int r = 0;
						for (int i = 0; i < (20 - size); i++) {
							r = ints[i];
							map.clear();
							map.put("name", robot.get(r).getName());
							map.put("level", robot.get(r).getLevel());
							map.put("percent", robot.get(r).getPercent());
							// 机器人
							map.put("t", 0);
							map.put("id", robot.get(r).getId());
							map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
							aryy.add(map);
						}
						robot.clear();
						rlt.put("roles", aryy);
					}
				}else if(level>30&&level<41){//ary3
					int size = 0;
					if(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).containsKey(3)){
						size=GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(3).size();
					}
					if (size > 20) {
						//System.out.println("ary3==========200");
						int[] ints = ran(size, size>=20?20:size);
						JSONArray ary2 = new JSONArray();
						for(int i=0;i<ints.length;i++){
							Map map1=	(Map) GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(3).get(ints[i]);
							int id=Integer.parseInt(String.valueOf( map1.get("id")));
							if(roleid==id){
								continue;
							}
							ary2.add(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(3).get(ints[i]));
						}
						rlt.put("roles", ary2);
					} else {// 小于20个玩家
						JSONArray aryy = new JSONArray();
						int[] ints0 = ran(size, size>=20?20:size);
						for(int i=0;i<ints0.length;i++){
	                    Map map1 = (Map)GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(3).get(ints0[i]);
						int id=Integer.parseInt(String.valueOf( map1.get("id")));
						if(roleid==id){
							continue;
						}	
						aryy.add(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(3).get(ints0[i]));
						}
						// 添加机器人
						param.clear();
						param.put("level", level);
						List<GameRobotDetail> robot = this.getGameRobotService().findGameRobot(param);
						int num = robot.size();
						int[] ints = ran(num, (20-size));
						Map<String, Object> m = new HashMap<String, Object>();
						int r = 0;
						for (int i = 0; i < (20 - size); i++) {
							r = ints[i];
							map.clear();
							map.put("name", robot.get(r).getName());
							map.put("level", robot.get(r).getLevel());
							map.put("percent", robot.get(r).getPercent());
							// 机器人
							map.put("t", 0);
							map.put("id", robot.get(r).getId());
							map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
							aryy.add(map);
						}
						robot.clear();
						rlt.put("roles", aryy);
					}
				}else if(level>40&&level<51){//ary4
					int size = 0;
					if(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).containsKey(4)){
						size=GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(4).size();
					}
					if (size > 20) {
						int[] ints = ran(size, size>=20?20:size);
						JSONArray ary2 = new JSONArray();
						for(int i=0;i<ints.length;i++){
							Map map1=	(Map) GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(4).get(ints[i]);
							int id=Integer.parseInt(String.valueOf( map1.get("id")));
							if(roleid==id){
								continue;
							}
							ary2.add(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(4).get(ints[i]));
						}
						rlt.put("roles", ary2);
					} else {// 小于20个玩家
						JSONArray aryy = new JSONArray();
						int[] ints0 = ran(size, size>=20?20:size);
						for(int i=0;i<ints0.length;i++){
		                    Map map1 = (Map)GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(4).get(ints0[i]);
							int id=Integer.parseInt(String.valueOf( map1.get("id")));
							if(roleid==id){
								continue;
							}
							aryy.add(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(4).get(ints0[i]));
						}
						// 添加机器人
						param.clear();
						param.put("level", level);
						List<GameRobotDetail> robot = this.getGameRobotService().findGameRobot(param);
						int num = robot.size();
						int[] ints = ran(num, (20-size));
						Map<String, Object> m = new HashMap<String, Object>();
						int r = 0;
						for (int i = 0; i < (20 - size); i++) {
							r = ints[i];
							map.clear();
							map.put("name", robot.get(r).getName());
							map.put("level", robot.get(r).getLevel());
							map.put("percent", robot.get(r).getPercent());
							// 机器人
							map.put("t", 0);
							map.put("id", robot.get(r).getId());
							map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
							aryy.add(map);
						}
						robot.clear();
						rlt.put("roles", aryy);
					}
				}else if(level>50&&level<61){//ary5
					int size = 0;
					if(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).containsKey(5)){
						size=GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(5).size();
					}
					if (size > 20) {
						int[] ints = ran(size, size>=20?20:size);
						JSONArray ary2 = new JSONArray();
						for(int i=0;i<ints.length;i++){
							Map map1=	(Map) GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(5).get(ints[i]);
							int id=Integer.parseInt(String.valueOf( map1.get("id")));
							if(roleid==id){
								continue;
							}
							ary2.add(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(5).get(ints[i]));
						}
						rlt.put("roles", ary2);
					} else {// 小于20个玩家
						JSONArray aryy = new JSONArray();
						int[] ints0 = ran(size, size>=20?20:size);
						for(int i=0;i<ints0.length;i++){
		                    Map map1 = (Map)GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(5).get(ints0[i]);
							int id=Integer.parseInt(String.valueOf( map1.get("id")));
							if(roleid==id){
								continue;
							}	
							aryy.add(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(5).get(ints0[i]));
						}
						// 添加机器人
						param.clear();
						param.put("level", level);
						List<GameRobotDetail> robot = this.getGameRobotService().findGameRobot(param);
						int num = robot.size();
						int[] ints = ran(num, (20-size));
						Map<String, Object> m = new HashMap<String, Object>();
						int r = 0;
						for (int i = 0; i < (20 - size); i++) {
							r = ints[i];
							map.clear();
							map.put("name", robot.get(r).getName());
							map.put("level", robot.get(r).getLevel());
							map.put("percent", robot.get(r).getPercent());
							// 机器人
							map.put("t", 0);
							map.put("id", robot.get(r).getId());
							map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
							aryy.add(map);
						}
						robot.clear();
						rlt.put("roles", aryy);
					}
				}else if(level>60&&level<71){//ary6
					int size = 0;
					
					if(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).containsKey(6)){
						size=GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(6).size();
					}
					if (size > 20) {
						int[] ints = ran(size, size>=20?20:size);
						JSONArray ary2 = new JSONArray();
						for(int i=0;i<ints.length;i++){
							Map map1=	(Map) GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(6).get(ints[i]);
							int id=Integer.parseInt(String.valueOf( map1.get("id")));
							if(roleid==id){
								continue;
							}
							ary2.add(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(6).get(ints[i]));
						}
						rlt.put("roles", ary2);
					} else {// 小于20个玩家
						JSONArray aryy = new JSONArray();
						int[] ints0 = ran(size, size>=20?20:size);
						for(int i=0;i<ints0.length;i++){
		                    Map map1 = (Map)GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(6).get(ints0[i]);
							int id=Integer.parseInt(String.valueOf( map1.get("id")));
							if(roleid==id){
								continue;
							}	
							aryy.add(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(6).get(ints0[i]));
						}
						// 添加机器人
						param.clear();
						param.put("level", level);
						List<GameRobotDetail> robot = this.getGameRobotService().findGameRobot(param);
						int num = robot.size();
						int[] ints = ran(num, (20-size));
						Map<String, Object> m = new HashMap<String, Object>();
						int r = 0;
						for (int i = 0; i < (20 - size); i++) {
							r = ints[i];
							map.clear();
							map.put("name", robot.get(r).getName());
							map.put("level", robot.get(r).getLevel());
							map.put("percent", robot.get(r).getPercent());
							// 机器人
							map.put("t", 0);
							map.put("id", robot.get(r).getId());
							map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
							aryy.add(map);
						}
						robot.clear();
						rlt.put("roles", aryy);
					}
				}else if(level>70&&level<101){//ary7
					int size = 0;
					if(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).containsKey(7)){
						size=GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(7).size();
					}
					if (size > 20) {
						int[] ints = ran(size, size>=20?20:size);
						JSONArray ary2 = new JSONArray();
						for(int i=0;i<ints.length;i++){
							Map map1=	(Map) GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(7).get(ints[i]);
							int id=Integer.parseInt(String.valueOf( map1.get("id")));
							if(roleid==id){
								continue;
							}
							ary2.add(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(7).get(ints[i]));
						}
						rlt.put("roles", ary2);
					} else {// 小于20个玩家
						JSONArray aryy = new JSONArray();
						int[] ints0 = ran(size, size>=20?20:size);
						for(int i=0;i<ints0.length;i++){
	                    Map map1 = (Map)GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(7).get(ints0[i]);
						int id=Integer.parseInt(String.valueOf( map1.get("id")));
							if(roleid==id){
								continue;
							}	
							aryy.add(GlobalDatat.challenge.get(Integer.valueOf(gameRole.getServerId())).get(7).get(ints0[i]));
						}
						// 添加机器人
						param.clear();
						param.put("level", level);
						List<GameRobotDetail> robot = this.getGameRobotService().findGameRobot(param);
						int num = robot.size();
						int[] ints = ran(num, (20-size));
						Map<String, Object> m = new HashMap<String, Object>();
						int r = 0;
						for (int i = 0; i < (20 - size); i++) {
							r = ints[i];
							map.clear();
							map.put("name", robot.get(r).getName());
							map.put("level", robot.get(r).getLevel());
							map.put("percent", robot.get(r).getPercent());
							// 机器人
							map.put("t", 0);
							map.put("id", robot.get(r).getId());
							map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
							aryy.add(map);
						}
						robot.clear();
						rlt.put("roles", aryy);
					}
				}
				JsonSerializer json = new JsonSerializer();
				param.clear();
				param.put("roleid", roleid);
				rolechallenge = this.getRoleChallengeService().findRoleChallengeById(param);
				List<Map<String, Object>> mids = (List<Map<String, Object>>) json.deserialize(rolechallenge.get(0).getMilitaryid());
				rlt.put("mids", mids);
			if (rolechallenge.get(0).getTotals() == 0) {
				rlt.put("rpercent", 100);// 玩家胜率
			} else {
				rlt.put("rpercent", rolechallenge.get(0).getSuccess() * 100 / rolechallenge.get(0).getTotals());
			}
			rolechallenge.clear();
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
			ary=null;
			map=null;
			rlt=null;
			param=null;
			gameRole=null;
		}else{//新手引导// 添加机器人
			JSONArray ary = new JSONArray();
			int size = ary0.size();
			if (size >= 20) {
				int[] ints = ran(size, 20);
				for (int i = 0; i < 20; i++) {
					ary.add(ary0.get(ints[i]));
				}
				rlt.put("roles", ary);
			}else{
				rlt.put("roles", ary0);
			}
			
		//	session.setAttribute("challenge", ary);//缓存
			JsonSerializer json = new JsonSerializer();
			param.clear();
			param.put("roleid", roleid);
			rolechallenge = this.getRoleChallengeService().findRoleChallengeById(param);
			List<Map<String, Object>> mids = (List<Map<String, Object>>) json.deserialize(rolechallenge.get(0).getMilitaryid());
			rlt.put("mids", mids);
			if (rolechallenge.get(0).getTotals() == 0) {
				rlt.put("rpercent", 100);// 玩家胜率
			} else {
				rlt.put("rpercent", rolechallenge.get(0).getSuccess() * 100 / rolechallenge.get(0).getTotals());
			}
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
			param=null;
			rlt=null;
			mids=null;
		}
		gameRole=null;
		param=null;
	}
	
//	public void oldmanytw(){//不是新手且所有玩家多于20
//		Map<String, Object> param = new HashMap<String, Object>();
//		Map<String, Object> map = new HashMap<String, Object>();	
//		List<GameRoleDetail> rc = this.getGameRoleService().getRoleByLevels1();
//		int size = rc.size();
//	    List<GameRoleDetail> rc2 = this.getGameRoleService().getRoleByLevels2();
//		int size2 = rc2.size();
//	    List<GameRoleDetail> rc3 = this.getGameRoleService().getRoleByLevels3();
//		int size3 = rc3.size();
//	    List<GameRoleDetail> rc4 = this.getGameRoleService().getRoleByLevels4();
//		int size4 = rc4.size();
//	    List<GameRoleDetail> rc5 = this.getGameRoleService().getRoleByLevels5();
//		int size5 = rc5.size();
//	    List<GameRoleDetail> rc6 = this.getGameRoleService().getRoleByLevels6();
//		int size6 = rc6.size();
//	    List<GameRoleDetail> rc7 = this.getGameRoleService().getRoleByLevels7();
//		int size7 = rc7.size();
//		ary1.clear();
//		ary2.clear();
//		ary3.clear();
//		ary4.clear();
//		ary5.clear();
//		ary6.clear();
//		ary7.clear();
//		ary8.clear();
//		ary11.clear();
//		ary22.clear();
//		ary33.clear();
//		ary44.clear();
//		ary55.clear();
//		ary66.clear();
//		ary77.clear();
//		ary88.clear();
//			for (int i = 0; i < size; i++) {
//				// 插入数据...... 判断是否存在
//				param.clear();
//				map.clear();
//				param.put("roleid", rc.get(i).getId());
//				RoleChallengeDetail ro = this.getRoleChallengeService().findRoleChallengeById(param).get(0);
//				map.put("level", rc.get(i).getLevel());
//		    	int success = ro.getSuccess();
//				int totals = ro.getTotals();
//				if (totals == 0) {
//					map.put("percent", 100);
//				} else {
//					map.put("percent", success * 100 / totals);
//				}
//				map.put("id", rc.get(i).getId());// 人物id
//				//添加黄钻信息
//				JsonSerializer json = new JsonSerializer();
//				if(!"null".equals(String.valueOf(rc.get(i).getHuangzuaninfo()))){
//					List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
//					.deserialize(rc.get(i).getHuangzuaninfo());
//					int ret = Integer.parseInt(String.valueOf(roleinfo.get(0).get("ret")));
//					if(ret==0){
//						map.put("isyellowvip", roleinfo.get(0).get("is_yellow_vip"));
//						map.put("yellowviplevel", roleinfo.get(0).get("yellow_vip_level"));
//						map.put("isyellowyearsvip", roleinfo.get(0).get("is_yellow_year_vip"));
//						map.put("url", roleinfo.get(0).get("figureurl"));
//					}else{
//						map.put("isyellowvip", 0);
//						map.put("yellowviplevel", 0);
//						map.put("isyellowyearsvip", 0);
//						map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
//					}
//					roleinfo=null;
//				}else{
//					map.put("isyellowvip", 0);
//					map.put("yellowviplevel", 0);
//					map.put("isyellowyearsvip", 0);
//					map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
//				}
//				map.put("name", rc.get(i).getName());
//				map.put("t", 1);
//				ary1.add(map);
//				ary11.add(rc.get(i).getId());
//				ro=null;
//			}
//			
//			for (int i = 0; i < size2; i++) {
//				// 插入数据...... 判断是否存在
//				param.clear();
//				map.clear();
//				param.put("roleid", rc2.get(i).getId());
//				RoleChallengeDetail ro = this.getRoleChallengeService()
//						.findRoleChallengeById(param).get(0);
//				map.put("level", rc2.get(i).getLevel());
//		    	int success = ro.getSuccess();
//				int totals = ro.getTotals();
//				if (totals == 0) {
//					map.put("percent", 100);
//				} else {
//					map.put("percent", success * 100 / totals);
//				}
//				map.put("id", rc2.get(i).getId());// 人物id
//				//添加黄钻信息
//				JsonSerializer json = new JsonSerializer();
//				if(!"null".equals(String.valueOf(rc2.get(i).getHuangzuaninfo()))){
//					List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
//					.deserialize(rc2.get(i).getHuangzuaninfo());
//					int ret = Integer.parseInt(String.valueOf(roleinfo.get(0).get("ret")));
//					if(ret==0){
////						map.put("name", this.getGameRoleService().findRoleById(id).getName());
//						map.put("isyellowvip", roleinfo.get(0).get("is_yellow_vip"));
//						map.put("yellowviplevel", roleinfo.get(0).get("yellow_vip_level"));
//						map.put("isyellowyearsvip", roleinfo.get(0).get("is_yellow_year_vip"));
//						map.put("url", roleinfo.get(0).get("figureurl"));
//					}else{
////						map.put("name", "");
//						map.put("isyellowvip", 0);
//						map.put("yellowviplevel", 0);
//						map.put("isyellowyearsvip", 0);
//						map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
//					}
//					roleinfo=null;
//				}else{
////					map.put("name", "");
//					map.put("isyellowvip", 0);
//					map.put("yellowviplevel", 0);
//					map.put("isyellowyearsvip", 0);
//					map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
//				}
//				map.put("name", rc2.get(i).getName());
//				map.put("t", 1);
//				ary2.add(map);
//				ary22.add(rc2.get(i).getId());
//				ro=null;
//			}
//			
//			
//			for (int i = 0; i < size3; i++) {
//				// 插入数据...... 判断是否存在
//				param.clear();
//				map.clear();
//				param.put("roleid", rc3.get(i).getId());
//				RoleChallengeDetail ro = this.getRoleChallengeService()
//						.findRoleChallengeById(param).get(0);
//				map.put("level", rc3.get(i).getLevel());
//		    	int success = ro.getSuccess();
//				int totals = ro.getTotals();
//				if (totals == 0) {
//					map.put("percent", 100);
//				} else {
//					map.put("percent", success * 100 / totals);
//				}
//				map.put("id", rc3.get(i).getId());// 人物id
//				//添加黄钻信息
//				JsonSerializer json = new JsonSerializer();
//				if(!"null".equals(String.valueOf(rc3.get(i).getHuangzuaninfo()))){
//					List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
//					.deserialize(rc3.get(i).getHuangzuaninfo());
//					int ret = Integer.parseInt(String.valueOf(roleinfo.get(0).get("ret")));
//					if(ret==0){
////						map.put("name", this.getGameRoleService().findRoleById(id).getName());
//						map.put("isyellowvip", roleinfo.get(0).get("is_yellow_vip"));
//						map.put("yellowviplevel", roleinfo.get(0).get("yellow_vip_level"));
//						map.put("isyellowyearsvip", roleinfo.get(0).get("is_yellow_year_vip"));
//						map.put("url", roleinfo.get(0).get("figureurl"));
//					}else{
////						map.put("name", "");
//						map.put("isyellowvip", 0);
//						map.put("yellowviplevel", 0);
//						map.put("isyellowyearsvip", 0);
//						map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
//					}
//					roleinfo=null;
//				}else{
////					map.put("name", "");
//					map.put("isyellowvip", 0);
//					map.put("yellowviplevel", 0);
//					map.put("isyellowyearsvip", 0);
//					map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
//				}
//				map.put("name", rc3.get(i).getName());
//				map.put("t", 1);
//				ary3.add(map);
//                ary33.add(rc3.get(i).getId());
//				ro=null;
//			}
//			
//			for (int i = 0; i < size4; i++) {
//				// 插入数据...... 判断是否存在
//				param.clear();
//				map.clear();
//				param.put("roleid", rc4.get(i).getId());
//				RoleChallengeDetail ro = this.getRoleChallengeService()
//						.findRoleChallengeById(param).get(0);
//				map.put("level", rc4.get(i).getLevel());
//		    	int success = ro.getSuccess();
//				int totals = ro.getTotals();
//				if (totals == 0) {
//					map.put("percent", 100);
//				} else {
//					map.put("percent", success * 100 / totals);
//				}
//				map.put("id", rc4.get(i).getId());// 人物id
//				//添加黄钻信息
//				JsonSerializer json = new JsonSerializer();
//				if(!"null".equals(String.valueOf(rc4.get(i).getHuangzuaninfo()))){
//					List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
//					.deserialize(rc4.get(i).getHuangzuaninfo());
//					int ret = Integer.parseInt(String.valueOf(roleinfo.get(0).get("ret")));
//					if(ret==0){
////						map.put("name", this.getGameRoleService().findRoleById(id).getName());
//						map.put("isyellowvip", roleinfo.get(0).get("is_yellow_vip"));
//						map.put("yellowviplevel", roleinfo.get(0).get("yellow_vip_level"));
//						map.put("isyellowyearsvip", roleinfo.get(0).get("is_yellow_year_vip"));
//						map.put("url", roleinfo.get(0).get("figureurl"));
//					}else{
////						map.put("name", "");
//						map.put("isyellowvip", 0);
//						map.put("yellowviplevel", 0);
//						map.put("isyellowyearsvip", 0);
//						map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
//					}
//					roleinfo=null;
//				}else{
////					map.put("name", "");
//					map.put("isyellowvip", 0);
//					map.put("yellowviplevel", 0);
//					map.put("isyellowyearsvip", 0);
//					map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
//				}
//				map.put("name", rc4.get(i).getName());
//				map.put("t", 1);
//				ary4.add(map);
//				ary44.add(rc4.get(i).getId());
//				ro=null;
//			}
//			
//			for (int i = 0; i < size5; i++) {
//				// 插入数据...... 判断是否存在
//				param.clear();
//				map.clear();
//				param.put("roleid", rc5.get(i).getId());
//				RoleChallengeDetail ro = this.getRoleChallengeService()
//						.findRoleChallengeById(param).get(0);
//				map.put("level", rc5.get(i).getLevel());
//		    	int success = ro.getSuccess();
//				int totals = ro.getTotals();
//				if (totals == 0) {
//					map.put("percent", 100);
//				} else {
//					map.put("percent", success * 100 / totals);
//				}
//				map.put("id", rc5.get(i).getId());// 人物id
//				//添加黄钻信息
//				JsonSerializer json = new JsonSerializer();
//				if(!"null".equals(String.valueOf(rc5.get(i).getHuangzuaninfo()))){
//					List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
//					.deserialize(rc5.get(i).getHuangzuaninfo());
//					int ret = Integer.parseInt(String.valueOf(roleinfo.get(0).get("ret")));
//					if(ret==0){
////						map.put("name", this.getGameRoleService().findRoleById(id).getName());
//						map.put("isyellowvip", roleinfo.get(0).get("is_yellow_vip"));
//						map.put("yellowviplevel", roleinfo.get(0).get("yellow_vip_level"));
//						map.put("isyellowyearsvip", roleinfo.get(0).get("is_yellow_year_vip"));
//						map.put("url", roleinfo.get(0).get("figureurl"));
//					}else{
////						map.put("name", "");
//						map.put("isyellowvip", 0);
//						map.put("yellowviplevel", 0);
//						map.put("isyellowyearsvip", 0);
//						map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
//					}
//					roleinfo=null;
//				}else{
////					map.put("name", "");
//					map.put("isyellowvip", 0);
//					map.put("yellowviplevel", 0);
//					map.put("isyellowyearsvip", 0);
//					map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
//				}
//				map.put("name", rc5.get(i).getName());
//				map.put("t", 1);
//				ary5.add(map);
//				ary55.add(rc5.get(i).getId());
//				ro=null;
//			}
//			
//			for (int i = 0; i < size6; i++) {
//				// 插入数据...... 判断是否存在
//				param.clear();
//				map.clear();
//				param.put("roleid", rc6.get(i).getId());
//				RoleChallengeDetail ro = this.getRoleChallengeService()
//						.findRoleChallengeById(param).get(0);
//				map.put("level", rc6.get(i).getLevel());
//		    	int success = ro.getSuccess();
//				int totals = ro.getTotals();
//				if (totals == 0) {
//					map.put("percent", 100);
//				} else {
//					map.put("percent", success * 100 / totals);
//				}
//				map.put("id", rc6.get(i).getId());// 人物id
//				//添加黄钻信息
//				JsonSerializer json = new JsonSerializer();
//				if(!"null".equals(String.valueOf(rc6.get(i).getHuangzuaninfo()))){
//					List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
//					.deserialize(rc6.get(i).getHuangzuaninfo());
//					int ret = Integer.parseInt(String.valueOf(roleinfo.get(0).get("ret")));
//					if(ret==0){
////						map.put("name", this.getGameRoleService().findRoleById(id).getName());
//						map.put("isyellowvip", roleinfo.get(0).get("is_yellow_vip"));
//						map.put("yellowviplevel", roleinfo.get(0).get("yellow_vip_level"));
//						map.put("isyellowyearsvip", roleinfo.get(0).get("is_yellow_year_vip"));
//						map.put("url", roleinfo.get(0).get("figureurl"));
//					}else{
////						map.put("name", "");
//						map.put("isyellowvip", 0);
//						map.put("yellowviplevel", 0);
//						map.put("isyellowyearsvip", 0);
//						map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
//					}
//					roleinfo=null;
//				}else{
////					map.put("name", "");
//					map.put("isyellowvip", 0);
//					map.put("yellowviplevel", 0);
//					map.put("isyellowyearsvip", 0);
//					map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
//				}
//				map.put("name", rc6.get(i).getName());
//				map.put("t", 1);
//				ary6.add(map);
//                  ary66.add(rc6.get(i).getId());
//				ro=null;
//			}
//			
//			for (int i = 0; i < size7; i++) {
//				// 插入数据...... 判断是否存在
//				param.clear();
//				map.clear();
//				param.put("roleid", rc7.get(i).getId());
//				RoleChallengeDetail ro = this.getRoleChallengeService()
//						.findRoleChallengeById(param).get(0);
//				map.put("level", rc7.get(i).getLevel());
//		    	int success = ro.getSuccess();
//				int totals = ro.getTotals();
//				if (totals == 0) {
//					map.put("percent", 100);
//				} else {
//					map.put("percent", success * 100 / totals);
//				}
//				map.put("id", rc7.get(i).getId());// 人物id
//				//添加黄钻信息
//				JsonSerializer json = new JsonSerializer();
//				if(!"null".equals(String.valueOf(rc7.get(i).getHuangzuaninfo()))){
//					List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
//					.deserialize(rc7.get(i).getHuangzuaninfo());
//					int ret = Integer.parseInt(String.valueOf(roleinfo.get(0).get("ret")));
//					if(ret==0){
////						map.put("name", this.getGameRoleService().findRoleById(id).getName());
//						map.put("isyellowvip", roleinfo.get(0).get("is_yellow_vip"));
//						map.put("yellowviplevel", roleinfo.get(0).get("yellow_vip_level"));
//						map.put("isyellowyearsvip", roleinfo.get(0).get("is_yellow_year_vip"));
//						map.put("url", roleinfo.get(0).get("figureurl"));
//					}else{
////						map.put("name", "");
//						map.put("isyellowvip", 0);
//						map.put("yellowviplevel", 0);
//						map.put("isyellowyearsvip", 0);
//						map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
//					}
//					roleinfo=null;
//				}else{
////					map.put("name", "");
//					map.put("isyellowvip", 0);
//					map.put("yellowviplevel", 0);
//					map.put("isyellowyearsvip", 0);
//					map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
//				}
//				map.put("name", rc7.get(i).getName());
//				map.put("t", 1);
//				ary7.add(map);
//				ary77.add(rc7.get(i).getId());
//				ro=null;
//			}
//			System.out.println("ary1:" + ary1.size());
//			System.out.println("ary2:" + ary2.size());
//			System.out.println("ary3:" + ary3.size());
//			System.out.println("ary4:" + ary4.size());
//			System.out.println("ary5:" + ary5.size());
//			System.out.println("ary6:" + ary6.size());
//			System.out.println("ary7:" + ary7.size());
//			System.out.println("ary11:" + ary11.size());
//			System.out.println("ary22:" + ary22.size());
//			System.out.println("ary33:" + ary33.size());
//			System.out.println("ary44:" + ary44.size());
//			System.out.println("ary55:" + ary55.size());
//			System.out.println("ary66:" + ary66.size());
//			System.out.println("ary77:" + ary77.size());
//			System.out.println("ary0:" + ary0.size());
//	}
	public void oldllesstw(){//不是新手且所有玩家少于20
		
	}
	public void youngmanytw(){//是新手
		ary0.clear();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<GameRobotDetail> robot = this.getGameRobotService()
				.findGameRobott(param);
		//System.out.println("新手引导的机器人:"+robot);
		int num = robot.size();
		int[] ints = ran(num, 30);
		int r = 0;
		for (int i = 0; i < 30; i++) {
			r = ints[i];
			map.clear();
			map.put("name", robot.get(r).getName());
			map.put("level", robot.get(r).getLevel());
			map.put("percent", robot.get(r).getPercent());
			// 机器人
			map.put("t", 0);
			map.put("id", robot.get(r).getId());
			map.put("url", "http://thirdapp3.qlogo.cn/qzopenapp/2d46f7afe9fbea36e9526bad653ff696bf77937e78818d5965b40fdb3acdabf2/50");
			ary0.add(map);
		}
		//System.out.println("ary0新手引导："+ary0);
	}

	public void uproleItem(){//更新玩家的背包道具
		//System.out.println("更新玩家的背包道具cache开始：");
		long a=System.currentTimeMillis();
		List li=new ArrayList();
		li=itemcache;
		//System.out.println(itemcache.size()+":itemcache.size()");
		if(itemcache.size()<1){
			return;
		}
		
		this.getRoleItemService().UpdateItemCache(itemcache);
		itemcache.clear();
		//long b=System.currentTimeMillis();
		//System.out.println("更新玩家的背包道具cache花费的时间："+(b-a));
	}
}
