package com.stang.game.ffd.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGMRejectChatIdsDao;
import com.stang.game.ffd.dao.impl.GMRejectChatIdsDaoImpl;
import com.stang.game.ffd.entity.detail.GMRejectChatIdsDetail;
import com.stang.game.ffd.service.IGMRejectChatIdsService;


public class GMRejectChatIdsServiceImpl extends
		BaseServiceImpl<GMRejectChatIdsDetail> implements
		IGMRejectChatIdsService {
		protected IGMRejectChatIdsDao getBaseDao() {
			if(baseDao==null){
				baseDao = new GMRejectChatIdsDaoImpl();
			}
			return (IGMRejectChatIdsDao) baseDao;
		}

		public void deleteGMRejectChatIdsDetailById(Integer roleId) {
			// TODO Auto-generated method stub
			getBaseDao().deleteGMRejectChatIdsDetailById(roleId);
		}

		public List<GMRejectChatIdsDetail> getGMRejectChatIdsDetailByParam(
				Map<String, Object> param) {
			return getBaseDao().getGMRejectChatIdsDetailByParam(param);
		}

		public void insertGMRejectChatIdsDetail(GMRejectChatIdsDetail gmr) {
			// TODO Auto-generated method stub
			getBaseDao().insertGMRejectChatIdsDetail(gmr);
		}

		public void updateGMRejectChatIdsDetail(GMRejectChatIdsDetail gmr) {
			// TODO Auto-generated method stub
			getBaseDao().updateGMRejectChatIdsDetail(gmr);
		}

		public List<GMRejectChatIdsDetail> getGMRejectChatIdsDetailByTimeAndRoleId(
				int roleId) {
			// TODO Auto-generated method stub
			return getBaseDao().getGMRejectChatIdsDetailByTimeAndRoleId(roleId);
		}

		public List<GMRejectChatIdsDetail> getGMRejectChatIdsDetailByRoleNames(
				String[] names) {
			return getBaseDao().getGMRejectChatIdsDetailByRoleNames(names);
		}

		public void insertGMRejectChatIdsDetails(
				List<GMRejectChatIdsDetail> igmclidList) {
			// TODO Auto-generated method stub
			getBaseDao().insertGMRejectChatIdsDetails(igmclidList);
		}

		public void updateGMRejectChatIdsDetails(
				List<GMRejectChatIdsDetail> gmrcidList) {
			// TODO Auto-generated method stub
			getBaseDao().updateGMRejectChatIdsDetails(gmrcidList);
		}

		public int getGMRejectChatIdsDetailCount() {
			// TODO Auto-generated method stub
			return 	getBaseDao().getGMRejectChatIdsDetailCount();
		}

		public List<GMRejectChatIdsDetail> findGMRejectChatIdsByTime(
				Map<String, Object> param) {
			// TODO Auto-generated method stub
			return 	getBaseDao().findGMRejectChatIdsByTime(param);
		}



}
