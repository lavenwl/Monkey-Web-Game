package com.stang.game.ffd.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.LogSendGiftDetail;

public interface ILogSendGiftDetailDao extends IEntityDao<LogSendGiftDetail> {

	public void deleteLogSendGiftDetail(Map<String, Object> param);

	public List<LogSendGiftDetail> getLogSendGiftDetail(Map<String, Object> param);

	public void insertLogSendGiftDetail(Map<String, Object> param);

	public void updateLogSendGiftDetail(Map<String, Object> param);

	public int getLogSendGiftDetailCount();

}
