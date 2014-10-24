package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.ITempPackageDao;
import com.stang.game.dao.impl.TempPackageDaoImpl;
import com.stang.game.entity.detail.TempPackageDetail;
import com.stang.game.service.ITempPackageService;

public class TempPackageServiceImpl extends BaseServiceImpl<TempPackageDetail>
		implements ITempPackageService {

	protected ITempPackageDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new TempPackageDaoImpl();
		}
		return (ITempPackageDao) baseDao;
	}

	public List<TempPackageDetail> getTempPackage(Map<String, Object> param) {
		return getBaseDao().getTempPackage(param);
	}

	public void updateTempPackageByParam(Map<String, Object> param) {
		getBaseDao().updateTempPackageByParam(param);

	}

	public void insertTempPackageDetail(List<TempPackageDetail> list) {
		getBaseDao().insertTempPackageDetail(list);
	}

	public void updateTempPackageByList(List<TempPackageDetail> updateList) {
		getBaseDao().updateTempPackageByList(updateList);
	}

	public void deleteTempPackageDetailByParam(Map<String, Object> param) {
		getBaseDao().deleteTempPackageDetailByParam(param);
	}

	public boolean deleteTempPackageDetailByIds(
			List<TempPackageDetail> tempPackageList) {
		return getBaseDao().deleteTempPackageDetailByIds(tempPackageList);
	}

	public void insertTempPackage(Map<String, Object> param) {
		getBaseDao().insertTempPackage(param);
	}

}
