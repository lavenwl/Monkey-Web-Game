package com.stang.game.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IAutoIdDao;
import com.stang.game.dao.impl.AutoIdDaoImpl;
import com.stang.game.entity.detail.AutoIdDetail;
import com.stang.game.service.IAutoIdService;

public class AutoIdServiceImpl extends BaseServiceImpl<AutoIdDetail> implements
		IAutoIdService {

	protected IAutoIdDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new AutoIdDaoImpl();
		}
		return (IAutoIdDao) baseDao;
	}

	public Integer fingKeyValueByTableName(String tableName) {
		// TODO Auto-generated method stub
		return getBaseDao().fingKeyValueByTableName(tableName);
	}

	public int updateKeyValueAddOneByTableName(String tableName) {
		// TODO Auto-generated method stub
		return getBaseDao().updateKeyValueAddOneByTableName(tableName);
	}

	public boolean updateAutoIdDetail(AutoIdDetail model) {
		// TODO Auto-generated method stub
		boolean isSuccess = false;

		try {
			int dataCode = this.getBaseDao().update(model);
			if (dataCode == GameConstants.CODE_DAO_SUCCESS) {
				isSuccess = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;
	}

	public boolean updateKeyValueByTableName(String tableName, int keyValue) {
		// TODO Auto-generated method stub
		boolean isSuccess = false;
		try {
			this.getBaseDao().updateKeyValueByTableName(tableName, keyValue);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("tableName", tableName);
			while (true) {
				AutoIdDetail _model = this.getBaseDao()
						.getAutoIdDetalByProperty(param);
				if (_model.getKeyValue().intValue() != keyValue) {
					System.out.println("更新主键值不成功，继续....");
					this.getBaseDao().updateKeyValueByTableName(tableName,
							keyValue);
				} else {
					System.out.println("更新主键值成功，退出。");
					isSuccess = true;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	public int updateByTableName(String tableName) {
		return getBaseDao().updateByTableName(tableName);
	}

}
