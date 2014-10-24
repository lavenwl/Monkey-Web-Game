package com.stang.game.ffd.service;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.LogRejectDetail;

public interface ILogRejectService extends IBaseService<LogRejectDetail> {


	public void updateLogRejectByParam(Map<String, Object> param);

	public List<LogRejectDetail> getLogRejectByParam(Map<String, Object> param);

	public void insertLogReject(LogRejectDetail lrd);

	public int getLogRejectCount(Map<String, Object> param);

}
