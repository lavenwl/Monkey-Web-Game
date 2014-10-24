package com.stang.game.ffd.service;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.GMRejectLoginIdsDetail;


public interface IGMRejectLoginIdsService extends
		IBaseService<GMRejectLoginIdsDetail> {

	public void insertGMRejectLoginIdsDetail(GMRejectLoginIdsDetail gmr);

	public void updateGMRejectLoginIdsDetail(GMRejectLoginIdsDetail gmr);

	public List<GMRejectLoginIdsDetail> getGMRejectLoginIdsDetailByParam(
			Map<String, Object> param);
	public List<GMRejectLoginIdsDetail> getGMRejectLoginIdsDetailByTimeAndRoleId(
			int roleId);

	public void deleteGMRejectLoginIdsDetailById(Integer roleId);

	public List<GMRejectLoginIdsDetail> getGMRejectLoginIdsDetailByRoleNames(String[] names);

	public void insertGMRejectLoginIdsDetails(
			List<GMRejectLoginIdsDetail> igmrlidList);

	public void updateGMRejectLoginIdsDetails(
			List<GMRejectLoginIdsDetail> igmrlidList);
	public int getGMRejectLoginIdsDetailCount();
	
	public List<GMRejectLoginIdsDetail> findGMRejectLoginIdsDetailByTime(
			Map<String, Object> param);
}
