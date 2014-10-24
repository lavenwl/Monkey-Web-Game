package com.stang.game.ffd.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGameSkillDao;
import com.stang.game.ffd.entity.detail.EntityGameSkillDetail;
public class GameSkillDaoImpl extends EntityDao<EntityGameSkillDetail> implements IGameSkillDao {
	public List<EntityGameSkillDetail> getAllInfo(){
		//获取技能表里面所有的数据
		List<EntityGameSkillDetail> legsd= new ArrayList<EntityGameSkillDetail>();
		try{
			legsd=this.sqlMapperFlight.queryForList("getAllInfoSkill");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return legsd;
	}
	
	public List<EntityGameSkillDetail> getAllInfo(Map<String,Object> params){
		//获取技能表里面所有的数据
		List<EntityGameSkillDetail> legsd= new ArrayList<EntityGameSkillDetail>();
		try{
			legsd=this.sqlMapperFlight.queryForList("listEntityGameSkillDetail",params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return legsd;
	}
}
