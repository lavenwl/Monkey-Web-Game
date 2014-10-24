package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameRoleDetail;

public interface IGameRoleService extends IBaseService<GameRoleDetail> {

	public boolean updateGameRoleGamblingInfo(Map<String, Object> updateMap);

	public GameRoleDetail findRoleById(int id);

	public boolean insertRole(GameRoleDetail model);

	public boolean updateRole(GameRoleDetail model);

	public boolean updateMap(int mapid, int placeid, int roleId);

	public boolean addRoleCoin(int roleId, int coin);

	public boolean addRoleYin(int roleId, int yin);

	public boolean addRoleGongxun(int roleId, int gongxun);

	public boolean subRoleCoin(int roleId, int coin);

	public boolean subRoleYin(int roleId, int yin);

	public boolean subRoleGongxun(int roleId, int gongxun);

	public boolean addRoleLevel(int roleId, int level, int exp);

	public boolean addRoleExp(int roleId, int exp);

	public boolean upRoleYin(int roleId, int yin);
	
	//寮�娓告垙锛屽噺灏�涓啗浠�
	public boolean subRolejunling(int roleId, int num);
	
	//鍐涗护灏忎簬15锛屾瘡灏忔椂澧炲姞1 
	public boolean addRolejunling(int roleId, int num);
	
	//鍐涗护鏃堕棿澧炲姞1灏忔椂 
	public boolean addRolejunlingtime(int roleId, long jltime);
	
	public boolean updateRolestate(Map<String,Object>param);
	//鏈堜唤鏇存柊鐨勫弬鐓ф椂闂�
	public boolean updateRolerefertime(Map<String,Object>param);
	
	public boolean updateRolestateseven(Map<String,Object>param);
	
	public boolean updateRoleSupsign(Map<String, Object> param);
	
	public boolean updateRoleDaynumstate(Map<String,Object>param);
	
	public boolean addRolecoinspend(Map<String,Object>param);
	
	public boolean updateRoleVip(Map<String,Object>param);
	
	public boolean updateRolenowtime(Map<String,Object>param);

	public boolean updateRoleintegral(Map<String,Object>param);
	
	public List<GameRoleDetail> getRoleByLevel(Map<String, Object> param);
	
	public boolean updateRolehelpstep(Map<String,Object>param);
	
	public boolean updateRoleline(int roleId, int line);
	
}
