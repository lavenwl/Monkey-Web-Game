package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IDeliveryDao;
import com.stang.game.entity.detail.DeliveryDetail;
import com.stang.game.entity.detail.MemberDetail;

public class DeliveryDaoImpl extends EntityDao<DeliveryDetail> implements
		IDeliveryDao {

	@Override
	public List<DeliveryDetail> findDeliveryByopenid(String openid) {
		List<DeliveryDetail> list = null;
		try {
			list = sqlMapper.queryForList("findDeliveryByopenid", openid);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public boolean updateDelivery(DeliveryDetail model){
		System.out.println("updateDelivery:model.status:___________________________________:" + model.getStatus() );

		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateDeliveryc", model);
			sqlMapper.commitTransaction();
			isSuccess = true;
		} catch (Exception e) {
			GameConstants.log.warn("", e);
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("", e);
			}
		}
		return isSuccess;
	}
	
	public boolean insertDelivery(DeliveryDetail model){
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertDelivery", model);
			sqlMapper.commitTransaction();
			isSuccess = true;
		} catch (Exception e) {
			GameConstants.log.warn("", e);
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("", e);
			}
		}
		return isSuccess;
	}
	
	
	@Override
	public boolean updateDelivery(Map<String, Object> param) {
		System.out.println("updateDelivery:param___________________________________:" + param.toString() );
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateDelivery", param);
			sqlMapper.commitTransaction();
			isSuccess = true;
		} catch (Exception e) {
			GameConstants.log.warn("", e);
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("", e);
			}
		}
		return isSuccess;
	}

	@Override
	public List<DeliveryDetail> findeDeliveryByList(Map<String, Object> param) {
		List<DeliveryDetail> list = null;
		try {
			list = sqlMapper.queryForList("findDeliveryByList", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<DeliveryDetail> findAllDelivery() {
		List<DeliveryDetail> list = null;
		try {
			list = sqlMapper.queryForList("findAllDelivery");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

}
