package com.stang.game.ffd.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.LogRejectDetail;
import com.stang.game.ffd.service.ILogRejectService;

public interface ILogRejectDao extends IEntityDao<LogRejectDetail> {

	public List<LogRejectDetail> getLogRejectByParam(Map<String, Object> param);

	public void updateLogRejectByParam(Map<String, Object> param);

	public void insertLogReject(LogRejectDetail lrd);

	public int getLogRejectCount(Map<String, Object> param);

}
