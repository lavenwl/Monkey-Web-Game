package com.stang.game.ffd.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IMessageManagerDao;
import com.stang.game.ffd.dao.IRightUserDao;
import com.stang.game.ffd.dao.impl.MessageManagerDaoImpl;
import com.stang.game.ffd.dao.impl.RightUserDaoImpl;
import com.stang.game.ffd.entity.detail.MessageManagerDetail;
import com.stang.game.ffd.service.IMessageManagerService;

public class MessageManagerServiceImpl extends
		BaseServiceImpl<MessageManagerDetail> implements IMessageManagerService {

	public IMessageManagerDao getBaseDao(){
		if(this.baseDao==null){
			baseDao = new MessageManagerDaoImpl();
		}
		return (IMessageManagerDao)baseDao;
	}

	public int insertMessageManagerDetail(MessageManagerDetail entity) {
		// TODO Auto-generated method stub
		return getBaseDao().insertMessageManagerDetail(entity);
	}

	public int updateMessageManagerDetail(MessageManagerDetail entity) {
		// TODO Auto-generated method stub
		return getBaseDao().updateMessageManagerDetail(entity);
	}

	public List<MessageManagerDetail> findMessageManagerByFlag(int flag) {
		// TODO Auto-generated method stub
		return getBaseDao().findMessageManagerByFlag(flag);
	}

	public List<MessageManagerDetail> findMessageManagerByTime(Date endTime) {
		// TODO Auto-generated method stub
		return getBaseDao().findMessageManagerByTime(endTime);
	}

	public List<MessageManagerDetail> findMessageManagerByFlagOrderByOpTime() {
		// TODO Auto-generated method stub
		return getBaseDao().findMessageManagerByFlagOrderByOpTime();
	}

	public int updateMessageManagerDetailByIDs(List<Integer> ids) {
		// TODO Auto-generated method stub
		return getBaseDao().updateMessageManagerDetailByIDs(ids);
	}

}
