package com.stang.game.ffd.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGMRejectLoginIdsDao;
import com.stang.game.ffd.dao.impl.GMRejectLoginIdsDaoImpl;
import com.stang.game.ffd.entity.detail.GMRejectLoginIdsDetail;
import com.stang.game.ffd.service.IGMRejectLoginIdsService;


public class GMRejectLoginIdsServiceImpl extends
		BaseServiceImpl<GMRejectLoginIdsDetail> implements
		IGMRejectLoginIdsService {
		protected IGMRejectLoginIdsDao getBaseDao() {
			if(baseDao==null){
				baseDao = new GMRejectLoginIdsDaoImpl();
			}
			return (IGMRejectLoginIdsDao) baseDao;
		}

		public void deleteGMRejectLoginIdsDetailById(Integer roleId) {
			// TODO Auto-generated method stub
			getBaseDao().deleteGMRejectLoginIdsDetailById(roleId);
		}

		public List<GMRejectLoginIdsDetail> getGMRejectLoginIdsDetailByParam(
				Map<String, Object> param) {
			return getBaseDao().getGMRejectLoginIdsDetailByParam(param);
		}

		public void insertGMRejectLoginIdsDetail(GMRejectLoginIdsDetail gmr) {
			// TODO Auto-generated method stub
			getBaseDao().insertGMRejectLoginIdsDetail(gmr);
		}

		public void updateGMRejectLoginIdsDetail(GMRejectLoginIdsDetail gmr) {
			// TODO Auto-generated method stub
			getBaseDao().updateGMRejectLoginIdsDetail(gmr);
		}

		public List<GMRejectLoginIdsDetail> getGMRejectLoginIdsDetailByTimeAndRoleId(
				int roleId) {
			// TODO Auto-generated method stub
			return getBaseDao().getGMRejectLoginIdsDetailByTimeAndRoleId(roleId);	
		}

		public List<GMRejectLoginIdsDetail> getGMRejectLoginIdsDetailByRoleNames(String[] names) {
			// TODO Auto-generated method stub
			return getBaseDao().getGMRejectLoginIdsDetailByRoleNames(names);
		}

		public void insertGMRejectLoginIdsDetails(
				List<GMRejectLoginIdsDetail> igmrlidList) {
			getBaseDao().insertGMRejectLoginIdsDetails(igmrlidList);
		}

		public void updateGMRejectLoginIdsDetails(
				List<GMRejectLoginIdsDetail> igmrlidList) {
			getBaseDao().updateGMRejectLoginIdsDetails(igmrlidList);			
		}

		public int getGMRejectLoginIdsDetailCount() {
			// TODO Auto-generated method stub
			return getBaseDao().getGMRejectLoginIdsDetailCount();
		}

		public List<GMRejectLoginIdsDetail> findGMRejectLoginIdsDetailByTime(
				Map<String, Object> param) {
			// TODO Auto-generated method stub
			return 	getBaseDao().findGMRejectLoginIdsDetailByTime(param);
			}



}
