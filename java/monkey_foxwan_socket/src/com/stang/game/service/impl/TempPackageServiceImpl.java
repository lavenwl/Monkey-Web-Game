package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.cache.CacheTempPackage;
import com.stang.game.dao.ITempPackageDao;
import com.stang.game.dao.impl.TempPackageDaoImpl;
import com.stang.game.entity.detail.TempPackageDetail;
import com.stang.game.service.ITempPackageService;

public class TempPackageServiceImpl extends BaseServiceImpl<TempPackageDetail>
		implements ITempPackageService {
	CacheTempPackage c0;
	private CacheTempPackage c(){
		if(c0==null){
			c0=new CacheTempPackage();
		}
		return c0;
	}

	protected ITempPackageDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new TempPackageDaoImpl();
		}
		return (ITempPackageDao) baseDao;
	}

	public List<TempPackageDetail> getTempPackage(Map<String, Object> param) {
		//return c.getTempPackage(param);
	
		return getBaseDao().getTempPackage(param);
	}

	public void updateTempPackageByParam(Map<String, Object> param) {
		//c.updateTempPackageByParam(param);

		getBaseDao().updateTempPackageByParam(param);

	}

	public void insertTempPackageDetail(List<TempPackageDetail> list) {
		//c.insertTempPackageDetail(list);

		getBaseDao().insertTempPackageDetail(list);
	}

	public void updateTempPackageByList(List<TempPackageDetail> updateList) {
		//c.updateTempPackageByList(updateList);

		getBaseDao().updateTempPackageByList(updateList);
	}

	public void deleteTempPackageDetailByParam(Map<String, Object> param) {
		//c.deleteTempPackageDetailByParam(param);
		getBaseDao().deleteTempPackageDetailByParam(param);
	}

	public boolean deleteTempPackageDetailByIds(
			List<TempPackageDetail> tempPackageList) {
		return getBaseDao().deleteTempPackageDetailByIds(tempPackageList);
	}

	@Override
	public void insertTempPackage(Map<String, Object> param) {
		//c.insertTempPackage(param);

		getBaseDao().insertTempPackage(param);
	}

	@Override
	public List<TempPackageDetail> findAllTempPackage() {
		// TODO Auto-generated method stub
		return getBaseDao().findAllTempPackage();
	}

}
