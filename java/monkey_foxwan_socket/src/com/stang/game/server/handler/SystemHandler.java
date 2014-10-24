package com.stang.game.server.handler;

/**
 * @author fei_wei
 * @company 上海三唐信息科技有限公司
 * @description 系统文件处理
 */
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.sf.json.JSONArray;
import net.sf.sojo.interchange.json.JsonSerializer;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.mina.core.session.IoSession;

import com.alibaba.fastjson.JSON;
import com.google.gson.JsonArray;
import com.stang.game.cache.ClrCache;
import com.stang.game.cache.GlobalData;
import com.stang.game.cache.GlobalDatat;
import com.stang.game.cache.QueueCache;
import com.stang.game.cache.ThreadCache;
import com.stang.game.common.GameConstants;
import com.stang.game.entity.detail.ActivityDetail;
import com.stang.game.entity.detail.CdkStoreDetail;
import com.stang.game.entity.detail.DeliveryDetail;
import com.stang.game.entity.detail.GameBbuffDetail;
import com.stang.game.entity.detail.GameBingDetail;
import com.stang.game.entity.detail.GameBmapDetail;
import com.stang.game.entity.detail.GameBskillDetail;
import com.stang.game.entity.detail.GameBuffDetail;
import com.stang.game.entity.detail.GameChLevelDetail;
import com.stang.game.entity.detail.GameEInsDetail;
import com.stang.game.entity.detail.GameEPropertyDetail;
import com.stang.game.entity.detail.GameEquipDetail;
import com.stang.game.entity.detail.GameFoeDetail;
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
import com.stang.game.entity.detail.RoleEquipDetail;
import com.stang.game.entity.detail.RoleItemDetail;
import com.stang.game.entity.detail.RoleMilitaryDetail;
import com.stang.game.entity.detail.RoleTaskTaskDetail;
import com.stang.game.entity.detail.RoletotemDetail;
import com.stang.game.entity.detail.ServerDetail;
import com.stang.game.entity.detail.ShopdiscountDetail;
import com.stang.game.server.ServerHandler;
import com.stang.game.service.ICoinService;
import com.stang.game.service.IGameVipService;
import com.stang.game.service.IGameYellowVipService;
import com.stang.game.service.IGametotemService;
import com.stang.game.service.IRoleEquipService;
import com.stang.game.service.IRoleItemService;
import com.stang.game.service.IRoleMilitaryService;
import com.stang.game.service.IRoletotemService;
import com.stang.game.service.IServerService;
import com.stang.game.service.IShopdiscountService;
import com.stang.game.service.impl.CoinServiceImpl;
import com.stang.game.service.impl.GameStarServiceImpl;
import com.stang.game.service.impl.GameVipServiceImpl;
import com.stang.game.service.impl.GameYellowVipServiceImpl;
import com.stang.game.service.impl.GametotemServiceImpl;
import com.stang.game.service.impl.RoleEquipServiceImpl;
import com.stang.game.service.impl.RoleItemServiceImpl;
import com.stang.game.service.impl.RoleMilitaryServiceImpl;
import com.stang.game.service.impl.RoletotemServiceImpl;
import com.stang.game.service.impl.ServerServiceImpl;
import com.stang.game.service.impl.ShopdiscountServiceImpl;

public class SystemHandler extends BaseHandler {
	
	public static QueueCache systemMessageQueue = null;
	//静态类同步数据库线程
	public static ThreadCache thread = null;
	private static IRoleEquipService roleEquipService;
	private IRoleEquipService getRoleEquipService() {
		if (roleEquipService == null) {
			roleEquipService = new RoleEquipServiceImpl();
		}
		return roleEquipService;
	}
	private static IGameYellowVipService gameYellowVipService=null;
	private static IGameYellowVipService getGameYellowVipService(){
		if(gameYellowVipService==null){
			gameYellowVipService=new GameYellowVipServiceImpl();	
		}
		return gameYellowVipService;
		
	}
	
	static private SystemHandler systemHandler;

	private SystemHandler getsystemHandler() {
		if (systemHandler == null) {
			systemHandler = new SystemHandler();
		}
		return systemHandler;
	}
	
	private static IRoleMilitaryService roleMilitaryService;

	private IRoleMilitaryService getRoleMilitaryService() {
		if (roleMilitaryService == null) {
			roleMilitaryService = new RoleMilitaryServiceImpl();
		}
		return roleMilitaryService;
	}
	private static IRoletotemService roletotemService;
	private IRoletotemService getRoletotemService(){
		if(roletotemService==null){
			roletotemService=new RoletotemServiceImpl();
		}
		return roletotemService;
	}
	private static ICoinService coin;

	private ICoinService getCoinService() {
		if (coin == null) {
			coin = new CoinServiceImpl();
		}
		return coin;
	}
	
	static private TaskHandler taskHandler;

	private TaskHandler getTaskHandler() {
		if (taskHandler == null) {
			taskHandler = new TaskHandler(gameApiName, globalIdentifier,
					encryptedSignature, playerId, cacheKey, params, session);
		}
		return taskHandler;
	}
	
	private static IGameVipService gameVipService;

	private IGameVipService getGameVipService() {
		if (gameVipService == null) {
			gameVipService = new GameVipServiceImpl();
		}
		return gameVipService;
	}
	private static IGametotemService gametotemService;
	private IGametotemService getGametotemService(){
		if(gametotemService==null){
			gametotemService=new GametotemServiceImpl();
		}
		return gametotemService;
	}
	private static IRoleItemService roleItemService;

	private IRoleItemService getRoleItemService() {
		if (roleItemService == null) {
			roleItemService = new RoleItemServiceImpl();
		}
		return roleItemService;
	}
	
	private static IServerService ServerService;

	private IServerService getServerService() {
		if (ServerService == null) {
			ServerService = new ServerServiceImpl();
		}
		return ServerService;
	}
	private static IShopdiscountService shopService=new ShopdiscountServiceImpl();
	
	static private PlayerHandler playerHandler;
	private PlayerHandler getplayerHandler() {
		if (playerHandler == null) {
			playerHandler = new PlayerHandler(gameApiName, globalIdentifier,
					encryptedSignature, playerId, cacheKey, params, session);
		}
		return playerHandler;
	}
	public SystemHandler(){}
	public SystemHandler(String gameApiName, String globalIdentifier,
			String encryptedSignature, String playerId, String cacheKey,
			Map params, IoSession session) {
		super(gameApiName, globalIdentifier, encryptedSignature, playerId,
				cacheKey, params, session);
		if (gameApiName.equals("sys.allmodels")) {
			/** 所有模型信息 */
			this.allModels();
		} else if (gameApiName.equals("sys.impose")) {
			/** 所有模型信息 */
			this.impose();
		}else if (gameApiName.equals("sys.upStep")) {
			upStep();// 更新新手进度
		}else if (gameApiName.equals("sys.pay")) {
			pay();// 奖励小人钱
		}else if (gameApiName.equals("sys.message")) {
			message();// 系统公告
		}else if (gameApiName.equals("sys.buygoods1")) {
			buygoods();// 购买
		}else if (gameApiName.equals("sys.buygoods2")) {
			buygoods();// 购买
		}else if (gameApiName.equals("sys.buygoods3")) {
			buygoods();// 购买,元宝优先购买
		}else if (gameApiName.equals("sys.buybylevel")) {
			buybylevel();// 到达一定等级开放购买
		}else if (gameApiName.equals("sys.clrcache")) {
			clrcache();// 刷新模型缓存
		}else if (gameApiName.equals("sys.openactivity")) {
			openactivity();// 打开活动
		}else if (gameApiName.equals("sys.changeactivity")) {
			changeactivity();// 选择点击活动
		}else if (gameApiName.equals("sys.getreward")) {
			getreward();// 活动领取奖励
		}else if (gameApiName.equals("sys.cacheRoleItem")) {
			cacheRoleItem();//
		}else if (gameApiName.equals("sys.cacheGameRole")) {
			cacheGameRole();//
		}else if (gameApiName.equals("sys.cacheGameRoletwo")) {
			cacheGameRoletwo();//
		}else if (gameApiName.equals("sys.cacheGameRolethree")) {
			cacheGameRolethree();//
		}else if (gameApiName.equals("sys.buyhoudongitem")) {
			buyhoudongitem();//
		}else if (gameApiName.equals("sys.opencompensate")) {
			opencompensate();//打开补偿活动
		}else if (gameApiName.equals("sys.compensategift")) {
			compensategift();//补偿活动领取奖励
		}else if (gameApiName.equals("sys.cdk")) {
			cdk();//CDK领取奖励
		}else if (gameApiName.equals("sys.cacheMember")) {
			//cacheMember();
		}else if (gameApiName.equals("sys.cacheRoletotem")) {
			cacheRoletotem();
		}else if (gameApiName.equals("sys.insertRoleItem")) {
			insertRoleItem();
		}else if (gameApiName.equals("sys.udpateGameRoleCoinAndCoinspend")) {
			udpateGameRoleCoinAndCoinspend();
		}else if (gameApiName.equals("sys.updateGameRoleBylevel")) {
			updateGameRoleBylevel();
		}else if (gameApiName.equals("sys.cacheRoletasktask")) {
			cacheRoletasktask();//更新用户任务缓存
		}else if (gameApiName.equals("sys.cacheRoleEquip")) {
			cacheRoleEquip();//更新用户装备
		}else if (gameApiName.equals("sys.shutdown")) {
			//System.out.println("SystemHandler（）关闭服务器");
			ServerHandler.closeServer();//更新用户装备
		}
		if(thread == null){
			thread = new ThreadCache("systemMessage");
			thread.start();
		}
		if(systemMessageQueue == null)
			systemMessageQueue = new QueueCache("systemMessage");
	}

	
	private void allModels() {
		if (params.containsKey("t")) {
			int t = Integer.parseInt(String.valueOf(params.get("t")));
			if(t==1){
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, GlobalDatat.rlt);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				ServerHandler.sendData(session, respMap);
			}else if(t==2){
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, GlobalDatat.rlttwo);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				ServerHandler.sendData(session, respMap);
			}
		}
//		GameConstants.log.warn("allModels start：：");
//		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, GlobalDatat.rlt);
//		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
//				GameConstants.GAME_API_SUCCESS);
//		ServerHandler.sendData(session, respMap);
//		GameConstants.log.warn("allModels over：：");
	}
	
	private void cdk(){
		if(params.containsKey("foxcdk")){
			String foxcdk = String.valueOf(params.get("foxcdk"));
			List<CdkStoreDetail> cdkstore = this.getCdkStoreService().findCdkStoreBycdk(foxcdk);
			Map<String, Object> rlt = new HashMap<String, Object>();
			int roleid1 = Integer.parseInt(playerId);
			if(cdkstore!=null){
				Map<String,Integer> item1 = new HashMap<String, Integer>();
			item1.put("1", 365);
			item1.put("2", 366);
			item1.put("3", 367);
			item1.put("4", 368);
			item1.put("5", 369);
			String employ = cdkstore.get(0).getEmploy();
			if(employ.equals("0")){
				String level1 = cdkstore.get(0).getLevel();
				int itemnum = item1.get(level1);
//				System.out.println("cdkstore.getlevel();:::"+level1);
				GameRoleDetail grd = this.getGameRoleService().findRoleById(roleid1);
				String getcdk = grd.getGetcdk();
				JSONArray ary = JSONArray.fromObject(getcdk);
				int dengji = Integer.valueOf(level1);
				if(getcdk!=null){
				Object num = ary.get(dengji-1);
//				System.out.println("num::"+String.valueOf(num));
				if(String.valueOf(num).equals("0")){
					Map<String, Object> params = new HashMap<String, Object>();
						JSONArray list = new JSONArray();
							int type = 5;
							int id = itemnum;
							int num1 = 1;
							if (type == 5) {// 道具
								params.clear();
								params.put("roleid", roleid1);
								params.put("itemid", id);
								List<RoleItemDetail> item = this.getRoleItemService().getRoleItem(params);
								// 判断背包格子是否已满
								int itemtype = this.getGameItemService().getGameItemById(id).get(0).getItemtype();
								boolean boo = this.getplayerHandler().getShangxian(itemtype, type, roleid1,id, num1);
								if (boo == false) {// 背包格子不足
									respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -4);
									respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "道具空间不足");
									ServerHandler.sendData(session, respMap);
									return;
								}
								if (!item.isEmpty()) {// 已存在
									params.clear();
									params.put("roleid", roleid1);
									params.put("id", item.get(0).getId());
									params.put("itemid", id);
									params.put("num", num1);
									params.put("itemid", id);
									boolean bo = this.getRoleItemService().addRoleItemNum(params);
									if (bo == true) {
										long bid = item.get(0).getId();
										params.clear();
										params.put("bid", bid);
										params.put("id", id);
										params.put("resType", type);
										params.put("num", num1);
										list.add(params);
									}
								} else {// 不存在，
									long bid = this.getAutoIdService().fingKeyValueByTableName("role_item");
									RoleItemDetail iDetail = new RoleItemDetail();
									iDetail.setId(bid);
									iDetail.setRoleid(roleid1);
									iDetail.setItemid(id);
									iDetail.setNum(num1);
									iDetail.setFlag(1);
									iDetail.setType(itemtype);
									boolean bo = this.getRoleItemService().insertRoleItem(iDetail);
									if (bo == true) {
										params.clear();
										params.put("bid", bid);
										params.put("id", id);
										params.put("resType", type);
										params.put("num", num1);
										list.add(params);
									}
								}
							}
					ary.set(dengji-1, 1);
					String getcdk1 = String.valueOf(ary);
//					System.out.println("getcdk1::"+getcdk1.toString());
					grd.setGetcdk(getcdk1);
					this.getGameRoleService().updateRole(grd);
					this.getCdkStoreService().Updatemploy("1", foxcdk);
					rlt.put("reward", list);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
					ServerHandler.sendData(session, respMap);
				}else{
//					System.out.println("已经领过此等级礼包");
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
					ServerHandler.sendData(session, respMap);
				}
			}else{
//				System.out.println("登录游戏10分钟后领取");
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -5);
				ServerHandler.sendData(session, respMap);
			}
			}else{
//				System.out.println("此cdk已领取过奖励");
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
				ServerHandler.sendData(session, respMap);
			}
		}else {
//			System.out.println("此CDK无效");
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);
			ServerHandler.sendData(session, respMap);
		}	
		}
	}
	
	private void cacheRoleEquip() {
		if (params.containsKey("idEquip")) {
			int id = Integer.parseInt(String.valueOf(params.get("idEquip")));
			//System.out.println("socket接到更新用户装备的请求数据id：："+id);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id", id);
			List<RoleEquipDetail> re=this.getRoleEquipService().getRoleEquiptwo(param);
			GlobalDatat.cacheRoleEquipDetails.put(re.get(0).getId(), re.get(0));
		}
		
	}

	private void cacheRoletasktask() {
		if (params.containsKey("id")&& params.containsKey("type")) {//1:删除任务   2：添加任务
		
		int id = Integer.parseInt(String.valueOf(params.get("id")));
		int type = Integer.parseInt(String.valueOf(params.get("type")));
		//System.out.println("更新模型用户任务表socket接到tomcat请求数据id:::"+id+"     type:"+type);
		if(type==1){
			GlobalDatat.cacheRoleTaskTaskDetails.get(id).setFlag(0);
		}else if(type==2){//添加任务
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id", id);
		List<RoleTaskTaskDetail> rt=this.getRoleTaskTaskService().findRoleTaskone(param);	
		Map<String, Object> detail = new HashMap<String, Object>();
		int bid = this.getAutoIdService().fingKeyValueByTableName("role_task_task");
		detail.put("id", bid);
		detail.put("roleId", rt.get(0).getRoleId());// 0,还没执行；1,已经执行
		detail.put("taskid", rt.get(0).getTaskid());
		detail.put("taskoldid", rt.get(0).getTaskoldid());
		detail.put("type", rt.get(0).getType());
		detail.put("tasktype", rt.get(0).getTasktype());
		detail.put("tasknum", rt.get(0).getTasknum());
		detail.put("tasklevel",rt.get(0).getTasklevel());
		detail.put("flag", rt.get(0).getFlag());
		detail.put("states", 0);
		detail.put("progress", 0);
		boolean boo = this.getRoleTaskTaskService().insertRoleTask0(detail);
		if(boo){
			
		}else{
			this.getRoleTaskTaskService().insertRoleTask0(detail);	
		}
		param=null;
//		detail.put("id", bid);
//		detail.put("roleId", roleid);// 0,还没执行；1,已经执行
//		detail.put("taskid", model.getId());
//		detail.put("taskoldid", model.getOldid());
//		detail.put("type", model.getType());
//		detail.put("tasktype", model.getTasktype());
//		detail.put("tasknum", model.getTasknum());
//		detail.put("tasklevel", model.getTasklevel());
//		detail.put("flag", model.getFlag());
//		detail.put("states", 0);
//		detail.put("progress", 0);
//		boo = this.getRoleTaskTaskService().insertRoleTask0(detail);
		}
	
	}
		
	}

	private void updateGameRoleBylevel(){
		try{
		//	System.out.println("SystemHandler_________________________updateGameRoleBylevel:params:" + params.toString());
			if(params.containsKey("bylevel") && params.containsKey("rid")){
				int rid = Integer.valueOf(String.valueOf(params.get("rid")));
				String bylevel = String.valueOf(params.get("bylevel"));
				GameRoleDetail gameRole = this.getGameRoleService().findRoleById(rid);
				if(null != gameRole){
					gameRole.setBylevel(bylevel);
				}else{
					throw new Exception("SystemHandler.updateGameRoleBylevel不存在玩家信息！");
				}
			}else{
				throw new Exception("SystemHandler.updateGameRoleBylevel参数异常！");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void udpateGameRoleCoinAndCoinspend(){
		try{
	//		System.out.println("SystemHandler_________________________udpateGameRoleCoinAndCoinspend:params:" + params.toString());
			if(params.containsKey("coinspend") && params.containsKey("rid")){
				int rid = Integer.valueOf(String.valueOf(params.get("rid")));
				int coin = 0;
				if(null != params.get("coin"))
					coin = Integer.valueOf(String.valueOf(params.get("coin")));
				int coinspend = Integer.valueOf(String.valueOf(params.get("coinspend")));
				GameRoleDetail gameRole = this.getGameRoleService().findRoleById(rid);
				if(null != gameRole){
					if(coin != 0)
						gameRole.setCoin(gameRole.getCoin() + coin);
					gameRole.setCoinspend(gameRole.getCoinspend() + coinspend);
				}else{
					throw new Exception("SystemHandler.udpateGameROleCoinAndCoinspend不存在玩家信息！");
				}
			}else{
				throw new Exception("SystemHandler.udpateGameRoleCoinAndCoinspend参数异常！");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void insertRoleItem(){
		try{
//			System.out.println("SystemHandler_________________________insertROleItem:params:" + params.toString());
			if(params.containsKey("num") && params.containsKey("rid") && params.containsKey("itemid")){
				int rid = Integer.valueOf(String.valueOf(params.get("rid")));
				long id = 0L;
				if(null != params.get("id"))
					id = Long.valueOf(String.valueOf(params.get("id")));
				int itemid = Integer.valueOf(String.valueOf(params.get("itemid")));
				int num = Integer.valueOf(String.valueOf(params.get("num")));
				int type = 5;
				if(null != params.get("type"))
					type = Integer.valueOf(String.valueOf(params.get("type")));
				List<RoleItemDetail> items = this.getRoleItemService().findRoleItemsByRoleId(rid);
				boolean b = false;
				for(int i = 0; i < items.size(); i++){
					if(items.get(i).getItemid() == itemid){
						id = items.get(i).getId();
					//	System.out.println("cunzai:ID:" + items.get(i).getId() + " itemid:" + items.get(i).getItemid());
						b = true;
						break;
					}
				}
			//	System.out.println("b:" + b);
				if(b){
					Map<String, Object> param = new HashMap<String, Object>();
					param.put("id", id);
					param.put("num", num);
					this.getRoleItemService().addRoleItemNum(param);
				}else{
					RoleItemDetail item = new RoleItemDetail();
					item.setId(id);
					item.setRoleid(rid);
					item.setNum(num);
					item.setItemid(itemid);
					item.setType(type);
					this.getRoleItemService().insertRoleItem(item);
				}
			}else{
				throw new Exception("SystemHandler.insertRoleItem参数异常！");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	private void cacheGameRolethree() {
//		System.out.println("SystemHanldelr:params:" + params.toString()+"===================================================");
		if (params.containsKey("roleid")&& params.containsKey("share")) {
			Map<String, Object> param = new HashMap<String, Object>();
			int roleid = Integer.parseInt(String.valueOf(params.get("roleid")));
			int share=Integer.parseInt(String.valueOf(params.get("share")));
			//System.out.println("share:::::::::"+share);
			param.put("roleid", roleid);
			param.put("share", share);
			this.getGameRoleService().cacheGameRolethree(param);
	      
		}
		
		if (params.containsKey("roleid")&& params.containsKey("huangzuan")) {
			Map<String, Object> param = new HashMap<String, Object>();
			int roleid = Integer.parseInt(String.valueOf(params.get("roleid")));
			int huangzuan=Integer.parseInt(String.valueOf(params.get("huangzuan")));
		//	System.out.println("share:::::::::"+share);
			param.put("roleid", roleid);
			param.put("huangzuan", huangzuan);
			this.getGameRoleService().cacheGameRolethree(param);
	      
		}
		
		if (params.containsKey("roleid")&& params.containsKey("fdshare")) {
			Map<String, Object> param = new HashMap<String, Object>();
			int roleid = Integer.parseInt(String.valueOf(params.get("roleid")));
			int fdshare=Integer.parseInt(String.valueOf(params.get("fdshare")));
		//	System.out.println("fdshare:::::::::"+fdshare);
			param.put("roleid", roleid);
			param.put("fdshare", fdshare);
			this.getGameRoleService().cacheGameRolethree(param);
		}
		
		if (params.containsKey("roleid")&& params.containsKey("flaunt")) {
			Map<String, Object> param = new HashMap<String, Object>();
			int roleid = Integer.parseInt(String.valueOf(params.get("roleid")));
			int flaunt=Integer.parseInt(String.valueOf(params.get("flaunt")));
		//	System.out.println("flaunt:::::::::"+flaunt);
			param.put("roleid", roleid);
			param.put("flaunt", flaunt);
			this.getGameRoleService().cacheGameRolethree(param);
		}
		
		if (params.containsKey("roleid")&& params.containsKey("sharedemo")) {
			Map<String, Object> param = new HashMap<String, Object>();
			int roleid = Integer.parseInt(String.valueOf(params.get("roleid")));
			int sharedemo=Integer.parseInt(String.valueOf(params.get("sharedemo")));
		//	System.out.println("sharedemo:::::::::"+sharedemo);
			param.put("roleid", roleid);
			param.put("sharedemo", sharedemo);
			this.getGameRoleService().cacheGameRolethree(param);
		}
		
		if (params.containsKey("roleid")&& params.containsKey("challenge")) {
			Map<String, Object> param = new HashMap<String, Object>();
			int roleid = Integer.parseInt(String.valueOf(params.get("roleid")));
			int challenge=Integer.parseInt(String.valueOf(params.get("challenge")));
			//System.out.println("challenge:::::::::"+challenge);
			param.put("roleid", roleid);
			param.put("challenge", challenge);
			this.getGameRoleService().cacheGameRolethree(param);
		}
		
		if (params.containsKey("roleid")&& params.containsKey("oldfriend")) {
			Map<String, Object> param = new HashMap<String, Object>();
			int roleid = Integer.parseInt(String.valueOf(params.get("roleid")));
			int oldfriend=Integer.parseInt(String.valueOf(params.get("oldfriend")));
			//System.out.println("oldfriend:::::::::"+oldfriend);
            param.put("roleid", roleid);
			param.put("oldfriend", oldfriend);
			this.getGameRoleService().cacheGameRolethree(param);
		}
		
		if (params.containsKey("roleid")&& params.containsKey("huangzuaninfo")) {
			JsonSerializer json1 = new JsonSerializer();
			Map<String, Object> param = new HashMap<String, Object>();
			int roleid = Integer.parseInt(String.valueOf(params.get("roleid")));
			String huangzuaninfo=String.valueOf(params.get("huangzuaninfo"));
			//System.out.println("SystemHandler.GameRoleThreee:huangzuaninfo:"+huangzuaninfo);
			//GameConstants.log.warn("SystemHandler.GameRoleThreee:huangzuaninfo:"+huangzuaninfo);
			List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json1.deserialize(huangzuaninfo);
			String name = String.valueOf(roleinfo.get(0).get("nickname"));
			String name2 = checkStr(name);
			roleinfo.get(0).put("nickname", name2);
			huangzuaninfo = (String) json1.serialize(roleinfo);
			//huangzuaninfo = checkStr(huangzuaninfo);
			//System.out.println("SystemHandler.GameRoleThreee:huangzuaninfo:"+huangzuaninfo);
			//GameConstants.log.warn("SystemHandler.GameRoleThreee:huangzuaninfo:"+huangzuaninfo);
			param.put("roleid", roleid);
			param.put("huangzuaninfo", huangzuaninfo);
			this.getGameRoleService().cacheGameRolethree(param);
		}
		
		if (params.containsKey("roleid")&& params.containsKey("name")) {
			Map<String, Object> param = new HashMap<String, Object>();
			int roleid = Integer.parseInt(String.valueOf(params.get("roleid")));
			String name=String.valueOf(params.get("name"));
			//System.out.println("SystemHandler.GameRoleThree.name:" + name);
			String name2 = checkStr(name);
			//System.out.println("SystemHandler.GameRoleThree.name2:" + name2);
			param.put("roleid", roleid);
			param.put("name", name2);
			this.getGameRoleService().cacheGameRolethree(param);
		}
		
		if (params.containsKey("roleid")&& params.containsKey("invite")&& params.containsKey("ids")) {
			//invite=数据表里invite+invite
			Map<String, Object> param = new HashMap<String, Object>();
			int roleid = Integer.parseInt(String.valueOf(params.get("roleid")));
			String ids=String.valueOf(params.get("ids"));
			//System.out.println("invite:::::::::"+1+":::::ids:::"+ids);
			int invite=1;
			param.put("roleid", roleid);
			param.put("ids", ids);
			param.put("invite", 1);
			this.getGameRoleService().cacheGameRolethree(param);
		}
		
		if (params.containsKey("roleid")&& params.containsKey("idsold")) {
			Map<String, Object> param = new HashMap<String, Object>();
			int roleid = Integer.parseInt(String.valueOf(params.get("roleid")));
			String idsold=String.valueOf(params.get("idsold"));
			//System.out.println("idsold:::::::::"+idsold);
			param.put("roleid", roleid);
			param.put("idsold", idsold);
			this.getGameRoleService().cacheGameRolethree(param);
		}
		
		if (params.containsKey("roleid")&& params.containsKey("coin")) {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> rlt = new HashMap<String, Object>();
			int roleid = Integer.parseInt(String.valueOf(params.get("roleid")));
			int coin=Integer.valueOf(String.valueOf(params.get("coin")));
			//System.out.println("SystemHandler.GameRoleThree.name:" + name);
			//System.out.println("SystemHandler.GameRoleThree.name2:" + name2);
			GameRoleDetail grd = this.getGameRoleService().findRoleById(roleid);
			int coin1 = grd.getCoin()+coin;
			param.put("roleid", roleid);
			param.put("coin", coin1);
			this.getGameRoleService().cacheGameRolethree(param);
			rlt.put("coin", coin1);
			this.getsystemHandler().pacMes3(rlt, roleid);
			rlt = null ;
			int coinspend = grd.getCoinspend()+Integer.valueOf(coin);
			int vip = 0;
			if(coinspend>=88&&coinspend<386){vip = 1;}
			if(coinspend>=386&&coinspend<880){vip = 2;}
			if(coinspend>=880&&coinspend<1680){vip = 3;}
			if(coinspend>=1680&&coinspend<2880){vip = 4;}
			if(coinspend>=2880&&coinspend<6880){vip = 5;}
			if(coinspend>=6880&&coinspend<12880){vip = 6;}
			if(coinspend>=12880&&coinspend<26800){vip = 7;}
			if(coinspend>=26800&&coinspend<58800){vip = 8;}
			if(coinspend>=58800&&coinspend<98800){vip = 9;}
			if(coinspend>=98800){vip = 10;}
			param.clear();
			param.put("roleid", roleid);
			param.put("coinspend", coinspend);
			this.getGameRoleService().cacheGameRolethree(param);
			param.clear();
			param.put("roleid", roleid);
			param.put("vip", vip);
			this.getGameRoleService().cacheGameRolethree(param);
		}
		
		
	}
	
	public static String checkStr(String str){
		String s = null;
		char[] cc = str.toCharArray();
		for(int i = 0; i < cc.length; i++){
			boolean b = isValidChar(cc[i]);
			if(!b)
				cc[i] = ' ';
		}
		s = String.valueOf(cc);
		return s;
	}

	private static boolean isValidChar(char ch) {
	    if ((ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z')|| (ch >= 'a' && ch <= 'z'))
	        return true;
	    if ((ch >= 0x4e00 && ch <= 0x7fff) || (ch >= 0x8000 && ch <= 0x952f))
	        return true;// 简体中文汉字编码
	    return false;
	}

	private void compensategift() {//领取补偿礼包

				int roleId = Integer.parseInt(playerId);
				int id = 16;
				Map<String,Object> param = new HashMap<String,Object>();
				Map<String,Object> rlt = new HashMap<String,Object>();
				param.put("id", id);
				List<ActivityDetail> activity = this.getActivityService().getActivityByParams(param);
				if(activity.isEmpty()){//活动已下架
					//System.out.println("::1:::::::::::::::::::::::::::::::::::::");
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
					ServerHandler.sendData(session, respMap);
					return;
				}
				Calendar calendar = Calendar.getInstance();
				int month0 = calendar.get(Calendar.MONTH) + 1;
				int day0 = calendar.get(Calendar.DAY_OF_MONTH);
				int month = activity.get(0).getMonth();
				int day = activity.get(0).getDay();
				int monthend = activity.get(0).getMonthend();
				int dayend = activity.get(0).getDayend();
	            int type = activity.get(0).getType();
				if(month==month0 && month0==monthend){
					if(day0>=day && day0<=dayend){
						
					}else{//结束了
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
						ServerHandler.sendData(session, respMap);
						return;
					}
				}else if(month0>=month && month0<monthend){
					//不用判断day
				}else if(month0>=month && month0<=monthend){
					if(day0<=dayend){
				
					}else{
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
						ServerHandler.sendData(session, respMap);
						return;
					}
				}else{
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
					ServerHandler.sendData(session, respMap);
					return;
				}
				//领取奖励
				GameRoleDetail gameRole = this.getGameRoleService().findRoleById(roleId);
				if(gameRole==null){
					return;
				}
				String buyitem=gameRole.getCompensate();
				JSONArray ary = JSONArray.fromObject(buyitem);
				if(ary.getInt(4)==1){//不可以领取
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);
					ServerHandler.sendData(session, respMap);
					return;
				}
				ary.set(4, 1);
				
				
				//可以领取了
				List<Map> reward = JSONArray.fromObject(JSONArray.fromObject(activity.get(0).getReward()).get(0));
				int s = reward.size();
				int itemid2 = 0;
				int resType2 = 0;
				int num2 = 0;
				int type2 = 0;
				boolean bo = false;
				for(int i=0;i<s;i++){
					itemid2 = Integer.parseInt(String.valueOf(reward.get(i).get("id")));
					resType2 = Integer.parseInt(String.valueOf(reward.get(i).get("resType")));
					num2 = Integer.parseInt(String.valueOf(reward.get(i).get("num")));
					type2 = Integer.parseInt(String.valueOf(reward.get(i).get("type")));
					bo = this.getplayerHandler().getShangxian(type2, resType2, roleId, itemid2, num2);
					if(bo==false){//背包个字不足
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);
						ServerHandler.sendData(session, respMap);
						return;
					}
				}
				JSONArray list = new JSONArray();
				for(int i=0;i<s;i++){
					itemid2 = Integer.parseInt(String.valueOf(reward.get(i).get("id")));
					resType2 = Integer.parseInt(String.valueOf(reward.get(i).get("resType")));
					num2 = Integer.parseInt(String.valueOf(reward.get(i).get("num")));
					this.getplayerHandler().getItem(roleId, itemid2, num2, resType2, list);
				}
				//标记已领取
				
				param.clear();
				param.put("id", roleId);
				//param.put("buyitem", ary.toString());
				param.put("compensate", ary.toString());
				this.getGameRoleService().updatebuyitem(param);
				rlt.put("reward", list);
				rlt.put("id", id);
				ary=null;
				list=null;
				reward=null;
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
				ServerHandler.sendData(session, respMap);
				activity=null;
				
				
				gameRole=null;
				
				param=null;
		
		
	}

	public void opencompensate(){//打开补偿活动

		int roleid = Integer.parseInt(playerId);
		int id =16;
		Map<String,Object> param = new HashMap<String,Object>();
		Map<String,Object> rlt = new HashMap<String,Object>();
		param.put("id", id);
		List<ActivityDetail> activity = this.getActivityService().getActivityByParams(param);
		if(activity.isEmpty()){//活动已下架
			//System.out.println("活动下架！");
			//System.out.println("::1:::::::::::::::::::::::::::::::::::::");
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
			ServerHandler.sendData(session, respMap);
			return;
		}
		Calendar calendar = Calendar.getInstance();
		int month0 = calendar.get(Calendar.MONTH) + 1;
		int day0 = calendar.get(Calendar.DAY_OF_MONTH);
		int month = activity.get(0).getMonth();
		int day = activity.get(0).getDay();   
		int monthend = activity.get(0).getMonthend();
		int dayend = activity.get(0).getDayend();
		if(month==month0 && month0==monthend){
			if(day0>=day && day0<=dayend){
				
			}else{//结束了
				//System.out.println("结束了");
				//System.out.println("::2:::::::::::::::::::::::::::::::::::::");
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
				ServerHandler.sendData(session, respMap);
				return;
			}
		}else if(month0>=month && month0<=monthend){
			//不用判断day
		}else{
			//System.out.println("::3:::::::::::::::::::::::::::::::::::::");
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
			ServerHandler.sendData(session, respMap);
			return;
		}
		GameRoleDetail gameRole = this.getGameRoleService().findRoleById(roleid);
		String buyitem=gameRole.getCompensate();
		JSONArray ary = JSONArray.fromObject(buyitem);
//		if(ary.getInt(4)==1){//1不可领取
//			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
//			ServerHandler.sendData(session, respMap);
//			return;
//		}
		 
		rlt.put("statu", ary.getInt(4));
		rlt.put("tipurl", activity.get(0).getTipurl());
		rlt.put("desc", activity.get(0).getDescription());
		
		rlt.put("conditions", JSONArray.fromObject(activity.get(0).getConditions()));
		rlt.put("reward", JSONArray.fromObject(activity.get(0).getReward()));
		StringBuffer sb = new StringBuffer();
		sb.append(calendar.get(Calendar.YEAR)).append(".").append(month).append(".").append(day);
		sb.append("--");
		//sb.append(calendar.get(Calendar.YEAR)).append(".").append(monthend).append(".").append(dayend-3);
		sb.append(calendar.get(Calendar.YEAR)).append(".").append(monthend).append(".").append(dayend);
		rlt.put("time", sb.toString());
		rlt.put("id", id);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
		ServerHandler.sendData(session, respMap);
		sb=null;
		rlt=null;
		param=null;
		activity=null;
	
	}
	
	private void buyhoudongitem() {

		
//		System.out.println("buygoods");
     	if(params.containsKey("id")){
			int itemId = Integer.parseInt(String.valueOf(params.get("id")));
			int num = 1;
			int roleid = Integer.parseInt(playerId);
			Map<String, Object> rlt = new HashMap<String, Object>();
			Map<String, Object> param = new HashMap<String, Object>();
			List<GameItemDetail> gameItem = this.getGameItemService().getGameItemById(itemId);
			
			if(gameItem.isEmpty()){
				if(itemId>=10000){
					
				}else{
					//该道具不存在
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
					ServerHandler.sendData(session, respMap);
					return;
				}
				
			}
			//int type = gameItem.get(0).getItemtype();//道具类型
			//int resType = 5;
			//param.put("resType", resType);
			param.put("resId", itemId);
			param.put("costType", 2);
			List<GamePriceDetail> gamePrice = this.getGamePriceService().getGamePrice(param);
			if(gamePrice.isEmpty()){//道具不存在
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
				ServerHandler.sendData(session, respMap);
				return;
			}
			/****/
			
			int price=0;
			int onsale=0;
				price = gamePrice.get(0).getResCost();//消费一个时元宝
				onsale=gamePrice.get(0).getOnsale();
				int resType=gamePrice.get(0).getResType();
	//			System.out.println("resType=="+resType);
				//System.out.println("price原价====="+price+"onsale===="+onsale);
				param.clear();
				List<ShopdiscountDetail> sp=shopService.getShopdiscount(param);
				if(!sp.isEmpty()){
					Calendar calendar = Calendar.getInstance();
					int month0 = calendar.get(Calendar.MONTH) + 1;
					int day0 = calendar.get(Calendar.DAY_OF_MONTH);
					int month = sp.get(0).getMonth();
					int day = sp.get(0).getDay();
					int monthend =sp.get(0).getMonthend();
					int dayend = sp.get(0).getDayend();
					if(month0==month&&month0==monthend){
						if(day0>=day&&day0<=dayend){
							if(onsale!=0){
								price =(int) gamePrice.get(0).getResCost()*onsale/10;
								//System.out.println("=========1========");
								//System.out.println("price最终价====="+price);
							}
						}
						}else if(month0>=month&&month0<=monthend){
							if(onsale!=0){
								price = (int)gamePrice.get(0).getResCost()*onsale/10;
								//System.out.println("=========1========");
								//System.out.println("price最终价====="+price);
							}
						}
					
					//System.out.println("month"+month+"day"+day+"monthend"+monthend+"dayend"+dayend);
						
				}
				//System.out.println("price最终价====="+price);
			
		
			/****/
				int s=0;
			//int price = gamePrice.get(0).getResCost();//消费一个时元宝
			//判断元宝是否足够
			GameRoleDetail gameRole = this.getGameRoleService().findRoleById(roleid);
			if(gameRole==null){
				return;
			}
			int coin = gameRole.getCoin();
             String buyitem=gameRole.getBuyitem();
			int buy = 1;
			if(itemId==281){
				price=(int) (price*0.15);
			}
			if(itemId==282){
				price=(int) (price*0.1);
			}
			if(itemId==283){
				price=(int) (price*0.2);
			}
			
			
			 
			price = price*num;
			if(coin>=price&&price>0){//使用元宝购买
				//减少元宝
				 /***/
				JSONArray ary = JSONArray.fromObject(buyitem);
				if(itemId==281||itemId==282||itemId==283){
					if(itemId==281){//281  282  283
						ary.set(1, 1);
						itemId=13;
					}
					if(itemId==282){
						ary.set(2, 1);
						itemId=73;
					}
					if(itemId==283){
						ary.set(0, 1);
						itemId=12;
					}
					param.clear();
					param.put("id", roleid);
					param.put("buyitem", ary.toString());
				boolean a=this.getGameRoleService().updatebuyitem(param);
		//		System.out.println(a + "购买：——————————————————————————————————————————————————————————————————————");
				}
				
				/****/
				// type :子类型 resType:主类型 roleId:人物id id:物品
				/****/
				boolean b = false;
				//if(itemId==10000||itemId==130000||itemId==250000||itemId==370000||itemId==490000||itemId==610000||itemId==730000||itemId==850000){
				if(itemId>=10000){	
				b=true;
				}else{
					b = this.getplayerHandler().getShangxian(gameItem.get(0).getItemtype(), 5, roleid, itemId, num);
					
				}
				/****/
				// b = this.getplayerHandler().getShangxian(type, 5, roleid, itemId, num);
				if (b == true) {
					if (gamePrice.get(0).getCostType() == 2) {
						//减少元宝
						this.getGameRoleService().subRoleCoin(roleid, price);
						//增加道具
						Map<String, Object> items = new HashMap<String, Object>();
						if(resType == 5){
						
							
							int isover = gameItem.get(0).getIsover();
							items.put("id", itemId);
							items.put("resType", resType);
							items.put("num", num);
							param.clear();
							param.put("roleid", roleid);
							param.put("itemid", itemId);
							List<RoleItemDetail> item = this.getRoleItemService().getRoleItem(param);

							if (item.isEmpty() || isover == 0) {// 添加
								//int bid = this.getAutoIdService().fingKeyValueByTableName("role_item") + 1;
								long bid = this.getAutoIdService().fingKeyValueByTableName("role_item");
								
								RoleItemDetail iDetail = new RoleItemDetail();
								iDetail.setId(bid);
								iDetail.setRoleid(roleid);
								iDetail.setItemid(itemId);
								iDetail.setNum(num);
								iDetail.setFlag(1);
								iDetail.setType(gameItem.get(0).getItemtype());
//TODO								iDetail.setActivitynum(num);
								this.getRoleItemService().insertRoleItem(
										iDetail);
//								this.getAutoIdService()
//										.updateKeyValueAddOneByTableName(
//												"role_item");
								items.put("bid", bid);

							} else {// 不添加
								param.clear();
								param.put("roleid", roleid);
								param.put("itemid", itemId);
								param.put("num", num);
								this.getRoleItemService().addRoleItemNum(param);
								items.put("bid", item.get(0).getId());
							}
							rlt.put("reward", items);
						}
						/****/
						
						else if(resType==10){//图腾
							s=1;
							//查看玩家是否有这个图腾，有就更新，没有就插入
							param.clear();
							param.put("roleid", roleid);
							param.put("totemid", itemId/10000);
							List<RoletotemDetail> to=this.getRoletotemService().getRoletotem(param);
							if(to.isEmpty()){//第一次购买，插入
								List<GametotemDetail> gt=this.getGametotemService().getGametotembyid(itemId/10000);
								RoletotemDetail mo = new RoletotemDetail();
								mo.setRoleid(roleid);
								mo.setType(gt.get(0).getType());
								mo.setLevel(gt.get(0).getLevel());
								mo.setNum(num);
								mo.setQuality(gt.get(0).getQuality());
								mo.setTotemid(gt.get(0).getId());
								boolean c=this.getRoletotemService().insertRoletotem(mo);
							}else{//更新
								List<GametotemDetail> gt=this.getGametotemService().getGametotembyid(itemId/10000);
								   param.clear();
								   param.put("roleid", roleid);
								   param.put("type",gt.get(0).getType() );
								   param.put("level", gt.get(0).getLevel());
								   param.put("num", num);
								   this.getRoletotemService().addRoletotemNum(param);	
							}
							
						}
						/****/
						items=null;
					}
				} else {
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							-1);// 背包上限
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
							"");
					ServerHandler.sendData(session, respMap);
					return;
				}
				rlt.put("coin", coin-price);
				rlt.put("coinspend", gameRole.getCoinspend());
				// 判断是否有任务，及是否完成
				param.clear();
				param.put("roleid", roleid);
				param.put("type", 4);
				List<RoleTaskTaskDetail> listW = this.getRoleTaskTaskService()
						.findRoleTaskBytype0(param);
				for(int i=0;i<listW.size();i++){
					if (listW.get(i).getTasklevel() == itemId) {
						param.clear();
						param.put("roleid", roleid);
						param.put("taskid", listW.get(i)
								.getTaskid());
						param.put("progress", 1);
						this.getRoleTaskTaskService().updateRoleTaskProgress(param);
						// 判断是否有任务完成3
						this.getTaskHandler().taskcomplete(roleid);
					}
				}
				listW=null;
				//记录购买数据
				param.clear();
				param.put("roleid", roleid);
				param.put("num", num);
				param.put("coin", price);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String time = sdf.format(new Date());
				param.put("time", time);
				this.getCoinService().insertCoin(param);
				
				//活动记录购买数量
				param.clear();
				param.put("type", 1);
				List<ActivityDetail> activity = this.getActivityService().getActivityByParams(param);
				if(!activity.isEmpty()){
					Calendar calendar = Calendar.getInstance();
					int month0 = calendar.get(Calendar.MONTH) + 1;
					int day0 = calendar.get(Calendar.DAY_OF_MONTH);
					int month = activity.get(0).getMonth();
					int day = activity.get(0).getDay();
					int monthend = activity.get(0).getMonthend();
					int dayend = activity.get(0).getDayend();
					int status = 0;
					if(month==month0 && month0==monthend){
						if(day0>=day && day0<=dayend){
							status = 1;
						}
					}else if(month0>=month && month0<monthend){
						//不用判断day
						status = 1;
					}
					
					if(status==1){//记录数量
						param.clear();
						param.put("roleid", roleid);
						param.put("itemid", itemId);
						List<RoleItemDetail> item = this.getRoleItemService().getRoleItem(param);
						if(item.get(0).getIsnew()!=activity.get(0).getIsnew()){
							param.clear();
							param.put("isnew", activity.get(0).getIsnew());
							param.put("roleid", roleid);
							param.put("itemid", itemId);
							param.put("activitynum", num);
							this.getRoleItemService().updateRoleItemByParams(param);
						}else{//增加
							param.clear();
							param.put("roleid", roleid);
							param.put("itemid", itemId);
							param.put("activitynum", item.get(0).getActivitynum()+num);
							this.getRoleItemService().updateRoleItemByParams(param);
						}
						item=null;
					}
				}
				activity=null;
			}else{//元宝不足
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
				ServerHandler.sendData(session, respMap);
				return;
			}

			
			rlt.put("yin", gameRole.getYin());
			rlt.put("buy", buy);
			rlt.put("id", itemId);
			rlt.put("s", s);//1是图腾
			//rlt.put("t", 1);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
					rlt);
			ServerHandler.sendData(session, respMap);
			param=null;
			rlt=null;
			gamePrice=null;
			gameRole =null;
			gameItem=null;
		}
		
		
	}

	
	

	private void cacheRoletotem() {
//		if (params.containsKey("roleid")) {
//		// 更新roleTotem表
//		int roleid = Integer.parseInt(String.valueOf(params.get("roleid")));
//		System.out.println("更新Roletotem表socket接到tomcat请求roleid:::"+roleid);
//		Map<String, Object> param = new HashMap<String, Object>();
//		param.put("roleid", roleid);
//		List<RoletotemDetail> rt=this.roletotemService.getRoletotemtwo(param);
//		System.out.println(rt.size()+"rt.size()");
//		GlobalDatat.cacheRoletotemDetails.put(rt.get(0).getId(), rt.get(0));
//		}
		
		
		
		//图腾
		if (params.containsKey("roleid")&&params.containsKey("itemid")&&params.containsKey("num")&&params.containsKey("coin")) {
	//		System.out.println("SystemHandler.tuuteng__________________________params:" + params.toString());
		//查看玩家是否有这个图腾，有就更新，没有就插入
			Map<String, Object> param = new HashMap<String, Object>();
			int roleid = Integer.parseInt(String.valueOf(params.get("roleid")));
			int itemId=Integer.parseInt(String.valueOf(params.get("itemid")));
			int num=Integer.parseInt(String.valueOf(params.get("num")));
			int coin=Integer.parseInt(String.valueOf(params.get("coin")));
			
			/****/
			String payitem=itemId+"*"+coin+"*"+num;
			List<MemberDetail> member = this.getMemberService().findMemberByid(roleid);
			String openid="";
			String serverid = "";
		//	System.out.println("!member.isEmpty():" + !member.isEmpty());
			if(!member.isEmpty()){
				openid = member.get(0).getUsername();
				serverid = member.get(0).getServerId();
				param.clear();
				param.put("openid", openid);
				param.put("serverid", serverid);
			//	System.out.println("param:" + param.toString());
				List<DeliveryDetail> delivery = this.getDeliveryService().findeDeliveryByList(param);
			//	System.out.println("delivery:" + delivery.size());
//				List<DeliveryDetail> delivery = this.getDeliveryService().findDeliveryByopenid(openid);
				if(!delivery.isEmpty()){
					if(delivery.get(0).getStatus()==0){
						//System.out.println("非法购买图腾！！");
						GameConstants.log.info("illagal trade！！roleid:" + roleid);
						return;//非法购买
					}
					payitem = delivery.get(0).getPayitem();
				}
			}
			/****/
			
			
			param.clear();
		param.put("roleid", roleid);
		param.put("totemid", itemId/10000);
		List<RoletotemDetail> to=this.getRoletotemService().getRoletotem(param);
		if(to.isEmpty()){//第一次购买，插入
			List<GametotemDetail> gt=this.getGametotemService().getGametotembyid(itemId/10000);
			RoletotemDetail mo = new RoletotemDetail();
			mo.setRoleid(roleid);
			mo.setType(gt.get(0).getType());
			mo.setLevel(gt.get(0).getLevel());
			mo.setNum(num);
			mo.setQuality(gt.get(0).getQuality());
			mo.setTotemid(gt.get(0).getId());
			boolean c=this.getRoletotemService().insertRoletotem(mo);
//							System.out.println("插入图腾========"+c);
		}else{//更新
			List<GametotemDetail> gt=this.getGametotemService().getGametotembyid(itemId/10000);
			   param.clear();
			   param.put("roleid", roleid);
			   param.put("type",gt.get(0).getType() );
			   param.put("level", gt.get(0).getLevel());
			   param.put("num", num);
			   this.getRoletotemService().addRoletotemNum(param);	
//							   System.out.println("更新图腾========");
		}
		//更新token
		param.clear();
		param.put("openid", openid);
		param.put("status", 0);
		this.getDeliveryService().updateDelivery(param);
		
		/****/
		int daycoin = coin * num;//记录每日消费q点
		param.clear();
		param.put("id", roleid);
		param.put("daycoin", daycoin);
		this.getGameRoleService().updateRoleVip(param);

		Map<String, Object> paramc = new HashMap<String, Object>();
		paramc.put("id", roleid);
		paramc.put("coinspend", coin);
		boolean boo = this.getGameRoleService()
				.addRolecoinspend(paramc);
		if (boo == true) {
			
			// 获取人物VIP等级
			int vip = this.getGameRoleService()
					.findRoleById(roleid).getVip();
			// 消费的总金币
			int coinspendz = this.getGameRoleService()
					.findRoleById(roleid)
					.getCoinspend();
			// 跟模型表里面进行比较看看能到达哪个等级
			int Nvip = this.getGameVipService()
					.getGameVipByAllvipRmb(coinspendz)
					.get(0).getVipLevel();
		int cha=this.getGameVipService().getGameVipByLe(Nvip).get(0).getVipRmb()-coinspendz;
		//rlt.put("cha", cha);
			if (Nvip > vip) {
				// 更改用户的vip等级
				Map<String, Object> paramv = new HashMap<String, Object>();
				paramv.put("id", roleid);
				paramv.put("vip", Nvip);
				this.getGameRoleService()
						.updateRoleVip(paramv);
				// 给前端发送数据
				Map<String, Object> rlt1 = new HashMap<String, Object>();
				rlt1.put("vip", Nvip);
				Map<String, Object> res = new HashMap<String, Object>();
				res.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								GameConstants.GAME_API_SUCCESS);
				res.put(GameConstants.GAME_API_RESPONSE_FIELD_ACTPID,
						roleid);
				res.put(GameConstants.GAME_API_RESPONSE_FIELD_CMD,
								"sys.viplevelup");
				res.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
								rlt1);
				ServerHandler.sendDataByRoleId(res,
						roleid);
				res.clear();
				rlt1.clear();
				// 系统公告//发送广播
				GameRoleDetail role = this.getGameRoleService().findRoleById(roleid);
				String message= "玩家 <font color=\"#FF0000\">" + role.getName() + "</font>的VIP等级提升到了 <font color=\"#FFFF00\"><b>" + role.getVip() + "</b></font>";
				GameConstants.log.warn("Military.buyItems:" + message);
				this.getsystemHandler().addMessage(message);
				
				rlt1.put("vip", Nvip);
				rlt1.put("info", "购买");
				rlt1.put("place",1);
				//添加黄钻信息
				JsonSerializer json = new JsonSerializer();
				String Huangzuaninfo = this.getGameRoleService().findRoleById(roleid).getHuangzuaninfo();
				if("null".equals(String.valueOf(Huangzuaninfo))){
//					rlt1.put("rname", "");
					rlt1.put("isyellowvip", 0);
					rlt1.put("yellowviplevel", 0);
					rlt1.put("isyellowyearsvip", 0);
				}else{
					List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
					.deserialize(Huangzuaninfo);
					int ret = Integer.parseInt(String.valueOf(roleinfo.get(0).get("ret")));
					if(ret==0){
//						rlt1.put("rname", this.getGameRoleService().findRoleById(roleId).getName());
						rlt1.put("isyellowvip", roleinfo.get(0).get("is_yellow_vip"));
						rlt1.put("yellowviplevel", roleinfo.get(0).get("yellow_vip_level"));
						rlt1.put("isyellowyearsvip", roleinfo.get(0).get("is_yellow_year_vip"));
					}else{
//						rlt1.put("rname", "");
						rlt1.put("isyellowvip", 0);
						rlt1.put("yellowviplevel", 0);
						rlt1.put("isyellowyearsvip", 0);
					}
				}
				rlt1.put("rname", this.getGameRoleService().findRoleById(roleid).getName());
				res.put("roleline", 1);
				List<GameRoleDetail> status = this.getGameRoleService().getRoleByLevel(res);
				if(status.isEmpty()){
					return;
				}
//				for (int i = 0; i < status.size(); i++) {
//					res.clear();
//					res.put(
//							GameConstants.GAME_API_RESPONSE_FIELD_CODE,
//							GameConstants.GAME_API_SUCCESS);
//					res.put(
//							GameConstants.GAME_API_RESPONSE_FIELD_RLT,
//							rlt1);
//					res.put(
//							GameConstants.GAME_API_RESPONSE_FIELD_CMD,
//							"sys.send");
//					System.out.println("啦啦啦");
////					ServerHandler.sendDataByRoleId(res, status.get(i).getId());
//				}
				
			}

		}
	
		// 判断是否有任务，及是否完成
		Map<String, Object> paramW = new HashMap<String, Object>();
		paramW.put("roleid", roleid);
		paramW.put("type", 4);
		List<RoleTaskTaskDetail> listW = this.getRoleTaskTaskService()
				.findRoleTaskBytype0(paramW);
		for(int i=0;i<listW.size();i++){
			if (listW.get(i).getTasklevel() == itemId) {
				Map<String, Object> paramI = new HashMap<String, Object>();
				paramI.put("roleid", roleid);
				paramI.put("taskid", listW.get(i).getTaskid());
				paramI.put("progress", 1);
				this.getRoleTaskTaskService().updateRoleTaskProgress(paramI);
				// 判断是否有任务完成3
				this.getTaskHandler().taskcomplete(roleid);
			}
		}
		listW=null;
		/****/
		
		}
	}
	
	
	private void cacheGameRole() {//更新gameRole表
		if (params.containsKey("roleid")) {
			
			int roleid = Integer.parseInt(String.valueOf(params.get("roleid")));
		//	System.out.println("更新模型用户表socket接到tomcat请求roleid:::"+roleid);
			GameRoleDetail gameRole = this.getGameRoleService().cachefindRoleById(roleid);
			GlobalDatat.cacheGameRoleDetails.put(roleid, gameRole); 
		}
		
		
	}
	private void cacheGameRoletwo() {//更新gameRole表
		if (params.containsKey("roleid")&& params.containsKey("ary")) {
			
		//	System.out.println("SysttemHandler.CacheGameROletow_____________________________roleid:" + Integer.parseInt(String.valueOf(params.get("roleid"))) + " ary:" + String.valueOf(params.get("ary")));
			Map<String, Object> param = new HashMap<String, Object>();
			int roleid = Integer.parseInt(String.valueOf(params.get("roleid")));	
	        String ary=String.valueOf(params.get("ary"));
	        param.put("id", roleid);
			param.put("buyitem", ary);
			this.getGameRoleService().updatebuyitem(param);
		}
		
		
	}

	private void cacheMember(){
//		try{
//			if(params.containsKey("name") && params.containsKey("serverid")){
//		//		System.out.println("SystemHandler.cacheMember_________________________________:params:" + params.toString());
//				MemberDetail model = new MemberDetail();
//				model.setUsername(String.valueOf(params.get("name")));
//				model.setServerId(String.valueOf(params.get("serverid")));
//				model.setId(Integer.valueOf(String.valueOf(params.get("id"))));
//				this.getMemberService().insertMember(model);
//			}else{
//				throw new Exception("同步数据库Ｍｅｍｂｅｒ表参数不完整：ｐａｒａｍｓ：" + params.toString());
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
	}
	
	private void cacheRoleItem(){//1：插入玩家道具       2：更新玩家道具
		if (params.containsKey("roleid")&&params.containsKey("itemid")) {
			 JSONArray list = new JSONArray();
		int num=1;
		int type=5;
		int roleid = Integer.parseInt(String.valueOf(params.get("roleid")));
		int itemid = Integer.parseInt(String.valueOf(params.get("itemid")));
	//	System.out.println("roleid::::"+roleid+"itemid:::::"+itemid);
		this.getplayerHandler().getItem(roleid, itemid, 1, 5, list);
		}
	}
	
	private void message() {
		long a=System.currentTimeMillis();
		//System.out.println("发送广播开始：：：：：：：");
		if (params.containsKey("mess")&&params.containsKey("url")) {
			String message = String.valueOf(params.get("mess"));
			String url = String.valueOf(params.get("url"));
			Map<String, Object> rlt = new HashMap<String, Object>();
			Map<String, Object> res = new HashMap<String, Object>();
			rlt.put("mess",message );
			rlt.put("url", url);
			//res.put("roleline", 1);
//			List<GameRoleDetail> status = this.getGameRoleService().getRoleByLevel(res);
//			if(status.isEmpty()){
//				return;
//			}
//			for (int i = 0; i < status.size(); i++) {
//				res.clear();
//				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
//				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
//				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CMD,"sys.message");
//				ServerHandler.sendDataByRoleId(respMap, (int)status.get(i).getId());
//			}
			res.clear();
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CMD,"sys.message");
			ServerHandler.sendDataToAll(respMap);
			rlt=null;
			res=null;
		}
		long b=System.currentTimeMillis();
	//	System.out.println("发送广播信息结束：：：：：：：：：用时：："+(b-a));
	}
	
	private void getreward() {
	//	System.out.println("到了getreward()");
		if(params.containsKey("id")&&params.containsKey("t")){
			int roleId = Integer.parseInt(playerId);
			int id = Integer.parseInt(String.valueOf(params.get("id")));
			int t = Integer.parseInt(String.valueOf(params.get("t")));//1234
			Map<String,Object> param = new HashMap<String,Object>();
			Map<String,Object> rlt = new HashMap<String,Object>();
			param.put("id", id);
			List<ActivityDetail> activity = this.getActivityService().getActivityByParams(param);
			if(activity.isEmpty()){//活动已下架
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
				ServerHandler.sendData(session, respMap);
				return;
			}
			Calendar calendar = Calendar.getInstance();
			int month0 = calendar.get(Calendar.MONTH) + 1;
			int day0 = calendar.get(Calendar.DAY_OF_MONTH);
			int month = activity.get(0).getMonth();
			int day = activity.get(0).getDay();
			int monthend = activity.get(0).getMonthend();
			int dayend = activity.get(0).getDayend()+3;
            int type = activity.get(0).getType();
			if(month==month0 && month0==monthend){
				if(day0>=day && day0<=dayend){
					
				}else{//结束了
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
					ServerHandler.sendData(session, respMap);
					return;
				}
			}else if(month0>=month && month0<monthend){
				//不用判断day
			}else if(month0>=month && month0<=monthend){
				if(day0<=dayend){
			
				}else{
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
					ServerHandler.sendData(session, respMap);
					return;
				}
			}else{
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
				ServerHandler.sendData(session, respMap);
				return;
			}
			//领取奖励
			GameRoleDetail gameRole = this.getGameRoleService().findRoleById(roleId);
			if(gameRole==null){
				return;
			}
			 /****/
			if(type==5){//领取开新服活动奖励
				JsonSerializer json=new JsonSerializer();
				String activitygift=gameRole.getActivitygift();
		    	List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
				.deserialize(activitygift);
		    	if(roleinfo.size()==0||roleinfo.isEmpty()){
		    	//	System.out.println("新玩家开新服活动没有插入：：：：：");
		    		Map<String, Object> ma=new HashMap<String, Object>();
		    		ma.put("one", 0);
		    		ma.put("two", 0);
		    		ma.put("three", 0);
		    		ma.put("four", 0);
		    		roleinfo.add(ma);
		    	}
              
		    	Map<String, Object> map = new HashMap<String, Object>();
                JSONArray js=new JSONArray();
                JSONArray list = new JSONArray();
                int one=0;
                int two=0;
                int three=0;
                int four=0;
		    	one=Integer.parseInt(String.valueOf(roleinfo.get(0).get("one")));
		        two=Integer.parseInt(String.valueOf(roleinfo.get(0).get("two")));
		        three=Integer.parseInt(String.valueOf(roleinfo.get(0).get("three")));
		        four=Integer.parseInt(String.valueOf(roleinfo.get(0).get("four")));
		        MapHandler maphandler=new MapHandler();
				if(t==1){//领取第一重奖励
					if(one!=1){//可以领取
						
						/****/
					  Boolean bo = this.getplayerHandler().getShangxian(5, 5, roleId, 20, 2);
					  Boolean bo1= this.getplayerHandler().getShangxian(5, 5, roleId, 4, 5);
					  Boolean bo2=this.getplayerHandler().getShangxian(6, 6, roleId, 79, 1);
					  Boolean bo3= this.getplayerHandler().getShangxian(6, 6, roleId, 80, 1);
						
					  if(bo==false||bo1==false||bo2==false||bo3==false){//背包个字不足
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);
							ServerHandler.sendData(session, respMap);
							return;
						}
						/****/
						//getShangxian(int type, int resType, int roleId, int id,int num)
						//getItem(int roleId,int id,int num,int type,JSONArray list)
						this.getplayerHandler().getItem(roleId, 80, 1, 6, list);
						this.getplayerHandler().getItem(roleId, 79, 1, 6, list);
						this.getplayerHandler().getItem(roleId, 4, 5, 5, list);
						this.getplayerHandler().getItem(roleId, 20, 2, 5, list);
						one=1;
					    
					}else{//已经领取过了，不可以再领取
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
						 ServerHandler.sendData(session, respMap);
						 return;
					}
				}else if(t==2){//领取第二重奖励
                         if(two!=1){//可以领取
                        	 
                        		/****/
       					  Boolean bo = this.getplayerHandler().getShangxian(5, 5, roleId, 4, 10);
       					  Boolean bo1= this.getplayerHandler().getShangxian(5, 5, roleId, 20, 4);
       					  Boolean bo2=this.getplayerHandler().getShangxian(6, 6, roleId, 74, 1);
       					  Boolean bo3= this.getplayerHandler().getShangxian(6, 6, roleId, 75, 1);
       						
       					  if(bo==false||bo1==false||bo2==false||bo3==false){//背包个字不足
       							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);
       							ServerHandler.sendData(session, respMap);
       							return;
       						}
       						/****/
                        	 
                        	 this.getplayerHandler().getItem(roleId, 75, 1, 6, list);
                        	 this.getplayerHandler().getItem(roleId, 74, 1, 6, list);
                        	 this.getplayerHandler().getItem(roleId, 4, 10, 5, list);
                        	 this.getplayerHandler().getItem(roleId, 20, 4, 5, list);
     						 two=1;
						 }else{//已经领取过了，不可以再领取
						  respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
						  ServerHandler.sendData(session, respMap);
						  return;
					}
				}else if(t==3){//领取第三重奖励
                      if(three!=1){//可以领取
                    	  
                    		/****/
    					  Boolean bo = this.getplayerHandler().getShangxian(5, 5, roleId, 5, 20);
    					  Boolean bo1= this.getplayerHandler().getShangxian(5, 5, roleId, 20, 10);
    					  Boolean bo2=this.getplayerHandler().getShangxian(6, 6, roleId, 90, 1);
    					  Boolean bo3= this.getplayerHandler().getShangxian(6, 6, roleId, 89, 1);
    						
    					  if(bo==false||bo1==false||bo2==false||bo3==false){//背包个字不足
    							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);
    							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "背包空间不足");
    							ServerHandler.sendData(session, respMap);
    							return;
    						}
    						/****/
                    	  
                    	  this.getplayerHandler().getItem(roleId, 5, 20, 5, list);
                    	  this.getplayerHandler().getItem(roleId, 20, 10, 5, list);
                    	  this.getplayerHandler().getItem(roleId, 90, 1, 6, list);
                    	  this.getplayerHandler().getItem(roleId, 89, 1, 6, list);
  						
						three=1;
					  }else{//已经领取过了，不可以再领取
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
						 ServerHandler.sendData(session, respMap);
						 return;
					}
				}else{//领取第四重奖励
                      if(four!=1){//可以领取
                    	  
                    		/****/
    					  Boolean bo = this.getplayerHandler().getShangxian(5, 5, roleId, 5, 30);
    					  Boolean bo1= this.getplayerHandler().getShangxian(5, 5, roleId, 20, 20);
    					  Boolean bo2=this.getplayerHandler().getShangxian(6, 6, roleId, 84, 1);
    					  Boolean bo3= this.getplayerHandler().getShangxian(6, 6, roleId, 85, 1);
    						
    					  if(bo==false||bo1==false||bo2==false||bo3==false){//背包个字不足
    							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);
    							ServerHandler.sendData(session, respMap);
    							return;
    						}
    						/****/
                    	  
                    	  this.getplayerHandler().getItem(roleId, 85, 1, 6, list);
                    	  this.getplayerHandler().getItem(roleId, 84, 1, 6, list);
                    	  this.getplayerHandler().getItem(roleId, 5, 30, 5, list);
                    	  this.getplayerHandler().getItem(roleId, 20, 20, 5, list);
  						 four=1;
					  }else{//已经领取过了，不可以再领取
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
						 ServerHandler.sendData(session, respMap);
						 return;
					   }
				}
				
				
			map.put("one", one);
			map.put("two", two);
			map.put("three", three);
			map.put("four", four);
			js.add(map);
			String giftstatu=js.toString();
			//System.out.println("领取礼物状态=giftstatu========="+giftstatu);
			map.clear();
			map.put("activitygift", giftstatu);
			map.put("id", roleId);
			this.getGameRoleService().upactivitygift(map);
				
				
				rlt.put("reward",list);
				rlt.put("id", id);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
				ServerHandler.sendData(session, respMap);
				js=null;
				list=null;
				map.clear();
				return;
				
			}
			/****/
			
			List<Map> ary = JSONArray.fromObject(gameRole.getActivitytype());
			int size = ary.size();
			String str = "9";
			int status = 0;//标记是否是第一次
			//判断是否已领取
//			for(int i=0;i<size;i++){
//				if(ary.get(i).get(""+id)!=null){
//					str = String.valueOf(ary.get(i).get(""+id));
//					status = 1;
//				}
//			}
//			//System.out.println("str:"+str+">>t:"+t);
//			if(!"9".equals(str)){
//				if(str.indexOf((t-1)+"")!=-1){//已领取
//					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-3);
//					ServerHandler.sendData(session, respMap);
//					return;
//				}
//			}
			
			if(type!=3){
				for(int i=0;i<size;i++){
					if(ary.get(i).get(""+id)!=null){
						str = String.valueOf(ary.get(i).get(""+id));
						status = 1;
					}
				}
				//System.out.println("str:"+str+">>t:"+t);
				if(!"9".equals(str)){
					if(str.indexOf((t-1)+"")!=-1){//已领取
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-3);
						ServerHandler.sendData(session, respMap);
						return;
					}
				}
			}
			
			int itemid=0;
			int num=0;
			int resType=0;
			
			
			 if(type==2){//特殊
				List list = JSONArray.fromObject(activity.get(0).getConditions());
				List<Map> list2 = JSONArray.fromObject(list.get(t-1));
				int size2 = list2.size();
				//判断是哪一种物品
				 itemid = Integer.parseInt(String.valueOf(list2.get(0).get("id")));
				 num = Integer.parseInt(String.valueOf(list2.get(0).get("num")));
				 resType = Integer.parseInt(String.valueOf(list2.get(0).get("resType")));
				// System.out.println("resType"+resType);
				 if(resType==3){//武将
					 List<RoleMilitaryDetail> rolem=null;
					 if(size2>1){
						 for(int j=0;j<size2;j++){
							 itemid = Integer.parseInt(String.valueOf(list2.get(j).get("id")));
							 rolem = this.getRoleMilitaryService().getRoleMilitarytime(itemid, roleId);
							 if(rolem.isEmpty()){
								 respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);
								 ServerHandler.sendData(session, respMap);
								 return;
							 }
						 }
					 }else{
						 rolem = this.getRoleMilitaryService().getRoleMilitarytime(itemid, roleId);
						 if(rolem.isEmpty()){
							 respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);
							 ServerHandler.sendData(session, respMap);
							 return;
						 }
					 }
					 rolem=null;
				 }else if(resType==5){
					 List<RoleItemDetail> roleItem = null;
					 if(size2>1){
						 for(int j=0;j<size2;j++){
							 itemid = Integer.parseInt(String.valueOf(list2.get(j).get("id")));
							 num = Integer.parseInt(String.valueOf(list2.get(j).get("num")));
							 param.clear();
							 param.put("roleid", roleId);
							 param.put("itemid", itemid);
							 roleItem = this.getRoleItemService().getRoleItemByitem(param);
							 if(roleItem.isEmpty()){
								 respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);
								 ServerHandler.sendData(session, respMap);
								 return;
							 }else{
								 if(roleItem.get(0).getNum()<num){
									 respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);
									 ServerHandler.sendData(session, respMap);
									 return;
								 }
							 }
							 
						 }
					 }else{
						 param.clear();
						 param.put("roleid", roleId);
						 param.put("itemid", itemid);
						 roleItem = this.getRoleItemService().getRoleItemByitem(param);
						 if(roleItem.isEmpty()){
							 respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);
							 ServerHandler.sendData(session, respMap);
							 return;
						 }
					 }
					 roleItem=null;
				 }else if(resType==6){
					 List<RoleEquipDetail> roleEquip = null;
					 if(size2>1){
						 for(int j=0;j<size2;j++){
							 itemid = Integer.parseInt(String.valueOf(list2.get(j).get("id")));
							 num = Integer.parseInt(String.valueOf(list2.get(j).get("num")));
							 param.clear();
							 param.put("equipId", itemid);
							 param.put("roleId", roleId);
							 roleEquip = this.getRoleEquipService().getRoleEquipByEquipId(param);
							 if(roleEquip.isEmpty()){
								 respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);
								 ServerHandler.sendData(session, respMap);
								 return;
							 }
						 }
						 roleEquip=null;
					 }else{
						 param.clear();
						 param.put("equipId", itemid);
						 param.put("roleId", roleId);
						 roleEquip = this.getRoleEquipService().getRoleEquipByEquipId(param);
						 if(roleEquip.isEmpty()){
							 respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);
							 ServerHandler.sendData(session, respMap);
							 return;
						 }
					 }
					 roleEquip=null;
				 }
				 list2=null;
			}else{
				List<Map> list = JSONArray.fromObject(activity.get(0).getConditions());
				if(type==1){
					param.clear();
					 param.put("roleid", roleId);
					 param.put("itemid", Integer.parseInt(String.valueOf(list.get(0).get("id"))));
					 List<RoleItemDetail> roleItem = this.getRoleItemService().getRoleItemByitem(param);
					 int itemNum =0;
					 if(!roleItem.isEmpty()){
						 if(roleItem.get(0).getIsnew()==activity.get(0).getIsnew()){
							 itemNum = roleItem.get(0).getActivitynum();
						 }
					 }else{
						 respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);
						 ServerHandler.sendData(session, respMap);
						 return;
					 }
					 if(Integer.parseInt(String.valueOf(list.get(t-1).get("num")))>itemNum){
						 respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);
						 ServerHandler.sendData(session, respMap);
						 return;
					 }
				}else if(type==3){
					int spends = gameRole.getDaycoin();
//					if(spends!=0){
//					}
					//spends = gameRole.getCoinspend() - spends;
					if(Integer.parseInt(String.valueOf(list.get(t-1).get("num")))>spends){
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);
						 ServerHandler.sendData(session, respMap);
						 return;
					}
				
				}else if(type==4){
//					int tday = (int) ((gameRole.getTasktime()-System.currentTimeMillis())/1000/60/60/24 +1);
//					List<Map> to = JSONArray.fromObject(gameRole.getToday());
//					if(Integer.parseInt(String.valueOf(to.get(0).get("day")))!=tday){
//						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);
//						 ServerHandler.sendData(session, respMap);
//						 return;
//					}
				}
				list = null;
			}
			
			
			//可以领取了
			List<Map> reward = JSONArray.fromObject(JSONArray.fromObject(activity.get(0).getReward()).get(t-1));
			int s = reward.size();
			int itemid2 = 0;
			int resType2 = 0;
			int num2 = 0;
			int type2 = 0;
			boolean bo = false;
			for(int i=0;i<s;i++){
				itemid2 = Integer.parseInt(String.valueOf(reward.get(i).get("id")));
				resType2 = Integer.parseInt(String.valueOf(reward.get(i).get("resType")));
				num2 = Integer.parseInt(String.valueOf(reward.get(i).get("num")));
				type2 = Integer.parseInt(String.valueOf(reward.get(i).get("type")));
				bo = this.getplayerHandler().getShangxian(type2, resType2, roleId, itemid2, num2);
				if(bo==false){//背包个字不足
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);
					ServerHandler.sendData(session, respMap);
					return;
				}
			}
			JSONArray list = new JSONArray();
			String qcost0=gameRole.getQcost();
			JSONArray qcosts = JSONArray.fromObject(qcost0);
			for(int i=0;i<s;i++){
//				itemid2 = Integer.parseInt(String.valueOf(reward.get(i).get("id")));
//				resType2 = Integer.parseInt(String.valueOf(reward.get(i).get("resType")));
//				num2 = Integer.parseInt(String.valueOf(reward.get(i).get("num")));
//				this.getplayerHandler().getItem(roleId, itemid2, num2, resType2, list);
				if(type==3){
					if(qcosts.getInt(t-1)==1){//已领取过奖励
					
					}else{
						itemid2 = Integer.parseInt(String.valueOf(reward.get(i).get("id")));
						resType2 = Integer.parseInt(String.valueOf(reward.get(i).get("resType")));
						num2 = Integer.parseInt(String.valueOf(reward.get(i).get("num")));
						this.getplayerHandler().getItem(roleId, itemid2, num2, resType2, list);
					}
				}else{
					itemid2 = Integer.parseInt(String.valueOf(reward.get(i).get("id")));
					resType2 = Integer.parseInt(String.valueOf(reward.get(i).get("resType")));
					num2 = Integer.parseInt(String.valueOf(reward.get(i).get("num")));
					this.getplayerHandler().getItem(roleId, itemid2, num2, resType2, list);
				}
			}
			/****/
			if(type==3){//每日q币消费领取奖励
//				String qcost0=gameRole.getQcost();
//				JSONArray qcosts = JSONArray.fromObject(qcost0);
				if(qcosts.getInt(t-1)==1){//已领取过奖励
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-3);
					ServerHandler.sendData(session, respMap);
					return;
				}
				 qcosts.set(t-1, 1);
				 //System.out.println("q币消费领取奖励：：：：：：t：："+t+":::::::qcost::"+qcosts);
				param.clear();
				 param.put("id", roleId);
					param.put("qcost", qcosts.toString());
					this.getGameRoleService().updatebuyitem(param);
					rlt.put("reward", list);
					rlt.put("id", id);
					ary=null;
					list=null;
					reward=null;
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
					ServerHandler.sendData(session, respMap);
					activity=null;
					
					
					gameRole=null;
					
					param=null;
					return;
			}
			/****/
			
			//标记已领取
			if(status==0){//第一次
				param.clear();
				param.put(id+"", (t-1)+"");
				ary.add(param);
			}else if(status==1){
				str += (t-1);
				for(int i=0;i<size;i++){
					if(ary.get(i).get(id+"")!=null){
						param.clear();
						param.put(""+id, ary.get(i).get(id+"")+""+(t-1));
						ary.set(i, param);
					}
				}
			}
			param.clear();
			param.put("id", roleId);
			param.put("activitytype", ary.toString());
			this.getGameRoleService().updateRoleVip(param);
			rlt.put("reward", list);
			rlt.put("id", id);
			ary=null;
			list=null;
			reward=null;
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
			ServerHandler.sendData(session, respMap);
			activity=null;
			
			
			gameRole=null;
			
			param=null;
		}
	}

	private void changeactivity() {
		//	TODO
		if(params.containsKey("id")){
			int roleId = Integer.parseInt(playerId);
			int id = Integer.parseInt(String.valueOf(params.get("id")));
			Map<String,Object> param = new HashMap<String,Object>();
			Map<String,Object> rlt = new HashMap<String,Object>();
			param.put("id", id);
			List<ActivityDetail> activity = this.getActivityService().getActivityByParams(param);
			if(activity.isEmpty()){//活动已下架
//				System.out.println("活动下架！");
				//System.out.println("1");
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
				ServerHandler.sendData(session, respMap);
				return;
			}
//			System.out.println(activity.get(0).getDescription());
			 //int remainday=7-(day0-day);//新服活动结束还有几天
			int remainday=0;
			Calendar calendar = Calendar.getInstance();
			int month0 = calendar.get(Calendar.MONTH) + 1;
			int day0 = calendar.get(Calendar.DAY_OF_MONTH);
			int month = activity.get(0).getMonth();
			int day = activity.get(0).getDay();   
			int monthend = activity.get(0).getMonthend();
			int dayend = activity.get(0).getDayend();
			if(month==month0 && month0==monthend){
				if(day0>=day && day0<=dayend){
					remainday=7-(day0-day);
				}else{//结束了
					//System.out.println("2");
					//System.out.println("结束了");
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
					ServerHandler.sendData(session, respMap);
					return;
				}
			}else if(month0>=month && month0<=monthend){
				//不用判断day
				if(month0>month && month0<=monthend){
					if(month==2){
						remainday=7-(day0+28-day);
					}
				}else{
					remainday=7-(day0-day);
				}
				
			}else{
				//System.out.println("3");
				//System.out.println("else");
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
				ServerHandler.sendData(session, respMap);
				return;
			}
			//有该活动,判断哪个可以领取
			int type = activity.get(0).getType();
			GameRoleDetail gameRole = this.getGameRoleService().findRoleById(roleId);
			
			/****/
			 if(type==5){//type=6开新服活动
				// System.out.println("开新服活动======================");
				List<GameMilitaryDetail> gm=this.getGameMilitaryService().getMilitaryPinzhi(roleId);
				JsonSerializer json=new JsonSerializer();
				int[] ary = new int[4];
				//System.out.println(gm.get(0).getGongji()+"传奇魔将"+gm.get(0).getGongsu()+"一流魔将");
			    int legend=gm.get(0).getGongji();//传奇魔将数量
			    int red=gm.get(0).getGongsu();//红将数量
			    String activitygift=gameRole.getActivitygift();
			   // System.out.println("activitygift======"+activitygift);
		    	List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json
				.deserialize(activitygift);
		    	if(roleinfo.size()==0||roleinfo.isEmpty()){
		    		//System.out.println("新玩家开新服活动没有插入：：：：：");
		    		Map<String, Object> ma=new HashMap<String, Object>();
		    		ma.put("one", 0);
		    		ma.put("two", 0);
		    		ma.put("three", 0);
		    		ma.put("four", 0);
		    		roleinfo.add(ma);
		    	}
		    	//System.out.println("roleinfo===one="+roleinfo.get(0).get("one"));
		    	int one=Integer.parseInt(String.valueOf(roleinfo.get(0).get("one")));
		        int two=Integer.parseInt(String.valueOf(roleinfo.get(0).get("two")));
		        int three=Integer.parseInt(String.valueOf(roleinfo.get(0).get("three")));
		        int four=Integer.parseInt(String.valueOf(roleinfo.get(0).get("four")));
			     
		        //System.out.println("red======"+red+"legend========="+legend);
		        
		        if(red>=3&&legend>=2){//红将金将
		        	//System.out.println("=============1=============");
		        	 if(red>=6){//领取红将第1重第2重奖励
		   	    	  //2可以领取   3已经领取   1不可以领取
		   			    	
		   			    	if(one==0){//可以领取第一重
		   			        	ary[0]=2;
		   			        }else{//不可以领取第一重
		   			        	ary[0]=3;
		   			        }
		   			    	
		   			    	if(two==0){//可以领取第二重
		   			    		ary[1]=2;
		   			    	}else{//不可以领取第二重
		   			    		ary[1]=3;
		   			    	}
		   			    	
		   			    	
		   		}else if(red>=3){//领取红将第1重奖励
		                        if(one==0){//可以领取第一重
		                       	 ary[0]=2;
		   			        }else{//不可以领取第一重
		   			        	ary[0]=3;
		   			        }
		                        ary[1]=1;
		   			    }
		   	      
		   	      
		   			    if(legend>=4){//领取金将第3重第4重奖励
		   			    	if(three==0){
		   			    		//System.out.println("=============2=============");
		   			    		ary[2]=2;
		   			    	}else{
		   			    		ary[2]=3;
		   			    		//System.out.println("=============3=============");
		   			    	}
		   			    	if(four==0){
		   			    		//System.out.println("=============4=============");
		   			    		ary[3]=2;
		   			    	}else{
		   			    		ary[3]=3;
		   			    		//System.out.println("=============5=============");
		   			    	}
		   			    }else if(legend>=2){//领取金将第3重奖励
		   			    	if(three==0){
		   			    		//System.out.println("=============6=============");
		   			    		ary[2]=2;
		   			    	}else{
		   			    		ary[2]=3;
		   			    		//System.out.println("=============7=============");
		   			    	}
		   			    	 ary[3]=1;
		   			    }
		        }else if(red>=3||legend>=2){
		        	//System.out.println("=============11=============");
		        	 if(red>=6){//领取红将第1重第2重奖励
			   	    	  //2可以领取   3已经领取   1不可以领取
			   			    	
			   			    	if(one==0){//可以领取第一重
			   			        	ary[0]=2;
			   			        }else{//不可以领取第一重
			   			        	ary[0]=3;
			   			        }
			   			    	
			   			    	if(two==0){//可以领取第二重
			   			    		ary[1]=2;
			   			    	}else{//不可以领取第二重
			   			    		ary[1]=3;
			   			    	}
			   			    	ary[2]=1;
			   			    	ary[3]=1;	
			   			    	
			   		}else if(red>=3){//领取红将第1重奖励
			                        if(one==0){//可以领取第一重
			                       	 ary[0]=2;
			   			        }else{//不可以领取第一重
			   			        	ary[0]=3;
			   			        }
			                        ary[1]=1;
			                        ary[2]=1;
				   			    	ary[3]=1;
			   			    }
			   	      
			   	      
			   			    if(legend>=4){//领取金将第3重第4重奖励
			   			    	if(three==0){
			   			    		ary[2]=2;
			   			    	}else{
			   			    		ary[2]=3;
			   			    	}
			   			    	if(four==0){
			   			    		ary[3]=2;
			   			    	}else{
			   			    		ary[3]=3;
			   			    	}
			   			    	ary[0]=1;
		                        ary[1]=1;
			   			    }else if(legend>=2){//领取金将第3重奖励
			   			    	if(three==0){
			   			    		ary[2]=2;
			   			    	}else{
			   			    		ary[2]=3;
			   			    	}
			   			    	 ary[3]=1;
			   			    	 ary[0]=1;
		                         ary[1]=1;
			   			    }
		        }else{
		        	//System.out.println("=============111=============");
		        	 ary[3]=1;
   			    	 ary[1]=1;
                     ary[2]=1;
                     ary[0]=1;
		        }
		       // int remainday=7-(day0-day);//新服活动结束还有几天
		        //System.out.println("剩余天数=="+remainday);
		        rlt.put("canget", ary);
		        rlt.put("remainday", remainday);
		        rlt.put("tipurl", activity.get(0).getTipurl());
				rlt.put("desc", activity.get(0).getDescription());
				
				rlt.put("conditions", JSONArray.fromObject(activity.get(0).getConditions()));
				rlt.put("reward", JSONArray.fromObject(activity.get(0).getReward()));
				StringBuffer sb = new StringBuffer();
				sb.append(calendar.get(Calendar.YEAR)).append(".").append(month).append(".").append(day);
				sb.append("--");
				sb.append(calendar.get(Calendar.YEAR)).append(".").append(monthend).append(".").append(dayend-3);
				rlt.put("time", sb.toString());
				rlt.put("id", id);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
				ServerHandler.sendData(session, respMap);
				 ary=null;
				 return;
			    
	               }
			/****/
			
			
			//判断是否是新活动
			List<Map> isnew = JSONArray.fromObject(gameRole.getIsnew());
			int n = isnew.size();
			int f = 0;
			for(int i=0;i<n;i++){
				if(isnew.get(i).get(id+"")!=null){
					f=1;
					if(!isnew.get(i).get(id+"").equals(activity.get(0).getIsnew()+"")){//更新活动
						param.clear();
						param.put(id+"", activity.get(0).getIsnew()+"");
						isnew.set(i, param);
						
						param.clear();
						param.put("id", roleId);
						param.put("isnew", isnew.toString());
						List<Map> actype = JSONArray.fromObject(gameRole.getActivitytype());
						int acsize = actype.size();
						for(int j=0;j<acsize;j++){
							if(actype.get(j).get(id+"")!=null){
								actype.remove(j);
								break;
							}
						}
						if(type==3){
							//param.put("daycoin", gameRole.getCoinspend());
						}
						param.put("activitytype", actype.toString());
						this.getGameRoleService().updateRoleVip(param);
						gameRole = this.getGameRoleService().findRoleById(roleId);
					}
				}
			}
			if(f==0){//插入一条标记
				param.clear();
				param.put(id+"", activity.get(0).getIsnew()+"");
				isnew.add(param);
				param.clear();
				param.put("id", roleId);
				if(type==3){
					//param.put("daycoin", gameRole.getCoinspend());
				}
				param.put("isnew", isnew.toString());
				this.getGameRoleService().updateRoleVip(param);
				gameRole = this.getGameRoleService().findRoleById(roleId);
			}
			//System.out.println("id:"+id);
			if(type==2){//比较特殊
				List list = JSONArray.fromObject(activity.get(0).getConditions());
				 int size = list.size();
				 int[] ary = new int[size];
				//System.out.println("type:"+type);
				 List<Map> grList = JSON.parseArray(gameRole.getActivitytype(),Map.class);
				 String str = "";
				 if(!grList.isEmpty()){
					 for(int i=0;i<grList.size();i++){
						 if(grList.get(i).get(activity.get(0).getId()+"")!=null){
							 str = String.valueOf(grList.get(i).get(activity.get(0).getId()+""));
						 }
					 }
				 }
				 grList=null;
				 int resType = 0;
				 int itemid = 0;
				 int num = 0;
				 for(int i=0;i<size;i++){
					 if(str.indexOf(i+"")!=-1){
						 ary[i]=-1;
					 }else{//判断是哪一种物品
						 List<Map> list2 = JSONArray.fromObject(list.get(i));
						 int size2 = list2.size();
						 
						 itemid = Integer.parseInt(String.valueOf(list2.get(0).get("id")));
						 num = Integer.parseInt(String.valueOf(list2.get(0).get("num")));
						 resType = Integer.parseInt(String.valueOf(list2.get(0).get("resType")));
						// System.out.println("resType"+resType);
						 if(resType==3){//武将
							 List<RoleMilitaryDetail> rolem=null;
							 if(size2>1){
								 for(int j=0;j<size2;j++){
									 itemid = Integer.parseInt(String.valueOf(list2.get(j).get("id")));
									 rolem = this.getRoleMilitaryService().getRoleMilitarytime(itemid, roleId);
									 if(rolem.isEmpty()){
										 ary[i]=0;
										 break;
									 }else{
										 ary[i]=1;
									 }
								 }
							 }else{
								 rolem = this.getRoleMilitaryService().getRoleMilitarytime(itemid, roleId);
								 if(rolem.isEmpty()){
									 ary[i]=0;
								 }else{
									 ary[i]=1;
								 }
							 }
							 rolem=null;
						 }else if(resType==5){
							 List<RoleItemDetail> roleItem = null;
							 if(size2>1){
								 for(int j=0;j<size2;j++){
									 itemid = Integer.parseInt(String.valueOf(list2.get(j).get("id")));
									 num = Integer.parseInt(String.valueOf(list2.get(j).get("num")));
									 param.clear();
									 param.put("roleid", roleId);
									 param.put("itemid", itemid);
									 roleItem = this.getRoleItemService().getRoleItemByitem(param);
									 if(roleItem.isEmpty()){
										 ary[i]=0;
										 break;
									 }else{
										 if(roleItem.get(0).getNum()<num){
											 ary[i]=0;
											 break;
										 }else{
											 ary[i]=1;
										 }
									 }
									 
								 }
							 }else{
								 param.clear();
								 param.put("roleid", roleId);
								 param.put("itemid", itemid);
								 roleItem = this.getRoleItemService().getRoleItemByitem(param);
								 if(roleItem.isEmpty()){
									 ary[i]=0;
								 }else{
									 if(roleItem.get(0).getNum()<num){
										 ary[i]=0;
									 }else{
										 ary[i]=1;
									 }
								 }
							 }
							 roleItem=null;
						 }else if(resType==6){
							 List<RoleEquipDetail> roleEquip = null;
							 if(size2>1){
								 for(int j=0;j<size2;j++){
									 itemid = Integer.parseInt(String.valueOf(list2.get(j).get("id")));
									 num = Integer.parseInt(String.valueOf(list2.get(j).get("num")));
									 param.clear();
									 param.put("equipId", itemid);
									 param.put("roleId", roleId);
									 roleEquip = this.getRoleEquipService().getRoleEquipByEquipId(param);
									 if(roleEquip.isEmpty()){
										 ary[i]=0;
										 break;
									 }else{
										 if(roleEquip.size()<num){
											 ary[i]=0;
											 break;
										 }else{
											 ary[i]=1;
										 }
									 }
								 }
								 roleEquip=null;
							 }else{
								 param.clear();
								 param.put("equipId", itemid);
								 param.put("roleId", roleId);
								 roleEquip = this.getRoleEquipService().getRoleEquipByEquipId(param);
								 if(roleEquip.isEmpty()){
									 ary[i]=0;
								 }else{
									 if(roleEquip.size()<num){
										 ary[i]=0;
									 }else{
										 ary[i]=1;
									 }
								 }
							 }
							 roleEquip=null;
						 }
						 list2=null;
					 }
				 }
				 //更新到标记是否可领取
				 
				 rlt.put("canget", ary);
				 rlt.put("percent", 0);//前段不用
				 list=null;
				 ary=null;
			}else{
				List<Map> list = JSON.parseArray(activity.get(0).getConditions(),Map.class);
				 int size = list.size();
				 int[] ary = new int[size];
				if(type==1){//购买道具
					 param.clear();
					 param.put("roleid", roleId);
					 param.put("itemid", Integer.parseInt(String.valueOf(list.get(0).get("id"))));
					 List<RoleItemDetail> roleItem = this.getRoleItemService().getRoleItemByitem(param);
					 int num =0;
					 if(!roleItem.isEmpty()){//不存在时，第一次购买要把num加上,在购买里写
						 if(roleItem.get(0).getIsnew()==activity.get(0).getIsnew()){
							 num = roleItem.get(0).getActivitynum();
						 }else{//更新购买道具数量,清零
							 param.clear();
							 param.put("isnew", activity.get(0).getIsnew());
							 param.put("activitynum", 0);
							 param.put("roleid", roleId);
							 param.put("itemid", Integer.parseInt(String.valueOf(list.get(0).get("id"))));
							 this.getRoleItemService().updateRoleItemByParams(param);
						 }
					 }
					 
					 roleItem=null;
					 List<Map> grList = JSON.parseArray(gameRole.getActivitytype(),Map.class);
					 String str = "";
					 if(!grList.isEmpty()){
						 for(int i=0;i<grList.size();i++){
							 if(grList.get(i).get(activity.get(0).getId()+"")!=null){
								 str = String.valueOf(grList.get(i).get(activity.get(0).getId()+""));
							 }
						 }
					 }
					 grList=null;
					 for(int i=0;i<size;i++){
						 if(str.indexOf(i+"")!=-1){
							 ary[i]=-1;//已领取
						 }else if(num>=Integer.parseInt(String.valueOf(list.get(i).get("num")))){
							 ary[i]=1;//可以领取
						 }else{
							 ary[i]=0;//未领取(无领取资格)
						 }
					 }
					 rlt.put("canget", ary);
					 rlt.put("percent", num);
					 grList=null;
				}else if(type==3){//每日消费
//					 List<Map> grList = JSON.parseArray(gameRole.getActivitytype(),Map.class);
//	//				 System.out.println("SystemHandler().gameRole.getActivitytype():" + gameRole.getActivitytype());
//					 String str = "";
//					 if(!grList.isEmpty()){
//						 for(int i=0;i<grList.size();i++){
//							 if(grList.get(i).get(activity.get(0).getId()+"")!=null){
//								 str = String.valueOf(grList.get(i).get(activity.get(0).getId()+""));
//							 }
//						 }
//					 }
					int spends = gameRole.getDaycoin();
					String qcost0=gameRole.getQcost();
					JSONArray qcosts = JSONArray.fromObject(qcost0);
//					if(spends!=0){
//					}
					//spends = gameRole.getCoinspend() - spends;
					for(int i=0;i<size;i++){
						//if(str.indexOf(i+"")!=-1){
							//ary[i]=-1;
						//}else{
							if(Integer.parseInt(String.valueOf(list.get(i).get("num")))<=spends){
								if(qcosts.getInt(i)==0){
									ary[i]=1;	
								}else{
									ary[i]=0;
								}
								
							}else{
								ary[i]=0;
							}
						}
						
					//}
					 rlt.put("canget", ary);
					 rlt.put("percent", spends);
					 //grList=null;
				}else if(type==4){//每日登陆
					List<Map> grList = JSON.parseArray(gameRole.getActivitytype(),Map.class);
					 String str = "";
					 if(!grList.isEmpty()){
						 for(int i=0;i<grList.size();i++){
							 if(grList.get(i).get(activity.get(0).getId()+"")!=null){
								 str = String.valueOf(grList.get(i).get(activity.get(0).getId()+""));
							 }
						 }
					 }
					if(str.indexOf("0")!=-1){
						ary[0]=-1;
					}else{
						ary[0]=1;
					}
					
					rlt.put("canget", ary);
					rlt.put("percent", 0);
					grList=null;
				}
				list=null;
				ary=null;
			}
			 
			rlt.put("tipurl", activity.get(0).getTipurl());
			rlt.put("desc", activity.get(0).getDescription());
			
			rlt.put("conditions", JSONArray.fromObject(activity.get(0).getConditions()));
			rlt.put("reward", JSONArray.fromObject(activity.get(0).getReward()));
			StringBuffer sb = new StringBuffer();
			sb.append(calendar.get(Calendar.YEAR)).append(".").append(month).append(".").append(day);
			sb.append("--");
			sb.append(calendar.get(Calendar.YEAR)).append(".").append(monthend).append(".").append(dayend);
			rlt.put("time", sb.toString());
			rlt.put("id", id);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
			ServerHandler.sendData(session, respMap);
			sb=null;
			rlt=null;
			param=null;
			activity=null;
			gameRole=null;
		}
	}

	private void openactivity() {
		int roleid = Integer.parseInt(playerId);
		Map<String,Object> rlt = new HashMap<String,Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		List<ActivityDetail> activity = this.getActivityService().getActivityByParams(param);
		//List<MemberDetail> member=this.getMemberService().findMemberByid(roleid);
		GameRoleDetail gameRole = this.getGameRoleService().findRoleById(roleid);
		int memberserverid=Integer.parseInt(String.valueOf(gameRole.getServerId()));
		List<ServerDetail> ser=this.getServerService().getAllNewServer();
		int seeStatu=0;//可以看开新服的状态
		for(int i=0;i<ser.size();i++){
			if(memberserverid==ser.get(i).getId()){
			//	System.out.println("server_table的Id是新服："+ser.get(i).getId());
				seeStatu=1;
				break;
			}
		}
		
		JSONArray list = new JSONArray();
		if(activity.isEmpty()){//没有活动了
			rlt.put("types", list);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
			ServerHandler.sendData(session, respMap);
			rlt=null;
			list = null;
			return;
		}
		
		Calendar calendar = Calendar.getInstance();
		int month0 = calendar.get(Calendar.MONTH) + 1;
		int day0 = calendar.get(Calendar.DAY_OF_MONTH);
		int size = activity.size();
		Map<String,Object> map = new HashMap<String,Object>();
		int month=0;
		int day=0;
		int monthend=0;
		int dayend=0;
		for(int i=0;i<size;i++){
			if(activity.get(i).getId()==16){
				continue;
			}
			if(activity.get(i).getId()==20||activity.get(i).getId()==21||activity.get(i).getId()==23||activity.get(i).getId()==24||activity.get(i).getId()>1000){
				continue;
			}
			month = activity.get(i).getMonth();
			day = activity.get(i).getDay();
			monthend = activity.get(i).getMonthend();
			//dayend = activity.get(i).getDayend()+3;
			dayend = activity.get(i).getDayend();
			int serverid=activity.get(i).getServerid();
//			if(serverid==2&&memberserverid==2){//id=2高老庄区的玩家能看到此活动
//			
//			}
			if(month0==month&&month0==monthend){
				if(day0>=day&&day0<=dayend){
					map.clear();
					map.put("type", activity.get(i).getType());
					map.put("id", activity.get(i).getId());
					map.put("url", activity.get(i).getUrl());
					if(serverid!=0){//新区2区活动，serverid=2的用户才能看到
					//if(true){//新区2区活动，serverid=2的用户才能看到
					//if(memberserverid==2){
						if(seeStatu!=0){	
						//System.out.println("=========1============");
							list.add(map);
							continue;
						}else{
							//System.out.println("=========2============");
							continue;
							
						}
					}
					list.add(map);
				}else{//结束了
					continue;
				}
			}else if(month0>=month&&month0<=monthend){
				//不用判断day
				map.clear();
				map.put("type", activity.get(i).getType());
				map.put("id", activity.get(i).getId());
				map.put("url", activity.get(i).getUrl());
				if(serverid!=0){//新区2区活动，serverid=2的用户才能看到
				//if(true){//新区2区活动，serverid=2的用户才能看到
				//if(memberserverid==2){
					if(seeStatu!=0){	
							list.add(map);
							//System.out.println("=========3============");
							continue;
					 }else {
						// System.out.println("=========4============");
						continue;
					}
				 }
				list.add(map);
			}else{
				continue;
			}
		}
		
		//判断是否是新的一天
		long nowtime2 = new Date().getTime();
		int day2 = (int) ((nowtime2 - gameRole.getTasktime()) / 1000 / 60 / 60 / 24 + 1);
		int roleday = gameRole.getDay();
		if (day2 > roleday) {// 新的一天，dailynum应设为0，day增加1，今天还没有领取礼包
			if(day2>this.getRoleTaskService().findRoleTask(roleid).get(0).getDay()){
				map.clear();
				map.put("roleId", roleid);
				map.put("dailynum", 0);
				map.put("day", day2);
				map.put("status", 1);
				this.getRoleTaskService().updateRoleTasknumday(map);
			}
			
			// 恢复妖牌为0

			//标记今天上线，将今天的放到昨天
			JSONArray ary = new JSONArray();
			Map<String, Object> pp = new HashMap<String, Object>();
			pp.put("day", day2);
			ary.add(pp);
			map.clear();
			map.put("id", roleid);
			map.put("day", day2);
			map.put("num", 0);
			map.put("yesterday", gameRole.getToday());
			map.put("today", ary.toString());
			map.put("live", 0);//好友活跃度奖励
			map.put("huangzuangift", 0);//黄钻礼包
			map.put("jingji", 10);
			map.put("jjnum", 0);
//			map.put("jjstatus", 1);
			this.getGameRoleService().updateRoleVip(map);
			this.getplayerHandler().updateActivity(roleid);//更新每日活动
			pp=null;
		}
		gameRole=null;
		
		rlt.put("types", list);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
				GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
		ServerHandler.sendData(session, respMap);
		rlt=null;
		list=null;
		activity=null;
		map=null;
	}

	private void clrcache() {
		ServerHandler.regameCache();
	}

	private void buybylevel() {
		if(params.containsKey("id")&&params.containsKey("num")){
			int itemId = Integer.parseInt(String.valueOf(params.get("id")));
//			int num = Integer.parseInt(String.valueOf(params.get("num")));
			int num = 1;
			int roleid = Integer.parseInt(playerId);
			Map<String, Object> rlt = new HashMap<String, Object>();
			Map<String, Object> param = new HashMap<String, Object>();
			List<GameItemDetail> gameItem = this.getGameItemService().getGameItemById(itemId);
			if(gameItem.isEmpty()){//该道具不存在
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-2);
				ServerHandler.sendData(session, respMap);
				return;
			}
			//判断是否符合条件
			GameRoleDetail gameRole = this.getGameRoleService().findRoleById(roleid);
			int level = gameRole.getLevel();
			if(gameItem.get(0).getItemlevel()>level){
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);
				ServerHandler.sendData(session, respMap);
				return;
			}
			
			JSONArray ary = JSONArray.fromObject(gameRole.getBylevel());
			if(ary.size()>0){
				if(ary.contains(gameItem.get(0).getItemlevel())){//已购买
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-3);
					ServerHandler.sendData(session, respMap);
					return;
				}
			}
			int type = gameItem.get(0).getItemtype();//道具类型
			int resType = 5;
			param.put("resType", resType);
			param.put("resId", itemId);
			List<GamePriceDetail> gamePrice = this.getGamePriceService().getGamePrice(param);
			if(gamePrice.isEmpty()){//道具不存在
				return;
			}
			int price = gamePrice.get(0).getResCost();//消费一个时元宝
			//判断元宝是否足够
			if(gameRole==null){
				return;
			}
			int coin = gameRole.getCoin();

			int buy = 1;
			price = price*num;
			if(coin>=price&&price>0){//使用元宝购买
				//减少元宝
				
				// type :子类型 resType:主类型 roleId:人物id id:物品
				boolean b = this.getplayerHandler().getShangxian(type, 5, roleid, itemId, num);
				if (b == true) {
					if (gamePrice.get(0).getCostType() == 2) {
						//减少元宝
						this.getGameRoleService().subRoleCoin(roleid, price);
						//增加道具
						Map<String, Object> items = new HashMap<String, Object>();
						if(resType == 5){
							int isover = gameItem.get(0).getIsover();
							items.put("id", itemId);
							items.put("resType", resType);
							items.put("num", num);
							param.clear();
							param.put("roleid", roleid);
							param.put("itemid", itemId);
							List<RoleItemDetail> item = this.getRoleItemService().getRoleItem(param);

							if (item.isEmpty() || isover == 0) {// 添加
								//int bid = this.getAutoIdService().fingKeyValueByTableName("role_item") + 1;
								
								long bid = this.getAutoIdService().fingKeyValueByTableName("role_item");
								RoleItemDetail iDetail = new RoleItemDetail();
								iDetail.setId(bid);
								iDetail.setRoleid(roleid);
								iDetail.setItemid(itemId);
								iDetail.setNum(num);
								iDetail.setFlag(1);
								iDetail.setType(type);
								this.getRoleItemService().insertRoleItem(
										iDetail);
//								this.getAutoIdService()
//										.updateKeyValueAddOneByTableName(
//												"role_item");
								items.put("bid", bid);

							} else {// 不添加
								param.clear();
								param.put("roleid", roleid);
								param.put("itemid", itemId);
								param.put("num", num);
								this.getRoleItemService().addRoleItemNum(param);
								items.put("bid", item.get(0).getId());
							}
							rlt.put("items", items);
						}
						items=null;
					}
				} else {
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							-1);// 背包上限
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
							"");
					ServerHandler.sendData(session, respMap);
					return;
				}
				rlt.put("coin", coin-price);
				rlt.put("coinspend", gameRole.getCoinspend());
				// 判断是否有任务，及是否完成
				param.clear();
				param.put("roleid", roleid);
				param.put("type", 4);
				List<RoleTaskTaskDetail> listW = this.getRoleTaskTaskService()
						.findRoleTaskBytype0(param);
				for(int i=0;i<listW.size();i++){
					if (listW.get(i).getTasklevel() == itemId) {
						param.clear();
						param.put("roleid", roleid);
						param.put("taskid", listW.get(i)
								.getTaskid());
						param.put("progress", 1);
						this.getRoleTaskTaskService().updateRoleTaskProgress(param);
						// 判断是否有任务完成3
						this.getTaskHandler().taskcomplete(roleid);
					}
				}
				listW=null;
				//记录购买数据
				param.clear();
				param.put("roleid", roleid);
				param.put("num", num);
				param.put("coin", price);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String time = sdf.format(new Date());
				param.put("time", time);
				this.getCoinService().insertCoin(param);
				//标记已购买
				ary.add(gameItem.get(0).getItemlevel());
				param.clear();
				param.put("id", roleid);
				param.put("bylevel", ary.toString());
				this.getGameRoleService().updateRoleVip(param);
			}else{//元宝不足
				buy = 0;
				rlt.put("cha", 0);
				param.clear();
				rlt.put("items", param);
				rlt.put("coin", coin);
				rlt.put("coinspend", gameRole.getCoinspend());
			}

			
			rlt.put("yin", gameRole.getYin());
			rlt.put("buy", buy);
			rlt.put("id", itemId);
			rlt.put("bylevel", ary);
			//System.out.println("systemHandler中的返回值：" + rlt.toString());
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
					rlt);
			ServerHandler.sendData(session, respMap);
			param=null;
			rlt=null;
			gamePrice=null;
			gameRole =null;
			gameItem=null;
			ary=null;
		}
	}

	private void buygoods() {
//		System.out.println("购买开始==========================================");
//		System.out.println("buygoods");
		if(params.containsKey("id")&&params.containsKey("num")){
			int itemId = Integer.parseInt(String.valueOf(params.get("id")));
			int num = Integer.parseInt(String.valueOf(params.get("num")));
			int roleid = Integer.parseInt(playerId);
			Map<String, Object> rlt = new HashMap<String, Object>();
			Map<String, Object> param = new HashMap<String, Object>();
 //   	System.out.println("：：：购买道具或者图腾的Id========"+itemId);
			List<GameItemDetail> gameItem = this.getGameItemService().getGameItemById(itemId);
			
			if(gameItem.isEmpty()){
				if(itemId>=10000){
					
				}else{
					//该道具不存在
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
					ServerHandler.sendData(session, respMap);
					return;
				}
				
			}
			//int type = gameItem.get(0).getItemtype();//道具类型
			//int resType = 5;
			//param.put("resType", resType);
			param.put("resId", itemId);
			param.put("costType", 2);
			List<GamePriceDetail> gamePrice = this.getGamePriceService().getGamePrice(param);
			if(gamePrice.isEmpty()){//道具不存在
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -2);
				ServerHandler.sendData(session, respMap);
				return;
			}
			/****/
			
			int price=0;
			int onsale=0;
				price = gamePrice.get(0).getResCost();//消费一个时元宝
				onsale=gamePrice.get(0).getOnsale();
				int resType=gamePrice.get(0).getResType();
	//			System.out.println("resType=="+resType);
				//System.out.println("price原价====="+price+"onsale===="+onsale);
				param.clear();
				List<ShopdiscountDetail> sp=shopService.getShopdiscount(param);
				if(!sp.isEmpty()){
					Calendar calendar = Calendar.getInstance();
					int month0 = calendar.get(Calendar.MONTH) + 1;
					int day0 = calendar.get(Calendar.DAY_OF_MONTH);
					int month = sp.get(0).getMonth();
					int day = sp.get(0).getDay();
					int monthend =sp.get(0).getMonthend();
					int dayend = sp.get(0).getDayend();
					
					if(month!=monthend){
						if(month0>=month && month0<=monthend){
							if(month0==month){
								if(day0>=day){
									if(onsale!=0){
										price =(int) gamePrice.get(0).getResCost()*onsale/10;
									}
								}
							}else if(month0==monthend){
								if(day0<=dayend){
									if(onsale!=0){
										price =(int) gamePrice.get(0).getResCost()*onsale/10;
									}
								}
							}else if(month0!=month&&month0!=monthend){
								if(onsale!=0){
									price =(int) gamePrice.get(0).getResCost()*onsale/10;
								}
							}
						}
					}
					if(month == monthend){
						if(day0>=day&&day0<=dayend){
							if(onsale!=0){
								price =(int) gamePrice.get(0).getResCost()*onsale/10;
							}
						}
					}
				}
			/****/
				int s=0;
			//int price = gamePrice.get(0).getResCost();//消费一个时元宝
			//判断元宝是否足够
			GameRoleDetail gameRole = this.getGameRoleService().findRoleById(roleid);
			if(gameRole==null){
				return;
			}
			int coin = gameRole.getCoin();
             String buyitem=gameRole.getBuyitem();
			int buy = 1;
			price = price*num;
			
			if(itemId==320){//新手成长基金，不放在背包里面只能购买一次
				int fundsstatu=gameRole.getFundsstatu();
				if(fundsstatu!=0){//
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							-9);//
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
							"");
					ServerHandler.sendData(session, respMap);
					return;
				}
				
			}
			
			if(coin>=price&&price>0){//使用元宝购买
				//减少元宝
			
				// type :子类型 resType:主类型 roleId:人物id id:物品
				/****/
				boolean b = false;
				//if(itemId==10000||itemId==130000||itemId==250000||itemId==370000||itemId==490000||itemId==610000||itemId==730000||itemId==850000){
				if(itemId>=10000){	
				b=true;
				}else if(itemId==320){
					b=true;
				}else{
					b = this.getplayerHandler().getShangxian(gameItem.get(0).getItemtype(), 5, roleid, itemId, num);
					
				}
				/****/
				// b = this.getplayerHandler().getShangxian(type, 5, roleid, itemId, num);
				if (b == true) {
					if (gamePrice.get(0).getCostType() == 2) {
						//减少元宝
						this.getGameRoleService().subRoleCoin(roleid, price);
						//增加道具
						Map<String, Object> items = new HashMap<String, Object>();
						if(resType == 5){
							if(itemId==320){//新手成长基金，不放在背包里面
								param.clear();
								param.put("id", roleid);
								param.put("fundsstatu", 2);
								this.getGameRoleService().updateRoleVip(param);
								
							}else{
								int isover = gameItem.get(0).getIsover();
								items.put("id", itemId);
								items.put("resType", resType);
								items.put("num", num);
								param.clear();
								param.put("roleid", roleid);
								param.put("itemid", itemId);
								List<RoleItemDetail> item = this.getRoleItemService().getRoleItem(param);

								if (item.isEmpty() || isover == 0) {// 添加
									//int bid = this.getAutoIdService().fingKeyValueByTableName("role_item") + 1;
									long bid = this.getAutoIdService().fingKeyValueByTableName("role_item");
									
									RoleItemDetail iDetail = new RoleItemDetail();
									iDetail.setId(bid);
									iDetail.setRoleid(roleid);
									iDetail.setItemid(itemId);
									iDetail.setNum(num);
									iDetail.setFlag(1);
									iDetail.setType(gameItem.get(0).getItemtype());
	//TODO								iDetail.setActivitynum(num);
									this.getRoleItemService().insertRoleItem(
											iDetail);
//									this.getAutoIdService()
//											.updateKeyValueAddOneByTableName(
//													"role_item");
									items.put("bid", bid);

								} else {// 不添加
									param.clear();
									param.put("roleid", roleid);
									param.put("itemid", itemId);
									param.put("num", num);
									this.getRoleItemService().addRoleItemNum(param);
									items.put("bid", item.get(0).getId());
								}
								rlt.put("items", items);
							}
						 
							
							
						}
						/****/
						
						else if(resType==10){//图腾
							s=1;
							//查看玩家是否有这个图腾，有就更新，没有就插入
							param.clear();
							param.put("roleid", roleid);
							param.put("totemid", itemId/10000);
							List<RoletotemDetail> to=this.getRoletotemService().getRoletotem(param);
							if(to.isEmpty()){//第一次购买，插入
								List<GametotemDetail> gt=this.getGametotemService().getGametotembyid(itemId/10000);
								RoletotemDetail mo = new RoletotemDetail();
								mo.setRoleid(roleid);
								mo.setType(gt.get(0).getType());
								mo.setLevel(gt.get(0).getLevel());
								mo.setNum(num);
								mo.setQuality(gt.get(0).getQuality());
								mo.setTotemid(gt.get(0).getId());
								boolean c=this.getRoletotemService().insertRoletotem(mo);
	//							System.out.println("插入图腾========"+c);
							}else{//更新
								List<GametotemDetail> gt=this.getGametotemService().getGametotembyid(itemId/10000);
								   param.clear();
								   param.put("roleid", roleid);
								   param.put("type",gt.get(0).getType() );
								   param.put("level", gt.get(0).getLevel());
								   param.put("num", num);
								   this.getRoletotemService().addRoletotemNum(param);	
	//							   System.out.println("更新图腾========");
							}
							
						}
						/****/
						items=null;
					}
				} else {
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							-1);// 背包上限
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
							"");
					ServerHandler.sendData(session, respMap);
					return;
				}
				rlt.put("coin", coin-price);
				rlt.put("coinspend", gameRole.getCoinspend());
				// 判断是否有任务，及是否完成
				param.clear();
				param.put("roleid", roleid);
				param.put("type", 4);
				List<RoleTaskTaskDetail> listW = this.getRoleTaskTaskService()
						.findRoleTaskBytype0(param);
				for(int i=0;i<listW.size();i++){
					if (listW.get(i).getTasklevel() == itemId) {
						param.clear();
						param.put("roleid", roleid);
						param.put("taskid", listW.get(i)
								.getTaskid());
						param.put("progress", 1);
						this.getRoleTaskTaskService().updateRoleTaskProgress(param);
						// 判断是否有任务完成3
						this.getTaskHandler().taskcomplete(roleid);
					}
				}
				listW=null;
				//记录购买数据
				param.clear();
				param.put("roleid", roleid);
				param.put("num", num);
				param.put("coin", price);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String time = sdf.format(new Date());
				param.put("time", time);
				this.getCoinService().insertCoin(param);
			//	System.out.println(":::::::::::::itemid::::"+itemId);
				if(itemId==320){
					
				}else if(itemId<10000){
					try {
						//活动记录购买数量
						param.clear();
						param.put("type", 1);
						List<ActivityDetail> activity = this.getActivityService().getActivityByParams(param);
						if(!activity.isEmpty()){
							//System.out.println(":2::::::::::::::::");
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
							if(status==1){//记录数量
								param.clear();
								param.put("roleid", roleid);
								param.put("itemid", itemId);
								List<RoleItemDetail> item = this.getRoleItemService().getRoleItem(param);
								if(item.get(0).getIsnew()!=activity.get(0).getIsnew()){
									param.clear();
									param.put("isnew", activity.get(0).getIsnew());
									param.put("roleid", roleid);
									param.put("itemid", itemId);
									param.put("activitynum", num);
									this.getRoleItemService().updateRoleItemByParams(param);
								}else{//增加
									param.clear();
									param.put("roleid", roleid);
									param.put("itemid", itemId);
									param.put("activitynum", item.get(0).getActivitynum()+num);
									this.getRoleItemService().updateRoleItemByParams(param);
								}
								item=null;
							}
						}
						activity=null;
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			}else{//元宝不足
				buy = 0;
				rlt.put("cha", 0);
				param.clear();
				rlt.put("items", param);
				rlt.put("coin", coin);
				rlt.put("coinspend", gameRole.getCoinspend());
			}

			
			rlt.put("yin", gameRole.getYin());
			rlt.put("buy", buy);
			rlt.put("id", itemId);
			rlt.put("s", s);//1是图腾
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
					rlt);
			ServerHandler.sendData(session, respMap);
			param=null;
			rlt=null;
			gamePrice=null;
			gameRole =null;
			gameItem=null;
		}
	//	System.out.println("购买结束==========================================");
	}
	
	public void messagetwo(String message){
		GameConstants.log.warn("SystemHandler.messagetwo():message:" + message);
//		systemMessageQueue.enqueue(message);
			Map<String, Object> rlt = new HashMap<String, Object>();
			rlt.put("mess",message );
			rlt.put("url", "#");
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CMD,"sys.message");
			ServerHandler.sendDataToAll(respMap);
			rlt=null;
	}
	
	public static void sendMessage(String message){
			//GameConstants.log.warn("SystemHandler.sendMessage:message:" + message);
			//systemMessageQueue.enqueue(message);
			String mess = "";
			mess = message;
			Map<String, Object> rlt = new HashMap<String, Object>();
			if(message.startsWith("寻宝")){
				mess = message.substring(3, message.length());
				GameConstants.log.warn("SystemHandler.sendMessage:message:" + mess);
				rlt.put("suibian", "suibian");
			}
			rlt.put("mess", mess);
			rlt.put("url", "#");
			Map<String, Object> res = new HashMap<String, Object>();
			res.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
			res.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			res.put(GameConstants.GAME_API_RESPONSE_FIELD_CMD,"sys.message");
			ServerHandler.sendDataToAll(res);
			rlt=null;
	}
	
	public void addMessage(String message){
		GameConstants.log.warn("SystemHandler.addMessage():size:" + systemMessageQueue.size() + "message:" + message);
		systemMessageQueue.enqueue(message);
	}
	
	public void pacMes(Map<String, Object> rlt, int id){
//		Map<String, Object> res = new HashMap<String, Object>();
		//System.out.println("发送背包同步数据：" + rlt.toString());
//			res.clear();
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CMD,"sys.buygoods1");
			ServerHandler.sendDataByRoleId(respMap, id);
		rlt=null;
	}
	
	public void pacMes2(Map<String, Object> rlt, int id){
//		Map<String, Object> res = new HashMap<String, Object>();
			//System.out.println("发送礼尚往来同步数据：" + rlt.toString());
	//	System.out.println("pacMes2:cacheKey:" + cacheKey);
//			res.clear();
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CMD,"map.updateData");
			ServerHandler.sendDataByRoleId(respMap, id);
		rlt=null;
}
	public void pacMes3(Map<String, Object> rlt, int id){
//		Map<String, Object> res = new HashMap<String, Object>();
			//System.out.println("发送元宝同步数据：" + rlt.toString());
	//	System.out.println("pacMes2:cacheKey:" + cacheKey);
//			res.clear();
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CMD,"map.updatecoin");
			ServerHandler.sendDataByRoleId(respMap, id);
		rlt=null;
}
	
	private void pay(){ 
		int roleid = Integer.parseInt(playerId);
		Map<String, Object> rlt = new HashMap<String, Object>();
		GameRoleDetail role = this.getGameRoleService().findRoleById(roleid);
		int yin=role.getYin();
		 Random random = new Random();
		 int yun =random.nextInt(75)+25;
		 int coin=yin+yun;
		 this.getGameRoleService().addRoleYin(roleid, yun);
		 rlt.put("pay", yun);
		 rlt.put("allyin",coin );
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
	}
	
	public void upStep() {
		try {
			if (params.containsKey("i") && params.containsKey("s")) {
				Map<String, Object> rlt = new HashMap<String, Object>();
				int i = Integer.parseInt(String.valueOf(params.get("i")));
				int s = Integer.parseInt(String.valueOf(params.get("s")));
				int roleId = Integer.parseInt(playerId);
				String helpstring = this.getGameRoleService().findRoleById(roleId).getHelpstep();
				//System.out.println("SystemHandler.helpstep:" + helpstring + "  i:" + i + "  s:" + s );
				JSONArray ary = JSONArray.fromObject(helpstring);
				
				int[] helpArray = new int[ary.size()];
				for(int r = 0; r < ary.size(); r++){
					helpArray[r] = ary.getInt(r);
				}
				
				boolean b = false;
				//峰值预设
				int[] upArray = new int[ary.size()];
				upArray[0] = 9;
				upArray[1] = 8;
				upArray[2] = 4;
				upArray[3] = 6;
				upArray[4] = 2;
				upArray[5] = 3;
				upArray[6] = 5;
				upArray[7] = 5;
				upArray[8] = 5;
				upArray[9] = 6;
				upArray[10] = 2;
				upArray[11] = 6;
				
				
				int helpstep = helpArray[i];
				if (helpstep != 0) {
					if (helpstep >=upArray[i]) {
						if(i == 11){
							Map<String, Object> param = new HashMap<String, Object>();
							JSONArray helpchange = new JSONArray();
							if(s == 100){
								helpArray[0] = 0;
								helpArray[1] = 0;
								helpArray[2] = 0;
								helpArray[3] = 0;
								helpArray[4] = 0;
								helpArray[5] = 0;
								helpArray[6] = 0;
								helpArray[7] = 0;
								helpArray[8] = 0;
								helpArray[9] = 0;
								helpArray[10] = 0;
								helpArray[11] = 0;
							}else{
								helpArray[i] = s;
							}
							for(int u = 0; u < helpArray.length; u++){
								helpchange.add(helpArray[u]);
							}
							param.put("helpstep", helpchange.toString());
							param.put("id", roleId);
							b = this.getGameRoleService().updateRolehelpstep(param);
							param = null;
						}else{
							Map<String, Object> param = new HashMap<String, Object>();
							JSONArray helpchange = new JSONArray();
							if(s == 100){
								helpArray[i] = 0;
							}else{
								helpArray[i] = s;
							}
							for(int u = 0; u < helpArray.length; u++){
								helpchange.add(helpArray[u]);
							}
							param.put("helpstep", helpchange.toString());
							param.put("id", roleId);
							b = this.getGameRoleService().updateRolehelpstep(param);
							param = null;
						}
						
					} else {
//						if(helpstep==44){ 
//							int day=this.getGameRoleService().findRoleById(roleId).getDay();
//							if(day>7){ 
//								Map<String, Object> param = new HashMap<String, Object>();
//								param.put("helpstep", 49);
//								param.put("id", roleId);
//								b = this.getGameRoleService().updateRolehelpstep(param);	
//							}else{
//								Map<String, Object> param = new HashMap<String, Object>();
//								param.put("helpstep", helpstep + 1);
//								param.put("id", roleId);
//								b = this.getGameRoleService().updateRolehelpstep(param);
//							}
//						}else{
							Map<String, Object> param = new HashMap<String, Object>();
							JSONArray helpchange = new JSONArray();
							if(s == 100){
								helpArray[i] = helpstep + 1;
							}else{
								helpArray[i] = s;
							}
							for(int u = 0; u < helpArray.length; u++){
								helpchange.add(helpArray[u]);
							}
							param.put("helpstep", helpchange.toString());
							param.put("id", roleId);
							b = this.getGameRoleService().updateRolehelpstep(param);
						//	int c=	this.getGameRoleService().findRoleById(roleId).getHelpstep();
							param = null;
//					}
				 }
				}else{
					Map<String, Object> param = new HashMap<String, Object>();
					JSONArray helpchange = new JSONArray();
					if(s == 100){
						helpArray[i] = 0;
					}else{
						helpArray[i] = s;
					}
					for(int u = 0; u < helpArray.length; u++){
						helpchange.add(helpArray[u]);
					}
					param.put("helpstep", helpchange.toString());
					param.put("id", roleId);
					b = this.getGameRoleService().updateRolehelpstep(param);
					param = null;
				}
				if (b == true) {
					helpstring = this.getGameRoleService().findRoleById(roleId).getHelpstep();
					//System.out.println("help...."+helpstring);
				}
				JSONArray help =JSONArray.fromObject(helpstring);
				rlt.put("i", i+1);
				rlt.put("helpStep", help);
				//System.out.println("help...." + rlt.toString() + "  s:" + s);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
				ServerHandler.sendData(session, respMap);
			}else{
				GameConstants.log.warn("SystemHandler.upStep缺少参数i！");
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, GameConstants.GAME_API_ERROR_PROCESS_FAILURE_INFO);
				ServerHandler.sendData(session, respMap);
			}
			
		} catch (Exception e) {
			GameConstants.log.warn("", e);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_ERROR_PROCESS_FAILURE);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, GameConstants.GAME_API_ERROR_PROCESS_FAILURE_INFO);
			ServerHandler.sendData(session, respMap);
		}
	}

	private void impose() {
		try {
			if (params.containsKey("t")) {
				int t = Integer.parseInt(String.valueOf(params.get("t")));
				switch (t) {
				case 1:
					break;
				case 0:
					break;
				default:
					break;
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

	/**
	 * @method allModels
	 * @description 所有模型信息
	 */
//	private void allModels() {
//		System.out.println("请求x次");
//		long a=System.currentTimeMillis();
////		if (params.containsKey("t")) {
////			Object _t = params.get("t");
////			if (!String.valueOf(_t).equals("")
////					&& NumberUtils.isNumber(String.valueOf(_t))
////					&& NumberUtils.createInteger(String.valueOf(_t)) > 0) {
////				int t = NumberUtils.createInteger(String.valueOf(_t))
////						.intValue();
//				Map<String, Object> rlt = new HashMap<String, Object>();
//				/**
//				 * 分类 resType: 1/地图 2/防御塔 3/武将信息 4/敌将 5/道具 6 装备/ 7/vip模型10/价格表
//				 * *9/任务 14/技能 18/coin 16:兵/17:game_mission 18:game_bmap 19:game_bskill
//				 * 21:game_bbuff
//				 * //武将经验
//				 */
//				//switch (t) {
//				//case 1:
//					List<Map<String, Object>> maplist = new ArrayList<Map<String, Object>>();
//					if (!GlobalData.cacheGameMap.isEmpty()) {
//						int size = GlobalData.cacheGameMap.size();
////						System.out.println("SystemHandler,size:" + size);
//						for (int i = 0; i < size; i++) {
//							GameMapDetail gamemap = GlobalData.cacheGameMap
//									.get(i);
//							Map<String, Object> map = new HashMap<String, Object>();
//							map.put("id", gamemap.getId());
//							map.put("name", gamemap.getName());
//							map.put("desc", gamemap.getDesc());
//							map.put("battery", gamemap.getBattery());
//							maplist.add(map);
//							map = null;
//						}
//					}
//					rlt.put("gamemap", maplist);
//					//System.out.println("rlt:" + rlt.toString());
//					maplist = null;
//					//break;
//				//case 2:
//					List<Map<String, Object>> tlist = new ArrayList<Map<String, Object>>();
//					if (!GlobalData.cacheGameFTa.isEmpty()) {
//						int size = GlobalData.cacheGameFTa.size();
//						for (int i = 0; i < size; i++) {
//							GameTowerDetail gamet = GlobalData.cacheGameFTa
//									.get(i);
//							Map<String, Object> map = new HashMap<String, Object>();
//							map.put("id", gamet.getId());
//							map.put("name", gamet.getName());
//							map.put("desc", gamet.getDesc());
//							map.put("level", gamet.getLevel());
//							map.put("type", gamet.getType());
//							map.put("shottype", gamet.getShottype());
//							map.put("bombtype", gamet.getBombtype());
//							map.put("description", gamet.getDescription());
//							map.put("fwextra", gamet.getFwextra());
//							map.put("gjextra", gamet.getGjextra());
//							map.put("gsextra", gamet.getGsextra());
//							map.put("fanwei", gamet.getFanwei());
//							tlist.add(map);
//							map = null;
//						}
//					}
//					rlt.put("gametower", tlist);
//					tlist = null;
//					//break;
//				//case 3:
//					List<Map<String, Object>> mlist = new ArrayList<Map<String, Object>>();
//					if (!GlobalData.cacheGameMilitary.isEmpty()) {
//						int size = GlobalData.cacheGameMilitary.size();
//						for (int i = 0; i < size; i++) {
//							GameMilitaryDetail gamem = GlobalData.cacheGameMilitary
//									.get(i);
//							Map<String, Object> map = new HashMap<String, Object>();
//							map.put("desc", gamem.getDesc());
//							map.put("name", gamem.getName());
//							map.put("art", gamem.getArt());
//							map.put("arts", gamem.getArts());
//							map.put("fanwei", gamem.getFanwei());
//							map.put("gjiachenhg", gamem.getGjiacheng());
//							map.put("gongji", gamem.getGongji());
//							map.put("gongsu", gamem.getGongsu());
//							map.put("id", gamem.getId());
//							map.put("level", gamem.getLevel());
//							map.put("pingzhi", gamem.getPingzhi());
//							map.put("pztype", gamem.getPztype());
//							map.put("type", gamem.getType());
//							map.put("xljiacheng", gamem.getXljiacheng());
//							map.put("xueliang", gamem.getXueliang());
//							map.put("iscompose", gamem.getIscompose());
//							map.put("isaddcompose", gamem.getIsaddcompose());
//							map.put("needcompose", gamem.getNeedcompose());
//							map.put("composeid", gamem.getComposeid());
//							String describe="0";
//							if(gamem.getDescribe()==null){
//								
//							}else{
//								describe=gamem.getDescribe();
//							}
//							map.put("describe", describe);
//							mlist.add(map);
//							map = null;
//						}
//					}
//					rlt.put("gamemilitary", mlist);
//					mlist = null;
//					//break;
//				//case 4:
//					List<Map<String, Object>> flist = new ArrayList<Map<String, Object>>();
//					if (!GlobalData.cacheGameFoe.isEmpty()) {
//						int size = GlobalData.cacheGameFoe.size();
//						for (int i = 0; i < size; i++) {
//							GameFoeDetail gamef = GlobalData.cacheGameFoe
//									.get(i);
//							Map<String, Object> map = new HashMap<String, Object>();
//							map.put("foeid", gamef.getFoeid());
//							map.put("foename", gamef.getFoename());
//							map.put("foedesc", gamef.getFoedesc());
//							map.put("foefangyu", gamef.getFangyu());
//							map.put("foesudu", gamef.getSudu());
//							map.put("foetype", gamef.getType());
//							map.put("foexueliang", gamef.getXueliang());
//							flist.add(map);
//							map = null;
//						}
//					}
//					rlt.put("gamefoe", flist);
//					flist = null;
//					//break;
//				//case 5:
//					List<Map<String, Object>> itemShopList = new ArrayList<Map<String, Object>>();
//					if (!GlobalData.cacheModelItems.isEmpty()) {
//						int size = GlobalData.cacheModelItems.size();
//						for (int i = 0; i < size; i++) {
//							GameItemDetail item = GlobalData.cacheModelItems
//									.get(i);
//							Map<String, Object> map = new HashMap<String, Object>();
//							map.put("id", item.getId()); /* 道具模型序号 */
//							map.put("itemtype", item.getItemtype()); /* 道具类型() */
//							map.put("itemname", item.getItemname());
//							map.put("itemres", item.getItemres()); /* 资源名称 */
//							map.put("itemprop", item.getItemprop()); /* 道具说明 */
//							map.put("itemlevel", item.getItemlevel());
//							map.put("itemurl", item.getItemurl());
//							map.put("isover", item.getIsover());
//							map.put("isuse", item.getIsuse());
//							map.put("isshop", item.getIsshop());
//							map.put("coin", item.getCoin());
//							map.put("cointype", item.getCointype());
//							map.put("flg", item.getFlag());
//							map.put("quality", item.getQuality());
//							map.put("reward", item.getReward());
//							map.put("itemvip", item.getItemvip());
//							map.put("indexs", item.getIndexs());
//							itemShopList.add(map);
//							item = null;
//							map = null;
//						}
//					}
//					rlt.put("items", itemShopList);
//					itemShopList = null;
//					//break;
//				//case 6:
//					List<Map<String, Object>> gameEquipList = new ArrayList<Map<String, Object>>();
//					if (!GlobalData.cacheGameEquip.isEmpty()) {
//						int size = GlobalData.cacheGameEquip.size();
//						for (int i = 0; i < size; i++) {
//							GameEquipDetail equip = GlobalData.cacheGameEquip
//									.get(i);
//							Map<String, Object> map = new HashMap<String, Object>();
//							map.put("id", equip.getId()); /* 道具模型序号 */
//							map.put("equipname", equip.getEquipname()); /* 道具类型() */
//							map.put("equipurl", equip.getEquipurl());
//							map.put("equiptype", equip.getEquiptype()); /* 资源名称 */
//							map.put("type", equip.getType()); /* 道具说明 */
//							map.put("gongji", equip.getGongji());
//							map.put("fanwei", equip.getFanwei());
//							map.put("sudu", equip.getSudu());
//							map.put("extra", equip.getExtra());
//							map.put("xueliang", equip.getXueliang());
//							map.put("level", equip.getLevel());
//							map.put("flg", equip.getFlag());
//							map.put("isshop", equip.getIsshop());
//							map.put("desc", equip.getDesc());
//							map.put("quality", equip.getQuality());
//							map.put("coin", equip.getCoin());
//							map.put("isstar", equip.getIsstar());
//							map.put("eatequipid", equip.getEatequipid());
//							gameEquipList.add(map);
//							equip = null;
//							map = null;
//						}
//					}
//
//
//
//
//					rlt.put("equip", gameEquipList);
//										itemShopList = null;
//										//break;
//
//
//				//case 7:
//					List<Map<String, Object>> viplist = new ArrayList<Map<String, Object>>();
//					if (!GlobalData.cacheGameVip.isEmpty()) {
//						int size = GlobalData.cacheGameVip.size();
//						for (int i = 0; i < size; i++) {
//							GameVipDetail gamevip = GlobalData.cacheGameVip
//									.get(i);
//							Map<String, Object> map = new HashMap<String, Object>();
//							map.put("id", gamevip.getId());
//							map.put("vipLevel", gamevip.getVipLevel());
//							map.put("vipRmb", gamevip.getVipRmb());
//							map.put("militaryTop", gamevip.getMilitaryTop());
//							map.put("junlingTop", gamevip.getJunlingTop());
//							map.put("backTop", gamevip.getBackTop());
//							map.put("challengTop", gamevip.getChallengTop());
//							map.put("trainTop", gamevip.getTrainTop());
//							map.put("qiangzhengTop", gamevip.getQiangzhengTop());
//							map.put("dhjlTop", gamevip.getDhjlTop());
//							map.put("zjxxTop", gamevip.getZjxxTop());
//							map.put("gjxxTop", gamevip.getGjxxTop());
//							map.put("vipsli", gamevip.getVipsli());
//							map.put("djzmTop", gamevip.getDjzmTop());
//							map.put("zjxlTop", gamevip.getZjxlTop());
//							map.put("yptop", gamevip.getYptop());
//							map.put("missionTop", gamevip.getMissionTop());
//							viplist.add(map);
//							map = null;
//						}
//					}
//					rlt.put("gamevip", viplist);
//					maplist = null;
//					//break;
//				//case 8:
//					List<Map<String, Object>> chlevellist = new ArrayList<Map<String, Object>>();
//					if (!GlobalData.cacheGameChLevel.isEmpty()) {
//						int size = GlobalData.cacheGameChLevel.size();
//						for (int i = 0; i < size; i++) {
//							GameChLevelDetail gamechlevle = GlobalData.cacheGameChLevel
//									.get(i);
//							Map<String, Object> map = new HashMap<String, Object>();
//							map.put("id", gamechlevle.getId());
//							map.put("name", gamechlevle.getName());
//							map.put("level", gamechlevle.getLevel());
//							map.put("gongxun", gamechlevle.getGongxun());
//							map.put("ta", gamechlevle.getTa());
//							map.put("type", gamechlevle.getType());
//					
//							chlevellist.add(map);
//							map = null;
//							gamechlevle = null;
//						}
//					}
//					rlt.put("chlevel", chlevellist);
//					chlevellist = null;
//					//break;
//				//case 10:
//					List<Map<String, Object>> priceMap = new ArrayList<Map<String, Object>>();
//					if (!GlobalData.cacheGamepList.isEmpty()) {
//
//						int size = GlobalData.cacheGamepList.size();
//						Map<String, Object> param = new HashMap<String, Object>();
//						List<ShopdiscountDetail> sp=shopService.getShopdiscount(param);
//	//					System.out.println("month"+sp.get(0).getMonth()+"day"+sp.get(0).getDay()+"monthend"+sp.get(0).getMonth()+"dayend"+sp.get(0).getDayend());
//						
//						for (int i = 0; i < size; i++) {
//							
//							int onsale=0;
//							
//							GamePriceDetail gresp = GlobalData.cacheGamepList
//									.get(i);
//							
//							/****/
//							
//							if(!sp.isEmpty()){
//								//System.out.println("1=====================");
//								Calendar calendar = Calendar.getInstance();
//								int month0 = calendar.get(Calendar.MONTH) + 1;
//								int day0 = calendar.get(Calendar.DAY_OF_MONTH);
//								int month = sp.get(0).getMonth();
//								int day = sp.get(0).getDay();
//								int monthend =sp.get(0).getMonthend();
//								int dayend = sp.get(0).getDayend();
//								if(month0==month&&month0==monthend){
//									if(day0>=day&&day0<=dayend){
//										onsale=gresp.getOnsale();
//									}
//									}else if(month0>=month&&month0<=monthend){
//									onsale=gresp.getOnsale();	
//									}
//								
//									
//							}
//							
//						
//						/****/
//							double x=onsale/10.0;
//							Map<String, Object> map = new HashMap<String, Object>();
//							map.put("id", gresp.getId());
//							map.put("resId", gresp.getResId());
//							map.put("resCost", gresp.getResCost());
//							map.put("resType", gresp.getResType());
//							map.put("costType", gresp.getCostType());
//							map.put("keepTime", gresp.getKeepTime());
//							map.put("discount", x);
//							//System.out.println("道具模型价格打折========="+onsale+"====x===="+x);
//							priceMap.add(map);
//							map = null;
//							gresp = null;
//						}
//						//System.out.println("discount======="+discount);
//					}
//					rlt.put("price", priceMap);
//					
//					priceMap = null;
//					//break;
//				//case 11:
//					List<Map<String, Object>> mlevelList = new ArrayList<Map<String, Object>>();
//					if (!GlobalData.cacheMlevel.isEmpty()) {
//						int size = GlobalData.cacheMlevel.size();
//						for (int i = 0; i < size; i++) {
//							GameMLevelDetail mlevel = GlobalData.cacheMlevel
//									.get(i);
//							Map<String, Object> map = new HashMap<String, Object>();
//							map.put("id", mlevel.getId());
//							map.put("level", mlevel.getLevel());
//							map.put("exp", mlevel.getExp());
//							map.put("xyin", mlevel.getXyin());
//							mlevelList.add(map);
//							map = null;
//							mlevel = null;
//						}
//					}
//					rlt.put("mlevel", mlevelList);
//					mlevelList = null;
//					//break;
//					
//					
//				//case 12:
//					List<Map<String, Object>> insList = new ArrayList<Map<String, Object>>();//装备属性表
//					if (!GlobalData.cacheGameEIns.isEmpty()) {
//						int size = GlobalData.cacheGameEIns.size();
//						for (int i = 0; i < size; i++) {
//							GameEInsDetail ins = GlobalData.cacheGameEIns.get(i);
//						    Map<String, Object> map = new HashMap<String, Object>();
//							map.put("level", ins.getLevel());
//							map.put("price", ins.getPrice());
//							insList .add(map);
//							map = null;
//							ins = null;
//						}
//					}
//					rlt.put("ins", insList  );
//					insList = null;
//					//break;
//					
//				//case 13:
//					List<Map<String, Object>> proList = new ArrayList<Map<String, Object>>();//装备属性表
//					if (!GlobalData.cacheGameEProperty.isEmpty()) {
//						int size = GlobalData.cacheGameEProperty.size();
//						for (int i = 0; i < size; i++) {
//							GameEPropertyDetail pro = GlobalData.cacheGameEProperty.get(i);
//							Map<String, Object> map = new HashMap<String, Object>();
//							map.put("id", pro.getId());
//							map.put("hp", pro.getHp());
//							map.put("speed", pro.getSpeed());
//							map.put("range", pro.getRange());
//							map.put("quality", pro.getQuality());
//							map.put("at", pro.getAttack());
//							map.put("type",pro.getType());
//							proList .add(map);
//							map = null;
//							pro = null;
//						}
//					}
//					rlt.put("pro", proList  );
//					proList = null;
//					//break;	
//				
//				//case 14:
//					List<Map<String, Object>> skillList = new ArrayList<Map<String, Object>>();//技能属性表
//					if (!GlobalData.cacheGameSkill.isEmpty()) {
//						int size = GlobalData.cacheGameSkill.size();
//						for (int i = 0; i < size; i++) {
//							GameSkillDetail skill = GlobalData.cacheGameSkill
//									.get(i);
//							Map<String, Object> map = new HashMap<String, Object>();
//							map.put("id", skill.getId());
//							map.put("skillName", skill.getSkillName());
//							map.put("skillDesc", skill.getSkillDesc());
//							map.put("skillIcon", skill.getSkillIcon());
//							map.put("skillMc", skill.getSkillMc());
//							map.put("skillMcclip", skill.getSkillMcclip());
//							map.put("type",skill.getType());
//							map.put("skillType",skill.getSkillType());
//							map.put("mpcost",skill.getMpcost());
//							map.put("skillCd",skill.getSkillCd());
//							map.put("skillArea",skill.getSkillArea());
//							map.put("skillBuffId",skill.getSkillBuffId());
//							map.put("nameurl",skill.getNameurl());
//							skillList .add(map);
//							map = null;
//							skill = null;
//						}
//					}
//					rlt.put("skill", skillList  );
//					skillList = null;
//					//break;
//				
//				//case 15:
//					List<Map<String, Object>> buffList = new ArrayList<Map<String, Object>>();//属性表
//					if (!GlobalData.cacheGameBuff.isEmpty()) {
//						int size = GlobalData.cacheGameBuff.size();
//						for (int i = 0; i < size; i++) {
//							GameBuffDetail buff = GlobalData.cacheGameBuff.get(i);
//						    Map<String, Object> map = new HashMap<String, Object>();
//							map.put("id", buff.getId());
//							map.put("name", buff.getName());
//							map.put("buffDip", buff.getBuffDip());
//							map.put("type", buff.getType());
//							map.put("buffAlktime", buff.getBuffAtktime());
//							map.put("buffKeeptime", buff.getBuffKeeptime());
//							map.put("atkperson", buff.getAtkperson());
//							map.put("bufftype", buff.getBufftype());
//							map.put("bufftime", buff.getBufftime());		
//							buffList .add(map);
//							map = null;
//							buff = null;
//						}
//					}
//					rlt.put("buff", buffList  );
//					insList = null;
//					//break;
//					
//				
//				//case 9:
//					List<Map<String, Object>> taskList = new ArrayList<Map<String, Object>>();//装备属性表
//					if (!GlobalData.cacheGameTask.isEmpty()) {
//						int size = GlobalData.cacheGameTask.size();
//						for (int i = 0; i < size; i++) {
//							GameTaskDetail task = GlobalData.cacheGameTask.get(i);
//							Map<String, Object> map = new HashMap<String, Object>();
//							map.put("id", task.getId());
//							map.put("taskname", task.getTaskname());
//							map.put("taskdesc", task.getTaskdesc());
//							map.put("tasktype", task.getTasktype());
//							map.put("taskgoal", task.getTaskgoal());
//							map.put("taskcoin", task.getTaskcoin());
//							map.put("gongxun", task.getGongxun());
//							map.put("junling", task.getJunling());
//							map.put("type",task.getType());
//							map.put("exp",task.getExp());
//							String taskres = task.getTaskres();
//							List<Map> tasks = JSON.parseArray(String.valueOf(taskres),
//									Map.class);
//							map.put("taskres",tasks);
//							taskList.add(map);
//							map = null;
//							task = null;
//						}
//					}
//					rlt.put("task", taskList );
//					taskList = null;
//					//break;
//				//case 16:
//					List<Map<String, Object>> gamebingList = new ArrayList<Map<String, Object>>();//兵属性表
//					if (!GlobalData.cacheGameBing.isEmpty()) {
//						int size = GlobalData.cacheGameBing.size();
//						for (int i = 0; i < size; i++) {
//							GameBingDetail task = GlobalData.cacheGameBing.get(i);
//							Map<String, Object> map = new HashMap<String, Object>();
//							map.put("id", task.getId());
//							map.put("name", task.getName());
//							map.put("icon", task.getIcon());
//							map.put("desc", task.getArtdesc());
//							map.put("type", task.getType());
//							map.put("isenemy", task.getIsenemy());
//							map.put("gongji",task.getGongji());
//							map.put("xishu1",task.getXishu1());
//							map.put("xueliang",task.getXueliang());
//							map.put("xishu2",task.getXishu2());
//							map.put("fangyu",task.getFangyu());
//							map.put("gongsu",task.getGongsu());
//							map.put("gongfan",task.getGongfan());
//							map.put("shangfan",task.getShangfan());
//							map.put("sudu",task.getSudu());
//							map.put("renkou", task.getRenkou());
//							map.put("jiage", task.getJiage());
//							map.put("lengque", task.getLengque());
//							map.put("bullet", task.getBullet());
//							map.put("bulletfly", task.getBulletfly());
//							map.put("bullethit", task.getBullethit());
//							map.put("speakdesc", task.getSpeakdesc());
//							map.put("speaktext", task.getSpeaktext());
//							List skill = JSON.parseArray(task.getSkill());
//							map.put("skill", skill);
//							map.put("xtype", task.getXtype());
//							skill=null;
//							List accord=JSON.parseArray(task.getAccord());
//							map.put("gongjun", task.getGongjun());
//							map.put("bingfu", task.getBingfu());
//							map.put("xixue", task.getXixue());
//							map.put("accord",accord );
//							map.put("qty", task.getQty());
//							gamebingList.add(map);
//							map = null;
//							task = null;
//						}
//					}
//					rlt.put("gamebing", gamebingList );
//					gamebingList = null;
//					//break;
//				//case 17:
//					List<Map<String, Object>> gamemisssionList = new ArrayList<Map<String, Object>>();//副本限制属性表
//					if (!GlobalData.cacheGameMission.isEmpty()) {
//						int size = GlobalData.cacheGameMission.size();
//						for (int i = 0; i < size; i++) {
//							GameMissionDetail task = GlobalData.cacheGameMission.get(i);
//							Map<String, Object> map = new HashMap<String, Object>();
//							map.put("id", task.getId());
//							map.put("name", task.getName());
//							map.put("desc",task.getArtdesc());
//							List goal = JSON.parseArray(task.getGoal());
//							map.put("goal",goal);
//							List jiangli = JSON.parseArray(task.getJiangli());
//							map.put("jiangli",jiangli);
//							gamemisssionList.add(map);
//							goal=null;
//							jiangli=null;
//							map = null;
//							task = null;
//						}
//					}
//					rlt.put("mission", gamemisssionList );
//					gamemisssionList = null;
//					//break;
//				//case 18:
//					List<Map<String, Object>> gameBmapList = new ArrayList<Map<String, Object>>();
//					if (!GlobalData.cacheGameBmap.isEmpty()) {
//						int size = GlobalData.cacheGameBmap.size();
//						for (int i = 0; i < size; i++) {
//							GameBmapDetail task = GlobalData.cacheGameBmap.get(i);
//							Map<String, Object> map = new HashMap<String, Object>();
//							map.put("id", task.getId());
//							map.put("name", task.getName());
//							map.put("nandu", task.getNandu());
//						//List chubing = JSON.parseArray(task.getChubing());
//							String chubing=task.getChubing();
//							/****/
//							// ob=chubing;
//							/****/
//							
//							
//							map.put("chubing", chubing);
//							chubing=null;
//							map.put("isagain", task.getIsagain());
//							map.put("startlv", task.getStartlv());
//							map.put("startnum", task.getStartnum());
//							map.put("getexp",task.getGetexp());
//							map.put("getgongxun",task.getGetgongxun());
//							map.put("getyin",task.getGetyin());
//							map.put("dengji", task.getDengji());
//							gameBmapList.add(map);
//							map = null;
//							task = null;
//						}
//					}
//					rlt.put("gamebmap", gameBmapList );
//					gameBmapList = null;
//					//break;
//				
//				//case 19:
//					List<Map<String, Object>> gameBskillList = new ArrayList<Map<String, Object>>();
//					if (!GlobalData.cacheGameBskill.isEmpty()) {
//						int size = GlobalData.cacheGameBskill.size();
//						for (int i = 0; i < size; i++) {
//							GameBskillDetail task = GlobalData.cacheGameBskill.get(i);
//							Map<String, Object> map = new HashMap<String, Object>();
//							map.put("id", task.getId());
//							map.put("name", task.getName());
//							map.put("desc", task.getArtdesc());
//							map.put("type", task.getType());
//							List buffid = JSON.parseArray(task.getBuffid());
//							map.put("buffid", buffid);
//							buffid=null;
//							map.put("target", task.getTarget());
//							map.put("jilv", task.getJilv());
//							map.put("chufa", task.getChufa());
//							map.put("fanwei", task.getFanwei());
//							map.put("shanghai", task.getShanghai());
//							map.put("cishu", task.getCishu());
//							map.put("time", task.getTime());
//							map.put("bullet", task.getBullet());
//							map.put("cd", task.getCd());
//							gameBskillList.add(map);
//							map = null;
//							task = null;
//						}
//					}
//					rlt.put("gamebskill", gameBskillList );
//					gameBskillList = null;
//					//break;
//					
//				//case 20:
//					List<Map<String, Object>> starlist = new ArrayList<Map<String, Object>>();//属性表
//				List<GameStarDetail> gs=(new GameStarServiceImpl()).getallgamestar();
//				if (!gs.isEmpty()) {
//					int size = gs.size();
//					for (int i = 0; i < size; i++) {
//						GameStarDetail star = gs.get(i);
//						Map<String, Object> map = new HashMap<String, Object>();
//						map.put("id", star.getId());
//						map.put("starlevel", star.getStarlevel());
//      		   			map.put("levelexp", star.getLevelexp());
//						map.put("statusadd", star.getStatusadd());
//						map.put("flag", star.getFlag());
//						starlist.add(map);
//						map = null;
//						star = null;
//					}
//				}
//				rlt.put("star", starlist );
//				starlist = null;
//				//break;
//				
//				//case 22:
//					List<Map<String, Object>> totemlist = new ArrayList<Map<String, Object>>();
//				List<GametotemDetail> to=(new GametotemServiceImpl()).getGametotem();
//				if (!to.isEmpty()) {
//					int size = to.size();
//					for (int i = 0; i < size; i++) {
//						GametotemDetail gt = to.get(i);
//						Map<String, Object> map = new HashMap<String, Object>();
//						map.put("id", gt.getId());
//						map.put("name", gt.getName());
//						map.put("type", gt.getType());
//						map.put("level", gt.getLevel());
//						map.put("quality", gt.getQuality());
//						map.put("flag", gt.getFlag());
//						map.put("icon",gt.getIcon());
//						map.put("halo", gt.getHalo());
//						map.put("isshop", gt.getIsshop());
//						map.put("indexs", gt.getIndexs());
//						totemlist.add(map);
//						map = null;
//						gt = null;
//					}
//				}
//				rlt.put("totem", totemlist );
//				starlist = null;
//				//break;
//					
//				//case 21:
//					List<Map<String, Object>> gameBbuffList = new ArrayList<Map<String, Object>>();
//					if (!GlobalData.cacheGameBbuff.isEmpty()) {
//						int size = GlobalData.cacheGameBbuff.size();
//						for (int i = 0; i < size; i++) {
//							GameBbuffDetail task = GlobalData.cacheGameBbuff.get(i);
//							Map<String, Object> map = new HashMap<String, Object>();
//							map.put("id", task.getId());
//							map.put("name", task.getName());
//							map.put("desc", task.getArtdesc());
//							map.put("cishu", task.getCishu());
//							map.put("time", task.getTime());
//							map.put("shanghai", task.getShanghai());
//							map.put("type", task.getType());
//							gameBbuffList.add(map);
//							map = null;
//							task = null;
//						}
//					}
//					rlt.put("gamebbuff", gameBbuffList );
//					gameBbuffList = null;
//					//break;
//				
//				//default:
//					//break;
//				//}
//				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
//				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
//						GameConstants.GAME_API_SUCCESS);
//				ServerHandler.sendData(session, respMap);
//			//}
//		//}
//				long b=System.currentTimeMillis();
//				System.out.println("获取模型信息所用的时间："+(b-a));
//	}
	
}