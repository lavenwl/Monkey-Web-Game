package com.stang.game.cache;

import com.stang.game.entity.detail.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import com.stang.game.common.GameConstants;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheGameRole {
	//缓存类操作的缓存对象(key:id, value:GameRoleDetail)
	private static Map<Integer, GameRoleDetail> gameRoles = null;
	//变动过的对象组成的队列，由于自动同步数据库
	public static QueueCache gameRoleQueue = null;
	public static QueueCache gameRoleQueue_in = null;
	//静态类同步数据库线程
	public static ThreadCache thread = null;
	//静态初始化方法
	public CacheGameRole(){
		if(thread == null){
			thread = new ThreadCache("gameRole");
			thread.start();
		}
		if(gameRoles == null)
			gameRoles = GlobalDatat.cacheGameRoleDetails;
		if(gameRoleQueue == null)
			gameRoleQueue = new QueueCache("gameRole");
		if(gameRoleQueue_in == null)
			gameRoleQueue_in = new QueueCache("gameRole_in");
	}
	//根据玩家ID查询玩家的具体数据
	public GameRoleDetail findRoleById(int id){
		return gameRoles.get(id);
	}
	//插入玩家对象
	public boolean insertRole(GameRoleDetail model1){
		boolean b = false;
		try{
			model1.setTotem("[]");
			model1.setIsnew("[]");
			model1.setActivitygift("[]");
			model1.setActivitytype("[]");
			model1.setBuyitem("[0,0,0,0,0]");
			model1.setFuben(1);
			model1.setFubentwo(1);
			model1.setFubenthree(1);
			model1.setCompensate("[0,0,0,0,0]");
			model1.setQcost("[0,0,0]");
			model1.setOpenmountain("[0,0,0,0,0]");
			model1.setVipGift("01");
			model1.setVipTime("2010-08-14 11:24:16");
			model1.setAlchemygift("[]");
			model1.setTemperature(0);
			model1.setFundsgift("[0,0,0,0,0,0,0,0]");
			model1.setFundslevel(35);
			model1.setFundsstatu(0);
			model1.setSeventotal("[0,0,0,0]");
			model1.setAimreward("[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]");
			model1.setGetreward(0);
			model1.setAwakenstatu("[0,0,0,0,0,0,0,0]");
			model1.setMilluck(0);
			model1.setZillionaireplace(0);//大富翁
			GameRoleDetail model = new GameRoleDetail();
			try{
				model = (GameRoleDetail)model1.clone();
			}catch(Exception e){
				e.printStackTrace();
			}
			//System.out.println("执行了CacheGameRole.insertRole():" + model.getId());
			gameRoles.put(model.getId(), model);
			model.setIsUpdate(2);
			gameRoleQueue_in.enqueue(model);
			//System.out.println("执行了CacheGameRole.insertRole():" + model.getId() + ";" + ((GameRoleDetail)gameRoleQueue.front()).getIsUpdate());
			b = true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//根据玩家对象更新数据
	public boolean updateRole(GameRoleDetail model){
		boolean b = false;
		try{
			//gameRoles.remove(model.getIds());
			gameRoles.put(model.getId(), model);
			model.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(model.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(model.getId(), null);
				gameRoleQueue.enqueue(model);
			}
			
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//更新玩家地图信息
	public boolean updateMap(int mapid, int placeid, int roleId){
		boolean b = false;
		try{
			GameRoleDetail gameRoleDetail = new GameRoleDetail();
			try{
				gameRoleDetail = gameRoles.get(roleId);
			}catch(Exception e){
				e.printStackTrace();
			}
			gameRoleDetail.setMapid(mapid);
			gameRoleDetail.setPlaceid(placeid);
			//gameRoles.remove(roleId);
			gameRoles.put(roleId, gameRoleDetail);
			gameRoleDetail.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(gameRoleDetail.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(gameRoleDetail.getId(), null);
				gameRoleQueue.enqueue(gameRoleDetail);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//增加玩家的元宝（coin）数量
	public boolean addRoleCoin(int roleId, int coin){
		boolean b = false;
		try{
			GameRoleDetail gameRoleDetail = null;
			try{
				gameRoleDetail = gameRoles.get(roleId);
			}catch(Exception e){
				e.printStackTrace();
			}
			gameRoleDetail.setCoin(gameRoleDetail.getCoin() + coin);
			//gameRoles.remove(roleId);
			gameRoles.put(roleId, gameRoleDetail);
			gameRoleDetail.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(gameRoleDetail.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(gameRoleDetail.getId(), null);
				gameRoleQueue.enqueue(gameRoleDetail);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//增加玩家的功勋
	public boolean addRoleGongxun(int roleId, int gongxun){
		boolean b = false;
		try{
			GameRoleDetail gameRoleDetail = null;
			try{
				gameRoleDetail = gameRoles.get(roleId);
			}catch(Exception e){
				e.printStackTrace();
			}
			gameRoleDetail.setGongxun(gameRoleDetail.getGongxun() + gongxun);
		//	gameRoles.remove(roleId);
			gameRoles.put(roleId, gameRoleDetail);
			gameRoleDetail.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(gameRoleDetail.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(gameRoleDetail.getId(), null);
				gameRoleQueue.enqueue(gameRoleDetail);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//增加玩家的银币数量
	public boolean addRoleYin(int roleId, int yin){
		boolean b = false;
		try{
			GameRoleDetail gameRoleDetail = null;
			try{
				gameRoleDetail = gameRoles.get(roleId);
			}catch(Exception e){
				e.printStackTrace();
			}
			gameRoleDetail.setYin(gameRoleDetail.getYin() + yin);
			//gameRoles.remove(roleId);
			gameRoles.put(roleId, gameRoleDetail);
			gameRoleDetail.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(gameRoleDetail.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(gameRoleDetail.getId(), null);
				gameRoleQueue.enqueue(gameRoleDetail);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//减少玩家的元宝数
	public boolean subRoleCoin(int roleId, int coin){
		boolean b = false;
		try{
			GameRoleDetail gameRoleDetail = null;
			try{
				gameRoleDetail = gameRoles.get(roleId);
			}catch(Exception e){
				e.printStackTrace();
			}
			gameRoleDetail.setCoin(gameRoleDetail.getCoin() - coin);
			//gameRoles.remove(roleId);
			gameRoles.put(roleId, gameRoleDetail);
			gameRoleDetail.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(gameRoleDetail.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(gameRoleDetail.getId(), null);
				gameRoleQueue.enqueue(gameRoleDetail);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//减少玩家查功勋
	public boolean subRoleGongxun(int roleId, int gongxun){
		boolean b = false;
		try{
			GameRoleDetail gameRoleDetail = null;
			try{
				gameRoleDetail = gameRoles.get(roleId);
			}catch(Exception e){
				e.printStackTrace();
			}
			gameRoleDetail.setGongxun(gameRoleDetail.getGongxun() - gongxun);
			//gameRoles.remove(roleId);
			gameRoles.put(roleId, gameRoleDetail);
			gameRoleDetail.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(gameRoleDetail.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(gameRoleDetail.getId(), null);
				gameRoleQueue.enqueue(gameRoleDetail);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//减少玩家的银币
	public boolean subRoleYin(int roleId, int yin){
		boolean b = false;
		try{
			GameRoleDetail gameRoleDetail = null;
			try{
				gameRoleDetail = gameRoles.get(roleId);
			}catch(Exception e){
				e.printStackTrace();
			}
			gameRoleDetail.setYin(gameRoleDetail.getYin() - yin);
			//gameRoles.remove(roleId);
			gameRoles.put(roleId, gameRoleDetail);
			gameRoleDetail.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(gameRoleDetail.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(gameRoleDetail.getId(), null);
				gameRoleQueue.enqueue(gameRoleDetail);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//改变玩家的当前经验
	public boolean addRoleExp(int roleId, int exp){
		boolean b = false;
		try{
			// 获得用户信息
			GameRoleDetail gameRoleDetail = null;
			try{
				gameRoleDetail = gameRoles.get(roleId);
			}catch(Exception e){
				e.printStackTrace();
			}
			int key = gameRoleDetail.getLevel();
			int roleexp = gameRoleDetail.getExp() + exp;
			// 得到模型数据
			GameLevelDetail gameLevelDetail = GlobalDatat.cacheGameLevelDetails.get(key);
			// 判断
			if (roleexp >= gameRoleDetail.getNeedexp()) {
				// 到升级的时候了
				roleexp = roleexp - gameRoleDetail.getNeedexp();
				this.addRoleLevel(roleId, (key + 1), roleexp);
			} else {
				gameRoleDetail.setExp(roleexp);
				//更新缓存
				//gameRoles.remove(roleId);
				gameRoles.put(roleId, gameRoleDetail);
				//更新队列
				gameRoleDetail.setIsUpdate(1);
				if(gameRoleQueue.indexMap.containsKey(gameRoleDetail.getId())){
					//System.out.println("gameRole避免了一次数据库操作");
				}else{
					gameRoleQueue.indexMap.put(gameRoleDetail.getId(), null);
					gameRoleQueue.enqueue(gameRoleDetail);
				}
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//增加玩家等级
	public boolean addRoleLevel(int roleId, int level, int exp){
		boolean b = false;
		try{
			GameRoleDetail gameRoleDetail = null;
			try{
				gameRoleDetail = gameRoles.get(roleId);
			}catch(Exception e){
				e.printStackTrace();
			}
			gameRoleDetail.setLevel(level);
			gameRoleDetail.setExp(exp);
			//gameRoles.remove(roleId);
			gameRoles.put(roleId, gameRoleDetail);
			gameRoleDetail.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(gameRoleDetail.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(gameRoleDetail.getId(), null);
				gameRoleQueue.enqueue(gameRoleDetail);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//更新玩家的银币数量
	public boolean upRoleYin(int roleId, int yin){
		boolean b = false;
		try{
			GameRoleDetail gameRoleDetail = null;
			try{
				gameRoleDetail = gameRoles.get(roleId);
			}catch(Exception e){
				e.printStackTrace();
			}
			gameRoleDetail.setYin(yin);
			//gameRoles.remove(roleId);
			gameRoles.put(roleId, gameRoleDetail);
			gameRoleDetail.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(gameRoleDetail.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(gameRoleDetail.getId(), null);
				gameRoleQueue.enqueue(gameRoleDetail);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//更新gamblinginfo《？》
	public boolean updateGameRoleGamebingInfo(Map<String, Object> updateMap){
		boolean b = true;
	//	System.out.println("调用了方法：updateGameRoleGamblingInfo____________________________________________________");
		return b;
	}
	//减少玩家的军令
	public boolean subRolejunling(int roleId, int num){
		boolean b = false;
		try{
			GameRoleDetail gameRoleDetail = null;
			try{
				gameRoleDetail = gameRoles.get(roleId);
			}catch(Exception e){
				e.printStackTrace();
			}
			gameRoleDetail.setJunling(gameRoleDetail.getJunling() - num);
			//gameRoles.remove(roleId);
			gameRoles.put(roleId, gameRoleDetail);
			gameRoleDetail.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(gameRoleDetail.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(gameRoleDetail.getId(), null);
				gameRoleQueue.enqueue(gameRoleDetail);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//增加玩家的军令
	public boolean addRolejunling(int roleId, int num){
		boolean b = false;
		try{
			GameRoleDetail gameRoleDetail = null;
			try{
				gameRoleDetail = gameRoles.get(roleId);
			}catch(Exception e){
				e.printStackTrace();
			}
			gameRoleDetail.setJunling(num);
			//gameRoles.remove(roleId);
			gameRoles.put(roleId, gameRoleDetail);
			gameRoleDetail.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(gameRoleDetail.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(gameRoleDetail.getId(), null);
				gameRoleQueue.enqueue(gameRoleDetail);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//增加玩家的军令时间
	public boolean addRolejunlingtime(int roleId, long jltime){
		boolean b = false;
		try{
			GameRoleDetail gameRoleDetail = null;
			try{
				gameRoleDetail = gameRoles.get(roleId);
			}catch(Exception e){
				e.printStackTrace();
			}
			gameRoleDetail.setJltime(jltime);
			//gameRoles.remove(roleId);
			gameRoles.put(roleId, gameRoleDetail);
			gameRoleDetail.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(gameRoleDetail.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(gameRoleDetail.getId(), null);
				gameRoleQueue.enqueue(gameRoleDetail);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//更新玩家状态
	public boolean updateRolestate(Map<String, Object> param){
		boolean b = false;
		int roleId = Integer.valueOf(String.valueOf(param.get("id")));
		String state = String.valueOf(param.get("state"));
		try{
			GameRoleDetail gameRoleDetail = null;
			try{
				gameRoleDetail = gameRoles.get(roleId);
			}catch(Exception e){
				e.printStackTrace();
			}
			gameRoleDetail.setState(state);
			//gameRoles.remove(roleId);
			gameRoles.put(roleId, gameRoleDetail);
			gameRoleDetail.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(gameRoleDetail.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(gameRoleDetail.getId(), null);
				gameRoleQueue.enqueue(gameRoleDetail);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//更新玩家的updateRoleline
	public boolean updateRoleline(int roleId, int line){
		boolean b = false;
		try{
			GameRoleDetail gameRoleDetail = null;
			try{
				gameRoleDetail = gameRoles.get(roleId);
			}catch(Exception e){
				e.printStackTrace();
			}
			gameRoleDetail.setRoleline(line);
			//gameRoles.remove(roleId);
			gameRoles.put(roleId, gameRoleDetail);
			gameRoleDetail.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(gameRoleDetail.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(gameRoleDetail.getId(), null);
				gameRoleQueue.enqueue(gameRoleDetail);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//更新玩家的updateRoleGift
	public boolean updateRoleGift(GameRoleDetail model){
		boolean b = false;
		int roleId = model.getId();
		try{
			GameRoleDetail gameRoleDetail = null;
			try{
				gameRoleDetail = gameRoles.get(roleId);
			}catch(Exception e){
				e.printStackTrace();
			}
			gameRoleDetail.setFlauntgift(model.getFlauntgift());
			//gameRoles.remove(roleId);
			gameRoles.put(roleId, gameRoleDetail);
			gameRoleDetail.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(gameRoleDetail.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(gameRoleDetail.getId(), null);
				gameRoleQueue.enqueue(gameRoleDetail);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//更新玩家的updateRoleGift2
	public boolean updateRoleGift2(GameRoleDetail model){
		boolean b = false;
		int roleId = model.getId();
		try{
			GameRoleDetail gameRoleDetail = null;
			try{
				gameRoleDetail = gameRoles.get(roleId);
			}catch(Exception e){
				e.printStackTrace();
			}
			gameRoleDetail.setChallengegift(model.getChallengegift());
			//gameRoles.remove(roleId);
			gameRoles.put(roleId, gameRoleDetail);
			gameRoleDetail.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(gameRoleDetail.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(gameRoleDetail.getId(), null);
				gameRoleQueue.enqueue(gameRoleDetail);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//更新玩家的updateRoleGift3
	public boolean updateRoleGift3(GameRoleDetail model){
		boolean b = false;
		int roleId = model.getId();
		try{
			GameRoleDetail gameRoleDetail = null;
			try{
				gameRoleDetail = gameRoles.get(roleId);
			}catch(Exception e){
				e.printStackTrace();
			}
			gameRoleDetail.setSharedemogift(model.getSharedemogift());
			//gameRoles.remove(roleId);
			gameRoles.put(roleId, gameRoleDetail);
			gameRoleDetail.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(gameRoleDetail.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(gameRoleDetail.getId(), null);
				gameRoleQueue.enqueue(gameRoleDetail);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//更新玩家的updateRoleGift4
	public boolean updateRoleGift4(GameRoleDetail model){
		boolean b = false;
		int roleId = model.getId();
		try{
			GameRoleDetail gameRoleDetail = null;
			try{
				gameRoleDetail = gameRoles.get(roleId);
			}catch(Exception e){
				e.printStackTrace();
			}
			gameRoleDetail.setFdsharegift(model.getFdsharegift());
			//gameRoles.remove(roleId);
			gameRoles.put(roleId, gameRoleDetail);
			gameRoleDetail.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(gameRoleDetail.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(gameRoleDetail.getId(), null);
				gameRoleQueue.enqueue(gameRoleDetail);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//更新玩家的updateRoleGift5
	public boolean updateRoleGift5(GameRoleDetail model){
		boolean b = false;
		int roleId = model.getId();
		try{
			GameRoleDetail gameRoleDetail = null;
			try{
				gameRoleDetail = gameRoles.get(roleId);
			}catch(Exception e){
				e.printStackTrace();
			}
			gameRoleDetail.setAllfdgift(model.getAllfdgift());
			//gameRoles.remove(roleId);
			gameRoles.put(roleId, gameRoleDetail);
			gameRoleDetail.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(gameRoleDetail.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(gameRoleDetail.getId(), null);
				gameRoleQueue.enqueue(gameRoleDetail);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//更新玩家的updateRoleVipGiftTime
	public boolean updateRoleVipGiftTime(Map<String, Object> param){
		boolean b = false;
		int roleId = Integer.valueOf(String.valueOf(param.get("id")));
		String viptime = String.valueOf(param.get("viptime"));
		String vipgift = String.valueOf(param.get("vipgift"));
		try{
			GameRoleDetail gameRoleDetail = null;
			try{
				gameRoleDetail = gameRoles.get(roleId);
			}catch(Exception e){
				e.printStackTrace();
			}
			gameRoleDetail.setVipTime(viptime);
			gameRoleDetail.setVipGift(vipgift);
		//	gameRoles.remove(roleId);
			gameRoles.put(roleId, gameRoleDetail);
			gameRoleDetail.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(gameRoleDetail.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(gameRoleDetail.getId(), null);
				gameRoleQueue.enqueue(gameRoleDetail);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//更新玩家的upactivitygift
	public boolean upactivitygift(Map<String, Object> param){
		boolean b = false;
		int roleId = Integer.valueOf(String.valueOf(param.get("id")));
		String activitygift = String.valueOf(param.get("activitygift"));
		try{
			GameRoleDetail gameRoleDetail = null;
			try{
				gameRoleDetail = gameRoles.get(roleId);
			}catch(Exception e){
				e.printStackTrace();
			}
			gameRoleDetail.setActivitygift(activitygift);
		//	gameRoles.remove(roleId);
			gameRoles.put(roleId, gameRoleDetail);
			gameRoleDetail.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(gameRoleDetail.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(gameRoleDetail.getId(), null);
				gameRoleQueue.enqueue(gameRoleDetail);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//更新玩家的upoldfriendgift
	public boolean upoldfriendgift(Map<String, Object> param){
		boolean b = false;
		int roleId = Integer.valueOf(String.valueOf(param.get("id")));
		String oldfriendgift = String.valueOf(param.get("oldfriendgift"));
		try{
			GameRoleDetail gameRoleDetail = null;
			try{
				gameRoleDetail = gameRoles.get(roleId);
			}catch(Exception e){
				e.printStackTrace();
			}
			gameRoleDetail.setOldfriendgift(oldfriendgift);
		//	gameRoles.remove(roleId);
			gameRoles.put(roleId, gameRoleDetail);
			gameRoleDetail.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(gameRoleDetail.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(gameRoleDetail.getId(), null);
				gameRoleQueue.enqueue(gameRoleDetail);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//更新玩家的updateTotem
	public boolean updateTotem(Map<String, Object> param){
		boolean b = false;
		int roleId = Integer.valueOf(String.valueOf(param.get("id")));
		String totem = String.valueOf(param.get("totem"));
		try{
			GameRoleDetail gameRoleDetail = null;
			try{
				gameRoleDetail = gameRoles.get(roleId);
			}catch(Exception e){
				e.printStackTrace();
			}
			gameRoleDetail.setTotem(totem);
		//	gameRoles.remove(roleId);
			gameRoles.put(roleId, gameRoleDetail);
			gameRoleDetail.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(gameRoleDetail.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(gameRoleDetail.getId(), null);
				gameRoleQueue.enqueue(gameRoleDetail);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//更新玩家的updateJingji
	public boolean updateJingji(int jjstatus){
		//System.out.println("CacheGameROle:updateJingji:______________________" + jjstatus + " gameRoles.size():" + gameRoles.size());
		boolean b = false;
		try{
			List<GameRoleDetail> list = new ArrayList<GameRoleDetail>();
			Iterator it = gameRoles.keySet().iterator();
			while(it.hasNext()){
				Integer i = Integer.valueOf(it.next().toString());
				GameRoleDetail gameRole = null;
				try{
					gameRole = gameRoles.get(i);
				}catch(Exception e){
					e.printStackTrace();
				}
				gameRole.setJjstatus(jjstatus);
				//list.add(gameRole);
				
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	
	//更新玩家的updateDeskcheck
		public boolean updateDeskcheck(int jjstatus){
			//System.out.println("CacheGameROle:updateJingji:______________________" + jjstatus + " gameRoles.size():" + gameRoles.size());
			boolean b = false;
			try{
				List<GameRoleDetail> list = new ArrayList<GameRoleDetail>();
				Iterator it = gameRoles.keySet().iterator();
				while(it.hasNext()){
					Integer i = Integer.valueOf(it.next().toString());
					GameRoleDetail gameRole = null;
					try{
						gameRole = gameRoles.get(i);
					}catch(Exception e){
						e.printStackTrace();
					}
					gameRole.setMohunboolean(1);
					gameRole.setDeskcheck(0);
					gameRole.setStsdnum(0);
					gameRole.setStsfriend("");
					gameRole.setGroupactive(0);
					//list.add(gameRole);
					
				}
				b = true;
			}catch(Exception e){
				e.printStackTrace();
			}
			return b;
		}
	
	//更新玩家挑战状态
	public boolean updatefrinedchallenge(){
		boolean b = false;
		try{
			List<GameRoleDetail> list = new ArrayList<GameRoleDetail>();
			Iterator it = gameRoles.keySet().iterator();
			while(it.hasNext()){
				Integer i = Integer.valueOf(it.next().toString());
				//GameRoleDetail gameRole = new GameRoleDetail();
				GameRoleDetail gameRole =null;
				try{
					//gameRole = (GameRoleDetail)gameRoles.get(i).clone();
					gameRole = gameRoles.get(i);
				}catch(Exception e){
					e.printStackTrace();
				}
				gameRole.setFlaunt(0);
				gameRole.setFlauntgift(0);
				gameRole.setChallenge(0);
				gameRole.setChallengegift(0);
				gameRole.setSharedemo(0);
				gameRole.setSharedemogift(0);
				gameRole.setFdshare(0);
				gameRole.setFdsharegift(0);
				gameRole.setAllfdgift(0);
				gameRole.setOldfriend(0);
				gameRole.setDaycoin(0);
				gameRole.setQcost("[0,0,0]");
				list.add(gameRole);
			}
		//	System.out.println("数据库异步执行！更新玩家挑战状态，更新玩家数量：" + list.size());
//			for(int i = 0; i < list.size(); i++){
//				GameRoleDetail gameRole = list.get(i);
//				//更新缓存
//				gameRoles.remove(gameRole.getIds());
//				gameRoles.put(gameRole.getId(), gameRole);
//				//更新队列
//				gameRole.setIsUpdate(1);
//				gameRoleQueue.enqueue(gameRole);
//			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//更新玩家的reference
	public boolean updateRolerefertime(Map<String, Object> param){
		boolean b = false;
		int roleId = Integer.valueOf(String.valueOf(param.get("id")));
		long refertime = Long.valueOf(String.valueOf(param.get("refertime")));
		try{
			GameRoleDetail gameRoleDetail = null;
			try{
				gameRoleDetail = gameRoles.get(roleId);
			}catch(Exception e){
				e.printStackTrace();
			}
			gameRoleDetail.setRefertime(refertime);
		//	gameRoles.remove(roleId);
			gameRoles.put(roleId, gameRoleDetail);
			gameRoleDetail.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(gameRoleDetail.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(gameRoleDetail.getId(), null);
				gameRoleQueue.enqueue(gameRoleDetail);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//更新玩家的updateRolestateseven
	public boolean updateRolestateseven(Map<String, Object> param){
		boolean b = false;
		int roleId = Integer.valueOf(String.valueOf(param.get("id")));
		String stateseven = String.valueOf(param.get("stateseven"));
		try{
			GameRoleDetail gameRoleDetail = null;
			try{
				gameRoleDetail = gameRoles.get(roleId);
			}catch(Exception e){
				e.printStackTrace();
			}
			gameRoleDetail.setStateseven(stateseven);
			//gameRoles.remove(roleId);
			gameRoles.put(roleId, gameRoleDetail);
			gameRoleDetail.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(gameRoleDetail.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(gameRoleDetail.getId(), null);
				gameRoleQueue.enqueue(gameRoleDetail);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//更新玩家的updateRoleSupsign
	public boolean updateRoleSupsign(Map<String, Object> param){
		boolean b = false;
		int roleId = Integer.valueOf(String.valueOf(param.get("id")));
		String supsign = String.valueOf(param.get("supsign"));
		try{
			GameRoleDetail gameRoleDetail = null;
			try{
				gameRoleDetail = gameRoles.get(roleId);
			}catch(Exception e){
				e.printStackTrace();
			}
			gameRoleDetail.setSupsign(supsign);
		//	gameRoles.remove(roleId);
			gameRoles.put(roleId, gameRoleDetail);
			gameRoleDetail.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(gameRoleDetail.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(gameRoleDetail.getId(), null);
				gameRoleQueue.enqueue(gameRoleDetail);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//更新玩家的updateRoleintegral
	public boolean updateRoleintegral(Map<String, Object> param){
		boolean b = false;
		int roleId = Integer.valueOf(String.valueOf(param.get("id")));
		int integral = Integer.valueOf(String.valueOf(param.get("integral")));
		try{
			GameRoleDetail gameRoleDetail = null;
			try{
				gameRoleDetail = gameRoles.get(roleId);
			}catch(Exception e){
				e.printStackTrace();
			}
			gameRoleDetail.setIntegral(integral);
		//	gameRoles.remove(roleId);
			gameRoles.put(roleId, gameRoleDetail);
			gameRoleDetail.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(gameRoleDetail.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(gameRoleDetail.getId(), null);
				gameRoleQueue.enqueue(gameRoleDetail);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//更新玩家的updateRolehelpstep
	public boolean updateRolehelpstep(Map<String, Object> param){
		boolean b = false;
		int roleId = Integer.valueOf(String.valueOf(param.get("id")));
		String helpstep = String.valueOf(param.get("helpstep"));
		try{
			GameRoleDetail gameRoleDetail = null;
			try{
				gameRoleDetail = gameRoles.get(roleId);
			}catch(Exception e){
				e.printStackTrace();
			}
			gameRoleDetail.setHelpstep(helpstep);
	//		gameRoles.remove(roleId);
			gameRoles.put(roleId, gameRoleDetail);
			gameRoleDetail.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(gameRoleDetail.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(gameRoleDetail.getId(), null);
				gameRoleQueue.enqueue(gameRoleDetail);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//更新玩家的updateRolenowtime
	public boolean updateRolenowtime(Map<String, Object> param){
		boolean b = false;
		int roleId = Integer.valueOf(String.valueOf(param.get("id")));
		long nowtime = Long.valueOf(String.valueOf(param.get("nowtime")));
		try{
			GameRoleDetail gameRoleDetail = null;
			try{
				gameRoleDetail = gameRoles.get(roleId);
			}catch(Exception e){
				e.printStackTrace();
			}
			gameRoleDetail.setNowtime(nowtime);
	//		gameRoles.remove(roleId);
			gameRoles.put(roleId, gameRoleDetail);
			gameRoleDetail.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(gameRoleDetail.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(gameRoleDetail.getId(), null);
				gameRoleQueue.enqueue(gameRoleDetail);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//更新玩家的addRolecoinspend
	public boolean addRolecoinspend(Map<String, Object> param){
		boolean b = false;
		int roleId = Integer.valueOf(String.valueOf(param.get("id")));
		int coinspend = Integer.valueOf(String.valueOf(param.get("coinspend")));
		try{
			GameRoleDetail gameRoleDetail = null;
			try{
				gameRoleDetail = gameRoles.get(roleId);
			}catch(Exception e){
				e.printStackTrace();
			}
			gameRoleDetail.setCoinspend(gameRoleDetail.getCoinspend() + coinspend);
			gameRoles.put(roleId, gameRoleDetail);
			gameRoleDetail.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(gameRoleDetail.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(gameRoleDetail.getId(), null);
				gameRoleQueue.enqueue(gameRoleDetail);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//更新玩家的updateRoleDaynumstate
	public boolean updateRoleDaynumstate(Map<String, Object> param){
		boolean b = false;
		int roleId = Integer.valueOf(String.valueOf(param.get("id")));
		String daynumstate = String.valueOf(param.get("daynumstate"));
		try{
			GameRoleDetail gameRoleDetail = null;
			try{
				gameRoleDetail = gameRoles.get(roleId);
			}catch(Exception e){
				e.printStackTrace();
			}
			gameRoleDetail.setDaynumstate(daynumstate);
	//		gameRoles.remove(roleId);
			gameRoles.put(roleId, gameRoleDetail);
			gameRoleDetail.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(gameRoleDetail.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(gameRoleDetail.getId(), null);
				gameRoleQueue.enqueue(gameRoleDetail);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}

	//更新玩家的VIP信息
	public boolean updateRoleVip(Map<String, Object> param){
		boolean b = false;
		int roleId = Integer.valueOf(String.valueOf(param.get("id")));
		try{
			Object vip = param.get("vip");
			Object mapid = param.get("mapid");
			Object mapid2 = param.get("mapid2");
			Object placeid = param.get("placeid");
			Object placeid2 = param.get("placeid2");
			Object exp = param.get("exp");
			Object level = param.get("level");
			Object yin = param.get("yin");
			Object gongxun = param.get("gongxun");
			Object signjl = param.get("signjl");
			Object junling = param.get("junling");
			Object num = param.get("num");
			Object day = param.get("day");
			Object challengenum = param.get("challengenum");
			Object challengetime = param.get("challengetime");
			Object today = param.get("today");
			Object yesterday = param.get("yesterday");
			Object live = param.get("live");
			Object huangzuangift = param.get("huangzuangift");
			Object friends = param.get("friends");
			Object vips = param.get("vips");
			Object imposenum = param.get("imposenum");
			Object share = param.get("share");
			Object onlinetime = param.get("onlinetime");
			Object exist = param.get("exist");
			Object three = param.get("three");
			Object bylevel = param.get("bylevel");
			Object vipTime = param.get("vipTime");
			Object vipGift = param.get("vipGift");
			Object zhuxianling = param.get("zhuxianling");
			Object friendlevel = param.get("friendlevel");
			Object friendcost = param.get("friendcost");
			Object activitytype = param.get("activitytype");
			Object isnew = param.get("isnew");
			Object daycoin = param.get("daycoin");
			Object fubentwo = param.get("fubentwo");
			Object jjtime = param.get("jjtime");
			Object jjstatus = param.get("jjstatus");
			Object jjnum = param.get("jjnum");
			Object jingji = param.get("jingji");
			Object zxtime = param.get("zxtime");
			Object btime = param.get("btime");
			Object fuben = param.get("fuben");
			Object bmap = param.get("bmap");
			Object fubenthree = param.get("fubenthree");
			Object openmountain = param.get("openmountain");
			Object flushmountain = param.get("flushmountain");
			Object alchemygift = param.get("alchemygift");
			Object temperature = param.get("temperature");
			Object fundsgift=param.get("fundsgift");
			Object fundsstatu=param.get("fundsstatu");
			Object seventotal=param.get("seventotal");
			Object aimreward=param.get("aimreward");
			Object getreward=param.get("getreward");
			Object awakenstatu=param.get("awakenstatu");
			Object milluck=param.get("milluck");
			Object zillionaireplace=param.get("zillionaireplace");
			GameRoleDetail gameRoleDetail = null;
			try{
				gameRoleDetail = gameRoles.get(roleId);
			}catch(Exception e){
				e.printStackTrace();
			}
			if(null!=zillionaireplace){
				gameRoleDetail.setZillionaireplace(Integer.valueOf(String.valueOf(zillionaireplace)));//大富翁棋子位置
			}
			if(null!=milluck){
				gameRoleDetail.setMilluck(Integer.valueOf(String.valueOf(milluck)));//武将幸运度
			}
			if(null!=awakenstatu){
				gameRoleDetail.setAwakenstatu(String.valueOf(awakenstatu));
			}
			if(null!=getreward){
				gameRoleDetail.setGetreward(gameRoleDetail.getGetreward()+1);
			}
			if(null!=aimreward){
				gameRoleDetail.setAimreward(String.valueOf(aimreward));
			}
			if(null!=seventotal){
				gameRoleDetail.setSeventotal(String.valueOf(seventotal));
			}
			if(null!=fundsstatu){
				gameRoleDetail.setFundsstatu(Integer.valueOf(String.valueOf(fundsstatu)));
			}
			if(null!=fundsgift){
				gameRoleDetail.setFundsgift(String.valueOf(fundsgift));
			}
			if(null!=alchemygift){
				gameRoleDetail.setAlchemygift(String.valueOf(alchemygift));
			}
			if(null!=temperature){
				gameRoleDetail.setTemperature(Integer.valueOf(String.valueOf(temperature)));
			} 
			if(null!=flushmountain){
				gameRoleDetail.setFlushmountain(String.valueOf(flushmountain));	
			}
			if(null!=openmountain){
				gameRoleDetail.setOpenmountain(String.valueOf(openmountain));
			}
			if(null != exp){
				gameRoleDetail.setExp(Integer.valueOf(String.valueOf(exp)));
			}
			if(null != placeid2){
				gameRoleDetail.setPlaceid2(Integer.valueOf(String.valueOf(placeid2)));
			}
			if(null != placeid){
				gameRoleDetail.setPlaceid(Integer.valueOf(String.valueOf(placeid)));
			}
			if(null != mapid2){
				gameRoleDetail.setMapid2(Integer.valueOf(String.valueOf(mapid2)));
			}
			if(null != mapid){
				gameRoleDetail.setMapid(Integer.valueOf(String.valueOf(mapid)));
			}
			if(null != vip){
				gameRoleDetail.setVip(Integer.valueOf(String.valueOf(vip)));
			}
			if(null != challengenum){
				gameRoleDetail.setChallengenum(Integer.valueOf(String.valueOf(challengenum)));
			}
			if(null != day){
				gameRoleDetail.setDay(Integer.valueOf(String.valueOf(day)));
			}
			if(null != num){
				gameRoleDetail.setNum(Integer.valueOf(String.valueOf(num)));
			}
			if(null != junling){
				gameRoleDetail.setJunling(Integer.valueOf(String.valueOf(junling)));
			}
			if(null != signjl){
				gameRoleDetail.setSignjl(Integer.valueOf(String.valueOf(signjl)));
			}
			if(null != gongxun){
				gameRoleDetail.setGongxun(Integer.valueOf(String.valueOf(gongxun)));
			}
			if(null != yin){
				gameRoleDetail.setYin(Integer.valueOf(String.valueOf(yin)));
			}
			if(null != level){
				gameRoleDetail.setLevel(Integer.valueOf(String.valueOf(level)));
			}
			if(null != challengetime){
				gameRoleDetail.setChallengetime(Long.valueOf(String.valueOf(challengetime)));
			}
			if(null != today){
				gameRoleDetail.setToday(String.valueOf(today));
			}
			if(null != yesterday){
				gameRoleDetail.setYesterday(String.valueOf(yesterday));
			}
			if(null != live){
				gameRoleDetail.setLive(Integer.valueOf(String.valueOf(live)));
			}
			if(null != huangzuangift){
				gameRoleDetail.setHuangzuangift(Integer.valueOf(String.valueOf(huangzuangift)));
			}
			if(null != friends){
				gameRoleDetail.setFriends(String.valueOf(friends));
			}
			if(null != vips){
				gameRoleDetail.setVips(Integer.valueOf(String.valueOf(vips)));
			}
			if(null != imposenum){
				gameRoleDetail.setImposenum(Integer.valueOf(String.valueOf(imposenum)));
			}
			if(null != zhuxianling){
				gameRoleDetail.setZhuxianling(Integer.valueOf(String.valueOf(zhuxianling)));
			}
			if(null != vipGift){
				gameRoleDetail.setVipGift(String.valueOf(vipGift));
			}
			if(null != vipTime){
				gameRoleDetail.setVipTime(String.valueOf(vipTime));
			}
			if(null != bylevel){
				gameRoleDetail.setBylevel(String.valueOf(bylevel));
			}
			if(null != three){
				gameRoleDetail.setThree(String.valueOf(three));
			}
			if(null != exist){
				gameRoleDetail.setExist(String.valueOf(exist));
			}
			if(null != onlinetime){
				gameRoleDetail.setOnlinetime(Long.valueOf(String.valueOf(onlinetime)));
			}
			if(null != share){
				gameRoleDetail.setShare(Integer.valueOf(String.valueOf(share)));
			}
			if(null != friendlevel){
				gameRoleDetail.setFriendlevel(String.valueOf(friendlevel));
			}
			if(null != friendcost){
				gameRoleDetail.setFriendcost(String.valueOf(friendcost));
			}
			if(null != activitytype){
				gameRoleDetail.setActivitytype(String.valueOf(activitytype));
			}
			if(null != isnew){
				gameRoleDetail.setIsnew(String.valueOf(isnew));
			}
			if(null != daycoin){
				gameRoleDetail.setDaycoin(gameRoleDetail.getDaycoin()+Integer.valueOf(String.valueOf(daycoin)));
			//System.out.println("缓存更新玩家今天消费的所有的q点：：：：：：：：：：");
			}
			if(null != bmap){
				gameRoleDetail.setBmap(Integer.valueOf(String.valueOf(bmap)));
			}
			if(null != fuben){
				gameRoleDetail.setFuben(Integer.valueOf(String.valueOf(fuben)));
			}
			if(null != btime){
				gameRoleDetail.setBtime(Long.valueOf(String.valueOf(btime)));
			}
			if(null != zxtime){
				gameRoleDetail.setZxtime(Long.valueOf(String.valueOf(zxtime)));
			}
			if(null != jingji){
				gameRoleDetail.setJingji(Integer.valueOf(String.valueOf(jingji)));
			}
			if(null != jjnum){
				gameRoleDetail.setJjnum(Integer.valueOf(String.valueOf(jjnum)));
			}
			if(null != jjstatus){
				gameRoleDetail.setJjstatus(Integer.valueOf(String.valueOf(jjstatus)));
			}
			if(null != jjtime){
				gameRoleDetail.setJjtime(Long.valueOf(String.valueOf(jjtime)));
			}
			if(null != fubentwo){
				gameRoleDetail.setFubentwo(Integer.valueOf(String.valueOf(fubentwo)));
			}
			if(null != fubenthree){
				gameRoleDetail.setFubenthree(Integer.valueOf(String.valueOf(fubenthree)));
			}
			
		//	gameRoles.remove(roleId);
			gameRoles.put(roleId, gameRoleDetail);
			gameRoleDetail.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(gameRoleDetail.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(gameRoleDetail.getId(), null);
				gameRoleQueue.enqueue(gameRoleDetail);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	public boolean updatebuyitem(Map<String, Object> param) {
		boolean b = false;
		int roleId = Integer.valueOf(String.valueOf(param.get("id")));
		//String buyitem = String.valueOf(param.get("buyitem"));
		Object buyitem = param.get("buyitem");
		Object compensate=param.get("compensate");
		Object qcost=param.get("qcost");
		try{
			GameRoleDetail gameRoleDetail = null;
			try{
				gameRoleDetail = gameRoles.get(roleId);
			}catch(Exception e){
				e.printStackTrace();
			}
			if(buyitem!=null){
				gameRoleDetail.setBuyitem(String.valueOf(param.get("buyitem")));
			}
			if(null!=compensate){
				gameRoleDetail.setCompensate(String.valueOf(param.get("compensate")));
			}
			if(null!=qcost){
				gameRoleDetail.setQcost(String.valueOf(param.get("qcost")));
			}
			//gameRoleDetail.setBuyitem(buyitem);
			//gameRoles.remove(roleId);
			gameRoles.put(roleId, gameRoleDetail);
			gameRoleDetail.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(gameRoleDetail.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(gameRoleDetail.getId(), null);
				gameRoleQueue.enqueue(gameRoleDetail);
			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	public boolean cacheGameRolethree(Map<String, Object> param) {
		//System.out.println("CacheGasmeRoleThree:param:" + param.toString());
		boolean b = false;
		int roleid = Integer.valueOf(String.valueOf(param.get("roleid")));
		Object share=param.get("share");
		Object coin=param.get("coin");
		Object fdshare=param.get("fdshare");
		Object coinspend=param.get("coinspend");
		Object vip=param.get("vip");
		Object flaunt=param.get("flaunt");
		Object sharedemo=param.get("sharedemo");
		Object challenge=param.get("challenge");
		Object oldfriend=param.get("oldfriend");
		Object huangzuaninfo=param.get("huangzuaninfo");
		Object name=param.get("name");
		Object invite=param.get("invite");
		Object ids=param.get("ids");
		Object idsold=param.get("idsold");
		Object huangzuan = param.get("huangzuan");
		GameRoleDetail gr=null;
		gr = gameRoles.get(roleid);
		if(gr != null){
			if(null!=share){
				try{
				gr.setShare(Integer.valueOf(String.valueOf(param.get("share"))));
			//	System.out.println("gr:" + gr + " roleid:" + roleid + " share:" + String.valueOf(param.get("share")) + System.currentTimeMillis());
				}catch(Exception e){
					e.printStackTrace();
			//		System.out.println("gr:" + gr + " roleid:" + roleid + " share:" + String.valueOf(param.get("share")));
					GameConstants.log.warn("gr:" + gr.getShare() + " roleid:" + roleid + " share:" + String.valueOf(param.get("share")));
				}
			}
			if(null!=fdshare){
				gr.setFdshare(Integer.valueOf(String.valueOf(param.get("fdshare"))));
			}
			if(null!=flaunt){
				gr.setFlaunt(Integer.valueOf(String.valueOf(param.get("flaunt"))));
			}
			if(null!=sharedemo){
				gr.setSharedemo(Integer.valueOf(String.valueOf(param.get("sharedemo"))));
			}
			if(null!=challenge){
				gr.setChallenge(Integer.valueOf(String.valueOf(param.get("challenge"))));
			}
			if(null!=oldfriend){
				gr.setOldfriend(Integer.valueOf(String.valueOf(param.get("oldfriend"))));
			}
			if(null!=huangzuaninfo){
				try{
					gr.setHuangzuaninfo(String.valueOf(param.get("huangzuaninfo")));
				}catch(Exception e){
					e.printStackTrace();
					GameConstants.log.warn("gr:" + gr + " roleid:" + roleid + " huangzuaninfo:" + String.valueOf(param.get("huangzuaninfo")));
				}
			}
			if(null!=name){
				try{
					gr.setName(String.valueOf(param.get("name")));
				}catch(Exception e){
					e.printStackTrace();
					GameConstants.log.warn("gr:" + gr + " roleid:" + roleid + " name:" + String.valueOf(param.get("name")));
				}
				
			}
			if(null!=coin){
				try{
					gr.setCoin(Integer.valueOf(String.valueOf(param.get("coin"))));
				}catch(Exception e){
					e.printStackTrace();
					GameConstants.log.warn("gr:" + gr + " roleid:" + roleid + " coin:" + Integer.valueOf(String.valueOf(param.get("coin"))));
				}
				
			}
			if(null!=coinspend){
				gr.setCoinspend(Integer.valueOf(String.valueOf(param.get("coinspend"))));
			}
			if(null!=vip){
				gr.setVip(Integer.valueOf(String.valueOf(param.get("vip"))));
			}
			if(null!=invite){
				gr.setInvite(gr.getInvite()+1);
			}
			if(null!=ids){
				gr.setIds(String.valueOf(param.get("ids")));
			}
			if(null!=idsold){
				gr.setIdsold(String.valueOf(param.get("idsold")));
			}
			if(null!=huangzuan){
				gr.setHuangzuan(Integer.valueOf(String.valueOf(param.get("idsold"))));
			}
			gameRoles.put(roleid, gr);
			gr.setIsUpdate(1);
			if(gameRoleQueue.indexMap.containsKey(gr.getId())){
				//System.out.println("gameRole避免了一次数据库操作");
			}else{
				gameRoleQueue.indexMap.put(gr.getId(), null);
				gameRoleQueue.enqueue(gr);
			}
		}else{
			GameConstants.log.warn("CacheGameRole.cacheGameRolethree():" + gr + " roleid:" + roleid + " param:" + param.toString());
		}
		
		return b;
	}
	public boolean updatefrinedchallenge(int x) {
		boolean b = false;
		try{
			List<GameRoleDetail> list = new ArrayList<GameRoleDetail>();
			Iterator it = gameRoles.keySet().iterator();
			while(it.hasNext()){
				Integer i = Integer.valueOf(it.next().toString());
				//GameRoleDetail gameRole = new GameRoleDetail();
				GameRoleDetail gameRole =null;
				try{
					//gameRole = (GameRoleDetail)gameRoles.get(i).clone();
					gameRole = gameRoles.get(i);
				}catch(Exception e){
					e.printStackTrace();
				}
				if(x==1){
					gameRole.setCompensate("[0,0,0,0,0]");
					//System.out.println("更新用户领取补偿礼包：：：：");
				}
				gameRole.setFlaunt(0);
				gameRole.setFlauntgift(0);
				gameRole.setChallenge(0);
				gameRole.setChallengegift(0);
				gameRole.setSharedemo(0);
				gameRole.setSharedemogift(0);
				gameRole.setFdshare(0);
				gameRole.setFdsharegift(0);
				gameRole.setAllfdgift(0);
				gameRole.setOldfriend(0);
				gameRole.setDaycoin(0);
				gameRole.setQcost("[0,0,0]");
				list.add(gameRole);
			}
		//	System.out.println("数据库异步执行！更新玩家挑战状态，更新玩家数量：" + list.size());
//			for(int i = 0; i < list.size(); i++){
//				GameRoleDetail gameRole = list.get(i);
//				//更新缓存
//				gameRoles.remove(gameRole.getIds());
//				gameRoles.put(gameRole.getId(), gameRole);
//				//更新队列
//				gameRole.setIsUpdate(1);
//				gameRoleQueue.enqueue(gameRole);
//			}
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	public int getnum(int flag){
		List<GameRoleDetail> list = new ArrayList<GameRoleDetail>();
		Iterator it = gameRoles.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GameRoleDetail gameRole =null;
			try{
				gameRole = gameRoles.get(i);
			}catch(Exception e){
				e.printStackTrace();
			}
			if(flag == 1){
				if(gameRole.getJjstatus() == 0)
					list.add(gameRole);
			}else if(flag == 2){
				if(	gameRole.getFlaunt() != 0 ||
					gameRole.getFlauntgift() != 0 ||
					gameRole.getChallenge() != 0 ||
					gameRole.getChallengegift() != 0 ||
					gameRole.getSharedemo() != 0 ||
					gameRole.getSharedemogift() != 0 ||
					gameRole.getFdshare() != 0 ||
					gameRole.getFdsharegift() != 0 ||
					gameRole.getAllfdgift() != 0 ||
					gameRole.getOldfriend() != 0 ||
					gameRole.getDaycoin() != 0)
					list.add(gameRole);
			}else if (flag == 3){
				if(gameRole.getMohunboolean() == 0 || gameRole.getDeskcheck() != 0)
					list.add(gameRole);
			}
			
		}
		for(int i = 0; i < list.size(); i++){
			GameConstants.log.warn("CacheGameRole:last jingji update or share update flag(1:jingji; 2:share):" + flag + " list:"  + list.get(i).getId());
		}
		return list.size();
	}
}
