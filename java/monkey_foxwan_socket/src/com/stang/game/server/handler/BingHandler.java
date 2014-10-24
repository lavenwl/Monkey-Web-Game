package com.stang.game.server.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.sojo.interchange.json.JsonSerializer;

import org.apache.mina.core.session.IoSession;

import com.stang.game.cache.GlobalData;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;
import com.stang.game.common.GameConstants;
import com.stang.game.entity.detail.GameBingDetail;
import com.stang.game.entity.detail.GameBmapDetail;
import com.stang.game.entity.detail.GameMilitaryDetail;
import com.stang.game.entity.detail.GameMissionDetail;
import com.stang.game.entity.detail.GameRoleDetail;
import com.stang.game.entity.detail.GameStarDetail;
import com.stang.game.entity.detail.GameTaskDetail;
import com.stang.game.entity.detail.GameVipDetail;
import com.stang.game.entity.detail.RoleBingDetail;
import com.stang.game.entity.detail.RoleEquipDetail;
import com.stang.game.entity.detail.RoleItemDetail;
import com.stang.game.entity.detail.RoleMilitaryDetail;
import com.stang.game.server.ServerHandler;
import com.stang.game.service.IAutoIdService;
import com.stang.game.service.IDantiaoService;
import com.stang.game.service.IGameBingService;
import com.stang.game.service.IGameChartsService;
import com.stang.game.service.IGameChartstwoService;
import com.stang.game.service.IGameLevelService;
import com.stang.game.service.IGameMLevelService;
import com.stang.game.service.IGameStarService;
import com.stang.game.service.IGameVipService;
import com.stang.game.service.IQunzhanService;
import com.stang.game.service.IRoleDaytaskService;
import com.stang.game.service.IRoleEquipService;
import com.stang.game.service.IRoleItemService;
import com.stang.game.service.IRoleMilitaryService;
import com.stang.game.service.IRoleQuicktimeService;
import com.stang.game.service.IZhugongService;
import com.stang.game.service.impl.AutoIdServiceImpl;
import com.stang.game.service.impl.DantiaoServiceImpl;
import com.stang.game.service.impl.GameBingServiceImpl;
import com.stang.game.service.impl.GameChartsServiceImpl;
import com.stang.game.service.impl.GameChartstwoServiceImpl;
import com.stang.game.service.impl.GameLevelServiceImpl;
import com.stang.game.service.impl.GameMLevelServiceImpl;
import com.stang.game.service.impl.GameStarServiceImpl;
import com.stang.game.service.impl.GameVipServiceImpl;
import com.stang.game.service.impl.QunzhanServiceImpl;
import com.stang.game.service.impl.RoleDaytaskServiceImpl;
import com.stang.game.service.impl.RoleEquipServiceImpl;
import com.stang.game.service.impl.RoleItemServiceImpl;
import com.stang.game.service.impl.RoleMilitaryServiceImpl;
import com.stang.game.service.impl.RoleQuicktimeServiceImpl;
import com.stang.game.service.impl.ZhugongServiceImpl;

public class BingHandler extends BaseHandler{

	private static IGameBingService gameBingService;
	private IGameBingService getGameBingService(){
		if(gameBingService==null){
			gameBingService = new GameBingServiceImpl();
		}
		return gameBingService;
	}

	static private SystemHandler systemHandler;
	private SystemHandler getsystemHandler() {
		if (systemHandler == null) {
			systemHandler = new SystemHandler();
		}
		return systemHandler;
	}	
	
	static private TaskHandler taskHandler;

	private TaskHandler getTaskHandler() {
		if (taskHandler == null) {
			taskHandler = new TaskHandler(gameApiName, globalIdentifier,
					encryptedSignature, playerId, cacheKey, params, session);
		}
		return taskHandler;
	}
	
	private static IGameStarService gameStarService;
	private IGameStarService getGameStarService(){
		if(gameStarService==null){
			gameStarService=new GameStarServiceImpl();
		}
		return gameStarService;
	}
	
	private static IGameLevelService gameLevelService;

	private IGameLevelService getGameLevelService() {
		if (gameLevelService == null) {
			gameLevelService = new GameLevelServiceImpl();
		}
		return gameLevelService;
	}
	
static private PlayerHandler playerHandler;
	
	private PlayerHandler getplayerHandler() {
		if (playerHandler == null) {
			playerHandler = new PlayerHandler(gameApiName, globalIdentifier,
					encryptedSignature, playerId, cacheKey, params, session);
		}
		return playerHandler;
	}
	
	private static IRoleEquipService roleEquipService;

	private IRoleEquipService getRoleEquipService() {
		if (roleEquipService == null) {
			roleEquipService = new RoleEquipServiceImpl();
		}
		return roleEquipService;
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
	
	private static IZhugongService zhugongService;
	private IZhugongService getZhugongService() {
		if (zhugongService == null) {
			zhugongService = new ZhugongServiceImpl();
		}
		return zhugongService;
	}
	
	
	private static IGameChartstwoService gameChartstwoService;
	private IGameChartstwoService getgameChartstwoService() {
		if (gameChartstwoService == null) {
			gameChartstwoService =  new GameChartstwoServiceImpl();
		}
		return gameChartstwoService;
	}
	private static IGameChartsService gameChartsService;
	private IGameChartsService getgameChartsService() {
		if (gameChartsService == null) {
			gameChartsService = new GameChartsServiceImpl();
		}
		return gameChartsService;
	}
	private static IRoleMilitaryService roleMilitaryService;
	private static IAutoIdService autoIdService=new AutoIdServiceImpl();
	private IRoleMilitaryService getRoleMilitaryService() {
		if (roleMilitaryService == null) {
			roleMilitaryService = new RoleMilitaryServiceImpl();
		}
		return roleMilitaryService;
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

	public BingHandler(String gameApiName, String globalIdentifier,
			String encryptedSignature, String playerId, String cacheKey,
			Map params, IoSession session) {
		super(gameApiName, globalIdentifier, encryptedSignature, playerId,
				cacheKey, params, session);
		if (gameApiName.equals("bing.openfuben")) {
			/*打开副本*/	
			openfuben();
		}else if (gameApiName.equals("bing.openbing")) {
			/* 打开出兵界面*/
			openbing();
		}else if (gameApiName.equals("bing.chuzhan")) {
			/* 选择武将出战*/
			chuzhan();
		}else if (gameApiName.equals("bing.bingtype")) {
			/* 更换选择武将出什么类型的兵种*/
			bingtype();
		}else if (gameApiName.equals("bing.addbingtype")) {
			/* 使用道具开启出兵类型*/
			addbingtype();
		}else if (gameApiName.equals("bing.gamestart")) {
			/* 开始战斗*/
			gamestart();
		}else if (gameApiName.equals("bing.usezxl")) {
			/* 使用诛仙令道具战斗*/
			usezxl();
		}else if (gameApiName.equals("bing.gameover")) {
			/* 战斗结束领取奖励*/
			gameover();
		}else if (gameApiName.equals("bing.changnandu")) {
			/* 选择出战难度*/
			changnandu();
		}else if (gameApiName.equals("bing.changzhandou")) {
			/* 校验兵的攻击力*/
			changzhandou();
		}else if (gameApiName.equals("bing.consumeitem")) {
			/* 玩家打副本消耗的道具*/
			consumeitem();
		}
	}

	private void consumeitem() {
		if(params.containsKey("itemid")&&params.containsKey("num")){
			int itemid = Integer.parseInt(String.valueOf(params.get("itemid")));
		    int num= Integer.parseInt(String.valueOf(params.get("num")));
		    int roleid = Integer.parseInt(playerId);
		    Map<String,Object> rlt = new HashMap<String,Object>();
		    GameRoleDetail gameRole = this.getGameRoleService().findRoleById(roleid);
			if(gameRole==null){
				return;
			}
			Map<String,Object> param = new HashMap<String,Object>();
			//使用道具战斗
			param.clear();
			param.put("roleid", roleid);
			param.put("itemid", itemid);
			List<RoleItemDetail> roleItem = this.getRoleItemService().getRoleItemByitem(param);
		if(roleItem.isEmpty()){//道具不足
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
			ServerHandler.sendData(session, respMap);
			roleItem=null;
			gameRole=null;
			return;
		}
		if(roleItem.get(0).getNum()<num){
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
			ServerHandler.sendData(session, respMap);
			roleItem=null;
			gameRole=null;
			return;
		}
		param.clear();
		param.put("num", num);
		param.put("roleid", roleid);
		param.put("itemid", itemid);
		this.getRoleItemService().subRoleItem(param);
		param.clear();//返回给前端
		param.put("num", roleItem.get(0).getNum()-num);
		param.put("bid", roleItem.get(0).getId());
		param.put("id", itemid);
		rlt.put("item", param);
		//System.out.println(rlt.get("item"));
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);
		rlt=null;
		gameRole=null;
		param=null;
		
		}
		
	}

	private void changzhandou() {
		Map<String,Object> map = new HashMap<String,Object>();
		JSONArray list = new JSONArray();
	//	System.out.println("BingHanler.changzhuan______________dou:list:" + list.toString());
		list = (JSONArray) session.getAttribute("bing");
	//	System.out.println("BingHanler.changzhuan______________dou:list:" + list.toString());
		map.put("bing", list);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, map);
		ServerHandler.sendData(session, respMap);
		map = null;
		list = null;
	}

	private void changnandu() {
		if(params.containsKey("t")){
			int roleId = Integer.parseInt(playerId);
			int t = Integer.parseInt(String.valueOf(params.get("t")));
			Map<String,Object> rlt = new HashMap<String,Object>();
			Map<String,Object> param = new HashMap<String,Object>();
			GameRoleDetail gameRole = this.getGameRoleService().findRoleById(roleId);
			if(gameRole==null){
				return;
			}
			int mapid = gameRole.getBmap();//战斗地图
			param.put("roleid", roleId);
			param.put("mapid", mapid);
			List<RoleBingDetail> roleBing = this.getRoleBingService().findRoleBingByParams(param);
			if(roleBing.isEmpty()){
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
				ServerHandler.sendData(session, respMap);
				rlt=null;
				param=null;
				gameRole=null;
				roleBing=null;
				return;
			}
			int nandu = roleBing.get(0).getNandu();
			int nandu2 = roleBing.get(0).getNandu2();
			if(t<=nandu){
				if(t!=nandu2){
					param.clear();
					param.put("roleid", roleId);
					param.put("mapid", mapid);
					param.put("nandu2", t);
					this.getRoleBingService().updateRoleBing(param);
				}
			}else{//该难度未开启
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);
				ServerHandler.sendData(session, respMap);
				rlt=null;
				param=null;
				gameRole=null;
				roleBing=null;
				return;
			}
			rlt.put("t", t);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
			rlt=null;
			param=null;
			gameRole=null;
			roleBing=null;
		}
	}

	private void gameover() {
		if(params.containsKey("t")&&params.containsKey("star")&&params.containsKey("flag")){
			int roleId = Integer.parseInt(playerId);
			int t = Integer.parseInt(String.valueOf(params.get("t")));
			int star = Integer.parseInt(String.valueOf(params.get("star")));
			int flag = Integer.parseInt(String.valueOf(params.get("flag")));
			int diff= Integer.parseInt(String.valueOf(params.get("diff")));
			Map<String,Object> rlt = new HashMap<String,Object>();
			Map<String,Object> param = new HashMap<String,Object>();
			GameRoleDetail gameRole = this.getGameRoleService().findRoleById(roleId);
			if(gameRole==null){
				return;
			}
			int mapid = gameRole.getBmap();
			param.put("roleid", roleId);
			param.put("mapid", mapid);
			List<RoleBingDetail> roleBing = this.getRoleBingService().findRoleBingByParams(param);
			if(roleBing.isEmpty()){
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-3);
				ServerHandler.sendData(session, respMap);
				return;
			}
			if(roleBing.get(0).getStatus()!=1){//非法战斗
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);
				ServerHandler.sendData(session, respMap);
				return;
			}
			//更改status
			param.clear();
			param.put("roleid", roleId);
			param.put("mapid", mapid);
			param.put("status", 0);
			this.getRoleBingService().updateRoleBing(param);
			int nandu = roleBing.get(0).getNandu2();
			List<GameMissionDetail> gameMission = this.getGameMissionService().findGameMissionById(mapid);
			if(gameMission.isEmpty()){
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
				ServerHandler.sendData(session, respMap);
				return;
			}
			param.clear();
			param.put("mapid", mapid);
			param.put("nandu", nandu);
			List<GameBmapDetail> gameBmap = this.getGameBmapService().findGameBmapByParams(param);
			if(gameBmap.isEmpty()){
				return;
			}
			//是否是训练
			if(flag==1){
				int mapyin =0;
				int mapgongxun = 0;
				int mapexp=0;
				int upplevel = 0;
				if(t==1){//胜利
					String jiangli = gameMission.get(0).getJiangli();
					List json = JSONArray.fromObject(jiangli);
					if(nandu<=json.size()){
						List<Map> ary = JSONArray.fromObject(json.get(nandu));
						int size = ary.size();
						double ran =0;
						int percent = 0;
						JSONArray list = new JSONArray();
						int id=0;
						int type=0;
						int num=0;
						for(int i=0;i<size;i++){
							ran = Math.random()*100;
							percent=Integer.parseInt(String.valueOf(ary.get(i).get("chance")));
							if(ran<=percent){//增加道具
								id = Integer.parseInt(String.valueOf(ary.get(i).get("id")));
								type = Integer.parseInt(String.valueOf(ary.get(i).get("resType")));
								num = Integer.parseInt(String.valueOf(ary.get(i).get("num")));
								this.getplayerHandler().getItem(roleId, id, num, type, list);
							}
						}
						rlt.put("item", list);
						mapyin = gameBmap.get(0).getGetyin();
						mapgongxun = gameBmap.get(0).getGetgongxun();
						mapexp = gameBmap.get(0).getGetexp();
						param.clear();
						param.put("id", roleId);
						param.put("yin", mapyin+gameRole.getYin());
						param.put("gongxun", mapgongxun+gameRole.getGongxun());
						param.put("exp", mapexp+gameRole.getExp());
						this.getGameRoleService().updateRoleVip(param);
						// 判断是否可以升级
						upplevel = this.getplayerHandler().shengji(roleId, gameRole.getLevel(), gameRole.getExp(), mapexp);
						//更改星星
						if(roleBing.get(0).getNandu()==nandu){
							param.clear();
							param.put("roleid", roleId);
							param.put("mapid", mapid);
							param.put("nandu2", nandu);
							param.put("stars", star);
							this.getRoleBingService().updateRoleBing(param);
						}
						//更改难度
						if(star==3){
							
							/****/
							String state0 = gameRole.getAimreward();
							JSONArray aimreward = JSONArray.fromObject(state0);//目标大奖状态
							if(aimreward.getInt(2)==0){//3。达成一次副本三星通关
								aimreward.set(2, 1);
								param.clear();
								param.put("id", roleId);
								param.put("aimreward", aimreward.toString());
								this.getGameRoleService().updateRoleVip(param);
							}
						   /***/
							
							if(roleBing.get(0).getNandu()!=3){
								if(roleBing.get(0).getNandu()==nandu){
									param.clear();
									param.put("roleid", roleId);
									param.put("mapid", mapid);
									param.put("stars", 0);
									param.put("nandu", roleBing.get(0).getNandu()+1);
									this.getRoleBingService().updateRoleBing(param);
								}
							}
							//判断是否有任务完成
							this.getTaskHandler().taskcomplete(roleId);
						}
						ary=null;
						list=null;
					}
					json=null;
					
					// 系统公告//发送广播
//					String message= "玩家 <font color=\"#FFCC00\">"+ gameRole.getName() + "</font>" + gameRole.getVip() + "以 <font color=\"#FF0000\">" + star + "</font> 星的成绩通关了 <font color=\"" + GlobalData.colorMission.get(diff) + "\">" + this.getGameMapService().findGameMapByid(mapid).get(0).getName() + "</font>";
//					GameConstants.log.warn("Military.buyItems:" + message);
//					this.getsystemHandler().addMessage(message);
					UtilHandler util = new UtilHandler();
					String name2 = gameRole.getName();
					int vip2 = gameRole.getVip();
					String where = "超神的操作";
					int pinzhi = diff;
					int xing = star;
					String goodsName = ""+this.getGameMapService().findGameMapByid(mapid).get(0).getName();
					util.sendCustomsMessage(name2, vip2, where, pinzhi,xing, goodsName,"bing_customs");
					
				}else{//失败
					List list = new ArrayList();
					rlt.put("item", list);
					
					mapyin = gameBmap.get(0).getGetyin();
					mapgongxun = gameBmap.get(0).getGetgongxun();
					mapexp = gameBmap.get(0).getGetexp();
					param.clear();
					param.put("id", roleId);
					param.put("yin", mapyin+gameRole.getYin());
					param.put("gongxun", mapgongxun+gameRole.getGongxun());
					param.put("exp", mapexp+gameRole.getExp());
					this.getGameRoleService().updateRoleVip(param);
					
					// 判断是否可以升级
					upplevel = this.getplayerHandler().shengji(roleId, gameRole.getLevel(), gameRole.getExp(), mapexp);
					list=null;
				}
				gameRole = this.getGameRoleService().findRoleById(roleId);
				int needexp = this.getGameLevelService().getGameLevelByRoleLevel(gameRole.getLevel()).getNeedexp();
				rlt.put("t", t);
				param.clear();
				param.put("mapyin", mapyin);
				param.put("mapgongxun", mapgongxun);
				param.put("mapexp", mapexp);
				param.put("yin", gameRole.getYin());
				param.put("exp", gameRole.getExp());
				param.put("gongxun", gameRole.getGongxun());
				param.put("level", gameRole.getLevel());
				param.put("needexp", needexp);
				param.put("uppmapid", 0);
				param.put("upplevel", upplevel);
				param.put("mapid", gameRole.getMapid());
				param.put("placeid", gameRole.getPlaceid());
				param.put("mapid2", gameRole.getMapid2());
				param.put("placeid2", gameRole.getPlaceid2());
				rlt.put("role", param);
				rlt.put("junling", gameRole.getJunling());
			}else{//训练模式
				List list = new ArrayList();
				rlt.put("item", list);
				list=null;
				rlt.put("t", t);
				param.clear();
				param.put("mapyin", 0);
				param.put("mapgongxun", 0);
				param.put("mapexp", 0);
				param.put("yin", gameRole.getYin());
				param.put("exp", gameRole.getExp());
				param.put("gongxun", gameRole.getGongxun());
				param.put("level", gameRole.getLevel());
				param.put("needexp", this.getGameLevelService().getGameLevelByRoleLevel(gameRole.getLevel()).getNeedexp());
				param.put("uppmapid", 0);
				param.put("upplevel", 0);
				param.put("mapid", gameRole.getMapid());
				param.put("placeid", gameRole.getPlaceid());
				param.put("mapid2", gameRole.getMapid2());
				param.put("placeid2", gameRole.getPlaceid2());
				rlt.put("role", param);
				rlt.put("junling", gameRole.getJunling());
			}
			
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
			rlt=null;
			gameRole=null;
			gameMission=null;
			roleBing=null;
			param=null;
			gameBmap=null;
		}
	}

	private void usezxl() {
		int roleId = Integer.parseInt(playerId);
		Map<String,Object> rlt = new HashMap<String,Object>();
		Map<String,Object> param = new HashMap<String,Object>();
		//使用道具战斗
		param.put("roleid", roleId);
		param.put("itemid", 185);
		List<RoleItemDetail> roleItem = this.getRoleItemService().getRoleItemByitem(param);
		if(roleItem.isEmpty()){
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
			ServerHandler.sendData(session, respMap);
			return;
		}
		int zxl = roleItem.get(0).getNum();
		if(zxl<=0){//诛仙令不足
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
			ServerHandler.sendData(session, respMap);
			return;
		}
		param.clear();
		param.put("num", 1);
		param.put("roleid", roleId);
		param.put("itemid", 185);
		this.getRoleItemService().subRoleItem(param);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("num", zxl-1);
		map.put("bid", roleItem.get(0).getId());
		map.put("id", roleItem.get(0).getItemid());
		rlt.put("item", map);
		map =null;
		roleItem=null;
		//增加诛仙令
		GameRoleDetail gameRole = this.getGameRoleService().findRoleById(roleId);
		int zhuxl = gameRole.getZhuxianling();
		param.clear();
		param.put("id", roleId);
		param.put("zhuxianling", zhuxl+1);
		this.getGameRoleService().updateRoleVip(param);
		rlt.put("zxl", zhuxl+1);
		gameRole=null;
	//System.out.println(rlt);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);
		rlt=null;
		param=null;
	}

	private void gamestart() {
		if(params.containsKey("t")){
			int roleId = Integer.parseInt(playerId);
			int t = Integer.parseInt(String.valueOf(params.get("t")));
			Map<String,Object> rlt = new HashMap<String,Object>();
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("roleId", roleId);
			param.put("fuben", 1);
			List<RoleMilitaryDetail> roleMili = this.getRoleMilitaryService().getRoleMilitaryByparam(param);
			if(roleMili.isEmpty()){//没有选择出战兵
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);
				ServerHandler.sendData(session, respMap);
				return;
			}
			roleMili=null;
			GameRoleDetail gameRole = this.getGameRoleService().findRoleById(roleId);
			if(gameRole==null){
				return;
			}
			int mapid = gameRole.getBmap();
			int zxl = gameRole.getZhuxianling();
			if(t==1){//
				List<GameVipDetail> gamevip = this.getGameVipService().getGameVipByLe(gameRole.getVip());
				if(!gamevip.isEmpty()){
					if(zxl==gamevip.get(0).getZhuxianTop()){
						if(zxl==gamevip.get(0).getZhuxianTop()){
							param.clear();
							param.put("id", roleId);
							param.put("zxtime", System.currentTimeMillis());
							this.getGameRoleService().updateRoleVip(param);
						}
					}
				}
				if(zxl>=1){
					param.clear();
					param.put("id", roleId);
					param.put("zhuxianling", zxl-1);
					this.getGameRoleService().updateRoleVip(param);
					rlt.put("zxl", zxl-1);
					//标记正常战斗
					param.clear();
					param.put("roleid", roleId);
					param.put("mapid", mapid);
					param.put("status", 1);
					this.getRoleBingService().updateRoleBing(param);
				}else{//诛仙令不足
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
					ServerHandler.sendData(session, respMap);
					return;
				}
			}else if(t==0){//训练，不消耗道具
				//更改倒计时
				param.clear();
				param.put("roleid", roleId);
				param.put("mapid", mapid);
				List<RoleBingDetail> roleBing = this.getRoleBingService().findRoleBingByParams(param);
				long time = (System.currentTimeMillis()-gameRole.getBtime())/1000;
				if(time>=0){
					//标记正常战斗
					param.clear();
					param.put("id", roleId);
					param.put("btime", System.currentTimeMillis()+1800000);
					this.getGameRoleService().updateRoleVip(param);
				}else{//等待冷却时间
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);
					ServerHandler.sendData(session, respMap);
					return;
				}
				param.clear();
				param.put("roleid", roleId);
				param.put("mapid", mapid);
				param.put("status", 1);
				this.getRoleBingService().updateRoleBing(param);
				rlt.put("zxl", zxl);
				
				
			}
			verifyBattle(session, roleId,mapid);//记录校验数据
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
			rlt=null;
			param=null;
			gameRole=null;
		}
	}

	private void addbingtype() {
		if(params.containsKey("id")&&params.containsKey("t")&&params.containsKey("type")){
			int roleId = Integer.parseInt(playerId);
			int id = Integer.parseInt(String.valueOf(params.get("id")));
			int t = Integer.parseInt(String.valueOf(params.get("t")));//0123456
			int type = Integer.parseInt(String.valueOf(params.get("type")));
			Map<String,Object> rlt = new HashMap<String,Object>();
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("id", id);
			param.put("roleId", roleId);
			List<RoleMilitaryDetail> roleMili = this.getRoleMilitaryService().getRoleMilitaryByparam(param);
			if(roleMili.isEmpty()){
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
				ServerHandler.sendData(session, respMap);
				return;
			}
			int types = roleMili.get(0).getTypes();//初，高，中，终
			String bingstatus = roleMili.get(0).getBingstatus();
			if(t>=1&&t<=3){
				if(types<(t+1)){//武将等级不足
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-3);
					ServerHandler.sendData(session, respMap);
					return;
				}
				if(t==2){//t从0开始可以出bingstatus里的3兵
					if(bingstatus.indexOf("2")==-1){//不可以出该兵
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);
						ServerHandler.sendData(session, respMap);
						return;
					}
				}else if(t==3){
					if(bingstatus.indexOf("2")==-1	||	bingstatus.indexOf("3")==-1){//不可以出该兵
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);
						ServerHandler.sendData(session, respMap);
						return;
					}
				}
			}else if(t>=4&&t<=6){
				if(types<(t-2)){//武将等级不足
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-3);
					ServerHandler.sendData(session, respMap);
					return;
				}
				if(t==5){//出bingstatus里的6
					if(bingstatus.indexOf("5")==-1){//不可以出该兵
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);
						ServerHandler.sendData(session, respMap);
						return;
					}
				}else if(t==6){
					if(bingstatus.indexOf("5")==-1	||	bingstatus.indexOf("6")==-1){//不可以出该兵
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);
						ServerHandler.sendData(session, respMap);
						return;
					}
				}
			}
			//那种购买方式

			GameRoleDetail gameRole = this.getGameRoleService().findRoleById(roleId);
			int gongxun = gameRole.getGongxun();
			
			int mid = roleMili.get(0).getMilitaryid();//武将的ID
			List<GameMilitaryDetail> gameM = this.getGameMilitaryService().getGameMilitaryBymid(mid);
			if(!gameM.isEmpty()){
				int tt = t;
				int te = gameM.get(0).getType();
				if(te==2){
					tt +=7;
				}else if(te==3){
					tt +=14;
				}
				param.clear();
				param.put("id", tt+1);
				param.put("type", te);
				List<GameBingDetail> gameBing = this.getGameBingService().getGameBingById(param);
				if(gameBing.isEmpty()){
					return;
				}
				
				Map<String,Object> map = new HashMap<String,Object>();
			if(type==1){//道具购买
				//减少道具
				
				param.clear();
				param.put("roleid", roleId);
				param.put("itemid", 170);//兵符
				List<RoleItemDetail> roleItem = this.getRoleItemService().getRoleItemByitem(param);
				if(roleItem.isEmpty()){//道具不存在
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);
					ServerHandler.sendData(session, respMap);
					return;
				}
				int num = roleItem.get(0).getNum();
				//if(num<=gameBing.get(0).getBingfu()){//道具不足
				if(num<gameBing.get(0).getBingfu()){//道具不足	
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);
					ServerHandler.sendData(session, respMap);
					return;
				}
				//减少道具
				param.clear();
				param.put("num", gameBing.get(0).getBingfu());
				param.put("roleid", roleId);
				param.put("itemid", 170);
				this.getRoleItemService().subRoleItem(param);
				map.put("bid", roleItem.get(0).getId());
				map.put("id", 170);
				map.put("num", num-gameBing.get(0).getBingfu());
		//		System.out.println(map);
				rlt.put("item", map);
				rlt.put("gongxun", gongxun);
				roleItem=null;
				map = null;
			}else{//功勋购买
				
					if(!gameBing.isEmpty()){
						if(gongxun>=gameBing.get(0).getGongjun()){//修改功勋相等时不能升级的问题
							this.getGameRoleService().subRoleGongxun(roleId, gameBing.get(0).getGongjun());
							rlt.put("gongxun", gongxun-gameBing.get(0).getGongjun());
							rlt.put("item", map);
							map = null;
						}else{//功勋不足
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-5);
							ServerHandler.sendData(session, respMap);
							return;
						}
					}
					gameBing = null;
					
				}
				gameM=null;
			}
			//标记可以出战
			int i = t+1;
			bingstatus = bingstatus+i;
			param.clear();
			param.put("bingstatus", bingstatus);
			param.put("roleId", roleId);
			param.put("id", id);
			this.getRoleMilitaryService().updateRoleMilitary(param);
			
			rlt.put("id", id);
			rlt.put("t", t);
			rlt.put("bingstatus", bingstatus);
			rlt.put("bing", roleMili.get(0).getBing());
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
	//		System.out.println(rlt);
			rlt=null;
			param=null;
			roleMili=null;
		}
	}

	private void bingtype() {
//		if(params.containsKey("id")&&params.containsKey("t")){
//			int roleId = Integer.parseInt(playerId);
//			int id = Integer.parseInt(String.valueOf(params.get("id")));
//			int t = Integer.parseInt(String.valueOf(params.get("t")));//0123456
//			Map<String,Object> rlt = new HashMap<String,Object>();
//			Map<String,Object> param = new HashMap<String,Object>();
//			param.put("id", id);
//			param.put("roleId", roleId);
//			List<RoleMilitaryDetail> roleMili = this.getRoleMilitaryService().getRoleMilitaryByparam(param);
//			String bingstatus = "";
//			if(roleMili.isEmpty()){
//				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
//				ServerHandler.sendData(session, respMap);
//				return;
//			}
//			int types = roleMili.get(0).getTypes();//初，高，中，终
//			bingstatus = roleMili.get(0).getBingstatus();
//			if(t>=1&&t<=3){
//				if(types<(t+1)){//武将等级不足
//					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-3);
//					ServerHandler.sendData(session, respMap);
//					return;
//				}
//				if(t==1){//t从0开始可以出bingstatus里的2兵
//					if(bingstatus.indexOf("2")==-1){//不可以出该兵
//						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);
//						ServerHandler.sendData(session, respMap);
//						return;
//					}
//				}else if(t==2){
//					if(bingstatus.indexOf("2")==-1	||	bingstatus.indexOf("3")==-1){//不可以出该兵
//						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);
//						ServerHandler.sendData(session, respMap);
//						return;
//					}
//				}else if(t==3){
//					if(bingstatus.indexOf("2")==-1	||	bingstatus.indexOf("3")==-1	|| bingstatus.indexOf("4")==-1){//不可以出该兵
//						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);
//						ServerHandler.sendData(session, respMap);
//						return;
//					}
//				}
//			}else if(t>=4&&t<=6){
//				if(types<(t-2)){//武将等级不足
//					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-3);
//					ServerHandler.sendData(session, respMap);
//					return;
//				}
//				if(t==4){//出bingstatus里的5
//					if(bingstatus.indexOf("5")==-1){//不可以出该兵
//						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);
//						ServerHandler.sendData(session, respMap);
//						return;
//					}
//				}else if(t==5){
//					if(bingstatus.indexOf("5")==-1	||	bingstatus.indexOf("6")==-1){//不可以出该兵
//						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);
//						ServerHandler.sendData(session, respMap);
//						return;
//					}
//				}else if(t==6){
//					if(bingstatus.indexOf("5")==-1	||	bingstatus.indexOf("6")==-1	|| bingstatus.indexOf("7")==-1){//不可以出该兵
//						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);
//						ServerHandler.sendData(session, respMap);
//						return;
//					}
//				}
//			}
//			//统一标记出该兵
//			param.clear();
//			param.put("bing", t+1);
//			param.put("roleId", roleId);
//			param.put("id", id);
//			this.getRoleMilitaryService().updateRoleMilitary(param);
//		
//			
//			rlt.put("id", id);
//			rlt.put("t", t+1);
//			rlt.put("bingstatus", bingstatus);
//			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
//					GameConstants.GAME_API_SUCCESS);
//			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
//			ServerHandler.sendData(session, respMap);
//			rlt=null;
//			param=null;
//			roleMili=null;
//		}

	

		if(params.containsKey("list")&&params.containsKey("type")){
			int roleId = Integer.parseInt(playerId);
			JsonSerializer json = new JsonSerializer();
			Map<String,Object> rlt = new HashMap<String,Object>();
			Map<String,Object> param = new HashMap<String,Object>();
	     	JSONArray ar=new JSONArray();
			int type=Integer.parseInt(String.valueOf(params.get("type")));//得到武将职业类型( 召唤阵法狙击)
//			System.out.println(type+":type:::::params.get(list)::::::"+params.get("list"));
		List<Map<String, Object>> list = null;	
	     try {
            	    list = (List<Map<String, Object>>) json
 				.deserialize(params.get("list"));
            	} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				for(int i=0;i<list.size();i++){
					int id=Integer.parseInt(String.valueOf(list.get(i).get("id")));
					int t=Integer.parseInt(String.valueOf(list.get(i).get("t")));//0123456
				//System.out.println(id+"::id:::::::::::::::::::::::::::t::"+t);
				param.clear();
				param.put("id", id);
				param.put("roleId", roleId);
				List<RoleMilitaryDetail> roleMili = this.getRoleMilitaryService().getRoleMilitaryByparam(param);
				String bingstatus = "";
				if(roleMili.isEmpty()||roleMili.get(0)==null){
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
					ServerHandler.sendData(session, respMap);
					return;
				}
				int types = roleMili.get(0).getTypes();//初，高，中，终
				bingstatus = roleMili.get(0).getBingstatus();
				//System.out.println(bingstatus);
				//String str = this.roleMilitaryService.getRoleMilitaryById(roleId).getBingstatus();
//				System.out.println(str);   1
				
				if(t>=1&&t<=3){
					if(types<(t+1)){//武将等级不足
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-3);
						ServerHandler.sendData(session, respMap);
						return;
					}
					if(t==1){//t从0开始可以出bingstatus里的2兵
						if(bingstatus.indexOf("2")==-1){//不可以出该兵
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);
							ServerHandler.sendData(session, respMap);
							return;
						}
					}else if(t==2){
						if(bingstatus.indexOf("2")==-1	||	bingstatus.indexOf("3")==-1){//不可以出该兵
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);
							ServerHandler.sendData(session, respMap);
							return;
						}
					}else if(t==3){
						if(bingstatus.indexOf("2")==-1	||	bingstatus.indexOf("3")==-1	|| bingstatus.indexOf("4")==-1){//不可以出该兵
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);
							ServerHandler.sendData(session, respMap);
							return;
						}
					}
				}else if(t>=4&&t<=6){
					if(types<(t-2)){//武将等级不足
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-3);
						ServerHandler.sendData(session, respMap);
						return;
					}
					if(t==4){//出bingstatus里的5
						if(bingstatus.indexOf("5")==-1){//不可以出该兵
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);
							ServerHandler.sendData(session, respMap);
							return;
						}
					}else if(t==5){
						if(bingstatus.indexOf("5")==-1	||	bingstatus.indexOf("6")==-1){//不可以出该兵
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);
							ServerHandler.sendData(session, respMap);
							return;
						}
					}else if(t==6){
						if(bingstatus.indexOf("5")==-1	||	bingstatus.indexOf("6")==-1	|| bingstatus.indexOf("7")==-1){//不可以出该兵
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);
							ServerHandler.sendData(session, respMap);
							return;
						}
					}
				}
				//统一标记出该兵
				param.clear();
				param.put("bing", t+1);
				param.put("roleId", roleId);
				param.put("id", id);
				this.getRoleMilitaryService().updateRoleMilitary(param);
			
				param.clear();
				param.put("id", id);
				param.put("t", t+1);
				param.put("bingstatus", bingstatus);
				ar.add(param);
				} 
				//System.out.println(":::::::::::rlt.put(list,ar)::::"+ar);
				rlt.put("list",ar);
				rlt.put("type", type);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
			rlt=null;
			param=null;
			json=null;
			ar=null;
		}
	
	
	}

	private void chuzhan() {
//		if(params.containsKey("id")&&params.containsKey("t")){
//			int roleId = Integer.parseInt(playerId);
//			int id = Integer.parseInt(String.valueOf(params.get("id")));
//			int t = Integer.parseInt(String.valueOf(params.get("t")));
//			Map<String,Object> rlt = new HashMap<String,Object>();
//			Map<String,Object> param = new HashMap<String,Object>();
//			param.put("id", id);
//			param.put("roleId", roleId);
//			List<RoleMilitaryDetail> roleMili = this.getRoleMilitaryService().getRoleMilitaryByparam(param);
//			if(roleMili.isEmpty()){
//				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-3);
//				ServerHandler.sendData(session, respMap);
//				return;
//			}
//			if(t==1){//出战
//				int fuben = roleMili.get(0).getFuben();//是否出战
//				if(fuben==1){//已出战
//					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
//					ServerHandler.sendData(session, respMap);
//					return;
//				}
//				param.clear();
//				param.put("roleId", roleId);
//				param.put("id", id);
//				param.put("fuben", 1);
//				this.getRoleMilitaryService().updateRoleMilitary(param);
//			}else if(t==0){//取消出战
//				int fuben = roleMili.get(0).getFuben();//是否出战
//				if(fuben==0){//已出战
//					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);
//					ServerHandler.sendData(session, respMap);
//					return;
//				}
//				param.clear();
//				param.put("roleId", roleId);
//				param.put("id", id);
//				param.put("fuben", 0);
//				this.getRoleMilitaryService().updateRoleMilitary(param);
//			}
//			rlt.put("t", t);
//			rlt.put("id", id);
//			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
//					GameConstants.GAME_API_SUCCESS);
//			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
//			ServerHandler.sendData(session, respMap);
//			rlt=null;
//			param=null;
//			roleMili=null;
//		}
		

		if(params.containsKey("id")&&params.containsKey("t")){
			int roleId = Integer.parseInt(playerId);
			int t = Integer.parseInt(String.valueOf(params.get("t")));//1出战  0取消出战
			JSONArray js=null;
			try {
				js = JSONArray.fromObject(params.get("id"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			//System.out.println(":::::::::::::::::js:::"+js);
			Map<String,Object> rlt = new HashMap<String,Object>();
			Map<String,Object> param = new HashMap<String,Object>();
			for(int i=0;i<js.size();i++){
				int id=js.getInt(i);
				//System.out.println(":::::::::::::::::js.getInt(i):::"+js.getInt(i));
				param.clear();
				param.put("id", id);
				param.put("roleId", roleId);
				List<RoleMilitaryDetail> roleMili = this.getRoleMilitaryService().getRoleMilitaryByparam(param);
				if(roleMili.isEmpty()){
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-3);
					ServerHandler.sendData(session, respMap);
					return;
				}
				if(t==1){//出战
					if(roleMili.get(0)==null){
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-3);
						ServerHandler.sendData(session, respMap);
						return;
					}
					int fuben = roleMili.get(0).getFuben();//是否出战
					
					if(fuben==1){//已出战
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
						ServerHandler.sendData(session, respMap);
						return;
					}
					param.clear();
					param.put("roleId", roleId);
					param.put("id", id);
					param.put("fuben", 1);
					this.getRoleMilitaryService().updateRoleMilitary(param);
				}else if(t==0){//取消出战
					int fuben = roleMili.get(0).getFuben();//是否出战
					if(fuben==0){//已出战
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);
						ServerHandler.sendData(session, respMap);
						return;
					}
					param.clear();
					param.put("roleId", roleId);
					param.put("id", id);
					param.put("fuben", 0);
					this.getRoleMilitaryService().updateRoleMilitary(param);
				}
			}
			
			rlt.put("t", t);
			rlt.put("id", js);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
			rlt=null;
			param=null;
			js=null;
			
		}
	
	}

	private void openbing() {
		int roleId = Integer.parseInt(playerId);
		Map<String,Object> rlt = new HashMap<String,Object>();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("roleId", roleId);
		param.put("fuben", 1);
		List<RoleMilitaryDetail> roleMilitary = this.getRoleMilitaryService().getRoleMilitaryByparam(param);
		int size = roleMilitary.size();
		List list = new ArrayList();
		if(size!=0){
			for(int i=0;i<size;i++){
				list.add(roleMilitary.get(i).getId());
			}
		}
		rlt.put("mids", list);//出战武将数据id
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);
		rlt=null;
		param=null;
		roleMilitary=null;
		list=null;
	}

	private void openfuben() {
		if(params.containsKey("mapid")){
			int roleId = Integer.parseInt(playerId);
			int mapid = Integer.parseInt(String.valueOf(params.get("mapid")));
			Map<String,Object> rlt = new HashMap<String,Object>();
			Map<String,Object> param = new HashMap<String,Object>();
			GameRoleDetail gameRole = this.getGameRoleService().findRoleById(roleId);
			if(gameRole==null){
				return;
			}
			int vip = gameRole.getVip();
			
			if(mapid>gameRole.getMapid()||mapid<=0){
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
				ServerHandler.sendData(session, respMap);
				return;
			}
			//插入副本任务
//			if(gameRole.getFuben()==1){//401是玩家通过了第11关第10波后添加
//				if(mapid>9){
//					List<GameTaskDetail> gameTask = this.getGameTaskService().getGameTaskDetailById(401);//11关执行
//					if(!gameTask.isEmpty()){
//						int bid = this.getAutoIdService().fingKeyValueByTableName("role_task_task");
//						param.clear();
//						param.put("id", bid);
//						param.put("roleId", roleId);
//						param.put("type", gameTask.get(0).getType());
//						param.put("tasktype", gameTask.get(0).getTasktype());
//						param.put("tasklevel", gameTask.get(0).getTasklevel());
//						param.put("taskid", gameTask.get(0).getId());
//						param.put("taskoldid", gameTask.get(0).getOldid());
//						param.put("tasknum", gameTask.get(0).getTasknum());
//						param.put("states", 0);
//						param.put("flag", 1);
//						param.put("progress", 0);
//						boolean b=this.getRoleTaskTaskService().insertRoleTask0(param);
//		//				System.out.println("插入gameTask=========="+b);
//						//this.getAutoIdService().updateKeyValueAddOneByTableName("role_task_task");
//						gameTask=null;
//						
//						param.clear();
//						param.put("id", roleId);
//						param.put("fuben", 0);
//						this.getGameRoleService().updateRoleVip(param);
//					}	
//				}
//			
//			}
			
//			if(gameRole.getFubentwo()==1){
//	List<GameTaskDetail> gameTask2 = this.getGameTaskService().getGameTaskDetailById(527);//第二关
//				
//				
//				if(!gameTask2.isEmpty()){
//					int bid = this.getAutoIdService().fingKeyValueByTableName("role_task_task");
//					param.clear();
//					param.put("id", bid);
//					param.put("roleId", roleId);
//					param.put("type", gameTask2.get(0).getType());
//					param.put("tasktype", gameTask2.get(0).getTasktype());
//					param.put("tasklevel", gameTask2.get(0).getTasklevel());
//					param.put("taskid", gameTask2.get(0).getId());
//					param.put("taskoldid", gameTask2.get(0).getOldid());
//					param.put("tasknum", gameTask2.get(0).getTasknum());
//					param.put("states", 0);
//					param.put("flag", 1);
//					param.put("progress", 0);
//					boolean b2=this.getRoleTaskTaskService().insertRoleTask0(param);
//		//			System.out.println("插入gameTask2==="+b2);
//					//this.getAutoIdService().updateKeyValueAddOneByTableName("role_task_task");
//					gameTask2=null;
//					
//					param.clear();
//					param.put("id", roleId);
//					param.put("fubentwo", 0);
//					this.getGameRoleService().updateRoleVip(param);
//				}
//			}
			
			
			if(gameRole.getFubentwo()==1){//插入第一个副本任务527（修改）
				List<GameTaskDetail> gameTask2 = this.getGameTaskService().getGameTaskDetailById(527);//第二关
							//this.getRoleTaskTaskService().findRoleTask(roleId);
				//System.out.println("1=============================================================================");
				//GameConstants.log.warn("玩家Id："+roleId+"第1个副本任务527进入副本就插入：");
				if(!gameTask2.isEmpty()){
								//GameConstants.log.warn("玩家Id："+roleId+"第1个副本任务527进入副本就插入：");
								int bid = this.getAutoIdService().fingKeyValueByTableName("role_task_task");
								param.clear();
								param.put("id", bid);
								param.put("roleId", roleId);
								param.put("type", gameTask2.get(0).getType());
								param.put("tasktype", gameTask2.get(0).getTasktype());
								param.put("tasklevel", gameTask2.get(0).getTasklevel());
								param.put("taskid", gameTask2.get(0).getId());
								param.put("taskoldid", gameTask2.get(0).getOldid());
								param.put("tasknum", gameTask2.get(0).getTasknum());
								param.put("states", 0);
								param.put("flag", 1);
								param.put("progress", 0);
								boolean b2=this.getRoleTaskTaskService().insertRoleTask0(param);
					//			System.out.println("插入gameTask2==="+b2);
								//this.getAutoIdService().updateKeyValueAddOneByTableName("role_task_task");
								gameTask2=null;
								
								param.clear();
								param.put("id", roleId);
								param.put("fubentwo", 0);
								this.getGameRoleService().updateRoleVip(param);
							}
						}
			
			if(gameRole.getFuben()==1){//第2个副本任务(xiugai)401是玩家通过了第11关第10波后添加
				int atlas=gameRole.getMapid();
				int place=gameRole.getPlaceid();
				if(atlas>=11&&place>=1){
					//System.out.println("2=============================================================================");
					//System.out.println("第2个副本任务401玩家的地图："+atlas+"  玩家在多少波：："+place);
					List<GameTaskDetail> gameTask = this.getGameTaskService().getGameTaskDetailById(401);//11关执行
					if(!gameTask.isEmpty()){
						//GameConstants.log.warn("玩家Id："+roleId+"第2个副本任务401玩家的地图："+atlas+"  玩家在多少波：："+place);
						int bid = this.getAutoIdService().fingKeyValueByTableName("role_task_task");
						param.clear();
						param.put("id", bid);
						param.put("roleId", roleId);
						param.put("type", gameTask.get(0).getType());
						param.put("tasktype", gameTask.get(0).getTasktype());
						param.put("tasklevel", gameTask.get(0).getTasklevel());
						param.put("taskid", gameTask.get(0).getId());
						param.put("taskoldid", gameTask.get(0).getOldid());
						param.put("tasknum", gameTask.get(0).getTasknum());
						param.put("states", 0);
						param.put("flag", 1);
						param.put("progress", 0);
						boolean b=this.getRoleTaskTaskService().insertRoleTask0(param);
		//				System.out.println("插入gameTask=========="+b);
						//this.getAutoIdService().updateKeyValueAddOneByTableName("role_task_task");
						gameTask=null;
						
						param.clear();
						param.put("id", roleId);
						param.put("fuben", 0);
						this.getGameRoleService().updateRoleVip(param);
					}	
				}
			
			}
			
			
			if(gameRole.getFubenthree()==1){//第三个副本任务(xiugai)
				int atlas=gameRole.getMapid();
				int place=gameRole.getPlaceid();
				if(atlas>=26&&place>=1){
					List<GameTaskDetail> gameTask2 = this.getGameTaskService().getGameTaskDetailById(563);//第二关
					//System.out.println("3=============================================================================");
					if(!gameTask2.isEmpty()){
						//System.out.println(roleId+"插入玩家第3个副本任务563玩家的地图："+atlas+"  玩家在多少波：："+place);
						//GameConstants.log.warn("玩家ID："+roleId+"  插入第3个副本任务563玩家的地图："+atlas+"  玩家在多少波：："+place);
						//int bid = this.getAutoIdService().fingKeyValueByTableName("role_task_task") + 1;
						int bid = this.getAutoIdService().fingKeyValueByTableName("role_task_task");
						param.clear();
						param.put("id", bid);
						param.put("roleId", roleId);
						param.put("type", gameTask2.get(0).getType());
						param.put("tasktype", gameTask2.get(0).getTasktype());
						param.put("tasklevel", gameTask2.get(0).getTasklevel());
						param.put("taskid", gameTask2.get(0).getId());
						param.put("taskoldid", gameTask2.get(0).getOldid());
						param.put("tasknum", gameTask2.get(0).getTasknum());
						param.put("states", 0);
						param.put("flag", 1);
						param.put("progress", 0);
						boolean b2=this.getRoleTaskTaskService().insertRoleTask0(param);
			//			System.out.println("插入gameTask2==="+b2);
						//this.getAutoIdService().updateKeyValueAddOneByTableName("role_task_task");
						gameTask2=null;
						
						param.clear();
						param.put("id", roleId);
						param.put("fubenthree", 0);
						this.getGameRoleService().updateRoleVip(param);
					}
				}
				
						}
			
			
			
//			if(gameRole.getFubenthree()==1){//第三个副本任务
//				List<GameTaskDetail> gameTask2 = this.getGameTaskService().getGameTaskDetailById(563);//第二关
//							
//							
//							if(!gameTask2.isEmpty()){
//								//int bid = this.getAutoIdService().fingKeyValueByTableName("role_task_task") + 1;
//								int bid = this.getAutoIdService().fingKeyValueByTableName("role_task_task");
//								param.clear();
//								param.put("id", bid);
//								param.put("roleId", roleId);
//								param.put("type", gameTask2.get(0).getType());
//								param.put("tasktype", gameTask2.get(0).getTasktype());
//								param.put("tasklevel", gameTask2.get(0).getTasklevel());
//								param.put("taskid", gameTask2.get(0).getId());
//								param.put("taskoldid", gameTask2.get(0).getOldid());
//								param.put("tasknum", gameTask2.get(0).getTasknum());
//								param.put("states", 0);
//								param.put("flag", 1);
//								param.put("progress", 0);
//								boolean b2=this.getRoleTaskTaskService().insertRoleTask0(param);
//					//			System.out.println("插入gameTask2==="+b2);
//								//this.getAutoIdService().updateKeyValueAddOneByTableName("role_task_task");
//								gameTask2=null;
//								
//								param.clear();
//								param.put("id", roleId);
//								param.put("fubenthree", 0);
//								this.getGameRoleService().updateRoleVip(param);
//							}
//						}
			//更新副本地图
	//		System.out.println("mapid:"+mapid);
			if(mapid!=gameRole.getBmap()){
				param.clear();
				param.put("id", roleId);
				param.put("bmap", mapid);
				this.getGameRoleService().updateRoleVip(param);
			}
			param.clear();
			param.put("roleid", roleId);
			param.put("mapid", mapid);
			List<RoleBingDetail> roleBing = this.getRoleBingService().findRoleBingByParams(param);
			if(roleBing.isEmpty()){
				param.clear();
				param.put("roleid", roleId);
				param.put("mapid", mapid);
				param.put("nandu", 0);
				param.put("stars", 0);
				param.put("flag", 1);
				this.getRoleBingService().insertRoleBing(param);
				
				param.remove("nandu");
				param.remove("stars");
				roleBing = this.getRoleBingService().findRoleBingByParams(param);
			}
			//设置战斗难度为最大值
			int nandu = roleBing.get(0).getNandu();
			int nandu2 = roleBing.get(0).getNandu2();
			if(nandu!=nandu2){
				param.clear();
				param.put("roleid", roleId);
				param.put("nandu2", nandu);
				param.put("mapid", mapid);
				this.getRoleBingService().updateRoleBing(param);
			}
			long time = (gameRole.getBtime()-System.currentTimeMillis())/1000;
			if(time<=0){
				rlt.put("time", 0);
			}else{
				rlt.put("time", time);
			}
			
			
			/****/
			List<GameVipDetail> gv = this.getGameVipService().getGameVipByLe(vip);
			if(gameRole.getZhuxianling()<1){
				long hour = (System.currentTimeMillis()-gameRole.getZxtime());
				long h = gv.get(0).getHour()*1000*60*60;
				long lesstime=(h-hour)/1000;
				if(lesstime<0){
					lesstime=0;
				}
				rlt.put("lesstime", lesstime);
			}else{
				rlt.put("lesstime", 0);
			}
			/****/
			
			rlt.put("nandu", nandu);
			rlt.put("stars", roleBing.get(0).getStars());
			rlt.put("zxl", gameRole.getZhuxianling());
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
			rlt =null;
			param=null;
			gameRole=null;
			roleBing=null;
		}
	}

	/**
	 * 缓存校验战斗信息
	 * @param session
	 * @param roleId
	 * @param mapid战斗地图
	 */
	void verifyBattle(IoSession session,int roleId,int mapid){
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("roleId", roleId);
		param.put("fuben", 1);
		List<RoleMilitaryDetail> roleM = this.getRoleMilitaryService().getRoleMilitaryByparam(param);
		if(!roleM.isEmpty()){
			session.removeAttribute("bing");
			int size = roleM.size();
			int gongji=0;
			List<GameMilitaryDetail> gameM = null;
			List<RoleEquipDetail> wq =null;
			List<RoleEquipDetail> hw = null;
			List<RoleEquipDetail> yf = null;
			List<RoleEquipDetail> tg = null;
			List<RoleEquipDetail> xz = null;
			List<RoleEquipDetail> sp = null;
			List<GameStarDetail> gs = null;
			JSONArray list = new JSONArray();
			param.clear();
			param.put("roleid", roleId);
			param.put("mapid", mapid);
			List<RoleBingDetail> roleBing = this.getRoleBingService().findRoleBingByParams(param);
			param.clear();
			param.put("mapid", mapid);
			param.put("nandu", roleBing.get(0).getNandu2());
			List<GameBmapDetail> gameBmap = this.getGameBmapService().findGameBmapByParams(param);
			int id = 1;
			if(!gameBmap.isEmpty()){
				id = gameBmap.get(0).getId();
			}
			roleBing = null;
			gameBmap = null;
			double addattack=0;
			for(int i=0;i<size;i++){
				gameM = this.getGameMilitaryService().getGameMilitaryBymid(roleM.get(i).getMilitaryid());
				gongji = gameM.get(0).getGongji()+gameM.get(0).getGjiacheng()*(roleM.get(i).getLevel()-1);
				param.clear();
				param.put("id", roleM.get(i).getWuqi());
				wq = this.getRoleEquipService().getRoleEquipDetail(param);
				if(!wq.isEmpty()){
					gs=this.getGameStarService().getgamestars(wq.get(0).getStarlevel());
					if(!gs.isEmpty()){
						addattack=(wq.get(0).getAttack())*gs.get(0).getStatusadd()/100;
					}
					gongji = (int) (gongji + wq.get(0).getAttack() + addattack);
				}
				param.clear();
				param.put("id", roleM.get(i).getHuwan());
				hw = this.getRoleEquipService().getRoleEquipDetail(param);
				if(!hw.isEmpty()){
					gs=this.getGameStarService().getgamestars(hw.get(0).getStarlevel());
					if(!gs.isEmpty()){
						addattack=(hw.get(0).getAttack())*gs.get(0).getStatusadd()/100;
					}
					gongji = (int) (gongji + hw.get(0).getAttack() + addattack);
				}
				param.clear();
				param.put("id", roleM.get(i).getYifu());
				yf = this.getRoleEquipService().getRoleEquipDetail(param);
				if(!yf.isEmpty()){
					gs=this.getGameStarService().getgamestars(yf.get(0).getStarlevel());
					if(!gs.isEmpty()){
						addattack=(yf.get(0).getAttack())*gs.get(0).getStatusadd()/100;
					}
					gongji = (int) (gongji + yf.get(0).getAttack()+ addattack);
				}
				param.clear();
				param.put("id", roleM.get(i).getTouguan());
				tg = this.getRoleEquipService().getRoleEquipDetail(param);
				if(!tg.isEmpty()){
					gs=this.getGameStarService().getgamestars(tg.get(0).getStarlevel());
					if(!gs.isEmpty()){
						addattack=(tg.get(0).getAttack())*gs.get(0).getStatusadd()/100;
					}
					gongji = (int) (gongji + tg.get(0).getAttack()+ addattack);
				}
				param.clear();
				param.put("id", roleM.get(i).getXiezi());
				xz = this.getRoleEquipService().getRoleEquipDetail(param);
				if(!xz.isEmpty()){
					gs=this.getGameStarService().getgamestars(xz.get(0).getStarlevel());
					if(!gs.isEmpty()){
						addattack=(xz.get(0).getAttack())*gs.get(0).getStatusadd()/100;
					}
					gongji = (int) (gongji + xz.get(0).getAttack()+ addattack);
				}
				param.clear();
				param.put("id", roleM.get(i).getShipin());
				sp = this.getRoleEquipService().getRoleEquipDetail(param);
				if(!sp.isEmpty()){
					gs=this.getGameStarService().getgamestars(sp.get(0).getStarlevel());
					if(!gs.isEmpty()){
						addattack=(sp.get(0).getAttack())*gs.get(0).getStatusadd()/100;
					}
					gongji = (int) (gongji + sp.get(0).getAttack()+ addattack);
				}
				
				param.clear();
				param.put("mid", roleM.get(i).getId());
				param.put("atk", gongji);
				param.put("mapid", id);
				list.add(param);
			}
			session.setAttribute("bing", list);
			gameM = null;
			wq =null;
			hw = null;
			yf = null;
			tg = null;
			xz = null;
			sp = null;
			gs = null;
		}
		param = null;
		roleM = null;
	}

}