package com.stang.game.ffd.service;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityGameRoleDetail;

public interface IGameRoleService extends IBaseService<EntityGameRoleDetail> {
	
	public List<EntityGameRoleDetail> getGameJob(Map<String,Object> param);
	
	public List<EntityGameRoleDetail> getGameJob(List<EntityGameRoleDetail> param,int roleRace);
	

	public List<String> getRoleNameByIllegibleName(String name);

	public Long getSum();
	
	public List<Integer> getRoleIdByRoeName(String name);

	public String getRoleNameByRoleId(Integer receiver);
	
	public List<Integer> getIdByRoleName(String params);
	 
	 /**
	  * 根据pps 获取的 pps账号获取 玩家在游戏里面的角色名
	  * @param param
	  * @return
	  */
	public String getRoleNameByMemberId(Map<String,Object> param);
	
	public String getRoleIdByMemberId(Map<String,Object> param);
	
	public List<Map<String,Object>> getRoleLevel();
	
	public int getGameRoleCount(Map<String,Object> param);
}
