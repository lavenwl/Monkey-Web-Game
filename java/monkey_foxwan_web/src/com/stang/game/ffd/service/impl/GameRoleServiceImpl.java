package com.stang.game.ffd.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.common.Response;
import com.stang.game.ffd.dao.IGameRoleDao;
import com.stang.game.ffd.dao.impl.GameRoleDaoImpl;
import com.stang.game.ffd.entity.detail.EntityGameRoleDetail;
import com.stang.game.ffd.service.IGameRoleService;

public class GameRoleServiceImpl extends BaseServiceImpl<EntityGameRoleDetail> implements
		IGameRoleService {

	public IGameRoleDao getBaseDao(){
		if(this.baseDao==null){
			baseDao = new GameRoleDaoImpl();
		}
		return (IGameRoleDao)baseDao;
	}
	
	public List<EntityGameRoleDetail> getGameJob(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().getGameJob(param);
	}
	
	public List<EntityGameRoleDetail> getGameJob(List<EntityGameRoleDetail> param,int roleRace){
		List<EntityGameRoleDetail> legrd= new ArrayList<EntityGameRoleDetail>();
		for(EntityGameRoleDetail temprs : param ){
			if(temprs.getRoleRace()==roleRace){
				legrd.add(temprs);
			}
		}
		return legrd;
	}
	
	public Long getSum(){
		return getBaseDao().getSum();
	}

	public List<String> getRoleNameByIllegibleName(String name) {
		// TODO Auto-generated method stub
		return getBaseDao().getRoleNameByIllegibleName(name);
	}

	public List<Integer> getRoleIdByRoeName(String name) {
		// TODO Auto-generated method stub
		return getBaseDao().getRoleIdByRoeName(name);
	}

	public String getRoleNameByRoleId(Integer receiver) {
		// TODO Auto-generated method stub
		return getBaseDao().getRoleNameByRoleId(receiver);
		}

	 public List<Integer> getIdByRoleName(String params){
		 return getBaseDao().getIdByRoleName(params);
	 }
	
	 public String getRoleNameByMemberId(Map<String,Object> param){
		 return getBaseDao().getRoleNameByMemberId(param);
	 }
	 
	 public String getRoleIdByMemberId(Map<String,Object> param){
		 return getBaseDao().getRoleIdByMemberId(param);
	 }
	 
	 public List<Map<String,Object>> getRoleLevel(){
		 return getBaseDao().getRoleLevel();
	 }
	 
	 public int getGameRoleCount(Map<String,Object> param){
		 return getBaseDao().getGameRoleCount(param);
	 }
}
