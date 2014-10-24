package com.stang.game.ffd.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityCheckDayDbDetail;

public class CheckDayDbDaoImpl extends EntityDao<EntityCheckDayDbDetail> {
	@SuppressWarnings({ "unchecked", "static-access" })
	public List<EntityCheckDayDbDetail> findAll(Map<String,Object> param){
		List<EntityCheckDayDbDetail> lecddd = new ArrayList<EntityCheckDayDbDetail>();
		try {
			lecddd=this.sqlMapper.queryForList("findAllCheckDayDb",param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lecddd;
	}
	
	
	@SuppressWarnings({ "unchecked", "static-access" })
	public void addCheckDayDbDetail(Map<String,Object> param){
		List<EntityCheckDayDbDetail> lecddd = new ArrayList<EntityCheckDayDbDetail>();
		try {
			this.sqlMapper.insert("AddCheckDayDb",param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int searchCheckDayCount(Map<String,Object> param){
		int value_num=0;
		try {
		value_num=Integer.parseInt(this.sqlMapper.queryForList("searchCheckDayCount",param).get(0)+"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return value_num;
	}
}
