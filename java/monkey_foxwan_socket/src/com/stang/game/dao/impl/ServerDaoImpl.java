package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IServerDao;
import com.stang.game.entity.detail.ActivityDetail;
import com.stang.game.entity.detail.RoletotemDetail;
import com.stang.game.entity.detail.ServerDetail;

public class ServerDaoImpl extends EntityDao<ServerDetail> implements IServerDao{

	@Override
	public List<ServerDetail> getAllServer() {
		List<ServerDetail> list = null;
		try {
			list = sqlMapper.queryForList("getAllServer");
		} catch (SQLException e) {
			GameConstants.log.warn("",e);
		}
		return list;
	}

	@Override
	public List<ServerDetail> getAllNewServer() {
		List<ServerDetail> list = null;
		try {
			list = sqlMapper.queryForList("getAllNewServer");
		} catch (SQLException e) {
			GameConstants.log.warn("",e);
		}
		return list;
	}

	@Override
	public List<ServerDetail> getnamebyid(int id) {
		List<ServerDetail> list = null;
		try {
			list = sqlMapper.queryForList("getnamebyid",id);
		} catch (SQLException e) {
			GameConstants.log.warn("",e);
		}
		return list;
	}
	@Override
	public void updateServer(ServerDetail detail) {
		//System.out.println("ServerDaoImpl.updateServer:serverid:" + detail.getId() + " onlineNum:" + detail.getOnlineNum());
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateServer", detail);
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
		//return isSuccess;
	}
}
