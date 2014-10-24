package com.stang.game.ffd.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.LogRejectIpsDetail;

public interface ILogRejectIpsDao extends IEntityDao<LogRejectIpsDetail> {

	List<LogRejectIpsDetail> getLogRejectIpsDetailByParam(
			Map<String, Object> param);

	int getLogRejectIpsDetailCount();

	void insertLogRejectIpsDetail(LogRejectIpsDetail lrd);

	void updateLogRejectIpsByParam(Map<String, Object> param);

}
