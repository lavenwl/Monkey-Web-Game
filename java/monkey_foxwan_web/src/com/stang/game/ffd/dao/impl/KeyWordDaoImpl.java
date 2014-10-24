package com.stang.game.ffd.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.common.PageProperty;
import com.stang.game.ffd.dao.IKeyWordDao;
import com.stang.game.ffd.entity.detail.EntityGameRoleDetail;
import com.stang.game.ffd.entity.detail.EntityKeyWordDetail;

public class KeyWordDaoImpl extends EntityDao<EntityKeyWordDetail> implements
		IKeyWordDao {

	public void deleteEntityKeyWordDetaill(EntityKeyWordDetail keyWord) {
		try {
			this.sqlMapper.startTransaction();
			this.sqlMapper.insert("deleteEntityKeyWordDetaill", keyWord);
			this.sqlMapper.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.sqlMapper.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public List<EntityKeyWordDetail> findEntityKeyWordDetailByParam(
			Map<String, Object> map) {
		List<EntityKeyWordDetail> legrd = null;
		try {
			legrd = this.sqlMapper.queryForList(
					"findEntityKeyWordDetailByParam", map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return legrd;
	}

	public void insertEntityKeyWordDetaill(EntityKeyWordDetail keyWord) {
		try {
			this.sqlMapper.startTransaction();
			this.sqlMapper.insert("insertEntityKeyWordDetaill", keyWord);
			this.sqlMapper.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.sqlMapper.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void updateEntityKeyWordDetail(EntityKeyWordDetail keyWord) {
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateEntityKeyWordDetail", keyWord);
			sqlMapper.commitTransaction();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
