package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IAutoIdDao;
import com.stang.game.entity.detail.AutoIdDetail;

public class AutoIdDaoImpl extends EntityDao<AutoIdDetail> implements
		IAutoIdDao {

	public Integer fingKeyValueByTableName(String tableName) {
		Integer keyValue = new Integer(0);
		try {
			List list = (List) sqlMapper.queryForList(
					"fingKeyValueByTableName", tableName);
			if (!list.isEmpty() && list != null) {
				keyValue = (Integer) list.get(0);
			}
			list = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return keyValue;
	}

	public int updateKeyValueAddOneByTableName(String tableName) {
		int dataCode = GameConstants.CODE_DATA_FAILURE;

		try {
			HashMap param = new HashMap();
			param.put("tableName", tableName);
			sqlMapper.startTransaction();
			sqlMapper.update("updateKeyValueAddOneByTableName", param);
			sqlMapper.commitTransaction();
			dataCode = GameConstants.CODE_DATA_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return dataCode;
	}

	public int updateKeyValueByTableName(String tableName, int keyValue) {
		int dataCode = GameConstants.CODE_DATA_FAILURE;

		try {
			HashMap param = new HashMap();
			param.put("keyValue", keyValue);
			param.put("tableName", tableName);
			sqlMapper.startTransaction();
			sqlMapper.update("updateKeyValueByTableName", param);
			sqlMapper.commitTransaction();
			dataCode = GameConstants.CODE_DATA_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return dataCode;
	}

	public AutoIdDetail getAutoIdDetalByProperty(Map<String, Object> param) {
		AutoIdDetail model = null;

		try {
			List<AutoIdDetail> list = sqlMapper.queryForList("getAutoIdDetail",
					param);
			if (list != null) {
				if (!list.isEmpty()) {
					for (AutoIdDetail _model : list) {
						if (_model != null) {
							model = _model;
							break;
						}
					}
				}
			}
			list = null;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return model;
	}

	@Override
	public int updateByTableName(String tableName) {
		int dataCode = GameConstants.CODE_DATA_FAILURE;
		try {
			HashMap param = new HashMap();
			param.put("tableName", tableName);
			sqlMapper.startTransaction();
			sqlMapper.update("updateByTableName", param);
			sqlMapper.commitTransaction();
			dataCode = GameConstants.CODE_DATA_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dataCode;
	}

	@Override
	public int updateAutoIdGamechart(int id) {
		int dataCode = GameConstants.CODE_DATA_FAILURE;

		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateAutoIdGamechart", id);
			sqlMapper.commitTransaction();
			dataCode = GameConstants.CODE_DATA_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return dataCode;
	
	
	}

	@Override
	public List<AutoIdDetail> findAllAutoId() {
		List<AutoIdDetail> roles = null;
		try {
			roles = sqlMapper.queryForList("findAllAutoId");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		if (!roles.isEmpty()) {
			return roles;
		} else {
			return null;
		}
	}

	@Override
	public boolean updateAutoId(AutoIdDetail autoIdDetail) {
		boolean bo = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateAutoId",autoIdDetail);
			sqlMapper.commitTransaction();
			bo = true;
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}finally{
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("", e);
			}
		}
		return bo;
	}

	@Override
	public boolean insertAutoId(AutoIdDetail autoIdDetail) {
		boolean bo = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("insertAutoId",autoIdDetail);
			sqlMapper.commitTransaction();
			bo = true;
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}finally{
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("", e);
			}
		}
		return bo;
	}

}
