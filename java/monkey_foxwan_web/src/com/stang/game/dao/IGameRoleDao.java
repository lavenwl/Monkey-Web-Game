package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameRoleDetail;
import com.stang.game.entity.detail.RoleImposeDetail;
import com.stang.game.entity.detail.RoleQuicktimeDetail;

public interface IGameRoleDao extends IEntityDao<GameRoleDetail> {

	public boolean updateGameRoleGamblingInfo(Map<String, Object> updateMap);

	public GameRoleDetail findRoleById(int id);

	public boolean updateMap(int mapid, int placeid, int roleId);

	public boolean insertRole(GameRoleDetail model);


	public boolean addRoleCoin(int roleId, int coin);

	public boolean addRoleYin(int roleId, int yin);
	
	public boolean upRoleYin(int roleId, int yin);

	public boolean addRoleGongxun(int roleId, int gongxun);

	public boolean subRoleCoin(int roleId, int coin);

	public boolean subRoleYin(int roleId, int yin);

	public boolean subRoleGongxun(int roleId, int gongxun);

	public boolean addRoleLevel(int roleId, int level, int exp);

	public boolean addRoleExp(int roleId, int exp);
	
	public boolean updateRole(GameRoleDetail model);
	
	//开始游戏，减少1个军令
	public boolean subRolejunling(int roleId, int num);
	
	//军令小于15，每小时增加1 
	public boolean addRolejunling(int roleId, int num);
	
	//军令时间增加1小时 
	public boolean addRolejunlingtime(int roleId, long jltime);
	
	public boolean updateRolestate(Map<String,Object>param);
	
	public boolean updateRolerefertime(Map<String,Object>param);
	
	public boolean updateRolestateseven(Map<String,Object>param);
	
	public boolean updateRoleSupsign(Map<String,Object>param);
	
	public boolean updateRoleDaynumstate(Map<String,Object>param);
	
	public boolean addRolecoinspend(Map<String,Object>param);
	
	public boolean updateRoleVip(Map<String,Object>param);
	
	public boolean updateRolenowtime(Map<String,Object>param);
	
	public boolean updateRoleintegral(Map<String,Object>param);
	public List<GameRoleDetail> getRoleByLevel(Map<String, Object> param);
	
	public boolean updateRolehelpstep(Map<String,Object>param);
	
	public boolean updateRoleline(int roleId, int line);

}
