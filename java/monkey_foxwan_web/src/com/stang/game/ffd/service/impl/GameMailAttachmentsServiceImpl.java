package com.stang.game.ffd.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGameMailAttachmentsDao;
import com.stang.game.ffd.dao.impl.GameMailAttachmentsDaoImpl;
import com.stang.game.ffd.entity.detail.GameMailAttachmentsDetail;
import com.stang.game.ffd.service.IGameMailAttachmentsService;


public class GameMailAttachmentsServiceImpl extends BaseServiceImpl<GameMailAttachmentsDetail> implements
		IGameMailAttachmentsService {

	protected IGameMailAttachmentsDao getBaseDao() {
		if(baseDao == null) {
			baseDao = new GameMailAttachmentsDaoImpl();
		}
		return (IGameMailAttachmentsDao)baseDao;
	}

	public boolean batchDeleteGameMailAtts(List<Integer> ids) {
		// TODO Auto-generated method stub
		return getBaseDao().batchDeleteGameMailAtts(ids);
	}

	public boolean deleteGameMailAttById(Integer id) {
		// TODO Auto-generated method stub
		return getBaseDao().deleteGameMailAttById(id);
	}

	public boolean deleteGameMailAttsByMailId(Integer mailId) {
		// TODO Auto-generated method stub
		return getBaseDao().deleteGameMailAttsByMailId(mailId);
	}

	public boolean updateGameMailAttIsOpen(Integer id) {
		// TODO Auto-generated method stub
		return getBaseDao().updateGameMailAttIsOpen(id);
	}

	public List<GameMailAttachmentsDetail> findGameMailAttachmentsDetailByParam(
			Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findGameMailAttachmentsDetailByParam(param);
	}

	public GameMailAttachmentsDetail getGameMailAttachmentsDetailById(Integer id) {
		// TODO Auto-generated method stub
		return getBaseDao().getGameMailAttachmentsDetailById(id);
	}

	public List<GameMailAttachmentsDetail> getGameMailAttsByMailIds(
			List<Integer> ids) {
		// TODO Auto-generated method stub
		return getBaseDao().getGameMailAttsByMailIds(ids);
	}

	public boolean batchDeleteGameMailAttsByMailIds(List<Integer> ids) {
		// TODO Auto-generated method stub
		return getBaseDao().batchDeleteGameMailAttsByMailIds(ids);
	}
	
	public List<GameMailAttachmentsDetail> getGameMailAttachmentsByParam(Map<String, Object> param){
		return getBaseDao().getGameMailAttachmentsByParam(param);
	}
	
}
