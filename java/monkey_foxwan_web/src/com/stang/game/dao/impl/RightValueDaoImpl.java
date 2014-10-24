package com.stang.game.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.dao.IRightValueDao;
import com.stang.game.entity.detail.EntityRightUserDetail;
import com.stang.game.entity.detail.EntityRightValueDetail;

public class RightValueDaoImpl extends EntityDao<EntityRightValueDetail>
		implements IRightValueDao {

	public List<EntityRightValueDetail> findRightValueByMap(
			Map<String, Object> param) {
		List<EntityRightValueDetail> list = null;
		try {
			list = this.sqlMapper.queryForList("findRightValueByMap", param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public int insertRightValueDetail(EntityRightValueDetail entity) {
		int i =0;
		try {
			this.sqlMapper.startTransaction();
			this.sqlMapper.insert("insertRightValueDetail",entity);
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

	public int updateRightValueDetail(EntityRightValueDetail entity) {
		int i =0;
		try {
			sqlMapper.startTransaction();
			i=sqlMapper.update("updateRightValueDetail",entity);
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
