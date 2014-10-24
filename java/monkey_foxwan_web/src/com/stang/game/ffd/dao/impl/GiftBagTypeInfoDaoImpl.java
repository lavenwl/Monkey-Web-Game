package com.stang.game.ffd.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGiftBagTypeInfoDao;
import com.stang.game.ffd.entity.detail.EntityGiftBagTypeInfoDetail;

public class GiftBagTypeInfoDaoImpl extends EntityDao<EntityGiftBagTypeInfoDetail> implements IGiftBagTypeInfoDao {

	public boolean AddGiftBagType(EntityGiftBagTypeInfoDetail param) {
		// TODO Auto-generated method stub
		try {
			this.sqlMapperFlight.insert("addGiftBagTypeInfo",param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean EditGiftBagType(EntityGiftBagTypeInfoDetail param) {
		// TODO Auto-generated method stub
		int rs=0;
			try {
				rs=this.sqlMapperFlight.update("updateGiftTypeInfo",param);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(rs>0){
				return true;
			}else
		return false;
	}
	
	@SuppressWarnings({ "unchecked", "static-access" })
	public List<EntityGiftBagTypeInfoDetail> findGiftBagType(EntityGiftBagTypeInfoDetail param){
		List<EntityGiftBagTypeInfoDetail>legbtid = new ArrayList<EntityGiftBagTypeInfoDetail>();
		try {
			legbtid=this.sqlMapperFlight.queryForList("findAllGiftTypeInfo",param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return legbtid;
	}
	
	@SuppressWarnings({ "unchecked", "static-access" })
	public List<EntityGiftBagTypeInfoDetail> findGiftBagType(){
		List<EntityGiftBagTypeInfoDetail>legbtid = new ArrayList<EntityGiftBagTypeInfoDetail>();
		try {
			legbtid=this.sqlMapperFlight.queryForList("findAllGiftTypeInfoAll");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return legbtid;
	}
	
	//根据名字来查询是否有数据已经使用。
	public  List<EntityGiftBagTypeInfoDetail> findGiftBagTypeByName(EntityGiftBagTypeInfoDetail param){
		List<EntityGiftBagTypeInfoDetail>legbtid = new ArrayList<EntityGiftBagTypeInfoDetail>();
		try {
			legbtid=this.sqlMapperFlight.queryForList("findAllGiftTypeInfoByName",param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return legbtid;
	}
	
	public int editGiftBagTypeByFlag(EntityGiftBagTypeInfoDetail param) {
		// TODO Auto-generated method stub
		int rs=0;
			try {
				rs=this.sqlMapperFlight.update("updateGiftTypeInfoStats",param);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return rs;
	}
	
	public void editetest(){
		System.out.print("testfuncton");
	}
	
	public List<EntityGiftBagTypeInfoDetail> findGiftAll(){
		List<EntityGiftBagTypeInfoDetail>legbtid = new ArrayList<EntityGiftBagTypeInfoDetail>();
		try {
			legbtid=this.sqlMapperFlight.queryForList("findAllGiftTypeAll");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return legbtid;
	}
}
