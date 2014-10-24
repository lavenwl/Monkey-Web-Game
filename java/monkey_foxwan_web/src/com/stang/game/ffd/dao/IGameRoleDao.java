package com.stang.game.ffd.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityGameRoleDetail;

public interface IGameRoleDao extends IEntityDao<EntityGameRoleDetail> {
	
	/**
	 * 获取游戏中所有的职业信息
	 */
	public List<EntityGameRoleDetail> getGameJob(Map<String,Object> param);

	public List<String> getRoleNameByIllegibleName(String name);


	/**
	 * 获取当前游戏服务器的总金币数
	 * 
	 */
	public Long getSum();

	public List<Integer> getRoleIdByRoeName(String name);

	public String getRoleNameByRoleId(Integer receiver);
	
	public List<Integer> getIdByRoleName(String params);
	
	public String getRoleNameByMemberId(Map<String,Object> param);
	
	public String getRoleIdByMemberId(Map<String,Object> param);
	
	public List<Map<String,Object>> getRoleLevel();
	
	public int getGameRoleCount(Map<String,Object> param);

}
