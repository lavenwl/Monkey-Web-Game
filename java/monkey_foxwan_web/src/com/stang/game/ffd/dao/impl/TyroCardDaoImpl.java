package com.stang.game.ffd.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


import com.stang.game.ffd.dao.ITyroCardDao;
import com.stang.game.ffd.dao.impl.EntityDao;
import com.stang.game.ffd.entity.detail.TyroCardDetail;

public class TyroCardDaoImpl extends EntityDao<TyroCardDetail> implements
		ITyroCardDao {

	public int insertTryoCardDetail(TyroCardDetail tcd) {
		int num=0;
		try {
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.insert("insertTryoCardDetail", tcd);
			sqlMapperFlight.commitTransaction();
			num=1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sqlMapperFlight.endTransaction();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return num;
	}

	public List<TyroCardDetail> findTryoCardDetailByParam(
			Map<String, Object> map) {
		List<TyroCardDetail> list = null;
		try {
			list = sqlMapperFlight.queryForList("findTryoCardDetailByParam", map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}


	public int updateTryoCardDetail(TyroCardDetail tcd) {
		int num=0;
		try {

			sqlMapperFlight.startTransaction();
			num=sqlMapperFlight.update("updateTryoCardDetail", tcd);
			sqlMapperFlight.commitTransaction();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				sqlMapperFlight.endTransaction();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return num;

	}


}
