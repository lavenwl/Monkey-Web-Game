package com.stang.game.cache;

import com.stang.game.entity.detail.*;
import com.stang.game.util.*;
import com.stang.game.server.ServerHandler;
import com.stang.game.server.handler.SystemHandler;
import com.stang.game.service.impl.BaseServiceImpl;
import com.stang.game.dao.*;
import com.stang.game.dao.IGamblingItemDao;
import com.stang.game.dao.impl.*;
import java.util.*;
import com.stang.game.common.GameConstants;

public class ThreadCache extends Thread{
	private static IGameRoleDao gameRoleDao = null;
	private static IGameRoleDao getGameRoleDao(){
		if(gameRoleDao == null){
			gameRoleDao = new GameRoleDaoImpl();
		}
		return gameRoleDao;
	}
	private static IAutoIdDao autoIdDao = null;
	private static IAutoIdDao getAutoIdDao(){
		if(autoIdDao == null){
			autoIdDao = new AutoIdDaoImpl();
		}
		return autoIdDao;
	}
	
	private static ICdkStoreDao cdkStoreDao = null;
	private static ICdkStoreDao getCdkStoreDao(){
		if(cdkStoreDao == null){
			cdkStoreDao = new CdkStoreDaoImpl();
		}
		return cdkStoreDao;
	}
	
	private static IChallengeRecordDao challengeRecordDao = null;
	private static IChallengeRecordDao getChallengeRecordDao(){
		if(challengeRecordDao == null){
			challengeRecordDao = new ChallengeRecordDaoImpl();
		}
		return challengeRecordDao;
	}
	private static IRoleBingDao roleBingDao = null;
	private static IRoleBingDao getRoleBingDao(){
		if(roleBingDao == null){
			roleBingDao = new RoleBingDaoImpl();
		}
		return roleBingDao;
	}
	private static IRoleChallengeDao roleChallenge = null;
	private static IRoleChallengeDao getRoleChallengeDao(){
		if(roleChallenge == null){
			roleChallenge = new RoleChallengeDaoImpl();
		}
		return roleChallenge;
	}
	private static IRoleDaytaskDao roleDaytask = null;
	private static IRoleDaytaskDao getRoleDaytaskDao(){
		if(roleDaytask == null){
			roleDaytask = new RoleDaytaskDaoImpl();
		}
		return roleDaytask;
	}
	private static IRoleEquipDao roleEquip = null;
	private static IRoleEquipDao getRoleEquipDao(){
		if(roleEquip == null){
			roleEquip = new RoleEquipDaoImpl();
		}
		return roleEquip;
	}
	private static IRoleImposeDao roleImpose = null;
	private static IRoleImposeDao getRoleImposeDao(){
		if(roleImpose == null){
			roleImpose = new RoleImposeDaoImpl();
		}
		return roleImpose;
	}
	private static IRoleInsDao roleIns = null;
	private static IRoleInsDao getRoleInsDao(){
		if(roleIns == null){
			roleIns = new RoleInsDaoImpl();
		}
		return roleIns;
	}
	private static IRoleItemDao roleItem = null;
	private static IRoleItemDao getRoleItemDao(){
		if(roleItem == null){
			roleItem = new RoleItemDaoImpl();
		}
		return roleItem;
	}
	private static IRoleMapDao roleMap = null;
	private static IRoleMapDao getRoleMapDao(){
		if(roleMap == null){
			roleMap = new RoleMapDaoImpl();
		}
		return roleMap;
	}
	private static IRoleMilitaryDao roleMilitary = null;
	private static IRoleMilitaryDao getRoleMilitaryDao(){
		if(roleMilitary == null){
			roleMilitary = new RoleMilitaryDaoImpl();
		}
		return roleMilitary;
	}
	private static IRoleQuicktimeDao roleQuicktime = null;
	private static IRoleQuicktimeDao getRoleQuicktimeDao(){
		if(roleQuicktime == null){
			roleQuicktime = new RoleQuicktimeDaoImpl();
		}
		return roleQuicktime;
	}
	private static IRoleTaskDao roleTask = null;
	private static IRoleTaskDao getRoleTaskDao(){
		if(roleTask == null){
			roleTask = new RoleTaskDaoImpl();
		}
		return roleTask;
	}
	private static IRoleTaskTaskDao roleTaskTask = null;
	private static IRoleTaskTaskDao getRoleTaskTaskDao(){
		if(roleTaskTask == null){
			roleTaskTask = new RoleTaskTaskDaoImpl();
		}
		return roleTaskTask;
	}
	private static IRoletotemDao roletotem = null;
	private static IRoletotemDao getRoletotemDao(){
		if(roletotem == null){
			roletotem = new RoletotemDaoImpl();
		}
		return roletotem;
	}
	private static ICoinDao coin = null;
	private static ICoinDao getCoinDao(){
		if(coin == null){
			coin = new CoinDaoImpl();
		}
		return coin;
	}
	private static IDeliveryDao delivery = null;
	private static IDeliveryDao getDeliveryDao(){
		if(delivery == null){
			delivery = new DeliveryDaoImpl();
		}
		return delivery;
	}
	private static IGamblingItemDao gamBlingItem = null;
	private static IGamblingItemDao getGamblingItemDao(){
		if(gamBlingItem == null){
			gamBlingItem = new GamblingItemDaoImpl();
		}
		return gamBlingItem;
	}
	private static IMemberDao member = null;
	private static IMemberDao getMemberDao(){
		if(member == null){
			member = new MemberDaoImpl();
		}
		return member;
	}
	private static IRoleAvatarDao roleAvatar = null;
	private static IRoleAvatarDao getRoleAvatarDao(){
		if(roleAvatar == null){
			roleAvatar = new RoleAvatarDaoImpl();
		}
		return roleAvatar;
	}
	private static IRoleTavernDao roletavern = null;
	private static IRoleTavernDao getRoleTavernDao(){
		if(roletavern == null){
			roletavern = new RoleTavernDaoImpl();
		}
		return roletavern;
	}
	private static IServerDao server = null;
	private static IServerDao getServerDao(){
		if(server == null){
			server = new ServerDaoImpl();
		}
		return server;
	}
	private static IStatetostateDao statetostate = null;
	private static IStatetostateDao getStatetostateDao(){
		if(statetostate == null){
			statetostate = new StatetostateDaoImpl();
		}
		return statetostate;
	}
	
	private String name = null;
	public ThreadCache(){}
	public ThreadCache(String name){
		this.setName(name);
	}
	public void run(){
		String name = this.getName();
		boolean bo = false;
		if(name.equals("gameRole")){
			//System.out.println("同步线程启动！" + this.getName());
			int time = 300000;
			int l = null == CacheGameRole.gameRoleQueue? 0:CacheGameRole.gameRoleQueue.size();
			//System.out.println("CacheGameRole________________________________l:" + l + " size:" + CacheGameRole.gameRoleQueue_in.size());
			if(CacheGameRole.gameRoleQueue_in.size() > 0){
				for(int n = 0; n < CacheGameRole.gameRoleQueue_in.size(); n++){
					try{
						GameRoleDetail gameRoleDetail = (GameRoleDetail)CacheGameRole.gameRoleQueue_in.front();
						if(null != gameRoleDetail){
							this.getGameRoleDao().insertGameRole(gameRoleDetail);
							CacheGameRole.gameRoleQueue_in.dequeue();
						}else{
							CacheGameRole.gameRoleQueue_in.clear();
							l = CacheGameRole.gameRoleQueue_in.size();
						}
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}
			}
			for(int i = 0; i <= l; ){
				try{
					if(l > 0){
						//队列有内容
						//GameConstants.log.warn("ThreadCache.updateFlag:" + QueueCache.updateFlag);
						if(QueueCache.updateFlag == 1){
							if(CacheGameRole.gameRoleQueue_in.size() > 0){
								for(int n = 0; n < CacheGameRole.gameRoleQueue_in.size(); n++){
									try{
										GameRoleDetail gameRoleDetail = (GameRoleDetail)CacheGameRole.gameRoleQueue_in.front();
										if(null != gameRoleDetail){
											this.getGameRoleDao().insertGameRole(gameRoleDetail);
											CacheGameRole.gameRoleQueue_in.dequeue();
										}else{
											CacheGameRole.gameRoleQueue_in.clear();
											l = CacheGameRole.gameRoleQueue_in.size();
										}
									}catch(Exception e){
										e.printStackTrace();
									}
									
								}
							}
							GameRoleDetail gameRoleDetail = (GameRoleDetail)CacheGameRole.gameRoleQueue.front();
							//System.out.println("gg_____________________________________________xc:" + gameRoleDetail.getIsUpdate());
							if(null != gameRoleDetail){
								//GameConstants.log.warn("gg_____________________________________________xc:" + gameRoleDetail.getCoin() + " indexMap:" + CacheGameRole.gameRoleQueue.indexMap.size());
								if(gameRoleDetail.getIsUpdate() == 1){
									//System.out.println(this.getName() + "更新：" + gameRoleDetail.getId());
									this.getGameRoleDao().updateGameRole(gameRoleDetail);
									CacheGameRole.gameRoleQueue.dequeue();
									CacheGameRole.gameRoleQueue.indexMap.remove(gameRoleDetail.getId());
								}else if(gameRoleDetail.getIsUpdate() == 2){
									//System.out.println(this.getName() + "插入：" + gameRoleDetail.getId());
									this.getGameRoleDao().insertGameRole(gameRoleDetail);
									CacheGameRole.gameRoleQueue.dequeue();
									CacheGameRole.gameRoleQueue.indexMap.remove(gameRoleDetail.getId());
								}else if(gameRoleDetail.getIsUpdate() == 3){
									
								}else{
									System.out.println("队列内存在参数异常！");
								}
							}else{
//								System.out.println("CacheGameRole.gameRoleQueue:" + CacheGameRole.gameRoleQueue.size());
//								CacheGameRole.gameRoleQueue.nextHeader();
//								CacheGameRole.gameRoleQueue.dequeue();
								CacheGameRole.gameRoleQueue.clear();
								l = CacheGameRole.gameRoleQueue.size();
							}
							
						}else{
							Thread.sleep(2000);
						}
						
					}else{
						//队列为空，一秒钟一次的定时器检测CacheGameRole
						try{
							if(bo){
								bo = false;
//								GameConstants.log.warn("END:ThreadCache Name:" + this.getName());
//								ServerHandler.debugQueue();
//								System.out.println(this.getName() + "队列内无内容：" + l + "进入休眠时间：" + time);
							}
							this.sleep(time);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
						l = CacheGameRole.gameRoleQueue.size();
						if(l == 0 && CacheGameRole.gameRoleQueue_in.size() > 0){
							l = CacheGameRole.gameRoleQueue_in.size();
						}
						
						if(l != 0){
							bo = true;
							//System.out.println(this.getName() + "得到的队列长度：" + l);
//							GameConstants.log.warn("START:ThreadCache Name:" + this.getName());
//							ServerHandler.debugQueue();
						}		
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
				//l = CacheGameRole.gameRoleQueue.size();
			}
		}else if(name.equals("RoleTarven")){

			//System.out.println("同步线程启动！" + this.getName());
			int time = 300000;
			int l = null == CacheRoleTarven.RoleTarvenQueue? 0:CacheRoleTarven.RoleTarvenQueue.size();
			if(CacheRoleTarven.RoleTarvenQueue_in.size() > 0){
				for(int n = 0; n < CacheRoleTarven.RoleTarvenQueue_in.size(); n++){
					try{
						RoleTavernDetail roleTavernDetail = (RoleTavernDetail)CacheRoleTarven.RoleTarvenQueue_in.front();
						if(null != roleTavernDetail){
							this.getRoleTavernDao().insertRoleTavern(roleTavernDetail);
							CacheRoleTarven.RoleTarvenQueue_in.dequeue();
						}else{
							CacheRoleTarven.RoleTarvenQueue_in.clear();
							l = CacheRoleTarven.RoleTarvenQueue_in.size();
						}
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}
			}
			for(int i = 0; i <= l; ){
				try{
					if(l > 0){
						//队列有内容
						if(QueueCache.updateFlag == 1){
							if(CacheRoleTarven.RoleTarvenQueue_in.size() > 0){
								for(int n = 0; n < CacheRoleTarven.RoleTarvenQueue_in.size(); n++){
									try{
										RoleTavernDetail roleTavernDetail = (RoleTavernDetail)CacheRoleTarven.RoleTarvenQueue_in.front();
										if(null != roleTavernDetail){
											this.getRoleTavernDao().insertRoleTavern(roleTavernDetail);
											CacheRoleTarven.RoleTarvenQueue_in.dequeue();
										}else{
											CacheRoleTarven.RoleTarvenQueue_in.clear();
											l = CacheRoleTarven.RoleTarvenQueue_in.size();
										}
									}catch(Exception e){
										e.printStackTrace();
									}
									
								}
							}
							//System.out.println(this.getName() + "队列有内容:" + l);
							RoleTavernDetail roleTavernDetail = (RoleTavernDetail)CacheRoleTarven.RoleTarvenQueue.front();
							if(null != roleTavernDetail){
								if(roleTavernDetail.getIsUpdate() == 1){
									//System.out.println(this.getName() + "更新：" + roleTavernDetail.getId());
									this.getRoleTavernDao().updateRoleTavern(roleTavernDetail);
									CacheRoleTarven.RoleTarvenQueue.dequeue();
									CacheRoleTarven.RoleTarvenQueue.indexMap.remove(roleTavernDetail.getRoleId());
								}else if(roleTavernDetail.getIsUpdate() == 2){
									//System.out.println(this.getName() + "插入：" + roleTavernDetail.getId());
									this.getRoleTavernDao().insertRoleTavern(roleTavernDetail);
									CacheRoleTarven.RoleTarvenQueue.dequeue();
									CacheRoleTarven.RoleTarvenQueue.indexMap.remove(roleTavernDetail.getRoleId());
								}else if(roleTavernDetail.getIsUpdate() == 3){
									
								}else{
									System.out.println("队列内存在参数异常！");
								}
							}else{
//								CacheRoleTarven.RoleTarvenQueue.nextHeader();
//								CacheRoleTarven.RoleTarvenQueue.dequeue();
								CacheRoleTarven.RoleTarvenQueue.clear();
								l = CacheRoleTarven.RoleTarvenQueue.size();
							}
							
						}else{
							Thread.sleep(2000);
						}
						
					}else{
						//队列为空，一秒钟一次的定时器检测CacheGameRole
						try{
							if(bo){
								bo = false;
//								GameConstants.log.warn("END:ThreadCache Name:" + this.getName());
//								ServerHandler.debugQueue();
//								System.out.println(this.getName() + "队列内无内容：" + l + "进入休眠时间：" + time);
							}
							this.sleep(time);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
						l = CacheRoleTarven.RoleTarvenQueue.size();
						if(l == 0 && CacheRoleTarven.RoleTarvenQueue_in.size() > 0){
							l = CacheRoleTarven.RoleTarvenQueue_in.size();
						}
						if(l != 0){
							bo = true;
							//System.out.println(this.getName() + "得到的队列长度：" + l);
//							GameConstants.log.warn("START:ThreadCache Name:" + this.getName());
//							ServerHandler.debugQueue();
						}		
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
				//l = CacheRoleTarven.RoleTarvenQueue.size();
			}
		
		}else if(name.equals("autoId")){
			//System.out.println("同步线程启动！" + this.getName());
			int time = 300000;
			int l = null == CacheAutoId.autoIdQueue? 0:CacheAutoId.autoIdQueue.size();
			for(int i = 0; i <= l; ){
				try{
					if(l > 0){
						//队列有内容
						if(QueueCache.updateFlag == 1){
							//System.out.println(this.getName() + "队列有内容:" + l);
							AutoIdDetail autoIdDetail = (AutoIdDetail)CacheAutoId.autoIdQueue.front();
							if(null != autoIdDetail){
								if(autoIdDetail.getIsUpdate() == 1){
									//System.out.println(this.getName() + "更新：" + autoIdDetail.getId());
									this.getAutoIdDao().updateAutoId(autoIdDetail);
									CacheAutoId.autoIdQueue.dequeue();
								}else if(autoIdDetail.getIsUpdate() == 2){
									//System.out.println(this.getName() + "插入：" + autoIdDetail.getId());
									this.getAutoIdDao().insertAutoId(autoIdDetail);
									CacheAutoId.autoIdQueue.dequeue();
								}else if(autoIdDetail.getIsUpdate() == 3){
										
								}else{
									System.out.println("队列内存在参数异常！");
								}
							}else{
//								CacheAutoId.autoIdQueue.nextHeader();
//								CacheAutoId.autoIdQueue.dequeue();
								CacheAutoId.autoIdQueue.clear();
								l = CacheAutoId.autoIdQueue.size();
							}
						}else{
							Thread.sleep(2000);
						}
						
						
					}else{
						//队列为空，一秒钟一次的定时器检测CacheGameRole
						try{
							if(bo){
								bo = false;
//								GameConstants.log.warn("END:ThreadCache Name:" + this.getName());
//								ServerHandler.debugQueue();
//								System.out.println(this.getName() + "队列内无内容：" + l + "进入休眠时间：" + time);
							}
							this.sleep(time);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
						l = CacheAutoId.autoIdQueue.size();
						if(l != 0){
							bo = true;
							//System.out.println(this.getName() + "得到的队列长度：" + l);
//							GameConstants.log.warn("START:ThreadCache Name:" + this.getName());
//							ServerHandler.debugQueue();
						}		
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
				//l = CacheAutoId.autoIdQueue.size();
			}
		}else if(name.equals("cdkStore")){
//			System.out.println("同步线程启动！" + this.getName());
			int time = 300000;
			int l = null == CacheCdkStore.cdkStoreQueue? 0:CacheCdkStore.cdkStoreQueue.size();
			for(int i = 0; i <= l; ){
				try{
					if(l > 0){
						//队列有内容
						if(QueueCache.updateFlag == 1){
							System.out.println(this.getName() + "队列有内容:" + l);
							CdkStoreDetail cdkStoreDetail = (CdkStoreDetail)CacheCdkStore.cdkStoreQueue.front();
							if(null != cdkStoreDetail){
								if(cdkStoreDetail.getIsUpdate() == 1){
									//System.out.println(this.getName() + "更新：" + autoIdDetail.getId());
									this.getCdkStoreDao().Updatemploy(cdkStoreDetail);
									CacheCdkStore.cdkStoreQueue.dequeue();
								}else if(cdkStoreDetail.getIsUpdate() == 2){
								}else if(cdkStoreDetail.getIsUpdate() == 3){
										
								}else{
									System.out.println("队列内存在参数异常！");
								}
							}else{
//								CacheAutoId.autoIdQueue.nextHeader();
//								CacheAutoId.autoIdQueue.dequeue();
								CacheAutoId.autoIdQueue.clear();
								l = CacheAutoId.autoIdQueue.size();
							}
						}else{
							Thread.sleep(2000);
						}
						
						
					}else{
						//队列为空，一秒钟一次的定时器检测CacheGameRole
						try{
							if(bo){
								bo = false;
//								GameConstants.log.warn("END:ThreadCache Name:" + this.getName());
//								ServerHandler.debugQueue();
//								System.out.println(this.getName() + "队列内无内容：" + l + "进入休眠时间：" + time);
							}
							this.sleep(time);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
						l = CacheCdkStore.cdkStoreQueue.size();
						if(l != 0){
							bo = true;
							//System.out.println(this.getName() + "得到的队列长度：" + l);
//							GameConstants.log.warn("START:ThreadCache Name:" + this.getName());
//							ServerHandler.debugQueue();
						}		
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
				//l = CacheAutoId.autoIdQueue.size();
			}
		}else if(name.equals("challengeRecord")){
			//System.out.println("同步线程启动！" + this.getName());
			int time = 300000;
			int l = null == CacheChallengeRecord.challengeRecordQueue? 0:CacheChallengeRecord.challengeRecordQueue.size();
			for(int i = 0; i <= l; ){
				try{
					if(l > 0){
						//队列有内容
						if(QueueCache.updateFlag == 1){
							//	System.out.println(this.getName() + "队列有内容:" + l);
							ChallengeRecordDetail challengeRecordDetail = (ChallengeRecordDetail)CacheChallengeRecord.challengeRecordQueue.front();
							if(null != challengeRecordDetail){
								if(challengeRecordDetail.getIsUpdate() == 1){
									//System.out.println(this.getName() + "更新：" + challengeRecordDetail.getId());
									this.getChallengeRecordDao().updateChallengeRecord(challengeRecordDetail);
									CacheChallengeRecord.challengeRecordQueue.dequeue();
								}else if(challengeRecordDetail.getIsUpdate() == 2){
									//System.out.println(this.getName() + "插入：" + challengeRecordDetail.getId());
									this.getChallengeRecordDao().insertChallengeRecord(challengeRecordDetail);
									CacheChallengeRecord.challengeRecordQueue.dequeue();
								}else if(challengeRecordDetail.getIsUpdate() == 3){
											
								}else{
									System.out.println("队列内存在参数异常！");
								}
							}else{
//								CacheChallengeRecord.challengeRecordQueue.nextHeader();
//								CacheChallengeRecord.challengeRecordQueue.dequeue();
								CacheChallengeRecord.challengeRecordQueue.clear();
								l = CacheChallengeRecord.challengeRecordQueue.size();
							}
						}else{
							Thread.sleep(2000);
						}
				
						
					}else{
						//队列为空，一秒钟一次的定时器检测CacheGameRole
						try{
							if(bo){
								bo = false;
//								GameConstants.log.warn("END:ThreadCache Name:" + this.getName());
//								ServerHandler.debugQueue();
//								System.out.println(this.getName() + "队列内无内容：" + l + "进入休眠时间：" + time);
							}
							this.sleep(time);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
						l = CacheChallengeRecord.challengeRecordQueue.size();
						if(l != 0){
							bo = true;
							//System.out.println(this.getName() + "得到的队列长度：" + l);
//							GameConstants.log.warn("START:ThreadCache Name:" + this.getName());
//							ServerHandler.debugQueue();
						}		
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
				//l = CacheChallengeRecord.challengeRecordQueue.size();
			}
		}else if(name.equals("statetostate")){
			//System.out.println("同步线程启动！" + this.getName());
			int time = 300000;
			int l = null == CacheStatetostate.statetostateQueue? 0:CacheStatetostate.statetostateQueue.size();
			for(int i = 0; i <= l; ){
				try{
					if(l > 0){
						//队列有内容
						if(QueueCache.updateFlag == 1){
								//System.out.println(this.getName() + "队列有内容:" + l);
							StatetostateDetail statetostateDetail = (StatetostateDetail)CacheStatetostate.statetostateQueue.front();
							if(null != statetostateDetail){
								if(statetostateDetail.getIsUpdate() == 1){
									//System.out.println(this.getName() + "更新：" + statetostateDetail.getId());
									this.getStatetostateDao().updateStatetostate(statetostateDetail);
									CacheStatetostate.statetostateQueue.dequeue();
								}else if(statetostateDetail.getIsUpdate() == 2){
									//System.out.println(this.getName() + "插入：" + statetostateDetail.getId() + " des:" + statetostateDetail.getDescribe() + " flag:" + statetostateDetail.getFlag());
									this.getStatetostateDao().insertStatetostate(statetostateDetail);
									CacheStatetostate.statetostateQueue.dequeue();
								}else if(statetostateDetail.getIsUpdate() == 3){
											
								}else{
									System.out.println("队列内存在参数异常！");
								}
							}else{
								CacheStatetostate.statetostateQueue.clear();
								l = CacheStatetostate.statetostateQueue.size();
							}
						}else{
							Thread.sleep(2000);
						}
				
						
					}else{
						//队列为空，一秒钟一次的定时器检测CacheGameRole
						try{
							if(bo){
								bo = false;
								//GameConstants.log.warn("END:ThreadCache Name:" + this.getName());
								ServerHandler.debugQueue();
								//System.out.println(this.getName() + "队列内无内容：" + l + "进入休眠时间：" + time);
							}
							this.sleep(time);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
						l = CacheStatetostate.statetostateQueue.size();
						if(l != 0){
							bo = true;
							//System.out.println(this.getName() + "得到的队列长度：" + l);
							//GameConstants.log.warn("START:ThreadCache Name:" + this.getName());
							ServerHandler.debugQueue();
						}		
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
				//l = CacheChallengeRecord.challengeRecordQueue.size();
			}
		}else if(name.equals("roleBing")){
			//System.out.println("同步线程启动！" + this.getName());
			int time = 300000;
			int l = null == CacheRoleBing.roleBingQueue? 0:CacheRoleBing.roleBingQueue.size();
			for(int i = 0; i <= l; ){
				try{
					if(l > 0){
						//队列有内容
						if(QueueCache.updateFlag == 1){
//							System.out.println(this.getName() + "队列有内容:" + l);
							RoleBingDetail roleBingDetail = (RoleBingDetail)CacheRoleBing.roleBingQueue.front();
							if(null != roleBingDetail){
								if(roleBingDetail.getIsUpdate() == 1){
									//System.out.println(this.getName() + "更新：" + roleBingDetail.getId());
									this.getRoleBingDao().updateRoleBing(roleBingDetail);
									CacheRoleBing.roleBingQueue.dequeue();
								}else if(roleBingDetail.getIsUpdate() == 2){
									//System.out.println(this.getName() + "插入：" + roleBingDetail.getId());
									this.getRoleBingDao().insertRoleBing(roleBingDetail);
									CacheRoleBing.roleBingQueue.dequeue();
								}else if(roleBingDetail.getIsUpdate() == 3){
												
								}else{
									System.out.println("队列内存在参数异常！");
								}
							}else{
//								CacheRoleBing.roleBingQueue.nextHeader();
//								CacheRoleBing.roleBingQueue.dequeue();
								CacheRoleBing.roleBingQueue.clear();
								l = CacheRoleBing.roleBingQueue.size();
							}
						}else{
							Thread.sleep(2000);
						}
					
						
					}else{
						//队列为空，一秒钟一次的定时器检测CacheGameRole
						try{
							if(bo){
								bo = false;
//								GameConstants.log.warn("END:ThreadCache Name:" + this.getName());
//								ServerHandler.debugQueue();
//								System.out.println(this.getName() + "队列内无内容：" + l + "进入休眠时间：" + time);
							}
							this.sleep(time);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
						l = CacheRoleBing.roleBingQueue.size();
						if(l != 0){
							bo = true;
							//System.out.println(this.getName() + "得到的队列长度：" + l);
//							GameConstants.log.warn("START:ThreadCache Name:" + this.getName());
//							ServerHandler.debugQueue();
						}		
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
				//l = CacheRoleBing.roleBingQueue.size();
			}
		}else if(name.equals("roleChallenge")){
			//System.out.println("同步线程启动！" + this.getName());
			int time = 300000;
			int l = null == CacheRoleChallenge.roleChallengeQueue? 0:CacheRoleChallenge.roleChallengeQueue.size();
			for(int i = 0; i <= l; ){
				try{
					if(l > 0){
						//队列有内容
						if(QueueCache.updateFlag == 1){
							//System.out.println(this.getName() + "队列有内容:" + l);
							RoleChallengeDetail roleChallengeDetail = (RoleChallengeDetail)CacheRoleChallenge.roleChallengeQueue.front();
							if(null != roleChallengeDetail){
								if(roleChallengeDetail.getIsUpdate() == 1){
									//System.out.println(this.getName() + "更新：" + roleChallengeDetail.getId());
									this.getRoleChallengeDao().updateRoleChallenge(roleChallengeDetail);
									CacheRoleChallenge.roleChallengeQueue.dequeue();
								}else if(roleChallengeDetail.getIsUpdate() == 2){
									//System.out.println(this.getName() + "插入：" + roleChallengeDetail.getId());
									this.getRoleChallengeDao().insertRoleChallenge(roleChallengeDetail);
									CacheRoleChallenge.roleChallengeQueue.dequeue();
								}else if(roleChallengeDetail.getIsUpdate() == 3){
												
								}else{
									System.out.println("队列内存在参数异常！");
								}
							}else{
//								System.out.println("roleChallengeQueue:" + CacheRoleChallenge.roleChallengeQueue.size());
//								CacheRoleChallenge.roleChallengeQueue.nextHeader();
//								CacheRoleChallenge.roleChallengeQueue.dequeue();
								CacheRoleChallenge.roleChallengeQueue.clear();
								l = CacheRoleChallenge.roleChallengeQueue.size();
							}
						}else{
							Thread.sleep(2000);
						}
						
						
					}else{
						//队列为空，一秒钟一次的定时器检测CacheGameRole
						try{
							if(bo){
								bo = false;
//								GameConstants.log.warn("END:ThreadCache Name:" + this.getName());
//								ServerHandler.debugQueue();
//								System.out.println(this.getName() + "队列内无内容：" + l + "进入休眠时间：" + time);
							}
							this.sleep(time);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
						l = CacheRoleChallenge.roleChallengeQueue.size();
						if(l != 0){
							bo = true;
							//System.out.println(this.getName() + "得到的队列长度：" + l);
//							GameConstants.log.warn("START:ThreadCache Name:" + this.getName());
//							ServerHandler.debugQueue();
						}		
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
				//l = CacheRoleChallenge.roleChallengeQueue.size();
			}
		
		}else if(name.equals("roleDaytask")){
			//System.out.println("同步线程启动！" + this.getName());
			int time = 300000;
			int l = null == CacheRoleDaytask.roleDaytaskQueue? 0:CacheRoleDaytask.roleDaytaskQueue.size();
			//System.out.println("ROleDayTask________________________________l:" + l + " size:" + CacheRoleDaytask.roleDaytaskQueue_in.size());
			if(CacheRoleDaytask.roleDaytaskQueue_in.size() > 0){
				for(int n = 0; n < CacheRoleDaytask.roleDaytaskQueue_in.size(); n++){
					try{
						RoleDaytaskDetail roleDaytaskDetail = (RoleDaytaskDetail)CacheRoleDaytask.roleDaytaskQueue_in.front();
						if(null != roleDaytaskDetail){
							this.getRoleDaytaskDao().insertRoleDaytask(roleDaytaskDetail);
							CacheRoleDaytask.roleDaytaskQueue_in.dequeue();
						}else{
//							CacheRoleDaytask.roleDaytaskQueue_in.nextHeader();
//							CacheRoleDaytask.roleDaytaskQueue_in.dequeue();
							CacheRoleDaytask.roleDaytaskQueue_in.clear();
							l = CacheRoleDaytask.roleDaytaskQueue_in.size();
						}
						
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}
			}
			for(int i = 0; i <= l; ){
				try{
					if(l > 0){
						//队列有内容
						if(QueueCache.updateFlag == 1){
							if(CacheRoleDaytask.roleDaytaskQueue_in.size() > 0){
								for(int n = 0; n < CacheRoleDaytask.roleDaytaskQueue_in.size(); n++){
									RoleDaytaskDetail roleDaytaskDetail = (RoleDaytaskDetail)CacheRoleDaytask.roleDaytaskQueue_in.front();
									if(null != roleDaytaskDetail){
										//System.out.println(this.getName() + "插入：" + roleDaytaskDetail.getId() + "  roleid:" + roleDaytaskDetail.getRoleid());
										this.getRoleDaytaskDao().insertRoleDaytask(roleDaytaskDetail);
										CacheRoleDaytask.roleDaytaskQueue_in.dequeue();
									}else{
//										CacheRoleDaytask.roleDaytaskQueue_in.nextHeader();
//										CacheRoleDaytask.roleDaytaskQueue_in.dequeue();
										CacheRoleDaytask.roleDaytaskQueue_in.clear();
										l = CacheRoleDaytask.roleDaytaskQueue_in.size();

									}
									
								}
								
							}
						//	System.out.println(this.getName() + "队列有内容:" + l);
							RoleDaytaskDetail roleDaytaskDetail = (RoleDaytaskDetail)CacheRoleDaytask.roleDaytaskQueue.front();
							if(null != roleDaytaskDetail){
								//System.out.println("roleDaytask:____________________________size:" + l);
								if(roleDaytaskDetail.getIsUpdate() == 1){
									//System.out.println(this.getName() + "更新：" + roleDaytaskDetail.getId() + "  roleid:" + roleDaytaskDetail.getRoleid());
									this.getRoleDaytaskDao().updateRoleDaytask(roleDaytaskDetail);
									CacheRoleDaytask.roleDaytaskQueue.indexMap.remove(roleDaytaskDetail.getRoleid());
									CacheRoleDaytask.roleDaytaskQueue.dequeue();
								}else if(roleDaytaskDetail.getIsUpdate() == 2){
									//System.out.println(this.getName() + "插入：" + roleDaytaskDetail.getId() + "  roleid:" + roleDaytaskDetail.getRoleid());
									this.getRoleDaytaskDao().insertRoleDaytask(roleDaytaskDetail);
									CacheRoleDaytask.roleDaytaskQueue.dequeue();
								}else if(roleDaytaskDetail.getIsUpdate() == 3){
									
								}else{
									System.out.println("队列内存在参数异常！");
								}
							}else{
//								System.out.println("CacheRoleDaytask.roleDaytaskQueue:" + CacheRoleDaytask.roleDaytaskQueue.size());
//								CacheRoleDaytask.roleDaytaskQueue.nextHeader();
//								CacheRoleDaytask.roleDaytaskQueue.dequeue();
								CacheRoleDaytask.roleDaytaskQueue.clear();
								l = CacheRoleDaytask.roleDaytaskQueue.size();
							}
						}else{
							Thread.sleep(2000);
						}
						
						
					}else{
						//队列为空，一秒钟一次的定时器检测CacheGameRole
						try{
							if(bo){
								bo = false;
//								GameConstants.log.warn("END:ThreadCache Name:" + this.getName());
//								ServerHandler.debugQueue();
//								System.out.println(this.getName() + "队列内无内容：" + l + "进入休眠时间：" + time);
							}
							this.sleep(time);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
						l = CacheRoleDaytask.roleDaytaskQueue.size();
						if(l == 0 && CacheRoleDaytask.roleDaytaskQueue_in.size() > 0){
							l = CacheRoleDaytask.roleDaytaskQueue_in.size();
						}
						if(l != 0){
							bo = true;
							//System.out.println(this.getName() + "得到的队列长度：" + l);
//							GameConstants.log.warn("START:ThreadCache Name:" + this.getName());
//							ServerHandler.debugQueue();
						}		
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
				//l = CacheRoleDaytask.roleDaytaskQueue.size();
			}
		}else if(name.equals("roleEquip")){
		//	System.out.println("同步线程启动！" + this.getName());
			int time = 300000;
			int l = null == CacheRoleEquip.roleEquipQueue? 0:CacheRoleEquip.roleEquipQueue.size();
			if(CacheRoleEquip.roleEquipQueue_in.size() > 0){
				for(int n = 0; n < CacheRoleEquip.roleEquipQueue_in.size(); n++){
					try{
						RoleEquipDetail roleEquipDetail = (RoleEquipDetail)CacheRoleEquip.roleEquipQueue_in.front();
						if(null != roleEquipDetail){
							this.getRoleEquipDao().insertRoleEquip(roleEquipDetail);
							CacheRoleEquip.roleEquipQueue_in.dequeue();
						}else{
							CacheRoleEquip.roleEquipQueue_in.clear();
							l = CacheRoleEquip.roleEquipQueue_in.size();
						}
						
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}
			}
			for(int i = 0; i <= l; ){
				try{
					if(l > 0){
						//队列有内容
						if(QueueCache.updateFlag == 1){
							if(CacheRoleEquip.roleEquipQueue_in.size() > 0){
								for(int n = 0; n < CacheRoleEquip.roleEquipQueue_in.size(); n++){
									try{
										RoleEquipDetail roleEquipDetail = (RoleEquipDetail)CacheRoleEquip.roleEquipQueue_in.front();
										if(null != roleEquipDetail){
											this.getRoleEquipDao().insertRoleEquip(roleEquipDetail);
											CacheRoleEquip.roleEquipQueue_in.dequeue();
										}else{
											CacheRoleEquip.roleEquipQueue_in.clear();
											l = CacheRoleEquip.roleEquipQueue_in.size();
										}
										
									}catch(Exception e){
										e.printStackTrace();
									}
									
								}
							}
//							System.out.println(this.getName() + "队列有内容:" + l);
							RoleEquipDetail roleEquipDetail = (RoleEquipDetail)CacheRoleEquip.roleEquipQueue.front();
							if(null != roleEquipDetail){
								if(roleEquipDetail.getIsUpdate() == 1){
									//System.out.println(this.getName() + "更新：" + roleEquipDetail.getId());
									this.getRoleEquipDao().updateRoleEquip(roleEquipDetail);
									CacheRoleEquip.roleEquipQueue.dequeue();
									CacheRoleEquip.roleEquipQueue.indexMap.remove(roleEquipDetail.getId());
								}else if(roleEquipDetail.getIsUpdate() == 2){
									//System.out.println(this.getName() + "插入：" + roleEquipDetail.getId());
									this.getRoleEquipDao().insertRoleEquip(roleEquipDetail);
									CacheRoleEquip.roleEquipQueue.dequeue();
								}else if(roleEquipDetail.getIsUpdate() == 3){
									//System.out.println(this.getName() + "删除：" + roleEquipDetail.getId());
									this.getRoleEquipDao().deleteRoleEquip(roleEquipDetail);
									CacheRoleEquip.roleEquipQueue.dequeue();
								}else{
									System.out.println("队列内存在参数异常！");
								}
							}else{
//								CacheRoleEquip.roleEquipQueue.nextHeader();
//								CacheRoleEquip.roleEquipQueue.dequeue();
								CacheRoleEquip.roleEquipQueue.clear();
								l = CacheRoleEquip.roleEquipQueue.size();
							}
						}else{
							Thread.sleep(2000);
						}
					
						
					}else{
						//队列为空，一秒钟一次的定时器检测CacheGameRole
						try{
							if(bo){
								bo = false;
//								GameConstants.log.warn("END:ThreadCache Name:" + this.getName());
//								ServerHandler.debugQueue();
//								System.out.println(this.getName() + "队列内无内容：" + l + "进入休眠时间：" + time);
							}
							this.sleep(time);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
						l = CacheRoleEquip.roleEquipQueue.size();
						if(l == 0 && CacheRoleEquip.roleEquipQueue_in.size() > 0){
							l = CacheRoleEquip.roleEquipQueue_in.size();
						}
						
						if(l != 0){
							bo = true;
							//System.out.println(this.getName() + "得到的队列长度：" + l);
//							GameConstants.log.warn("START:ThreadCache Name:" + this.getName());
//							ServerHandler.debugQueue();
						}		
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
				//l = CacheRoleEquip.roleEquipQueue.size();
			}
		}else if(name.equals("roleImpose")){
//			System.out.println("同步线程启动！" + this.getName());
			int time = 300000;
			int l = null == CacheRoleImpose.roleImposeQueue? 0:CacheRoleImpose.roleImposeQueue.size();
			for(int i = 0; i <= l; ){
				try{
					if(l > 0){
						//队列有内容
						if(QueueCache.updateFlag == 1){
							//System.out.println(this.getName() + "队列有内容:" + l);
							RoleImposeDetail roleImposeDetail = (RoleImposeDetail)CacheRoleImpose.roleImposeQueue.front();
							if(null != roleImposeDetail){
								if(roleImposeDetail.getIsUpdate() == 1){
									//System.out.println(this.getName() + "更新：" + roleImposeDetail.getRoleid());
									this.getRoleImposeDao().updateRoleImpose(roleImposeDetail);
									CacheRoleImpose.roleImposeQueue.dequeue();
								}else if(roleImposeDetail.getIsUpdate() == 2){
									//System.out.println(this.getName() + "插入：" + roleImposeDetail.getRoleid());
									this.getRoleImposeDao().insertRoleImpose(roleImposeDetail);
									CacheRoleImpose.roleImposeQueue.dequeue();
								}else if(roleImposeDetail.getIsUpdate() == 3){
												
								}else{
									System.out.println("队列内存在参数异常！");
								}
							}else{
//								CacheRoleImpose.roleImposeQueue.nextHeader();
//								CacheRoleImpose.roleImposeQueue.dequeue();
								CacheRoleImpose.roleImposeQueue.clear();
								l = CacheRoleImpose.roleImposeQueue.size();
							}
						}else{
							Thread.sleep(2000);
						}
						
						
					}else{
						//队列为空，一秒钟一次的定时器检测CacheGameRole
						try{
							if(bo){
								bo = false;
//								GameConstants.log.warn("END:ThreadCache Name:" + this.getName());
//								ServerHandler.debugQueue();
//								System.out.println(this.getName() + "队列内无内容：" + l + "进入休眠时间：" + time);
							}
							this.sleep(time);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
						l = CacheRoleImpose.roleImposeQueue.size();
						if(l != 0){
							bo = true;
							//System.out.println(this.getName() + "得到的队列长度：" + l);
//							GameConstants.log.warn("START:ThreadCache Name:" + this.getName());
//							ServerHandler.debugQueue();
						}		
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
				//l = CacheRoleImpose.roleImposeQueue.size();
			}
		}else if(name.equals("roleIns")){
			//System.out.println("同步线程启动！" + this.getName());
			int time = 300000;
			int l = null == CacheRoleIns.roleInsQueue? 0:CacheRoleIns.roleInsQueue.size();
			for(int i = 0; i <= l; ){
				try{
					if(l > 0){
						//队列有内容
						if(QueueCache.updateFlag == 1){
							//System.out.println(this.getName() + "队列有内容:" + l);
							RoleInsDetail roleInsDetail = (RoleInsDetail)CacheRoleIns.roleInsQueue.front();
							if(null != roleInsDetail){
								if(roleInsDetail.getIsUpdate() == 1){
									//System.out.println(this.getName() + "更新：" + roleInsDetail.getRoleId());
									this.getRoleInsDao().updateRoleIns(roleInsDetail);
									CacheRoleIns.roleInsQueue.dequeue();
								}else if(roleInsDetail.getIsUpdate() == 2){
									//System.out.println(this.getName() + "插入：" + roleInsDetail.getRoleId());
									this.getRoleInsDao().insertRoleIns(roleInsDetail);
									CacheRoleIns.roleInsQueue.dequeue();
								}else if(roleInsDetail.getIsUpdate() == 3){
												
								}else{
									System.out.println("队列内存在参数异常！");
								}
							}else{
//								CacheRoleIns.roleInsQueue.nextHeader();
//								CacheRoleIns.roleInsQueue.dequeue();
								CacheRoleIns.roleInsQueue.clear();
								l = CacheRoleIns.roleInsQueue.size();
							}
						}else{
							Thread.sleep(2000);
						}
						
						
					}else{
						//队列为空，一秒钟一次的定时器检测CacheGameRole
						try{
							if(bo){
								bo = false;
//								GameConstants.log.warn("END:ThreadCache Name:" + this.getName());
//								ServerHandler.debugQueue();
//								System.out.println(this.getName() + "队列内无内容：" + l + "进入休眠时间：" + time);
							}
							this.sleep(time);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
						l = CacheRoleIns.roleInsQueue.size();
						if(l != 0){
							bo = true;
							System.out.println(this.getName() + "得到的队列长度：" + l);
//							GameConstants.log.warn("START:ThreadCache Name:" + this.getName());
//							ServerHandler.debugQueue();
						}		
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
				//l = CacheRoleIns.roleInsQueue.size();
			}
		
		}else if(name.equals("roleItem")){
			//System.out.println("同步线程启动！" + this.getName());
			int time = 300000;
			int l = null == CacheRoleItem.roleItemQueue? 0:CacheRoleItem.roleItemQueue.size();
			if(CacheRoleItem.roleItemQueue_in.size() > 0){
				for(int n = 0; n < CacheRoleItem.roleItemQueue_in.size(); n++){
					try{
						RoleItemDetail roleItemDetail = (RoleItemDetail)CacheRoleItem.roleItemQueue_in.front();
						if(null != roleItemDetail){
							this.getRoleItemDao().insertRoleItem(roleItemDetail);
							CacheRoleItem.roleItemQueue_in.dequeue();
						}else{
							CacheRoleItem.roleItemQueue_in.clear();
							l = CacheRoleItem.roleItemQueue_in.size();
						}
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}
			}
			for(int i = 0; i <= l; ){
				try{
					if(l > 0){
						//队列有内容
						if(QueueCache.updateFlag == 1){
							if(CacheRoleItem.roleItemQueue_in.size() > 0){
								for(int n = 0; n < CacheRoleItem.roleItemQueue_in.size(); n++){
									try{
										RoleItemDetail roleItemDetail = (RoleItemDetail)CacheRoleItem.roleItemQueue_in.front();
										if(null != roleItemDetail){
											this.getRoleItemDao().insertRoleItem(roleItemDetail);
											CacheRoleItem.roleItemQueue_in.dequeue();
										}else{
											CacheRoleItem.roleItemQueue_in.clear();
											l = CacheRoleItem.roleItemQueue_in.size();
										}
									}catch(Exception e){
										e.printStackTrace();
									}
									
								}
							}
							//System.out.println(this.getName() + "队列有内容:" + l);
							RoleItemDetail roleItemDetail = (RoleItemDetail)CacheRoleItem.roleItemQueue.front();
							if(null != roleItemDetail){
								if(roleItemDetail.getIsUpdate() == 1){
									//System.out.println(this.getName() + "更新：" + roleItemDetail.getRoleid() + " itemid:" + roleItemDetail.getItemid() + " num:" + roleItemDetail.getNum());
									this.getRoleItemDao().updateRoleItem(roleItemDetail);
									CacheRoleItem.roleItemQueue.dequeue();
									CacheRoleItem.roleItemQueue.indexMapl.remove(roleItemDetail.getId());
								}else if(roleItemDetail.getIsUpdate() == 2){
									//System.out.println(this.getName() + "插入：" + roleItemDetail.getRoleid() + " itemid:" + roleItemDetail.getItemid() + " num:" + roleItemDetail.getNum());
									this.getRoleItemDao().insertRoleItem(roleItemDetail);
									CacheRoleItem.roleItemQueue.dequeue();
									CacheRoleItem.roleItemQueue.indexMapl.remove(roleItemDetail.getId());
								}else if(roleItemDetail.getIsUpdate() == 3){
									//System.out.println(this.getName() + "删除：" + roleItemDetail.getRoleid() + " itemid:" + roleItemDetail.getItemid() + " num:" + roleItemDetail.getNum());
									this.getRoleItemDao().deleteRoleItem(roleItemDetail);
									CacheRoleItem.roleItemQueue.dequeue();
								}else{
									System.out.println("队列内存在参数异常！");
								}
							}else{
//								CacheRoleItem.roleItemQueue.nextHeader();
//								CacheRoleItem.roleItemQueue.dequeue();
								CacheRoleItem.roleItemQueue.clear();
								l = CacheRoleItem.roleItemQueue.size();
							}
						}else{
							Thread.sleep(2000);
						}
						
						
					}else{
						//队列为空，一秒钟一次的定时器检测CacheGameRole
						try{
							if(bo){
								bo = false;
//								GameConstants.log.warn("END:ThreadCache Name:" + this.getName());
//								ServerHandler.debugQueue();
//								System.out.println(this.getName() + "队列内无内容：" + l + "进入休眠时间：" + time);
							}
							this.sleep(time);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
						l = CacheRoleItem.roleItemQueue.size();
						if(l == 0 && CacheRoleItem.roleItemQueue_in.size() > 0){
							l = CacheRoleItem.roleItemQueue_in.size();
						}
						if(l != 0){
							bo = true;
							//System.out.println(this.getName() + "得到的队列长度：" + l);
//							GameConstants.log.warn("START:ThreadCache Name:" + this.getName());
//							ServerHandler.debugQueue();
						}		
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
				//l = CacheRoleItem.roleItemQueue.size();
			}
		
		}else if(name.equals("roleMap")){
			//System.out.println("同步线程启动！" + this.getName());
			int time = 300000;
			int l = null == CacheRoleMap.roleMapQueue? 0:CacheRoleMap.roleMapQueue.size();
			for(int i = 0; i <= l; ){
				try{
					if(l > 0){
						//队列有内容
						if(QueueCache.updateFlag == 1){
							//System.out.println(this.getName() + "队列有内容:" + l);
							RoleMapDetail roleMapDetail = (RoleMapDetail)CacheRoleMap.roleMapQueue.front();
							if(null != roleMapDetail){
								if(roleMapDetail.getIsUpdate() == 1){
									//System.out.println(this.getName() + "更新：" + roleMapDetail.getRoleId());
									this.getRoleMapDao().updateRoleMap(roleMapDetail);
									CacheRoleMap.roleMapQueue.dequeue();
								}else if(roleMapDetail.getIsUpdate() == 2){
									//System.out.println(this.getName() + "插入：" + roleMapDetail.getRoleId());
									this.getRoleMapDao().insertRoleMap(roleMapDetail);
									CacheRoleMap.roleMapQueue.dequeue();
								}else if(roleMapDetail.getIsUpdate() == 3){
												
								}else{
									System.out.println("队列内存在参数异常！");
								}
							}else{
//								CacheRoleMap.roleMapQueue.nextHeader();
//								CacheRoleMap.roleMapQueue.dequeue();
								CacheRoleMap.roleMapQueue.clear();
								l = CacheRoleMap.roleMapQueue.size();
							}
							
						}else{
							Thread.sleep(2000);
						}
						
					}else{
						//队列为空，一秒钟一次的定时器检测CacheGameRole
						try{
							if(bo){
								bo = false;
//								GameConstants.log.warn("END:ThreadCache Name:" + this.getName());
//								ServerHandler.debugQueue();
//								System.out.println(this.getName() + "队列内无内容：" + l + "进入休眠时间：" + time);
							}
							this.sleep(time);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
						l = CacheRoleMap.roleMapQueue.size();
						if(l != 0){
							bo = true;
							System.out.println(this.getName() + "得到的队列长度：" + l);
//							GameConstants.log.warn("START:ThreadCache Name:" + this.getName());
//							ServerHandler.debugQueue();
						}		
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
				//l = CacheRoleMap.roleMapQueue.size();
			}
		
		}else if(name.equals("roleMilitary")){
			//System.out.println("同步线程启动！" + this.getName());
			int time = 300000;
			int l = null == CacheRoleMilitary.roleMilitaryQueue? 0:CacheRoleMilitary.roleMilitaryQueue.size();
			if(CacheRoleMilitary.roleMilitaryQueue_in.size() > 0){
				for(int n = 0; n < CacheRoleMilitary.roleMilitaryQueue_in.size(); n++){
					try{
						RoleMilitaryDetail roleMilitaryDetail = (RoleMilitaryDetail)CacheRoleMilitary.roleMilitaryQueue_in.front();
						if(null != roleMilitaryDetail){
							this.getRoleMilitaryDao().insertRoleMilitary(roleMilitaryDetail);
							CacheRoleMilitary.roleMilitaryQueue_in.dequeue();
						}else{
							CacheRoleMilitary.roleMilitaryQueue_in.clear();
							l = CacheRoleMilitary.roleMilitaryQueue_in.size();
						}
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}
			}
			for(int i = 0; i <= l; ){
				try{
					if(l > 0){
						//队列有内容
						if(QueueCache.updateFlag == 1){
							if(CacheRoleMilitary.roleMilitaryQueue_in.size() > 0){
								for(int n = 0; n < CacheRoleMilitary.roleMilitaryQueue_in.size(); n++){
									try{
										RoleMilitaryDetail roleMilitaryDetail = (RoleMilitaryDetail)CacheRoleMilitary.roleMilitaryQueue_in.front();
										if(null != roleMilitaryDetail){
											this.getRoleMilitaryDao().insertRoleMilitary(roleMilitaryDetail);
											CacheRoleMilitary.roleMilitaryQueue_in.dequeue();
										}else{
											CacheRoleMilitary.roleMilitaryQueue_in.clear();
											l = CacheRoleMilitary.roleMilitaryQueue_in.size();
										}
									}catch(Exception e){
										e.printStackTrace();
									}
									
								}
							}
//							System.out.println(this.getName() + "队列有内容:" + l);
							RoleMilitaryDetail roleMilitaryDetail = (RoleMilitaryDetail)CacheRoleMilitary.roleMilitaryQueue.front();
							if(null != roleMilitaryDetail){
//								System.out.println("gg_____________________________________________xc:" + roleMilitaryDetail.getIsUpdate());
								//System.out.println("rolemilitary:.roleid:" + roleMilitaryDetail.getRoleId() + "    ||||rroleMilitaryidd:" + roleMilitaryDetail.getMilitaryid() );
								if(roleMilitaryDetail.getIsUpdate() == 1){
							//		System.out.println(this.getName() + "更新：" + roleMilitaryDetail.getRoleId());
									this.getRoleMilitaryDao().updateRoleMilitary(roleMilitaryDetail);
									CacheRoleMilitary.roleMilitaryQueue.dequeue();
									CacheRoleMilitary.roleMilitaryQueue.indexMap.remove(roleMilitaryDetail.getId());
								}else if(roleMilitaryDetail.getIsUpdate() == 2){
							//		System.out.println(this.getName() + "插入：" + roleMilitaryDetail.getRoleId());
									this.getRoleMilitaryDao().insertRoleMilitary(roleMilitaryDetail);
									CacheRoleMilitary.roleMilitaryQueue.dequeue();
									CacheRoleMilitary.roleMilitaryQueue.indexMap.remove(roleMilitaryDetail.getId());
								}else if(roleMilitaryDetail.getIsUpdate() == 3){
							//		System.out.println(this.getName() + "删除：" + roleMilitaryDetail.getRoleId());
									this.getRoleMilitaryDao().deleteRoleMilitary(roleMilitaryDetail);
									CacheRoleMilitary.roleMilitaryQueue.dequeue();
								}else{
									System.out.println("队列内存在参数异常！");
								}
							}else{
//								CacheRoleMilitary.roleMilitaryQueue.nextHeader();
//								CacheRoleMilitary.roleMilitaryQueue.dequeue();
								CacheRoleMilitary.roleMilitaryQueue.clear();
								l = CacheRoleMilitary.roleMilitaryQueue.size();
							}
						}else{
							Thread.sleep(2000);
						}
					
					
					}else{
						//队列为空，一秒钟一次的定时器检测CacheGameRole
						try{
							if(bo){
								bo = false;
//								GameConstants.log.warn("END:ThreadCache Name:" + this.getName());
//								ServerHandler.debugQueue();
//								System.out.println(this.getName() + "队列内无内容：" + l + "进入休眠时间：" + time);
							}
							this.sleep(time);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
						l = CacheRoleMilitary.roleMilitaryQueue.size();
						if(l == 0 && CacheRoleMilitary.roleMilitaryQueue_in.size() > 0){
							l = CacheRoleMilitary.roleMilitaryQueue_in.size();
						}
						if(l != 0){
							bo = true;
//							System.out.println(this.getName() + "得到的队列长度：" + l);
//							GameConstants.log.warn("START:ThreadCache Name:" + this.getName());
							ServerHandler.debugQueue();
						}		
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
				//l = CacheRoleMilitary.roleMilitaryQueue.size();
			}
		
		}else if(name.equals("roleQuicktime")){
			//System.out.println("同步线程启动！" + this.getName());
			int time = 300000;
			int l = null == CacheRoleQuicktime.roleQuicktimeQueue? 0:CacheRoleQuicktime.roleQuicktimeQueue.size();
			for(int i = 0; i <= l; ){
				try{
					if(l > 0){
						//队列有内容
						if(QueueCache.updateFlag == 1){
							//System.out.println(this.getName() + "队列有内容:" + l);
							RoleQuicktimeDetail roleQuicktimeDetail = (RoleQuicktimeDetail)CacheRoleQuicktime.roleQuicktimeQueue.front();
							if(null != roleQuicktimeDetail){
								if(roleQuicktimeDetail.getIsUpdate() == 1){
									//System.out.println(this.getName() + "更新：" + roleQuicktimeDetail.getRoleid());
									this.getRoleQuicktimeDao().updateRoleQuicktime(roleQuicktimeDetail);
									CacheRoleQuicktime.roleQuicktimeQueue.dequeue();
								}else if(roleQuicktimeDetail.getIsUpdate() == 2){
									//System.out.println(this.getName() + "插入：" + roleQuicktimeDetail.getRoleid());
									this.getRoleQuicktimeDao().insertRoleQuicktime(roleQuicktimeDetail);
									CacheRoleQuicktime.roleQuicktimeQueue.dequeue();
								}else if(roleQuicktimeDetail.getIsUpdate() == 3){
												
								}else{
									System.out.println("队列内存在参数异常！");
								}
							}else{
//								CacheRoleQuicktime.roleQuicktimeQueue.nextHeader();
//								CacheRoleQuicktime.roleQuicktimeQueue.dequeue();
								CacheRoleQuicktime.roleQuicktimeQueue.clear();
								l = CacheRoleQuicktime.roleQuicktimeQueue.size();
							}
						}else{
							Thread.sleep(2000);
						}
						
						
					}else{
						//队列为空，一秒钟一次的定时器检测CacheGameRole
						try{
							if(bo){
								bo = false;
//								GameConstants.log.warn("END:ThreadCache Name:" + this.getName());
//								ServerHandler.debugQueue();
//								System.out.println(this.getName() + "队列内无内容：" + l + "进入休眠时间：" + time);
							}
							this.sleep(time);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
						l = CacheRoleQuicktime.roleQuicktimeQueue.size();
						if(l != 0){
							bo = true;
							System.out.println(this.getName() + "得到的队列长度：" + l);
//							GameConstants.log.warn("START:ThreadCache Name:" + this.getName());
//							ServerHandler.debugQueue();
						}		
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
				//l = CacheRoleQuicktime.roleQuicktimeQueue.size();
			}
		
		}else if(name.equals("roleTask")){
			//System.out.println("同步线程启动！" + this.getName());
			int time = 300000;
			int l = null == CacheRoleTask.roleTaskQueue? 0:CacheRoleTask.roleTaskQueue.size();
			//System.out.println("roleTask:roleTaskQueue_in:" + CacheRoleTask.roleTaskQueue_in.size());
			if(CacheRoleTask.roleTaskQueue_in.size() > 0){
				for(int n = 0; n < CacheRoleTask.roleTaskQueue_in.size(); n++){
					try{
						RoleTaskDetail cacheRoleTask = (RoleTaskDetail)CacheRoleTask.roleTaskQueue_in.front();
						if(null != cacheRoleTask){
							this.getRoleTaskDao().insertRoleTask(cacheRoleTask);
							CacheRoleTask.roleTaskQueue_in.dequeue();
						}else{
							CacheRoleTask.roleTaskQueue_in.clear();
							l = CacheRoleTask.roleTaskQueue_in.size();
						}
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}
			}
			for(int i = 0; i <= l; ){
				try{
					if(l > 0){
						//队列有内容
						if(QueueCache.updateFlag == 1){
							if(CacheRoleTask.roleTaskQueue_in.size() > 0){
								for(int n = 0; n < CacheRoleTask.roleTaskQueue_in.size(); n++){
									try{
										RoleTaskDetail cacheRoleTask = (RoleTaskDetail)CacheRoleTask.roleTaskQueue_in.front();
										if(null != cacheRoleTask){
											this.getRoleTaskDao().insertRoleTask(cacheRoleTask);
											CacheRoleTask.roleTaskQueue_in.dequeue();
										}else{
											CacheRoleTask.roleTaskQueue_in.clear();
											l = CacheRoleTask.roleTaskQueue_in.size();
										}
									}catch(Exception e){
										e.printStackTrace();
									}
									
								}
							}
							//System.out.println(this.getName() + "队列有内容:" + l +"indexMap:" + CacheRoleTask.roleTaskQueue.indexMap.toString());
							RoleTaskDetail roleTaskDetail = (RoleTaskDetail)CacheRoleTask.roleTaskQueue.front();
							if(null != roleTaskDetail){
								if(roleTaskDetail.getIsUpdate() == 1){
									//System.out.println(this.getName() + "更新：" + roleTaskDetail.getRoleId());
									this.getRoleTaskDao().updateRoleTask(roleTaskDetail);
									CacheRoleTask.roleTaskQueue.dequeue();
									CacheRoleTask.roleTaskQueue.indexMap.remove(roleTaskDetail.getRoleId());
								}else if(roleTaskDetail.getIsUpdate() == 2){
									//System.out.println(this.getName() + "插入：" + roleTaskDetail.getRoleId());
									this.getRoleTaskDao().insertRoleTask(roleTaskDetail);
									CacheRoleTask.roleTaskQueue.dequeue();
									CacheRoleTask.roleTaskQueue.indexMap.remove(roleTaskDetail.getRoleId());
								}else if(roleTaskDetail.getIsUpdate() == 3){
												
								}else{
									System.out.println("队列内存在参数异常！");
								}
							}else{
//								CacheRoleTask.roleTaskQueue.nextHeader();
//								CacheRoleTask.roleTaskQueue.dequeue();
								CacheRoleTask.roleTaskQueue.clear();
								l = CacheRoleTask.roleTaskQueue.size();
							}
						}else{
							Thread.sleep(2000);
						}
						
						
					}else{
						//队列为空，一秒钟一次的定时器检测CacheGameRole
						try{
							if(bo){
								bo = false;
//								GameConstants.log.warn("END:ThreadCache Name:" + this.getName());
//								ServerHandler.debugQueue();
//								System.out.println(this.getName() + "队列内无内容：" + l + "进入休眠时间：" + time);
							}
							this.sleep(time);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
						l = CacheRoleTask.roleTaskQueue.size();
						if(l == 0 && CacheRoleTask.roleTaskQueue_in.size() > 0){
							l = CacheRoleTask.roleTaskQueue_in.size();
						}
						if(l != 0){
							bo = true;
							//System.out.println(this.getName() + "得到的队列长度：" + l);
//							GameConstants.log.warn("START:ThreadCache Name:" + this.getName());
//							ServerHandler.debugQueue();
						}		
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
				//l = CacheRoleTask.roleTaskQueue.size();
			}
		
		}else if(name.equals("roleTaskTask")){
			System.out.println("同步线程启动！" + this.getName());
//ServerHandler.debugQueue();
			int time = 300000;
			int l = null == CacheRoleTaskTask.roleTaskTaskQueue? 0:CacheRoleTaskTask.roleTaskTaskQueue.size();
			for(int i = 0; i <= l; ){
				try{
					if(l > 0){
						//队列有内容
						if(QueueCache.updateFlag == 1){
							//System.out.println(this.getName() + "队列有内容:" + l);
							RoleTaskTaskDetail roleTaskTaskDetail = (RoleTaskTaskDetail)CacheRoleTaskTask.roleTaskTaskQueue.front();
							if(null != roleTaskTaskDetail){
								if(roleTaskTaskDetail.getIsUpdate() == 1){
									//System.out.println(this.getName() + "更新：" + roleTaskTaskDetail.getRoleId());
									this.getRoleTaskTaskDao().updateRoleTaskTask(roleTaskTaskDetail);
									CacheRoleTaskTask.roleTaskTaskQueue.dequeue();
//ServerHandler.debugQueue();
								}else if(roleTaskTaskDetail.getIsUpdate() == 2){
									//System.out.println(this.getName() + "插入：" + roleTaskTaskDetail.getRoleId());
									this.getRoleTaskTaskDao().insertRoleTaskTask(roleTaskTaskDetail);
									CacheRoleTaskTask.roleTaskTaskQueue.dequeue();
//ServerHandler.debugQueue();
								}else if(roleTaskTaskDetail.getIsUpdate() == 3){
									//System.out.println(this.getName() + "删除：" + roleTaskTaskDetail.getRoleId());
									this.getRoleTaskTaskDao().deleteRoleTaskTask(roleTaskTaskDetail);
									CacheRoleTaskTask.roleTaskTaskQueue.dequeue();
//ServerHandler.debugQueue();
								}else{
									System.out.println("队列内存在参数异常！");
								}
							}else{
//								CacheRoleTaskTask.roleTaskTaskQueue.nextHeader();
//								CacheRoleTaskTask.roleTaskTaskQueue.dequeue();
								CacheRoleTaskTask.roleTaskTaskQueue.clear();
								l = CacheRoleTaskTask.roleTaskTaskQueue.size();
							}
						}else{
							Thread.sleep(2000);
						}
						
						
					}else{
						//队列为空，一秒钟一次的定时器检测CacheGameRole
						try{
							if(bo){
								bo = false;
//								GameConstants.log.warn("END:ThreadCache Name:" + this.getName());
//								ServerHandler.debugQueue();
//								System.out.println(this.getName() + "队列内无内容：" + l + "进入休眠时间：" + time);
							}
							this.sleep(time);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
						l = CacheRoleTaskTask.roleTaskTaskQueue.size();
						if(l != 0){
							bo = true;
							System.out.println(this.getName() + "得到的队列长度：" + l);
//							GameConstants.log.warn("START:ThreadCache Name:" + this.getName());
//							ServerHandler.debugQueue();
						}		
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
				//l = CacheRoleTaskTask.roleTaskTaskQueue.size();
			}
		
		}else if(name.equals("Roletotme")){
		//	System.out.println("同步线程启动！" + this.getName());
			int time = 300000;
			int l = null == CacheRoletotme.gameRoletotmeQueue? 0:CacheRoletotme.gameRoletotmeQueue.size();
			for(int i = 0; i <= l; ){
				try{
					if(l > 0){
						//队列有内容
						if(QueueCache.updateFlag == 1){
							//System.out.println(this.getName() + "队列有内容:" + l);
							RoletotemDetail roletotemDetail = (RoletotemDetail)CacheRoletotme.gameRoletotmeQueue.front();
							if(null != roletotemDetail){
								if(roletotemDetail.getIsUpdate() == 1){
									//System.out.println(this.getName() + "更新：" + roletotemDetail.getRoleid());
									this.getRoletotemDao().updateRoletotem(roletotemDetail);
									CacheRoletotme.gameRoletotmeQueue.dequeue();
								}else if(roletotemDetail.getIsUpdate() == 2){
									//System.out.println(this.getName() + "插入：" + roletotemDetail.getRoleid());
									this.getRoletotemDao().insertRoletotem(roletotemDetail);
									CacheRoletotme.gameRoletotmeQueue.dequeue();
								}else if(roletotemDetail.getIsUpdate() == 3){
									//System.out.println(this.getName() + "删除：" + roletotemDetail.getRoleid());
									this.getRoletotemDao().deleteRoletotem(roletotemDetail);
									CacheRoletotme.gameRoletotmeQueue.dequeue();
								}else{
									System.out.println("队列内存在参数异常！");
								}
							}else{
//								CacheRoletotme.gameRoletotmeQueue.nextHeader();
//								CacheRoletotme.gameRoletotmeQueue.dequeue();
								CacheRoletotme.gameRoletotmeQueue.clear();
								l = CacheRoletotme.gameRoletotmeQueue.size();
							}
						}else{
							Thread.sleep(2000);
						}
						
						
					}else{
						//队列为空，一秒钟一次的定时器检测CacheGameRole
						try{
							if(bo){
								bo = false;
//								GameConstants.log.warn("END:ThreadCache Name:" + this.getName());
//								ServerHandler.debugQueue();
//								System.out.println(this.getName() + "队列内无内容：" + l + "进入休眠时间：" + time);
							}
							this.sleep(time);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
						l = CacheRoletotme.gameRoletotmeQueue.size();
						if(l != 0){
							bo = true;
							System.out.println(this.getName() + "得到的队列长度：" + l);
//							GameConstants.log.warn("START:ThreadCache Name:" + this.getName());
//							ServerHandler.debugQueue();
						}		
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
				//l = CacheRoletotme.gameRoletotmeQueue.size();
			}
		
		}else if(name.equals("coin")){
			//System.out.println("同步线程启动！" + this.getName());
			int time = 300000;
			int l = null == CacheCoin.coinQueue? 0:CacheCoin.coinQueue.size();
			for(int i = 0; i <= l; ){
				try{
					if(l > 0){
						//队列有内容
						if(QueueCache.updateFlag == 1){
							//System.out.println(this.getName() + "队列有内容:" + l);
							CoinDetail coinDetail = (CoinDetail)CacheCoin.coinQueue.front();
							if(null != coinDetail){
								if(coinDetail.getIsUpdate() == 1){
									//System.out.println(this.getName() + "更新：" + coinDetail.getRoleid());
//									this.getCoinDao().updateCoin(coinDetail);
									CacheCoin.coinQueue.dequeue();
								}else if(coinDetail.getIsUpdate() == 2){
									//System.out.println(this.getName() + "插入：" + coinDetail.getRoleid());
									this.getCoinDao().insertCoin(coinDetail);
									CacheCoin.coinQueue.dequeue();
								}else if(coinDetail.getIsUpdate() == 3){
												
								}else{
									System.out.println("队列内存在参数异常！");
								}
							}else{
//								CacheCoin.coinQueue.nextHeader();
//								CacheCoin.coinQueue.dequeue();
								CacheCoin.coinQueue.clear();
								l = CacheCoin.coinQueue.size();
							}
						}else{
							Thread.sleep(2000);
						}
						
						
					}else{
						//队列为空，一秒钟一次的定时器检测CacheGameRole
						try{
							if(bo){
								bo = false;
//								GameConstants.log.warn("END:ThreadCache Name:" + this.getName());
//								ServerHandler.debugQueue();
//								System.out.println(this.getName() + "队列内无内容：" + l + "进入休眠时间：" + time);
							}
							this.sleep(time);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
						l = CacheCoin.coinQueue.size();
						if(l != 0){
							bo = true;
							System.out.println(this.getName() + "得到的队列长度：" + l);
//							GameConstants.log.warn("START:ThreadCache Name:" + this.getName());
//							ServerHandler.debugQueue();
						}		
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
				//l = CacheCoin.coinQueue.size();
			}
		
		}else if(name.equals("delivery")){
			//System.out.println("同步线程启动！" + this.getName());
			int time = 300000;
			int l = null == CacheDelivery.deliveryQueue? 0:CacheDelivery.deliveryQueue.size();
			for(int i = 0; i <= l; ){
				try{
					if(l > 0){
						//队列有内容
						if(QueueCache.updateFlag == 1){
							//System.out.println(this.getName() + "队列有内容:" + l);
							DeliveryDetail deliveryDetail = (DeliveryDetail)CacheDelivery.deliveryQueue.front();
							if(null != deliveryDetail){
								if(deliveryDetail.getIsUpdate() == 1){
									//System.out.println(this.getName() + "更新：" + deliveryDetail.getPayitem());
									this.getDeliveryDao().updateDelivery(deliveryDetail);
									CacheDelivery.deliveryQueue.dequeue();
								}else if(deliveryDetail.getIsUpdate() == 2){
									//System.out.println(this.getName() + "插入：" + deliveryDetail.getPayitem());
									this.getDeliveryDao().insertDelivery(deliveryDetail);
									CacheDelivery.deliveryQueue.dequeue();
								}else if(deliveryDetail.getIsUpdate() == 3){
												
								}else{
									System.out.println("队列内存在参数异常！");
								}
							}else{
//								CacheDelivery.deliveryQueue.nextHeader();
//								CacheDelivery.deliveryQueue.dequeue();
								CacheDelivery.deliveryQueue.clear();
								l = CacheDelivery.deliveryQueue.size();
							}
							
						}else{
							Thread.sleep(2000);
						}
						
					}else{
						//队列为空，一秒钟一次的定时器检测CacheGameRole
						try{
							if(bo){
								bo = false;
//								GameConstants.log.warn("END:ThreadCache Name:" + this.getName());
//								ServerHandler.debugQueue();
//								System.out.println(this.getName() + "队列内无内容：" + l + "进入休眠时间：" + time);
							}
							this.sleep(time);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
						l = CacheDelivery.deliveryQueue.size();
						if(l != 0){
							bo = true;
							System.out.println(this.getName() + "得到的队列长度：" + l);
//							GameConstants.log.warn("START:ThreadCache Name:" + this.getName());
//							ServerHandler.debugQueue();
						}		
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
				//l = CacheDelivery.deliveryQueue.size();
			}
		
		}else if(name.equals("gamblingItem")){
			//System.out.println("同步线程启动！" + this.getName());
			int time = 300000;
			int l = null == CacheGamBlingItem.gamblingItemQueue? 0:CacheGamBlingItem.gamblingItemQueue.size();
			for(int i = 0; i <= l; ){
				try{
					if(l > 0){
						//队列有内容
						if(QueueCache.updateFlag == 1){
							//System.out.println(this.getName() + "队列有内容:" + l);
							GamblingItemDetail gamblingItemDetail = (GamblingItemDetail)CacheGamBlingItem.gamblingItemQueue.front();
							if(null != gamblingItemDetail){
								if(gamblingItemDetail.getIsUpdate() == 1){
									//System.out.println(this.getName() + "更新：" + gamblingItemDetail.getMId());
									this.getGamblingItemDao().updateGamblingItem(gamblingItemDetail);
									CacheGamBlingItem.gamblingItemQueue.dequeue();
								}else if(gamblingItemDetail.getIsUpdate() == 2){
									//System.out.println(this.getName() + "插入：" + gamblingItemDetail.getMId());
									this.getGamblingItemDao().insertGamblingItem(gamblingItemDetail);
									CacheGamBlingItem.gamblingItemQueue.dequeue();
								}else if(gamblingItemDetail.getIsUpdate() == 3){
												
								}else{
									System.out.println("队列内存在参数异常！");
								}
							}else{
//								CacheGamBlingItem.gamblingItemQueue.nextHeader();
//								CacheGamBlingItem.gamblingItemQueue.dequeue();
								CacheGamBlingItem.gamblingItemQueue.clear();
								l = CacheGamBlingItem.gamblingItemQueue.size();
							}
						}else{
							Thread.sleep(2000);
						}
						
						
					}else{
						//队列为空，一秒钟一次的定时器检测CacheGameRole
						try{
							if(bo){
								bo = false;
//								GameConstants.log.warn("END:ThreadCache Name:" + this.getName());
//								ServerHandler.debugQueue();
//								System.out.println(this.getName() + "队列内无内容：" + l + "进入休眠时间：" + time);
							}
							this.sleep(time);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
						l = CacheGamBlingItem.gamblingItemQueue.size();
						if(l != 0){
							bo = true;
							System.out.println(this.getName() + "得到的队列长度：" + l);
//							GameConstants.log.warn("START:ThreadCache Name:" + this.getName());
//							ServerHandler.debugQueue();
						}		
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
				//l = CacheGamBlingItem.gamblingItemQueue.size();
			}
		
		}else if(name.equals("member")){
		//	System.out.println("同步线程启动！" + this.getName());
			int time = 300000;
			int l = null == CacheMember.memberQueue? 0:CacheMember.memberQueue.size();
			for(int i = 0; i <= l; ){
				try{
					if(l > 0){
						//队列有内容
						if(QueueCache.updateFlag == 1){
							System.out.println(this.getName() + "队列有内容:" + l);
							MemberDetail memberDetail = (MemberDetail)CacheMember.memberQueue.front();
							if(null != memberDetail){
								if(memberDetail.getIsUpdate() == 1){
									//System.out.println(this.getName() + "更新：" + memberDetail.getId());
									this.getMemberDao().updateMember(memberDetail);
									CacheMember.memberQueue.dequeue();
								}else if(memberDetail.getIsUpdate() == 2){
									System.out.println(this.getName() + "插入：" + memberDetail.getId());
									this.getMemberDao().insertMember(memberDetail);
									CacheMember.memberQueue.dequeue();
								}else if(memberDetail.getIsUpdate() == 3){
												
								}else{
									System.out.println("队列内存在参数异常！");
								}
							}else{
//								CacheMember.memberQueue.nextHeader();
//								CacheMember.memberQueue.dequeue();
								CacheMember.memberQueue.clear();
								l = CacheMember.memberQueue.size();
							}
						}else{
							Thread.sleep(2000);
						}
						
						
					}else{
						//队列为空，一秒钟一次的定时器检测CacheGameRole
						try{
							if(bo){
								bo = false;
//								GameConstants.log.warn("END:ThreadCache Name:" + this.getName());
//								ServerHandler.debugQueue();
//								System.out.println(this.getName() + "队列内无内容：" + l + "进入休眠时间：" + time);
							}
							this.sleep(time);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
						l = CacheMember.memberQueue.size();
						if(l != 0){
							bo = true;
							System.out.println(this.getName() + "得到的队列长度：" + l);
//							GameConstants.log.warn("START:ThreadCache Name:" + this.getName());
//							ServerHandler.debugQueue();
						}		
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
				//l = CacheMember.memberQueue.size();
			}
		
		}else if(name.equals("roleAvatar")){
			//System.out.println("同步线程启动！" + this.getName());
			int time = 300000;
			int l = null == CacheRoleAvatar.roleAvatarQueue? 0:CacheRoleAvatar.roleAvatarQueue.size();
			for(int i = 0; i <= l; ){
				try{
					if(l > 0){
						//队列有内容
						if(QueueCache.updateFlag == 1){
//							System.out.println(this.getName() + "队列有内容:" + l);
							RoleAvatarDetail roleAvatarDetail = (RoleAvatarDetail)CacheRoleAvatar.roleAvatarQueue.front();
							if(null != roleAvatarDetail){
								if(roleAvatarDetail.getIsUpdate() == 1){
									//System.out.println(this.getName() + "更新：" + roleAvatarDetail.getRoleid());
									this.getRoleAvatarDao().updateRoleAvatar(roleAvatarDetail);
									CacheRoleAvatar.roleAvatarQueue.dequeue();
								}else if(roleAvatarDetail.getIsUpdate() == 2){
									//System.out.println(this.getName() + "插入：" + roleAvatarDetail.getRoleid());
									this.getRoleAvatarDao().insertRoleAvatar(roleAvatarDetail);
									CacheRoleAvatar.roleAvatarQueue.dequeue();
								}else if(roleAvatarDetail.getIsUpdate() == 3){
												
								}else{
									System.out.println("队列内存在参数异常！");
								}
							}else{
//								CacheRoleAvatar.roleAvatarQueue.nextHeader();
//								CacheRoleAvatar.roleAvatarQueue.dequeue();
								CacheRoleAvatar.roleAvatarQueue.clear();
								l = CacheRoleAvatar.roleAvatarQueue.size();
							}
						}else{
							Thread.sleep(2000);
						}
					
						
					}else{
						//队列为空，一秒钟一次的定时器检测CacheGameRole
						try{
							if(bo){
								bo = false;
//								GameConstants.log.warn("END:ThreadCache Name:" + this.getName());
//								ServerHandler.debugQueue();
//								System.out.println(this.getName() + "队列内无内容：" + l + "进入休眠时间：" + time);
							}
							this.sleep(time);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
						l = CacheRoleAvatar.roleAvatarQueue.size();
						if(l != 0){
							bo = true;
							System.out.println(this.getName() + "得到的队列长度：" + l);
//							GameConstants.log.warn("START:ThreadCache Name:" + this.getName());
//							ServerHandler.debugQueue();
						}		
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				//l = CacheRoleAvatar.roleAvatarQueue.size();
			}
		}else if(name.equals("server")){
			//System.out.println("server 线程启动！");
			int time = 600000;
			int l = null == CacheServer.gameServerQueue? 0:CacheServer.gameServerQueue.size();
			for(int i = 0; i <= l; ){
				try{
					if(l > 0){
						//队列有内容
						ServerDetail serverDetail = (ServerDetail)CacheServer.gameServerQueue.front();
						if(null != serverDetail){	
							this.getServerDao().updateServer(serverDetail);
							CacheServer.gameServerQueue.dequeue();
						}else{
							CacheServer.gameServerQueue.clear();
							l = CacheServer.gameServerQueue.size();
						}
					}else{
						//队列为空，一秒钟一次的定时器检测CacheGameRole
						try{
							if(bo){
								bo = false;
							}
							this.sleep(time);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
						com.stang.game.server.handler.PlayerHandler.updateOnlineUserNumber();
						l = CacheServer.gameServerQueue.size();
						if(l != 0){
							bo = true;
							System.out.println(this.getName() + "得到的队列长度：" + l);
						}		
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}else if(name.equals("systemMessage")){
			//System.out.println("systemMessage 线程启动！___________________________________");
			int time = 14000;
			int l = null == SystemHandler.systemMessageQueue? 0:SystemHandler.systemMessageQueue.size();
			for(int i = 0; i <= l; ){
				try{
					if(l > 0){
						//队列有内容
						String message = (String)SystemHandler.systemMessageQueue.front();
						System.out.println("ThreadCache:message:" + message);
						if(null != message){	
							SystemHandler.sendMessage(message);
							SystemHandler.systemMessageQueue.dequeue();
						}else{
							SystemHandler.systemMessageQueue.clear();
							l = SystemHandler.systemMessageQueue.size();
						}
						this.sleep(time);
					}else{
						//队列为空，一秒钟一次的定时器检测CacheGameRole
						try{
							if(bo){
								bo = false;
							}
							this.sleep(time);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
						l = SystemHandler.systemMessageQueue.size();
						if(l != 0){
							bo = true;
							System.out.println(this.getName() + "得到的队列长度：" + l);
						}		
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
}
