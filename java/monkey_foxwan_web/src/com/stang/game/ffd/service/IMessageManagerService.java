package com.stang.game.ffd.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityRightUserDetail;
import com.stang.game.ffd.entity.detail.MessageManagerDetail;

public interface IMessageManagerService extends IBaseService<MessageManagerDetail> {
	public List<MessageManagerDetail> findMessageManagerByTime(Date endTime);
	public List<MessageManagerDetail> findMessageManagerByFlag(int flag);
	public int updateMessageManagerDetail(MessageManagerDetail entity);
	public int insertMessageManagerDetail(MessageManagerDetail entity);
	public List<MessageManagerDetail> findMessageManagerByFlagOrderByOpTime();
	public int updateMessageManagerDetailByIDs(List<Integer> ids);
}
