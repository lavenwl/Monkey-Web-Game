package com.stang.game.server.handler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.sojo.interchange.json.JsonSerializer;

import org.apache.mina.core.session.IoSession;

import com.alibaba.fastjson.JSON;
import com.stang.game.common.GameConstants;
import com.stang.game.entity.GameRole;
import com.stang.game.entity.detail.GameRoleDetail;
import com.stang.game.entity.detail.GameTaskDetail;
import com.stang.game.entity.detail.GameVipDetail;
import com.stang.game.entity.detail.RoleBingDetail;
import com.stang.game.entity.detail.RoleEquipDetail;
import com.stang.game.entity.detail.RoleItemDetail;
import com.stang.game.entity.detail.RoleMapDetail;
import com.stang.game.entity.detail.RoleMilitaryDetail;
import com.stang.game.entity.detail.RoleTaskDetail;
import com.stang.game.entity.detail.RoleTaskTaskDetail;
import com.stang.game.entity.detail.RoleTavernDetail;
import com.stang.game.server.ServerHandler;
import com.stang.game.service.IGameVipService;
import com.stang.game.service.IRoleEquipService;
import com.stang.game.service.IRoleItemService;
import com.stang.game.service.IRoleMapService;
import com.stang.game.service.IRoleMilitaryService;
import com.stang.game.service.IRoleTaskTaskService;
import com.stang.game.service.IRoleTavernService;
import com.stang.game.service.impl.GameVipServiceImpl;
import com.stang.game.service.impl.RoleEquipServiceImpl;
import com.stang.game.service.impl.RoleItemServiceImpl;
import com.stang.game.service.impl.RoleMapServiceImpl;
import com.stang.game.service.impl.RoleMilitaryServiceImpl;
import com.stang.game.service.impl.RoleTaskTaskServiceImpl;
import com.stang.game.service.impl.RoleTavernServiceImpl;

public class TaskHandler extends BaseHandler {
	static private PlayerHandler playerHandler;

	private PlayerHandler getplayerHandler() {
		if (playerHandler == null) {
			playerHandler = new PlayerHandler(gameApiName, globalIdentifier,
					encryptedSignature, playerId, cacheKey, params, session);
		}
		return playerHandler;
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

	public TaskHandler(String gameApiName, String globalIdentifier,
			String encryptedSignature, String playerId, String cacheKey,
			Map params, IoSession session) {
		super(gameApiName, globalIdentifier, encryptedSignature, playerId,
				cacheKey, params, session);
		if (gameApiName.equals("tas.opentask")) {
			/** 打开任务列表 */
			opentask();
		} else if (gameApiName.equals("tas.complete")) {
			/** 完成并领取奖励 */
			complete();
		}else if (gameApiName.equals("tas.openvip")) {
			/** 打开vip界面，可领取礼包等级 */
			openvip();
		}else if(gameApiName.equals("tas.vip_gift_desk")){
			/**打开vip每日领取礼包界面*/
			vip_gift_desk();
		}else if(gameApiName.equals("tas.vip_per_pacakage")){
			vip_per_package();
		}
	}

	private void vip_gift_desk() {
		Map<String, Object> rlt = new HashMap<String, Object>();
		int roleid = Integer.parseInt(playerId);
		GameRoleDetail gamerole = this.getGameRoleService().findRoleById(roleid);
		List<RoleTaskTaskDetail> list = this.getRoleTaskTaskService().findRoleTask(roleid);
		int[] role_task = getRoleTask(list);
		if(gamerole!=null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			int vip = gamerole.getVip();
			int coinspend = gamerole.getCoinspend();
			String viptime = gamerole.getVipTime();
			String vipgift = gamerole.getVipGift();
			String now = sdf.format(new Date());
			String vipPackage = "";
			long diff = 0;
			if(vip != 0){
				String str_vip = getVipString(vip);
				if(vipgift_check(vipgift, vip)){
					vipPackage = getVipString(vipgift, vip);
				}else{
					Map<String, Object> param = new HashMap<String, Object>();
					vipgift = str_vip;
					SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
					long diff1 = 0;
					try {
						diff1 = sdf.parse(now).getTime() - sdf.parse(viptime).getTime();
					} catch (ParseException e) {
						e.printStackTrace();
					}
					diff1 = diff1 + 1000*60*60*24 + 500;
					viptime = sdf2.format(diff1);
					param.put("id", roleid);
					param.put("vipgift", vipgift);
					param.put("viptime", viptime);
					boolean boq = this.getGameRoleService().updateRoleVipGiftTime(param);
				}
				try {
					diff = sdf.parse(now).getTime() - sdf.parse(viptime).getTime();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				//判断时间确定是否已经领取
				if(diff > 0){
					 str_vip = getVipString(vip);
					//判断vipGift确定当日vip是否有过变更
					if(vipgift.equals(str_vip)){
						//vip没变化，正常领取礼包
						vipPackage = String.valueOf(vip);
					}else{
						//vip当日有变化，实行特定逻辑
						SimpleDateFormat sdf11 = new SimpleDateFormat("yyyy-MM-dd");
						String today = sdf11.format(new Date());
						long newcharge = 0;
						try {
							newcharge = sdf.parse(viptime).getTime() - sdf11.parse(today).getTime();
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						long diffd = diff/(1000*24*60*60);
						//判断时间是否大于一天判断之前变动的vip礼包是否全部领取
						if(newcharge<0){
							//vip充值大于一天，正常执行
							vipPackage = String .valueOf(vip);
						}else{
							//vip当天充值，可以领取多个礼包
							if(vipgift_check(vipgift, vip)){
								vipPackage = getVipString(vipgift, vip);
							}else{
								Map<String, Object> param = new HashMap<String, Object>();
								vipgift = str_vip;
								SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
								long diff1 = 0;
								try {
									 diff1 =sdf1.parse(now).getTime();
								} catch (ParseException e) {
									e.printStackTrace();
								}
								diff1 = diff1 + 1000*60*60*24 + 500;
								viptime = sdf2.format(diff1);
								param.put("id", roleid);
								param.put("vipgift", vipgift);
								param.put("viptime", viptime);
								boolean boq = this.getGameRoleService().updateRoleVipGiftTime(param);
							}
						}
					}
					if(vipPackage.endsWith("10")){
						vipPackage = vipPackage.substring(0, vipPackage.indexOf("0")-1);
						vipPackage = vipPackage + "d";
					}
					rlt.put("vip", vip);
					rlt.put("giftpackage", vipPackage);
					rlt.put("expeirence", coinspend);
					rlt.put("taskId", role_task);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				}else{
					rlt.put("vip", vip);
					rlt.put("giftpackage", 0);
					rlt.put("expeirence", coinspend);
					rlt.put("taskId", role_task);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				}
			}else{
				rlt.put("vip", vip);
				rlt.put("giftpackage", 0);
				rlt.put("expeirence", coinspend);
				rlt.put("taskId", role_task);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			}
		}
		ServerHandler.sendData(session, respMap);
	}
	
	private void vip_per_package() {
		Map<String, Object> rlt = new HashMap<String, Object>();
		int roleid = Integer.parseInt(playerId);
		String pi = String.valueOf(params.get("t"));
		int packageindex =Integer.parseInt(pi);//礼包的序列号
		int id = 133 + packageindex;
		GameRoleDetail gamerole = this.getGameRoleService().findRoleById(roleid);
		if(gamerole!=null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			int vip = gamerole.getVip();
			int coinspend = gamerole.getCoinspend();
			String viptime = gamerole.getVipTime();
			String vipgift = gamerole.getVipGift();
			String now = sdf.format(new Date());
	//		System.out.println("数据库读取的（viptime）:" + viptime);
	//		System.out.println("数据库读取的（vipgift）:" + vipgift);
			String vipPackage = "";
			//System.out.println("判断vip等级与领取礼包：vip:" + vip + "  packageindex:" + packageindex);
			//GameConstants.log.warn("判断vip等级与领取礼包：vip:" + vip + "  packageindex:" + packageindex);
			if(vip >= packageindex){
				if(vip != 0 && vip != 1){
					long diff = 0;
					try {
						diff = sdf.parse(now).getTime() - sdf.parse(viptime).getTime();
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		//			System.out.println("判断时间，确定是否已经领取(diff=)：" + diff);
					//判断时间确定是否已经领取
					if(diff > 0){
		//				System.out.println("判断时间通过进入逻辑处理！");
						String str_vip = getVipString(vip);
						//得到vip相应礼包
						String reward = this.getGameItemService().getGameItemById(id).get(0).getReward();
						List<Map> resList = JSON.parseArray(String.valueOf(reward),Map.class);
						JSONArray list = new JSONArray();// 用list<map>type=6会报错
						//判断vipGift确定当日vip是否有过变更
		//				System.out.println("判断vip是否变动：" + vipgift + "是否等于" + str_vip);
						if(vipgift.equals(str_vip)){
		//					System.out.println("走到了第一条路！一条路！一条路！一条路！一条路！一条路！一条路！一条路！一条路！");
							//vip没变化，正常领取礼包
							for (int i = 0; i < resList.size(); i++) {
								Map map = resList.get(i);
								int type = Integer.parseInt(String.valueOf(map.get("resType")));
								int jianglidaoju_id = Integer.parseInt(String.valueOf(map.get("id")));
								int num = Integer.parseInt(String.valueOf(map.get("num")));
								Map<String, Object> params = new HashMap<String, Object>();
								if (type == 5) {// 道具
									params.clear();
									params.put("roleid", roleid);
									params.put("itemid", jianglidaoju_id);
									List<RoleItemDetail> item = this.getRoleItemService().getRoleItem(params);
									params.put("num", num);// 获得数量
									params.put("resType", type);
									// 判断背包格子是否已满
									int itemtype = this.getGameItemService().getGameItemById(id).get(0).getItemtype();
									boolean boo = this.getShangxian(itemtype, type, roleid, jianglidaoju_id, num);
									if (boo == false) {// 背包格子不足
										rlt.put("reward", list);
										respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);
										respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "道具空间不足");
										ServerHandler.sendData(session, respMap);
										return;
									}
									if (!item.isEmpty()) {// 已存在
										boolean bo = this.getRoleItemService().addRoleItemNum(params);
										if (bo == true) {
											long bid = item.get(0).getId();
											params.put("bid", bid);
											params.put("id", jianglidaoju_id);
											params.remove("roleid");
											params.remove("itemid");
											list.add(params);
										} else {

										}
									} else {// 不存在，
//										int bid = this.getAutoIdService()
//												.fingKeyValueByTableName("role_item") + 1;
										long bid = this.getAutoIdService()
										.fingKeyValueByTableName("role_item");
								
										RoleItemDetail iDetail = new RoleItemDetail();
										iDetail.setId(bid);
										iDetail.setRoleid(roleid);
										iDetail.setItemid(jianglidaoju_id);
										iDetail.setNum(num);
										iDetail.setFlag(1);
										iDetail.setType(itemtype);
										boolean bo = this.getRoleItemService()
												.insertRoleItem(iDetail);
//										this.getAutoIdService()
//												.updateKeyValueAddOneByTableName(
//														"role_item");
										if (bo == true) {
											params.put("bid", bid);
											params.remove("roleid");
											params.put("id", jianglidaoju_id);
											params.remove("itemid");
											list.add(params);

										}
									}
								}
							}
							vipPackage = String.valueOf(0);
							//更改时间，已经领取。
							SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
							long diff1 = 0;
							try {
								 diff1 =sdf1.parse(now).getTime();
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							diff1 = diff1 + 1000*60*60*24 + 500;
						//	diff1 = diff1 + 1000*60*60*9 + 1000*60*45;

							viptime = sdf2.format(diff1);
							Map<String, Object> param = new HashMap<String, Object>();
							param.put("id", roleid);
							param.put("vipgift", vipgift);
							param.put("viptime", viptime);
							boolean bo = this.getGameRoleService().updateRoleVipGiftTime(param);
//							System.out.println("写入数据库的（viptime）:" + viptime);
//							System.out.println("写入数据库的（vipgift）:" + vipgift);
//							System.out.println("taskHandler.changetime(334):" + bo);
						}else{
							//vip当日有变化，实行特定逻辑
							long diffd = diff/(1000*24*60*60);
							//判断时间是否大于一天判断之前变动的vip礼包是否全部领取
							
							
							SimpleDateFormat sdf11 = new SimpleDateFormat("yyyy-MM-dd");
							String today = sdf11.format(new Date());
//							System.out.println("today:" + today);
							long newcharge = 0;
							try {
								newcharge = sdf.parse(viptime).getTime() - sdf11.parse(today).getTime();
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
			//				System.out.println("newcharge:" + newcharge);
							
							
							
							
			//				System.out.println("判断是否大于一天diffd是否大于1：" + diffd);
							//if(diffd>=1){
							if(newcharge<0){
			//					System.out.println("走到了第二条路！二条路！二条路！二条路！二条路！二条路！二条路！二条路！二条路！");
								//vip充值大于一天，正常执行
								for (int i = 0; i < resList.size(); i++) {
									Map map = resList.get(i);
									int type = Integer.parseInt(String.valueOf(map.get("resType")));
									int jianglidaoju_id = Integer.parseInt(String.valueOf(map.get("id")));
									int num = Integer.parseInt(String.valueOf(map.get("num")));
									Map<String, Object> params = new HashMap<String, Object>();
									if (type == 5) {// 道具
										params.clear();
										params.put("roleid", roleid);
										params.put("itemid", jianglidaoju_id);
										List<RoleItemDetail> item = this.getRoleItemService().getRoleItem(params);
										params.put("num", num);// 获得数量
										params.put("resType", type);
										// 判断背包格子是否已满
										int itemtype = this.getGameItemService().getGameItemById(id).get(0).getItemtype();
										boolean boo = this.getShangxian(itemtype, type, roleid, jianglidaoju_id, num);
										if (boo == false) {// 背包格子不足
											rlt.put("reward", list);
											respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);
											respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "道具空间不足");
											ServerHandler.sendData(session, respMap);
											return;
										}
										if (!item.isEmpty()) {// 已存在
											boolean bo = this.getRoleItemService().addRoleItemNum(params);
											if (bo == true) {
												long bid = item.get(0).getId();
												params.put("bid", bid);
												params.put("id", jianglidaoju_id);
												params.remove("roleid");
												params.remove("itemid");
												list.add(params);
											} else {

											}
										} else {// 不存在，
//											int bid = this.getAutoIdService()
//													.fingKeyValueByTableName("role_item") + 1;
											long bid = this.getAutoIdService()
											.fingKeyValueByTableName("role_item");
											RoleItemDetail iDetail = new RoleItemDetail();
											iDetail.setId(bid);
											iDetail.setRoleid(roleid);
											iDetail.setItemid(jianglidaoju_id);
											iDetail.setNum(num);
											iDetail.setFlag(1);
											iDetail.setType(itemtype);
											boolean bo = this.getRoleItemService()
													.insertRoleItem(iDetail);
//											this.getAutoIdService()
//													.updateKeyValueAddOneByTableName(
//															"role_item");
											if (bo == true) {
												params.put("bid", bid);
												params.remove("roleid");
												params.put("id", jianglidaoju_id);
												params.remove("itemid");
												list.add(params);

											}
										}
									}
								}
								//更改时间，已经领取。
								SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
								long diff1 = 0;
								try {
									 diff1 =sdf1.parse(now).getTime();
								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								diff1 = diff1 + 1000*60*60*24 + 500;
								//diff1 = diff1 + 1000*60*60*9 + 1000*60*45;

								viptime = sdf2.format(diff1);
			//					System.out.println("vipgift400:" + vipgift);
								vipgift = this.getVipString(vip);
								Map<String, Object> param = new HashMap<String, Object>();
								param.put("id", roleid);
								param.put("vipgift", vipgift);
								param.put("viptime", viptime);
								boolean bo = this.getGameRoleService().updateRoleVipGiftTime(param);
			//					System.out.println("写入数据库的（viptime）:" + viptime);
			//					System.out.println("写入数据库的（vipgift）:" + vipgift);
			//					System.out.println("taskHandler.changetime(425):" + bo);
								vipPackage = String .valueOf(0);
							}else{
								//vip当天充值，可以领取多个礼包
			//					System.out.println("走到了第三条路！三条路！三条路！三条路！三条路！三条路！三条路！三条路！三条路！三条路！");
								if(vipgift_check(vipgift, vip)){
								for (int i = 0; i < resList.size(); i++) {
									Map map = resList.get(i);
									int type = Integer.parseInt(String.valueOf(map.get("resType")));
									int jianglidaoju_id = Integer.parseInt(String.valueOf(map.get("id")));
									int num = Integer.parseInt(String.valueOf(map.get("num")));
									Map<String, Object> params = new HashMap<String, Object>();
									if (type == 5) {// 道具
										params.clear();
										params.put("roleid", roleid);
										params.put("itemid", jianglidaoju_id);
										List<RoleItemDetail> item = this.getRoleItemService().getRoleItem(params);
										params.put("num", num);// 获得数量
										params.put("resType", type);
										// 判断背包格子是否已满
										int itemtype = this.getGameItemService().getGameItemById(id).get(0).getItemtype();
										boolean boo = this.getShangxian(itemtype, type, roleid, jianglidaoju_id, num);
										if (boo == false) {// 背包格子不足
											rlt.put("reward", list);
											respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -3);
											respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, "道具空间不足");
											ServerHandler.sendData(session, respMap);
											return;
										}
										if (!item.isEmpty()) {// 已存在
											boolean bo = this.getRoleItemService().addRoleItemNum(params);
											if (bo == true) {
												long bid = item.get(0).getId();
												params.put("bid", bid);
												params.put("id", jianglidaoju_id);
												params.remove("roleid");
												params.remove("itemid");
												list.add(params);
											} else {

											}
										} else {// 不存在，
//											int bid = this.getAutoIdService()
//													.fingKeyValueByTableName("role_item") + 1;
											long bid = this.getAutoIdService()
											.fingKeyValueByTableName("role_item");
											RoleItemDetail iDetail = new RoleItemDetail();
											iDetail.setId(bid);
											iDetail.setRoleid(roleid);
											iDetail.setItemid(jianglidaoju_id);
											iDetail.setNum(num);
											iDetail.setFlag(1);
											iDetail.setType(itemtype);
											boolean bo = this.getRoleItemService()
													.insertRoleItem(iDetail);
//											this.getAutoIdService()
//													.updateKeyValueAddOneByTableName(
//															"role_item");
											if (bo == true) {
												params.put("bid", bid);
												params.remove("roleid");
												params.put("id", jianglidaoju_id);
												params.remove("itemid");
												list.add(params);

											}
										}
									}
								}
								//更改时间，已经领取。
//								SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//								SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//								long diff1 = 0;
//								try {
//									 diff1 =sdf1.parse(now).getTime();
//								} catch (ParseException e) {
//									// TODO Auto-generated catch block
//									e.printStackTrace();
//								}
//								diff1 = diff1 + 1000*60*60*24 + 500;
//								viptime = sdf2.format(diff1);
			//					System.out.println("数据库读取的已经领取礼包代号：" + vipgift);
								vipgift = this.getVipStringz(vipgift, packageindex);
//								if(vipgift.endsWith("10")){
//									vipgift = vipgift.substring(0, vipgift.length() - 2);
//								}else{
//									vipgift = vipgift.substring(0, vipgift.length() - 1);
//								}
				//				System.out.println("更新后已经领取的礼包代码：" + vipgift);
								Map<String, Object> param = new HashMap<String, Object>();
								param.put("id", roleid);
								param.put("vipgift", vipgift);
								param.put("viptime", viptime);
				//				System.out.println("id:" + param.get("id") + ",vipgift:" + param.get("vipgift") + ",viptime:" + param.get("viptime"));
								boolean bo = this.getGameRoleService().updateRoleVipGiftTime(param);
				//				System.out.println("更新到数据库（515）:" + bo);
				//				System.out.println("写入数据库的（viptime）:" + viptime);
				//				System.out.println("写入数据库的（vipgift）:" + vipgift);
								vipPackage = getVipString(vipgift, vip);
				//				System.out.println("更新后可以领取的礼包：" + vipPackage);
				//				System.out.println("判断是否要更改时间：" + vipgift + "是否等于" + str_vip);
								vipgift = vipgift.substring(0, vipgift.length() - 1);
								if(vipgift.equals(str_vip)){
									//更改时间，已经领取。
									SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
									SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
									long diff1 = 0;
									try {
										 diff1 =sdf1.parse(now).getTime();
									} catch (ParseException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
									long ll = 0;
									try {
										ll = diff1 - sdf.parse(viptime).getTime();
									} catch (ParseException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									if(ll > 0){
				//						System.out.println("是第二天完成升级领取");
										vipPackage = String.valueOf(vip);
									}else{
				//						System.out.println("不不是第二天完成升级领取");
										diff1 = diff1 + 1000*60*60*24 + 500;
										//diff1 = diff1 + 1000*60*60*9 + 1000*60*45;
									}
									

									viptime = sdf2.format(diff1);
									param.put("id", roleid);
									param.put("vipgift", vipgift);
									param.put("viptime", viptime);
									boolean boq = this.getGameRoleService().updateRoleVipGiftTime(param);
				//					System.out.println("taskHandler.changetime(505):" + boq);
								}
							}else{
								Map<String, Object> param = new HashMap<String, Object>();
								vipgift = str_vip;
								SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
								long diff1 = 0;
								try {
									 diff1 =sdf1.parse(now).getTime();
								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								diff1 = diff1 + 1000*60*60*24 + 500;
								//diff1 = diff1 + 1000*60*60*9 + 1000*60*45;

								viptime = sdf2.format(diff1);
								param.put("id", roleid);
								param.put("vipgift", vipgift);
								param.put("viptime", viptime);
								boolean boq = this.getGameRoleService().updateRoleVipGiftTime(param);
				//				System.out.println("受到攻击，强制更新数据(587):" + boq);
							}
							}
						}
				//		System.out.println("返回的：" + vipPackage);
						if(vipPackage.endsWith("10")){
							vipPackage = vipPackage.substring(0, vipPackage.length()-2);
							vipPackage = vipPackage + "d";
						}
				//		System.out.println("返回的：" + vipPackage);
						rlt.put("vip", vip);
						rlt.put("giftpackage", vipPackage);
						rlt.put("expeirence", coinspend);
						rlt.put("reward", list);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
					}else{
			//			System.out.println(vipPackage);;
						rlt.put("vip", vip);
						rlt.put("giftpackage", 0);
						rlt.put("expeirence", coinspend);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
								GameConstants.DO_IT_BEFORE);
						respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
								rlt);
					}
					
				}else{
					rlt.put("vip", vip);
					rlt.put("giftpackage", 0);
					rlt.put("expeirence", coinspend);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.VIP_NOT_ENOUGH);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				}
			}else{
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
				return;
			}
		}
		ServerHandler.sendData(session, respMap);
	}
	
	public static boolean vipgift_check(String vipgift, int vip){
		boolean flag = true;
		boolean f1 = true;
		boolean f2 = true;
		//判断vip是否小于礼包编码
//		boolean fc = true;
//		if(vipgift.endsWith("10")){
//			if(vip==10){
//				fc=false;
//			}else{
//				vipgift = vipgift.substring(0, vipgift.length()-2);
//				String last = vipgift.substring(vipgift.length()-1,vipgift.length());
//				System.out.println("last:" + last);
//				if(Integer.valueOf(last) >= vip){
//					fc = false;
//				}else{
//					fc = true;
//				}
//			}
//		}else{
//		String last = vipgift.substring(vipgift.length()-1,vipgift.length());
//		System.out.println("last:" + last);
//		if(Integer.valueOf(last) >= vip){
//			fc = false;
//		}else{
//			fc = true;
//		}
//		}
		//判断VIPgift是否是"01"开头
		if(vipgift.startsWith("01")){
			f1 = true;
		}else{
			f1 = false;
		}
		//System.out.println("f1:" + f1);
		//判断VIPgift是否有重复
		if(vipgift.endsWith("10")){
			boolean f3 = true;
			boolean f4 = true;
			vipgift = vipgift.substring(0, vipgift.length()-2);
			if(vipgift.contains("10")){
				f3 = false;
			}else{
				f3 = true;
			}
			char[] cha = vipgift.toCharArray();
			for(int i = 0; i <= cha.length-1 ; i++){
				for(int j = i + 1; j <= cha.length-1 ; j++){
					if(cha[i]==cha[j]){
					//	System.out.println("cha[" + i + "]:" + cha[i] + ",cha[" + j + "]:" + cha[j]);
						f4 = false;
						break;
					}
				}
			}
			if(f3 && f4){
				f2 = true;
			}else{
				f2 = false;
			}
			//System.out.println("one:f2:" + f2);
		}else{
			char[] cha = vipgift.toCharArray();
			for(int i = 0; i <= cha.length-1 ; i++){
				for(int j = i + 1; j <= cha.length-1 ; j++){
					if(cha[i]==cha[j]){
						f2 = false;
					//	System.out.println("cha[" + i + "]:" + cha[i] + ",cha[" + j + "]:" + cha[j]);
						break;
					}
				}
			}
			//System.out.println("two:f2:" + f2);
		}
	//	System.out.println("f1:" + f1 + ",f2:" + f2);
		if(f1 && f2){
			flag = true;
		}else{
			flag = false;
		}
		return flag;
	}
	
	private static String getVipString(int vip){
		String str = "";
		for(int i = 0; i <= vip; i++){
			str = str.concat(String.valueOf(i));
		}
		if(str.endsWith("10")){
			str = str.substring(0, str.length() -2);
		}else{
			str = str.substring(0, str.length() -1);		
		}
		return str;
	}
	
	private static String getVipStringz(String vipgift, int packageindex){
		String str = "";
		if(vipgift.endsWith("10")){
			vipgift = vipgift.substring(0, vipgift.length()-2);
			boolean flag = true;
			char[] cha = vipgift.toCharArray();
			for(int i = 0; i <= cha.length-1 ; i++){
				int a = Integer.parseInt(String.valueOf(cha[i]));
				if(a < packageindex){
					str = str + a;
				}else if(a > packageindex && flag){
					str = str + packageindex + a;
					flag = false;
	//				System.out.println(flag);
				}else{
					str = str + a;
				}
				if(i==cha.length-1 && a<packageindex){
					str = str + packageindex;
				}
			}
			str = str + 10;
		}else{
		boolean flag = true;
		char[] cha = vipgift.toCharArray();
		for(int i = 0; i <= cha.length-1 ; i++){
			int a = Integer.parseInt(String.valueOf(cha[i]));
			if(a < packageindex){
				str = str + a;
			}else if(a > packageindex && flag){
				str = str + packageindex + a;
				flag = false;
			}else{
				str = str + a;
			}
			if(i==cha.length-1 && a<packageindex){
				str = str + packageindex;
			}
		}
		}
		return str;
	}
	
	private static String getVipString(String vipgift, int vip){
		String str = "";
		for(int i = 0; i <= vip; i++){
			if(!vipgift.contains(String.valueOf(i))){
				str = str.concat(String.valueOf(i));
			}
		}
		return  str;
	}
	
	private static int[] getRoleTask(List<RoleTaskTaskDetail> list){
		int length = list.size();
		int[] roleTask= new int[length];
		int i = 0;
		for(RoleTaskTaskDetail rttd : list){
			roleTask[i] = rttd.getTaskid();
			i++;
		}
		return roleTask;
	}
	
	private void openvip() {
		Map<String, Object> rlt = new HashMap<String, Object>();
		int roleid = Integer.parseInt(playerId);
		GameRoleDetail gamerole = this.getGameRoleService().findRoleById(roleid);
		if(gamerole!=null){
			int vip = gamerole.getVip();
			int Nvip = this.getGameVipService().getGameVipByAllvipRmb(gamerole.getCoinspend()).get(0).getVipLevel();
			if(Nvip>vip){
				//更新vip
				Map<String, Object> paramv = new HashMap<String, Object>();
				paramv.put("id", roleid);
				paramv.put("vip", Nvip);
				this.getGameRoleService().updateRoleVip(paramv);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String now = sdf.format(new Date());
				paramv.clear();
				paramv.put("id", roleid);
				paramv.put("vipgift", gamerole.getVipGift());
				paramv.put("viptime", now);
				boolean boq = this.getGameRoleService().updateRoleVipGiftTime(paramv);
	//			System.out.println("taskHandler.changetime(505):" + boq);
				paramv=null;
				vip = Nvip;
			}
			if(vip==0){
				rlt.put("vip", 0);
			}else{
				if(vip>=gamerole.getVips()){
					rlt.put("vip", gamerole.getVips());
				}else{
					rlt.put("vip", vip);
				}
			}
			rlt.put("rvip", vip);
			rlt.put("vipexp", gamerole.getCoinspend());
	//		System.out.println(vip+"%%%%%%%%%%%%");
		}
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
		respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
		ServerHandler.sendData(session, respMap);
	}

	private void complete() {
		if (params.containsKey("taskid")) {
			
			int taskid = Integer.parseInt(String.valueOf(params.get("taskid")));
			//System.out.println(taskid+"=TaskHandler.completeAPI=taskid领取任务奖励开始：");
			// 点击完成时把任务id 发给我
			int roleid = Integer.parseInt(playerId);
			Map<String, Object> rlt = new HashMap<String, Object>();
			// 领取礼包，完成时把那条任务删掉，放进去下一条任务
			rlt.put("shengji", 0);
			
			//判断下一个任务是否存在
			Map<String,Object> param = new HashMap<String,Object>();
			List<GameTaskDetail> renwu = this.getGameTaskService().getGameTaskDetailByoId(taskid);
			if(!renwu.isEmpty()){

				param.put("roleid", roleid);
				param.put("taskid", renwu.get(0).getId());
				//System.out.println(renwu.get(0).getId()+"..."+roleid);
				List<RoleTaskTaskDetail> cunzai = this.getRoleTaskTaskService().findRoleTask0(param);
				//System.out.println(cunzai.size());
				if(!cunzai.isEmpty()){//已存在
					//System.out.println("ren wu cun zai....");
					GameConstants.log.warn("the task is exist and return over：");
					return;
				}
			}
			
			//判断是否可以领取礼包
			param.clear();
			param.put("roleid", roleid);
			param.put("states", 1);
			param.put("taskid", taskid);
			List<RoleTaskTaskDetail> rolet = this.getRoleTaskTaskService().findRoleTask0(param);
			if(rolet.isEmpty()){
				//System.out.println("bu ke yi");
				GameConstants.log.warn(" the task gift is exist and return over：");
				return;
			}
			List<GameTaskDetail> lit = this.getGameTaskService()
					.getGameTaskDetailById(taskid);
			if (!lit.isEmpty()) {
				String task = lit.get(0).getTaskres();
				GameRoleDetail role0 = this.getGameRoleService().findRoleById(
						roleid);
				int rcoin = role0.getYin() + lit.get(0).getTaskcoin();
				int rgongxun = role0.getGongxun() + lit.get(0).getGongxun();
				int rjunling = role0.getJunling() + lit.get(0).getJunling();
				int rexp = role0.getExp() + lit.get(0).getExp();
				List<Map> tasks = JSON.parseArray(String.valueOf(task),
						Map.class);
				JSONArray temptask = new JSONArray();

				Map<String, JSONArray> result = this.getplayerHandler()
						.collect(tasks, roleid);
				temptask = result.get("temptask");
				Map<String, Object> paramCGJ = new HashMap<String, Object>();
				int coin = lit.get(0).getTaskcoin();
				int gongxun = lit.get(0).getGongxun();
				int junling = lit.get(0).getJunling();
				int exp = lit.get(0).getExp();
				if (gongxun > 0) {
					paramCGJ.clear();
					paramCGJ.put("flag", 4);
					paramCGJ.put("num", gongxun);
					temptask.add(paramCGJ);
				}
				if (junling > 0) {
					paramCGJ.clear();
					paramCGJ.put("flag", 2);
					paramCGJ.put("num", junling);
					temptask.add(paramCGJ);
				}
				if (coin > 0) {
					paramCGJ.clear();
					paramCGJ.put("flag", 1);
					paramCGJ.put("num", coin);
					temptask.add(paramCGJ);
				}
				if (exp > 0) {
					paramCGJ.clear();
					paramCGJ.put("flag", 3);
					paramCGJ.put("num", exp);
					temptask.add(paramCGJ);
				}

				JSONArray flag = result.get("flag");
				if (!flag.contains(false)) {// 领取礼包成功，把那条任务删掉，放进去下一条任务
					// 增加钱,增加功勋,增加军令,增加经验
					Map<String, Object> paramadd = new HashMap<String, Object>();
					paramadd.put("id", roleid);
					paramadd.put("yin", rcoin);
					paramadd.put("gongxun", rgongxun);
					paramadd.put("junling", rjunling);
					paramadd.put("exp", rexp);
					this.getGameRoleService().updateRoleVip(paramadd);
					/** roleid:人物id，level：人物等级，exp：原有经验，uppexp：本次获得经验 */
					int sheng=this.getplayerHandler().shengji( roleid,role0.getLevel(),role0.getExp(),lit.get(0).getExp());
					if(sheng==1){
						taskcomplete(roleid);
						rlt.put("shengji", 1);
					}
					
					Map<String, Object> paramI = new HashMap<String, Object>();
					paramI.put("roleid", roleid);
					paramI.put("taskid", taskid);
					boolean boo = this.getRoleTaskTaskService()
							.deleteRoleTaskByTaskId0(paramI);
					//System.out.println("领取玩任务奖励删除任务插入一条新的任务："+boo);
					//GameConstants.log.warn("领取玩任务奖励删除任务   to del the old task："+boo);

					// 查询下一条任务
					List<GameTaskDetail> list = this.getGameTaskService()
							.getGameTaskDetailByoId(taskid);
					// 插入数据库
					if (!list.isEmpty()) {
//						GameTaskDetail model = list.get(0);
//						boolean bo = insert(model, roleid);
						for(int i=0;i<list.size();i++){
							GameTaskDetail model = list.get(i);
							//判断老任务是否存在
							param.clear();
							param.put("roleid", roleid);
							param.put("taskid", model.getOldid());
							List<RoleTaskTaskDetail> cunzaiOld = this.getRoleTaskTaskService().findRoleTask0(param);
							if(!cunzaiOld.isEmpty()){
								boolean booo = this.getRoleTaskTaskService()
								.deleteRoleTaskByTaskId0(param);
								//GameConstants.log.warn("领取玩任务奖励删除任务   old task exit and del the old task："+booo);
								
							}
							//判断新任务是否存在
							param.clear();
							param.put("roleid", roleid);
							param.put("taskid", model.getId());
							List<RoleTaskTaskDetail> cunzai = this.getRoleTaskTaskService().findRoleTask0(param);
							if(cunzai.isEmpty()){
								insert(model, roleid);
							}
						}
					}

					//更新vip可领取的礼包等级
//					Map<String, Object> param = new HashMap<String, Object>();
					param.clear();
					if(taskid==92){//下次可领取vip=2的礼包
						param.put("id", roleid);
						param.put("vips", 2);
						this.getGameRoleService().updateRoleVip(param);
					}else if(taskid==93){
						param.put("id", roleid);
						param.put("vips", 3);
						this.getGameRoleService().updateRoleVip(param);
					}else if(taskid==94){
						param.put("id", roleid);
						param.put("vips", 4);
						this.getGameRoleService().updateRoleVip(param);
					}else if(taskid==95){
						param.put("id", roleid);
						param.put("vips", 5);
						this.getGameRoleService().updateRoleVip(param);
					}else if(taskid==96){
						param.put("id", roleid);
						param.put("vips", 6);
						this.getGameRoleService().updateRoleVip(param);
					}else if(taskid==97){
						param.put("id", roleid);
						param.put("vips", 7);
						this.getGameRoleService().updateRoleVip(param);
					}else if(taskid==98){
						param.put("id", roleid);
						param.put("vips", 8);
						this.getGameRoleService().updateRoleVip(param);
					}else if(taskid==99){
						param.put("id", roleid);
						param.put("vips", 9);
						this.getGameRoleService().updateRoleVip(param);
					}else if(taskid==100){
						param.put("id", roleid);
						param.put("vips", 10);
						this.getGameRoleService().updateRoleVip(param);
					}else if(taskid==101){//11
						param.put("id", roleid);
						param.put("vips", 10);
						this.getGameRoleService().updateRoleVip(param);
					}
					GameRoleDetail role = this.getGameRoleService()
							.findRoleById(roleid);
					rlt.put("rgongxun", role.getGongxun());
					rlt.put("rjunling", role.getJunling());
					rlt.put("rcoin", role.getYin());
					rlt.put("rexp", role.getExp());
					rlt.put("reward", temptask);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
					ServerHandler.sendData(session, respMap);
				} else {
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -6);
					respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
							"背包空间不足");
					ServerHandler.sendData(session, respMap);
				}
			} else {// 任务不存在
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
				respMap
						.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
								"没有这条任务");
				ServerHandler.sendData(session, respMap);
			}
		}
	}

	private void opentask() {
//		System.out.println("===========打开任务开始===================");
		// 判断有什么任务，完成没有
		int roleid = Integer.parseInt(playerId);
		// 查看表里面当前任务
		// type/roleid/..../taskid/taskoldid
		Map<String, Object> rlt = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		// param.put("type", 2);
		param.put("roleid", roleid);
		List<RoleTaskTaskDetail> list = this.getRoleTaskTaskService()
				.findRoleTask0(param);
		// 查看人物等级
		int level = this.getGameRoleService().findRoleById(roleid).getLevel();
		JSONArray taskff = new JSONArray();
//System.out.println("list:" + !list.isEmpty());
		if (!list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> task = new HashMap<String, Object>();
				task.put("taskid", list.get(i).getTaskid());
				if (list.get(i).getStates() == 0) {
					Map<String, Object> paramI = new HashMap<String, Object>();
					paramI.put("roleid", roleid);
					paramI.put("taskid", list.get(i).getTaskid());
					int tasktype = list.get(i).getTasktype();
					//System.out.println("tasktype:" + tasktype);
					int tasknum = list.get(i).getTasknum();// 要提升的等级
					int tasklevel = list.get(i).getTasklevel();
					int progress = list.get(i).getProgress();
					if (tasktype == 3) {// 等级提升
						if (level >= tasknum) {// 若是人物等级>=任务等级,任务已经完成
							// 更新人物任务表里面的state状态
							paramI.put("states", 1);
							boolean bo = this.getRoleTaskTaskService()
									.updateRoleTaskState0(paramI);
							if (bo == true) {
								task.put("states", 1);
								taskff.add(task);
							}
						} else {// 任务没完成
							task.put("states", 0);
							taskff.add(task);
						}
					} else if (tasktype == 23) {// VIP任务增加达到VIP等级的任务
						GameRoleDetail listR = this.getGameRoleService()
						.findRoleById(roleid);
				int vip=listR.getVip();//玩家的vip等级
				if (vip>=tasknum) {//tasknum任务的vip等级
					paramI.put("states", 1);
					boolean bo=this.getRoleTaskTaskService().updateRoleTaskState0(
							paramI);
					if (bo == true) {
						task.put("states", 1);
						taskff.add(task);
					}
				} else {
					task.put("states", 0);
					taskff.add(task);
				}
			}else if (tasktype == 5) {// 提升武将等级
						// 从表里面查询看是否有这个等级的武将
						Map<String, Object> paramM = new HashMap<String, Object>();
						paramM.put("roleid", roleid);
						paramM.put("level", tasknum);
						List<RoleMilitaryDetail> listM = new ArrayList<RoleMilitaryDetail>();
						listM = this.getRoleMilitaryService()
								.getRoleMilitaryByLevel(paramM);
						if (!listM.isEmpty()) {
							paramI.clear();
							paramI.put("roleid", roleid);
							paramI.put("taskid", list.get(i).getTaskid());
							paramI.put("states", 1);
							boolean bo = this.getRoleTaskTaskService()
									.updateRoleTaskState0(paramI);
							if (bo == true) {
								task.put("states", 1);
								taskff.add(task);
							}
						} else {
							task.put("states", 0);
							taskff.add(task);
						}
					} else if (tasktype == 9 || tasktype == 8) {// 强化装备至某一等级
						// 从表里面查询看是否有这个等级的武将
						Map<String, Object> paramE = new HashMap<String, Object>();
						paramE.put("roleid", roleid);
						paramE.put("dengji", tasknum);

						List<RoleEquipDetail> listE = this
								.getRoleEquipService().getRoleEquipByDengji(
										paramE);
						if (!listE.isEmpty()) {
							paramI.put("states", 1);
							boolean bo = this.getRoleTaskTaskService()
									.updateRoleTaskState0(paramI);
							if (bo == true) {
								task.put("states", 1);
								taskff.add(task);
							}
						} else {
							task.put("states", 0);
							taskff.add(task);
						}
					} else if (tasktype == 4) {// 通过指定的波数
						GameRoleDetail listR = this.getGameRoleService().findRoleById(roleid);
						
						int mapid = listR.getMapid();// 地图
						int placeid = listR.getPlaceid();// 波数
						// tasklevel:哪一个地图
					//	System.out.println("tasktype4:" + (mapid > tasklevel || mapid==tasklevel
//								&& placeid > tasknum));
						if (mapid > tasklevel || mapid==tasklevel
								&& placeid > tasknum) {
							paramI.put("states", 1);
							this.getRoleTaskTaskService().updateRoleTaskState0(
									paramI);
							task.put("states", 1);
							taskff.add(task);
						} else {
							task.put("states", 0);
							taskff.add(task);
						}
					} else if (tasktype == 6) {// 购买指定的道具
						// 2加速卡
						// item表 tasklevel itemid tasknum item数量
//						int itemid = list.get(i).getTasklevel();
//						Map<String, Object> paramIt = new HashMap<String, Object>();
//						paramIt.put("itemid", itemid);
//						paramIt.put("roleid", roleid);
//						List<RoleItemDetail> item = this.getRoleItemService()
//								.getRoleItemByitem(paramIt);
//							System.out.println("item.get(0).getNum()o:"
//									+ item.get(0).getNum());
							if ( progress >= tasknum) {
								paramI.put("states", 1);
								boolean bo = this.getRoleTaskTaskService()
										.updateRoleTaskState0(paramI);
								task.put("states", 1);
								taskff.add(task);
							} else {
								task.put("states", 0);
								taskff.add(task);
							}
					

					} else if (tasktype == 15) {// 邀请好友进入游戏
						int invite = this.getGameRoleService().findRoleById(roleid).getInvite();
						if(invite>=tasknum){
							paramI.put("states", 1);
							this.getRoleTaskTaskService().updateRoleTaskState0(
									paramI);
							task.put("states", 1);
							taskff.add(task);

                            /****/
							GameRole role = this.getGameRoleService().findRoleById(roleid);
							String state0 = role.getAimreward();
							JSONArray aimreward = JSONArray.fromObject(state0);//目标大奖状态
							if(aimreward.getInt(6)==0){//6。完成一次魔将转生
								aimreward.set(6, 1);
								param.clear();
								param.put("id", roleid);
								param.put("aimreward", aimreward.toString());
								this.getGameRoleService().updateRoleVip(param);
							}
							/****/
							
						}else {
							task.put("states", 0);
							taskff.add(task);
						}
					} else if (tasktype == 18) {// 加强塔防//拥有五个塔
						Map<String, Object> paramt = new HashMap<String, Object>();
						paramt.put("mapid", 1);
						paramt.put("roleId", roleid);
						List<RoleMapDetail> tt = this.getRoleMapService()
								.getRoleMapByParam(paramt);
						int placeid = tt.size();
						if (placeid >= tasknum) {
							paramI.put("states", 1);
							this.getRoleTaskTaskService().updateRoleTaskState0(
									paramI);
							task.put("states", 1);
							taskff.add(task);
						} else {
							task.put("states", 0);
							taskff.add(task);
						}
					} else if (tasktype == 180) {// 武将招募5个
						List<RoleMilitaryDetail> listM = new ArrayList<RoleMilitaryDetail>();
						listM = this.getRoleMilitaryService().getRoleMilitary(
								roleid);
						if (listM.size() >= tasknum) {
							paramI.put("states", 1);
							this.getRoleTaskTaskService().updateRoleTaskState0(
									paramI);
							task.put("states", 1);
							taskff.add(task);
						} else {
							task.put("states", 0);
							taskff.add(task);
						}

					}else if(tasktype == 13){//进行三次初级招募
				//		System.out.println("//进行三次初级招募");
						List<RoleTavernDetail> roleTavern = this.getRoleTavernService().getRoleTavern(roleid);
				//		System.out.println("roleTavern:" + roleTavern.size());
						if(roleTavern.isEmpty()){
							return;
						}
						int chuji = roleTavern.get(0).getChuji()-1;
						if (chuji >= tasknum) {
							paramI.put("states", 1);
							this.getRoleTaskTaskService().updateRoleTaskState0(
									paramI);
							task.put("states", 1);
							taskff.add(task);
						} else {
							task.put("states", 0);
							taskff.add(task);
						}
				//		System.out.println("//进行三次初级招募");
					}else if(tasktype == 11){//进行5次掠夺
						int imposenum = this.getGameRoleService().findRoleById(roleid).getImposenum();
						if (imposenum >= tasknum) {
							paramI.put("states", 1);
							this.getRoleTaskTaskService().updateRoleTaskState0(
									paramI);
							task.put("states", 1);
							taskff.add(task);
						} else {
							task.put("states", 0);
							taskff.add(task);
						}
					}else if(tasktype == 17){//进行2次战斗
						if (list.get(i).getNum() >= tasknum) {
							paramI.put("states", 1);
							this.getRoleTaskTaskService().updateRoleTaskState0(
									paramI);
							task.put("states", 1);
							taskff.add(task);
						} else {
							task.put("states", 0);
							taskff.add(task);
						}
					}else if(tasktype==20){//副本任务
						param.clear();
						param.put("roleid", roleid);
						param.put("mapid", tasklevel);
						List<RoleBingDetail> roleBing = this.getRoleBingService().findRoleBingByParams(param);
						if(!roleBing.isEmpty()){
							if(roleBing.get(0).getNandu()>tasknum){//可以领取奖励
								paramI.put("states", 1);
								this.getRoleTaskTaskService().updateRoleTaskState0(paramI);
								task.put("states", 1);
								taskff.add(task);
								//System.out.println("1副本的=============="+task);
							}else if(roleBing.get(0).getNandu()==tasknum){
								if(roleBing.get(0).getStars()==3){//可以领取
									paramI.put("states", 1);
									this.getRoleTaskTaskService().updateRoleTaskState0(paramI);
									task.put("states", 1);
									taskff.add(task);
									//System.out.println("2副本的=============="+task);
								}else{
									task.put("states", 0);
									taskff.add(task);
									//System.out.println("3副本的=============="+task);
								}
							}else{
								task.put("states", 0);
								taskff.add(task);
								//System.out.println("4副本的=============="+task);
							}
						}else{
							task.put("states", 0);
							taskff.add(task);
							//System.out.println("5副本的=============="+task);
						}
					}
				} else if (list.get(i).getStates() == 1) {// 可以领取任务奖励
					task.put("states", 1);
					taskff.add(task);
				//	System.out.println("6副本的=============="+task);
				}
			}
			rlt.put("task", taskff);
			//System.out.println("任务列表=================："+taskff);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
					GameConstants.GAME_API_SUCCESS);
			respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
			ServerHandler.sendData(session, respMap);
		} else {// 为空的话，插入两条数据
//			List<GameTaskDetail> list0 = this.getGameTaskService()
//					.getGameTaskDetailById(42);
//			GameTaskDetail model = list0.get(0);
//			boolean bo = insert(model, roleid);
			List<GameTaskDetail> list1 = this.getGameTaskService()
					.getGameTaskDetailById(60);
			GameTaskDetail model1 = list1.get(0);
			boolean bo1 = insert(model1, roleid);
			List<GameTaskDetail> list2 = this.getGameTaskService()
					.getGameTaskDetailById(70);
			GameTaskDetail model2 = list2.get(0);
			boolean bo2 = insert(model2, roleid);
			List<GameTaskDetail> list3 = this.getGameTaskService()
					.getGameTaskDetailById(71);
			GameTaskDetail model3 = list3.get(0);
			boolean bo3 = insert(model3, roleid);
			List<GameTaskDetail> list4 = this.getGameTaskService()
				.getGameTaskDetailById(92);
			GameTaskDetail model4= list4.get(0);
			boolean bo4 = insert(model4, roleid);

			if (bo1 == true) {
				Map<String, Object> task = new HashMap<String, Object>();
//				task.put("taskid", 42);
//				task.put("states", 0);
//				taskff.add(task);
				task.clear();
				task.put("taskid", 60);
				task.put("states", 0);
				taskff.add(task);
				task.clear();
				task.put("taskid", 70);
				task.put("states", 0);
				taskff.add(task);
				task.clear();
				task.put("taskid", 71);
				task.put("states", 0);
				taskff.add(task);
				task.clear();
				task.put("taskid", 92);
				task.put("states", 0);
				taskff.add(task);
				// opentask();
				rlt.put("task", taskff);
	//			System.out.println("2任务列表================："+taskff);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
						GameConstants.GAME_API_SUCCESS);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, rlt);
				ServerHandler.sendData(session, respMap);
			} else {// 添加数据失败
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, -1);
				respMap.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
						"获取当前任务失败");
				ServerHandler.sendData(session, respMap);
			}

		}

	}

	public boolean insert(GameTaskDetail model, int roleid) {
		boolean boo = false;
		Map<String, Object> detail = new HashMap<String, Object>();
		int bid = this.getAutoIdService().fingKeyValueByTableName("role_task_task");
		detail.put("id", bid);
		detail.put("roleId", roleid);// 0,还没执行；1,已经执行
		detail.put("taskid", model.getId());
		detail.put("taskoldid", model.getOldid());
		detail.put("type", model.getType());
		detail.put("tasktype", model.getTasktype());
		detail.put("tasknum", model.getTasknum());
		detail.put("tasklevel", model.getTasklevel());
		detail.put("flag", model.getFlag());
		detail.put("states", 0);
		detail.put("progress", 0);
		boo = this.getRoleTaskTaskService().insertRoleTask0(detail);
//		this.getAutoIdService().updateKeyValueAddOneByTableName(
//				"role_task_task");
		return boo;

	}

	protected void taskcomplete(int roleid) {
		// 判断有什么任务，完成没有
	
		// 查看表里面当前任务
		// type/roleid/..../taskid/taskoldid
		Map<String, Object> rlt = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		// param.put("type", 2);
		param.put("roleid", roleid);
		List<RoleTaskTaskDetail> list = this.getRoleTaskTaskService().findRoleTask0(param);
//		System.out.println("Taskhanler中得到玩家任务！：" + list.size());
		// 查看人物等级
		int level = this.getGameRoleService().findRoleById(roleid).getLevel();
		JSONArray taskff = new JSONArray();

		if (!list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> task = new HashMap<String, Object>();
				task.put("taskid", list.get(i).getTaskid());
				if (list.get(i).getStates() == 0) {
					Map<String, Object> paramI = new HashMap<String, Object>();
					paramI.put("roleid", roleid);
					paramI.put("taskid", list.get(i).getTaskid());
					int tasktype = list.get(i).getTasktype();
					//System.out.println("Taskhanler:tasktype:" + tasktype);
					int tasknum = list.get(i).getTasknum();// 要提升的等级
					int tasklevel = list.get(i).getTasklevel();
					int progress = list.get(i).getProgress();
					if (tasktype == 3) {// 等级提升
						if (level == tasknum) {// 若是人物等级>=任务等级,任务已经完成
							// 更新人物任务表里面的state状态
							paramI.put("states", 1);
							boolean bo = this.getRoleTaskTaskService().updateRoleTaskState0(paramI);
							if (bo == true) {
								Map<String, Object> res = new HashMap<String, Object>();
								res.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
								res.put(GameConstants.GAME_API_RESPONSE_FIELD_ACTPID, roleid);
								res.put(GameConstants.GAME_API_RESPONSE_FIELD_CMD, "sys.taskcomplete");
								res.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, 1);
								ServerHandler.sendDataByRoleId(res, roleid);
								res.clear();
								task.put("states", 1);
								taskff.add(task);
							}
						} else {// 任务没完成
							task.put("states", 0);
							taskff.add(task);
						}
					}else if (tasktype == 23) {// VIP任务增加达到VIP等级的任务
						GameRoleDetail listR = this.getGameRoleService()
						.findRoleById(roleid);
				int vip=listR.getVip();//玩家的vip等级
				if (vip>=tasknum) {//tasknum任务的vip等级
					paramI.put("states", 1);
					boolean bo=this.getRoleTaskTaskService().updateRoleTaskState0(
							paramI);
					if(bo==true){
						Map<String, Object> res = new HashMap<String, Object>();
						res.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
										GameConstants.GAME_API_SUCCESS);
						res.put(GameConstants.GAME_API_RESPONSE_FIELD_ACTPID,
										roleid);
						res.put(GameConstants.GAME_API_RESPONSE_FIELD_CMD,
										"sys.taskcomplete");
						res.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
										1);
						ServerHandler.sendDataByRoleId(res, roleid);
						task.put("states", 1);
						taskff.add(task);
					}
				} else {
					task.put("states", 0);
					taskff.add(task);
				}
			} else if (tasktype == 5) {// 提升武将等级
						// 从表里面查询看是否有这个等级的武将
						Map<String, Object> paramM = new HashMap<String, Object>();
						paramM.put("roleid", roleid);
						paramM.put("level", tasknum);
						List<RoleMilitaryDetail> listM = new ArrayList<RoleMilitaryDetail>();
						listM = this.getRoleMilitaryService()
								.getRoleMilitaryByLevel(paramM);
						if (!listM.isEmpty()) {
							paramI.clear();
							paramI.put("roleid", roleid);
							paramI.put("taskid", list.get(i).getTaskid());
							paramI.put("states", 1);
							boolean bo = this.getRoleTaskTaskService()
									.updateRoleTaskState0(paramI);
							if (bo == true) {
								Map<String, Object> res = new HashMap<String, Object>();
								res
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
												GameConstants.GAME_API_SUCCESS);
								res
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_ACTPID,
												roleid);
								res
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CMD,
												"sys.taskcomplete");
								res
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_RLT,
												1);
								ServerHandler.sendDataByRoleId(res, roleid);
								task.put("states", 1);
								taskff.add(task);
							}
						} else {
							task.put("states", 0);
							taskff.add(task);
						}
					} else if (tasktype == 9 || tasktype == 8) {// 强化装备至某一等级
						// 从表里面查询看是否有这个等级的武将
						//System.out.println("// 从表里面查询看是否有这个等级的武将");
						Map<String, Object> paramE = new HashMap<String, Object>();
						paramE.put("roleid", roleid);
						paramE.put("dengji", tasknum);
						List<RoleEquipDetail> listE = this.getRoleEquipService().getRoleEquipByDengji(paramE);
						if (!listE.isEmpty()) {
							paramI.put("states", 1);
							boolean bo = this.getRoleTaskTaskService().updateRoleTaskState0(paramI);
							if (bo == true) {
								Map<String, Object> res = new HashMap<String, Object>();
								res.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE, GameConstants.GAME_API_SUCCESS);
								res.put(GameConstants.GAME_API_RESPONSE_FIELD_ACTPID, roleid);
								res.put(GameConstants.GAME_API_RESPONSE_FIELD_CMD, "sys.taskcomplete");
								res.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, 1);
								ServerHandler.sendDataByRoleId(res, roleid);
								task.put("states", 1);
								taskff.add(task);
							}
						} else {
							task.put("states", 0);
							taskff.add(task);
						}
					} else if (tasktype == 4) {// 通过指定的波数
						GameRoleDetail listR = this.getGameRoleService()
								.findRoleById(roleid);
						int mapid = listR.getMapid();// 地图
						int placeid = listR.getPlaceid()-1;// 波数
						// tasklevel:哪一个地图
						if (mapid >tasklevel ||mapid==tasklevel&&placeid ==tasknum) {
							paramI.put("states", 1);
							this.getRoleTaskTaskService().updateRoleTaskState0(
									paramI);
							Map<String, Object> res = new HashMap<String, Object>();
							res.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
											GameConstants.GAME_API_SUCCESS);
							res.put(GameConstants.GAME_API_RESPONSE_FIELD_ACTPID,
											roleid);
							res.put(GameConstants.GAME_API_RESPONSE_FIELD_CMD,
											"sys.taskcomplete");
							res.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
											1);
							ServerHandler.sendDataByRoleId(res, roleid);
							task.put("states", 1);
							taskff.add(task);
						} else {
							task.put("states", 0);
							taskff.add(task);
						}
					} else if (tasktype == 6) {// 购买指定的道具
						// 2加速卡
						// item表 tasklevel itemid tasknum item数量
//						int itemid = list.get(i).getTasklevel();
//						Map<String, Object> paramIt = new HashMap<String, Object>();
//						paramIt.put("itemid", itemid);
//						paramIt.put("roleid", roleid);
//						List<RoleItemDetail> item = this.getRoleItemService()
//								.getRoleItemByitem(paramIt);
							if ( progress == tasknum) {
								Map<String, Object> res = new HashMap<String, Object>();
								res
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CODE,
												GameConstants.GAME_API_SUCCESS);
								res
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_ACTPID,
												roleid);
								res
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_CMD,
												"sys.taskcomplete");
								res
										.put(
												GameConstants.GAME_API_RESPONSE_FIELD_RLT,
												1);
								ServerHandler.sendDataByRoleId(res, roleid);
								paramI.put("states", 1);
								boolean bo = this.getRoleTaskTaskService()
										.updateRoleTaskState0(paramI);
								task.put("states", 1);
								taskff.add(task);
							} else {
								task.put("states", 0);
								taskff.add(task);
							}
					

					} else if (tasktype == 15) {// 邀请好友进入游戏
						task.put("states", 0);
						taskff.add(task);
					} else if (tasktype == 170) {// 加强塔防//不用了
						Map<String, Object> paramt = new HashMap<String, Object>();
						paramt.put("mapid", 1);
						paramt.put("roleid", roleid);
						List<RoleMapDetail> tt = this.getRoleMapService()
								.getRoleMapByParam(param);
						int placeid = tt.get(0).getMapid();
						if (placeid >= tasknum) {
							Map<String, Object> res = new HashMap<String, Object>();
							res.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									GameConstants.GAME_API_SUCCESS);
							res
									.put(
											GameConstants.GAME_API_RESPONSE_FIELD_ACTPID,
											roleid);
							res.put(GameConstants.GAME_API_RESPONSE_FIELD_CMD,
									"sys.taskcomplete");
							res.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
									1);
							ServerHandler.sendDataByRoleId(res, roleid);
							paramI.put("states", 1);
							this.getRoleTaskTaskService().updateRoleTaskState0(
									paramI);
							task.put("states", 1);
							taskff.add(task);
						} else {
							task.put("states", 0);
							taskff.add(task);
						}
					} else if (tasktype == 18) {// 拥有五个塔
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("mapid", 1);
						map.put("roleId", roleid);
						List<RoleMapDetail> tt = this.getRoleMapService()
								.getRoleMapByParam(map);
						if (tt.size() == tasknum) {
							Map<String, Object> res = new HashMap<String, Object>();
							res.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									GameConstants.GAME_API_SUCCESS);
							res
									.put(
											GameConstants.GAME_API_RESPONSE_FIELD_ACTPID,
											roleid);
							res.put(GameConstants.GAME_API_RESPONSE_FIELD_CMD,
									"sys.taskcomplete");
							res.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
									1);
							ServerHandler.sendDataByRoleId(res, roleid);
							paramI.put("states", 1);
							this.getRoleTaskTaskService().updateRoleTaskState0(
									paramI);
							task.put("states", 1);
							taskff.add(task);
						} else {
							task.put("states", 0);
							taskff.add(task);
						}

					}else if(tasktype==13){//进行3次招募

						List<RoleTavernDetail> roleTavern = this.getRoleTavernService().getRoleTavern(roleid);
						if(roleTavern.isEmpty()){
							return;
						}
						int chuji = roleTavern.get(0).getChuji()-1;
						if (chuji == tasknum) {
							Map<String, Object> res = new HashMap<String, Object>();
							res.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									GameConstants.GAME_API_SUCCESS);
							res
									.put(
											GameConstants.GAME_API_RESPONSE_FIELD_ACTPID,
											roleid);
							res.put(GameConstants.GAME_API_RESPONSE_FIELD_CMD,
									"sys.taskcomplete");
							res.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
									1);
							ServerHandler.sendDataByRoleId(res, roleid);
							paramI.put("states", 1);
							this.getRoleTaskTaskService().updateRoleTaskState0(
									paramI);
							task.put("states", 1);
							taskff.add(task);
						} else {
							task.put("states", 0);
							taskff.add(task);
						}
					
					}else if(tasktype==11){//进行5次掠夺
						int imposenum = this.getGameRoleService().findRoleById(roleid).getImposenum();
						if (imposenum == tasknum) {
							Map<String, Object> res = new HashMap<String, Object>();
							res.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									GameConstants.GAME_API_SUCCESS);
							res.put(GameConstants.GAME_API_RESPONSE_FIELD_ACTPID,
											roleid);
							res.put(GameConstants.GAME_API_RESPONSE_FIELD_CMD,
									"sys.taskcomplete");
							res.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
									1);
							ServerHandler.sendDataByRoleId(res, roleid);
							paramI.put("states", 1);
							this.getRoleTaskTaskService().updateRoleTaskState0(
									paramI);
							task.put("states", 1);
							taskff.add(task);
						} else {
							task.put("states", 0);
							taskff.add(task);
						}
					}else if(tasktype==17){//进行6次战斗
						if(list.get(i).getNum()==tasknum){
							Map<String, Object> res = new HashMap<String, Object>();
							res.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
									GameConstants.GAME_API_SUCCESS);
							res.put(GameConstants.GAME_API_RESPONSE_FIELD_ACTPID,
											roleid);
							res.put(GameConstants.GAME_API_RESPONSE_FIELD_CMD,
									"sys.taskcomplete");
							res.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
									1);
							ServerHandler.sendDataByRoleId(res, roleid);
							paramI.put("states", 1);
							this.getRoleTaskTaskService().updateRoleTaskState0(
									paramI);
							task.put("states", 1);
							taskff.add(task);
						}else {
							task.put("states", 0);
							taskff.add(task);
						}
					}else if(tasktype==20){//副本任务
						param.clear();
						param.put("roleid", roleid);
						param.put("mapid", tasklevel);
						List<RoleBingDetail> roleBing = this.getRoleBingService().findRoleBingByParams(param);
						if(!roleBing.isEmpty()){
							if(roleBing.get(0).getNandu()>tasknum){//可以领取奖励
								Map<String, Object> res = new HashMap<String, Object>();
								res.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
										GameConstants.GAME_API_SUCCESS);
								res.put(GameConstants.GAME_API_RESPONSE_FIELD_ACTPID,
												roleid);
								res.put(GameConstants.GAME_API_RESPONSE_FIELD_CMD,
										"sys.taskcomplete");
								res.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
										1);
								ServerHandler.sendDataByRoleId(res, roleid);
								paramI.put("states", 1);
								this.getRoleTaskTaskService().updateRoleTaskState0(
										paramI);
								task.put("states", 1);
								taskff.add(task);
								res = null;
							}else if(roleBing.get(0).getNandu()==tasknum){
								if(roleBing.get(0).getStars()==3){//可以领取
									Map<String, Object> res = new HashMap<String, Object>();
									res.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
											GameConstants.GAME_API_SUCCESS);
									res.put(GameConstants.GAME_API_RESPONSE_FIELD_ACTPID,
													roleid);
									res.put(GameConstants.GAME_API_RESPONSE_FIELD_CMD,
											"sys.taskcomplete");
									res.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT,
											1);
									ServerHandler.sendDataByRoleId(res, roleid);
									paramI.put("states", 1);
									this.getRoleTaskTaskService().updateRoleTaskState0(
											paramI);
									task.put("states", 1);
									taskff.add(task);
									res = null;
								}else{
									task.put("states", 0);
									taskff.add(task);
								}
							}else{
								task.put("states", 0);
								taskff.add(task);
							}
						}
					}
				} else if (list.get(i).getStates() == 1) {// 可以领取任务奖励
					Map<String, Object> res = new HashMap<String, Object>();
					res.put(GameConstants.GAME_API_RESPONSE_FIELD_CODE,
							GameConstants.GAME_API_SUCCESS);
					res.put(GameConstants.GAME_API_RESPONSE_FIELD_ACTPID,
							roleid);
					res.put(GameConstants.GAME_API_RESPONSE_FIELD_CMD,
							"sys.taskcomplete");
					res.put(GameConstants.GAME_API_RESPONSE_FIELD_RLT, 1);
//					ServerHandler.sendDataByRoleId(res, roleid);//不用提示了
					task.put("states", 1);
					taskff.add(task);
				}
			}

		}

	}

	public void insertroletasktask(int roleid) {
		// 为空的话，插入两条数据
		Map<String, Object> param = new HashMap<String, Object>();
		// param.put("type", 2);
		param.put("roleid", roleid);
		List<RoleTaskTaskDetail> list = this.getRoleTaskTaskService().findRoleTask0(param);
		//System.out.println("TaskHandler.insertroleTaskTask:检验是否已经有任务：list:" + list.size());
		if (list.isEmpty()) {
//			List<GameTaskDetail> list0 = this.getGameTaskService()
//					.getGameTaskDetailById(42);
//			GameTaskDetail model = list0.get(0);
//			boolean bo = insert(model, roleid);
			List<GameTaskDetail> list0 = this.getGameTaskService()
					.getGameTaskDetailById(60);//守卫观音寺第3波
			GameTaskDetail model1 = list0.get(0);
			boolean bo1 = insert(model1, roleid);
//			List<GameTaskDetail> list1 = this.getGameTaskService()
//					.getGameTaskDetailById(70);//邀请战友
//			GameTaskDetail model2 = list1.get(0);
//			boolean bo2 = insert(model2, roleid);
			List<GameTaskDetail> list2 = this.getGameTaskService()
					.getGameTaskDetailById(71);//购中招送神兵
			GameTaskDetail model3 = list2.get(0);
			boolean bo3 = insert(model3, roleid);
			
			List<GameTaskDetail> list3 = this.getGameTaskService()
				.getGameTaskDetailById(92);
			GameTaskDetail model4 = list3.get(0);
			boolean bo4 = insert(model4, roleid);
		}
	}
	
	public boolean getShangxian(int type, int resType, int roleId, int id, int num) {
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
		if (resType == 5) {
			param.clear();
			param.put("roleid", roleId);
			param.put("itemid", id);
			List<RoleItemDetail> item = this.getRoleItemService().getRoleItemByitem(param);// 查看有没有此物品
			if (!item.isEmpty()) {//当表中已经有的时候
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
			List<RoleEquipDetail> lists = this.getRoleEquipService().getRoleEquipUser(params);// 查看这种类型有几个是否到了上线；
			if (backTop - num >= lists.size()) {// 判断 是否超出上限
				boo = true;
			} else {
				boo = false;
			}
		}else if (resType==3){//武将背包格子是否足够
			int tom = gvip.getMilitaryTop();
			param.clear();
			param.put("roleId", roleId);
			List<RoleMilitaryDetail> militarys = this.getRoleMilitaryService().getRoleMilitaryByparam(param);
			if(militarys.isEmpty()){
				boo = true;
			}else{
				if(militarys.size()<tom){
					boo = true;
				}else{
					boo = false;
				}
			}
		}
		return boo;
	}
}
