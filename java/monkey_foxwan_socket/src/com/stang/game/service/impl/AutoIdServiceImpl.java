package com.stang.game.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.stang.game.cache.*;
import com.stang.game.common.GameConstants;
import com.stang.game.dao.IAutoIdDao;
import com.stang.game.dao.impl.AutoIdDaoImpl;
import com.stang.game.entity.detail.AutoIdDetail;
import com.stang.game.service.IAutoIdService;

public class AutoIdServiceImpl extends BaseServiceImpl<AutoIdDetail> implements
		IAutoIdService {

	private static CacheAutoId cacheAutoId = null;
	private static CacheAutoId getCacheAutoId(){
		if(cacheAutoId == null){
			cacheAutoId = new CacheAutoId();
		}
		return cacheAutoId;
	}
	
	protected IAutoIdDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new AutoIdDaoImpl();
		}
		return (IAutoIdDao) baseDao;
	}

	public Integer fingKeyValueByTableName(String tableName) {
		return getCacheAutoId().fingKeyValueByTableName(tableName);
//		return getBaseDao().fingKeyValueByTableName(tableName);
	}

	public int updateKeyValueAddOneByTableName(String tableName) {
		return getCacheAutoId().updateKeyValueAddOneByTableName(tableName);
//		return getBaseDao().updateKeyValueAddOneByTableName(tableName);
	}

	public boolean updateAutoIdDetail(AutoIdDetail model) {
		return getCacheAutoId().updateAutoIdDetail(model);
//		boolean isSuccess = false;
//		try {
//			int dataCode = this.getBaseDao().update(model);
//			if (dataCode == GameConstants.CODE_DAO_SUCCESS) {
//				isSuccess = true;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return isSuccess;
	}

	public boolean updateKeyValueByTableName(String tableName, int keyValue) {
		return getCacheAutoId().updateKeyValueByTableName(tableName, keyValue);
//		boolean isSuccess = false;
//		try {
//			this.getBaseDao().updateKeyValueByTableName(tableName, keyValue);
//			Map<String, Object> param = new HashMap<String, Object>();
//			param.put("tableName", tableName);
//			while (true) {
//				AutoIdDetail _model = this.getBaseDao()
//						.getAutoIdDetalByProperty(param);
//				if (_model.getKeyValue().intValue() != keyValue) {
//					System.out.println("更新主键值不成功，继续....");
//					this.getBaseDao().updateKeyValueByTableName(tableName,
//							keyValue);
//				} else {
//					System.out.println("更新主键值成功，退出。");
//					isSuccess = true;
//					break;
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return isSuccess;
	}

	@Override
	public int updateByTableName(String tableName) {
		return getCacheAutoId().updateByTableName(tableName);
		//return getBaseDao().updateByTableName(tableName);
	}

	@Override
	public int updateAutoIdGamechart(int id) {
		// TODO Auto-generated method stub
		return getCacheAutoId().updateAutoIdGamechart(id);
		//return getBaseDao().updateAutoIdGamechart(id);
	}

	@Override
	public List<AutoIdDetail> findAllAutoId() {
		// TODO Auto-generated method stub
		return getBaseDao().findAllAutoId();
	}

}
