package com.stang.game.ffd.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.GMRejectIpsDetail;

public interface IGMRejectIpsDao extends IEntityDao<GMRejectIpsDetail> {

	void deleteGMRejectIpsDetail(Map<String, Object> param);

	List<GMRejectIpsDetail> findGMRejectIpsDetailByParam(
			Map<String, Object> param);

	void insertGMRejectIpsDetail(GMRejectIpsDetail grid);

	void updateGMRejectIpsDetail(Map<String, Object> param);

	int getGMRejectIpsCount();

	List<GMRejectIpsDetail> findGMRejectIpsDetailByTime(
			Map<String, Object> param);

}
