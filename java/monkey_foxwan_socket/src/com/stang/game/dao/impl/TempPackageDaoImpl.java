package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.ITempPackageDao;
import com.stang.game.entity.detail.TempPackageDetail;

public class TempPackageDaoImpl extends EntityDao<TempPackageDetail> implements
		ITempPackageDao {

	public List<TempPackageDetail> getTempPackage(Map<String, Object> param) {
		List<TempPackageDetail> list = null;
		try {
			list = sqlMapper.queryForList("getTempPackage", param);
		} catch (Exception e) {
			GameConstants.log.warn("", e);
		}

		return list;
	}

	public void updateTempPackageByParam(Map<String, Object> param) {
		try {

			sqlMapper.startTransaction();
			sqlMapper.update("updateTempPackageByParam", param);
			sqlMapper.commitTransaction();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			GameConstants.log.warn("", e);
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				GameConstants.log.warn("", e);
			}
		}

	}

	public void insertTempPackageDetail(List<TempPackageDetail> list) {
		try {
			sqlMapper.startTransaction();
			sqlMapper.startBatch();
			for (int i = 0; i < list.size(); i++) {
				sqlMapper.insert("insertTempPackageDetail", list.get(i));
			}
			sqlMapper.executeBatch();
			sqlMapper.commitTransaction();
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				GameConstants.log.warn("", e);
			}
		}
	}

	public void updateTempPackageByList(List<TempPackageDetail> updateList) {
		try {
			sqlMapper.startTransaction();
			sqlMapper.startBatch();
			for (int i = 0; i < updateList.size(); i++) {
				sqlMapper.insert("updateTempPackageByList", updateList.get(i));
			}
			sqlMapper.executeBatch();
			sqlMapper.commitTransaction();
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				GameConstants.log.warn("", e);
			}
		}
	}

	public void deleteTempPackageDetailByParam(Map<String, Object> param) {
		// TODO Auto-generated method stub
		try {

			sqlMapper.startTransaction();
			sqlMapper.delete("deleteTempPackageDetailByParam", param);
			sqlMapper.commitTransaction();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			GameConstants.log.warn("", e);
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				GameConstants.log.warn("", e);
			}
		}
	}

	public boolean deleteTempPackageDetailByIds(
			List<TempPackageDetail> tempPackageList) {
		boolean flag = false;
		List<Integer> ids = new ArrayList<Integer>();
		for (int i = 0; i < tempPackageList.size(); i++) {
			int id = tempPackageList.get(i).getId();
			ids.add(id);
		}

		try {
			Map param = new HashMap();
			param.put("ids", ids);
			sqlMapper.startTransaction();
			sqlMapper.delete("deleteTempPackageDetailByIds", param);
			sqlMapper.commitTransaction();
			flag = true;
		} catch (Exception e) {
			GameConstants.log.warn("", e);
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				GameConstants.log.warn("", e);
			}
		}

		return flag;
	}

	@Override
	public void insertTempPackage(Map<String, Object> param) {
		try {
			sqlMapper.startTransaction();
			sqlMapper.startBatch();
			sqlMapper.insert("insertTempPackage", param);
			sqlMapper.executeBatch();
			sqlMapper.commitTransaction();
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				GameConstants.log.warn("", e);
			}
		}
	}

	@Override
	public List<TempPackageDetail> findAllTempPackage() {
		List<TempPackageDetail> list = null;
		try {
			list = sqlMapper.queryForList("findAllTempPackage");
		} catch (Exception e) {
			GameConstants.log.warn("", e);
		}

		return list;
	}

}
