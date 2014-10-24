package com.stang.game.ffd.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGameRoleDao;
import com.stang.game.ffd.entity.detail.EntityGameRoleDetail;

public class GameRoleDaoImpl extends EntityDao<EntityGameRoleDetail> implements IGameRoleDao {
	public List<EntityGameRoleDetail> getGameJob(Map<String,Object> param){
		List<EntityGameRoleDetail> legrd=null; 
		try {
			legrd=this.sqlMapperFlight.queryForList("getGameRoleDetail",param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return legrd;
	}

	public List<String> getRoleNameByIllegibleName(String name){
		List<String> names = null;
		try {
			names=this.sqlMapperFlight.queryForList("getRoleNameByIllegibleName",name);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return names;
	}
	public List<Integer> getRoleIdByRoeName(String name){
		List<Integer> ids = null;
			
		try {
			ids = this.sqlMapperFlight.queryForList("getRoleIdByRoeName",name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ids;
	}

	
	public Long getSum(){
		long sumMoney=0;
		try{
			sumMoney=Long.parseLong(this.sqlMapperFlight.queryForObject("getSum")+"");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return sumMoney;
	}

	public String getRoleNameByRoleId(Integer receiver) {
		List<String> names = null;
		String name = null;
		try {
			names=this.sqlMapperFlight.queryForList("getRoleNameByRoleId",receiver);
			for(int i = 0 ;i<names.size() ;i++){
				name = names.get(0);	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return name;
	}
	public List<Integer> selectIdAndCreateTime(Map<String,Object> params){
		List<Integer> result=new ArrayList<Integer>();
		try {
			result=this.sqlMapperFlight.queryForList("selectIdAndCreateTime",params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	} 
	
	@SuppressWarnings("unchecked")
	public List<Integer> getIdByRoleName(String roleName){
		List<Integer> result = new ArrayList<Integer>();
		try {
			result=this.sqlMapperFlight.queryForList("getRoleIdByRoeName",roleName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public String getRoleNameByMemberId(Map<String,Object> param){
		String roleName="";
		try {
			if(this.sqlMapperFlight.queryForList("getRoleNameByPpsNum",param).size()>0)
			roleName=this.sqlMapperFlight.queryForList("getRoleNameByPpsNum",param).get(0)+"";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roleName;
	}
	
	public String getRoleIdByMemberId(Map<String,Object> param){
		String roleId="";
		try {
			if(this.sqlMapperFlight.queryForList("getRoleIdByPpsNum",param).size()>0)
			roleId=this.sqlMapperFlight.queryForList("getRoleIdByPpsNum",param).get(0)+"";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roleId;
	}
	
	public List<Map<String,Object>> getRoleLevel(){
		List<Map<String,Object>> lmap=null;
		try {
			if(this.sqlMapperFlight.queryForList("getRoleIdByLevel").size()>0)
				lmap=this.sqlMapperFlight.queryForList("getRoleIdByLevel");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lmap;
	}
	
	public int getGameRoleCount(Map<String,Object> param){
		int result=0;
		try{
			result=Integer.parseInt(this.sqlMapperFlight.queryForList("getMemberCount",param).get(0)+"");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}
}
