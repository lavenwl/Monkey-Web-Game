package com.stang.game.ffd.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.common.GameConstants;
import com.stang.game.ffd.dao.IGameMailAttachmentsDao;
import com.stang.game.ffd.entity.detail.GameMailAttachmentsDetail;


public class GameMailAttachmentsDaoImpl extends EntityDao<GameMailAttachmentsDetail> implements
		IGameMailAttachmentsDao {

	public boolean batchDeleteGameMailAtts(List<Integer> ids) {
		// TODO Auto-generated method stub
		boolean isSuccess = false;
		
		try {
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("ids", ids);
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.delete("batchDeleteGameMailAtts", param);
			sqlMapperFlight.commitTransaction();
			isSuccess = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				sqlMapperFlight.endTransaction();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return isSuccess;
	}

	public boolean deleteGameMailAttById(Integer id) {
		// TODO Auto-generated method stub
		boolean isSuccess = false;
		
		try {
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("id", id);
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.delete("deleteGameMailAttById", param);
			sqlMapperFlight.commitTransaction();
			isSuccess = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				sqlMapperFlight.endTransaction();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return isSuccess;
	}

	public boolean deleteGameMailAttsByMailId(Integer mailId) {
		// TODO Auto-generated method stub
		boolean isSuccess = false;
		
		try {
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("mailId", mailId);
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.delete("deleteGameMailAttsByMailId", param);
			sqlMapperFlight.commitTransaction();
			isSuccess = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				sqlMapperFlight.endTransaction();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return isSuccess;
	}

	public boolean updateGameMailAttIsOpen(Integer id) {
		// TODO Auto-generated method stub
		boolean isSuccess = false;
		
		try {
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("id", id);
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.update("updateGameMailAttIsOpen", param);
			sqlMapperFlight.commitTransaction();
			isSuccess = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				sqlMapperFlight.endTransaction();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return isSuccess;
	}

	public List<GameMailAttachmentsDetail> findGameMailAttachmentsDetailByParam(
			Map<String, Object> param) {
		// TODO Auto-generated method stub
		List<GameMailAttachmentsDetail> atts = new ArrayList<GameMailAttachmentsDetail>();
		try {
			atts = sqlMapperFlight.queryForList("getGameMailAttachmentsDetail", param);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return atts;
	}

	public GameMailAttachmentsDetail getGameMailAttachmentsDetailById(Integer id) {
		// TODO Auto-generated method stub
		GameMailAttachmentsDetail att = new GameMailAttachmentsDetail();
		try {
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("id", id);
			List<GameMailAttachmentsDetail> atts = sqlMapperFlight.queryForList("getGameMailAttachmentsDetail", param);
			if(!atts.isEmpty()) {
				att = atts.get(0);
			}
			atts = null;
			param = null;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return att;
	}

	public List<GameMailAttachmentsDetail> getGameMailAttsByMailIds(
			List<Integer> ids) {
		// TODO Auto-generated method stub
		List<GameMailAttachmentsDetail> atts = new ArrayList<GameMailAttachmentsDetail>();
		try {
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("ids", ids);
			atts = sqlMapperFlight.queryForList("getGameMailAttsByMailIds", param);
			param = null;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return atts;
	}

	public boolean batchDeleteGameMailAttsByMailIds(List<Integer> ids) {
		// TODO Auto-generated method stub
		boolean isSuccess = false;
		
		try {
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("ids", ids);
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.delete("batchDeleteGameMailAttsByMailIds", param);
			sqlMapperFlight.commitTransaction();
			isSuccess = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				sqlMapperFlight.endTransaction();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return isSuccess;
	}
	
	public List<GameMailAttachmentsDetail> getGameMailAttachmentsByParam(Map<String, Object> param){
		List<GameMailAttachmentsDetail> list = null;
		try {
			list = sqlMapperFlight.queryForList("getGameMailAttachmentsByParam", param);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	

}
