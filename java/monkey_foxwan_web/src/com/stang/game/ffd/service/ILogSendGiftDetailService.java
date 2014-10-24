package com.stang.game.ffd.service;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.LogSendGiftDetail;
import com.stang.game.ffd.service.IBaseService;

public interface ILogSendGiftDetailService extends
		IBaseService<LogSendGiftDetail> {

	void insertLogSendGiftDetail(Map<String, Object> param);

	void updateLogSendGiftDetail(Map<String, Object> param);

	void deleteLogSendGiftDetail(Map<String, Object> param);

	List<LogSendGiftDetail> getLogSendGiftDetail(Map<String, Object> param);

	int getLogSendGiftDetailCount();
	
}
