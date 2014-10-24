package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameRoleDetail;

public interface IGameRoleService extends IBaseService<GameRoleDetail> {
	public GameRoleDetail cachefindRoleById(int id);
	public List<GameRoleDetail> findAllGameRole();
	public boolean updatebuyitem(Map<String,Object>param);
	public boolean cacheGameRolethree(Map<String,Object>param);
	public boolean updateTotem(Map<String,Object>param);
	public boolean updateGameRoleGamblingInfo(Map<String, Object> updateMap);
	public boolean upoldfriendgift(Map<String,Object>param);
	public GameRoleDetail findRoleById(int id);
	public GameRoleDetail findRoleById3(int id);
	public GameRoleDetail findRoleById4(int id);
	public boolean insertRole(GameRoleDetail model);
	public GameRoleDetail findRoleById2(int id);
	public boolean updateRoleGift2(GameRoleDetail model);
	public boolean updateRoleGift3(GameRoleDetail model);
	public boolean updateRoleGift4(GameRoleDetail model);
	public boolean updateRoleGift5(GameRoleDetail model);
	public List<GameRoleDetail> getRoleByLevels1();
	public List<GameRoleDetail> getRoleByLevels2();
	public List<GameRoleDetail> getRoleByLevels3();
	public List<GameRoleDetail> getRoleByLevels4();
	public List<GameRoleDetail> getRoleByLevels5();
	public List<GameRoleDetail> getRoleByLevels6();
	public List<GameRoleDetail> getRoleByLevels7();
	public boolean updateRole(GameRoleDetail model);
	public boolean updateRoleGift(GameRoleDetail model);
	public boolean updateMap(int mapid, int placeid, int roleId);
	public GameRoleDetail findRoleByName(String name);
	public boolean addRoleCoin(int roleId, int coin);
	public boolean updatefrinedchallenge();
	public boolean addRoleYin(int roleId, int yin);
	public boolean upactivitygift(Map<String,Object>param);
	public boolean addRoleGongxun(int roleId, int gongxun);
	
	public boolean subRoleCoin(int roleId, int coin);

	public boolean subRoleYin(int roleId, int yin);

	public boolean subRoleGongxun(int roleId, int gongxun);

	public boolean addRoleLevel(int roleId, int level, int exp);

	public boolean addRoleExp(int roleId, int exp);
      
	public boolean upRoleYin(int roleId, int yin);
	
	//开始游戏，减少1个军令
	public boolean subRolejunling(int roleId, int num);
	
	//军令小于15，每小时增加1 
	public boolean addRolejunling(int roleId, int num);
	
	//军令时间增加1小时 
	public boolean addRolejunlingtime(int roleId, long jltime);
	
	public boolean updateRolestate(Map<String,Object>param);
	//月份更新的参照时间
	public boolean updateRolerefertime(Map<String,Object>param);
	
	public boolean updateRolestateseven(Map<String,Object>param);
	
	public boolean updateRoleSupsign(Map<String, Object> param);
	
	public boolean updateRoleDaynumstate(Map<String,Object>param);
	
	public boolean updateRoleVipGiftTime(Map<String, Object> param);
	
	public boolean addRolecoinspend(Map<String,Object>param);
	
	public boolean updateRoleVip(Map<String,Object>param);
	
	public boolean updateRolenowtime(Map<String,Object>param);

	public boolean updateRoleintegral(Map<String,Object>param);
	
	public List<GameRoleDetail> getRoleByLevel(Map<String, Object> param);
	
	public boolean updateRolehelpstep(Map<String,Object>param);
	
	public boolean updateRoleline(int roleId, int line);
	
	public List<GameRoleDetail> getRoleByLevels(Map<String, Object> param);
	
	public boolean updateJingji(int jjstatus);
	public int getnum(int flag);
	public List<GameRoleDetail> getRoleByLevels01();
	public List<GameRoleDetail> getRoleByLevels02();
	public List<GameRoleDetail> getRoleByLevels03();
	public List<GameRoleDetail> getRoleByLevels04();
	public List<GameRoleDetail> getRoleByLevels05();
	public List<GameRoleDetail> getRoleByLevels06();
	public List<GameRoleDetail> getRoleByLevels07();
	public boolean updatefrinedchallenge(int i);
	boolean updateDeskcheck(int jjstatus);
	
}
