package com.stang.game.ffd.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;


import com.stang.game.ffd.dao.ICaseDateExDao;
import com.stang.game.ffd.entity.detail.EntityCaseDateExDetail;

public class CaseDateExDaoImpl extends EntityDao<EntityCaseDateExDetail> implements ICaseDateExDao {

	@SuppressWarnings("unchecked")
	public List<EntityCaseDateExDetail> getTableName() {
		// TODO Auto-generated method stub
		List<EntityCaseDateExDetail> ecded=null;
		HashMap<String,String> ma=new HashMap<String,String>();
		try{
			ecded=sqlMapper.queryForList("getTableName",ma);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ecded;
	}

}
