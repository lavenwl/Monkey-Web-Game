package com.stang.game.ffd.service;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.GMRejectIpsDetail;

public interface IGMRejectIpsService extends IBaseService<GMRejectIpsDetail> {

	void insertGMRejectIpsDetail(GMRejectIpsDetail grid);

	void updateGMRejectIpsDetail(Map<String, Object> param);

	List<GMRejectIpsDetail> findGMRejectIpsDetailByParam(
			Map<String, Object> param);

	void deleteGMRejectIpsDetail(Map<String, Object> param);
	
	int getGMRejectIpsCount();
	
	List<GMRejectIpsDetail> findGMRejectIpsDetailByTime(
			Map<String, Object> param);
}
