package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.TempPackageDetail;
import com.stang.game.service.IBaseService;

public interface ITempPackageService extends IBaseService<TempPackageDetail> {

	public List<TempPackageDetail> getTempPackage(Map<String, Object> param);

	public void updateTempPackageByParam(Map<String, Object> param);

	public void insertTempPackageDetail(List<TempPackageDetail> list);

	public void updateTempPackageByList(List<TempPackageDetail> updateList);

	public void deleteTempPackageDetailByParam(Map<String, Object> param);

	public boolean deleteTempPackageDetailByIds(
			List<TempPackageDetail> tempPackageList);

	public void insertTempPackage(Map<String, Object> param);

}
