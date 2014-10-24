package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IServerDao;
import com.stang.game.entity.detail.GameRoleDetail;
import com.stang.game.entity.detail.ServerDetail;

public class ServerDaoImpl extends EntityDao<ServerDetail> implements IServerDao{

	public List<ServerDetail> getAllServer() {
		List<ServerDetail> list = null;
		try {
			list = (List) sqlMapper.queryForList("getAllServer");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	
	}
	
	public boolean updateServerDetail(ServerDetail model) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			System.out.println("SErverDaoImpl.updateServer:serverid:" + model.getId());
			sqlMapper.update("updateServerDetail", model);
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

	
	
}
