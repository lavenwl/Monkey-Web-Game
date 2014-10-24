package com.stang.game.ffd.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGameItemsDao;
import com.stang.game.ffd.entity.detail.EntityGameItemsDetail;

public class GameItemsDaoImpl extends EntityDao<EntityGameItemsDetail> implements IGameItemsDao {
	public List<EntityGameItemsDetail> getAllInfo(Map<String,Object> parm){
		List<EntityGameItemsDetail> legid=null;
		try {
			legid=this.sqlMapperFlight.queryForList("findGameItemsByParam",parm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return legid;
	}
	
	public List<EntityGameItemsDetail> findGameItemsById (){
		List<EntityGameItemsDetail> legid=null;
		try {
			legid=this.sqlMapperFlight.queryForList("findGameItemsById");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return legid;
	}
	
	public int insertGameItemDetail(EntityGameItemsDetail param){
		int rs=0;
		try {
			this.sqlMapperFlight.insert("insertGameItemDetail",param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public List<EntityGameItemsDetail> findGameItemsGiftBag(Map<String,Object> parm){
		List<EntityGameItemsDetail> legid = null;
		try {
			legid=this.sqlMapperFlight.queryForList("findGameItemsGiftBag",parm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return legid;
	}
	
	
	public int delGiftBag(Map<String,Object> parm){
		int rs=0;
		try {
			rs=this.sqlMapperFlight.delete("delGiftBag",parm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public String getItemNameById(Map<String, Object> param) {
		List<String> names = new ArrayList<String>();
		String name = null;
		try {
			names=this.sqlMapperFlight.queryForList("getItemNameById",param);
			if(names.size()>0){
				name = names.get(0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
}
