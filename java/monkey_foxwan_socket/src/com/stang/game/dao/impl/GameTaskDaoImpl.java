package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameTaskDao;
import com.stang.game.entity.detail.GameTaskDetail;

public class GameTaskDaoImpl extends EntityDao<GameTaskDetail> implements
		IGameTaskDao {

	@Override
	public List<GameTaskDetail> getAllGameTask() {
		List<GameTaskDetail> list = null;
		try {
			list = sqlMapper.queryForList("getAllGameTask");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameTaskDetail> getGameTaskDetail(Map<String, Object> map) {
		List<GameTaskDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameTaskDetail", map);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameTaskDetail> getGameTaskDetailById(int id) {
		List<GameTaskDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameTaskDetailById", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameTaskDetail> getGameTaskDetailByLv(int rolelevel) {
		List<GameTaskDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameTaskDetailByLv", rolelevel);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameTaskDetail> getGameTaskDetailByType(int type) {
		List<GameTaskDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameTaskDetailByType", type);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameTaskDetail> getGameTaskDetailByLvandold(int level, int old) {
		List<GameTaskDetail> list = null;
		try {
			Map<String, Object> aa = new HashMap<String, Object>();// 存放数据
			aa.put("tasklevel", level);
			aa.put("oldid", 0);
			list = sqlMapper.queryForList("getGameTaskDetailByLvandold", aa);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameTaskDetail> getGameTaskDetailByoId(int oid) {
		List<GameTaskDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameTaskDetailByoId", oid);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameTaskDetail> getGameTaskDetailByTypeTasktype(int type,
			int tasktype) {
		List<GameTaskDetail> list = null;
		try {
			Map<String, Object> aa = new HashMap<String, Object>();// 存放数据
			aa.put("type", type);
			aa.put("tasktype", tasktype);
			list = sqlMapper.queryForList("getGameTaskDetailByTypeTasktype", aa);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public GameTaskDetail findGameTaskDetailById(int id) {
		List<GameTaskDetail> roles = null;
		try {
			roles = sqlMapper.queryForList("findGameTaskDetailById", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		if (!roles.isEmpty()) {
			return roles.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<GameTaskDetail> findAllGameTask() {
		List<GameTaskDetail> list = null;
		try {
			list = sqlMapper.queryForList("findAllGameTask");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	


	
}