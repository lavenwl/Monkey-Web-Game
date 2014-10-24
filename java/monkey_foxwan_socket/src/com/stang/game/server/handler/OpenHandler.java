package com.stang.game.server.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.sojo.interchange.json.JsonSerializer;

import org.apache.mina.core.session.IoSession;

import com.alibaba.fastjson.JSON;
import com.stang.game.cache.GlobalData;
import com.stang.game.common.GameConstants;
import com.stang.game.entity.detail.GameEquipDetail;
import com.stang.game.entity.detail.GameItemDetail;
import com.stang.game.entity.detail.GameMilitaryDetail;
import com.stang.game.entity.detail.GameRoleDetail;
import com.stang.game.entity.detail.GameVipDetail;
import com.stang.game.entity.detail.GametotemDetail;
import com.stang.game.entity.detail.RoleEquipDetail;
import com.stang.game.entity.detail.RoleItemDetail;
import com.stang.game.entity.detail.RoleMilitaryDetail;
import com.stang.game.entity.detail.RoletotemDetail;
import com.stang.game.server.ServerHandler;
import com.stang.game.service.IGameEInsService;
import com.stang.game.service.IGameEPropertyService;
import com.stang.game.service.IGameEquipService;
import com.stang.game.service.IGameLevelService;
import com.stang.game.service.IGameVipService;
import com.stang.game.service.IGametotemService;
import com.stang.game.service.IRoleEquipService;
import com.stang.game.service.IRoleItemService;
import com.stang.game.service.IRoleMilitaryService;
import com.stang.game.service.IRoleTavernService;
import com.stang.game.service.IRoletotemService;
import com.stang.game.service.impl.GameEInsServiceImpl;
import com.stang.game.service.impl.GameEPropertyServiceImpl;
import com.stang.game.service.impl.GameEquipServiceImpl;
import com.stang.game.service.impl.GameLevelServiceImpl;
import com.stang.game.service.impl.GameVipServiceImpl;
import com.stang.game.service.impl.GametotemServiceImpl;
import com.stang.game.service.impl.RoleEquipServiceImpl;
import com.stang.game.service.impl.RoleItemServiceImpl;
import com.stang.game.service.impl.RoleMilitaryServiceImpl;
import com.stang.game.service.impl.RoleTavernServiceImpl;
import com.stang.game.service.impl.RoletotemServiceImpl;

public class OpenHandler extends BaseHandler{
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
	private static IRoletotemService roletotemService;
	private IRoletotemService getRoletotemService(){
		if(roletotemService==null){
			roletotemService=new RoletotemServiceImpl();
		}
		return roletotemService;
	}
	private static IGametotemService gametotemService;
	private IGametotemService getGametotemService(){
		if(gametotemService==null){
			gametotemService=new GametotemServiceImpl();
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
	public OpenHandler(String gameApiName, String globalIdentifier,
			String encryptedSignature, String playerId, String cacheKey,
			Map params, IoSession session) {
		super(gameApiName, globalIdentifier, encryptedSignature, playerId, cacheKey,
				params, session);
		if (gameApiName.equals("open.openorcom")) {
			openorcom();
			//TODO
		}
	}

	private void openorcom() {
		//System.out.println("Openhandler.openrcom:param:" +params.toString());
		if (params.containsKey("itemid") && params.containsKey("type")&& params.containsKey("t")&&params.containsKey("nums")) {
			int roleid = Integer.parseInt(playerId);
			int itemid = Integer.parseInt(String.valueOf(params.get("itemid")));// item
			int type = Integer.parseInt(String.valueOf(params.get("type")));// 主类型
			int t = Integer.parseInt(String.valueOf(params.get("t")));//1合成，0打开
			int nums = Integer.parseInt(String.valueOf(params.get("nums")));
			int number = 0;
			if(params.containsKey("number")){
				number = Integer.parseInt(String.valueOf(params.get("number")));
			}
			Map<String, Object> rlt = new HashMap<String, Object>();// 发送数据
		//	System.out.println("itemid:"+itemid);
			int hasNum = 0;
			if(nums==1){//批量打开礼包
				List<GameItemDetail> gameItem = this.getGameItemService().getGameItemById(itemid);
				int itemtype = gameItem.get(0).getItemtype();
				int isuse = gameItem.get(0).getIsuse();
				if (isuse == 1) {//可以打开
					if(itemtype!=5){//不是礼包,不可以打开
						return;
					}
					Map<String, Object> param = new HashMap<String, Object>();
					param.put("itemid", itemid);
					param.put("roleid", roleid);
					List<RoleItemDetail> roleItem = this.getRoleItemService().getRoleItemByitem(param);
					if(roleItem.isEmpty()){
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-1);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,"role没有这个礼包");
						ServerHandler.sendData(session, respMap);
						return;
					}
					List<Map> list = JSONArray.fromObject(gameItem.get(0).getReward());//10
					int size = list.size();
					int[] ary = new int[size];
					int num = 0;
					int nummax = roleItem.get(0).getNum();
					if(number > nummax){
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-11);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,"数量输入不正确");
						ServerHandler.sendData(session, respMap);
						return;
					}
					if(number >= 1){
						num = number;
					} else if (number<1) {
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-11);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,"数量输入不正确");
						ServerHandler.sendData(session, respMap);
						return;
					}
					//System.out.println("num=="+num);
					Random ran = new Random();
					int index = 0;
	//				System.out.println("size:"+size);
					
					if (Integer.parseInt(gameItem.get(0).getItemurl())==1) {// 是神秘礼包,取出一条
						for(int i=0;i<num;i++){
							index = ran.nextInt(size);//假设为5
							ary[index] = ary[index]+1;
						}
					}else{//不是神秘礼包，reward都取出
						for(int i=0;i<size;i++){
							ary[i]=num;
						}
					}
					
					
					//判断背包个字是否已满
					boolean bo = true;
					int id = 0;
					int resType = 0;
					int n = 0;
					int te = 0;
					int a1 = 0;
					int a5 = 0;
					int a6 = 0;
					int a7 = 0;
					List list1 = new ArrayList();
					List list5 = new ArrayList();
					List list6 = new ArrayList();
					List list7 = new ArrayList();
					
					/****/
					if(Integer.parseInt(String.valueOf(list.get(0).get("resType")))==10){
						  JSONArray list2 = new JSONArray();
							Map<String,Object> map = new HashMap<String,Object>();
							for(int i=0;i<num;i++){
								int a=(int) (Math.random()*(list.size()));
								 map.put("id", Integer.parseInt(String.valueOf(list.get(a).get("id"))));
				                 map.put("num", Integer.parseInt(String.valueOf(list.get(a).get("num"))));
				                 map.put("resType", 10);
				                 list2.add(map);
				                 map.clear();
									//图腾的逻辑
									//成功：flag.add(true);         失败：：flag.add(false);
									param.clear();
									param.put("roleid", roleid);
									param.put("totemid", Integer.parseInt(String.valueOf(list.get(a).get("id"))));
									List<RoletotemDetail> to=this.getRoletotemService().getRoletotem(param);
								  if(to.isEmpty()){//插入图腾
									  List<GametotemDetail> gt=this.getGametotemService().getGametotembyid(Integer.parseInt(String.valueOf(list.get(a).get("id"))));
									  RoletotemDetail mo = new RoletotemDetail();
										mo.setRoleid(roleid);
										mo.setType(gt.get(0).getType());
										mo.setLevel(gt.get(0).getLevel());
										mo.setNum(Integer.parseInt(String.valueOf(list.get(a).get("num"))));
										mo.setQuality(gt.get(0).getQuality());
										mo.setTotemid(gt.get(0).getId());
										this.getRoletotemService().insertRoletotem(mo);
										mo=null;  
								  }else{//更新图腾
									  param.clear();
									   param.put("roleid", roleid);
									   param.put("type", to.get(0).getType());
									   param.put("totemid", Integer.parseInt(String.valueOf(list.get(a).get("id"))));
									   param.put("num",Integer.parseInt(String.valueOf(list.get(a).get("num"))));
									   this.getRoletotemService().addRoletotemNum(param);
								  }
								
							}
							rlt.put("reward", list2);
						
						map.put("bid", roleItem.get(0).getId());
						map.put("resType", 5);
						map.put("num", nummax-number);
						map.put("subtype", 10);
						map.put("itemid", itemid);
						rlt.put("package", map);
						map = null;
			//			System.out.println(resType);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,GameConstants.GAME_API_SUCCESS);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
						ServerHandler.sendData(session, respMap);
						
						//减少道具
						param.clear();
						param.put("num", num);
						param.put("roleid", roleid);
						param.put("itemid", itemid);
						this.getRoleItemService().sbRoleItemNum(param);
						param = null;
						rlt = null;
						roleItem = null;
						list = null;
						list2 = null;
						list1 = null;
						list5 = null;
						list6 = null;
						list7 = null;

						return;
					}
					/****/
					
					
					for(int i=0;i<size;i++){//10
						id = Integer.parseInt(String.valueOf(list.get(i).get("id")));
						resType = Integer.parseInt(String.valueOf(list.get(i).get("resType")));
						n = Integer.parseInt(String.valueOf(list.get(i).get("num")));
						n = n * Integer.parseInt(String.valueOf(ary[i]));
					if(resType==5){
							te = resType;
							if(te==1){
								if(!list1.contains(id)){
									list1.add(id);
									a1++;
								}
							}else if(te==5){
								if(!list5.contains(id)){
									list5.add(id);
									a5++;
								}
							}else if(te==6){
								if(!list6.contains(id)){
									list6.add(id);
									a6++;
								}
							}else if(te==7){
								if(!list7.contains(id)){
									list7.add(id);
									a7++;
								}
							}
						}else if(resType==6){
							te = this.getGameEquipService().getGameEquipById(id).get(0).getType();
							bo = getShangxian(te, resType, roleid, id, num);
						}
						if(bo==false){//背包格子不足
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-6);
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,"装备空间不足");
							ServerHandler.sendData(session, respMap);
							return;
						}
//						System.out.println("id:"+id);
					}
//					System.out.println("a1:"+a1+">a5:"+a5+">a6:"+a6+">a7:"+a7);
					if(a1!=0){
						bo = moreopen(1, 5, roleid, 1, a1);
						if(bo==false){
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-6);
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,"道具空间不足");
							ServerHandler.sendData(session, respMap);
							return;
						}
					}
					if(a5!=0){
						//TODO
						bo = moreopen(5, 5, roleid, 15, a5);
						if(bo==false){
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-6);
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,"");
							ServerHandler.sendData(session, respMap);
							return;
						}
					}
					if(a6!=0){
						bo = moreopen(6, 5, roleid, 25, a6);
						if(bo==false){
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-6);
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,"");
							ServerHandler.sendData(session, respMap);
							return;
						}
					}
					if(a7!=0){
						bo = moreopen(7, 5, roleid, 28, a7);
						if(bo==false){
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-6);
							respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,"");
							ServerHandler.sendData(session, respMap);
							return;
						}
					}
					
					
					
					
					
					//减少道具
					param.clear();
					param.put("num", num);
					param.put("roleid", roleid);
					param.put("itemid", itemid);
					this.getRoleItemService().sbRoleItemNum(param);
					//增加更新道具
	//				System.out.println(list);
					JSONArray list2 = new JSONArray();
					int b = 0;
					for(int i=0;i<size;i++){
						b = ary[i];
						if(b==0){
							continue;
						}
						id = Integer.parseInt(String.valueOf(list.get(i).get("id")));
						resType = Integer.parseInt(String.valueOf(list.get(i).get("resType")));
						n = Integer.parseInt(String.valueOf(list.get(i).get("num")));
						n = n * b;
	//					System.out.println("id:"+id+">resType:"+resType+">num:"+n);
						this.getplayerHandler().getItem(roleid, id, n, resType, list2);
					}
					rlt.put("reward", list2);
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("bid", roleItem.get(0).getId());
					map.put("resType", 5);
					map.put("num", nummax-num);
					//map.put("subtype", resType);
					if(type==5){
						map.put("subtype", 5);
						rlt.put("rolecoin", this
								.getGameRoleService()
								.findRoleById(roleid).getYin());
						rlt.put("lqtype", 1);
					}else{
						map.put("subtype", resType);
					}
					map.put("itemid", itemid);
					rlt.put("package", map);
					map = null;
		//			System.out.println(resType);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,GameConstants.GAME_API_SUCCESS);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
					ServerHandler.sendData(session, respMap);
					param = null;
					rlt = null;
					roleItem = null;
					list = null;
					list2 = null;
					list1 = null;
					list5 = null;
					list6 = null;
					list7 = null;
				}else{//不可以打开
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -8);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,"role没有这个礼包");
					ServerHandler.sendData(session, respMap);
				}
				gameItem = null;
				return;
			}
			
			if(((itemid==144)||(itemid==146))&&(t==1)){
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("itemid", itemid);
				param.put("roleid", roleid);
				List<RoleItemDetail> roleitem = this.getRoleItemService().getRoleItemByitem(param);
				if(roleitem.isEmpty()){
					return;
				}
				int num = roleitem.get(0).getNum();
				if(num>=10){//可以合成
					boolean top = this.getplayerHandler().getShangxian(5, 5, roleid, 145, 1);
					if(top==false){//背包格子不足
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-6);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,"道具空间不足");
						ServerHandler.sendData(session, respMap);
						return;
					}
					param.clear();
					param.put("num", 10);
					param.put("roleid", roleid);
					param.put("itemid", itemid);
					boolean bo = this.getRoleItemService().sbRoleItemNum(param);
					if(bo==false){
						return;
					}
					JSONArray list = new JSONArray();
					if(itemid==144){
						this.getplayerHandler().getItem(roleid, 145, 1, 5, list);
					}else if(itemid==146){
						this.getplayerHandler().getItem(roleid, 147, 1, 5, list);
					}
					param.clear();
					param.put("subtype", 5);
					param.put("resType", 5);
					param.put("num", num-10);
					param.put("bid", roleitem.get(0).getId());
					param.put("itemid", itemid);
					rlt.put("package", param);
					rlt.put("rolecoin", this.getGameRoleService().findRoleById(roleid).getYin());
					rlt.put("reward", list);
					rlt.put("lqtype", 1);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
					ServerHandler.sendData(session, respMap);
					list=null;
					rlt=null;
					roleitem=null;
					param=null;
				}else{//数量不足
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-3);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,"礼包数量不足");
					ServerHandler.sendData(session, respMap);
				}
				return;
			}
			
			//System.out.println("type:" + type);
			if (type == 5) {// 若是item表里面
				// gameitem表里边获取道具类型
				//System.out.println("：：：：：：：：：：：：：：礼包id::"+itemid);
				List<GameItemDetail> gameItem = this.getGameItemService().getGameItemById(itemid);
				int itemtype = gameItem.get(0).getItemtype();
				int isuse = gameItem.get(0).getIsuse();
				if (isuse == 1) {//可以打开
					
					// 从roleitem表里面取数据
					Map<String, Object> param = new HashMap<String, Object>();
					param.put("itemid", itemid);
					param.put("roleid", roleid);
					List<RoleItemDetail> roleitem = new ArrayList<RoleItemDetail>();
					roleitem = this.getRoleItemService().getRoleItemByitem(
							param);

					if(roleitem.isEmpty()){
						return;
					}
					Map<String, Object> paraml = new HashMap<String, Object>();// 存放礼包的信息

					int roleitemnum = roleitem.get(0).getNum();

					paraml.put("bid", roleitem.get(0).getId());
//					paraml.put("subtype", roleitem.get(0).getType());
					paraml.put("resType", type);
					paraml.put("itemid", itemid);
					// 找到对应的礼包
					List<GameItemDetail> gameitems = this.getGameItemService()
							.getGameItemById(itemid);
					// 如果是礼包类型
					JSONArray temptask = new JSONArray();
					String task = gameitems.get(0).getReward();
					List<Map> tasks = JSON.parseArray(String.valueOf(task),
							Map.class);
					boolean boo = false;
					if (!roleitem.isEmpty()) {
						//System.out.println("itemtype:" + itemtype);
						if (itemtype == 5) {//宝箱
						//System.out.println("::::::::::::::::::::itemtype == 5) {//宝箱:::::");
							if (roleitem.get(0).getNum() >= 1) {
								// 若是不为空，并且item数量大于1
								// 减少数量
								param.put("num", 1);
			
								// 领取礼包
								
//									if (itemid == 26||itemid==128||itemid==129) {// 是神秘礼包,取出一条
									if (Integer.parseInt(gameitems.get(0).getItemurl())==1) {// 是神秘礼包,取出一条
										//System.out.println(itemid+"itemid神秘礼包==============================================");
										if(itemid!=128){
											//System.out.println(itemid+"itemid神秘礼包2==============================================");
											
											int n = (int) (Math.random() * tasks.size());		
											List<Map> task0 = new ArrayList<Map>();
											task0.add(tasks.get(n));
											Map<String, JSONArray> result = this.getplayerHandler().collect(task0, roleid);
											temptask=result.get("temptask");
											JSONArray flag=result.get("flag");
											if(!flag.contains(false)){//背包空间足
													boo = this.getRoleItemService().sbRoleItemNum(
															param);
													paraml.put("num", this.getRoleItemService().getRoleItemByitem(
															param).get(0).getNum());								
											if (boo == true) {
												paraml.put("subtype", 5);
												rlt.put("package", paraml);
												rlt.put("rolecoin", this
														.getGameRoleService()
														.findRoleById(roleid).getYin());
												rlt.put("reward", temptask);
												rlt.put("lqtype", 1);
												
												respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
														GameConstants.GAME_API_SUCCESS);		
												respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
														rlt);		
												ServerHandler.sendData(session, respMap);
											} else {
												// 不是礼包类型
												respMap.put(
														GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);
												
												respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
												"礼包打开失败");
												ServerHandler.sendData(session, respMap);
											}
													
										}else {//背包空间不足
											respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-6);
											respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
															"背包空间不足");
											ServerHandler.sendData(session, respMap);
										 }
										}else{//128活动礼包
											//判断是否是第6次打开
										//	System.out.println("不会走活动的神秘礼包==============================================");
											
											GameRoleDetail gameRole = this.getGameRoleService().findRoleById(roleid);
											String three = gameRole.getThree();
											Map<String,Object> map = new HashMap<String,Object>();
											if(three.indexOf("6")==-1){//30几率
												if(Math.random()<=0.3){
													if(three.indexOf("1")==-1){
														map.clear();
														map.put("id", roleid);
														map.put("three", this.getGameRoleService().findRoleById(roleid).getThree()+"16");
														this.getGameRoleService().updateRoleVip(map);
													}else if(three.indexOf("2")==-1){
														map.clear();
														map.put("id", roleid);
														map.put("three", this.getGameRoleService().findRoleById(roleid).getThree()+"26");
														this.getGameRoleService().updateRoleVip(map);
													}else if(three.indexOf("6")==-1&&three.indexOf("3")==-1){
														map.clear();
														map.put("id", roleid);
														map.put("three", this.getGameRoleService().findRoleById(roleid).getThree()+"36");
														this.getGameRoleService().updateRoleVip(map);
													}else if(three.indexOf("4")==-1){
														map.clear();
														map.put("id", roleid);
														map.put("three", this.getGameRoleService().findRoleById(roleid).getThree()+"46");
														this.getGameRoleService().updateRoleVip(map);
													}else if(three.indexOf("5")==-1){
														map.clear();
														map.put("id", roleid);
														map.put("three", this.getGameRoleService().findRoleById(roleid).getThree()+"56");
														this.getGameRoleService().updateRoleVip(map);
													}
													//必给一个碎片
													this.getplayerHandler().getItem(roleid, 131, 1, 5, temptask);
													//减少道具
													boo = this.getRoleItemService().sbRoleItemNum(param);
													paraml.put("num", this.getRoleItemService().getRoleItemByitem(
															param).get(0).getNum());
													if (boo == true) {
														paraml.put("subtype", 5);
														rlt.put("package", paraml);
														rlt.put("rolecoin", this
																.getGameRoleService()
																.findRoleById(roleid).getYin());
														rlt.put("reward", temptask);
														rlt.put("lqtype", 1);
														
														respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
																GameConstants.GAME_API_SUCCESS);		
														respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
																rlt);		
														ServerHandler.sendData(session, respMap);
													} else {
														// 不是礼包类型
														respMap.put(
																GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);
														
														respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
														"礼包打开失败");
														ServerHandler.sendData(session, respMap);
													}
												}else{//正常发送
													//标记领取次数
													if(three.indexOf("4")!=-1&&three.indexOf("6")==-1&&three.indexOf("5")==-1){//第三次还没有领取，必发
														map.clear();
														map.put("id", roleid);
														map.put("three", this.getGameRoleService().findRoleById(roleid).getThree()+"56");
														this.getGameRoleService().updateRoleVip(map);
														//判断有没有碎片，没有增加
														this.getplayerHandler().getItem(roleid, 131, 1, 5, temptask);
														//减少道具
														boo = this.getRoleItemService().sbRoleItemNum(param);
														paraml.put("num", this.getRoleItemService().getRoleItemByitem(
																param).get(0).getNum());
														if (boo == true) {
															paraml.put("subtype", 5);
															rlt.put("package", paraml);
															rlt.put("rolecoin", this
																	.getGameRoleService()
																	.findRoleById(roleid).getYin());
															rlt.put("reward", temptask);
															rlt.put("lqtype", 1);
															
															respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
																	GameConstants.GAME_API_SUCCESS);		
															respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
																	rlt);		
															ServerHandler.sendData(session, respMap);
														} else {
															// 不是礼包类型
															respMap.put(
																	GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);
															
															respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
															"礼包打开失败");
															ServerHandler.sendData(session, respMap);
														}
													}else{
														if(three.indexOf("1")==-1){
															map.clear();
															map.put("id", roleid);
															map.put("three", this.getGameRoleService().findRoleById(roleid).getThree()+"1");
															this.getGameRoleService().updateRoleVip(map);
														}else if(three.indexOf("2")==-1){
															map.clear();
															map.put("id", roleid);
															map.put("three", this.getGameRoleService().findRoleById(roleid).getThree()+"2");
															this.getGameRoleService().updateRoleVip(map);
														}else if(three.indexOf("3")==-1){
															map.clear();
															map.put("id", roleid);
															map.put("three", this.getGameRoleService().findRoleById(roleid).getThree()+"3");
															this.getGameRoleService().updateRoleVip(map);
														}else if(three.indexOf("4")==-1){
															map.clear();
															map.put("id", roleid);
															map.put("three", this.getGameRoleService().findRoleById(roleid).getThree()+"4");
															this.getGameRoleService().updateRoleVip(map);
														}else if(three.indexOf("5")==-1){
															map.clear();
															map.put("id", roleid);
															map.put("three", this.getGameRoleService().findRoleById(roleid).getThree()+"5");
															this.getGameRoleService().updateRoleVip(map);
														}

														int n = (int) (Math.random() * tasks.size());		
														List<Map> task0 = new ArrayList<Map>();
														task0.add(tasks.get(n));
														Map<String, JSONArray> result = gethuodong(task0, roleid);
														temptask=result.get("temptask");
														JSONArray flag=result.get("flag");
														if(!flag.contains(false)){//背包空间足
																boo = this.getRoleItemService().sbRoleItemNum(
																		param);
																paraml.put("num", this.getRoleItemService().getRoleItemByitem(
																		param).get(0).getNum());								
														if (boo == true) {
															paraml.put("subtype", 5);
															rlt.put("package", paraml);
															rlt.put("rolecoin", this
																	.getGameRoleService()
																	.findRoleById(roleid).getYin());
															rlt.put("reward", temptask);
															rlt.put("lqtype", 1);
															
															respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
																	GameConstants.GAME_API_SUCCESS);		
															respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
																	rlt);		
															ServerHandler.sendData(session, respMap);
														} else {
															// 不是礼包类型
															respMap.put(
																	GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);
															
															respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
															"礼包打开失败");
															ServerHandler.sendData(session, respMap);
														}
																
													}else {//背包空间不足
														respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-6);
														respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
																		"背包空间不足");
														ServerHandler.sendData(session, respMap);
													 }
													}
												}
											}else{//正常几率
												
												int n = (int) (Math.random() * tasks.size());		
												List<Map> task0 = new ArrayList<Map>();
												task0.add(tasks.get(n));
												Map<String, JSONArray> result = gethuodong(task0, roleid);
												temptask=result.get("temptask");
												JSONArray flag=result.get("flag");
												if(!flag.contains(false)){//背包空间足
														boo = this.getRoleItemService().sbRoleItemNum(
																param);
														paraml.put("num", this.getRoleItemService().getRoleItemByitem(
																param).get(0).getNum());								
												if (boo == true) {
													paraml.put("subtype", 5);
													rlt.put("package", paraml);
													rlt.put("rolecoin", this
															.getGameRoleService()
															.findRoleById(roleid).getYin());
													rlt.put("reward", temptask);
													rlt.put("lqtype", 1);
													
													respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
															GameConstants.GAME_API_SUCCESS);		
													respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
															rlt);		
													ServerHandler.sendData(session, respMap);
												} else {
													// 不是礼包类型
													respMap.put(
															GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);
													
													respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
													"礼包打开失败");
													ServerHandler.sendData(session, respMap);
												}
														
											}else {//背包空间不足
												respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-6);
												respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
																"背包空间不足");
												ServerHandler.sendData(session, respMap);
											 }
												
												
											}
											
										}
										
									} else {//不是神秘礼包
										//System.out.println("=========不是神秘礼包=====================================");
										
										// 写入数据库
										Map<String, JSONArray> result = this.getplayerHandler().collect(tasks, roleid);
										temptask=result.get("temptask");
										JSONArray flag=result.get("flag");
										if(!flag.contains(false)){
											boo = this.getRoleItemService().sbRoleItemNum(
													param);
											paraml.put("num", this.getRoleItemService().getRoleItemByitem(
													param).get(0).getNum());
											if(boo==true){
												paraml.put("subtype", 5);
												rlt.put("package", paraml);
												
												int yuanbao=gameitems.get(0).getYuanbao();
												if(yuanbao!=0){
													Map<String,Object> map = new HashMap<String,Object>();
													map.put("num", yuanbao);
													map.put("flag",5);
													temptask.add(map);
													map=null;
													this.getGameRoleService().addRoleCoin(roleid, yuanbao);
												}
												GameRoleDetail gr = this.getGameRoleService().findRoleById(roleid);
												rlt.put("rolecoin", gr.getYin());
												rlt.put("goldCoin", gr.getCoin());
												gr=null;
												rlt.put("reward", temptask);
												rlt.put("lqtype", 1);
												respMap
														.put(
																GameConstants.GAME_API_RESPONSE_FIELD_CODE,
																GameConstants.GAME_API_SUCCESS);

												respMap
														.put(
																GameConstants.GAME_API_RESPONSE_FIELD_RLT,
																rlt);

												ServerHandler
														.sendData(session, respMap);
												
											}else{

												// 不是礼包类型
												respMap.put(
														GameConstants.GAME_API_RESPONSE_FIELD_CODE,-4);
												
												respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
												"礼包打开失败");
												ServerHandler.sendData(session, respMap);
											
											}
									
									}else{//背包空间不足
										respMap
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
												-6);
								respMap
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_RLT,
												"背包空间不足");
								ServerHandler.sendData(session, respMap);

							
							}}
								
							} else {// 数量不足
								respMap
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
												-3);
								respMap
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_RLT,
												"礼包数量不足");
								ServerHandler.sendData(session, respMap);
							}

						} else if (itemtype == 6) {// 魔将碎片
							//System.out.println("OpenHandler// 魔将碎片");
							if (roleitem.get(0).getNum() >= 10) {
								// 先判断有没有此武将，然后再删除碎片

								// if (boo = true) {
								//判断武将背包格子是否足够
								boolean top = this.getplayerHandler().getShangxian(1, 3, roleid, 1, 1);
								if(top==false){//魔将格子不足
									respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-10);
									respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,"魔将空间不足");
									ServerHandler.sendData(session, respMap);
									return;
								}
								//System.out.println("OPenHanler.itemtype6:" + gameItem.get(0).getItemurl());
								if (Integer.parseInt(gameItem.get(0).getItemurl()) != 1) {// 不是特殊
								
									int id = Integer.parseInt(String
											.valueOf(tasks.get(0).get("id")));
									int num = Integer.parseInt(String
											.valueOf(tasks.get(0).get("num")));
									int typew = Integer.parseInt(String
											.valueOf(tasks.get(0).get("resType")));
									Map<String, Object> params = new HashMap<String, Object>();
									params.put("roleId", roleid);
									params.put("militaryid", id);
									List<RoleMilitaryDetail> lists = this
											.getRoleMilitaryService()
											.getRoleMilitaryByparam(params);
									if (!lists.isEmpty()) {
										respMap
												.put(
														GameConstants.GAME_API_RESPONSE_FIELD_CODE,
														-5);// 你已拥有次武将
										respMap
												.put(
														GameConstants.GAME_API_RESPONSE_FIELD_RLT,
														rlt);
										ServerHandler
												.sendData(session, respMap);
									} else {
										param.put("num", 10);
										boo = this.getRoleItemService()
												.sbRoleItemNum(param);
										if (boo == true) {// 减少成功
											paraml.put("num", roleitemnum - 10);
											Map<String, Object> paramM = new HashMap<String, Object>();
											int mid = this.getAutoIdService()
													.fingKeyValueByTableName(
															"role_military");
											String name = this
													.getGameMilitaryService()
													.getGameMilitaryBymid(id)
													.get(0).getName();
											paramM.put("id", mid);
											paramM.put("militaryid", id);
											paramM.put("name", name);
											paramM.put("roleId", roleid);
											paramM.put("level", 1);
											paramM.put("exp", 0);
											paramM.put("type", 1);
											paramM.put("wuqi", 0);
											paramM.put("huwan", 0);
											paramM.put("yifu", 0);
											paramM.put("types", 1);
											paramM.put("touguan", 0);
											paramM.put("xiezi", 0);
											paramM.put("shipin", 0);
											boolean bo = this
													.getRoleMilitaryService()
													.insertRoleMilitary(paramM);

											if (bo == true) {
//												this
//														.getAutoIdService()
//														.updateKeyValueAddOneByTableName(
//																"role_military");
												List<GameMilitaryDetail> gml = this.getGameMilitaryService().getGameMilitaryBymid(id);
												GameRoleDetail role = this.getGameRoleService().findRoleById(roleid);
												if (gml.get(0).getPingzhi() >= 4) {
													// 系统公告//发送广播
//													String message = "玩家 <font color=\"#FF80FF\">"
//															+ role.getName()
//															+ "</font>"
//															+ role.getVip()
//															+ "通过 <font color=\"#FFFF00\">"
//															+ ("魔将碎片合成 ")
//															+ "</font> 获得了魔将 <font color=\""
//															+ GlobalData.color.get(gml.get(0)
//																	.getPingzhi())
//															+ "\">"
//															+ gml.get(0).getName()
//															+ "</font>";
//													GameConstants.log
//															.warn("PlayerHanlerHandler.buyMilitary:"
//																	+ message);
//													this.getsystemHandler().addMessage(message);
													
													UtilHandler util = new UtilHandler();
													String name2 = role.getName();
													int vip2 = role.getVip();
													String where = "魔将碎片合成";
													int pinzhi = gml.get(0).getPingzhi();
													String goodsName = gml.get(0).getName();
													util.sendGetMessage(name2, vip2, where, pinzhi, goodsName,"open_mojianghecheng");
													
												}
												temptask.add(tasks.get(0));
												paraml.put("subtype", 6);
												rlt.put("package", paraml);
												rlt.put("rolecoin", this
														.getGameRoleService()
														.findRoleById(roleid)
														.getYin());
												rlt.put("reward", paramM);
												respMap
														.put(
																GameConstants.GAME_API_RESPONSE_FIELD_CODE,
																GameConstants.GAME_API_SUCCESS);
												respMap
														.put(
																GameConstants.GAME_API_RESPONSE_FIELD_RLT,
																rlt);
												ServerHandler.sendData(session,
														respMap);
											}
										} else {// 道具减少失败
											respMap
													.put(
															GameConstants.GAME_API_RESPONSE_FIELD_CODE,
															-7);// 道具减少失败
											respMap
													.put(
															GameConstants.GAME_API_RESPONSE_FIELD_RLT,
															rlt);
											ServerHandler.sendData(session,
													respMap);
										}

									}
							
								} else {//
//									int pinzhi = 4;
									int pinzhi= gameItem.get(0).getQuality();
									gameItem=null;
									
									Map<String,Object> map = new HashMap<String,Object>();
									map.put("roleId", roleid);
									map.put("pingzhi", pinzhi);
									List<GameMilitaryDetail> list = this.getGameMilitaryService().getGameMilitaryByparam(map);
									map=null;
									if(!list.isEmpty()){
										int n = (int) (Math.random() * list.size());
										int md = list.get(n).getId();

										param.put("num", 10);
										boolean bod = this.getRoleItemService().sbRoleItemNum(param);
										paraml.put("num", this.getRoleItemService().getRoleItemByitem(param).get(0).getNum());
										if (bod == true) {// 减少道具成功
										Map<String, Object> paramM = new HashMap<String, Object>();
										int mid = this.getAutoIdService()
												.fingKeyValueByTableName(
														"role_military");
										String name = this.getGameMilitaryService().getGameMilitaryBymid(md)
												.get(0).getName();
										paramM.put("id", mid);
										paramM.put("militaryid", md);
										paramM.put("name", name);
										paramM.put("roleId", roleid);
										paramM.put("level", 1);
										paramM.put("exp", 0);
										paramM.put("type", 1);
										paramM.put("wuqi", 0);
										paramM.put("huwan", 0);
										paramM.put("yifu", 0);
										paramM.put("types", 1);
										paramM.put("touguan", 0);
										paramM.put("xiezi", 0);
										paramM.put("shipin", 0);
										boolean bo = this.getRoleMilitaryService().insertRoleMilitary(paramM);
										if (bo == true) {
											//this.getAutoIdService().updateKeyValueAddOneByTableName("role_military");
											// temptask.add(tasks.get(0));
											// rlt.put("military", paramM);
											List<GameMilitaryDetail> gml = this.getGameMilitaryService().getGameMilitaryBymid(md);
											GameRoleDetail role = this.getGameRoleService().findRoleById(roleid);
											if (gml.get(0).getPingzhi() >= 4) {
												// 系统公告//发送广播
//												String message = "玩家 <font color=\"#FF80FF\">"
//														+ role.getName()
//														+ "</font>"
//														+ role.getVip()
//														+ "通过 <font color=\"#FFFF00\">"
//														+ ("魔将碎片合成 ")
//														+ "</font> 获得了魔将 <font color=\""
//														+ GlobalData.color.get(gml.get(0)
//																.getPingzhi())
//														+ "\">"
//														+ gml.get(0).getName()
//														+ "</font>";
//												GameConstants.log
//														.warn("PlayerHanlerHandler.buyMilitary:"
//																+ message);
//												this.getsystemHandler().addMessage(message);
												
												UtilHandler util = new UtilHandler();
												String name2 = role.getName();
												int vip2 = role.getVip();
												String where = "魔将碎片合成";
												String goodsName = gml.get(0).getName();
												util.sendGetMessage(name2, vip2, where, pinzhi, goodsName,"open_mojianghecheng");
												
											}
											paraml.put("subtype", 6);
											rlt.put("package", paraml);
											rlt.put("rolecoin", this
													.getGameRoleService()
													.findRoleById(roleid)
													.getYin());
											rlt.put("reward", paramM);
											paramM=null;
											respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
															GameConstants.GAME_API_SUCCESS);
											respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
											ServerHandler.sendData(session,respMap);
										}
									} else {// 道具减少失败
										respMap
												.put(
														GameConstants.GAME_API_RESPONSE_FIELD_CODE,
														-7);
										respMap
												.put(
														GameConstants.GAME_API_RESPONSE_FIELD_RLT,
														"道具减少失败");
										ServerHandler.sendData(session, respMap);
									}
								
										list =null;
									}else{// 你已拥有所有此品质的武将
										respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-9);									
										respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
										"礼包数量不足");													
										ServerHandler.sendData(session,respMap);
										return;
									}

								}

							} else {// 数量不足
								respMap
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
												-3);
								respMap
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_RLT,
												"礼包数量不足");
								ServerHandler.sendData(session, respMap);
							}

						} else if (itemtype == 7) {// 武器碎片
							int id = Integer.parseInt(String
									.valueOf(tasks.get(0).get("id")));
							int num = Integer.parseInt(String
									.valueOf(tasks.get(0).get("num")));
							int typew = Integer.parseInt(String
									.valueOf(tasks.get(0).get("resType")));
							if (roleitem.get(0).getNum() >= 10) {
								Map<String, JSONArray> result=this.getplayerHandler().collect(tasks, roleid);
								JSONArray flag=result.get("flag");
								if(!flag.contains(false)){
									param.put("num", 10);
									boo = this.getRoleItemService().sbRoleItemNum(
											param);
									paraml.put("num", roleitemnum - 10);
								}else{//背包格子不足
									respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-6);
									respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,"背包空间不足");
									ServerHandler.sendData(session, respMap);
									return;
								}
								//System.out.println("OPnehandler,Gameitem id:" + id);
								List<GameEquipDetail> rel = this.getGameEquipService().getGameEquipById(id);
								GameRoleDetail role = this.getGameRoleService().findRoleById(roleid);
								if (rel.get(0).getQuality() >= 4) {
									// 系统公告//发送广播
//									String message = "玩家 <font color=\"#FF80FF\">"
//											+ role.getName()
//											+ "</font>"
//											+ role.getVip()
//											+ "通过 <font color=\"#FFFF00\">"
//											+ ("装备碎片合成 ")
//											+ "</font> 获得了装备 <font color=\""
//											+ GlobalData.color.get(rel.get(0).getQuality())
//											+ "\">"
//											+ rel.get(0).getEquipname()
//											+ "</font>";
//									GameConstants.log
//											.warn("OpenHandler.orcom:"
//													+ message);
//									this.getsystemHandler().addMessage(message);
									
									UtilHandler util = new UtilHandler();
									String name2 = role.getName();
									int vip2 = role.getVip();
									String where = "装备碎片合成";
									int pinzhi = rel.get(0).getQuality();
									String goodsName = rel.get(0).getEquipname();
									util.sendGetMessage(name2, vip2, where, pinzhi, goodsName,"open_suipianhecheng");
								}
								temptask = result.get("temptask");
								paraml.put("subtype", 7);
								rlt.put("package", paraml);
								rlt.put("rolecoin", this
										.getGameRoleService().findRoleById(
												roleid).getYin());
								rlt.put("reward", temptask);

								respMap
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
												GameConstants.GAME_API_SUCCESS);

								respMap
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_RLT,
												rlt);

								ServerHandler.sendData(session, respMap);

							

							} else {// 数量不足
								respMap
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
												-3);
								respMap
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_RLT,
												"礼包数量不足");
								ServerHandler.sendData(session, respMap);
							}

						} else if (itemtype == 8) {// 收集品

						} else if (itemtype == 1) {// 普通道具
							if (roleitem.get(0).getNum() >= 1) {
									if (itemid == 12 || itemid == 13||itemid==73) {//
										//判断武将背包格子是否足够
										boolean top = this.getplayerHandler().getShangxian(1, 3, roleid, 1, 1);
										if(top==false){//魔将格子不足
											respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-10);
											respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,"魔将格子不足");
											ServerHandler.sendData(session, respMap);
											return;
										}
										int pinzhi = 0;
										if (itemid == 12) {
											pinzhi = 3;
											// 查询用户拥有的这种武将跟模型表中的武将
										} else if(itemid==13) {
											pinzhi = 4;
										}else {
											pinzhi = 5;
										}
										
										Map<String,Object> map = new HashMap<String,Object>();
										map.put("roleId", roleid);
										map.put("pingzhi", pinzhi);
										List<GameMilitaryDetail> list = this.getGameMilitaryService().getGameMilitaryByparam(map);
										map=null;
										if(!list.isEmpty()){
											int n = (int) (Math.random() * list.size());
											int md = list.get(n).getId();
											list=null;
											param.put("num", 1);
											boolean bod = this.getRoleItemService().sbRoleItemNum(param);
											paraml.put("num", this.getRoleItemService().getRoleItemByitem(param).get(0).getNum());
											if (bod == true) {// 减少道具成功
											
											Map<String, Object> paramM = new HashMap<String, Object>();
											int mid = this.getAutoIdService().fingKeyValueByTableName("role_military");
											String name = this.getGameMilitaryService().getGameMilitaryBymid(md).get(0).getName();
											paramM.put("id", mid);
											paramM.put("militaryid", md);
											paramM.put("name", name);
											paramM.put("roleId", roleid);
											paramM.put("level", 1);
											paramM.put("exp", 0);
											paramM.put("type", 1);
											paramM.put("wuqi", 0);
											paramM.put("huwan", 0);
											paramM.put("yifu", 0);
											paramM.put("types", 1);
											paramM.put("touguan", 0);
											paramM.put("xiezi", 0);
											paramM.put("shipin", 0);
											boolean bo = this.getRoleMilitaryService().insertRoleMilitary(paramM);

											if (bo == true) {
												//this.getAutoIdService().updateKeyValueAddOneByTableName("role_military");
												// temptask.add(tasks.get(0));
												// rlt.put("military", paramM);
												List<GameMilitaryDetail> gml = this.getGameMilitaryService().getGameMilitaryBymid(md);
												GameRoleDetail role = this.getGameRoleService().findRoleById(roleid);
												if (gml.get(0).getPingzhi() >= 4) {
													// 系统公告//发送广播
//													String message = "玩家 <font color=\"#FF80FF\">"
//															+ role.getName()
//															+ "</font>"
//															+ role.getVip()
//															+ "通过 <font color=\"#FFFF00\">"
//															+ ("魔将卡 ")
//															+ "</font> 获得了魔将 <font color=\""
//															+ GlobalData.color.get(gml.get(0)
//																	.getPingzhi())
//															+ "\">"
//															+ gml.get(0).getName()
//															+ "</font>";
//													GameConstants.log
//															.warn("PlayerHanlerHandler.buyMilitary:"
//																	+ message);
//													this.getsystemHandler().addMessage(message);
													UtilHandler util = new UtilHandler();
													String name2 = role.getName();
													int vip2 = role.getVip();
													String where = "魔将卡";
													String goodsName = gml.get(0).getName();
													util.sendGetMessage(name2, vip2, where, pinzhi, goodsName,"open_魔将卡");
												}
												paraml.put("subtype", 1);
												rlt.put("package", paraml);
												rlt.put("rolecoin", this.getGameRoleService().findRoleById(roleid).getYin());
												rlt.put("reward", paramM);
												respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
																GameConstants.GAME_API_SUCCESS);
												respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,rlt);
												ServerHandler.sendData(session,respMap);
												paramM=null;
												rlt=null;
											}
										} else {// 道具减少失败
											respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-7);
											respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,"道具减少失败");
											ServerHandler.sendData(session, respMap);
											return;
										}
										}else{// 你已拥有所有此品质的武将
											respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,-9);									
											respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
											"礼包数量不足");													
											ServerHandler.sendData(session,respMap);
											return;
										}
									} else {
										// 减少道具成功，增加银币
										param.put("num", 1);
										boolean bod = this.getRoleItemService().sbRoleItemNum(param);
										if (bod == true) {// 减少道具成功
											paraml.put("num", this.getRoleItemService().getRoleItemByitem(param).get(0).getNum());
										int coin = Integer.parseInt(String
												.valueOf(tasks.get(0)
														.get("num")));
										boolean bo = this.getGameRoleService()
												.addRoleYin(roleid, coin);
										if (bo == true) {
											tasks.get(0).put("flag", 1);
											temptask.add(tasks.get(0));
											paraml.put("subtype", 1);
											rlt.put("package", paraml);
											rlt.put("rolecoin", this
													.getGameRoleService()
													.findRoleById(roleid)
													.getYin());
											rlt.put("reward", temptask);
											respMap
													.put(
															GameConstants.GAME_API_RESPONSE_FIELD_CODE,
															GameConstants.GAME_API_SUCCESS);
											respMap
													.put(
															GameConstants.GAME_API_RESPONSE_FIELD_RLT,
															rlt);

											ServerHandler.sendData(session,
													respMap);
										}
									}else{// 道具减少失败
										respMap
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
												-7);
								respMap
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_RLT,
												"道具减少失败");
								ServerHandler.sendData(session, respMap);
							}
									}

//								
							} else {// 数量不足
								respMap
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
												-3);
								respMap
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_RLT,
												"数量不足");
								ServerHandler.sendData(session, respMap);
							}

						} else {
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									-2);
							respMap.put(
									GameConstants.GAME_API_RESPONSE_FIELD_RLT,
									"没有这种类型的礼包");
							ServerHandler.sendData(session, respMap);
						}
					} else {
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								-1);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
								"role没有这个礼包");
						ServerHandler.sendData(session, respMap);
					}
				} else {// 物品不可以被打开
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -8);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
							"role没有这个礼包");
					ServerHandler.sendData(session, respMap);
				}
			}// 若是道具类型
		}
	}

	public Map<String, JSONArray> gethuodong(List<Map> tasks, int roleid) {// 领取礼包
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
			if (type == 5) {
				int subtype = this.getGameItemService().getGameItemById(id)
						.get(0).getItemtype();
				boolean b = this.getplayerHandler().getShangxian(subtype, type, roleid, id, num);
				flag.add(b);
				//判断是否获得特定的碎片
				if(id==131){
					Map<String,Object> param = new HashMap<String,Object>();
					param.put("id", roleid);
					param.put("three", this.getGameRoleService().findRoleById(roleid).getThree()+"6");
					this.getGameRoleService().updateRoleVip(param);
					param=null;
				}
			} else if (type == 6) {
				int subtype = this.getGameEquipService().getGameEquipByEid(id)
						.get(0).getType();
				// type :子类型 resType:主类型 roleId:人物id id:物品
				boolean b0 = this.getplayerHandler().getShangxian(subtype, type, roleid, id, num);
				flag.add(b0);
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
//						int bid = this.getAutoIdService()
//								.fingKeyValueByTableName("role_item") + 1;
						long bid = this.getAutoIdService()
						.fingKeyValueByTableName("role_item") + 0L;
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
//						this.getAutoIdService()
//								.updateKeyValueAddOneByTableName("role_item");

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
						int bid = this.getAutoIdService().fingKeyValueByTableName("role_equip");
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
//						this.getAutoIdService()
//								.updateKeyValueAddOneByTableName("role_equip");
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

				} else {// 礼物不存在
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "");
					ServerHandler.sendData(session, respMap);
				}
			}
		}
		back.put("temptask", temptask);
		back.put("flag", flag);
		return back;
	}
	
	/**
	 * 批量打开礼包上线
	 * @param type
	 * @param resType
	 * 
	 * @param roleId
	 * @param id
	 * @param num
	 */
//te = this.getGameEquipService().getGameEquipById(id).get(0).getType();
//	bo = moreopen(te, resType, roleid, id, n);
	boolean moreopen(int type, int resType, int roleId, int id, int num){
		boolean boo = false;
		int vip = this.getGameRoleService().findRoleById(roleId).getVip();// 查看vip等级
		//黄钻享受vip2待遇
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
		GameVipDetail gvip = this.getGameVipService().getGameVipByLe(vip)
				.get(0);// 得到vip 等级下的各种上限
		int backTop = gvip.getBackTop();// 背包上限
		Map<String, Object> param = new HashMap<String, Object>();
		List<RoleItemDetail> list1 = null;
		if (type == 5) {
			if(resType==1){//道具
				param.clear();
				param.put("roleid", roleId);
				param.put("type", resType);
				list1 = this.getRoleItemService().getRoleItem(param);
				int isUseItem = 0;
				for (int i = 0; i < list1.size(); i++) {
					if(list1.get(i).getNum()!=0){
						isUseItem++;
					}
				}
				if(isUseItem+num<=backTop){
					boo = true;
				}else{
					boo = false;
					return boo;
				}
			}else if(resType==5){//礼包
				param.clear();
				param.put("roleid", roleId);
				param.put("type", resType);
				list1 = this.getRoleItemService().getRoleItem(param);
				int isUseItem = 0;
				for (int i = 0; i < list1.size(); i++) {
					if(list1.get(i).getNum()!=0){
						isUseItem++;
					}
				}
				if(isUseItem+num<=backTop){
					boo = true;
				}else{
					boo = false;
					return boo;
				}
			}else if(resType==6){//装备碎片
				param.clear();
				param.put("roleid", roleId);
				param.put("type", resType);
				list1 = this.getRoleItemService().getRoleItem(param);
				int isUseItem = 0;
				for (int i = 0; i < list1.size(); i++) {
					if(list1.get(i).getNum()!=0){
						isUseItem++;
					}
				}
				if(isUseItem+num<=backTop){
					boo = true;
				}else{
					boo = false;
					return boo;
				}
			}else if(resType==7){//武将碎片
				param.clear();
				param.put("roleid", roleId);
				param.put("type", type);
				list1 = this.getRoleItemService().getRoleItem(param);
				int isUseItem = 0;
				for (int i = 0; i < list1.size(); i++) {
					if(list1.get(i).getNum()!=0){
						isUseItem++;
					}
				}
				if(isUseItem+num<=backTop){
					boo = true;
				}else{
					boo = false;
					return boo;
				}
			}
			list1 = null;
		} else if (type == 6) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("roleId", roleId);
//			params.put("itemid", id);
//			 params.put("type", type);
			List<RoleEquipDetail> lists = this.getRoleEquipService().getRoleEquipUser(params);// 查看这种类型有几个是否到了上线；
			int isUseItem = 0;
			for (int i = 0; i < lists.size(); i++) {
				if(lists.get(i).getFlag()==1&&Integer.valueOf(lists.get(i).getUser())==0){
					isUseItem++;
				}
			}
			if (backTop - num >= isUseItem) {// 判断 是否超出上限
				boo = true;
			} else {
				boo = false;
			}
		}else if (type==3){//武将背包格子是否足够
			int top = gvip.getMilitaryTop();
			param.clear();
			param.put("roleId", roleId);
			List<RoleMilitaryDetail> militarys = this.getRoleMilitaryService().getRoleMilitaryByparam(param);
			//System.out.println("该用户有"+militarys.size()+"个魔将");
			if(militarys.isEmpty()){
				boo = true;
			}else{
				if(militarys.size()<top){
					boo = true;
				}else{
					boo = false;
				}
			}
		}
		return boo;
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
}
