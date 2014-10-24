package com.stang.game.ffd.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IFilterIPDao;
import com.stang.game.ffd.entity.detail.EntityFilterIPDetail;
import com.stang.game.ffd.entity.detail.EntityFilterRoleDetail;

public class FilterIPDaoImpl extends EntityDao<EntityFilterIPDetail> implements IFilterIPDao {

	public List<EntityFilterIPDetail> findFilterIPByMap(
			Map<String, Object> param) {
		List<EntityFilterIPDetail> list=null;
		try {
			list=this.sqlMapper.queryForList("findFilterIPByMap",param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public int insertFilterIPDetail(EntityFilterIPDetail entity) {
		int i =0;
		try {
			this.sqlMapper.startTransaction();
			this.sqlMapper.insert("insertFilterIPDetail",entity);
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

	public int updateFilterIPDetail(EntityFilterIPDetail entity) {
		int i =0;
		try {
			sqlMapper.startTransaction();
			i=sqlMapper.update("updateFilterIPDetail",entity);
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
