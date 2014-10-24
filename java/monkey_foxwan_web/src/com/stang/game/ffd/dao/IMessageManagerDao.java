package com.stang.game.ffd.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.MessageManagerDetail;

public interface IMessageManagerDao extends IEntityDao<MessageManagerDetail> {

	

	public int insertMessageManagerDetail(MessageManagerDetail entity);

	public int updateMessageManagerDetail(MessageManagerDetail entity);

	public List<MessageManagerDetail> findMessageManagerByFlag(int flag);

	public List<MessageManagerDetail> findMessageManagerByTime(Date endTime);
	
	public int updateMessageManagerDetailByIDs(List<Integer> ids);
	public List<MessageManagerDetail> findMessageManagerByFlagOrderByOpTime();
}
