package com.stang.game.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.dao.IGameLevelDao;
import com.stang.game.dao.IGameRoleDao;
import com.stang.game.dao.impl.GameLevelDaoImpl;
import com.stang.game.dao.impl.GameRoleDaoImpl;
import com.stang.game.entity.detail.GameLevelDetail;
import com.stang.game.entity.detail.GameRoleDetail;
import com.stang.game.service.IGameRoleService;
import com.stang.game.cache.*;

public class GameRoleServiceImpl extends BaseServiceImpl<GameRoleDetail>
		implements IGameRoleService {
	
	@Override
	public List<GameRoleDetail> findAllGameRole() {
		return getBaseDao().findAllGameRole();
	}
	@Override
	public int getnum(int flag) {
		return getCacheGameRole().getnum(flag);
	}
	private CacheGameRole cacheGameRole;
	private CacheGameRole getCacheGameRole(){
		if(cacheGameRole == null){
			cacheGameRole = new CacheGameRole();
		}
		return cacheGameRole;
	}
	
	private IGameLevelDao gameLevelDao;
	private IGameRoleDao gameRoleDao;

	private IGameRoleDao getGameRoleDao() {
		if (gameRoleDao == null) {
			gameRoleDao = new GameRoleDaoImpl();
		}
		return gameRoleDao;
	}

	private IGameLevelDao getGameLevelDao() {
		if (gameLevelDao == null) {
			gameLevelDao = new GameLevelDaoImpl();
		}
		return gameLevelDao;
	}

	protected IGameRoleDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GameRoleDaoImpl();
		}
		return (IGameRoleDao) baseDao;
	}

	@Override
	public GameRoleDetail findRoleById(int id) {
		return getCacheGameRole().findRoleById(id);
		//return getBaseDao().findRoleById(id);
	}

	@Override
	public boolean insertRole(GameRoleDetail model) {
		return getCacheGameRole().insertRole(model);
		//return getBaseDao().insertRole(model);
	}

	@Override
	public boolean updateRole(GameRoleDetail model) {
		return getCacheGameRole().updateRole(model);
		//return getBaseDao().updateRole(model);
	}

	@Override
	public boolean updateMap(int mapid, int placeid, int roleId) {
		return getCacheGameRole().updateMap(mapid, placeid, roleId);
		//return getBaseDao().updateMap(mapid, placeid, roleId);
	}

	@Override
	public boolean addRoleCoin(int roleId, int coin) {
		return getCacheGameRole().addRoleCoin(roleId, coin);
		//return getBaseDao().addRoleCoin(roleId, coin);
	}

	@Override
	public boolean addRoleGongxun(int roleId, int gongxun) {
		return getCacheGameRole().addRoleGongxun(roleId, gongxun);
		//return getBaseDao().addRoleGongxun(roleId, gongxun);
	}

	@Override
	public boolean addRoleYin(int roleId, int yin) {
		return getCacheGameRole().addRoleYin(roleId, yin);
//		return getBaseDao().addRoleYin(roleId, yin);
	}

	@Override
	public boolean subRoleCoin(int roleId, int coin) {
		return getCacheGameRole().subRoleCoin(roleId, coin);
		//return getBaseDao().subRoleCoin(roleId, coin);
	}

	@Override
	public boolean subRoleGongxun(int roleId, int gongxun) {
		return getCacheGameRole().subRoleGongxun(roleId, gongxun);
//		return getBaseDao().subRoleGongxun(roleId, gongxun);
	}

	@Override
	public boolean subRoleYin(int roleId, int yin) {
		return getCacheGameRole().subRoleYin(roleId, yin);
//		return getBaseDao().subRoleYin(roleId, yin);
	}

	@Override
	public boolean addRoleExp(int roleId, int exp) {
//		boolean bo = false;
//		// 获得用户信息
//		GameRoleDetail gr = this.getGameRoleDao().findRoleById(roleId);
//		int key = gr.getLevel();
//		int roleexp = gr.getExp() + exp;
//		// 得到模型数据
//		GameLevelDetail gl = this.getGameLevelDao()
//				.getGameLevelByRoleLevel(key);
//		// 判断
//		if (roleexp >= gl.getNeedexp()) {
//			// 到升级的时候了
//			roleexp = roleexp - gl.getNeedexp();
//			this.getGameRoleDao().addRoleLevel(roleId, (key + 1), roleexp);
//		} else {
//			this.getGameRoleDao().addRoleExp(roleId, roleexp);
//		}
//		return bo;
		return getCacheGameRole().addRoleExp(roleId, exp);
	}

	@Override
	public boolean addRoleLevel(int roleId, int level, int exp) {
		return getCacheGameRole().addRoleLevel(roleId, level, exp);
//		return getBaseDao().addRoleLevel(roleId, level, exp);
	}

	@Override
	public boolean upRoleYin(int roleId, int yin) {
		return getCacheGameRole().upRoleYin(roleId, yin);
//		return getBaseDao().upRoleYin(roleId, yin);
	}

	@Override
	public boolean updateGameRoleGamblingInfo(Map<String, Object> updateMap) {
		return getCacheGameRole().updateGameRoleGamebingInfo(updateMap);
//		return getBaseDao().updateGameRoleGamblingInfo(updateMap);
	}

	@Override
	public boolean subRolejunling(int roleId, int num) {
		return getCacheGameRole().subRolejunling(roleId, num);
//		return getBaseDao().subRolejunling(roleId,num);
	}

	@Override
	public boolean addRolejunling(int roleId, int num) {
		return getCacheGameRole().addRolejunling(roleId, num);
//		return getBaseDao().addRolejunling(roleId,num);
	}

	@Override
	public boolean addRolejunlingtime(int roleId, long jltime) {
		return getCacheGameRole().addRolejunlingtime(roleId, jltime);
//		return getBaseDao().addRolejunlingtime(roleId,jltime);
	}

	@Override
	public boolean updateRolestate(Map<String, Object> param) {
		return getCacheGameRole().updateRolestate(param);
//		return getBaseDao().updateRolestate(param);
	}

	@Override
	public boolean updateRolerefertime(Map<String, Object> param) {
		return getCacheGameRole().updateRolerefertime(param);
//		return getBaseDao().updateRolerefertime(param);
	}

	@Override
	public boolean updateRolestateseven(Map<String, Object> param) {
		return getCacheGameRole().updateRolestateseven(param);
//		return getBaseDao().updateRolestateseven(param);
	}

	@Override
	public boolean updateRoleSupsign(Map<String, Object> param) {
		return getCacheGameRole().updateRoleSupsign(param);
//		return getBaseDao().updateRoleSupsign(param);
	}

	@Override
	public boolean updateRoleDaynumstate(Map<String, Object> param) {
		return getCacheGameRole().updateRoleDaynumstate(param);
//		return getBaseDao().updateRoleDaynumstate(param);
	}

	@Override
	public boolean addRolecoinspend(Map<String, Object> param) {
		return getCacheGameRole().addRolecoinspend(param);
//		return getBaseDao().addRolecoinspend(param);
	}

	@Override
	public boolean updateRoleVip(Map<String, Object> param) {
		return getCacheGameRole().updateRoleVip(param);
//		return getBaseDao().updateRoleVip(param);
	}

	@Override
	public boolean updateRolenowtime(Map<String, Object> param) {
		return getCacheGameRole().updateRolenowtime(param);
//		return getBaseDao().updateRolenowtime(param);
	}
	
	@Override
	public boolean updateRolehelpstep(Map<String, Object> param) {
		return getCacheGameRole().updateRolehelpstep(param);
//		return getBaseDao().updateRolehelpstep(param);
	}

	@Override
	public boolean updateRoleintegral(Map<String, Object> param) {
		return getCacheGameRole().updateRoleintegral(param);
//		return getBaseDao().updateRoleintegral(param);
	}
	@Override
	public List<GameRoleDetail> getRoleByLevel(Map<String, Object> param) {
		//System.out.println("执行了getRoleByLevel！");
		return getBaseDao().getRoleByLevel(param);
	}

	@Override
	public boolean updateRoleline(int roleId, int line) {
		return getCacheGameRole().updateRoleline(roleId, line);
//		return getBaseDao().updateRoleline(roleId, line);
	}

	@Override
	public List<GameRoleDetail> getRoleByLevels(Map<String, Object> param) {
		System.out.println("执行了getRoleByLevels");
		return getBaseDao().getRoleByLevels(param);
	}

	@Override
	public GameRoleDetail findRoleByName(String name) {
		System.out.println("执行了findRoleByName");
		return getBaseDao().findRoleByName(name);
	}
	
	@Override
	public boolean updateRoleVipGiftTime(Map<String, Object> param) {
		return getCacheGameRole().updateRoleVipGiftTime(param);
//		return getBaseDao().updateRoleVipGiftTime(param);
	}

	@Override
	public boolean updateJingji(int jjstatus) {
		//同步缓存
		getCacheGameRole().updateJingji(jjstatus);
		//同步数据库
		return getBaseDao().updateJingji(jjstatus);
	}

	@Override
	public boolean updateDeskcheck(int jjstatus) {
		//同步缓存
		getCacheGameRole().updateDeskcheck(jjstatus);
		//同步数据库
		return getBaseDao().updateDeskcheck(jjstatus);
	}
	
	@Override
	public boolean updatefrinedchallenge() {
		//同步缓存
		getCacheGameRole().updatefrinedchallenge();
		//同步数据库
		return getBaseDao().updatefrinedchallenge();
	}

	@Override
	public boolean updateRoleGift(GameRoleDetail model) {
		return getCacheGameRole().updateRoleGift(model);
//		return getBaseDao().updateRoleGift(model);
	}

	@Override
	public boolean updateRoleGift2(GameRoleDetail model) {
		return getCacheGameRole().updateRoleGift2(model);
//		return getBaseDao().updateRoleGift2(model);
	}

	@Override
	public boolean updateRoleGift3(GameRoleDetail model) {
		return getCacheGameRole().updateRoleGift3(model);
//		return getBaseDao().updateRoleGift3(model);
	}

	@Override
	public boolean updateRoleGift4(GameRoleDetail model) {
		return getCacheGameRole().updateRoleGift4(model);
//		return getBaseDao().updateRoleGift4(model);
	}

	@Override
	public boolean updateRoleGift5(GameRoleDetail model) {
		return getCacheGameRole().updateRoleGift5(model);
//		return getBaseDao().updateRoleGift5(model);
	}

	@Override
	public List<GameRoleDetail> getRoleByLevels1() {
		//System.out.println("执行了：getRoleByLevel");
		return getBaseDao().getRoleByLevels1();
	}

	@Override
	public List<GameRoleDetail> getRoleByLevels2() {
		//System.out.println("执行了：getRoleByLeve2");
		return getBaseDao().getRoleByLevels2();
	}

	@Override
	public List<GameRoleDetail> getRoleByLevels3() {
		//System.out.println("执行了：getRoleByLeve3");
		return getBaseDao().getRoleByLevels3();
	}

	@Override
	public List<GameRoleDetail> getRoleByLevels4() {
		//System.out.println("执行了：getRoleByLeve4");
		return getBaseDao().getRoleByLevels4();
	}

	@Override
	public List<GameRoleDetail> getRoleByLevels5() {
		//System.out.println("执行了：getRoleByLeve5");
		return getBaseDao().getRoleByLevels5();
	}

	@Override
	public List<GameRoleDetail> getRoleByLevels6() {
		//System.out.println("执行了：getRoleByLeve6");
		return getBaseDao().getRoleByLevels6();
	}

	@Override
	public List<GameRoleDetail> getRoleByLevels7() {
		//System.out.println("执行了：getRoleByLeve7");
		return getBaseDao().getRoleByLevels7();
	}

	@Override
	public GameRoleDetail findRoleById2(int id) {
		return getCacheGameRole().findRoleById(id);
//		return getBaseDao().findRoleById2(id);
	}

	@Override
	public GameRoleDetail findRoleById3(int id) {
		return getCacheGameRole().findRoleById(id);
//		return getBaseDao().findRoleById3(id);
	}

	@Override
	public GameRoleDetail findRoleById4(int id) {
		return getCacheGameRole().findRoleById(id);
//		return getBaseDao().findRoleById4(id);
	}

	@Override
	public List<GameRoleDetail> getRoleByLevels01() {
		System.out.println("执行了：getRoleByLevels01");
		return getBaseDao().getRoleByLevels01();
	}

	@Override
	public List<GameRoleDetail> getRoleByLevels02() {
		System.out.println("执行了：getRoleByLevels02");
		return getBaseDao().getRoleByLevels02();
	}

	@Override
	public List<GameRoleDetail> getRoleByLevels03() {
		System.out.println("执行了：getRoleByLevels03");
		return getBaseDao().getRoleByLevels03();
	}

	@Override
	public List<GameRoleDetail> getRoleByLevels04() {
		System.out.println("执行了：getRoleByLevels04");
		return getBaseDao().getRoleByLevels04();
	}

	@Override
	public List<GameRoleDetail> getRoleByLevels05() {
		System.out.println("执行了：getRoleByLevels05");
		return getBaseDao().getRoleByLevels05();
	}

	@Override
	public List<GameRoleDetail> getRoleByLevels06() {
		System.out.println("执行了：getRoleByLevels06");
		return getBaseDao().getRoleByLevels06();
	}

	@Override
	public List<GameRoleDetail> getRoleByLevels07() {
		System.out.println("执行了：getRoleByLevels07");
		return getBaseDao().getRoleByLevels07();
	}

	@Override
	public boolean upactivitygift(Map<String, Object> param) {
		return getCacheGameRole().upactivitygift(param);
//		return getBaseDao().upactivitygift(param);
	}

	@Override
	public boolean upoldfriendgift(Map<String, Object> param) {
		return getCacheGameRole().upoldfriendgift(param);
//		return getBaseDao().upoldfriendgift(param);
	}

	@Override
	public boolean updateTotem(Map<String, Object> param) {
		// TODO Auto-generated method stub
		//return getBaseDao().updateTotem(param);
		return getCacheGameRole().updateTotem(param);
	}

	@Override
	public boolean updatebuyitem(Map<String, Object> param) {
		// TODO Auto-generated method stub
		//return getCacheGameRole().updateRolestate(param);
		return getCacheGameRole().updatebuyitem(param);
	}

	@Override
	public GameRoleDetail cachefindRoleById(int id) {
		// TODO Auto-generated method stub
		return getBaseDao().findRoleById(id);
	}

	@Override
	public boolean cacheGameRolethree(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getCacheGameRole().cacheGameRolethree(param);
	}

	@Override
	public boolean updatefrinedchallenge(int i) {
		// TODO Auto-generated method stub
		//同步缓存
		getCacheGameRole().updatefrinedchallenge(i);
		//同步数据库
		return getBaseDao().updatefrinedchallenge(i);
	}
}
