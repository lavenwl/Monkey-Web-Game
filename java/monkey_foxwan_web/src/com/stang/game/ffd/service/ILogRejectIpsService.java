package com.stang.game.ffd.service;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.LogRejectIpsDetail;

public interface ILogRejectIpsService extends IBaseService<LogRejectIpsDetail> {
	public void updateLogRejectIpsByParam(Map<String, Object> param);

	public List<LogRejectIpsDetail> getLogRejectIpsDetailByParam(Map<String, Object> param);

	public void insertLogRejectIpsDetail(LogRejectIpsDetail lrd);

	public int getLogRejectIpsDetailCount();
}
