package com.stang.game.ffd.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.GMRejectChatIdsDetail;


public interface IGMRejectChatIdsDao extends IEntityDao<GMRejectChatIdsDetail> {

	public void deleteGMRejectChatIdsDetailById(Integer roleId);

	public List<GMRejectChatIdsDetail> getGMRejectChatIdsDetailByParam(
			Map<String, Object> param);

	public void insertGMRejectChatIdsDetail(GMRejectChatIdsDetail gmr);

	public void updateGMRejectChatIdsDetail(GMRejectChatIdsDetail gmr);

	public List<GMRejectChatIdsDetail> getGMRejectChatIdsDetailByTimeAndRoleId(
			int roleId);

	public List<GMRejectChatIdsDetail> getGMRejectChatIdsDetailByRoleNames(
			String[] names);


	public void insertGMRejectChatIdsDetails(
			List<GMRejectChatIdsDetail> igmclidList);

	public void updateGMRejectChatIdsDetails(
			List<GMRejectChatIdsDetail> gmrcidList);

	public int getGMRejectChatIdsDetailCount();

	public List<GMRejectChatIdsDetail> findGMRejectChatIdsByTime(
			Map<String, Object> param);


}
