package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.TempPackageDetail;

public interface ITempPackageDao extends IEntityDao<TempPackageDetail> {

	public List<TempPackageDetail> getTempPackage(Map<String, Object> param);

	public void updateTempPackageByParam(Map<String, Object> param);

	public void insertTempPackageDetail(List<TempPackageDetail> list);

	public void insertTempPackage(Map<String, Object> param);

	public void updateTempPackageByList(List<TempPackageDetail> updateList);

	public void deleteTempPackageDetailByParam(Map<String, Object> param);

	public boolean deleteTempPackageDetailByIds(
			List<TempPackageDetail> tempPackageList);

}
