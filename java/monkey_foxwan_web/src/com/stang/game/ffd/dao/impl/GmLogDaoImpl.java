package com.stang.game.ffd.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGmLogDao;
import com.stang.game.ffd.entity.detail.EntityFilterIPDetail;
import com.stang.game.ffd.entity.detail.EntityGmLogDetail;

public class GmLogDaoImpl extends EntityDao<EntityGmLogDetail> implements IGmLogDao{

	public List<EntityGmLogDetail> findGmLogByMap(Map<String, Object> param) {
		List<EntityGmLogDetail> list=null;
		try {
			list=this.sqlMapper.queryForList("findGmLogByMap",param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public int insertGmLogDetail(EntityGmLogDetail entity) {
		int i =0;
		try {
			this.sqlMapper.startTransaction();
			this.sqlMapper.insert("insertGmLogDetail",entity);
			this.sqlMapper.commitTransaction();
			i=1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				this.sqlMapper.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return i;
	}

	public int updateGmLogDetai(EntityGmLogDetail entity) {
		int i =0;
		try {
			sqlMapper.startTransaction();
			i=sqlMapper.update("updateGmLogDetail",entity);
			sqlMapper.commitTransaction();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return i;
	}
}
