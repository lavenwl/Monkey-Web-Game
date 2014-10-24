package com.stang.game.ffd.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityDubiousDataDetail;

public class DubiousDataDaoImpl extends EntityDao<EntityDubiousDataDetail> {
	
	
	@SuppressWarnings("static-access")
	public int AddDubiousData(Map<String,Object> params){
		 int result=0;
		  try {
			  	this.sqlMapper.insert("addDubiousData",params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return result;
	 }
	
	@SuppressWarnings("unchecked")
	public List<EntityDubiousDataDetail> getDoubiousInfo(Map<String,Object> params){
		List<EntityDubiousDataDetail> leddd=new ArrayList<EntityDubiousDataDetail>();
		try {
			leddd=this.sqlMapper.queryForList("findAllDubious",params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return leddd;
	}
}
