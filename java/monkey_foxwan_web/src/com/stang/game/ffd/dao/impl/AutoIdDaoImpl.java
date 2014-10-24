package com.stang.game.ffd.dao.impl;

import java.sql.SQLException;

import java.util.List;


import com.stang.game.ffd.common.GameConstants;
import com.stang.game.ffd.dao.IAutoIdDao;
import com.stang.game.ffd.entity.detail.AutoIdDetail;

public class AutoIdDaoImpl extends EntityDao<AutoIdDetail> implements
		IAutoIdDao {

	public Integer fingKeyValueByTableName(String tableName) {
		// TODO Auto-generated method stub

		Integer keyValue = new Integer(0);
		synchronized (tableName) {
			try {

				sqlMapper.startTransaction();
				List list = (List) sqlMapper.queryForList(
						"fingKeyValueByTableName", tableName);
				sqlMapper.update("updateKeyValueAddOneByTableName", tableName);
				sqlMapper.commitTransaction();
				if (!list.isEmpty() && list != null) {
					keyValue = (Integer) list.get(0);
				}
				list = null;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					sqlMapper.endTransaction();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return keyValue;
	}

	public int updateKeyValueAddOneByTableName(String tableName) {
		return GameConstants.CODE_DATA_SUCCESS;
	}
	// public int updateKeyValueAddOneByTableName(String tableName) {
	// // TODO Auto-generated method stub
	// int dataCode = GameConstants.CODE_DATA_FAILURE;
	//
	// try {
	// HashMap param = new HashMap();
	// param.put("tableName", tableName);
	// sqlMapper.startTransaction();
	// sqlMapper.update("updateKeyValueAddOneByTableName", param);
	// sqlMapper.commitTransaction();
	// dataCode = GameConstants.CODE_DATA_SUCCESS;
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// try {
	// sqlMapper.endTransaction();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	//
	// return dataCode;
	// }
	//
	// public int updateKeyValueByTableName(String tableName, int keyValue) {
	// // TODO Auto-generated method stub
	// int dataCode = GameConstants.CODE_DATA_FAILURE;
	//
	// try {
	// HashMap param = new HashMap();
	// param.put("keyValue", keyValue);
	// param.put("tableName", tableName);
	// sqlMapper.startTransaction();
	// sqlMapper.update("updateKeyValueByTableName", param);
	// sqlMapper.commitTransaction();
	// dataCode = GameConstants.CODE_DATA_SUCCESS;
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// try {
	// sqlMapper.endTransaction();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	//
	// return dataCode;
	// }
	//
	// public AutoIdDetail getAutoIdDetalByProperty(Map<String, Object> param) {
	// // TODO Auto-generated method stub
	// AutoIdDetail model = null;
	//
	// try {
	// List<AutoIdDetail> list = sqlMapper.queryForList("getAutoIdDetail",
	// param);
	// if (list != null) {
	// if (!list.isEmpty()) {
	// for (AutoIdDetail _model : list) {
	// if (_model != null) {
	// model = _model;
	// break;
	// }
	// }
	// }
	// }
	// list = null;
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// return model;
	// }

}
