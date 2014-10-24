package com.stang.game.ffd.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.common.PageProperty;
import com.stang.game.ffd.dao.IFilterRoleDao;
import com.stang.game.ffd.entity.detail.EntityFilterRoleDetail;
import com.stang.game.ffd.entity.detail.EntityRoleConsortiaDetail;

public class FilterRoleDaoImpl extends EntityDao<EntityFilterRoleDetail> implements IFilterRoleDao {

	public List<EntityFilterRoleDetail> findFilterRoleByMap(
			Map<String, Object> param) {
		List<EntityFilterRoleDetail> list=null;
		try {
			list=this.sqlMapper.queryForList("findFilterRoleByMap",param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	

	public int insertFilterRoleDetail(EntityFilterRoleDetail entity) {
		int i =0;
		try {
			this.sqlMapper.startTransaction();
			this.sqlMapper.insert("insertFilterRoleDetail",entity);
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
	

	public int updateFilterRoleDetail(EntityFilterRoleDetail entity) {
		int i =0;
		try {
			sqlMapper.startTransaction();
			i=sqlMapper.update("updateFilterRoleDetail",entity);
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




